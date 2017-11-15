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
    private List<com.baidu.tieba.personPolymeric.c.f> frn;
    private List<o> fro;
    private com.baidu.adp.lib.e.b<o> frp;
    private Context mContext;

    public n(Context context) {
        super(context);
        this.fro = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.frn = list;
        bar();
    }

    private void bar() {
        if (!v.v(this.frn)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.frn) {
                if (fVar != null) {
                    o fH = this.frp.fH();
                    fH.setData(fVar);
                    addView(fH, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ac(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) / 2, -2));
                    this.fro.add(fH);
                }
            }
        }
    }

    public void recycle() {
        if (!v.v(this.fro)) {
            for (o oVar : this.fro) {
                this.frp.m(oVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<o> bVar) {
        this.frp = bVar;
    }

    public void onChangeSkinType() {
        for (o oVar : this.fro) {
            if (oVar != null) {
                oVar.onChangeSkinType();
            }
        }
    }
}
