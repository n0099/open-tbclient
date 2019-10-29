package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0476a iht;
    private String ihv;
    private int ihw;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.ihv)) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.ihv);
            if (this.iht != null) {
                switch (this.ihw) {
                    case 0:
                        this.iht.k(this.ihv, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.iht.k(this.ihv, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.iht.k(this.ihv, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.iht.k(this.ihv, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.ihv = str;
        this.ihw = i;
    }
}
