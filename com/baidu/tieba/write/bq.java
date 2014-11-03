package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        ProgressBar progressBar;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean hK;
        z = this.this$0.bwW;
        if (!z) {
            i = this.this$0.JW;
            if (i == 12003) {
                Intent intent = new Intent();
                progressBar = this.this$0.mProgress;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.this$0.JV;
                    if (z2) {
                        bitmap = this.this$0.JO;
                        if (bitmap != null) {
                            bitmap2 = this.this$0.JO;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                hK = this.this$0.hK(str);
                                if (hK) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                                this.this$0.setResult(-1, intent);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                    this.this$0.setResult(-1, intent);
                } else {
                    return;
                }
            } else {
                this.this$0.setResult(0, new Intent());
            }
        } else {
            this.this$0.setResult(0, new Intent());
        }
        this.this$0.finish();
    }
}
