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
    public static int npr;
    private BdListView WO;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c nnU;
    private SignAllForumActivity nps;
    private SignAllForumProgressView npt;
    private g npu;
    private RelativeLayout npv;
    private TextView npw;
    private TextView npx;
    private LinearLayout npy;
    private TextView npz;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.nps = signAllForumActivity;
        this.nps.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.nps.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.nps.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.nps.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.nps.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WO = (BdListView) this.nps.findViewById(R.id.signallforum_list);
        this.WO.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WO.setPullRefresh(this.mPullView);
        this.npz = (TextView) LayoutInflater.from(this.nps.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WO.addFooterView(this.npz);
        this.npt = new SignAllForumProgressView(this.nps.getPageContext().getPageActivity());
        this.mProgressBar = this.npt.getProgressBar();
        this.mProgressBar.setOnClickListener(this.nps);
        this.WO.addHeaderView(this.npt);
        this.npt.setVisibility(8);
        this.npv = (RelativeLayout) this.npt.findViewById(R.id.guidecontainer);
        this.npy = (LinearLayout) this.npt.findViewById(R.id.guideopenbtn);
        this.npw = (TextView) this.npt.findViewById(R.id.guidetip);
        this.npx = (TextView) this.npt.findViewById(R.id.guideopen);
        this.npy.setOnClickListener(this.nps);
        this.npu = new g(this.nps, null);
        this.WO.setAdapter((ListAdapter) this.npu);
        this.WO.setOnScrollListener(this.npu);
    }

    public void onChangeSkinType(int i) {
        this.nps.getLayoutMode().setNightMode(i == 1);
        this.nps.getLayoutMode().onModeChanged(this.mRootView);
        this.nps.getLayoutMode().onModeChanged(this.npz);
        this.nps.getLayoutMode().onModeChanged(this.npt);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.npt != null) {
            this.npt.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.npu.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.nnU = cVar;
            dLp();
            ArrayList<d> dKE = cVar.dKE();
            this.npu.c(this.nnU);
            if (dKE.size() == npr) {
                this.npz.setVisibility(0);
                this.npz.setText(cVar.dKB());
            } else {
                this.npz.setVisibility(8);
            }
            String dKv = this.nnU.dKv();
            if (!StringUtils.isNull(dKv)) {
                this.npt.a(this.nps, dKv, this.nnU.dKw());
                return;
            }
            this.npt.dLo();
        }
    }

    private void dLp() {
        if (this.nnU != null) {
            this.npt.setHasPrivilege(this.nnU.dKI());
            this.npt.setmCurrentStatus(this.nnU.dKK());
            TextView message1 = this.npt.getMessage1();
            SpannableString spannableString = new SpannableString(this.nnU.dKy() + this.nnU.Bs() + this.nnU.dKz());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.nnU.dKy().length();
            spannableString.setSpan(foregroundColorSpan, length, this.nnU.Bs().length() + length, 33);
            message1.setText(spannableString);
            this.npt.getMessage2().setText(this.nnU.dKA());
            this.npw.setText(this.nnU.getContent());
            if (TextUtils.isEmpty(this.nnU.dKJ())) {
                this.npx.setText(R.string.member_buy_open);
            } else {
                this.npx.setText(this.nnU.dKJ());
            }
            this.npt.setVisibility(0);
            if (this.nnU.dKI() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.npv.setVisibility(8);
            } else {
                this.npv.setVisibility(0);
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

    public SignAllForumProgressView dLq() {
        return this.npt;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dLr() {
        return this.WO;
    }

    public c dLs() {
        return this.nnU;
    }

    public g dLt() {
        return this.npu;
    }

    public LinearLayout dLu() {
        return this.npy;
    }

    public void setListViewSelection(int i) {
        this.WO.setSelection(i);
    }

    public RelativeLayout cnu() {
        return this.mRootView;
    }
}
