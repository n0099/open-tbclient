package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> flR;
    private List<n> flS;
    private com.baidu.adp.lib.e.b<n> flT;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.flS = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.flR = list;
        aYx();
    }

    private void aYx() {
        if (!v.v(this.flR)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.flR) {
                if (fVar != null) {
                    n fI = this.flT.fI();
                    fI.setData(fVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.ad(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16)) / 2, -2);
                    fI.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds20), 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), 0);
                    addView(fI, layoutParams);
                    this.flS.add(fI);
                }
            }
        }
    }

    public void recycle() {
        if (!v.v(this.flS)) {
            for (n nVar : this.flS) {
                this.flT.m(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.flT = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.flS) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
