package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0267a ggE;
    private String ggG;
    private int ggH;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.ggG)) {
            com.baidu.tbadk.browser.a.ac(this.mContext, this.ggG);
            if (this.ggE != null) {
                switch (this.ggH) {
                    case 0:
                        this.ggE.d(this.ggG, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.ggE.d(this.ggG, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.ggE.d(this.ggG, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.ggE.d(this.ggG, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.ggG = str;
        this.ggH = i;
    }
}
