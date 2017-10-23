package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> fih;
    private List<n> fii;
    private com.baidu.adp.lib.e.b<n> fij;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.fii = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fih = list;
        aXb();
    }

    private void aXb() {
        if (!v.u(this.fih)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fih) {
                if (fVar != null) {
                    n fH = this.fij.fH();
                    fH.setData(fVar);
                    addView(fH, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ad(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds68)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds68)) / 2, -2));
                    this.fii.add(fH);
                }
            }
        }
    }

    public void recycle() {
        if (!v.u(this.fii)) {
            for (n nVar : this.fii) {
                this.fij.m(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fij = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.fii) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
