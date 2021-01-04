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
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.d<SignAllForumActivity> {
    public static int njO;
    private BdListView WV;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c nit;
    private SignAllForumActivity njP;
    private SignAllForumProgressView njQ;
    private g njR;
    private RelativeLayout njS;
    private TextView njT;
    private TextView njU;
    private LinearLayout njV;
    private TextView njW;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.njP = signAllForumActivity;
        this.njP.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.njP.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.njP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.njP.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.njP.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WV = (BdListView) this.njP.findViewById(R.id.signallforum_list);
        this.WV.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WV.setPullRefresh(this.mPullView);
        this.njW = (TextView) LayoutInflater.from(this.njP.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WV.addFooterView(this.njW);
        this.njQ = new SignAllForumProgressView(this.njP.getPageContext().getPageActivity());
        this.mProgressBar = this.njQ.getProgressBar();
        this.mProgressBar.setOnClickListener(this.njP);
        this.WV.addHeaderView(this.njQ);
        this.njQ.setVisibility(8);
        this.njS = (RelativeLayout) this.njQ.findViewById(R.id.guidecontainer);
        this.njV = (LinearLayout) this.njQ.findViewById(R.id.guideopenbtn);
        this.njT = (TextView) this.njQ.findViewById(R.id.guidetip);
        this.njU = (TextView) this.njQ.findViewById(R.id.guideopen);
        this.njV.setOnClickListener(this.njP);
        this.njR = new g(this.njP, null);
        this.WV.setAdapter((ListAdapter) this.njR);
        this.WV.setOnScrollListener(this.njR);
    }

    public void onChangeSkinType(int i) {
        this.njP.getLayoutMode().setNightMode(i == 1);
        this.njP.getLayoutMode().onModeChanged(this.mRootView);
        this.njP.getLayoutMode().onModeChanged(this.njW);
        this.njP.getLayoutMode().onModeChanged(this.njQ);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.njQ != null) {
            this.njQ.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.njR.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.nit = cVar;
            dMN();
            ArrayList<d> dMc = cVar.dMc();
            this.njR.c(this.nit);
            if (dMc.size() == njO) {
                this.njW.setVisibility(0);
                this.njW.setText(cVar.dLZ());
            } else {
                this.njW.setVisibility(8);
            }
            String dLT = this.nit.dLT();
            if (!StringUtils.isNull(dLT)) {
                this.njQ.a(this.njP, dLT, this.nit.dLU());
                return;
            }
            this.njQ.dMM();
        }
    }

    private void dMN() {
        if (this.nit != null) {
            this.njQ.setHasPrivilege(this.nit.dMg());
            this.njQ.setmCurrentStatus(this.nit.dMi());
            TextView message1 = this.njQ.getMessage1();
            SpannableString spannableString = new SpannableString(this.nit.dLW() + this.nit.dvb() + this.nit.dLX());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.nit.dLW().length();
            spannableString.setSpan(foregroundColorSpan, length, this.nit.dvb().length() + length, 33);
            message1.setText(spannableString);
            this.njQ.getMessage2().setText(this.nit.dLY());
            this.njT.setText(this.nit.getContent());
            if (TextUtils.isEmpty(this.nit.dMh())) {
                this.njU.setText(R.string.member_buy_open);
            } else {
                this.njU.setText(this.nit.dMh());
            }
            this.njQ.setVisibility(0);
            if (this.nit.dMg() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.njS.setVisibility(8);
            } else {
                this.njS.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.WV.startPullRefresh();
    }

    public void completeRefresh() {
        this.WV.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.WV.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dMO() {
        return this.njQ;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dMP() {
        return this.WV;
    }

    public c dMQ() {
        return this.nit;
    }

    public g dMR() {
        return this.njR;
    }

    public LinearLayout dMS() {
        return this.njV;
    }

    public void setListViewSelection(int i) {
        this.WV.setSelection(i);
    }

    public RelativeLayout cqg() {
        return this.mRootView;
    }
}
