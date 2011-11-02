package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.util.BitmapHelper;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity {
    public static Bitmap GlobalBitmap = null;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private Button mTurnLeft = null;
    private Button mTurnRight = null;
    private Button mBack = null;
    private Button mDelete = null;
    private LinearLayout mTitle = null;
    private RelativeLayout mTools = null;

    public static void startActivityForResult(Activity activity, Bitmap bm) {
        if (bm != null) {
            GlobalBitmap = bm;
            Intent intent = new Intent(activity, WriteImageActivity.class);
            activity.startActivityForResult(intent, WriteUtil.REQUEST_IMAGE_VIEW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_image_activity);
        initData();
        initUI();
    }

    private void initData() {
        this.mBitmap = GlobalBitmap;
        setResult(-1, null);
    }

    private void initUI() {
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WriteImageActivity.this.mTitle.getVisibility() == 0) {
                    WriteImageActivity.this.mTitle.setVisibility(8);
                    WriteImageActivity.this.mTools.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mTitle.setVisibility(0);
            }
        });
        this.mImage.setImageBitmap(this.mBitmap);
        this.mTitle = (LinearLayout) findViewById(R.id.title);
        this.mTools = (RelativeLayout) findViewById(R.id.tools);
        this.mTools.setVisibility(8);
        this.mTurnLeft = (Button) findViewById(R.id.turn_left);
        this.mTurnLeft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, -90.0f);
                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                WriteImageActivity.GlobalBitmap = WriteImageActivity.this.mBitmap;
            }
        });
        this.mTurnRight = (Button) findViewById(R.id.turn_right);
        this.mTurnRight.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, 90.0f);
                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                WriteImageActivity.GlobalBitmap = WriteImageActivity.this.mBitmap;
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteImageActivity.this.finish();
            }
        });
        this.mDelete = (Button) findViewById(R.id.delete);
        this.mDelete.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WriteImageActivity.GlobalBitmap = null;
                WriteImageActivity.this.finish();
            }
        });
    }
}
