package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f1811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f1811a = vVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        this.f1811a.s();
    }
}
