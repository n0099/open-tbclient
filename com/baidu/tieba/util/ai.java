package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ag f2420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.f2420a = agVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        z zVar;
        zVar = this.f2420a.f2418a;
        zVar.b(TiebaApplication.g().getString(R.string.error_unkown));
    }
}
