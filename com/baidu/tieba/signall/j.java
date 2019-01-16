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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int hhw;
    private BdListView OQ;
    private c hge;
    private RelativeLayout hhA;
    private TextView hhB;
    private TextView hhC;
    private LinearLayout hhD;
    private TextView hhE;
    private SignAllForumActivity hhx;
    private SignAllForumProgressView hhy;
    private g hhz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.hhx = signAllForumActivity;
        this.hhx.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.hhx.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.hhx.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hhx.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.hhx.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OQ = (BdListView) this.hhx.findViewById(e.g.signallforum_list);
        this.OQ.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OQ.setPullRefresh(this.mPullView);
        this.hhE = (TextView) LayoutInflater.from(this.hhx.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OQ.addFooterView(this.hhE);
        this.hhy = new SignAllForumProgressView(this.hhx.getPageContext().getPageActivity());
        this.mProgressBar = this.hhy.getProgressBar();
        this.mProgressBar.setOnClickListener(this.hhx);
        this.OQ.addHeaderView(this.hhy);
        this.hhy.setVisibility(8);
        this.hhA = (RelativeLayout) this.hhy.findViewById(e.g.guidecontainer);
        this.hhD = (LinearLayout) this.hhy.findViewById(e.g.guideopenbtn);
        this.hhB = (TextView) this.hhy.findViewById(e.g.guidetip);
        this.hhC = (TextView) this.hhy.findViewById(e.g.guideopen);
        this.hhD.setOnClickListener(this.hhx);
        this.hhz = new g(this.hhx, null);
        this.OQ.setAdapter((ListAdapter) this.hhz);
        this.OQ.setOnScrollListener(this.hhz);
    }

    public void onChangeSkinType(int i) {
        this.hhx.getLayoutMode().setNightMode(i == 1);
        this.hhx.getLayoutMode().onModeChanged(this.mRootView);
        this.hhx.getLayoutMode().onModeChanged(this.hhE);
        this.hhx.getLayoutMode().onModeChanged(this.hhy);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        this.hhz.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hge = cVar;
            bBJ();
            ArrayList<d> bAW = cVar.bAW();
            this.hhz.c(this.hge);
            if (bAW.size() == hhw) {
                this.hhE.setVisibility(0);
                this.hhE.setText(cVar.bAT());
            } else {
                this.hhE.setVisibility(8);
            }
            String bAN = this.hge.bAN();
            if (!StringUtils.isNull(bAN)) {
                this.hhy.a(this.hhx, bAN, this.hge.bAO());
                return;
            }
            this.hhy.bBH();
        }
    }

    private void bBJ() {
        if (this.hge != null) {
            this.hhy.setHasPrivilege(this.hge.bBa());
            this.hhy.setmCurrentStatus(this.hge.bBc());
            TextView message1 = this.hhy.getMessage1();
            SpannableString spannableString = new SpannableString(this.hge.bAQ() + this.hge.boA() + this.hge.bAR());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.hge.bAQ().length();
            spannableString.setSpan(foregroundColorSpan, length, this.hge.boA().length() + length, 33);
            message1.setText(spannableString);
            this.hhy.getMessage2().setText(this.hge.bAS());
            this.hhB.setText(this.hge.getContent());
            if (TextUtils.isEmpty(this.hge.bBb())) {
                this.hhC.setText(e.j.member_buy_open);
            } else {
                this.hhC.setText(this.hge.bBb());
            }
            this.hhy.setVisibility(0);
            if (this.hge.bBa() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.hhA.setVisibility(8);
            } else {
                this.hhA.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.OQ.startPullRefresh();
    }

    public void pk() {
        this.OQ.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.OQ.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView bBK() {
        return this.hhy;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bBL() {
        return this.OQ;
    }

    public c bBM() {
        return this.hge;
    }

    public g bBN() {
        return this.hhz;
    }

    public LinearLayout bBO() {
        return this.hhD;
    }

    public void setListViewSelection(int i) {
        this.OQ.setSelection(i);
    }

    public RelativeLayout aDc() {
        return this.mRootView;
    }
}
