package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eIY;
    private List<q> eIZ;
    private com.baidu.adp.lib.e.b<q> eJa;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eIZ = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eIY = list;
        aSG();
    }

    private void aSG() {
        if (!com.baidu.tbadk.core.util.x.q(this.eIY)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eIY) {
                if (eVar != null) {
                    q fK = this.eJa.fK();
                    fK.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16)) / 2, -2);
                    fK.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), 0);
                    addView(fK, layoutParams);
                    this.eIZ.add(fK);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.q(this.eIZ)) {
            for (q qVar : this.eIZ) {
                this.eJa.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<q> bVar) {
        this.eJa = bVar;
    }

    public void onChangeSkinType() {
        for (q qVar : this.eIZ) {
            if (qVar != null) {
                qVar.onChangeSkinType();
            }
        }
    }
}
