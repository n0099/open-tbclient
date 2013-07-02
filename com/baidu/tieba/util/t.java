package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements BaiduAccount.CallbackListener {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        NetWorkCore netWorkCore;
        netWorkCore = this.a.c;
        netWorkCore.b(TiebaApplication.f().getString(R.string.error_unkown));
    }
}
