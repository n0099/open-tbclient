package com.baidu.tieba.themeCenter.background;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class f {
    private BdListView WO;
    private View jYN;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private TextView nGz;
    private MemberRecommendView nHd;
    private BackgroundListActivity nHr;
    private e nHy;
    private int topMargin;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.nHr = backgroundListActivity;
        this.topMargin = l.getDimens(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nHr.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.nHr.setContentView(this.mRoot);
        this.jYN = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background_all);
        this.nHd = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nHd.setFromType(5);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.nHr.getPageContext());
        this.WO.setPullRefresh(this.mPullView);
        this.nGz = new TextView(this.nHr.getActivity());
        this.nGz.setHeight(l.getDimens(this.nHr.getActivity(), R.dimen.ds104));
        this.nHy = new e(this.nHr.getPageContext(), dVar);
        this.WO.setAdapter((ListAdapter) this.nHy);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WO.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cAO();
            return;
        }
        cAP();
        if (b(eVar)) {
            this.WO.removeHeaderView(this.nGz);
            this.WO.addHeaderView(this.nGz);
        } else {
            this.WO.removeHeaderView(this.nGz);
        }
        fT(fU(list));
    }

    private List<List<DressItemData>> fU(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i = i + 2 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 3; i2++) {
                if (i + i2 < size) {
                    arrayList2.add(list.get(i + i2));
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private void fT(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.WO.setVisibility(8);
            return;
        }
        this.WO.setVisibility(0);
        this.nHy.setData(list);
        this.nHy.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRw())) {
            this.nHd.setVisibility(8);
            return false;
        }
        this.nHd.setVisibility(0);
        this.nHd.a(eVar);
        return true;
    }

    public void cAO() {
        this.jYN.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nHr.getPageContext().getResources().getString(R.string.no_data_text);
        this.nHr.setNetRefreshViewTopMargin(this.topMargin);
        this.nHr.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAP() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nHr.hideNetRefreshView(this.mRoot);
        this.jYN.setVisibility(0);
    }

    public void bRI() {
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nHr.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nHr.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nHy != null) {
            this.nHy.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
        ap.setBackgroundColor(this.nGz, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
