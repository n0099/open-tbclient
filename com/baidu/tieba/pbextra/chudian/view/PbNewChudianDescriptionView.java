package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0365a ifI;
    private String ifK;
    private int ifL;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.ifK)) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.ifK);
            if (this.ifI != null) {
                switch (this.ifL) {
                    case 0:
                        this.ifI.h(this.ifK, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.ifI.h(this.ifK, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.ifI.h(this.ifK, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.ifI.h(this.ifK, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.ifK = str;
        this.ifL = i;
    }
}
