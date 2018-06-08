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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gAS;
    private SignAllForumActivity gAT;
    private ViewGroup gAU;
    private SignAllForumProgressView gAV;
    private BdListView gAW;
    private g gAX;
    private RelativeLayout gAY;
    private TextView gAZ;
    private TextView gBa;
    private LinearLayout gBb;
    private TextView gBc;
    private c gzz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gAT = signAllForumActivity;
        this.gAT.setContentView(d.i.signallforum_view);
        this.gAU = (ViewGroup) this.gAT.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gAT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gAT.getPageContext().getString(d.k.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.gAT.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gAW = (BdListView) this.gAT.findViewById(d.g.signallforum_list);
        this.gAW.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.g(signAllForumActivity.getPageContext());
        this.gAW.setPullRefresh(this.mPullView);
        this.gBc = (TextView) LayoutInflater.from(this.gAT.getPageContext().getPageActivity()).inflate(d.i.signallforum_maxcount_warning, (ViewGroup) null);
        this.gAW.addFooterView(this.gBc);
        this.gAV = new SignAllForumProgressView(this.gAT.getPageContext().getPageActivity());
        this.mProgressBar = this.gAV.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gAT);
        this.gAW.addHeaderView(this.gAV);
        this.gAV.setVisibility(8);
        this.gAY = (RelativeLayout) this.gAV.findViewById(d.g.guidecontainer);
        this.gBb = (LinearLayout) this.gAV.findViewById(d.g.guideopenbtn);
        this.gAZ = (TextView) this.gAV.findViewById(d.g.guidetip);
        this.gBa = (TextView) this.gAV.findViewById(d.g.guideopen);
        this.gBb.setOnClickListener(this.gAT);
        this.gAX = new g(this.gAT, null);
        this.gAW.setAdapter((ListAdapter) this.gAX);
        this.gAW.setOnScrollListener(this.gAX);
    }

    public void onChangeSkinType(int i) {
        this.gAT.getLayoutMode().setNightMode(i == 1);
        this.gAT.getLayoutMode().onModeChanged(this.gAU);
        this.gAT.getLayoutMode().onModeChanged(this.gBc);
        this.gAT.getLayoutMode().onModeChanged(this.gAV);
        al.j(this.gAU, d.C0141d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dy(i);
        this.gAX.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gzz = cVar;
            btW();
            ArrayList<d> btk = cVar.btk();
            this.gAX.c(this.gzz);
            if (btk.size() == gAS) {
                this.gBc.setVisibility(0);
                this.gBc.setText(cVar.bth());
            } else {
                this.gBc.setVisibility(8);
            }
            String btb = this.gzz.btb();
            if (!StringUtils.isNull(btb)) {
                this.gAV.a(this.gAT, btb, this.gzz.btc());
                return;
            }
            this.gAV.btU();
        }
    }

    private void btW() {
        if (this.gzz != null) {
            this.gAV.setHasPrivilege(this.gzz.bto());
            this.gAV.setmCurrentStatus(this.gzz.btq());
            TextView message1 = this.gAV.getMessage1();
            SpannableString spannableString = new SpannableString(this.gzz.bte() + this.gzz.bhj() + this.gzz.btf());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0141d.common_color_10191));
            int length = this.gzz.bte().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gzz.bhj().length() + length, 33);
            message1.setText(spannableString);
            this.gAV.getMessage2().setText(this.gzz.btg());
            this.gAZ.setText(this.gzz.getContent());
            if (TextUtils.isEmpty(this.gzz.btp())) {
                this.gBa.setText(d.k.member_buy_open);
            } else {
                this.gBa.setText(this.gzz.btp());
            }
            this.gAV.setVisibility(0);
            if (this.gzz.bto() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gAY.setVisibility(8);
            } else {
                this.gAY.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gAW.startPullRefresh();
    }

    public void nW() {
        this.gAW.completePullRefreshPostDelayed(2000L);
    }

    public void a(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gAW.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView btX() {
        return this.gAV;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView btY() {
        return this.gAW;
    }

    public c btZ() {
        return this.gzz;
    }

    public g bua() {
        return this.gAX;
    }

    public LinearLayout bub() {
        return this.gBb;
    }

    public void setListViewSelection(int i) {
        this.gAW.setSelection(i);
    }
}
