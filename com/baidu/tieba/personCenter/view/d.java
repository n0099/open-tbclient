package com.baidu.tieba.personCenter.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager eyw;
    private TbTabLayout hwX;
    private List<com.baidu.tieba.personCenter.c.c> lgh;
    private List<PersonCenterSmartAppPageView> lgi;
    private View lgj;
    private a lgk;
    private PersonCenterSmartAppPageView lgl;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.eyw = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.hwX = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lgj = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.hwX.setTabMode(1);
        this.lgi = new ArrayList();
        this.lgk = new a(this.lgi);
        this.eyw.setAdapter(this.lgk);
        this.hwX.setupWithViewPager(this.eyw);
        this.lgj.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lgi) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.hwX.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_indicator_b));
        this.hwX.setBackgroundDrawable(ap.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.cp_indicator_a)));
        ap.setBackgroundColor(this.lgj, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar == null || kVar.getData() == null || y.isEmpty(kVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lgi.clear();
        this.lgh = kVar.getData();
        this.lgl = new PersonCenterSmartAppPageView(getContext());
        this.lgi.add(this.lgl);
        int min = Math.min(7, this.lgh.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lgh, i));
        }
        if (this.lgh.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lgi.size() <= 1) {
            this.hwX.setVisibility(8);
        } else {
            this.hwX.setVisibility(0);
        }
        this.lgk.eK(this.lgi);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lgl.dgM()) {
            this.lgl.c(cVar);
            return;
        }
        this.lgl = new PersonCenterSmartAppPageView(getContext());
        this.lgi.add(this.lgl);
        this.lgl.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> lgm;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.lgm = list;
        }

        public void eK(List<PersonCenterSmartAppPageView> list) {
            this.lgm = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.lgm.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.lgm.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.lgm.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
