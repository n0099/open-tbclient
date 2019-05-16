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
    public static int iRF;
    private BdListView MS;
    private c iQn;
    private SignAllForumActivity iRG;
    private SignAllForumProgressView iRH;
    private g iRI;
    private RelativeLayout iRJ;
    private TextView iRK;
    private TextView iRL;
    private LinearLayout iRM;
    private TextView iRN;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iRG = signAllForumActivity;
        this.iRG.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.iRG.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iRG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iRG.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iRG.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.MS = (BdListView) this.iRG.findViewById(R.id.signallforum_list);
        this.MS.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.MS.setPullRefresh(this.mPullView);
        this.iRN = (TextView) LayoutInflater.from(this.iRG.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.MS.addFooterView(this.iRN);
        this.iRH = new SignAllForumProgressView(this.iRG.getPageContext().getPageActivity());
        this.mProgressBar = this.iRH.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iRG);
        this.MS.addHeaderView(this.iRH);
        this.iRH.setVisibility(8);
        this.iRJ = (RelativeLayout) this.iRH.findViewById(R.id.guidecontainer);
        this.iRM = (LinearLayout) this.iRH.findViewById(R.id.guideopenbtn);
        this.iRK = (TextView) this.iRH.findViewById(R.id.guidetip);
        this.iRL = (TextView) this.iRH.findViewById(R.id.guideopen);
        this.iRM.setOnClickListener(this.iRG);
        this.iRI = new g(this.iRG, null);
        this.MS.setAdapter((ListAdapter) this.iRI);
        this.MS.setOnScrollListener(this.iRI);
    }

    public void onChangeSkinType(int i) {
        this.iRG.getLayoutMode().setNightMode(i == 1);
        this.iRG.getLayoutMode().onModeChanged(this.mRootView);
        this.iRG.getLayoutMode().onModeChanged(this.iRN);
        this.iRG.getLayoutMode().onModeChanged(this.iRH);
        al.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.iRH != null) {
            this.iRH.onChangeSkinType();
        }
        this.mPullView.iP(i);
        this.iRI.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.iQn = cVar;
            ckA();
            ArrayList<d> cjO = cVar.cjO();
            this.iRI.c(this.iQn);
            if (cjO.size() == iRF) {
                this.iRN.setVisibility(0);
                this.iRN.setText(cVar.cjL());
            } else {
                this.iRN.setVisibility(8);
            }
            String cjF = this.iQn.cjF();
            if (!StringUtils.isNull(cjF)) {
                this.iRH.a(this.iRG, cjF, this.iQn.cjG());
                return;
            }
            this.iRH.ckz();
        }
    }

    private void ckA() {
        if (this.iQn != null) {
            this.iRH.setHasPrivilege(this.iQn.cjS());
            this.iRH.setmCurrentStatus(this.iQn.cjU());
            TextView message1 = this.iRH.getMessage1();
            SpannableString spannableString = new SpannableString(this.iQn.cjI() + this.iQn.bWN() + this.iQn.cjJ());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.iQn.cjI().length();
            spannableString.setSpan(foregroundColorSpan, length, this.iQn.bWN().length() + length, 33);
            message1.setText(spannableString);
            this.iRH.getMessage2().setText(this.iQn.cjK());
            this.iRK.setText(this.iQn.getContent());
            if (TextUtils.isEmpty(this.iQn.cjT())) {
                this.iRL.setText(R.string.member_buy_open);
            } else {
                this.iRL.setText(this.iQn.cjT());
            }
            this.iRH.setVisibility(0);
            if (this.iQn.cjS() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iRJ.setVisibility(8);
            } else {
                this.iRJ.setVisibility(0);
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

    public SignAllForumProgressView ckB() {
        return this.iRH;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ckC() {
        return this.MS;
    }

    public c ckD() {
        return this.iQn;
    }

    public g ckE() {
        return this.iRI;
    }

    public LinearLayout ckF() {
        return this.iRM;
    }

    public void setListViewSelection(int i) {
        this.MS.setSelection(i);
    }

    public RelativeLayout bla() {
        return this.mRootView;
    }
}
