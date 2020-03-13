package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.j;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<j> {
    private BdBaseViewPager dkI;
    private TbTabLayout gMP;
    private List<com.baidu.tieba.personCenter.c.c> jiD;
    private List<PersonCenterSmartAppPageView> jiE;
    private View jiF;
    private a jiG;
    private PersonCenterSmartAppPageView jiH;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dkI = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gMP = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.jiF = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gMP.setTabMode(1);
        this.jiE = new ArrayList();
        this.jiG = new a(this.jiE);
        this.dkI.setAdapter(this.jiG);
        this.gMP.setupWithViewPager(this.dkI);
        this.jiF.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.jiE) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gMP.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gMP.setBackgroundDrawable(am.ay(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.jiF, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(j jVar) {
        if (jVar == null || jVar.getData() == null || v.isEmpty(jVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jiE.clear();
        this.jiD = jVar.getData();
        this.jiH = new PersonCenterSmartAppPageView(getContext());
        this.jiE.add(this.jiH);
        int min = Math.min(7, this.jiD.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) v.getItem(this.jiD, i));
        }
        if (this.jiD.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.jiE.size() <= 1) {
            this.gMP.setVisibility(8);
        } else {
            this.gMP.setVisibility(0);
        }
        this.jiG.dP(this.jiE);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.jiH.cvq()) {
            this.jiH.c(cVar);
            return;
        }
        this.jiH = new PersonCenterSmartAppPageView(getContext());
        this.jiE.add(this.jiH);
        this.jiH.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> mViewList;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.mViewList = list;
        }

        public void dP(List<PersonCenterSmartAppPageView> list) {
            this.mViewList = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mViewList.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.mViewList.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.mViewList.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
