package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> grj;
    private List<n> grk;
    private com.baidu.adp.lib.e.b<n> grl;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.grk = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.grj = list;
        bkE();
    }

    private void bkE() {
        if (!v.E(this.grj)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.grj) {
                if (fVar != null) {
                    n nk = this.grl.nk();
                    nk.setData(fVar);
                    addView(nk, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ao(this.mContext) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds96)) / 2, -2));
                    this.grk.add(nk);
                }
            }
        }
    }

    public void recycle() {
        if (!v.E(this.grk)) {
            for (n nVar : this.grk) {
                this.grl.ar(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.grl = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.grk) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
