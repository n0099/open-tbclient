package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0202a fMk;
    private String fMm;
    private int fMn;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.fMm)) {
            com.baidu.tbadk.browser.a.O(this.mContext, this.fMm);
            if (this.fMk != null) {
                switch (this.fMn) {
                    case 0:
                        this.fMk.d(this.fMm, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fMk.d(this.fMm, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fMk.d(this.fMm, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fMk.d(this.fMm, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fMm = str;
        this.fMn = i;
    }
}
