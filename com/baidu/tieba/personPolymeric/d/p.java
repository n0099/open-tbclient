package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private View aTm;
    public ListViewPager dJa;
    private com.baidu.tieba.personPolymeric.c.c eWX;
    private com.baidu.adp.lib.e.b<s> eWZ;
    private Context eXB;
    private a eXC;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eXC = new a(this, null);
        this.eWZ = new com.baidu.adp.lib.e.b<>(new q(this), 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.eXB = context;
        this.rootView = LayoutInflater.from(this.eXB).inflate(w.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(w.h.common_forum_title);
        this.dJa = (ListViewPager) this.rootView.findViewById(w.h.common_forum_viewpager);
        this.aTm = this.rootView.findViewById(w.h.divider_line);
        this.dJa.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            as.j(this.rootView, w.e.cp_bg_line_d);
            as.i(this.mTitle, w.e.cp_cont_d);
            as.k(this.aTm, w.e.cp_bg_line_b);
            int childCount = this.dJa.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dJa.getChildAt(i2);
                if (childAt instanceof r) {
                    ((r) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    public int getLayout() {
        return w.j.person_info_common_forum_layout;
    }

    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar != null) {
            if (b(cVar)) {
                this.eWX = cVar;
                if (com.baidu.tbadk.core.util.z.s(cVar.eWz) <= 2) {
                    this.dJa.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.eXB, w.f.ds140);
                }
                this.dJa.setAdapter(this.eXC);
            }
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* loaded from: classes.dex */
    private class a extends PagerAdapter {
        private a() {
        }

        /* synthetic */ a(p pVar, a aVar) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (p.this.eWX == null || com.baidu.tbadk.core.util.z.t(p.this.eWX.eWz)) {
                return 0;
            }
            return p.this.eWX.eWz.size() % 4 == 0 ? p.this.eWX.eWz.size() / 4 : (p.this.eWX.eWz.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                rVar.recycle();
                viewGroup.removeView(rVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> pQ = p.this.pQ(i);
            if (com.baidu.tbadk.core.util.z.t(pQ)) {
                return null;
            }
            r rVar = new r(p.this.eXB);
            rVar.setForumItemViewBdObjectPool(p.this.eWZ);
            rVar.setData(pQ);
            rVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(rVar);
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> pQ(int i) {
        if (this.eWX == null || com.baidu.tbadk.core.util.z.t(this.eWX.eWz)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) com.baidu.tbadk.core.util.z.c(this.eWX.eWz, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eWZ = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || com.baidu.tbadk.core.util.z.t(cVar.eWz) || cVar == this.eWX) {
            return false;
        }
        if (this.eWX == null || com.baidu.tbadk.core.util.z.t(this.eWX.eWz)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.z.t(cVar.eWz)) {
            return false;
        }
        if (cVar.eWz.size() != this.eWX.eWz.size()) {
            return true;
        }
        for (int i = 0; i < cVar.eWz.size(); i++) {
            if (this.eWX.eWz.get(i) == null || cVar.eWz.get(i).forumId != this.eWX.eWz.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
