package com.baidu.tieba.personPolymeric.view;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.personPolymeric.c.c> {
    public ListViewPager kXe;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    public TextView mTitle;
    private com.baidu.tieba.personPolymeric.c.c muv;
    private C0843a muw;
    private com.baidu.adp.lib.d.b<PersonCommonForumItemView> mux;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.muw = new C0843a();
        this.mPageContext = tbPageContext;
        View view = getView();
        this.mTitle = (TextView) view.findViewById(R.id.common_forum_title);
        this.kXe = (ListViewPager) view.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            view.setLayerType(2, null);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipChildren(true);
            }
        }
        this.kXe.setOffscreenPageLimit(1);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0109);
            int childCount = this.kXe.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.kXe.getChildAt(i2);
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
            this.muv = cVar;
            if (y.getCount(cVar.mrO) <= 2) {
                this.kXe.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds140);
            }
            this.kXe.setAdapter(this.muw);
        }
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.personPolymeric.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public class C0843a extends PagerAdapter {
        private C0843a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (a.this.muv == null || y.isEmpty(a.this.muv.mrO)) {
                return 0;
            }
            return a.this.muv.mrO.size() % 4 == 0 ? a.this.muv.mrO.size() / 4 : (a.this.muv.mrO.size() / 4) + 1;
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
            List<com.baidu.tieba.personPolymeric.c.f> Iz = a.this.Iz(i);
            if (y.isEmpty(Iz)) {
                return null;
            }
            PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(a.this.mPageContext.getPageActivity());
            personCommonForumCardView.setForumItemViewBdObjectPool(a.this.mux);
            personCommonForumCardView.setData(Iz);
            personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
            viewGroup.addView(personCommonForumCardView);
            return personCommonForumCardView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.personPolymeric.c.f> Iz(int i) {
        if (this.muv == null || y.isEmpty(this.muv.mrO)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = i * 4;
        while (true) {
            int i3 = i2;
            if (i3 >= (i * 4) + 4) {
                return arrayList;
            }
            com.baidu.tieba.personPolymeric.c.f fVar = (com.baidu.tieba.personPolymeric.c.f) y.getItem(this.muv.mrO, i3);
            if (fVar != null) {
                arrayList.add(fVar);
            }
            i2 = i3 + 1;
        }
    }

    public void a(com.baidu.adp.lib.d.b<PersonCommonForumItemView> bVar) {
        this.mux = bVar;
    }

    private boolean b(com.baidu.tieba.personPolymeric.c.c cVar) {
        if (cVar == null || y.isEmpty(cVar.mrO) || cVar == this.muv) {
            return false;
        }
        if (this.muv == null || y.isEmpty(this.muv.mrO)) {
            return true;
        }
        if (y.isEmpty(cVar.mrO)) {
            return false;
        }
        if (cVar.mrO.size() != this.muv.mrO.size()) {
            return true;
        }
        for (int i = 0; i < cVar.mrO.size(); i++) {
            if (this.muv.mrO.get(i) == null || cVar.mrO.get(i).forumId != this.muv.mrO.get(i).forumId) {
                return true;
            }
        }
        return false;
    }
}
