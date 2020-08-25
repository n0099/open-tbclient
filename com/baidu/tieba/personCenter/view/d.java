package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager eys;
    private TbTabLayout hwR;
    private List<com.baidu.tieba.personCenter.c.c> lga;
    private List<PersonCenterSmartAppPageView> lgb;
    private View lgc;
    private a lgd;
    private PersonCenterSmartAppPageView lge;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.eys = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.hwR = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lgc = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.hwR.setTabMode(1);
        this.lgb = new ArrayList();
        this.lgd = new a(this.lgb);
        this.eys.setAdapter(this.lgd);
        this.hwR.setupWithViewPager(this.eys);
        this.lgc.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lgb) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.hwR.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_indicator_b));
        this.hwR.setBackgroundDrawable(ap.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.cp_indicator_a)));
        ap.setBackgroundColor(this.lgc, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar == null || kVar.getData() == null || y.isEmpty(kVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lgb.clear();
        this.lga = kVar.getData();
        this.lge = new PersonCenterSmartAppPageView(getContext());
        this.lgb.add(this.lge);
        int min = Math.min(7, this.lga.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lga, i));
        }
        if (this.lga.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lgb.size() <= 1) {
            this.hwR.setVisibility(8);
        } else {
            this.hwR.setVisibility(0);
        }
        this.lgd.eK(this.lgb);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lge.dgL()) {
            this.lge.c(cVar);
            return;
        }
        this.lge = new PersonCenterSmartAppPageView(getContext());
        this.lgb.add(this.lge);
        this.lge.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> lgf;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.lgf = list;
        }

        public void eK(List<PersonCenterSmartAppPageView> list) {
            this.lgf = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.lgf.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.lgf.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.lgf.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
