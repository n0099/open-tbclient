package com.baidu.tieba.personPolymeric.d;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private TbPageContext<?> GM;
    public TextView aYh;
    private com.baidu.tieba.personPolymeric.c.b eIM;
    private C0072a eIN;
    private com.baidu.adp.lib.f.b<q> eIO;
    public ListViewPager eIP;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eIN = new C0072a(this, null);
        this.GM = tbPageContext;
        View view = getView();
        this.aYh = (TextView) view.findViewById(t.g.common_forum_title);
        this.eIP = (ListViewPager) view.findViewById(t.g.common_forum_viewpager);
        this.eIP.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), t.d.cp_bg_line_d);
            av.j((View) this.aYh, t.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (b(bVar)) {
            this.eIM = bVar;
            if (com.baidu.tbadk.core.util.y.s(bVar.eIa) <= 2) {
                this.eIP.getLayoutParams().height = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds140);
            }
            this.eIP.setAdapter(this.eIN);
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0072a extends PagerAdapter {
        private C0072a() {
        }

        /* synthetic */ C0072a(a aVar, C0072a c0072a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.eIM == null || com.baidu.tbadk.core.util.y.t(a.this.eIM.eIa)) {
                return 0;
            }
            return a.this.eIM.eIa.size() % 4 == 0 ? a.this.eIM.eIa.size() / 4 : (a.this.eIM.eIa.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> oT = a.this.oT(i);
            if (com.baidu.tbadk.core.util.y.t(oT)) {
                return null;
            }
            p pVar = new p(a.this.GM.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.eIO);
            pVar.setData(oT);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(t.e.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> oT(int i) {
        if (this.eIM == null || com.baidu.tbadk.core.util.y.t(this.eIM.eIa)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.y.c(this.eIM.eIa, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.f.b<q> bVar) {
        this.eIO = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.y.t(bVar.eIa) || bVar == this.eIM) {
            return false;
        }
        if (this.eIM == null || com.baidu.tbadk.core.util.y.t(this.eIM.eIa)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.y.t(bVar.eIa)) {
            return false;
        }
        if (bVar.eIa.size() != this.eIM.eIa.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eIa.size(); i++) {
            if (this.eIM.eIa.get(i) == null || bVar.eIa.get(i).forumId != this.eIM.eIa.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
