package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class c implements bn {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bn
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.aj ajVar, String str, int i4) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        long j;
        long j2;
        bl blVar;
        long j3;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bs bsVar4;
        com.baidu.tieba.model.ai aiVar;
        bs bsVar5;
        bl blVar5;
        bs bsVar6;
        bl blVar6;
        bs bsVar7;
        bl blVar7;
        bs bsVar8;
        bs bsVar9;
        bsVar = this.a.D;
        bsVar.x();
        if (z && ajVar != null) {
            TbadkApplication.m252getInst().setDefaultBubble(ajVar.h().getBimg_url());
            TbadkApplication.m252getInst().setDefaultBubbleEndTime(ajVar.h().getBimg_end_time());
            bsVar4 = this.a.D;
            bsVar4.h.u();
            aiVar = this.a.y;
            aiVar.a(ajVar.i());
            bsVar5 = this.a.D;
            blVar5 = this.a.x;
            bsVar5.a(ajVar, i2, i3, blVar5.i(), i4);
            bsVar6 = this.a.D;
            blVar6 = this.a.x;
            bsVar6.a(ajVar, blVar6.i(), false, i2);
            bsVar7 = this.a.D;
            blVar7 = this.a.x;
            bsVar7.e(blVar7.h());
            this.a.J();
            AntiData g = ajVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.p = g.getVoice_message();
                this.a.a(valueOf);
            }
            if (ajVar == null || ajVar.m() != 1) {
                bsVar8 = this.a.D;
                bsVar8.i(false);
            } else {
                bsVar9 = this.a.D;
                bsVar9.i(true);
            }
        } else if (str != null) {
            if (UtilHelper.isNetOk()) {
                bsVar2 = this.a.D;
                bsVar2.d(str);
            } else {
                this.a.l();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            bsVar3 = this.a.D;
            bsVar3.Q();
        }
        j = this.a.k;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.k;
            blVar = this.a.x;
            long d = blVar.d();
            j3 = this.a.k;
            long j4 = d - j3;
            blVar2 = this.a.x;
            long b = blVar2.b();
            blVar3 = this.a.x;
            long c = blVar3.c();
            blVar4 = this.a.x;
            TiebaStatic.page("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - blVar4.a());
            this.a.k = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.bn
    public void a(com.baidu.tieba.data.aj ajVar) {
        bs bsVar;
        bsVar = this.a.D;
        bsVar.a(ajVar);
    }
}
