package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> evr;
    private List<q> evs;
    private com.baidu.adp.lib.f.b<q> evt;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.evs = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.evr = list;
        ahv();
    }

    private void ahv() {
        if (!com.baidu.tbadk.core.util.x.t(this.evr)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.evr) {
                if (eVar != null) {
                    q ey = this.evt.ey();
                    ey.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.I(this.mContext) - com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds80)) - com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16)) / 2, -2);
                    ey.setPadding(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16), 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds14), 0);
                    addView(ey, layoutParams);
                    this.evs.add(ey);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.t(this.evs)) {
            for (q qVar : this.evs) {
                this.evt.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.f.b<q> bVar) {
        this.evt = bVar;
    }

    public void tm() {
        for (q qVar : this.evs) {
            if (qVar != null) {
                qVar.tm();
            }
        }
    }
}
