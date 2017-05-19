package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private View aUr;
    public ListViewPager dvo;
    private com.baidu.tieba.personPolymeric.c.b eDZ;
    private Context eED;
    private a eEE;
    private com.baidu.adp.lib.e.b<s> eEb;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eEE = new a(this, null);
        this.eEb = new com.baidu.adp.lib.e.b<>(new q(this), 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.eED = context;
        this.rootView = LayoutInflater.from(this.eED).inflate(w.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(w.h.common_forum_title);
        this.dvo = (ListViewPager) this.rootView.findViewById(w.h.common_forum_viewpager);
        this.aUr = this.rootView.findViewById(w.h.divider_line);
        this.dvo.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.j(this.rootView, w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_d);
            aq.k(this.aUr, w.e.cp_bg_line_b);
            int childCount = this.dvo.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dvo.getChildAt(i2);
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

    public void a(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar != null) {
            if (b(bVar)) {
                this.eDZ = bVar;
                if (com.baidu.tbadk.core.util.x.q(bVar.eDd) <= 2) {
                    this.dvo.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.eED, w.f.ds140);
                }
                this.dvo.setAdapter(this.eEE);
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
            if (p.this.eDZ == null || com.baidu.tbadk.core.util.x.r(p.this.eDZ.eDd)) {
                return 0;
            }
            return p.this.eDZ.eDd.size() % 4 == 0 ? p.this.eDZ.eDd.size() / 4 : (p.this.eDZ.eDd.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> oY = p.this.oY(i);
            if (com.baidu.tbadk.core.util.x.r(oY)) {
                return null;
            }
            r rVar = new r(p.this.eED);
            rVar.setForumItemViewBdObjectPool(p.this.eEb);
            rVar.setData(oY);
            rVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(rVar);
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> oY(int i) {
        if (this.eDZ == null || com.baidu.tbadk.core.util.x.r(this.eDZ.eDd)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.x.c(this.eDZ.eDd, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eEb = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.x.r(bVar.eDd) || bVar == this.eDZ) {
            return false;
        }
        if (this.eDZ == null || com.baidu.tbadk.core.util.x.r(this.eDZ.eDd)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.r(bVar.eDd)) {
            return false;
        }
        if (bVar.eDd.size() != this.eDZ.eDd.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eDd.size(); i++) {
            if (this.eDZ.eDd.get(i) == null || bVar.eDd.get(i).forumId != this.eDZ.eDd.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
