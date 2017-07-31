package com.baidu.tieba.personPolymeric.d;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> alI;
    public ListViewPager dSU;
    private com.baidu.tieba.personPolymeric.c.c fkL;
    private C0114a fkM;
    private com.baidu.adp.lib.e.b<n> fkN;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fkM = new C0114a();
        this.alI = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.h.common_forum_title);
        this.dSU = (ListViewPager) view.findViewById(d.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dSU.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_d);
            int childCount = this.dSU.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dSU.getChildAt(i2);
                if (childAt instanceof m) {
                    ((m) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.fkL = cVar;
            if (u.u(cVar.fkm) <= 2) {
                this.dSU.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.alI.getPageActivity(), d.f.ds140);
            }
            this.dSU.setAdapter(this.fkM);
        }
        d(this.alI, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0114a extends PagerAdapter {
        private C0114a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.fkL == null || u.v(a.this.fkL.fkm)) {
                return 0;
            }
            return a.this.fkL.fkm.size() % 4 == 0 ? a.this.fkL.fkm.size() / 4 : (a.this.fkL.fkm.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof m) {
                m mVar = (m) obj;
                mVar.recycle();
                viewGroup.removeView(mVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> qf = a.this.qf(i);
            if (u.v(qf)) {
                return null;
            }
            m mVar = new m(a.this.alI.getPageActivity());
            mVar.setForumItemViewBdObjectPool(a.this.fkN);
            mVar.setData(qf);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qf(int i) {
        if (this.fkL == null || u.v(this.fkL.fkm)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) u.c(this.fkL.fkm, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fkN = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || u.v(cVar.fkm) || cVar == this.fkL) {
            return false;
        }
        if (this.fkL == null || u.v(this.fkL.fkm)) {
            return true;
        }
        if (u.v(cVar.fkm)) {
            return false;
        }
        if (cVar.fkm.size() != this.fkL.fkm.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fkm.size(); i++) {
            if (this.fkL.fkm.get(i) == null || cVar.fkm.get(i).forumId != this.fkL.fkm.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
