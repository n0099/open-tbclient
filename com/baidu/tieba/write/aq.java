package com.baidu.tieba.write;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tieba.au {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.f2638a = writeActivity;
    }

    @Override // com.baidu.tieba.au
    public void a(int i, String str, Address address) {
        this.f2638a.K = address;
        this.f2638a.p();
    }
}
