package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager ehU;
    private TbTabLayout heq;
    private List<com.baidu.tieba.personCenter.c.c> kHi;
    private List<PersonCenterSmartAppPageView> kHj;
    private View kHk;
    private a kHl;
    private PersonCenterSmartAppPageView kHm;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.ehU = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.heq = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.kHk = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.heq.setTabMode(1);
        this.kHj = new ArrayList();
        this.kHl = new a(this.kHj);
        this.ehU.setAdapter(this.kHl);
        this.heq.setupWithViewPager(this.ehU);
        this.kHk.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.kHj) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.heq.setSelectedTabIndicatorColor(an.getColor(R.color.cp_indicator_b));
        this.heq.setBackgroundDrawable(an.aG(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), an.getColor(R.color.cp_indicator_a)));
        an.setBackgroundColor(this.kHk, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar == null || kVar.getData() == null || w.isEmpty(kVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kHj.clear();
        this.kHi = kVar.getData();
        this.kHm = new PersonCenterSmartAppPageView(getContext());
        this.kHj.add(this.kHm);
        int min = Math.min(7, this.kHi.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) w.getItem(this.kHi, i));
        }
        if (this.kHi.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.kHj.size() <= 1) {
            this.heq.setVisibility(8);
        } else {
            this.heq.setVisibility(0);
        }
        this.kHl.ew(this.kHj);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.kHm.cRY()) {
            this.kHm.c(cVar);
            return;
        }
        this.kHm = new PersonCenterSmartAppPageView(getContext());
        this.kHj.add(this.kHm);
        this.kHm.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> kHn;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.kHn = list;
        }

        public void ew(List<PersonCenterSmartAppPageView> list) {
            this.kHn = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.kHn.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.kHn.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.kHn.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
