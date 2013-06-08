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
        com.baidu.tieba.c.bi biVar;
        com.baidu.tieba.c.bi biVar2;
        com.baidu.tieba.c.bi biVar3;
        com.baidu.tieba.c.bi biVar4;
        com.baidu.tieba.c.bi biVar5;
        com.baidu.tieba.c.bi biVar6;
        biVar = this.a.d;
        if (biVar.a() != 1) {
            biVar4 = this.a.d;
            if (biVar4.a() != 2) {
                biVar5 = this.a.d;
                if (biVar5.a() == 3) {
                    ba baVar = this.a.c;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    biVar6 = this.a.d;
                    baVar.a(booleanValue, biVar6);
                    return;
                }
                return;
            }
        }
        ba baVar2 = this.a.c;
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        biVar2 = this.a.d;
        biVar3 = this.a.d;
        baVar2.a(booleanValue2, biVar2, biVar3.a());
    }
}
