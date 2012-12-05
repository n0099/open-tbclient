package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ImagePbData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.MediaScannerClient;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ImageActivity extends BaseActivity {
    private static final long INV_TIME = 300000000;
    private ProgressBar mProgress = null;
    private ArrayList<String> mUrl = null;
    private int mIndex = -1;
    private int mCount = -1;
    private boolean mHasNext = false;
    private String mNextTitle = null;
    private SaveImageAsyncTask mSaveImageTask = null;
    private Button mSave = null;
    private Button mBack = null;
    private TextView mTextView = null;
    private LinearLayout mTitle = null;
    private MultiImageView mMultiImageView = null;
    private View.OnClickListener mOnClickListener = null;
    private BaseViewPager.OnScrollOutListener mOnscOnScrollOutListener = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation mAnim = null;
    private boolean mAnimFinished = true;
    private boolean mTitleGone = false;
    private PageAddedReceiver mPageAddedReceiver = null;
    private long pageDoneTime = 0;
    private HashMap<String, Boolean> pvHash = null;
    private String mFid = null;
    private String mTid = null;
    private String mFname = null;
    private String mPvType = null;

    public static void startActivity(Context context, ArrayList<String> data, int index, PbModel pbModel) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (data != null && data.size() > 0) {
            intent.putStringArrayListExtra("url", data);
            intent.putExtra("index", index);
            intent.putExtra("is_pv", true);
            intent.putExtra("pv_type", "pb");
            if (pbModel != null) {
                if (pbModel.getData() != null && pbModel.getData().getForum() != null) {
                    intent.putExtra("fname", pbModel.getData().getForum().getName());
                    intent.putExtra("fid", pbModel.getData().getForum().getId());
                }
                if (pbModel.getData() != null && pbModel.getData().getThread() != null) {
                    intent.putExtra("tid", pbModel.getData().getThread().getId());
                }
            }
            context.startActivity(intent);
        }
    }

    public static void startActivityForResult(Context context, ArrayList<String> data, int index, int count, boolean hasNext, ImagePbData fData) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (data != null && data.size() > 0) {
            intent.putStringArrayListExtra("url", data);
            intent.putExtra("index", index);
            intent.putExtra("count", count);
            intent.putExtra("hasnext", hasNext);
            intent.putExtra("pv_type", "photo");
            if (fData != null) {
                intent.putExtra("nexttitle", fData.getNextTitle());
                intent.putExtra("fname", fData.getForum());
                intent.putExtra("fid", fData.getFid());
                intent.putExtra("tid", fData.getTid());
            }
            ((Activity) context).startActivityForResult(intent, RequestResponseCode.REQUEST_PB_BIG_IMAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TiebaApplication.app.addRemoteActivity(this);
        setContentView(R.layout.image_activity);
        InitData(savedInstanceState);
        InitUI();
        initReceiver();
    }

    public String getFid() {
        return this.mFid;
    }

    public String getTid() {
        return this.mTid;
    }

    public String getFname() {
        return this.mFname;
    }

    private void initReceiver() {
        this.mPageAddedReceiver = new PageAddedReceiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BROADCAST_PAGE_ADDED);
        registerReceiver(this.mPageAddedReceiver, filter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mMultiImageView.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mMultiImageView.onResume();
    }

    @Override // com.baidu.tieba.BaseActivity
    public void releaseResouce() {
        this.mMultiImageView.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaApplication.app.delRemoteActivity(this);
        imageChange(this.mIndex, this.mIndex);
        sendImagePv();
        this.mMultiImageView.onDestroy();
        if (this.mSaveImageTask != null) {
            this.mSaveImageTask.cancel();
            this.mSaveImageTask = null;
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        unregisterReceiver(this.mPageAddedReceiver);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            Intent intent = new Intent();
            intent.putExtra("index", this.mIndex);
            setResult(-1, intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void InitUI() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v != ImageActivity.this.mBack) {
                    if (v == ImageActivity.this.mSave) {
                        if (ImageActivity.this.mTitle.getVisibility() != 8) {
                            try {
                                byte[] data = ImageActivity.this.mMultiImageView.getCurrentImageData();
                                if (data != null) {
                                    String name = ImageActivity.this.mMultiImageView.getCurrentImageUrl();
                                    ImageActivity.this.mSaveImageTask = new SaveImageAsyncTask(name, data);
                                    ImageActivity.this.mSaveImageTask.execute(new String[0]);
                                    ImageActivity.this.mSave.setVisibility(4);
                                    ImageActivity.this.mProgress.setVisibility(0);
                                } else {
                                    ImageActivity.this.showToast(ImageActivity.this.getString(R.string.no_data));
                                }
                            } catch (Exception e) {
                            }
                        }
                    } else if (ImageActivity.this.mAnimFinished) {
                        if (ImageActivity.this.mTitle.getVisibility() != 0) {
                            ImageActivity.this.mTitle.setVisibility(0);
                            ImageActivity.this.mMultiImageView.showTools();
                            ImageActivity.this.mAnim = new AlphaAnimation(0.0f, 1.0f);
                        } else {
                            ImageActivity.this.mAnim = new AlphaAnimation(1.0f, 0.0f);
                            ImageActivity.this.mTitleGone = true;
                            ImageActivity.this.mMultiImageView.hideTools();
                        }
                        ImageActivity.this.mAnim.setDuration(300L);
                        ImageActivity.this.mAnim.setFillAfter(true);
                        ImageActivity.this.mAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.ImageActivity.1.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation arg0) {
                                ImageActivity.this.mAnimFinished = true;
                                if (ImageActivity.this.mTitleGone) {
                                    ImageActivity.this.mTitleGone = false;
                                    ImageActivity.this.mTitle.setVisibility(8);
                                }
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation arg0) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation arg0) {
                            }
                        });
                        ImageActivity.this.mAnimFinished = false;
                        ImageActivity.this.mTitle.startAnimation(ImageActivity.this.mAnim);
                    }
                } else if (ImageActivity.this.mTitle.getVisibility() != 8) {
                    Intent intent = new Intent();
                    intent.putExtra("index", ImageActivity.this.mIndex);
                    ImageActivity.this.setResult(-1, intent);
                    ImageActivity.this.finish();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.ImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int arg0) {
                Intent intent = new Intent(Config.BROADCAST_PAGE_CHANGED);
                intent.putExtra("index", arg0);
                ImageActivity.this.sendBroadcast(intent);
                ImageActivity.this.imageChange(ImageActivity.this.mIndex, arg0);
                ImageActivity.this.mIndex = arg0;
                ImageActivity.this.setTitle();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int arg0) {
                if (arg0 == 1 && System.nanoTime() - ImageActivity.this.pageDoneTime > ImageActivity.INV_TIME && ImageActivity.this.mUrl != null && ImageActivity.this.mIndex < ImageActivity.this.mUrl.size()) {
                    ImageActivity.this.pvHash.put((String) ImageActivity.this.mUrl.get(ImageActivity.this.mIndex), true);
                }
            }
        };
        this.mOnscOnScrollOutListener = new BaseViewPager.OnScrollOutListener() { // from class: com.baidu.tieba.pb.ImageActivity.3
            @Override // com.baidu.tieba.view.BaseViewPager.OnScrollOutListener
            public void onScrollOut(int state) {
                Intent intent = new Intent(Config.BROADCAST_PAGE_CHANGED);
                intent.putExtra("index", -1);
                intent.putExtra("state", state);
                ImageActivity.this.sendBroadcast(intent);
            }
        };
        this.mTitle = (LinearLayout) findViewById(R.id.title);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mSave = (Button) findViewById(R.id.save);
        this.mSave.setOnClickListener(this.mOnClickListener);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.mTextView = (TextView) findViewById(R.id.titel_text);
        this.mMultiImageView = (MultiImageView) findViewById(R.id.viewpager);
        this.mMultiImageView.setPageMargin(UtilHelper.dip2px(this, 8.0f));
        this.mMultiImageView.setOffscreenPageLimit(2, Config.THREAD_IMAGE_MAX_WIDTH * Config.THREAD_IMAGE_MAX_WIDTH);
        this.mMultiImageView.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mMultiImageView.setUrlData(this.mUrl);
        this.mMultiImageView.setItemOnclickListener(this.mOnClickListener);
        this.mMultiImageView.setCurrentItem(calCurrentIndex(), false);
        this.mMultiImageView.setOnScrollOutListener(this.mOnscOnScrollOutListener);
        this.mMultiImageView.setHasNext(this.mHasNext);
        this.mMultiImageView.setNextTitle(this.mNextTitle);
        imageChange(this.mIndex, this.mIndex);
        setTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle() {
        String title;
        if (this.mUrl != null) {
            String title2 = String.valueOf(String.valueOf(this.mIndex + 1)) + "/";
            if (this.mCount > 0) {
                title = String.valueOf(title2) + this.mCount;
            } else {
                title = String.valueOf(title2) + this.mUrl.size();
            }
            if (this.mIndex == this.mCount) {
                this.mTextView.setText(getString(R.string.image_recommend));
                this.mSave.setVisibility(4);
                return;
            }
            this.mTextView.setText(title);
            this.mSave.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calCurrentIndex() {
        if (this.mUrl != null && this.mUrl.size() > 0) {
            int num = this.mUrl.size();
            if (this.mIndex >= num) {
                this.mIndex = num - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        } else {
            this.mIndex = 0;
        }
        return this.mIndex;
    }

    private void InitData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mUrl = savedInstanceState.getStringArrayList("url");
            this.mIndex = savedInstanceState.getInt("index", -1);
            this.mCount = savedInstanceState.getInt("count", -1);
            this.mHasNext = savedInstanceState.getBoolean("hasnext", false);
            this.mNextTitle = savedInstanceState.getString("nexttitle");
            this.mFid = savedInstanceState.getString("fid");
            this.mTid = savedInstanceState.getString("tid");
            this.mFname = savedInstanceState.getString("fname");
            this.mPvType = savedInstanceState.getString("pv_type");
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.mUrl = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
                this.mCount = intent.getIntExtra("count", -1);
                this.mHasNext = intent.getBooleanExtra("hasnext", false);
                this.mNextTitle = intent.getStringExtra("nexttitle");
                this.mFid = intent.getStringExtra("fid");
                this.mTid = intent.getStringExtra("tid");
                this.mFname = intent.getStringExtra("fname");
                this.mPvType = intent.getStringExtra("pv_type");
            }
        }
        this.pvHash = new HashMap<>();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("url", this.mUrl);
        outState.putInt("index", this.mIndex);
        outState.putInt("count", this.mCount);
        outState.putBoolean("hasNext", this.mHasNext);
        outState.putString("nexttitle", this.mNextTitle);
        outState.putString("fid", this.mFid);
        outState.putString("tid", this.mTid);
        outState.putString("fname", this.mFname);
        outState.putString("pv_type", this.mPvType);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mMultiImageView.setCurrentItem(this.mIndex, true);
    }

    /* loaded from: classes.dex */
    private class SaveImageAsyncTask extends AsyncTask<String, Integer, String> {
        byte[] mData;
        String mUrl;

        public SaveImageAsyncTask(String url, byte[] data) {
            this.mUrl = null;
            this.mData = null;
            this.mUrl = url;
            this.mData = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... arg0) {
            try {
                if (this.mUrl != null && this.mUrl.length() > 0 && this.mData != null) {
                    String postfix = ".jpg";
                    if (UtilHelper.isGif(this.mData)) {
                        postfix = ".gif";
                    }
                    String sname = StringHelper.getNameMd5FromUrl(this.mUrl);
                    if (sname == null) {
                        return ImageActivity.this.getString(R.string.save_error);
                    }
                    String xfilename = String.valueOf(sname) + postfix;
                    for (int i = 0; FileHelper.CheckFile(xfilename) && i < 10000; i++) {
                        xfilename = String.valueOf(sname) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + postfix;
                    }
                    String xfilename2 = FileHelper.SaveFile(xfilename, this.mData);
                    if (xfilename2 != null) {
                        MediaScannerClient client = new MediaScannerClient(ImageActivity.this);
                        client.saveImage(xfilename2);
                        String notifyStr = ImageActivity.this.getString(R.string.save_image_to_album);
                        return notifyStr;
                    }
                    String notifyStr2 = FileHelper.getSdErrorString();
                    return notifyStr2;
                }
                return ImageActivity.this.getString(R.string.save_error);
            } catch (Exception ex) {
                TiebaLog.e("SaveImageAsyncTask", "doInBackground", "error" + ex.getMessage());
                return ImageActivity.this.getString(R.string.save_error);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((SaveImageAsyncTask) result);
            ImageActivity.this.showToast(result);
            ImageActivity.this.mSaveImageTask = null;
            ImageActivity.this.mSave.setVisibility(0);
            ImageActivity.this.mProgress.setVisibility(8);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            ImageActivity.this.mSaveImageTask = null;
            ImageActivity.this.mSave.setVisibility(0);
            ImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PageAddedReceiver extends BroadcastReceiver {
        private PageAddedReceiver() {
        }

        /* synthetic */ PageAddedReceiver(ImageActivity imageActivity, PageAddedReceiver pageAddedReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ImageActivity.this.mHasNext = intent.getBooleanExtra("hasnext", false);
            ImageActivity.this.mNextTitle = intent.getStringExtra("nexttitle");
            ImageActivity.this.mUrl = intent.getStringArrayListExtra("url");
            ImageActivity.this.mCount = intent.getIntExtra("count", -1);
            int index = intent.getIntExtra("index", -1);
            ImageActivity.this.mMultiImageView.setUrlData(ImageActivity.this.mUrl);
            ImageActivity.this.mMultiImageView.setNextTitle(ImageActivity.this.mNextTitle);
            ImageActivity.this.mMultiImageView.setHasNext(ImageActivity.this.mHasNext);
            if (index >= 0) {
                ImageActivity.this.mIndex = index;
                ImageActivity.this.mMultiImageView.setCurrentItem(ImageActivity.this.calCurrentIndex(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageChange(int srcIndex, int dstIndex) {
        synchronized (this.pvHash) {
            if (System.nanoTime() - this.pageDoneTime > INV_TIME && this.mUrl != null && srcIndex < this.mUrl.size()) {
                this.pvHash.put(this.mUrl.get(srcIndex), true);
            }
            this.pageDoneTime = System.nanoTime();
            if (this.mUrl != null && dstIndex < this.mUrl.size() && this.pvHash.get(this.mUrl.get(dstIndex)) == null) {
                this.pvHash.put(this.mUrl.get(dstIndex), false);
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
                    TiebaApplication.app.sendImagePv(count, this.pvHash.size(), this.mPvType);
                    this.pvHash.clear();
                }
            }
        }
    }
}
