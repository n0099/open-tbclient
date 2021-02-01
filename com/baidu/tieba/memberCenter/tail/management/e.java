package com.baidu.tieba.memberCenter.tail.management;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private BdListView WO;
    private NoNetworkView gAh;
    private TextView iXJ;
    private TextView lsT;
    private BaseActivity<?> mActivity;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mRoot = baseActivity.findViewById(R.id.tail_management_root);
        this.WO = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.iXJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mActivity.getString(R.string.cancel), onClickListener);
        this.lsT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.lsT.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iXJ.getLayoutParams();
        layoutParams.leftMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.iXJ.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lsT.getLayoutParams();
        layoutParams2.rightMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.lsT.setLayoutParams(layoutParams2);
        int dimens = l.getDimens(this.mActivity, R.dimen.tbds27);
        this.lsT.setPadding(dimens, 0, dimens, 0);
        this.gAh = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.WO.addFooterView(view);
        this.WO.addHeaderView(view2);
    }

    public void d(a aVar) {
        this.WO.setAdapter((ListAdapter) aVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRoot);
        this.gAh.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        ap.setViewTextColor(this.lsT, R.color.navbar_btn_color);
        ap.setViewTextColor(this.iXJ, R.color.navi_back_text_color);
        ap.setBackgroundResource(this.lsT, R.drawable.s_navbar_button_bg);
    }

    public TextView dgh() {
        return this.lsT;
    }

    public TextView dgi() {
        return this.iXJ;
    }

    public void an(boolean z, boolean z2) {
        if (z) {
            this.lsT.setText(this.mActivity.getPageContext().getString(R.string.done));
            return;
        }
        this.lsT.setText(this.mActivity.getPageContext().getString(R.string.edit));
        this.lsT.setEnabled(!z2);
    }
}
