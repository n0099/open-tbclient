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
/* loaded from: classes11.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int kKK;
    private BdListView TX;
    private c kJp;
    private SignAllForumActivity kKL;
    private SignAllForumProgressView kKM;
    private g kKN;
    private RelativeLayout kKO;
    private TextView kKP;
    private TextView kKQ;
    private LinearLayout kKR;
    private TextView kKS;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.kKL = signAllForumActivity;
        this.kKL.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.kKL.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.kKL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kKL.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.kKL.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.TX = (BdListView) this.kKL.findViewById(R.id.signallforum_list);
        this.TX.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.TX.setPullRefresh(this.mPullView);
        this.kKS = (TextView) LayoutInflater.from(this.kKL.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.TX.addFooterView(this.kKS);
        this.kKM = new SignAllForumProgressView(this.kKL.getPageContext().getPageActivity());
        this.mProgressBar = this.kKM.getProgressBar();
        this.mProgressBar.setOnClickListener(this.kKL);
        this.TX.addHeaderView(this.kKM);
        this.kKM.setVisibility(8);
        this.kKO = (RelativeLayout) this.kKM.findViewById(R.id.guidecontainer);
        this.kKR = (LinearLayout) this.kKM.findViewById(R.id.guideopenbtn);
        this.kKP = (TextView) this.kKM.findViewById(R.id.guidetip);
        this.kKQ = (TextView) this.kKM.findViewById(R.id.guideopen);
        this.kKR.setOnClickListener(this.kKL);
        this.kKN = new g(this.kKL, null);
        this.TX.setAdapter((ListAdapter) this.kKN);
        this.TX.setOnScrollListener(this.kKN);
    }

    public void onChangeSkinType(int i) {
        this.kKL.getLayoutMode().setNightMode(i == 1);
        this.kKL.getLayoutMode().onModeChanged(this.mRootView);
        this.kKL.getLayoutMode().onModeChanged(this.kKS);
        this.kKL.getLayoutMode().onModeChanged(this.kKM);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kKM != null) {
            this.kKM.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.kKN.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.kJp = cVar;
            cUi();
            ArrayList<d> cTv = cVar.cTv();
            this.kKN.c(this.kJp);
            if (cTv.size() == kKK) {
                this.kKS.setVisibility(0);
                this.kKS.setText(cVar.cTs());
            } else {
                this.kKS.setVisibility(8);
            }
            String cTm = this.kJp.cTm();
            if (!StringUtils.isNull(cTm)) {
                this.kKM.a(this.kKL, cTm, this.kJp.cTn());
                return;
            }
            this.kKM.cUh();
        }
    }

    private void cUi() {
        if (this.kJp != null) {
            this.kKM.setHasPrivilege(this.kJp.cTz());
            this.kKM.setmCurrentStatus(this.kJp.cTB());
            TextView message1 = this.kKM.getMessage1();
            SpannableString spannableString = new SpannableString(this.kJp.cTp() + this.kJp.cDl() + this.kJp.cTq());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.kJp.cTp().length();
            spannableString.setSpan(foregroundColorSpan, length, this.kJp.cDl().length() + length, 33);
            message1.setText(spannableString);
            this.kKM.getMessage2().setText(this.kJp.cTr());
            this.kKP.setText(this.kJp.getContent());
            if (TextUtils.isEmpty(this.kJp.cTA())) {
                this.kKQ.setText(R.string.member_buy_open);
            } else {
                this.kKQ.setText(this.kJp.cTA());
            }
            this.kKM.setVisibility(0);
            if (this.kJp.cTz() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.kKO.setVisibility(8);
            } else {
                this.kKO.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.TX.startPullRefresh();
    }

    public void completeRefresh() {
        this.TX.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.TX.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cUj() {
        return this.kKM;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cUk() {
        return this.TX;
    }

    public c cUl() {
        return this.kJp;
    }

    public g cUm() {
        return this.kKN;
    }

    public LinearLayout cUn() {
        return this.kKR;
    }

    public void setListViewSelection(int i) {
        this.TX.setSelection(i);
    }

    public RelativeLayout bCt() {
        return this.mRootView;
    }
}
