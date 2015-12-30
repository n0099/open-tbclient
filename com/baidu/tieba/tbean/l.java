package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements NoNetworkView.a {
    final /* synthetic */ j dKq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dKq = jVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        BuyTBeanActivity buyTBeanActivity2;
        if (z) {
            buyTBeanActivity = this.dKq.dJV;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.dKq.dJV;
                buyTBeanActivity2.refresh();
            }
        }
    }
}
