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
    public static int iyR;
    private BdListView Pj;
    private c ixz;
    private SignAllForumActivity iyS;
    private SignAllForumProgressView iyT;
    private g iyU;
    private RelativeLayout iyV;
    private TextView iyW;
    private TextView iyX;
    private LinearLayout iyY;
    private TextView iyZ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iyS = signAllForumActivity;
        this.iyS.setContentView(d.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.iyS.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iyS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iyS.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iyS.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Pj = (BdListView) this.iyS.findViewById(d.g.signallforum_list);
        this.Pj.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.iyZ = (TextView) LayoutInflater.from(this.iyS.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.Pj.addFooterView(this.iyZ);
        this.iyT = new SignAllForumProgressView(this.iyS.getPageContext().getPageActivity());
        this.mProgressBar = this.iyT.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iyS);
        this.Pj.addHeaderView(this.iyT);
        this.iyT.setVisibility(8);
        this.iyV = (RelativeLayout) this.iyT.findViewById(d.g.guidecontainer);
        this.iyY = (LinearLayout) this.iyT.findViewById(d.g.guideopenbtn);
        this.iyW = (TextView) this.iyT.findViewById(d.g.guidetip);
        this.iyX = (TextView) this.iyT.findViewById(d.g.guideopen);
        this.iyY.setOnClickListener(this.iyS);
        this.iyU = new g(this.iyS, null);
        this.Pj.setAdapter((ListAdapter) this.iyU);
        this.Pj.setOnScrollListener(this.iyU);
    }

    public void onChangeSkinType(int i) {
        this.iyS.getLayoutMode().setNightMode(i == 1);
        this.iyS.getLayoutMode().onModeChanged(this.mRootView);
        this.iyS.getLayoutMode().onModeChanged(this.iyZ);
        this.iyS.getLayoutMode().onModeChanged(this.iyT);
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ib(i);
        this.iyU.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.ixz = cVar;
            ccw();
            ArrayList<d> cbJ = cVar.cbJ();
            this.iyU.c(this.ixz);
            if (cbJ.size() == iyR) {
                this.iyZ.setVisibility(0);
                this.iyZ.setText(cVar.cbG());
            } else {
                this.iyZ.setVisibility(8);
            }
            String cbA = this.ixz.cbA();
            if (!StringUtils.isNull(cbA)) {
                this.iyT.a(this.iyS, cbA, this.ixz.cbB());
                return;
            }
            this.iyT.ccu();
        }
    }

    private void ccw() {
        if (this.ixz != null) {
            this.iyT.setHasPrivilege(this.ixz.cbN());
            this.iyT.setmCurrentStatus(this.ixz.cbP());
            TextView message1 = this.iyT.getMessage1();
            SpannableString spannableString = new SpannableString(this.ixz.cbD() + this.ixz.bOU() + this.ixz.cbE());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0277d.common_color_10191));
            int length = this.ixz.cbD().length();
            spannableString.setSpan(foregroundColorSpan, length, this.ixz.bOU().length() + length, 33);
            message1.setText(spannableString);
            this.iyT.getMessage2().setText(this.ixz.cbF());
            this.iyW.setText(this.ixz.getContent());
            if (TextUtils.isEmpty(this.ixz.cbO())) {
                this.iyX.setText(d.j.member_buy_open);
            } else {
                this.iyX.setText(this.ixz.cbO());
            }
            this.iyT.setVisibility(0);
            if (this.ixz.cbN() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iyV.setVisibility(8);
            } else {
                this.iyV.setVisibility(0);
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

    public SignAllForumProgressView ccx() {
        return this.iyT;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ccy() {
        return this.Pj;
    }

    public c ccz() {
        return this.ixz;
    }

    public g ccA() {
        return this.iyU;
    }

    public LinearLayout ccB() {
        return this.iyY;
    }

    public void setListViewSelection(int i) {
        this.Pj.setSelection(i);
    }

    public RelativeLayout bdJ() {
        return this.mRootView;
    }
}
