package com.baidu.tieba.person;

import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.a.g {
    final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.bx bxVar;
        BaseFragmentActivity baseFragmentActivity;
        Boolean bool;
        com.baidu.tieba.model.bx bxVar2;
        com.baidu.tieba.model.bx bxVar3;
        com.baidu.tieba.model.bx bxVar4;
        com.baidu.tieba.model.bx bxVar5;
        com.baidu.tieba.model.bx bxVar6;
        com.baidu.tieba.model.bx bxVar7;
        com.baidu.tieba.model.bx bxVar8;
        bxVar = this.a.d;
        if (bxVar.getLoadDataMode() != 1) {
            bxVar6 = this.a.d;
            if (bxVar6.getLoadDataMode() != 2) {
                bxVar7 = this.a.d;
                if (bxVar7.getLoadDataMode() == 3 && this.a.b != null) {
                    bs bsVar = this.a.b;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bxVar8 = this.a.d;
                    bsVar.a(booleanValue, bxVar8);
                    return;
                }
                return;
            }
        }
        baseFragmentActivity = this.a.g;
        com.baidu.tieba.util.by.a(baseFragmentActivity, "person_info_pv", "infopv", 1, new Object[0]);
        bool = this.a.f;
        if (bool.booleanValue()) {
            if (this.a.a != null) {
                bt btVar = this.a.a;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                bxVar4 = this.a.d;
                bxVar5 = this.a.d;
                btVar.a(booleanValue2, bxVar4, bxVar5.getLoadDataMode());
            }
        } else if (this.a.b != null) {
            bs bsVar2 = this.a.b;
            boolean booleanValue3 = ((Boolean) obj).booleanValue();
            bxVar2 = this.a.d;
            bxVar3 = this.a.d;
            bsVar2.a(booleanValue3, bxVar2, bxVar3.getLoadDataMode());
        }
    }
}
