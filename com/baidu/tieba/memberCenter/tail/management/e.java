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
    private NoNetworkView gAv;
    private TextView iXX;
    private TextView lth;
    private BaseActivity<?> mActivity;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.mActivity = baseActivity;
        this.mRoot = baseActivity.findViewById(R.id.tail_management_root);
        this.WO = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        this.mNavigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.iXX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mActivity.getString(R.string.cancel), onClickListener);
        this.lth = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.lth.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iXX.getLayoutParams();
        layoutParams.leftMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.iXX.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lth.getLayoutParams();
        layoutParams2.rightMargin = l.getDimens(this.mActivity, R.dimen.ds16);
        this.lth.setLayoutParams(layoutParams2);
        int dimens = l.getDimens(this.mActivity, R.dimen.tbds27);
        this.lth.setPadding(dimens, 0, dimens, 0);
        this.gAv = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
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
        this.gAv.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        ap.setViewTextColor(this.lth, R.color.navbar_btn_color);
        ap.setViewTextColor(this.iXX, R.color.navi_back_text_color);
        ap.setBackgroundResource(this.lth, R.drawable.s_navbar_button_bg);
    }

    public TextView dgo() {
        return this.lth;
    }

    public TextView dgp() {
        return this.iXX;
    }

    public void an(boolean z, boolean z2) {
        if (z) {
            this.lth.setText(this.mActivity.getPageContext().getString(R.string.done));
            return;
        }
        this.lth.setText(this.mActivity.getPageContext().getString(R.string.edit));
        this.lth.setEnabled(!z2);
    }
}
