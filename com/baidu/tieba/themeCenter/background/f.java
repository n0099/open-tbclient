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
/* loaded from: classes9.dex */
public class f {
    private BdListView WV;
    private int aht;
    private View jVC;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private TextView nAT;
    private BackgroundListActivity nBL;
    private e nBS;
    private MemberRecommendView nBx;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.mPullView = null;
        this.aht = 0;
        this.nBL = backgroundListActivity;
        this.aht = l.getDimens(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nBL.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.nBL.setContentView(this.mRoot);
        this.jVC = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.personal_background_all);
        this.nBx = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nBx.setFromType(5);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.nBL.getPageContext());
        this.WV.setPullRefresh(this.mPullView);
        this.nAT = new TextView(this.nBL.getActivity());
        this.nAT.setHeight(l.getDimens(this.nBL.getActivity(), R.dimen.ds104));
        this.nBS = new e(this.nBL.getPageContext(), dVar);
        this.WV.setAdapter((ListAdapter) this.nBS);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WV.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cDo();
            return;
        }
        cDp();
        if (b(eVar)) {
            this.WV.removeHeaderView(this.nAT);
            this.WV.addHeaderView(this.nAT);
        } else {
            this.WV.removeHeaderView(this.nAT);
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
            this.WV.setVisibility(8);
            return;
        }
        this.WV.setVisibility(0);
        this.nBS.setData(list);
        this.nBS.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dSV())) {
            this.nBx.setVisibility(8);
            return false;
        }
        this.nBx.setVisibility(0);
        this.nBx.a(eVar);
        return true;
    }

    public void cDo() {
        this.jVC.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nBL.getPageContext().getResources().getString(R.string.no_data_text);
        this.nBL.setNetRefreshViewTopMargin(this.aht);
        this.nBL.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nBL.hideNetRefreshView(this.mRoot);
        this.jVC.setVisibility(0);
    }

    public void bUP() {
        this.WV.completePullRefreshPostDelayed(0L);
    }

    public void bCP() {
        com.baidu.tbadk.r.a.a(this.nBL.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nBL.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WV != null && this.WV.getVisibility() == 0 && this.nBS != null) {
            this.nBS.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
        ao.setBackgroundColor(this.nAT, R.color.CAM_X0204);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
