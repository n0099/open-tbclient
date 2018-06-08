package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager eMM;
    private com.baidu.tieba.personPolymeric.c.c fXp;
    private C0214a fXq;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fXr;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fXq = new C0214a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.g.common_forum_title);
        this.eMM = (ListViewPager) view.findViewById(d.g.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.eMM.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.C0141d.cp_bg_line_d);
            al.h(this.mTitle, d.C0141d.cp_cont_d);
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

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.fXp = cVar;
            if (w.y(cVar.fWE) <= 2) {
                this.eMM.getLayoutParams().height = com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds140);
            }
            this.eMM.setAdapter(this.fXq);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0214a extends PagerAdapter {
        private C0214a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.fXp == null || w.z(a.this.fXp.fWE)) {
                return 0;
            }
            return a.this.fXp.fWE.size() % 4 == 0 ? a.this.fXp.fWE.size() / 4 : (a.this.fXp.fWE.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> rv = a.this.rv(i);
            if (w.z(rv)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.fXr);
            personCommonForumCardView.setData(rv);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
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

    public void a(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.fXr = bVar;
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
