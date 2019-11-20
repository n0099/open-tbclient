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
import com.baidu.tieba.personCenter.data.j;
import com.baidu.tieba.personCenter.data.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<j> {
    private BdBaseViewPager cso;
    private TbTabLayout fSO;
    private List<com.baidu.tieba.personCenter.data.c> ilS;
    private List<PersonCenterSmartAppPageView> ilT;
    private View ilU;
    private a ilV;
    private PersonCenterSmartAppPageView ilW;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.cso = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fSO = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.ilU = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fSO.setTabMode(1);
        this.ilT = new ArrayList();
        this.ilV = new a(this.ilT);
        this.cso.setAdapter(this.ilV);
        this.fSO.setupWithViewPager(this.cso);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.ilT) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.fSO.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.fSO.setBackgroundDrawable(am.Z(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.ilU, R.color.cp_bg_line_c);
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
        this.ilT.clear();
        this.ilS = jVar.getData();
        this.ilW = new PersonCenterSmartAppPageView(getContext());
        this.ilT.add(this.ilW);
        int min = Math.min(7, this.ilS.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.getItem(this.ilS, i));
        }
        if (this.ilS.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.ilT.size() <= 1) {
            this.fSO.setVisibility(8);
        } else {
            this.fSO.setVisibility(0);
        }
        this.ilV.ed(this.ilT);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.ilW.bZt()) {
            this.ilW.c(cVar);
            return;
        }
        this.ilW = new PersonCenterSmartAppPageView(getContext());
        this.ilT.add(this.ilW);
        this.ilW.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> ilX;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.ilX = list;
        }

        public void ed(List<PersonCenterSmartAppPageView> list) {
            this.ilX = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.ilX.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.ilX.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.ilX.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
