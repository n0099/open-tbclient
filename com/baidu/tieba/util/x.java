package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BaiduAccount.CallbackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f1812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.f1812a = vVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        s sVar;
        sVar = this.f1812a.f1810a;
        sVar.b(TiebaApplication.g().getString(R.string.error_unkown));
    }
}
