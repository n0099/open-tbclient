package com.baidu.tieba.setting.more;

import android.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextNewDotView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.g<MoreActivity> {
    private View bNI;
    private MoreActivity caI;
    private q caJ;
    private AlertDialog caK;
    private SettingTextImageView caL;
    private TbSettingTextTipView caM;
    private TbSettingTextTipView caN;
    private TbSettingTextTipView caO;
    private TbSettingTextTipView caP;
    private SettingTextVersionView caQ;
    private TbSettingTextTipView caR;
    private TbSettingTextTipView caS;
    private View caT;
    private TbSettingTextNewDotView caU;
    private TextView caV;
    private RelativeLayout caW;
    private NavigationBar mNavigationBar;

    public aa(MoreActivity moreActivity, q qVar) {
        super(moreActivity.getPageContext());
        this.caI = moreActivity;
        this.caJ = qVar;
        this.caI.setContentView(com.baidu.tieba.w.more_activity);
        xi();
    }

    public void agQ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.caL.setVisibility(8);
        } else {
            this.caL.setVisibility(0);
        }
    }

    public void B(String str, boolean z) {
        if (str == null || str.length() <= 0) {
            if (this.caL != null) {
                this.caL.ahL();
                return;
            }
            return;
        }
        this.caL.ahM();
        this.caL.C(str, z);
    }

    public void refreshNewVersion() {
        if (this.caQ != null) {
            this.caQ.refresh();
        }
        if (this.caU != null) {
            this.caU.refresh();
        }
    }

    public void agf() {
        this.caL.recycle();
        this.caM.recycle();
        this.caN.recycle();
        this.caO.recycle();
        this.caP.recycle();
        this.caQ.recycle();
        this.caR.recycle();
        this.caS.recycle();
    }

    public void onChangeSkinType(int i) {
        dc(i);
    }

    public void dc(int i) {
        com.baidu.tbadk.core.util.ba.j(this.caW, com.baidu.tieba.s.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.caL.dc(i);
        this.caI.getLayoutMode().X(i == 1);
        this.caI.getLayoutMode().h(this.caW);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        refreshNewVersion();
    }

    private void xi() {
        View.OnClickListener agS = agS();
        this.caW = (RelativeLayout) this.caI.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) this.caI.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bNI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.caI.getPageContext().getString(com.baidu.tieba.y.setup));
        this.caL = (SettingTextImageView) this.caI.findViewById(com.baidu.tieba.v.personInfo);
        this.caM = (TbSettingTextTipView) this.caI.findViewById(com.baidu.tieba.v.accountManager);
        this.caN = (TbSettingTextTipView) this.caI.findViewById(com.baidu.tieba.v.browseSetting);
        this.caO = (TbSettingTextTipView) this.caI.findViewById(com.baidu.tieba.v.messageSetting);
        this.caP = (TbSettingTextTipView) this.caI.findViewById(com.baidu.tieba.v.secretSetting);
        this.caQ = (SettingTextVersionView) this.caI.findViewById(com.baidu.tieba.v.versionInfo);
        this.caR = (TbSettingTextTipView) this.caI.findViewById(com.baidu.tieba.v.feedBack);
        this.caS = (TbSettingTextTipView) this.caI.findViewById(com.baidu.tieba.v.recommend);
        this.caT = this.caI.findViewById(com.baidu.tieba.v.line_recommend);
        if (!TbadkCoreApplication.m411getInst().getIsAppOn()) {
            this.caS.setVisibility(8);
            this.caT.setVisibility(8);
        } else {
            this.caS.setVisibility(0);
            this.caT.setVisibility(0);
        }
        this.caU = (TbSettingTextNewDotView) this.caI.findViewById(com.baidu.tieba.v.systemhelpsetting);
        this.caV = (TextView) this.caI.findViewById(com.baidu.tieba.v.quit);
        refreshNewVersion();
        agQ();
        this.caL.ahL();
        dc(TbadkCoreApplication.m411getInst().getSkinType());
        z(agS);
        agR();
        if (!Kv()) {
            this.caN.setTip(this.caI.getResources().getString(com.baidu.tieba.y.browsing_settings_tip_no_night));
        }
    }

    private boolean Kv() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void agR() {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.caI.getPageContext().getPageActivity(), com.baidu.tieba.w.quit_dialog, null);
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_close_ll)).setOnClickListener(new ab(this));
        ((LinearLayout) inflate.findViewById(com.baidu.tieba.v.id_quit_ll)).setOnClickListener(new ac(this));
        this.caK = new AlertDialog.Builder(this.mContext.getPageActivity()).create();
        this.caK.setView(inflate, 0, 0, 0, 0);
    }

    private void z(View.OnClickListener onClickListener) {
        this.bNI.setOnClickListener(onClickListener);
        this.caL.setOnClickListener(onClickListener);
        this.caM.setOnClickListener(onClickListener);
        this.caN.setOnClickListener(onClickListener);
        this.caO.setOnClickListener(onClickListener);
        this.caP.setOnClickListener(onClickListener);
        this.caQ.setOnClickListener(onClickListener);
        this.caR.setOnClickListener(onClickListener);
        this.caS.setOnClickListener(onClickListener);
        this.caU.setOnClickListener(onClickListener);
        this.caV.setOnClickListener(onClickListener);
    }

    private View.OnClickListener agS() {
        return new ad(this);
    }

    public void agT() {
        if (this.caK != null) {
            com.baidu.adp.lib.g.k.a(this.caK, this.caI.getPageContext());
        }
    }
}
