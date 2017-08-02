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
    private View aUp;
    public ListViewPager dRD;
    private com.baidu.adp.lib.e.b<n> fjB;
    private com.baidu.tieba.personPolymeric.c.c fjz;
    private Context fkm;
    private a fkn;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fkn = new a();
        this.fjB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.d.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aXR */
            public n fI() {
                return new n(l.this.fkm);
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
        this.fkm = context;
        this.rootView = LayoutInflater.from(this.fkm).inflate(d.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.h.common_forum_title);
        this.dRD = (ListViewPager) this.rootView.findViewById(d.h.common_forum_viewpager);
        this.aUp = this.rootView.findViewById(d.h.divider_line);
        this.dRD.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.j(this.rootView, d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_d);
            ai.k(this.aUp, d.e.cp_bg_line_b);
            int childCount = this.dRD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dRD.getChildAt(i2);
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
                this.fjz = cVar;
                if (u.u(cVar.fja) <= 2) {
                    this.dRD.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.fkm, d.f.ds140);
                }
                this.dRD.setAdapter(this.fkn);
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
            if (l.this.fjz == null || u.v(l.this.fjz.fja)) {
                return 0;
            }
            return l.this.fjz.fja.size() % 4 == 0 ? l.this.fjz.fja.size() / 4 : (l.this.fjz.fja.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qg = l.this.qg(i);
            if (u.v(qg)) {
                return null;
            }
            m mVar = new m(l.this.fkm);
            mVar.setForumItemViewBdObjectPool(l.this.fjB);
            mVar.setData(qg);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qg(int i) {
        if (this.fjz == null || u.v(this.fjz.fja)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) u.c(this.fjz.fja, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fjB = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || u.v(cVar.fja) || cVar == this.fjz) {
            return false;
        }
        if (this.fjz == null || u.v(this.fjz.fja)) {
            return true;
        }
        if (u.v(cVar.fja)) {
            return false;
        }
        if (cVar.fja.size() != this.fjz.fja.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fja.size(); i++) {
            if (this.fjz.fja.get(i) == null || cVar.fja.get(i).forumId != this.fjz.fja.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
