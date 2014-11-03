package com.baidu.tieba.personInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.bER = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        v vVar;
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        vVar = this.bER.bEG;
        int f = com.baidu.adp.lib.g.c.f(vVar.getId(), -1);
        if (f > 0) {
            dVar = this.bER.bEF;
            if (dVar.getMaskType() == 1) {
                dVar3 = this.bER.bEF;
                dVar3.removeFromBlackList(f);
            } else {
                dVar2 = this.bER.bEF;
                dVar2.addToBlackList(f);
            }
        }
        aVar.dismiss();
    }
}
