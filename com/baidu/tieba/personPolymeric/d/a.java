package com.baidu.tieba.personPolymeric.d;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager dUQ;
    private com.baidu.tieba.personPolymeric.c.c fmG;
    private C0115a fmH;
    private com.baidu.adp.lib.e.b<n> fmI;
    private int mSkinType;
    public TextView mTitle;
    private TbPageContext<?> oW;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fmH = new C0115a();
        this.oW = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.h.common_forum_title);
        this.dUQ = (ListViewPager) view.findViewById(d.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dUQ.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_d);
            int childCount = this.dUQ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dUQ.getChildAt(i2);
                if (childAt instanceof m) {
                    ((m) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.fmG = cVar;
            if (u.u(cVar.fmh) <= 2) {
                this.dUQ.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.oW.getPageActivity(), d.f.ds140);
            }
            this.dUQ.setAdapter(this.fmH);
        }
        d(this.oW, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115a extends PagerAdapter {
        private C0115a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.fmG == null || u.v(a.this.fmG.fmh)) {
                return 0;
            }
            return a.this.fmG.fmh.size() % 4 == 0 ? a.this.fmG.fmh.size() / 4 : (a.this.fmG.fmh.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qp = a.this.qp(i);
            if (u.v(qp)) {
                return null;
            }
            m mVar = new m(a.this.oW.getPageActivity());
            mVar.setForumItemViewBdObjectPool(a.this.fmI);
            mVar.setData(qp);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qp(int i) {
        if (this.fmG == null || u.v(this.fmG.fmh)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) u.c(this.fmG.fmh, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fmI = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || u.v(cVar.fmh) || cVar == this.fmG) {
            return false;
        }
        if (this.fmG == null || u.v(this.fmG.fmh)) {
            return true;
        }
        if (u.v(cVar.fmh)) {
            return false;
        }
        if (cVar.fmh.size() != this.fmG.fmh.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fmh.size(); i++) {
            if (this.fmG.fmh.get(i) == null || cVar.fmh.get(i).forumId != this.fmG.fmh.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
