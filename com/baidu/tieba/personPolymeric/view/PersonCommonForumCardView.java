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
    private List<com.baidu.tieba.personPolymeric.c.f> hTJ;
    private List<PersonCommonForumItemView> hTK;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> hTL;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.hTK = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.hTJ = list;
        aOT();
    }

    private void aOT() {
        if (!v.T(this.hTJ)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.hTJ) {
                if (fVar != null) {
                    PersonCommonForumItemView jA = this.hTL.jA();
                    jA.setData(fVar);
                    addView(jA, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds96)) / 2, -2));
                    this.hTK.add(jA);
                }
            }
        }
    }

    public void recycle() {
        if (!v.T(this.hTK)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.hTK) {
                this.hTL.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.hTL = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.hTK) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
