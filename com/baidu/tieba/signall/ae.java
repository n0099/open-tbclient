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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int dyz;
    private c dxm;
    private SignAllForumActivity dyA;
    private ViewGroup dyB;
    private x dyC;
    private BdListView dyD;
    private p dyE;
    private RelativeLayout dyF;
    private TextView dyG;
    private TextView dyH;
    private LinearLayout dyI;
    private TextView dyJ;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;

    public ae(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.dyA = signAllForumActivity;
        this.dyA.setContentView(n.h.signallforum_view);
        this.dyB = (ViewGroup) this.dyA.findViewById(n.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.dyA.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.dyA.getPageContext().getString(n.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.dyD = (BdListView) this.dyA.findViewById(n.g.signallforum_list);
        this.dyD.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.t(signAllForumActivity.getPageContext());
        this.dyD.setPullRefresh(this.mPullView);
        this.dyJ = (TextView) LayoutInflater.from(this.dyA.getPageContext().getPageActivity()).inflate(n.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.dyD.addFooterView(this.dyJ);
        this.dyC = new x(this.dyA.getPageContext().getPageActivity());
        this.mProgressBar = this.dyC.getProgressBar();
        this.mProgressBar.setOnClickListener(this.dyA);
        this.dyD.addHeaderView(this.dyC);
        this.dyC.setVisibility(8);
        this.dyF = (RelativeLayout) this.dyC.findViewById(n.g.guidecontainer);
        this.dyI = (LinearLayout) this.dyC.findViewById(n.g.guideopenbtn);
        this.dyG = (TextView) this.dyC.findViewById(n.g.guidetip);
        this.dyH = (TextView) this.dyC.findViewById(n.g.guideopen);
        this.dyI.setOnClickListener(this.dyA);
        this.dyE = new p(this.dyA, null);
        this.dyD.setAdapter((ListAdapter) this.dyE);
        this.dyD.setOnScrollListener(this.dyE);
    }

    public void onChangeSkinType(int i) {
        this.dyA.getLayoutMode().ac(i == 1);
        this.dyA.getLayoutMode().k(this.dyB);
        this.dyA.getLayoutMode().k(this.dyJ);
        this.dyA.getLayoutMode().k(this.dyC);
        as.j(this.dyB, n.d.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cP(i);
        this.dyE.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.dxm = cVar;
            aCk();
            ArrayList<e> aBB = cVar.aBB();
            this.dyE.c(this.dxm);
            if (aBB.size() == dyz) {
                this.dyJ.setVisibility(0);
                this.dyJ.setText(cVar.aBy());
                return;
            }
            this.dyJ.setVisibility(8);
        }
    }

    private void aCk() {
        if (this.dxm != null) {
            this.dyC.setHasPrivilege(this.dxm.aBF());
            this.dyC.setmCurrentStatus(this.dxm.aBH());
            TextView message1 = this.dyC.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.dxm.aBv()) + this.dxm.aoj() + this.dxm.aBw());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(n.d.sign_all_forum_text_color));
            int length = this.dxm.aBv().length();
            spannableString.setSpan(foregroundColorSpan, length, this.dxm.aoj().length() + length, 33);
            message1.setText(spannableString);
            this.dyC.getMessage2().setText(this.dxm.aBx());
            this.dyG.setText(this.dxm.getContent());
            if (TextUtils.isEmpty(this.dxm.aBG())) {
                this.dyH.setText(n.j.sign_all_forum_memberbtn_content);
            } else {
                this.dyH.setText(this.dxm.aBG());
            }
            this.dyC.setVisibility(0);
            if (this.dxm.aBF() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.dyF.setVisibility(8);
            } else {
                this.dyF.setVisibility(0);
            }
        }
    }

    public void nb() {
        this.dyD.nb();
    }

    public void KK() {
        this.dyD.completePullRefresh();
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.dyD.setOnItemClickListener(onItemClickListener);
    }

    public x aCl() {
        return this.dyC;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aCm() {
        return this.dyD;
    }

    public c aCn() {
        return this.dxm;
    }

    public p aCo() {
        return this.dyE;
    }

    public LinearLayout aCp() {
        return this.dyI;
    }

    public void gh(int i) {
        this.dyD.setSelection(i);
    }
}
