package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i brS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.brS = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.m
    public void Vl() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.brS.brR;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.brS.brR;
        i = this.brS.index;
        aoVar2.delete(i);
    }
}
