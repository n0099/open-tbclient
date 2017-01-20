package com.baidu.tieba.personPolymeric.b;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.view.v {
    final /* synthetic */ ab eDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.eDM = abVar;
    }

    @Override // com.baidu.tieba.view.v
    public void onScrollStateChanged(AbsListView absListView, int i) {
        af afVar;
        af afVar2;
        af afVar3;
        afVar = this.eDM.eDI;
        if (afVar != null) {
            afVar2 = this.eDM.eDI;
            if (afVar2.eDO != null) {
                afVar3 = this.eDM.eDI;
                afVar3.eDO.onScrollStateChanged(absListView, i);
            }
        }
    }

    @Override // com.baidu.tieba.view.v
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        af afVar;
        af afVar2;
        af afVar3;
        afVar = this.eDM.eDI;
        if (afVar != null) {
            afVar2 = this.eDM.eDI;
            if (afVar2.eDO != null) {
                afVar3 = this.eDM.eDI;
                afVar3.eDO.onScroll(absListView, i, i2, i3);
            }
        }
    }
}
