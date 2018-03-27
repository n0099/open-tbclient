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
    private List<n> grA;
    private com.baidu.adp.lib.e.b<n> grB;
    private List<com.baidu.tieba.personPolymeric.c.f> grz;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.grA = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.grz = list;
        bkF();
    }

    private void bkF() {
        if (!v.E(this.grz)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.grz) {
                if (fVar != null) {
                    n nk = this.grB.nk();
                    nk.setData(fVar);
                    addView(nk, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ao(this.mContext) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds96)) / 2, -2));
                    this.grA.add(nk);
                }
            }
        }
    }

    public void recycle() {
        if (!v.E(this.grA)) {
            for (n nVar : this.grA) {
                this.grB.ar(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.grB = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.grA) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
