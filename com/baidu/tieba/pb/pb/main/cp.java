package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.bOG.bOd = (String) compoundButton.getTag();
        }
    }
}
