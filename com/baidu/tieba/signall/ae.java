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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.g<SignAllForumActivity> {
    public static int cfd;
    private c cdW;
    private SignAllForumActivity cfe;
    private RelativeLayout cff;
    private x cfg;
    private BdListView cfh;
    private o cfi;
    private RelativeLayout cfj;
    private TextView cfk;
    private TextView cfl;
    private LinearLayout cfm;
    private TextView cfn;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.ag mPullView;

    public ae(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.cfe = signAllForumActivity;
        this.cfe.setContentView(com.baidu.tieba.w.signallforum_view);
        this.cff = (RelativeLayout) this.cfe.findViewById(com.baidu.tieba.v.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.cfe.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.cfe.getPageContext().getString(com.baidu.tieba.y.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.cfh = (BdListView) this.cfe.findViewById(com.baidu.tieba.v.signallforum_list);
        this.cfh.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.ag(signAllForumActivity.getPageContext());
        this.cfh.setPullRefresh(this.mPullView);
        this.cfn = (TextView) com.baidu.adp.lib.g.b.hH().inflate(this.cfe.getPageContext().getPageActivity(), com.baidu.tieba.w.signallforum_maxcount_warning, null);
        this.cfh.addFooterView(this.cfn);
        this.cfg = new x(this.cfe.getPageContext().getPageActivity());
        this.mProgressBar = this.cfg.getProgressBar();
        this.mProgressBar.setOnClickListener(this.cfe);
        this.cfh.addHeaderView(this.cfg);
        this.cfg.setVisibility(8);
        this.cfj = (RelativeLayout) this.cfg.findViewById(com.baidu.tieba.v.guidecontainer);
        this.cfm = (LinearLayout) this.cfg.findViewById(com.baidu.tieba.v.guideopenbtn);
        this.cfk = (TextView) this.cfg.findViewById(com.baidu.tieba.v.guidetip);
        this.cfl = (TextView) this.cfg.findViewById(com.baidu.tieba.v.guideopen);
        this.cfm.setOnClickListener(this.cfe);
        this.cfi = new o(this.cfe, null);
        this.cfh.setAdapter((ListAdapter) this.cfi);
        this.cfh.setOnScrollListener(this.cfi);
    }

    public void onChangeSkinType(int i) {
        this.cfe.getLayoutMode().X(i == 1);
        this.cfe.getLayoutMode().h(this.cff);
        this.cfe.getLayoutMode().h(this.cfn);
        this.cfe.getLayoutMode().h(this.cfg);
        ba.j(this.cff, com.baidu.tieba.s.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ct(i);
        this.cfi.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cdW = cVar;
            ajj();
            ArrayList<e> aiB = cVar.aiB();
            this.cfi.b(this.cdW);
            if (aiB.size() == cfd) {
                this.cfn.setVisibility(0);
                this.cfn.setText(cVar.aiy());
                return;
            }
            this.cfn.setVisibility(8);
        }
    }

    private void ajj() {
        if (this.cdW != null) {
            this.cfg.setHasPrivilege(this.cdW.aiF());
            this.cfg.setmCurrentStatus(this.cdW.aiH());
            TextView message1 = this.cfg.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cdW.aiu()) + this.cdW.aiv() + this.cdW.aiw());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.s.sign_all_forum_text_color));
            int length = this.cdW.aiu().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cdW.aiv().length() + length, 33);
            message1.setText(spannableString);
            this.cfg.getMessage2().setText(this.cdW.aix());
            this.cfk.setText(this.cdW.getContent());
            if (TextUtils.isEmpty(this.cdW.aiG())) {
                this.cfl.setText(com.baidu.tieba.y.sign_all_forum_memberbtn_content);
            } else {
                this.cfl.setText(this.cdW.aiG());
            }
            this.cfg.setVisibility(0);
            if (this.cdW.aiF() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.cfj.setVisibility(8);
            } else {
                this.cfj.setVisibility(0);
            }
        }
    }

    public void mX() {
        this.cfh.mX();
    }

    public void Hx() {
        this.cfh.mW();
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.cfh.setOnItemClickListener(onItemClickListener);
    }

    public x ajk() {
        return this.cfg;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView ajl() {
        return this.cfh;
    }

    public c ajm() {
        return this.cdW;
    }

    public o ajn() {
        return this.cfi;
    }

    public LinearLayout ajo() {
        return this.cfm;
    }
}
