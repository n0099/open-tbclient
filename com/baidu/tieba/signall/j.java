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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.d<SignAllForumActivity> {
    public static int noR;
    private BdListView WO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c nnu;
    private SignAllForumActivity noS;
    private SignAllForumProgressView noT;
    private g noU;
    private RelativeLayout noV;
    private TextView noW;
    private TextView noX;
    private LinearLayout noY;
    private TextView noZ;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.noS = signAllForumActivity;
        this.noS.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.noS.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.noS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.noS.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.noS.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WO = (BdListView) this.noS.findViewById(R.id.signallforum_list);
        this.WO.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WO.setPullRefresh(this.mPullView);
        this.noZ = (TextView) LayoutInflater.from(this.noS.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WO.addFooterView(this.noZ);
        this.noT = new SignAllForumProgressView(this.noS.getPageContext().getPageActivity());
        this.mProgressBar = this.noT.getProgressBar();
        this.mProgressBar.setOnClickListener(this.noS);
        this.WO.addHeaderView(this.noT);
        this.noT.setVisibility(8);
        this.noV = (RelativeLayout) this.noT.findViewById(R.id.guidecontainer);
        this.noY = (LinearLayout) this.noT.findViewById(R.id.guideopenbtn);
        this.noW = (TextView) this.noT.findViewById(R.id.guidetip);
        this.noX = (TextView) this.noT.findViewById(R.id.guideopen);
        this.noY.setOnClickListener(this.noS);
        this.noU = new g(this.noS, null);
        this.WO.setAdapter((ListAdapter) this.noU);
        this.WO.setOnScrollListener(this.noU);
    }

    public void onChangeSkinType(int i) {
        this.noS.getLayoutMode().setNightMode(i == 1);
        this.noS.getLayoutMode().onModeChanged(this.mRootView);
        this.noS.getLayoutMode().onModeChanged(this.noZ);
        this.noS.getLayoutMode().onModeChanged(this.noT);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.noT != null) {
            this.noT.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.noU.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.nnu = cVar;
            dLh();
            ArrayList<d> dKw = cVar.dKw();
            this.noU.c(this.nnu);
            if (dKw.size() == noR) {
                this.noZ.setVisibility(0);
                this.noZ.setText(cVar.dKt());
            } else {
                this.noZ.setVisibility(8);
            }
            String dKn = this.nnu.dKn();
            if (!StringUtils.isNull(dKn)) {
                this.noT.a(this.noS, dKn, this.nnu.dKo());
                return;
            }
            this.noT.dLg();
        }
    }

    private void dLh() {
        if (this.nnu != null) {
            this.noT.setHasPrivilege(this.nnu.dKA());
            this.noT.setmCurrentStatus(this.nnu.dKC());
            TextView message1 = this.noT.getMessage1();
            SpannableString spannableString = new SpannableString(this.nnu.dKq() + this.nnu.Bs() + this.nnu.dKr());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.nnu.dKq().length();
            spannableString.setSpan(foregroundColorSpan, length, this.nnu.Bs().length() + length, 33);
            message1.setText(spannableString);
            this.noT.getMessage2().setText(this.nnu.dKs());
            this.noW.setText(this.nnu.getContent());
            if (TextUtils.isEmpty(this.nnu.dKB())) {
                this.noX.setText(R.string.member_buy_open);
            } else {
                this.noX.setText(this.nnu.dKB());
            }
            this.noT.setVisibility(0);
            if (this.nnu.dKA() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.noV.setVisibility(8);
            } else {
                this.noV.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.WO.startPullRefresh();
    }

    public void completeRefresh() {
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.WO.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dLi() {
        return this.noT;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dLj() {
        return this.WO;
    }

    public c dLk() {
        return this.nnu;
    }

    public g dLl() {
        return this.noU;
    }

    public LinearLayout dLm() {
        return this.noY;
    }

    public void setListViewSelection(int i) {
        this.WO.setSelection(i);
    }

    public RelativeLayout cnn() {
        return this.mRootView;
    }
}
