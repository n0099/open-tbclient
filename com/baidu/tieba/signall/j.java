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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int jbB;
    private BdListView Nj;
    private c jaj;
    private SignAllForumActivity jbC;
    private SignAllForumProgressView jbD;
    private g jbE;
    private RelativeLayout jbF;
    private TextView jbG;
    private TextView jbH;
    private LinearLayout jbI;
    private TextView jbJ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jbC = signAllForumActivity;
        this.jbC.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jbC.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jbC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jbC.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jbC.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Nj = (BdListView) this.jbC.findViewById(R.id.signallforum_list);
        this.Nj.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.Nj.setPullRefresh(this.mPullView);
        this.jbJ = (TextView) LayoutInflater.from(this.jbC.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Nj.addFooterView(this.jbJ);
        this.jbD = new SignAllForumProgressView(this.jbC.getPageContext().getPageActivity());
        this.mProgressBar = this.jbD.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jbC);
        this.Nj.addHeaderView(this.jbD);
        this.jbD.setVisibility(8);
        this.jbF = (RelativeLayout) this.jbD.findViewById(R.id.guidecontainer);
        this.jbI = (LinearLayout) this.jbD.findViewById(R.id.guideopenbtn);
        this.jbG = (TextView) this.jbD.findViewById(R.id.guidetip);
        this.jbH = (TextView) this.jbD.findViewById(R.id.guideopen);
        this.jbI.setOnClickListener(this.jbC);
        this.jbE = new g(this.jbC, null);
        this.Nj.setAdapter((ListAdapter) this.jbE);
        this.Nj.setOnScrollListener(this.jbE);
    }

    public void onChangeSkinType(int i) {
        this.jbC.getLayoutMode().setNightMode(i == 1);
        this.jbC.getLayoutMode().onModeChanged(this.mRootView);
        this.jbC.getLayoutMode().onModeChanged(this.jbJ);
        this.jbC.getLayoutMode().onModeChanged(this.jbD);
        am.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jbD != null) {
            this.jbD.onChangeSkinType();
        }
        this.mPullView.iY(i);
        this.jbE.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jaj = cVar;
            coz();
            ArrayList<d> cnN = cVar.cnN();
            this.jbE.c(this.jaj);
            if (cnN.size() == jbB) {
                this.jbJ.setVisibility(0);
                this.jbJ.setText(cVar.cnK());
            } else {
                this.jbJ.setVisibility(8);
            }
            String cnE = this.jaj.cnE();
            if (!StringUtils.isNull(cnE)) {
                this.jbD.a(this.jbC, cnE, this.jaj.cnF());
                return;
            }
            this.jbD.coy();
        }
    }

    private void coz() {
        if (this.jaj != null) {
            this.jbD.setHasPrivilege(this.jaj.cnR());
            this.jbD.setmCurrentStatus(this.jaj.cnT());
            TextView message1 = this.jbD.getMessage1();
            SpannableString spannableString = new SpannableString(this.jaj.cnH() + this.jaj.caL() + this.jaj.cnI());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jaj.cnH().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jaj.caL().length() + length, 33);
            message1.setText(spannableString);
            this.jbD.getMessage2().setText(this.jaj.cnJ());
            this.jbG.setText(this.jaj.getContent());
            if (TextUtils.isEmpty(this.jaj.cnS())) {
                this.jbH.setText(R.string.member_buy_open);
            } else {
                this.jbH.setText(this.jaj.cnS());
            }
            this.jbD.setVisibility(0);
            if (this.jaj.cnR() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jbF.setVisibility(8);
            } else {
                this.jbF.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Nj.startPullRefresh();
    }

    public void oU() {
        this.Nj.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Nj.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView coA() {
        return this.jbD;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView coB() {
        return this.Nj;
    }

    public c coC() {
        return this.jaj;
    }

    public g coD() {
        return this.jbE;
    }

    public LinearLayout coE() {
        return this.jbI;
    }

    public void setListViewSelection(int i) {
        this.Nj.setSelection(i);
    }

    public RelativeLayout aYe() {
        return this.mRootView;
    }
}
