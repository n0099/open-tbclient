package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements View.OnClickListener {
    final /* synthetic */ fn esm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(fn fnVar) {
        this.esm = fnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        int i;
        if (com.baidu.adp.lib.util.i.hk()) {
            this.esm.aMb();
            i = this.esm.esi;
            view.setTag(Boolean.valueOf(i == 0));
        }
        onClickListener = this.esm.esj;
        if (onClickListener != null) {
            onClickListener2 = this.esm.esj;
            onClickListener2.onClick(view);
        }
    }
}
