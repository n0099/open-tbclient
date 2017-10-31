package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> fqQ;
    private List<o> fqR;
    private com.baidu.adp.lib.e.b<o> fqS;
    private Context mContext;

    public n(Context context) {
        super(context);
        this.fqR = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fqQ = list;
        baj();
    }

    private void baj() {
        if (!v.v(this.fqQ)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fqQ) {
                if (fVar != null) {
                    o fH = this.fqS.fH();
                    fH.setData(fVar);
                    addView(fH, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ac(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) / 2, -2));
                    this.fqR.add(fH);
                }
            }
        }
    }

    public void recycle() {
        if (!v.v(this.fqR)) {
            for (o oVar : this.fqR) {
                this.fqS.m(oVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<o> bVar) {
        this.fqS = bVar;
    }

    public void onChangeSkinType() {
        for (o oVar : this.fqR) {
            if (oVar != null) {
                oVar.onChangeSkinType();
            }
        }
    }
}
