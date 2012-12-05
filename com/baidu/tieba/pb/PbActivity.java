package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.PbData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity {
    public static final String BACK_SPECIAL = "back_special";
    private static final String HOSTMODE = "hostMode";
    private static final String ID = "id";
    private static final String IS_AD = "isAd";
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
    public static final String MESSAGE_PUSH_ENTRY = "message_push_entry";
    private static final String SEQUENCE = "sequence";
    private static final String ST_TYPE = "st_type";
    private static final int UPDATE_TYPE_MARK = 4;
    private static final int UPDATE_TYPE_MORE = 1;
    private static final int UPDATE_TYPE_PREVIOUS = 2;
    private static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    private static final int UPDATE_TYPE_UPDATE = 3;
    private static final String URL_DIRECTION = "back";
    private static final String URL_HOST = "lz";
    private static final String URL_LAST = "last";
    private static final String URL_MARK = "mark";
    private static final String URL_NUM = "rn";
    private static final String URL_ORDER = "r";
    private static final String URL_PID = "pid";
    private static final String URL_PN = "pn";
    private static final String URL_ST_TYPE = "st_type";
    private static final String URL_THEME = "kz";
    private TextView headTextView;
    private static volatile long mPbLoadTime = 0;
    private static volatile long mPbLoadDataSize = 0;
    private static volatile int mNetError = 0;
    private ListView mPbList = null;
    private AlertDialog mContextMenu = null;
    private TextView mTitleText = null;
    private Button mReply = null;
    private Button mRedirectPage = null;
    private Button mBack = null;
    private Button mMore = null;
    private EditText mInputRedirectPage = null;
    private Button mBtnRecommend = null;
    private PbAdapter mAdapter = null;
    private PbAsyncTask mTask = null;
    private TipAsyncTask mTipTask = null;
    private PbModel mModel = null;
    private String mPbId = null;
    private ProgressBar mProgress = null;
    private Handler mHandler = new Handler();
    private AdapterView.OnItemLongClickListener mListLongClickListener = null;
    private long mClickId = -1;
    private PostData mClickPost = null;
    private AlertDialog mDialogMore = null;
    private AlertDialog mDialogTitle = null;
    private Dialog mDialogDirectPager = null;
    private View mDialogView = null;
    private View mDirectPagerDialogView = null;
    private LinearLayout mBottomBar = null;
    private Button mBtnRefresh = null;
    private Dialog mDialogDelPost = null;
    private View mDelPostView = null;
    private Button mBtnDoDelPost = null;
    private Button mBtnCancelDelPost = null;
    private TextView mTxtDelPostTip = null;
    private Dialog mDialogForbidUser = null;
    private View mForbidUserView = null;
    private int mForbidTime = 0;
    private RadioGroup mRadioGroup = null;
    private RadioButton mBtn1Day = null;
    private RadioButton mBtn3Day = null;
    private RadioButton mBtn10Day = null;
    private Button mBtnDoForbidUser = null;
    private Button mBtnCancelForbidUser = null;
    private TextView mTxtUserName = null;
    private DelPostAsyncTask mDelPostAsyncTask = null;
    private ForbidUserAsyncTask mForbidUserAsyncTask = null;
    private Menu mMenu = null;
    private DialogMoreAdapter mDialogAdapter = null;
    private ContextMenuAdapter mContextMenuAdapter = null;
    private String mSource = null;
    private int mLongPos = -1;
    private MarkData mMarkData = null;
    private boolean mMarkAdd = true;
    private String mUid = null;
    private boolean mBackSpecial = false;
    private String frsString = null;
    private boolean scrollButtom = false;
    private boolean pvSign = false;
    private ImageView mGuidePage = null;
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.pb.PbActivity.1
        @Override // java.lang.Runnable
        public void run() {
            boolean supportHold;
            try {
                int start = PbActivity.this.mPbList.getFirstVisiblePosition();
                int end = PbActivity.this.mPbList.getLastVisiblePosition();
                int image_num = 0;
                int photo_num = 0;
                NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(PbActivity.this);
                PbActivity.this.mAdapter.getImageLoader().clearHoldUrl();
                if (info == NetWorkCore.NetworkStateInfo.WIFI || info == NetWorkCore.NetworkStateInfo.ThreeG) {
                    supportHold = true;
                } else {
                    supportHold = false;
                }
                PbActivity.this.mAdapter.getImageLoader().setSupportHoldUrl(supportHold);
                for (int i = start; i < PbActivity.this.mAdapter.getCount(); i++) {
                    if (supportHold || i <= end) {
                        PostData data = (PostData) PbActivity.this.mAdapter.getItem(i);
                        if (data != null) {
                            ArrayList<ContentData> content = data.getUnite_content();
                            int contentSize = content.size();
                            if (PbActivity.this.mAdapter.isShowImage() && image_num < 13) {
                                for (int j = 0; j < contentSize; j++) {
                                    if (content.get(j).getType() == 3 || content.get(j).getType() == 5) {
                                        if (image_num >= 13) {
                                            break;
                                        }
                                        image_num++;
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
                            if (PbActivity.this.mModel.getIsDisplayPhoto() && authorPhoto != null && authorPhoto.length() > 0 && photo_num < 30) {
                                photo_num++;
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
                            if (supportHold && image_num >= 13 && photo_num >= 30) {
                                return;
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
            switch (item) {
                case 0:
                    if (PbActivity.this.mPbId != null && PbActivity.this.mPbId.length() > 0 && PbActivity.this.mModel.getData() != null) {
                        PostData post = PbActivity.this.mModel.getData().getPost_list().get((int) PbActivity.this.mClickId);
                        PbActivity.this.mClickPost = post;
                        PbActivity.this.replyBlog(post);
                        return;
                    }
                    return;
                case 1:
                    MarkData data = PbActivity.this.getMarkData();
                    PbActivity.this.mMarkData = data;
                    String text = (String) PbActivity.this.mContextMenuAdapter.getItem(1);
                    if (text == null || !text.equals(PbActivity.this.getString(R.string.remove_mark))) {
                        PbActivity.this.mMarkAdd = true;
                    } else {
                        PbActivity.this.mMarkAdd = false;
                    }
                    PbActivity.this.dealMark(data, PbActivity.this.mMarkAdd);
                    return;
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
    public void dealMark(MarkData data, boolean is_add) {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_MARK);
            return;
        }
        data.setAccount(TiebaApplication.getCurrentAccount());
        if (!is_add) {
            if (DatabaseService.deleteMarkData(data.getId())) {
                showToast(getString(R.string.success));
                this.mModel.setMarkId(null);
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            showToast(getString(R.string.fail));
        } else if (DatabaseService.saveMarkData(data)) {
            showToast(getString(R.string.success));
            this.mModel.setMarkId(data.getPostId());
            this.mAdapter.notifyDataSetChanged();
        } else {
            showToast(getString(R.string.fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replyBlog(PostData post) {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            if (this.mModel != null && this.mModel.getData() != null && this.mModel.getData().getAnti() != null) {
                this.mModel.getData().getAnti().setIfpost(1);
            }
            if (post != null) {
                LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_REPLY_FLOOR);
            } else {
                LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_REPLY);
            }
        } else if (this.mPbId != null && this.mPbId.length() > 0 && this.mModel.getData() != null) {
            if (post != null) {
                WriteActivity.startAcitivity(this, this.mModel.getData().getForum().getId(), this.mModel.getData().getForum().getName(), this.mPbId, post.getId(), post.getFloor_num(), getIntent().getBooleanExtra(IS_AD, false), this.mModel.getData().getAnti());
            } else {
                WriteActivity.startAcitivity(this, this.mModel.getData().getForum().getId(), this.mModel.getData().getForum().getName(), this.mPbId, (String) null, 0, getIntent().getBooleanExtra(IS_AD, false), this.mModel.getData().getAnti());
            }
        }
    }

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
        data.setSequence(Boolean.valueOf(this.mModel.getSequence()));
        if (this.mModel.getData().getIsHasFloor()) {
            data.setSubPost(1);
            data.setForumId(this.mModel.getData().getForum().getId());
            data.setForumName(this.mModel.getData().getForum().getName());
            data.setThreadId(this.mModel.getData().getThread().getId());
        }
        return data;
    }

    public static void startAcitivity(Context context, String id, String st_type) {
        startAcitivity(context, id, true, false, st_type, false);
    }

    public static void startAcitivity(Context context, String id, String st_type, boolean isAd) {
        startAcitivity(context, id, true, false, st_type, isAd);
    }

    public static void startAcitivityBackSpecial(Context context, String id) {
        Intent intent = new Intent(context, PbActivity.class);
        if (id != null && id.length() > 0) {
            intent.putExtra(ID, id);
            intent.putExtra(SEQUENCE, true);
            intent.putExtra(HOSTMODE, false);
            intent.putExtra(BACK_SPECIAL, true);
            context.startActivity(intent);
        }
    }

    public static void startAcitivity(Context context, String id, Boolean sequence, Boolean hostMode, String st_type, boolean isAd) {
        Intent intent = new Intent(context, PbActivity.class);
        if (id != null && id.length() > 0) {
            intent.putExtra(ID, id);
            intent.putExtra(SEQUENCE, sequence);
            intent.putExtra(HOSTMODE, hostMode);
            intent.putExtra(IS_AD, isAd);
            if (st_type != null) {
                intent.putExtra("st_type", st_type);
            }
            if ("tb_frslist".equals(st_type)) {
                ((Activity) context).startActivityForResult(intent, RequestResponseCode.REQUEST_DEL_POST);
            } else {
                context.startActivity(intent);
            }
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
        if (dealMassgePush()) {
            setContentView(R.layout.pb_activity);
            this.mUid = TiebaApplication.getCurrentAccount();
            initUI();
            initData(savedInstanceState);
        }
    }

    private boolean dealMassgePush() {
        boolean messgePushEntry = getIntent().getBooleanExtra(MESSAGE_PUSH_ENTRY, false);
        getIntent().putExtra(MESSAGE_PUSH_ENTRY, false);
        if (messgePushEntry) {
            ActivityManager am = (ActivityManager) getSystemService("activity");
            List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(10);
            Iterator<ActivityManager.RunningTaskInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo runningTaskInfo = it.next();
                if (runningTaskInfo.topActivity.getClassName().equals("com.baidu.tieba.pb.PbActivity")) {
                    if (runningTaskInfo.numActivities <= 1) {
                        MainTabActivity.startActivity(this, MainTabActivity.GOTO_MORE, 1, getIntent().getStringExtra(ID));
                        closeActivity();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 82) {
            return true;
        }
        if (keyCode == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void closeActivity() {
        closeAllDialog();
        if (!this.mBackSpecial) {
            finish();
        } else {
            MainTabActivity.startActivity(this, MainTabActivity.GOTO_RECOMMEND);
        }
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
            if (this.mModel != null && this.mModel.getData() != null) {
                this.mModel.setData(null);
            }
            if (this.mDelPostAsyncTask != null) {
                this.mDelPostAsyncTask.cancel();
                this.mDelPostAsyncTask = null;
            }
            if (this.mForbidUserAsyncTask != null) {
                this.mForbidUserAsyncTask.cancel();
                this.mForbidUserAsyncTask = null;
            }
            if (this.mGuidePage != null && this.mGuidePage.getBackground() != null) {
                Bitmap bm = ((BitmapDrawable) this.mGuidePage.getBackground()).getBitmap();
                this.mGuidePage.setBackgroundDrawable(null);
                if (bm != null && !bm.isRecycled()) {
                    bm.recycle();
                }
            }
            closeAllDialog();
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
        if (this.mDialogDirectPager != null && this.mDialogDirectPager.isShowing()) {
            this.mDialogDirectPager.dismiss();
        }
        if (this.mDialogDelPost != null && this.mDialogDelPost.isShowing()) {
            this.mDialogDelPost.dismiss();
        }
        if (this.mDialogForbidUser != null && this.mDialogForbidUser.isShowing()) {
            this.mDialogForbidUser.dismiss();
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
        if (this.mModel != null) {
            if (mark != null) {
                String markId = mark.getPostId();
                this.mModel.setMarkId(markId);
            } else {
                this.mModel.setMarkId(null);
            }
            String id = TiebaApplication.getCurrentAccount();
            if (this.mUid == null && id != null && id.length() > 0) {
                this.mUid = id;
                if (this.mModel.getData() != null && this.mModel.getData().getAnti() != null) {
                    this.mModel.getData().getAnti().setIfpost(1);
                }
            }
        }
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
        this.mGetImageRunnble.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mAdapter.getImageLoader().cancelAllAsyncTask();
    }

    private void initUI() {
        this.mListLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.PbActivity.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long id) {
                PbActivity.this.mLongPos = arg2;
                PbActivity.this.mClickId = id;
                if (id != -1 && id != -2 && id != -3 && PbActivity.this.getLongClickMenu() != null) {
                    PbActivity.this.showListMenu();
                }
                return true;
            }
        };
        this.mTitleText = (TextView) findViewById(R.id.titel_text);
        this.mBottomBar = (LinearLayout) findViewById(R.id.bottom_bar);
        this.mTitleText.setClickable(true);
        this.mTitleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ForumData forumData;
                if (PbActivity.this.mModel != null && PbActivity.this.mModel.getData() != null && (forumData = PbActivity.this.mModel.getData().getForum()) != null && forumData.getName() != null) {
                    String from = PbActivity.this.getIntent().getStringExtra("st_type");
                    if (from != null && from.equals("tb_frslist")) {
                        PbActivity.this.closeActivity();
                    } else {
                        FrsActivity.startAcitivity(PbActivity.this, forumData.getName(), null);
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
                            } else if (arg2 == 2 && PbActivity.this.mModel != null && PbActivity.this.mModel.getData() != null && PbActivity.this.mModel.getData().getUserIdentity() != 0) {
                                if (!PbActivity.this.mModel.getManageMode()) {
                                    PbActivity.this.openManageMode();
                                } else {
                                    PbActivity.this.closeManageMode();
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
                    int bottomBarHeight = PbActivity.this.mBottomBar.getHeight();
                    WindowManager.LayoutParams wmParams = PbActivity.this.mDialogMore.getWindow().getAttributes();
                    wmParams.gravity = 85;
                    wmParams.x = 2;
                    wmParams.y = bottomBarHeight;
                    wmParams.alpha = 1.0f;
                    wmParams.width = UtilHelper.dip2px(PbActivity.this, 120.0f);
                    wmParams.height = -2;
                    PbActivity.this.mDialogMore.getWindow().setAttributes(wmParams);
                }
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PbActivity.this.closeActivity();
            }
        });
        this.mRedirectPage = (Button) findViewById(R.id.skip_page);
        this.mRedirectPage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PbActivity.this.mDialogDirectPager == null) {
                    PbActivity.this.mDialogDirectPager = new Dialog(PbActivity.this, R.style.common_alert_dialog);
                    PbActivity.this.mDialogDirectPager.setCanceledOnTouchOutside(true);
                    PbActivity.this.mDialogDirectPager.setCancelable(true);
                    LayoutInflater mInflater = PbActivity.this.getLayoutInflater();
                    PbActivity.this.mDirectPagerDialogView = mInflater.inflate(R.layout.dialog_direct_pager, (ViewGroup) null);
                    PbActivity.this.mDialogDirectPager.setContentView(PbActivity.this.mDirectPagerDialogView);
                    WindowManager.LayoutParams wmParams = PbActivity.this.mDialogDirectPager.getWindow().getAttributes();
                    wmParams.gravity = 49;
                    wmParams.y = UtilHelper.dip2px(PbActivity.this, 54.0f);
                    wmParams.width = (int) (UtilHelper.getEquipmentWidth(PbActivity.this) * 0.9d);
                    PbActivity.this.mDialogDirectPager.getWindow().setAttributes(wmParams);
                    PbActivity.this.mInputRedirectPage = (EditText) PbActivity.this.mDirectPagerDialogView.findViewById(R.id.input_page_number);
                    PbActivity.this.mInputRedirectPage.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.pb.PbActivity.7.1
                        @Override // android.view.View.OnFocusChangeListener
                        public void onFocusChange(View view, boolean hasFocus) {
                            if (!hasFocus) {
                                UtilHelper.hideSoftKeyPad(PbActivity.this, view);
                            }
                        }
                    });
                    Button btnOK = (Button) PbActivity.this.mDirectPagerDialogView.findViewById(R.id.dialog_button_ok);
                    Button btnCancel = (Button) PbActivity.this.mDirectPagerDialogView.findViewById(R.id.dialog_button_cancel);
                    btnOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.7.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v2) {
                            PbActivity.this.startPbAsyncTask(5);
                            PbActivity.this.mDialogDirectPager.dismiss();
                        }
                    });
                    btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.7.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v2) {
                            PbActivity.this.mDialogDirectPager.dismiss();
                        }
                    });
                }
                if (PbActivity.this.mModel.getData() != null) {
                    TextView txtCurrentPn = (TextView) PbActivity.this.mDirectPagerDialogView.findViewById(R.id.current_page_number);
                    int currentPn = PbActivity.this.mModel.getData().getPage().getCurrent_page();
                    int totalPageCount = PbActivity.this.mModel.getData().getPage().getTotal_page();
                    if (currentPn <= 0) {
                        currentPn = 1;
                    }
                    if (totalPageCount <= 0) {
                        totalPageCount = 1;
                    }
                    txtCurrentPn.setText(MessageFormat.format(PbActivity.this.getApplicationContext().getResources().getString(R.string.current_page), Integer.valueOf(currentPn), Integer.valueOf(totalPageCount)));
                    PbActivity.this.mDialogDirectPager.show();
                    PbActivity.this.mInputRedirectPage.setText("");
                    PbActivity.this.mInputRedirectPage.requestFocus();
                    PbActivity.this.ShowSoftKeyPadDelay(PbActivity.this.mInputRedirectPage, 150);
                }
            }
        });
        this.mReply = (Button) findViewById(R.id.reply);
        this.mReply.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PbActivity.this.replyBlog(null);
            }
        });
        this.mBtnRecommend = (Button) findViewById(R.id.recommend);
        this.mBtnRecommend.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MainTabActivity.startActivity(PbActivity.this, MainTabActivity.GOTO_RECOMMEND);
                PbActivity.this.closeActivity();
            }
        });
        this.mBtnRefresh = (Button) findViewById(R.id.refresh);
        this.mBtnRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PbActivity.this.startPbAsyncTask(3);
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
        this.mPbList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.PbActivity.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long id) {
                boolean isMarked;
                PbActivity.this.mClickId = -1L;
                if (id != -3) {
                    if (id == -1) {
                        if (PbActivity.this.mAdapter.isProcessPre()) {
                            return;
                        }
                        PbActivity.this.getPreDate();
                    } else if (id != -2) {
                        if (PbActivity.this.mContextMenu != null) {
                            PbActivity.this.mClickId = id;
                            if (PbActivity.this.mModel.getData() != null) {
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
                                    intent.putExtra("anti", PbActivity.this.mModel.getData().getAnti());
                                    intent.putExtra("manage_mode", PbActivity.this.mModel.getManageMode());
                                    intent.putExtra("user_identity", PbActivity.this.mModel.getData().getUserIdentity());
                                    PbActivity.this.startActivityForResult(intent, RequestResponseCode.REQUEST_DEL_POST);
                                    return;
                                }
                                if (data != null && PbActivity.this.mModel.getMarkId() != null && PbActivity.this.mModel.getMarkId().equals(data.getId())) {
                                    PbActivity.this.mContextMenuAdapter.setItem(1, PbActivity.this.getString(R.string.remove_mark));
                                } else {
                                    PbActivity.this.mContextMenuAdapter.setItem(1, PbActivity.this.getString(R.string.add_mark));
                                }
                                PbActivity.this.mContextMenuAdapter.notifyDataSetInvalidated();
                                PbActivity.this.mContextMenu.show();
                            }
                        }
                    } else if (PbActivity.this.mAdapter.isProcessMore()) {
                    } else {
                        PbActivity.this.getNextDate();
                    }
                }
            }
        });
        this.mPbList.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.PbActivity.12
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                PbActivity.this.mHandler.removeCallbacks(PbActivity.this.mGetImageRunnble);
                PbActivity.this.mHandler.postDelayed(PbActivity.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
        this.mPbList.setOnItemLongClickListener(this.mListLongClickListener);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.headTextView = (TextView) findViewById(R.id.tofrs_textview);
        this.headTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (PbActivity.this.frsString != null) {
                    FrsActivity.startAcitivity(PbActivity.this, PbActivity.this.frsString, null);
                }
            }
        });
        this.mGuidePage = (ImageView) findViewById(R.id.guide_page_pb_img_mode);
        this.mGuidePage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (PbActivity.this.mGuidePage != null && PbActivity.this.mGuidePage.getBackground() != null) {
                    Bitmap bm = ((BitmapDrawable) PbActivity.this.mGuidePage.getBackground()).getBitmap();
                    PbActivity.this.mGuidePage.setBackgroundDrawable(null);
                    if (bm != null && !bm.isRecycled()) {
                        bm.recycle();
                    }
                    PbActivity.this.mGuidePage.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog getLongClickMenu() {
        if (getListMenu() != null && getListMenu().isShowing()) {
            return getListMenu();
        }
        DialogInterface.OnClickListener menuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                PostData data = (PostData) PbActivity.this.mAdapter.getItem(PbActivity.this.mLongPos);
                if (data != null) {
                    if (which == 0) {
                        data.setClipString(PbActivity.this);
                    } else if (which == 1) {
                        if (PbActivity.this.mModel != null) {
                            if (PbActivity.this.mModel.getMarkId() == null || !PbActivity.this.mModel.getMarkId().equals(data.getId())) {
                                PbActivity.this.mMarkAdd = true;
                            } else {
                                PbActivity.this.mMarkAdd = false;
                            }
                        }
                        PbActivity.this.mMarkData = PbActivity.this.getMarkData();
                        PbActivity.this.dealMark(PbActivity.this.mMarkData, PbActivity.this.mMarkAdd);
                    }
                }
            }
        };
        PostData data = (PostData) this.mAdapter.getItem(this.mLongPos);
        String mark_text = null;
        if (data != null && this.mModel != null && data.getId() != null) {
            mark_text = data.getId().equals(this.mModel.getMarkId()) ? getString(R.string.delete_mark) : getString(R.string.add_mark);
        }
        return mark_text != null ? newListMenu(new String[]{getString(R.string.copy), mark_text}, menuListener) : newListMenu(new String[]{getString(R.string.copy)}, menuListener);
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
        this.mBackSpecial = getIntent().getBooleanExtra(BACK_SPECIAL, false);
        this.pvSign = getIntent().getBooleanExtra("is_message_pv", false);
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
            this.mModel.setManageMode(app.getIsManageMode());
        }
        if (hostMode.booleanValue()) {
            sequence = true;
        }
        this.mModel.setSequence(sequence.booleanValue());
        this.mModel.setHostMode(hostMode.booleanValue());
        this.mModel.setMarkId(markId);
        if (this.mModel.getMarkMode()) {
            setSkipEnabled(false);
            startPbAsyncTask(4);
            return;
        }
        startPbAsyncTask(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipEnabled(boolean enabled) {
        if (enabled) {
            this.mRedirectPage.setEnabled(true);
        } else {
            this.mRedirectPage.setEnabled(false);
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
            BasicNameValuePair num = new BasicNameValuePair(URL_NUM, String.valueOf(30));
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
                if (type == 5) {
                    int bigPageNumber = Integer.parseInt(this.mInputRedirectPage.getText().toString(), 10);
                    int maxPage = this.mModel.getData().getPage().getTotal_page();
                    if (bigPageNumber < 1) {
                        bigPageNumber = 1;
                    }
                    if (bigPageNumber > maxPage) {
                        bigPageNumber = maxPage;
                    }
                    BasicNameValuePair pn = new BasicNameValuePair("pn", new StringBuilder(String.valueOf(bigPageNumber)).toString());
                    param.add(pn);
                    BasicNameValuePair direct = new BasicNameValuePair(URL_DIRECTION, "0");
                    param.add(direct);
                    BasicNameValuePair st_type = new BasicNameValuePair("st_type", "tb_bookmarklist");
                    param.add(st_type);
                    this.mProgress.setVisibility(0);
                } else if (type == 2) {
                    BasicNameValuePair direct2 = new BasicNameValuePair(URL_DIRECTION, NetWorkCore.NET_TYPE_NET);
                    param.add(direct2);
                    if (!this.mModel.getMarkMode()) {
                        if (this.mModel.getSequence()) {
                            BasicNameValuePair pn2 = new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.mModel.getSmallPageNumber() + (-1) < 0 ? 1 : this.mModel.getSmallPageNumber() - 1)).toString());
                            param.add(pn2);
                        } else if (this.mModel.getBigPageNumber() < this.mModel.getData().getPage().getTotal_page()) {
                            BasicNameValuePair pn3 = new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.mModel.getBigPageNumber() + 1)).toString());
                            param.add(pn3);
                            this.mModel.setIsLastPage(false);
                        } else {
                            this.mModel.setIsLastPage(true);
                        }
                    }
                    ArrayList<PostData> list = this.mModel.getData().getPost_list();
                    if (list != null && list.size() > 0) {
                        int size = list.size();
                        String id = list.get(0).getId();
                        if (id != null && id.length() > 0) {
                            BasicNameValuePair pid = new BasicNameValuePair(URL_PID, id);
                            param.add(pid);
                        }
                        if (size > Config.PB_LIST_ITEM_MAX_NUM - 30) {
                            for (int i = 1; i <= size - (Config.PB_LIST_ITEM_MAX_NUM - 30) && size - i >= 0; i++) {
                                list.remove(size - i);
                            }
                            this.mAdapter.setHaveFooter(2);
                            this.mAdapter.notifyDataSetChanged();
                        }
                    }
                } else if (type == 1) {
                    BasicNameValuePair direct3 = new BasicNameValuePair(URL_DIRECTION, String.valueOf(0));
                    param.add(direct3);
                    ArrayList<PostData> list2 = this.mModel.getData().getPost_list();
                    if (list2 != null && list2.size() > 0) {
                        int size2 = list2.size();
                        String id2 = list2.get(size2 - 1).getId();
                        if (id2 != null && id2.length() > 0) {
                            BasicNameValuePair pid2 = new BasicNameValuePair(URL_PID, id2);
                            param.add(pid2);
                        }
                        if (size2 > Config.PB_LIST_ITEM_MAX_NUM - 30) {
                            for (int i2 = Config.PB_LIST_ITEM_MAX_NUM - 30; i2 < size2; i2++) {
                                list2.remove(0);
                            }
                            this.mAdapter.setHaveHeader(2);
                            this.mAdapter.notifyDataSetChanged();
                        }
                    } else if (!this.mModel.getSequence()) {
                        param.add(new BasicNameValuePair(URL_LAST, String.valueOf(1)));
                    }
                    if (!this.mModel.getMarkMode()) {
                        if (this.mModel.getSequence()) {
                            if (this.mModel.getBigPageNumber() < this.mModel.getData().getPage().getTotal_page()) {
                                BasicNameValuePair pn4 = new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.mModel.getBigPageNumber() + 1)).toString());
                                param.add(pn4);
                                this.mModel.setIsLastPage(false);
                            } else {
                                this.mModel.setIsLastPage(true);
                            }
                        } else {
                            BasicNameValuePair pn5 = new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.mModel.getSmallPageNumber() - 1)).toString());
                            param.add(pn5);
                        }
                    }
                } else if (type == 4) {
                    BasicNameValuePair pid3 = new BasicNameValuePair(URL_PID, this.mModel.getMarkId());
                    param.add(pid3);
                    BasicNameValuePair direct4 = new BasicNameValuePair(URL_DIRECTION, "0");
                    param.add(direct4);
                    BasicNameValuePair st_type2 = new BasicNameValuePair("st_type", "tb_bookmarklist");
                    param.add(st_type2);
                    this.mAdapter.setHaveFooter(0);
                    this.mAdapter.setHaveHeader(0);
                    this.mProgress.setVisibility(0);
                } else {
                    BasicNameValuePair direct5 = new BasicNameValuePair(URL_DIRECTION, "0");
                    param.add(direct5);
                    if (this.mModel.getSequence()) {
                        BasicNameValuePair pn6 = new BasicNameValuePair("pn", NetWorkCore.NET_TYPE_NET);
                        param.add(pn6);
                    } else if ((getIntent().getStringExtra("st_type") == null || !getIntent().getStringExtra("st_type").equals("tb_frslist") || getIntent().getBooleanExtra(SEQUENCE, true)) && this.mModel != null && this.mModel.getData() != null && this.mModel.getData().getPage() != null) {
                        BasicNameValuePair pn7 = new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.mModel.getData().getPage().getTotal_page())).toString());
                        param.add(pn7);
                    }
                    if (this.mModel != null) {
                        this.mModel.setMarkMode(false);
                        if (!this.mModel.getSequence()) {
                            BasicNameValuePair last = new BasicNameValuePair(URL_LAST, String.valueOf(1));
                            param.add(last);
                        }
                        if (this.mModel.getData() != null) {
                            this.mModel.getData().getPost_list().clear();
                            this.mAdapter.notifyDataSetChanged();
                        }
                    }
                    this.mAdapter.setHaveFooter(0);
                    this.mAdapter.setHaveHeader(0);
                    if (this.mSource != null) {
                        BasicNameValuePair st_type3 = new BasicNameValuePair("st_type", this.mSource);
                        param.add(st_type3);
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
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_TIP);
        } else if (!this.mModel.getIsprogressTip() && this.mModel.getData() != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void openManageMode() {
        this.mModel.setManageMode(true);
        TiebaApplication.app.setIsManageMode(true);
        refreshActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeManageMode() {
        this.mModel.setManageMode(false);
        TiebaApplication.app.setIsManageMode(false);
        refreshActivity();
    }

    public void openDelPostDialog(final int delType, final String postId, final int userIdentity) {
        if (this.mDialogDelPost == null) {
            this.mDialogDelPost = new Dialog(this, R.style.common_alert_dialog);
            this.mDialogDelPost.setCanceledOnTouchOutside(true);
            this.mDialogDelPost.setCancelable(true);
            LayoutInflater inflater = getLayoutInflater();
            this.mDelPostView = inflater.inflate(R.layout.del_post, (ViewGroup) null);
            this.mDialogDelPost.setContentView(this.mDelPostView);
            WindowManager.LayoutParams wmParams = this.mDialogDelPost.getWindow().getAttributes();
            wmParams.width = (int) (UtilHelper.getEquipmentWidth(this) * 0.9d);
            this.mDialogDelPost.getWindow().setAttributes(wmParams);
            this.mBtnDoDelPost = (Button) this.mDelPostView.findViewById(R.id.dialog_button_ok);
            this.mBtnCancelDelPost = (Button) this.mDelPostView.findViewById(R.id.dialog_button_cancel);
            this.mBtnCancelDelPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.16
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    PbActivity.this.mDialogDelPost.dismiss();
                }
            });
            this.mTxtDelPostTip = (TextView) this.mDelPostView.findViewById(R.id.confirm_text);
        }
        if (this.mModel != null && this.mModel.getData() != null) {
            this.mBtnDoDelPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    PbActivity.this.startDelPostAsyncTask(delType, postId, userIdentity);
                    PbActivity.this.mDialogDelPost.dismiss();
                }
            });
            if (delType == 1) {
                this.mTxtDelPostTip.setText(R.string.del_thread_confirm);
            } else {
                this.mTxtDelPostTip.setText(R.string.del_post_confirm);
            }
            this.mDialogDelPost.show();
        }
    }

    public void openForbidUserDialog(final String userName, int userIdentity) {
        if (this.mDialogForbidUser == null) {
            this.mDialogForbidUser = new Dialog(this, R.style.common_alert_dialog);
            this.mDialogForbidUser.setCanceledOnTouchOutside(true);
            this.mDialogForbidUser.setCancelable(true);
            LayoutInflater inflater = getLayoutInflater();
            this.mForbidUserView = inflater.inflate(R.layout.forbid_user, (ViewGroup) null);
            this.mDialogForbidUser.setContentView(this.mForbidUserView);
            WindowManager.LayoutParams wmParams = this.mDialogForbidUser.getWindow().getAttributes();
            wmParams.width = (int) (UtilHelper.getEquipmentWidth(this) * 0.9d);
            this.mDialogForbidUser.getWindow().setAttributes(wmParams);
            this.mRadioGroup = (RadioGroup) this.mForbidUserView.findViewById(R.id.radio_group);
            this.mBtn1Day = (RadioButton) this.mForbidUserView.findViewById(R.id.radio_button_1day);
            this.mBtn3Day = (RadioButton) this.mForbidUserView.findViewById(R.id.radio_button_3day);
            this.mBtn10Day = (RadioButton) this.mForbidUserView.findViewById(R.id.radio_button_10day);
            CompoundButton.OnCheckedChangeListener radioButtonCheckedListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.PbActivity.18
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        switch (buttonView.getId()) {
                            case R.id.radio_button_1day /* 2131230854 */:
                                PbActivity.this.mForbidTime = 1;
                                return;
                            case R.id.radio_button_3day /* 2131230855 */:
                                PbActivity.this.mForbidTime = 3;
                                return;
                            case R.id.radio_button_10day /* 2131230856 */:
                                PbActivity.this.mForbidTime = 10;
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            this.mBtn1Day.setOnCheckedChangeListener(radioButtonCheckedListener);
            this.mBtn3Day.setOnCheckedChangeListener(radioButtonCheckedListener);
            this.mBtn10Day.setOnCheckedChangeListener(radioButtonCheckedListener);
            this.mBtnDoForbidUser = (Button) this.mForbidUserView.findViewById(R.id.dialog_button_ok);
            this.mBtnCancelForbidUser = (Button) this.mForbidUserView.findViewById(R.id.dialog_button_cancel);
            this.mBtnCancelForbidUser.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    PbActivity.this.mDialogForbidUser.dismiss();
                }
            });
            this.mTxtUserName = (TextView) this.mForbidUserView.findViewById(R.id.user_name);
        }
        if (this.mModel != null && this.mModel.getData() != null) {
            this.mTxtUserName.setText(userName);
            this.mRadioGroup.check(R.id.radio_button_1day);
            if (userIdentity == 2) {
                this.mBtn3Day.setVisibility(8);
                this.mBtn10Day.setVisibility(8);
            }
            this.mBtnDoForbidUser.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.PbActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    PbActivity.this.startForbidUserAsyncTask(userName);
                    PbActivity.this.mDialogForbidUser.dismiss();
                }
            });
            this.mDialogForbidUser.show();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 4:
                replyBlog(null);
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

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_LOGIN_PB_REPLY /* 1100004 */:
                    replyBlog(null);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_REPLY_FLOOR /* 1100005 */:
                    replyBlog(this.mClickPost);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_HOST /* 1100006 */:
                    requestHost();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_REVRESE /* 1100007 */:
                    requestReverse();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_TIP /* 1100008 */:
                    requestTip();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 1100009 */:
                    dealMark(this.mMarkData, this.mMarkAdd);
                    return;
                case RequestResponseCode.REQUEST_WRITE_REPLY_FLOOR /* 1300001 */:
                case RequestResponseCode.REQUEST_WRITE_REPLY /* 1300002 */:
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
                        return;
                    } catch (Exception ex) {
                        TiebaLog.e(getClass().getName(), "onActivityResult", ex.getMessage());
                        return;
                    }
                case RequestResponseCode.REQUEST_DEL_POST /* 1300004 */:
                    String postId = data.getStringExtra("del_post_id");
                    if (postId != null && this.mModel != null && this.mModel.getData() != null) {
                        ArrayList<PostData> list = this.mModel.getData().getPost_list();
                        int size = list.size();
                        int i = 0;
                        while (true) {
                            if (i < size) {
                                if (!postId.equals(list.get(i).getId())) {
                                    i++;
                                } else {
                                    list.remove(i);
                                }
                            }
                        }
                        refreshActivity();
                        return;
                    }
                    return;
                default:
                    return;
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
                if (PbActivity.mPbLoadDataSize != 0) {
                    this.mNetwork.addPostData("data_size", String.valueOf(PbActivity.mPbLoadDataSize));
                }
                if (PbActivity.mNetError != 0) {
                    this.mNetwork.addPostData("net_error", String.valueOf(PbActivity.mNetError));
                }
                if (PbActivity.this.pvSign) {
                    PbActivity.this.pvSign = false;
                    this.mNetwork.addPostData("msg_click", NetWorkCore.NET_TYPE_NET);
                }
                String data = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess()) {
                    TiebaLog.i(getClass().getName(), "doInBackground", "data=" + data);
                    PbData pbData2 = new PbData();
                    try {
                        pbData2.parserJson(data);
                        int size = pbData2.getPost_list().size();
                        for (int i = 0; i < size; i++) {
                            pbData2.getPost_list().get(i).uniteContentExcepFaceVideo(PbActivity.this);
                            pbData2.getPost_list().get(i).setContent(null);
                        }
                        PbActivity.this.frsString = pbData2.getForum().getName();
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
                    PbActivity.mPbLoadDataSize = 0L;
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
                    PbActivity.this.headTextView.setText(PbActivity.this.frsString);
                    PbData d_data = PbActivity.this.mModel.getData();
                    PbActivity.this.mSource = null;
                    PbActivity.this.mModel.setHaveMore(data.getPage().getHave_more());
                    PbActivity.this.mModel.setHavePre(data.getPage().getHave_pre());
                    if (this.mType == 3) {
                        PbActivity.this.mModel.setData(data);
                        if (PbActivity.this.mModel.getSequence()) {
                            PbActivity.this.mModel.setBigPageNumber(PbActivity.this.mModel.getData().getPage().getCurrent_page());
                            PbActivity.this.mModel.setSmallPageNumber(PbActivity.this.mModel.getData().getPage().getCurrent_page());
                        } else {
                            PbActivity.this.mModel.setBigPageNumber(PbActivity.this.mModel.getData().getPage().getTotal_page());
                            PbActivity.this.mModel.setSmallPageNumber(PbActivity.this.mModel.getData().getPage().getTotal_page());
                        }
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
                        PbActivity.this.setSkipEnabled(true);
                        if (PbActivity.this.mDialogMore != null && PbActivity.this.mDialogMore.isShowing() && PbActivity.this.mDialogAdapter != null) {
                            PbActivity.this.mDialogAdapter.notifyDataSetInvalidated();
                        }
                    } else if (d_data != null && this.mType == 2) {
                        if (d_data != null) {
                            int pos = PbActivity.this.mPbList.getFirstVisiblePosition();
                            ArrayList<PostData> d_list = d_data.getPost_list();
                            ArrayList<PostData> s_list = data.getPost_list();
                            int pos2 = pos + s_list.size();
                            d_list.addAll(0, s_list);
                            d_data.setPage(data.getPage());
                            d_data.setForum(data.getForum());
                            d_data.setThread(data.getThread());
                            d_data.setAnti(data.getAnti());
                            if (!PbActivity.this.mModel.getSequence()) {
                                if (PbActivity.this.mModel.getIsLastPage()) {
                                    if (d_data.getPage().getHave_pre() == 1) {
                                        PbActivity.this.mModel.setBigPageNumber(PbActivity.this.mModel.getBigPageNumber() + 1);
                                    } else {
                                        PbActivity.this.mModel.setBigPageNumber(data.getPage().getTotal_page());
                                    }
                                } else {
                                    PbActivity.this.mModel.setBigPageNumber(data.getPage().getCurrent_page());
                                }
                                if (PbActivity.this.mModel.getBigPageNumber() - PbActivity.this.mModel.getSmallPageNumber() >= PbActivity.this.mModel.getMaxShowPageCount()) {
                                    PbActivity.this.mModel.setSmallPageNumber((PbActivity.this.mModel.getBigPageNumber() - PbActivity.this.mModel.getMaxShowPageCount()) + 1);
                                }
                            } else {
                                PbActivity.this.mModel.setSmallPageNumber(data.getPage().getCurrent_page());
                                if (PbActivity.this.mModel.getBigPageNumber() - PbActivity.this.mModel.getSmallPageNumber() >= PbActivity.this.mModel.getMaxShowPageCount()) {
                                    PbActivity.this.mModel.setBigPageNumber((PbActivity.this.mModel.getSmallPageNumber() + PbActivity.this.mModel.getMaxShowPageCount()) - 1);
                                }
                            }
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
                        }
                    } else if (d_data != null && this.mType == 1) {
                        ArrayList<PostData> d_list2 = d_data.getPost_list();
                        d_list2.addAll(data.getPost_list());
                        d_data.setPage(data.getPage());
                        d_data.setForum(data.getForum());
                        d_data.setThread(data.getThread());
                        d_data.setAnti(data.getAnti());
                        if (PbActivity.this.mModel.getSequence()) {
                            if (PbActivity.this.mModel.getIsLastPage()) {
                                if (d_data.getPage().getHave_more() == 1) {
                                    PbActivity.this.mModel.setBigPageNumber(PbActivity.this.mModel.getBigPageNumber() + 1);
                                } else {
                                    PbActivity.this.mModel.setBigPageNumber(data.getPage().getTotal_page());
                                }
                            } else {
                                PbActivity.this.mModel.setBigPageNumber(data.getPage().getCurrent_page());
                            }
                            if (PbActivity.this.mModel.getBigPageNumber() - PbActivity.this.mModel.getSmallPageNumber() >= PbActivity.this.mModel.getMaxShowPageCount()) {
                                PbActivity.this.mModel.setSmallPageNumber((PbActivity.this.mModel.getBigPageNumber() - PbActivity.this.mModel.getMaxShowPageCount()) + 1);
                            }
                        } else {
                            PbActivity.this.mModel.setSmallPageNumber(data.getPage().getCurrent_page());
                            if (PbActivity.this.mModel.getBigPageNumber() - PbActivity.this.mModel.getSmallPageNumber() >= PbActivity.this.mModel.getMaxShowPageCount()) {
                                PbActivity.this.mModel.setBigPageNumber((PbActivity.this.mModel.getSmallPageNumber() + PbActivity.this.mModel.getMaxShowPageCount()) - 1);
                            }
                        }
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
                        if (!PbActivity.this.mModel.getSequence()) {
                            PbActivity.this.scrollButtom = true;
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
                        } else {
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
                        }
                        if (PbActivity.this.mDialogMore != null && PbActivity.this.mDialogMore.isShowing() && PbActivity.this.mDialogAdapter != null) {
                            PbActivity.this.mDialogAdapter.notifyDataSetInvalidated();
                        }
                    } else if (this.mType == 5) {
                        PbActivity.this.mModel.setData(data);
                        PbActivity.this.mModel.setBigPageNumber(PbActivity.this.mModel.getData().getPage().getCurrent_page());
                        PbActivity.this.mModel.setSmallPageNumber(PbActivity.this.mModel.getData().getPage().getCurrent_page());
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
                        if (data.getPost_list().size() > 0) {
                            PbActivity.this.mPbList.setSelection(0);
                        }
                    }
                    long end_time = System.nanoTime();
                    PbActivity.mPbLoadTime = (end_time - this.mStartTime) / 1000000;
                    if (this.mNetwork != null) {
                        PbActivity.mPbLoadDataSize = this.mNetwork.getNetDataSize();
                    }
                } else if (this.mNetwork != null) {
                    if (this.mType == 3 || this.mType == 4) {
                        if (this.mNetwork.isNetSuccess()) {
                            PbActivity.this.showToast(this.mNetwork.getErrorString());
                            if (this.mNetwork.getErrorCode() == 4 || this.mNetwork.getErrorCode() == 28) {
                                PbActivity.this.closeActivity();
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
                PbActivity.this.refreshActivity();
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "onPostExecute", ex.getMessage());
            }
            PbActivity.this.mTask = null;
            hideProgress();
            if (this.mType == 5) {
                PbActivity.this.mAdapter.notifyDataSetInvalidated();
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void startDelPostAsyncTask(int delType, String postId, int userIdentity) {
        String addr;
        String accountId = TiebaApplication.getCurrentAccount();
        if (accountId == null || accountId.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST);
        } else if (!this.mModel.getIsProcessDelPost()) {
            this.mModel.setIsProcessDelPost(true);
            if (this.mDelPostAsyncTask != null) {
                this.mDelPostAsyncTask.cancel();
                this.mDelPostAsyncTask = null;
            }
            ForumData forum = this.mModel.getData().getForum();
            this.mDelPostAsyncTask = new DelPostAsyncTask(forum.getId(), forum.getName(), this.mModel.getData().getThread().getId(), postId, delType, userIdentity);
            if (delType == 1) {
                addr = String.valueOf(Config.SERVER_ADDRESS) + Config.DEL_THREAD_ADDRESS;
            } else {
                addr = String.valueOf(Config.SERVER_ADDRESS) + Config.DEL_POST_ADDRESS;
            }
            this.mDelPostAsyncTask.execute(addr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DelPostAsyncTask extends AsyncTask<String, Integer, String> {
        private int mDelType;
        private String mForumId;
        private String mForumName;
        private NetWork mNetwork = null;
        private String mPostId;
        private String mThreadId;
        private int mUserIdentity;

        public DelPostAsyncTask(String forumId, String forumName, String threadId, String postId, int delType, int userIdentity) {
            this.mForumId = forumId;
            this.mForumName = forumName;
            this.mThreadId = threadId;
            this.mPostId = postId;
            this.mDelType = delType;
            this.mUserIdentity = userIdentity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            String url = params[0];
            this.mNetwork = new NetWork(url);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            if (this.mDelType == 0) {
                this.mNetwork.addPostData(PbActivity.URL_PID, this.mPostId);
                this.mNetwork.addPostData("isfloor", "0");
                this.mNetwork.addPostData("src", NetWorkCore.NET_TYPE_NET);
            }
            if (this.mUserIdentity == 0) {
                this.mNetwork.addPostData("is_vipdel", NetWorkCore.NET_TYPE_NET);
            } else {
                this.mNetwork.addPostData("is_vipdel", "0");
            }
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
            PbActivity.this.mDelPostAsyncTask = null;
            PbActivity.this.mModel.setIsProcessDelPost(false);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((DelPostAsyncTask) result);
            PbActivity.this.mDelPostAsyncTask = null;
            PbActivity.this.mModel.setIsProcessDelPost(false);
            if (this.mNetwork != null) {
                if (result == null) {
                    PbActivity.this.showToast(PbActivity.this.getString(R.string.success));
                    if (this.mDelType == 0) {
                        if (PbActivity.this.mModel != null && PbActivity.this.mModel.getData() != null) {
                            ArrayList<PostData> list = PbActivity.this.mModel.getData().getPost_list();
                            int size = list.size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    break;
                                } else if (!this.mPostId.equals(list.get(i).getId())) {
                                    i++;
                                } else {
                                    list.remove(i);
                                    break;
                                }
                            }
                            PbActivity.this.refreshActivity();
                            return;
                        }
                        return;
                    }
                    String from = PbActivity.this.getIntent().getStringExtra("st_type");
                    if (from != null && from.equals("tb_frslist")) {
                        PbActivity.this.setResult(-1);
                    }
                    PbActivity.this.closeActivity();
                    return;
                }
                PbActivity.this.showToast(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startForbidUserAsyncTask(String userName) {
        String accountId = TiebaApplication.getCurrentAccount();
        if (accountId == null || accountId.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_FORBID_USER);
        } else if (!this.mModel.getIsProcessForbidUser()) {
            this.mModel.setIsProcessForbidUser(true);
            if (this.mForbidUserAsyncTask != null) {
                this.mForbidUserAsyncTask.cancel();
                this.mForbidUserAsyncTask = null;
            }
            ForumData forum = this.mModel.getData().getForum();
            this.mForbidUserAsyncTask = new ForbidUserAsyncTask(forum.getId(), forum.getName(), this.mModel.getData().getThread().getId(), userName, String.valueOf(this.mForbidTime));
            this.mForbidUserAsyncTask.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ForbidUserAsyncTask extends AsyncTask<String, Integer, String> {
        private String mForbidTime;
        private String mForumId;
        private String mForumName;
        private NetWork mNetwork = null;
        private String mThreadId;
        private String mUserName;

        public ForbidUserAsyncTask(String forumId, String forumName, String threadId, String userName, String forbidTime) {
            this.mForumId = forumId;
            this.mForumName = forumName;
            this.mThreadId = threadId;
            this.mUserName = userName;
            this.mForbidTime = forbidTime;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... params) {
            String url = params[0];
            this.mNetwork = new NetWork(url);
            this.mNetwork.addPostData("day", this.mForbidTime);
            this.mNetwork.addPostData("un", this.mUserName);
            this.mNetwork.addPostData("fid", this.mForumId);
            this.mNetwork.addPostData("word", this.mForumName);
            this.mNetwork.addPostData("z", this.mThreadId);
            this.mNetwork.addPostData("ntn", "banid");
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
            PbActivity.this.mForbidUserAsyncTask = null;
            PbActivity.this.mModel.setIsProcessForbidUser(false);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ForbidUserAsyncTask) result);
            PbActivity.this.mForbidUserAsyncTask = null;
            PbActivity.this.mModel.setIsProcessForbidUser(false);
            if (this.mNetwork != null) {
                if (result == null) {
                    PbActivity.this.showToast(PbActivity.this.getString(R.string.success));
                } else {
                    PbActivity.this.showToast(result);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshActivity() {
        try {
            if (this.mModel != null && this.mModel.getData() != null) {
                ArrayList<PostData> list = this.mModel.getData().getPost_list();
                if (list != null) {
                    this.mAdapter.setData(this.mModel);
                    this.mAdapter.notifyDataSetChanged();
                }
                ForumData forumData = this.mModel.getData().getForum();
                if (forumData != null && forumData.getName() != null) {
                    this.mTitleText.setText(String.valueOf(forumData.getName()) + getString(R.string.forum));
                }
            }
            if (this.mModel != null && this.mModel.getData() != null && this.mModel.getData().getForum().getId() != null && this.mMenu != null && this.mMenu.hasVisibleItems()) {
                if (this.mMenu.findItem(4) != null) {
                    this.mMenu.findItem(4).setEnabled(true);
                }
                if (this.mMenu.findItem(5) != null) {
                    if (!this.mModel.isCanTip()) {
                        this.mMenu.findItem(5).setEnabled(false);
                    } else {
                        this.mMenu.findItem(5).setEnabled(true);
                    }
                }
                if (!isAnonymityUser(this.mModel)) {
                    if (this.mMenu.findItem(6) != null) {
                        this.mMenu.findItem(6).setEnabled(true);
                    }
                    if (this.mMenu.findItem(8) != null) {
                        this.mMenu.findItem(8).setEnabled(true);
                    }
                }
                if (this.mMenu.findItem(7) != null) {
                    this.mMenu.findItem(7).setEnabled(true);
                }
                if (this.mMenu.findItem(9) != null) {
                    this.mMenu.findItem(9).setEnabled(true);
                }
                MenuItem hostMenu = this.mMenu.findItem(6);
                if (hostMenu != null) {
                    hostMenu.setEnabled(isAnonymityUser(this.mModel) ? false : true);
                }
            }
            if (this.scrollButtom) {
                this.mPbList.setSelection(this.mPbList.getCount());
            }
            this.scrollButtom = false;
            checkShowGuidePage(3, this.mGuidePage, R.drawable.guide_page_pb_img_mode);
        } catch (Exception ex) {
            TiebaLog.e("PbActivity", "refreshActivity", "error = " + ex.getMessage());
        }
    }
}
