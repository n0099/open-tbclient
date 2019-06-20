package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0366a hZs;
    private String hZu;
    private int hZv;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.hZu)) {
            com.baidu.tbadk.browser.a.af(this.mContext, this.hZu);
            if (this.hZs != null) {
                switch (this.hZv) {
                    case 0:
                        this.hZs.g(this.hZu, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.hZs.g(this.hZu, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.hZs.g(this.hZu, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.hZs.g(this.hZu, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.hZu = str;
        this.hZv = i;
    }
}
