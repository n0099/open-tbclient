package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1671a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonInfoActivity personInfoActivity) {
        this.f1671a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.model.bo boVar;
        Boolean bool;
        com.baidu.tieba.model.bo boVar2;
        com.baidu.tieba.model.bo boVar3;
        com.baidu.tieba.model.bo boVar4;
        com.baidu.tieba.model.bo boVar5;
        com.baidu.tieba.model.bo boVar6;
        com.baidu.tieba.model.bo boVar7;
        com.baidu.tieba.model.bo boVar8;
        boVar = this.f1671a.d;
        if (boVar.getLoadDataMode() != 1) {
            boVar6 = this.f1671a.d;
            if (boVar6.getLoadDataMode() != 2) {
                boVar7 = this.f1671a.d;
                if (boVar7.getLoadDataMode() == 3 && this.f1671a.b != null) {
                    bg bgVar = this.f1671a.b;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    boVar8 = this.f1671a.d;
                    bgVar.a(booleanValue, boVar8);
                    new Timer().schedule(new bc(this), 300L);
                    return;
                }
                return;
            }
        }
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1671a, "person_info_pv", "infopv", 1);
        }
        bool = this.f1671a.e;
        if (bool.booleanValue()) {
            if (this.f1671a.f1643a != null) {
                bh bhVar = this.f1671a.f1643a;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                boVar4 = this.f1671a.d;
                boVar5 = this.f1671a.d;
                bhVar.a(booleanValue2, boVar4, boVar5.getLoadDataMode());
            }
        } else if (this.f1671a.b != null) {
            bg bgVar2 = this.f1671a.b;
            boolean booleanValue3 = ((Boolean) obj).booleanValue();
            boVar2 = this.f1671a.d;
            boVar3 = this.f1671a.d;
            bgVar2.a(booleanValue3, boVar2, boVar3.getLoadDataMode());
            new Timer().schedule(new ba(this), 300L);
        }
    }
}
