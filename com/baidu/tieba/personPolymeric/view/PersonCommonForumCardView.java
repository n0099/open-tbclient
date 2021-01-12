package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private Context mContext;
    private List<com.baidu.tieba.personPolymeric.c.f> mwb;
    private List<PersonCommonForumItemView> mwc;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mwd;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.mwc = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.mwb = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!x.isEmpty(this.mwb)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.mwb) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.mwd.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.mwc.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!x.isEmpty(this.mwc)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.mwc) {
                this.mwd.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mwd = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.mwc) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
