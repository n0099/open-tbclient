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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.b> {
    private TbPageContext<?> ajU;
    public ListViewPager dAW;
    private com.baidu.tieba.personPolymeric.c.b eIu;
    private C0069a eIv;
    private com.baidu.adp.lib.e.b<q> eIw;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eIv = new C0069a(this, null);
        this.ajU = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(w.h.common_forum_title);
        this.dAW = (ListViewPager) view.findViewById(w.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dAW.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_d);
            int childCount = this.dAW.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dAW.getChildAt(i2);
                if (childAt instanceof p) {
                    ((p) childAt).onChangeSkinType();
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
            this.eIu = bVar;
            if (com.baidu.tbadk.core.util.x.p(bVar.eHJ) <= 2) {
                this.dAW.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds140);
            }
            this.dAW.setAdapter(this.eIv);
        }
        onChangeSkinType(this.ajU, TbadkCoreApplication.m9getInst().getSkinType());
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
            if (a.this.eIu == null || com.baidu.tbadk.core.util.x.q(a.this.eIu.eHJ)) {
                return 0;
            }
            return a.this.eIu.eHJ.size() % 4 == 0 ? a.this.eIu.eHJ.size() / 4 : (a.this.eIu.eHJ.size() / 4) + 1;
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
            if (com.baidu.tbadk.core.util.x.q(pi)) {
                return null;
            }
            p pVar = new p(a.this.ajU.getPageActivity());
            pVar.setForumItemViewBdObjectPool(a.this.eIw);
            pVar.setData(pi);
            pVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(pVar);
            return pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> pi(int i) {
        if (this.eIu == null || com.baidu.tbadk.core.util.x.q(this.eIu.eHJ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.x.c(this.eIu.eHJ, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<q> bVar) {
        this.eIw = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.x.q(bVar.eHJ) || bVar == this.eIu) {
            return false;
        }
        if (this.eIu == null || com.baidu.tbadk.core.util.x.q(this.eIu.eHJ)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.q(bVar.eHJ)) {
            return false;
        }
        if (bVar.eHJ.size() != this.eIu.eHJ.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eHJ.size(); i++) {
            if (this.eIu.eHJ.get(i) == null || bVar.eHJ.get(i).forumId != this.eIu.eHJ.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
