package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ad {
    final /* synthetic */ j cvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.cvh = jVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void au(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        if (z) {
            buyTBeanActivity = this.cvh.cuK;
            buyTBeanActivity.refresh();
        }
    }
}
