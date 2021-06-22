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
import d.a.o0.j2.e.c;
import d.a.o0.j2.e.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20055e;

    /* renamed from: f  reason: collision with root package name */
    public c f20056f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20057g;

    /* renamed from: h  reason: collision with root package name */
    public ListViewPager f20058h;

    /* renamed from: i  reason: collision with root package name */
    public View f20059i;
    public View j;
    public d.a.c.e.k.b<PersonCommonForumItemView> k;

    /* loaded from: classes5.dex */
    public class a implements d.a.c.e.k.c<PersonCommonForumItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView a(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            e(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView c(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            h(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        public PersonCommonForumItemView e(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(PersonCommonForumItemView personCommonForumItemView) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public PersonCommonForumItemView d() {
            return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.f20055e);
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
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (PersonCenterAttentionBarListView.this.f20056f == null || ListUtils.isEmpty(PersonCenterAttentionBarListView.this.f20056f.f60208e)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.f20056f.f60208e.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.f20056f.f60208e.size() / 4 : (PersonCenterAttentionBarListView.this.f20056f.f60208e.size() / 4) + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            List<f> e2 = PersonCenterAttentionBarListView.this.e(i2);
            if (ListUtils.isEmpty(e2)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.f20055e);
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
        this.k = new d.a.c.e.k.b<>(new a(), 12, 0);
        f(context);
    }

    public final List<f> e(int i2) {
        c cVar = this.f20056f;
        if (cVar == null || ListUtils.isEmpty(cVar.f60208e)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = i2 * 4;
        for (int i4 = i3; i4 < i3 + 4; i4++) {
            f fVar = (f) ListUtils.getItem(this.f20056f.f60208e, i4);
            if (fVar != null) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public final void f(Context context) {
        this.f20055e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.person_info_common_forum_layout, this);
        this.f20059i = inflate;
        this.f20057g = (TextView) inflate.findViewById(R.id.common_forum_title);
        this.f20058h = (ListViewPager) this.f20059i.findViewById(R.id.common_forum_viewpager);
        this.j = this.f20059i.findViewById(R.id.divider_line);
        this.f20058h.setOffscreenPageLimit(1);
    }

    public int getLayout() {
        return R.layout.person_info_common_forum_layout;
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new b(this, null);
        this.k = new d.a.c.e.k.b<>(new a(), 12, 0);
        f(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new b(this, null);
        this.k = new d.a.c.e.k.b<>(new a(), 12, 0);
        f(context);
    }
}
