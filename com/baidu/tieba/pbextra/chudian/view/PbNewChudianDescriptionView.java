package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.pb.a;
/* loaded from: classes3.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private String fQA;
    private int fQB;
    private a.InterfaceC0203a fQy;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!ap.isEmpty(this.fQA)) {
            com.baidu.tbadk.browser.a.Q(this.mContext, this.fQA);
            if (this.fQy != null) {
                switch (this.fQB) {
                    case 0:
                        this.fQy.d(this.fQA, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.fQy.d(this.fQA, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.fQy.d(this.fQA, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.fQy.d(this.fQA, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.fQA = str;
        this.fQB = i;
    }
}
