package com.baidu.tieba.pb;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.a.ah = (String) compoundButton.getTag();
        }
    }
}
