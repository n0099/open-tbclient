package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {
    private View bam;
    public ListViewPager eAn;
    private Context fLX;
    private a fLY;
    private com.baidu.tieba.personPolymeric.c.c fLa;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fLc;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public PersonCenterAttentionBarListView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fLY = new a();
        this.fLc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beW */
            public PersonCommonForumItemView fo() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.fLX);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView o(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView p(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fLY = new a();
        this.fLc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beW */
            public PersonCommonForumItemView fo() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.fLX);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView o(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView p(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fLY = new a();
        this.fLc = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: beW */
            public PersonCommonForumItemView fo() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.fLX);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView o(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView p(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.fLX = context;
        this.rootView = LayoutInflater.from(this.fLX).inflate(d.i.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.common_forum_title);
        this.eAn = (ListViewPager) this.rootView.findViewById(d.g.common_forum_viewpager);
        this.bam = this.rootView.findViewById(d.g.divider_line);
        this.eAn.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.i(this.rootView, d.C0126d.cp_bg_line_d);
            ak.h(this.mTitle, d.C0126d.cp_cont_b);
            ak.j(this.bam, d.C0126d.cp_bg_line_e);
            int childCount = this.eAn.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eAn.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    public int getLayout() {
        return d.i.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.fLa = cVar;
                if (v.v(cVar.fKp) <= 2) {
                    this.eAn.getLayoutParams().height = com.baidu.adp.lib.util.l.e(this.fLX, d.e.tbds172);
                } else {
                    this.eAn.getLayoutParams().height = com.baidu.adp.lib.util.l.e(this.fLX, d.e.tbds344);
                }
                this.eAn.setAdapter(this.fLY);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes3.dex */
    private class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (PersonCenterAttentionBarListView.this.fLa == null || v.w(PersonCenterAttentionBarListView.this.fLa.fKp)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.fLa.fKp.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.fLa.fKp.size() / 4 : (PersonCenterAttentionBarListView.this.fLa.fKp.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.recycle();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> rk = PersonCenterAttentionBarListView.this.rk(i);
            if (v.w(rk)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.fLX);
            personCommonForumCardView.setForumItemViewBdObjectPool(PersonCenterAttentionBarListView.this.fLc);
            personCommonForumCardView.setData(rk);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
            personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds48));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> rk(int i) {
        if (this.fLa == null || v.w(this.fLa.fKp)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.fLa.fKp, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.w(cVar.fKp) || cVar == this.fLa) {
            return false;
        }
        if (this.fLa == null || v.w(this.fLa.fKp)) {
            return true;
        }
        if (v.w(cVar.fKp)) {
            return false;
        }
        if (cVar.fKp.size() != this.fLa.fKp.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fKp.size(); i++) {
            if (this.fLa.fKp.get(i) == null || cVar.fKp.get(i).forumId != this.fLa.fKp.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
