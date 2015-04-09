package com.baidu.tieba.pb.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.bMC.bLZ = (String) compoundButton.getTag();
        }
    }
}
