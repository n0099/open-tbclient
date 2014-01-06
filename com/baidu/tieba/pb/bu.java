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
        cs csVar;
        cs csVar2;
        String str2;
        cs csVar3;
        cs csVar4;
        String str3;
        boolean a;
        cs csVar5;
        com.baidu.tieba.model.bm bmVar;
        boolean a2;
        boolean a3;
        cs csVar6;
        cs csVar7;
        cs csVar8;
        boolean a4;
        cs csVar9;
        if (i == 0) {
            a4 = this.a.a(11025);
            if (a4) {
                NewPbActivity newPbActivity = this.a;
                csVar9 = this.a.z;
                newPbActivity.A = csVar9.ae();
                AtListActivity.a(this.a, 12004);
            }
        } else if (i == 7) {
            csVar7 = this.a.z;
            if (!csVar7.F()) {
                csVar8 = this.a.z;
                csVar8.E();
                return;
            }
            WriteImageActivity.a(this.a, 12003);
        } else if (i == 26) {
            a3 = this.a.a(11026);
            if (a3) {
                NewPbActivity newPbActivity2 = this.a;
                csVar6 = this.a.z;
                newPbActivity2.A = csVar6.ae();
                AtListActivity.a(this.a, 12005);
            }
        } else if (i == 10) {
            bmVar = this.a.t;
            if (bmVar.l() != null) {
                a2 = this.a.a(11001);
                if (a2) {
                    this.a.a((String) null);
                }
            }
        } else if (i == 27) {
            a = this.a.a(11027);
            if (a) {
                csVar5 = this.a.z;
                this.a.a(csVar5.L());
            }
        } else if (i == 4) {
            str = this.a.l;
            if (str != null) {
                str2 = this.a.l;
                if (str2.length() > 0) {
                    csVar3 = this.a.z;
                    csVar3.c(false);
                    csVar4 = this.a.z;
                    csVar4.d(false);
                    NewPbActivity newPbActivity3 = this.a;
                    str3 = this.a.l;
                    newPbActivity3.showToast(str3);
                    return;
                }
            }
            csVar = this.a.z;
            csVar.c(true);
            csVar2 = this.a.z;
            csVar2.d(true);
        } else if (i == 22) {
            com.baidu.tieba.write.bb.a(this.a);
        } else if (i == 23) {
            com.baidu.tieba.write.bb.b(this.a);
        }
    }
}
