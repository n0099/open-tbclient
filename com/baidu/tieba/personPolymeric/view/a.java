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
    public ListViewPager ffn;
    private com.baidu.tieba.personPolymeric.c.c gqj;
    private C0216a gqk;
    private com.baidu.adp.lib.e.b<n> gql;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gqk = new C0216a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.g.common_forum_title);
        this.ffn = (ListViewPager) view.findViewById(d.g.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.ffn.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.C0141d.cp_bg_line_d);
            aj.r(this.mTitle, d.C0141d.cp_cont_d);
            int childCount = this.ffn.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ffn.getChildAt(i2);
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
            this.gqj = cVar;
            if (v.D(cVar.gpx) <= 2) {
                this.ffn.getLayoutParams().height = com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds140);
            }
            this.ffn.setAdapter(this.gqk);
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
            if (a.this.gqj == null || v.E(a.this.gqj.gpx)) {
                return 0;
            }
            return a.this.gqj.gpx.size() % 4 == 0 ? a.this.gqj.gpx.size() / 4 : (a.this.gqj.gpx.size() / 4) + 1;
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
            mVar.setForumItemViewBdObjectPool(a.this.gql);
            mVar.setData(tO);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> tO(int i) {
        if (this.gqj == null || v.E(this.gqj.gpx)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.f(this.gqj.gpx, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<n> bVar) {
        this.gql = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.E(cVar.gpx) || cVar == this.gqj) {
            return false;
        }
        if (this.gqj == null || v.E(this.gqj.gpx)) {
            return true;
        }
        if (v.E(cVar.gpx)) {
            return false;
        }
        if (cVar.gpx.size() != this.gqj.gpx.size()) {
            return true;
        }
        for (int i = 0; i < cVar.gpx.size(); i++) {
            if (this.gqj.gpx.get(i) == null || cVar.gpx.get(i).forumId != this.gqj.gpx.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
