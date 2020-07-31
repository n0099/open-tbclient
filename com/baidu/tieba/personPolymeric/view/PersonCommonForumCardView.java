package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> kZN;
    private List<PersonCommonForumItemView> kZO;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> kZP;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.kZO = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.kZN = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!x.isEmpty(this.kZN)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.kZN) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.kZP.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.kZO.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!x.isEmpty(this.kZO)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.kZO) {
                this.kZP.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.kZP = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.kZO) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
