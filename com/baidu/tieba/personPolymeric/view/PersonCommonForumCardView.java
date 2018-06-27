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
    private List<com.baidu.tieba.personPolymeric.c.f> gcp;
    private List<PersonCommonForumItemView> gcq;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gcr;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.gcq = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.gcp = list;
        ash();
    }

    private void ash() {
        if (!w.A(this.gcp)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.gcp) {
                if (fVar != null) {
                    PersonCommonForumItemView ie = this.gcr.ie();
                    ie.setData(fVar);
                    addView(ie, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds96)) / 2, -2));
                    this.gcq.add(ie);
                }
            }
        }
    }

    public void recycle() {
        if (!w.A(this.gcq)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.gcq) {
                this.gcr.p(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gcr = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.gcq) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
