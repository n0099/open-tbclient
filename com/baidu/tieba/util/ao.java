package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f2584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.f2584a = amVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        af afVar;
        afVar = this.f2584a.f2582a;
        afVar.c(TiebaApplication.h().getString(R.string.error_unkown));
    }
}
