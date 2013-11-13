package com.baidu.tieba.pb;

import android.widget.CompoundButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cp cpVar) {
        this.f2126a = cpVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f2126a.ad = (String) compoundButton.getTag();
        }
    }
}
