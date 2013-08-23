package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonInfoActivity personInfoActivity) {
        this.f1623a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.bm bmVar;
        Boolean bool;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        com.baidu.tieba.model.bm bmVar5;
        com.baidu.tieba.model.bm bmVar6;
        com.baidu.tieba.model.bm bmVar7;
        com.baidu.tieba.model.bm bmVar8;
        bmVar = this.f1623a.d;
        if (bmVar.getLoadDataMode() != 1) {
            bmVar6 = this.f1623a.d;
            if (bmVar6.getLoadDataMode() != 2) {
                bmVar7 = this.f1623a.d;
                if (bmVar7.getLoadDataMode() == 3 && this.f1623a.b != null) {
                    bh bhVar = this.f1623a.b;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bmVar8 = this.f1623a.d;
                    bhVar.a(booleanValue, bmVar8);
                    new Timer().schedule(new bd(this), 300L);
                    return;
                }
                return;
            }
        }
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this.f1623a, "person_info_pv", "infopv", 1);
        }
        bool = this.f1623a.e;
        if (bool.booleanValue()) {
            if (this.f1623a.f1593a != null) {
                bi biVar = this.f1623a.f1593a;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                bmVar4 = this.f1623a.d;
                bmVar5 = this.f1623a.d;
                biVar.a(booleanValue2, bmVar4, bmVar5.getLoadDataMode());
            }
        } else if (this.f1623a.b != null) {
            bh bhVar2 = this.f1623a.b;
            boolean booleanValue3 = ((Boolean) obj).booleanValue();
            bmVar2 = this.f1623a.d;
            bmVar3 = this.f1623a.d;
            bhVar2.a(booleanValue3, bmVar2, bmVar3.getLoadDataMode());
            new Timer().schedule(new bb(this), 300L);
        }
    }
}
