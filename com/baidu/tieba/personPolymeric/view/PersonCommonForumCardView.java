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
    private List<com.baidu.tieba.personPolymeric.c.f> gsY;
    private List<PersonCommonForumItemView> gsZ;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gta;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gsZ = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gsY = list;
        axr();
    }

    private void axr() {
        if (!v.I(this.gsY)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gsY) {
                if (fVar != null) {
                    PersonCommonForumItemView jy = this.gta.jy();
                    jy.setData(fVar);
                    addView(jy, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds96)) / 2, -2));
                    this.gsZ.add(jy);
                }
            }
        }
    }

    public void recycle() {
        if (!v.I(this.gsZ)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gsZ) {
                this.gta.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gta = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gsZ) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
