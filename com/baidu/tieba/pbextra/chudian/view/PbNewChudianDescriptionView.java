package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0348a hHC;
    private String hHE;
    private int hHF;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.hHE)) {
            com.baidu.tbadk.browser.a.ar(this.mContext, this.hHE);
            if (this.hHC != null) {
                switch (this.hHF) {
                    case 0:
                        this.hHC.d(this.hHE, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.hHC.d(this.hHE, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.hHC.d(this.hHE, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.hHC.d(this.hHE, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.hHE = str;
        this.hHF = i;
    }
}
