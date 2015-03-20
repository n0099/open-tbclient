package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    private final /* synthetic */ String bPd;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.bPd = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            imageView = this.this$0.atv;
            bitmap = this.this$0.mBitmap;
            imageView.setImageBitmap(bitmap);
            this.this$0.bOY = false;
            this.this$0.hU(this.bPd);
            this.this$0.bOU = this.val$id;
        }
    }
}
