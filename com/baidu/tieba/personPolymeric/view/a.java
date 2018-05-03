package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager eAk;
    private com.baidu.tieba.personPolymeric.c.c fKX;
    private C0198a fKY;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> fKZ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fKY = new C0198a();
        this.mPageContext = tbPageContext;
        View view2 = getView();
        this.mTitle = (TextView) view2.findViewById(d.g.common_forum_title);
        this.eAk = (ListViewPager) view2.findViewById(d.g.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view2.setLayerType(2, null);
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).setClipChildren(true);
            }
        }
        this.eAk.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.h(this.mTitle, d.C0126d.cp_cont_d);
            int childCount = this.eAk.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.eAk.getChildAt(i2);
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
            this.fKX = cVar;
            if (v.v(cVar.fKm) <= 2) {
                this.eAk.getLayoutParams().height = com.baidu.adp.lib.util.l.e(this.mPageContext.getPageActivity(), d.e.ds140);
            }
            this.eAk.setAdapter(this.fKY);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0198a extends PagerAdapter {
        private C0198a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.fKX == null || v.w(a.this.fKX.fKm)) {
                return 0;
            }
            return a.this.fKX.fKm.size() % 4 == 0 ? a.this.fKX.fKm.size() / 4 : (a.this.fKX.fKm.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> rk = a.this.rk(i);
            if (v.w(rk)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.fKZ);
            personCommonForumCardView.setData(rk);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> rk(int i) {
        if (this.fKX == null || v.w(this.fKX.fKm)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.fKX.fKm, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.fKZ = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.w(cVar.fKm) || cVar == this.fKX) {
            return false;
        }
        if (this.fKX == null || v.w(this.fKX.fKm)) {
            return true;
        }
        if (v.w(cVar.fKm)) {
            return false;
        }
        if (cVar.fKm.size() != this.fKX.fKm.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fKm.size(); i++) {
            if (this.fKX.fKm.get(i) == null || cVar.fKm.get(i).forumId != this.fKX.fKm.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
