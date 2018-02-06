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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gTk;
    private c gRR;
    private SignAllForumActivity gTl;
    private ViewGroup gTm;
    private j gTn;
    private BdListView gTo;
    private g gTp;
    private RelativeLayout gTq;
    private TextView gTr;
    private TextView gTs;
    private LinearLayout gTt;
    private TextView gTu;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;

    public k(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gTl = signAllForumActivity;
        this.gTl.setContentView(d.h.signallforum_view);
        this.gTm = (ViewGroup) this.gTl.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gTl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gTl.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.gTl.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gTo = (BdListView) this.gTl.findViewById(d.g.signallforum_list);
        this.gTo.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.gTo.setPullRefresh(this.mPullView);
        this.gTu = (TextView) LayoutInflater.from(this.gTl.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.gTo.addFooterView(this.gTu);
        this.gTn = new j(this.gTl.getPageContext().getPageActivity());
        this.mProgressBar = this.gTn.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gTl);
        this.gTo.addHeaderView(this.gTn);
        this.gTn.setVisibility(8);
        this.gTq = (RelativeLayout) this.gTn.findViewById(d.g.guidecontainer);
        this.gTt = (LinearLayout) this.gTn.findViewById(d.g.guideopenbtn);
        this.gTr = (TextView) this.gTn.findViewById(d.g.guidetip);
        this.gTs = (TextView) this.gTn.findViewById(d.g.guideopen);
        this.gTt.setOnClickListener(this.gTl);
        this.gTp = new g(this.gTl, null);
        this.gTo.setAdapter((ListAdapter) this.gTp);
        this.gTo.setOnScrollListener(this.gTp);
    }

    public void onChangeSkinType(int i) {
        this.gTl.getLayoutMode().aQ(i == 1);
        this.gTl.getLayoutMode().aM(this.gTm);
        this.gTl.getLayoutMode().aM(this.gTu);
        this.gTl.getLayoutMode().aM(this.gTn);
        aj.t(this.gTm, d.C0140d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        this.gTp.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gRR = cVar;
            btQ();
            ArrayList<d> btd = cVar.btd();
            this.gTp.c(this.gRR);
            if (btd.size() == gTk) {
                this.gTu.setVisibility(0);
                this.gTu.setText(cVar.bta());
            } else {
                this.gTu.setVisibility(8);
            }
            String bsU = this.gRR.bsU();
            if (!StringUtils.isNull(bsU)) {
                this.gTn.a(this.gTl, bsU, this.gRR.bsV());
                return;
            }
            this.gTn.btO();
        }
    }

    private void btQ() {
        if (this.gRR != null) {
            this.gTn.setHasPrivilege(this.gRR.bth());
            this.gTn.setmCurrentStatus(this.gRR.btj());
            TextView message1 = this.gTn.getMessage1();
            SpannableString spannableString = new SpannableString(this.gRR.bsX() + this.gRR.bhj() + this.gRR.bsY());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0140d.common_color_10191));
            int length = this.gRR.bsX().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gRR.bhj().length() + length, 33);
            message1.setText(spannableString);
            this.gTn.getMessage2().setText(this.gRR.bsZ());
            this.gTr.setText(this.gRR.getContent());
            if (TextUtils.isEmpty(this.gRR.bti())) {
                this.gTs.setText(d.j.member_buy_open);
            } else {
                this.gTs.setText(this.gRR.bti());
            }
            this.gTn.setVisibility(0);
            if (this.gRR.bth() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gTq.setVisibility(8);
            } else {
                this.gTq.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gTo.startPullRefresh();
    }

    public void sV() {
        this.gTo.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gTo.setOnItemClickListener(onItemClickListener);
    }

    public j btR() {
        return this.gTn;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView btS() {
        return this.gTo;
    }

    public c btT() {
        return this.gRR;
    }

    public g btU() {
        return this.gTp;
    }

    public LinearLayout btV() {
        return this.gTt;
    }

    public void setListViewSelection(int i) {
        this.gTo.setSelection(i);
    }
}
