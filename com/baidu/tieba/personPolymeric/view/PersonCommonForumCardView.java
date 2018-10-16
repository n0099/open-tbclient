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
    private List<com.baidu.tieba.personPolymeric.c.f> grx;
    private List<PersonCommonForumItemView> gry;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> grz;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gry = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.grx = list;
        axU();
    }

    private void axU() {
        if (!v.J(this.grx)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.grx) {
                if (fVar != null) {
                    PersonCommonForumItemView jA = this.grz.jA();
                    jA.setData(fVar);
                    addView(jA, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds96)) / 2, -2));
                    this.gry.add(jA);
                }
            }
        }
    }

    public void recycle() {
        if (!v.J(this.gry)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gry) {
                this.grz.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.grz = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gry) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
