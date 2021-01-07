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
/* loaded from: classes9.dex */
public class b {
    private BdListView WV;
    private int aht;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRoot;
    private MemberRecommendView nBx;
    private BubbleListActivity nCH;
    private a nCM;

    public b(BubbleListActivity bubbleListActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mPullView = null;
        this.aht = 0;
        this.nCH = bubbleListActivity;
        this.aht = l.getDimens(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        this.mRoot = LayoutInflater.from(this.nCH.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.nCH.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.bubble_all);
        this.nBx = (MemberRecommendView) this.mRoot.findViewById(R.id.view_member_recommend);
        this.nBx.setFromType(7);
        this.WV = (BdListView) this.mRoot.findViewById(R.id.listview_bubble);
        this.mPullView = new g(this.nCH.getPageContext());
        this.WV.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.nCH.getActivity());
        textView.setHeight(l.getDimens(this.nCH.getActivity(), R.dimen.ds20));
        this.WV.addFooterView(textView);
        this.nCM = new a(this.nCH.getPageContext(), aVar);
        this.WV.setAdapter((ListAdapter) this.nCM);
    }

    public void a(BdListView.e eVar, f.c cVar) {
        this.WV.setOnSrollToBottomListener(eVar);
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(e eVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            cDo();
            return;
        }
        cDp();
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
            this.WV.setVisibility(8);
            return;
        }
        this.WV.setVisibility(0);
        this.nCM.setData(list);
        this.nCM.notifyDataSetChanged();
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

    public void cDo() {
        this.nBx.setVisibility(8);
        this.WV.setVisibility(8);
        this.mRoot.setVisibility(8);
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0201);
        String string = this.nCH.getPageContext().getResources().getString(R.string.no_data_text);
        this.nCH.setNetRefreshViewTopMargin(this.aht);
        this.nCH.showNetRefreshView(this.mRoot, string, false);
    }

    public void cDp() {
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
        this.nCH.hideNetRefreshView(this.mRoot);
        this.nBx.setVisibility(0);
        this.WV.setVisibility(0);
        this.mRoot.setVisibility(0);
    }

    public void bUP() {
        this.WV.completePullRefreshPostDelayed(0L);
    }

    public void bCP() {
        com.baidu.tbadk.r.a.a(this.nCH.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.nCH.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.WV != null && this.WV.getVisibility() == 0 && this.nCM != null) {
            this.nCM.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
