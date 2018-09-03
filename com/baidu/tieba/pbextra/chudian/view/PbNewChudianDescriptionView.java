package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0203a fQq;
    private String fQs;
    private int fQt;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.fQs)) {
            com.baidu.tbadk.browser.a.Q(this.mContext, this.fQs);
            if (this.fQq != null) {
                switch (this.fQt) {
                    case 0:
                        this.fQq.d(this.fQs, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fQq.d(this.fQs, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fQq.d(this.fQs, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fQq.d(this.fQs, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fQs = str;
        this.fQt = i;
    }
}
