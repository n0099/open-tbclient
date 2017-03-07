package com.baidu.tieba.personPolymeric.d;

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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    public TextView aSO;
    private TbPageContext<?> ajF;
    public ListViewPager dCb;
    private com.baidu.tieba.personPolymeric.c.b eIj;
    private C0070a eIk;
    private com.baidu.adp.lib.e.b<q> eIl;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eIk = new C0070a(this, null);
        this.ajF = tbPageContext;
        View view = getView();
        this.aSO = (TextView) view.findViewById(w.h.common_forum_title);
        this.dCb = (ListViewPager) view.findViewById(w.h.common_forum_viewpager);
        this.dCb.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.e.cp_bg_line_d);
            aq.i((View) this.aSO, w.e.cp_cont_d);
            int childCount = this.dCb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dCb.getChildAt(i2);
                if (childAt instanceof p) {
                    ((p) childAt).tD();
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
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (b(bVar)) {
            this.eIj = bVar;
            if (com.baidu.tbadk.core.util.x.p(bVar.eHx) <= 2) {
                this.dCb.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds140);
            }
            this.dCb.setAdapter(this.eIk);
        }
        onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0070a extends PagerAdapter {
        private C0070a() {
        }

        /* synthetic */ C0070a(a aVar, C0070a c0070a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.eIj == null || com.baidu.tbadk.core.util.x.q(a.this.eIj.eHx)) {
                return 0;
            }
            return a.this.eIj.eHx.size() % 4 == 0 ? a.this.eIj.eHx.size() / 4 : (a.this.eIj.eHx.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof p) {
                p pVar = (p) obj;
                pVar.recycle();
                viewGroup.removeView(pVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.e> pe = a.this.pe(i);
            if (com.baidu.tbadk.core.util.x.q(pe)) {
                return null;
            }
            p pVar = new p(a.this.ajF.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.eIl);
            pVar.setData(pe);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> pe(int i) {
        if (this.eIj == null || com.baidu.tbadk.core.util.x.q(this.eIj.eHx)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.x.c(this.eIj.eHx, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<q> bVar) {
        this.eIl = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.x.q(bVar.eHx) || bVar == this.eIj) {
            return false;
        }
        if (this.eIj == null || com.baidu.tbadk.core.util.x.q(this.eIj.eHx)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.q(bVar.eHx)) {
            return false;
        }
        if (bVar.eHx.size() != this.eIj.eHx.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eHx.size(); i++) {
            if (this.eIj.eHx.get(i) == null || bVar.eHx.get(i).forumId != this.eIj.eHx.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
