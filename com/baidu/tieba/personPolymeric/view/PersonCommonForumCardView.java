package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private Context mContext;
    private List<com.baidu.tieba.personPolymeric.c.f> mHx;
    private List<PersonCommonForumItemView> mHy;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mHz;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.mHy = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.mHx = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!y.isEmpty(this.mHx)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.mHx) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.mHz.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.mHy.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!y.isEmpty(this.mHy)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.mHy) {
                this.mHz.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mHz = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.mHy) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
