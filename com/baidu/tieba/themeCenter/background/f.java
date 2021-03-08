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
/* loaded from: classes8.dex */
public class f {
    private BdListView Yj;
    private View kaP;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private TextView nIF;
    private e nJE;
    private MemberRecommendView nJj;
    private BackgroundListActivity nJx;
    private int topMargin;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.nJx = backgroundListActivity;
        this.topMargin = l.getDimens(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nJx.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.nJx.setContentView(this.mRoot);
        this.kaP = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background_all);
        this.nJj = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nJj.setFromType(5);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.nJx.getPageContext());
        this.Yj.setPullRefresh(this.mPullView);
        this.nIF = new TextView(this.nJx.getActivity());
        this.nIF.setHeight(l.getDimens(this.nJx.getActivity(), R.dimen.ds104));
        this.nJE = new e(this.nJx.getPageContext(), dVar);
        this.Yj.setAdapter((ListAdapter) this.nJE);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.Yj.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cAU();
            return;
        }
        cAV();
        if (b(eVar)) {
            this.Yj.removeHeaderView(this.nIF);
            this.Yj.addHeaderView(this.nIF);
        } else {
            this.Yj.removeHeaderView(this.nIF);
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
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setVisibility(0);
        this.nJE.setData(list);
        this.nJE.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dRF())) {
            this.nJj.setVisibility(8);
            return false;
        }
        this.nJj.setVisibility(0);
        this.nJj.a(eVar);
        return true;
    }

    public void cAU() {
        this.kaP.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nJx.getPageContext().getResources().getString(R.string.no_data_text);
        this.nJx.setNetRefreshViewTopMargin(this.topMargin);
        this.nJx.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nJx.hideNetRefreshView(this.mRoot);
        this.kaP.setVisibility(0);
    }

    public void bRO() {
        this.Yj.completePullRefreshPostDelayed(0L);
    }

    public void bzq() {
        com.baidu.tbadk.r.a.a(this.nJx.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nJx.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.Yj != null && this.Yj.getVisibility() == 0 && this.nJE != null) {
            this.nJE.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
        ap.setBackgroundColor(this.nIF, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
