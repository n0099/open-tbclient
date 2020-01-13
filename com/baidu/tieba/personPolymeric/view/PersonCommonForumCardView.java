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
    private List<com.baidu.tieba.personPolymeric.c.f> jqQ;
    private List<PersonCommonForumItemView> jqR;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> jqS;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.jqR = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.jqQ = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.isEmpty(this.jqQ)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.jqQ) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.jqS.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.jqR.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!v.isEmpty(this.jqR)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.jqR) {
                this.jqS.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.jqS = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.jqR) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
