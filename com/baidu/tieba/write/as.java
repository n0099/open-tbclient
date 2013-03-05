package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        ProgressBar progressBar;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean d;
        z = this.a.z;
        if (!z) {
            i = this.a.A;
            if (i == 1200003) {
                Intent intent = new Intent();
                progressBar = this.a.j;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.a.y;
                    if (z2) {
                        bitmap = this.a.r;
                        if (bitmap != null) {
                            bitmap2 = this.a.r;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                d = this.a.d(str);
                                if (d) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                                this.a.setResult(-1, intent);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                    this.a.setResult(-1, intent);
                } else {
                    return;
                }
            } else {
                this.a.setResult(0, new Intent());
            }
        } else {
            this.a.setResult(0, new Intent());
        }
        this.a.finish();
    }
}
