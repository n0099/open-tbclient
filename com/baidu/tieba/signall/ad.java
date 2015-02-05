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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.ak;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.g<SignAllForumActivity> {
    public static int bRS;
    private b bQM;
    private SignAllForumActivity bRT;
    private RelativeLayout bRU;
    private x bRV;
    private BdListView bRW;
    private o bRX;
    private RelativeLayout bRY;
    private TextView bRZ;
    private TextView bSa;
    private LinearLayout bSb;
    private TextView bSc;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ak mPullView;

    public ad(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.bRT = signAllForumActivity;
        this.bRT.setContentView(com.baidu.tieba.x.signallforum_view);
        this.bRU = (RelativeLayout) this.bRT.findViewById(com.baidu.tieba.w.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.bRT.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bRT.getPageContext().getString(com.baidu.tieba.z.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ae(this));
        this.bRW = (BdListView) this.bRT.findViewById(com.baidu.tieba.w.signallforum_list);
        this.bRW.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new ak(signAllForumActivity.getPageContext());
        this.bRW.setPullRefresh(this.mPullView);
        this.bSc = (TextView) com.baidu.adp.lib.g.b.ei().inflate(this.bRT.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_maxcount_warning, null);
        this.bRW.addFooterView(this.bSc);
        this.bRV = new x(this.bRT.getPageContext().getPageActivity());
        this.mProgressBar = this.bRV.getProgressBar();
        this.mProgressBar.setOnClickListener(this.bRT);
        this.bRW.addHeaderView(this.bRV);
        this.bRV.setVisibility(8);
        this.bRY = (RelativeLayout) this.bRV.findViewById(com.baidu.tieba.w.guidecontainer);
        this.bSb = (LinearLayout) this.bRV.findViewById(com.baidu.tieba.w.guideopenbtn);
        this.bRZ = (TextView) this.bRV.findViewById(com.baidu.tieba.w.guidetip);
        this.bSa = (TextView) this.bRV.findViewById(com.baidu.tieba.w.guideopen);
        this.bSb.setOnClickListener(this.bRT);
        this.bRX = new o(this.bRT, null);
        this.bRW.setAdapter((ListAdapter) this.bRX);
        this.bRW.setOnScrollListener(this.bRX);
    }

    public void onChangeSkinType(int i) {
        this.bRT.getLayoutMode().ab(i == 1);
        this.bRT.getLayoutMode().h(this.bRU);
        this.bRT.getLayoutMode().h(this.bSc);
        this.bRT.getLayoutMode().h(this.bRV);
        bc.j(this.bRU, com.baidu.tieba.t.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cs(i);
        this.bRX.notifyDataSetChanged();
    }

    public void d(b bVar) {
        if (bVar != null) {
            this.bQM = bVar;
            aed();
            ArrayList<d> adu = bVar.adu();
            this.bRX.b(this.bQM);
            if (adu.size() == bRS) {
                this.bSc.setVisibility(0);
                this.bSc.setText(bVar.adr());
                return;
            }
            this.bSc.setVisibility(8);
        }
    }

    private void aed() {
        if (this.bQM != null) {
            this.bRV.setHasPrivilege(this.bQM.ady());
            this.bRV.setmCurrentStatus(this.bQM.adA());
            TextView message1 = this.bRV.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.bQM.adn()) + this.bQM.ado() + this.bQM.adp());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.t.sign_all_forum_text_color));
            int length = this.bQM.adn().length();
            spannableString.setSpan(foregroundColorSpan, length, this.bQM.ado().length() + length, 33);
            message1.setText(spannableString);
            this.bRV.getMessage2().setText(this.bQM.adq());
            this.bRZ.setText(this.bQM.getContent());
            if (TextUtils.isEmpty(this.bQM.adz())) {
                this.bSa.setText(com.baidu.tieba.z.sign_all_forum_memberbtn_content);
            } else {
                this.bSa.setText(this.bQM.adz());
            }
            this.bRV.setVisibility(0);
            if (this.bQM.ady() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.bRY.setVisibility(8);
            } else {
                this.bRY.setVisibility(0);
            }
        }
    }

    public void jC() {
        this.bRW.jC();
    }

    public void JD() {
        this.bRW.jB();
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.bRW.setOnItemClickListener(onItemClickListener);
    }

    public x aee() {
        return this.bRV;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aef() {
        return this.bRW;
    }

    public b aeg() {
        return this.bQM;
    }

    public o aeh() {
        return this.bRX;
    }

    public LinearLayout aei() {
        return this.bSb;
    }
}
