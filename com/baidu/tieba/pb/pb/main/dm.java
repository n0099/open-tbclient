package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class dm extends dk {
    public CoverFlowView<com.baidu.tieba.tbadkCore.data.k> bvk;
    private b.a ddo;
    public TextView dmp;

    public dm(View view, boolean z, boolean z2, int i) {
        super(view, z, z2, i);
        this.ddo = null;
        this.bvk = (CoverFlowView) view.findViewById(t.g.chudian_coverflowview);
        this.dmp = (TextView) view.findViewById(t.g.chudian_pic);
    }

    public void a(Context context, com.baidu.tieba.tbadkCore.data.i iVar, b.a aVar) {
        if (iVar != null && iVar.aTv() == 1) {
            if (!com.baidu.adp.lib.g.c.dF().V(17)) {
                com.baidu.tbadk.core.util.at.c(this.dmp, t.d.cp_cont_b, 1);
                this.dmp.setVisibility(0);
                return;
            }
            this.ddo = aVar;
            List<com.baidu.tieba.tbadkCore.data.k> aTt = iVar.aTt();
            if (aTt != null && aTt.size() > 0) {
                com.baidu.adp.lib.util.k.c(context, t.e.ds320);
                int B = (com.baidu.adp.lib.util.k.B(context) - com.baidu.adp.lib.util.k.c(context, t.e.ds104)) - com.baidu.adp.lib.util.k.c(context, t.e.ds32);
                int i = (int) (B / 1.7777778f);
                int m = m(aTt, B);
                if (i > m) {
                    i = m;
                }
                com.baidu.tieba.pb.view.m mVar = new com.baidu.tieba.pb.view.m(context, this.ddo);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                mVar.setLayoutParams(layoutParams);
                this.bvk.setCallback(new com.baidu.tieba.pb.d(mVar, context, aVar));
                this.bvk.setVisibility(0);
                if (aTt.size() > 3) {
                    aTt = aTt.subList(0, 3);
                }
                this.bvk.setDisableParentEvent(false);
                com.baidu.tieba.tbadkCore.data.k kVar = aTt.get(0);
                if (!com.baidu.tbadk.core.util.ay.isEmpty(kVar.aTy())) {
                    mVar.dsB.setText(kVar.aTy());
                    mVar.dsB.setVisibility(0);
                } else {
                    mVar.dsB.setVisibility(8);
                }
                if (!com.baidu.tbadk.core.util.ay.isEmpty(kVar.getSubTitle())) {
                    mVar.dsC.setText(kVar.getSubTitle());
                    mVar.dsC.setVisibility(0);
                } else {
                    mVar.dsC.setVisibility(8);
                }
                if (mVar.dsB.getVisibility() != 0 && mVar.dsC.getVisibility() != 0) {
                    mVar.setVisibility(8);
                } else {
                    mVar.as(kVar.oU(), 1);
                }
                if (this.ddo != null) {
                    this.ddo.z(kVar.oU(), "IMAGE1", "VIEW_CAROUSEL");
                }
                this.bvk.setCoverFlowFactory(new com.baidu.tieba.pb.e(mVar, i));
                this.bvk.setData(aTt);
                if (this.dmo.getVisibility() == 8) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bvk.getLayoutParams();
                    layoutParams2.setMargins(com.baidu.adp.lib.util.k.c(context, t.e.ds104), 0, com.baidu.adp.lib.util.k.c(context, t.e.ds32), com.baidu.adp.lib.util.k.c(context, t.e.ds32));
                    this.bvk.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private int m(List<com.baidu.tieba.tbadkCore.data.k> list, int i) {
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
