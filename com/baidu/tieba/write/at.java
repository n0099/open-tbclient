package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteImageActivity writeImageActivity) {
        this.f1572a = writeImageActivity;
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
        z = this.f1572a.z;
        if (!z) {
            i = this.f1572a.A;
            if (i == 1200003) {
                Intent intent = new Intent();
                intent.putExtra("delete", true);
                this.f1572a.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                z2 = this.f1572a.y;
                if (z2) {
                    bitmap = this.f1572a.r;
                    if (bitmap != null) {
                        bitmap2 = this.f1572a.r;
                        if (!bitmap2.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            d = this.f1572a.d(str);
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
                    intent2.setData(this.f1572a.getIntent().getData());
                    this.f1572a.setResult(-1, intent2);
                }
                this.f1572a.setResult(-1, intent2);
            }
            this.f1572a.finish();
            return;
        }
        Intent intent3 = new Intent();
        z3 = this.f1572a.y;
        if (z3) {
            bitmap3 = this.f1572a.r;
            if (bitmap3 != null) {
                bitmap4 = this.f1572a.r;
                if (!bitmap4.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    d2 = this.f1572a.d(str2);
                    if (d2) {
                        intent3.putExtra("filename", str2);
                    }
                }
            }
        }
        this.f1572a.setResult(-1, intent3);
        this.f1572a.finish();
    }
}
