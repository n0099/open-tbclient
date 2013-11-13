package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2227a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonChangeActivity personChangeActivity) {
        this.f2227a = personChangeActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.f2227a.a();
        }
    }
}
