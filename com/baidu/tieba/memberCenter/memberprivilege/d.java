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
    private NoNetworkView gAh;
    private MemberPrivilegeActivity lrJ;
    private c lrK;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.lrJ = memberPrivilegeActivity;
        initView();
    }

    private void initView() {
        this.lrJ.setContentView(R.layout.memberprivilege_activity);
        this.mRootView = this.lrJ.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText(R.string.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.nonetworkview);
        this.gAh.a(new NoNetworkView.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z) {
                    d.this.lrJ.dfK();
                }
            }
        });
        this.WO = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.lrK = new c(this.lrJ);
        this.WO.setAdapter((ListAdapter) this.lrK);
        this.WO.setOnItemClickListener(this.lrJ);
    }

    public c dfL() {
        return this.lrK;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.lrJ.getLayoutMode().setNightMode(i == 1);
        this.lrJ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lrJ.getPageContext(), i);
        this.gAh.onChangeSkinType(this.lrJ.getPageContext(), i);
    }
}
