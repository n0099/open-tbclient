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
    private MemberRecommendView nwT;
    private TextView nwp;
    private b nyA;
    private PersonalCardItemView.a nyl;
    private int nyy = 3;
    private PersonalCardCategoryActivity nyz;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.agC = 0;
        this.nyz = personalCardCategoryActivity;
        this.agC = l.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nyz.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.nyz.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card);
        this.fJE = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.nwT = (MemberRecommendView) this.mRoot.findViewById(R.id.categary_card_recommend);
        this.nwT.setFromType(9);
        this.nwp = new TextView(this.nyz.getActivity());
        this.nwp.setHeight(l.getDimens(this.nyz.getActivity(), R.dimen.ds104));
        this.WT = (BdListView) this.mRoot.findViewById(R.id.categary_card_listview);
        this.nyA = new b(this.nyz.getPageContext());
        this.WT.setAdapter((ListAdapter) this.nyA);
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
                this.WT.removeHeaderView(this.nwp);
                this.WT.addHeaderView(this.nwp);
            } else {
                this.WT.removeHeaderView(this.nwp);
            }
            fV(list);
        }
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwT.setVisibility(8);
            return false;
        }
        this.nwT.setVisibility(0);
        this.nwT.a(eVar);
        return true;
    }

    private void fV(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nyA.setData(fW(list));
        this.nyA.notifyDataSetChanged();
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
                    for (int i3 = 0; i3 < this.nyy; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(dOX.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = (this.nyy - 1) + i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public void czw() {
        this.jQX.setVisibility(8);
        String string = this.nyz.getPageContext().getResources().getString(R.string.no_data_text);
        this.nyz.setNetRefreshViewTopMargin(this.agC);
        this.nyz.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        this.nyz.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void onChangeSkinType() {
        this.nyz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nyz.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nyz.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fJE != null) {
            this.fJE.onChangeSkinType(this.nyz.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nyA != null) {
            this.nyA.notifyDataSetChanged();
        }
        if (this.nwT != null && this.nwT.getVisibility() == 0) {
            this.nwT.btV();
        }
        ao.setBackgroundColor(this.nwp, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nyl = aVar;
        if (this.nyA != null) {
            this.nyA.setCardViewController(aVar);
        }
    }
}
