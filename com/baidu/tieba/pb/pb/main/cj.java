package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ cb cgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cb cbVar) {
        this.cgg = cbVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.cgg.cfE = (String) compoundButton.getTag();
        }
    }
}
