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
    public static int gUX;
    private BdListView OE;
    private c gTD;
    private SignAllForumActivity gUY;
    private SignAllForumProgressView gUZ;
    private g gVa;
    private RelativeLayout gVb;
    private TextView gVc;
    private TextView gVd;
    private LinearLayout gVe;
    private TextView gVf;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gUY = signAllForumActivity;
        this.gUY.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.gUY.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gUY.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gUY.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gUY.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OE = (BdListView) this.gUY.findViewById(e.g.signallforum_list);
        this.OE.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OE.setPullRefresh(this.mPullView);
        this.gVf = (TextView) LayoutInflater.from(this.gUY.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OE.addFooterView(this.gVf);
        this.gUZ = new SignAllForumProgressView(this.gUY.getPageContext().getPageActivity());
        this.mProgressBar = this.gUZ.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gUY);
        this.OE.addHeaderView(this.gUZ);
        this.gUZ.setVisibility(8);
        this.gVb = (RelativeLayout) this.gUZ.findViewById(e.g.guidecontainer);
        this.gVe = (LinearLayout) this.gUZ.findViewById(e.g.guideopenbtn);
        this.gVc = (TextView) this.gUZ.findViewById(e.g.guidetip);
        this.gVd = (TextView) this.gUZ.findViewById(e.g.guideopen);
        this.gVe.setOnClickListener(this.gUY);
        this.gVa = new g(this.gUY, null);
        this.OE.setAdapter((ListAdapter) this.gVa);
        this.OE.setOnScrollListener(this.gVa);
    }

    public void onChangeSkinType(int i) {
        this.gUY.getLayoutMode().setNightMode(i == 1);
        this.gUY.getLayoutMode().onModeChanged(this.mRootView);
        this.gUY.getLayoutMode().onModeChanged(this.gVf);
        this.gUY.getLayoutMode().onModeChanged(this.gUZ);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dW(i);
        this.gVa.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gTD = cVar;
            byV();
            ArrayList<d> byi = cVar.byi();
            this.gVa.c(this.gTD);
            if (byi.size() == gUX) {
                this.gVf.setVisibility(0);
                this.gVf.setText(cVar.byf());
            } else {
                this.gVf.setVisibility(8);
            }
            String bxZ = this.gTD.bxZ();
            if (!StringUtils.isNull(bxZ)) {
                this.gUZ.a(this.gUY, bxZ, this.gTD.bya());
                return;
            }
            this.gUZ.byT();
        }
    }

    private void byV() {
        if (this.gTD != null) {
            this.gUZ.setHasPrivilege(this.gTD.bym());
            this.gUZ.setmCurrentStatus(this.gTD.byo());
            TextView message1 = this.gUZ.getMessage1();
            SpannableString spannableString = new SpannableString(this.gTD.byc() + this.gTD.blS() + this.gTD.byd());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.gTD.byc().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gTD.blS().length() + length, 33);
            message1.setText(spannableString);
            this.gUZ.getMessage2().setText(this.gTD.bye());
            this.gVc.setText(this.gTD.getContent());
            if (TextUtils.isEmpty(this.gTD.byn())) {
                this.gVd.setText(e.j.member_buy_open);
            } else {
                this.gVd.setText(this.gTD.byn());
            }
            this.gUZ.setVisibility(0);
            if (this.gTD.bym() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gVb.setVisibility(8);
            } else {
                this.gVb.setVisibility(0);
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
        return this.gUZ;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView byX() {
        return this.OE;
    }

    public c byY() {
        return this.gTD;
    }

    public g byZ() {
        return this.gVa;
    }

    public LinearLayout bza() {
        return this.gVe;
    }

    public void setListViewSelection(int i) {
        this.OE.setSelection(i);
    }

    public RelativeLayout aAI() {
        return this.mRootView;
    }
}
