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
    public static int hhx;
    private BdListView OQ;
    private c hgf;
    private g hhA;
    private RelativeLayout hhB;
    private TextView hhC;
    private TextView hhD;
    private LinearLayout hhE;
    private TextView hhF;
    private SignAllForumActivity hhy;
    private SignAllForumProgressView hhz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.hhy = signAllForumActivity;
        this.hhy.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.hhy.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.hhy.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hhy.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.hhy.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OQ = (BdListView) this.hhy.findViewById(e.g.signallforum_list);
        this.OQ.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OQ.setPullRefresh(this.mPullView);
        this.hhF = (TextView) LayoutInflater.from(this.hhy.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OQ.addFooterView(this.hhF);
        this.hhz = new SignAllForumProgressView(this.hhy.getPageContext().getPageActivity());
        this.mProgressBar = this.hhz.getProgressBar();
        this.mProgressBar.setOnClickListener(this.hhy);
        this.OQ.addHeaderView(this.hhz);
        this.hhz.setVisibility(8);
        this.hhB = (RelativeLayout) this.hhz.findViewById(e.g.guidecontainer);
        this.hhE = (LinearLayout) this.hhz.findViewById(e.g.guideopenbtn);
        this.hhC = (TextView) this.hhz.findViewById(e.g.guidetip);
        this.hhD = (TextView) this.hhz.findViewById(e.g.guideopen);
        this.hhE.setOnClickListener(this.hhy);
        this.hhA = new g(this.hhy, null);
        this.OQ.setAdapter((ListAdapter) this.hhA);
        this.OQ.setOnScrollListener(this.hhA);
    }

    public void onChangeSkinType(int i) {
        this.hhy.getLayoutMode().setNightMode(i == 1);
        this.hhy.getLayoutMode().onModeChanged(this.mRootView);
        this.hhy.getLayoutMode().onModeChanged(this.hhF);
        this.hhy.getLayoutMode().onModeChanged(this.hhz);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        this.hhA.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hgf = cVar;
            bBJ();
            ArrayList<d> bAW = cVar.bAW();
            this.hhA.c(this.hgf);
            if (bAW.size() == hhx) {
                this.hhF.setVisibility(0);
                this.hhF.setText(cVar.bAT());
            } else {
                this.hhF.setVisibility(8);
            }
            String bAN = this.hgf.bAN();
            if (!StringUtils.isNull(bAN)) {
                this.hhz.a(this.hhy, bAN, this.hgf.bAO());
                return;
            }
            this.hhz.bBH();
        }
    }

    private void bBJ() {
        if (this.hgf != null) {
            this.hhz.setHasPrivilege(this.hgf.bBa());
            this.hhz.setmCurrentStatus(this.hgf.bBc());
            TextView message1 = this.hhz.getMessage1();
            SpannableString spannableString = new SpannableString(this.hgf.bAQ() + this.hgf.boA() + this.hgf.bAR());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.hgf.bAQ().length();
            spannableString.setSpan(foregroundColorSpan, length, this.hgf.boA().length() + length, 33);
            message1.setText(spannableString);
            this.hhz.getMessage2().setText(this.hgf.bAS());
            this.hhC.setText(this.hgf.getContent());
            if (TextUtils.isEmpty(this.hgf.bBb())) {
                this.hhD.setText(e.j.member_buy_open);
            } else {
                this.hhD.setText(this.hgf.bBb());
            }
            this.hhz.setVisibility(0);
            if (this.hgf.bBa() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.hhB.setVisibility(8);
            } else {
                this.hhB.setVisibility(0);
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
        return this.hhz;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bBL() {
        return this.OQ;
    }

    public c bBM() {
        return this.hgf;
    }

    public g bBN() {
        return this.hhA;
    }

    public LinearLayout bBO() {
        return this.hhE;
    }

    public void setListViewSelection(int i) {
        this.OQ.setSelection(i);
    }

    public RelativeLayout aDc() {
        return this.mRootView;
    }
}
