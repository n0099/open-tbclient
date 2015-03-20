package com.baidu.tieba.imMessageCenter.im.floatwindow.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements m {
    final /* synthetic */ i brC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.brC = iVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.floatwindow.view.m
    public void UY() {
        ao aoVar;
        ao aoVar2;
        int i;
        aoVar = this.brC.brB;
        if (aoVar == null) {
            return;
        }
        aoVar2 = this.brC.brB;
        i = this.brC.index;
        aoVar2.delete(i);
    }
}
