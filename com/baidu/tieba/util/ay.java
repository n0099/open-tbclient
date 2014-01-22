package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements BaiduAccount.CallbackListener {
    final /* synthetic */ ax a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.a = axVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        this.a.x();
    }
}
