package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fy implements View.OnClickListener {
    final /* synthetic */ fw eBx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(fw fwVar) {
        this.eBx = fwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        int i;
        if (com.baidu.adp.lib.util.i.hj()) {
            this.eBx.aPZ();
            i = this.eBx.eBt;
            view.setTag(Boolean.valueOf(i == 0));
        }
        onClickListener = this.eBx.eBu;
        if (onClickListener != null) {
            onClickListener2 = this.eBx.eBu;
            onClickListener2.onClick(view);
        }
    }
}
