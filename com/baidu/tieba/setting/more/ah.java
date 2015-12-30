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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView Mv;
    private RelativeLayout bKF;
    private LinearLayout dvA;
    private TextView dvB;
    private LinearLayout dvC;
    private TextView dvD;
    public boolean dvE;
    private MsgRemindActivity dvF;
    private MsgSettingItemView dvd;
    private LinearLayout dve;
    private MsgSettingItemView2 dvf;
    private MsgSettingItemView2 dvg;
    private MsgSettingItemView2 dvh;
    private MsgSettingItemView2 dvi;
    private MsgSettingItemView2 dvj;
    private MsgSettingItemView2 dvk;
    private MsgSettingItemView dvl;
    private MsgSettingItemView dvm;
    private MsgSettingItemView dvn;
    private MsgSettingItemView dvo;
    private MsgSettingItemView dvp;
    private MsgSettingItemView dvq;
    private LinearLayout dvr;
    private TextView dvs;
    private MsgSettingItemView dvt;
    private MsgSettingItemView dvu;
    private MsgSettingItemView dvv;
    private LinearLayout dvw;
    private TextView dvx;
    private LinearLayout dvy;
    private LinearLayout dvz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ah(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bKF = null;
        this.mNavigationBar = null;
        this.Mv = null;
        this.dvE = true;
        this.dvF = msgRemindActivity;
        msgRemindActivity.setContentView(n.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        aAy();
        aAE();
        aAD();
        aAC();
        aAB();
        aAz();
        aAF();
        aAA();
        d(msgRemindActivity);
        aAt();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.bKF = (RelativeLayout) msgRemindActivity.findViewById(n.g.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(n.g.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dvy = (LinearLayout) msgRemindActivity.findViewById(n.g.front_container);
        this.dvz = (LinearLayout) msgRemindActivity.findViewById(n.g.back_container);
        this.Mv = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(n.j.msg_remind));
        this.dvd = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.receive_message_swtich);
        this.dvd.setText(n.j.receive_msg_text);
        this.dvd.setLineVisibility(true);
        this.dve = (LinearLayout) msgRemindActivity.findViewById(n.g.receive_message_container);
        this.dvf = (MsgSettingItemView2) msgRemindActivity.findViewById(n.g.reply_check_box);
        this.dvf.setText(n.j.frs_item_reply_text);
        this.dvg = (MsgSettingItemView2) msgRemindActivity.findViewById(n.g.zan_check_box);
        this.dvg.setText(n.j.frs_item_praise_text);
        this.dvh = (MsgSettingItemView2) msgRemindActivity.findViewById(n.g.at_me_check_box);
        this.dvh.setText(n.j.mention_atme);
        this.dvi = (MsgSettingItemView2) msgRemindActivity.findViewById(n.g.new_fans_swtich);
        this.dvi.setText(n.j.new_fans);
        this.dvj = (MsgSettingItemView2) msgRemindActivity.findViewById(n.g.chat_msg_swtich);
        this.dvj.setText(n.j.chat_msg_text);
        this.dvk = (MsgSettingItemView2) msgRemindActivity.findViewById(n.g.group_chat_swtich);
        this.dvk.setLineVisibility(false);
        this.dvk.setText(n.j.group_chat_text);
        this.dvl = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.screen_lock_swtich);
        this.dvl.setText(n.j.remind_screen_lock);
        this.dvm = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.chat_float_swtich);
        this.dvm.setLineVisibility(false);
        this.dvm.setText(n.j.chat_float_window);
        this.dvn = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.tone_remind_swtich);
        this.dvn.setText(n.j.remind_tone);
        this.dvo = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.vibrate_remind_swtich);
        this.dvo.setText(n.j.remind_vibrate);
        this.dvp = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.light_remind_swtich);
        this.dvp.setLineVisibility(true);
        this.dvp.setText(n.j.remind_light);
        this.dvq = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.sign_remind_swtich);
        this.dvq.setText(n.j.sign_remind_outline);
        this.dvr = (LinearLayout) msgRemindActivity.findViewById(n.g.sign_remind);
        this.dvs = (TextView) msgRemindActivity.findViewById(n.g.sign_remind_time);
        this.dvt = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.promoted_content_swtich);
        this.dvt.setLineVisibility(true);
        this.dvt.setText(n.j.promoted_message_text);
        this.dvv = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.no_disturb_swtich);
        this.dvv.setText(n.j.no_disturb_mode);
        this.dvw = (LinearLayout) msgRemindActivity.findViewById(n.g.no_disturb_mode_time_container);
        this.dvx = (TextView) msgRemindActivity.findViewById(n.g.no_disturb_mode_time_value);
        this.dvA = (LinearLayout) msgRemindActivity.findViewById(n.g.no_disturb_start_time);
        this.dvB = (TextView) msgRemindActivity.findViewById(n.g.no_disturb_start_time_value);
        this.dvC = (LinearLayout) msgRemindActivity.findViewById(n.g.no_disturb_end_time);
        this.dvD = (TextView) msgRemindActivity.findViewById(n.g.no_disturb_end_time_value);
        this.dvu = (MsgSettingItemView) msgRemindActivity.findViewById(n.g.remind_recommend_swtich);
        this.dvu.setLineVisibility(false);
        this.dvu.setText(n.j.remind_message_recommend);
    }

    private void aAt() {
        aAu();
        aAv();
        aAw();
        aAx();
    }

    private void aAu() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.dvv.setVisibility(8);
            this.dvw.setVisibility(8);
            this.dvd.setVisibility(8);
            this.dve.setVisibility(8);
            this.dvq.setVisibility(8);
            this.dvr.setVisibility(8);
            this.dvn.setVisibility(8);
            this.dvo.setVisibility(8);
            this.dvp.setVisibility(8);
            this.dvl.setVisibility(8);
            this.dvm.setVisibility(8);
        }
    }

    private void aAv() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.dvm.setVisibility(0);
            this.dvl.setLineVisibility(true);
            return;
        }
        this.dvm.setVisibility(8);
        this.dvl.setLineVisibility(false);
    }

    private void aAw() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.dvj.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.dvk.setVisibility(0);
        } else {
            this.dvk.setVisibility(8);
        }
    }

    private void aAx() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.dvl.setVisibility(0);
        } else {
            this.dvl.setVisibility(8);
        }
    }

    public View aqV() {
        return this.mBack;
    }

    private void aAy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xU()) {
            this.dvd.mc();
            this.dve.setVisibility(0);
        } else {
            this.dvd.md();
            this.dve.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ()) {
            this.dvf.getSwitchView().setChecked(true);
        } else {
            this.dvf.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yi()) {
            this.dvg.getSwitchView().setChecked(true);
        } else {
            this.dvg.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX()) {
            this.dvh.getSwitchView().setChecked(true);
        } else {
            this.dvh.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().xY()) {
            this.dvi.getSwitchView().setChecked(true);
        } else {
            this.dvi.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya()) {
            this.dvj.getSwitchView().setChecked(true);
        } else {
            this.dvj.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yh()) {
            this.dvk.getSwitchView().setChecked(true);
        } else {
            this.dvk.getSwitchView().setChecked(false);
        }
    }

    private void aAz() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.dvt.mc();
        } else {
            this.dvt.md();
        }
    }

    private void aAA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().ym()) {
            this.dvu.mc();
        } else {
            this.dvu.md();
        }
    }

    private void aAB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().isSignAlertOn()) {
            this.dvq.me();
            this.dvr.setVisibility(0);
            this.dvq.setLineVisibility(true);
            aAG();
            return;
        }
        this.dvq.mf();
        this.dvq.setLineVisibility(false);
        this.dvr.setVisibility(8);
    }

    private void aAC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yb()) {
            this.dvn.mc();
        } else {
            this.dvn.md();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().ye()) {
            this.dvo.mc();
        } else {
            this.dvo.md();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yc()) {
            this.dvp.mc();
        } else {
            this.dvp.md();
        }
    }

    private void aAD() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yj()) {
            this.dvm.mc();
        } else {
            this.dvm.md();
        }
    }

    private void aAE() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yk()) {
            this.dvl.mc();
        } else {
            this.dvl.md();
        }
    }

    private void aAF() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().yd()) {
            this.dvv.mc();
            this.dvw.setVisibility(0);
            aAH();
            return;
        }
        this.dvv.md();
        this.dvw.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.dvd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvf.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dvh.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dvg.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dvi.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dvj.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dvk.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dvl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvr.setOnClickListener(msgRemindActivity);
        this.dvt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dvw.setOnClickListener(msgRemindActivity);
        this.dvA.setOnClickListener(msgRemindActivity);
        this.dvC.setOnClickListener(msgRemindActivity);
        this.dvu.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void ha(boolean z) {
        this.dvv.setLineVisibility(z);
        if (z) {
            this.dvw.setVisibility(0);
            aAH();
            com.baidu.tbadk.core.util.as.i(this.dvw, n.f.more_all);
            return;
        }
        this.dvw.setVisibility(8);
    }

    public void hb(boolean z) {
        if (z) {
            this.dvr.setVisibility(0);
            this.dvq.setLineVisibility(true);
            com.baidu.tbadk.core.util.as.i(this.dvr, n.f.more_all);
            return;
        }
        this.dvr.setVisibility(8);
        this.dvq.setLineVisibility(false);
    }

    public void hc(boolean z) {
        if (z) {
            this.dve.setVisibility(0);
        } else {
            this.dve.setVisibility(8);
        }
    }

    public void aAG() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xS().getSignAlertMins();
            }
            this.dvs.setText(this.dvF.getPageContext().getPageActivity().getString(n.j.sign_remind_time, new Object[]{str, str2}));
            this.dvr.setVisibility(0);
            if (!this.dvq.hA()) {
                this.dvq.mc();
                return;
            }
            return;
        }
        this.dvs.setText(n.j.close);
        this.dvr.setVisibility(8);
        if (this.dvq.hA()) {
            this.dvq.md();
        }
    }

    public void aAH() {
        this.dvx.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yf()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.xS().yg());
        this.dvB.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yf());
        this.dvD.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yg());
    }

    public BdSwitchView aAI() {
        return this.dvu.getSwitchView();
    }

    public BdSwitchView aAJ() {
        return this.dvt.getSwitchView();
    }

    public BdSwitchView aAK() {
        return this.dvq.getSwitchView();
    }

    public BdSwitchView aAL() {
        return this.dvd.getSwitchView();
    }

    public View aAM() {
        return this.dvr;
    }

    public BdSwitchView aAN() {
        return this.dvv.getSwitchView();
    }

    public View aAO() {
        return this.dvw;
    }

    public LinearLayout aAP() {
        return this.dvA;
    }

    public LinearLayout aAQ() {
        return this.dvC;
    }

    public BdSwitchView aAR() {
        return this.dvn.getSwitchView();
    }

    public BdSwitchView aAS() {
        return this.dvo.getSwitchView();
    }

    public BdSwitchView aAT() {
        return this.dvp.getSwitchView();
    }

    public BdSwitchView aAU() {
        return this.dvl.getSwitchView();
    }

    public BdSwitchView aAV() {
        return this.dvm.getSwitchView();
    }

    public CheckBox aAW() {
        return this.dvf.getSwitchView();
    }

    public CheckBox aAX() {
        return this.dvg.getSwitchView();
    }

    public CheckBox aAY() {
        return this.dvh.getSwitchView();
    }

    public CheckBox aAZ() {
        return this.dvj.getSwitchView();
    }

    public CheckBox aBa() {
        return this.dvk.getSwitchView();
    }

    public CheckBox aBb() {
        return this.dvi.getSwitchView();
    }

    public void aBc() {
        this.dvf.getSwitchView().setOnCheckedChangeListener(null);
        this.dvf.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ());
        this.dvf.getSwitchView().setOnCheckedChangeListener(this.dvF);
    }

    public void aBd() {
        this.dvg.getSwitchView().setOnCheckedChangeListener(null);
        this.dvg.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yi());
        this.dvg.getSwitchView().setOnCheckedChangeListener(this.dvF);
    }

    public void aBe() {
        this.dvh.getSwitchView().setOnCheckedChangeListener(null);
        this.dvh.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX());
        this.dvh.getSwitchView().setOnCheckedChangeListener(this.dvF);
    }

    public void aBf() {
        this.dvi.getSwitchView().setOnCheckedChangeListener(null);
        this.dvi.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xY());
        this.dvi.getSwitchView().setOnCheckedChangeListener(this.dvF);
    }

    public void aBg() {
        this.dvj.getSwitchView().setOnCheckedChangeListener(null);
        this.dvj.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya());
        this.dvj.getSwitchView().setOnCheckedChangeListener(this.dvF);
    }

    public void aBh() {
        this.dvk.getSwitchView().setOnCheckedChangeListener(null);
        this.dvk.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yh());
        this.dvk.getSwitchView().setOnCheckedChangeListener(this.dvF);
    }

    public void hd(boolean z) {
        if (this.dvE != z) {
            this.dvE = z;
            if (z) {
                this.Mv.setText(n.j.msg_remind);
                this.dvy.setVisibility(0);
                this.dvz.setVisibility(8);
                return;
            }
            this.Mv.setText(n.j.no_disturb_mode_time);
            this.dvz.setVisibility(0);
            this.dvy.setVisibility(8);
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
        this.dvF.getLayoutMode().ac(i == 1);
        this.dvF.getLayoutMode().k(this.bKF);
        this.mNavigationBar.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvd.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvf.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvg.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvh.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvi.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvj.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvk.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvl.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvm.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvn.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvo.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvp.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvq.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvt.onChangeSkinType(this.dvF.getPageContext(), i);
        this.dvv.onChangeSkinType(this.dvF.getPageContext(), i);
        if (this.dvu != null) {
            this.dvu.onChangeSkinType(this.dvF.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.as.i(this.dvw, n.f.more_all);
        com.baidu.tbadk.core.util.as.i(this.dvA, n.f.more_all);
        com.baidu.tbadk.core.util.as.i(this.dvC, n.f.more_all);
        com.baidu.tbadk.core.util.as.i(this.dvr, n.f.more_all);
        com.baidu.tbadk.core.util.as.c((ImageView) this.dvw.findViewById(n.g.no_disturb_mode_time_arrow), n.f.icon_arrow_right);
        com.baidu.tbadk.core.util.as.c((ImageView) this.dvr.findViewById(n.g.sign_remind_arrow), n.f.icon_arrow_right);
        com.baidu.tbadk.core.util.as.c((ImageView) this.dvA.findViewById(n.g.no_disturb_start_time_arrow), n.f.icon_arrow_right);
        com.baidu.tbadk.core.util.as.c((ImageView) this.dvC.findViewById(n.g.no_disturb_end_time_arrow), n.f.icon_arrow_right);
    }
}
