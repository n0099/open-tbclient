package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ImagePbActivity imagePbActivity) {
        this.f2193a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2193a.e();
    }
}
