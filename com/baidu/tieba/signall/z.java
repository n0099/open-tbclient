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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int cSI;
    private c cRD;
    private SignAllForumActivity cSJ;
    private RelativeLayout cSK;
    private s cSL;
    private BdListView cSM;
    private n cSN;
    private RelativeLayout cSO;
    private TextView cSP;
    private TextView cSQ;
    private LinearLayout cSR;
    private TextView cSS;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.r mPullView;

    public z(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cSJ = signAllForumActivity;
        this.cSJ.setContentView(i.g.signallforum_view);
        this.cSK = (RelativeLayout) this.cSJ.findViewById(i.f.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cSJ.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cSJ.getPageContext().getString(i.h.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new aa(this));
        this.cSM = (BdListView) this.cSJ.findViewById(i.f.signallforum_list);
        this.cSM.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.r(signAllForumActivity.getPageContext());
        this.cSM.setPullRefresh(this.mPullView);
        this.cSS = (TextView) LayoutInflater.from(this.cSJ.getPageContext().getPageActivity()).inflate(i.g.signallforum_maxcount_warning, (ViewGroup) null);
        this.cSM.addFooterView(this.cSS);
        this.cSL = new s(this.cSJ.getPageContext().getPageActivity());
        this.mProgressBar = this.cSL.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cSJ);
        this.cSM.addHeaderView(this.cSL);
        this.cSL.setVisibility(8);
        this.cSO = (RelativeLayout) this.cSL.findViewById(i.f.guidecontainer);
        this.cSR = (LinearLayout) this.cSL.findViewById(i.f.guideopenbtn);
        this.cSP = (TextView) this.cSL.findViewById(i.f.guidetip);
        this.cSQ = (TextView) this.cSL.findViewById(i.f.guideopen);
        this.cSR.setOnClickListener(this.cSJ);
        this.cSN = new n(this.cSJ, null);
        this.cSM.setAdapter((ListAdapter) this.cSN);
        this.cSM.setOnScrollListener(this.cSN);
    }

    public void onChangeSkinType(int i) {
        this.cSJ.getLayoutMode().ad(i == 1);
        this.cSJ.getLayoutMode().k(this.cSK);
        this.cSJ.getLayoutMode().k(this.cSS);
        this.cSJ.getLayoutMode().k(this.cSL);
        an.j(this.cSK, i.c.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cN(i);
        this.cSN.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cRD = cVar;
            auA();
            ArrayList<e> atS = cVar.atS();
            this.cSN.b(this.cRD);
            if (atS.size() == cSI) {
                this.cSS.setVisibility(0);
                this.cSS.setText(cVar.atP());
                return;
            }
            this.cSS.setVisibility(8);
        }
    }

    private void auA() {
        if (this.cRD != null) {
            this.cSL.setHasPrivilege(this.cRD.atW());
            this.cSL.setmCurrentStatus(this.cRD.atY());
            TextView message1 = this.cSL.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cRD.atM()) + this.cRD.aiv() + this.cRD.atN());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(i.c.sign_all_forum_text_color));
            int length = this.cRD.atM().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cRD.aiv().length() + length, 33);
            message1.setText(spannableString);
            this.cSL.getMessage2().setText(this.cRD.atO());
            this.cSP.setText(this.cRD.getContent());
            if (TextUtils.isEmpty(this.cRD.atX())) {
                this.cSQ.setText(i.h.sign_all_forum_memberbtn_content);
            } else {
                this.cSQ.setText(this.cRD.atX());
            }
            this.cSL.setVisibility(0);
            if (this.cRD.atW() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cSO.setVisibility(8);
            } else {
                this.cSO.setVisibility(0);
            }
        }
    }

    public void nx() {
        this.cSM.nx();
    }

    public void Jg() {
        this.cSM.completePullRefresh();
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cSM.setOnItemClickListener(onItemClickListener);
    }

    public s auB() {
        return this.cSL;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView auC() {
        return this.cSM;
    }

    public c auD() {
        return this.cRD;
    }

    public n auE() {
        return this.cSN;
    }

    public LinearLayout auF() {
        return this.cSR;
    }
}
