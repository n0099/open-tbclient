package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PersonInfoActivity personInfoActivity) {
        this.f2234a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bx bxVar;
        Boolean bool;
        bx bxVar2;
        bx bxVar3;
        bx bxVar4;
        bx bxVar5;
        BaseFragmentActivity baseFragmentActivity;
        bx bxVar6;
        bx bxVar7;
        bx bxVar8;
        bxVar = this.f2234a.e;
        if (bxVar.getLoadDataMode() != 1) {
            bxVar6 = this.f2234a.e;
            if (bxVar6.getLoadDataMode() != 2) {
                bxVar7 = this.f2234a.e;
                if (bxVar7.getLoadDataMode() == 3 && this.f2234a.b != null) {
                    bc bcVar = this.f2234a.b;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bxVar8 = this.f2234a.e;
                    bcVar.a(booleanValue, bxVar8);
                    return;
                }
                return;
            }
        }
        if (TiebaApplication.g().s()) {
            baseFragmentActivity = this.f2234a.g;
            StatService.onEvent(baseFragmentActivity, "person_info_pv", "infopv", 1);
        }
        bool = this.f2234a.f;
        if (bool.booleanValue()) {
            if (this.f2234a.f2203a != null) {
                bd bdVar = this.f2234a.f2203a;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                bxVar4 = this.f2234a.e;
                bxVar5 = this.f2234a.e;
                bdVar.a(booleanValue2, bxVar4, bxVar5.getLoadDataMode());
            }
        } else if (this.f2234a.b != null) {
            bc bcVar2 = this.f2234a.b;
            boolean booleanValue3 = ((Boolean) obj).booleanValue();
            bxVar2 = this.f2234a.e;
            bxVar3 = this.f2234a.e;
            bcVar2.a(booleanValue3, bxVar2, bxVar3.getLoadDataMode());
        }
    }
}
