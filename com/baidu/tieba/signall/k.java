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
    public static int gTl;
    private c gRS;
    private SignAllForumActivity gTm;
    private ViewGroup gTn;
    private j gTo;
    private BdListView gTp;
    private g gTq;
    private RelativeLayout gTr;
    private TextView gTs;
    private TextView gTt;
    private LinearLayout gTu;
    private TextView gTv;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;

    public k(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gTm = signAllForumActivity;
        this.gTm.setContentView(d.h.signallforum_view);
        this.gTn = (ViewGroup) this.gTm.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gTm.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gTm.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.gTm.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gTp = (BdListView) this.gTm.findViewById(d.g.signallforum_list);
        this.gTp.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.gTp.setPullRefresh(this.mPullView);
        this.gTv = (TextView) LayoutInflater.from(this.gTm.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.gTp.addFooterView(this.gTv);
        this.gTo = new j(this.gTm.getPageContext().getPageActivity());
        this.mProgressBar = this.gTo.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gTm);
        this.gTp.addHeaderView(this.gTo);
        this.gTo.setVisibility(8);
        this.gTr = (RelativeLayout) this.gTo.findViewById(d.g.guidecontainer);
        this.gTu = (LinearLayout) this.gTo.findViewById(d.g.guideopenbtn);
        this.gTs = (TextView) this.gTo.findViewById(d.g.guidetip);
        this.gTt = (TextView) this.gTo.findViewById(d.g.guideopen);
        this.gTu.setOnClickListener(this.gTm);
        this.gTq = new g(this.gTm, null);
        this.gTp.setAdapter((ListAdapter) this.gTq);
        this.gTp.setOnScrollListener(this.gTq);
    }

    public void onChangeSkinType(int i) {
        this.gTm.getLayoutMode().aQ(i == 1);
        this.gTm.getLayoutMode().aM(this.gTn);
        this.gTm.getLayoutMode().aM(this.gTv);
        this.gTm.getLayoutMode().aM(this.gTo);
        aj.t(this.gTn, d.C0141d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        this.gTq.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gRS = cVar;
            btQ();
            ArrayList<d> btd = cVar.btd();
            this.gTq.c(this.gRS);
            if (btd.size() == gTl) {
                this.gTv.setVisibility(0);
                this.gTv.setText(cVar.bta());
            } else {
                this.gTv.setVisibility(8);
            }
            String bsU = this.gRS.bsU();
            if (!StringUtils.isNull(bsU)) {
                this.gTo.a(this.gTm, bsU, this.gRS.bsV());
                return;
            }
            this.gTo.btO();
        }
    }

    private void btQ() {
        if (this.gRS != null) {
            this.gTo.setHasPrivilege(this.gRS.bth());
            this.gTo.setmCurrentStatus(this.gRS.btj());
            TextView message1 = this.gTo.getMessage1();
            SpannableString spannableString = new SpannableString(this.gRS.bsX() + this.gRS.bhj() + this.gRS.bsY());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0141d.common_color_10191));
            int length = this.gRS.bsX().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gRS.bhj().length() + length, 33);
            message1.setText(spannableString);
            this.gTo.getMessage2().setText(this.gRS.bsZ());
            this.gTs.setText(this.gRS.getContent());
            if (TextUtils.isEmpty(this.gRS.bti())) {
                this.gTt.setText(d.j.member_buy_open);
            } else {
                this.gTt.setText(this.gRS.bti());
            }
            this.gTo.setVisibility(0);
            if (this.gRS.bth() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gTr.setVisibility(8);
            } else {
                this.gTr.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gTp.startPullRefresh();
    }

    public void sV() {
        this.gTp.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gTp.setOnItemClickListener(onItemClickListener);
    }

    public j btR() {
        return this.gTo;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView btS() {
        return this.gTp;
    }

    public c btT() {
        return this.gRS;
    }

    public g btU() {
        return this.gTq;
    }

    public LinearLayout btV() {
        return this.gTu;
    }

    public void setListViewSelection(int i) {
        this.gTp.setSelection(i);
    }
}
