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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes8.dex */
public class b {
    private BdListView WT;
    private int agC;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRoot;
    private MemberRecommendView nwS;
    private BubbleListActivity nyc;
    private a nyh;

    public b(BubbleListActivity bubbleListActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mPullView = null;
        this.agC = 0;
        this.nyc = bubbleListActivity;
        this.agC = l.getDimens(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nyc.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.nyc.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.bubble_all);
        this.nwS = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nwS.setFromType(7);
        this.WT = (BdListView) this.mRoot.findViewById(R.id.listview_bubble);
        this.mPullView = new g(this.nyc.getPageContext());
        this.WT.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.nyc.getActivity());
        textView.setHeight(l.getDimens(this.nyc.getActivity(), R.dimen.ds20));
        this.WT.addFooterView(textView);
        this.nyh = new a(this.nyc.getPageContext(), aVar);
        this.WT.setAdapter((ListAdapter) this.nyh);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WT.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            czw();
            return;
        }
        czx();
        b(eVar);
        fV(fW(list));
    }

    private List<List<DressItemData>> fW(List<DressItemData> list) {
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

    private void fV(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.WT.setVisibility(8);
            return;
        }
        this.WT.setVisibility(0);
        this.nyh.setData(list);
        this.nyh.notifyDataSetChanged();
    }

    private boolean b(e eVar) {
        if (eVar == null || StringUtils.isNull(eVar.dPd())) {
            this.nwS.setVisibility(8);
            return false;
        }
        this.nwS.setVisibility(0);
        this.nwS.a(eVar);
        return true;
    }

    public void czw() {
        this.nwS.setVisibility(8);
        this.WT.setVisibility(8);
        this.mRoot.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nyc.getPageContext().getResources().getString(R.string.no_data_text);
        this.nyc.setNetRefreshViewTopMargin(this.agC);
        this.nyc.showNetRefreshView(this.mRoot, string, false);
    }

    public void czx() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nyc.hideNetRefreshView(this.mRoot);
        this.nwS.setVisibility(0);
        this.WT.setVisibility(0);
        this.mRoot.setVisibility(0);
    }

    public void bQX() {
        this.WT.completePullRefreshPostDelayed(0L);
    }

    public void byV() {
        com.baidu.tbadk.r.a.a(this.nyc.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nyc.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WT != null && this.WT.getVisibility() == 0 && this.nyh != null) {
            this.nyh.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
