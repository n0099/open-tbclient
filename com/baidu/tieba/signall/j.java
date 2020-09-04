package com.baidu.tieba.signall;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int lXx;
    private BdListView Vo;
    private c lWb;
    private g lXA;
    private RelativeLayout lXB;
    private TextView lXC;
    private TextView lXD;
    private LinearLayout lXE;
    private TextView lXF;
    private SignAllForumActivity lXy;
    private SignAllForumProgressView lXz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.lXy = signAllForumActivity;
        this.lXy.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.lXy.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.lXy.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.lXy.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.lXy.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Vo = (BdListView) this.lXy.findViewById(R.id.signallforum_list);
        this.Vo.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.Vo.setPullRefresh(this.mPullView);
        this.lXF = (TextView) LayoutInflater.from(this.lXy.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Vo.addFooterView(this.lXF);
        this.lXz = new SignAllForumProgressView(this.lXy.getPageContext().getPageActivity());
        this.mProgressBar = this.lXz.getProgressBar();
        this.mProgressBar.setOnClickListener(this.lXy);
        this.Vo.addHeaderView(this.lXz);
        this.lXz.setVisibility(8);
        this.lXB = (RelativeLayout) this.lXz.findViewById(R.id.guidecontainer);
        this.lXE = (LinearLayout) this.lXz.findViewById(R.id.guideopenbtn);
        this.lXC = (TextView) this.lXz.findViewById(R.id.guidetip);
        this.lXD = (TextView) this.lXz.findViewById(R.id.guideopen);
        this.lXE.setOnClickListener(this.lXy);
        this.lXA = new g(this.lXy, null);
        this.Vo.setAdapter((ListAdapter) this.lXA);
        this.Vo.setOnScrollListener(this.lXA);
    }

    public void onChangeSkinType(int i) {
        this.lXy.getLayoutMode().setNightMode(i == 1);
        this.lXy.getLayoutMode().onModeChanged(this.mRootView);
        this.lXy.getLayoutMode().onModeChanged(this.lXF);
        this.lXy.getLayoutMode().onModeChanged(this.lXz);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lXz != null) {
            this.lXz.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.lXA.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lWb = cVar;
            duz();
            ArrayList<d> dtN = cVar.dtN();
            this.lXA.c(this.lWb);
            if (dtN.size() == lXx) {
                this.lXF.setVisibility(0);
                this.lXF.setText(cVar.dtK());
            } else {
                this.lXF.setVisibility(8);
            }
            String dtE = this.lWb.dtE();
            if (!StringUtils.isNull(dtE)) {
                this.lXz.a(this.lXy, dtE, this.lWb.dtF());
                return;
            }
            this.lXz.duy();
        }
    }

    private void duz() {
        if (this.lWb != null) {
            this.lXz.setHasPrivilege(this.lWb.dtR());
            this.lXz.setmCurrentStatus(this.lWb.dtT());
            TextView message1 = this.lXz.getMessage1();
            SpannableString spannableString = new SpannableString(this.lWb.dtH() + this.lWb.ddv() + this.lWb.dtI());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lWb.dtH().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lWb.ddv().length() + length, 33);
            message1.setText(spannableString);
            this.lXz.getMessage2().setText(this.lWb.dtJ());
            this.lXC.setText(this.lWb.getContent());
            if (TextUtils.isEmpty(this.lWb.dtS())) {
                this.lXD.setText(R.string.member_buy_open);
            } else {
                this.lXD.setText(this.lWb.dtS());
            }
            this.lXz.setVisibility(0);
            if (this.lWb.dtR() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.lXB.setVisibility(8);
            } else {
                this.lXB.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Vo.startPullRefresh();
    }

    public void completeRefresh() {
        this.Vo.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Vo.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView duA() {
        return this.lXz;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView duB() {
        return this.Vo;
    }

    public c duC() {
        return this.lWb;
    }

    public g duD() {
        return this.lXA;
    }

    public LinearLayout duE() {
        return this.lXE;
    }

    public void setListViewSelection(int i) {
        this.Vo.setSelection(i);
    }

    public RelativeLayout bZc() {
        return this.mRootView;
    }
}
