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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gEL;
    private c gDs;
    private SignAllForumActivity gEM;
    private ViewGroup gEN;
    private SignAllForumProgressView gEO;
    private BdListView gEP;
    private g gEQ;
    private RelativeLayout gER;
    private TextView gES;
    private TextView gET;
    private LinearLayout gEU;
    private TextView gEV;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gEM = signAllForumActivity;
        this.gEM.setContentView(d.i.signallforum_view);
        this.gEN = (ViewGroup) this.gEM.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gEM.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gEM.getPageContext().getString(d.k.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gEM.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gEP = (BdListView) this.gEM.findViewById(d.g.signallforum_list);
        this.gEP.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.gEP.setPullRefresh(this.mPullView);
        this.gEV = (TextView) LayoutInflater.from(this.gEM.getPageContext().getPageActivity()).inflate(d.i.signallforum_maxcount_warning, (ViewGroup) null);
        this.gEP.addFooterView(this.gEV);
        this.gEO = new SignAllForumProgressView(this.gEM.getPageContext().getPageActivity());
        this.mProgressBar = this.gEO.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gEM);
        this.gEP.addHeaderView(this.gEO);
        this.gEO.setVisibility(8);
        this.gER = (RelativeLayout) this.gEO.findViewById(d.g.guidecontainer);
        this.gEU = (LinearLayout) this.gEO.findViewById(d.g.guideopenbtn);
        this.gES = (TextView) this.gEO.findViewById(d.g.guidetip);
        this.gET = (TextView) this.gEO.findViewById(d.g.guideopen);
        this.gEU.setOnClickListener(this.gEM);
        this.gEQ = new g(this.gEM, null);
        this.gEP.setAdapter((ListAdapter) this.gEQ);
        this.gEP.setOnScrollListener(this.gEQ);
    }

    public void onChangeSkinType(int i) {
        this.gEM.getLayoutMode().setNightMode(i == 1);
        this.gEM.getLayoutMode().onModeChanged(this.gEN);
        this.gEM.getLayoutMode().onModeChanged(this.gEV);
        this.gEM.getLayoutMode().onModeChanged(this.gEO);
        am.j(this.gEN, d.C0142d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dz(i);
        this.gEQ.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gDs = cVar;
            buw();
            ArrayList<d> btK = cVar.btK();
            this.gEQ.c(this.gDs);
            if (btK.size() == gEL) {
                this.gEV.setVisibility(0);
                this.gEV.setText(cVar.btH());
            } else {
                this.gEV.setVisibility(8);
            }
            String btB = this.gDs.btB();
            if (!StringUtils.isNull(btB)) {
                this.gEO.a(this.gEM, btB, this.gDs.btC());
                return;
            }
            this.gEO.buu();
        }
    }

    private void buw() {
        if (this.gDs != null) {
            this.gEO.setHasPrivilege(this.gDs.btO());
            this.gEO.setmCurrentStatus(this.gDs.btQ());
            TextView message1 = this.gEO.getMessage1();
            SpannableString spannableString = new SpannableString(this.gDs.btE() + this.gDs.bhP() + this.gDs.btF());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0142d.common_color_10191));
            int length = this.gDs.btE().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gDs.bhP().length() + length, 33);
            message1.setText(spannableString);
            this.gEO.getMessage2().setText(this.gDs.btG());
            this.gES.setText(this.gDs.getContent());
            if (TextUtils.isEmpty(this.gDs.btP())) {
                this.gET.setText(d.k.member_buy_open);
            } else {
                this.gET.setText(this.gDs.btP());
            }
            this.gEO.setVisibility(0);
            if (this.gDs.btO() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gER.setVisibility(8);
            } else {
                this.gER.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gEP.startPullRefresh();
    }

    public void nW() {
        this.gEP.completePullRefreshPostDelayed(2000L);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gEP.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView bux() {
        return this.gEO;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView buy() {
        return this.gEP;
    }

    public c buz() {
        return this.gDs;
    }

    public g buA() {
        return this.gEQ;
    }

    public LinearLayout buB() {
        return this.gEU;
    }

    public void setListViewSelection(int i) {
        this.gEP.setSelection(i);
    }
}
