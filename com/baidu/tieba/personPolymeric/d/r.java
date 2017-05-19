package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.e> eEG;
    private List<s> eEH;
    private com.baidu.adp.lib.e.b<s> eEI;
    private Context mContext;

    public r(Context context) {
        super(context);
        this.eEH = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.e> list) {
        this.eEG = list;
        aQa();
    }

    private void aQa() {
        if (!com.baidu.tbadk.core.util.x.r(this.eEG)) {
            for (com.baidu.tieba.personPolymeric.c.e eVar : this.eEG) {
                if (eVar != null) {
                    s fK = this.eEI.fK();
                    fK.setData(eVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16)) / 2, -2);
                    fK.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), 0);
                    addView(fK, layoutParams);
                    this.eEH.add(fK);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.r(this.eEH)) {
            for (s sVar : this.eEH) {
                this.eEI.n(sVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eEI = bVar;
    }

    public void onChangeSkinType() {
        for (s sVar : this.eEH) {
            if (sVar != null) {
                sVar.onChangeSkinType();
            }
        }
    }
}
