package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eJr;
    private List<q> eJs;
    private com.baidu.adp.lib.f.b<q> eJt;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eJs = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eJr = list;
        akM();
    }

    private void akM() {
        if (!com.baidu.tbadk.core.util.y.t(this.eJr)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eJr) {
                if (eVar != null) {
                    q ey = this.eJt.ey();
                    ey.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds80)) - com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds16)) / 2, -2);
                    ey.setPadding(com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds16), 0, com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds14), 0);
                    addView(ey, layoutParams);
                    this.eJs.add(ey);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.y.t(this.eJs)) {
            for (q qVar : this.eJs) {
                this.eJt.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.f.b<q> bVar) {
        this.eJt = bVar;
    }
}
