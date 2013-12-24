package com.baidu.tieba.pb;

import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.tieba.editortool.h {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.editortool.h
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
        cr crVar9;
        cr crVar10;
        boolean a4;
        cr crVar11;
        if (i == 0) {
            a4 = this.a.a(11025);
            if (a4) {
                NewPbActivity newPbActivity = this.a;
                crVar11 = this.a.x;
                newPbActivity.y = crVar11.ae();
                AtListActivity.a(this.a, 12004);
            }
        } else if (i == 7) {
            crVar7 = this.a.x;
            if (!crVar7.E()) {
                crVar10 = this.a.x;
                crVar10.D();
            } else {
                NewPbActivity newPbActivity2 = this.a;
                crVar8 = this.a.x;
                WriteImageActivity.a(newPbActivity2, crVar8.F(), 12003);
            }
            crVar9 = this.a.x;
            crVar9.e(false);
        } else if (i == 26) {
            a3 = this.a.a(11026);
            if (a3) {
                NewPbActivity newPbActivity3 = this.a;
                crVar6 = this.a.x;
                newPbActivity3.y = crVar6.ae();
                AtListActivity.a(this.a, 12005);
            }
        } else if (i == 10) {
            bmVar = this.a.r;
            if (bmVar.l() != null) {
                a2 = this.a.a(11001);
                if (a2) {
                    this.a.a((String) null);
                }
            }
        } else if (i == 27) {
            a = this.a.a(11027);
            if (a) {
                crVar5 = this.a.x;
                this.a.a(crVar5.L());
            }
        } else if (i == 4) {
            str = this.a.k;
            if (str != null) {
                str2 = this.a.k;
                if (str2.length() > 0) {
                    crVar3 = this.a.x;
                    crVar3.c(false);
                    crVar4 = this.a.x;
                    crVar4.d(false);
                    NewPbActivity newPbActivity4 = this.a;
                    str3 = this.a.k;
                    newPbActivity4.showToast(str3);
                    return;
                }
            }
            crVar = this.a.x;
            crVar.c(true);
            crVar2 = this.a.x;
            crVar2.d(true);
        } else if (i == 22) {
            com.baidu.tieba.write.bd.a(this.a);
        } else if (i == 23) {
            com.baidu.tieba.write.bd.b(this.a);
        }
    }
}
