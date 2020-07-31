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
    public static int lFB;
    private BdListView UL;
    private c lEg;
    private SignAllForumActivity lFC;
    private SignAllForumProgressView lFD;
    private g lFE;
    private RelativeLayout lFF;
    private TextView lFG;
    private TextView lFH;
    private LinearLayout lFI;
    private TextView lFJ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.lFC = signAllForumActivity;
        this.lFC.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.lFC.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.lFC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.lFC.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.lFC.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.UL = (BdListView) this.lFC.findViewById(R.id.signallforum_list);
        this.UL.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.UL.setPullRefresh(this.mPullView);
        this.lFJ = (TextView) LayoutInflater.from(this.lFC.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.UL.addFooterView(this.lFJ);
        this.lFD = new SignAllForumProgressView(this.lFC.getPageContext().getPageActivity());
        this.mProgressBar = this.lFD.getProgressBar();
        this.mProgressBar.setOnClickListener(this.lFC);
        this.UL.addHeaderView(this.lFD);
        this.lFD.setVisibility(8);
        this.lFF = (RelativeLayout) this.lFD.findViewById(R.id.guidecontainer);
        this.lFI = (LinearLayout) this.lFD.findViewById(R.id.guideopenbtn);
        this.lFG = (TextView) this.lFD.findViewById(R.id.guidetip);
        this.lFH = (TextView) this.lFD.findViewById(R.id.guideopen);
        this.lFI.setOnClickListener(this.lFC);
        this.lFE = new g(this.lFC, null);
        this.UL.setAdapter((ListAdapter) this.lFE);
        this.UL.setOnScrollListener(this.lFE);
    }

    public void onChangeSkinType(int i) {
        this.lFC.getLayoutMode().setNightMode(i == 1);
        this.lFC.getLayoutMode().onModeChanged(this.mRootView);
        this.lFC.getLayoutMode().onModeChanged(this.lFJ);
        this.lFC.getLayoutMode().onModeChanged(this.lFD);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lFD != null) {
            this.lFD.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.lFE.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lEg = cVar;
            diZ();
            ArrayList<d> din = cVar.din();
            this.lFE.c(this.lEg);
            if (din.size() == lFB) {
                this.lFJ.setVisibility(0);
                this.lFJ.setText(cVar.dik());
            } else {
                this.lFJ.setVisibility(8);
            }
            String die = this.lEg.die();
            if (!StringUtils.isNull(die)) {
                this.lFD.a(this.lFC, die, this.lEg.dif());
                return;
            }
            this.lFD.diY();
        }
    }

    private void diZ() {
        if (this.lEg != null) {
            this.lFD.setHasPrivilege(this.lEg.dir());
            this.lFD.setmCurrentStatus(this.lEg.dit());
            TextView message1 = this.lFD.getMessage1();
            SpannableString spannableString = new SpannableString(this.lEg.dih() + this.lEg.cSC() + this.lEg.dii());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lEg.dih().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lEg.cSC().length() + length, 33);
            message1.setText(spannableString);
            this.lFD.getMessage2().setText(this.lEg.dij());
            this.lFG.setText(this.lEg.getContent());
            if (TextUtils.isEmpty(this.lEg.dis())) {
                this.lFH.setText(R.string.member_buy_open);
            } else {
                this.lFH.setText(this.lEg.dis());
            }
            this.lFD.setVisibility(0);
            if (this.lEg.dir() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.lFF.setVisibility(8);
            } else {
                this.lFF.setVisibility(0);
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
        return this.lFD;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView djb() {
        return this.UL;
    }

    public c djc() {
        return this.lEg;
    }

    public g djd() {
        return this.lFE;
    }

    public LinearLayout dje() {
        return this.lFI;
    }

    public void setListViewSelection(int i) {
        this.UL.setSelection(i);
    }

    public RelativeLayout bPb() {
        return this.mRootView;
    }
}
