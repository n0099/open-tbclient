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
/* loaded from: classes8.dex */
public class j extends com.baidu.adp.base.d<SignAllForumActivity> {
    public static int njN;
    private BdListView WV;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c nis;
    private SignAllForumActivity njO;
    private SignAllForumProgressView njP;
    private g njQ;
    private RelativeLayout njR;
    private TextView njS;
    private TextView njT;
    private LinearLayout njU;
    private TextView njV;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.njO = signAllForumActivity;
        this.njO.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.njO.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.njO.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.njO.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.njO.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WV = (BdListView) this.njO.findViewById(R.id.signallforum_list);
        this.WV.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WV.setPullRefresh(this.mPullView);
        this.njV = (TextView) LayoutInflater.from(this.njO.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WV.addFooterView(this.njV);
        this.njP = new SignAllForumProgressView(this.njO.getPageContext().getPageActivity());
        this.mProgressBar = this.njP.getProgressBar();
        this.mProgressBar.setOnClickListener(this.njO);
        this.WV.addHeaderView(this.njP);
        this.njP.setVisibility(8);
        this.njR = (RelativeLayout) this.njP.findViewById(R.id.guidecontainer);
        this.njU = (LinearLayout) this.njP.findViewById(R.id.guideopenbtn);
        this.njS = (TextView) this.njP.findViewById(R.id.guidetip);
        this.njT = (TextView) this.njP.findViewById(R.id.guideopen);
        this.njU.setOnClickListener(this.njO);
        this.njQ = new g(this.njO, null);
        this.WV.setAdapter((ListAdapter) this.njQ);
        this.WV.setOnScrollListener(this.njQ);
    }

    public void onChangeSkinType(int i) {
        this.njO.getLayoutMode().setNightMode(i == 1);
        this.njO.getLayoutMode().onModeChanged(this.mRootView);
        this.njO.getLayoutMode().onModeChanged(this.njV);
        this.njO.getLayoutMode().onModeChanged(this.njP);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.njP != null) {
            this.njP.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.njQ.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.nis = cVar;
            dMO();
            ArrayList<d> dMd = cVar.dMd();
            this.njQ.c(this.nis);
            if (dMd.size() == njN) {
                this.njV.setVisibility(0);
                this.njV.setText(cVar.dMa());
            } else {
                this.njV.setVisibility(8);
            }
            String dLU = this.nis.dLU();
            if (!StringUtils.isNull(dLU)) {
                this.njP.a(this.njO, dLU, this.nis.dLV());
                return;
            }
            this.njP.dMN();
        }
    }

    private void dMO() {
        if (this.nis != null) {
            this.njP.setHasPrivilege(this.nis.dMh());
            this.njP.setmCurrentStatus(this.nis.dMj());
            TextView message1 = this.njP.getMessage1();
            SpannableString spannableString = new SpannableString(this.nis.dLX() + this.nis.dvc() + this.nis.dLY());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.nis.dLX().length();
            spannableString.setSpan(foregroundColorSpan, length, this.nis.dvc().length() + length, 33);
            message1.setText(spannableString);
            this.njP.getMessage2().setText(this.nis.dLZ());
            this.njS.setText(this.nis.getContent());
            if (TextUtils.isEmpty(this.nis.dMi())) {
                this.njT.setText(R.string.member_buy_open);
            } else {
                this.njT.setText(this.nis.dMi());
            }
            this.njP.setVisibility(0);
            if (this.nis.dMh() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.njR.setVisibility(8);
            } else {
                this.njR.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.WV.startPullRefresh();
    }

    public void completeRefresh() {
        this.WV.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.WV.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dMP() {
        return this.njP;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dMQ() {
        return this.WV;
    }

    public c dMR() {
        return this.nis;
    }

    public g dMS() {
        return this.njQ;
    }

    public LinearLayout dMT() {
        return this.njU;
    }

    public void setListViewSelection(int i) {
        this.WV.setSelection(i);
    }

    public RelativeLayout cqh() {
        return this.mRootView;
    }
}
