package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eIN;
    private List<q> eIO;
    private com.baidu.adp.lib.e.b<q> eIP;
    private Context mContext;

    public p(Context context) {
        super(context);
        this.eIO = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eIN = list;
        aRw();
    }

    private void aRw() {
        if (!com.baidu.tbadk.core.util.x.q(this.eIN)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eIN) {
                if (eVar != null) {
                    q fE = this.eIP.fE();
                    fE.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.ag(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16)) / 2, -2);
                    fE.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), 0);
                    addView(fE, layoutParams);
                    this.eIO.add(fE);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.q(this.eIO)) {
            for (q qVar : this.eIO) {
                this.eIP.n(qVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<q> bVar) {
        this.eIP = bVar;
    }

    public void tD() {
        for (q qVar : this.eIO) {
            if (qVar != null) {
                qVar.tD();
            }
        }
    }
}
