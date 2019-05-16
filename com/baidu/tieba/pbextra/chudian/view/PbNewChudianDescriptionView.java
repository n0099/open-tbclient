package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0366a hZo;
    private String hZq;
    private int hZr;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.hZq)) {
            com.baidu.tbadk.browser.a.af(this.mContext, this.hZq);
            if (this.hZo != null) {
                switch (this.hZr) {
                    case 0:
                        this.hZo.g(this.hZq, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.hZo.g(this.hZq, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.hZo.g(this.hZq, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.hZo.g(this.hZq, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.hZq = str;
        this.hZr = i;
    }
}
