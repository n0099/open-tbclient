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
    public static int nef;
    private BdListView WX;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private RelativeLayout mRootView;
    private c ncK;
    private SignAllForumActivity neg;
    private SignAllForumProgressView neh;
    private g nei;
    private RelativeLayout nej;
    private TextView nek;
    private TextView nel;
    private LinearLayout nem;
    private TextView nen;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.neg = signAllForumActivity;
        this.neg.setContentView(R.layout.signallforum_view);
        this.mRootView = (RelativeLayout) this.neg.findViewById(R.id.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.neg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.neg.getPageContext().getString(R.string.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.neg.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.WX = (BdListView) this.neg.findViewById(R.id.signallforum_list);
        this.WX.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.WX.setPullRefresh(this.mPullView);
        this.nen = (TextView) LayoutInflater.from(this.neg.getPageContext().getPageActivity()).inflate(R.layout.signallforum_maxcount_warning, (ViewGroup) null);
        this.WX.addFooterView(this.nen);
        this.neh = new SignAllForumProgressView(this.neg.getPageContext().getPageActivity());
        this.mProgressBar = this.neh.getProgressBar();
        this.mProgressBar.setOnClickListener(this.neg);
        this.WX.addHeaderView(this.neh);
        this.neh.setVisibility(8);
        this.nej = (RelativeLayout) this.neh.findViewById(R.id.guidecontainer);
        this.nem = (LinearLayout) this.neh.findViewById(R.id.guideopenbtn);
        this.nek = (TextView) this.neh.findViewById(R.id.guidetip);
        this.nel = (TextView) this.neh.findViewById(R.id.guideopen);
        this.nem.setOnClickListener(this.neg);
        this.nei = new g(this.neg, null);
        this.WX.setAdapter((ListAdapter) this.nei);
        this.WX.setOnScrollListener(this.nei);
    }

    public void onChangeSkinType(int i) {
        this.neg.getLayoutMode().setNightMode(i == 1);
        this.neg.getLayoutMode().onModeChanged(this.mRootView);
        this.neg.getLayoutMode().onModeChanged(this.nen);
        this.neg.getLayoutMode().onModeChanged(this.neh);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.neh != null) {
            this.neh.onChangeSkinType();
        }
        this.mPullView.changeSkin(i);
        this.nei.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.ncK = cVar;
            dMU();
            ArrayList<d> dMj = cVar.dMj();
            this.nei.c(this.ncK);
            if (dMj.size() == nef) {
                this.nen.setVisibility(0);
                this.nen.setText(cVar.dMg());
            } else {
                this.nen.setVisibility(8);
            }
            String dMa = this.ncK.dMa();
            if (!StringUtils.isNull(dMa)) {
                this.neh.a(this.neg, dMa, this.ncK.dMb());
                return;
            }
            this.neh.dMT();
        }
    }

    private void dMU() {
        if (this.ncK != null) {
            this.neh.setHasPrivilege(this.ncK.dMn());
            this.neh.setmCurrentStatus(this.ncK.dMp());
            TextView message1 = this.neh.getMessage1();
            SpannableString spannableString = new SpannableString(this.ncK.dMd() + this.ncK.dvl() + this.ncK.dMe());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
            int length = this.ncK.dMd().length();
            spannableString.setSpan(foregroundColorSpan, length, this.ncK.dvl().length() + length, 33);
            message1.setText(spannableString);
            this.neh.getMessage2().setText(this.ncK.dMf());
            this.nek.setText(this.ncK.getContent());
            if (TextUtils.isEmpty(this.ncK.dMo())) {
                this.nel.setText(R.string.member_buy_open);
            } else {
                this.nel.setText(this.ncK.dMo());
            }
            this.neh.setVisibility(0);
            if (this.ncK.dMn() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.nej.setVisibility(8);
            } else {
                this.nej.setVisibility(0);
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

    public SignAllForumProgressView dMV() {
        return this.neh;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView dMW() {
        return this.WX;
    }

    public c dMX() {
        return this.ncK;
    }

    public g dMY() {
        return this.nei;
    }

    public LinearLayout dMZ() {
        return this.nem;
    }

    public void setListViewSelection(int i) {
        this.WX.setSelection(i);
    }

    public RelativeLayout cnn() {
        return this.mRootView;
    }
}
