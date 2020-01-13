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
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.a<j> {
    private BdBaseViewPager dgo;
    private TbTabLayout gKC;
    private List<com.baidu.tieba.personCenter.data.c> jhq;
    private List<PersonCenterSmartAppPageView> jhr;
    private View jhs;
    private a jht;
    private PersonCenterSmartAppPageView jhu;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.dgo = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.gKC = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.jhs = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.gKC.setTabMode(1);
        this.jhr = new ArrayList();
        this.jht = new a(this.jhr);
        this.dgo.setAdapter(this.jht);
        this.gKC.setupWithViewPager(this.dgo);
        this.jhs.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.jhr) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.gKC.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.gKC.setBackgroundDrawable(am.ay(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.jhs, R.color.cp_bg_line_c);
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
        this.jhr.clear();
        this.jhq = jVar.getData();
        this.jhu = new PersonCenterSmartAppPageView(getContext());
        this.jhr.add(this.jhu);
        int min = Math.min(7, this.jhq.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.getItem(this.jhq, i));
        }
        if (this.jhq.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.jhr.size() <= 1) {
            this.gKC.setVisibility(8);
        } else {
            this.gKC.setVisibility(0);
        }
        this.jht.dT(this.jhr);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.jhu.ctS()) {
            this.jhu.c(cVar);
            return;
        }
        this.jhu = new PersonCenterSmartAppPageView(getContext());
        this.jhr.add(this.jhu);
        this.jhu.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> mViewList;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.mViewList = list;
        }

        public void dT(List<PersonCenterSmartAppPageView> list) {
            this.mViewList = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mViewList.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.mViewList.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.mViewList.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
