package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> kwU;
    private List<PersonCommonForumItemView> kwV;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> kwW;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.kwV = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.kwU = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.isEmpty(this.kwU)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.kwU) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.kwW.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.kwV.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!v.isEmpty(this.kwV)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.kwV) {
                this.kwW.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.kwW = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.kwV) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
