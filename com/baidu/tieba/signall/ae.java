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
    public static int cjh;
    private c cia;
    private SignAllForumActivity cji;
    private RelativeLayout cjj;
    private x cjk;
    private BdListView cjl;
    private o cjm;
    private RelativeLayout cjn;
    private TextView cjo;
    private TextView cjp;
    private LinearLayout cjq;
    private TextView cjr;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private al mPullView;

    public ae(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cji = signAllForumActivity;
        this.cji.setContentView(com.baidu.tieba.r.signallforum_view);
        this.cjj = (RelativeLayout) this.cji.findViewById(com.baidu.tieba.q.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cji.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cji.getPageContext().getString(com.baidu.tieba.t.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.cjl = (BdListView) this.cji.findViewById(com.baidu.tieba.q.signallforum_list);
        this.cjl.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new al(signAllForumActivity.getPageContext());
        this.cjl.setPullRefresh(this.mPullView);
        this.cjr = (TextView) com.baidu.adp.lib.g.b.hr().inflate(this.cji.getPageContext().getPageActivity(), com.baidu.tieba.r.signallforum_maxcount_warning, null);
        this.cjl.addFooterView(this.cjr);
        this.cjk = new x(this.cji.getPageContext().getPageActivity());
        this.mProgressBar = this.cjk.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cji);
        this.cjl.addHeaderView(this.cjk);
        this.cjk.setVisibility(8);
        this.cjn = (RelativeLayout) this.cjk.findViewById(com.baidu.tieba.q.guidecontainer);
        this.cjq = (LinearLayout) this.cjk.findViewById(com.baidu.tieba.q.guideopenbtn);
        this.cjo = (TextView) this.cjk.findViewById(com.baidu.tieba.q.guidetip);
        this.cjp = (TextView) this.cjk.findViewById(com.baidu.tieba.q.guideopen);
        this.cjq.setOnClickListener(this.cji);
        this.cjm = new o(this.cji, null);
        this.cjl.setAdapter((ListAdapter) this.cjm);
        this.cjl.setOnScrollListener(this.cjm);
    }

    public void onChangeSkinType(int i) {
        this.cji.getLayoutMode().ab(i == 1);
        this.cji.getLayoutMode().j(this.cjj);
        this.cji.getLayoutMode().j(this.cjr);
        this.cji.getLayoutMode().j(this.cjk);
        ay.j(this.cjj, com.baidu.tieba.n.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cy(i);
        this.cjm.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cia = cVar;
            akT();
            ArrayList<e> akl = cVar.akl();
            this.cjm.b(this.cia);
            if (akl.size() == cjh) {
                this.cjr.setVisibility(0);
                this.cjr.setText(cVar.aki());
                return;
            }
            this.cjr.setVisibility(8);
        }
    }

    private void akT() {
        if (this.cia != null) {
            this.cjk.setHasPrivilege(this.cia.akp());
            this.cjk.setmCurrentStatus(this.cia.akr());
            TextView message1 = this.cjk.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cia.ake()) + this.cia.akf() + this.cia.akg());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.n.sign_all_forum_text_color));
            int length = this.cia.ake().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cia.akf().length() + length, 33);
            message1.setText(spannableString);
            this.cjk.getMessage2().setText(this.cia.akh());
            this.cjo.setText(this.cia.getContent());
            if (TextUtils.isEmpty(this.cia.akq())) {
                this.cjp.setText(com.baidu.tieba.t.sign_all_forum_memberbtn_content);
            } else {
                this.cjp.setText(this.cia.akq());
            }
            this.cjk.setVisibility(0);
            if (this.cia.akp() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cjn.setVisibility(8);
            } else {
                this.cjn.setVisibility(0);
            }
        }
    }

    public void no() {
        this.cjl.no();
    }

    public void Ix() {
        this.cjl.completePullRefresh();
    }

    public void a(aj ajVar) {
        this.mPullView.a(ajVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cjl.setOnItemClickListener(onItemClickListener);
    }

    public x akU() {
        return this.cjk;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView akV() {
        return this.cjl;
    }

    public c akW() {
        return this.cia;
    }

    public o akX() {
        return this.cjm;
    }

    public LinearLayout akY() {
        return this.cjq;
    }
}
