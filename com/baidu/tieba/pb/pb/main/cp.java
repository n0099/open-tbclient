package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(ch chVar) {
        this.bOF = chVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.bOF.bOc = (String) compoundButton.getTag();
        }
    }
}
