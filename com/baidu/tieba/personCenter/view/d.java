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
    private BdBaseViewPager ceT;
    private TbTabLayout fUl;
    private List<com.baidu.tieba.personCenter.data.c> iob;
    private List<PersonCenterSmartAppPageView> ioc;
    private View iod;
    private a ioe;
    private PersonCenterSmartAppPageView iof;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.ceT = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fUl = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.iod = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fUl.setTabMode(1);
        this.ioc = new ArrayList();
        this.ioe = new a(this.ioc);
        this.ceT.setAdapter(this.ioe);
        this.fUl.setupWithViewPager(this.ceT);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.ioc) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.l(getView(), R.color.cp_bg_line_e);
        this.fUl.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.fUl.setBackgroundDrawable(am.X(l.g(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.l(this.iod, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(j jVar) {
        if (jVar == null || jVar.getData() == null || v.aa(jVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ioc.clear();
        this.iob = jVar.getData();
        this.iof = new PersonCenterSmartAppPageView(getContext());
        this.ioc.add(this.iof);
        int min = Math.min(7, this.iob.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.c(this.iob, i));
        }
        if (this.iob.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.ioc.size() <= 1) {
            this.fUl.setVisibility(8);
        } else {
            this.fUl.setVisibility(0);
        }
        this.ioe.dQ(this.ioc);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.iof.cct()) {
            this.iof.c(cVar);
            return;
        }
        this.iof = new PersonCenterSmartAppPageView(getContext());
        this.ioc.add(this.iof);
        this.iof.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> dRr;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.dRr = list;
        }

        public void dQ(List<PersonCenterSmartAppPageView> list) {
            this.dRr = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.dRr.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.dRr.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.dRr.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
