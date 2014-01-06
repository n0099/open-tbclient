package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean b;
        boolean z3;
        Bitmap bitmap3;
        Bitmap bitmap4;
        boolean b2;
        z = this.a.y;
        if (!z) {
            i = this.a.z;
            if (i == 12003) {
                Intent intent = new Intent();
                intent.putExtra("delete", true);
                this.a.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                z2 = this.a.x;
                if (z2) {
                    bitmap = this.a.p;
                    if (bitmap != null) {
                        bitmap2 = this.a.p;
                        if (!bitmap2.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            b = this.a.b(str);
                            if (b) {
                                intent2.putExtra("change", true);
                                intent2.putExtra("file_name", str);
                            } else {
                                intent2.putExtra("change", false);
                            }
                        }
                    }
                    intent2.putExtra("change", false);
                } else {
                    intent2.setData(this.a.getIntent().getData());
                    this.a.setResult(-1, intent2);
                }
                this.a.setResult(-1, intent2);
            }
            this.a.finish();
            return;
        }
        Intent intent3 = new Intent();
        z3 = this.a.x;
        if (z3) {
            bitmap3 = this.a.p;
            if (bitmap3 != null) {
                bitmap4 = this.a.p;
                if (!bitmap4.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    b2 = this.a.b(str2);
                    if (b2) {
                        intent3.putExtra("filename", str2);
                    }
                }
            }
        }
        this.a.setResult(-1, intent3);
        this.a.finish();
    }
}
