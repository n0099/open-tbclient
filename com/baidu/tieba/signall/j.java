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
import com.baidu.tieba.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gFU;
    private c gEA;
    private SignAllForumActivity gFV;
    private ViewGroup gFW;
    private SignAllForumProgressView gFX;
    private BdListView gFY;
    private g gFZ;
    private RelativeLayout gGa;
    private TextView gGb;
    private TextView gGc;
    private LinearLayout gGd;
    private TextView gGe;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gFV = signAllForumActivity;
        this.gFV.setContentView(d.h.signallforum_view);
        this.gFW = (ViewGroup) this.gFV.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gFV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gFV.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gFV.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gFY = (BdListView) this.gFV.findViewById(d.g.signallforum_list);
        this.gFY.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.gFY.setPullRefresh(this.mPullView);
        this.gGe = (TextView) LayoutInflater.from(this.gFV.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.gFY.addFooterView(this.gGe);
        this.gFX = new SignAllForumProgressView(this.gFV.getPageContext().getPageActivity());
        this.mProgressBar = this.gFX.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gFV);
        this.gFY.addHeaderView(this.gFX);
        this.gFX.setVisibility(8);
        this.gGa = (RelativeLayout) this.gFX.findViewById(d.g.guidecontainer);
        this.gGd = (LinearLayout) this.gFX.findViewById(d.g.guideopenbtn);
        this.gGb = (TextView) this.gFX.findViewById(d.g.guidetip);
        this.gGc = (TextView) this.gFX.findViewById(d.g.guideopen);
        this.gGd.setOnClickListener(this.gFV);
        this.gFZ = new g(this.gFV, null);
        this.gFY.setAdapter((ListAdapter) this.gFZ);
        this.gFY.setOnScrollListener(this.gFZ);
    }

    public void onChangeSkinType(int i) {
        this.gFV.getLayoutMode().setNightMode(i == 1);
        this.gFV.getLayoutMode().onModeChanged(this.gFW);
        this.gFV.getLayoutMode().onModeChanged(this.gGe);
        this.gFV.getLayoutMode().onModeChanged(this.gFX);
        am.j(this.gFW, d.C0140d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dC(i);
        this.gFZ.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gEA = cVar;
            bsZ();
            ArrayList<d> bsn = cVar.bsn();
            this.gFZ.c(this.gEA);
            if (bsn.size() == gFU) {
                this.gGe.setVisibility(0);
                this.gGe.setText(cVar.bsk());
            } else {
                this.gGe.setVisibility(8);
            }
            String bse = this.gEA.bse();
            if (!StringUtils.isNull(bse)) {
                this.gFX.a(this.gFV, bse, this.gEA.bsf());
                return;
            }
            this.gFX.bsX();
        }
    }

    private void bsZ() {
        if (this.gEA != null) {
            this.gFX.setHasPrivilege(this.gEA.bsr());
            this.gFX.setmCurrentStatus(this.gEA.bst());
            TextView message1 = this.gFX.getMessage1();
            SpannableString spannableString = new SpannableString(this.gEA.bsh() + this.gEA.bgi() + this.gEA.bsi());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0140d.common_color_10191));
            int length = this.gEA.bsh().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gEA.bgi().length() + length, 33);
            message1.setText(spannableString);
            this.gFX.getMessage2().setText(this.gEA.bsj());
            this.gGb.setText(this.gEA.getContent());
            if (TextUtils.isEmpty(this.gEA.bss())) {
                this.gGc.setText(d.j.member_buy_open);
            } else {
                this.gGc.setText(this.gEA.bss());
            }
            this.gFX.setVisibility(0);
            if (this.gEA.bsr() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gGa.setVisibility(8);
            } else {
                this.gGa.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gFY.startPullRefresh();
    }

    public void nY() {
        this.gFY.completePullRefreshPostDelayed(2000L);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gFY.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView bta() {
        return this.gFX;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView btb() {
        return this.gFY;
    }

    public c btc() {
        return this.gEA;
    }

    public g btd() {
        return this.gFZ;
    }

    public LinearLayout bte() {
        return this.gGd;
    }

    public void setListViewSelection(int i) {
        this.gFY.setSelection(i);
    }
}
