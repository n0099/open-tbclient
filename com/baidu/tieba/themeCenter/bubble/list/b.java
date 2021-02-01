package com.baidu.tieba.themeCenter.bubble.list;

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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class b {
    private BdListView WO;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRoot;
    private MemberRecommendView nGD;
    private BubbleListActivity nHN;
    private a nHS;
    private int topMargin;

    public b(BubbleListActivity bubbleListActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.nHN = bubbleListActivity;
        this.topMargin = l.getDimens(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nHN.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.nHN.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.bubble_all);
        this.nGD = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nGD.setFromType(7);
        this.WO = (BdListView) this.mRoot.findViewById(R.id.listview_bubble);
        this.mPullView = new g(this.nHN.getPageContext());
        this.WO.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.nHN.getActivity());
        textView.setHeight(l.getDimens(this.nHN.getActivity(), R.dimen.ds20));
        this.WO.addFooterView(textView);
        this.nHS = new a(this.nHN.getPageContext(), aVar);
        this.WO.setAdapter((ListAdapter) this.nHS);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WO.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cAH();
            return;
        }
        cAI();
        b(eVar);
        fT(fU(list));
    }

    private List<List<DressItemData>> fU(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i = i + 1 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
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
        this.nHS.setData(list);
        this.nHS.notifyDataSetChanged();
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

    public void cAH() {
        this.nGD.setVisibility(8);
        this.WO.setVisibility(8);
        this.mRoot.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nHN.getPageContext().getResources().getString(R.string.no_data_text);
        this.nHN.setNetRefreshViewTopMargin(this.topMargin);
        this.nHN.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAI() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nHN.hideNetRefreshView(this.mRoot);
        this.nGD.setVisibility(0);
        this.WO.setVisibility(0);
        this.mRoot.setVisibility(0);
    }

    public void bRB() {
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.nHN.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nHN.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WO != null && this.WO.getVisibility() == 0 && this.nHS != null) {
            this.nHS.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
