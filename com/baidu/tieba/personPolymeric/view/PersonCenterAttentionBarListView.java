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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {
    private View cTa;
    public ListViewPager hcK;
    private com.baidu.tieba.personPolymeric.c.c ilm;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> ilo;
    private Context imk;
    private a iml;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public PersonCenterAttentionBarListView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iml = new a();
        this.ilo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bZK */
            public PersonCommonForumItemView makeObject() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.imk);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView activateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView passivateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iml = new a();
        this.ilo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bZK */
            public PersonCommonForumItemView makeObject() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.imk);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView activateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView passivateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iml = new a();
        this.ilo = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bZK */
            public PersonCommonForumItemView makeObject() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.imk);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void destroyObject(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView activateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView passivateObject(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.imk = context;
        this.rootView = LayoutInflater.from(this.imk).inflate(R.layout.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.common_forum_title);
        this.hcK = (ListViewPager) this.rootView.findViewById(R.id.common_forum_viewpager);
        this.cTa = this.rootView.findViewById(R.id.divider_line);
        this.hcK.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.rootView, R.color.cp_bg_line_d);
            al.j(this.mTitle, R.color.cp_cont_b);
            al.l(this.cTa, R.color.cp_bg_line_e);
            int childCount = this.hcK.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.hcK.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    public int getLayout() {
        return R.layout.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.ilm = cVar;
                if (v.Z(cVar.ikB) <= 2) {
                    this.hcK.getLayoutParams().height = com.baidu.adp.lib.util.l.g(this.imk, R.dimen.tbds172);
                } else {
                    this.hcK.getLayoutParams().height = com.baidu.adp.lib.util.l.g(this.imk, R.dimen.tbds344);
                }
                this.hcK.setAdapter(this.iml);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes6.dex */
    private class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (PersonCenterAttentionBarListView.this.ilm == null || v.aa(PersonCenterAttentionBarListView.this.ilm.ikB)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.ilm.ikB.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.ilm.ikB.size() / 4 : (PersonCenterAttentionBarListView.this.ilm.ikB.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> ym = PersonCenterAttentionBarListView.this.ym(i);
            if (v.aa(ym)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.imk);
            personCommonForumCardView.setForumItemViewBdObjectPool(PersonCenterAttentionBarListView.this.ilo);
            personCommonForumCardView.setData(ym);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds48));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> ym(int i) {
        if (this.ilm == null || v.aa(this.ilm.ikB)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.ilm.ikB, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.aa(cVar.ikB) || cVar == this.ilm) {
            return false;
        }
        if (this.ilm == null || v.aa(this.ilm.ikB)) {
            return true;
        }
        if (v.aa(cVar.ikB)) {
            return false;
        }
        if (cVar.ikB.size() != this.ilm.ikB.size()) {
            return true;
        }
        for (int i = 0; i < cVar.ikB.size(); i++) {
            if (this.ilm.ikB.get(i) == null || cVar.ikB.get(i).forumId != this.ilm.ikB.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
