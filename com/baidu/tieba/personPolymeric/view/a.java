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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager jea;
    private com.baidu.tieba.personPolymeric.c.c kvV;
    private C0701a kvW;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> kvX;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.kvW = new C0701a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(R.id.common_forum_title);
        this.jea = (ListViewPager) view.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.jea.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_d);
            int childCount = this.jea.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.jea.getChildAt(i2);
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
            this.kvV = cVar;
            if (v.getCount(cVar.ktM) <= 2) {
                this.jea.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds140);
            }
            this.jea.setAdapter(this.kvW);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0701a extends PagerAdapter {
        private C0701a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.kvV == null || v.isEmpty(a.this.kvV.ktM)) {
                return 0;
            }
            return a.this.kvV.ktM.size() % 4 == 0 ? a.this.kvV.ktM.size() / 4 : (a.this.kvV.ktM.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> BA = a.this.BA(i);
            if (v.isEmpty(BA)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.kvX);
            personCommonForumCardView.setData(BA);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> BA(int i) {
        if (this.kvV == null || v.isEmpty(this.kvV.ktM)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) v.getItem(this.kvV.ktM, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.kvX = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || v.isEmpty(cVar.ktM) || cVar == this.kvV) {
            return false;
        }
        if (this.kvV == null || v.isEmpty(this.kvV.ktM)) {
            return true;
        }
        if (v.isEmpty(cVar.ktM)) {
            return false;
        }
        if (cVar.ktM.size() != this.kvV.ktM.size()) {
            return true;
        }
        for (int i = 0; i < cVar.ktM.size(); i++) {
            if (this.kvV.ktM.get(i) == null || cVar.ktM.get(i).forumId != this.kvV.ktM.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
