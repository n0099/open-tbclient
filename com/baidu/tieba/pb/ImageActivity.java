package com.baidu.tieba.pb;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
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
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.MediaScannerClient;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.MultiImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImageActivity extends BaseActivity {
    private ProgressBar mProgress = null;
    private ArrayList<String> mUrl = null;
    private int mIndex = -1;
    private SaveImageAsyncTask mSaveImageTask = null;
    private Button mSave = null;
    private Button mBack = null;
    private TextView mTextView = null;
    private LinearLayout mTitle = null;
    private MultiImageView mMultiImageView = null;
    private View.OnClickListener mOnClickListener = null;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = null;
    private AlphaAnimation mAnim = null;
    private boolean mAnimFinished = true;
    private boolean mTitleGone = false;

    public static void startActivity(Context context, ArrayList<String> data, int index) {
        Intent intent = new Intent(context, ImageActivity.class);
        if (data != null && data.size() > 0) {
            intent.putStringArrayListExtra("url", data);
            intent.putExtra("index", index);
            context.startActivity(intent);
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
        this.mMultiImageView.onDestroy();
        if (this.mSaveImageTask != null) {
            this.mSaveImageTask.cancel();
            this.mSaveImageTask = null;
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        super.onDestroy();
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
                    ImageActivity.this.finish();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.ImageActivity.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int arg0) {
                ImageActivity.this.mIndex = arg0;
                ImageActivity.this.setTitle();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int arg0) {
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
        this.mMultiImageView.setUrlData(this.mUrl);
        this.mMultiImageView.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mMultiImageView.setItemOnclickListener(this.mOnClickListener);
        this.mMultiImageView.setCurrentItem(calCurrentIndex(), false);
        setTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle() {
        if (this.mUrl != null) {
            String title = String.valueOf(this.mIndex + 1);
            this.mTextView.setText(String.valueOf(String.valueOf(title) + "/") + this.mUrl.size());
        }
    }

    private int calCurrentIndex() {
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
            return;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.mUrl = intent.getStringArrayListExtra("url");
            this.mIndex = intent.getIntExtra("index", -1);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("url", this.mUrl);
        outState.putInt("index", this.mIndex);
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
}
