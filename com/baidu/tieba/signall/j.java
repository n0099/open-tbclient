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
    public static int kbv;
    private BdListView AG;
    private c kac;
    private TextView kbA;
    private TextView kbB;
    private LinearLayout kbC;
    private TextView kbD;
    private SignAllForumActivity kbw;
    private SignAllForumProgressView kbx;
    private g kby;
    private RelativeLayout kbz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.kbw = signAllForumActivity;
        this.kbw.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.kbw.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.kbw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.kbw.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.kbw.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.AG = (BdListView) this.kbw.findViewById(R.id.signallforum_list);
        this.AG.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.AG.setPullRefresh(this.mPullView);
        this.kbD = (TextView) LayoutInflater.from(this.kbw.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.AG.addFooterView(this.kbD);
        this.kbx = new SignAllForumProgressView(this.kbw.getPageContext().getPageActivity());
        this.mProgressBar = this.kbx.getProgressBar();
        this.mProgressBar.setOnClickListener(this.kbw);
        this.AG.addHeaderView(this.kbx);
        this.kbx.setVisibility(8);
        this.kbz = (RelativeLayout) this.kbx.findViewById(R.id.guidecontainer);
        this.kbC = (LinearLayout) this.kbx.findViewById(R.id.guideopenbtn);
        this.kbA = (TextView) this.kbx.findViewById(R.id.guidetip);
        this.kbB = (TextView) this.kbx.findViewById(R.id.guideopen);
        this.kbC.setOnClickListener(this.kbw);
        this.kby = new g(this.kbw, null);
        this.AG.setAdapter((ListAdapter) this.kby);
        this.AG.setOnScrollListener(this.kby);
    }

    public void onChangeSkinType(int i) {
        this.kbw.getLayoutMode().setNightMode(i == 1);
        this.kbw.getLayoutMode().onModeChanged(this.mRootView);
        this.kbw.getLayoutMode().onModeChanged(this.kbD);
        this.kbw.getLayoutMode().onModeChanged(this.kbx);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.kbx != null) {
            this.kbx.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.kby.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.kac = cVar;
            cJE();
            ArrayList<d> cIS = cVar.cIS();
            this.kby.c(this.kac);
            if (cIS.size() == kbv) {
                this.kbD.setVisibility(0);
                this.kbD.setText(cVar.cIP());
            } else {
                this.kbD.setVisibility(8);
            }
            String cIJ = this.kac.cIJ();
            if (!StringUtils.isNull(cIJ)) {
                this.kbx.a(this.kbw, cIJ, this.kac.cIK());
                return;
            }
            this.kbx.cJD();
        }
    }

    private void cJE() {
        if (this.kac != null) {
            this.kbx.setHasPrivilege(this.kac.cIW());
            this.kbx.setmCurrentStatus(this.kac.cIY());
            TextView message1 = this.kbx.getMessage1();
            SpannableString spannableString = new SpannableString(this.kac.cIM() + this.kac.csF() + this.kac.cIN());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.kac.cIM().length();
            spannableString.setSpan(foregroundColorSpan, length, this.kac.csF().length() + length, 33);
            message1.setText(spannableString);
            this.kbx.getMessage2().setText(this.kac.cIO());
            this.kbA.setText(this.kac.getContent());
            if (TextUtils.isEmpty(this.kac.cIX())) {
                this.kbB.setText(R.string.member_buy_open);
            } else {
                this.kbB.setText(this.kac.cIX());
            }
            this.kbx.setVisibility(0);
            if (this.kac.cIW() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.kbz.setVisibility(8);
            } else {
                this.kbz.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.AG.startPullRefresh();
    }

    public void completeRefresh() {
        this.AG.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.AG.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cJF() {
        return this.kbx;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cJG() {
        return this.AG;
    }

    public c cJH() {
        return this.kac;
    }

    public g cJI() {
        return this.kby;
    }

    public LinearLayout cJJ() {
        return this.kbC;
    }

    public void setListViewSelection(int i) {
        this.AG.setSelection(i);
    }

    public RelativeLayout bsL() {
        return this.mRootView;
    }
}
