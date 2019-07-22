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
    public static int iYc;
    private BdListView Ni;
    private c iWK;
    private SignAllForumActivity iYd;
    private SignAllForumProgressView iYe;
    private g iYf;
    private RelativeLayout iYg;
    private TextView iYh;
    private TextView iYi;
    private LinearLayout iYj;
    private TextView iYk;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.iYd = signAllForumActivity;
        this.iYd.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.iYd.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.iYd.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iYd.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.iYd.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Ni = (BdListView) this.iYd.findViewById(R.id.signallforum_list);
        this.Ni.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.i(signAllForumActivity.getPageContext());
        this.Ni.setPullRefresh(this.mPullView);
        this.iYk = (TextView) LayoutInflater.from(this.iYd.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Ni.addFooterView(this.iYk);
        this.iYe = new SignAllForumProgressView(this.iYd.getPageContext().getPageActivity());
        this.mProgressBar = this.iYe.getProgressBar();
        this.mProgressBar.setOnClickListener(this.iYd);
        this.Ni.addHeaderView(this.iYe);
        this.iYe.setVisibility(8);
        this.iYg = (RelativeLayout) this.iYe.findViewById(R.id.guidecontainer);
        this.iYj = (LinearLayout) this.iYe.findViewById(R.id.guideopenbtn);
        this.iYh = (TextView) this.iYe.findViewById(R.id.guidetip);
        this.iYi = (TextView) this.iYe.findViewById(R.id.guideopen);
        this.iYj.setOnClickListener(this.iYd);
        this.iYf = new g(this.iYd, null);
        this.Ni.setAdapter((ListAdapter) this.iYf);
        this.Ni.setOnScrollListener(this.iYf);
    }

    public void onChangeSkinType(int i) {
        this.iYd.getLayoutMode().setNightMode(i == 1);
        this.iYd.getLayoutMode().onModeChanged(this.mRootView);
        this.iYd.getLayoutMode().onModeChanged(this.iYk);
        this.iYd.getLayoutMode().onModeChanged(this.iYe);
        am.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.iYe != null) {
            this.iYe.onChangeSkinType();
        }
        this.mPullView.iV(i);
        this.iYf.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.iWK = cVar;
            cnu();
            ArrayList<d> cmI = cVar.cmI();
            this.iYf.c(this.iWK);
            if (cmI.size() == iYc) {
                this.iYk.setVisibility(0);
                this.iYk.setText(cVar.cmF());
            } else {
                this.iYk.setVisibility(8);
            }
            String cmz = this.iWK.cmz();
            if (!StringUtils.isNull(cmz)) {
                this.iYe.a(this.iYd, cmz, this.iWK.cmA());
                return;
            }
            this.iYe.cnt();
        }
    }

    private void cnu() {
        if (this.iWK != null) {
            this.iYe.setHasPrivilege(this.iWK.cmM());
            this.iYe.setmCurrentStatus(this.iWK.cmO());
            TextView message1 = this.iYe.getMessage1();
            SpannableString spannableString = new SpannableString(this.iWK.cmC() + this.iWK.bZG() + this.iWK.cmD());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.iWK.cmC().length();
            spannableString.setSpan(foregroundColorSpan, length, this.iWK.bZG().length() + length, 33);
            message1.setText(spannableString);
            this.iYe.getMessage2().setText(this.iWK.cmE());
            this.iYh.setText(this.iWK.getContent());
            if (TextUtils.isEmpty(this.iWK.cmN())) {
                this.iYi.setText(R.string.member_buy_open);
            } else {
                this.iYi.setText(this.iWK.cmN());
            }
            this.iYe.setVisibility(0);
            if (this.iWK.cmM() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.iYg.setVisibility(8);
            } else {
                this.iYg.setVisibility(0);
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

    public SignAllForumProgressView cnv() {
        return this.iYe;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cnw() {
        return this.Ni;
    }

    public c cnx() {
        return this.iWK;
    }

    public g cny() {
        return this.iYf;
    }

    public LinearLayout cnz() {
        return this.iYj;
    }

    public void setListViewSelection(int i) {
        this.Ni.setSelection(i);
    }

    public RelativeLayout aXy() {
        return this.mRootView;
    }
}
