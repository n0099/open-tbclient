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
    public static int iRL;
    private BdListView MR;
    private c iQt;
    private SignAllForumActivity iRM;
    private SignAllForumProgressView iRN;
    private g iRO;
    private RelativeLayout iRP;
    private TextView iRQ;
    private TextView iRR;
    private LinearLayout iRS;
    private TextView iRT;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iRM = signAllForumActivity;
        this.iRM.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.iRM.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iRM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iRM.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iRM.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.MR = (BdListView) this.iRM.findViewById(R.id.signallforum_list);
        this.MR.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.MR.setPullRefresh(this.mPullView);
        this.iRT = (TextView) LayoutInflater.from(this.iRM.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.MR.addFooterView(this.iRT);
        this.iRN = new SignAllForumProgressView(this.iRM.getPageContext().getPageActivity());
        this.mProgressBar = this.iRN.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iRM);
        this.MR.addHeaderView(this.iRN);
        this.iRN.setVisibility(8);
        this.iRP = (RelativeLayout) this.iRN.findViewById(R.id.guidecontainer);
        this.iRS = (LinearLayout) this.iRN.findViewById(R.id.guideopenbtn);
        this.iRQ = (TextView) this.iRN.findViewById(R.id.guidetip);
        this.iRR = (TextView) this.iRN.findViewById(R.id.guideopen);
        this.iRS.setOnClickListener(this.iRM);
        this.iRO = new g(this.iRM, null);
        this.MR.setAdapter((ListAdapter) this.iRO);
        this.MR.setOnScrollListener(this.iRO);
    }

    public void onChangeSkinType(int i) {
        this.iRM.getLayoutMode().setNightMode(i == 1);
        this.iRM.getLayoutMode().onModeChanged(this.mRootView);
        this.iRM.getLayoutMode().onModeChanged(this.iRT);
        this.iRM.getLayoutMode().onModeChanged(this.iRN);
        al.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.iRN != null) {
            this.iRN.onChangeSkinType();
        }
        this.mPullView.iP(i);
        this.iRO.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.iQt = cVar;
            ckD();
            ArrayList<d> cjR = cVar.cjR();
            this.iRO.c(this.iQt);
            if (cjR.size() == iRL) {
                this.iRT.setVisibility(0);
                this.iRT.setText(cVar.cjO());
            } else {
                this.iRT.setVisibility(8);
            }
            String cjI = this.iQt.cjI();
            if (!StringUtils.isNull(cjI)) {
                this.iRN.a(this.iRM, cjI, this.iQt.cjJ());
                return;
            }
            this.iRN.ckC();
        }
    }

    private void ckD() {
        if (this.iQt != null) {
            this.iRN.setHasPrivilege(this.iQt.cjV());
            this.iRN.setmCurrentStatus(this.iQt.cjX());
            TextView message1 = this.iRN.getMessage1();
            SpannableString spannableString = new SpannableString(this.iQt.cjL() + this.iQt.bWR() + this.iQt.cjM());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.iQt.cjL().length();
            spannableString.setSpan(foregroundColorSpan, length, this.iQt.bWR().length() + length, 33);
            message1.setText(spannableString);
            this.iRN.getMessage2().setText(this.iQt.cjN());
            this.iRQ.setText(this.iQt.getContent());
            if (TextUtils.isEmpty(this.iQt.cjW())) {
                this.iRR.setText(R.string.member_buy_open);
            } else {
                this.iRR.setText(this.iQt.cjW());
            }
            this.iRN.setVisibility(0);
            if (this.iQt.cjV() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iRP.setVisibility(8);
            } else {
                this.iRP.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.MR.startPullRefresh();
    }

    public void oy() {
        this.MR.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.MR.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView ckE() {
        return this.iRN;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ckF() {
        return this.MR;
    }

    public c ckG() {
        return this.iQt;
    }

    public g ckH() {
        return this.iRO;
    }

    public LinearLayout ckI() {
        return this.iRS;
    }

    public void setListViewSelection(int i) {
        this.MR.setSelection(i);
    }

    public RelativeLayout bld() {
        return this.mRootView;
    }
}
