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
    public static int jYF;
    private BdListView Ao;
    private c jXn;
    private SignAllForumActivity jYG;
    private SignAllForumProgressView jYH;
    private g jYI;
    private RelativeLayout jYJ;
    private TextView jYK;
    private TextView jYL;
    private LinearLayout jYM;
    private TextView jYN;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jYG = signAllForumActivity;
        this.jYG.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jYG.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jYG.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jYG.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jYG.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Ao = (BdListView) this.jYG.findViewById(R.id.signallforum_list);
        this.Ao.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.Ao.setPullRefresh(this.mPullView);
        this.jYN = (TextView) LayoutInflater.from(this.jYG.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Ao.addFooterView(this.jYN);
        this.jYH = new SignAllForumProgressView(this.jYG.getPageContext().getPageActivity());
        this.mProgressBar = this.jYH.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jYG);
        this.Ao.addHeaderView(this.jYH);
        this.jYH.setVisibility(8);
        this.jYJ = (RelativeLayout) this.jYH.findViewById(R.id.guidecontainer);
        this.jYM = (LinearLayout) this.jYH.findViewById(R.id.guideopenbtn);
        this.jYK = (TextView) this.jYH.findViewById(R.id.guidetip);
        this.jYL = (TextView) this.jYH.findViewById(R.id.guideopen);
        this.jYM.setOnClickListener(this.jYG);
        this.jYI = new g(this.jYG, null);
        this.Ao.setAdapter((ListAdapter) this.jYI);
        this.Ao.setOnScrollListener(this.jYI);
    }

    public void onChangeSkinType(int i) {
        this.jYG.getLayoutMode().setNightMode(i == 1);
        this.jYG.getLayoutMode().onModeChanged(this.mRootView);
        this.jYG.getLayoutMode().onModeChanged(this.jYN);
        this.jYG.getLayoutMode().onModeChanged(this.jYH);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jYH != null) {
            this.jYH.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jYI.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jXn = cVar;
            cHD();
            ArrayList<d> cGR = cVar.cGR();
            this.jYI.c(this.jXn);
            if (cGR.size() == jYF) {
                this.jYN.setVisibility(0);
                this.jYN.setText(cVar.cGO());
            } else {
                this.jYN.setVisibility(8);
            }
            String cGI = this.jXn.cGI();
            if (!StringUtils.isNull(cGI)) {
                this.jYH.a(this.jYG, cGI, this.jXn.cGJ());
                return;
            }
            this.jYH.cHC();
        }
    }

    private void cHD() {
        if (this.jXn != null) {
            this.jYH.setHasPrivilege(this.jXn.cGV());
            this.jYH.setmCurrentStatus(this.jXn.cGX());
            TextView message1 = this.jYH.getMessage1();
            SpannableString spannableString = new SpannableString(this.jXn.cGL() + this.jXn.cqR() + this.jXn.cGM());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jXn.cGL().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jXn.cqR().length() + length, 33);
            message1.setText(spannableString);
            this.jYH.getMessage2().setText(this.jXn.cGN());
            this.jYK.setText(this.jXn.getContent());
            if (TextUtils.isEmpty(this.jXn.cGW())) {
                this.jYL.setText(R.string.member_buy_open);
            } else {
                this.jYL.setText(this.jXn.cGW());
            }
            this.jYH.setVisibility(0);
            if (this.jXn.cGV() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jYJ.setVisibility(8);
            } else {
                this.jYJ.setVisibility(0);
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

    public SignAllForumProgressView cHE() {
        return this.jYH;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cHF() {
        return this.Ao;
    }

    public c cHG() {
        return this.jXn;
    }

    public g cHH() {
        return this.jYI;
    }

    public LinearLayout cHI() {
        return this.jYM;
    }

    public void setListViewSelection(int i) {
        this.Ao.setSelection(i);
    }

    public RelativeLayout bqY() {
        return this.mRootView;
    }
}
