package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ImagePbActivity imagePbActivity) {
        this.f2191a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2191a.f();
    }
}
