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
    private List<com.baidu.tieba.personPolymeric.c.f> gCF;
    private List<PersonCommonForumItemView> gCG;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gCH;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gCG = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gCF = list;
        anJ();
    }

    private void anJ() {
        if (!v.I(this.gCF)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gCF) {
                if (fVar != null) {
                    PersonCommonForumItemView jy = this.gCH.jy();
                    jy.setData(fVar);
                    addView(jy, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds96)) / 2, -2));
                    this.gCG.add(jy);
                }
            }
        }
    }

    public void recycle() {
        if (!v.I(this.gCG)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gCG) {
                this.gCH.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gCH = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gCG) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
