package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> gcG;
    private List<PersonCommonForumItemView> gcH;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gcI;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gcH = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gcG = list;
        asK();
    }

    private void asK() {
        if (!w.z(this.gcG)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gcG) {
                if (fVar != null) {
                    PersonCommonForumItemView m9if = this.gcI.m9if();
                    m9if.setData(fVar);
                    addView(m9if, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds88)) - com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds96)) / 2, -2));
                    this.gcH.add(m9if);
                }
            }
        }
    }

    public void recycle() {
        if (!w.z(this.gcH)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gcH) {
                this.gcI.p(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gcI = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gcH) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
