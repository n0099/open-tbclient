package com.baidu.tieba.write;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.ak {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.f1909a = writeActivity;
    }

    @Override // com.baidu.tieba.ak
    public void a(int i, String str, Address address) {
        this.f1909a.H = address;
        this.f1909a.d();
    }
}
