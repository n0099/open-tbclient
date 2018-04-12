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
    private List<com.baidu.tieba.personPolymeric.c.f> fMa;
    private List<PersonCommonForumItemView> fMb;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fMc;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.fMb = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fMa = list;
        bfJ();
    }

    private void bfJ() {
        if (!v.w(this.fMa)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fMa) {
                if (fVar != null) {
                    PersonCommonForumItemView fn = this.fMc.fn();
                    fn.setData(fVar);
                    addView(fn, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds96)) / 2, -2));
                    this.fMb.add(fn);
                }
            }
        }
    }

    public void recycle() {
        if (!v.w(this.fMb)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.fMb) {
                this.fMc.m(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.fMc = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.fMb) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
