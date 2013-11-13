package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ImagePbActivity imagePbActivity) {
        this.f2196a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbActivity imagePbActivity = this.f2196a;
        i = this.f2196a.w;
        imagePbActivity.c(i);
    }
}
