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
        bsVar = this.a.E;
        bsVar.x();
        if (z && ajVar != null) {
            TbadkApplication.m252getInst().setDefaultBubble(ajVar.h().getBimg_url());
            TbadkApplication.m252getInst().setDefaultBubbleEndTime(ajVar.h().getBimg_end_time());
            bsVar4 = this.a.E;
            bsVar4.h.u();
            aiVar = this.a.z;
            aiVar.a(ajVar.i());
            bsVar5 = this.a.E;
            blVar5 = this.a.y;
            bsVar5.a(ajVar, i2, i3, blVar5.i(), i4);
            bsVar6 = this.a.E;
            blVar6 = this.a.y;
            bsVar6.a(ajVar, blVar6.i(), false, i2);
            bsVar7 = this.a.E;
            blVar7 = this.a.y;
            bsVar7.e(blVar7.h());
            this.a.J();
            AntiData g = ajVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.q = g.getVoice_message();
                this.a.a(valueOf);
            }
            if (ajVar == null || ajVar.m() != 1) {
                bsVar8 = this.a.E;
                bsVar8.i(false);
            } else {
                bsVar9 = this.a.E;
                bsVar9.i(true);
            }
        } else if (str != null) {
            if (UtilHelper.isNetOk()) {
                bsVar2 = this.a.E;
                bsVar2.d(str);
            } else {
                this.a.l();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            bsVar3 = this.a.E;
            bsVar3.Q();
        }
        j = this.a.l;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.l;
            blVar = this.a.y;
            long d = blVar.d();
            j3 = this.a.l;
            long j4 = d - j3;
            blVar2 = this.a.y;
            long b = blVar2.b();
            blVar3 = this.a.y;
            long c = blVar3.c();
            blVar4 = this.a.y;
            TiebaStatic.page("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - blVar4.a());
            this.a.l = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.bn
    public void a(com.baidu.tieba.data.aj ajVar) {
        bs bsVar;
        bsVar = this.a.E;
        bsVar.a(ajVar);
    }
}
