package com.baidu.tieba.memberCenter.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.d<MemberPrivilegeActivity> {
    private BdListView WT;
    private NoNetworkView gxx;
    private MemberPrivilegeActivity ljD;
    private c ljE;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.ljD = memberPrivilegeActivity;
        initView();
    }

    private void initView() {
        this.ljD.setContentView(R.layout.memberprivilege_activity);
        this.mRootView = this.ljD.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText(R.string.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.nonetworkview);
        this.gxx.a(new NoNetworkView.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z) {
                    d.this.ljD.ddK();
                }
            }
        });
        this.WT = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.ljE = new c(this.ljD);
        this.WT.setAdapter((ListAdapter) this.ljE);
        this.WT.setOnItemClickListener(this.ljD);
    }

    public c ddL() {
        return this.ljE;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.ljD.getLayoutMode().setNightMode(i == 1);
        this.ljD.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ljD.getPageContext(), i);
        this.gxx.onChangeSkinType(this.ljD.getPageContext(), i);
    }
}
