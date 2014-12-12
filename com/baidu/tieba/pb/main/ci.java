package com.baidu.tieba.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.bCR.bCo = (String) compoundButton.getTag();
        }
    }
}
