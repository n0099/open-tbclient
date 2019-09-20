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
    private List<com.baidu.tieba.personPolymeric.c.f> ivG;
    private List<PersonCommonForumItemView> ivH;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> ivI;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.ivH = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.ivG = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.aa(this.ivG)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.ivG) {
                if (fVar != null) {
                    PersonCommonForumItemView iD = this.ivI.iD();
                    iD.setData(fVar);
                    addView(iD, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.ivH.add(iD);
                }
            }
        }
    }

    public void recycle() {
        if (!v.aa(this.ivH)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.ivH) {
                this.ivI.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.ivI = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.ivH) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
