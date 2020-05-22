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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int lde;
    private BdListView Um;
    private c lbJ;
    private SignAllForumActivity ldf;
    private SignAllForumProgressView ldg;
    private g ldh;
    private RelativeLayout ldi;
    private TextView ldj;
    private TextView ldk;
    private LinearLayout ldl;
    private TextView ldm;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.ldf = signAllForumActivity;
        this.ldf.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.ldf.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.ldf.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ldf.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.ldf.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Um = (BdListView) this.ldf.findViewById(R.id.signallforum_list);
        this.Um.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.Um.setPullRefresh(this.mPullView);
        this.ldm = (TextView) LayoutInflater.from(this.ldf.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Um.addFooterView(this.ldm);
        this.ldg = new SignAllForumProgressView(this.ldf.getPageContext().getPageActivity());
        this.mProgressBar = this.ldg.getProgressBar();
        this.mProgressBar.setOnClickListener(this.ldf);
        this.Um.addHeaderView(this.ldg);
        this.ldg.setVisibility(8);
        this.ldi = (RelativeLayout) this.ldg.findViewById(R.id.guidecontainer);
        this.ldl = (LinearLayout) this.ldg.findViewById(R.id.guideopenbtn);
        this.ldj = (TextView) this.ldg.findViewById(R.id.guidetip);
        this.ldk = (TextView) this.ldg.findViewById(R.id.guideopen);
        this.ldl.setOnClickListener(this.ldf);
        this.ldh = new g(this.ldf, null);
        this.Um.setAdapter((ListAdapter) this.ldh);
        this.Um.setOnScrollListener(this.ldh);
    }

    public void onChangeSkinType(int i) {
        this.ldf.getLayoutMode().setNightMode(i == 1);
        this.ldf.getLayoutMode().onModeChanged(this.mRootView);
        this.ldf.getLayoutMode().onModeChanged(this.ldm);
        this.ldf.getLayoutMode().onModeChanged(this.ldg);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.ldg != null) {
            this.ldg.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.ldh.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lbJ = cVar;
            dbk();
            ArrayList<d> dax = cVar.dax();
            this.ldh.c(this.lbJ);
            if (dax.size() == lde) {
                this.ldm.setVisibility(0);
                this.ldm.setText(cVar.dau());
            } else {
                this.ldm.setVisibility(8);
            }
            String dao = this.lbJ.dao();
            if (!StringUtils.isNull(dao)) {
                this.ldg.a(this.ldf, dao, this.lbJ.dap());
                return;
            }
            this.ldg.dbj();
        }
    }

    private void dbk() {
        if (this.lbJ != null) {
            this.ldg.setHasPrivilege(this.lbJ.daB());
            this.ldg.setmCurrentStatus(this.lbJ.daD());
            TextView message1 = this.ldg.getMessage1();
            SpannableString spannableString = new SpannableString(this.lbJ.dar() + this.lbJ.cKh() + this.lbJ.das());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lbJ.dar().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lbJ.cKh().length() + length, 33);
            message1.setText(spannableString);
            this.ldg.getMessage2().setText(this.lbJ.dat());
            this.ldj.setText(this.lbJ.getContent());
            if (TextUtils.isEmpty(this.lbJ.daC())) {
                this.ldk.setText(R.string.member_buy_open);
            } else {
                this.ldk.setText(this.lbJ.daC());
            }
            this.ldg.setVisibility(0);
            if (this.lbJ.daB() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.ldi.setVisibility(8);
            } else {
                this.ldi.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Um.startPullRefresh();
    }

    public void completeRefresh() {
        this.Um.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Um.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dbl() {
        return this.ldg;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dbm() {
        return this.Um;
    }

    public c dbn() {
        return this.lbJ;
    }

    public g dbo() {
        return this.ldh;
    }

    public LinearLayout dbp() {
        return this.ldl;
    }

    public void setListViewSelection(int i) {
        this.Um.setSelection(i);
    }

    public RelativeLayout bIL() {
        return this.mRootView;
    }
}
