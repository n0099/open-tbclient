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
import com.baidu.tieba.personCenter.c.j;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<j> {
    private BdBaseViewPager dZk;
    private TbTabLayout gRH;
    private List<com.baidu.tieba.personCenter.c.c> knr;
    private List<PersonCenterSmartAppPageView> kns;
    private View knt;
    private a knu;
    private PersonCenterSmartAppPageView knv;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dZk = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gRH = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.knt = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gRH.setTabMode(1);
        this.kns = new ArrayList();
        this.knu = new a(this.kns);
        this.dZk.setAdapter(this.knu);
        this.gRH.setupWithViewPager(this.dZk);
        this.knt.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.kns) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gRH.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gRH.setBackgroundDrawable(am.aE(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.knt, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(j jVar) {
        if (jVar == null || jVar.getData() == null || v.isEmpty(jVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kns.clear();
        this.knr = jVar.getData();
        this.knv = new PersonCenterSmartAppPageView(getContext());
        this.kns.add(this.knv);
        int min = Math.min(7, this.knr.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) v.getItem(this.knr, i));
        }
        if (this.knr.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.kns.size() <= 1) {
            this.gRH.setVisibility(8);
        } else {
            this.gRH.setVisibility(0);
        }
        this.knu.ei(this.kns);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.knv.cNG()) {
            this.knv.c(cVar);
            return;
        }
        this.knv = new PersonCenterSmartAppPageView(getContext());
        this.kns.add(this.knv);
        this.knv.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> knw;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.knw = list;
        }

        public void ei(List<PersonCenterSmartAppPageView> list) {
            this.knw = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.knw.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.knw.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.knw.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
