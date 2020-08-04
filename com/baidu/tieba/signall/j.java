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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int lFD;
    private BdListView UL;
    private c lEi;
    private SignAllForumActivity lFE;
    private SignAllForumProgressView lFF;
    private g lFG;
    private RelativeLayout lFH;
    private TextView lFI;
    private TextView lFJ;
    private LinearLayout lFK;
    private TextView lFL;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.lFE = signAllForumActivity;
        this.lFE.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.lFE.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.lFE.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.lFE.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.lFE.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.UL = (BdListView) this.lFE.findViewById(R.id.signallforum_list);
        this.UL.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.UL.setPullRefresh(this.mPullView);
        this.lFL = (TextView) LayoutInflater.from(this.lFE.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.UL.addFooterView(this.lFL);
        this.lFF = new SignAllForumProgressView(this.lFE.getPageContext().getPageActivity());
        this.mProgressBar = this.lFF.getProgressBar();
        this.mProgressBar.setOnClickListener(this.lFE);
        this.UL.addHeaderView(this.lFF);
        this.lFF.setVisibility(8);
        this.lFH = (RelativeLayout) this.lFF.findViewById(R.id.guidecontainer);
        this.lFK = (LinearLayout) this.lFF.findViewById(R.id.guideopenbtn);
        this.lFI = (TextView) this.lFF.findViewById(R.id.guidetip);
        this.lFJ = (TextView) this.lFF.findViewById(R.id.guideopen);
        this.lFK.setOnClickListener(this.lFE);
        this.lFG = new g(this.lFE, null);
        this.UL.setAdapter((ListAdapter) this.lFG);
        this.UL.setOnScrollListener(this.lFG);
    }

    public void onChangeSkinType(int i) {
        this.lFE.getLayoutMode().setNightMode(i == 1);
        this.lFE.getLayoutMode().onModeChanged(this.mRootView);
        this.lFE.getLayoutMode().onModeChanged(this.lFL);
        this.lFE.getLayoutMode().onModeChanged(this.lFF);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lFF != null) {
            this.lFF.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.lFG.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lEi = cVar;
            diZ();
            ArrayList<d> din = cVar.din();
            this.lFG.c(this.lEi);
            if (din.size() == lFD) {
                this.lFL.setVisibility(0);
                this.lFL.setText(cVar.dik());
            } else {
                this.lFL.setVisibility(8);
            }
            String die = this.lEi.die();
            if (!StringUtils.isNull(die)) {
                this.lFF.a(this.lFE, die, this.lEi.dif());
                return;
            }
            this.lFF.diY();
        }
    }

    private void diZ() {
        if (this.lEi != null) {
            this.lFF.setHasPrivilege(this.lEi.dir());
            this.lFF.setmCurrentStatus(this.lEi.dit());
            TextView message1 = this.lFF.getMessage1();
            SpannableString spannableString = new SpannableString(this.lEi.dih() + this.lEi.cSC() + this.lEi.dii());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lEi.dih().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lEi.cSC().length() + length, 33);
            message1.setText(spannableString);
            this.lFF.getMessage2().setText(this.lEi.dij());
            this.lFI.setText(this.lEi.getContent());
            if (TextUtils.isEmpty(this.lEi.dis())) {
                this.lFJ.setText(R.string.member_buy_open);
            } else {
                this.lFJ.setText(this.lEi.dis());
            }
            this.lFF.setVisibility(0);
            if (this.lEi.dir() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.lFH.setVisibility(8);
            } else {
                this.lFH.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.UL.startPullRefresh();
    }

    public void completeRefresh() {
        this.UL.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.UL.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dja() {
        return this.lFF;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView djb() {
        return this.UL;
    }

    public c djc() {
        return this.lEi;
    }

    public g djd() {
        return this.lFG;
    }

    public LinearLayout dje() {
        return this.lFK;
    }

    public void setListViewSelection(int i) {
        this.UL.setSelection(i);
    }

    public RelativeLayout bPb() {
        return this.mRootView;
    }
}
