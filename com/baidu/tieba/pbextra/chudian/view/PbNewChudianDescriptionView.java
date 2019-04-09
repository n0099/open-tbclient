package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0348a hHp;
    private String hHr;
    private int hHs;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.hHr)) {
            com.baidu.tbadk.browser.a.ar(this.mContext, this.hHr);
            if (this.hHp != null) {
                switch (this.hHs) {
                    case 0:
                        this.hHp.d(this.hHr, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.hHp.d(this.hHr, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.hHp.d(this.hHr, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.hHp.d(this.hHr, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.hHr = str;
        this.hHs = i;
    }
}
