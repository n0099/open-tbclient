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
    private View aVB;
    public ListViewPager dSU;
    private com.baidu.tieba.personPolymeric.c.c fkL;
    private com.baidu.adp.lib.e.b<n> fkN;
    private Context fly;
    private a flz;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.flz = new a();
        this.fkN = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.d.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aYc */
            public n fT() {
                return new n(l.this.fly);
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
        this.fly = context;
        this.rootView = LayoutInflater.from(this.fly).inflate(d.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.h.common_forum_title);
        this.dSU = (ListViewPager) this.rootView.findViewById(d.h.common_forum_viewpager);
        this.aVB = this.rootView.findViewById(d.h.divider_line);
        this.dSU.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.j(this.rootView, d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_d);
            ai.k(this.aVB, d.e.cp_bg_line_b);
            int childCount = this.dSU.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dSU.getChildAt(i2);
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
                this.fkL = cVar;
                if (u.u(cVar.fkm) <= 2) {
                    this.dSU.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.fly, d.f.ds140);
                }
                this.dSU.setAdapter(this.flz);
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
            if (l.this.fkL == null || u.v(l.this.fkL.fkm)) {
                return 0;
            }
            return l.this.fkL.fkm.size() % 4 == 0 ? l.this.fkL.fkm.size() / 4 : (l.this.fkL.fkm.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qf = l.this.qf(i);
            if (u.v(qf)) {
                return null;
            }
            m mVar = new m(l.this.fly);
            mVar.setForumItemViewBdObjectPool(l.this.fkN);
            mVar.setData(qf);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qf(int i) {
        if (this.fkL == null || u.v(this.fkL.fkm)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) u.c(this.fkL.fkm, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fkN = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || u.v(cVar.fkm) || cVar == this.fkL) {
            return false;
        }
        if (this.fkL == null || u.v(this.fkL.fkm)) {
            return true;
        }
        if (u.v(cVar.fkm)) {
            return false;
        }
        if (cVar.fkm.size() != this.fkL.fkm.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fkm.size(); i++) {
            if (this.fkL.fkm.get(i) == null || cVar.fkm.get(i).forumId != this.fkL.fkm.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
