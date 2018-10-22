package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0240a gfi;
    private String gfk;
    private int gfl;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.gfk)) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.gfk);
            if (this.gfi != null) {
                switch (this.gfl) {
                    case 0:
                        this.gfi.d(this.gfk, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.gfi.d(this.gfk, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.gfi.d(this.gfk, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.gfi.d(this.gfk, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.gfk = str;
        this.gfl = i;
    }
}
