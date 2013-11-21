package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImageActivity f2673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteImageActivity writeImageActivity) {
        this.f2673a = writeImageActivity;
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
        z = this.f2673a.y;
        if (!z) {
            i = this.f2673a.z;
            if (i == 12003) {
                Intent intent = new Intent();
                progressBar = this.f2673a.g;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.f2673a.x;
                    if (z2) {
                        bitmap = this.f2673a.p;
                        if (bitmap != null) {
                            bitmap2 = this.f2673a.p;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + Util.PHOTO_DEFAULT_EXT;
                                b = this.f2673a.b(str);
                                if (b) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                                this.f2673a.setResult(-1, intent);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                    this.f2673a.setResult(-1, intent);
                } else {
                    return;
                }
            } else {
                this.f2673a.setResult(0, new Intent());
            }
        } else {
            this.f2673a.setResult(0, new Intent());
        }
        this.f2673a.finish();
    }
}
