package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
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
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager foQ;
    private TbTabLayout geR;
    private List<com.baidu.tieba.personCenter.c.c> muO;
    private List<PersonCenterSmartAppPageView> muP;
    private View muQ;
    private a muR;
    private PersonCenterSmartAppPageView muS;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.foQ = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.geR = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.muQ = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.geR.setTabMode(1);
        this.muP = new ArrayList();
        this.muR = new a(this.muP);
        this.foQ.setAdapter(this.muR);
        this.geR.setupWithViewPager(this.foQ);
        this.muQ.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.muP) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.geR.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0629));
        this.geR.setBackgroundDrawable(ap.aL(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.CAM_X0625)));
        ap.setBackgroundColor(this.muQ, R.color.CAM_X0204);
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
        this.muP.clear();
        this.muO = kVar.getData();
        this.muS = new PersonCenterSmartAppPageView(getContext());
        this.muP.add(this.muS);
        int min = Math.min(7, this.muO.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.muO, i));
        }
        if (this.muO.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.muP.size() <= 1) {
            this.geR.setVisibility(8);
        } else {
            this.geR.setVisibility(0);
        }
        this.muR.fw(this.muP);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.muS.dwK()) {
            this.muS.c(cVar);
            return;
        }
        this.muS = new PersonCenterSmartAppPageView(getContext());
        this.muP.add(this.muS);
        this.muS.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> geN;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.geN = list;
        }

        public void fw(List<PersonCenterSmartAppPageView> list) {
            this.geN = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.geN.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.geN.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.geN.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
