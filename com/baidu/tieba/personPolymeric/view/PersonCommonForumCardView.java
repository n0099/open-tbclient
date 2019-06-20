package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> imn;
    private List<PersonCommonForumItemView> imo;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> imp;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.imo = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.imn = list;
        aVb();
    }

    private void aVb() {
        if (!v.aa(this.imn)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.imn) {
                if (fVar != null) {
                    PersonCommonForumItemView iu = this.imp.iu();
                    iu.setData(fVar);
                    addView(iu, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.imo.add(iu);
                }
            }
        }
    }

    public void recycle() {
        if (!v.aa(this.imo)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.imo) {
                this.imp.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.imp = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.imo) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
