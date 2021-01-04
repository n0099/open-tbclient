package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager lcJ;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;
    private com.baidu.tieba.personPolymeric.c.c mzI;
    private C0827a mzJ;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mzK;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mzJ = new C0827a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(R.id.common_forum_title);
        this.lcJ = (ListViewPager) view.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.lcJ.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0109);
            int childCount = this.lcJ.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.lcJ.getChildAt(i2);
                if (childAt instanceof PersonCommonForumCardView) {
                    ((PersonCommonForumCardView) childAt).onChangeSkinType();
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_info_common_forum_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (b(cVar)) {
            this.mzI = cVar;
            if (x.getCount(cVar.mxc) <= 2) {
                this.lcJ.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds140);
            }
            this.lcJ.setAdapter(this.mzJ);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0827a extends PagerAdapter {
        private C0827a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (a.this.mzI == null || x.isEmpty(a.this.mzI.mxc)) {
                return 0;
            }
            return a.this.mzI.mxc.size() % 4 == 0 ? a.this.mzI.mxc.size() / 4 : (a.this.mzI.mxc.size() / 4) + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof PersonCommonForumCardView) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.recycle();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            List<com.baidu.tieba.personPolymeric.c.f> It = a.this.It(i);
            if (x.isEmpty(It)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.mzK);
            personCommonForumCardView.setData(It);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> It(int i) {
        if (this.mzI == null || x.isEmpty(this.mzI.mxc)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) x.getItem(this.mzI.mxc, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mzK = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || x.isEmpty(cVar.mxc) || cVar == this.mzI) {
            return false;
        }
        if (this.mzI == null || x.isEmpty(this.mzI.mxc)) {
            return true;
        }
        if (x.isEmpty(cVar.mxc)) {
            return false;
        }
        if (cVar.mxc.size() != this.mzI.mxc.size()) {
            return true;
        }
        for (int i = 0; i < cVar.mxc.size(); i++) {
            if (this.mzI.mxc.get(i) == null || cVar.mxc.get(i).forumId != this.mzI.mxc.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
