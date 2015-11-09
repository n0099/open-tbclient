package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView LO;
    private RelativeLayout brS;
    private MsgSettingItemView2 cPA;
    private MsgSettingItemView2 cPB;
    private MsgSettingItemView cPC;
    private MsgSettingItemView cPD;
    private MsgSettingItemView cPE;
    private MsgSettingItemView cPF;
    private MsgSettingItemView cPG;
    private MsgSettingItemView cPH;
    private LinearLayout cPI;
    private TextView cPJ;
    private MsgSettingItemView cPK;
    private MsgSettingItemView cPL;
    private MsgSettingItemView cPM;
    private LinearLayout cPN;
    private TextView cPO;
    private LinearLayout cPP;
    private LinearLayout cPQ;
    private LinearLayout cPR;
    private TextView cPS;
    private LinearLayout cPT;
    private TextView cPU;
    public boolean cPV;
    private MsgRemindActivity cPW;
    private MsgSettingItemView cPu;
    private LinearLayout cPv;
    private MsgSettingItemView2 cPw;
    private MsgSettingItemView2 cPx;
    private MsgSettingItemView2 cPy;
    private MsgSettingItemView2 cPz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ae(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.brS = null;
        this.mNavigationBar = null;
        this.LO = null;
        this.cPV = true;
        this.cPW = msgRemindActivity;
        msgRemindActivity.setContentView(i.g.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        asQ();
        asW();
        asV();
        asU();
        asT();
        asR();
        asX();
        asS();
        d(msgRemindActivity);
        asL();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.brS = (RelativeLayout) msgRemindActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cPP = (LinearLayout) msgRemindActivity.findViewById(i.f.front_container);
        this.cPQ = (LinearLayout) msgRemindActivity.findViewById(i.f.back_container);
        this.LO = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(i.h.msg_remind));
        this.cPu = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.receive_message_swtich);
        this.cPu.setText(i.h.receive_msg_text);
        this.cPu.setLineVisibility(true);
        this.cPv = (LinearLayout) msgRemindActivity.findViewById(i.f.receive_message_container);
        this.cPw = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.reply_check_box);
        this.cPw.setText(i.h.frs_item_reply_text);
        this.cPx = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.zan_check_box);
        this.cPx.setText(i.h.frs_item_praise_text);
        this.cPy = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.at_me_check_box);
        this.cPy.setText(i.h.mention_atme);
        this.cPz = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.new_fans_swtich);
        this.cPz.setText(i.h.new_fans);
        this.cPA = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.chat_msg_swtich);
        this.cPA.setText(i.h.chat_msg_text);
        this.cPB = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.group_chat_swtich);
        this.cPB.setLineVisibility(false);
        this.cPB.setText(i.h.group_chat_text);
        this.cPC = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.screen_lock_swtich);
        this.cPC.setText(i.h.remind_screen_lock);
        this.cPD = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.chat_float_swtich);
        this.cPD.setLineVisibility(false);
        this.cPD.setText(i.h.chat_float_window);
        this.cPE = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.tone_remind_swtich);
        this.cPE.setText(i.h.remind_tone);
        this.cPF = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.vibrate_remind_swtich);
        this.cPF.setText(i.h.remind_vibrate);
        this.cPG = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.light_remind_swtich);
        this.cPG.setLineVisibility(true);
        this.cPG.setText(i.h.remind_light);
        this.cPH = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.sign_remind_swtich);
        this.cPH.setText(i.h.sign_remind_outline);
        this.cPI = (LinearLayout) msgRemindActivity.findViewById(i.f.sign_remind);
        this.cPJ = (TextView) msgRemindActivity.findViewById(i.f.sign_remind_time);
        this.cPK = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.promoted_content_swtich);
        this.cPK.setLineVisibility(true);
        this.cPK.setText(i.h.promoted_message_text);
        this.cPM = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.no_disturb_swtich);
        this.cPM.setText(i.h.no_disturb_mode);
        this.cPN = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_container);
        this.cPO = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_value);
        this.cPR = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_start_time);
        this.cPS = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_start_time_value);
        this.cPT = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_end_time);
        this.cPU = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_end_time_value);
        this.cPL = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.remind_recommend_swtich);
        this.cPL.setLineVisibility(false);
        this.cPL.setText(i.h.remind_message_recommend);
    }

    private void asL() {
        asM();
        asN();
        asO();
        asP();
    }

    private void asM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cPM.setVisibility(8);
            this.cPN.setVisibility(8);
            this.cPu.setVisibility(8);
            this.cPv.setVisibility(8);
            this.cPH.setVisibility(8);
            this.cPI.setVisibility(8);
            this.cPE.setVisibility(8);
            this.cPF.setVisibility(8);
            this.cPG.setVisibility(8);
            this.cPC.setVisibility(8);
            this.cPD.setVisibility(8);
        }
    }

    private void asN() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cPD.setVisibility(0);
            this.cPC.setLineVisibility(true);
            return;
        }
        this.cPD.setVisibility(8);
        this.cPC.setLineVisibility(false);
    }

    private void asO() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cPA.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cPB.setVisibility(0);
        } else {
            this.cPB.setVisibility(8);
        }
    }

    private void asP() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cPC.setVisibility(0);
        } else {
            this.cPC.setVisibility(8);
        }
    }

    public View akF() {
        return this.mBack;
    }

    private void asQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xl()) {
            this.cPu.mA();
            this.cPv.setVisibility(0);
        } else {
            this.cPu.mB();
            this.cPv.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xq()) {
            this.cPw.getSwitchView().setChecked(true);
        } else {
            this.cPw.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xz()) {
            this.cPx.getSwitchView().setChecked(true);
        } else {
            this.cPx.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo()) {
            this.cPy.getSwitchView().setChecked(true);
        } else {
            this.cPy.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xp()) {
            this.cPz.getSwitchView().setChecked(true);
        } else {
            this.cPz.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr()) {
            this.cPA.getSwitchView().setChecked(true);
        } else {
            this.cPA.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy()) {
            this.cPB.getSwitchView().setChecked(true);
        } else {
            this.cPB.getSwitchView().setChecked(false);
        }
    }

    private void asR() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cPK.mA();
        } else {
            this.cPK.mB();
        }
    }

    private void asS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xD()) {
            this.cPL.mA();
        } else {
            this.cPL.mB();
        }
    }

    private void asT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().isSignAlertOn()) {
            this.cPH.mC();
            this.cPI.setVisibility(0);
            this.cPH.setLineVisibility(true);
            asY();
            return;
        }
        this.cPH.mD();
        this.cPH.setLineVisibility(false);
        this.cPI.setVisibility(8);
    }

    private void asU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xs()) {
            this.cPE.mA();
        } else {
            this.cPE.mB();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xv()) {
            this.cPF.mA();
        } else {
            this.cPF.mB();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xt()) {
            this.cPG.mA();
        } else {
            this.cPG.mB();
        }
    }

    private void asV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xA()) {
            this.cPD.mA();
        } else {
            this.cPD.mB();
        }
    }

    private void asW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xB()) {
            this.cPC.mA();
        } else {
            this.cPC.mB();
        }
    }

    private void asX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xu()) {
            this.cPM.mA();
            this.cPN.setVisibility(0);
            asZ();
            return;
        }
        this.cPM.mB();
        this.cPN.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cPu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPw.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cPy.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cPx.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cPz.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cPA.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cPB.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cPC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPI.setOnClickListener(msgRemindActivity);
        this.cPK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cPN.setOnClickListener(msgRemindActivity);
        this.cPR.setOnClickListener(msgRemindActivity);
        this.cPT.setOnClickListener(msgRemindActivity);
        this.cPL.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void gc(boolean z) {
        this.cPM.setLineVisibility(z);
        if (z) {
            this.cPN.setVisibility(0);
            asZ();
            com.baidu.tbadk.core.util.an.i(this.cPN, i.e.more_all);
            return;
        }
        this.cPN.setVisibility(8);
    }

    public void gd(boolean z) {
        if (z) {
            this.cPI.setVisibility(0);
            this.cPH.setLineVisibility(true);
            com.baidu.tbadk.core.util.an.i(this.cPI, i.e.more_all);
            return;
        }
        this.cPI.setVisibility(8);
        this.cPH.setLineVisibility(false);
    }

    public void ge(boolean z) {
        if (z) {
            this.cPv.setVisibility(0);
        } else {
            this.cPv.setVisibility(8);
        }
    }

    public void asY() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xj().getSignAlertMins();
            }
            this.cPJ.setText(this.cPW.getPageContext().getPageActivity().getString(i.h.sign_remind_time, new Object[]{str, str2}));
            this.cPI.setVisibility(0);
            if (!this.cPH.hy()) {
                this.cPH.mA();
                return;
            }
            return;
        }
        this.cPJ.setText(i.h.close);
        this.cPI.setVisibility(8);
        if (this.cPH.hy()) {
            this.cPH.mB();
        }
    }

    public void asZ() {
        this.cPO.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xw()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.xj().xx());
        this.cPS.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xw());
        this.cPU.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xx());
    }

    public BdSwitchView ata() {
        return this.cPL.getSwitchView();
    }

    public BdSwitchView atb() {
        return this.cPK.getSwitchView();
    }

    public BdSwitchView atc() {
        return this.cPH.getSwitchView();
    }

    public BdSwitchView atd() {
        return this.cPu.getSwitchView();
    }

    public View ate() {
        return this.cPI;
    }

    public BdSwitchView atf() {
        return this.cPM.getSwitchView();
    }

    public View atg() {
        return this.cPN;
    }

    public LinearLayout ath() {
        return this.cPR;
    }

    public LinearLayout ati() {
        return this.cPT;
    }

    public BdSwitchView atj() {
        return this.cPE.getSwitchView();
    }

    public BdSwitchView atk() {
        return this.cPF.getSwitchView();
    }

    public BdSwitchView atl() {
        return this.cPG.getSwitchView();
    }

    public BdSwitchView atm() {
        return this.cPC.getSwitchView();
    }

    public BdSwitchView atn() {
        return this.cPD.getSwitchView();
    }

    public CheckBox ato() {
        return this.cPw.getSwitchView();
    }

    public CheckBox atp() {
        return this.cPx.getSwitchView();
    }

    public CheckBox atq() {
        return this.cPy.getSwitchView();
    }

    public CheckBox atr() {
        return this.cPA.getSwitchView();
    }

    public CheckBox ats() {
        return this.cPB.getSwitchView();
    }

    public CheckBox att() {
        return this.cPz.getSwitchView();
    }

    public void atu() {
        this.cPw.getSwitchView().setOnCheckedChangeListener(null);
        this.cPw.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xq());
        this.cPw.getSwitchView().setOnCheckedChangeListener(this.cPW);
    }

    public void atv() {
        this.cPx.getSwitchView().setOnCheckedChangeListener(null);
        this.cPx.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xz());
        this.cPx.getSwitchView().setOnCheckedChangeListener(this.cPW);
    }

    public void atw() {
        this.cPy.getSwitchView().setOnCheckedChangeListener(null);
        this.cPy.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo());
        this.cPy.getSwitchView().setOnCheckedChangeListener(this.cPW);
    }

    public void atx() {
        this.cPz.getSwitchView().setOnCheckedChangeListener(null);
        this.cPz.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xp());
        this.cPz.getSwitchView().setOnCheckedChangeListener(this.cPW);
    }

    public void aty() {
        this.cPA.getSwitchView().setOnCheckedChangeListener(null);
        this.cPA.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr());
        this.cPA.getSwitchView().setOnCheckedChangeListener(this.cPW);
    }

    public void atz() {
        this.cPB.getSwitchView().setOnCheckedChangeListener(null);
        this.cPB.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy());
        this.cPB.getSwitchView().setOnCheckedChangeListener(this.cPW);
    }

    public void gf(boolean z) {
        if (this.cPV != z) {
            this.cPV = z;
            if (z) {
                this.LO.setText(i.h.msg_remind);
                this.cPP.setVisibility(0);
                this.cPQ.setVisibility(8);
                return;
            }
            this.LO.setText(i.h.no_disturb_mode_time);
            this.cPQ.setVisibility(0);
            this.cPP.setVisibility(8);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v19, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v27, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v29, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v33, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v47, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cPW.getLayoutMode().ad(i == 1);
        this.cPW.getLayoutMode().k(this.brS);
        this.mNavigationBar.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPu.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPw.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPx.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPy.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPz.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPA.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPB.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPC.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPD.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPE.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPF.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPG.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPH.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPK.onChangeSkinType(this.cPW.getPageContext(), i);
        this.cPM.onChangeSkinType(this.cPW.getPageContext(), i);
        if (this.cPL != null) {
            this.cPL.onChangeSkinType(this.cPW.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.an.i(this.cPN, i.e.more_all);
        com.baidu.tbadk.core.util.an.i(this.cPR, i.e.more_all);
        com.baidu.tbadk.core.util.an.i(this.cPT, i.e.more_all);
        com.baidu.tbadk.core.util.an.i(this.cPI, i.e.more_all);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cPN.findViewById(i.f.no_disturb_mode_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cPI.findViewById(i.f.sign_remind_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cPR.findViewById(i.f.no_disturb_start_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cPT.findViewById(i.f.no_disturb_end_time_arrow), i.e.icon_arrow_right);
    }
}
