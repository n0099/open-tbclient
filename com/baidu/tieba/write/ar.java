package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteImageActivity writeImageActivity) {
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
        z = this.a.y;
        if (z) {
            this.a.setResult(0, new Intent());
        } else {
            i = this.a.z;
            if (i == 1200003) {
                Intent intent = new Intent();
                progressBar = this.a.i;
                if (progressBar.getVisibility() == 0) {
                    return;
                }
                z2 = this.a.x;
                if (z2) {
                    bitmap = this.a.q;
                    if (bitmap != null) {
                        bitmap2 = this.a.q;
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
                this.a.setResult(0, new Intent());
            }
        }
        this.a.finish();
    }
}
