package com.baidu.tieba.write;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.f1563a = writeActivity;
    }

    @Override // com.baidu.tieba.at
    public void a(int i, String str, Address address) {
        this.f1563a.H = address;
        this.f1563a.d();
    }
}
