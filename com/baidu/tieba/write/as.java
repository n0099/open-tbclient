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
        z = this.a.y;
        if (z) {
            z3 = this.a.x;
            if (z3) {
                bitmap3 = this.a.q;
                if (bitmap3 != null) {
                    bitmap4 = this.a.q;
                    if (!bitmap4.isRecycled()) {
                        String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                        d2 = this.a.d(str);
                        if (d2) {
                            Intent intent = this.a.getIntent();
                            if (intent.getStringExtra("threadid") == null) {
                                WriteActivity.a(this.a, intent.getStringExtra("forumid"), intent.getStringExtra("foruimname"), null, true, str);
                            } else {
                                WriteActivity.a(this.a, intent.getStringExtra("forumid"), intent.getStringExtra("foruimname"), intent.getStringExtra("threadid"), str);
                            }
                        }
                    }
                }
            } else {
                Intent intent2 = this.a.getIntent();
                if (intent2.getStringExtra("threadid") == null) {
                    WriteActivity.a(this.a, intent2.getStringExtra("forumid"), intent2.getStringExtra("foruimname"), null, true, null);
                } else {
                    WriteActivity.a(this.a, intent2.getStringExtra("forumid"), intent2.getStringExtra("foruimname"), intent2.getStringExtra("threadid"), null);
                }
            }
            this.a.setResult(-1, new Intent());
        } else {
            i = this.a.z;
            if (i == 1200003) {
                Intent intent3 = new Intent();
                intent3.putExtra("delete", true);
                this.a.setResult(-1, intent3);
            } else {
                Intent intent4 = new Intent();
                z2 = this.a.x;
                if (z2) {
                    bitmap = this.a.q;
                    if (bitmap != null) {
                        bitmap2 = this.a.q;
                        if (!bitmap2.isRecycled()) {
                            String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            d = this.a.d(str2);
                            if (d) {
                                intent4.putExtra("change", true);
                                intent4.putExtra("file_name", str2);
                            } else {
                                intent4.putExtra("change", false);
                            }
                        }
                    }
                    intent4.putExtra("change", false);
                } else {
                    intent4.setData(this.a.getIntent().getData());
                    this.a.setResult(-1, intent4);
                }
                this.a.setResult(-1, intent4);
            }
        }
        this.a.finish();
    }
}
