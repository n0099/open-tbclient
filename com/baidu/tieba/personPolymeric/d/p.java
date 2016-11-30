package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eRS;
    private List<q> eRT;
    private com.baidu.adp.lib.f.b<q> eRU;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eRT = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eRS = list;
        amV();
    }

    private void amV() {
        if (!com.baidu.tbadk.core.util.x.t(this.eRS)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eRS) {
                if (eVar != null) {
                    q ey = this.eRU.ey();
                    ey.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds80)) - com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16)) / 2, -2);
                    ey.setPadding(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16), 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds14), 0);
                    addView(ey, layoutParams);
                    this.eRT.add(ey);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.t(this.eRT)) {
            for (q qVar : this.eRT) {
                this.eRU.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.f.b<q> bVar) {
        this.eRU = bVar;
    }

    public void tB() {
        for (q qVar : this.eRT) {
            if (qVar != null) {
                qVar.tB();
            }
        }
    }
}
