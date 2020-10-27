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
    private BdBaseViewPager eVd;
    private TbTabLayout fJT;
    private List<com.baidu.tieba.personCenter.c.c> lQM;
    private List<PersonCenterSmartAppPageView> lQN;
    private View lQO;
    private a lQP;
    private PersonCenterSmartAppPageView lQQ;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.eVd = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fJT = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lQO = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fJT.setTabMode(1);
        this.lQN = new ArrayList();
        this.lQP = new a(this.lQN);
        this.eVd.setAdapter(this.lQP);
        this.fJT.setupWithViewPager(this.eVd);
        this.lQO.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lQN) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.fJT.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_indicator_b));
        this.fJT.setBackgroundDrawable(ap.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.cp_indicator_a)));
        ap.setBackgroundColor(this.lQO, R.color.cp_bg_line_c);
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
        this.lQN.clear();
        this.lQM = kVar.getData();
        this.lQQ = new PersonCenterSmartAppPageView(getContext());
        this.lQN.add(this.lQQ);
        int min = Math.min(7, this.lQM.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lQM, i));
        }
        if (this.lQM.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lQN.size() <= 1) {
            this.fJT.setVisibility(8);
        } else {
            this.fJT.setVisibility(0);
        }
        this.lQP.fe(this.lQN);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lQQ.dri()) {
            this.lQQ.c(cVar);
            return;
        }
        this.lQQ = new PersonCenterSmartAppPageView(getContext());
        this.lQN.add(this.lQQ);
        this.lQQ.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> fJP;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.fJP = list;
        }

        public void fe(List<PersonCenterSmartAppPageView> list) {
            this.fJP = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fJP.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.fJP.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.fJP.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
