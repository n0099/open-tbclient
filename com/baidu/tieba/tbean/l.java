package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements NoNetworkView.a {
    final /* synthetic */ j eav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.eav = jVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        BuyTBeanActivity buyTBeanActivity2;
        if (z) {
            buyTBeanActivity = this.eav.eaa;
            if (buyTBeanActivity != null) {
                buyTBeanActivity2 = this.eav.eaa;
                buyTBeanActivity2.refresh();
            }
        }
    }
}
