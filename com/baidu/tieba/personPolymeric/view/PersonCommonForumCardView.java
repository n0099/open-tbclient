package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> fYp;
    private List<PersonCommonForumItemView> fYq;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fYr;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.fYq = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fYp = list;
        bkI();
    }

    private void bkI() {
        if (!w.z(this.fYp)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fYp) {
                if (fVar != null) {
                    PersonCommonForumItemView ie = this.fYr.ie();
                    ie.setData(fVar);
                    addView(ie, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds96)) / 2, -2));
                    this.fYq.add(ie);
                }
            }
        }
    }

    public void recycle() {
        if (!w.z(this.fYq)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.fYq) {
                this.fYr.p(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.fYr = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.fYq) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
