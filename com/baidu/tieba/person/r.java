package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(EditHeadActivity editHeadActivity) {
        this.f2288a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.f2288a.o;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.f2288a.h;
            if (bitmap == null) {
                bitmap2 = this.f2288a.x;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.f2288a.E = false;
                this.f2288a.a(view.getTag().toString());
            }
        }
    }
}
