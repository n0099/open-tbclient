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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class j extends com.baidu.adp.base.d<SignAllForumActivity> {
    public static int nfi;
    private BdListView WT;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c ndM;
    private SignAllForumActivity nfj;
    private SignAllForumProgressView nfk;
    private g nfl;
    private RelativeLayout nfm;
    private TextView nfn;
    private TextView nfo;
    private LinearLayout nfp;
    private TextView nfq;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.nfj = signAllForumActivity;
        this.nfj.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.nfj.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.nfj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.nfj.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.nfj.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WT = (BdListView) this.nfj.findViewById(R.id.signallforum_list);
        this.WT.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WT.setPullRefresh(this.mPullView);
        this.nfq = (TextView) LayoutInflater.from(this.nfj.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WT.addFooterView(this.nfq);
        this.nfk = new SignAllForumProgressView(this.nfj.getPageContext().getPageActivity());
        this.mProgressBar = this.nfk.getProgressBar();
        this.mProgressBar.setOnClickListener(this.nfj);
        this.WT.addHeaderView(this.nfk);
        this.nfk.setVisibility(8);
        this.nfm = (RelativeLayout) this.nfk.findViewById(R.id.guidecontainer);
        this.nfp = (LinearLayout) this.nfk.findViewById(R.id.guideopenbtn);
        this.nfn = (TextView) this.nfk.findViewById(R.id.guidetip);
        this.nfo = (TextView) this.nfk.findViewById(R.id.guideopen);
        this.nfp.setOnClickListener(this.nfj);
        this.nfl = new g(this.nfj, null);
        this.WT.setAdapter((ListAdapter) this.nfl);
        this.WT.setOnScrollListener(this.nfl);
    }

    public void onChangeSkinType(int i) {
        this.nfj.getLayoutMode().setNightMode(i == 1);
        this.nfj.getLayoutMode().onModeChanged(this.mRootView);
        this.nfj.getLayoutMode().onModeChanged(this.nfq);
        this.nfj.getLayoutMode().onModeChanged(this.nfk);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.nfk != null) {
            this.nfk.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.nfl.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.ndM = cVar;
            dIW();
            ArrayList<d> dIl = cVar.dIl();
            this.nfl.c(this.ndM);
            if (dIl.size() == nfi) {
                this.nfq.setVisibility(0);
                this.nfq.setText(cVar.dIi());
            } else {
                this.nfq.setVisibility(8);
            }
            String dIc = this.ndM.dIc();
            if (!StringUtils.isNull(dIc)) {
                this.nfk.a(this.nfj, dIc, this.ndM.dId());
                return;
            }
            this.nfk.dIV();
        }
    }

    private void dIW() {
        if (this.ndM != null) {
            this.nfk.setHasPrivilege(this.ndM.dIp());
            this.nfk.setmCurrentStatus(this.ndM.dIr());
            TextView message1 = this.nfk.getMessage1();
            SpannableString spannableString = new SpannableString(this.ndM.dIf() + this.ndM.drk() + this.ndM.dIg());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.ndM.dIf().length();
            spannableString.setSpan(foregroundColorSpan, length, this.ndM.drk().length() + length, 33);
            message1.setText(spannableString);
            this.nfk.getMessage2().setText(this.ndM.dIh());
            this.nfn.setText(this.ndM.getContent());
            if (TextUtils.isEmpty(this.ndM.dIq())) {
                this.nfo.setText(R.string.member_buy_open);
            } else {
                this.nfo.setText(this.ndM.dIq());
            }
            this.nfk.setVisibility(0);
            if (this.ndM.dIp() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.nfm.setVisibility(8);
            } else {
                this.nfm.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.WT.startPullRefresh();
    }

    public void completeRefresh() {
        this.WT.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.WT.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dIX() {
        return this.nfk;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dIY() {
        return this.WT;
    }

    public c dIZ() {
        return this.ndM;
    }

    public g dJa() {
        return this.nfl;
    }

    public LinearLayout dJb() {
        return this.nfp;
    }

    public void setListViewSelection(int i) {
        this.WT.setSelection(i);
    }

    public RelativeLayout cmp() {
        return this.mRootView;
    }
}
