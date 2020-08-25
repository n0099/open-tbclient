package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> lqe;
    private List<PersonCommonForumItemView> lqf;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> lqg;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.lqf = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.lqe = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!y.isEmpty(this.lqe)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.lqe) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.lqg.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.lqf.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!y.isEmpty(this.lqf)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.lqf) {
                this.lqg.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.lqg = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.lqf) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
