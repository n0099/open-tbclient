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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int dOD;
    private c dNq;
    private SignAllForumActivity dOE;
    private ViewGroup dOF;
    private x dOG;
    private BdListView dOH;
    private p dOI;
    private RelativeLayout dOJ;
    private TextView dOK;
    private TextView dOL;
    private LinearLayout dOM;
    private TextView dON;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;

    public af(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.dOE = signAllForumActivity;
        this.dOE.setContentView(t.h.signallforum_view);
        this.dOF = (ViewGroup) this.dOE.findViewById(t.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.dOE.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dOE.getPageContext().getString(t.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ag(this));
        this.dOH = (BdListView) this.dOE.findViewById(t.g.signallforum_list);
        this.dOH.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.t(signAllForumActivity.getPageContext());
        this.dOH.setPullRefresh(this.mPullView);
        this.dON = (TextView) LayoutInflater.from(this.dOE.getPageContext().getPageActivity()).inflate(t.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.dOH.addFooterView(this.dON);
        this.dOG = new x(this.dOE.getPageContext().getPageActivity());
        this.mProgressBar = this.dOG.getProgressBar();
        this.mProgressBar.setOnClickListener(this.dOE);
        this.dOH.addHeaderView(this.dOG);
        this.dOG.setVisibility(8);
        this.dOJ = (RelativeLayout) this.dOG.findViewById(t.g.guidecontainer);
        this.dOM = (LinearLayout) this.dOG.findViewById(t.g.guideopenbtn);
        this.dOK = (TextView) this.dOG.findViewById(t.g.guidetip);
        this.dOL = (TextView) this.dOG.findViewById(t.g.guideopen);
        this.dOM.setOnClickListener(this.dOE);
        this.dOI = new p(this.dOE, null);
        this.dOH.setAdapter((ListAdapter) this.dOI);
        this.dOH.setOnScrollListener(this.dOI);
    }

    public void onChangeSkinType(int i) {
        this.dOE.getLayoutMode().ac(i == 1);
        this.dOE.getLayoutMode().x(this.dOF);
        this.dOE.getLayoutMode().x(this.dON);
        this.dOE.getLayoutMode().x(this.dOG);
        ar.l(this.dOF, t.d.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.dg(i);
        this.dOI.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.dNq = cVar;
            aJs();
            ArrayList<e> aII = cVar.aII();
            this.dOI.c(this.dNq);
            if (aII.size() == dOD) {
                this.dON.setVisibility(0);
                this.dON.setText(cVar.aIF());
                return;
            }
            this.dON.setVisibility(8);
        }
    }

    private void aJs() {
        if (this.dNq != null) {
            this.dOG.setHasPrivilege(this.dNq.aIM());
            this.dOG.setmCurrentStatus(this.dNq.aIO());
            TextView message1 = this.dOG.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.dNq.aIC()) + this.dNq.asS() + this.dNq.aID());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(t.d.sign_all_forum_text_color));
            int length = this.dNq.aIC().length();
            spannableString.setSpan(foregroundColorSpan, length, this.dNq.asS().length() + length, 33);
            message1.setText(spannableString);
            this.dOG.getMessage2().setText(this.dNq.aIE());
            this.dOK.setText(this.dNq.getContent());
            if (TextUtils.isEmpty(this.dNq.aIN())) {
                this.dOL.setText(t.j.sign_all_forum_memberbtn_content);
            } else {
                this.dOL.setText(this.dNq.aIN());
            }
            this.dOG.setVisibility(0);
            if (this.dNq.aIM() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.dOJ.setVisibility(8);
            } else {
                this.dOJ.setVisibility(0);
            }
        }
    }

    public void ns() {
        this.dOH.ns();
    }

    public void MB() {
        this.dOH.nr();
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.dOH.setOnItemClickListener(onItemClickListener);
    }

    public x aJt() {
        return this.dOG;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aJu() {
        return this.dOH;
    }

    public c aJv() {
        return this.dNq;
    }

    public p aJw() {
        return this.dOI;
    }

    public LinearLayout aJx() {
        return this.dOM;
    }

    public void gE(int i) {
        this.dOH.setSelection(i);
    }
}
