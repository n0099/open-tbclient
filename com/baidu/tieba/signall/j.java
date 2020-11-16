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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes23.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int mQb;
    private BdListView Wa;
    private NavigationBar mNavigationBar;
    private c mOE;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private SignAllForumActivity mQc;
    private SignAllForumProgressView mQd;
    private g mQe;
    private RelativeLayout mQf;
    private TextView mQg;
    private TextView mQh;
    private LinearLayout mQi;
    private TextView mQj;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.mQc = signAllForumActivity;
        this.mQc.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.mQc.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mQc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mQc.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.mQc.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Wa = (BdListView) this.mQc.findViewById(R.id.signallforum_list);
        this.Wa.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.Wa.setPullRefresh(this.mPullView);
        this.mQj = (TextView) LayoutInflater.from(this.mQc.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Wa.addFooterView(this.mQj);
        this.mQd = new SignAllForumProgressView(this.mQc.getPageContext().getPageActivity());
        this.mProgressBar = this.mQd.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mQc);
        this.Wa.addHeaderView(this.mQd);
        this.mQd.setVisibility(8);
        this.mQf = (RelativeLayout) this.mQd.findViewById(R.id.guidecontainer);
        this.mQi = (LinearLayout) this.mQd.findViewById(R.id.guideopenbtn);
        this.mQg = (TextView) this.mQd.findViewById(R.id.guidetip);
        this.mQh = (TextView) this.mQd.findViewById(R.id.guideopen);
        this.mQi.setOnClickListener(this.mQc);
        this.mQe = new g(this.mQc, null);
        this.Wa.setAdapter((ListAdapter) this.mQe);
        this.Wa.setOnScrollListener(this.mQe);
    }

    public void onChangeSkinType(int i) {
        this.mQc.getLayoutMode().setNightMode(i == 1);
        this.mQc.getLayoutMode().onModeChanged(this.mRootView);
        this.mQc.getLayoutMode().onModeChanged(this.mQj);
        this.mQc.getLayoutMode().onModeChanged(this.mQd);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mQd != null) {
            this.mQd.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.mQe.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.mOE = cVar;
            dHE();
            ArrayList<d> dGS = cVar.dGS();
            this.mQe.c(this.mOE);
            if (dGS.size() == mQb) {
                this.mQj.setVisibility(0);
                this.mQj.setText(cVar.dGP());
            } else {
                this.mQj.setVisibility(8);
            }
            String dGJ = this.mOE.dGJ();
            if (!StringUtils.isNull(dGJ)) {
                this.mQd.a(this.mQc, dGJ, this.mOE.dGK());
                return;
            }
            this.mQd.dHD();
        }
    }

    private void dHE() {
        if (this.mOE != null) {
            this.mQd.setHasPrivilege(this.mOE.dGW());
            this.mQd.setmCurrentStatus(this.mOE.dGY());
            TextView message1 = this.mQd.getMessage1();
            SpannableString spannableString = new SpannableString(this.mOE.dGM() + this.mOE.dpS() + this.mOE.dGN());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.mOE.dGM().length();
            spannableString.setSpan(foregroundColorSpan, length, this.mOE.dpS().length() + length, 33);
            message1.setText(spannableString);
            this.mQd.getMessage2().setText(this.mOE.dGO());
            this.mQg.setText(this.mOE.getContent());
            if (TextUtils.isEmpty(this.mOE.dGX())) {
                this.mQh.setText(R.string.member_buy_open);
            } else {
                this.mQh.setText(this.mOE.dGX());
            }
            this.mQd.setVisibility(0);
            if (this.mOE.dGW() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.mQf.setVisibility(8);
            } else {
                this.mQf.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Wa.startPullRefresh();
    }

    public void completeRefresh() {
        this.Wa.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Wa.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dHF() {
        return this.mQd;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dHG() {
        return this.Wa;
    }

    public c dHH() {
        return this.mOE;
    }

    public g dHI() {
        return this.mQe;
    }

    public LinearLayout dHJ() {
        return this.mQi;
    }

    public void setListViewSelection(int i) {
        this.Wa.setSelection(i);
    }

    public RelativeLayout cjt() {
        return this.mRootView;
    }
}
