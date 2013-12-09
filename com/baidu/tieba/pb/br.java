package com.baidu.tieba.pb;

import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(NewPbActivity newPbActivity) {
        this.f2193a = newPbActivity;
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
        boolean a2;
        cr crVar5;
        com.baidu.tieba.model.bm bmVar;
        boolean a3;
        boolean a4;
        cr crVar6;
        cr crVar7;
        cr crVar8;
        cr crVar9;
        cr crVar10;
        boolean a5;
        cr crVar11;
        if (i == 0) {
            a5 = this.f2193a.a(11025);
            if (a5) {
                NewPbActivity newPbActivity = this.f2193a;
                crVar11 = this.f2193a.y;
                newPbActivity.z = crVar11.ae();
                AtListActivity.a(this.f2193a, 12004);
            }
        } else if (i == 7) {
            crVar7 = this.f2193a.y;
            if (!crVar7.E()) {
                crVar10 = this.f2193a.y;
                crVar10.D();
            } else {
                NewPbActivity newPbActivity2 = this.f2193a;
                crVar8 = this.f2193a.y;
                WriteImageActivity.a(newPbActivity2, crVar8.F(), 12003);
            }
            crVar9 = this.f2193a.y;
            crVar9.e(false);
        } else if (i == 26) {
            a4 = this.f2193a.a(11026);
            if (a4) {
                NewPbActivity newPbActivity3 = this.f2193a;
                crVar6 = this.f2193a.y;
                newPbActivity3.z = crVar6.ae();
                AtListActivity.a(this.f2193a, 12005);
            }
        } else if (i == 10) {
            bmVar = this.f2193a.s;
            if (bmVar.l() != null) {
                a3 = this.f2193a.a(11001);
                if (a3) {
                    this.f2193a.a((String) null);
                }
            }
        } else if (i == 27) {
            a2 = this.f2193a.a(11027);
            if (a2) {
                crVar5 = this.f2193a.y;
                this.f2193a.a(crVar5.L());
            }
        } else if (i == 4) {
            str = this.f2193a.l;
            if (str != null) {
                str2 = this.f2193a.l;
                if (str2.length() > 0) {
                    crVar3 = this.f2193a.y;
                    crVar3.c(false);
                    crVar4 = this.f2193a.y;
                    crVar4.d(false);
                    NewPbActivity newPbActivity4 = this.f2193a;
                    str3 = this.f2193a.l;
                    newPbActivity4.showToast(str3);
                    return;
                }
            }
            crVar = this.f2193a.y;
            crVar.c(true);
            crVar2 = this.f2193a.y;
            crVar2.d(true);
        } else if (i == 22) {
            com.baidu.tieba.write.bd.a(this.f2193a);
        } else if (i == 23) {
            com.baidu.tieba.write.bd.b(this.f2193a);
        }
    }
}
