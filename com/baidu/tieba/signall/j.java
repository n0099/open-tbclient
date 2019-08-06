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
    public static int iZg;
    private BdListView Ni;
    private c iXO;
    private SignAllForumActivity iZh;
    private SignAllForumProgressView iZi;
    private g iZj;
    private RelativeLayout iZk;
    private TextView iZl;
    private TextView iZm;
    private LinearLayout iZn;
    private TextView iZo;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iZh = signAllForumActivity;
        this.iZh.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.iZh.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iZh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iZh.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iZh.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Ni = (BdListView) this.iZh.findViewById(R.id.signallforum_list);
        this.Ni.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.Ni.setPullRefresh(this.mPullView);
        this.iZo = (TextView) LayoutInflater.from(this.iZh.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Ni.addFooterView(this.iZo);
        this.iZi = new SignAllForumProgressView(this.iZh.getPageContext().getPageActivity());
        this.mProgressBar = this.iZi.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iZh);
        this.Ni.addHeaderView(this.iZi);
        this.iZi.setVisibility(8);
        this.iZk = (RelativeLayout) this.iZi.findViewById(R.id.guidecontainer);
        this.iZn = (LinearLayout) this.iZi.findViewById(R.id.guideopenbtn);
        this.iZl = (TextView) this.iZi.findViewById(R.id.guidetip);
        this.iZm = (TextView) this.iZi.findViewById(R.id.guideopen);
        this.iZn.setOnClickListener(this.iZh);
        this.iZj = new g(this.iZh, null);
        this.Ni.setAdapter((ListAdapter) this.iZj);
        this.Ni.setOnScrollListener(this.iZj);
    }

    public void onChangeSkinType(int i) {
        this.iZh.getLayoutMode().setNightMode(i == 1);
        this.iZh.getLayoutMode().onModeChanged(this.mRootView);
        this.iZh.getLayoutMode().onModeChanged(this.iZo);
        this.iZh.getLayoutMode().onModeChanged(this.iZi);
        am.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.iZi != null) {
            this.iZi.onChangeSkinType();
        }
        this.mPullView.iV(i);
        this.iZj.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.iXO = cVar;
            cnM();
            ArrayList<d> cna = cVar.cna();
            this.iZj.c(this.iXO);
            if (cna.size() == iZg) {
                this.iZo.setVisibility(0);
                this.iZo.setText(cVar.cmX());
            } else {
                this.iZo.setVisibility(8);
            }
            String cmR = this.iXO.cmR();
            if (!StringUtils.isNull(cmR)) {
                this.iZi.a(this.iZh, cmR, this.iXO.cmS());
                return;
            }
            this.iZi.cnL();
        }
    }

    private void cnM() {
        if (this.iXO != null) {
            this.iZi.setHasPrivilege(this.iXO.cne());
            this.iZi.setmCurrentStatus(this.iXO.cng());
            TextView message1 = this.iZi.getMessage1();
            SpannableString spannableString = new SpannableString(this.iXO.cmU() + this.iXO.bZX() + this.iXO.cmV());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.iXO.cmU().length();
            spannableString.setSpan(foregroundColorSpan, length, this.iXO.bZX().length() + length, 33);
            message1.setText(spannableString);
            this.iZi.getMessage2().setText(this.iXO.cmW());
            this.iZl.setText(this.iXO.getContent());
            if (TextUtils.isEmpty(this.iXO.cnf())) {
                this.iZm.setText(R.string.member_buy_open);
            } else {
                this.iZm.setText(this.iXO.cnf());
            }
            this.iZi.setVisibility(0);
            if (this.iXO.cne() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iZk.setVisibility(8);
            } else {
                this.iZk.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Ni.startPullRefresh();
    }

    public void oT() {
        this.Ni.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Ni.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cnN() {
        return this.iZi;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cnO() {
        return this.Ni;
    }

    public c cnP() {
        return this.iXO;
    }

    public g cnQ() {
        return this.iZj;
    }

    public LinearLayout cnR() {
        return this.iZn;
    }

    public void setListViewSelection(int i) {
        this.Ni.setSelection(i);
    }

    public RelativeLayout aXA() {
        return this.mRootView;
    }
}
