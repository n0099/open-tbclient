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
    private TbTabLayout fXB;
    private BdBaseViewPager fhx;
    private List<com.baidu.tieba.personCenter.c.c> mli;
    private List<PersonCenterSmartAppPageView> mlj;
    private View mlk;
    private a mll;
    private PersonCenterSmartAppPageView mlm;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fhx = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fXB = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.mlk = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fXB.setTabMode(1);
        this.mlj = new ArrayList();
        this.mll = new a(this.mlj);
        this.fhx.setAdapter(this.mll);
        this.fXB.setupWithViewPager(this.fhx);
        this.mlk.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.mlj) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.fXB.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0629));
        this.fXB.setBackgroundDrawable(ap.aR(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.CAM_X0625)));
        ap.setBackgroundColor(this.mlk, R.color.CAM_X0204);
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
        this.mlj.clear();
        this.mli = kVar.getData();
        this.mlm = new PersonCenterSmartAppPageView(getContext());
        this.mlj.add(this.mlm);
        int min = Math.min(7, this.mli.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.mli, i));
        }
        if (this.mli.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.mlj.size() <= 1) {
            this.fXB.setVisibility(8);
        } else {
            this.fXB.setVisibility(0);
        }
        this.mll.fy(this.mlj);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.mlm.dyC()) {
            this.mlm.c(cVar);
            return;
        }
        this.mlm = new PersonCenterSmartAppPageView(getContext());
        this.mlj.add(this.mlm);
        this.mlm.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> fXx;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.fXx = list;
        }

        public void fy(List<PersonCenterSmartAppPageView> list) {
            this.fXx = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fXx.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.fXx.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.fXx.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
