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
    private List<com.baidu.tieba.personPolymeric.c.f> fLX;
    private List<PersonCommonForumItemView> fLY;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fLZ;
    private Context mContext;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.fLY = new ArrayList();
        this.mContext = context;
    }

    public void setData(List<com.baidu.tieba.personPolymeric.c.f> list) {
        this.fLX = list;
        bfJ();
    }

    private void bfJ() {
        if (!v.w(this.fLX)) {
            for (com.baidu.tieba.personPolymeric.c.f fVar : this.fLX) {
                if (fVar != null) {
                    PersonCommonForumItemView fn = this.fLZ.fn();
                    fn.setData(fVar);
                    addView(fn, new ViewGroup.LayoutParams(((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds88)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds96)) / 2, -2));
                    this.fLY.add(fn);
                }
            }
        }
    }

    public void recycle() {
        if (!v.w(this.fLY)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.fLY) {
                this.fLZ.m(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setForumItemViewBdObjectPool(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.fLZ = bVar;
    }

    public void onChangeSkinType() {
        for (PersonCommonForumItemView personCommonForumItemView : this.fLY) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.onChangeSkinType();
            }
        }
    }
}
