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
    private List<com.baidu.tieba.personPolymeric.c.f> gjX;
    private List<PersonCommonForumItemView> gjY;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gjZ;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gjY = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gjX = list;
        auy();
    }

    private void auy() {
        if (!v.z(this.gjX)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gjX) {
                if (fVar != null) {
                    PersonCommonForumItemView jl = this.gjZ.jl();
                    jl.setData(fVar);
                    addView(jl, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds96)) / 2, -2));
                    this.gjY.add(jl);
                }
            }
        }
    }

    public void recycle() {
        if (!v.z(this.gjY)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gjY) {
                this.gjZ.q(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gjZ = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gjY) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
