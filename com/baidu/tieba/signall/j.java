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
    public static int iyS;
    private BdListView Pj;
    private c ixA;
    private SignAllForumActivity iyT;
    private SignAllForumProgressView iyU;
    private g iyV;
    private RelativeLayout iyW;
    private TextView iyX;
    private TextView iyY;
    private LinearLayout iyZ;
    private TextView iza;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iyT = signAllForumActivity;
        this.iyT.setContentView(d.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.iyT.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iyT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iyT.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iyT.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Pj = (BdListView) this.iyT.findViewById(d.g.signallforum_list);
        this.Pj.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.Pj.setPullRefresh(this.mPullView);
        this.iza = (TextView) LayoutInflater.from(this.iyT.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.Pj.addFooterView(this.iza);
        this.iyU = new SignAllForumProgressView(this.iyT.getPageContext().getPageActivity());
        this.mProgressBar = this.iyU.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iyT);
        this.Pj.addHeaderView(this.iyU);
        this.iyU.setVisibility(8);
        this.iyW = (RelativeLayout) this.iyU.findViewById(d.g.guidecontainer);
        this.iyZ = (LinearLayout) this.iyU.findViewById(d.g.guideopenbtn);
        this.iyX = (TextView) this.iyU.findViewById(d.g.guidetip);
        this.iyY = (TextView) this.iyU.findViewById(d.g.guideopen);
        this.iyZ.setOnClickListener(this.iyT);
        this.iyV = new g(this.iyT, null);
        this.Pj.setAdapter((ListAdapter) this.iyV);
        this.Pj.setOnScrollListener(this.iyV);
    }

    public void onChangeSkinType(int i) {
        this.iyT.getLayoutMode().setNightMode(i == 1);
        this.iyT.getLayoutMode().onModeChanged(this.mRootView);
        this.iyT.getLayoutMode().onModeChanged(this.iza);
        this.iyT.getLayoutMode().onModeChanged(this.iyU);
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ib(i);
        this.iyV.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.ixA = cVar;
            ccw();
            ArrayList<d> cbJ = cVar.cbJ();
            this.iyV.c(this.ixA);
            if (cbJ.size() == iyS) {
                this.iza.setVisibility(0);
                this.iza.setText(cVar.cbG());
            } else {
                this.iza.setVisibility(8);
            }
            String cbA = this.ixA.cbA();
            if (!StringUtils.isNull(cbA)) {
                this.iyU.a(this.iyT, cbA, this.ixA.cbB());
                return;
            }
            this.iyU.ccu();
        }
    }

    private void ccw() {
        if (this.ixA != null) {
            this.iyU.setHasPrivilege(this.ixA.cbN());
            this.iyU.setmCurrentStatus(this.ixA.cbP());
            TextView message1 = this.iyU.getMessage1();
            SpannableString spannableString = new SpannableString(this.ixA.cbD() + this.ixA.bOU() + this.ixA.cbE());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0277d.common_color_10191));
            int length = this.ixA.cbD().length();
            spannableString.setSpan(foregroundColorSpan, length, this.ixA.bOU().length() + length, 33);
            message1.setText(spannableString);
            this.iyU.getMessage2().setText(this.ixA.cbF());
            this.iyX.setText(this.ixA.getContent());
            if (TextUtils.isEmpty(this.ixA.cbO())) {
                this.iyY.setText(d.j.member_buy_open);
            } else {
                this.iyY.setText(this.ixA.cbO());
            }
            this.iyU.setVisibility(0);
            if (this.ixA.cbN() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iyW.setVisibility(8);
            } else {
                this.iyW.setVisibility(0);
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
        return this.iyU;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ccy() {
        return this.Pj;
    }

    public c ccz() {
        return this.ixA;
    }

    public g ccA() {
        return this.iyV;
    }

    public LinearLayout ccB() {
        return this.iyZ;
    }

    public void setListViewSelection(int i) {
        this.Pj.setSelection(i);
    }

    public RelativeLayout bdJ() {
        return this.mRootView;
    }
}
