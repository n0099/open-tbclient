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
    private TbPageContext<?> ako;
    public ListViewPager dRD;
    private C0115a fjA;
    private com.baidu.adp.lib.e.b<n> fjB;
    private com.baidu.tieba.personPolymeric.c.c fjz;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fjA = new C0115a();
        this.ako = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.h.common_forum_title);
        this.dRD = (ListViewPager) view.findViewById(d.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dRD.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_d);
            int childCount = this.dRD.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dRD.getChildAt(i2);
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
            this.fjz = cVar;
            if (u.u(cVar.fja) <= 2) {
                this.dRD.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds140);
            }
            this.dRD.setAdapter(this.fjA);
        }
        d(this.ako, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115a extends PagerAdapter {
        private C0115a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.fjz == null || u.v(a.this.fjz.fja)) {
                return 0;
            }
            return a.this.fjz.fja.size() % 4 == 0 ? a.this.fjz.fja.size() / 4 : (a.this.fjz.fja.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qg = a.this.qg(i);
            if (u.v(qg)) {
                return null;
            }
            m mVar = new m(a.this.ako.getPageActivity());
            mVar.setForumItemViewBdObjectPool(a.this.fjB);
            mVar.setData(qg);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qg(int i) {
        if (this.fjz == null || u.v(this.fjz.fja)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) u.c(this.fjz.fja, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fjB = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || u.v(cVar.fja) || cVar == this.fjz) {
            return false;
        }
        if (this.fjz == null || u.v(this.fjz.fja)) {
            return true;
        }
        if (u.v(cVar.fja)) {
            return false;
        }
        if (cVar.fja.size() != this.fjz.fja.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fja.size(); i++) {
            if (this.fjz.fja.get(i) == null || cVar.fja.get(i).forumId != this.fjz.fja.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
