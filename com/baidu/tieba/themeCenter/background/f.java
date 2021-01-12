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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class f {
    private BdListView WT;
    private int agC;
    private View jQX;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private MemberRecommendView nwS;
    private TextView nwo;
    private BackgroundListActivity nxg;
    private e nxn;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.mPullView = null;
        this.agC = 0;
        this.nxg = backgroundListActivity;
        this.agC = l.getDimens(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nxg.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.nxg.setContentView(this.mRoot);
        this.jQX = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background_all);
        this.nwS = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nwS.setFromType(5);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.nxg.getPageContext());
        this.WT.setPullRefresh(this.mPullView);
        this.nwo = new TextView(this.nxg.getActivity());
        this.nwo.setHeight(l.getDimens(this.nxg.getActivity(), R.dimen.ds104));
        this.nxn = new e(this.nxg.getPageContext(), dVar);
        this.WT.setAdapter((ListAdapter) this.nxn);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WT.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            czw();
            return;
        }
        czx();
        if (b(eVar)) {
            this.WT.removeHeaderView(this.nwo);
            this.WT.addHeaderView(this.nwo);
        } else {
            this.WT.removeHeaderView(this.nwo);
        }
        fV(fW(list));
    }

    private List<List<DressItemData>> fW(List<DressItemData> list) {
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

    private void fV(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nxn.setData(list);
        this.nxn.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwS.setVisibility(8);
            return false;
        }
        this.nwS.setVisibility(0);
        this.nwS.a(eVar);
        return true;
    }

    public void czw() {
        this.jQX.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nxg.getPageContext().getResources().getString(R.string.no_data_text);
        this.nxg.setNetRefreshViewTopMargin(this.agC);
        this.nxg.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nxg.hideNetRefreshView(this.mRoot);
        this.jQX.setVisibility(0);
    }

    public void bQX() {
        this.WT.completePullRefreshPostDelayed(0L);
    }

    public void byV() {
        com.baidu.tbadk.r.a.a(this.nxg.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nxg.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nxn != null) {
            this.nxn.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
        ao.setBackgroundColor(this.nwo, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
