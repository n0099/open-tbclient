package com.baidu.tieba.signall;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ak;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.g<SignAllForumActivity> {
    public static int bQi;
    private b bPd;
    private SignAllForumActivity bQj;
    private RelativeLayout bQk;
    private x bQl;
    private BdListView bQm;
    private o bQn;
    private RelativeLayout bQo;
    private TextView bQp;
    private TextView bQq;
    private LinearLayout bQr;
    private TextView bQs;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ak mPullView;

    public ad(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.bQj = signAllForumActivity;
        this.bQj.setContentView(com.baidu.tieba.x.signallforum_view);
        this.bQk = (RelativeLayout) this.bQj.findViewById(com.baidu.tieba.w.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.bQj.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bQj.getPageContext().getString(com.baidu.tieba.z.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ae(this));
        this.bQm = (BdListView) this.bQj.findViewById(com.baidu.tieba.w.signallforum_list);
        this.bQm.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new ak(signAllForumActivity.getPageContext().getPageActivity());
        this.bQm.setPullRefresh(this.mPullView);
        this.bQs = (TextView) com.baidu.adp.lib.g.b.ek().inflate(this.bQj.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_maxcount_warning, null);
        this.bQm.addFooterView(this.bQs);
        this.bQl = new x(this.bQj.getPageContext().getPageActivity());
        this.mProgressBar = this.bQl.getProgressBar();
        this.mProgressBar.setOnClickListener(this.bQj);
        this.bQm.addHeaderView(this.bQl);
        this.bQl.setVisibility(8);
        this.bQo = (RelativeLayout) this.bQl.findViewById(com.baidu.tieba.w.guidecontainer);
        this.bQr = (LinearLayout) this.bQl.findViewById(com.baidu.tieba.w.guideopenbtn);
        this.bQp = (TextView) this.bQl.findViewById(com.baidu.tieba.w.guidetip);
        this.bQq = (TextView) this.bQl.findViewById(com.baidu.tieba.w.guideopen);
        this.bQr.setOnClickListener(this.bQj);
        this.bQn = new o(this.bQj, null);
        this.bQm.setAdapter((ListAdapter) this.bQn);
        this.bQm.setOnScrollListener(this.bQn);
    }

    public void onChangeSkinType(int i) {
        this.bQj.getLayoutMode().ab(i == 1);
        this.bQj.getLayoutMode().h(this.bQk);
        this.bQj.getLayoutMode().h(this.bQs);
        this.bQj.getLayoutMode().h(this.bQl);
        ax.j(this.bQk, com.baidu.tieba.t.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cl(i);
        this.bQn.notifyDataSetChanged();
    }

    public void d(b bVar) {
        if (bVar != null) {
            this.bPd = bVar;
            adE();
            ArrayList<d> acV = bVar.acV();
            this.bQn.b(this.bPd);
            if (acV.size() == bQi) {
                this.bQs.setVisibility(0);
                this.bQs.setText(bVar.acS());
                return;
            }
            this.bQs.setVisibility(8);
        }
    }

    private void adE() {
        if (this.bPd != null) {
            this.bQl.setHasPrivilege(this.bPd.acZ());
            this.bQl.setmCurrentStatus(this.bPd.adb());
            TextView message1 = this.bQl.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.bPd.acO()) + this.bPd.acP() + this.bPd.acQ());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.t.sign_all_forum_text_color));
            int length = this.bPd.acO().length();
            spannableString.setSpan(foregroundColorSpan, length, this.bPd.acP().length() + length, 33);
            message1.setText(spannableString);
            this.bQl.getMessage2().setText(this.bPd.acR());
            this.bQp.setText(this.bPd.getContent());
            if (TextUtils.isEmpty(this.bPd.ada())) {
                this.bQq.setText(com.baidu.tieba.z.sign_all_forum_memberbtn_content);
            } else {
                this.bQq.setText(this.bPd.ada());
            }
            this.bQl.setVisibility(0);
            if (this.bPd.acZ() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.bQo.setVisibility(8);
            } else {
                this.bQo.setVisibility(0);
            }
        }
    }

    public void jK() {
        this.bQm.jK();
    }

    public void Jm() {
        this.bQm.jJ();
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.bQm.setOnItemClickListener(onItemClickListener);
    }

    public x adF() {
        return this.bQl;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView adG() {
        return this.bQm;
    }

    public b adH() {
        return this.bPd;
    }

    public o adI() {
        return this.bQn;
    }

    public LinearLayout adJ() {
        return this.bQr;
    }
}
