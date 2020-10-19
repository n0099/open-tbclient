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
    private BdBaseViewPager eMH;
    private TbTabLayout fBy;
    private List<com.baidu.tieba.personCenter.c.c> lEq;
    private List<PersonCenterSmartAppPageView> lEr;
    private View lEs;
    private a lEt;
    private PersonCenterSmartAppPageView lEu;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.eMH = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fBy = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lEs = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fBy.setTabMode(1);
        this.lEr = new ArrayList();
        this.lEt = new a(this.lEr);
        this.eMH.setAdapter(this.lEt);
        this.fBy.setupWithViewPager(this.eMH);
        this.lEs.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lEr) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.fBy.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_indicator_b));
        this.fBy.setBackgroundDrawable(ap.aN(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.cp_indicator_a)));
        ap.setBackgroundColor(this.lEs, R.color.cp_bg_line_c);
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
        this.lEr.clear();
        this.lEq = kVar.getData();
        this.lEu = new PersonCenterSmartAppPageView(getContext());
        this.lEr.add(this.lEu);
        int min = Math.min(7, this.lEq.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lEq, i));
        }
        if (this.lEq.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lEr.size() <= 1) {
            this.fBy.setVisibility(8);
        } else {
            this.fBy.setVisibility(0);
        }
        this.lEt.eV(this.lEr);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lEu.dob()) {
            this.lEu.c(cVar);
            return;
        }
        this.lEu = new PersonCenterSmartAppPageView(getContext());
        this.lEr.add(this.lEu);
        this.lEu.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> fBu;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.fBu = list;
        }

        public void eV(List<PersonCenterSmartAppPageView> list) {
            this.fBu = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fBu.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.fBu.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.fBu.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
