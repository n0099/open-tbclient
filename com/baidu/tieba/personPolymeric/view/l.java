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
/* loaded from: classes3.dex */
public class l extends LinearLayout {
    private View bQq;
    public ListViewPager ffB;
    private com.baidu.adp.lib.e.b<n> gqB;
    private com.baidu.tieba.personPolymeric.c.c gqz;
    private Context grw;
    private a grx;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.grx = new a();
        this.gqB = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.view.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: bjT */
            public n nl() {
                return new n(l.this.grw);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void as(n nVar) {
                if (nVar != null) {
                    nVar.removeAllViews();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public n at(n nVar) {
                return nVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public n au(n nVar) {
                return nVar;
            }
        }, 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.grw = context;
        this.rootView = LayoutInflater.from(this.grw).inflate(d.h.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.common_forum_title);
        this.ffB = (ListViewPager) this.rootView.findViewById(d.g.common_forum_viewpager);
        this.bQq = this.rootView.findViewById(d.g.divider_line);
        this.ffB.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.rootView, d.C0141d.cp_bg_line_d);
            aj.r(this.mTitle, d.C0141d.cp_cont_b);
            aj.t(this.bQq, d.C0141d.cp_bg_line_e);
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

    public int getLayout() {
        return d.h.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.gqz = cVar;
                if (v.D(cVar.gpN) <= 2) {
                    this.ffB.getLayoutParams().height = com.baidu.adp.lib.util.l.t(this.grw, d.e.tbds172);
                } else {
                    this.ffB.getLayoutParams().height = com.baidu.adp.lib.util.l.t(this.grw, d.e.tbds344);
                }
                this.ffB.setAdapter(this.grx);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes3.dex */
    private class a extends PagerAdapter {
        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (l.this.gqz == null || v.E(l.this.gqz.gpN)) {
                return 0;
            }
            return l.this.gqz.gpN.size() % 4 == 0 ? l.this.gqz.gpN.size() / 4 : (l.this.gqz.gpN.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> tO = l.this.tO(i);
            if (v.E(tO)) {
                return null;
            }
            m mVar = new m(l.this.grw);
            mVar.setForumItemViewBdObjectPool(l.this.gqB);
            mVar.setData(tO);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds42));
            mVar.setHorizontalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.tbds48));
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
