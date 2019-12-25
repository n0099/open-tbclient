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
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int jUY;
    private BdListView Ak;
    private c jTG;
    private SignAllForumActivity jUZ;
    private SignAllForumProgressView jVa;
    private g jVb;
    private RelativeLayout jVc;
    private TextView jVd;
    private TextView jVe;
    private LinearLayout jVf;
    private TextView jVg;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jUZ = signAllForumActivity;
        this.jUZ.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jUZ.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jUZ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jUZ.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jUZ.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.Ak = (BdListView) this.jUZ.findViewById(R.id.signallforum_list);
        this.Ak.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.Ak.setPullRefresh(this.mPullView);
        this.jVg = (TextView) LayoutInflater.from(this.jUZ.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.Ak.addFooterView(this.jVg);
        this.jVa = new SignAllForumProgressView(this.jUZ.getPageContext().getPageActivity());
        this.mProgressBar = this.jVa.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jUZ);
        this.Ak.addHeaderView(this.jVa);
        this.jVa.setVisibility(8);
        this.jVc = (RelativeLayout) this.jVa.findViewById(R.id.guidecontainer);
        this.jVf = (LinearLayout) this.jVa.findViewById(R.id.guideopenbtn);
        this.jVd = (TextView) this.jVa.findViewById(R.id.guidetip);
        this.jVe = (TextView) this.jVa.findViewById(R.id.guideopen);
        this.jVf.setOnClickListener(this.jUZ);
        this.jVb = new g(this.jUZ, null);
        this.Ak.setAdapter((ListAdapter) this.jVb);
        this.Ak.setOnScrollListener(this.jVb);
    }

    public void onChangeSkinType(int i) {
        this.jUZ.getLayoutMode().setNightMode(i == 1);
        this.jUZ.getLayoutMode().onModeChanged(this.mRootView);
        this.jUZ.getLayoutMode().onModeChanged(this.jVg);
        this.jUZ.getLayoutMode().onModeChanged(this.jVa);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jVa != null) {
            this.jVa.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jVb.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jTG = cVar;
            cGx();
            ArrayList<d> cFL = cVar.cFL();
            this.jVb.c(this.jTG);
            if (cFL.size() == jUY) {
                this.jVg.setVisibility(0);
                this.jVg.setText(cVar.cFI());
            } else {
                this.jVg.setVisibility(8);
            }
            String cFC = this.jTG.cFC();
            if (!StringUtils.isNull(cFC)) {
                this.jVa.a(this.jUZ, cFC, this.jTG.cFD());
                return;
            }
            this.jVa.cGw();
        }
    }

    private void cGx() {
        if (this.jTG != null) {
            this.jVa.setHasPrivilege(this.jTG.cFP());
            this.jVa.setmCurrentStatus(this.jTG.cFR());
            TextView message1 = this.jVa.getMessage1();
            SpannableString spannableString = new SpannableString(this.jTG.cFF() + this.jTG.cpI() + this.jTG.cFG());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jTG.cFF().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jTG.cpI().length() + length, 33);
            message1.setText(spannableString);
            this.jVa.getMessage2().setText(this.jTG.cFH());
            this.jVd.setText(this.jTG.getContent());
            if (TextUtils.isEmpty(this.jTG.cFQ())) {
                this.jVe.setText(R.string.member_buy_open);
            } else {
                this.jVe.setText(this.jTG.cFQ());
            }
            this.jVa.setVisibility(0);
            if (this.jTG.cFP() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jVc.setVisibility(8);
            } else {
                this.jVc.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.Ak.startPullRefresh();
    }

    public void completeRefresh() {
        this.Ak.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.Ak.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView cGy() {
        return this.jVa;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cGz() {
        return this.Ak;
    }

    public c cGA() {
        return this.jTG;
    }

    public g cGB() {
        return this.jVb;
    }

    public LinearLayout cGC() {
        return this.jVf;
    }

    public void setListViewSelection(int i) {
        this.Ak.setSelection(i);
    }

    public RelativeLayout bpX() {
        return this.mRootView;
    }
}
