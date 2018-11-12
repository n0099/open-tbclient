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
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonCenterAttentionBarListView extends LinearLayout {
    private View bvs;
    public ListViewPager fkQ;
    private com.baidu.tieba.personPolymeric.c.c grY;
    private Context gsV;
    private a gsW;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gsa;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public PersonCenterAttentionBarListView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gsW = new a();
        this.gsa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnZ */
            public PersonCommonForumItemView jz() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.gsV);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView v(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView w(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gsW = new a();
        this.gsa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnZ */
            public PersonCommonForumItemView jz() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.gsV);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView v(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView w(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    public PersonCenterAttentionBarListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gsW = new a();
        this.gsa = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<PersonCommonForumItemView>() { // from class: com.baidu.tieba.personPolymeric.view.PersonCenterAttentionBarListView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bnZ */
            public PersonCommonForumItemView jz() {
                return new PersonCommonForumItemView(PersonCenterAttentionBarListView.this.gsV);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(PersonCommonForumItemView personCommonForumItemView) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public PersonCommonForumItemView v(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public PersonCommonForumItemView w(PersonCommonForumItemView personCommonForumItemView) {
                return personCommonForumItemView;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.gsV = context;
        this.rootView = LayoutInflater.from(this.gsV).inflate(e.h.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.common_forum_title);
        this.fkQ = (ListViewPager) this.rootView.findViewById(e.g.common_forum_viewpager);
        this.bvs = this.rootView.findViewById(e.g.divider_line);
        this.fkQ.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.rootView, e.d.cp_bg_line_d);
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.bvs, e.d.cp_bg_line_e);
            int childCount = this.fkQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.fkQ.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    public int getLayout() {
        return e.h.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.grY = cVar;
                if (v.H(cVar.grn) <= 2) {
                    this.fkQ.getLayoutParams().height = com.baidu.adp.lib.util.l.h(this.gsV, e.C0200e.tbds172);
                } else {
                    this.fkQ.getLayoutParams().height = com.baidu.adp.lib.util.l.h(this.gsV, e.C0200e.tbds344);
                }
                this.fkQ.setAdapter(this.gsW);
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
            if (PersonCenterAttentionBarListView.this.grY == null || v.I(PersonCenterAttentionBarListView.this.grY.grn)) {
                return 0;
            }
            return PersonCenterAttentionBarListView.this.grY.grn.size() % 4 == 0 ? PersonCenterAttentionBarListView.this.grY.grn.size() / 4 : (PersonCenterAttentionBarListView.this.grY.grn.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> sO = PersonCenterAttentionBarListView.this.sO(i);
            if (v.I(sO)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(PersonCenterAttentionBarListView.this.gsV);
            personCommonForumCardView.setForumItemViewBdObjectPool(PersonCenterAttentionBarListView.this.gsa);
            personCommonForumCardView.setData(sO);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.tbds42));
            personCommonForumCardView.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.tbds48));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> sO(int i) {
        if (this.grY == null || v.I(this.grY.grn)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.d(this.grY.grn, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.I(cVar.grn) || cVar == this.grY) {
            return false;
        }
        if (this.grY == null || v.I(this.grY.grn)) {
            return true;
        }
        if (v.I(cVar.grn)) {
            return false;
        }
        if (cVar.grn.size() != this.grY.grn.size()) {
            return true;
        }
        for (int i = 0; i < cVar.grn.size(); i++) {
            if (this.grY.grn.get(i) == null || cVar.grn.get(i).forumId != this.grY.grn.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
