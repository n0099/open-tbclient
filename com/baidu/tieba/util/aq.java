package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f2487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.f2487a = apVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        this.f2487a.u();
    }
}
