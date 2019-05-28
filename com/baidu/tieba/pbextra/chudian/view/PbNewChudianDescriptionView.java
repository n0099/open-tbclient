package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0366a hZr;
    private String hZt;
    private int hZu;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.hZt)) {
            com.baidu.tbadk.browser.a.af(this.mContext, this.hZt);
            if (this.hZr != null) {
                switch (this.hZu) {
                    case 0:
                        this.hZr.g(this.hZt, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.hZr.g(this.hZt, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.hZr.g(this.hZt, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.hZr.g(this.hZt, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.hZt = str;
        this.hZu = i;
    }
}
