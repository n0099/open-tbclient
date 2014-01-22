package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements BaiduAccount.CallbackListener {
    final /* synthetic */ ax a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.a = axVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        al alVar;
        alVar = this.a.a;
        alVar.c(TiebaApplication.h().getString(R.string.error_unkown));
    }
}
