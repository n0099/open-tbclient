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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {
    private View biz;
    public ListViewPager eMM;
    private com.baidu.tieba.personPolymeric.c.c fXp;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fXr;
    private Context fYm;
    private a fYn;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public PersonCenterAttentionBarListView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fYn = new a();
        this.fXr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjW */
            public PersonCommonForumItemView mo9if() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.fYm);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView r(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView s(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fYn = new a();
        this.fXr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjW */
            public PersonCommonForumItemView mo9if() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.fYm);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView r(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView s(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fYn = new a();
        this.fXr = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjW */
            public PersonCommonForumItemView mo9if() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.fYm);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView r(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView s(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.fYm = context;
        this.rootView = LayoutInflater.from(this.fYm).inflate(d.i.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.common_forum_title);
        this.eMM = (ListViewPager) this.rootView.findViewById(d.g.common_forum_viewpager);
        this.biz = this.rootView.findViewById(d.g.divider_line);
        this.eMM.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.rootView, d.C0141d.cp_bg_line_d);
            al.h(this.mTitle, d.C0141d.cp_cont_b);
            al.j(this.biz, d.C0141d.cp_bg_line_e);
            int childCount = this.eMM.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eMM.getChildAt(i2);
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
                this.fXp = cVar;
                if (w.y(cVar.fWE) <= 2) {
                    this.eMM.getLayoutParams().height = com.baidu.adp.lib.util.l.e(this.fYm, d.e.tbds172);
                } else {
                    this.eMM.getLayoutParams().height = com.baidu.adp.lib.util.l.e(this.fYm, d.e.tbds344);
                }
                this.eMM.setAdapter(this.fYn);
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
            if (PersonCenterAttentionBarListView.this.fXp == null || w.z(PersonCenterAttentionBarListView.this.fXp.fWE)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.fXp.fWE.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.fXp.fWE.size() / 4 : (PersonCenterAttentionBarListView.this.fXp.fWE.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
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
            List<com.baidu.tieba.personPolymeric.c.f> rv = PersonCenterAttentionBarListView.this.rv(i);
            if (w.z(rv)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.fYm);
            personCommonForumCardView.setForumItemViewBdObjectPool(PersonCenterAttentionBarListView.this.fXr);
            personCommonForumCardView.setData(rv);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
            personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds48));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> rv(int i) {
        if (this.fXp == null || w.z(this.fXp.fWE)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) w.c(this.fXp.fWE, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || w.z(cVar.fWE) || cVar == this.fXp) {
            return false;
        }
        if (this.fXp == null || w.z(this.fXp.fWE)) {
            return true;
        }
        if (w.z(cVar.fWE)) {
            return false;
        }
        if (cVar.fWE.size() != this.fXp.fWE.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fWE.size(); i++) {
            if (this.fXp.fWE.get(i) == null || cVar.fWE.get(i).forumId != this.fXp.fWE.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
