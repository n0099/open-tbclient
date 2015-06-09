package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.g<MoreActivity> {
    private AlertDialog cfA;
    private View cfB;
    private SettingTextImageView cfC;
    private TbSettingTextTipView cfD;
    private TbSettingTextTipView cfE;
    private TbSettingTextTipView cfF;
    private TbSettingTextTipView cfG;
    private SettingTextVersionView cfH;
    private TbSettingTextTipView cfI;
    private TbSettingTextTipView cfJ;
    private View cfK;
    private TbSettingTextNewDotView cfL;
    private TextView cfM;
    private RelativeLayout cfN;
    private View cfO;
    private MoreActivity cfy;
    private q cfz;
    private NavigationBar mNavigationBar;

    public aa(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.cfy = moreActivity;
        this.cfz = qVar;
        this.cfy.setContentView(com.baidu.tieba.r.more_activity);
        yc();
    }

    public void aiY() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cfC.setVisibility(8);
        } else {
            this.cfC.setVisibility(0);
        }
    }

    public void B(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cfC != null) {
                this.cfC.ajS();
                return;
            }
            return;
        }
        this.cfC.ajT();
        this.cfC.C(str, z);
    }

    public void refreshNewVersion() {
        if (this.cfH != null) {
            this.cfH.refresh();
        }
        if (this.cfL != null) {
            this.cfL.refresh();
        }
    }

    public void aio() {
        this.cfC.recycle();
        this.cfD.recycle();
        this.cfE.recycle();
        this.cfF.recycle();
        this.cfG.recycle();
        this.cfH.recycle();
        this.cfI.recycle();
        this.cfJ.recycle();
    }

    public void onChangeSkinType(int i) {
        dl(i);
        if (this.cfB != null) {
            this.cfy.getLayoutMode().ab(i == 1);
            this.cfy.getLayoutMode().j(this.cfB);
        }
    }

    public void dl(int i) {
        com.baidu.tbadk.core.util.ay.j(this.cfN, com.baidu.tieba.n.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cfC.dl(i);
        this.cfy.getLayoutMode().ab(i == 1);
        this.cfy.getLayoutMode().j(this.cfN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void yc() {
        View.OnClickListener aiZ = aiZ();
        this.cfN = (RelativeLayout) this.cfy.findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) this.cfy.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.cfO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cfy.getPageContext().getString(com.baidu.tieba.t.setup));
        this.cfC = (SettingTextImageView) this.cfy.findViewById(com.baidu.tieba.q.personInfo);
        this.cfD = (TbSettingTextTipView) this.cfy.findViewById(com.baidu.tieba.q.accountManager);
        this.cfE = (TbSettingTextTipView) this.cfy.findViewById(com.baidu.tieba.q.browseSetting);
        this.cfF = (TbSettingTextTipView) this.cfy.findViewById(com.baidu.tieba.q.messageSetting);
        this.cfG = (TbSettingTextTipView) this.cfy.findViewById(com.baidu.tieba.q.secretSetting);
        this.cfH = (SettingTextVersionView) this.cfy.findViewById(com.baidu.tieba.q.versionInfo);
        this.cfI = (TbSettingTextTipView) this.cfy.findViewById(com.baidu.tieba.q.feedBack);
        this.cfJ = (TbSettingTextTipView) this.cfy.findViewById(com.baidu.tieba.q.recommend);
        this.cfK = this.cfy.findViewById(com.baidu.tieba.q.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cfJ.setVisibility(8);
            this.cfK.setVisibility(8);
        } else {
            this.cfJ.setVisibility(0);
            this.cfK.setVisibility(0);
        }
        this.cfL = (TbSettingTextNewDotView) this.cfy.findViewById(com.baidu.tieba.q.systemhelpsetting);
        this.cfM = (TextView) this.cfy.findViewById(com.baidu.tieba.q.quit);
        refreshNewVersion();
        aiY();
        this.cfC.ajS();
        dl(TbadkCoreApplication.m411getInst().getSkinType());
        y(aiZ);
        if (!LL()) {
            this.cfE.setTip(this.cfy.getResources().getString(com.baidu.tieba.t.browsing_settings_tip_no_night));
        }
    }

    private boolean LL() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void createDialog() {
        this.cfB = com.baidu.adp.lib.g.b.hr().inflate(this.cfy.getPageContext().getPageActivity(), com.baidu.tieba.r.quit_dialog, null);
        this.cfy.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cfy.getLayoutMode().j(this.cfB);
        ((TextView) this.cfB.findViewById(com.baidu.tieba.q.id_close_tv)).setOnClickListener(new ab(this));
        ((TextView) this.cfB.findViewById(com.baidu.tieba.q.id_quit_tv)).setOnClickListener(new ac(this));
        this.cfA = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.cfA.show();
        if (this.cfA.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cfA.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cfA.getWindow().setAttributes(attributes);
            this.cfA.getWindow().setContentView(this.cfB);
        }
    }

    private void y(View.OnClickListener onClickListener) {
        this.cfO.setOnClickListener(onClickListener);
        this.cfC.setOnClickListener(onClickListener);
        this.cfD.setOnClickListener(onClickListener);
        this.cfE.setOnClickListener(onClickListener);
        this.cfF.setOnClickListener(onClickListener);
        this.cfG.setOnClickListener(onClickListener);
        this.cfH.setOnClickListener(onClickListener);
        this.cfI.setOnClickListener(onClickListener);
        this.cfJ.setOnClickListener(onClickListener);
        this.cfL.setOnClickListener(onClickListener);
        this.cfM.setOnClickListener(onClickListener);
    }

    private View.OnClickListener aiZ() {
        return new ad(this);
    }

    public void aja() {
        if (this.cfA == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.k.a(this.cfA, this.cfy.getPageContext());
    }
}
