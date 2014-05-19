package com.baidu.tieba.pb.main;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class aw implements bd {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bd
    public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.data.ae aeVar, String str, int i4) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        long j;
        long j2;
        bc bcVar;
        long j3;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        bj bjVar4;
        com.baidu.tieba.model.ai aiVar;
        bj bjVar5;
        bc bcVar5;
        bj bjVar6;
        bc bcVar6;
        bj bjVar7;
        bc bcVar7;
        Handler handler;
        Handler handler2;
        Handler handler3;
        bj bjVar8;
        bj bjVar9;
        bjVar = this.a.E;
        bjVar.w();
        if (z && aeVar != null) {
            TbadkApplication.m252getInst().setDefaultBubble(aeVar.h().getBimg_url());
            bjVar4 = this.a.E;
            bjVar4.j.t();
            aiVar = this.a.z;
            aiVar.a(aeVar.i());
            bjVar5 = this.a.E;
            bcVar5 = this.a.y;
            bjVar5.a(aeVar, i2, i3, bcVar5.h(), i4);
            bjVar6 = this.a.E;
            bcVar6 = this.a.y;
            bjVar6.a(aeVar, bcVar6.h(), false, i2);
            bjVar7 = this.a.E;
            bcVar7 = this.a.y;
            bjVar7.e(bcVar7.g());
            this.a.G();
            handler = this.a.x;
            handler.removeMessages(0);
            handler2 = this.a.x;
            handler3 = this.a.x;
            handler2.sendMessageDelayed(handler3.obtainMessage(0), 90L);
            AntiData g = aeVar.g();
            if (g != null) {
                Boolean valueOf = Boolean.valueOf(g.isIfvoice());
                this.a.p = g.getVoice_message();
                this.a.a(valueOf);
            }
            if (aeVar == null || aeVar.m() != 1) {
                bjVar8 = this.a.E;
                bjVar8.i(false);
            } else {
                bjVar9 = this.a.E;
                bjVar9.i(true);
            }
        } else if (str != null) {
            if (UtilHelper.isNetOk()) {
                bjVar2 = this.a.E;
                bjVar2.d(str);
            } else {
                this.a.l();
            }
            if (i == 4 || i == 28) {
                this.a.finish();
            }
            bjVar3 = this.a.E;
            bjVar3.P();
        }
        j = this.a.m;
        if (j > -1) {
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.a.m;
            bcVar = this.a.y;
            long d = bcVar.d();
            j3 = this.a.m;
            long j4 = d - j3;
            bcVar2 = this.a.y;
            long b = bcVar2.b();
            bcVar3 = this.a.y;
            long c = bcVar3.c();
            bcVar4 = this.a.y;
            TiebaStatic.page("op_pb_enter", currentTimeMillis - j2, j4, b, c, currentTimeMillis - bcVar4.a());
            this.a.m = -1L;
        }
    }

    @Override // com.baidu.tieba.pb.main.bd
    public void a(com.baidu.tieba.data.ae aeVar) {
        bj bjVar;
        bjVar = this.a.E;
        bjVar.a(aeVar);
    }
}
