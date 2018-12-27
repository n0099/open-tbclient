package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0278a gqm;
    private String gqo;
    private int gqp;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.gqo)) {
            com.baidu.tbadk.browser.a.ad(this.mContext, this.gqo);
            if (this.gqm != null) {
                switch (this.gqp) {
                    case 0:
                        this.gqm.d(this.gqo, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.gqm.d(this.gqo, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.gqm.d(this.gqo, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.gqm.d(this.gqo, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.gqo = str;
        this.gqp = i;
    }
}
