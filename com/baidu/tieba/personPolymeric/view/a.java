package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager fkQ;
    private com.baidu.tieba.personPolymeric.c.c grY;
    private C0283a grZ;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> gsa;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.grZ = new C0283a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(e.g.common_forum_title);
        this.fkQ = (ListViewPager) view.findViewById(e.g.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.fkQ.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.h(this.mTitle, e.d.cp_cont_d);
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

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.grY = cVar;
            if (v.H(cVar.grn) <= 2) {
                this.fkQ.getLayoutParams().height = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), e.C0200e.ds140);
            }
            this.fkQ.setAdapter(this.grZ);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0283a extends PagerAdapter {
        private C0283a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.grY == null || v.I(a.this.grY.grn)) {
                return 0;
            }
            return a.this.grY.grn.size() % 4 == 0 ? a.this.grY.grn.size() / 4 : (a.this.grY.grn.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> sO = a.this.sO(i);
            if (v.I(sO)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.gsa);
            personCommonForumCardView.setData(sO);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(e.C0200e.tbds42));
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

    public void a(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.gsa = bVar;
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
