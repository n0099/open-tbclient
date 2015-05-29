package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i buE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.buE = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.m
    public void WC() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.buE.buD;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.buE.buD;
        i = this.buE.index;
        aoVar2.delete(i);
    }
}
