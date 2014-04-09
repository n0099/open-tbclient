package com.baidu.tieba.pb.main;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
final class ax implements bg {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bg
    public final void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ae aeVar, String str, int i4) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        long j;
        long j2;
        bf bfVar;
        long j3;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bm bmVar4;
        com.baidu.tieba.model.ai aiVar;
        bm bmVar5;
        bf bfVar5;
        bm bmVar6;
        bf bfVar6;
        bm bmVar7;
        bf bfVar7;
        Handler handler;
        Handler handler2;
        Handler handler3;
        bf bfVar8;
        bm bmVar8;
        bm bmVar9;
        bmVar = this.a.D;
        bmVar.w();
        if (z && aeVar != null) {
            TbadkApplication.j().q(aeVar.h().getBimg_url());
            bmVar4 = this.a.D;
            bmVar4.j.s();
            aiVar = this.a.y;
            aiVar.a(aeVar.i());
            bmVar5 = this.a.D;
            bfVar5 = this.a.x;
            bmVar5.a(aeVar, i2, i3, bfVar5.h(), i4);
            bmVar6 = this.a.D;
            bfVar6 = this.a.x;
            bmVar6.a(aeVar, bfVar6.h(), false, i2);
            bmVar7 = this.a.D;
            bfVar7 = this.a.x;
            bmVar7.e(bfVar7.g());
            this.a.w();
            handler = this.a.w;
            handler.removeMessages(0);
            handler2 = this.a.w;
            handler3 = this.a.w;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 300L);
            AntiData g = aeVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.p = g.getVoice_message();
                PbActivity.a(this.a, valueOf);
            }
            bfVar8 = this.a.x;
            if (bfVar8.p().m() == 1) {
                bmVar9 = this.a.D;
                bmVar9.i(true);
            } else {
                bmVar8 = this.a.D;
                bmVar8.i(false);
            }
        } else if (str != null) {
            if (UtilHelper.a()) {
                bmVar2 = this.a.D;
                bmVar2.b(str);
            } else {
                this.a.m();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            bmVar3 = this.a.D;
            bmVar3.P();
        }
        j = this.a.m;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.m;
            bfVar = this.a.x;
            long d = bfVar.d();
            j3 = this.a.m;
            long j4 = d - j3;
            bfVar2 = this.a.x;
            long b = bfVar2.b();
            bfVar3 = this.a.x;
            long c = bfVar3.c();
            bfVar4 = this.a.x;
            TiebaStatic.a("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - bfVar4.a());
            this.a.m = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.bg
    public final void a(com.baidu.tieba.data.ae aeVar) {
        bm bmVar;
        bmVar = this.a.D;
        bmVar.a(aeVar);
    }
}
