package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonInfoActivity personInfoActivity) {
        this.f2332a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        com.baidu.tieba.model.bx bxVar;
        Boolean bool;
        com.baidu.tieba.model.bx bxVar2;
        com.baidu.tieba.model.bx bxVar3;
        com.baidu.tieba.model.bx bxVar4;
        com.baidu.tieba.model.bx bxVar5;
        BaseFragmentActivity baseFragmentActivity;
        com.baidu.tieba.model.bx bxVar6;
        com.baidu.tieba.model.bx bxVar7;
        com.baidu.tieba.model.bx bxVar8;
        bxVar = this.f2332a.e;
        if (bxVar.getLoadDataMode() != 1) {
            bxVar6 = this.f2332a.e;
            if (bxVar6.getLoadDataMode() != 2) {
                bxVar7 = this.f2332a.e;
                if (bxVar7.getLoadDataMode() == 3 && this.f2332a.b != null) {
                    bi biVar = this.f2332a.b;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bxVar8 = this.f2332a.e;
                    biVar.a(booleanValue, bxVar8);
                    return;
                }
                return;
            }
        }
        if (TiebaApplication.h().t()) {
            baseFragmentActivity = this.f2332a.g;
            StatService.onEvent(baseFragmentActivity, "person_info_pv", "infopv", 1);
        }
        bool = this.f2332a.f;
        if (bool.booleanValue()) {
            if (this.f2332a.f2296a != null) {
                bj bjVar = this.f2332a.f2296a;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                bxVar4 = this.f2332a.e;
                bxVar5 = this.f2332a.e;
                bjVar.a(booleanValue2, bxVar4, bxVar5.getLoadDataMode());
            }
        } else if (this.f2332a.b != null) {
            bi biVar2 = this.f2332a.b;
            boolean booleanValue3 = ((Boolean) obj).booleanValue();
            bxVar2 = this.f2332a.e;
            bxVar3 = this.f2332a.e;
            biVar2.a(booleanValue3, bxVar2, bxVar3.getLoadDataMode());
        }
    }
}
