package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class aw implements bk {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bk
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.af afVar, String str, int i4) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        long j;
        long j2;
        bj bjVar;
        long j3;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bq bqVar4;
        com.baidu.tieba.model.ai aiVar;
        bq bqVar5;
        bj bjVar5;
        bq bqVar6;
        bj bjVar6;
        bq bqVar7;
        bj bjVar7;
        bq bqVar8;
        bq bqVar9;
        bqVar = this.a.D;
        bqVar.w();
        if (z && afVar != null) {
            TbadkApplication.m252getInst().setDefaultBubble(afVar.h().getBimg_url());
            bqVar4 = this.a.D;
            bqVar4.j.t();
            aiVar = this.a.y;
            aiVar.a(afVar.i());
            bqVar5 = this.a.D;
            bjVar5 = this.a.x;
            bqVar5.a(afVar, i2, i3, bjVar5.h(), i4);
            bqVar6 = this.a.D;
            bjVar6 = this.a.x;
            bqVar6.a(afVar, bjVar6.h(), false, i2);
            bqVar7 = this.a.D;
            bjVar7 = this.a.x;
            bqVar7.e(bjVar7.g());
            this.a.H();
            AntiData g = afVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.p = g.getVoice_message();
                this.a.a(valueOf);
            }
            if (afVar == null || afVar.m() != 1) {
                bqVar8 = this.a.D;
                bqVar8.i(false);
            } else {
                bqVar9 = this.a.D;
                bqVar9.i(true);
            }
        } else if (str != null) {
            if (UtilHelper.isNetOk()) {
                bqVar2 = this.a.D;
                bqVar2.d(str);
            } else {
                this.a.l();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            bqVar3 = this.a.D;
            bqVar3.P();
        }
        j = this.a.m;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.m;
            bjVar = this.a.x;
            long d = bjVar.d();
            j3 = this.a.m;
            long j4 = d - j3;
            bjVar2 = this.a.x;
            long b = bjVar2.b();
            bjVar3 = this.a.x;
            long c = bjVar3.c();
            bjVar4 = this.a.x;
            TiebaStatic.page("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - bjVar4.a());
            this.a.m = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.bk
    public void a(com.baidu.tieba.data.af afVar) {
        bq bqVar;
        bqVar = this.a.D;
        bqVar.a(afVar);
    }
}
