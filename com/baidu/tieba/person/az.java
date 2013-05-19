package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.a.e {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.c.bf bfVar;
        com.baidu.tieba.c.bf bfVar2;
        com.baidu.tieba.c.bf bfVar3;
        com.baidu.tieba.c.bf bfVar4;
        com.baidu.tieba.c.bf bfVar5;
        com.baidu.tieba.c.bf bfVar6;
        bfVar = this.a.d;
        if (bfVar.a() != 1) {
            bfVar4 = this.a.d;
            if (bfVar4.a() != 2) {
                bfVar5 = this.a.d;
                if (bfVar5.a() == 3) {
                    ba baVar = this.a.c;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bfVar6 = this.a.d;
                    baVar.a(booleanValue, bfVar6);
                    return;
                }
                return;
            }
        }
        ba baVar2 = this.a.c;
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        bfVar2 = this.a.d;
        bfVar3 = this.a.d;
        baVar2.a(booleanValue2, bfVar2, bfVar3.a());
    }
}
