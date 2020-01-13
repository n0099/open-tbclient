package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.b;
/* loaded from: classes7.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private b.a jcg;
    private int jci;
    private String mClickUrl;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.mClickUrl)) {
            a.startWebActivity(this.mContext, this.mClickUrl);
            if (this.jcg != null) {
                switch (this.jci) {
                    case 0:
                        this.jcg.k(this.mClickUrl, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.jcg.k(this.mClickUrl, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.jcg.k(this.mClickUrl, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.jcg.k(this.mClickUrl, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.mClickUrl = str;
        this.jci = i;
    }
}
