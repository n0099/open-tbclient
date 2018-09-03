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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {
    private View bkJ;
    public ListViewPager eUs;
    private com.baidu.tieba.personPolymeric.c.c gbH;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gbJ;
    private Context gcD;
    private a gcE;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public PersonCenterAttentionBarListView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gcE = new a();
        this.gbJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: biS */
            public PersonCommonForumItemView ig() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.gcD);
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
        this.gcE = new a();
        this.gbJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: biS */
            public PersonCommonForumItemView ig() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.gcD);
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
        this.gcE = new a();
        this.gbJ = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: biS */
            public PersonCommonForumItemView ig() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.gcD);
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
        this.gcD = context;
        this.rootView = LayoutInflater.from(this.gcD).inflate(f.h.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(f.g.common_forum_title);
        this.eUs = (ListViewPager) this.rootView.findViewById(f.g.common_forum_viewpager);
        this.bkJ = this.rootView.findViewById(f.g.divider_line);
        this.eUs.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.rootView, f.d.cp_bg_line_d);
            am.h(this.mTitle, f.d.cp_cont_b);
            am.j(this.bkJ, f.d.cp_bg_line_e);
            int childCount = this.eUs.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eUs.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    public int getLayout() {
        return f.h.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.gbH = cVar;
                if (w.y(cVar.gaV) <= 2) {
                    this.eUs.getLayoutParams().height = com.baidu.adp.lib.util.l.f(this.gcD, f.e.tbds172);
                } else {
                    this.eUs.getLayoutParams().height = com.baidu.adp.lib.util.l.f(this.gcD, f.e.tbds344);
                }
                this.eUs.setAdapter(this.gcE);
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
            if (PersonCenterAttentionBarListView.this.gbH == null || w.z(PersonCenterAttentionBarListView.this.gbH.gaV)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.gbH.gaV.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.gbH.gaV.size() / 4 : (PersonCenterAttentionBarListView.this.gbH.gaV.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> rB = PersonCenterAttentionBarListView.this.rB(i);
            if (w.z(rB)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.gcD);
            personCommonForumCardView.setForumItemViewBdObjectPool(PersonCenterAttentionBarListView.this.gbJ);
            personCommonForumCardView.setData(rB);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.tbds42));
            personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(f.e.tbds48));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> rB(int i) {
        if (this.gbH == null || w.z(this.gbH.gaV)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) w.d(this.gbH.gaV, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || w.z(cVar.gaV) || cVar == this.gbH) {
            return false;
        }
        if (this.gbH == null || w.z(this.gbH.gaV)) {
            return true;
        }
        if (w.z(cVar.gaV)) {
            return false;
        }
        if (cVar.gaV.size() != this.gbH.gaV.size()) {
            return true;
        }
        for (int i = 0; i < cVar.gaV.size(); i++) {
            if (this.gbH.gaV.get(i) == null || cVar.gaV.get(i).forumId != this.gbH.gaV.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
