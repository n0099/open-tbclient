package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
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
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager fmy;
    private TbTabLayout gcC;
    private List<com.baidu.tieba.personCenter.c.c> mlN;
    private List<PersonCenterSmartAppPageView> mlO;
    private View mlP;
    private a mlQ;
    private PersonCenterSmartAppPageView mlR;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fmy = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gcC = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.mlP = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gcC.setTabMode(1);
        this.mlO = new ArrayList();
        this.mlQ = new a(this.mlO);
        this.fmy.setAdapter(this.mlQ);
        this.gcC.setupWithViewPager(this.fmy);
        this.mlP.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.mlO) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.gcC.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0629));
        this.gcC.setBackgroundDrawable(ao.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ao.getColor(R.color.CAM_X0625)));
        ao.setBackgroundColor(this.mlP, R.color.CAM_X0204);
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
        this.mlO.clear();
        this.mlN = kVar.getData();
        this.mlR = new PersonCenterSmartAppPageView(getContext());
        this.mlO.add(this.mlR);
        int min = Math.min(7, this.mlN.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) x.getItem(this.mlN, i));
        }
        if (this.mlN.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.mlO.size() <= 1) {
            this.gcC.setVisibility(8);
        } else {
            this.gcC.setVisibility(0);
        }
        this.mlQ.fy(this.mlO);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.mlR.duB()) {
            this.mlR.c(cVar);
            return;
        }
        this.mlR = new PersonCenterSmartAppPageView(getContext());
        this.mlO.add(this.mlR);
        this.mlR.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> gcy;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.gcy = list;
        }

        public void fy(List<PersonCenterSmartAppPageView> list) {
            this.gcy = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.gcy.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.gcy.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.gcy.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
