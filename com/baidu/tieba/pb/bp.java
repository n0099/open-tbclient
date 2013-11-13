package com.baidu.tieba.pb;

import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(NewPbActivity newPbActivity) {
        this.f2100a = newPbActivity;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        String str;
        cp cpVar;
        cp cpVar2;
        String str2;
        cp cpVar3;
        cp cpVar4;
        String str3;
        boolean a2;
        cp cpVar5;
        com.baidu.tieba.model.bm bmVar;
        boolean a3;
        boolean a4;
        cp cpVar6;
        cp cpVar7;
        cp cpVar8;
        cp cpVar9;
        cp cpVar10;
        boolean a5;
        cp cpVar11;
        if (i == 0) {
            a5 = this.f2100a.a(11025);
            if (a5) {
                NewPbActivity newPbActivity = this.f2100a;
                cpVar11 = this.f2100a.y;
                newPbActivity.z = cpVar11.ae();
                AtListActivity.a(this.f2100a, 12004);
            }
        } else if (i == 7) {
            cpVar7 = this.f2100a.y;
            if (!cpVar7.E()) {
                cpVar10 = this.f2100a.y;
                cpVar10.D();
            } else {
                NewPbActivity newPbActivity2 = this.f2100a;
                cpVar8 = this.f2100a.y;
                WriteImageActivity.a(newPbActivity2, cpVar8.F(), 12003);
            }
            cpVar9 = this.f2100a.y;
            cpVar9.e(false);
        } else if (i == 26) {
            a4 = this.f2100a.a(11026);
            if (a4) {
                NewPbActivity newPbActivity3 = this.f2100a;
                cpVar6 = this.f2100a.y;
                newPbActivity3.z = cpVar6.ae();
                AtListActivity.a(this.f2100a, 12005);
            }
        } else if (i == 10) {
            bmVar = this.f2100a.s;
            if (bmVar.l() != null) {
                a3 = this.f2100a.a(11001);
                if (a3) {
                    this.f2100a.a((String) null);
                }
            }
        } else if (i == 27) {
            a2 = this.f2100a.a(11027);
            if (a2) {
                cpVar5 = this.f2100a.y;
                this.f2100a.a(cpVar5.L());
            }
        } else if (i == 4) {
            str = this.f2100a.l;
            if (str != null) {
                str2 = this.f2100a.l;
                if (str2.length() > 0) {
                    cpVar3 = this.f2100a.y;
                    cpVar3.c(false);
                    cpVar4 = this.f2100a.y;
                    cpVar4.d(false);
                    NewPbActivity newPbActivity4 = this.f2100a;
                    str3 = this.f2100a.l;
                    newPbActivity4.showToast(str3);
                    return;
                }
            }
            cpVar = this.f2100a.y;
            cpVar.c(true);
            cpVar2 = this.f2100a.y;
            cpVar2.d(true);
        } else if (i == 22) {
            com.baidu.tieba.write.bc.a(this.f2100a);
        } else if (i == 23) {
            com.baidu.tieba.write.bc.b(this.f2100a);
        }
    }
}
