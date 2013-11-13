package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ eb f2159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(eb ebVar) {
        this.f2159a = ebVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2159a.q();
    }
}
