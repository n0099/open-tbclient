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
/* loaded from: classes9.dex */
public class d {
    private BdListView WO;
    private NavigationBar iUI;
    private NoNetworkView jCY;
    private MemberTaskCenterActivity lnV;
    private b lof;
    private View loh;
    private TbImageView loi;
    private TextView loj;
    private View mRootView;

    public d(MemberTaskCenterActivity memberTaskCenterActivity, View.OnClickListener onClickListener) {
        this.lnV = memberTaskCenterActivity;
        memberTaskCenterActivity.setContentView(R.layout.member_task_center_activity);
        this.mRootView = memberTaskCenterActivity.findViewById(R.id.root_view);
        this.jCY = (NoNetworkView) memberTaskCenterActivity.findViewById(R.id.view_no_network);
        this.iUI = (NavigationBar) memberTaskCenterActivity.findViewById(R.id.view_navigation_bar);
        this.iUI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iUI.setTitleText(R.string.member_task_center);
        this.WO = (BdListView) memberTaskCenterActivity.findViewById(R.id.member_task_list);
        this.loh = LayoutInflater.from(memberTaskCenterActivity.getActivity()).inflate(R.layout.member_task_center_header_view, (ViewGroup) null);
        BdListViewHelper.a(memberTaskCenterActivity.getActivity(), this.WO, BdListViewHelper.HeadType.DEFAULT);
        this.loi = (TbImageView) this.loh.findViewById(R.id.advert_image_view);
        this.loi.setScaleType(ImageView.ScaleType.FIT_XY);
        this.loj = (TextView) this.loh.findViewById(R.id.current_score_num);
        this.loi.setOnClickListener(onClickListener);
        this.lof = new b(memberTaskCenterActivity);
        this.lof.H(onClickListener);
        this.WO.addHeaderView(this.loh);
        this.WO.setAdapter((ListAdapter) this.lof);
    }

    public void a(String str, List<r> list, long j) {
        this.loi.startLoad(str, 10, false);
        this.loj.setText(fM(this.lnV.getResources().getString(R.string.current_score), String.valueOf(j)));
        this.lof.setData(list);
        this.lof.notifyDataSetChanged();
    }

    private SpannableString fM(String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109)), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0301)), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public BdListView getListView() {
        return this.WO;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        this.iUI.onChangeSkinType(this.lnV.getPageContext(), i);
        this.jCY.onChangeSkinType(this.lnV.getPageContext(), i);
        ap.setBackgroundColor(this.loj, R.color.CAM_X0205);
    }
}
