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
    private List<com.baidu.tieba.personPolymeric.c.f> imm;
    private List<PersonCommonForumItemView> imn;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> imo;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.imn = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.imm = list;
        aVb();
    }

    private void aVb() {
        if (!v.aa(this.imm)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.imm) {
                if (fVar != null) {
                    PersonCommonForumItemView iu = this.imo.iu();
                    iu.setData(fVar);
                    addView(iu, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.imn.add(iu);
                }
            }
        }
    }

    public void recycle() {
        if (!v.aa(this.imn)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.imn) {
                this.imo.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.imo = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.imn) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
