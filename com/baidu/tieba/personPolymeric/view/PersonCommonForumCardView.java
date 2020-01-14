package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> jqV;
    private List<PersonCommonForumItemView> jqW;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> jqX;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.jqW = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.jqV = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.isEmpty(this.jqV)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.jqV) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.jqX.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.jqW.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!v.isEmpty(this.jqW)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.jqW) {
                this.jqX.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.jqX = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.jqW) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
