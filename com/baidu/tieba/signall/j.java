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
    public static int jaB;
    private c iZk;
    private SignAllForumActivity jaC;
    private SignAllForumProgressView jaD;
    private g jaE;
    private RelativeLayout jaF;
    private TextView jaG;
    private TextView jaH;
    private LinearLayout jaI;
    private TextView jaJ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;
    private BdListView xL;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jaC = signAllForumActivity;
        this.jaC.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jaC.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jaC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jaC.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jaC.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.xL = (BdListView) this.jaC.findViewById(R.id.signallforum_list);
        this.xL.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.xL.setPullRefresh(this.mPullView);
        this.jaJ = (TextView) LayoutInflater.from(this.jaC.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.xL.addFooterView(this.jaJ);
        this.jaD = new SignAllForumProgressView(this.jaC.getPageContext().getPageActivity());
        this.mProgressBar = this.jaD.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jaC);
        this.xL.addHeaderView(this.jaD);
        this.jaD.setVisibility(8);
        this.jaF = (RelativeLayout) this.jaD.findViewById(R.id.guidecontainer);
        this.jaI = (LinearLayout) this.jaD.findViewById(R.id.guideopenbtn);
        this.jaG = (TextView) this.jaD.findViewById(R.id.guidetip);
        this.jaH = (TextView) this.jaD.findViewById(R.id.guideopen);
        this.jaI.setOnClickListener(this.jaC);
        this.jaE = new g(this.jaC, null);
        this.xL.setAdapter((ListAdapter) this.jaE);
        this.xL.setOnScrollListener(this.jaE);
    }

    public void onChangeSkinType(int i) {
        this.jaC.getLayoutMode().setNightMode(i == 1);
        this.jaC.getLayoutMode().onModeChanged(this.mRootView);
        this.jaC.getLayoutMode().onModeChanged(this.jaJ);
        this.jaC.getLayoutMode().onModeChanged(this.jaD);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jaD != null) {
            this.jaD.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jaE.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.iZk = cVar;
            cmn();
            ArrayList<d> clB = cVar.clB();
            this.jaE.c(this.iZk);
            if (clB.size() == jaB) {
                this.jaJ.setVisibility(0);
                this.jaJ.setText(cVar.cly());
            } else {
                this.jaJ.setVisibility(8);
            }
            String cls = this.iZk.cls();
            if (!StringUtils.isNull(cls)) {
                this.jaD.a(this.jaC, cls, this.iZk.clt());
                return;
            }
            this.jaD.cmm();
        }
    }

    private void cmn() {
        if (this.iZk != null) {
            this.jaD.setHasPrivilege(this.iZk.clF());
            this.jaD.setmCurrentStatus(this.iZk.clH());
            TextView message1 = this.jaD.getMessage1();
            SpannableString spannableString = new SpannableString(this.iZk.clv() + this.iZk.bXM() + this.iZk.clw());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.iZk.clv().length();
            spannableString.setSpan(foregroundColorSpan, length, this.iZk.bXM().length() + length, 33);
            message1.setText(spannableString);
            this.jaD.getMessage2().setText(this.iZk.clx());
            this.jaG.setText(this.iZk.getContent());
            if (TextUtils.isEmpty(this.iZk.clG())) {
                this.jaH.setText(R.string.member_buy_open);
            } else {
                this.jaH.setText(this.iZk.clG());
            }
            this.jaD.setVisibility(0);
            if (this.iZk.clF() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jaF.setVisibility(8);
            } else {
                this.jaF.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.xL.startPullRefresh();
    }

    public void completeRefresh() {
        this.xL.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.xL.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cmo() {
        return this.jaD;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cmp() {
        return this.xL;
    }

    public c cmq() {
        return this.iZk;
    }

    public g cmr() {
        return this.jaE;
    }

    public LinearLayout cms() {
        return this.jaI;
    }

    public void setListViewSelection(int i) {
        this.xL.setSelection(i);
    }

    public RelativeLayout aYb() {
        return this.mRootView;
    }
}
