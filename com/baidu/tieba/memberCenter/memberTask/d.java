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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.index.a.r;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private BdListView Yj;
    private NavigationBar iWF;
    private NoNetworkView jEV;
    private TbImageView lqA;
    private TextView lqB;
    private MemberTaskCenterActivity lqp;
    private b lqy;
    private View lqz;
    private View mRootView;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.lqp = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.mRootView = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.jEV = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        this.iWF = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.iWF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWF.setTitleText(R.string.member_task_center);
        this.Yj = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.lqz = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.a(memberTaskCenterActivity.getActivity(), this.Yj, BdListViewHelper.HeadType.DEFAULT);
        this.lqA = (TbImageView) this.lqz.findViewById(R.id.advert_image_view);
        this.lqA.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lqB = (TextView) this.lqz.findViewById(R.id.current_score_num);
        this.lqA.setOnClickListener(onClickListener);
        this.lqy = new b(memberTaskCenterActivity);
        this.lqy.I(onClickListener);
        this.Yj.addHeaderView(this.lqz);
        this.Yj.setAdapter((ListAdapter) this.lqy);
    }

    public void a(String str, List<r> list, long j) {
        this.lqA.startLoad(str, 10, false);
        this.lqB.setText(fM(this.lqp.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.lqy.setData(list);
        this.lqy.notifyDataSetChanged();
    }

    private SpannableString fM(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView getListView() {
        return this.Yj;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.iWF.onChangeSkinType(this.lqp.getPageContext(), i);
        this.jEV.onChangeSkinType(this.lqp.getPageContext(), i);
        ap.setBackgroundColor(this.lqB, R.color.CAM_X0205);
    }
}
