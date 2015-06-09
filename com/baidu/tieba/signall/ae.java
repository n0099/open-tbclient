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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.aj;
import com.baidu.tbadk.core.view.al;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g<SignAllForumActivity> {
    public static int cji;
    private c cib;
    private SignAllForumActivity cjj;
    private RelativeLayout cjk;
    private x cjl;
    private BdListView cjm;
    private o cjn;
    private RelativeLayout cjo;
    private TextView cjp;
    private TextView cjq;
    private LinearLayout cjr;
    private TextView cjs;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private al mPullView;

    public ae(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cjj = signAllForumActivity;
        this.cjj.setContentView(com.baidu.tieba.r.signallforum_view);
        this.cjk = (RelativeLayout) this.cjj.findViewById(com.baidu.tieba.q.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cjj.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cjj.getPageContext().getString(com.baidu.tieba.t.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.cjm = (BdListView) this.cjj.findViewById(com.baidu.tieba.q.signallforum_list);
        this.cjm.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new al(signAllForumActivity.getPageContext());
        this.cjm.setPullRefresh(this.mPullView);
        this.cjs = (TextView) com.baidu.adp.lib.g.b.hr().inflate(this.cjj.getPageContext().getPageActivity(), com.baidu.tieba.r.signallforum_maxcount_warning, null);
        this.cjm.addFooterView(this.cjs);
        this.cjl = new x(this.cjj.getPageContext().getPageActivity());
        this.mProgressBar = this.cjl.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cjj);
        this.cjm.addHeaderView(this.cjl);
        this.cjl.setVisibility(8);
        this.cjo = (RelativeLayout) this.cjl.findViewById(com.baidu.tieba.q.guidecontainer);
        this.cjr = (LinearLayout) this.cjl.findViewById(com.baidu.tieba.q.guideopenbtn);
        this.cjp = (TextView) this.cjl.findViewById(com.baidu.tieba.q.guidetip);
        this.cjq = (TextView) this.cjl.findViewById(com.baidu.tieba.q.guideopen);
        this.cjr.setOnClickListener(this.cjj);
        this.cjn = new o(this.cjj, null);
        this.cjm.setAdapter((ListAdapter) this.cjn);
        this.cjm.setOnScrollListener(this.cjn);
    }

    public void onChangeSkinType(int i) {
        this.cjj.getLayoutMode().ab(i == 1);
        this.cjj.getLayoutMode().j(this.cjk);
        this.cjj.getLayoutMode().j(this.cjs);
        this.cjj.getLayoutMode().j(this.cjl);
        ay.j(this.cjk, com.baidu.tieba.n.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cy(i);
        this.cjn.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cib = cVar;
            akU();
            ArrayList<e> akm = cVar.akm();
            this.cjn.b(this.cib);
            if (akm.size() == cji) {
                this.cjs.setVisibility(0);
                this.cjs.setText(cVar.akj());
                return;
            }
            this.cjs.setVisibility(8);
        }
    }

    private void akU() {
        if (this.cib != null) {
            this.cjl.setHasPrivilege(this.cib.akq());
            this.cjl.setmCurrentStatus(this.cib.aks());
            TextView message1 = this.cjl.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cib.akf()) + this.cib.akg() + this.cib.akh());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.n.sign_all_forum_text_color));
            int length = this.cib.akf().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cib.akg().length() + length, 33);
            message1.setText(spannableString);
            this.cjl.getMessage2().setText(this.cib.aki());
            this.cjp.setText(this.cib.getContent());
            if (TextUtils.isEmpty(this.cib.akr())) {
                this.cjq.setText(com.baidu.tieba.t.sign_all_forum_memberbtn_content);
            } else {
                this.cjq.setText(this.cib.akr());
            }
            this.cjl.setVisibility(0);
            if (this.cib.akq() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cjo.setVisibility(8);
            } else {
                this.cjo.setVisibility(0);
            }
        }
    }

    public void no() {
        this.cjm.no();
    }

    public void Iy() {
        this.cjm.completePullRefresh();
    }

    public void a(aj ajVar) {
        this.mPullView.a(ajVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cjm.setOnItemClickListener(onItemClickListener);
    }

    public x akV() {
        return this.cjl;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView akW() {
        return this.cjm;
    }

    public c akX() {
        return this.cib;
    }

    public o akY() {
        return this.cjn;
    }

    public LinearLayout akZ() {
        return this.cjr;
    }
}
