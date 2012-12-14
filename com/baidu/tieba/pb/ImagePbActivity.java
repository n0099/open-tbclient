package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ImageData;
import com.baidu.tieba.data.ImagePbData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.VcodeInfoData;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.MediaScannerClient;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbImageView;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.baidu.tieba.view.KeyboardLayout;
import com.baidu.tieba.view.MyBitmapDrawable;
import com.baidu.tieba.write.FaceAdapter;
import com.baidu.tieba.write.VcodeActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.WriteUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends BaseActivity implements BaseViewPager.OnScrollOutListener {
    private static final String CURRENTPAGE = "current_page";
    private static final String FORUM = "forum";
    private static final String ID = "id";
    private static final int IMAGE_PER_PAGE = 9;
    public static final int INTENT_MORE = 2;
    public static final int INTENT_NEXT = 1;
    public static final int INTENT_PRE = 0;
    private static final long INV_TIME = 300000000;
    private static final int TEXT_LIMIT = 140;
    private static final String TITLE = "title";
    private GridView faceView;
    private Button mButtonFace;
    private Button mButtonReply;
    private EditText mEditReply;
    private ImagePbAsyncTask mImagePbAsyncTask = null;
    private Button mBackButton = null;
    private Button mCameraButton = null;
    private Button mComment = null;
    private Button mSave = null;
    private TextView mTitle = null;
    private TextView mPage = null;
    private AlertDialog mDialogTitle = null;
    private View mPbTileDialogView = null;
    private ProgressBar mProgress = null;
    private LinearLayout mPostLayout = null;
    private LinearLayout mBottomLayout = null;
    private KeyboardLayout mKeyboardLayout = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private ReplyAsyncTask mReplyAsyncTask = null;
    private AntiData mAnti = null;
    private int mFloor = 0;
    private SaveImageAsyncTask mSaveImageTask = null;
    private BaseViewPager mViewPager = null;
    private ImagePbPagerAdapter mViewPagerAdapter = null;
    private PageChangeReceiver mPagecChangeReceiver = null;
    private boolean isActive = false;
    private String mForum = null;
    private String mTid = null;
    private String mPbTitle = null;
    private int currentPage = 0;
    private ImagePbData mData = null;
    private ImagePbData mPreData = null;
    private AlertDialog mSelectImageDialog = null;
    private int mIndex = 0;
    private MyOnPageChangeListener pageChangeListener = null;
    private String replyPostId = null;
    private long pageDoneTime = 0;
    private HashMap<String, Boolean> pvHash = null;
    private Handler mHandler = null;
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.pb.ImagePbActivity.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ImagePbActivity.this.isActive && ImagePbActivity.this.mData != null) {
                    int start = ImagePbActivity.this.mIndex > 0 ? ImagePbActivity.this.mIndex - 1 : 0;
                    int end = ImagePbActivity.this.mIndex >= ImagePbActivity.this.mData.getImageNum() - 1 ? ImagePbActivity.this.mData.getImageNum() - 1 : ImagePbActivity.this.mIndex + 1;
                    NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(ImagePbActivity.this);
                    ImagePbActivity.this.mViewPagerAdapter.getImageLoader().clearHoldUrl();
                    boolean supportHold = false;
                    if (info != NetWorkCore.NetworkStateInfo.WIFI && info != NetWorkCore.NetworkStateInfo.ThreeG) {
                        start = ImagePbActivity.this.mIndex;
                        end = ImagePbActivity.this.mIndex;
                    } else {
                        supportHold = true;
                    }
                    ImagePbActivity.this.mViewPagerAdapter.getImageLoader().setSupportHoldUrl(supportHold);
                    for (int i = start; i <= end; i++) {
                        ImagePbActivity.this.mViewPagerAdapter.getImageLoader().loadImage(ImagePbActivity.this.mData.getImageInfo().get(i).getImageUrl(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.pb.ImagePbActivity.1.1
                            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                ImagePbImageView view;
                                if (bitmap != null && (view = (ImagePbImageView) ImagePbActivity.this.mViewPager.findViewWithTag(imageUrl)) != null) {
                                    view.invalidate();
                                    view.startAnim();
                                }
                            }
                        });
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("ImagePbActivity", "mGetImageRunnble.run", "error = " + ex.getMessage());
            }
        }
    };
    private OnPreLoading mOnprLoading = new OnPreLoading() { // from class: com.baidu.tieba.pb.ImagePbActivity.2
        @Override // com.baidu.tieba.pb.ImagePbActivity.OnPreLoading
        public void startPreLoad(int index, int pre, int last) {
            if (ImagePbActivity.this.mImagePbAsyncTask == null) {
                ImagePbActivity.this.startImagePbAsyncTask(ImagePbActivity.this.mData.getLastPicID(), 0, 10, false);
            }
        }
    };
    private KeyboardLayout.onKybdsChangeListener mKbdChangeListener = new KeyboardLayout.onKybdsChangeListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.3
        @Override // com.baidu.tieba.view.KeyboardLayout.onKybdsChangeListener
        public void onKeyBoardStateChange(int state) {
            if (state == -2) {
                ImagePbActivity.this.mPostLayout.setVisibility(8);
                ImagePbActivity.this.mBottomLayout.setVisibility(0);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface OnPreLoading {
        void startPreLoad(int i, int i2, int i3);
    }

    public static void startAcitivity(Context context, String id, String forum, String title) {
        Intent intent = new Intent(context, ImagePbActivity.class);
        if (id != null && id.length() > 0) {
            intent.putExtra(ID, id);
            intent.putExtra(FORUM, forum);
            intent.putExtra(TITLE, title);
        }
        context.startActivity(intent);
    }

    public static void startAcitivity(Context context, ImagePbData datas) {
        Intent intent = new Intent(context, ImagePbActivity.class);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_pb_activity);
        this.mData = new ImagePbData(this);
        initUI();
        initData(savedInstanceState);
        initReceiver();
    }

    private void initReceiver() {
        this.mPagecChangeReceiver = new PageChangeReceiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BROADCAST_PAGE_CHANGED);
        registerReceiver(this.mPagecChangeReceiver, filter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
        AsyncImageLoader mLoader = this.mViewPagerAdapter.getImageLoader();
        if (mLoader != null) {
            mLoader.cancelAllAsyncTask();
        }
        this.isActive = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
        this.mHandler.post(this.mGetImageRunnble);
        this.isActive = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        imageChange(this.mIndex, this.mIndex);
        sendImagePv();
        if (this.mSaveImageTask != null) {
            this.mSaveImageTask.cancel();
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mReplyAsyncTask != null) {
            this.mReplyAsyncTask.cancel();
        }
        if (this.mImagePbAsyncTask != null) {
            this.mImagePbAsyncTask.cancel();
        }
        if (this.mDialogTitle != null && this.mDialogTitle.isShowing()) {
            this.mDialogTitle.dismiss();
        }
        this.mViewPagerAdapter.onDestroy();
        unregisterReceiver(this.mPagecChangeReceiver);
        super.onDestroy();
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

    private void initUI() {
        this.mBackButton = (Button) findViewById(R.id.back);
        this.mBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                ImagePbActivity.this.finish();
            }
        });
        this.mCameraButton = (Button) findViewById(R.id.camera);
        this.mCameraButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                ImagePbActivity.this.followThread();
            }
        });
        this.mComment = (Button) findViewById(R.id.reply);
        this.mComment.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImagePbActivity.this.switchEdit(true);
            }
        });
        this.mSave = (Button) findViewById(R.id.save);
        this.mSave.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                ImagePbActivity.this.saveImage();
            }
        });
        this.mTitle = (TextView) findViewById(R.id.title_text);
        this.mTitle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (ImagePbActivity.this.mPbTitle != null && ImagePbActivity.this.mPbTitle.length() != 0) {
                    ImagePbActivity.this.createTitleHint();
                    TextView text = (TextView) ImagePbActivity.this.mPbTileDialogView.findViewById(R.id.text);
                    if (text != null) {
                        ImagePbActivity.this.mDialogTitle.show();
                        text.setText(String.valueOf(ImagePbActivity.this.getString(R.string.title)) + ImagePbActivity.this.mPbTitle);
                        ImagePbActivity.this.mDialogTitle.setContentView(ImagePbActivity.this.mPbTileDialogView);
                        int y = (ImagePbActivity.this.mTitle.getTop() + ImagePbActivity.this.mTitle.getHeight()) - 5;
                        WindowManager.LayoutParams wmParams = ImagePbActivity.this.mDialogTitle.getWindow().getAttributes();
                        wmParams.gravity = 51;
                        wmParams.x = 0;
                        wmParams.y = y;
                        wmParams.width = -1;
                        wmParams.height = -2;
                        wmParams.alpha = 1.0f;
                        ImagePbActivity.this.mDialogTitle.getWindow().setAttributes(wmParams);
                    }
                }
            }
        });
        this.mPage = (TextView) findViewById(R.id.title_page);
        this.mViewPager = (BaseViewPager) findViewById(R.id.content_view);
        this.mViewPager.setOnScrollOutListener(this);
        String[] items = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    WriteUtil.takePhoto(ImagePbActivity.this);
                } else {
                    WriteUtil.getAlbumImage(ImagePbActivity.this);
                }
            }
        });
        this.mPostLayout = (LinearLayout) findViewById(R.id.layout_reply);
        this.mEditReply = (EditText) findViewById(R.id.reply_content);
        this.mButtonFace = (Button) findViewById(R.id.button_face);
        this.mButtonReply = (Button) findViewById(R.id.reply_button);
        this.mButtonReply.setEnabled(false);
        setTextWatcher();
        this.faceView = (GridView) findViewById(R.id.face_view);
        final FaceAdapter faceAdapter = new FaceAdapter(this);
        this.faceView.setAdapter((ListAdapter) faceAdapter);
        this.faceView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String name;
                ImageSpan[] all = (ImageSpan[]) ImagePbActivity.this.mEditReply.getText().getSpans(0, ImagePbActivity.this.mEditReply.getText().length(), ImageSpan.class);
                if (all.length >= 10) {
                    ImagePbActivity.this.showToast(ImagePbActivity.this.getString(R.string.too_many_face));
                } else if (!ImagePbActivity.this.checkTextNum() && (name = faceAdapter.getName(arg2)) != null) {
                    int pos = ImagePbActivity.this.mEditReply.getSelectionStart();
                    SpannableStringBuilder spanName = new SpannableStringBuilder(name);
                    Bitmap bm = (Bitmap) faceAdapter.getItem(arg2);
                    if (bm != null) {
                        MyBitmapDrawable dr = new MyBitmapDrawable(bm);
                        dr.setBounds(0, 0, bm.getWidth() + 1, bm.getHeight());
                        dr.setGravity(3);
                        ImageSpan span = new ImageSpan(dr, 0);
                        spanName.setSpan(span, 0, spanName.length(), 33);
                        ImagePbActivity.this.mEditReply.getText().insert(pos, spanName);
                    }
                }
            }
        });
        this.mKeyboardLayout = (KeyboardLayout) findViewById(R.id.image_pb_layout);
        this.mKeyboardLayout.setOnkbdStateListener(this.mKbdChangeListener);
        this.mButtonReply.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImagePbActivity.this.reply(ImagePbActivity.this.mFloor);
            }
        });
        final Handler handler = new Handler();
        final Runnable showFaceRunnable = new Runnable() { // from class: com.baidu.tieba.pb.ImagePbActivity.12
            @Override // java.lang.Runnable
            public void run() {
                if (ImagePbActivity.this.faceView.getVisibility() != 0) {
                    ImagePbActivity.this.faceView.setVisibility(0);
                }
                ImagePbActivity.this.mKeyboardLayout.setOnkbdStateListener(ImagePbActivity.this.mKbdChangeListener);
            }
        };
        this.mButtonFace.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ImagePbActivity.this.faceView.getVisibility() == 0) {
                    ImagePbActivity.this.mEditReply.requestFocus();
                    ImagePbActivity.this.faceView.setVisibility(8);
                    UtilHelper.showSoftKeyPad(ImagePbActivity.this, ImagePbActivity.this.mEditReply);
                    ImagePbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
                    return;
                }
                ImagePbActivity.this.mKeyboardLayout.setOnkbdStateListener(null);
                UtilHelper.hideSoftKeyPad(ImagePbActivity.this, ImagePbActivity.this.mEditReply);
                handler.postDelayed(showFaceRunnable, 200L);
                ImagePbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_keyboard);
            }
        });
        this.mBottomLayout = (LinearLayout) findViewById(R.id.image_pb_bottom);
        this.mEditReply.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.14
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (ImagePbActivity.this.faceView.getVisibility() == 0) {
                    ImagePbActivity.this.mEditReply.requestFocus();
                    ImagePbActivity.this.faceView.setVisibility(8);
                    UtilHelper.showSoftKeyPad(ImagePbActivity.this, ImagePbActivity.this.mEditReply);
                    ImagePbActivity.this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
                    return true;
                }
                return false;
            }
        });
        this.mProgress = (ProgressBar) findViewById(R.id.image_pb_progress);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.ImagePbActivity.15
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                ImagePbActivity.this.DeinitWaitingDialog();
                if (ImagePbActivity.this.mReplyAsyncTask != null) {
                    ImagePbActivity.this.mReplyAsyncTask.cancel();
                }
            }
        };
        if (this.mSelectImageDialog == null) {
            this.mSelectImageDialog = builder.create();
            this.mSelectImageDialog.setCanceledOnTouchOutside(true);
        }
        switchEdit(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsRefresh(boolean b) {
        if (this.mProgress != null) {
            if (b) {
                this.mProgress.setVisibility(0);
            } else {
                this.mProgress.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchEdit(boolean isShow) {
        if (isShow) {
            this.mEditReply.requestFocus();
            this.mPostLayout.setVisibility(0);
            this.faceView.setVisibility(8);
            UtilHelper.showSoftKeyPad(this, this.mEditReply);
            this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
            this.mBottomLayout.setVisibility(4);
            return;
        }
        this.mPostLayout.setVisibility(8);
        this.faceView.setVisibility(8);
        this.mBottomLayout.setVisibility(0);
        UtilHelper.hideSoftKeyPad(this, this.mEditReply);
    }

    private void initData(Bundle savedInstanceState) {
        this.mHandler = new Handler();
        this.currentPage = 0;
        if (savedInstanceState != null) {
            this.mTid = savedInstanceState.getString(ID);
            this.mForum = savedInstanceState.getString(FORUM);
            this.mPbTitle = savedInstanceState.getString(TITLE);
            this.currentPage = savedInstanceState.getInt(CURRENTPAGE);
        } else {
            this.mTid = getIntent().getStringExtra(ID);
            this.mForum = getIntent().getStringExtra(FORUM);
            this.mPbTitle = getIntent().getStringExtra(TITLE);
        }
        this.mData.setTid(this.mTid);
        this.mData.setTitle(this.mPbTitle);
        this.mTitle.setText(this.mPbTitle);
        this.mViewPagerAdapter = new ImagePbPagerAdapter(this);
        this.mViewPagerAdapter.setOnPreLodingCallBack(this.mOnprLoading);
        this.mViewPagerAdapter.setTid(this.mTid);
        this.mViewPager.setAdapter(this.mViewPagerAdapter);
        this.pageChangeListener = new MyOnPageChangeListener();
        this.mViewPager.setOnPageChangeListener(this.pageChangeListener);
        this.mViewPager.setCurrentItem(this.currentPage);
        if (this.mForum != null && this.mForum.length() > 0 && this.mTid != null && this.mTid.length() > 0) {
            startImagePbAsyncTask(null, 0, 9, true);
        }
        this.pvHash = new HashMap<>();
        imageChange(this.mIndex, this.mIndex);
    }

    private void freshData(boolean isNext) {
        this.mHandler.removeCallbacks(this.mGetImageRunnble);
        AsyncImageLoader mLoader = this.mViewPagerAdapter.getImageLoader();
        if (mLoader != null) {
            mLoader.cancelAllAsyncTask();
        }
        if (!isNext) {
            String toastString = this.mPbTitle;
            if (this.mPbTitle != null && this.mPbTitle.length() > 6) {
                toastString = String.valueOf(this.mPbTitle.substring(0, 6)) + getString(R.string.three_point);
            }
            showToast(getString(R.string.image_pb_imagethread).replace("?", toastString));
        }
        this.mData.setTid(this.mTid);
        this.mData.setTitle(this.mPbTitle);
        this.mTitle.setText(this.mPbTitle);
        this.mViewPagerAdapter.reset();
        this.mViewPagerAdapter.setTid(this.mTid);
        this.mViewPagerAdapter.setDatas(this.mData);
        this.mViewPagerAdapter.notifyDataSetChanged();
        this.mViewPagerAdapter.clearComments();
        if (isNext && this.mForum != null && this.mForum.length() > 0 && this.mTid != null && this.mTid.length() > 0) {
            startImagePbAsyncTask(null, 0, 9, true);
        } else {
            sendUrlIntent(0);
        }
        if (this.mDialogTitle != null && this.mDialogTitle.isShowing()) {
            this.mDialogTitle.dismiss();
        }
        imageChange(this.mIndex, this.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImagePv() {
        ArrayList<BasicNameValuePair> infos = new ArrayList<>(0);
        BasicNameValuePair temp = new BasicNameValuePair("fname", this.mForum);
        infos.add(temp);
        BasicNameValuePair temp2 = new BasicNameValuePair("tid", this.mTid);
        infos.add(temp2);
        if (this.mData != null) {
            BasicNameValuePair temp3 = new BasicNameValuePair("fid", String.valueOf(this.mData.getFid()));
            infos.add(temp3);
        }
        if (this.mViewPagerAdapter.getImageLoader() != null) {
            this.mViewPagerAdapter.getImageLoader().setExtraInfos(infos);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(ID, this.mTid);
        outState.putString(FORUM, this.mForum);
        outState.putInt(CURRENTPAGE, this.currentPage);
        outState.putString(TITLE, this.mPbTitle);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0030: INVOKE  (r3v2 int A[REMOVE]) = (r15v0 'data' android.content.Intent A[D('data' android.content.Intent)]), ("index"), (0 int) type: VIRTUAL call: android.content.Intent.getIntExtra(java.lang.String, int):int)] */
    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_LOGIN_PB_REPLY_FLOOR /* 1100005 */:
                    reply(this.mFloor);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 1100016 */:
                    this.mSelectImageDialog.show();
                    return;
                case RequestResponseCode.REQUEST_CAMERA /* 1200001 */:
                    if (this.mData != null && this.mData.getForum() != null && this.mForum != null) {
                        WriteImageActivity.startActivityForResult(this, RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, String.valueOf(this.mData.getFid()), this.mForum, this.mTid, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 1200002 */:
                    if (this.mData != null && this.mData.getForum() != null && this.mForum != null) {
                        if (data != null && data.getData() != null) {
                            WriteImageActivity.startActivityForResult(this, RequestResponseCode.REQUEST_ALBUM_IMAGE, RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, data.getData(), String.valueOf(this.mData.getFid()), this.mForum, this.mTid, null);
                            return;
                        } else {
                            WriteUtil.getAlbumImage(this);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 1200005 */:
                    if (data.getSerializableExtra(VcodeActivity.SAVE_KEY) != null) {
                        refreshOnReplySuccess();
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_PB_BIG_IMAGE /* 1400001 */:
                    if (data != null && data.getIntExtra("index", -1) >= 0) {
                        TiebaLog.i(getClass().getName(), "onActivityResult", new StringBuilder().append(data.getIntExtra("index", 0)).toString());
                        this.mViewPager.setCurrentItem(data.getIntExtra("index", 0), false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImage() {
        if (this.mSaveImageTask != null) {
            this.mSaveImageTask.cancel();
        }
        this.mSaveImageTask = new SaveImageAsyncTask(this, null);
        this.mSaveImageTask.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void followThread() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            if (this.mData != null && this.mData.getAntiData() != null) {
                this.mData.getAntiData().setIfpost(1);
            }
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE);
        } else if (this.mData != null) {
            this.mSelectImageDialog.show();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 'next' int A[D('next' int)])] */
    /* JADX INFO: Access modifiers changed from: private */
    public void startImagePbAsyncTask(String picId, int prev, int next, boolean isFirst) {
        TiebaLog.i(getClass().getName(), picId, new StringBuilder().append(next).toString());
        if (!this.mData.isFinished()) {
            if (this.mImagePbAsyncTask != null) {
                this.mImagePbAsyncTask.cancel();
            }
            ArrayList<BasicNameValuePair> param = new ArrayList<>();
            BasicNameValuePair temp = new BasicNameValuePair("kw", this.mForum);
            param.add(temp);
            BasicNameValuePair temp2 = new BasicNameValuePair("tid", this.mTid);
            param.add(temp2);
            if (picId != null) {
                BasicNameValuePair temp3 = new BasicNameValuePair("pic_id", picId);
                param.add(temp3);
            }
            BasicNameValuePair temp4 = new BasicNameValuePair("prev", String.valueOf(prev));
            param.add(temp4);
            BasicNameValuePair temp5 = new BasicNameValuePair("next", String.valueOf(next));
            param.add(temp5);
            setIsRefresh(true);
            TiebaLog.i(getClass().getName(), "startImagePbAsyncTask", picId);
            this.mImagePbAsyncTask = new ImagePbAsyncTask("http://c.tieba.baidu.com/c/f/pb/picpage".toString(), param, isFirst);
            this.mImagePbAsyncTask.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImagePbAsyncTask extends AsyncTask<Object, Integer, String> {
        private String address;
        private String data = null;
        private boolean isCanceled = false;
        private boolean isFirst;
        private NetWork mNetWork;
        private ArrayList<BasicNameValuePair> param;

        public ImagePbAsyncTask(String adress, ArrayList<BasicNameValuePair> param, boolean isFirst) {
            this.param = null;
            this.address = null;
            this.isFirst = false;
            this.address = adress;
            this.param = param;
            this.isFirst = isFirst;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Object... arg0) {
            this.mNetWork = new NetWork(this.address);
            this.mNetWork.setPostData(this.param);
            this.data = this.mNetWork.postNetData();
            return this.data;
        }

        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.cancelNetConnect();
            }
            ImagePbActivity.this.mImagePbAsyncTask = null;
            ImagePbActivity.this.setIsRefresh(false);
            this.isCanceled = true;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ImagePbAsyncTask) result);
            if (!this.isCanceled) {
                if (this.mNetWork != null && this.mNetWork.isNetSuccess() && ImagePbActivity.this.mData != null) {
                    if (this.mNetWork.isRequestSuccess()) {
                        if (!ImagePbActivity.this.mData.isFinished()) {
                            ImagePbActivity.this.mData.paserJson(this.data, true);
                        }
                        ImagePbActivity.this.mViewPagerAdapter.setDatas(ImagePbActivity.this.mData);
                        ImagePbActivity.this.mViewPagerAdapter.notifyDataSetChanged();
                        ImagePbActivity.this.pageChangeListener.onPageSelected(ImagePbActivity.this.mIndex);
                        if (ImagePbActivity.this.isActive) {
                            ImagePbActivity.this.mHandler.removeCallbacks(ImagePbActivity.this.mGetImageRunnble);
                            ImagePbActivity.this.mHandler.post(ImagePbActivity.this.mGetImageRunnble);
                        } else if (this.isFirst) {
                            ImagePbActivity.this.sendUrlIntent(1);
                        } else {
                            ImagePbActivity.this.sendUrlIntent(2);
                        }
                        ImagePbActivity.this.setImagePv();
                        if (ImagePbActivity.this.mIndex >= ImagePbActivity.this.mData.getImageInfo().size() && ImagePbActivity.this.mIndex < ImagePbActivity.this.mData.getImageNum() && ImagePbActivity.this.mData.getImageInfo().size() < ImagePbActivity.this.mData.getImageNum()) {
                            ImagePbActivity.this.startImagePbAsyncTask(ImagePbActivity.this.mData.getLastPicID(), 0, 10, false);
                        }
                    } else {
                        ImagePbActivity.this.showToast(ImagePbActivity.this.getString(R.string.pb_nodata));
                        if (this.isFirst && ImagePbActivity.this.mPreData != null) {
                            ImagePbActivity.this.onScrollOut(0);
                        } else {
                            ImagePbActivity.this.finish();
                        }
                    }
                } else {
                    ImagePbActivity.this.showToast(ImagePbActivity.this.getString(R.string.neterror));
                }
                ImagePbActivity.this.mImagePbAsyncTask = null;
                ImagePbActivity.this.setIsRefresh(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUrlIntent(int state) {
        Intent intent = new Intent(Config.BROADCAST_PAGE_ADDED);
        LinkedList<ImageData> images = this.mData.getImageInfo();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {
            ImageData imageItem = images.get(i);
            StringBuffer buffer = new StringBuffer(100);
            if (imageItem.getHeight() * imageItem.getWidth() > Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) {
                double a = Math.sqrt((Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH) / (imageItem.getHeight() * imageItem.getWidth()));
                buffer.append("width=");
                buffer.append(String.valueOf((int) (imageItem.getWidth() * a)));
                buffer.append("&height=");
                buffer.append(String.valueOf((int) (imageItem.getHeight() * a)));
            } else {
                buffer.append("width=");
                buffer.append(String.valueOf(imageItem.getWidth()));
                buffer.append("&height=");
                buffer.append(String.valueOf(imageItem.getHeight()));
            }
            buffer.append("&src=");
            String encode = StringHelper.getUrlEncode(imageItem.getImageUrl());
            buffer.append(encode);
            list.add(buffer.toString());
        }
        if (list != null && list.size() > 0) {
            intent.putStringArrayListExtra("url", list);
            intent.putExtra("count", this.mData.getImageNum());
            if (this.mData.hasNext() && list.size() == this.mData.getImageNum()) {
                intent.putExtra("hasnext", true);
                intent.putExtra("nexttitle", this.mData.getNextTitle());
            }
            if (state == 0) {
                intent.putExtra("index", this.mData.getImageNum() - 1);
            } else if (state == 1) {
                intent.putExtra("index", 0);
            } else {
                intent.putExtra("index", -1);
            }
            sendBroadcast(intent);
        }
    }

    /* loaded from: classes.dex */
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        public MyOnPageChangeListener() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int arg0) {
            ImagePbActivity.this.imageChange(ImagePbActivity.this.mIndex, arg0);
            ImagePbActivity.this.mIndex = arg0;
            ImagePbActivity.this.mCameraButton.setVisibility(4);
            ImagePbActivity.this.mCameraButton.setClickable(false);
            ImagePbActivity.this.mPage.setText((CharSequence) null);
            if (ImagePbActivity.this.mData != null && ImagePbActivity.this.mData.getImageNum() > 0) {
                if (arg0 == ImagePbActivity.this.mData.getImageNum()) {
                    ImagePbActivity.this.mPage.setVisibility(8);
                    ImagePbActivity.this.mTitle.setText(ImagePbActivity.this.getString(R.string.image_recommend));
                    ImagePbActivity.this.mBottomLayout.setVisibility(8);
                    return;
                }
                ImagePbActivity.this.mTitle.setText(ImagePbActivity.this.mPbTitle);
                ImagePbActivity.this.mPage.setVisibility(0);
                ImagePbActivity.this.mBottomLayout.setVisibility(0);
                ImagePbActivity.this.mPage.setText(String.valueOf(String.valueOf(arg0 + 1)) + "/" + String.valueOf(ImagePbActivity.this.mData.getImageNum()));
                LinkedList<ImageData> data = ImagePbActivity.this.mData.getImageInfo();
                if (data != null && ImagePbActivity.this.mIndex < data.size() && data.get(ImagePbActivity.this.mIndex) != null) {
                    ImagePbActivity.this.replyPostId = data.get(ImagePbActivity.this.mIndex).getCommentID();
                    if (data.get(ImagePbActivity.this.mIndex).getUserID().equals(TiebaApplication.getCurrentAccount())) {
                        ImagePbActivity.this.mCameraButton.setVisibility(0);
                        ImagePbActivity.this.mCameraButton.setClickable(true);
                    }
                }
            }
            ImagePbActivity.this.pageDoneTime = System.nanoTime();
            ImagePbActivity.this.mHandler.removeCallbacks(ImagePbActivity.this.mGetImageRunnble);
            ImagePbActivity.this.mHandler.postDelayed(ImagePbActivity.this.mGetImageRunnble, 300L);
        }
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
        return (this.mEditReply.getText().toString().length() - faceTextCount) + faceCount > TEXT_LIMIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reply(int floor) {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            if (this.mAnti != null) {
                this.mAnti.setIfpost(1);
            }
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_post), true, (int) RequestResponseCode.REQUEST_LOGIN_PB_REPLY_FLOOR);
        } else if (this.mAnti != null && this.mAnti.getIfpost() == 0) {
            UtilHelper.showToast(this, this.mAnti.getForbid_info());
        } else {
            String content = this.mEditReply.getText().toString();
            if (content != null && content.length() > 0 && this.mData != null) {
                if (checkTextNum()) {
                    content = content.substring(0, TEXT_LIMIT);
                }
                showLoadingDialog(getString(R.string.sending), this.mDialogCancelListener);
                WriteModel model = new WriteModel();
                model.setForumId(String.valueOf(this.mData.getFid()));
                model.setForumName(this.mData.getForum());
                model.setContent(content);
                model.setVcode(null);
                model.setFloor(this.replyPostId);
                model.setThreadId(this.mTid);
                model.setFloorNum(0);
                model.setType(WriteModel.REPLY_FLOOR);
                this.mReplyAsyncTask = new ReplyAsyncTask(model);
                this.mReplyAsyncTask.execute(new Integer[0]);
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
                    VcodeActivity.startActivityForResult(ImagePbActivity.this, this.mWriteModel, (int) RequestResponseCode.REQUEST_VCODE);
                    return;
                }
                ImagePbActivity.this.showToast(errorString);
                return;
            }
            ImagePbActivity.this.showToast(errorString);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((ReplyAsyncTask) result);
            ImagePbActivity.this.closeLoadingDialog();
            ImagePbActivity.this.mReplyAsyncTask = null;
            if (this.mNetwork != null) {
                if (!this.mNetwork.isRequestSuccess()) {
                    handleRequestFail(this.mNetwork.getErrorCode(), this.mNetwork.getErrorString(), result);
                } else {
                    ImagePbActivity.this.refreshOnReplySuccess();
                }
            }
        }

        public void cancel() {
            ImagePbActivity.this.mReplyAsyncTask = null;
            ImagePbActivity.this.closeLoadingDialog();
            this.mCanceled = true;
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            super.cancel(true);
        }
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
        this.mPostLayout.setVisibility(8);
        this.mBottomLayout.setVisibility(0);
        this.mButtonFace.setBackgroundResource(R.drawable.sub_pb_face);
        this.mViewPagerAdapter.loadMoreComment();
    }

    @Override // com.baidu.tieba.BaseActivity
    public void showLoadingDialog(String string, DialogInterface.OnCancelListener listener) {
        if (string != null) {
            this.mWaitingDialog = ProgressDialog.show(this, "", string, true, true, listener);
        } else {
            this.mWaitingDialog = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, listener);
        }
    }

    @Override // com.baidu.tieba.BaseActivity
    public void closeLoadingDialog() {
        if (this.mWaitingDialog != null) {
            try {
                if (this.mWaitingDialog.isShowing()) {
                    this.mWaitingDialog.dismiss();
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "closeLoadingDialog", ex.getMessage());
            }
            this.mWaitingDialog = null;
        }
    }

    private void setTextWatcher() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.pb.ImagePbActivity.16
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s == null || s.length() <= 0) {
                    ImagePbActivity.this.mButtonReply.setEnabled(false);
                } else {
                    ImagePbActivity.this.mButtonReply.setEnabled(true);
                }
            }
        };
        this.mEditReply.addTextChangedListener(textWatcher);
        this.mEditReply.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.pb.ImagePbActivity.17
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (ImagePbActivity.this.checkTextNum()) {
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
    /* loaded from: classes.dex */
    public class PageChangeReceiver extends BroadcastReceiver {
        private PageChangeReceiver() {
        }

        /* synthetic */ PageChangeReceiver(ImagePbActivity imagePbActivity, PageChangeReceiver pageChangeReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int index = intent.getIntExtra("index", -1);
            if (index >= 0) {
                ImagePbActivity.this.mIndex = index;
                if (ImagePbActivity.this.mData != null && index + 5 >= ImagePbActivity.this.mData.getImageInfo().size() && ImagePbActivity.this.mData.getImageInfo().size() != ImagePbActivity.this.mData.getImageNum() && ImagePbActivity.this.mImagePbAsyncTask == null) {
                    ImagePbActivity.this.startImagePbAsyncTask(ImagePbActivity.this.mData.getLastPicID(), 0, 10, false);
                }
            } else if (ImagePbActivity.this.mIndex == 0 || (ImagePbActivity.this.mIndex >= ImagePbActivity.this.mData.getImageNum() - 1 && ImagePbActivity.this.mData.getImageInfo().size() == ImagePbActivity.this.mData.getImageNum())) {
                int state = intent.getIntExtra("state", -1);
                ImagePbActivity.this.onScrollOut(state);
                TiebaLog.i(getClass().getName(), "find_bug_onReceive", "state=" + String.valueOf(state));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SaveImageAsyncTask extends AsyncTask<String, Integer, String> {
        private SaveImageAsyncTask() {
        }

        /* synthetic */ SaveImageAsyncTask(ImagePbActivity imagePbActivity, SaveImageAsyncTask saveImageAsyncTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... arg0) {
            try {
                if (ImagePbActivity.this.mData == null || ImagePbActivity.this.mData.getImageInfo() == null || ImagePbActivity.this.mData.getImageInfo().size() <= ImagePbActivity.this.mIndex) {
                    return null;
                }
                String mUrl = String.valueOf(ImagePbActivity.this.mData.getImageInfo().get(ImagePbActivity.this.mIndex).getImageUrl()) + AsyncImageLoader.BIG;
                if (mUrl != null && mUrl.length() > 0) {
                    String sname = StringHelper.getNameMd5FromUrl(mUrl);
                    if (sname != null) {
                        String xfilename = String.valueOf(sname) + ".jpg";
                        for (int i = 0; FileHelper.CheckFile(xfilename) && i < 10000; i++) {
                            xfilename = String.valueOf(sname) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
                        }
                        if (TiebaApplication.app.getSdramImage().getPic(mUrl) != null) {
                            String xfilename2 = FileHelper.SaveFile(null, xfilename, TiebaApplication.app.getSdramImage().getPic(mUrl), 80);
                            if (xfilename2 != null) {
                                MediaScannerClient client = new MediaScannerClient(ImagePbActivity.this);
                                client.saveImage(xfilename2);
                                String notifyStr = ImagePbActivity.this.getString(R.string.save_image_to_album);
                                return notifyStr;
                            }
                            String notifyStr2 = FileHelper.getSdErrorString();
                            return notifyStr2;
                        }
                        return null;
                    }
                    return ImagePbActivity.this.getString(R.string.save_error);
                }
                return ImagePbActivity.this.getString(R.string.save_error);
            } catch (Exception ex) {
                TiebaLog.e("SaveImageAsyncTask", "doInBackground", "error" + ex.getMessage());
                return ImagePbActivity.this.getString(R.string.save_error);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((SaveImageAsyncTask) result);
            if (result != null) {
                ImagePbActivity.this.showToast(result);
            }
            ImagePbActivity.this.mSaveImageTask = null;
        }

        public void cancel() {
            ImagePbActivity.this.mSaveImageTask = null;
            super.cancel(true);
        }
    }

    @Override // com.baidu.tieba.view.BaseViewPager.OnScrollOutListener
    public void onScrollOut(int state) {
        switch (state) {
            case 0:
                if (this.mData.getNextTid() != null && this.mData.getNextTitle() != null) {
                    if (this.mImagePbAsyncTask != null) {
                        this.mImagePbAsyncTask.cancel();
                    }
                    this.mTid = this.mData.getNextTid();
                    this.mForum = this.mData.getForum();
                    this.mPbTitle = this.mData.getNextTitle();
                    this.mIndex = 0;
                    this.mViewPager.setCurrentItem(0, false);
                    this.mPage.setText((CharSequence) null);
                    this.mPreData = this.mData;
                    this.mData = new ImagePbData();
                    freshData(true);
                    return;
                }
                return;
            case 1:
                if (this.mPreData != null) {
                    if (this.mImagePbAsyncTask != null) {
                        this.mImagePbAsyncTask.cancel();
                    }
                    this.mData = this.mPreData;
                    this.mPreData = null;
                    this.mTid = this.mData.getTid();
                    this.mForum = this.mData.getForum();
                    this.mPbTitle = this.mData.getTitle();
                    this.mIndex = this.mData.getImageNum() - 1;
                    freshData(false);
                    this.mViewPager.setCurrentItem(this.mIndex, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageChange(int srcIndex, int dstIndex) {
        synchronized (this.pvHash) {
            if (System.nanoTime() - this.pageDoneTime > INV_TIME && this.mData != null && this.mData.getImageInfo() != null && this.mIndex < this.mData.getImageInfo().size()) {
                this.pvHash.put(this.mData.getImageInfo().get(srcIndex).getImageUrl(), true);
            }
            this.pageDoneTime = System.nanoTime();
            if (this.mData.getImageInfo() != null && dstIndex < this.mData.getImageInfo().size() && this.pvHash.get(this.mData.getImageInfo().get(dstIndex).getImageUrl()) == null) {
                this.pvHash.put(this.mData.getImageInfo().get(dstIndex).getImageUrl(), false);
            }
        }
        if (this.pvHash.size() >= 100) {
            sendImagePv();
        }
    }

    private void sendImagePv() {
        if (this.pvHash != null) {
            synchronized (this.pvHash) {
                if (this.pvHash.size() > 0) {
                    int count = 0;
                    for (Map.Entry<String, Boolean> entry : this.pvHash.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            count++;
                        }
                    }
                    TiebaApplication.app.sendImagePv(count, this.pvHash.size(), "photo");
                    this.pvHash.clear();
                }
            }
        }
    }
}
