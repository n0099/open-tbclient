package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.k();
    }
}
