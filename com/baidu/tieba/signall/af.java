package com.baidu.tieba.signall;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int ehd;
    private c efP;
    private SignAllForumActivity ehe;
    private ViewGroup ehf;
    private x ehg;
    private BdListView ehh;
    private p ehi;
    private RelativeLayout ehj;
    private TextView ehk;
    private TextView ehl;
    private LinearLayout ehm;
    private TextView ehn;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.u mPullView;

    public af(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.ehe = signAllForumActivity;
        this.ehe.setContentView(t.h.signallforum_view);
        this.ehf = (ViewGroup) this.ehe.findViewById(t.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.ehe.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ehe.getPageContext().getString(t.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ag(this));
        this.ehh = (BdListView) this.ehe.findViewById(t.g.signallforum_list);
        this.ehh.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.u(signAllForumActivity.getPageContext());
        this.ehh.setPullRefresh(this.mPullView);
        this.ehn = (TextView) LayoutInflater.from(this.ehe.getPageContext().getPageActivity()).inflate(t.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.ehh.addFooterView(this.ehn);
        this.ehg = new x(this.ehe.getPageContext().getPageActivity());
        this.mProgressBar = this.ehg.getProgressBar();
        this.mProgressBar.setOnClickListener(this.ehe);
        this.ehh.addHeaderView(this.ehg);
        this.ehg.setVisibility(8);
        this.ehj = (RelativeLayout) this.ehg.findViewById(t.g.guidecontainer);
        this.ehm = (LinearLayout) this.ehg.findViewById(t.g.guideopenbtn);
        this.ehk = (TextView) this.ehg.findViewById(t.g.guidetip);
        this.ehl = (TextView) this.ehg.findViewById(t.g.guideopen);
        this.ehm.setOnClickListener(this.ehe);
        this.ehi = new p(this.ehe, null);
        this.ehh.setAdapter((ListAdapter) this.ehi);
        this.ehh.setOnScrollListener(this.ehi);
    }

    public void onChangeSkinType(int i) {
        this.ehe.getLayoutMode().ab(i == 1);
        this.ehe.getLayoutMode().x(this.ehf);
        this.ehe.getLayoutMode().x(this.ehn);
        this.ehe.getLayoutMode().x(this.ehg);
        at.l(this.ehf, t.d.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dj(i);
        this.ehi.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.efP = cVar;
            aQj();
            ArrayList<e> aPy = cVar.aPy();
            this.ehi.c(this.efP);
            if (aPy.size() == ehd) {
                this.ehn.setVisibility(0);
                this.ehn.setText(cVar.aPv());
                return;
            }
            this.ehn.setVisibility(8);
        }
    }

    private void aQj() {
        if (this.efP != null) {
            this.ehg.setHasPrivilege(this.efP.aPC());
            this.ehg.setmCurrentStatus(this.efP.aPE());
            TextView message1 = this.ehg.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.efP.aPs()) + this.efP.aAC() + this.efP.aPt());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(t.d.sign_all_forum_text_color));
            int length = this.efP.aPs().length();
            spannableString.setSpan(foregroundColorSpan, length, this.efP.aAC().length() + length, 33);
            message1.setText(spannableString);
            this.ehg.getMessage2().setText(this.efP.aPu());
            this.ehk.setText(this.efP.getContent());
            if (TextUtils.isEmpty(this.efP.aPD())) {
                this.ehl.setText(t.j.sign_all_forum_memberbtn_content);
            } else {
                this.ehl.setText(this.efP.aPD());
            }
            this.ehg.setVisibility(0);
            if (this.efP.aPC() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.ehj.setVisibility(8);
            } else {
                this.ehj.setVisibility(0);
            }
        }
    }

    public void nk() {
        this.ehh.nk();
    }

    public void Op() {
        this.ehh.nj();
    }

    public void a(s.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ehh.setOnItemClickListener(onItemClickListener);
    }

    public x aQk() {
        return this.ehg;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aQl() {
        return this.ehh;
    }

    public c aQm() {
        return this.efP;
    }

    public p aQn() {
        return this.ehi;
    }

    public LinearLayout aQo() {
        return this.ehm;
    }

    public void gV(int i) {
        this.ehh.setSelection(i);
    }
}
