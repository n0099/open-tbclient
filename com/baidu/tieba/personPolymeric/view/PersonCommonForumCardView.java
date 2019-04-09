package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> hTw;
    private List<PersonCommonForumItemView> hTx;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> hTy;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.hTx = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.hTw = list;
        aOO();
    }

    private void aOO() {
        if (!v.T(this.hTw)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.hTw) {
                if (fVar != null) {
                    PersonCommonForumItemView jA = this.hTy.jA();
                    jA.setData(fVar);
                    addView(jA, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds96)) / 2, -2));
                    this.hTx.add(jA);
                }
            }
        }
    }

    public void recycle() {
        if (!v.T(this.hTx)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.hTx) {
                this.hTy.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.hTy = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.hTx) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
