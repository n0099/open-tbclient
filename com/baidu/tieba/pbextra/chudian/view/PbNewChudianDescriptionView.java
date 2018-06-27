package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0204a fQn;
    private String fQp;
    private int fQq;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.fQp)) {
            com.baidu.tbadk.browser.a.O(this.mContext, this.fQp);
            if (this.fQn != null) {
                switch (this.fQq) {
                    case 0:
                        this.fQn.d(this.fQp, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fQn.d(this.fQp, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fQn.d(this.fQp, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fQn.d(this.fQp, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fQp = str;
        this.fQq = i;
    }
}
