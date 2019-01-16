package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0278a grq;
    private String grs;
    private int grt;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.grs)) {
            com.baidu.tbadk.browser.a.ad(this.mContext, this.grs);
            if (this.grq != null) {
                switch (this.grt) {
                    case 0:
                        this.grq.d(this.grs, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.grq.d(this.grs, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.grq.d(this.grs, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.grq.d(this.grs, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.grs = str;
        this.grt = i;
    }
}
