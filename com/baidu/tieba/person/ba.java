package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.e {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.bi biVar;
        com.baidu.tieba.model.bi biVar2;
        com.baidu.tieba.model.bi biVar3;
        com.baidu.tieba.model.bi biVar4;
        com.baidu.tieba.model.bi biVar5;
        com.baidu.tieba.model.bi biVar6;
        biVar = this.a.b;
        if (biVar.getLoadDataMode() != 1) {
            biVar4 = this.a.b;
            if (biVar4.getLoadDataMode() != 2) {
                biVar5 = this.a.b;
                if (biVar5.getLoadDataMode() == 3) {
                    bb bbVar = this.a.a;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    biVar6 = this.a.b;
                    bbVar.a(booleanValue, biVar6);
                    return;
                }
                return;
            }
        }
        bb bbVar2 = this.a.a;
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        biVar2 = this.a.b;
        biVar3 = this.a.b;
        bbVar2.a(booleanValue2, biVar2, biVar3.getLoadDataMode());
    }
}
