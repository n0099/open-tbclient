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
    private List<com.baidu.tieba.personPolymeric.c.f> itr;
    private List<PersonCommonForumItemView> its;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> itt;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.its = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.itr = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.isEmpty(this.itr)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.itr) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.itt.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.its.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!v.isEmpty(this.its)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.its) {
                this.itt.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.itt = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.its) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
