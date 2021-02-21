package com.baidu.tieba.memberCenter.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.d<MemberPrivilegeActivity> {
    private BdListView WO;
    private NoNetworkView gAv;
    private MemberPrivilegeActivity lrX;
    private c lrY;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.lrX = memberPrivilegeActivity;
        initView();
    }

    private void initView() {
        this.lrX.setContentView(R.layout.memberprivilege_activity);
        this.mRootView = this.lrX.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText(R.string.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.nonetworkview);
        this.gAv.a(new NoNetworkView.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z) {
                    d.this.lrX.dfR();
                }
            }
        });
        this.WO = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.lrY = new c(this.lrX);
        this.WO.setAdapter((ListAdapter) this.lrY);
        this.WO.setOnItemClickListener(this.lrX);
    }

    public c dfS() {
        return this.lrY;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.lrX.getLayoutMode().setNightMode(i == 1);
        this.lrX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lrX.getPageContext(), i);
        this.gAv.onChangeSkinType(this.lrX.getPageContext(), i);
    }
}
