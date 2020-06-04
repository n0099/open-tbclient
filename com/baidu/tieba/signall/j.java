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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int leo;
    private BdListView Um;
    private c lcS;
    private SignAllForumActivity lep;
    private SignAllForumProgressView leq;
    private g ler;
    private RelativeLayout les;
    private TextView let;
    private TextView leu;
    private LinearLayout lev;
    private TextView lew;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.lep = signAllForumActivity;
        this.lep.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.lep.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.lep.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.lep.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.lep.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Um = (BdListView) this.lep.findViewById(R.id.signallforum_list);
        this.Um.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.Um.setPullRefresh(this.mPullView);
        this.lew = (TextView) LayoutInflater.from(this.lep.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Um.addFooterView(this.lew);
        this.leq = new SignAllForumProgressView(this.lep.getPageContext().getPageActivity());
        this.mProgressBar = this.leq.getProgressBar();
        this.mProgressBar.setOnClickListener(this.lep);
        this.Um.addHeaderView(this.leq);
        this.leq.setVisibility(8);
        this.les = (RelativeLayout) this.leq.findViewById(R.id.guidecontainer);
        this.lev = (LinearLayout) this.leq.findViewById(R.id.guideopenbtn);
        this.let = (TextView) this.leq.findViewById(R.id.guidetip);
        this.leu = (TextView) this.leq.findViewById(R.id.guideopen);
        this.lev.setOnClickListener(this.lep);
        this.ler = new g(this.lep, null);
        this.Um.setAdapter((ListAdapter) this.ler);
        this.Um.setOnScrollListener(this.ler);
    }

    public void onChangeSkinType(int i) {
        this.lep.getLayoutMode().setNightMode(i == 1);
        this.lep.getLayoutMode().onModeChanged(this.mRootView);
        this.lep.getLayoutMode().onModeChanged(this.lew);
        this.lep.getLayoutMode().onModeChanged(this.leq);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.leq != null) {
            this.leq.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.ler.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lcS = cVar;
            dbA();
            ArrayList<d> daN = cVar.daN();
            this.ler.c(this.lcS);
            if (daN.size() == leo) {
                this.lew.setVisibility(0);
                this.lew.setText(cVar.daK());
            } else {
                this.lew.setVisibility(8);
            }
            String daE = this.lcS.daE();
            if (!StringUtils.isNull(daE)) {
                this.leq.a(this.lep, daE, this.lcS.daF());
                return;
            }
            this.leq.dbz();
        }
    }

    private void dbA() {
        if (this.lcS != null) {
            this.leq.setHasPrivilege(this.lcS.daR());
            this.leq.setmCurrentStatus(this.lcS.daT());
            TextView message1 = this.leq.getMessage1();
            SpannableString spannableString = new SpannableString(this.lcS.daH() + this.lcS.cKx() + this.lcS.daI());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lcS.daH().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lcS.cKx().length() + length, 33);
            message1.setText(spannableString);
            this.leq.getMessage2().setText(this.lcS.daJ());
            this.let.setText(this.lcS.getContent());
            if (TextUtils.isEmpty(this.lcS.daS())) {
                this.leu.setText(R.string.member_buy_open);
            } else {
                this.leu.setText(this.lcS.daS());
            }
            this.leq.setVisibility(0);
            if (this.lcS.daR() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.les.setVisibility(8);
            } else {
                this.les.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Um.startPullRefresh();
    }

    public void completeRefresh() {
        this.Um.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Um.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dbB() {
        return this.leq;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dbC() {
        return this.Um;
    }

    public c dbD() {
        return this.lcS;
    }

    public g dbE() {
        return this.ler;
    }

    public LinearLayout dbF() {
        return this.lev;
    }

    public void setListViewSelection(int i) {
        this.Um.setSelection(i);
    }

    public RelativeLayout bIN() {
        return this.mRootView;
    }
}
