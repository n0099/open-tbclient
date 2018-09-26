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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.e;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gNA;
    private BdListView Op;
    private c gMg;
    private SignAllForumActivity gNB;
    private SignAllForumProgressView gNC;
    private g gND;
    private RelativeLayout gNE;
    private TextView gNF;
    private TextView gNG;
    private LinearLayout gNH;
    private TextView gNI;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gNB = signAllForumActivity;
        this.gNB.setContentView(e.h.signallforum_view);
        this.mRootView = (RelativeLayout) this.gNB.findViewById(e.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gNB.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gNB.getPageContext().getString(e.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gNB.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Op = (BdListView) this.gNB.findViewById(e.g.signallforum_list);
        this.Op.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.Op.setPullRefresh(this.mPullView);
        this.gNI = (TextView) LayoutInflater.from(this.gNB.getPageContext().getPageActivity()).inflate(e.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.Op.addFooterView(this.gNI);
        this.gNC = new SignAllForumProgressView(this.gNB.getPageContext().getPageActivity());
        this.mProgressBar = this.gNC.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gNB);
        this.Op.addHeaderView(this.gNC);
        this.gNC.setVisibility(8);
        this.gNE = (RelativeLayout) this.gNC.findViewById(e.g.guidecontainer);
        this.gNH = (LinearLayout) this.gNC.findViewById(e.g.guideopenbtn);
        this.gNF = (TextView) this.gNC.findViewById(e.g.guidetip);
        this.gNG = (TextView) this.gNC.findViewById(e.g.guideopen);
        this.gNH.setOnClickListener(this.gNB);
        this.gND = new g(this.gNB, null);
        this.Op.setAdapter((ListAdapter) this.gND);
        this.Op.setOnScrollListener(this.gND);
    }

    public void onChangeSkinType(int i) {
        this.gNB.getLayoutMode().setNightMode(i == 1);
        this.gNB.getLayoutMode().onModeChanged(this.mRootView);
        this.gNB.getLayoutMode().onModeChanged(this.gNI);
        this.gNB.getLayoutMode().onModeChanged(this.gNC);
        al.j(this.mRootView, e.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dM(i);
        this.gND.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gMg = cVar;
            bvG();
            ArrayList<d> buT = cVar.buT();
            this.gND.c(this.gMg);
            if (buT.size() == gNA) {
                this.gNI.setVisibility(0);
                this.gNI.setText(cVar.buQ());
            } else {
                this.gNI.setVisibility(8);
            }
            String buK = this.gMg.buK();
            if (!StringUtils.isNull(buK)) {
                this.gNC.a(this.gNB, buK, this.gMg.buL());
                return;
            }
            this.gNC.bvE();
        }
    }

    private void bvG() {
        if (this.gMg != null) {
            this.gNC.setHasPrivilege(this.gMg.buX());
            this.gNC.setmCurrentStatus(this.gMg.buZ());
            TextView message1 = this.gNC.getMessage1();
            SpannableString spannableString = new SpannableString(this.gMg.buN() + this.gMg.biG() + this.gMg.buO());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(e.d.common_color_10191));
            int length = this.gMg.buN().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gMg.biG().length() + length, 33);
            message1.setText(spannableString);
            this.gNC.getMessage2().setText(this.gMg.buP());
            this.gNF.setText(this.gMg.getContent());
            if (TextUtils.isEmpty(this.gMg.buY())) {
                this.gNG.setText(e.j.member_buy_open);
            } else {
                this.gNG.setText(this.gMg.buY());
            }
            this.gNC.setVisibility(0);
            if (this.gMg.buX() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gNE.setVisibility(8);
            } else {
                this.gNE.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Op.startPullRefresh();
    }

    public void pb() {
        this.Op.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Op.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView bvH() {
        return this.gNC;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bvI() {
        return this.Op;
    }

    public c bvJ() {
        return this.gMg;
    }

    public g bvK() {
        return this.gND;
    }

    public LinearLayout bvL() {
        return this.gNH;
    }

    public void setListViewSelection(int i) {
        this.Op.setSelection(i);
    }

    public RelativeLayout axn() {
        return this.mRootView;
    }
}
