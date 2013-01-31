package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
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
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean d;
        boolean z3;
        Bitmap bitmap3;
        Bitmap bitmap4;
        boolean d2;
        z = this.a.z;
        if (!z) {
            i = this.a.A;
            if (i == 1200003) {
                Intent intent = new Intent();
                intent.putExtra("delete", true);
                this.a.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                z2 = this.a.y;
                if (z2) {
                    bitmap = this.a.r;
                    if (bitmap != null) {
                        bitmap2 = this.a.r;
                        if (!bitmap2.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            d = this.a.d(str);
                            if (d) {
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
        } else {
            Intent intent3 = new Intent();
            Intent intent4 = this.a.getIntent();
            z3 = this.a.y;
            if (z3) {
                bitmap3 = this.a.r;
                if (bitmap3 != null) {
                    bitmap4 = this.a.r;
                    if (!bitmap4.isRecycled()) {
                        String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                        d2 = this.a.d(str2);
                        if (d2) {
                            if (intent4.getStringExtra("threadid") == null) {
                                intent3.putExtra("filename", str2);
                            } else {
                                WriteActivity.a(this.a, intent4.getStringExtra("forumid"), intent4.getStringExtra("foruimname"), intent4.getStringExtra("threadid"), str2);
                            }
                        }
                    }
                }
            } else if (intent4.getStringExtra("threadid") != null) {
                WriteActivity.a(this.a, intent4.getStringExtra("forumid"), intent4.getStringExtra("foruimname"), intent4.getStringExtra("threadid"), null);
            }
            this.a.setResult(-1, intent3);
        }
        this.a.finish();
    }
}
