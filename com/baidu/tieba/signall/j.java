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
    public static int lXi;
    private BdListView Vo;
    private c lVM;
    private SignAllForumActivity lXj;
    private SignAllForumProgressView lXk;
    private g lXl;
    private RelativeLayout lXm;
    private TextView lXn;
    private TextView lXo;
    private LinearLayout lXp;
    private TextView lXq;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.lXj = signAllForumActivity;
        this.lXj.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.lXj.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.lXj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.lXj.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.lXj.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Vo = (BdListView) this.lXj.findViewById(R.id.signallforum_list);
        this.Vo.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.Vo.setPullRefresh(this.mPullView);
        this.lXq = (TextView) LayoutInflater.from(this.lXj.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Vo.addFooterView(this.lXq);
        this.lXk = new SignAllForumProgressView(this.lXj.getPageContext().getPageActivity());
        this.mProgressBar = this.lXk.getProgressBar();
        this.mProgressBar.setOnClickListener(this.lXj);
        this.Vo.addHeaderView(this.lXk);
        this.lXk.setVisibility(8);
        this.lXm = (RelativeLayout) this.lXk.findViewById(R.id.guidecontainer);
        this.lXp = (LinearLayout) this.lXk.findViewById(R.id.guideopenbtn);
        this.lXn = (TextView) this.lXk.findViewById(R.id.guidetip);
        this.lXo = (TextView) this.lXk.findViewById(R.id.guideopen);
        this.lXp.setOnClickListener(this.lXj);
        this.lXl = new g(this.lXj, null);
        this.Vo.setAdapter((ListAdapter) this.lXl);
        this.Vo.setOnScrollListener(this.lXl);
    }

    public void onChangeSkinType(int i) {
        this.lXj.getLayoutMode().setNightMode(i == 1);
        this.lXj.getLayoutMode().onModeChanged(this.mRootView);
        this.lXj.getLayoutMode().onModeChanged(this.lXq);
        this.lXj.getLayoutMode().onModeChanged(this.lXk);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lXk != null) {
            this.lXk.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.lXl.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lVM = cVar;
            duu();
            ArrayList<d> dtI = cVar.dtI();
            this.lXl.c(this.lVM);
            if (dtI.size() == lXi) {
                this.lXq.setVisibility(0);
                this.lXq.setText(cVar.dtF());
            } else {
                this.lXq.setVisibility(8);
            }
            String dtz = this.lVM.dtz();
            if (!StringUtils.isNull(dtz)) {
                this.lXk.a(this.lXj, dtz, this.lVM.dtA());
                return;
            }
            this.lXk.dut();
        }
    }

    private void duu() {
        if (this.lVM != null) {
            this.lXk.setHasPrivilege(this.lVM.dtM());
            this.lXk.setmCurrentStatus(this.lVM.dtO());
            TextView message1 = this.lXk.getMessage1();
            SpannableString spannableString = new SpannableString(this.lVM.dtC() + this.lVM.ddu() + this.lVM.dtD());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lVM.dtC().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lVM.ddu().length() + length, 33);
            message1.setText(spannableString);
            this.lXk.getMessage2().setText(this.lVM.dtE());
            this.lXn.setText(this.lVM.getContent());
            if (TextUtils.isEmpty(this.lVM.dtN())) {
                this.lXo.setText(R.string.member_buy_open);
            } else {
                this.lXo.setText(this.lVM.dtN());
            }
            this.lXk.setVisibility(0);
            if (this.lVM.dtM() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.lXm.setVisibility(8);
            } else {
                this.lXm.setVisibility(0);
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

    public SignAllForumProgressView duv() {
        return this.lXk;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView duw() {
        return this.Vo;
    }

    public c dux() {
        return this.lVM;
    }

    public g duy() {
        return this.lXl;
    }

    public LinearLayout duz() {
        return this.lXp;
    }

    public void setListViewSelection(int i) {
        this.Vo.setSelection(i);
    }

    public RelativeLayout bZb() {
        return this.mRootView;
    }
}
