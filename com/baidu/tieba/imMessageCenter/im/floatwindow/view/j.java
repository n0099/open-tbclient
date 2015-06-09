package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i buF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.buF = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.m
    public void WD() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.buF.buE;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.buF.buE;
        i = this.buF.index;
        aoVar2.delete(i);
    }
}
