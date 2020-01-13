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
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int jYA;
    private BdListView Ao;
    private c jXi;
    private SignAllForumActivity jYB;
    private SignAllForumProgressView jYC;
    private g jYD;
    private RelativeLayout jYE;
    private TextView jYF;
    private TextView jYG;
    private LinearLayout jYH;
    private TextView jYI;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jYB = signAllForumActivity;
        this.jYB.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jYB.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jYB.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jYB.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jYB.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Ao = (BdListView) this.jYB.findViewById(R.id.signallforum_list);
        this.Ao.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.Ao.setPullRefresh(this.mPullView);
        this.jYI = (TextView) LayoutInflater.from(this.jYB.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Ao.addFooterView(this.jYI);
        this.jYC = new SignAllForumProgressView(this.jYB.getPageContext().getPageActivity());
        this.mProgressBar = this.jYC.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jYB);
        this.Ao.addHeaderView(this.jYC);
        this.jYC.setVisibility(8);
        this.jYE = (RelativeLayout) this.jYC.findViewById(R.id.guidecontainer);
        this.jYH = (LinearLayout) this.jYC.findViewById(R.id.guideopenbtn);
        this.jYF = (TextView) this.jYC.findViewById(R.id.guidetip);
        this.jYG = (TextView) this.jYC.findViewById(R.id.guideopen);
        this.jYH.setOnClickListener(this.jYB);
        this.jYD = new g(this.jYB, null);
        this.Ao.setAdapter((ListAdapter) this.jYD);
        this.Ao.setOnScrollListener(this.jYD);
    }

    public void onChangeSkinType(int i) {
        this.jYB.getLayoutMode().setNightMode(i == 1);
        this.jYB.getLayoutMode().onModeChanged(this.mRootView);
        this.jYB.getLayoutMode().onModeChanged(this.jYI);
        this.jYB.getLayoutMode().onModeChanged(this.jYC);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jYC != null) {
            this.jYC.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jYD.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jXi = cVar;
            cHB();
            ArrayList<d> cGP = cVar.cGP();
            this.jYD.c(this.jXi);
            if (cGP.size() == jYA) {
                this.jYI.setVisibility(0);
                this.jYI.setText(cVar.cGM());
            } else {
                this.jYI.setVisibility(8);
            }
            String cGG = this.jXi.cGG();
            if (!StringUtils.isNull(cGG)) {
                this.jYC.a(this.jYB, cGG, this.jXi.cGH());
                return;
            }
            this.jYC.cHA();
        }
    }

    private void cHB() {
        if (this.jXi != null) {
            this.jYC.setHasPrivilege(this.jXi.cGT());
            this.jYC.setmCurrentStatus(this.jXi.cGV());
            TextView message1 = this.jYC.getMessage1();
            SpannableString spannableString = new SpannableString(this.jXi.cGJ() + this.jXi.cqP() + this.jXi.cGK());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jXi.cGJ().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jXi.cqP().length() + length, 33);
            message1.setText(spannableString);
            this.jYC.getMessage2().setText(this.jXi.cGL());
            this.jYF.setText(this.jXi.getContent());
            if (TextUtils.isEmpty(this.jXi.cGU())) {
                this.jYG.setText(R.string.member_buy_open);
            } else {
                this.jYG.setText(this.jXi.cGU());
            }
            this.jYC.setVisibility(0);
            if (this.jXi.cGT() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jYE.setVisibility(8);
            } else {
                this.jYE.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Ao.startPullRefresh();
    }

    public void completeRefresh() {
        this.Ao.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Ao.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cHC() {
        return this.jYC;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cHD() {
        return this.Ao;
    }

    public c cHE() {
        return this.jXi;
    }

    public g cHF() {
        return this.jYD;
    }

    public LinearLayout cHG() {
        return this.jYH;
    }

    public void setListViewSelection(int i) {
        this.Ao.setSelection(i);
    }

    public RelativeLayout bqY() {
        return this.mRootView;
    }
}
