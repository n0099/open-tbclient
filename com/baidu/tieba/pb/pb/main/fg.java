package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements View.OnClickListener {
    final /* synthetic */ fe emz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(fe feVar) {
        this.emz = feVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        int i;
        if (com.baidu.adp.lib.util.i.hk()) {
            this.emz.aLf();
            i = this.emz.emv;
            view.setTag(Boolean.valueOf(i == 0));
        }
        onClickListener = this.emz.emw;
        if (onClickListener != null) {
            onClickListener2 = this.emz.emw;
            onClickListener2.onClick(view);
        }
    }
}
