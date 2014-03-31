package com.baidu.tieba.pb.main;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
final class av implements be {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.be
    public final void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ae aeVar, String str, int i4) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        long j;
        long j2;
        bd bdVar;
        long j3;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        bk bkVar4;
        com.baidu.tieba.model.ai aiVar;
        bk bkVar5;
        bd bdVar5;
        bk bkVar6;
        bd bdVar6;
        bk bkVar7;
        bd bdVar7;
        Handler handler;
        Handler handler2;
        Handler handler3;
        bd bdVar8;
        bk bkVar8;
        bk bkVar9;
        bkVar = this.a.D;
        bkVar.w();
        if (z && aeVar != null) {
            TbadkApplication.j().q(aeVar.h().getBimg_url());
            bkVar4 = this.a.D;
            bkVar4.j.s();
            aiVar = this.a.y;
            aiVar.a(aeVar.i());
            bkVar5 = this.a.D;
            bdVar5 = this.a.x;
            bkVar5.a(aeVar, i2, i3, bdVar5.h(), i4);
            bkVar6 = this.a.D;
            bdVar6 = this.a.x;
            bkVar6.a(aeVar, bdVar6.h(), false);
            bkVar7 = this.a.D;
            bdVar7 = this.a.x;
            bkVar7.e(bdVar7.g());
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
            bdVar8 = this.a.x;
            if (bdVar8.p().m() == 1) {
                bkVar9 = this.a.D;
                bkVar9.i(true);
            } else {
                bkVar8 = this.a.D;
                bkVar8.i(false);
            }
        } else if (str != null) {
            if (UtilHelper.a()) {
                bkVar2 = this.a.D;
                bkVar2.b(str);
            } else {
                this.a.m();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            bkVar3 = this.a.D;
            bkVar3.P();
        }
        j = this.a.m;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.m;
            bdVar = this.a.x;
            long d = bdVar.d();
            j3 = this.a.m;
            long j4 = d - j3;
            bdVar2 = this.a.x;
            long b = bdVar2.b();
            bdVar3 = this.a.x;
            long c = bdVar3.c();
            bdVar4 = this.a.x;
            TiebaStatic.a("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - bdVar4.a());
            this.a.m = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.be
    public final void a(com.baidu.tieba.data.ae aeVar) {
        bk bkVar;
        bkVar = this.a.D;
        bkVar.a(aeVar);
    }
}
