package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImagePbActivity imagePbActivity) {
        this.f2192a = imagePbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2192a.b(true);
    }
}
