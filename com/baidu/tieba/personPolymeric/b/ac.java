package com.baidu.tieba.personPolymeric.b;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.view.v {
    final /* synthetic */ ab eJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.eJU = abVar;
    }

    @Override // com.baidu.tieba.view.v
    public void onScrollStateChanged(AbsListView absListView, int i) {
        af afVar;
        af afVar2;
        af afVar3;
        afVar = this.eJU.eJQ;
        if (afVar != null) {
            afVar2 = this.eJU.eJQ;
            if (afVar2.eJX != null) {
                afVar3 = this.eJU.eJQ;
                afVar3.eJX.onScrollStateChanged(absListView, i);
            }
        }
    }

    @Override // com.baidu.tieba.view.v
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        af afVar;
        af afVar2;
        af afVar3;
        afVar = this.eJU.eJQ;
        if (afVar != null) {
            afVar2 = this.eJU.eJQ;
            if (afVar2.eJX != null) {
                afVar3 = this.eJU.eJQ;
                afVar3.eJX.onScroll(absListView, i, i2, i3);
            }
        }
    }
}
