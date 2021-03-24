package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import d.b.b.e.k.b;
import d.b.b.e.p.l;
import d.b.i0.h2.e.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonCommonForumCardView extends FlowLayout {
    public Context i;
    public List<f> j;
    public List<PersonCommonForumItemView> k;
    public b<PersonCommonForumItemView> l;

    public PersonCommonForumCardView(Context context) {
        super(context);
        this.k = new ArrayList();
        this.i = context;
    }

    public final void i() {
        if (ListUtils.isEmpty(this.j)) {
            return;
        }
        for (f fVar : this.j) {
            if (fVar != null) {
                PersonCommonForumItemView b2 = this.l.b();
                b2.setData(fVar);
                addView(b2, new ViewGroup.LayoutParams(((l.k(this.i) - l.g(this.i, R.dimen.tbds88)) - l.g(this.i, R.dimen.tbds96)) / 2, -2));
                this.k.add(b2);
            }
        }
    }

    public void j() {
        for (PersonCommonForumItemView personCommonForumItemView : this.k) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.e();
            }
        }
    }

    public void k() {
        if (ListUtils.isEmpty(this.k)) {
            return;
        }
        for (PersonCommonForumItemView personCommonForumItemView : this.k) {
            this.l.e(personCommonForumItemView);
        }
        removeAllViews();
    }

    public void setData(List<f> list) {
        this.j = list;
        i();
    }

    public void setForumItemViewBdObjectPool(b<PersonCommonForumItemView> bVar) {
        this.l = bVar;
    }
}
