package com.baidu.tieba.pb;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1526a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bo boVar) {
        this.f1526a = boVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1526a.ao = (String) compoundButton.getTag();
        }
    }
}
