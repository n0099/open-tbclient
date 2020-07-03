package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> kQR;
    private List<PersonCommonForumItemView> kQS;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> kQT;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.kQS = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.kQR = list;
        bindDataToView();
    }

    private void bindDataToView() {
        if (!w.isEmpty(this.kQR)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.kQR) {
                if (fVar != null) {
                    PersonCommonForumItemView borrowObject = this.kQT.borrowObject();
                    borrowObject.setData(fVar);
                    addView(borrowObject, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds88)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds96)) / 2, -2));
                    this.kQS.add(borrowObject);
                }
            }
        }
    }

    public void recycle() {
        if (!w.isEmpty(this.kQS)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.kQS) {
                this.kQT.returnObject(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.kQT = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.kQS) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
