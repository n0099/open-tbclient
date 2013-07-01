package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f1469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.f1469a = rVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        NetWorkCore netWorkCore;
        netWorkCore = this.f1469a.f1467a;
        netWorkCore.b(TiebaApplication.f().getString(R.string.error_unkown));
    }
}
