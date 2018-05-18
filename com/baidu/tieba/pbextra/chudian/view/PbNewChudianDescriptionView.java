package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0186a fAP;
    private String fAR;
    private int fAS;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!an.isEmpty(this.fAR)) {
            com.baidu.tbadk.browser.a.M(this.mContext, this.fAR);
            if (this.fAP != null) {
                switch (this.fAS) {
                    case 0:
                        this.fAP.d(this.fAR, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fAP.d(this.fAR, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fAP.d(this.fAR, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fAP.d(this.fAR, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fAR = str;
        this.fAS = i;
    }
}
