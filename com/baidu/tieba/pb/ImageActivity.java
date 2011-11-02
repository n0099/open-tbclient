package com.baidu.tieba.pb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.MediaScannerClient;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.view.DragImageView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ImageActivity extends BaseActivity {
    private HashMap<String, byte[]> imageCache;
    private DragImageView mImageView = null;
    private RelativeLayout mTools = null;
    private Button mPrevious = null;
    private Button mNext = null;
    private ProgressBar mProgress = null;
    private ArrayList<String> mUrl = null;
    private int mIndex = -1;
    private volatile byte[] mCurrentByte = null;
    private ImageAsyncTask mTask = null;
    private SaveImageAsyncTask mSaveImageTask = null;
    private Button mSave = null;
    private Button mBack = null;
    private Button mZoomIn = null;
    private Button mZoomOut = null;
    private ProgressBar mLoadProgress = null;
    private LinearLayout mTitle = null;

    static /* synthetic */ int access$608(ImageActivity x0) {
        int i = x0.mIndex;
        x0.mIndex = i + 1;
        return i;
    }

    static /* synthetic */ int access$610(ImageActivity x0) {
        int i = x0.mIndex;
        x0.mIndex = i - 1;
        return i;
    }

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
        setContentView(R.layout.image_activity);
        InitUI();
        InitData(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.imageCache != null) {
            this.imageCache.clear();
            this.imageCache = null;
        }
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        if (this.mSaveImageTask != null) {
            this.mSaveImageTask.cancel();
            this.mSaveImageTask = null;
        }
        this.mImageView.releaseBitmap();
        this.mCurrentByte = null;
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.mLoadProgress != null) {
            this.mLoadProgress.setVisibility(8);
        }
        super.onDestroy();
    }

    private void InitUI() {
        this.mLoadProgress = (ProgressBar) findViewById(R.id.load_progress);
        this.mTitle = (LinearLayout) findViewById(R.id.title);
        this.mZoomIn = (Button) findViewById(R.id.zoomin);
        this.mZoomIn.setEnabled(false);
        this.mZoomOut = (Button) findViewById(R.id.zoomout);
        this.mZoomOut.setEnabled(false);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mImageView = (DragImageView) findViewById(R.id.image);
        this.mImageView.setImageOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                if (ImageActivity.this.mTitle.getVisibility() != 0) {
                    ImageActivity.this.mTitle.setVisibility(0);
                    ImageActivity.this.mTools.setVisibility(0);
                    return;
                }
                ImageActivity.this.mTitle.setVisibility(8);
                ImageActivity.this.mTools.setVisibility(8);
            }
        });
        this.mImageView.setOnSizeChangedListener(new DragImageView.OnSizeChangedListener() { // from class: com.baidu.tieba.pb.ImageActivity.2
            @Override // com.baidu.tieba.view.DragImageView.OnSizeChangedListener
            public void sizeChenged(boolean canZoomIn, boolean canZoomOut) {
                if (canZoomOut) {
                    ImageActivity.this.mZoomOut.setEnabled(true);
                } else {
                    ImageActivity.this.mZoomOut.setEnabled(false);
                }
                if (canZoomIn) {
                    ImageActivity.this.mZoomIn.setEnabled(true);
                } else {
                    ImageActivity.this.mZoomIn.setEnabled(false);
                }
            }
        });
        this.mTools = (RelativeLayout) findViewById(R.id.tools);
        this.mZoomIn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                boolean ret = ImageActivity.this.mImageView.zoomInBitmap();
                if (!ret) {
                    ImageActivity.this.mZoomIn.setEnabled(false);
                }
                ImageActivity.this.mZoomOut.setEnabled(true);
            }
        });
        this.mZoomOut.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                boolean ret = ImageActivity.this.mImageView.zoomOutBitmap();
                if (!ret) {
                    ImageActivity.this.mZoomOut.setEnabled(false);
                }
                ImageActivity.this.mZoomIn.setEnabled(true);
            }
        });
        this.mPrevious = (Button) findViewById(R.id.previous);
        this.mPrevious.setEnabled(false);
        this.mPrevious.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ImageActivity.this.mTask != null) {
                    ImageActivity.this.mTask.cancel();
                    ImageActivity.this.mTask = null;
                }
                if (ImageActivity.this.mIndex > 0) {
                    ImageActivity.access$610(ImageActivity.this);
                    ImageActivity.this.mTask = new ImageAsyncTask();
                    ImageActivity.this.mTask.execute((String) ImageActivity.this.mUrl.get(ImageActivity.this.mIndex));
                }
                ImageActivity.this.mImageView.setImageBitmap(null);
                ImageActivity.this.mCurrentByte = null;
                ImageActivity.this.adjustButton();
            }
        });
        this.mNext = (Button) findViewById(R.id.next);
        this.mNext.setEnabled(false);
        this.mNext.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ImageActivity.this.mTask != null) {
                    ImageActivity.this.mTask.cancel();
                    ImageActivity.this.mTask = null;
                }
                if (ImageActivity.this.mIndex < ImageActivity.this.mUrl.size() - 1) {
                    ImageActivity.access$608(ImageActivity.this);
                    ImageActivity.this.mTask = new ImageAsyncTask();
                    ImageActivity.this.mTask.execute((String) ImageActivity.this.mUrl.get(ImageActivity.this.mIndex));
                }
                ImageActivity.this.mImageView.setImageBitmap(null);
                ImageActivity.this.mCurrentByte = null;
                ImageActivity.this.adjustButton();
            }
        });
        this.mSave = (Button) findViewById(R.id.save);
        this.mSave.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    if (ImageActivity.this.mCurrentByte != null) {
                        String name = (String) ImageActivity.this.mUrl.get(ImageActivity.this.mIndex);
                        ImageActivity.this.mSaveImageTask = new SaveImageAsyncTask(name, ImageActivity.this.mCurrentByte);
                        ImageActivity.this.mSaveImageTask.execute(new String[0]);
                        ImageActivity.this.mSave.setVisibility(4);
                        ImageActivity.this.mProgress.setVisibility(0);
                    } else {
                        ImageActivity.this.showToast(ImageActivity.this.getString(R.string.no_data));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.ImageActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ImageActivity.this.finish();
            }
        });
    }

    private void InitData(Bundle savedInstanceState) {
        this.imageCache = new HashMap<>();
        if (savedInstanceState != null) {
            this.mUrl = savedInstanceState.getStringArrayList("url");
            this.mIndex = savedInstanceState.getInt("index", -1);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.mUrl = intent.getStringArrayListExtra("url");
                this.mIndex = intent.getIntExtra("index", -1);
            }
        }
        if (this.mUrl != null) {
            int num = this.mUrl.size();
            if (this.mIndex >= num) {
                this.mIndex = num - 1;
            }
            if (this.mIndex >= 0 && this.mUrl.get(this.mIndex) != null) {
                this.mTask = new ImageAsyncTask();
                this.mTask.execute(this.mUrl.get(this.mIndex));
            }
        }
        adjustButton();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("url", this.mUrl);
        outState.putInt("index", this.mIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustButton() {
        int num = 0;
        if (this.mUrl != null) {
            num = this.mUrl.size();
        }
        if (num > 0 && this.mIndex < num - 1) {
            this.mNext.setEnabled(true);
        } else {
            this.mNext.setEnabled(false);
        }
        if (this.mIndex > 0) {
            this.mPrevious.setEnabled(true);
        } else {
            this.mPrevious.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageAsyncTask extends AsyncTask<String, Integer, Bitmap> {
        NetWork network;

        private ImageAsyncTask() {
            this.network = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            String url = params[0];
            Bitmap bm = null;
            try {
                byte[] cashData = (byte[]) ImageActivity.this.imageCache.get(url);
                if (cashData != null) {
                    bm = BitmapHelper.Bytes2Bitmap(cashData);
                    ImageActivity.this.mCurrentByte = cashData;
                }
                if (bm == null) {
                    String fullUrl = Config.IMAGE_ADDRESS + url;
                    this.network = new NetWork(fullUrl);
                    this.network.setIsBDImage(true);
                    byte[] data = this.network.getNetData();
                    if (this.network.isRequestSuccess()) {
                        bm = BitmapHelper.Bytes2Bitmap(data);
                    }
                    if (bm != null) {
                        ImageActivity.this.imageCache.put(url, data);
                        ImageActivity.this.mCurrentByte = data;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("ImageAsyncTask2", "doInBackground", "error = " + ex.getMessage());
            }
            return bm;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bm) {
            try {
                if (bm != null) {
                    ImageActivity.this.mImageView.setImageBitmap(bm);
                } else if (this.network != null && !this.network.isRequestSuccess()) {
                    String error = this.network.getErrorString();
                    ImageActivity.this.showToast(error);
                } else {
                    ImageActivity.this.showToast(ImageActivity.this.getString(R.string.pic_parser_error));
                }
            } catch (Exception e) {
            }
            ImageActivity.this.mLoadProgress.setVisibility(8);
            ImageActivity.this.mTask = null;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            ImageActivity.this.mLoadProgress.setVisibility(0);
            super.onPreExecute();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            if (this.network != null) {
                this.network.cancelNetConnect();
            }
            super.cancel(true);
        }
    }

    /* loaded from: classes.dex */
    private class SaveImageAsyncTask extends AsyncTask<String, Integer, String> {
        byte[] mData;
        String mName;

        public SaveImageAsyncTask(String name, byte[] data) {
            this.mName = null;
            this.mData = null;
            this.mName = name;
            this.mData = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... arg0) {
            try {
                if (this.mName != null && this.mName.length() > 0 && this.mData != null) {
                    String sname = null;
                    if (this.mName != null && this.mName.length() > 0) {
                        String sname2 = StringHelper.getUrlDecode(this.mName);
                        sname = sname2.substring(sname2.lastIndexOf("/") + 1).trim();
                    }
                    if (sname == null || sname.length() < 1) {
                        sname = this.mName;
                    }
                    String postfix = null;
                    int index = sname.lastIndexOf(".");
                    if (index != -1) {
                        postfix = sname.substring(index);
                        sname = sname.substring(0, index);
                    }
                    String xfilename = sname + postfix;
                    for (int i = 0; FileHelper.CheckFile(xfilename) && i < 10000; i++) {
                        xfilename = sname + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + postfix;
                    }
                    String xfilename2 = FileHelper.SaveFile(xfilename, this.mData);
                    if (xfilename2 != null) {
                        MediaScannerClient client = new MediaScannerClient(ImageActivity.this);
                        client.saveImage(xfilename2);
                        String notifyStr = ImageActivity.this.getString(R.string.save_to);
                        return notifyStr + xfilename2;
                    }
                    return FileHelper.getSdErrorString();
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
