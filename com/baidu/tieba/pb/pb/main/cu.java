package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.a;
import java.util.List;
/* loaded from: classes.dex */
public class cu extends cs {
    public CoverFlowView<com.baidu.tieba.tbadkCore.data.j> bnB;
    private a.InterfaceC0072a cBf;
    public TextView cHU;

    public cu(View view, boolean z, boolean z2, int i) {
        super(view, z, z2, i);
        this.cBf = null;
        this.bnB = (CoverFlowView) view.findViewById(n.g.chudian_coverflowview);
        this.cHU = (TextView) view.findViewById(n.g.chudian_pic);
    }

    public void a(Context context, com.baidu.tieba.tbadkCore.data.h hVar, a.InterfaceC0072a interfaceC0072a) {
        if (hVar != null && hVar.aET() == 1) {
            if (!com.baidu.adp.lib.g.c.hd().X(17)) {
                com.baidu.tbadk.core.util.as.b(this.cHU, n.d.cp_cont_b, 1);
                this.cHU.setVisibility(0);
                return;
            }
            this.cBf = interfaceC0072a;
            List<com.baidu.tieba.tbadkCore.data.j> aER = hVar.aER();
            if (aER != null && aER.size() > 0) {
                com.baidu.adp.lib.util.k.d(context, n.e.ds320);
                int K = (com.baidu.adp.lib.util.k.K(context) - com.baidu.adp.lib.util.k.d(context, n.e.ds104)) - com.baidu.adp.lib.util.k.d(context, n.e.ds32);
                int i = (int) (K / 1.7777778f);
                int g = g(aER, K);
                if (i > g) {
                    i = g;
                }
                com.baidu.tieba.pb.view.g gVar = new com.baidu.tieba.pb.view.g(context, this.cBf);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                gVar.setLayoutParams(layoutParams);
                this.bnB.setCallback(new com.baidu.tieba.pb.c(gVar, context, interfaceC0072a));
                this.bnB.setVisibility(0);
                if (aER.size() > 3) {
                    aER = aER.subList(0, 3);
                }
                if (aER.size() > 1) {
                    this.bnB.setDisableParentEvent(true);
                } else {
                    this.bnB.setDisableParentEvent(false);
                }
                com.baidu.tieba.tbadkCore.data.j jVar = aER.get(0);
                if (!com.baidu.tbadk.core.util.ax.isEmpty(jVar.aEV())) {
                    gVar.cMO.setText(jVar.aEV());
                    gVar.cMO.setVisibility(0);
                } else {
                    gVar.cMO.setVisibility(8);
                }
                if (!com.baidu.tbadk.core.util.ax.isEmpty(jVar.sX())) {
                    gVar.cMP.setText(jVar.sX());
                    gVar.cMP.setVisibility(0);
                } else {
                    gVar.cMP.setVisibility(8);
                }
                if (gVar.cMO.getVisibility() != 0 && gVar.cMP.getVisibility() != 0) {
                    gVar.setVisibility(8);
                } else {
                    gVar.ad(jVar.rt(), 1);
                }
                if (this.cBf != null) {
                    this.cBf.t(jVar.rt(), "IMAGE1", "VIEW_CAROUSEL");
                }
                this.bnB.setCoverFlowFactory(new com.baidu.tieba.pb.d(gVar, i));
                this.bnB.setData(aER);
            }
        }
    }

    private int g(List<com.baidu.tieba.tbadkCore.data.j> list, int i) {
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
