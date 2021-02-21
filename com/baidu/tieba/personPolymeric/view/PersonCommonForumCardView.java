package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private Context mContext;
    private List<com.baidu.tieba.personPolymeric.c.f> mFu;
    private List<PersonCommonForumItemView> mFv;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mFw;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.mFv = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.mFu = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!y.isEmpty(this.mFu)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.mFu) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.mFw.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.mFv.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!y.isEmpty(this.mFv)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.mFv) {
                this.mFw.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mFw = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.mFv) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
