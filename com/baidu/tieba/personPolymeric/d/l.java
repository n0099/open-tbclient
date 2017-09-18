package com.baidu.tieba.personPolymeric.d;

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
    private View aVj;
    public ListViewPager ecv;
    private com.baidu.tieba.personPolymeric.c.c flU;
    private com.baidu.adp.lib.e.b<n> flW;
    private Context fmH;
    private a fmI;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public l(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fmI = new a();
        this.flW = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<n>() { // from class: com.baidu.tieba.personPolymeric.d.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aYb */
            public n fJ() {
                return new n(l.this.fmH);
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
        this.fmH = context;
        this.rootView = LayoutInflater.from(this.fmH).inflate(d.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(d.h.common_forum_title);
        this.ecv = (ListViewPager) this.rootView.findViewById(d.h.common_forum_viewpager);
        this.aVj = this.rootView.findViewById(d.h.divider_line);
        this.ecv.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.j(this.rootView, d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_d);
            aj.k(this.aVj, d.e.cp_bg_line_b);
            int childCount = this.ecv.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ecv.getChildAt(i2);
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
                this.flU = cVar;
                if (v.u(cVar.flv) <= 2) {
                    this.ecv.getLayoutParams().height = com.baidu.adp.lib.util.k.f(this.fmH, d.f.ds140);
                }
                this.ecv.setAdapter(this.fmI);
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
            if (l.this.flU == null || v.v(l.this.flU.flv)) {
                return 0;
            }
            return l.this.flU.flv.size() % 4 == 0 ? l.this.flU.flv.size() / 4 : (l.this.flU.flv.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qr = l.this.qr(i);
            if (v.v(qr)) {
                return null;
            }
            m mVar = new m(l.this.fmH);
            mVar.setForumItemViewBdObjectPool(l.this.flW);
            mVar.setData(qr);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qr(int i) {
        if (this.flU == null || v.v(this.flU.flv)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.flU.flv, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.flW = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.v(cVar.flv) || cVar == this.flU) {
            return false;
        }
        if (this.flU == null || v.v(this.flU.flv)) {
            return true;
        }
        if (v.v(cVar.flv)) {
            return false;
        }
        if (cVar.flv.size() != this.flU.flv.size()) {
            return true;
        }
        for (int i = 0; i < cVar.flv.size(); i++) {
            if (this.flU.flv.get(i) == null || cVar.flv.get(i).forumId != this.flU.flv.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
