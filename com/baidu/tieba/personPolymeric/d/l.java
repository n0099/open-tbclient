package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private View aVC;
    public ListViewPager dUQ;
    private com.baidu.tieba.personPolymeric.c.c fmE;
    private com.baidu.adp.lib.e.b<n> fmG;
    private Context fnr;
    private a fns;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fns = new a();
        this.fmG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.d.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aYJ */
            public n fT() {
                return new n(l.this.fnr);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void o(n nVar) {
                if (nVar != null) {
                    nVar.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public n p(n nVar) {
                return nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public n q(n nVar) {
                return nVar;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.fnr = context;
        this.rootView = LayoutInflater.from(this.fnr).inflate(d.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.h.common_forum_title);
        this.dUQ = (ListViewPager) this.rootView.findViewById(d.h.common_forum_viewpager);
        this.aVC = this.rootView.findViewById(d.h.divider_line);
        this.dUQ.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.j(this.rootView, d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_d);
            ai.k(this.aVC, d.e.cp_bg_line_b);
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

    public int getLayout() {
        return d.j.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.fmE = cVar;
                if (u.u(cVar.fmf) <= 2) {
                    this.dUQ.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.fnr, d.f.ds140);
                }
                this.dUQ.setAdapter(this.fns);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes.dex */
    private class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (l.this.fmE == null || u.v(l.this.fmE.fmf)) {
                return 0;
            }
            return l.this.fmE.fmf.size() % 4 == 0 ? l.this.fmE.fmf.size() / 4 : (l.this.fmE.fmf.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qp = l.this.qp(i);
            if (u.v(qp)) {
                return null;
            }
            m mVar = new m(l.this.fnr);
            mVar.setForumItemViewBdObjectPool(l.this.fmG);
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
