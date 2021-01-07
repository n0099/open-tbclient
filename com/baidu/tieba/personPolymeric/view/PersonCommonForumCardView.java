package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> mAF;
    private List<PersonCommonForumItemView> mAG;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mAH;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.mAG = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.mAF = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!x.isEmpty(this.mAF)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.mAF) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.mAH.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.mAG.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!x.isEmpty(this.mAG)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.mAG) {
                this.mAH.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mAH = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.mAG) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
