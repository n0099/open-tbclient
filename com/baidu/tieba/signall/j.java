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
    public static int jZS;
    private BdListView AG;
    private c jYA;
    private SignAllForumActivity jZT;
    private SignAllForumProgressView jZU;
    private g jZV;
    private RelativeLayout jZW;
    private TextView jZX;
    private TextView jZY;
    private LinearLayout jZZ;
    private TextView kaa;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.jZT = signAllForumActivity;
        this.jZT.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.jZT.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.jZT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jZT.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.jZT.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.AG = (BdListView) this.jZT.findViewById(R.id.signallforum_list);
        this.AG.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.AG.setPullRefresh(this.mPullView);
        this.kaa = (TextView) LayoutInflater.from(this.jZT.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.AG.addFooterView(this.kaa);
        this.jZU = new SignAllForumProgressView(this.jZT.getPageContext().getPageActivity());
        this.mProgressBar = this.jZU.getProgressBar();
        this.mProgressBar.setOnClickListener(this.jZT);
        this.AG.addHeaderView(this.jZU);
        this.jZU.setVisibility(8);
        this.jZW = (RelativeLayout) this.jZU.findViewById(R.id.guidecontainer);
        this.jZZ = (LinearLayout) this.jZU.findViewById(R.id.guideopenbtn);
        this.jZX = (TextView) this.jZU.findViewById(R.id.guidetip);
        this.jZY = (TextView) this.jZU.findViewById(R.id.guideopen);
        this.jZZ.setOnClickListener(this.jZT);
        this.jZV = new g(this.jZT, null);
        this.AG.setAdapter((ListAdapter) this.jZV);
        this.AG.setOnScrollListener(this.jZV);
    }

    public void onChangeSkinType(int i) {
        this.jZT.getLayoutMode().setNightMode(i == 1);
        this.jZT.getLayoutMode().onModeChanged(this.mRootView);
        this.jZT.getLayoutMode().onModeChanged(this.kaa);
        this.jZT.getLayoutMode().onModeChanged(this.jZU);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.jZU != null) {
            this.jZU.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.jZV.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.jYA = cVar;
            cJk();
            ArrayList<d> cIy = cVar.cIy();
            this.jZV.c(this.jYA);
            if (cIy.size() == jZS) {
                this.kaa.setVisibility(0);
                this.kaa.setText(cVar.cIv());
            } else {
                this.kaa.setVisibility(8);
            }
            String cIp = this.jYA.cIp();
            if (!StringUtils.isNull(cIp)) {
                this.jZU.a(this.jZT, cIp, this.jYA.cIq());
                return;
            }
            this.jZU.cJj();
        }
    }

    private void cJk() {
        if (this.jYA != null) {
            this.jZU.setHasPrivilege(this.jYA.cIC());
            this.jZU.setmCurrentStatus(this.jYA.cIE());
            TextView message1 = this.jZU.getMessage1();
            SpannableString spannableString = new SpannableString(this.jYA.cIs() + this.jYA.csk() + this.jYA.cIt());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.jYA.cIs().length();
            spannableString.setSpan(foregroundColorSpan, length, this.jYA.csk().length() + length, 33);
            message1.setText(spannableString);
            this.jZU.getMessage2().setText(this.jYA.cIu());
            this.jZX.setText(this.jYA.getContent());
            if (TextUtils.isEmpty(this.jYA.cID())) {
                this.jZY.setText(R.string.member_buy_open);
            } else {
                this.jZY.setText(this.jYA.cID());
            }
            this.jZU.setVisibility(0);
            if (this.jYA.cIC() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.jZW.setVisibility(8);
            } else {
                this.jZW.setVisibility(0);
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

    public SignAllForumProgressView cJl() {
        return this.jZU;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView cJm() {
        return this.AG;
    }

    public c cJn() {
        return this.jYA;
    }

    public g cJo() {
        return this.jZV;
    }

    public LinearLayout cJp() {
        return this.jZZ;
    }

    public void setListViewSelection(int i) {
        this.AG.setSelection(i);
    }

    public RelativeLayout bsF() {
        return this.mRootView;
    }
}
