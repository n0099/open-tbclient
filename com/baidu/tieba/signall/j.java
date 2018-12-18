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
    public static int hdo;
    private BdListView OF;
    private c hbW;
    private SignAllForumActivity hdp;
    private SignAllForumProgressView hdq;
    private g hdr;
    private RelativeLayout hds;
    private TextView hdt;
    private TextView hdu;
    private LinearLayout hdv;
    private TextView hdw;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.hdp = signAllForumActivity;
        this.hdp.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.hdp.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.hdp.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hdp.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.hdp.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.OF = (BdListView) this.hdp.findViewById(e.g.signallforum_list);
        this.OF.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.OF.setPullRefresh(this.mPullView);
        this.hdw = (TextView) LayoutInflater.from(this.hdp.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.OF.addFooterView(this.hdw);
        this.hdq = new SignAllForumProgressView(this.hdp.getPageContext().getPageActivity());
        this.mProgressBar = this.hdq.getProgressBar();
        this.mProgressBar.setOnClickListener(this.hdp);
        this.OF.addHeaderView(this.hdq);
        this.hdq.setVisibility(8);
        this.hds = (RelativeLayout) this.hdq.findViewById(e.g.guidecontainer);
        this.hdv = (LinearLayout) this.hdq.findViewById(e.g.guideopenbtn);
        this.hdt = (TextView) this.hdq.findViewById(e.g.guidetip);
        this.hdu = (TextView) this.hdq.findViewById(e.g.guideopen);
        this.hdv.setOnClickListener(this.hdp);
        this.hdr = new g(this.hdp, null);
        this.OF.setAdapter((ListAdapter) this.hdr);
        this.OF.setOnScrollListener(this.hdr);
    }

    public void onChangeSkinType(int i) {
        this.hdp.getLayoutMode().setNightMode(i == 1);
        this.hdp.getLayoutMode().onModeChanged(this.mRootView);
        this.hdp.getLayoutMode().onModeChanged(this.hdw);
        this.hdp.getLayoutMode().onModeChanged(this.hdq);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ey(i);
        this.hdr.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.hbW = cVar;
            bAk();
            ArrayList<d> bzx = cVar.bzx();
            this.hdr.c(this.hbW);
            if (bzx.size() == hdo) {
                this.hdw.setVisibility(0);
                this.hdw.setText(cVar.bzu());
            } else {
                this.hdw.setVisibility(8);
            }
            String bzo = this.hbW.bzo();
            if (!StringUtils.isNull(bzo)) {
                this.hdq.a(this.hdp, bzo, this.hbW.bzp());
                return;
            }
            this.hdq.bAi();
        }
    }

    private void bAk() {
        if (this.hbW != null) {
            this.hdq.setHasPrivilege(this.hbW.bzB());
            this.hdq.setmCurrentStatus(this.hbW.bzD());
            TextView message1 = this.hdq.getMessage1();
            SpannableString spannableString = new SpannableString(this.hbW.bzr() + this.hbW.bng() + this.hbW.bzs());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.hbW.bzr().length();
            spannableString.setSpan(foregroundColorSpan, length, this.hbW.bng().length() + length, 33);
            message1.setText(spannableString);
            this.hdq.getMessage2().setText(this.hbW.bzt());
            this.hdt.setText(this.hbW.getContent());
            if (TextUtils.isEmpty(this.hbW.bzC())) {
                this.hdu.setText(e.j.member_buy_open);
            } else {
                this.hdu.setText(this.hbW.bzC());
            }
            this.hdq.setVisibility(0);
            if (this.hbW.bzB() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.hds.setVisibility(8);
            } else {
                this.hds.setVisibility(0);
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

    public SignAllForumProgressView bAl() {
        return this.hdq;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bAm() {
        return this.OF;
    }

    public c bAn() {
        return this.hbW;
    }

    public g bAo() {
        return this.hdr;
    }

    public LinearLayout bAp() {
        return this.hdv;
    }

    public void setListViewSelection(int i) {
        this.OF.setSelection(i);
    }

    public RelativeLayout aBQ() {
        return this.mRootView;
    }
}
