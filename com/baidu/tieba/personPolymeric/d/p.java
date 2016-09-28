package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eLu;
    private List<q> eLv;
    private com.baidu.adp.lib.f.b<q> eLw;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eLv = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eLu = list;
        ala();
    }

    private void ala() {
        if (!com.baidu.tbadk.core.util.y.t(this.eLu)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eLu) {
                if (eVar != null) {
                    q ey = this.eLw.ey();
                    ey.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds80)) - com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16)) / 2, -2);
                    ey.setPadding(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds16), 0, com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds14), 0);
                    addView(ey, layoutParams);
                    this.eLv.add(ey);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.y.t(this.eLv)) {
            for (q qVar : this.eLv) {
                this.eLw.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.f.b<q> bVar) {
        this.eLw = bVar;
    }
}
