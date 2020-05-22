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
    private TbTabLayout gRw;
    private List<com.baidu.tieba.personCenter.c.c> kml;
    private List<PersonCenterSmartAppPageView> kmm;
    private View kmn;
    private a kmo;
    private PersonCenterSmartAppPageView kmp;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dZk = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gRw = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.kmn = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gRw.setTabMode(1);
        this.kmm = new ArrayList();
        this.kmo = new a(this.kmm);
        this.dZk.setAdapter(this.kmo);
        this.gRw.setupWithViewPager(this.dZk);
        this.kmn.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.kmm) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gRw.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gRw.setBackgroundDrawable(am.aE(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.kmn, R.color.cp_bg_line_c);
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
        this.kmm.clear();
        this.kml = jVar.getData();
        this.kmp = new PersonCenterSmartAppPageView(getContext());
        this.kmm.add(this.kmp);
        int min = Math.min(7, this.kml.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) v.getItem(this.kml, i));
        }
        if (this.kml.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.kmm.size() <= 1) {
            this.gRw.setVisibility(8);
        } else {
            this.gRw.setVisibility(0);
        }
        this.kmo.eg(this.kmm);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.kmp.cNq()) {
            this.kmp.c(cVar);
            return;
        }
        this.kmp = new PersonCenterSmartAppPageView(getContext());
        this.kmm.add(this.kmp);
        this.kmp.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> kmq;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.kmq = list;
        }

        public void eg(List<PersonCenterSmartAppPageView> list) {
            this.kmq = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.kmq.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.kmq.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.kmq.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
