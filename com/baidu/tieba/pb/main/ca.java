package com.baidu.tieba.pb.main;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.a.az = (String) compoundButton.getTag();
        }
    }
}
