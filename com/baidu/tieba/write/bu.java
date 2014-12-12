package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    private final /* synthetic */ String Pl;
    final /* synthetic */ WriteImageActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(WriteImageActivity writeImageActivity, String str, int i) {
        this.this$0 = writeImageActivity;
        this.Pl = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            imageView = this.this$0.akv;
            bitmap = this.this$0.mBitmap;
            imageView.setImageBitmap(bitmap);
            this.this$0.Pg = false;
            this.this$0.de(this.Pl);
            this.this$0.Pc = this.val$id;
        }
    }
}
