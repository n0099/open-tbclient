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
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private TbTabLayout fPJ;
    private BdBaseViewPager faS;
    private List<com.baidu.tieba.personCenter.c.c> lWI;
    private List<PersonCenterSmartAppPageView> lWJ;
    private View lWK;
    private a lWL;
    private PersonCenterSmartAppPageView lWM;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.faS = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fPJ = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lWK = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fPJ.setTabMode(1);
        this.lWJ = new ArrayList();
        this.lWL = new a(this.lWJ);
        this.faS.setAdapter(this.lWL);
        this.fPJ.setupWithViewPager(this.faS);
        this.lWK.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lWJ) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.fPJ.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_indicator_b));
        this.fPJ.setBackgroundDrawable(ap.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.cp_indicator_a)));
        ap.setBackgroundColor(this.lWK, R.color.cp_bg_line_c);
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
        this.lWJ.clear();
        this.lWI = kVar.getData();
        this.lWM = new PersonCenterSmartAppPageView(getContext());
        this.lWJ.add(this.lWM);
        int min = Math.min(7, this.lWI.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lWI, i));
        }
        if (this.lWI.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lWJ.size() <= 1) {
            this.fPJ.setVisibility(8);
        } else {
            this.fPJ.setVisibility(0);
        }
        this.lWL.fm(this.lWJ);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lWM.dtK()) {
            this.lWM.c(cVar);
            return;
        }
        this.lWM = new PersonCenterSmartAppPageView(getContext());
        this.lWJ.add(this.lWM);
        this.lWM.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> fPF;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.fPF = list;
        }

        public void fm(List<PersonCenterSmartAppPageView> list) {
            this.fPF = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fPF.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.fPF.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.fPF.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
