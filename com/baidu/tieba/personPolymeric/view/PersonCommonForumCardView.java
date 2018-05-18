package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCommonForumCardView extends FlowLayout {
    private List<com.baidu.tieba.personPolymeric.c.f> fNd;
    private List<PersonCommonForumItemView> fNe;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fNf;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.fNe = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fNd = list;
        bfJ();
    }

    private void bfJ() {
        if (!v.w(this.fNd)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fNd) {
                if (fVar != null) {
                    PersonCommonForumItemView fn = this.fNf.fn();
                    fn.setData(fVar);
                    addView(fn, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds96)) / 2, -2));
                    this.fNe.add(fn);
                }
            }
        }
    }

    public void recycle() {
        if (!v.w(this.fNe)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.fNe) {
                this.fNf.m(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.fNf = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.fNe) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
