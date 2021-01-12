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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager kYc;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;
    private com.baidu.tieba.personPolymeric.c.c mvd;
    private C0843a mve;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mvf;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mve = new C0843a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(R.id.common_forum_title);
        this.kYc = (ListViewPager) view.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.kYc.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0109);
            int childCount = this.kYc.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.kYc.getChildAt(i2);
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
            this.mvd = cVar;
            if (x.getCount(cVar.msx) <= 2) {
                this.kYc.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds140);
            }
            this.kYc.setAdapter(this.mve);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0843a extends PagerAdapter {
        private C0843a() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (a.this.mvd == null || x.isEmpty(a.this.mvd.msx)) {
                return 0;
            }
            return a.this.mvd.msx.size() % 4 == 0 ? a.this.mvd.msx.size() / 4 : (a.this.mvd.msx.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> GM = a.this.GM(i);
            if (x.isEmpty(GM)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.mvf);
            personCommonForumCardView.setData(GM);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> GM(int i) {
        if (this.mvd == null || x.isEmpty(this.mvd.msx)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) x.getItem(this.mvd.msx, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mvf = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || x.isEmpty(cVar.msx) || cVar == this.mvd) {
            return false;
        }
        if (this.mvd == null || x.isEmpty(this.mvd.msx)) {
            return true;
        }
        if (x.isEmpty(cVar.msx)) {
            return false;
        }
        if (cVar.msx.size() != this.mvd.msx.size()) {
            return true;
        }
        for (int i = 0; i < cVar.msx.size(); i++) {
            if (this.mvd.msx.get(i) == null || cVar.msx.get(i).forumId != this.mvd.msx.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
