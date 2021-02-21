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
    private BdBaseViewPager foQ;
    private TbTabLayout geW;
    private List<com.baidu.tieba.personCenter.c.c> mvd;
    private List<PersonCenterSmartAppPageView> mve;
    private View mvf;
    private a mvg;
    private PersonCenterSmartAppPageView mvh;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.foQ = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.geW = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.mvf = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.geW.setTabMode(1);
        this.mve = new ArrayList();
        this.mvg = new a(this.mve);
        this.foQ.setAdapter(this.mvg);
        this.geW.setupWithViewPager(this.foQ);
        this.mvf.setVisibility(8);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.mve) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
        this.geW.setSelectedTabIndicatorColor(ap.getColor(R.color.CAM_X0629));
        this.geW.setBackgroundDrawable(ap.aL(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), ap.getColor(R.color.CAM_X0625)));
        ap.setBackgroundColor(this.mvf, R.color.CAM_X0204);
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
        this.mve.clear();
        this.mvd = kVar.getData();
        this.mvh = new PersonCenterSmartAppPageView(getContext());
        this.mve.add(this.mvh);
        int min = Math.min(7, this.mvd.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.c.c) y.getItem(this.mvd, i));
        }
        if (this.mvd.isEmpty()) {
            setVisibility(8);
        } else {
            a(new com.baidu.tieba.personCenter.c.l());
        }
        if (this.mve.size() <= 1) {
            this.geW.setVisibility(8);
        } else {
            this.geW.setVisibility(0);
        }
        this.mvg.fw(this.mve);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.c.c cVar) {
        if (this.mvh.dwR()) {
            this.mvh.c(cVar);
            return;
        }
        this.mvh = new PersonCenterSmartAppPageView(getContext());
        this.mve.add(this.mvh);
        this.mvh.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> geS;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.geS = list;
        }

        public void fw(List<PersonCenterSmartAppPageView> list) {
            this.geS = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.geS.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.geS.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.geS.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
