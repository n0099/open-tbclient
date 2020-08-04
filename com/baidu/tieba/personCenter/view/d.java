package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager eog;
    private TbTabLayout hka;
    private List<com.baidu.tieba.personCenter.c.c> kQk;
    private List<PersonCenterSmartAppPageView> kQl;
    private View kQm;
    private a kQn;
    private PersonCenterSmartAppPageView kQo;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.eog = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.hka = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.kQm = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.hka.setTabMode(1);
        this.kQl = new ArrayList();
        this.kQn = new a(this.kQl);
        this.eog.setAdapter(this.kQn);
        this.hka.setupWithViewPager(this.eog);
        this.kQm.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.kQl) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.hka.setSelectedTabIndicatorColor(ao.getColor(R.color.cp_indicator_b));
        this.hka.setBackgroundDrawable(ao.aH(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ao.getColor(R.color.cp_indicator_a)));
        ao.setBackgroundColor(this.kQm, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar == null || kVar.getData() == null || x.isEmpty(kVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kQl.clear();
        this.kQk = kVar.getData();
        this.kQo = new PersonCenterSmartAppPageView(getContext());
        this.kQl.add(this.kQo);
        int min = Math.min(7, this.kQk.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) x.getItem(this.kQk, i));
        }
        if (this.kQk.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.kQl.size() <= 1) {
            this.hka.setVisibility(8);
        } else {
            this.hka.setVisibility(0);
        }
        this.kQn.eC(this.kQl);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.kQo.cVO()) {
            this.kQo.c(cVar);
            return;
        }
        this.kQo = new PersonCenterSmartAppPageView(getContext());
        this.kQl.add(this.kQo);
        this.kQo.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> kQp;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.kQp = list;
        }

        public void eC(List<PersonCenterSmartAppPageView> list) {
            this.kQp = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.kQp.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.kQp.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.kQp.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
