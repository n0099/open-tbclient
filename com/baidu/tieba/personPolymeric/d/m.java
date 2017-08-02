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
    private List<com.baidu.tieba.personPolymeric.c.f> fkp;
    private List<n> fkq;
    private com.baidu.adp.lib.e.b<n> fkr;
    private Context mContext;

    public m(Context context) {
        super(context);
        this.fkq = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fkp = list;
        aYy();
    }

    private void aYy() {
        if (!u.v(this.fkp)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fkp) {
                if (fVar != null) {
                    n fH = this.fkr.fH();
                    fH.setData(fVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds16)) / 2, -2);
                    fH.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds20), 0, com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds14), 0);
                    addView(fH, layoutParams);
                    this.fkq.add(fH);
                }
            }
        }
    }

    public void recycle() {
        if (!u.v(this.fkq)) {
            for (n nVar : this.fkq) {
                this.fkr.n(nVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fkr = bVar;
    }

    public void onChangeSkinType() {
        for (n nVar : this.fkq) {
            if (nVar != null) {
                nVar.onChangeSkinType();
            }
        }
    }
}
