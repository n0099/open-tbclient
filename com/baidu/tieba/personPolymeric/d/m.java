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
    private List<com.baidu.tieba.personPolymeric.c.f> fmK;
    private List<n> fmL;
    private com.baidu.adp.lib.e.b<n> fmM;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.fmL = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fmK = list;
        aYI();
    }

    private void aYI() {
        if (!v.v(this.fmK)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fmK) {
                if (fVar != null) {
                    n fI = this.fmM.fI();
                    fI.setData(fVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.ae(this.mContext) - com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds80)) - com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds16)) / 2, -2);
                    fI.setPadding(com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds20), 0, com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds14), 0);
                    addView(fI, layoutParams);
                    this.fmL.add(fI);
                }
            }
        }
    }

    public void recycle() {
        if (!v.v(this.fmL)) {
            for (n nVar : this.fmL) {
                this.fmM.m(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fmM = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.fmL) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
