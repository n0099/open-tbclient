package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0382a iiJ;
    private String iiL;
    private int iiM;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.iiL)) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.iiL);
            if (this.iiJ != null) {
                switch (this.iiM) {
                    case 0:
                        this.iiJ.h(this.iiL, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.iiJ.h(this.iiL, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.iiJ.h(this.iiL, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.iiJ.h(this.iiL, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.iiL = str;
        this.iiM = i;
    }
}
