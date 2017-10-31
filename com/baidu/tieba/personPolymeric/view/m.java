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
public class m extends LinearLayout {
    private View aXa;
    public ListViewPager egb;
    private com.baidu.tieba.personPolymeric.c.c fpQ;
    private com.baidu.adp.lib.e.b<o> fpS;
    private Context fqN;
    private a fqO;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public m(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fqO = new a();
        this.fpS = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<o>() { // from class: com.baidu.tieba.personPolymeric.view.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aZt */
            public o fI() {
                return new o(m.this.fqN);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void n(o oVar) {
                if (oVar != null) {
                    oVar.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public o o(o oVar) {
                return oVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public o p(o oVar) {
                return oVar;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.fqN = context;
        this.rootView = LayoutInflater.from(this.fqN).inflate(d.h.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.common_forum_title);
        this.egb = (ListViewPager) this.rootView.findViewById(d.g.common_forum_viewpager);
        this.aXa = this.rootView.findViewById(d.g.divider_line);
        this.egb.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.rootView, d.C0080d.cp_bg_line_d);
            aj.i(this.mTitle, d.C0080d.cp_cont_b);
            aj.k(this.aXa, d.C0080d.cp_bg_line_e);
            int childCount = this.egb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.egb.getChildAt(i2);
                if (childAt instanceof n) {
                    ((n) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    public int getLayout() {
        return d.h.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.fpQ = cVar;
                if (v.u(cVar.fpe) <= 2) {
                    this.egb.getLayoutParams().height = com.baidu.adp.lib.util.l.f(this.fqN, d.e.ds140);
                }
                this.egb.setAdapter(this.fqO);
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
            if (m.this.fpQ == null || v.v(m.this.fpQ.fpe)) {
                return 0;
            }
            return m.this.fpQ.fpe.size() % 4 == 0 ? m.this.fpQ.fpe.size() / 4 : (m.this.fpQ.fpe.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof n) {
                n nVar = (n) obj;
                nVar.recycle();
                viewGroup.removeView(nVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> qF = m.this.qF(i);
            if (v.v(qF)) {
                return null;
            }
            n nVar = new n(m.this.fqN);
            nVar.setForumItemViewBdObjectPool(m.this.fpS);
            nVar.setData(qF);
            nVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds34));
            nVar.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds34));
            viewGroup.addView(nVar);
            return nVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qF(int i) {
        if (this.fpQ == null || v.v(this.fpQ.fpe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.fpQ.fpe, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<o> bVar) {
        this.fpS = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.v(cVar.fpe) || cVar == this.fpQ) {
            return false;
        }
        if (this.fpQ == null || v.v(this.fpQ.fpe)) {
            return true;
        }
        if (v.v(cVar.fpe)) {
            return false;
        }
        if (cVar.fpe.size() != this.fpQ.fpe.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fpe.size(); i++) {
            if (this.fpQ.fpe.get(i) == null || cVar.fpe.get(i).forumId != this.fpQ.fpe.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
