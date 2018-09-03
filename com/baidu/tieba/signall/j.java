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
import com.baidu.tieba.f;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gFX;
    private c gED;
    private SignAllForumActivity gFY;
    private ViewGroup gFZ;
    private SignAllForumProgressView gGa;
    private BdListView gGb;
    private g gGc;
    private RelativeLayout gGd;
    private TextView gGe;
    private TextView gGf;
    private LinearLayout gGg;
    private TextView gGh;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.h mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gFY = signAllForumActivity;
        this.gFY.setContentView(f.h.signallforum_view);
        this.gFZ = (ViewGroup) this.gFY.findViewById(f.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gFY.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gFY.getPageContext().getString(f.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gFY.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gGb = (BdListView) this.gFY.findViewById(f.g.signallforum_list);
        this.gGb.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.h(signAllForumActivity.getPageContext());
        this.gGb.setPullRefresh(this.mPullView);
        this.gGh = (TextView) LayoutInflater.from(this.gFY.getPageContext().getPageActivity()).inflate(f.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.gGb.addFooterView(this.gGh);
        this.gGa = new SignAllForumProgressView(this.gFY.getPageContext().getPageActivity());
        this.mProgressBar = this.gGa.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gFY);
        this.gGb.addHeaderView(this.gGa);
        this.gGa.setVisibility(8);
        this.gGd = (RelativeLayout) this.gGa.findViewById(f.g.guidecontainer);
        this.gGg = (LinearLayout) this.gGa.findViewById(f.g.guideopenbtn);
        this.gGe = (TextView) this.gGa.findViewById(f.g.guidetip);
        this.gGf = (TextView) this.gGa.findViewById(f.g.guideopen);
        this.gGg.setOnClickListener(this.gFY);
        this.gGc = new g(this.gFY, null);
        this.gGb.setAdapter((ListAdapter) this.gGc);
        this.gGb.setOnScrollListener(this.gGc);
    }

    public void onChangeSkinType(int i) {
        this.gFY.getLayoutMode().setNightMode(i == 1);
        this.gFY.getLayoutMode().onModeChanged(this.gFZ);
        this.gFY.getLayoutMode().onModeChanged(this.gGh);
        this.gFY.getLayoutMode().onModeChanged(this.gGa);
        am.j(this.gFZ, f.d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dB(i);
        this.gGc.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gED = cVar;
            bta();
            ArrayList<d> bso = cVar.bso();
            this.gGc.c(this.gED);
            if (bso.size() == gFX) {
                this.gGh.setVisibility(0);
                this.gGh.setText(cVar.bsl());
            } else {
                this.gGh.setVisibility(8);
            }
            String bsf = this.gED.bsf();
            if (!StringUtils.isNull(bsf)) {
                this.gGa.a(this.gFY, bsf, this.gED.bsg());
                return;
            }
            this.gGa.bsY();
        }
    }

    private void bta() {
        if (this.gED != null) {
            this.gGa.setHasPrivilege(this.gED.bss());
            this.gGa.setmCurrentStatus(this.gED.bsu());
            TextView message1 = this.gGa.getMessage1();
            SpannableString spannableString = new SpannableString(this.gED.bsi() + this.gED.bgd() + this.gED.bsj());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(f.d.common_color_10191));
            int length = this.gED.bsi().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gED.bgd().length() + length, 33);
            message1.setText(spannableString);
            this.gGa.getMessage2().setText(this.gED.bsk());
            this.gGe.setText(this.gED.getContent());
            if (TextUtils.isEmpty(this.gED.bst())) {
                this.gGf.setText(f.j.member_buy_open);
            } else {
                this.gGf.setText(this.gED.bst());
            }
            this.gGa.setVisibility(0);
            if (this.gED.bss() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gGd.setVisibility(8);
            } else {
                this.gGd.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gGb.startPullRefresh();
    }

    public void nV() {
        this.gGb.completePullRefreshPostDelayed(2000L);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gGb.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView btb() {
        return this.gGa;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView btc() {
        return this.gGb;
    }

    public c btd() {
        return this.gED;
    }

    public g bte() {
        return this.gGc;
    }

    public LinearLayout btf() {
        return this.gGg;
    }

    public void setListViewSelection(int i) {
        this.gGb.setSelection(i);
    }
}
