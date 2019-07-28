package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager hiX;
    private com.baidu.tieba.personPolymeric.c.c irE;
    private C0389a irF;
    private com.baidu.adp.lib.e.b<PersonCommonForumItemView> irG;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.irF = new C0389a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(R.id.common_forum_title);
        this.hiX = (ListViewPager) view.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.hiX.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.j(this.mTitle, R.color.cp_cont_d);
            int childCount = this.hiX.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.hiX.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.irE = cVar;
            if (v.Z(cVar.iqT) <= 2) {
                this.hiX.getLayoutParams().height = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.ds140);
            }
            this.hiX.setAdapter(this.irF);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0389a extends PagerAdapter {
        private C0389a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.irE == null || v.aa(a.this.irE.iqT)) {
                return 0;
            }
            return a.this.irE.iqT.size() % 4 == 0 ? a.this.irE.iqT.size() / 4 : (a.this.irE.iqT.size() / 4) + 1;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.recycle();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> yR = a.this.yR(i);
            if (v.aa(yR)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.irG);
            personCommonForumCardView.setData(yR);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> yR(int i) {
        if (this.irE == null || v.aa(this.irE.iqT)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.c(this.irE.iqT, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.e.b<PersonCommonForumItemView> bVar) {
        this.irG = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.aa(cVar.iqT) || cVar == this.irE) {
            return false;
        }
        if (this.irE == null || v.aa(this.irE.iqT)) {
            return true;
        }
        if (v.aa(cVar.iqT)) {
            return false;
        }
        if (cVar.iqT.size() != this.irE.iqT.size()) {
            return true;
        }
        for (int i = 0; i < cVar.iqT.size(); i++) {
            if (this.irE.iqT.get(i) == null || cVar.iqT.get(i).forumId != this.irE.iqT.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
