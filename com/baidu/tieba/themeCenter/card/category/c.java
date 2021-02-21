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
    private View jYN;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private TextView nGz;
    private MemberRecommendView nHd;
    private int nII = 3;
    private PersonalCardCategoryActivity nIJ;
    private b nIK;
    private PersonalCardItemView.a nIv;
    private int topMargin;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.topMargin = 0;
        this.nIJ = personalCardCategoryActivity;
        this.topMargin = l.getDimens(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nIJ.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.nIJ.setContentView(this.mRoot);
        this.jYN = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_card);
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.nHd = (MemberRecommendView) this.mRoot.findViewById(R.id.categary_card_recommend);
        this.nHd.setFromType(9);
        this.nGz = new TextView(this.nIJ.getActivity());
        this.nGz.setHeight(l.getDimens(this.nIJ.getActivity(), R.dimen.ds104));
        this.WO = (BdListView) this.mRoot.findViewById(R.id.categary_card_listview);
        this.nIK = new b(this.nIJ.getPageContext());
        this.WO.setAdapter((ListAdapter) this.nIK);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WO.setOnSrollToBottomListener(eVar);
    }

    public void a(int i, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.dRw())) && (list == null || list.size() <= 0)) {
            cAO();
        } else if (i == 0) {
            cAP();
            if (b(eVar)) {
                this.WO.removeHeaderView(this.nGz);
                this.WO.addHeaderView(this.nGz);
            } else {
                this.WO.removeHeaderView(this.nGz);
            }
            fT(list);
        }
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRw())) {
            this.nHd.setVisibility(8);
            return false;
        }
        this.nHd.setVisibility(0);
        this.nHd.a(eVar);
        return true;
    }

    private void fT(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nIK.setData(fU(list));
        this.nIK.notifyDataSetChanged();
    }

    private List<Object> fU(List<a> list) {
        int size;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<com.baidu.tieba.themeCenter.a> dRq = aVar.dRq();
            if (dRq != null && (size = dRq.size()) != 0) {
                arrayList.add(aVar.getCategoryName());
                int i = size > 6 ? 6 : size;
                int i2 = 0;
                while (i2 < i) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < this.nII; i3++) {
                        if (i2 + i3 < i) {
                            arrayList2.add(dRq.get(i2 + i3));
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = (this.nII - 1) + i2 + 1;
                }
            }
        }
        return arrayList;
    }

    public void cAO() {
        this.jYN.setVisibility(8);
        String string = this.nIJ.getPageContext().getResources().getString(R.string.no_data_text);
        this.nIJ.setNetRefreshViewTopMargin(this.topMargin);
        this.nIJ.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        this.nIJ.hideNetRefreshView(this.mRoot);
        this.jYN.setVisibility(0);
    }

    public void onChangeSkinType() {
        this.nIJ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.nIJ.getLayoutMode().onModeChanged(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nIJ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.fLP != null) {
            this.fLP.onChangeSkinType(this.nIJ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nIK != null) {
            this.nIK.notifyDataSetChanged();
        }
        if (this.nHd != null && this.nHd.getVisibility() == 0) {
            this.nHd.bup();
        }
        ap.setBackgroundColor(this.nGz, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void setCardViewController(PersonalCardItemView.a aVar) {
        this.nIv = aVar;
        if (this.nIK != null) {
            this.nIK.setCardViewController(aVar);
        }
    }
}
