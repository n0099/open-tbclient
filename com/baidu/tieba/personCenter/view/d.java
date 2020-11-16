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
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private TbTabLayout fPs;
    private BdBaseViewPager faa;
    private List<com.baidu.tieba.personCenter.c.c> lXa;
    private List<PersonCenterSmartAppPageView> lXb;
    private View lXc;
    private a lXd;
    private PersonCenterSmartAppPageView lXe;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.faa = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fPs = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lXc = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fPs.setTabMode(1);
        this.lXb = new ArrayList();
        this.lXd = new a(this.lXb);
        this.faa.setAdapter(this.lXd);
        this.fPs.setupWithViewPager(this.faa);
        this.lXc.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lXb) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.fPs.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0629));
        this.fPs.setBackgroundDrawable(ap.aP(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.CAM_X0625)));
        ap.setBackgroundColor(this.lXc, R.color.CAM_X0204);
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
        this.lXb.clear();
        this.lXa = kVar.getData();
        this.lXe = new PersonCenterSmartAppPageView(getContext());
        this.lXb.add(this.lXe);
        int min = Math.min(7, this.lXa.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lXa, i));
        }
        if (this.lXa.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lXb.size() <= 1) {
            this.fPs.setVisibility(8);
        } else {
            this.fPs.setVisibility(0);
        }
        this.lXd.fm(this.lXb);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lXe.dtk()) {
            this.lXe.c(cVar);
            return;
        }
        this.lXe = new PersonCenterSmartAppPageView(getContext());
        this.lXb.add(this.lXe);
        this.lXe.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> fPo;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.fPo = list;
        }

        public void fm(List<PersonCenterSmartAppPageView> list) {
            this.fPo = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fPo.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.fPo.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.fPo.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
