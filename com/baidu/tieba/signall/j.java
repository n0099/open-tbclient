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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int izh;
    private BdListView Pj;
    private c ixP;
    private SignAllForumActivity izi;
    private SignAllForumProgressView izj;
    private g izk;
    private RelativeLayout izl;
    private TextView izm;
    private TextView izn;
    private LinearLayout izo;
    private TextView izp;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.izi = signAllForumActivity;
        this.izi.setContentView(d.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.izi.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.izi.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.izi.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.izi.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Pj = (BdListView) this.izi.findViewById(d.g.signallforum_list);
        this.Pj.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.izp = (TextView) LayoutInflater.from(this.izi.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.Pj.addFooterView(this.izp);
        this.izj = new SignAllForumProgressView(this.izi.getPageContext().getPageActivity());
        this.mProgressBar = this.izj.getProgressBar();
        this.mProgressBar.setOnClickListener(this.izi);
        this.Pj.addHeaderView(this.izj);
        this.izj.setVisibility(8);
        this.izl = (RelativeLayout) this.izj.findViewById(d.g.guidecontainer);
        this.izo = (LinearLayout) this.izj.findViewById(d.g.guideopenbtn);
        this.izm = (TextView) this.izj.findViewById(d.g.guidetip);
        this.izn = (TextView) this.izj.findViewById(d.g.guideopen);
        this.izo.setOnClickListener(this.izi);
        this.izk = new g(this.izi, null);
        this.Pj.setAdapter((ListAdapter) this.izk);
        this.Pj.setOnScrollListener(this.izk);
    }

    public void onChangeSkinType(int i) {
        this.izi.getLayoutMode().setNightMode(i == 1);
        this.izi.getLayoutMode().onModeChanged(this.mRootView);
        this.izi.getLayoutMode().onModeChanged(this.izp);
        this.izi.getLayoutMode().onModeChanged(this.izj);
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ic(i);
        this.izk.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.ixP = cVar;
            ccA();
            ArrayList<d> cbN = cVar.cbN();
            this.izk.c(this.ixP);
            if (cbN.size() == izh) {
                this.izp.setVisibility(0);
                this.izp.setText(cVar.cbK());
            } else {
                this.izp.setVisibility(8);
            }
            String cbE = this.ixP.cbE();
            if (!StringUtils.isNull(cbE)) {
                this.izj.a(this.izi, cbE, this.ixP.cbF());
                return;
            }
            this.izj.ccy();
        }
    }

    private void ccA() {
        if (this.ixP != null) {
            this.izj.setHasPrivilege(this.ixP.cbR());
            this.izj.setmCurrentStatus(this.ixP.cbT());
            TextView message1 = this.izj.getMessage1();
            SpannableString spannableString = new SpannableString(this.ixP.cbH() + this.ixP.bOX() + this.ixP.cbI());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0277d.common_color_10191));
            int length = this.ixP.cbH().length();
            spannableString.setSpan(foregroundColorSpan, length, this.ixP.bOX().length() + length, 33);
            message1.setText(spannableString);
            this.izj.getMessage2().setText(this.ixP.cbJ());
            this.izm.setText(this.ixP.getContent());
            if (TextUtils.isEmpty(this.ixP.cbS())) {
                this.izn.setText(d.j.member_buy_open);
            } else {
                this.izn.setText(this.ixP.cbS());
            }
            this.izj.setVisibility(0);
            if (this.ixP.cbR() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.izl.setVisibility(8);
            } else {
                this.izl.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Pj.startPullRefresh();
    }

    public void pD() {
        this.Pj.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Pj.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView ccB() {
        return this.izj;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ccC() {
        return this.Pj;
    }

    public c ccD() {
        return this.ixP;
    }

    public g ccE() {
        return this.izk;
    }

    public LinearLayout ccF() {
        return this.izo;
    }

    public void setListViewSelection(int i) {
        this.Pj.setSelection(i);
    }

    public RelativeLayout bdL() {
        return this.mRootView;
    }
}
