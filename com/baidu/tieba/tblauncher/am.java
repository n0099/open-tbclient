package com.baidu.tieba.tblauncher;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ al cbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.cbF = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        com.baidu.tbadk.mainTab.e eVar;
        com.baidu.tbadk.mainTab.e eVar2;
        View.OnClickListener onClickListener2;
        onClickListener = this.cbF.mOnClickListener;
        if (onClickListener != null) {
            onClickListener2 = this.cbF.mOnClickListener;
            onClickListener2.onClick(view);
        }
        eVar = this.cbF.cbw;
        if (eVar != null) {
            eVar2 = this.cbF.cbw;
            eVar2.onClick();
        }
        this.cbF.aiN();
        this.cbF.aiO();
    }
}
