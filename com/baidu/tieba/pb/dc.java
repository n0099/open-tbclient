package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements View.OnClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.q();
    }
}
