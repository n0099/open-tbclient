package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends LinearLayout {
    private View aWK;
    public ListViewPager dYq;
    private com.baidu.tieba.personPolymeric.c.c fhr;
    private com.baidu.adp.lib.e.b<n> fht;
    private Context fie;
    private a fif;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fif = new a();
        this.fht = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aWq */
            public n fI() {
                return new n(l.this.fie);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(n nVar) {
                if (nVar != null) {
                    nVar.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public n o(n nVar) {
                return nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public n p(n nVar) {
                return nVar;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.fie = context;
        this.rootView = LayoutInflater.from(this.fie).inflate(d.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.h.common_forum_title);
        this.dYq = (ListViewPager) this.rootView.findViewById(d.h.common_forum_viewpager);
        this.aWK = this.rootView.findViewById(d.h.divider_line);
        this.dYq.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.rootView, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.aWK, d.e.cp_bg_line_e);
            int childCount = this.dYq.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dYq.getChildAt(i2);
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
                this.fhr = cVar;
                if (v.t(cVar.fgG) <= 2) {
                    this.dYq.getLayoutParams().height = com.baidu.adp.lib.util.l.f(this.fie, d.f.ds140);
                }
                this.dYq.setAdapter(this.fif);
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
            if (l.this.fhr == null || v.u(l.this.fhr.fgG)) {
                return 0;
            }
            return l.this.fhr.fgG.size() % 4 == 0 ? l.this.fhr.fgG.size() / 4 : (l.this.fhr.fgG.size() / 4) + 1;
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
            if (v.u(qp)) {
                return null;
            }
            m mVar = new m(l.this.fie);
            mVar.setForumItemViewBdObjectPool(l.this.fht);
            mVar.setData(qp);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds34));
            mVar.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds34));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qp(int i) {
        if (this.fhr == null || v.u(this.fhr.fgG)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.fhr.fgG, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fht = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.u(cVar.fgG) || cVar == this.fhr) {
            return false;
        }
        if (this.fhr == null || v.u(this.fhr.fgG)) {
            return true;
        }
        if (v.u(cVar.fgG)) {
            return false;
        }
        if (cVar.fgG.size() != this.fhr.fgG.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fgG.size(); i++) {
            if (this.fhr.fgG.get(i) == null || cVar.fgG.get(i).forumId != this.fhr.fgG.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
