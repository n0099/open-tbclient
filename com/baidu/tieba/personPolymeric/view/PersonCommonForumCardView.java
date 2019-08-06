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
    private List<com.baidu.tieba.personPolymeric.c.f> itH;
    private List<PersonCommonForumItemView> itI;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> itJ;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.itI = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.itH = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.aa(this.itH)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.itH) {
                if (fVar != null) {
                    PersonCommonForumItemView iD = this.itJ.iD();
                    iD.setData(fVar);
                    addView(iD, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.itI.add(iD);
                }
            }
        }
    }

    public void recycle() {
        if (!v.aa(this.itI)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.itI) {
                this.itJ.t(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.itJ = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.itI) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
