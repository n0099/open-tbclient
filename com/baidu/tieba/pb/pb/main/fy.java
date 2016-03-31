package com.baidu.tieba.pb.pb.main;

import android.os.Handler;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fy implements Runnable {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy(eu euVar) {
        this.dnc = euVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        PbActivity pbActivity;
        View view;
        com.baidu.adp.lib.guide.d dVar2;
        com.baidu.adp.lib.guide.d dVar3;
        PbActivity pbActivity2;
        Handler handler;
        dVar = this.dnc.dmO;
        if (dVar == null) {
            pbActivity = this.dnc.dfw;
            String string = pbActivity.getPageContext().getPageActivity().getResources().getString(t.j.graffiti_pb_bottom_tips);
            if (!StringUtils.isNull(string)) {
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                view = this.dnc.dma;
                gVar.o(view).Z(0).u(true).v(true);
                gVar.a(new fz(this, string));
                this.dnc.dmO = gVar.gH();
                dVar2 = this.dnc.dmO;
                dVar2.s(false);
                dVar3 = this.dnc.dmO;
                pbActivity2 = this.dnc.dfw;
                dVar3.d(pbActivity2.getPageContext().getPageActivity());
                handler = this.dnc.mHandler;
                handler.postDelayed(new ga(this), 3000L);
            }
        }
    }
}
