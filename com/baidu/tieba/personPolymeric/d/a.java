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
    private TbPageContext<?> ajr;
    public ListViewPager dvo;
    private com.baidu.tieba.personPolymeric.c.b eDZ;
    private C0075a eEa;
    private com.baidu.adp.lib.e.b<s> eEb;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eEa = new C0075a(this, null);
        this.ajr = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(w.h.common_forum_title);
        this.dvo = (ListViewPager) view.findViewById(w.h.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.dvo.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.j(getView(), w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_d);
            int childCount = this.dvo.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.dvo.getChildAt(i2);
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
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (b(bVar)) {
            this.eDZ = bVar;
            if (com.baidu.tbadk.core.util.x.q(bVar.eDd) <= 2) {
                this.dvo.getLayoutParams().height = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds140);
            }
            this.dvo.setAdapter(this.eEa);
        }
        onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
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
            if (a.this.eDZ == null || com.baidu.tbadk.core.util.x.r(a.this.eDZ.eDd)) {
                return 0;
            }
            return a.this.eDZ.eDd.size() % 4 == 0 ? a.this.eDZ.eDd.size() / 4 : (a.this.eDZ.eDd.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.e> oY = a.this.oY(i);
            if (com.baidu.tbadk.core.util.x.r(oY)) {
                return null;
            }
            r rVar = new r(a.this.ajr.getPageActivity());
            rVar.setForumItemViewBdObjectPool(a.this.eEb);
            rVar.setData(oY);
            rVar.setVerticalSpacing(TbadkCoreApplication.m9getInst().getContext().getResources().getDimensionPixelSize(w.f.ds32));
            viewGroup.addView(rVar);
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.e> oY(int i) {
        if (this.eDZ == null || com.baidu.tbadk.core.util.x.r(this.eDZ.eDd)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.e eVar = (com.baidu.tieba.personPolymeric.c.e) com.baidu.tbadk.core.util.x.c(this.eDZ.eDd, i3);
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i2 = i3 + 1;
        }
    }

    public void setForumCardItemViewPool(com.baidu.adp.lib.e.b<s> bVar) {
        this.eEb = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.b bVar) {
        if (bVar == null || com.baidu.tbadk.core.util.x.r(bVar.eDd) || bVar == this.eDZ) {
            return false;
        }
        if (this.eDZ == null || com.baidu.tbadk.core.util.x.r(this.eDZ.eDd)) {
            return true;
        }
        if (com.baidu.tbadk.core.util.x.r(bVar.eDd)) {
            return false;
        }
        if (bVar.eDd.size() != this.eDZ.eDd.size()) {
            return true;
        }
        for (int i = 0; i < bVar.eDd.size(); i++) {
            if (this.eDZ.eDd.get(i) == null || bVar.eDd.get(i).forumId != this.eDZ.eDd.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
