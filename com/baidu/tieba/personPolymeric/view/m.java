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
    private List<com.baidu.tieba.personPolymeric.c.f> fiw;
    private List<n> fiy;
    private com.baidu.adp.lib.e.b<n> fiz;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.fiy = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fiw = list;
        aXh();
    }

    private void aXh() {
        if (!v.u(this.fiw)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fiw) {
                if (fVar != null) {
                    n fH = this.fiz.fH();
                    fH.setData(fVar);
                    addView(fH, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ad(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds68)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds68)) / 2, -2));
                    this.fiy.add(fH);
                }
            }
        }
    }

    public void recycle() {
        if (!v.u(this.fiy)) {
            for (n nVar : this.fiy) {
                this.fiz.m(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fiz = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.fiy) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
