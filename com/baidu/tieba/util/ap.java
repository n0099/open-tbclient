package com.baidu.tieba.util;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements BaiduAccount.CallbackListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        ag agVar;
        agVar = this.a.a;
        agVar.c(TiebaApplication.h().getString(R.string.error_unkown));
    }
}
