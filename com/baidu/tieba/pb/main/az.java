package com.baidu.tieba.pb.main;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class az implements bn {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bn
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ai aiVar, String str, int i4) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        long j;
        long j2;
        bm bmVar;
        long j3;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bt btVar4;
        com.baidu.tieba.model.ah ahVar;
        bt btVar5;
        bm bmVar5;
        bt btVar6;
        bm bmVar6;
        bt btVar7;
        bm bmVar7;
        bt btVar8;
        bt btVar9;
        btVar = this.a.D;
        btVar.x();
        if (z && aiVar != null) {
            TbadkApplication.m252getInst().setDefaultBubble(aiVar.g().getBimg_url());
            TbadkApplication.m252getInst().setDefaultBubbleEndTime(aiVar.g().getBimg_end_time());
            btVar4 = this.a.D;
            btVar4.h.u();
            ahVar = this.a.y;
            ahVar.a(aiVar.h());
            btVar5 = this.a.D;
            bmVar5 = this.a.x;
            btVar5.a(aiVar, i2, i3, bmVar5.i(), i4);
            btVar6 = this.a.D;
            bmVar6 = this.a.x;
            btVar6.a(aiVar, bmVar6.i(), false, i2);
            btVar7 = this.a.D;
            bmVar7 = this.a.x;
            btVar7.e(bmVar7.h());
            this.a.G();
            AntiData f = aiVar.f();
            if (f != null) {
                Boolean valueOf = Boolean.valueOf(f.isIfvoice());
                this.a.p = f.getVoice_message();
                this.a.a(valueOf);
            }
            if (aiVar == null || aiVar.l() != 1) {
                btVar8 = this.a.D;
                btVar8.i(false);
            } else {
                btVar9 = this.a.D;
                btVar9.i(true);
            }
        } else if (str != null) {
            if (UtilHelper.isNetOk()) {
                btVar2 = this.a.D;
                btVar2.d(str);
            } else {
                this.a.l();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            btVar3 = this.a.D;
            btVar3.Q();
        }
        j = this.a.k;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.k;
            bmVar = this.a.x;
            long d = bmVar.d();
            j3 = this.a.k;
            long j4 = d - j3;
            bmVar2 = this.a.x;
            long b = bmVar2.b();
            bmVar3 = this.a.x;
            long c = bmVar3.c();
            bmVar4 = this.a.x;
            TiebaStatic.page("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - bmVar4.a());
            this.a.k = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.bn
    public void a(com.baidu.tieba.data.ai aiVar) {
        bt btVar;
        btVar = this.a.D;
        btVar.a(aiVar);
    }
}
