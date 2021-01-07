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
/* loaded from: classes9.dex */
public class c {
    private BdListView WV;
    private int aht;
    private NoNetworkView fOl;
    private View jVC;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nAT;
    private MemberRecommendView nBx;
    private PersonalCardItemView.a nCP;
    private int nDc = 3;
    private PersonalCardCategoryActivity nDd;
    private b nDe;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.aht = 0;
        this.nDd = personalCardCategoryActivity;
        this.aht = l.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nDd.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.nDd.setContentView(this.mRoot);
        this.jVC = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card);
        this.fOl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.nBx = (MemberRecommendView) this.mRoot.findViewById(R.id.categary_card_recommend);
        this.nBx.setFromType(9);
        this.nAT = new TextView(this.nDd.getActivity());
        this.nAT.setHeight(l.getDimens(this.nDd.getActivity(), R.dimen.ds104));
        this.WV = (BdListView) this.mRoot.findViewById(R.id.categary_card_listview);
        this.nDe = new b(this.nDd.getPageContext());
        this.WV.setAdapter((ListAdapter) this.nDe);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WV.setOnSrollToBottomListener(eVar);
    }

    public void a(int i, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.dSV())) && (list == null || list.size() <= 0)) {
            cDo();
        } else if (i == 0) {
            cDp();
            if (b(eVar)) {
                this.WV.removeHeaderView(this.nAT);
                this.WV.addHeaderView(this.nAT);
            } else {
                this.WV.removeHeaderView(this.nAT);
            }
            fV(list);
        }
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dSV())) {
            this.nBx.setVisibility(8);
            return false;
        }
        this.nBx.setVisibility(0);
        this.nBx.a(eVar);
        return true;
    }

    private void fV(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.WV.setVisibility(8);
            return;
        }
        this.WV.setVisibility(0);
        this.nDe.setData(fW(list));
        this.nDe.notifyDataSetChanged();
    }

    private List<Object> fW(List<a> list) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<com.baidu.tieba.themeCenter.a> dSP = aVar.dSP();
            if (dSP != null && (size = dSP.size()) != 0) {
                arrayList.add(aVar.getCategoryName());
                int i = size > 6 ? 6 : size;
                int i2 = 0;
                while (i2 < i) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < this.nDc; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(dSP.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = (this.nDc - 1) + i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public void cDo() {
        this.jVC.setVisibility(8);
        String string = this.nDd.getPageContext().getResources().getString(R.string.no_data_text);
        this.nDd.setNetRefreshViewTopMargin(this.aht);
        this.nDd.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        this.nDd.hideNetRefreshView(this.mRoot);
        this.jVC.setVisibility(0);
    }

    public void onChangeSkinType() {
        this.nDd.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nDd.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nDd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fOl != null) {
            this.fOl.onChangeSkinType(this.nDd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WV != null && this.WV.getVisibility() == 0 && this.nDe != null) {
            this.nDe.notifyDataSetChanged();
        }
        if (this.nBx != null && this.nBx.getVisibility() == 0) {
            this.nBx.bxP();
        }
        ao.setBackgroundColor(this.nAT, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nCP = aVar;
        if (this.nDe != null) {
            this.nDe.setCardViewController(aVar);
        }
    }
}
