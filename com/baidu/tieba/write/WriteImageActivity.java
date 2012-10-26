package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.util.FileHelper;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity {
    public static String DELET_FLAG = "delete";
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private Button mBack = null;
    private Button mDelete = null;
    private LinearLayout mTitle = null;
    private ProgressBar mProgress = null;
    private GetImageTask mTask = null;

    public static void startActivityForResult(Activity activity, Bitmap bm) {
        if (bm != null) {
            Intent intent = new Intent(activity, WriteImageActivity.class);
            activity.startActivityForResult(intent, RequestResponseCode.REQUEST_IMAGE_VIEW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TiebaApplication.app.addRemoteActivity(this);
        setContentView(R.layout.write_image_activity);
        initUI();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable dr = this.mImage.getDrawable();
        if (dr != null && (dr instanceof BitmapDrawable) && ((BitmapDrawable) dr).getBitmap() == null && this.mTask == null) {
            this.mTask = new GetImageTask(this, null);
            this.mTask.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.BaseActivity
    public void releaseResouce() {
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mImage.setImageBitmap(null);
    }

    private void initData() {
        this.mTask = new GetImageTask(this, null);
        this.mTask.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        this.mProgress.setVisibility(8);
        TiebaApplication.app.delRemoteActivity(this);
    }

    private void initUI() {
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WriteImageActivity.this.mTitle.getVisibility() == 0) {
                    WriteImageActivity.this.mTitle.setVisibility(8);
                } else {
                    WriteImageActivity.this.mTitle.setVisibility(0);
                }
            }
        });
        this.mImage.setImageBitmap(this.mBitmap);
        this.mTitle = (LinearLayout) findViewById(R.id.title);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteImageActivity.this.finish();
            }
        });
        this.mDelete = (Button) findViewById(R.id.delete);
        this.mDelete.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(WriteImageActivity.DELET_FLAG, true);
                WriteImageActivity.this.setResult(-1, intent);
                WriteImageActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<Object, Integer, Bitmap> {
        private GetImageTask() {
        }

        /* synthetic */ GetImageTask(WriteImageActivity writeImageActivity, GetImageTask getImageTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... params) {
            Bitmap bitmap = FileHelper.getImage(null, Config.IMAGE_RESIZED_FILE);
            if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                return null;
            }
            return bitmap;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        public void cancel() {
            WriteImageActivity.this.mTask = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            super.onPostExecute((GetImageTask) result);
            WriteImageActivity.this.mTask = null;
            WriteImageActivity.this.mBitmap = result;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (result != null) {
                WriteImageActivity.this.mImage.setImageBitmap(result);
            }
        }
    }
}
