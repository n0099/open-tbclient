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
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager eAA;
    private TbTabLayout fpk;
    private List<com.baidu.tieba.personCenter.c.c> lpd;
    private List<PersonCenterSmartAppPageView> lpe;
    private View lpf;
    private a lpg;
    private PersonCenterSmartAppPageView lph;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.eAA = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fpk = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.lpf = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fpk.setTabMode(1);
        this.lpe = new ArrayList();
        this.lpg = new a(this.lpe);
        this.eAA.setAdapter(this.lpg);
        this.fpk.setupWithViewPager(this.eAA);
        this.lpf.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.lpe) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.fpk.setSelectedTabIndicatorColor(ap.getColor(R.color.cp_indicator_b));
        this.fpk.setBackgroundDrawable(ap.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.cp_indicator_a)));
        ap.setBackgroundColor(this.lpf, R.color.cp_bg_line_c);
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
        this.lpe.clear();
        this.lpd = kVar.getData();
        this.lph = new PersonCenterSmartAppPageView(getContext());
        this.lpe.add(this.lph);
        int min = Math.min(7, this.lpd.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.lpd, i));
        }
        if (this.lpd.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.lpe.size() <= 1) {
            this.fpk.setVisibility(8);
        } else {
            this.fpk.setVisibility(0);
        }
        this.lpg.eS(this.lpe);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.lph.dkr()) {
            this.lph.c(cVar);
            return;
        }
        this.lph = new PersonCenterSmartAppPageView(getContext());
        this.lpe.add(this.lph);
        this.lph.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> fpg;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.fpg = list;
        }

        public void eS(List<PersonCenterSmartAppPageView> list) {
            this.fpg = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.fpg.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.fpg.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.fpg.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
