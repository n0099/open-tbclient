package com.baidu.tieba.personPolymeric.b;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.view.v {
    final /* synthetic */ ab etS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.etS = abVar;
    }

    @Override // com.baidu.tieba.view.v
    public void onScrollStateChanged(AbsListView absListView, int i) {
        af afVar;
        af afVar2;
        af afVar3;
        afVar = this.etS.etO;
        if (afVar != null) {
            afVar2 = this.etS.etO;
            if (afVar2.etU != null) {
                afVar3 = this.etS.etO;
                afVar3.etU.onScrollStateChanged(absListView, i);
            }
        }
    }

    @Override // com.baidu.tieba.view.v
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        af afVar;
        af afVar2;
        af afVar3;
        afVar = this.etS.etO;
        if (afVar != null) {
            afVar2 = this.etS.etO;
            if (afVar2.etU != null) {
                afVar3 = this.etS.etO;
                afVar3.etU.onScroll(absListView, i, i2, i3);
            }
        }
    }
}
