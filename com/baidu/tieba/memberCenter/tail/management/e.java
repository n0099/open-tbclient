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
/* loaded from: classes8.dex */
public class e {
    private BdListView Yj;
    private NoNetworkView gCe;
    private TextView iZG;
    private TextView lvk;
    private BaseActivity<?> mActivity;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mRoot = baseActivity.findViewById(R.id.tail_management_root);
        this.Yj = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.iZG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mActivity.getString(R.string.cancel), onClickListener);
        this.lvk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.lvk.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iZG.getLayoutParams();
        layoutParams.leftMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.iZG.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lvk.getLayoutParams();
        layoutParams2.rightMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.lvk.setLayoutParams(layoutParams2);
        int dimens = l.getDimens(this.mActivity, R.dimen.tbds27);
        this.lvk.setPadding(dimens, 0, dimens, 0);
        this.gCe = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.Yj.addFooterView(view);
        this.Yj.addHeaderView(view2);
    }

    public void d(a aVar) {
        this.Yj.setAdapter((ListAdapter) aVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().setNightMode(i == 1);
        this.mActivity.getLayoutMode().onModeChanged(this.mRoot);
        this.gCe.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        ap.setViewTextColor(this.lvk, R.color.navbar_btn_color);
        ap.setViewTextColor(this.iZG, R.color.navi_back_text_color);
        ap.setBackgroundResource(this.lvk, R.drawable.s_navbar_button_bg);
    }

    public TextView dgx() {
        return this.lvk;
    }

    public TextView dgy() {
        return this.iZG;
    }

    public void an(boolean z, boolean z2) {
        if (z) {
            this.lvk.setText(this.mActivity.getPageContext().getString(R.string.done));
            return;
        }
        this.lvk.setText(this.mActivity.getPageContext().getString(R.string.edit));
        this.lvk.setEnabled(!z2);
    }
}
