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
    private View aWX;
    public ListViewPager dYE;
    private com.baidu.tieba.personPolymeric.c.c fhF;
    private com.baidu.adp.lib.e.b<n> fhH;
    private Context fis;
    private a fit;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fit = new a();
        this.fhH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aWv */
            public n fI() {
                return new n(l.this.fis);
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
        this.fis = context;
        this.rootView = LayoutInflater.from(this.fis).inflate(d.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.h.common_forum_title);
        this.dYE = (ListViewPager) this.rootView.findViewById(d.h.common_forum_viewpager);
        this.aWX = this.rootView.findViewById(d.h.divider_line);
        this.dYE.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.rootView, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.aWX, d.e.cp_bg_line_e);
            int childCount = this.dYE.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dYE.getChildAt(i2);
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
                this.fhF = cVar;
                if (v.t(cVar.fgU) <= 2) {
                    this.dYE.getLayoutParams().height = com.baidu.adp.lib.util.l.f(this.fis, d.f.ds140);
                }
                this.dYE.setAdapter(this.fit);
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
            if (l.this.fhF == null || v.u(l.this.fhF.fgU)) {
                return 0;
            }
            return l.this.fhF.fgU.size() % 4 == 0 ? l.this.fhF.fgU.size() / 4 : (l.this.fhF.fgU.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qq = l.this.qq(i);
            if (v.u(qq)) {
                return null;
            }
            m mVar = new m(l.this.fis);
            mVar.setForumItemViewBdObjectPool(l.this.fhH);
            mVar.setData(qq);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds34));
            mVar.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds34));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qq(int i) {
        if (this.fhF == null || v.u(this.fhF.fgU)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.fhF.fgU, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fhH = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.u(cVar.fgU) || cVar == this.fhF) {
            return false;
        }
        if (this.fhF == null || v.u(this.fhF.fgU)) {
            return true;
        }
        if (v.u(cVar.fgU)) {
            return false;
        }
        if (cVar.fgU.size() != this.fhF.fgU.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fgU.size(); i++) {
            if (this.fhF.fgU.get(i) == null || cVar.fgU.get(i).forumId != this.fhF.fgU.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
