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
    public static int gWw;
    private BdListView OF;
    private c gVe;
    private RelativeLayout gWA;
    private TextView gWB;
    private TextView gWC;
    private LinearLayout gWD;
    private TextView gWE;
    private SignAllForumActivity gWx;
    private SignAllForumProgressView gWy;
    private g gWz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gWx = signAllForumActivity;
        this.gWx.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.gWx.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gWx.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gWx.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gWx.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OF = (BdListView) this.gWx.findViewById(e.g.signallforum_list);
        this.OF.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.gWE = (TextView) LayoutInflater.from(this.gWx.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OF.addFooterView(this.gWE);
        this.gWy = new SignAllForumProgressView(this.gWx.getPageContext().getPageActivity());
        this.mProgressBar = this.gWy.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gWx);
        this.OF.addHeaderView(this.gWy);
        this.gWy.setVisibility(8);
        this.gWA = (RelativeLayout) this.gWy.findViewById(e.g.guidecontainer);
        this.gWD = (LinearLayout) this.gWy.findViewById(e.g.guideopenbtn);
        this.gWB = (TextView) this.gWy.findViewById(e.g.guidetip);
        this.gWC = (TextView) this.gWy.findViewById(e.g.guideopen);
        this.gWD.setOnClickListener(this.gWx);
        this.gWz = new g(this.gWx, null);
        this.OF.setAdapter((ListAdapter) this.gWz);
        this.OF.setOnScrollListener(this.gWz);
    }

    public void onChangeSkinType(int i) {
        this.gWx.getLayoutMode().setNightMode(i == 1);
        this.gWx.getLayoutMode().onModeChanged(this.mRootView);
        this.gWx.getLayoutMode().onModeChanged(this.gWE);
        this.gWx.getLayoutMode().onModeChanged(this.gWy);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ek(i);
        this.gWz.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gVe = cVar;
            byr();
            ArrayList<d> bxE = cVar.bxE();
            this.gWz.c(this.gVe);
            if (bxE.size() == gWw) {
                this.gWE.setVisibility(0);
                this.gWE.setText(cVar.bxB());
            } else {
                this.gWE.setVisibility(8);
            }
            String bxv = this.gVe.bxv();
            if (!StringUtils.isNull(bxv)) {
                this.gWy.a(this.gWx, bxv, this.gVe.bxw());
                return;
            }
            this.gWy.byp();
        }
    }

    private void byr() {
        if (this.gVe != null) {
            this.gWy.setHasPrivilege(this.gVe.bxI());
            this.gWy.setmCurrentStatus(this.gVe.bxK());
            TextView message1 = this.gWy.getMessage1();
            SpannableString spannableString = new SpannableString(this.gVe.bxy() + this.gVe.blo() + this.gVe.bxz());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.gVe.bxy().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gVe.blo().length() + length, 33);
            message1.setText(spannableString);
            this.gWy.getMessage2().setText(this.gVe.bxA());
            this.gWB.setText(this.gVe.getContent());
            if (TextUtils.isEmpty(this.gVe.bxJ())) {
                this.gWC.setText(e.j.member_buy_open);
            } else {
                this.gWC.setText(this.gVe.bxJ());
            }
            this.gWy.setVisibility(0);
            if (this.gVe.bxI() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gWA.setVisibility(8);
            } else {
                this.gWA.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.OF.startPullRefresh();
    }

    public void ph() {
        this.OF.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.OF.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView bys() {
        return this.gWy;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView byt() {
        return this.OF;
    }

    public c byu() {
        return this.gVe;
    }

    public g byv() {
        return this.gWz;
    }

    public LinearLayout byw() {
        return this.gWD;
    }

    public void setListViewSelection(int i) {
        this.OF.setSelection(i);
    }

    public RelativeLayout aAg() {
        return this.mRootView;
    }
}
