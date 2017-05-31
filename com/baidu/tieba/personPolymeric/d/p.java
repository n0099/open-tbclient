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
    private View aRT;
    public ListViewPager dAG;
    private com.baidu.tieba.personPolymeric.c.c eMO;
    private com.baidu.adp.lib.e.b<s> eMQ;
    private Context eNs;
    private a eNt;
    private int mSkinType;
    public TextView mTitle;
    private View rootView;

    public p(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eNt = new a(this, null);
        this.eMQ = new com.baidu.adp.lib.e.b<>(new q(this), 12, 0);
        init(context);
    }

    private void init(Context context) {
        this.eNs = context;
        this.rootView = LayoutInflater.from(this.eNs).inflate(w.j.person_info_common_forum_layout, this);
        this.mTitle = (TextView) this.rootView.findViewById(w.h.common_forum_title);
        this.dAG = (ListViewPager) this.rootView.findViewById(w.h.common_forum_viewpager);
        this.aRT = this.rootView.findViewById(w.h.divider_line);
        this.dAG.setOffscreenPageLimit(1);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.j(this.rootView, w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_d);
            aq.k(this.aRT, w.e.cp_bg_line_b);
            int childCount = this.dAG.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dAG.getChildAt(i2);
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
                this.eMO = cVar;
                if (com.baidu.tbadk.core.util.x.q(cVar.eMq) <= 2) {
                    this.dAG.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.eNs, w.f.ds140);
                }
                this.dAG.setAdapter(this.eNt);
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
            if (p.this.eMO == null || com.baidu.tbadk.core.util.x.r(p.this.eMO.eMq)) {
                return 0;
            }
            return p.this.eMO.eMq.size() % 4 == 0 ? p.this.eMO.eMq.size() / 4 : (p.this.eMO.eMq.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> px = p.this.px(i);
            if (com.baidu.tbadk.core.util.x.r(px)) {
                return null;
            }
            r rVar = new r(p.this.eNs);
            rVar.setForumItemViewBdObjectPool(p.this.eMQ);
            rVar.setData(px);
            rVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(rVar);
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> px(int i) {
        if (this.eMO == null || com.baidu.tbadk.core.util.x.r(this.eMO.eMq)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) com.baidu.tbadk.core.util.x.c(this.eMO.eMq, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eMQ = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || com.baidu.tbadk.core.util.x.r(cVar.eMq) || cVar == this.eMO) {
            return false;
        }
        if (this.eMO == null || com.baidu.tbadk.core.util.x.r(this.eMO.eMq)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.r(cVar.eMq)) {
            return false;
        }
        if (cVar.eMq.size() != this.eMO.eMq.size()) {
            return true;
        }
        for (int i = 0; i < cVar.eMq.size(); i++) {
            if (this.eMO.eMq.get(i) == null || cVar.eMq.get(i).forumId != this.eMO.eMq.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
