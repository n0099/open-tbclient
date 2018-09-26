package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0206a fXG;
    private String fXI;
    private int fXJ;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.fXI)) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.fXI);
            if (this.fXG != null) {
                switch (this.fXJ) {
                    case 0:
                        this.fXG.d(this.fXI, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fXG.d(this.fXI, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fXG.d(this.fXI, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fXG.d(this.fXI, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fXI = str;
        this.fXJ = i;
    }
}
