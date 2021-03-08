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
/* loaded from: classes7.dex */
public class j extends com.baidu.adp.base.d<SignAllForumActivity> {
    public static int nrv;
    private BdListView Yj;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c nqa;
    private TextView nrA;
    private TextView nrB;
    private LinearLayout nrC;
    private TextView nrD;
    private SignAllForumActivity nrw;
    private SignAllForumProgressView nrx;
    private g nry;
    private RelativeLayout nrz;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.nrw = signAllForumActivity;
        this.nrw.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.nrw.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.nrw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.nrw.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.nrw.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Yj = (BdListView) this.nrw.findViewById(R.id.signallforum_list);
        this.Yj.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.Yj.setPullRefresh(this.mPullView);
        this.nrD = (TextView) LayoutInflater.from(this.nrw.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Yj.addFooterView(this.nrD);
        this.nrx = new SignAllForumProgressView(this.nrw.getPageContext().getPageActivity());
        this.mProgressBar = this.nrx.getProgressBar();
        this.mProgressBar.setOnClickListener(this.nrw);
        this.Yj.addHeaderView(this.nrx);
        this.nrx.setVisibility(8);
        this.nrz = (RelativeLayout) this.nrx.findViewById(R.id.guidecontainer);
        this.nrC = (LinearLayout) this.nrx.findViewById(R.id.guideopenbtn);
        this.nrA = (TextView) this.nrx.findViewById(R.id.guidetip);
        this.nrB = (TextView) this.nrx.findViewById(R.id.guideopen);
        this.nrC.setOnClickListener(this.nrw);
        this.nry = new g(this.nrw, null);
        this.Yj.setAdapter((ListAdapter) this.nry);
        this.Yj.setOnScrollListener(this.nry);
    }

    public void onChangeSkinType(int i) {
        this.nrw.getLayoutMode().setNightMode(i == 1);
        this.nrw.getLayoutMode().onModeChanged(this.mRootView);
        this.nrw.getLayoutMode().onModeChanged(this.nrD);
        this.nrw.getLayoutMode().onModeChanged(this.nrx);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.nrx != null) {
            this.nrx.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.nry.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.nqa = cVar;
            dLx();
            ArrayList<d> dKM = cVar.dKM();
            this.nry.c(this.nqa);
            if (dKM.size() == nrv) {
                this.nrD.setVisibility(0);
                this.nrD.setText(cVar.dKJ());
            } else {
                this.nrD.setVisibility(8);
            }
            String dKD = this.nqa.dKD();
            if (!StringUtils.isNull(dKD)) {
                this.nrx.a(this.nrw, dKD, this.nqa.dKE());
                return;
            }
            this.nrx.dLw();
        }
    }

    private void dLx() {
        if (this.nqa != null) {
            this.nrx.setHasPrivilege(this.nqa.dKQ());
            this.nrx.setmCurrentStatus(this.nqa.dKS());
            TextView message1 = this.nrx.getMessage1();
            SpannableString spannableString = new SpannableString(this.nqa.dKG() + this.nqa.Bv() + this.nqa.dKH());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.nqa.dKG().length();
            spannableString.setSpan(foregroundColorSpan, length, this.nqa.Bv().length() + length, 33);
            message1.setText(spannableString);
            this.nrx.getMessage2().setText(this.nqa.dKI());
            this.nrA.setText(this.nqa.getContent());
            if (TextUtils.isEmpty(this.nqa.dKR())) {
                this.nrB.setText(R.string.member_buy_open);
            } else {
                this.nrB.setText(this.nqa.dKR());
            }
            this.nrx.setVisibility(0);
            if (this.nqa.dKQ() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.nrz.setVisibility(8);
            } else {
                this.nrz.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Yj.startPullRefresh();
    }

    public void completeRefresh() {
        this.Yj.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Yj.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dLy() {
        return this.nrx;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dLz() {
        return this.Yj;
    }

    public c dLA() {
        return this.nqa;
    }

    public g dLB() {
        return this.nry;
    }

    public LinearLayout dLC() {
        return this.nrC;
    }

    public void setListViewSelection(int i) {
        this.Yj.setSelection(i);
    }

    public RelativeLayout cnA() {
        return this.mRootView;
    }
}
