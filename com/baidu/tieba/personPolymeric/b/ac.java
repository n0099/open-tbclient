package com.baidu.tieba.personPolymeric.b;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.view.y {
    final /* synthetic */ ab eCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.eCS = abVar;
    }

    @Override // com.baidu.tieba.view.y
    public void onScrollStateChanged(AbsListView absListView, int i) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        ajVar = this.eCS.eCN;
        if (ajVar != null) {
            ajVar2 = this.eCS.eCN;
            if (ajVar2.eCX != null) {
                ajVar3 = this.eCS.eCN;
                ajVar3.eCX.onScrollStateChanged(absListView, i);
            }
        }
        if (i != 0) {
            this.eCS.aPP();
        }
    }

    @Override // com.baidu.tieba.view.y
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        ajVar = this.eCS.eCN;
        if (ajVar != null) {
            ajVar2 = this.eCS.eCN;
            if (ajVar2.eCX != null) {
                ajVar3 = this.eCS.eCN;
                ajVar3.eCX.onScroll(absListView, i, i2, i3);
            }
        }
    }
}
