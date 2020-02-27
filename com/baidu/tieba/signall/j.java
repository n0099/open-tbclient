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
    public static int jZE;
    private BdListView AG;
    private c jYm;
    private SignAllForumActivity jZF;
    private SignAllForumProgressView jZG;
    private g jZH;
    private RelativeLayout jZI;
    private TextView jZJ;
    private TextView jZK;
    private LinearLayout jZL;
    private TextView jZM;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jZF = signAllForumActivity;
        this.jZF.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jZF.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jZF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jZF.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jZF.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.AG = (BdListView) this.jZF.findViewById(R.id.signallforum_list);
        this.AG.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.AG.setPullRefresh(this.mPullView);
        this.jZM = (TextView) LayoutInflater.from(this.jZF.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.AG.addFooterView(this.jZM);
        this.jZG = new SignAllForumProgressView(this.jZF.getPageContext().getPageActivity());
        this.mProgressBar = this.jZG.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jZF);
        this.AG.addHeaderView(this.jZG);
        this.jZG.setVisibility(8);
        this.jZI = (RelativeLayout) this.jZG.findViewById(R.id.guidecontainer);
        this.jZL = (LinearLayout) this.jZG.findViewById(R.id.guideopenbtn);
        this.jZJ = (TextView) this.jZG.findViewById(R.id.guidetip);
        this.jZK = (TextView) this.jZG.findViewById(R.id.guideopen);
        this.jZL.setOnClickListener(this.jZF);
        this.jZH = new g(this.jZF, null);
        this.AG.setAdapter((ListAdapter) this.jZH);
        this.AG.setOnScrollListener(this.jZH);
    }

    public void onChangeSkinType(int i) {
        this.jZF.getLayoutMode().setNightMode(i == 1);
        this.jZF.getLayoutMode().onModeChanged(this.mRootView);
        this.jZF.getLayoutMode().onModeChanged(this.jZM);
        this.jZF.getLayoutMode().onModeChanged(this.jZG);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jZG != null) {
            this.jZG.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jZH.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jYm = cVar;
            cJh();
            ArrayList<d> cIv = cVar.cIv();
            this.jZH.c(this.jYm);
            if (cIv.size() == jZE) {
                this.jZM.setVisibility(0);
                this.jZM.setText(cVar.cIs());
            } else {
                this.jZM.setVisibility(8);
            }
            String cIm = this.jYm.cIm();
            if (!StringUtils.isNull(cIm)) {
                this.jZG.a(this.jZF, cIm, this.jYm.cIn());
                return;
            }
            this.jZG.cJg();
        }
    }

    private void cJh() {
        if (this.jYm != null) {
            this.jZG.setHasPrivilege(this.jYm.cIz());
            this.jZG.setmCurrentStatus(this.jYm.cIB());
            TextView message1 = this.jZG.getMessage1();
            SpannableString spannableString = new SpannableString(this.jYm.cIp() + this.jYm.csh() + this.jYm.cIq());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jYm.cIp().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jYm.csh().length() + length, 33);
            message1.setText(spannableString);
            this.jZG.getMessage2().setText(this.jYm.cIr());
            this.jZJ.setText(this.jYm.getContent());
            if (TextUtils.isEmpty(this.jYm.cIA())) {
                this.jZK.setText(R.string.member_buy_open);
            } else {
                this.jZK.setText(this.jYm.cIA());
            }
            this.jZG.setVisibility(0);
            if (this.jYm.cIz() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jZI.setVisibility(8);
            } else {
                this.jZI.setVisibility(0);
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

    public SignAllForumProgressView cJi() {
        return this.jZG;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cJj() {
        return this.AG;
    }

    public c cJk() {
        return this.jYm;
    }

    public g cJl() {
        return this.jZH;
    }

    public LinearLayout cJm() {
        return this.jZL;
    }

    public void setListViewSelection(int i) {
        this.AG.setSelection(i);
    }

    public RelativeLayout bsC() {
        return this.mRootView;
    }
}
