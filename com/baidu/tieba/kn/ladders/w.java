package com.baidu.tieba.kn.ladders;

import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnTabActivity f1761a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(KnTabActivity knTabActivity) {
        this.f1761a = knTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1761a.finish();
    }
}
