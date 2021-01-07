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
/* loaded from: classes9.dex */
public class d {
    private BdListView WV;
    private NavigationBar iTI;
    private NoNetworkView jBY;
    private b lkG;
    private View lkH;
    private TbImageView lkI;
    private TextView lkJ;
    private MemberTaskCenterActivity lkx;
    private View mRootView;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.lkx = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.mRootView = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.jBY = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        this.iTI = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.iTI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTI.setTitleText(R.string.member_task_center);
        this.WV = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.lkH = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.a(memberTaskCenterActivity.getActivity(), this.WV, BdListViewHelper.HeadType.DEFAULT);
        this.lkI = (TbImageView) this.lkH.findViewById(R.id.advert_image_view);
        this.lkI.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lkJ = (TextView) this.lkH.findViewById(R.id.current_score_num);
        this.lkI.setOnClickListener(onClickListener);
        this.lkG = new b(memberTaskCenterActivity);
        this.lkG.H(onClickListener);
        this.WV.addHeaderView(this.lkH);
        this.WV.setAdapter((ListAdapter) this.lkG);
    }

    public void a(String str, List<r> list, long j) {
        this.lkI.startLoad(str, 10, false);
        this.lkJ.setText(fN(this.lkx.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.lkG.setData(list);
        this.lkG.notifyDataSetChanged();
    }

    private SpannableString fN(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView getListView() {
        return this.WV;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.iTI.onChangeSkinType(this.lkx.getPageContext(), i);
        this.jBY.onChangeSkinType(this.lkx.getPageContext(), i);
        ao.setBackgroundColor(this.lkJ, R.color.CAM_X0205);
    }
}
