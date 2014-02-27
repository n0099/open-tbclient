package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        int i;
        Intent intent;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean a;
        boolean z3;
        Bitmap bitmap3;
        Bitmap bitmap4;
        boolean a2;
        z = this.a.y;
        if (!z) {
            i = this.a.z;
            if (i == 12003) {
                intent = new Intent();
                intent.putExtra("delete", true);
            } else {
                intent = new Intent();
                z2 = this.a.x;
                if (z2) {
                    bitmap = this.a.p;
                    if (bitmap != null) {
                        bitmap2 = this.a.p;
                        if (!bitmap2.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            a = this.a.a(str);
                            if (a) {
                                intent.putExtra("change", true);
                                intent.putExtra("file_name", str);
                            } else {
                                intent.putExtra("change", false);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                } else {
                    intent.setData(this.a.getIntent().getData());
                    this.a.setResult(-1, intent);
                }
            }
            this.a.setResult(-1, intent);
        } else {
            Intent intent2 = new Intent();
            z3 = this.a.x;
            if (z3) {
                bitmap3 = this.a.p;
                if (bitmap3 != null) {
                    bitmap4 = this.a.p;
                    if (!bitmap4.isRecycled()) {
                        String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                        a2 = this.a.a(str2);
                        if (a2) {
                            intent2.putExtra("filename", str2);
                        }
                    }
                }
            }
            this.a.setResult(-1, intent2);
        }
        this.a.finish();
    }
}
