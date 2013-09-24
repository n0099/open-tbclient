package com.baidu.tieba.write;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.an {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.f2093a = writeActivity;
    }

    @Override // com.baidu.tieba.an
    public void a(int i, String str, Address address) {
        this.f2093a.K = address;
        this.f2093a.p();
    }
}
