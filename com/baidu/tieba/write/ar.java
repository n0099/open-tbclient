package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f1888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteImageActivity writeImageActivity) {
        this.f1888a = writeImageActivity;
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
        z = this.f1888a.z;
        if (!z) {
            i = this.f1888a.A;
            if (i == 12003) {
                Intent intent = new Intent();
                progressBar = this.f1888a.j;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.f1888a.y;
                    if (z2) {
                        bitmap = this.f1888a.r;
                        if (bitmap != null) {
                            bitmap2 = this.f1888a.r;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + Util.PHOTO_DEFAULT_EXT;
                                d = this.f1888a.d(str);
                                if (d) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                                this.f1888a.setResult(-1, intent);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                    this.f1888a.setResult(-1, intent);
                } else {
                    return;
                }
            } else {
                this.f1888a.setResult(0, new Intent());
            }
        } else {
            this.f1888a.setResult(0, new Intent());
        }
        this.f1888a.finish();
    }
}
