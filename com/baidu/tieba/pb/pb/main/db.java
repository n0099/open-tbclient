package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class db extends cz {
    public CoverFlowView<com.baidu.tieba.tbadkCore.data.j> bqt;
    private a.InterfaceC0074a cHL;
    public TextView cPD;

    public db(View view, boolean z, boolean z2, int i) {
        super(view, z, z2, i);
        this.cHL = null;
        this.bqt = (CoverFlowView) view.findViewById(t.g.chudian_coverflowview);
        this.cPD = (TextView) view.findViewById(t.g.chudian_pic);
    }

    public void a(Context context, com.baidu.tieba.tbadkCore.data.h hVar, a.InterfaceC0074a interfaceC0074a) {
        if (hVar != null && hVar.aLZ() == 1) {
            if (!com.baidu.adp.lib.g.c.hl().ai(17)) {
                com.baidu.tbadk.core.util.ar.b(this.cPD, t.d.cp_cont_b, 1);
                this.cPD.setVisibility(0);
                return;
            }
            this.cHL = interfaceC0074a;
            List<com.baidu.tieba.tbadkCore.data.j> aLX = hVar.aLX();
            if (aLX != null && aLX.size() > 0) {
                com.baidu.adp.lib.util.k.c(context, t.e.ds320);
                int K = (com.baidu.adp.lib.util.k.K(context) - com.baidu.adp.lib.util.k.c(context, t.e.ds104)) - com.baidu.adp.lib.util.k.c(context, t.e.ds32);
                int i = (int) (K / 1.7777778f);
                int h = h(aLX, K);
                if (i > h) {
                    i = h;
                }
                com.baidu.tieba.pb.view.g gVar = new com.baidu.tieba.pb.view.g(context, this.cHL);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                gVar.setLayoutParams(layoutParams);
                this.bqt.setCallback(new com.baidu.tieba.pb.c(gVar, context, interfaceC0074a));
                this.bqt.setVisibility(0);
                if (aLX.size() > 3) {
                    aLX = aLX.subList(0, 3);
                }
                this.bqt.setDisableParentEvent(false);
                com.baidu.tieba.tbadkCore.data.j jVar = aLX.get(0);
                if (!com.baidu.tbadk.core.util.aw.isEmpty(jVar.aMb())) {
                    gVar.cVC.setText(jVar.aMb());
                    gVar.cVC.setVisibility(0);
                } else {
                    gVar.cVC.setVisibility(8);
                }
                if (!com.baidu.tbadk.core.util.aw.isEmpty(jVar.tV())) {
                    gVar.cVD.setText(jVar.tV());
                    gVar.cVD.setVisibility(0);
                } else {
                    gVar.cVD.setVisibility(8);
                }
                if (gVar.cVC.getVisibility() != 0 && gVar.cVD.getVisibility() != 0) {
                    gVar.setVisibility(8);
                } else {
                    gVar.af(jVar.rX(), 1);
                }
                if (this.cHL != null) {
                    this.cHL.u(jVar.rX(), "IMAGE1", "VIEW_CAROUSEL");
                }
                this.bqt.setCoverFlowFactory(new com.baidu.tieba.pb.d(gVar, i));
                this.bqt.setData(aLX);
            }
        }
    }

    private int h(List<com.baidu.tieba.tbadkCore.data.j> list, int i) {
        int i2;
        if (list == null || list.size() <= 0 || i <= 0) {
            return 0;
        }
        int i3 = 1;
        for (int i4 = 0; i4 != list.size(); i4++) {
            com.baidu.tieba.tbadkCore.data.j jVar = list.get(i4);
            int width = jVar.getWidth();
            int height = jVar.getHeight();
            if (width > 1 && (i2 = (int) ((height * i) / width)) > i3) {
                i3 = i2;
            }
        }
        return i3;
    }
}
