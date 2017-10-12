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
    private List<com.baidu.tieba.personPolymeric.c.f> fiv;
    private List<n> fiw;
    private com.baidu.adp.lib.e.b<n> fiy;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.fiw = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fiv = list;
        aXg();
    }

    private void aXg() {
        if (!v.u(this.fiv)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fiv) {
                if (fVar != null) {
                    n fH = this.fiy.fH();
                    fH.setData(fVar);
                    addView(fH, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ad(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds68)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds68)) / 2, -2));
                    this.fiw.add(fH);
                }
            }
        }
    }

    public void recycle() {
        if (!v.u(this.fiw)) {
            for (n nVar : this.fiw) {
                this.fiy.m(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fiy = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.fiw) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
