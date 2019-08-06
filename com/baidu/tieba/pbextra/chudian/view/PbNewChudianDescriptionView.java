package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0371a igK;
    private String igM;
    private int igN;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.igM)) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.igM);
            if (this.igK != null) {
                switch (this.igN) {
                    case 0:
                        this.igK.h(this.igM, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.igK.h(this.igM, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.igK.h(this.igM, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.igK.h(this.igM, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.igM = str;
        this.igN = i;
    }
}
