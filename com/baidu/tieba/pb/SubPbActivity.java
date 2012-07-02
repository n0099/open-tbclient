package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.data.SubPbData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.SubPbModel;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.ContentHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.MyBitmapDrawable;
import com.baidu.tieba.write.FaceAdapter;
import com.baidu.tieba.write.VcodeActivity;
import com.baidu.tieba.write.WriteUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class SubPbActivity extends BaseActivity {
    private static final int UPDATE_TYPE_MORE = 1;
    private static final int UPDATE_TYPE_PREVIOUS = 2;
    private static final int UPDATE_TYPE_UPDATE = 3;
    private Button mButtonFace;
    private Button mButtonReply;
    private EditText mEditReply;
    private View mPostLayout;
    private List<PostData> mSubPbData;
    private ListView mSubPbListView;
    private SubPbModel mSubPbModel = null;
    private SubPbAdapter mSubPbAdapter = null;
    private String mThemeId = null;
    private String mPostId = null;
    private String mForumId = null;
    private String mForumName = null;
    private MarkData mMarkData = null;
    private boolean mIsMarked = false;
    private boolean mSequence = true;
    private boolean mHostMode = false;
    private boolean mIsFromMention = false;
    private ProgressBar mProgress = null;
    private int mReplyFloor = -1;
    private String mReplyPostId = null;
    private String mThreadId = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private ReplyAsyncTask mReplyAsyncTask = null;
    private SubPbAsyncTask mSubPbAsyncTask = null;
    private int mPageTop = 1;
    private int mPageBottom = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_pb_activity);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.mReplyAsyncTask != null) {
                this.mReplyAsyncTask.cancel();
                this.mReplyAsyncTask = null;
            }
            if (this.mSubPbAsyncTask != null) {
                this.mSubPbAsyncTask.cancel();
                this.mSubPbAsyncTask = null;
            }
            if (this.mSubPbAdapter != null) {
                this.mSubPbAdapter.releaseProgressBar();
            }
        } catch (Exception e) {
            TiebaLog.d(getClass().getName(), "onDestroy", e.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == WriteUtil.REQUEST_VCODE) {
            refreshOnReplySuccess();
        }
    }

    private void initUI() {
        Button back = (Button) findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SubPbActivity.this.finish();
            }
        });
        this.mButtonReply = (Button) findViewById(R.id.reply_button);
        this.mButtonReply.setEnabled(false);
        this.mButtonReply.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String content = SubPbActivity.this.mEditReply.getText().toString();
                if (content == null || content.length() <= 0) {
                    return;
                }
                SubPbActivity.this.reply();
            }
        });
        Button mark = (Button) findViewById(R.id.button_mark);
        mark.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SubPbActivity.this.mark();
            }
        });
        this.mEditReply = (EditText) findViewById(R.id.reply_content);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(0);
        setTextWatcher();
        this.mMarkData = (MarkData) getIntent().getSerializableExtra("mark");
        this.mIsMarked = getIntent().getBooleanExtra("isMarked", false);
        this.mIsFromMention = getIntent().getBooleanExtra("isFromMention", false);
        if (this.mMarkData != null) {
            this.mThemeId = this.mMarkData.getId();
            this.mPostId = this.mMarkData.getPostId();
            this.mForumId = this.mMarkData.getForumId();
            this.mForumName = this.mMarkData.getForumName();
            this.mThreadId = this.mMarkData.getThreadId();
            this.mSequence = this.mMarkData.getSequence().booleanValue();
            this.mHostMode = this.mMarkData.getHostMode();
        } else {
            this.mThemeId = getIntent().getStringExtra("themeId");
            this.mPostId = getIntent().getStringExtra("postId");
            mark.setEnabled(false);
        }
        final Handler handler = new Handler();
        final GridView faceView = (GridView) findViewById(R.id.face_view);
        this.mButtonFace = (Button) findViewById(R.id.button_face);
        final FaceAdapter faceAdapter = new FaceAdapter(this);
        faceView.setAdapter((ListAdapter) faceAdapter);
        faceView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String name;
                ImageSpan[] all = (ImageSpan[]) SubPbActivity.this.mEditReply.getText().getSpans(0, SubPbActivity.this.mEditReply.getText().length(), ImageSpan.class);
                if (all.length >= 10) {
                    SubPbActivity.this.showToast(SubPbActivity.this.getString(R.string.too_many_face));
                } else if (!SubPbActivity.this.checkTextNum() && (name = faceAdapter.getName(arg2)) != null) {
                    int pos = SubPbActivity.this.mEditReply.getSelectionStart();
                    SpannableStringBuilder spanName = new SpannableStringBuilder(name);
                    Bitmap bm = (Bitmap) faceAdapter.getItem(arg2);
                    if (bm != null) {
                        MyBitmapDrawable dr = new MyBitmapDrawable(bm);
                        dr.setBounds(0, 0, bm.getWidth() + 1, bm.getHeight());
                        dr.setGravity(3);
                        ImageSpan span = new ImageSpan(dr, 0);
                        spanName.setSpan(span, 0, spanName.length(), 33);
                        SubPbActivity.this.mEditReply.getText().insert(pos, spanName);
                    }
                }
            }
        });
        final Runnable showFaceRunnable = new Runnable() { // from class: com.baidu.tieba.pb.SubPbActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (faceView.getVisibility() != 0) {
                    faceView.setVisibility(0);
                }
            }
        };
        this.mButtonFace.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (faceView.getVisibility() == 0) {
                    SubPbActivity.this.mEditReply.requestFocus();
                    faceView.setVisibility(8);
                    UtilHelper.showSoftKeyPad(SubPbActivity.this, SubPbActivity.this.mEditReply);
                    SubPbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
                    return;
                }
                UtilHelper.hideSoftKeyPad(SubPbActivity.this, SubPbActivity.this.mEditReply);
                handler.postDelayed(showFaceRunnable, 200L);
                SubPbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_keyboard);
            }
        });
        this.mEditReply.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.SubPbActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (faceView.getVisibility() == 0) {
                    SubPbActivity.this.mEditReply.requestFocus();
                    faceView.setVisibility(8);
                    UtilHelper.showSoftKeyPad(SubPbActivity.this, SubPbActivity.this.mEditReply);
                    SubPbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
                    return true;
                }
                return false;
            }
        });
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.SubPbActivity.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                SubPbActivity.this.DeinitWaitingDialog();
                if (SubPbActivity.this.mReplyAsyncTask != null) {
                    SubPbActivity.this.mReplyAsyncTask.cancel();
                }
            }
        };
        this.mPostLayout = getLayoutInflater().inflate(R.layout.sub_pb_header, (ViewGroup) null);
        this.mPostLayout.setVisibility(8);
        this.mSubPbListView = (ListView) findViewById(R.id.pb_list);
        this.mSubPbListView.addHeaderView(this.mPostLayout, null, false);
        this.mSubPbListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long id) {
                if (id == -1 && !SubPbActivity.this.mSubPbAdapter.isProcessPre()) {
                    SubPbActivity.this.startTask(2);
                }
                if (id != -2 || SubPbActivity.this.mSubPbAdapter.isProcessMore()) {
                    return;
                }
                SubPbActivity.this.startTask(1);
            }
        });
        AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.SubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == 2 || scrollState == 1) {
                    UtilHelper.hideSoftKeyPad(SubPbActivity.this, view);
                    SubPbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
                    faceView.setVisibility(8);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        };
        this.mSubPbListView.setOnScrollListener(scrollListener);
        final Runnable scrollRunnable = new Runnable() { // from class: com.baidu.tieba.pb.SubPbActivity.11
            @Override // java.lang.Runnable
            public void run() {
                SubPbActivity.this.mSubPbListView.setSelection(SubPbActivity.this.mReplyFloor + 1);
            }
        };
        this.mSubPbData = new ArrayList();
        this.mSubPbAdapter = new SubPbAdapter(this, this.mSubPbData);
        this.mSubPbAdapter.setReplyListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SubPbActivity.this.mReplyFloor = Integer.valueOf((String) v.getTag()).intValue();
                PostData data = (PostData) SubPbActivity.this.mSubPbAdapter.getItem(SubPbActivity.this.mReplyFloor);
                SubPbActivity.this.mEditReply.setText(SubPbActivity.this.getString(R.string.reply_sub_floor, new Object[]{data.getAuthor().getName()}));
                SubPbActivity.this.mEditReply.setSelection(SubPbActivity.this.mEditReply.getText().length());
                SubPbActivity.this.mEditReply.requestFocus();
                UtilHelper.showSoftKeyPad(SubPbActivity.this, SubPbActivity.this.mEditReply);
                SubPbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
                handler.postDelayed(scrollRunnable, 600L);
            }
        });
        this.mSubPbListView.setAdapter((ListAdapter) this.mSubPbAdapter);
        setupMarkView();
        startTask(3);
    }

    private void setupMarkView() {
        Button mark = (Button) findViewById(R.id.button_mark);
        ImageView markView = (ImageView) this.mPostLayout.findViewById(R.id.mark);
        if (this.mIsMarked) {
            markView.setVisibility(0);
            mark.setText(R.string.remove_mark);
            return;
        }
        markView.setVisibility(8);
        mark.setText(R.string.add_mark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mark() {
        ImageView markView = (ImageView) this.mPostLayout.findViewById(R.id.mark);
        Button mark = (Button) findViewById(R.id.button_mark);
        if (this.mIsMarked) {
            if (DatabaseService.deleteMarkData(this.mMarkData.getId())) {
                showToast(getString(R.string.success));
                this.mIsMarked = false;
                markView.setVisibility(8);
                mark.setText(R.string.add_mark);
                return;
            }
            showToast(getString(R.string.fail));
        } else if (DatabaseService.saveMarkData(this.mMarkData)) {
            showToast(getString(R.string.success));
            this.mIsMarked = true;
            markView.setVisibility(0);
            mark.setText(R.string.remove_mark);
        } else {
            showToast(getString(R.string.fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTask(int type) {
        int size;
        if ((type != 2 && type != 1) || this.mSubPbData == null || this.mSubPbData.size() < Config.SUB_PB_LIST_ITEM_MAX_NUM) {
            if (this.mSubPbAsyncTask != null) {
                this.mSubPbAsyncTask.cancel();
                this.mSubPbAsyncTask = null;
            }
            if ((type == 2 || type == 1) && this.mSubPbModel != null) {
                List<PostData> list = this.mSubPbModel.getSubPbData().getSubPbList();
                if (list != null && list.size() > 0 && (size = list.size()) > Config.SUB_PB_LIST_ITEM_MAX_NUM - 10) {
                    for (int i = 1; i <= size - (Config.SUB_PB_LIST_ITEM_MAX_NUM - 10) && size - i >= 0; i++) {
                        list.remove(size - i);
                    }
                    if (type == 2) {
                        this.mSubPbAdapter.setHaveFooter(2);
                    }
                    if (type == 1) {
                        this.mSubPbAdapter.setHaveHeader(2);
                    }
                    this.mSubPbAdapter.notifyDataSetChanged();
                }
            } else {
                this.mSubPbAdapter.setHaveFooter(0);
                this.mSubPbAdapter.setHaveHeader(0);
                this.mProgress.setVisibility(0);
            }
            this.mSubPbAsyncTask = new SubPbAsyncTask(type);
            this.mSubPbAsyncTask.execute(new String[0]);
            if ((type == 2 || type == 1) && this.mSubPbAsyncTask != null) {
                this.mSubPbAdapter.setIsProcessMore(true);
                this.mSubPbAdapter.notifyDataSetChanged();
            }
        }
    }

    private void loadPhoto(final ImageView view) {
        AsyncImageLoader imageLoader = new AsyncImageLoader(this);
        String url = this.mSubPbModel.getSubPbData().getPostData().getAuthor().getPortrait();
        if (StringHelper.isEmpty(url)) {
            view.setImageResource(R.drawable.photo);
            return;
        }
        Bitmap avatar = imageLoader.getPhoto(url);
        if (avatar != null) {
            view.setImageBitmap(avatar);
        } else {
            imageLoader.loadFriendPhotoByNet(url, new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.pb.SubPbActivity.13
                @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                    view.setImageBitmap(bitmap);
                }
            });
        }
    }

    private void setTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.pb.SubPbActivity.14
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    SubPbActivity.this.mButtonReply.setEnabled(false);
                } else {
                    SubPbActivity.this.mButtonReply.setEnabled(true);
                }
            }
        };
        this.mEditReply.addTextChangedListener(textWatcher);
        this.mEditReply.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.SubPbActivity.15
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (SubPbActivity.this.checkTextNum()) {
                    if (source.length() <= 0 && dest.length() > 0) {
                        return dest.subSequence(dstart, dend - 1);
                    }
                    return "";
                }
                return null;
            }
        }});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkTextNum() {
        ImageSpan[] all = (ImageSpan[]) this.mEditReply.getText().getSpans(0, this.mEditReply.getText().length(), ImageSpan.class);
        int faceCount = all.length;
        int faceTextCount = 0;
        for (int i = 0; i < faceCount; i++) {
            if (all[i] != null && all[i].getSource() != null) {
                faceTextCount += all[i].getSource().length();
            }
        }
        return (this.mEditReply.getText().toString().length() - faceTextCount) + faceCount > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        TextView text = (TextView) this.mPostLayout.findViewById(R.id.text);
        TextView user = (TextView) this.mPostLayout.findViewById(R.id.user_name);
        TextView rank = (TextView) this.mPostLayout.findViewById(R.id.rank);
        TextView time = (TextView) this.mPostLayout.findViewById(R.id.time);
        TextView floor = (TextView) this.mPostLayout.findViewById(R.id.floor);
        ImageView photo = (ImageView) this.mPostLayout.findViewById(R.id.photo);
        TextView title = (TextView) findViewById(R.id.text_title);
        LinearLayout seg = (LinearLayout) this.mPostLayout.findViewById(R.id.seg);
        TextView replyNum = (TextView) this.mPostLayout.findViewById(R.id.text_reply_num);
        PostData postData = this.mSubPbModel.getSubPbData().getPostData();
        title.setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(postData.getFloor_num())}));
        rank.setText(getString(R.string.format_grade, new Object[]{Integer.valueOf(postData.getAuthor().getLevel_id())}));
        floor.setText(getString(R.string.format_floor, new Object[]{Integer.valueOf(postData.getFloor_num())}));
        time.setText(StringHelper.getTimeString(postData.getTime()));
        text.setMovementMethod(LinkMovementMethod.getInstance());
        replyNum.setText(String.valueOf(this.mSubPbModel.getSubPbData().getTotalCount()));
        user.setTextSize(Config.getNameSize());
        user.getPaint().setFakeBoldText(true);
        user.setText(this.mSubPbModel.getSubPbData().getPostData().getAuthor().getName_show());
        ArrayList<ContentData> content = postData.getUnite_content();
        ContentHelper helper = new ContentHelper(this);
        helper.setIsEllipsized(true);
        helper.setContent(text, seg, content, false);
        photo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.SubPbActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String id = SubPbActivity.this.mSubPbModel.getSubPbData().getPostData().getAuthor().getId();
                if (id != null && id.length() > 0) {
                    String name = SubPbActivity.this.mSubPbModel.getSubPbData().getPostData().getAuthor().getName();
                    PersonInfoActivity.startActivity(SubPbActivity.this, id, name);
                }
            }
        });
        this.mReplyPostId = postData.getId();
        this.mProgress.setVisibility(8);
        this.mPostLayout.setVisibility(0);
        loadPhoto(photo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshOnReplySuccess() {
        showToast(TiebaApplication.app.getString(R.string.send_success));
        this.mEditReply.setText((CharSequence) null);
        GridView faceView = (GridView) findViewById(R.id.face_view);
        if (faceView.getVisibility() == 0) {
            faceView.setVisibility(8);
        }
        UtilHelper.hideSoftKeyPad(this, this.mEditReply);
        this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
        this.mSubPbAdapter.setHaveFooter(2);
        this.mSubPbAdapter.notifyDataSetChanged();
        if (this.mSubPbModel != null && this.mSubPbModel.getSubPbData() != null && this.mSubPbModel.getSubPbData().getCurrentPage() == this.mSubPbModel.getSubPbData().getTotalPage()) {
            startTask(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMarkData() {
        String markId;
        this.mMarkData = new MarkData();
        Date date = new Date();
        this.mMarkData.setAccount(TiebaApplication.getCurrentAccount());
        this.mMarkData.setTime(date.getTime());
        this.mMarkData.setSequence(true);
        this.mMarkData.setSubPost(1);
        this.mMarkData.setSequence(Boolean.valueOf(this.mSequence));
        this.mMarkData.setHostMode(this.mHostMode);
        if (this.mSubPbData != null) {
            PostData post = this.mSubPbModel.getSubPbData().getPostData();
            ThreadData thread = this.mSubPbModel.getSubPbData().getThreadData();
            ForumData forum = this.mSubPbModel.getSubPbData().getForumData();
            this.mForumId = forum.getId();
            this.mForumName = forum.getName();
            this.mThreadId = thread.getId();
            this.mPostId = post.getId();
            this.mPageBottom = this.mSubPbModel.getSubPbData().getCurrentPage();
            this.mMarkData.setId(thread.getId());
            this.mMarkData.setTitle(thread.getTitle());
            this.mMarkData.setAuthorName(thread.getAuthor().getName_show());
            this.mMarkData.setReplyNum(thread.getReply_num());
            this.mMarkData.setForumId(forum.getId());
            this.mMarkData.setForumName(forum.getName());
            this.mMarkData.setThreadId(thread.getId());
            this.mMarkData.setFloor(post.getFloor_num());
            this.mMarkData.setPostId(post.getId());
        }
        boolean isMarked = false;
        MarkData mark = DatabaseService.getMarkDataById(this.mThemeId);
        if (mark != null && (markId = mark.getPostId()) != null && markId.equals(this.mPostId)) {
            isMarked = true;
        }
        if (this.mIsMarked != isMarked) {
            this.mIsMarked = isMarked;
            setupMarkView();
        }
        Button buttonMark = (Button) findViewById(R.id.button_mark);
        buttonMark.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reply() {
        if (this.mSubPbModel != null && this.mSubPbModel.getSubPbData() != null) {
            String content = this.mEditReply.getText().toString();
            if (checkTextNum()) {
                content = content.substring(0, 140);
            }
            showLoadingDialog(getString(R.string.sending), this.mDialogCancelListener);
            WriteModel model = new WriteModel();
            model.setForumId(this.mForumId);
            model.setForumName(this.mForumName);
            model.setContent(content);
            model.setVcode(null);
            model.setFloor(this.mReplyPostId);
            model.setThreadId(this.mThreadId);
            model.setFloorNum(0);
            model.setType(WriteModel.REPLY_FLOOR);
            this.mReplyAsyncTask = new ReplyAsyncTask(model);
            this.mReplyAsyncTask.execute(new Integer[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SubPbAsyncTask extends AsyncTask<String, Integer, String> {
        private NetWork mNetwork = null;
        private int mRequestPage;
        private int mType;

        public SubPbAsyncTask(int type) {
            this.mRequestPage = 0;
            this.mType = 3;
            this.mType = type;
            switch (type) {
                case 1:
                    if (SubPbActivity.this.mSubPbData.size() % 10 == 0) {
                        this.mRequestPage = SubPbActivity.this.mPageBottom + 1;
                        return;
                    } else {
                        this.mRequestPage = SubPbActivity.this.mPageBottom;
                        return;
                    }
                case 2:
                    this.mRequestPage = SubPbActivity.this.mPageTop - 1;
                    return;
                case 3:
                    this.mRequestPage = 1;
                    return;
                default:
                    return;
            }
        }

        private void refreshActivity() {
            try {
                SubPbActivity.this.refresh();
                if (SubPbActivity.this.mSubPbData == null || SubPbActivity.this.mSubPbData.size() < Config.SUB_PB_LIST_ITEM_MAX_NUM) {
                    SubPbData data = SubPbActivity.this.mSubPbModel.getSubPbData();
                    if (SubPbActivity.this.mSubPbModel != null && data != null) {
                        if (this.mType == 1) {
                            SubPbActivity.this.mPageBottom = data.getCurrentPage();
                        }
                        if (this.mType == 2) {
                            SubPbActivity.this.mPageTop = data.getCurrentPage();
                        }
                        if (data.getCurrentPage() < data.getTotalPage()) {
                            SubPbActivity.this.mSubPbAdapter.setHaveFooter(2);
                        } else {
                            SubPbActivity.this.mSubPbAdapter.setHaveFooter(0);
                        }
                        if (SubPbActivity.this.mPageTop > 1) {
                            SubPbActivity.this.mSubPbAdapter.setHaveHeader(2);
                        } else {
                            SubPbActivity.this.mSubPbAdapter.setHaveHeader(0);
                        }
                        List<PostData> list = SubPbActivity.this.mSubPbModel.getSubPbData().getSubPbList();
                        int listSize = list.size();
                        if (list != null && list.size() > 0) {
                            if (this.mType == 3) {
                                SubPbActivity.this.mSubPbData.addAll(list);
                            }
                            if (this.mType == 1) {
                                if (this.mRequestPage == data.getTotalPage()) {
                                    int lastPageCount = SubPbActivity.this.mSubPbData.size() % 10;
                                    if (listSize > lastPageCount) {
                                        for (int i = lastPageCount; i < listSize; i++) {
                                            SubPbActivity.this.mSubPbData.add(list.get(i));
                                        }
                                    }
                                } else {
                                    SubPbActivity.this.mSubPbData.addAll(list);
                                }
                            }
                            if (this.mType == 2) {
                                SubPbActivity.this.mSubPbData.addAll(0, list);
                            }
                            SubPbActivity.this.mSubPbAdapter.setData(SubPbActivity.this.mSubPbData);
                            SubPbActivity.this.mSubPbAdapter.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    return;
                }
                SubPbActivity.this.mSubPbAdapter.setHaveFooter(0);
                SubPbActivity.this.mSubPbAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                TiebaLog.d(getClass().getName(), "refreshActivity", e.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/f/pb/floor");
            this.mNetwork.addPostData("kz", SubPbActivity.this.mThemeId);
            if (!SubPbActivity.this.mIsFromMention) {
                this.mNetwork.addPostData("pid", SubPbActivity.this.mPostId);
                this.mNetwork.addPostData(PersonListActivity.TAG_PAGE, String.valueOf(this.mRequestPage));
            } else {
                this.mNetwork.addPostData("spid", SubPbActivity.this.mPostId);
            }
            this.mNetwork.setIsNeedTbs(true);
            return this.mNetwork.postNetData();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((SubPbAsyncTask) result);
            try {
                if (this.mNetwork != null) {
                    if (this.mNetwork.isRequestSuccess()) {
                        SubPbActivity.this.mSubPbModel = new SubPbModel(SubPbActivity.this, result);
                        SubPbActivity.this.mForumId = SubPbActivity.this.mSubPbModel.getSubPbData().getForumData().getId();
                        SubPbActivity.this.mForumName = SubPbActivity.this.mSubPbModel.getSubPbData().getForumData().getName();
                        SubPbActivity.this.mIsFromMention = false;
                        SubPbActivity.this.setMarkData();
                        refreshActivity();
                    } else {
                        SubPbActivity.this.showToast(this.mNetwork.getErrorString());
                        int errorCode = this.mNetwork.getErrorCode();
                        if (errorCode == 4 || errorCode == 28 || errorCode == 29) {
                            SubPbActivity.this.finish();
                        }
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "onPostExecute", ex.getMessage());
            }
            SubPbActivity.this.mSubPbAsyncTask = null;
            hideProgress();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            hideProgress();
            super.cancel(true);
        }

        private void hideProgress() {
            if (SubPbActivity.this.mProgress.getVisibility() == 0) {
                SubPbActivity.this.mProgress.setVisibility(8);
            }
            if (SubPbActivity.this.mSubPbAdapter.isProcessMore()) {
                SubPbActivity.this.mSubPbAdapter.setIsProcessMore(false);
                if (SubPbActivity.this.mSubPbAdapter.isHaveFooter()) {
                    SubPbActivity.this.mSubPbAdapter.notifyDataSetChanged();
                }
            }
            if (SubPbActivity.this.mSubPbAdapter.isProcessPre()) {
                SubPbActivity.this.mSubPbAdapter.setIsProcessPre(false);
                if (SubPbActivity.this.mSubPbAdapter.isHaveHeader()) {
                    SubPbActivity.this.mSubPbAdapter.notifyDataSetInvalidated();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ReplyAsyncTask extends AsyncTask<Integer, Integer, String> {
        private WriteModel mWriteModel;
        private NetWork mNetwork = null;
        private boolean mCanceled = false;

        public ReplyAsyncTask(WriteModel model) {
            this.mWriteModel = null;
            this.mWriteModel = model;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Integer... params) {
            if (this.mCanceled) {
                return null;
            }
            this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/post/add");
            this.mNetwork.addPostData("anonymous", "0");
            this.mNetwork.addPostData("fid", this.mWriteModel.getForumId());
            this.mNetwork.addPostData("kw", this.mWriteModel.getForumName());
            this.mNetwork.addPostData("content", this.mWriteModel.getContent());
            this.mNetwork.addPostData("tid", this.mWriteModel.getThreadId());
            if (this.mWriteModel.getVcode() != null && this.mWriteModel.getVcode().length() > 0) {
                this.mNetwork.addPostData("vcode", this.mWriteModel.getVcode());
            }
            this.mNetwork.addPostData("quote_id", this.mWriteModel.getFloor());
            this.mNetwork.addPostData("floor_num", String.valueOf(this.mWriteModel.getFloorNum()));
            this.mNetwork.setIsNeedTbs(true);
            return this.mNetwork.postNetData();
        }

        private void handleRequestFail(int errorCode, String errorString, String result) {
            if (errorCode == 5 || errorCode == 6) {
                VcodeInfoData info = new VcodeInfoData();
                info.parserJson(result);
                if (info.getVcode_pic_url() != null) {
                    this.mWriteModel.setVcodeMD5(info.getVcode_md5());
                    this.mWriteModel.setVcodeUrl(info.getVcode_pic_url());
                    VcodeActivity.startActivityForResult(SubPbActivity.this, this.mWriteModel, WriteUtil.REQUEST_VCODE);
                    return;
                }
                SubPbActivity.this.showToast(errorString);
                return;
            }
            SubPbActivity.this.showToast(errorString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ReplyAsyncTask) result);
            SubPbActivity.this.closeLoadingDialog();
            SubPbActivity.this.mReplyAsyncTask = null;
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    SubPbActivity.this.refreshOnReplySuccess();
                } else {
                    handleRequestFail(this.mNetwork.getErrorCode(), this.mNetwork.getErrorString(), result);
                }
            }
        }

        public void cancel() {
            SubPbActivity.this.mReplyAsyncTask = null;
            SubPbActivity.this.closeLoadingDialog();
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }
    }
}
