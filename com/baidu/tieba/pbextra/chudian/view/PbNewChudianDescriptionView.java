package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0186a fzM;
    private String fzO;
    private int fzP;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!an.isEmpty(this.fzO)) {
            com.baidu.tbadk.browser.a.M(this.mContext, this.fzO);
            if (this.fzM != null) {
                switch (this.fzP) {
                    case 0:
                        this.fzM.d(this.fzO, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fzM.d(this.fzO, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fzM.d(this.fzO, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fzM.d(this.fzO, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fzO = str;
        this.fzP = i;
    }
}
