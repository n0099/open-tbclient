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
    private List<com.baidu.tieba.personPolymeric.c.f> mvr;
    private List<PersonCommonForumItemView> mvs;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mvt;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.mvs = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.mvr = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!y.isEmpty(this.mvr)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.mvr) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.mvt.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.mvs.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!y.isEmpty(this.mvs)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.mvs) {
                this.mvt.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mvt = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.mvs) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
