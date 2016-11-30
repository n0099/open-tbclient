package com.baidu.tieba.personPolymeric.d;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private TbPageContext<?> GO;
    public TextView aOH;
    public ListViewPager dLP;
    private com.baidu.tieba.personPolymeric.c.b eRo;
    private C0075a eRp;
    private com.baidu.adp.lib.f.b<q> eRq;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eRp = new C0075a(this, null);
        this.GO = tbPageContext;
        View view = getView();
        this.aOH = (TextView) view.findViewById(r.g.common_forum_title);
        this.dLP = (ListViewPager) view.findViewById(r.g.common_forum_viewpager);
        this.dLP.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            at.k(getView(), r.d.cp_bg_line_d);
            at.j((View) this.aOH, r.d.cp_cont_d);
            int childCount = this.dLP.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dLP.getChildAt(i2);
                if (childAt instanceof p) {
                    ((p) childAt).tB();
                }
            }
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
            this.eRo = bVar;
            if (com.baidu.tbadk.core.util.x.s(bVar.eQC) <= 2) {
                this.dLP.getLayoutParams().height = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds140);
            }
            this.dLP.setAdapter(this.eRp);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
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
            if (a.this.eRo == null || com.baidu.tbadk.core.util.x.t(a.this.eRo.eQC)) {
                return 0;
            }
            return a.this.eRo.eQC.size() % 4 == 0 ? a.this.eRo.eQC.size() / 4 : (a.this.eRo.eQC.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> pq = a.this.pq(i);
            if (com.baidu.tbadk.core.util.x.t(pq)) {
                return null;
            }
            p pVar = new p(a.this.GO.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.eRq);
            pVar.setData(pq);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> pq(int i) {
        if (this.eRo == null || com.baidu.tbadk.core.util.x.t(this.eRo.eQC)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.x.c(this.eRo.eQC, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.f.b<q> bVar) {
        this.eRq = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.x.t(bVar.eQC) || bVar == this.eRo) {
            return false;
        }
        if (this.eRo == null || com.baidu.tbadk.core.util.x.t(this.eRo.eQC)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.t(bVar.eQC)) {
            return false;
        }
        if (bVar.eQC.size() != this.eRo.eQC.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eQC.size(); i++) {
            if (this.eRo.eQC.get(i) == null || bVar.eQC.get(i).forumId != this.eRo.eQC.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
