package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements u {
    final /* synthetic */ j bNX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bNX = jVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        if (z) {
            buyTBeanActivity = this.bNX.bNA;
            buyTBeanActivity.refresh();
        }
    }
}
