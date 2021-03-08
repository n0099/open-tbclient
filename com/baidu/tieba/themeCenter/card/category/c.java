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
/* loaded from: classes8.dex */
public class c {
    private BdListView Yj;
    private NoNetworkView fNp;
    private View kaP;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nIF;
    private MemberRecommendView nJj;
    private PersonalCardItemView.a nKB;
    private int nKO = 3;
    private PersonalCardCategoryActivity nKP;
    private b nKQ;
    private int topMargin;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.topMargin = 0;
        this.nKP = personalCardCategoryActivity;
        this.topMargin = l.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nKP.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.nKP.setContentView(this.mRoot);
        this.kaP = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card);
        this.fNp = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.nJj = (MemberRecommendView) this.mRoot.findViewById(R.id.categary_card_recommend);
        this.nJj.setFromType(9);
        this.nIF = new TextView(this.nKP.getActivity());
        this.nIF.setHeight(l.getDimens(this.nKP.getActivity(), R.dimen.ds104));
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.categary_card_listview);
        this.nKQ = new b(this.nKP.getPageContext());
        this.Yj.setAdapter((ListAdapter) this.nKQ);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Yj.setOnSrollToBottomListener(eVar);
    }

    public void a(int i, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.dRF())) && (list == null || list.size() <= 0)) {
            cAU();
        } else if (i == 0) {
            cAV();
            if (b(eVar)) {
                this.Yj.removeHeaderView(this.nIF);
                this.Yj.addHeaderView(this.nIF);
            } else {
                this.Yj.removeHeaderView(this.nIF);
            }
            fT(list);
        }
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRF())) {
            this.nJj.setVisibility(8);
            return false;
        }
        this.nJj.setVisibility(0);
        this.nJj.a(eVar);
        return true;
    }

    private void fT(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setVisibility(0);
        this.nKQ.setData(fU(list));
        this.nKQ.notifyDataSetChanged();
    }

    private List<Object> fU(List<a> list) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<com.baidu.tieba.themeCenter.a> dRz = aVar.dRz();
            if (dRz != null && (size = dRz.size()) != 0) {
                arrayList.add(aVar.getCategoryName());
                int i = size > 6 ? 6 : size;
                int i2 = 0;
                while (i2 < i) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < this.nKO; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(dRz.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = (this.nKO - 1) + i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public void cAU() {
        this.kaP.setVisibility(8);
        String string = this.nKP.getPageContext().getResources().getString(R.string.no_data_text);
        this.nKP.setNetRefreshViewTopMargin(this.topMargin);
        this.nKP.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        this.nKP.hideNetRefreshView(this.mRoot);
        this.kaP.setVisibility(0);
    }

    public void onChangeSkinType() {
        this.nKP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nKP.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nKP.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fNp != null) {
            this.fNp.onChangeSkinType(this.nKP.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.Yj != null && this.Yj.getVisibility() == 0 && this.nKQ != null) {
            this.nKQ.notifyDataSetChanged();
        }
        if (this.nJj != null && this.nJj.getVisibility() == 0) {
            this.nJj.bus();
        }
        ap.setBackgroundColor(this.nIF, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nKB = aVar;
        if (this.nKQ != null) {
            this.nKQ.setCardViewController(aVar);
        }
    }
}
