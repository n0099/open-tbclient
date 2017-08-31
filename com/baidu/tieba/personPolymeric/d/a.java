package com.baidu.tieba.personPolymeric.d;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager ebB;
    private com.baidu.tieba.personPolymeric.c.c flb;
    private C0117a flc;
    private com.baidu.adp.lib.e.b<n> fld;
    private TbPageContext<?> mF;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.flc = new C0117a();
        this.mF = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.h.common_forum_title);
        this.ebB = (ListViewPager) view.findViewById(d.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.ebB.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.e.cp_bg_line_d);
            aj.i(this.mTitle, d.e.cp_cont_d);
            int childCount = this.ebB.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.ebB.getChildAt(i2);
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
            this.flb = cVar;
            if (v.u(cVar.fkC) <= 2) {
                this.ebB.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.mF.getPageActivity(), d.f.ds140);
            }
            this.ebB.setAdapter(this.flc);
        }
        d(this.mF, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0117a extends PagerAdapter {
        private C0117a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.flb == null || v.v(a.this.flb.fkC)) {
                return 0;
            }
            return a.this.flb.fkC.size() % 4 == 0 ? a.this.flb.fkC.size() / 4 : (a.this.flb.fkC.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> qp = a.this.qp(i);
            if (v.v(qp)) {
                return null;
            }
            m mVar = new m(a.this.mF.getPageActivity());
            mVar.setForumItemViewBdObjectPool(a.this.fld);
            mVar.setData(qp);
            mVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.f.ds32));
            viewGroup.addView(mVar);
            return mVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qp(int i) {
        if (this.flb == null || v.v(this.flb.fkC)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.flb.fkC, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<n> bVar) {
        this.fld = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.v(cVar.fkC) || cVar == this.flb) {
            return false;
        }
        if (this.flb == null || v.v(this.flb.fkC)) {
            return true;
        }
        if (v.v(cVar.fkC)) {
            return false;
        }
        if (cVar.fkC.size() != this.flb.fkC.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fkC.size(); i++) {
            if (this.flb.fkC.get(i) == null || cVar.fkC.get(i).forumId != this.flb.fkC.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
