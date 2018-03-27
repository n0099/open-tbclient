package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager ffB;
    private C0216a gqA;
    private com.baidu.adp.lib.e.b<n> gqB;
    private com.baidu.tieba.personPolymeric.c.c gqz;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gqA = new C0216a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.g.common_forum_title);
        this.ffB = (ListViewPager) view.findViewById(d.g.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.ffB.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.C0141d.cp_bg_line_d);
            aj.r(this.mTitle, d.C0141d.cp_cont_d);
            int childCount = this.ffB.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ffB.getChildAt(i2);
                if (childAt instanceof m) {
                    ((m) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.gqz = cVar;
            if (v.D(cVar.gpN) <= 2) {
                this.ffB.getLayoutParams().height = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds140);
            }
            this.ffB.setAdapter(this.gqA);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0216a extends PagerAdapter {
        private C0216a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.gqz == null || v.E(a.this.gqz.gpN)) {
                return 0;
            }
            return a.this.gqz.gpN.size() % 4 == 0 ? a.this.gqz.gpN.size() / 4 : (a.this.gqz.gpN.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof m) {
                m mVar = (m) obj;
                mVar.recycle();
                viewGroup.removeView(mVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> tO = a.this.tO(i);
            if (v.E(tO)) {
                return null;
            }
            m mVar = new m(a.this.mPageContext.getPageActivity());
            mVar.setForumItemViewBdObjectPool(a.this.gqB);
            mVar.setData(tO);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> tO(int i) {
        if (this.gqz == null || v.E(this.gqz.gpN)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.f(this.gqz.gpN, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<n> bVar) {
        this.gqB = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.E(cVar.gpN) || cVar == this.gqz) {
            return false;
        }
        if (this.gqz == null || v.E(this.gqz.gpN)) {
            return true;
        }
        if (v.E(cVar.gpN)) {
            return false;
        }
        if (cVar.gpN.size() != this.gqz.gpN.size()) {
            return true;
        }
        for (int i = 0; i < cVar.gpN.size(); i++) {
            if (this.gqz.gpN.get(i) == null || cVar.gpN.get(i).forumId != this.gqz.gpN.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
