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
    private List<com.baidu.tieba.personPolymeric.c.f> gzO;
    private List<PersonCommonForumItemView> gzP;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gzQ;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gzP = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gzO = list;
        anj();
    }

    private void anj() {
        if (!v.I(this.gzO)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gzO) {
                if (fVar != null) {
                    PersonCommonForumItemView jy = this.gzQ.jy();
                    jy.setData(fVar);
                    addView(jy, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.aO(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds88)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds96)) / 2, -2));
                    this.gzP.add(jy);
                }
            }
        }
    }

    public void recycle() {
        if (!v.I(this.gzP)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gzP) {
                this.gzQ.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gzQ = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gzP) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
