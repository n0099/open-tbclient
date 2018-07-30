package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> gcH;
    private List<PersonCommonForumItemView> gcI;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gcJ;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gcI = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gcH = list;
        asL();
    }

    private void asL() {
        if (!w.z(this.gcH)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gcH) {
                if (fVar != null) {
                    PersonCommonForumItemView m9if = this.gcJ.m9if();
                    m9if.setData(fVar);
                    addView(m9if, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds96)) / 2, -2));
                    this.gcI.add(m9if);
                }
            }
        }
    }

    public void recycle() {
        if (!w.z(this.gcI)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gcI) {
                this.gcJ.p(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gcJ = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gcI) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
