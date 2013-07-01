package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteImageActivity writeImageActivity) {
        this.f1571a = writeImageActivity;
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
        z = this.f1571a.z;
        if (!z) {
            i = this.f1571a.A;
            if (i == 1200003) {
                Intent intent = new Intent();
                progressBar = this.f1571a.j;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.f1571a.y;
                    if (z2) {
                        bitmap = this.f1571a.r;
                        if (bitmap != null) {
                            bitmap2 = this.f1571a.r;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                d = this.f1571a.d(str);
                                if (d) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                                this.f1571a.setResult(-1, intent);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                    this.f1571a.setResult(-1, intent);
                } else {
                    return;
                }
            } else {
                this.f1571a.setResult(0, new Intent());
            }
        } else {
            this.f1571a.setResult(0, new Intent());
        }
        this.f1571a.finish();
    }
}
