package com.baidu.tieba.personPolymeric.d;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> ajh;
    public ListViewPager dAG;
    private com.baidu.tieba.personPolymeric.c.c eMO;
    private C0076a eMP;
    private com.baidu.adp.lib.e.b<s> eMQ;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eMP = new C0076a(this, null);
        this.ajh = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(w.h.common_forum_title);
        this.dAG = (ListViewPager) view.findViewById(w.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dAG.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_d);
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

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.eMO = cVar;
            if (com.baidu.tbadk.core.util.x.q(cVar.eMq) <= 2) {
                this.dAG.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds140);
            }
            this.dAG.setAdapter(this.eMP);
        }
        d(this.ajh, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076a extends PagerAdapter {
        private C0076a() {
        }

        /* synthetic */ C0076a(a aVar, C0076a c0076a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.eMO == null || com.baidu.tbadk.core.util.x.r(a.this.eMO.eMq)) {
                return 0;
            }
            return a.this.eMO.eMq.size() % 4 == 0 ? a.this.eMO.eMq.size() / 4 : (a.this.eMO.eMq.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> px = a.this.px(i);
            if (com.baidu.tbadk.core.util.x.r(px)) {
                return null;
            }
            r rVar = new r(a.this.ajh.getPageActivity());
            rVar.setForumItemViewBdObjectPool(a.this.eMQ);
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
