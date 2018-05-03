package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0186a fzJ;
    private String fzL;
    private int fzM;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!an.isEmpty(this.fzL)) {
            com.baidu.tbadk.browser.a.M(this.mContext, this.fzL);
            if (this.fzJ != null) {
                switch (this.fzM) {
                    case 0:
                        this.fzJ.d(this.fzL, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fzJ.d(this.fzL, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fzJ.d(this.fzL, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fzJ.d(this.fzL, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fzL = str;
        this.fzM = i;
    }
}
