package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ap f2488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.f2488a = apVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        ai aiVar;
        aiVar = this.f2488a.f2486a;
        aiVar.c(TiebaApplication.g().getString(R.string.error_unkown));
    }
}
