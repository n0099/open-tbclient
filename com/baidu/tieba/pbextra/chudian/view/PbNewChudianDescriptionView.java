package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0240a gfh;
    private String gfj;
    private int gfk;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.gfj)) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.gfj);
            if (this.gfh != null) {
                switch (this.gfk) {
                    case 0:
                        this.gfh.d(this.gfj, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.gfh.d(this.gfj, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.gfh.d(this.gfj, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.gfh.d(this.gfj, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.gfj = str;
        this.gfk = i;
    }
}
