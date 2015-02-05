package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ad {
    final /* synthetic */ j ccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.ccp = jVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        if (z) {
            buyTBeanActivity = this.ccp.cbS;
            buyTBeanActivity.refresh();
        }
    }
}
