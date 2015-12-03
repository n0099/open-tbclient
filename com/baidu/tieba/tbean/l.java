package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements NoNetworkView.a {
    final /* synthetic */ j dCO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dCO = jVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        BuyTBeanActivity buyTBeanActivity2;
        if (z) {
            buyTBeanActivity = this.dCO.dCt;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.dCO.dCt;
                buyTBeanActivity2.refresh();
            }
        }
    }
}
