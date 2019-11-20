package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0476a igC;
    private String igE;
    private int igF;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.igE)) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.igE);
            if (this.igC != null) {
                switch (this.igF) {
                    case 0:
                        this.igC.k(this.igE, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.igC.k(this.igE, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.igC.k(this.igE, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.igC.k(this.igE, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.igE = str;
        this.igF = i;
    }
}
