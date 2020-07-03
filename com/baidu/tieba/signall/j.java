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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int lyk;
    private BdListView US;
    private c lwP;
    private SignAllForumActivity lyl;
    private SignAllForumProgressView lym;
    private g lyn;
    private RelativeLayout lyp;
    private TextView lyq;
    private TextView lyr;
    private LinearLayout lys;
    private TextView lyt;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.lyl = signAllForumActivity;
        this.lyl.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.lyl.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.lyl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.lyl.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.lyl.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.US = (BdListView) this.lyl.findViewById(R.id.signallforum_list);
        this.US.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.US.setPullRefresh(this.mPullView);
        this.lyt = (TextView) LayoutInflater.from(this.lyl.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.US.addFooterView(this.lyt);
        this.lym = new SignAllForumProgressView(this.lyl.getPageContext().getPageActivity());
        this.mProgressBar = this.lym.getProgressBar();
        this.mProgressBar.setOnClickListener(this.lyl);
        this.US.addHeaderView(this.lym);
        this.lym.setVisibility(8);
        this.lyp = (RelativeLayout) this.lym.findViewById(R.id.guidecontainer);
        this.lys = (LinearLayout) this.lym.findViewById(R.id.guideopenbtn);
        this.lyq = (TextView) this.lym.findViewById(R.id.guidetip);
        this.lyr = (TextView) this.lym.findViewById(R.id.guideopen);
        this.lys.setOnClickListener(this.lyl);
        this.lyn = new g(this.lyl, null);
        this.US.setAdapter((ListAdapter) this.lyn);
        this.US.setOnScrollListener(this.lyn);
    }

    public void onChangeSkinType(int i) {
        this.lyl.getLayoutMode().setNightMode(i == 1);
        this.lyl.getLayoutMode().onModeChanged(this.mRootView);
        this.lyl.getLayoutMode().onModeChanged(this.lyt);
        this.lyl.getLayoutMode().onModeChanged(this.lym);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.lym != null) {
            this.lym.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.lyn.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.lwP = cVar;
            dfP();
            ArrayList<d> dfd = cVar.dfd();
            this.lyn.c(this.lwP);
            if (dfd.size() == lyk) {
                this.lyt.setVisibility(0);
                this.lyt.setText(cVar.dfa());
            } else {
                this.lyt.setVisibility(8);
            }
            String deU = this.lwP.deU();
            if (!StringUtils.isNull(deU)) {
                this.lym.a(this.lyl, deU, this.lwP.deV());
                return;
            }
            this.lym.dfO();
        }
    }

    private void dfP() {
        if (this.lwP != null) {
            this.lym.setHasPrivilege(this.lwP.dfh());
            this.lym.setmCurrentStatus(this.lwP.dfj());
            TextView message1 = this.lym.getMessage1();
            SpannableString spannableString = new SpannableString(this.lwP.deX() + this.lwP.cOO() + this.lwP.deY());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.lwP.deX().length();
            spannableString.setSpan(foregroundColorSpan, length, this.lwP.cOO().length() + length, 33);
            message1.setText(spannableString);
            this.lym.getMessage2().setText(this.lwP.deZ());
            this.lyq.setText(this.lwP.getContent());
            if (TextUtils.isEmpty(this.lwP.dfi())) {
                this.lyr.setText(R.string.member_buy_open);
            } else {
                this.lyr.setText(this.lwP.dfi());
            }
            this.lym.setVisibility(0);
            if (this.lwP.dfh() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.lyp.setVisibility(8);
            } else {
                this.lyp.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.US.startPullRefresh();
    }

    public void completeRefresh() {
        this.US.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.US.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dfQ() {
        return this.lym;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dfR() {
        return this.US;
    }

    public c dfS() {
        return this.lwP;
    }

    public g dfT() {
        return this.lyn;
    }

    public LinearLayout dfU() {
        return this.lys;
    }

    public void setListViewSelection(int i) {
        this.US.setSelection(i);
    }

    public RelativeLayout bLS() {
        return this.mRootView;
    }
}
