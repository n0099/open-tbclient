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
    private List<com.baidu.tieba.personPolymeric.c.f> isE;
    private List<PersonCommonForumItemView> isF;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> isG;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.isF = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.isE = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.aa(this.isE)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.isE) {
                if (fVar != null) {
                    PersonCommonForumItemView iD = this.isG.iD();
                    iD.setData(fVar);
                    addView(iD, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.isF.add(iD);
                }
            }
        }
    }

    public void recycle() {
        if (!v.aa(this.isF)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.isF) {
                this.isG.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.isG = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.isF) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
