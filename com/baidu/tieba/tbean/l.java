package com.baidu.tieba.tbean;

import com.baidu.tbadk.core.view.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements y {
    final /* synthetic */ j crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.crd = jVar;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        BuyTBeanActivity buyTBeanActivity;
        if (z) {
            buyTBeanActivity = this.crd.cqG;
            buyTBeanActivity.refresh();
        }
    }
}
