package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import d.b.i0.h2.e.c;
import d.b.i0.h2.e.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20465e;

    /* renamed from: f  reason: collision with root package name */
    public c f20466f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20467g;

    /* renamed from: h  reason: collision with root package name */
    public ListViewPager f20468h;
    public View i;
    public View j;
    public d.b.b.e.k.b<PersonCommonForumItemView> k;

    /* loaded from: classes5.dex */
    public class a implements d.b.b.e.k.c<PersonCommonForumItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView a(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            e(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView c(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            h(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        public PersonCommonForumItemView e(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(PersonCommonForumItemView personCommonForumItemView) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public PersonCommonForumItemView d() {
            return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.f20465e);
        }

        public PersonCommonForumItemView h(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends PagerAdapter {
        public b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (PersonCenterAttentionBarListView.this.f20466f == null || ListUtils.isEmpty(PersonCenterAttentionBarListView.this.f20466f.f55273e)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.f20466f.f55273e.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.f20466f.f55273e.size() / 4 : (PersonCenterAttentionBarListView.this.f20466f.f55273e.size() / 4) + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<f> e2 = PersonCenterAttentionBarListView.this.e(i);
            if (ListUtils.isEmpty(e2)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.f20465e);
            personCommonForumCardView.setForumItemViewBdObjectPool(PersonCenterAttentionBarListView.this.k);
            personCommonForumCardView.setData(e2);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds48));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public /* synthetic */ b(PersonCenterAttentionBarListView personCenterAttentionBarListView, a aVar) {
            this();
        }
    }

    public PersonCenterAttentionBarListView(Context context) {
        super(context);
        new b(this, null);
        this.k = new d.b.b.e.k.b<>(new a(), 12, 0);
        f(context);
    }

    public final List<f> e(int i) {
        c cVar = this.f20466f;
        if (cVar == null || ListUtils.isEmpty(cVar.f55273e)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        for (int i3 = i2; i3 < i2 + 4; i3++) {
            f fVar = (f) ListUtils.getItem(this.f20466f.f55273e, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public final void f(Context context) {
        this.f20465e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.person_info_common_forum_layout, this);
        this.i = inflate;
        this.f20467g = (TextView) inflate.findViewById(R.id.common_forum_title);
        this.f20468h = (ListViewPager) this.i.findViewById(R.id.common_forum_viewpager);
        this.j = this.i.findViewById(R.id.divider_line);
        this.f20468h.setOffscreenPageLimit(1);
    }

    public int getLayout() {
        return R.layout.person_info_common_forum_layout;
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new b(this, null);
        this.k = new d.b.b.e.k.b<>(new a(), 12, 0);
        f(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new b(this, null);
        this.k = new d.b.b.e.k.b<>(new a(), 12, 0);
        f(context);
    }
}
