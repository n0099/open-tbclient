package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f2583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.f2583a = amVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        this.f2583a.w();
    }
}
