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
    private View jYz;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private TextView nFZ;
    private MemberRecommendView nGD;
    private BackgroundListActivity nGR;
    private e nGY;
    private int topMargin;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.nGR = backgroundListActivity;
        this.topMargin = l.getDimens(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nGR.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.nGR.setContentView(this.mRoot);
        this.jYz = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background_all);
        this.nGD = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nGD.setFromType(5);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.nGR.getPageContext());
        this.WO.setPullRefresh(this.mPullView);
        this.nFZ = new TextView(this.nGR.getActivity());
        this.nFZ.setHeight(l.getDimens(this.nGR.getActivity(), R.dimen.ds104));
        this.nGY = new e(this.nGR.getPageContext(), dVar);
        this.WO.setAdapter((ListAdapter) this.nGY);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WO.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cAH();
            return;
        }
        cAI();
        if (b(eVar)) {
            this.WO.removeHeaderView(this.nFZ);
            this.WO.addHeaderView(this.nFZ);
        } else {
            this.WO.removeHeaderView(this.nFZ);
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
        this.nGY.setData(list);
        this.nGY.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRo())) {
            this.nGD.setVisibility(8);
            return false;
        }
        this.nGD.setVisibility(0);
        this.nGD.a(eVar);
        return true;
    }

    public void cAH() {
        this.jYz.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nGR.getPageContext().getResources().getString(R.string.no_data_text);
        this.nGR.setNetRefreshViewTopMargin(this.topMargin);
        this.nGR.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAI() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nGR.hideNetRefreshView(this.mRoot);
        this.jYz.setVisibility(0);
    }

    public void bRB() {
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nGR.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nGR.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nGY != null) {
            this.nGY.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
        ap.setBackgroundColor(this.nFZ, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
