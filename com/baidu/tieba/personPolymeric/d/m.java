package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> flB;
    private List<n> flC;
    private com.baidu.adp.lib.e.b<n> flD;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.flC = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.flB = list;
        aYJ();
    }

    private void aYJ() {
        if (!u.v(this.flB)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.flB) {
                if (fVar != null) {
                    n fS = this.flD.fS();
                    fS.setData(fVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.ag(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16)) / 2, -2);
                    fS.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds20), 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), 0);
                    addView(fS, layoutParams);
                    this.flC.add(fS);
                }
            }
        }
    }

    public void recycle() {
        if (!u.v(this.flC)) {
            for (n nVar : this.flC) {
                this.flD.n(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.flD = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.flC) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
