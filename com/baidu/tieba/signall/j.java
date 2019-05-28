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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int iRH;
    private BdListView MS;
    private c iQp;
    private SignAllForumActivity iRI;
    private SignAllForumProgressView iRJ;
    private g iRK;
    private RelativeLayout iRL;
    private TextView iRM;
    private TextView iRN;
    private LinearLayout iRO;
    private TextView iRP;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iRI = signAllForumActivity;
        this.iRI.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.iRI.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iRI.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iRI.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iRI.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.MS = (BdListView) this.iRI.findViewById(R.id.signallforum_list);
        this.MS.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.MS.setPullRefresh(this.mPullView);
        this.iRP = (TextView) LayoutInflater.from(this.iRI.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.MS.addFooterView(this.iRP);
        this.iRJ = new SignAllForumProgressView(this.iRI.getPageContext().getPageActivity());
        this.mProgressBar = this.iRJ.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iRI);
        this.MS.addHeaderView(this.iRJ);
        this.iRJ.setVisibility(8);
        this.iRL = (RelativeLayout) this.iRJ.findViewById(R.id.guidecontainer);
        this.iRO = (LinearLayout) this.iRJ.findViewById(R.id.guideopenbtn);
        this.iRM = (TextView) this.iRJ.findViewById(R.id.guidetip);
        this.iRN = (TextView) this.iRJ.findViewById(R.id.guideopen);
        this.iRO.setOnClickListener(this.iRI);
        this.iRK = new g(this.iRI, null);
        this.MS.setAdapter((ListAdapter) this.iRK);
        this.MS.setOnScrollListener(this.iRK);
    }

    public void onChangeSkinType(int i) {
        this.iRI.getLayoutMode().setNightMode(i == 1);
        this.iRI.getLayoutMode().onModeChanged(this.mRootView);
        this.iRI.getLayoutMode().onModeChanged(this.iRP);
        this.iRI.getLayoutMode().onModeChanged(this.iRJ);
        al.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.iRJ != null) {
            this.iRJ.onChangeSkinType();
        }
        this.mPullView.iP(i);
        this.iRK.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.iQp = cVar;
            ckC();
            ArrayList<d> cjQ = cVar.cjQ();
            this.iRK.c(this.iQp);
            if (cjQ.size() == iRH) {
                this.iRP.setVisibility(0);
                this.iRP.setText(cVar.cjN());
            } else {
                this.iRP.setVisibility(8);
            }
            String cjH = this.iQp.cjH();
            if (!StringUtils.isNull(cjH)) {
                this.iRJ.a(this.iRI, cjH, this.iQp.cjI());
                return;
            }
            this.iRJ.ckB();
        }
    }

    private void ckC() {
        if (this.iQp != null) {
            this.iRJ.setHasPrivilege(this.iQp.cjU());
            this.iRJ.setmCurrentStatus(this.iQp.cjW());
            TextView message1 = this.iRJ.getMessage1();
            SpannableString spannableString = new SpannableString(this.iQp.cjK() + this.iQp.bWQ() + this.iQp.cjL());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.iQp.cjK().length();
            spannableString.setSpan(foregroundColorSpan, length, this.iQp.bWQ().length() + length, 33);
            message1.setText(spannableString);
            this.iRJ.getMessage2().setText(this.iQp.cjM());
            this.iRM.setText(this.iQp.getContent());
            if (TextUtils.isEmpty(this.iQp.cjV())) {
                this.iRN.setText(R.string.member_buy_open);
            } else {
                this.iRN.setText(this.iQp.cjV());
            }
            this.iRJ.setVisibility(0);
            if (this.iQp.cjU() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iRL.setVisibility(8);
            } else {
                this.iRL.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.MS.startPullRefresh();
    }

    public void oy() {
        this.MS.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.MS.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView ckD() {
        return this.iRJ;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ckE() {
        return this.MS;
    }

    public c ckF() {
        return this.iQp;
    }

    public g ckG() {
        return this.iRK;
    }

    public LinearLayout ckH() {
        return this.iRO;
    }

    public void setListViewSelection(int i) {
        this.MS.setSelection(i);
    }

    public RelativeLayout bld() {
        return this.mRootView;
    }
}
