package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1335a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.f1335a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.bi biVar;
        com.baidu.tieba.model.bi biVar2;
        com.baidu.tieba.model.bi biVar3;
        com.baidu.tieba.model.bi biVar4;
        com.baidu.tieba.model.bi biVar5;
        com.baidu.tieba.model.bi biVar6;
        biVar = this.f1335a.b;
        if (biVar.getLoadDataMode() != 1) {
            biVar4 = this.f1335a.b;
            if (biVar4.getLoadDataMode() != 2) {
                biVar5 = this.f1335a.b;
                if (biVar5.getLoadDataMode() == 3) {
                    bb bbVar = this.f1335a.f1304a;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    biVar6 = this.f1335a.b;
                    bbVar.a(booleanValue, biVar6);
                    return;
                }
                return;
            }
        }
        bb bbVar2 = this.f1335a.f1304a;
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        biVar2 = this.f1335a.b;
        biVar3 = this.f1335a.b;
        bbVar2.a(booleanValue2, biVar2, biVar3.getLoadDataMode());
    }
}
