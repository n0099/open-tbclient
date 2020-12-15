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
/* loaded from: classes24.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int neh;
    private BdListView WX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c ncM;
    private SignAllForumActivity nei;
    private SignAllForumProgressView nej;
    private g nek;
    private RelativeLayout nel;
    private TextView nem;
    private TextView nen;
    private LinearLayout neo;
    private TextView nep;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.nei = signAllForumActivity;
        this.nei.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.nei.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.nei.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.nei.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.nei.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WX = (BdListView) this.nei.findViewById(R.id.signallforum_list);
        this.WX.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WX.setPullRefresh(this.mPullView);
        this.nep = (TextView) LayoutInflater.from(this.nei.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WX.addFooterView(this.nep);
        this.nej = new SignAllForumProgressView(this.nei.getPageContext().getPageActivity());
        this.mProgressBar = this.nej.getProgressBar();
        this.mProgressBar.setOnClickListener(this.nei);
        this.WX.addHeaderView(this.nej);
        this.nej.setVisibility(8);
        this.nel = (RelativeLayout) this.nej.findViewById(R.id.guidecontainer);
        this.neo = (LinearLayout) this.nej.findViewById(R.id.guideopenbtn);
        this.nem = (TextView) this.nej.findViewById(R.id.guidetip);
        this.nen = (TextView) this.nej.findViewById(R.id.guideopen);
        this.neo.setOnClickListener(this.nei);
        this.nek = new g(this.nei, null);
        this.WX.setAdapter((ListAdapter) this.nek);
        this.WX.setOnScrollListener(this.nek);
    }

    public void onChangeSkinType(int i) {
        this.nei.getLayoutMode().setNightMode(i == 1);
        this.nei.getLayoutMode().onModeChanged(this.mRootView);
        this.nei.getLayoutMode().onModeChanged(this.nep);
        this.nei.getLayoutMode().onModeChanged(this.nej);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.nej != null) {
            this.nej.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.nek.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.ncM = cVar;
            dMV();
            ArrayList<d> dMk = cVar.dMk();
            this.nek.c(this.ncM);
            if (dMk.size() == neh) {
                this.nep.setVisibility(0);
                this.nep.setText(cVar.dMh());
            } else {
                this.nep.setVisibility(8);
            }
            String dMb = this.ncM.dMb();
            if (!StringUtils.isNull(dMb)) {
                this.nej.a(this.nei, dMb, this.ncM.dMc());
                return;
            }
            this.nej.dMU();
        }
    }

    private void dMV() {
        if (this.ncM != null) {
            this.nej.setHasPrivilege(this.ncM.dMo());
            this.nej.setmCurrentStatus(this.ncM.dMq());
            TextView message1 = this.nej.getMessage1();
            SpannableString spannableString = new SpannableString(this.ncM.dMe() + this.ncM.dvm() + this.ncM.dMf());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.ncM.dMe().length();
            spannableString.setSpan(foregroundColorSpan, length, this.ncM.dvm().length() + length, 33);
            message1.setText(spannableString);
            this.nej.getMessage2().setText(this.ncM.dMg());
            this.nem.setText(this.ncM.getContent());
            if (TextUtils.isEmpty(this.ncM.dMp())) {
                this.nen.setText(R.string.member_buy_open);
            } else {
                this.nen.setText(this.ncM.dMp());
            }
            this.nej.setVisibility(0);
            if (this.ncM.dMo() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.nel.setVisibility(8);
            } else {
                this.nel.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.WX.startPullRefresh();
    }

    public void completeRefresh() {
        this.WX.completePullRefreshPostDelayed(0L);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.WX.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView dMW() {
        return this.nej;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dMX() {
        return this.WX;
    }

    public c dMY() {
        return this.ncM;
    }

    public g dMZ() {
        return this.nek;
    }

    public LinearLayout dNa() {
        return this.neo;
    }

    public void setListViewSelection(int i) {
        this.WX.setSelection(i);
    }

    public RelativeLayout cno() {
        return this.mRootView;
    }
}
