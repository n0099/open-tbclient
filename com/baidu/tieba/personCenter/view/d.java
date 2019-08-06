package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
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
    private BdBaseViewPager cea;
    private TbTabLayout fSu;
    private List<com.baidu.tieba.personCenter.data.c> ilZ;
    private List<PersonCenterSmartAppPageView> ima;
    private View imb;
    private a imc;
    private PersonCenterSmartAppPageView imd;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.cea = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fSu = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.imb = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fSu.setTabMode(1);
        this.ima = new ArrayList();
        this.imc = new a(this.ima);
        this.cea.setAdapter(this.imc);
        this.fSu.setupWithViewPager(this.cea);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.ima) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        this.fSu.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_c));
        am.k(this.fSu, R.drawable.frs_tab_layout_bg);
        am.l(this.imb, R.color.cp_bg_line_c);
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
        this.ima.clear();
        this.ilZ = jVar.getData();
        this.imd = new PersonCenterSmartAppPageView(getContext());
        this.ima.add(this.imd);
        int min = Math.min(7, this.ilZ.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.c(this.ilZ, i));
        }
        if (this.ilZ.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.ima.size() <= 1) {
            this.fSu.setVisibility(8);
        } else {
            this.fSu.setVisibility(0);
        }
        this.imc.dQ(this.ima);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.imd.cbF()) {
            this.imd.c(cVar);
            return;
        }
        this.imd = new PersonCenterSmartAppPageView(getContext());
        this.ima.add(this.imd);
        this.imd.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> dPG;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.dPG = list;
        }

        public void dQ(List<PersonCenterSmartAppPageView> list) {
            this.dPG = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.dPG.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.dPG.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.dPG.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
