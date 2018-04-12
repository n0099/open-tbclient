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
    public static int gos;
    private c gmY;
    private TextView goA;
    private LinearLayout goB;
    private TextView goC;
    private SignAllForumActivity got;
    private ViewGroup gou;
    private SignAllForumProgressView gov;
    private BdListView gow;
    private g gox;
    private RelativeLayout goy;
    private TextView goz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.got = signAllForumActivity;
        this.got.setContentView(d.i.signallforum_view);
        this.gou = (ViewGroup) this.got.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.got.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.got.getPageContext().getString(d.k.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.got.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gow = (BdListView) this.got.findViewById(d.g.signallforum_list);
        this.gow.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.f(signAllForumActivity.getPageContext());
        this.gow.setPullRefresh(this.mPullView);
        this.goC = (TextView) LayoutInflater.from(this.got.getPageContext().getPageActivity()).inflate(d.i.signallforum_maxcount_warning, (ViewGroup) null);
        this.gow.addFooterView(this.goC);
        this.gov = new SignAllForumProgressView(this.got.getPageContext().getPageActivity());
        this.mProgressBar = this.gov.getProgressBar();
        this.mProgressBar.setOnClickListener(this.got);
        this.gow.addHeaderView(this.gov);
        this.gov.setVisibility(8);
        this.goy = (RelativeLayout) this.gov.findViewById(d.g.guidecontainer);
        this.goB = (LinearLayout) this.gov.findViewById(d.g.guideopenbtn);
        this.goz = (TextView) this.gov.findViewById(d.g.guidetip);
        this.goA = (TextView) this.gov.findViewById(d.g.guideopen);
        this.goB.setOnClickListener(this.got);
        this.gox = new g(this.got, null);
        this.gow.setAdapter((ListAdapter) this.gox);
        this.gow.setOnScrollListener(this.gox);
    }

    public void onChangeSkinType(int i) {
        this.got.getLayoutMode().setNightMode(i == 1);
        this.got.getLayoutMode().u(this.gou);
        this.got.getLayoutMode().u(this.goC);
        this.got.getLayoutMode().u(this.gov);
        ak.j(this.gou, d.C0126d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dw(i);
        this.gox.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gmY = cVar;
            boY();
            ArrayList<d> bom = cVar.bom();
            this.gox.c(this.gmY);
            if (bom.size() == gos) {
                this.goC.setVisibility(0);
                this.goC.setText(cVar.boj());
            } else {
                this.goC.setVisibility(8);
            }
            String bod = this.gmY.bod();
            if (!StringUtils.isNull(bod)) {
                this.gov.a(this.got, bod, this.gmY.boe());
                return;
            }
            this.gov.boW();
        }
    }

    private void boY() {
        if (this.gmY != null) {
            this.gov.setHasPrivilege(this.gmY.boq());
            this.gov.setmCurrentStatus(this.gmY.bos());
            TextView message1 = this.gov.getMessage1();
            SpannableString spannableString = new SpannableString(this.gmY.bog() + this.gmY.bcj() + this.gmY.boh());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0126d.common_color_10191));
            int length = this.gmY.bog().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gmY.bcj().length() + length, 33);
            message1.setText(spannableString);
            this.gov.getMessage2().setText(this.gmY.boi());
            this.goz.setText(this.gmY.getContent());
            if (TextUtils.isEmpty(this.gmY.bor())) {
                this.goA.setText(d.k.member_buy_open);
            } else {
                this.goA.setText(this.gmY.bor());
            }
            this.gov.setVisibility(0);
            if (this.gmY.boq() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.goy.setVisibility(8);
            } else {
                this.goy.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gow.startPullRefresh();
    }

    public void lh() {
        this.gow.completePullRefreshPostDelayed(2000L);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gow.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView boZ() {
        return this.gov;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView bpa() {
        return this.gow;
    }

    public c bpb() {
        return this.gmY;
    }

    public g bpc() {
        return this.gox;
    }

    public LinearLayout bpd() {
        return this.goB;
    }

    public void setListViewSelection(int i) {
        this.gow.setSelection(i);
    }
}
