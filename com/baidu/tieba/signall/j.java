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
    public static int gpu;
    private c gob;
    private RelativeLayout gpA;
    private TextView gpB;
    private TextView gpC;
    private LinearLayout gpD;
    private TextView gpE;
    private SignAllForumActivity gpv;
    private ViewGroup gpw;
    private SignAllForumProgressView gpx;
    private BdListView gpy;
    private g gpz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public j(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.gpv = signAllForumActivity;
        this.gpv.setContentView(d.i.signallforum_view);
        this.gpw = (ViewGroup) this.gpv.findViewById(d.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.gpv.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gpv.getPageContext().getString(d.k.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.signall.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                j.this.gpv.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.gpy = (BdListView) this.gpv.findViewById(d.g.signallforum_list);
        this.gpy.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.f(signAllForumActivity.getPageContext());
        this.gpy.setPullRefresh(this.mPullView);
        this.gpE = (TextView) LayoutInflater.from(this.gpv.getPageContext().getPageActivity()).inflate(d.i.signallforum_maxcount_warning, (ViewGroup) null);
        this.gpy.addFooterView(this.gpE);
        this.gpx = new SignAllForumProgressView(this.gpv.getPageContext().getPageActivity());
        this.mProgressBar = this.gpx.getProgressBar();
        this.mProgressBar.setOnClickListener(this.gpv);
        this.gpy.addHeaderView(this.gpx);
        this.gpx.setVisibility(8);
        this.gpA = (RelativeLayout) this.gpx.findViewById(d.g.guidecontainer);
        this.gpD = (LinearLayout) this.gpx.findViewById(d.g.guideopenbtn);
        this.gpB = (TextView) this.gpx.findViewById(d.g.guidetip);
        this.gpC = (TextView) this.gpx.findViewById(d.g.guideopen);
        this.gpD.setOnClickListener(this.gpv);
        this.gpz = new g(this.gpv, null);
        this.gpy.setAdapter((ListAdapter) this.gpz);
        this.gpy.setOnScrollListener(this.gpz);
    }

    public void onChangeSkinType(int i) {
        this.gpv.getLayoutMode().setNightMode(i == 1);
        this.gpv.getLayoutMode().u(this.gpw);
        this.gpv.getLayoutMode().u(this.gpE);
        this.gpv.getLayoutMode().u(this.gpx);
        ak.j(this.gpw, d.C0126d.common_color_10163);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dw(i);
        this.gpz.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.gob = cVar;
            boW();
            ArrayList<d> bok = cVar.bok();
            this.gpz.c(this.gob);
            if (bok.size() == gpu) {
                this.gpE.setVisibility(0);
                this.gpE.setText(cVar.boh());
            } else {
                this.gpE.setVisibility(8);
            }
            String bob = this.gob.bob();
            if (!StringUtils.isNull(bob)) {
                this.gpx.a(this.gpv, bob, this.gob.boc());
                return;
            }
            this.gpx.boU();
        }
    }

    private void boW() {
        if (this.gob != null) {
            this.gpx.setHasPrivilege(this.gob.boo());
            this.gpx.setmCurrentStatus(this.gob.boq());
            TextView message1 = this.gpx.getMessage1();
            SpannableString spannableString = new SpannableString(this.gob.boe() + this.gob.bcj() + this.gob.bof());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(d.C0126d.common_color_10191));
            int length = this.gob.boe().length();
            spannableString.setSpan(foregroundColorSpan, length, this.gob.bcj().length() + length, 33);
            message1.setText(spannableString);
            this.gpx.getMessage2().setText(this.gob.bog());
            this.gpB.setText(this.gob.getContent());
            if (TextUtils.isEmpty(this.gob.bop())) {
                this.gpC.setText(d.k.member_buy_open);
            } else {
                this.gpC.setText(this.gob.bop());
            }
            this.gpx.setVisibility(0);
            if (this.gob.boo() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.gpA.setVisibility(8);
            } else {
                this.gpA.setVisibility(0);
            }
        }
    }

    public void startPullRefresh() {
        this.gpy.startPullRefresh();
    }

    public void lg() {
        this.gpy.completePullRefreshPostDelayed(2000L);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.gpy.setOnItemClickListener(onItemClickListener);
    }

    public SignAllForumProgressView boX() {
        return this.gpx;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView boY() {
        return this.gpy;
    }

    public c boZ() {
        return this.gob;
    }

    public g bpa() {
        return this.gpz;
    }

    public LinearLayout bpb() {
        return this.gpD;
    }

    public void setListViewSelection(int i) {
        this.gpy.setSelection(i);
    }
}
