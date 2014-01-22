package com.baidu.tieba.pb;

import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements com.baidu.tieba.editortool.t {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        String str;
        cr crVar;
        cr crVar2;
        String str2;
        cr crVar3;
        cr crVar4;
        String str3;
        boolean a;
        cr crVar5;
        com.baidu.tieba.model.bm bmVar;
        boolean a2;
        boolean a3;
        cr crVar6;
        cr crVar7;
        cr crVar8;
        boolean a4;
        cr crVar9;
        if (i == 0) {
            a4 = this.a.a(11025);
            if (a4) {
                NewPbActivity newPbActivity = this.a;
                crVar9 = this.a.A;
                newPbActivity.B = crVar9.ae();
                AtListActivity.a(this.a, 12004);
            }
        } else if (i == 7) {
            crVar7 = this.a.A;
            if (!crVar7.F()) {
                crVar8 = this.a.A;
                crVar8.E();
                return;
            }
            WriteImageActivity.a(this.a, 12003);
        } else if (i == 26) {
            a3 = this.a.a(11026);
            if (a3) {
                NewPbActivity newPbActivity2 = this.a;
                crVar6 = this.a.A;
                newPbActivity2.B = crVar6.ae();
                AtListActivity.a(this.a, 12005);
            }
        } else if (i == 10) {
            bmVar = this.a.u;
            if (bmVar.l() != null) {
                a2 = this.a.a(11001);
                if (a2) {
                    this.a.a((String) null);
                }
            }
        } else if (i == 27) {
            a = this.a.a(11027);
            if (a) {
                crVar5 = this.a.A;
                this.a.a(crVar5.L());
            }
        } else if (i == 4) {
            str = this.a.m;
            if (str != null) {
                str2 = this.a.m;
                if (str2.length() > 0) {
                    crVar3 = this.a.A;
                    crVar3.c(false);
                    crVar4 = this.a.A;
                    crVar4.d(false);
                    NewPbActivity newPbActivity3 = this.a;
                    str3 = this.a.m;
                    newPbActivity3.showToast(str3);
                    return;
                }
            }
            crVar = this.a.A;
            crVar.c(true);
            crVar2 = this.a.A;
            crVar2.d(true);
        } else if (i == 22) {
            com.baidu.tieba.write.bb.a(this.a);
        } else if (i == 23) {
            com.baidu.tieba.write.bb.b(this.a);
        }
    }
}
