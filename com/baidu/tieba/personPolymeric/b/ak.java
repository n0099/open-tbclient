package com.baidu.tieba.personPolymeric.b;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.view.z {
    final /* synthetic */ aj eLE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.eLE = ajVar;
    }

    @Override // com.baidu.tieba.view.z
    public void onScrollStateChanged(AbsListView absListView, int i) {
        as asVar;
        as asVar2;
        as asVar3;
        asVar = this.eLE.bwG;
        if (asVar != null) {
            asVar2 = this.eLE.bwG;
            if (asVar2.eLJ != null) {
                asVar3 = this.eLE.bwG;
                asVar3.eLJ.onScrollStateChanged(absListView, i);
            }
        }
        if (i != 0) {
            this.eLE.Tw();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        as asVar;
        as asVar2;
        as asVar3;
        asVar = this.eLE.bwG;
        if (asVar != null) {
            asVar2 = this.eLE.bwG;
            if (asVar2.eLJ != null) {
                asVar3 = this.eLE.bwG;
                asVar3.eLJ.onScroll(absListView, i, i2, i3);
            }
        }
    }
}
