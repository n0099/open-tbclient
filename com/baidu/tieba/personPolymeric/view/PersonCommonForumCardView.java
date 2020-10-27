package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private Context mContext;
    private List<com.baidu.tieba.personPolymeric.c.f> maV;
    private List<PersonCommonForumItemView> maW;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> maX;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.maW = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.maV = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!y.isEmpty(this.maV)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.maV) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.maX.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.maW.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!y.isEmpty(this.maW)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.maW) {
                this.maX.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.maX = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.maW) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
