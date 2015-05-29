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
    private View cfA;
    private SettingTextImageView cfB;
    private TbSettingTextTipView cfC;
    private TbSettingTextTipView cfD;
    private TbSettingTextTipView cfE;
    private TbSettingTextTipView cfF;
    private SettingTextVersionView cfG;
    private TbSettingTextTipView cfH;
    private TbSettingTextTipView cfI;
    private View cfJ;
    private TbSettingTextNewDotView cfK;
    private TextView cfL;
    private RelativeLayout cfM;
    private View cfN;
    private MoreActivity cfx;
    private q cfy;
    private AlertDialog cfz;
    private NavigationBar mNavigationBar;

    public aa(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.cfx = moreActivity;
        this.cfy = qVar;
        this.cfx.setContentView(com.baidu.tieba.r.more_activity);
        yb();
    }

    public void aiX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cfB.setVisibility(8);
        } else {
            this.cfB.setVisibility(0);
        }
    }

    public void B(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.cfB != null) {
                this.cfB.ajR();
                return;
            }
            return;
        }
        this.cfB.ajS();
        this.cfB.C(str, z);
    }

    public void refreshNewVersion() {
        if (this.cfG != null) {
            this.cfG.refresh();
        }
        if (this.cfK != null) {
            this.cfK.refresh();
        }
    }

    public void ain() {
        this.cfB.recycle();
        this.cfC.recycle();
        this.cfD.recycle();
        this.cfE.recycle();
        this.cfF.recycle();
        this.cfG.recycle();
        this.cfH.recycle();
        this.cfI.recycle();
    }

    public void onChangeSkinType(int i) {
        dl(i);
        if (this.cfA != null) {
            this.cfx.getLayoutMode().ab(i == 1);
            this.cfx.getLayoutMode().j(this.cfA);
        }
    }

    public void dl(int i) {
        com.baidu.tbadk.core.util.ay.j(this.cfM, com.baidu.tieba.n.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cfB.dl(i);
        this.cfx.getLayoutMode().ab(i == 1);
        this.cfx.getLayoutMode().j(this.cfM);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void yb() {
        View.OnClickListener aiY = aiY();
        this.cfM = (RelativeLayout) this.cfx.findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) this.cfx.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.cfN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cfx.getPageContext().getString(com.baidu.tieba.t.setup));
        this.cfB = (SettingTextImageView) this.cfx.findViewById(com.baidu.tieba.q.personInfo);
        this.cfC = (TbSettingTextTipView) this.cfx.findViewById(com.baidu.tieba.q.accountManager);
        this.cfD = (TbSettingTextTipView) this.cfx.findViewById(com.baidu.tieba.q.browseSetting);
        this.cfE = (TbSettingTextTipView) this.cfx.findViewById(com.baidu.tieba.q.messageSetting);
        this.cfF = (TbSettingTextTipView) this.cfx.findViewById(com.baidu.tieba.q.secretSetting);
        this.cfG = (SettingTextVersionView) this.cfx.findViewById(com.baidu.tieba.q.versionInfo);
        this.cfH = (TbSettingTextTipView) this.cfx.findViewById(com.baidu.tieba.q.feedBack);
        this.cfI = (TbSettingTextTipView) this.cfx.findViewById(com.baidu.tieba.q.recommend);
        this.cfJ = this.cfx.findViewById(com.baidu.tieba.q.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.cfI.setVisibility(8);
            this.cfJ.setVisibility(8);
        } else {
            this.cfI.setVisibility(0);
            this.cfJ.setVisibility(0);
        }
        this.cfK = (TbSettingTextNewDotView) this.cfx.findViewById(com.baidu.tieba.q.systemhelpsetting);
        this.cfL = (TextView) this.cfx.findViewById(com.baidu.tieba.q.quit);
        refreshNewVersion();
        aiX();
        this.cfB.ajR();
        dl(TbadkCoreApplication.m411getInst().getSkinType());
        y(aiY);
        if (!LK()) {
            this.cfD.setTip(this.cfx.getResources().getString(com.baidu.tieba.t.browsing_settings_tip_no_night));
        }
    }

    private boolean LK() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void createDialog() {
        this.cfA = com.baidu.adp.lib.g.b.hr().inflate(this.cfx.getPageContext().getPageActivity(), com.baidu.tieba.r.quit_dialog, null);
        this.cfx.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cfx.getLayoutMode().j(this.cfA);
        ((TextView) this.cfA.findViewById(com.baidu.tieba.q.id_close_tv)).setOnClickListener(new ab(this));
        ((TextView) this.cfA.findViewById(com.baidu.tieba.q.id_quit_tv)).setOnClickListener(new ac(this));
        this.cfz = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.cfz.show();
        if (this.cfz.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.cfz.getWindow().getAttributes();
            attributes.dimAmount = 0.7f;
            this.cfz.getWindow().setAttributes(attributes);
            this.cfz.getWindow().setContentView(this.cfA);
        }
    }

    private void y(View.OnClickListener onClickListener) {
        this.cfN.setOnClickListener(onClickListener);
        this.cfB.setOnClickListener(onClickListener);
        this.cfC.setOnClickListener(onClickListener);
        this.cfD.setOnClickListener(onClickListener);
        this.cfE.setOnClickListener(onClickListener);
        this.cfF.setOnClickListener(onClickListener);
        this.cfG.setOnClickListener(onClickListener);
        this.cfH.setOnClickListener(onClickListener);
        this.cfI.setOnClickListener(onClickListener);
        this.cfK.setOnClickListener(onClickListener);
        this.cfL.setOnClickListener(onClickListener);
    }

    private View.OnClickListener aiY() {
        return new ad(this);
    }

    public void aiZ() {
        if (this.cfz == null) {
            createDialog();
        }
        com.baidu.adp.lib.g.k.a(this.cfz, this.cfx.getPageContext());
    }
}
