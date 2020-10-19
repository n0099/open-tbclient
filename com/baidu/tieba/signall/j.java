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
/* loaded from: classes24.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int mwB;
    private BdListView VX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c mvg;
    private SignAllForumActivity mwC;
    private SignAllForumProgressView mwD;
    private g mwE;
    private RelativeLayout mwF;
    private TextView mwG;
    private TextView mwH;
    private LinearLayout mwI;
    private TextView mwJ;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.mwC = signAllForumActivity;
        this.mwC.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.mwC.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.mwC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mwC.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.mwC.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.VX = (BdListView) this.mwC.findViewById(R.id.signallforum_list);
        this.VX.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.VX.setPullRefresh(this.mPullView);
        this.mwJ = (TextView) LayoutInflater.from(this.mwC.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.VX.addFooterView(this.mwJ);
        this.mwD = new SignAllForumProgressView(this.mwC.getPageContext().getPageActivity());
        this.mProgressBar = this.mwD.getProgressBar();
        this.mProgressBar.setOnClickListener(this.mwC);
        this.VX.addHeaderView(this.mwD);
        this.mwD.setVisibility(8);
        this.mwF = (RelativeLayout) this.mwD.findViewById(R.id.guidecontainer);
        this.mwI = (LinearLayout) this.mwD.findViewById(R.id.guideopenbtn);
        this.mwG = (TextView) this.mwD.findViewById(R.id.guidetip);
        this.mwH = (TextView) this.mwD.findViewById(R.id.guideopen);
        this.mwI.setOnClickListener(this.mwC);
        this.mwE = new g(this.mwC, null);
        this.VX.setAdapter((ListAdapter) this.mwE);
        this.VX.setOnScrollListener(this.mwE);
    }

    public void onChangeSkinType(int i) {
        this.mwC.getLayoutMode().setNightMode(i == 1);
        this.mwC.getLayoutMode().onModeChanged(this.mRootView);
        this.mwC.getLayoutMode().onModeChanged(this.mwJ);
        this.mwC.getLayoutMode().onModeChanged(this.mwD);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mwD != null) {
            this.mwD.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.mwE.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.mvg = cVar;
            dCd();
            ArrayList<d> dBr = cVar.dBr();
            this.mwE.c(this.mvg);
            if (dBr.size() == mwB) {
                this.mwJ.setVisibility(0);
                this.mwJ.setText(cVar.dBo());
            } else {
                this.mwJ.setVisibility(8);
            }
            String dBi = this.mvg.dBi();
            if (!StringUtils.isNull(dBi)) {
                this.mwD.a(this.mwC, dBi, this.mvg.dBj());
                return;
            }
            this.mwD.dCc();
        }
    }

    private void dCd() {
        if (this.mvg != null) {
            this.mwD.setHasPrivilege(this.mvg.dBv());
            this.mwD.setmCurrentStatus(this.mvg.dBx());
            TextView message1 = this.mwD.getMessage1();
            SpannableString spannableString = new SpannableString(this.mvg.dBl() + this.mvg.dkI() + this.mvg.dBm());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.mvg.dBl().length();
            spannableString.setSpan(foregroundColorSpan, length, this.mvg.dkI().length() + length, 33);
            message1.setText(spannableString);
            this.mwD.getMessage2().setText(this.mvg.dBn());
            this.mwG.setText(this.mvg.getContent());
            if (TextUtils.isEmpty(this.mvg.dBw())) {
                this.mwH.setText(R.string.member_buy_open);
            } else {
                this.mwH.setText(this.mvg.dBw());
            }
            this.mwD.setVisibility(0);
            if (this.mvg.dBv() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.mwF.setVisibility(8);
            } else {
                this.mwF.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.VX.startPullRefresh();
    }

    public void completeRefresh() {
        this.VX.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.VX.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dCe() {
        return this.mwD;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dCf() {
        return this.VX;
    }

    public c dCg() {
        return this.mvg;
    }

    public g dCh() {
        return this.mwE;
    }

    public LinearLayout dCi() {
        return this.mwI;
    }

    public void setListViewSelection(int i) {
        this.VX.setSelection(i);
    }

    public RelativeLayout cew() {
        return this.mRootView;
    }
}
