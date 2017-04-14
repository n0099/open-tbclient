package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eGI;
    private List<q> eGJ;
    private com.baidu.adp.lib.e.b<q> eGK;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eGJ = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eGI = list;
        aRF();
    }

    private void aRF() {
        if (!com.baidu.tbadk.core.util.x.q(this.eGI)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eGI) {
                if (eVar != null) {
                    q fJ = this.eGK.fJ();
                    fJ.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16)) / 2, -2);
                    fJ.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), 0);
                    addView(fJ, layoutParams);
                    this.eGJ.add(fJ);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.q(this.eGJ)) {
            for (q qVar : this.eGJ) {
                this.eGK.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<q> bVar) {
        this.eGK = bVar;
    }

    public void onChangeSkinType() {
        for (q qVar : this.eGJ) {
            if (qVar != null) {
                qVar.onChangeSkinType();
            }
        }
    }
}
