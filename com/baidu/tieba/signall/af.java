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
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<SignAllForumActivity> {
    public static int ekp;
    private c eja;
    private SignAllForumActivity ekq;
    private ViewGroup ekr;
    private x eks;
    private BdListView ekt;
    private p eku;
    private RelativeLayout ekv;
    private TextView ekw;
    private TextView ekx;
    private LinearLayout eky;
    private TextView ekz;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.w mPullView;

    public af(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.ekq = signAllForumActivity;
        this.ekq.setContentView(t.h.signallforum_view);
        this.ekr = (ViewGroup) this.ekq.findViewById(t.g.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.ekq.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ekq.getPageContext().getString(t.j.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ag(this));
        this.ekt = (BdListView) this.ekq.findViewById(t.g.signallforum_list);
        this.ekt.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.w(signAllForumActivity.getPageContext());
        this.ekt.setPullRefresh(this.mPullView);
        this.ekz = (TextView) LayoutInflater.from(this.ekq.getPageContext().getPageActivity()).inflate(t.h.signallforum_maxcount_warning, (ViewGroup) null);
        this.ekt.addFooterView(this.ekz);
        this.eks = new x(this.ekq.getPageContext().getPageActivity());
        this.mProgressBar = this.eks.getProgressBar();
        this.mProgressBar.setOnClickListener(this.ekq);
        this.ekt.addHeaderView(this.eks);
        this.eks.setVisibility(8);
        this.ekv = (RelativeLayout) this.eks.findViewById(t.g.guidecontainer);
        this.eky = (LinearLayout) this.eks.findViewById(t.g.guideopenbtn);
        this.ekw = (TextView) this.eks.findViewById(t.g.guidetip);
        this.ekx = (TextView) this.eks.findViewById(t.g.guideopen);
        this.eky.setOnClickListener(this.ekq);
        this.eku = new p(this.ekq, null);
        this.ekt.setAdapter((ListAdapter) this.eku);
        this.ekt.setOnScrollListener(this.eku);
    }

    public void onChangeSkinType(int i) {
        this.ekq.getLayoutMode().ae(i == 1);
        this.ekq.getLayoutMode().x(this.ekr);
        this.ekq.getLayoutMode().x(this.ekz);
        this.ekq.getLayoutMode().x(this.eks);
        at.l(this.ekr, t.d.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cS(i);
        this.eku.notifyDataSetChanged();
    }

    public void a(c cVar, boolean z) {
        if (cVar != null) {
            this.eja = cVar;
            aQC();
            ArrayList<e> aPO = cVar.aPO();
            this.eku.c(this.eja);
            if (aPO.size() == ekp) {
                this.ekz.setVisibility(0);
                this.ekz.setText(cVar.aPL());
                return;
            }
            this.ekz.setVisibility(8);
        }
    }

    private void aQC() {
        if (this.eja != null) {
            this.eks.setHasPrivilege(this.eja.aPS());
            this.eks.setmCurrentStatus(this.eja.aPU());
            TextView message1 = this.eks.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.eja.aPI()) + this.eja.aAK() + this.eja.aPJ());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(t.d.sign_all_forum_text_color));
            int length = this.eja.aPI().length();
            spannableString.setSpan(foregroundColorSpan, length, this.eja.aAK().length() + length, 33);
            message1.setText(spannableString);
            this.eks.getMessage2().setText(this.eja.aPK());
            this.ekw.setText(this.eja.getContent());
            if (TextUtils.isEmpty(this.eja.aPT())) {
                this.ekx.setText(t.j.sign_all_forum_memberbtn_content);
            } else {
                this.ekx.setText(this.eja.aPT());
            }
            this.eks.setVisibility(0);
            if (this.eja.aPS() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.ekv.setVisibility(8);
            } else {
                this.ekv.setVisibility(0);
            }
        }
    }

    public void jy() {
        this.ekt.jy();
    }

    public void Nn() {
        this.ekt.k(2000L);
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ekt.setOnItemClickListener(onItemClickListener);
    }

    public x aQD() {
        return this.eks;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aQE() {
        return this.ekt;
    }

    public c aQF() {
        return this.eja;
    }

    public p aQG() {
        return this.eku;
    }

    public LinearLayout aQH() {
        return this.eky;
    }

    public void gE(int i) {
        this.ekt.setSelection(i);
    }
}
