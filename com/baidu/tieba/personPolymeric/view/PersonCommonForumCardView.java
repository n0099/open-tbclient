package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> grA;
    private List<com.baidu.tieba.personPolymeric.c.f> gry;
    private List<PersonCommonForumItemView> grz;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.grz = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gry = list;
        axV();
    }

    private void axV() {
        if (!v.J(this.gry)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gry) {
                if (fVar != null) {
                    PersonCommonForumItemView jA = this.grA.jA();
                    jA.setData(fVar);
                    addView(jA, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds96)) / 2, -2));
                    this.grz.add(jA);
                }
            }
        }
    }

    public void recycle() {
        if (!v.J(this.grz)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.grz) {
                this.grA.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.grA = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.grz) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
