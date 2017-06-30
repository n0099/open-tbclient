package com.baidu.tieba.personPolymeric.d;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    private TbPageContext<?> ajP;
    public ListViewPager dJa;
    private com.baidu.tieba.personPolymeric.c.c eWX;
    private C0079a eWY;
    private com.baidu.adp.lib.e.b<s> eWZ;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eWY = new C0079a(this, null);
        this.ajP = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(w.h.common_forum_title);
        this.dJa = (ListViewPager) view.findViewById(w.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dJa.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.j(getView(), w.e.cp_bg_line_d);
            as.i(this.mTitle, w.e.cp_cont_d);
            int childCount = this.dJa.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dJa.getChildAt(i2);
                if (childAt instanceof r) {
                    ((r) childAt).onChangeSkinType();
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
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.eWX = cVar;
            if (com.baidu.tbadk.core.util.z.s(cVar.eWz) <= 2) {
                this.dJa.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds140);
            }
            this.dJa.setAdapter(this.eWY);
        }
        d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079a extends PagerAdapter {
        private C0079a() {
        }

        /* synthetic */ C0079a(a aVar, C0079a c0079a) {
            this();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.eWX == null || com.baidu.tbadk.core.util.z.t(a.this.eWX.eWz)) {
                return 0;
            }
            return a.this.eWX.eWz.size() % 4 == 0 ? a.this.eWX.eWz.size() / 4 : (a.this.eWX.eWz.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof r) {
                r rVar = (r) obj;
                rVar.recycle();
                viewGroup.removeView(rVar);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> pQ = a.this.pQ(i);
            if (com.baidu.tbadk.core.util.z.t(pQ)) {
                return null;
            }
            r rVar = new r(a.this.ajP.getPageActivity());
            rVar.setForumItemViewBdObjectPool(a.this.eWZ);
            rVar.setData(pQ);
            rVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(rVar);
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> pQ(int i) {
        if (this.eWX == null || com.baidu.tbadk.core.util.z.t(this.eWX.eWz)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) com.baidu.tbadk.core.util.z.c(this.eWX.eWz, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eWZ = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || com.baidu.tbadk.core.util.z.t(cVar.eWz) || cVar == this.eWX) {
            return false;
        }
        if (this.eWX == null || com.baidu.tbadk.core.util.z.t(this.eWX.eWz)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.z.t(cVar.eWz)) {
            return false;
        }
        if (cVar.eWz.size() != this.eWX.eWz.size()) {
            return true;
        }
        for (int i = 0; i < cVar.eWz.size(); i++) {
            if (this.eWX.eWz.get(i) == null || cVar.eWz.get(i).forumId != this.eWX.eWz.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
