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
    public static int mJl;
    private BdListView VY;
    private c mHM;
    private SignAllForumActivity mJm;
    private SignAllForumProgressView mJn;
    private g mJo;
    private RelativeLayout mJp;
    private TextView mJq;
    private TextView mJr;
    private LinearLayout mJs;
    private TextView mJt;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.mJm = signAllForumActivity;
        this.mJm.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.mJm.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mJm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mJm.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.mJm.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.VY = (BdListView) this.mJm.findViewById(R.id.signallforum_list);
        this.VY.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.VY.setPullRefresh(this.mPullView);
        this.mJt = (TextView) LayoutInflater.from(this.mJm.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.VY.addFooterView(this.mJt);
        this.mJn = new SignAllForumProgressView(this.mJm.getPageContext().getPageActivity());
        this.mProgressBar = this.mJn.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mJm);
        this.VY.addHeaderView(this.mJn);
        this.mJn.setVisibility(8);
        this.mJp = (RelativeLayout) this.mJn.findViewById(R.id.guidecontainer);
        this.mJs = (LinearLayout) this.mJn.findViewById(R.id.guideopenbtn);
        this.mJq = (TextView) this.mJn.findViewById(R.id.guidetip);
        this.mJr = (TextView) this.mJn.findViewById(R.id.guideopen);
        this.mJs.setOnClickListener(this.mJm);
        this.mJo = new g(this.mJm, null);
        this.VY.setAdapter((ListAdapter) this.mJo);
        this.VY.setOnScrollListener(this.mJo);
    }

    public void onChangeSkinType(int i) {
        this.mJm.getLayoutMode().setNightMode(i == 1);
        this.mJm.getLayoutMode().onModeChanged(this.mRootView);
        this.mJm.getLayoutMode().onModeChanged(this.mJt);
        this.mJm.getLayoutMode().onModeChanged(this.mJn);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mJn != null) {
            this.mJn.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.mJo.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.mHM = cVar;
            dFl();
            ArrayList<d> dEz = cVar.dEz();
            this.mJo.c(this.mHM);
            if (dEz.size() == mJl) {
                this.mJt.setVisibility(0);
                this.mJt.setText(cVar.dEw());
            } else {
                this.mJt.setVisibility(8);
            }
            String dEq = this.mHM.dEq();
            if (!StringUtils.isNull(dEq)) {
                this.mJn.a(this.mJm, dEq, this.mHM.dEr());
                return;
            }
            this.mJn.dFk();
        }
    }

    private void dFl() {
        if (this.mHM != null) {
            this.mJn.setHasPrivilege(this.mHM.dED());
            this.mJn.setmCurrentStatus(this.mHM.dEF());
            TextView message1 = this.mJn.getMessage1();
            SpannableString spannableString = new SpannableString(this.mHM.dEt() + this.mHM.dnQ() + this.mHM.dEu());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.mHM.dEt().length();
            spannableString.setSpan(foregroundColorSpan, length, this.mHM.dnQ().length() + length, 33);
            message1.setText(spannableString);
            this.mJn.getMessage2().setText(this.mHM.dEv());
            this.mJq.setText(this.mHM.getContent());
            if (TextUtils.isEmpty(this.mHM.dEE())) {
                this.mJr.setText(R.string.member_buy_open);
            } else {
                this.mJr.setText(this.mHM.dEE());
            }
            this.mJn.setVisibility(0);
            if (this.mHM.dED() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.mJp.setVisibility(8);
            } else {
                this.mJp.setVisibility(0);
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

    public SignAllForumProgressView dFm() {
        return this.mJn;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dFn() {
        return this.VY;
    }

    public c dFo() {
        return this.mHM;
    }

    public g dFp() {
        return this.mJo;
    }

    public LinearLayout dFq() {
        return this.mJs;
    }

    public void setListViewSelection(int i) {
        this.VY.setSelection(i);
    }

    public RelativeLayout chy() {
        return this.mRootView;
    }
}
