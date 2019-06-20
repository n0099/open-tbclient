package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.j;
import com.baidu.tieba.personCenter.data.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<j> {
    private BdBaseViewPager ccR;
    private TbTabLayout fMJ;
    private List<com.baidu.tieba.personCenter.data.c> ieG;
    private List<PersonCenterSmartAppPageView> ieH;
    private View ieI;
    private a ieJ;
    private PersonCenterSmartAppPageView ieK;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.ccR = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fMJ = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.ieI = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fMJ.setTabMode(1);
        this.ieH = new ArrayList();
        this.ieJ = new a(this.ieH);
        this.ccR.setAdapter(this.ieJ);
        this.fMJ.setupWithViewPager(this.ccR);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.ieH) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        this.fMJ.setSelectedTabIndicatorColor(al.getColor(R.color.cp_cont_c));
        al.k(this.fMJ, R.drawable.frs_tab_layout_bg);
        al.l(this.ieI, R.color.cp_bg_line_c);
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
        this.ieH.clear();
        this.ieG = jVar.getData();
        this.ieK = new PersonCenterSmartAppPageView(getContext());
        this.ieH.add(this.ieK);
        int min = Math.min(7, this.ieG.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.c(this.ieG, i));
        }
        if (this.ieG.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.ieH.size() <= 1) {
            this.fMJ.setVisibility(8);
        } else {
            this.fMJ.setVisibility(0);
        }
        this.ieJ.dP(this.ieH);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.ieK.bYy()) {
            this.ieK.c(cVar);
            return;
        }
        this.ieK = new PersonCenterSmartAppPageView(getContext());
        this.ieH.add(this.ieK);
        this.ieK.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> dLR;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.dLR = list;
        }

        public void dP(List<PersonCenterSmartAppPageView> list) {
            this.dLR = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.dLR.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.dLR.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.dLR.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
