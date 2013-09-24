package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.f1892a = zVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        s sVar;
        sVar = this.f1892a.f1932a;
        sVar.b(TiebaApplication.g().getString(R.string.error_unkown));
    }
}
