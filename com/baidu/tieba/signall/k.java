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
    public static int gSV;
    private c gRC;
    private SignAllForumActivity gSW;
    private ViewGroup gSX;
    private j gSY;
    private BdListView gSZ;
    private g gTa;
    private RelativeLayout gTb;
    private TextView gTc;
    private TextView gTd;
    private LinearLayout gTe;
    private TextView gTf;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.k mPullView;

    public k(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gSW = signAllForumActivity;
        this.gSW.setContentView(d.h.signallforum_view);
        this.gSX = (ViewGroup) this.gSW.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gSW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gSW.getPageContext().getString(d.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.gSW.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gSZ = (BdListView) this.gSW.findViewById(d.g.signallforum_list);
        this.gSZ.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.k(signAllForumActivity.getPageContext());
        this.gSZ.setPullRefresh(this.mPullView);
        this.gTf = (TextView) LayoutInflater.from(this.gSW.getPageContext().getPageActivity()).inflate(d.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.gSZ.addFooterView(this.gTf);
        this.gSY = new j(this.gSW.getPageContext().getPageActivity());
        this.mProgressBar = this.gSY.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gSW);
        this.gSZ.addHeaderView(this.gSY);
        this.gSY.setVisibility(8);
        this.gTb = (RelativeLayout) this.gSY.findViewById(d.g.guidecontainer);
        this.gTe = (LinearLayout) this.gSY.findViewById(d.g.guideopenbtn);
        this.gTc = (TextView) this.gSY.findViewById(d.g.guidetip);
        this.gTd = (TextView) this.gSY.findViewById(d.g.guideopen);
        this.gTe.setOnClickListener(this.gSW);
        this.gTa = new g(this.gSW, null);
        this.gSZ.setAdapter((ListAdapter) this.gTa);
        this.gSZ.setOnScrollListener(this.gTa);
    }

    public void onChangeSkinType(int i) {
        this.gSW.getLayoutMode().aQ(i == 1);
        this.gSW.getLayoutMode().aM(this.gSX);
        this.gSW.getLayoutMode().aM(this.gTf);
        this.gSW.getLayoutMode().aM(this.gSY);
        aj.t(this.gSX, d.C0141d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.gx(i);
        this.gTa.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gRC = cVar;
            btP();
            ArrayList<d> btc = cVar.btc();
            this.gTa.c(this.gRC);
            if (btc.size() == gSV) {
                this.gTf.setVisibility(0);
                this.gTf.setText(cVar.bsZ());
            } else {
                this.gTf.setVisibility(8);
            }
            String bsT = this.gRC.bsT();
            if (!StringUtils.isNull(bsT)) {
                this.gSY.a(this.gSW, bsT, this.gRC.bsU());
                return;
            }
            this.gSY.btN();
        }
    }

    private void btP() {
        if (this.gRC != null) {
            this.gSY.setHasPrivilege(this.gRC.btg());
            this.gSY.setmCurrentStatus(this.gRC.bti());
            TextView message1 = this.gSY.getMessage1();
            SpannableString spannableString = new SpannableString(this.gRC.bsW() + this.gRC.bhi() + this.gRC.bsX());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0141d.common_color_10191));
            int length = this.gRC.bsW().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gRC.bhi().length() + length, 33);
            message1.setText(spannableString);
            this.gSY.getMessage2().setText(this.gRC.bsY());
            this.gTc.setText(this.gRC.getContent());
            if (TextUtils.isEmpty(this.gRC.bth())) {
                this.gTd.setText(d.j.member_buy_open);
            } else {
                this.gTd.setText(this.gRC.bth());
            }
            this.gSY.setVisibility(0);
            if (this.gRC.btg() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gTb.setVisibility(8);
            } else {
                this.gTb.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gSZ.startPullRefresh();
    }

    public void sV() {
        this.gSZ.completePullRefreshPostDelayed(2000L);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gSZ.setOnItemClickListener(onItemClickListener);
    }

    public j btQ() {
        return this.gSY;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView btR() {
        return this.gSZ;
    }

    public c btS() {
        return this.gRC;
    }

    public g btT() {
        return this.gTa;
    }

    public LinearLayout btU() {
        return this.gTe;
    }

    public void setListViewSelection(int i) {
        this.gSZ.setSelection(i);
    }
}
