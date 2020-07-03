package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager jvj;
    private com.baidu.tieba.personPolymeric.c.c kPS;
    private C0717a kPT;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> kPU;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.kPT = new C0717a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(R.id.common_forum_title);
        this.jvj = (ListViewPager) view.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.jvj.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_d);
            int childCount = this.jvj.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.jvj.getChildAt(i2);
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
            this.kPS = cVar;
            if (w.getCount(cVar.kNJ) <= 2) {
                this.jvj.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds140);
            }
            this.jvj.setAdapter(this.kPT);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0717a extends PagerAdapter {
        private C0717a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.kPS == null || w.isEmpty(a.this.kPS.kNJ)) {
                return 0;
            }
            return a.this.kPS.kNJ.size() % 4 == 0 ? a.this.kPS.kNJ.size() / 4 : (a.this.kPS.kNJ.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> CC = a.this.CC(i);
            if (w.isEmpty(CC)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.kPU);
            personCommonForumCardView.setData(CC);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> CC(int i) {
        if (this.kPS == null || w.isEmpty(this.kPS.kNJ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) w.getItem(this.kPS.kNJ, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.kPU = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || w.isEmpty(cVar.kNJ) || cVar == this.kPS) {
            return false;
        }
        if (this.kPS == null || w.isEmpty(this.kPS.kNJ)) {
            return true;
        }
        if (w.isEmpty(cVar.kNJ)) {
            return false;
        }
        if (cVar.kNJ.size() != this.kPS.kNJ.size()) {
            return true;
        }
        for (int i = 0; i < cVar.kNJ.size(); i++) {
            if (this.kPS.kNJ.get(i) == null || cVar.kNJ.get(i).forumId != this.kPS.kNJ.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
