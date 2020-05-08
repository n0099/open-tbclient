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
    private BdBaseViewPager dKT;
    private TbTabLayout gCN;
    private List<com.baidu.tieba.personCenter.c.c> jUt;
    private List<PersonCenterSmartAppPageView> jUu;
    private View jUv;
    private a jUw;
    private PersonCenterSmartAppPageView jUx;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dKT = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gCN = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.jUv = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gCN.setTabMode(1);
        this.jUu = new ArrayList();
        this.jUw = new a(this.jUu);
        this.dKT.setAdapter(this.jUw);
        this.gCN.setupWithViewPager(this.dKT);
        this.jUv.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.jUu) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gCN.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gCN.setBackgroundDrawable(am.aB(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.jUv, R.color.cp_bg_line_c);
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
        this.jUu.clear();
        this.jUt = jVar.getData();
        this.jUx = new PersonCenterSmartAppPageView(getContext());
        this.jUu.add(this.jUx);
        int min = Math.min(7, this.jUt.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) v.getItem(this.jUt, i));
        }
        if (this.jUt.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.jUu.size() <= 1) {
            this.gCN.setVisibility(8);
        } else {
            this.gCN.setVisibility(0);
        }
        this.jUw.ea(this.jUu);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.jUx.cGq()) {
            this.jUx.c(cVar);
            return;
        }
        this.jUx = new PersonCenterSmartAppPageView(getContext());
        this.jUu.add(this.jUx);
        this.jUx.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> jUy;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.jUy = list;
        }

        public void ea(List<PersonCenterSmartAppPageView> list) {
            this.jUy = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.jUy.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.jUy.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.jUy.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
