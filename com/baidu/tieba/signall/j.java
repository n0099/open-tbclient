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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class j extends com.baidu.adp.base.c<SignAllForumActivity> {
    public static int gop;
    private c gmV;
    private SignAllForumActivity goq;
    private ViewGroup gor;
    private SignAllForumProgressView gos;
    private BdListView got;
    private g gou;
    private RelativeLayout gov;
    private TextView gow;
    private TextView gox;
    private LinearLayout goy;
    private TextView goz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.goq = signAllForumActivity;
        this.goq.setContentView(d.i.signallforum_view);
        this.gor = (ViewGroup) this.goq.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.goq.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.goq.getPageContext().getString(d.k.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.goq.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.got = (BdListView) this.goq.findViewById(d.g.signallforum_list);
        this.got.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.f(signAllForumActivity.getPageContext());
        this.got.setPullRefresh(this.mPullView);
        this.goz = (TextView) LayoutInflater.from(this.goq.getPageContext().getPageActivity()).inflate(d.i.signallforum_maxcount_warning, (ViewGroup) null);
        this.got.addFooterView(this.goz);
        this.gos = new SignAllForumProgressView(this.goq.getPageContext().getPageActivity());
        this.mProgressBar = this.gos.getProgressBar();
        this.mProgressBar.setOnClickListener(this.goq);
        this.got.addHeaderView(this.gos);
        this.gos.setVisibility(8);
        this.gov = (RelativeLayout) this.gos.findViewById(d.g.guidecontainer);
        this.goy = (LinearLayout) this.gos.findViewById(d.g.guideopenbtn);
        this.gow = (TextView) this.gos.findViewById(d.g.guidetip);
        this.gox = (TextView) this.gos.findViewById(d.g.guideopen);
        this.goy.setOnClickListener(this.goq);
        this.gou = new g(this.goq, null);
        this.got.setAdapter((ListAdapter) this.gou);
        this.got.setOnScrollListener(this.gou);
    }

    public void onChangeSkinType(int i) {
        this.goq.getLayoutMode().setNightMode(i == 1);
        this.goq.getLayoutMode().u(this.gor);
        this.goq.getLayoutMode().u(this.goz);
        this.goq.getLayoutMode().u(this.gos);
        ak.j(this.gor, d.C0126d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dv(i);
        this.gou.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gmV = cVar;
            boY();
            ArrayList<d> bom = cVar.bom();
            this.gou.c(this.gmV);
            if (bom.size() == gop) {
                this.goz.setVisibility(0);
                this.goz.setText(cVar.boj());
            } else {
                this.goz.setVisibility(8);
            }
            String bod = this.gmV.bod();
            if (!StringUtils.isNull(bod)) {
                this.gos.a(this.goq, bod, this.gmV.boe());
                return;
            }
            this.gos.boW();
        }
    }

    private void boY() {
        if (this.gmV != null) {
            this.gos.setHasPrivilege(this.gmV.boq());
            this.gos.setmCurrentStatus(this.gmV.bos());
            TextView message1 = this.gos.getMessage1();
            SpannableString spannableString = new SpannableString(this.gmV.bog() + this.gmV.bcj() + this.gmV.boh());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0126d.common_color_10191));
            int length = this.gmV.bog().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gmV.bcj().length() + length, 33);
            message1.setText(spannableString);
            this.gos.getMessage2().setText(this.gmV.boi());
            this.gow.setText(this.gmV.getContent());
            if (TextUtils.isEmpty(this.gmV.bor())) {
                this.gox.setText(d.k.member_buy_open);
            } else {
                this.gox.setText(this.gmV.bor());
            }
            this.gos.setVisibility(0);
            if (this.gmV.boq() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gov.setVisibility(8);
            } else {
                this.gov.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.got.startPullRefresh();
    }

    public void lh() {
        this.got.completePullRefreshPostDelayed(2000L);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.got.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView boZ() {
        return this.gos;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bpa() {
        return this.got;
    }

    public c bpb() {
        return this.gmV;
    }

    public g bpc() {
        return this.gou;
    }

    public LinearLayout bpd() {
        return this.goy;
    }

    public void setListViewSelection(int i) {
        this.got.setSelection(i);
    }
}
