package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0278a gnv;
    private String gnx;
    private int gny;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ao.isEmpty(this.gnx)) {
            com.baidu.tbadk.browser.a.ad(this.mContext, this.gnx);
            if (this.gnv != null) {
                switch (this.gny) {
                    case 0:
                        this.gnv.d(this.gnx, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.gnv.d(this.gnx, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.gnv.d(this.gnx, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.gnv.d(this.gnx, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.gnx = str;
        this.gny = i;
    }
}
