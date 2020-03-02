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
    public static int jZG;
    private BdListView AG;
    private c jYo;
    private SignAllForumActivity jZH;
    private SignAllForumProgressView jZI;
    private g jZJ;
    private RelativeLayout jZK;
    private TextView jZL;
    private TextView jZM;
    private LinearLayout jZN;
    private TextView jZO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jZH = signAllForumActivity;
        this.jZH.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jZH.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jZH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jZH.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jZH.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.AG = (BdListView) this.jZH.findViewById(R.id.signallforum_list);
        this.AG.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.AG.setPullRefresh(this.mPullView);
        this.jZO = (TextView) LayoutInflater.from(this.jZH.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.AG.addFooterView(this.jZO);
        this.jZI = new SignAllForumProgressView(this.jZH.getPageContext().getPageActivity());
        this.mProgressBar = this.jZI.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jZH);
        this.AG.addHeaderView(this.jZI);
        this.jZI.setVisibility(8);
        this.jZK = (RelativeLayout) this.jZI.findViewById(R.id.guidecontainer);
        this.jZN = (LinearLayout) this.jZI.findViewById(R.id.guideopenbtn);
        this.jZL = (TextView) this.jZI.findViewById(R.id.guidetip);
        this.jZM = (TextView) this.jZI.findViewById(R.id.guideopen);
        this.jZN.setOnClickListener(this.jZH);
        this.jZJ = new g(this.jZH, null);
        this.AG.setAdapter((ListAdapter) this.jZJ);
        this.AG.setOnScrollListener(this.jZJ);
    }

    public void onChangeSkinType(int i) {
        this.jZH.getLayoutMode().setNightMode(i == 1);
        this.jZH.getLayoutMode().onModeChanged(this.mRootView);
        this.jZH.getLayoutMode().onModeChanged(this.jZO);
        this.jZH.getLayoutMode().onModeChanged(this.jZI);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jZI != null) {
            this.jZI.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jZJ.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jYo = cVar;
            cJj();
            ArrayList<d> cIx = cVar.cIx();
            this.jZJ.c(this.jYo);
            if (cIx.size() == jZG) {
                this.jZO.setVisibility(0);
                this.jZO.setText(cVar.cIu());
            } else {
                this.jZO.setVisibility(8);
            }
            String cIo = this.jYo.cIo();
            if (!StringUtils.isNull(cIo)) {
                this.jZI.a(this.jZH, cIo, this.jYo.cIp());
                return;
            }
            this.jZI.cJi();
        }
    }

    private void cJj() {
        if (this.jYo != null) {
            this.jZI.setHasPrivilege(this.jYo.cIB());
            this.jZI.setmCurrentStatus(this.jYo.cID());
            TextView message1 = this.jZI.getMessage1();
            SpannableString spannableString = new SpannableString(this.jYo.cIr() + this.jYo.csj() + this.jYo.cIs());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jYo.cIr().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jYo.csj().length() + length, 33);
            message1.setText(spannableString);
            this.jZI.getMessage2().setText(this.jYo.cIt());
            this.jZL.setText(this.jYo.getContent());
            if (TextUtils.isEmpty(this.jYo.cIC())) {
                this.jZM.setText(R.string.member_buy_open);
            } else {
                this.jZM.setText(this.jYo.cIC());
            }
            this.jZI.setVisibility(0);
            if (this.jYo.cIB() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jZK.setVisibility(8);
            } else {
                this.jZK.setVisibility(0);
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

    public SignAllForumProgressView cJk() {
        return this.jZI;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cJl() {
        return this.AG;
    }

    public c cJm() {
        return this.jYo;
    }

    public g cJn() {
        return this.jZJ;
    }

    public LinearLayout cJo() {
        return this.jZN;
    }

    public void setListViewSelection(int i) {
        this.AG.setSelection(i);
    }

    public RelativeLayout bsE() {
        return this.mRootView;
    }
}
