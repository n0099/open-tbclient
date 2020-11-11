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
/* loaded from: classes24.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int mPg;
    private BdListView VY;
    private c mNL;
    private NavigationBar mNavigationBar;
    private SignAllForumActivity mPh;
    private SignAllForumProgressView mPi;
    private g mPj;
    private RelativeLayout mPk;
    private TextView mPl;
    private TextView mPo;
    private LinearLayout mPp;
    private TextView mPq;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.mPh = signAllForumActivity;
        this.mPh.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.mPh.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mPh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mPh.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.mPh.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.VY = (BdListView) this.mPh.findViewById(R.id.signallforum_list);
        this.VY.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.VY.setPullRefresh(this.mPullView);
        this.mPq = (TextView) LayoutInflater.from(this.mPh.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.VY.addFooterView(this.mPq);
        this.mPi = new SignAllForumProgressView(this.mPh.getPageContext().getPageActivity());
        this.mProgressBar = this.mPi.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mPh);
        this.VY.addHeaderView(this.mPi);
        this.mPi.setVisibility(8);
        this.mPk = (RelativeLayout) this.mPi.findViewById(R.id.guidecontainer);
        this.mPp = (LinearLayout) this.mPi.findViewById(R.id.guideopenbtn);
        this.mPl = (TextView) this.mPi.findViewById(R.id.guidetip);
        this.mPo = (TextView) this.mPi.findViewById(R.id.guideopen);
        this.mPp.setOnClickListener(this.mPh);
        this.mPj = new g(this.mPh, null);
        this.VY.setAdapter((ListAdapter) this.mPj);
        this.VY.setOnScrollListener(this.mPj);
    }

    public void onChangeSkinType(int i) {
        this.mPh.getLayoutMode().setNightMode(i == 1);
        this.mPh.getLayoutMode().onModeChanged(this.mRootView);
        this.mPh.getLayoutMode().onModeChanged(this.mPq);
        this.mPh.getLayoutMode().onModeChanged(this.mPi);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mPi != null) {
            this.mPi.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.mPj.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.mNL = cVar;
            dHN();
            ArrayList<d> dHb = cVar.dHb();
            this.mPj.c(this.mNL);
            if (dHb.size() == mPg) {
                this.mPq.setVisibility(0);
                this.mPq.setText(cVar.dGY());
            } else {
                this.mPq.setVisibility(8);
            }
            String dGS = this.mNL.dGS();
            if (!StringUtils.isNull(dGS)) {
                this.mPi.a(this.mPh, dGS, this.mNL.dGT());
                return;
            }
            this.mPi.dHM();
        }
    }

    private void dHN() {
        if (this.mNL != null) {
            this.mPi.setHasPrivilege(this.mNL.dHf());
            this.mPi.setmCurrentStatus(this.mNL.dHh());
            TextView message1 = this.mPi.getMessage1();
            SpannableString spannableString = new SpannableString(this.mNL.dGV() + this.mNL.dqs() + this.mNL.dGW());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.mNL.dGV().length();
            spannableString.setSpan(foregroundColorSpan, length, this.mNL.dqs().length() + length, 33);
            message1.setText(spannableString);
            this.mPi.getMessage2().setText(this.mNL.dGX());
            this.mPl.setText(this.mNL.getContent());
            if (TextUtils.isEmpty(this.mNL.dHg())) {
                this.mPo.setText(R.string.member_buy_open);
            } else {
                this.mPo.setText(this.mNL.dHg());
            }
            this.mPi.setVisibility(0);
            if (this.mNL.dHf() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.mPk.setVisibility(8);
            } else {
                this.mPk.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.VY.startPullRefresh();
    }

    public void completeRefresh() {
        this.VY.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.VY.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dHO() {
        return this.mPi;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dHP() {
        return this.VY;
    }

    public c dHQ() {
        return this.mNL;
    }

    public g dHR() {
        return this.mPj;
    }

    public LinearLayout dHS() {
        return this.mPp;
    }

    public void setListViewSelection(int i) {
        this.VY.setSelection(i);
    }

    public RelativeLayout cka() {
        return this.mRootView;
    }
}
