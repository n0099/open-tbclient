package com.baidu.tieba.personPolymeric.d;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private TbPageContext<?> GO;
    public TextView aNY;
    public ListViewPager dqm;
    private com.baidu.tieba.personPolymeric.c.b euN;
    private C0069a euO;
    private com.baidu.adp.lib.f.b<q> euP;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.euO = new C0069a(this, null);
        this.GO = tbPageContext;
        View view = getView();
        this.aNY = (TextView) view.findViewById(r.g.common_forum_title);
        this.dqm = (ListViewPager) view.findViewById(r.g.common_forum_viewpager);
        this.dqm.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ar.k(getView(), r.d.cp_bg_line_d);
            ar.j((View) this.aNY, r.d.cp_cont_d);
            int childCount = this.dqm.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dqm.getChildAt(i2);
                if (childAt instanceof p) {
                    ((p) childAt).tm();
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
            this.euN = bVar;
            if (com.baidu.tbadk.core.util.x.s(bVar.eub) <= 2) {
                this.dqm.getLayoutParams().height = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds140);
            }
            this.dqm.setAdapter(this.euO);
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0069a extends PagerAdapter {
        private C0069a() {
        }

        /* synthetic */ C0069a(a aVar, C0069a c0069a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.euN == null || com.baidu.tbadk.core.util.x.t(a.this.euN.eub)) {
                return 0;
            }
            return a.this.euN.eub.size() % 4 == 0 ? a.this.euN.eub.size() / 4 : (a.this.euN.eub.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> oq = a.this.oq(i);
            if (com.baidu.tbadk.core.util.x.t(oq)) {
                return null;
            }
            p pVar = new p(a.this.GO.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.euP);
            pVar.setData(oq);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.e.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> oq(int i) {
        if (this.euN == null || com.baidu.tbadk.core.util.x.t(this.euN.eub)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.x.c(this.euN.eub, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.f.b<q> bVar) {
        this.euP = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.x.t(bVar.eub) || bVar == this.euN) {
            return false;
        }
        if (this.euN == null || com.baidu.tbadk.core.util.x.t(this.euN.eub)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.t(bVar.eub)) {
            return false;
        }
        if (bVar.eub.size() != this.euN.eub.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eub.size(); i++) {
            if (this.euN.eub.get(i) == null || bVar.eub.get(i).forumId != this.euN.eub.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
