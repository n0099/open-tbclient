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
    private BdBaseViewPager dkV;
    private TbTabLayout gNU;
    private List<com.baidu.tieba.personCenter.c.c> jkc;
    private List<PersonCenterSmartAppPageView> jkd;
    private View jke;
    private a jkf;
    private PersonCenterSmartAppPageView jkg;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dkV = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gNU = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.jke = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gNU.setTabMode(1);
        this.jkd = new ArrayList();
        this.jkf = new a(this.jkd);
        this.dkV.setAdapter(this.jkf);
        this.gNU.setupWithViewPager(this.dkV);
        this.jke.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.jkd) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gNU.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gNU.setBackgroundDrawable(am.ay(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.jke, R.color.cp_bg_line_c);
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
        this.jkd.clear();
        this.jkc = jVar.getData();
        this.jkg = new PersonCenterSmartAppPageView(getContext());
        this.jkd.add(this.jkg);
        int min = Math.min(7, this.jkc.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) v.getItem(this.jkc, i));
        }
        if (this.jkc.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.jkd.size() <= 1) {
            this.gNU.setVisibility(8);
        } else {
            this.gNU.setVisibility(0);
        }
        this.jkf.dP(this.jkd);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.jkg.cvJ()) {
            this.jkg.c(cVar);
            return;
        }
        this.jkg = new PersonCenterSmartAppPageView(getContext());
        this.jkd.add(this.jkg);
        this.jkg.c(cVar);
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
