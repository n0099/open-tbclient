package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0278a grr;
    private String grt;
    private int gru;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.grt)) {
            com.baidu.tbadk.browser.a.ad(this.mContext, this.grt);
            if (this.grr != null) {
                switch (this.gru) {
                    case 0:
                        this.grr.d(this.grt, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.grr.d(this.grt, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.grr.d(this.grt, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.grr.d(this.grt, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.grt = str;
        this.gru = i;
    }
}
