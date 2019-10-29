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
    public static int jbs;
    private c jab;
    private TextView jbA;
    private SignAllForumActivity jbt;
    private SignAllForumProgressView jbu;
    private g jbv;
    private RelativeLayout jbw;
    private TextView jbx;
    private TextView jby;
    private LinearLayout jbz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;
    private BdListView yl;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jbt = signAllForumActivity;
        this.jbt.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jbt.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jbt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jbt.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jbt.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.yl = (BdListView) this.jbt.findViewById(R.id.signallforum_list);
        this.yl.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.yl.setPullRefresh(this.mPullView);
        this.jbA = (TextView) LayoutInflater.from(this.jbt.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.yl.addFooterView(this.jbA);
        this.jbu = new SignAllForumProgressView(this.jbt.getPageContext().getPageActivity());
        this.mProgressBar = this.jbu.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jbt);
        this.yl.addHeaderView(this.jbu);
        this.jbu.setVisibility(8);
        this.jbw = (RelativeLayout) this.jbu.findViewById(R.id.guidecontainer);
        this.jbz = (LinearLayout) this.jbu.findViewById(R.id.guideopenbtn);
        this.jbx = (TextView) this.jbu.findViewById(R.id.guidetip);
        this.jby = (TextView) this.jbu.findViewById(R.id.guideopen);
        this.jbz.setOnClickListener(this.jbt);
        this.jbv = new g(this.jbt, null);
        this.yl.setAdapter((ListAdapter) this.jbv);
        this.yl.setOnScrollListener(this.jbv);
    }

    public void onChangeSkinType(int i) {
        this.jbt.getLayoutMode().setNightMode(i == 1);
        this.jbt.getLayoutMode().onModeChanged(this.mRootView);
        this.jbt.getLayoutMode().onModeChanged(this.jbA);
        this.jbt.getLayoutMode().onModeChanged(this.jbu);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jbu != null) {
            this.jbu.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jbv.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jab = cVar;
            cmp();
            ArrayList<d> clD = cVar.clD();
            this.jbv.c(this.jab);
            if (clD.size() == jbs) {
                this.jbA.setVisibility(0);
                this.jbA.setText(cVar.clA());
            } else {
                this.jbA.setVisibility(8);
            }
            String clu = this.jab.clu();
            if (!StringUtils.isNull(clu)) {
                this.jbu.a(this.jbt, clu, this.jab.clv());
                return;
            }
            this.jbu.cmo();
        }
    }

    private void cmp() {
        if (this.jab != null) {
            this.jbu.setHasPrivilege(this.jab.clH());
            this.jbu.setmCurrentStatus(this.jab.clJ());
            TextView message1 = this.jbu.getMessage1();
            SpannableString spannableString = new SpannableString(this.jab.clx() + this.jab.bXO() + this.jab.cly());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jab.clx().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jab.bXO().length() + length, 33);
            message1.setText(spannableString);
            this.jbu.getMessage2().setText(this.jab.clz());
            this.jbx.setText(this.jab.getContent());
            if (TextUtils.isEmpty(this.jab.clI())) {
                this.jby.setText(R.string.member_buy_open);
            } else {
                this.jby.setText(this.jab.clI());
            }
            this.jbu.setVisibility(0);
            if (this.jab.clH() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jbw.setVisibility(8);
            } else {
                this.jbw.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.yl.startPullRefresh();
    }

    public void completeRefresh() {
        this.yl.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.yl.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cmq() {
        return this.jbu;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cmr() {
        return this.yl;
    }

    public c cms() {
        return this.jab;
    }

    public g cmt() {
        return this.jbv;
    }

    public LinearLayout cmu() {
        return this.jbz;
    }

    public void setListViewSelection(int i) {
        this.yl.setSelection(i);
    }

    public RelativeLayout aYd() {
        return this.mRootView;
    }
}
