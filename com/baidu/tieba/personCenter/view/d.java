package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
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
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<k> {
    private BdBaseViewPager fqq;
    private TbTabLayout ggz;
    private List<com.baidu.tieba.personCenter.c.c> mxf;
    private List<PersonCenterSmartAppPageView> mxg;
    private View mxh;
    private a mxi;
    private PersonCenterSmartAppPageView mxj;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.fqq = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.ggz = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.mxh = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.ggz.setTabMode(1);
        this.mxg = new ArrayList();
        this.mxi = new a(this.mxg);
        this.fqq.setAdapter(this.mxi);
        this.ggz.setupWithViewPager(this.fqq);
        this.mxh.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.mxg) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.ggz.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0629));
        this.ggz.setBackgroundDrawable(ap.aL(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.CAM_X0625)));
        ap.setBackgroundColor(this.mxh, R.color.CAM_X0204);
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
        this.mxg.clear();
        this.mxf = kVar.getData();
        this.mxj = new PersonCenterSmartAppPageView(getContext());
        this.mxg.add(this.mxj);
        int min = Math.min(7, this.mxf.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.mxf, i));
        }
        if (this.mxf.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.mxg.size() <= 1) {
            this.ggz.setVisibility(8);
        } else {
            this.ggz.setVisibility(0);
        }
        this.mxi.fw(this.mxg);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.mxj.dxa()) {
            this.mxj.c(cVar);
            return;
        }
        this.mxj = new PersonCenterSmartAppPageView(getContext());
        this.mxg.add(this.mxj);
        this.mxj.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> ggv;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.ggv = list;
        }

        public void fw(List<PersonCenterSmartAppPageView> list) {
            this.ggv = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.ggv.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.ggv.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.ggv.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
