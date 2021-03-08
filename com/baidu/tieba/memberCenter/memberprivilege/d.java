package com.baidu.tieba.memberCenter.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.d<MemberPrivilegeActivity> {
    private BdListView Yj;
    private NoNetworkView gCe;
    private MemberPrivilegeActivity lua;
    private c lub;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.lua = memberPrivilegeActivity;
        initView();
    }

    private void initView() {
        this.lua.setContentView(R.layout.memberprivilege_activity);
        this.mRootView = this.lua.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText(R.string.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.nonetworkview);
        this.gCe.a(new NoNetworkView.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z) {
                    d.this.lua.dga();
                }
            }
        });
        this.Yj = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.lub = new c(this.lua);
        this.Yj.setAdapter((ListAdapter) this.lub);
        this.Yj.setOnItemClickListener(this.lua);
    }

    public c dgb() {
        return this.lub;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.lua.getLayoutMode().setNightMode(i == 1);
        this.lua.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lua.getPageContext(), i);
        this.gCe.onChangeSkinType(this.lua.getPageContext(), i);
    }
}
