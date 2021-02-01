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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private BdListView WO;
    private NoNetworkView fLP;
    private View jYz;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nFZ;
    private MemberRecommendView nGD;
    private PersonalCardItemView.a nHV;
    private int nIi = 3;
    private PersonalCardCategoryActivity nIj;
    private b nIk;
    private int topMargin;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.topMargin = 0;
        this.nIj = personalCardCategoryActivity;
        this.topMargin = l.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nIj.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.nIj.setContentView(this.mRoot);
        this.jYz = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card);
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.nGD = (MemberRecommendView) this.mRoot.findViewById(R.id.categary_card_recommend);
        this.nGD.setFromType(9);
        this.nFZ = new TextView(this.nIj.getActivity());
        this.nFZ.setHeight(l.getDimens(this.nIj.getActivity(), R.dimen.ds104));
        this.WO = (BdListView) this.mRoot.findViewById(R.id.categary_card_listview);
        this.nIk = new b(this.nIj.getPageContext());
        this.WO.setAdapter((ListAdapter) this.nIk);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WO.setOnSrollToBottomListener(eVar);
    }

    public void a(int i, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.dRo())) && (list == null || list.size() <= 0)) {
            cAH();
        } else if (i == 0) {
            cAI();
            if (b(eVar)) {
                this.WO.removeHeaderView(this.nFZ);
                this.WO.addHeaderView(this.nFZ);
            } else {
                this.WO.removeHeaderView(this.nFZ);
            }
            fT(list);
        }
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRo())) {
            this.nGD.setVisibility(8);
            return false;
        }
        this.nGD.setVisibility(0);
        this.nGD.a(eVar);
        return true;
    }

    private void fT(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nIk.setData(fU(list));
        this.nIk.notifyDataSetChanged();
    }

    private List<Object> fU(List<a> list) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<com.baidu.tieba.themeCenter.a> dRi = aVar.dRi();
            if (dRi != null && (size = dRi.size()) != 0) {
                arrayList.add(aVar.getCategoryName());
                int i = size > 6 ? 6 : size;
                int i2 = 0;
                while (i2 < i) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < this.nIi; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(dRi.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = (this.nIi - 1) + i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public void cAH() {
        this.jYz.setVisibility(8);
        String string = this.nIj.getPageContext().getResources().getString(R.string.no_data_text);
        this.nIj.setNetRefreshViewTopMargin(this.topMargin);
        this.nIj.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAI() {
        this.nIj.hideNetRefreshView(this.mRoot);
        this.jYz.setVisibility(0);
    }

    public void onChangeSkinType() {
        this.nIj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nIj.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nIj.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fLP != null) {
            this.fLP.onChangeSkinType(this.nIj.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nIk != null) {
            this.nIk.notifyDataSetChanged();
        }
        if (this.nGD != null && this.nGD.getVisibility() == 0) {
            this.nGD.bup();
        }
        ap.setBackgroundColor(this.nFZ, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nHV = aVar;
        if (this.nIk != null) {
            this.nIk.setCardViewController(aVar);
        }
    }
}
