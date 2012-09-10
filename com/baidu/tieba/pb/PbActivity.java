package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.PbData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity {
    private static final String HOSTMODE = "hostMode";
    private static final String ID = "id";
    private static final String MARK = "mark";
    private static final String MARKID = "markid";
    private static final String MARKMODE = "markMode";
    private static final int MENU_ID_MARK = 1;
    private static final int MENU_ID_RELAY = 4;
    private static final int MENU_ID_REPLY = 0;
    private static final int MENU_ID_TIP = 5;
    private static final int MENU_ID_VIEW_ALL = 8;
    private static final int MENU_ID_VIEW_HOST = 6;
    private static final int MENU_ID_VIEW_INFO = 2;
    private static final int MENU_ID_VIEW_REVERSE = 7;
    private static final int MENU_ID_VIEW_SEQUENCE = 9;
    private static final String SEQUENCE = "sequence";
    private static final String ST_TYPE = "st_type";
    private static final int UPDATE_TYPE_MARK = 4;
    private static final int UPDATE_TYPE_MORE = 1;
    private static final int UPDATE_TYPE_PREVIOUS = 2;
    private static final int UPDATE_TYPE_UPDATE = 3;
    private static final String URL_DIRECTION = "back";
    private static final String URL_HOST = "lz";
    private static final String URL_LAST = "last";
    private static final String URL_MARK = "mark";
    private static final String URL_NUM = "rn";
    private static final String URL_ORDER = "r";
    private static final String URL_PID = "pid";
    private static final String URL_ST_TYPE = "st_type";
    private static final String URL_THEME = "kz";
    private static volatile long mPbLoadTime = 0;
    private static volatile int mNetError = 0;
    private ListView mPbList = null;
    private AlertDialog mContextMenu = null;
    private TextView mTitleText = null;
    private Button mReply = null;
    private Button mBack = null;
    private Button mMore = null;
    private PbAdapter mAdapter = null;
    private PbAsyncTask mTask = null;
    private TipAsyncTask mTipTask = null;
    private PbModel mModel = null;
    private String mPbId = null;
    private ProgressBar mProgress = null;
    private Handler mHandler = new Handler();
    private AdapterView.OnItemLongClickListener mListLongClickListener = null;
    private long mClickId = -1;
    private AlertDialog mDialogMore = null;
    private AlertDialog mDialogTitle = null;
    private View mDialogView = null;
    private View mPbTileDialogView = null;
    private LinearLayout mTitle = null;
    private Menu mMenu = null;
    private DialogMoreAdapter mDialogAdapter = null;
    private ContextMenuAdapter mContextMenuAdapter = null;
    private String mSource = null;
    private int mLongPos = -1;
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.pb.PbActivity.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                int start = PbActivity.this.mPbList.getFirstVisiblePosition();
                int end = PbActivity.this.mPbList.getLastVisiblePosition();
                int image_num = 0;
                for (int i = start; i <= end; i++) {
                    if (i < PbActivity.this.mAdapter.getCount()) {
                        PostData data = (PostData) PbActivity.this.mAdapter.getItem(i);
                        if (data != null) {
                            ArrayList<ContentData> content = data.getUnite_content();
                            int index = -1;
                            int contentSize = content.size();
                            if (PbActivity.this.mAdapter.isShowImage()) {
                                for (int j = 0; j < contentSize; j++) {
                                    if (content.get(j).getType() == 3) {
                                        index++;
                                        image_num++;
                                        if (image_num > 15) {
                                            break;
                                        }
                                        PbActivity.this.mAdapter.getImageLoader().loadImage(content.get(j).getLink(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.pb.PbActivity.1.1
                                            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                                ImageView view;
                                                if (bitmap != null && (view = (ImageView) PbActivity.this.mPbList.findViewWithTag(imageUrl)) != null) {
                                                    view.invalidate();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                            String authorPhoto = data.getAuthor().getPortrait();
                            if (PbActivity.this.mModel.getIsDisplayPhoto() && authorPhoto != null && authorPhoto.length() > 0) {
                                PbActivity.this.mAdapter.getImageLoader().loadPbPhoto(authorPhoto, new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.pb.PbActivity.1.2
                                    @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                    public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                        if (bitmap != null) {
                                            ImageView view = (ImageView) PbActivity.this.mPbList.findViewWithTag(imageUrl);
                                            while (view != null) {
                                                view.setTag(null);
                                                view.setImageBitmap(bitmap);
                                                view = (ImageView) PbActivity.this.mPbList.findViewWithTag(imageUrl);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("PbActivity", "mGetImageRunnble.run", "error = " + ex.getMessage());
            }
        }
    };
    DialogInterface.OnClickListener mContextMenuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.2
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int item) {
            PostData post;
            switch (item) {
                case 0:
                    if (PbActivity.this.mPbId != null && PbActivity.this.mPbId.length() > 0 && PbActivity.this.mModel.getData() != null && (post = PbActivity.this.mModel.getData().getPost_list().get((int) PbActivity.this.mClickId)) != null) {
                        WriteActivity.startAcitivity(PbActivity.this, PbActivity.this.mModel.getData().getForum().getId(), PbActivity.this.mModel.getData().getForum().getName(), PbActivity.this.mPbId, post.getId(), post.getFloor_num(), PbActivity.this.mModel.getData().getAnti());
                        return;
                    }
                    return;
                case 1:
                    if (TiebaApplication.isBaiduAccountManager() && TiebaApplication.getCurrentAccount() == null) {
                        MainTabActivity.startActivityOnUserChanged(PbActivity.this, null);
                        return;
                    }
                    MarkData data = PbActivity.this.getMarkData();
                    String text = (String) PbActivity.this.mContextMenuAdapter.getItem(1);
                    if (text != null && text.equals(PbActivity.this.getString(R.string.remove_mark))) {
                        if (DatabaseService.deleteMarkData(data.getId())) {
                            PbActivity.this.showToast(PbActivity.this.getString(R.string.success));
                            PbActivity.this.mModel.setMarkId(null);
                            PbActivity.this.mAdapter.notifyDataSetChanged();
                            return;
                        }
                        PbActivity.this.showToast(PbActivity.this.getString(R.string.fail));
                        return;
                    } else if (DatabaseService.saveMarkData(data)) {
                        PbActivity.this.showToast(PbActivity.this.getString(R.string.success));
                        PbActivity.this.mModel.setMarkId(data.getPostId());
                        PbActivity.this.mAdapter.notifyDataSetChanged();
                        return;
                    } else {
                        PbActivity.this.showToast(PbActivity.this.getString(R.string.fail));
                        return;
                    }
                case 2:
                    if (PbActivity.this.mModel != null && PbActivity.this.mModel.getData() != null && PbActivity.this.mClickId >= 0 && PbActivity.this.mClickId < PbActivity.this.mModel.getData().getPost_list().size()) {
                        PostData post2 = PbActivity.this.mModel.getData().getPost_list().get((int) PbActivity.this.mClickId);
                        if (post2.getAuthor() != null) {
                            if (post2.getAuthor().getId() != null && post2.getAuthor().getId().equalsIgnoreCase("0")) {
                                PbActivity.this.showToast(PbActivity.this.getString(R.string.invalid_user));
                                return;
                            } else {
                                PersonInfoActivity.startActivity(PbActivity.this, post2.getAuthor().getId(), post2.getAuthor().getName());
                                return;
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public MarkData getMarkData() {
        MarkData data = new MarkData();
        Date date = new Date();
        data.setAccount(TiebaApplication.getCurrentAccount());
        data.setId(this.mPbId);
        if (this.mModel.getData() != null) {
            data.setTitle(this.mModel.getData().getThread().getTitle());
            if (this.mClickId >= 0 && this.mClickId < this.mModel.getData().getPost_list().size()) {
                PostData post = this.mModel.getData().getPost_list().get((int) this.mClickId);
                data.setFloor(post.getFloor_num());
                data.setPostId(this.mModel.getData().getPost_list().get((int) this.mClickId).getId());
            }
            data.setAuthorName(this.mModel.getData().getThread().getAuthor().getName_show());
            data.setReplyNum(this.mModel.getData().getThread().getReply_num());
        }
        data.setTime(date.getTime());
        data.setHostMode(this.mModel.getHostMode());
        data.setSequence(true);
        if (this.mModel.getData().getIsHasFloor()) {
            data.setSubPost(1);
            data.setForumId(this.mModel.getData().getForum().getId());
            data.setForumName(this.mModel.getData().getForum().getName());
            data.setThreadId(this.mModel.getData().getThread().getId());
        }
        return data;
    }

    public static void startAcitivity(Context context, String id, String st_type) {
        startAcitivity(context, id, true, false, st_type);
    }

    public static void startAcitivity(Context context, String id, Boolean sequence, Boolean hostMode, String st_type) {
        Intent intent = new Intent(context, PbActivity.class);
        if (id != null && id.length() > 0) {
            intent.putExtra(ID, id);
            intent.putExtra(SEQUENCE, sequence);
            intent.putExtra(HOSTMODE, hostMode);
            if (st_type != null) {
                intent.putExtra("st_type", st_type);
            }
            context.startActivity(intent);
        }
    }

    public static void startAcitivity(Context context, MarkData data) {
        Intent intent = new Intent(context, PbActivity.class);
        if (data.getId() != null && data.getPostId() != null) {
            intent.putExtra("mark", data);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pb_activity);
        initUI();
        initData(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
        try {
            if (this.mTask != null) {
                this.mTask.cancel();
                this.mTask = null;
            }
            if (this.mTipTask != null) {
                this.mTipTask.cancel();
                this.mTipTask = null;
            }
            if (this.mAdapter != null) {
                this.mAdapter.releaseProgressBar();
                this.mAdapter.getImageLoader().cancelAllAsyncTask();
            }
            if (this.mDialogAdapter != null) {
                this.mDialogAdapter.releaseProgressBar();
            }
            if (this.mModel != null) {
                if (this.mModel.getData() != null) {
                    this.mModel.setData(null);
                }
                this.mModel = null;
            }
            this.mProgress.setVisibility(8);
            System.gc();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ID, this.mPbId);
        outState.putBoolean(SEQUENCE, this.mModel.getSequence());
        outState.putBoolean(HOSTMODE, this.mModel.getHostMode());
        outState.putString(MARKID, this.mModel.getMarkId());
        outState.putBoolean(MARKMODE, this.mModel.getMarkMode());
        if (this.mSource != null) {
            outState.putString("st_type", this.mSource);
        }
    }

    public static boolean isAnonymityUser(PbModel data) {
        ThreadData thread;
        String id;
        return data == null || data.getData() == null || (thread = data.getData().getThread()) == null || thread.getAuthor() == null || (id = thread.getAuthor().getId()) == null || id.equals("0");
    }

    public void closeAllDialog() {
        if (this.mContextMenu != null && this.mContextMenu.isShowing()) {
            this.mContextMenu.dismiss();
        }
        if (this.mDialogMore != null && this.mDialogMore.isShowing()) {
            this.mDialogMore.dismiss();
        }
        if (this.mDialogTitle != null && this.mDialogTitle.isShowing()) {
            this.mDialogTitle.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTitleHint() {
        if (this.mDialogTitle == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            this.mDialogTitle = builder.create();
            this.mDialogTitle.setCanceledOnTouchOutside(true);
            LayoutInflater mInflater = getLayoutInflater();
            this.mPbTileDialogView = mInflater.inflate(R.layout.pb_title_dialog, (ViewGroup) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        if (this.mAdapter != null && this.mAdapter.getTextConfig() != TiebaApplication.app.getFontSize()) {
            this.mAdapter.setTextConfig(TiebaApplication.app.getFontSize());
            this.mAdapter.notifyDataSetChanged();
        }
        if (this.mAdapter != null && this.mAdapter.isShowImage() != TiebaApplication.app.isShowImages()) {
            this.mAdapter.setIsShowImage(TiebaApplication.app.isShowImages());
            this.mAdapter.notifyDataSetChanged();
        }
        MarkData mark = DatabaseService.getMarkDataById(this.mPbId);
        if (mark != null) {
            String markId = mark.getPostId();
            this.mModel.setMarkId(markId);
        } else {
            this.mModel.setMarkId(null);
        }
        this.mAdapter.notifyDataSetChanged();
        super.onResume();
    }

    private void initUI() {
        this.mListLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.PbActivity.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                PbActivity.this.mLongPos = arg2;
                if (PbActivity.this.getLongClickMenu() != null) {
                    PbActivity.this.showListMenu();
                    return true;
                }
                return true;
            }
        };
        this.mTitleText = (TextView) findViewById(R.id.titel_text);
        this.mTitle = (LinearLayout) findViewById(R.id.title);
        this.mTitleText.setClickable(true);
        this.mTitleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ThreadData thread;
                if (PbActivity.this.mModel != null && PbActivity.this.mModel.getData() != null && (thread = PbActivity.this.mModel.getData().getThread()) != null && thread.getTitle() != null && thread.getTitle().length() > 0) {
                    PbActivity.this.createTitleHint();
                    TextView text = (TextView) PbActivity.this.mPbTileDialogView.findViewById(R.id.text);
                    if (text != null) {
                        PbActivity.this.mDialogTitle.show();
                        text.setText("标题：" + thread.getTitle());
                        PbActivity.this.mDialogTitle.setContentView(PbActivity.this.mPbTileDialogView);
                        int y = (PbActivity.this.mTitle.getTop() + PbActivity.this.mTitle.getHeight()) - 5;
                        WindowManager.LayoutParams wmParams = PbActivity.this.mDialogTitle.getWindow().getAttributes();
                        wmParams.gravity = 51;
                        wmParams.x = 0;
                        wmParams.y = y;
                        wmParams.width = -1;
                        wmParams.height = -2;
                        wmParams.alpha = 1.0f;
                        PbActivity.this.mDialogTitle.getWindow().setAttributes(wmParams);
                    }
                }
            }
        });
        this.mMore = (Button) findViewById(R.id.more);
        this.mMore.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PbActivity.this.mDialogMore == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PbActivity.this);
                    PbActivity.this.mDialogMore = builder.create();
                    PbActivity.this.mDialogMore.setCanceledOnTouchOutside(true);
                    LayoutInflater mInflater = PbActivity.this.getLayoutInflater();
                    PbActivity.this.mDialogView = mInflater.inflate(R.layout.dialog_more, (ViewGroup) null);
                    ListView list = (ListView) PbActivity.this.mDialogView.findViewById(R.id.list);
                    PbActivity.this.mDialogAdapter = new DialogMoreAdapter(PbActivity.this, PbActivity.this.mModel);
                    list.setAdapter((ListAdapter) PbActivity.this.mDialogAdapter);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.PbActivity.5.1
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                            if (arg2 == 0) {
                                if (!PbActivity.this.mModel.getHostMode()) {
                                    PbActivity.this.requestHost();
                                } else {
                                    PbActivity.this.requestAll();
                                }
                            } else if (arg2 == 1) {
                                if (PbActivity.this.mModel.getSequence()) {
                                    PbActivity.this.requestReverse();
                                } else {
                                    PbActivity.this.requestSequence();
                                }
                            }
                            PbActivity.this.mDialogMore.dismiss();
                        }
                    });
                }
                if (PbActivity.this.mModel.getData() != null) {
                    if (PbActivity.this.mDialogAdapter != null) {
                        PbActivity.this.mDialogAdapter.setIsProgress(PbActivity.this.mModel.getIsprogressTip());
                        PbActivity.this.mDialogAdapter.notifyDataSetInvalidated();
                    }
                    PbActivity.this.mDialogMore.show();
                    PbActivity.this.mDialogMore.setContentView(PbActivity.this.mDialogView);
                    int width = PbActivity.this.mDialogView.getWidth();
                    int y = (PbActivity.this.mTitle.getTop() + PbActivity.this.mTitle.getHeight()) - 5;
                    int equipWidth = UtilHelper.getEquipmentWidth(PbActivity.this);
                    WindowManager.LayoutParams wmParams = PbActivity.this.mDialogMore.getWindow().getAttributes();
                    wmParams.gravity = 51;
                    wmParams.x = (equipWidth - width) - 1;
                    wmParams.y = y;
                    wmParams.alpha = 1.0f;
                    wmParams.width = UtilHelper.dip2px(PbActivity.this, 200.0f);
                    wmParams.height = -2;
                    PbActivity.this.mDialogMore.getWindow().setAttributes(wmParams);
                }
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PbActivity.this.closeAllDialog();
                PbActivity.this.finish();
            }
        });
        this.mReply = (Button) findViewById(R.id.reply);
        this.mReply.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PbActivity.this.mPbId != null && PbActivity.this.mPbId.length() > 0 && PbActivity.this.mModel.getData() != null) {
                    WriteActivity.startAcitivity(PbActivity.this, PbActivity.this.mModel.getData().getForum().getId(), PbActivity.this.mModel.getData().getForum().getName(), PbActivity.this.mPbId, null, 0, PbActivity.this.mModel.getData().getAnti());
                }
            }
        });
        this.mPbList = (ListView) findViewById(R.id.pb_list);
        this.mPbList.setFastScrollEnabled(true);
        this.mAdapter = new PbAdapter(this, null, UtilHelper.dip2px(this, 234.0f));
        this.mAdapter.setTextConfig(TiebaApplication.app.getFontSize());
        this.mAdapter.setIsShowImage(TiebaApplication.app.isShowImages());
        this.mAdapter.setHaveFooter(0);
        this.mAdapter.setHaveHeader(0);
        this.mPbList.setAdapter((ListAdapter) this.mAdapter);
        this.mPbList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.PbActivity.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long id) {
                boolean isMarked;
                PbActivity.this.mClickId = -1L;
                if (id == -1) {
                    if (PbActivity.this.mAdapter.isProcessPre()) {
                        return;
                    }
                    PbActivity.this.getPreDate();
                } else if (id != -2) {
                    if (PbActivity.this.mContextMenu != null) {
                        PbActivity.this.mClickId = id;
                        PostData data = (PostData) PbActivity.this.mAdapter.getItem(arg2);
                        if (PbActivity.this.mModel.getData().getIsHasFloor() && data.getFloor_num() != 1) {
                            if (data != null && PbActivity.this.mModel.getMarkId() != null && PbActivity.this.mModel.getMarkId().equals(data.getId())) {
                                isMarked = true;
                            } else {
                                isMarked = false;
                            }
                            Intent intent = new Intent(PbActivity.this, SubPbActivity.class);
                            intent.putExtra("themeId", PbActivity.this.mPbId);
                            intent.putExtra("postId", data.getId());
                            intent.putExtra("fid", PbActivity.this.mModel.getData().getForum().getId());
                            intent.putExtra("kw", PbActivity.this.mModel.getData().getForum().getName());
                            intent.putExtra("threadId", PbActivity.this.mModel.getData().getThread().getId());
                            intent.putExtra("mark", PbActivity.this.getMarkData());
                            intent.putExtra("isMarked", isMarked);
                            PbActivity.this.startActivity(intent);
                            return;
                        }
                        if (data == null || PbActivity.this.mModel.getMarkId() == null || !PbActivity.this.mModel.getMarkId().equals(data.getId())) {
                            PbActivity.this.mContextMenuAdapter.setItem(1, PbActivity.this.getString(R.string.add_mark));
                        } else {
                            PbActivity.this.mContextMenuAdapter.setItem(1, PbActivity.this.getString(R.string.remove_mark));
                        }
                        PbActivity.this.mContextMenuAdapter.notifyDataSetInvalidated();
                        PbActivity.this.mContextMenu.show();
                    }
                } else if (PbActivity.this.mAdapter.isProcessMore()) {
                } else {
                    PbActivity.this.getNextDate();
                }
            }
        });
        this.mPbList.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.PbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                PbActivity.this.mHandler.removeCallbacks(PbActivity.this.mGetImageRunnble);
                PbActivity.this.mHandler.postDelayed(PbActivity.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                PbActivity.this.mPbList.setOnItemLongClickListener(null);
            }
        });
        this.mPbList.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.PbActivity.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 0) {
                    PbActivity.this.mPbList.setOnItemLongClickListener(PbActivity.this.mListLongClickListener);
                    return false;
                }
                return false;
            }
        });
        this.mPbList.setOnItemLongClickListener(this.mListLongClickListener);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog getLongClickMenu() {
        if (getListMenu() != null) {
            return getListMenu();
        }
        DialogInterface.OnClickListener menuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                PostData data;
                if (which == 0 && (data = (PostData) PbActivity.this.mAdapter.getItem(PbActivity.this.mLongPos)) != null) {
                    data.setClipString(PbActivity.this);
                }
            }
        };
        return createListMenu(new String[]{getString(R.string.copy)}, menuListener);
    }

    private void getMoreDate(int direct) {
        ArrayList<PostData> list;
        if (this.mModel != null && this.mModel.getData() != null && (list = this.mModel.getData().getPost_list()) != null && list.size() > 0) {
            if (direct == 0) {
                startPbAsyncTask(2);
            } else {
                startPbAsyncTask(1);
            }
            if (this.mTask != null) {
                if (direct == 0) {
                    this.mAdapter.setIsProcessPre(true);
                } else {
                    this.mAdapter.setIsProcessMore(true);
                }
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNextDate() {
        getMoreDate(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getPreDate() {
        getMoreDate(0);
    }

    private void initData(Bundle savedInstanceState) {
        Boolean sequence;
        Boolean hostMode;
        String[] items = {getString(R.string.reply), getString(R.string.mark), getString(R.string.view_info)};
        this.mContextMenuAdapter = new ContextMenuAdapter(this, items);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setAdapter(this.mContextMenuAdapter, this.mContextMenuListener);
        if (this.mContextMenu == null) {
            this.mContextMenu = builder.create();
            this.mContextMenu.setCanceledOnTouchOutside(true);
        }
        this.mModel = new PbModel();
        Boolean.valueOf(true);
        Boolean.valueOf(false);
        String markId = null;
        if (savedInstanceState != null) {
            this.mPbId = savedInstanceState.getString(ID);
            sequence = Boolean.valueOf(savedInstanceState.getBoolean(SEQUENCE, true));
            hostMode = Boolean.valueOf(savedInstanceState.getBoolean(HOSTMODE, false));
            markId = savedInstanceState.getString(MARKID);
            this.mModel.setMarkMode(savedInstanceState.getBoolean(MARKMODE, false));
            this.mSource = savedInstanceState.getString("st_type");
        } else {
            Intent intent = getIntent();
            this.mSource = intent.getStringExtra("st_type");
            MarkData data = (MarkData) intent.getSerializableExtra("mark");
            if (data != null) {
                this.mPbId = data.getId();
                sequence = data.getSequence();
                hostMode = Boolean.valueOf(data.getHostMode());
                markId = data.getPostId();
                this.mModel.setMarkMode(true);
            } else {
                this.mPbId = intent.getStringExtra(ID);
                sequence = Boolean.valueOf(intent.getBooleanExtra(SEQUENCE, true));
                hostMode = Boolean.valueOf(intent.getBooleanExtra(HOSTMODE, false));
                MarkData mark = DatabaseService.getMarkDataById(this.mPbId);
                if (mark != null) {
                    markId = mark.getPostId();
                }
            }
        }
        TiebaApplication app = (TiebaApplication) getApplication();
        if (app != null) {
            this.mModel.setIsDisplayPhoto(app.getDisplayPhoto());
        }
        if (hostMode.booleanValue()) {
            sequence = true;
        }
        this.mModel.setSequence(sequence.booleanValue());
        this.mModel.setHostMode(hostMode.booleanValue());
        this.mModel.setMarkId(markId);
        if (this.mModel.getMarkMode()) {
            startPbAsyncTask(4);
        } else {
            startPbAsyncTask(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPbAsyncTask(int type) {
        BasicNameValuePair mark;
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        try {
            StringBuffer address = new StringBuffer(30);
            address.append(Config.SERVER_ADDRESS);
            address.append(Config.PB_ADDRESS);
            ArrayList<BasicNameValuePair> param = new ArrayList<>();
            BasicNameValuePair theme = new BasicNameValuePair(URL_THEME, this.mPbId);
            param.add(theme);
            BasicNameValuePair num = new BasicNameValuePair(URL_NUM, String.valueOf(60));
            param.add(num);
            if (!this.mModel.getSequence()) {
                BasicNameValuePair order = new BasicNameValuePair(URL_ORDER, String.valueOf(1));
                param.add(order);
            }
            if (this.mModel.getHostMode()) {
                BasicNameValuePair host = new BasicNameValuePair(URL_HOST, String.valueOf(1));
                param.add(host);
            }
            if (this.mPbId != null && this.mPbId.length() > 0) {
                if (type == 2) {
                    BasicNameValuePair direct = new BasicNameValuePair(URL_DIRECTION, NetWorkCore.NET_TYPE_NET);
                    param.add(direct);
                    ArrayList<PostData> list = this.mModel.getData().getPost_list();
                    if (list != null && list.size() > 0) {
                        int size = list.size();
                        String id = list.get(0).getId();
                        if (id != null && id.length() > 0) {
                            BasicNameValuePair pid = new BasicNameValuePair(URL_PID, id);
                            param.add(pid);
                        }
                        if (size > Config.PB_LIST_ITEM_MAX_NUM - 60) {
                            for (int i = 1; i <= size - (Config.PB_LIST_ITEM_MAX_NUM - 60) && size - i >= 0; i++) {
                                list.remove(size - i);
                            }
                            this.mAdapter.setHaveFooter(2);
                            this.mAdapter.notifyDataSetChanged();
                        }
                    }
                } else if (type == 1) {
                    BasicNameValuePair direct2 = new BasicNameValuePair(URL_DIRECTION, String.valueOf(0));
                    param.add(direct2);
                    ArrayList<PostData> list2 = this.mModel.getData().getPost_list();
                    if (list2 != null && list2.size() > 0) {
                        int size2 = list2.size();
                        String id2 = list2.get(size2 - 1).getId();
                        if (id2 != null && id2.length() > 0) {
                            BasicNameValuePair pid2 = new BasicNameValuePair(URL_PID, id2);
                            param.add(pid2);
                        }
                        if (size2 > Config.PB_LIST_ITEM_MAX_NUM - 60) {
                            for (int i2 = Config.PB_LIST_ITEM_MAX_NUM - 60; i2 < size2; i2++) {
                                list2.remove(0);
                            }
                            this.mAdapter.setHaveHeader(2);
                            this.mAdapter.notifyDataSetChanged();
                        }
                    } else if (!this.mModel.getSequence()) {
                        param.add(new BasicNameValuePair(URL_LAST, String.valueOf(1)));
                    }
                } else if (type == 4) {
                    BasicNameValuePair pid3 = new BasicNameValuePair(URL_PID, this.mModel.getMarkId());
                    param.add(pid3);
                    BasicNameValuePair direct3 = new BasicNameValuePair(URL_DIRECTION, "0");
                    param.add(direct3);
                    BasicNameValuePair st_type = new BasicNameValuePair("st_type", "tb_bookmarklist");
                    param.add(st_type);
                    this.mAdapter.setHaveFooter(0);
                    this.mAdapter.setHaveHeader(0);
                    this.mProgress.setVisibility(0);
                } else {
                    BasicNameValuePair direct4 = new BasicNameValuePair(URL_DIRECTION, "0");
                    param.add(direct4);
                    if (!this.mModel.getSequence()) {
                        BasicNameValuePair last = new BasicNameValuePair(URL_LAST, String.valueOf(1));
                        param.add(last);
                    }
                    if (this.mModel.getData() != null) {
                        this.mModel.getData().getPost_list().clear();
                        this.mAdapter.notifyDataSetChanged();
                    }
                    this.mAdapter.setHaveFooter(0);
                    this.mAdapter.setHaveHeader(0);
                    if (this.mSource != null) {
                        BasicNameValuePair st_type2 = new BasicNameValuePair("st_type", this.mSource);
                        param.add(st_type2);
                    }
                    this.mProgress.setVisibility(0);
                    System.gc();
                }
                if (type == 4) {
                    mark = new BasicNameValuePair("mark", NetWorkCore.NET_TYPE_NET);
                } else {
                    mark = new BasicNameValuePair("mark", "0");
                }
                param.add(mark);
                this.mTask = new PbAsyncTask(address.toString(), param, type);
                this.mTask.execute(address.toString(), param);
            }
        } catch (Exception ex) {
            TiebaLog.e("PbActivity", "startPbAsyncTask", "error" + ex.getMessage());
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            if (this.mModel.getData() != null && this.mModel.getData().getForum().getId() != null && this.mModel.getData().getForum().getName() != null) {
                menu.findItem(4).setEnabled(true);
            } else {
                menu.findItem(4).setEnabled(false);
            }
            MenuItem tip = menu.findItem(5);
            tip.setTitleCondensed(this.mModel.getTipString(this, true));
            if (!this.mModel.isCanTip()) {
                tip.setEnabled(false);
            } else {
                tip.setEnabled(true);
            }
            if (!isAnonymityUser(this.mModel)) {
                menu.findItem(6).setEnabled(true);
                menu.findItem(8).setEnabled(true);
            } else {
                menu.findItem(6).setEnabled(false);
                menu.findItem(8).setEnabled(false);
            }
            if (this.mModel.getHostMode()) {
                menu.findItem(6).setVisible(false);
                menu.findItem(8).setVisible(true);
            } else {
                menu.findItem(6).setVisible(true);
                menu.findItem(8).setVisible(false);
            }
            if (this.mModel.getData() != null) {
                menu.findItem(7).setEnabled(true);
                menu.findItem(9).setEnabled(true);
            } else {
                menu.findItem(7).setEnabled(false);
                menu.findItem(9).setEnabled(false);
            }
            if (this.mModel.getSequence()) {
                menu.findItem(7).setVisible(true);
                menu.findItem(9).setVisible(false);
            } else {
                menu.findItem(7).setVisible(false);
                menu.findItem(9).setVisible(true);
            }
        } catch (Exception e) {
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.mMenu = menu;
        menu.add(0, 4, 1, getString(R.string.reply)).setIcon(R.drawable.menu_reply);
        menu.add(0, 5, 2, getString(R.string.tip)).setIcon(R.drawable.menu_tip);
        menu.add(0, 8, 4, getString(R.string.view_all)).setIcon(R.drawable.menu_view_all);
        menu.add(0, 6, 4, getString(R.string.view_host)).setIcon(R.drawable.menu_view_host);
        menu.add(0, 7, 5, getString(R.string.view_reverse)).setIcon(R.drawable.menu_view_new);
        menu.add(0, 9, 5, getString(R.string.view_sequence)).setIcon(17301568);
        return true;
    }

    private void requestTip() {
        if (!this.mModel.getIsprogressTip() && this.mModel.getData() != null) {
            if (this.mTipTask != null) {
                this.mTipTask.cancel();
                this.mTipTask = null;
            }
            this.mModel.setIsprogressTip(true);
            ForumData forum = this.mModel.getData().getForum();
            this.mTipTask = new TipAsyncTask(forum.getId(), forum.getName(), this.mModel.getData().getThread().getId());
            this.mTipTask.execute("http://c.tieba.baidu.com/c/c/thread/comment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestHost() {
        this.mModel.setHostMode(true);
        this.mModel.setSequence(true);
        startPbAsyncTask(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAll() {
        this.mModel.setHostMode(false);
        startPbAsyncTask(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestReverse() {
        this.mModel.setSequence(false);
        this.mModel.setHostMode(false);
        startPbAsyncTask(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSequence() {
        this.mModel.setSequence(true);
        startPbAsyncTask(3);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 4:
                if (this.mPbId != null && this.mPbId.length() > 0 && this.mModel.getData() != null) {
                    WriteActivity.startAcitivity(this, this.mModel.getData().getForum().getId(), this.mModel.getData().getForum().getName(), this.mPbId, null, 0, this.mModel.getData().getAnti());
                    break;
                }
                break;
            case 5:
                requestTip();
                break;
            case 6:
                requestHost();
                break;
            case 7:
                requestReverse();
                break;
            case 8:
                requestAll();
                break;
            case 9:
                requestSequence();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0049 -> B:27:0x000f). Please submit an issue!!! */
    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == 101 || requestCode == 102) {
                try {
                    String current_id = TiebaApplication.getCurrentAccount();
                    String host_id = this.mModel.getData().getThread().getAuthor().getId();
                    if (!this.mModel.getHostMode() || current_id.equals(host_id)) {
                        if (this.mModel.getSequence() && this.mAdapter.getHaveFooter() == 1) {
                            getNextDate();
                        } else if (!this.mModel.getSequence() && this.mAdapter.getHaveHeader() == 1) {
                            getPreDate();
                        }
                    }
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "onActivityResult", ex.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PbAsyncTask extends AsyncTask<Object, Integer, PbData> {
        ArrayList<BasicNameValuePair> mParam;
        private int mType;
        private String mUrl;
        private NetWork mNetwork = null;
        private volatile long mStartTime = 0;

        public PbAsyncTask(String url, ArrayList<BasicNameValuePair> param, int type) {
            this.mType = 3;
            this.mUrl = null;
            this.mParam = null;
            this.mUrl = url;
            this.mParam = param;
            this.mType = type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public PbData doInBackground(Object... params) {
            PbData pbData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParam);
                if (PbActivity.mPbLoadTime != 0) {
                    this.mNetwork.addPostData("ctime", String.valueOf(PbActivity.mPbLoadTime));
                }
                if (PbActivity.mNetError != 0) {
                    this.mNetwork.addPostData("net_error", String.valueOf(PbActivity.mNetError));
                }
                String data = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess()) {
                    PbData pbData2 = new PbData();
                    try {
                        pbData2.parserJson(data);
                        int size = pbData2.getPost_list().size();
                        for (int i = 0; i < size; i++) {
                            pbData2.getPost_list().get(i).uniteContentExcepFace(PbActivity.this);
                            pbData2.getPost_list().get(i).setContent(null);
                        }
                        pbData = pbData2;
                    } catch (Exception e) {
                        ex = e;
                        pbData = pbData2;
                        TiebaLog.e("PbAsyncTask", "doInBackground", "error = " + ex.getMessage());
                        return pbData;
                    }
                }
                if (this.mNetwork.isNetSuccess()) {
                    PbActivity.mPbLoadTime = 0L;
                    PbActivity.mNetError = 0;
                } else {
                    PbActivity.mNetError = 1;
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return pbData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(PbData data) {
            try {
                if (data != null) {
                    PbData d_data = PbActivity.this.mModel.getData();
                    PbActivity.this.mSource = null;
                    PbActivity.this.mModel.setHaveMore(data.getPage().getHave_more());
                    PbActivity.this.mModel.setHavePre(data.getPage().getHave_pre());
                    if (this.mType == 3) {
                        PbActivity.this.mModel.setData(data);
                        if (PbActivity.this.mModel.getSequence()) {
                            if (data.getPage().getHave_more() == 1) {
                                PbActivity.this.mAdapter.setHaveFooter(2);
                            } else {
                                PbActivity.this.mAdapter.setHaveFooter(1);
                            }
                            if (data.getPage().getHave_pre() == 1) {
                                PbActivity.this.mAdapter.setHaveHeader(2);
                            } else {
                                PbActivity.this.mAdapter.setHaveHeader(0);
                            }
                        } else {
                            if (data.getPage().getHave_more() == 1) {
                                PbActivity.this.mAdapter.setHaveFooter(2);
                            } else {
                                PbActivity.this.mAdapter.setHaveFooter(0);
                            }
                            if (data.getPage().getHave_pre() == 1) {
                                PbActivity.this.mAdapter.setHaveHeader(2);
                            } else {
                                PbActivity.this.mAdapter.setHaveHeader(1);
                            }
                        }
                        if (PbActivity.this.mDialogMore != null && PbActivity.this.mDialogMore.isShowing() && PbActivity.this.mDialogAdapter != null) {
                            PbActivity.this.mDialogAdapter.notifyDataSetInvalidated();
                        }
                    } else if (d_data != null && this.mType == 2) {
                        int pos = PbActivity.this.mPbList.getFirstVisiblePosition();
                        ArrayList<PostData> d_list = d_data.getPost_list();
                        ArrayList<PostData> s_list = data.getPost_list();
                        int pos2 = pos + s_list.size();
                        d_list.addAll(0, s_list);
                        d_data.setPage(data.getPage());
                        d_data.setForum(data.getForum());
                        d_data.setThread(data.getThread());
                        d_data.setAnti(data.getAnti());
                        if (PbActivity.this.mModel.getSequence()) {
                            if (d_data.getPage().getHave_pre() == 1) {
                                PbActivity.this.mAdapter.setHaveHeader(2);
                            } else {
                                PbActivity.this.mAdapter.setHaveHeader(0);
                            }
                        } else if (d_data.getPage().getHave_pre() == 1) {
                            PbActivity.this.mAdapter.setHaveHeader(2);
                        } else {
                            PbActivity.this.mAdapter.setHaveHeader(1);
                        }
                        PbActivity.this.mPbList.setSelection(pos2);
                    } else if (d_data != null && this.mType == 1) {
                        ArrayList<PostData> d_list2 = d_data.getPost_list();
                        d_list2.addAll(data.getPost_list());
                        d_data.setPage(data.getPage());
                        d_data.setForum(data.getForum());
                        d_data.setThread(data.getThread());
                        d_data.setAnti(data.getAnti());
                        if (PbActivity.this.mModel.getSequence()) {
                            if (d_data.getPage().getHave_more() == 1) {
                                PbActivity.this.mAdapter.setHaveFooter(2);
                            } else {
                                PbActivity.this.mAdapter.setHaveFooter(1);
                            }
                        } else if (d_data.getPage().getHave_more() == 1) {
                            PbActivity.this.mAdapter.setHaveFooter(2);
                        } else {
                            PbActivity.this.mAdapter.setHaveFooter(0);
                        }
                    } else if (this.mType == 4) {
                        PbActivity.this.mModel.setData(data);
                        if (data.getPage().getHave_more() == 1) {
                            PbActivity.this.mAdapter.setHaveFooter(2);
                        } else {
                            PbActivity.this.mAdapter.setHaveFooter(1);
                        }
                        if (data.getPage().getHave_pre() == 1) {
                            PbActivity.this.mAdapter.setHaveHeader(2);
                            PbActivity.this.mPbList.setSelection(1);
                        } else {
                            PbActivity.this.mAdapter.setHaveHeader(0);
                        }
                        if (PbActivity.this.mDialogMore != null && PbActivity.this.mDialogMore.isShowing() && PbActivity.this.mDialogAdapter != null) {
                            PbActivity.this.mDialogAdapter.notifyDataSetInvalidated();
                        }
                    }
                    long end_time = System.nanoTime();
                    PbActivity.mPbLoadTime = (end_time - this.mStartTime) / 1000000000;
                } else if (this.mNetwork != null) {
                    if (this.mType == 3 || this.mType == 4) {
                        if (this.mNetwork.isNetSuccess()) {
                            PbActivity.this.showToast(this.mNetwork.getErrorString());
                            if (this.mNetwork.getErrorCode() == 4 || this.mNetwork.getErrorCode() == 28) {
                                PbActivity.this.closeAllDialog();
                                PbActivity.this.finish();
                                return;
                            }
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(PbActivity.this);
                            builder.setTitle(PbActivity.this.getString(R.string.error));
                            builder.setMessage(this.mNetwork.getErrorString());
                            builder.setPositiveButton(PbActivity.this.getString(R.string.retry), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.PbAsyncTask.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    PbActivity.this.startPbAsyncTask(PbAsyncTask.this.mType);
                                }
                            });
                            builder.setNegativeButton(PbActivity.this.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.PbAsyncTask.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            if (PbActivity.this.mDialogMore != null && PbActivity.this.mDialogMore.isShowing()) {
                                PbActivity.this.mDialogMore.dismiss();
                            }
                            builder.create().show();
                        }
                    } else {
                        PbActivity.this.showToast(this.mNetwork.getErrorString());
                    }
                }
                refreshActivity();
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "onPostExecute", ex.getMessage());
            }
            PbActivity.this.mTask = null;
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
            if (PbActivity.this.mProgress.getVisibility() == 0) {
                PbActivity.this.mProgress.setVisibility(8);
            }
            if (PbActivity.this.mAdapter.isProcessMore()) {
                PbActivity.this.mAdapter.setIsProcessMore(false);
                if (PbActivity.this.mAdapter.isHaveFooter()) {
                    PbActivity.this.mAdapter.notifyDataSetChanged();
                }
            }
            if (PbActivity.this.mAdapter.isProcessPre()) {
                PbActivity.this.mAdapter.setIsProcessPre(false);
                if (PbActivity.this.mAdapter.isHaveHeader()) {
                    PbActivity.this.mAdapter.notifyDataSetInvalidated();
                }
            }
        }

        private void refreshActivity() {
            try {
                if (PbActivity.this.mModel != null && PbActivity.this.mModel.getData() != null) {
                    ArrayList<PostData> list = PbActivity.this.mModel.getData().getPost_list();
                    if (list != null) {
                        PbActivity.this.mAdapter.setData(PbActivity.this.mModel);
                        PbActivity.this.mAdapter.notifyDataSetChanged();
                    }
                    ThreadData threadData = PbActivity.this.mModel.getData().getThread();
                    if (threadData != null && threadData.getTitle() != null) {
                        PbActivity.this.mTitleText.setText(threadData.getTitle());
                    }
                }
                if (PbActivity.this.mModel.getData() != null && PbActivity.this.mModel.getData().getForum().getId() != null && PbActivity.this.mMenu != null && PbActivity.this.mMenu.hasVisibleItems()) {
                    if (PbActivity.this.mMenu.findItem(4) != null) {
                        PbActivity.this.mMenu.findItem(4).setEnabled(true);
                    }
                    if (PbActivity.this.mMenu.findItem(5) != null) {
                        if (!PbActivity.this.mModel.isCanTip()) {
                            PbActivity.this.mMenu.findItem(5).setEnabled(false);
                        } else {
                            PbActivity.this.mMenu.findItem(5).setEnabled(true);
                        }
                    }
                    if (!PbActivity.isAnonymityUser(PbActivity.this.mModel)) {
                        if (PbActivity.this.mMenu.findItem(6) != null) {
                            PbActivity.this.mMenu.findItem(6).setEnabled(true);
                        }
                        if (PbActivity.this.mMenu.findItem(8) != null) {
                            PbActivity.this.mMenu.findItem(8).setEnabled(true);
                        }
                    }
                    if (PbActivity.this.mMenu.findItem(7) != null) {
                        PbActivity.this.mMenu.findItem(7).setEnabled(true);
                    }
                    if (PbActivity.this.mMenu.findItem(9) != null) {
                        PbActivity.this.mMenu.findItem(9).setEnabled(true);
                    }
                    MenuItem hostMenu = PbActivity.this.mMenu.findItem(6);
                    if (hostMenu != null) {
                        hostMenu.setEnabled(PbActivity.isAnonymityUser(PbActivity.this.mModel) ? false : true);
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("PbActivity", "refreshActivity", "error = " + ex.getMessage());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.mStartTime = System.nanoTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TipAsyncTask extends AsyncTask<String, Integer, String> {
        private String mForumId;
        private String mForumName;
        private NetWork mNetwork = null;
        private String mThreadId;

        public TipAsyncTask(String forumId, String forumName, String threadId) {
            this.mForumId = forumId;
            this.mForumName = forumName;
            this.mThreadId = threadId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            String url = params[0];
            this.mNetwork = new NetWork(url);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("kw", this.mForumName);
            this.mNetwork.addPostData("tid", this.mThreadId);
            this.mNetwork.setIsNeedTbs(true);
            this.mNetwork.postNetData();
            if (this.mNetwork.isRequestSuccess()) {
                return null;
            }
            return this.mNetwork.getErrorString();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            PbActivity.this.mModel.setIsprogressTip(false);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            MenuItem tip;
            super.onPostExecute((TipAsyncTask) result);
            PbActivity.this.mTipTask = null;
            PbActivity.this.mModel.setIsprogressTip(false);
            if (this.mNetwork != null) {
                if (!this.mNetwork.isRequestSuccess()) {
                    PbActivity.this.showToast(this.mNetwork.getErrorString());
                    if (this.mNetwork.getErrorCode() != 14) {
                        return;
                    }
                } else {
                    PbActivity.this.showToast(PbActivity.this.getString(R.string.success));
                }
                if (PbActivity.this.mModel.getData() != null) {
                    PbActivity.this.mModel.getData().getThread().setHas_commented(1);
                    if (this.mNetwork.getErrorCode() != 14) {
                        int comment_num = PbActivity.this.mModel.getData().getThread().getComment_num() + 1;
                        PbActivity.this.mModel.getData().getThread().setComment_num(comment_num);
                    }
                }
                if (PbActivity.this.mDialogAdapter != null) {
                    PbActivity.this.mDialogAdapter.setIsProgress(PbActivity.this.mModel.getIsprogressTip());
                    PbActivity.this.mDialogAdapter.notifyDataSetInvalidated();
                }
                if (PbActivity.this.mMenu != null && PbActivity.this.mMenu.hasVisibleItems() && (tip = PbActivity.this.mMenu.findItem(5)) != null) {
                    tip.setTitleCondensed(PbActivity.this.mModel.getTipString(PbActivity.this, true));
                    if (!PbActivity.this.mModel.isCanTip()) {
                        tip.setEnabled(false);
                    } else {
                        tip.setEnabled(true);
                    }
                }
            }
        }
    }
}
