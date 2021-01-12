package com.baidu.tieba.memberCenter.memberTask;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.a.r;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private BdListView WT;
    private NavigationBar iPb;
    private NoNetworkView jxs;
    private MemberTaskCenterActivity lfS;
    private b lgb;
    private View lgc;
    private TbImageView lgd;
    private TextView lge;
    private View mRootView;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.lfS = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.mRootView = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.jxs = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        this.iPb = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.iPb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iPb.setTitleText(R.string.member_task_center);
        this.WT = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.lgc = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.a(memberTaskCenterActivity.getActivity(), this.WT, BdListViewHelper.HeadType.DEFAULT);
        this.lgd = (TbImageView) this.lgc.findViewById(R.id.advert_image_view);
        this.lgd.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lge = (TextView) this.lgc.findViewById(R.id.current_score_num);
        this.lgd.setOnClickListener(onClickListener);
        this.lgb = new b(memberTaskCenterActivity);
        this.lgb.H(onClickListener);
        this.WT.addHeaderView(this.lgc);
        this.WT.setAdapter((ListAdapter) this.lgb);
    }

    public void a(String str, List<r> list, long j) {
        this.lgd.startLoad(str, 10, false);
        this.lge.setText(fM(this.lfS.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.lgb.setData(list);
        this.lgb.notifyDataSetChanged();
    }

    private SpannableString fM(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView getListView() {
        return this.WT;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.iPb.onChangeSkinType(this.lfS.getPageContext(), i);
        this.jxs.onChangeSkinType(this.lfS.getPageContext(), i);
        ao.setBackgroundColor(this.lge, R.color.CAM_X0205);
    }
}
