package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.bMm.bLJ = (String) compoundButton.getTag();
        }
    }
}
