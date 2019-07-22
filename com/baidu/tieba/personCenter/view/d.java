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
    private BdBaseViewPager cdT;
    private TbTabLayout fRG;
    private List<com.baidu.tieba.personCenter.data.c> ikW;
    private List<PersonCenterSmartAppPageView> ikX;
    private View ikY;
    private a ikZ;
    private PersonCenterSmartAppPageView ila;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.cdT = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fRG = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.ikY = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fRG.setTabMode(1);
        this.ikX = new ArrayList();
        this.ikZ = new a(this.ikX);
        this.cdT.setAdapter(this.ikZ);
        this.fRG.setupWithViewPager(this.cdT);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.ikX) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        this.fRG.setSelectedTabIndicatorColor(am.getColor(R.color.cp_cont_c));
        am.k(this.fRG, R.drawable.frs_tab_layout_bg);
        am.l(this.ikY, R.color.cp_bg_line_c);
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
        this.ikX.clear();
        this.ikW = jVar.getData();
        this.ila = new PersonCenterSmartAppPageView(getContext());
        this.ikX.add(this.ila);
        int min = Math.min(7, this.ikW.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.c(this.ikW, i));
        }
        if (this.ikW.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.ikX.size() <= 1) {
            this.fRG.setVisibility(8);
        } else {
            this.fRG.setVisibility(0);
        }
        this.ikZ.dR(this.ikX);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.ila.cbn()) {
            this.ila.c(cVar);
            return;
        }
        this.ila = new PersonCenterSmartAppPageView(getContext());
        this.ikX.add(this.ila);
        this.ila.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> dPz;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.dPz = list;
        }

        public void dR(List<PersonCenterSmartAppPageView> list) {
            this.dPz = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.dPz.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.dPz.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.dPz.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
