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
    public static int hgs;
    private BdListView OF;
    private c hfa;
    private TextView hgA;
    private SignAllForumActivity hgt;
    private SignAllForumProgressView hgu;
    private g hgv;
    private RelativeLayout hgw;
    private TextView hgx;
    private TextView hgy;
    private LinearLayout hgz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.hgt = signAllForumActivity;
        this.hgt.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.hgt.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.hgt.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hgt.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.hgt.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OF = (BdListView) this.hgt.findViewById(e.g.signallforum_list);
        this.OF.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.hgA = (TextView) LayoutInflater.from(this.hgt.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OF.addFooterView(this.hgA);
        this.hgu = new SignAllForumProgressView(this.hgt.getPageContext().getPageActivity());
        this.mProgressBar = this.hgu.getProgressBar();
        this.mProgressBar.setOnClickListener(this.hgt);
        this.OF.addHeaderView(this.hgu);
        this.hgu.setVisibility(8);
        this.hgw = (RelativeLayout) this.hgu.findViewById(e.g.guidecontainer);
        this.hgz = (LinearLayout) this.hgu.findViewById(e.g.guideopenbtn);
        this.hgx = (TextView) this.hgu.findViewById(e.g.guidetip);
        this.hgy = (TextView) this.hgu.findViewById(e.g.guideopen);
        this.hgz.setOnClickListener(this.hgt);
        this.hgv = new g(this.hgt, null);
        this.OF.setAdapter((ListAdapter) this.hgv);
        this.OF.setOnScrollListener(this.hgv);
    }

    public void onChangeSkinType(int i) {
        this.hgt.getLayoutMode().setNightMode(i == 1);
        this.hgt.getLayoutMode().onModeChanged(this.mRootView);
        this.hgt.getLayoutMode().onModeChanged(this.hgA);
        this.hgt.getLayoutMode().onModeChanged(this.hgu);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        this.hgv.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hfa = cVar;
            bBa();
            ArrayList<d> bAn = cVar.bAn();
            this.hgv.c(this.hfa);
            if (bAn.size() == hgs) {
                this.hgA.setVisibility(0);
                this.hgA.setText(cVar.bAk());
            } else {
                this.hgA.setVisibility(8);
            }
            String bAe = this.hfa.bAe();
            if (!StringUtils.isNull(bAe)) {
                this.hgu.a(this.hgt, bAe, this.hfa.bAf());
                return;
            }
            this.hgu.bAY();
        }
    }

    private void bBa() {
        if (this.hfa != null) {
            this.hgu.setHasPrivilege(this.hfa.bAr());
            this.hgu.setmCurrentStatus(this.hfa.bAt());
            TextView message1 = this.hgu.getMessage1();
            SpannableString spannableString = new SpannableString(this.hfa.bAh() + this.hfa.bnS() + this.hfa.bAi());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.hfa.bAh().length();
            spannableString.setSpan(foregroundColorSpan, length, this.hfa.bnS().length() + length, 33);
            message1.setText(spannableString);
            this.hgu.getMessage2().setText(this.hfa.bAj());
            this.hgx.setText(this.hfa.getContent());
            if (TextUtils.isEmpty(this.hfa.bAs())) {
                this.hgy.setText(e.j.member_buy_open);
            } else {
                this.hgy.setText(this.hfa.bAs());
            }
            this.hgu.setVisibility(0);
            if (this.hfa.bAr() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.hgw.setVisibility(8);
            } else {
                this.hgw.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.OF.startPullRefresh();
    }

    public void pg() {
        this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.OF.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView bBb() {
        return this.hgu;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bBc() {
        return this.OF;
    }

    public c bBd() {
        return this.hfa;
    }

    public g bBe() {
        return this.hgv;
    }

    public LinearLayout bBf() {
        return this.hgz;
    }

    public void setListViewSelection(int i) {
        this.OF.setSelection(i);
    }

    public RelativeLayout aCF() {
        return this.mRootView;
    }
}
