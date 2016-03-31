package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class dv extends dt {
    public CoverFlowView<com.baidu.tieba.tbadkCore.data.k> bvv;
    private b.a daU;
    public TextView djT;

    public dv(View view, boolean z, boolean z2, int i) {
        super(view, z, z2, i);
        this.daU = null;
        this.bvv = (CoverFlowView) view.findViewById(t.g.chudian_coverflowview);
        this.djT = (TextView) view.findViewById(t.g.chudian_pic);
    }

    public void a(Context context, com.baidu.tieba.tbadkCore.data.i iVar, b.a aVar) {
        if (iVar != null && iVar.aSU() == 1) {
            if (!com.baidu.adp.lib.g.c.hr().ah(17)) {
                com.baidu.tbadk.core.util.at.b(this.djT, t.d.cp_cont_b, 1);
                this.djT.setVisibility(0);
                return;
            }
            this.daU = aVar;
            List<com.baidu.tieba.tbadkCore.data.k> aSS = iVar.aSS();
            if (aSS != null && aSS.size() > 0) {
                com.baidu.adp.lib.util.k.c(context, t.e.ds320);
                int B = (com.baidu.adp.lib.util.k.B(context) - com.baidu.adp.lib.util.k.c(context, t.e.ds104)) - com.baidu.adp.lib.util.k.c(context, t.e.ds32);
                int i = (int) (B / 1.7777778f);
                int l = l(aSS, B);
                if (i > l) {
                    i = l;
                }
                com.baidu.tieba.pb.view.g gVar = new com.baidu.tieba.pb.view.g(context, this.daU);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                gVar.setLayoutParams(layoutParams);
                this.bvv.setCallback(new com.baidu.tieba.pb.d(gVar, context, aVar));
                this.bvv.setVisibility(0);
                if (aSS.size() > 3) {
                    aSS = aSS.subList(0, 3);
                }
                this.bvv.setDisableParentEvent(false);
                com.baidu.tieba.tbadkCore.data.k kVar = aSS.get(0);
                if (!com.baidu.tbadk.core.util.ay.isEmpty(kVar.aSX())) {
                    gVar.dqx.setText(kVar.aSX());
                    gVar.dqx.setVisibility(0);
                } else {
                    gVar.dqx.setVisibility(8);
                }
                if (!com.baidu.tbadk.core.util.ay.isEmpty(kVar.getSubTitle())) {
                    gVar.dqy.setText(kVar.getSubTitle());
                    gVar.dqy.setVisibility(0);
                } else {
                    gVar.dqy.setVisibility(8);
                }
                if (gVar.dqx.getVisibility() != 0 && gVar.dqy.getVisibility() != 0) {
                    gVar.setVisibility(8);
                } else {
                    gVar.ao(kVar.rA(), 1);
                }
                if (this.daU != null) {
                    this.daU.y(kVar.rA(), "IMAGE1", "VIEW_CAROUSEL");
                }
                this.bvv.setCoverFlowFactory(new com.baidu.tieba.pb.e(gVar, i));
                this.bvv.setData(aSS);
            }
        }
    }

    private int l(List<com.baidu.tieba.tbadkCore.data.k> list, int i) {
        int i2;
        if (list == null || list.size() <= 0 || i <= 0) {
            return 0;
        }
        int i3 = 1;
        for (int i4 = 0; i4 != list.size(); i4++) {
            com.baidu.tieba.tbadkCore.data.k kVar = list.get(i4);
            int width = kVar.getWidth();
            int height = kVar.getHeight();
            if (width > 1 && (i2 = (int) ((height * i) / width)) > i3) {
                i3 = i2;
            }
        }
        return i3;
    }
}
