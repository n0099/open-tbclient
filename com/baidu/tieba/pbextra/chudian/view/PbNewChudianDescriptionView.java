package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes4.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private a.InterfaceC0348a hHo;
    private String hHq;
    private int hHr;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.hHq)) {
            com.baidu.tbadk.browser.a.ar(this.mContext, this.hHq);
            if (this.hHo != null) {
                switch (this.hHr) {
                    case 0:
                        this.hHo.d(this.hHq, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.hHo.d(this.hHq, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.hHo.d(this.hHq, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.hHo.d(this.hHq, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.hHq = str;
        this.hHr = i;
    }
}
