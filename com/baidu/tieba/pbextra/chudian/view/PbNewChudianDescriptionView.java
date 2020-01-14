package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.b;
/* loaded from: classes7.dex */
public class PbNewChudianDescriptionView extends LinearLayout implements View.OnClickListener {
    private b.a jcl;
    private int jcn;
    private String mClickUrl;
    private Context mContext;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!aq.isEmpty(this.mClickUrl)) {
            a.startWebActivity(this.mContext, this.mClickUrl);
            if (this.jcl != null) {
                switch (this.jcn) {
                    case 0:
                        this.jcl.k(this.mClickUrl, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 1:
                        this.jcl.k(this.mClickUrl, "IMAGE1", "LINK_IMAGE", null, null);
                        return;
                    case 2:
                        this.jcl.k(this.mClickUrl, "IMAGE2", "LINK_IMAGE", null, null);
                        return;
                    case 3:
                        this.jcl.k(this.mClickUrl, "IMAGE3", "LINK_IMAGE", null, null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void setClickUrl(String str, int i) {
        this.mClickUrl = str;
        this.jcn = i;
    }
}
