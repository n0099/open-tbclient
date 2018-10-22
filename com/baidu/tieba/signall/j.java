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
    public static int gUY;
    private BdListView OE;
    private c gTE;
    private SignAllForumActivity gUZ;
    private SignAllForumProgressView gVa;
    private g gVb;
    private RelativeLayout gVc;
    private TextView gVd;
    private TextView gVe;
    private LinearLayout gVf;
    private TextView gVg;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gUZ = signAllForumActivity;
        this.gUZ.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.gUZ.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gUZ.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gUZ.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gUZ.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OE = (BdListView) this.gUZ.findViewById(e.g.signallforum_list);
        this.OE.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OE.setPullRefresh(this.mPullView);
        this.gVg = (TextView) LayoutInflater.from(this.gUZ.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OE.addFooterView(this.gVg);
        this.gVa = new SignAllForumProgressView(this.gUZ.getPageContext().getPageActivity());
        this.mProgressBar = this.gVa.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gUZ);
        this.OE.addHeaderView(this.gVa);
        this.gVa.setVisibility(8);
        this.gVc = (RelativeLayout) this.gVa.findViewById(e.g.guidecontainer);
        this.gVf = (LinearLayout) this.gVa.findViewById(e.g.guideopenbtn);
        this.gVd = (TextView) this.gVa.findViewById(e.g.guidetip);
        this.gVe = (TextView) this.gVa.findViewById(e.g.guideopen);
        this.gVf.setOnClickListener(this.gUZ);
        this.gVb = new g(this.gUZ, null);
        this.OE.setAdapter((ListAdapter) this.gVb);
        this.OE.setOnScrollListener(this.gVb);
    }

    public void onChangeSkinType(int i) {
        this.gUZ.getLayoutMode().setNightMode(i == 1);
        this.gUZ.getLayoutMode().onModeChanged(this.mRootView);
        this.gUZ.getLayoutMode().onModeChanged(this.gVg);
        this.gUZ.getLayoutMode().onModeChanged(this.gVa);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dW(i);
        this.gVb.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gTE = cVar;
            byV();
            ArrayList<d> byi = cVar.byi();
            this.gVb.c(this.gTE);
            if (byi.size() == gUY) {
                this.gVg.setVisibility(0);
                this.gVg.setText(cVar.byf());
            } else {
                this.gVg.setVisibility(8);
            }
            String bxZ = this.gTE.bxZ();
            if (!StringUtils.isNull(bxZ)) {
                this.gVa.a(this.gUZ, bxZ, this.gTE.bya());
                return;
            }
            this.gVa.byT();
        }
    }

    private void byV() {
        if (this.gTE != null) {
            this.gVa.setHasPrivilege(this.gTE.bym());
            this.gVa.setmCurrentStatus(this.gTE.byo());
            TextView message1 = this.gVa.getMessage1();
            SpannableString spannableString = new SpannableString(this.gTE.byc() + this.gTE.blS() + this.gTE.byd());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.gTE.byc().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gTE.blS().length() + length, 33);
            message1.setText(spannableString);
            this.gVa.getMessage2().setText(this.gTE.bye());
            this.gVd.setText(this.gTE.getContent());
            if (TextUtils.isEmpty(this.gTE.byn())) {
                this.gVe.setText(e.j.member_buy_open);
            } else {
                this.gVe.setText(this.gTE.byn());
            }
            this.gVa.setVisibility(0);
            if (this.gTE.bym() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gVc.setVisibility(8);
            } else {
                this.gVc.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.OE.startPullRefresh();
    }

    public void pj() {
        this.OE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.OE.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView byW() {
        return this.gVa;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView byX() {
        return this.OE;
    }

    public c byY() {
        return this.gTE;
    }

    public g byZ() {
        return this.gVb;
    }

    public LinearLayout bza() {
        return this.gVf;
    }

    public void setListViewSelection(int i) {
        this.OE.setSelection(i);
    }

    public RelativeLayout aAJ() {
        return this.mRootView;
    }
}
