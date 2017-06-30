package com.baidu.tieba.personPolymeric.b;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tieba.view.z {
    final /* synthetic */ ak eVM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.eVM = akVar;
    }

    @Override // com.baidu.tieba.view.z
    public void onScrollStateChanged(AbsListView absListView, int i) {
        at atVar;
        at atVar2;
        at atVar3;
        atVar = this.eVM.eVH;
        if (atVar != null) {
            atVar2 = this.eVM.eVH;
            if (atVar2.eVR != null) {
                atVar3 = this.eVM.eVH;
                atVar3.eVR.onScrollStateChanged(absListView, i);
            }
        }
        if (i != 0) {
            this.eVM.aVt();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        at atVar;
        at atVar2;
        at atVar3;
        atVar = this.eVM.eVH;
        if (atVar != null) {
            atVar2 = this.eVM.eVH;
            if (atVar2.eVR != null) {
                atVar3 = this.eVM.eVH;
                atVar3.eVR.onScroll(absListView, i, i2, i3);
            }
        }
    }
}
