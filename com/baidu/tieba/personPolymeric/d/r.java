package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> eXE;
    private List<s> eXF;
    private com.baidu.adp.lib.e.b<s> eXG;
    private Context mContext;

    public r(Context context) {
        super(context);
        this.eXF = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.eXE = list;
        aVD();
    }

    private void aVD() {
        if (!com.baidu.tbadk.core.util.z.t(this.eXE)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.eXE) {
                if (fVar != null) {
                    s fJ = this.eXG.fJ();
                    fJ.setData(fVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16)) / 2, -2);
                    fJ.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), 0);
                    addView(fJ, layoutParams);
                    this.eXF.add(fJ);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.z.t(this.eXF)) {
            for (s sVar : this.eXF) {
                this.eXG.n(sVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eXG = bVar;
    }

    public void onChangeSkinType() {
        for (s sVar : this.eXF) {
            if (sVar != null) {
                sVar.onChangeSkinType();
            }
        }
    }
}
