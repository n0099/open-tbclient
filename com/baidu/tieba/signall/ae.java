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
    public static int ceO;
    private c cdH;
    private SignAllForumActivity ceP;
    private RelativeLayout ceQ;
    private x ceR;
    private BdListView ceS;
    private o ceT;
    private RelativeLayout ceU;
    private TextView ceV;
    private TextView ceW;
    private LinearLayout ceX;
    private TextView ceY;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.ag mPullView;

    public ae(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.mPullView = null;
        this.ceP = signAllForumActivity;
        this.ceP.setContentView(com.baidu.tieba.w.signallforum_view);
        this.ceQ = (RelativeLayout) this.ceP.findViewById(com.baidu.tieba.v.sign_all_forum_parent);
        this.mNavigationBar = (NavigationBar) this.ceP.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.ceP.getPageContext().getString(com.baidu.tieba.y.signallforum));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new af(this));
        this.ceS = (BdListView) this.ceP.findViewById(com.baidu.tieba.v.signallforum_list);
        this.ceS.setOnItemClickListener(signAllForumActivity);
        this.mPullView = new com.baidu.tbadk.core.view.ag(signAllForumActivity.getPageContext());
        this.ceS.setPullRefresh(this.mPullView);
        this.ceY = (TextView) com.baidu.adp.lib.g.b.hH().inflate(this.ceP.getPageContext().getPageActivity(), com.baidu.tieba.w.signallforum_maxcount_warning, null);
        this.ceS.addFooterView(this.ceY);
        this.ceR = new x(this.ceP.getPageContext().getPageActivity());
        this.mProgressBar = this.ceR.getProgressBar();
        this.mProgressBar.setOnClickListener(this.ceP);
        this.ceS.addHeaderView(this.ceR);
        this.ceR.setVisibility(8);
        this.ceU = (RelativeLayout) this.ceR.findViewById(com.baidu.tieba.v.guidecontainer);
        this.ceX = (LinearLayout) this.ceR.findViewById(com.baidu.tieba.v.guideopenbtn);
        this.ceV = (TextView) this.ceR.findViewById(com.baidu.tieba.v.guidetip);
        this.ceW = (TextView) this.ceR.findViewById(com.baidu.tieba.v.guideopen);
        this.ceX.setOnClickListener(this.ceP);
        this.ceT = new o(this.ceP, null);
        this.ceS.setAdapter((ListAdapter) this.ceT);
        this.ceS.setOnScrollListener(this.ceT);
    }

    public void onChangeSkinType(int i) {
        this.ceP.getLayoutMode().X(i == 1);
        this.ceP.getLayoutMode().h(this.ceQ);
        this.ceP.getLayoutMode().h(this.ceY);
        this.ceP.getLayoutMode().h(this.ceR);
        ba.j(this.ceQ, com.baidu.tieba.s.signallforum_item_bg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mPullView.ct(i);
        this.ceT.notifyDataSetChanged();
    }

    public void d(c cVar) {
        if (cVar != null) {
            this.cdH = cVar;
            aiU();
            ArrayList<e> aim = cVar.aim();
            this.ceT.b(this.cdH);
            if (aim.size() == ceO) {
                this.ceY.setVisibility(0);
                this.ceY.setText(cVar.aij());
                return;
            }
            this.ceY.setVisibility(8);
        }
    }

    private void aiU() {
        if (this.cdH != null) {
            this.ceR.setHasPrivilege(this.cdH.aiq());
            this.ceR.setmCurrentStatus(this.cdH.ais());
            TextView message1 = this.ceR.getMessage1();
            SpannableString spannableString = new SpannableString(String.valueOf(this.cdH.aif()) + this.cdH.aig() + this.cdH.aih());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(com.baidu.tieba.s.sign_all_forum_text_color));
            int length = this.cdH.aif().length();
            spannableString.setSpan(foregroundColorSpan, length, this.cdH.aig().length() + length, 33);
            message1.setText(spannableString);
            this.ceR.getMessage2().setText(this.cdH.aii());
            this.ceV.setText(this.cdH.getContent());
            if (TextUtils.isEmpty(this.cdH.air())) {
                this.ceW.setText(com.baidu.tieba.y.sign_all_forum_memberbtn_content);
            } else {
                this.ceW.setText(this.cdH.air());
            }
            this.ceR.setVisibility(0);
            if (this.cdH.aiq() || TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
                this.ceU.setVisibility(8);
            } else {
                this.ceU.setVisibility(0);
            }
        }
    }

    public void mX() {
        this.ceS.mX();
    }

    public void Hr() {
        this.ceS.mW();
    }

    public void a(com.baidu.tbadk.core.view.ae aeVar) {
        this.mPullView.a(aeVar);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ceS.setOnItemClickListener(onItemClickListener);
    }

    public x aiV() {
        return this.ceR;
    }

    public ProgressBar getProgressBar() {
        return this.mProgressBar;
    }

    public BdListView aiW() {
        return this.ceS;
    }

    public c aiX() {
        return this.cdH;
    }

    public o aiY() {
        return this.ceT;
    }

    public LinearLayout aiZ() {
        return this.ceX;
    }
}
