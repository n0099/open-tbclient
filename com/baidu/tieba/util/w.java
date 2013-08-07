package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.f1775a = uVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        NetWorkCore netWorkCore;
        netWorkCore = this.f1775a.f1773a;
        netWorkCore.b(TiebaApplication.f().getString(R.string.error_unkown));
    }
}
