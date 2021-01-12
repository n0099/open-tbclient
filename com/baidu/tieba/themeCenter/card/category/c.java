package com.baidu.tieba.themeCenter.card.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private BdListView WT;
    private int agC;
    private NoNetworkView fJE;
    private View jQX;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private MemberRecommendView nwS;
    private TextView nwo;
    private PersonalCardItemView.a nyk;
    private int nyx = 3;
    private PersonalCardCategoryActivity nyy;
    private b nyz;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.agC = 0;
        this.nyy = personalCardCategoryActivity;
        this.agC = l.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nyy.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.nyy.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card);
        this.fJE = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.nwS = (MemberRecommendView) this.mRoot.findViewById(R.id.categary_card_recommend);
        this.nwS.setFromType(9);
        this.nwo = new TextView(this.nyy.getActivity());
        this.nwo.setHeight(l.getDimens(this.nyy.getActivity(), R.dimen.ds104));
        this.WT = (BdListView) this.mRoot.findViewById(R.id.categary_card_listview);
        this.nyz = new b(this.nyy.getPageContext());
        this.WT.setAdapter((ListAdapter) this.nyz);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WT.setOnSrollToBottomListener(eVar);
    }

    public void a(int i, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.dPd())) && (list == null || list.size() <= 0)) {
            czw();
        } else if (i == 0) {
            czx();
            if (b(eVar)) {
                this.WT.removeHeaderView(this.nwo);
                this.WT.addHeaderView(this.nwo);
            } else {
                this.WT.removeHeaderView(this.nwo);
            }
            fV(list);
        }
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwS.setVisibility(8);
            return false;
        }
        this.nwS.setVisibility(0);
        this.nwS.a(eVar);
        return true;
    }

    private void fV(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nyz.setData(fW(list));
        this.nyz.notifyDataSetChanged();
    }

    private List<Object> fW(List<a> list) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<com.baidu.tieba.themeCenter.a> dOX = aVar.dOX();
            if (dOX != null && (size = dOX.size()) != 0) {
                arrayList.add(aVar.getCategoryName());
                int i = size > 6 ? 6 : size;
                int i2 = 0;
                while (i2 < i) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < this.nyx; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(dOX.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = (this.nyx - 1) + i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public void czw() {
        this.jQX.setVisibility(8);
        String string = this.nyy.getPageContext().getResources().getString(R.string.no_data_text);
        this.nyy.setNetRefreshViewTopMargin(this.agC);
        this.nyy.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        this.nyy.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void onChangeSkinType() {
        this.nyy.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nyy.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nyy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fJE != null) {
            this.fJE.onChangeSkinType(this.nyy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nyz != null) {
            this.nyz.notifyDataSetChanged();
        }
        if (this.nwS != null && this.nwS.getVisibility() == 0) {
            this.nwS.btV();
        }
        ao.setBackgroundColor(this.nwo, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nyk = aVar;
        if (this.nyz != null) {
            this.nyz.setCardViewController(aVar);
        }
    }
}
