package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eFl;
    private List<q> eFm;
    private com.baidu.adp.lib.e.b<q> eFn;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eFm = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eFl = list;
        aRT();
    }

    private void aRT() {
        if (!com.baidu.tbadk.core.util.w.s(this.eFl)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eFl) {
                if (eVar != null) {
                    q ew = this.eFn.ew();
                    ew.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.I(this.mContext) - com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds80)) - com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds16)) / 2, -2);
                    ew.setPadding(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds16), 0, com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds14), 0);
                    addView(ew, layoutParams);
                    this.eFm.add(ew);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.w.s(this.eFm)) {
            for (q qVar : this.eFm) {
                this.eFn.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<q> bVar) {
        this.eFn = bVar;
    }

    public void tg() {
        for (q qVar : this.eFm) {
            if (qVar != null) {
                qVar.tg();
            }
        }
    }
}
