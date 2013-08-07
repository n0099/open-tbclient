package com.baidu.tieba.person;

import com.baidu.tieba.model.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.f1585a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bn bnVar5;
        bn bnVar6;
        bnVar = this.f1585a.b;
        if (bnVar.getLoadDataMode() != 1) {
            bnVar4 = this.f1585a.b;
            if (bnVar4.getLoadDataMode() != 2) {
                bnVar5 = this.f1585a.b;
                if (bnVar5.getLoadDataMode() == 3) {
                    bb bbVar = this.f1585a.f1555a;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bnVar6 = this.f1585a.b;
                    bbVar.a(booleanValue, bnVar6);
                    return;
                }
                return;
            }
        }
        bb bbVar2 = this.f1585a.f1555a;
        boolean booleanValue2 = ((Boolean) obj).booleanValue();
        bnVar2 = this.f1585a.b;
        bnVar3 = this.f1585a.b;
        bbVar2.a(booleanValue2, bnVar2, bnVar3.getLoadDataMode());
    }
}
