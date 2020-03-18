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
    private List<com.baidu.tieba.personPolymeric.c.f> jtD;
    private List<PersonCommonForumItemView> jtE;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> jtF;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.jtE = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.jtD = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!v.isEmpty(this.jtD)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.jtD) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.jtF.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.jtE.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!v.isEmpty(this.jtE)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.jtE) {
                this.jtF.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.jtF = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.jtE) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
