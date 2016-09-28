package com.baidu.tieba.personPolymeric.d;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private TbPageContext<?> GM;
    public TextView aMI;
    public ListViewPager dGc;
    private com.baidu.tieba.personPolymeric.c.b eKQ;
    private C0075a eKR;
    private com.baidu.adp.lib.f.b<q> eKS;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eKR = new C0075a(this, null);
        this.GM = tbPageContext;
        View view = getView();
        this.aMI = (TextView) view.findViewById(r.g.common_forum_title);
        this.dGc = (ListViewPager) view.findViewById(r.g.common_forum_viewpager);
        this.dGc.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), r.d.cp_bg_line_d);
            av.j((View) this.aMI, r.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (b(bVar)) {
            this.eKQ = bVar;
            if (com.baidu.tbadk.core.util.y.s(bVar.eKe) <= 2) {
                this.dGc.getLayoutParams().height = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), r.e.ds140);
            }
            this.dGc.setAdapter(this.eKR);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0075a extends PagerAdapter {
        private C0075a() {
        }

        /* synthetic */ C0075a(a aVar, C0075a c0075a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.eKQ == null || com.baidu.tbadk.core.util.y.t(a.this.eKQ.eKe)) {
                return 0;
            }
            return a.this.eKQ.eKe.size() % 4 == 0 ? a.this.eKQ.eKe.size() / 4 : (a.this.eKQ.eKe.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> pd = a.this.pd(i);
            if (com.baidu.tbadk.core.util.y.t(pd)) {
                return null;
            }
            p pVar = new p(a.this.GM.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.eKS);
            pVar.setData(pd);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> pd(int i) {
        if (this.eKQ == null || com.baidu.tbadk.core.util.y.t(this.eKQ.eKe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.y.c(this.eKQ.eKe, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.f.b<q> bVar) {
        this.eKS = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.y.t(bVar.eKe) || bVar == this.eKQ) {
            return false;
        }
        if (this.eKQ == null || com.baidu.tbadk.core.util.y.t(this.eKQ.eKe)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.y.t(bVar.eKe)) {
            return false;
        }
        if (bVar.eKe.size() != this.eKQ.eKe.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eKe.size(); i++) {
            if (this.eKQ.eKe.get(i) == null || bVar.eKe.get(i).forumId != this.eKQ.eKe.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
