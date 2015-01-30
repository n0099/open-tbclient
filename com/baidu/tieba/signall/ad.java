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
    public static int bRT;
    private b bQN;
    private SignAllForumActivity bRU;
    private RelativeLayout bRV;
    private x bRW;
    private BdListView bRX;
    private o bRY;
    private RelativeLayout bRZ;
    private TextView bSa;
    private TextView bSb;
    private LinearLayout bSc;
    private TextView bSd;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private ak mPullView;

    public ad(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.bRU = signAllForumActivity;
        this.bRU.setContentView(com.baidu.tieba.x.signallforum_view);
        this.bRV = (RelativeLayout) this.bRU.findViewById(com.baidu.tieba.w.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.bRU.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.bRU.getPageContext().getString(com.baidu.tieba.z.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ae(this));
        this.bRX = (BdListView) this.bRU.findViewById(com.baidu.tieba.w.signallforum_list);
        this.bRX.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new ak(signAllForumActivity.getPageContext());
        this.bRX.setPullRefresh(this.mPullView);
        this.bSd = (TextView) com.baidu.adp.lib.g.b.ei().inflate(this.bRU.getPageContext().getPageActivity(), com.baidu.tieba.x.signallforum_maxcount_warning, null);
        this.bRX.addFooterView(this.bSd);
        this.bRW = new x(this.bRU.getPageContext().getPageActivity());
        this.mProgressBar = this.bRW.getProgressBar();
        this.mProgressBar.setOnClickListener(this.bRU);
        this.bRX.addHeaderView(this.bRW);
        this.bRW.setVisibility(8);
        this.bRZ = (RelativeLayout) this.bRW.findViewById(com.baidu.tieba.w.guidecontainer);
        this.bSc = (LinearLayout) this.bRW.findViewById(com.baidu.tieba.w.guideopenbtn);
        this.bSa = (TextView) this.bRW.findViewById(com.baidu.tieba.w.guidetip);
        this.bSb = (TextView) this.bRW.findViewById(com.baidu.tieba.w.guideopen);
        this.bSc.setOnClickListener(this.bRU);
        this.bRY = new o(this.bRU, null);
        this.bRX.setAdapter((ListAdapter) this.bRY);
        this.bRX.setOnScrollListener(this.bRY);
    }

    public void onChangeSkinType(int i) {
        this.bRU.getLayoutMode().ab(i == 1);
        this.bRU.getLayoutMode().h(this.bRV);
        this.bRU.getLayoutMode().h(this.bSd);
        this.bRU.getLayoutMode().h(this.bRW);
        bc.j(this.bRV, com.baidu.tieba.t.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.cs(i);
        this.bRY.notifyDataSetChanged();
    }

    public void d(b bVar) {
        if (bVar != null) {
            this.bQN = bVar;
            aei();
            ArrayList<d> adz = bVar.adz();
            this.bRY.b(this.bQN);
            if (adz.size() == bRT) {
                this.bSd.setVisibility(0);
                this.bSd.setText(bVar.adw());
                return;
            }
            this.bSd.setVisibility(8);
        }
    }

    private void aei() {
        if (this.bQN != null) {
            this.bRW.setHasPrivilege(this.bQN.adD());
            this.bRW.setmCurrentStatus(this.bQN.adF());
            TextView message1 = this.bRW.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.bQN.ads()) + this.bQN.adt() + this.bQN.adu());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.t.sign_all_forum_text_color));
            int length = this.bQN.ads().length();
            spannableString.setSpan(foregroundColorSpan, length, this.bQN.adt().length() + length, 33);
            message1.setText(spannableString);
            this.bRW.getMessage2().setText(this.bQN.adv());
            this.bSa.setText(this.bQN.getContent());
            if (TextUtils.isEmpty(this.bQN.adE())) {
                this.bSb.setText(com.baidu.tieba.z.sign_all_forum_memberbtn_content);
            } else {
                this.bSb.setText(this.bQN.adE());
            }
            this.bRW.setVisibility(0);
            if (this.bQN.adD() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.bRZ.setVisibility(8);
            } else {
                this.bRZ.setVisibility(0);
            }
        }
    }

    public void jJ() {
        this.bRX.jJ();
    }

    public void JI() {
        this.bRX.jI();
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.bRX.setOnItemClickListener(onItemClickListener);
    }

    public x aej() {
        return this.bRW;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aek() {
        return this.bRX;
    }

    public b ael() {
        return this.bQN;
    }

    public o aem() {
        return this.bRY;
    }

    public LinearLayout aen() {
        return this.bSc;
    }
}
