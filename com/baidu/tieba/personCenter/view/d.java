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
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<j> {
    private BdBaseViewPager ctf;
    private TbTabLayout fTF;
    private List<com.baidu.tieba.personCenter.data.c> imK;
    private List<PersonCenterSmartAppPageView> imL;
    private View imM;
    private a imN;
    private PersonCenterSmartAppPageView imO;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.ctf = (BdBaseViewPager) view.findViewById(R.id.vp_person_center_smart_app_banner);
        this.fTF = (TbTabLayout) view.findViewById(R.id.tl_person_center_smart_app_banner);
        this.imM = view.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.fTF.setTabMode(1);
        this.imL = new ArrayList();
        this.imN = new a(this.imL);
        this.ctf.setAdapter(this.imN);
        this.fTF.setupWithViewPager(this.ctf);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.imL) {
            if (personCenterSmartAppPageView != null) {
                personCenterSmartAppPageView.onChangeSkinType();
            }
        }
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
        this.fTF.setSelectedTabIndicatorColor(am.getColor(R.color.cp_indicator_b));
        this.fTF.setBackgroundDrawable(am.ab(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3), am.getColor(R.color.cp_indicator_a)));
        am.setBackgroundColor(this.imM, R.color.cp_bg_line_c);
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
        this.imL.clear();
        this.imK = jVar.getData();
        this.imO = new PersonCenterSmartAppPageView(getContext());
        this.imL.add(this.imO);
        int min = Math.min(7, this.imK.size());
        for (int i = 0; i < min; i++) {
            a((com.baidu.tieba.personCenter.data.c) v.getItem(this.imK, i));
        }
        if (this.imK.isEmpty()) {
            setVisibility(8);
        } else {
            a(new k());
        }
        if (this.imL.size() <= 1) {
            this.fTF.setVisibility(8);
        } else {
            this.fTF.setVisibility(0);
        }
        this.imN.ed(this.imL);
        onChangeSkinType(getTbPageContext(), this.mSkinType);
    }

    private void a(com.baidu.tieba.personCenter.data.c cVar) {
        if (this.imO.bZv()) {
            this.imO.c(cVar);
            return;
        }
        this.imO = new PersonCenterSmartAppPageView(getContext());
        this.imL.add(this.imO);
        this.imO.c(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends PagerAdapter {
        private List<PersonCenterSmartAppPageView> imP;

        public a(List<PersonCenterSmartAppPageView> list) {
            this.imP = list;
        }

        public void ed(List<PersonCenterSmartAppPageView> list) {
            this.imP = list;
            notifyDataSetChanged();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.imP.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PersonCenterSmartAppPageView personCenterSmartAppPageView = this.imP.get(i);
            viewGroup.addView(personCenterSmartAppPageView);
            return personCenterSmartAppPageView;
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            int indexOf = this.imP.indexOf(obj);
            if (indexOf == -1) {
                return -2;
            }
            return indexOf;
        }
    }
}
