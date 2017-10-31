package com.baidu.tieba.personPolymeric.view;

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
    public ListViewPager egb;
    private com.baidu.tieba.personPolymeric.c.c fpQ;
    private C0117a fpR;
    private com.baidu.adp.lib.e.b<o> fpS;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.fpR = new C0117a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(d.g.common_forum_title);
        this.egb = (ListViewPager) view.findViewById(d.g.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.egb.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.C0080d.cp_bg_line_d);
            aj.i(this.mTitle, d.C0080d.cp_cont_d);
            int childCount = this.egb.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.egb.getChildAt(i2);
                if (childAt instanceof n) {
                    ((n) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.fpQ = cVar;
            if (v.u(cVar.fpe) <= 2) {
                this.egb.getLayoutParams().height = com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds140);
            }
            this.egb.setAdapter(this.fpR);
        }
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0117a extends PagerAdapter {
        private C0117a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.fpQ == null || v.v(a.this.fpQ.fpe)) {
                return 0;
            }
            return a.this.fpQ.fpe.size() % 4 == 0 ? a.this.fpQ.fpe.size() / 4 : (a.this.fpQ.fpe.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof n) {
                n nVar = (n) obj;
                nVar.recycle();
                viewGroup.removeView(nVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> qF = a.this.qF(i);
            if (v.v(qF)) {
                return null;
            }
            n nVar = new n(a.this.mPageContext.getPageActivity());
            nVar.setForumItemViewBdObjectPool(a.this.fpS);
            nVar.setData(qF);
            nVar.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(d.e.ds32));
            viewGroup.addView(nVar);
            return nVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> qF(int i) {
        if (this.fpQ == null || v.v(this.fpQ.fpe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.fpQ.fpe, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<o> bVar) {
        this.fpS = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.v(cVar.fpe) || cVar == this.fpQ) {
            return false;
        }
        if (this.fpQ == null || v.v(this.fpQ.fpe)) {
            return true;
        }
        if (v.v(cVar.fpe)) {
            return false;
        }
        if (cVar.fpe.size() != this.fpQ.fpe.size()) {
            return true;
        }
        for (int i = 0; i < cVar.fpe.size(); i++) {
            if (this.fpQ.fpe.get(i) == null || cVar.fpe.get(i).forumId != this.fpQ.fpe.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
