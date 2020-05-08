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
    public static int kKO;
    private BdListView Ua;
    private c kJt;
    private SignAllForumActivity kKP;
    private SignAllForumProgressView kKQ;
    private g kKR;
    private RelativeLayout kKS;
    private TextView kKT;
    private TextView kKU;
    private LinearLayout kKV;
    private TextView kKW;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.kKP = signAllForumActivity;
        this.kKP.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.kKP.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.kKP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kKP.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.kKP.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Ua = (BdListView) this.kKP.findViewById(R.id.signallforum_list);
        this.Ua.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.Ua.setPullRefresh(this.mPullView);
        this.kKW = (TextView) LayoutInflater.from(this.kKP.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Ua.addFooterView(this.kKW);
        this.kKQ = new SignAllForumProgressView(this.kKP.getPageContext().getPageActivity());
        this.mProgressBar = this.kKQ.getProgressBar();
        this.mProgressBar.setOnClickListener(this.kKP);
        this.Ua.addHeaderView(this.kKQ);
        this.kKQ.setVisibility(8);
        this.kKS = (RelativeLayout) this.kKQ.findViewById(R.id.guidecontainer);
        this.kKV = (LinearLayout) this.kKQ.findViewById(R.id.guideopenbtn);
        this.kKT = (TextView) this.kKQ.findViewById(R.id.guidetip);
        this.kKU = (TextView) this.kKQ.findViewById(R.id.guideopen);
        this.kKV.setOnClickListener(this.kKP);
        this.kKR = new g(this.kKP, null);
        this.Ua.setAdapter((ListAdapter) this.kKR);
        this.Ua.setOnScrollListener(this.kKR);
    }

    public void onChangeSkinType(int i) {
        this.kKP.getLayoutMode().setNightMode(i == 1);
        this.kKP.getLayoutMode().onModeChanged(this.mRootView);
        this.kKP.getLayoutMode().onModeChanged(this.kKW);
        this.kKP.getLayoutMode().onModeChanged(this.kKQ);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kKQ != null) {
            this.kKQ.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.kKR.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.kJt = cVar;
            cUf();
            ArrayList<d> cTs = cVar.cTs();
            this.kKR.c(this.kJt);
            if (cTs.size() == kKO) {
                this.kKW.setVisibility(0);
                this.kKW.setText(cVar.cTp());
            } else {
                this.kKW.setVisibility(8);
            }
            String cTj = this.kJt.cTj();
            if (!StringUtils.isNull(cTj)) {
                this.kKQ.a(this.kKP, cTj, this.kJt.cTk());
                return;
            }
            this.kKQ.cUe();
        }
    }

    private void cUf() {
        if (this.kJt != null) {
            this.kKQ.setHasPrivilege(this.kJt.cTw());
            this.kKQ.setmCurrentStatus(this.kJt.cTy());
            TextView message1 = this.kKQ.getMessage1();
            SpannableString spannableString = new SpannableString(this.kJt.cTm() + this.kJt.cDi() + this.kJt.cTn());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.kJt.cTm().length();
            spannableString.setSpan(foregroundColorSpan, length, this.kJt.cDi().length() + length, 33);
            message1.setText(spannableString);
            this.kKQ.getMessage2().setText(this.kJt.cTo());
            this.kKT.setText(this.kJt.getContent());
            if (TextUtils.isEmpty(this.kJt.cTx())) {
                this.kKU.setText(R.string.member_buy_open);
            } else {
                this.kKU.setText(this.kJt.cTx());
            }
            this.kKQ.setVisibility(0);
            if (this.kJt.cTw() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.kKS.setVisibility(8);
            } else {
                this.kKS.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Ua.startPullRefresh();
    }

    public void completeRefresh() {
        this.Ua.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Ua.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cUg() {
        return this.kKQ;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cUh() {
        return this.Ua;
    }

    public c cUi() {
        return this.kJt;
    }

    public g cUj() {
        return this.kKR;
    }

    public LinearLayout cUk() {
        return this.kKV;
    }

    public void setListViewSelection(int i) {
        this.Ua.setSelection(i);
    }

    public RelativeLayout bCr() {
        return this.mRootView;
    }
}
