package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ImagePbActivity imagePbActivity) {
        this.f1585a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1585a.b(true);
    }
}
