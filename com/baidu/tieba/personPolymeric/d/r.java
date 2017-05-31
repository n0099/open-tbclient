package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> eNv;
    private List<s> eNw;
    private com.baidu.adp.lib.e.b<s> eNx;
    private Context mContext;

    public r(Context context) {
        super(context);
        this.eNw = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.eNv = list;
        aRv();
    }

    private void aRv() {
        if (!com.baidu.tbadk.core.util.x.r(this.eNv)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.eNv) {
                if (fVar != null) {
                    s fK = this.eNx.fK();
                    fK.setData(fVar);
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.k.af(this.mContext) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds80)) - com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16)) / 2, -2);
                    fK.setPadding(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds16), 0, com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds14), 0);
                    addView(fK, layoutParams);
                    this.eNw.add(fK);
                }
            }
        }
    }

    public void recycle() {
        if (!com.baidu.tbadk.core.util.x.r(this.eNw)) {
            for (s sVar : this.eNw) {
                this.eNx.n(sVar);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eNx = bVar;
    }

    public void onChangeSkinType() {
        for (s sVar : this.eNw) {
            if (sVar != null) {
                sVar.onChangeSkinType();
            }
        }
    }
}
