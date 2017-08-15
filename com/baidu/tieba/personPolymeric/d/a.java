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
    private com.baidu.tieba.personPolymeric.c.c fmE;
    private C0115a fmF;
    private com.baidu.adp.lib.e.b<n> fmG;
    private int mSkinType;
    public TextView mTitle;
    private TbPageContext<?> oV;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fmF = new C0115a();
        this.oV = tbPageContext;
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
            this.fmE = cVar;
            if (u.u(cVar.fmf) <= 2) {
                this.dUQ.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.oV.getPageActivity(), d.f.ds140);
            }
            this.dUQ.setAdapter(this.fmF);
        }
        d(this.oV, TbadkCoreApplication.getInst().getSkinType());
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
            if (a.this.fmE == null || u.v(a.this.fmE.fmf)) {
                return 0;
            }
            return a.this.fmE.fmf.size() % 4 == 0 ? a.this.fmE.fmf.size() / 4 : (a.this.fmE.fmf.size() / 4) + 1;
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
            m mVar = new m(a.this.oV.getPageActivity());
            mVar.setForumItemViewBdObjectPool(a.this.fmG);
            mVar.setData(qp);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qp(int i) {
        if (this.fmE == null || u.v(this.fmE.fmf)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) u.c(this.fmE.fmf, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fmG = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || u.v(cVar.fmf) || cVar == this.fmE) {
            return false;
        }
        if (this.fmE == null || u.v(this.fmE.fmf)) {
            return true;
        }
        if (u.v(cVar.fmf)) {
            return false;
        }
        if (cVar.fmf.size() != this.fmE.fmf.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fmf.size(); i++) {
            if (this.fmE.fmf.get(i) == null || cVar.fmf.get(i).forumId != this.fmE.fmf.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
