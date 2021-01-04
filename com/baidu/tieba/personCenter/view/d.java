package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager fri;
    private TbTabLayout ghk;
    private List<com.baidu.tieba.personCenter.c.c> mqt;
    private List<PersonCenterSmartAppPageView> mqu;
    private View mqv;
    private a mqw;
    private PersonCenterSmartAppPageView mqx;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fri = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.ghk = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.mqv = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.ghk.setTabMode(1);
        this.mqu = new ArrayList();
        this.mqw = new a(this.mqu);
        this.fri.setAdapter(this.mqw);
        this.ghk.setupWithViewPager(this.fri);
        this.mqv.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.mqu) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.ghk.setSelectedTabIndicatorColor(ao.getColor(R.color.CAM_X0629));
        this.ghk.setBackgroundDrawable(ao.aO(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ao.getColor(R.color.CAM_X0625)));
        ao.setBackgroundColor(this.mqv, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_smart_app_banner_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(k kVar) {
        if (kVar == null || kVar.getData() == null || x.isEmpty(kVar.getData())) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mqu.clear();
        this.mqt = kVar.getData();
        this.mqx = new PersonCenterSmartAppPageView(getContext());
        this.mqu.add(this.mqx);
        int min = Math.min(7, this.mqt.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) x.getItem(this.mqt, i));
        }
        if (this.mqt.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.mqu.size() <= 1) {
            this.ghk.setVisibility(8);
        } else {
            this.ghk.setVisibility(0);
        }
        this.mqw.fy(this.mqu);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.mqx.dys()) {
            this.mqx.c(cVar);
            return;
        }
        this.mqx = new PersonCenterSmartAppPageView(getContext());
        this.mqu.add(this.mqx);
        this.mqx.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> ghg;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.ghg = list;
        }

        public void fy(List<PersonCenterSmartAppPageView> list) {
            this.ghg = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.ghg.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.ghg.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.ghg.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
