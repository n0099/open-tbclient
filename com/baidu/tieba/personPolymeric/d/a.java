package com.baidu.tieba.personPolymeric.d;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private TbPageContext<?> FY;
    public TextView aNb;
    public ListViewPager dzD;
    private com.baidu.tieba.personPolymeric.c.b eEH;
    private C0071a eEI;
    private com.baidu.adp.lib.e.b<q> eEJ;
    private int mSkinType;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eEI = new C0071a(this, null);
        this.FY = tbPageContext;
        View view = getView();
        this.aNb = (TextView) view.findViewById(r.h.common_forum_title);
        this.dzD = (ListViewPager) view.findViewById(r.h.common_forum_viewpager);
        this.dzD.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.j(getView(), r.e.cp_bg_line_d);
            ap.i((View) this.aNb, r.e.cp_cont_d);
            int childCount = this.dzD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dzD.getChildAt(i2);
                if (childAt instanceof p) {
                    ((p) childAt).tg();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (b(bVar)) {
            this.eEH = bVar;
            if (com.baidu.tbadk.core.util.w.r(bVar.eDV) <= 2) {
                this.dzD.getLayoutParams().height = com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds140);
            }
            this.dzD.setAdapter(this.eEI);
        }
        onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0071a extends PagerAdapter {
        private C0071a() {
        }

        /* synthetic */ C0071a(a aVar, C0071a c0071a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.eEH == null || com.baidu.tbadk.core.util.w.s(a.this.eEH.eDV)) {
                return 0;
            }
            return a.this.eEH.eDV.size() % 4 == 0 ? a.this.eEH.eDV.size() / 4 : (a.this.eEH.eDV.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> pi = a.this.pi(i);
            if (com.baidu.tbadk.core.util.w.s(pi)) {
                return null;
            }
            p pVar = new p(a.this.FY.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.eEJ);
            pVar.setData(pi);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(r.f.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> pi(int i) {
        if (this.eEH == null || com.baidu.tbadk.core.util.w.s(this.eEH.eDV)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.w.c(this.eEH.eDV, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<q> bVar) {
        this.eEJ = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.w.s(bVar.eDV) || bVar == this.eEH) {
            return false;
        }
        if (this.eEH == null || com.baidu.tbadk.core.util.w.s(this.eEH.eDV)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.w.s(bVar.eDV)) {
            return false;
        }
        if (bVar.eDV.size() != this.eEH.eDV.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eDV.size(); i++) {
            if (this.eEH.eDV.get(i) == null || bVar.eDV.get(i).forumId != this.eEH.eDV.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
