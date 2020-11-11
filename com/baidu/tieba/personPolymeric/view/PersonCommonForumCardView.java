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
    private List<com.baidu.tieba.personPolymeric.c.f> mgS;
    private List<PersonCommonForumItemView> mgT;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mgU;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.mgT = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.mgS = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!y.isEmpty(this.mgS)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.mgS) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.mgU.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.mgT.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!y.isEmpty(this.mgT)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.mgT) {
                this.mgU.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mgU = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.mgT) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
