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
public class d extends com.baidu.tieba.card.a<j> {
    private BdBaseViewPager dKP;
    private TbTabLayout gCH;
    private List<com.baidu.tieba.personCenter.c.c> jUp;
    private List<PersonCenterSmartAppPageView> jUq;
    private View jUr;
    private a jUs;
    private PersonCenterSmartAppPageView jUt;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dKP = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gCH = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.jUr = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gCH.setTabMode(1);
        this.jUq = new ArrayList();
        this.jUs = new a(this.jUq);
        this.dKP.setAdapter(this.jUs);
        this.gCH.setupWithViewPager(this.dKP);
        this.jUr.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.jUq) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gCH.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gCH.setBackgroundDrawable(am.aB(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.jUr, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(j jVar) {
        if (jVar == null || jVar.getData() == null || v.isEmpty(jVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jUq.clear();
        this.jUp = jVar.getData();
        this.jUt = new PersonCenterSmartAppPageView(getContext());
        this.jUq.add(this.jUt);
        int min = Math.min(7, this.jUp.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) v.getItem(this.jUp, i));
        }
        if (this.jUp.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.jUq.size() <= 1) {
            this.gCH.setVisibility(8);
        } else {
            this.gCH.setVisibility(0);
        }
        this.jUs.ea(this.jUq);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.jUt.cGt()) {
            this.jUt.c(cVar);
            return;
        }
        this.jUt = new PersonCenterSmartAppPageView(getContext());
        this.jUq.add(this.jUt);
        this.jUt.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> jUu;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.jUu = list;
        }

        public void ea(List<PersonCenterSmartAppPageView> list) {
            this.jUu = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.jUu.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.jUu.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.jUu.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
