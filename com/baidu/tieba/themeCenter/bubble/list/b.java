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
/* loaded from: classes8.dex */
public class b {
    private BdListView Yj;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRoot;
    private MemberRecommendView nJj;
    private BubbleListActivity nKt;
    private a nKy;
    private int topMargin;

    public b(BubbleListActivity bubbleListActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.nKt = bubbleListActivity;
        this.topMargin = l.getDimens(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nKt.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.nKt.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.bubble_all);
        this.nJj = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nJj.setFromType(7);
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.listview_bubble);
        this.mPullView = new g(this.nKt.getPageContext());
        this.Yj.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.nKt.getActivity());
        textView.setHeight(l.getDimens(this.nKt.getActivity(), R.dimen.ds20));
        this.Yj.addFooterView(textView);
        this.nKy = new a(this.nKt.getPageContext(), aVar);
        this.Yj.setAdapter((ListAdapter) this.nKy);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.Yj.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cAU();
            return;
        }
        cAV();
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
            this.Yj.setVisibility(8);
            return;
        }
        this.Yj.setVisibility(0);
        this.nKy.setData(list);
        this.nKy.notifyDataSetChanged();
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

    public void cAU() {
        this.nJj.setVisibility(8);
        this.Yj.setVisibility(8);
        this.mRoot.setVisibility(8);
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nKt.getPageContext().getResources().getString(R.string.no_data_text);
        this.nKt.setNetRefreshViewTopMargin(this.topMargin);
        this.nKt.showNetRefreshView(this.mRoot, string, false);
    }

    public void cAV() {
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nKt.hideNetRefreshView(this.mRoot);
        this.nJj.setVisibility(0);
        this.Yj.setVisibility(0);
        this.mRoot.setVisibility(0);
    }

    public void bRO() {
        this.Yj.completePullRefreshPostDelayed(0L);
    }

    public void bzq() {
        com.baidu.tbadk.r.a.a(this.nKt.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nKt.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.Yj != null && this.Yj.getVisibility() == 0 && this.nKy != null) {
            this.nKy.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
