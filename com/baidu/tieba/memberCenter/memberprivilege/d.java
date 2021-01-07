package com.baidu.tieba.memberCenter.memberprivilege;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.d<MemberPrivilegeActivity> {
    private BdListView WV;
    private NoNetworkView gCe;
    private MemberPrivilegeActivity lol;
    private c lom;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(MemberPrivilegeActivity memberPrivilegeActivity) {
        super(memberPrivilegeActivity.getPageContext());
        this.lol = memberPrivilegeActivity;
        initView();
    }

    private void initView() {
        this.lol.setContentView(R.layout.memberprivilege_activity);
        this.mRootView = this.lol.findViewById(R.id.root);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.navigationbar);
        this.mNavigationBar.setTitleText(R.string.member_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.nonetworkview);
        this.gCe.a(new NoNetworkView.a() { // from class: com.baidu.tieba.memberCenter.memberprivilege.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z) {
                    d.this.lol.dhC();
                }
            }
        });
        this.WV = (BdListView) this.mRootView.findViewById(R.id.listview);
        this.lom = new c(this.lol);
        this.WV.setAdapter((ListAdapter) this.lom);
        this.WV.setOnItemClickListener(this.lol);
    }

    public c dhD() {
        return this.lom;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.lol.getLayoutMode().setNightMode(i == 1);
        this.lol.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.lol.getPageContext(), i);
        this.gCe.onChangeSkinType(this.lol.getPageContext(), i);
    }
}
