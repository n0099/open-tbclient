package com.baidu.tieba.person;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bw;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f2192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PersonInfoActivity personInfoActivity) {
        this.f2192a = personInfoActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bw bwVar;
        Boolean bool;
        bw bwVar2;
        bw bwVar3;
        bw bwVar4;
        bw bwVar5;
        bw bwVar6;
        bw bwVar7;
        bw bwVar8;
        bwVar = this.f2192a.d;
        if (bwVar.getLoadDataMode() != 1) {
            bwVar6 = this.f2192a.d;
            if (bwVar6.getLoadDataMode() != 2) {
                bwVar7 = this.f2192a.d;
                if (bwVar7.getLoadDataMode() == 3 && this.f2192a.b != null) {
                    bi biVar = this.f2192a.b;
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    bwVar8 = this.f2192a.d;
                    biVar.a(booleanValue, bwVar8);
                    new Timer().schedule(new be(this), 300L);
                    return;
                }
                return;
            }
        }
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2192a, "person_info_pv", "infopv", 1);
        }
        bool = this.f2192a.e;
        if (bool.booleanValue()) {
            if (this.f2192a.f2161a != null) {
                bj bjVar = this.f2192a.f2161a;
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                bwVar4 = this.f2192a.d;
                bwVar5 = this.f2192a.d;
                bjVar.a(booleanValue2, bwVar4, bwVar5.getLoadDataMode());
            }
        } else if (this.f2192a.b != null) {
            bi biVar2 = this.f2192a.b;
            boolean booleanValue3 = ((Boolean) obj).booleanValue();
            bwVar2 = this.f2192a.d;
            bwVar3 = this.f2192a.d;
            biVar2.a(booleanValue3, bwVar2, bwVar3.getLoadDataMode());
            new Timer().schedule(new bc(this), 300L);
        }
    }
}
