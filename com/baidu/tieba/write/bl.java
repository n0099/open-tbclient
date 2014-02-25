package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Date;
/* loaded from: classes.dex */
class bl implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteImageActivity writeImageActivity) {
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
        boolean b;
        z = this.a.y;
        if (!z) {
            i = this.a.z;
            if (i == 12003) {
                Intent intent = new Intent();
                progressBar = this.a.g;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.a.x;
                    if (z2) {
                        bitmap = this.a.p;
                        if (bitmap != null) {
                            bitmap2 = this.a.p;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                b = this.a.b(str);
                                if (b) {
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
