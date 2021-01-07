package com.baidu.tieba.memberCenter.tail.management;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private BdListView WV;
    private NoNetworkView gCe;
    private TextView iWJ;
    private TextView lpx;
    private BaseActivity<?> mActivity;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mRoot = baseActivity.findViewById(R.id.tail_management_root);
        this.WV = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.iWJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mActivity.getString(R.string.cancel), onClickListener);
        this.lpx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.lpx.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iWJ.getLayoutParams();
        layoutParams.leftMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.iWJ.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lpx.getLayoutParams();
        layoutParams2.rightMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.lpx.setLayoutParams(layoutParams2);
        int dimens = l.getDimens(this.mActivity, R.dimen.tbds27);
        this.lpx.setPadding(dimens, 0, dimens, 0);
        this.gCe = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.WV.addFooterView(view);
        this.WV.addHeaderView(view2);
    }

    public void d(a aVar) {
        this.WV.setAdapter((ListAdapter) aVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRoot);
        this.gCe.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        ao.setViewTextColor(this.lpx, R.color.navbar_btn_color);
        ao.setViewTextColor(this.iWJ, R.color.navi_back_text_color);
        ao.setBackgroundResource(this.lpx, R.drawable.s_navbar_button_bg);
    }

    public TextView dhZ() {
        return this.lpx;
    }

    public TextView dia() {
        return this.iWJ;
    }

    public void an(boolean z, boolean z2) {
        if (z) {
            this.lpx.setText(this.mActivity.getPageContext().getString(R.string.done));
            return;
        }
        this.lpx.setText(this.mActivity.getPageContext().getString(R.string.edit));
        this.lpx.setEnabled(!z2);
    }
}
