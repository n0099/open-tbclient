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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView ML;
    private View ajk;
    private RelativeLayout bOs;
    private LinearLayout dLA;
    private TextView dLB;
    private LinearLayout dLC;
    private LinearLayout dLD;
    private LinearLayout dLE;
    private TextView dLF;
    private LinearLayout dLG;
    private TextView dLH;
    public boolean dLI;
    private MsgRemindActivity dLJ;
    private MsgSettingItemView dLh;
    private LinearLayout dLi;
    private MsgSettingItemView2 dLj;
    private MsgSettingItemView2 dLk;
    private MsgSettingItemView2 dLl;
    private MsgSettingItemView2 dLm;
    private MsgSettingItemView2 dLn;
    private MsgSettingItemView2 dLo;
    private MsgSettingItemView dLp;
    private MsgSettingItemView dLq;
    private MsgSettingItemView dLr;
    private MsgSettingItemView dLs;
    private MsgSettingItemView dLt;
    private MsgSettingItemView dLu;
    private LinearLayout dLv;
    private TextView dLw;
    private MsgSettingItemView dLx;
    private MsgSettingItemView dLy;
    private MsgSettingItemView dLz;
    private NavigationBar mNavigationBar;

    public ah(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bOs = null;
        this.mNavigationBar = null;
        this.ML = null;
        this.dLI = true;
        this.dLJ = msgRemindActivity;
        msgRemindActivity.setContentView(t.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        aHF();
        aHL();
        aHK();
        aHJ();
        aHI();
        aHG();
        aHM();
        aHH();
        d(msgRemindActivity);
        aHA();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.bOs = (RelativeLayout) msgRemindActivity.findViewById(t.g.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(t.g.view_navigation_bar);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dLC = (LinearLayout) msgRemindActivity.findViewById(t.g.front_container);
        this.dLD = (LinearLayout) msgRemindActivity.findViewById(t.g.back_container);
        this.ML = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(t.j.msg_remind));
        this.dLh = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.receive_message_swtich);
        this.dLh.setText(t.j.receive_msg_text);
        this.dLh.setLineVisibility(true);
        this.dLi = (LinearLayout) msgRemindActivity.findViewById(t.g.receive_message_container);
        this.dLj = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.reply_check_box);
        this.dLj.setText(t.j.frs_item_reply_text);
        this.dLk = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.zan_check_box);
        this.dLk.setText(t.j.frs_item_praise_text);
        this.dLl = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.at_me_check_box);
        this.dLl.setText(t.j.mention_atme);
        this.dLm = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.new_fans_swtich);
        this.dLm.setText(t.j.new_fans);
        this.dLn = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.chat_msg_swtich);
        this.dLn.setText(t.j.chat_msg_text);
        this.dLo = (MsgSettingItemView2) msgRemindActivity.findViewById(t.g.group_chat_swtich);
        this.dLo.setLineVisibility(false);
        this.dLo.setText(t.j.group_chat_text);
        this.dLp = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.screen_lock_swtich);
        this.dLp.setText(t.j.remind_screen_lock);
        this.dLq = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.chat_float_swtich);
        this.dLq.setLineVisibility(false);
        this.dLq.setText(t.j.chat_float_window);
        this.dLr = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.tone_remind_swtich);
        this.dLr.setText(t.j.remind_tone);
        this.dLs = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.vibrate_remind_swtich);
        this.dLs.setText(t.j.remind_vibrate);
        this.dLt = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.light_remind_swtich);
        this.dLt.setLineVisibility(true);
        this.dLt.setText(t.j.remind_light);
        this.dLu = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.sign_remind_swtich);
        this.dLu.setText(t.j.sign_remind_outline);
        this.dLv = (LinearLayout) msgRemindActivity.findViewById(t.g.sign_remind);
        this.dLw = (TextView) msgRemindActivity.findViewById(t.g.sign_remind_time);
        this.dLx = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.promoted_content_swtich);
        this.dLx.setLineVisibility(true);
        this.dLx.setText(t.j.promoted_message_text);
        this.dLz = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.no_disturb_swtich);
        this.dLz.setText(t.j.no_disturb_mode);
        this.dLA = (LinearLayout) msgRemindActivity.findViewById(t.g.no_disturb_mode_time_container);
        this.dLB = (TextView) msgRemindActivity.findViewById(t.g.no_disturb_mode_time_value);
        this.dLE = (LinearLayout) msgRemindActivity.findViewById(t.g.no_disturb_start_time);
        this.dLF = (TextView) msgRemindActivity.findViewById(t.g.no_disturb_start_time_value);
        this.dLG = (LinearLayout) msgRemindActivity.findViewById(t.g.no_disturb_end_time);
        this.dLH = (TextView) msgRemindActivity.findViewById(t.g.no_disturb_end_time_value);
        this.dLy = (MsgSettingItemView) msgRemindActivity.findViewById(t.g.remind_recommend_swtich);
        this.dLy.setLineVisibility(false);
        this.dLy.setText(t.j.remind_message_recommend);
    }

    private void aHA() {
        aHB();
        aHC();
        aHD();
        aHE();
    }

    private void aHB() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.dLz.setVisibility(8);
            this.dLA.setVisibility(8);
            this.dLh.setVisibility(8);
            this.dLi.setVisibility(8);
            this.dLu.setVisibility(8);
            this.dLv.setVisibility(8);
            this.dLr.setVisibility(8);
            this.dLs.setVisibility(8);
            this.dLt.setVisibility(8);
            this.dLp.setVisibility(8);
            this.dLq.setVisibility(8);
        }
    }

    private void aHC() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.dLq.setVisibility(0);
            this.dLp.setLineVisibility(true);
            return;
        }
        this.dLq.setVisibility(8);
        this.dLp.setLineVisibility(false);
    }

    private void aHD() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.dLn.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.dLo.setVisibility(0);
        } else {
            this.dLo.setVisibility(8);
        }
    }

    private void aHE() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.dLp.setVisibility(0);
        } else {
            this.dLp.setVisibility(8);
        }
    }

    public View awm() {
        return this.ajk;
    }

    private void aHF() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zm()) {
            this.dLh.mq();
            this.dLi.setVisibility(0);
        } else {
            this.dLh.mr();
            this.dLi.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zr()) {
            this.dLj.getSwitchView().setChecked(true);
        } else {
            this.dLj.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zA()) {
            this.dLk.getSwitchView().setChecked(true);
        } else {
            this.dLk.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zp()) {
            this.dLl.getSwitchView().setChecked(true);
        } else {
            this.dLl.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zq()) {
            this.dLm.getSwitchView().setChecked(true);
        } else {
            this.dLm.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs()) {
            this.dLn.getSwitchView().setChecked(true);
        } else {
            this.dLn.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zz()) {
            this.dLo.getSwitchView().setChecked(true);
        } else {
            this.dLo.getSwitchView().setChecked(false);
        }
    }

    private void aHG() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.dLx.mq();
        } else {
            this.dLx.mr();
        }
    }

    private void aHH() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zE()) {
            this.dLy.mq();
        } else {
            this.dLy.mr();
        }
    }

    private void aHI() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().isSignAlertOn()) {
            this.dLu.ms();
            this.dLv.setVisibility(0);
            this.dLu.setLineVisibility(true);
            aHN();
            return;
        }
        this.dLu.mt();
        this.dLu.setLineVisibility(false);
        this.dLv.setVisibility(8);
    }

    private void aHJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zt()) {
            this.dLr.mq();
        } else {
            this.dLr.mr();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zw()) {
            this.dLs.mq();
        } else {
            this.dLs.mr();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zu()) {
            this.dLt.mq();
        } else {
            this.dLt.mr();
        }
    }

    private void aHK() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zB()) {
            this.dLq.mq();
        } else {
            this.dLq.mr();
        }
    }

    private void aHL() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zC()) {
            this.dLp.mq();
        } else {
            this.dLp.mr();
        }
    }

    private void aHM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zv()) {
            this.dLz.mq();
            this.dLA.setVisibility(0);
            aHO();
            return;
        }
        this.dLz.mr();
        this.dLA.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.ajk.setOnClickListener(msgRemindActivity);
        this.dLh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLj.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dLl.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dLk.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dLm.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dLn.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dLo.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dLp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLv.setOnClickListener(msgRemindActivity);
        this.dLx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dLA.setOnClickListener(msgRemindActivity);
        this.dLE.setOnClickListener(msgRemindActivity);
        this.dLG.setOnClickListener(msgRemindActivity);
        this.dLy.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void hA(boolean z) {
        this.dLz.setLineVisibility(z);
        if (z) {
            this.dLA.setVisibility(0);
            aHO();
            com.baidu.tbadk.core.util.ar.k(this.dLA, t.f.more_all);
            return;
        }
        this.dLA.setVisibility(8);
    }

    public void hB(boolean z) {
        if (z) {
            this.dLv.setVisibility(0);
            this.dLu.setLineVisibility(true);
            com.baidu.tbadk.core.util.ar.k(this.dLv, t.f.more_all);
            return;
        }
        this.dLv.setVisibility(8);
        this.dLu.setLineVisibility(false);
    }

    public void hC(boolean z) {
        if (z) {
            this.dLi.setVisibility(0);
        } else {
            this.dLi.setVisibility(8);
        }
    }

    public void aHN() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.zk().getSignAlertMins();
            }
            this.dLw.setText(this.dLJ.getPageContext().getPageActivity().getString(t.j.sign_remind_time, new Object[]{str, str2}));
            this.dLv.setVisibility(0);
            if (!this.dLu.hI()) {
                this.dLu.mq();
                return;
            }
            return;
        }
        this.dLw.setText(t.j.close);
        this.dLv.setVisibility(8);
        if (this.dLu.hI()) {
            this.dLu.mr();
        }
    }

    public void aHO() {
        this.dLB.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zx()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.zk().zy());
        this.dLF.setText(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zx());
        this.dLH.setText(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zy());
    }

    public BdSwitchView aHP() {
        return this.dLy.getSwitchView();
    }

    public BdSwitchView aHQ() {
        return this.dLx.getSwitchView();
    }

    public BdSwitchView aHR() {
        return this.dLu.getSwitchView();
    }

    public BdSwitchView aHS() {
        return this.dLh.getSwitchView();
    }

    public View aHT() {
        return this.dLv;
    }

    public BdSwitchView aHU() {
        return this.dLz.getSwitchView();
    }

    public View aHV() {
        return this.dLA;
    }

    public LinearLayout aHW() {
        return this.dLE;
    }

    public LinearLayout aHX() {
        return this.dLG;
    }

    public BdSwitchView aHY() {
        return this.dLr.getSwitchView();
    }

    public BdSwitchView aHZ() {
        return this.dLs.getSwitchView();
    }

    public BdSwitchView aIa() {
        return this.dLt.getSwitchView();
    }

    public BdSwitchView aIb() {
        return this.dLp.getSwitchView();
    }

    public BdSwitchView aIc() {
        return this.dLq.getSwitchView();
    }

    public CheckBox aId() {
        return this.dLj.getSwitchView();
    }

    public CheckBox aIe() {
        return this.dLk.getSwitchView();
    }

    public CheckBox aIf() {
        return this.dLl.getSwitchView();
    }

    public CheckBox aIg() {
        return this.dLn.getSwitchView();
    }

    public CheckBox aIh() {
        return this.dLo.getSwitchView();
    }

    public CheckBox aIi() {
        return this.dLm.getSwitchView();
    }

    public void aIj() {
        this.dLj.getSwitchView().setOnCheckedChangeListener(null);
        this.dLj.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zr());
        this.dLj.getSwitchView().setOnCheckedChangeListener(this.dLJ);
    }

    public void aIk() {
        this.dLk.getSwitchView().setOnCheckedChangeListener(null);
        this.dLk.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zA());
        this.dLk.getSwitchView().setOnCheckedChangeListener(this.dLJ);
    }

    public void aIl() {
        this.dLl.getSwitchView().setOnCheckedChangeListener(null);
        this.dLl.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zp());
        this.dLl.getSwitchView().setOnCheckedChangeListener(this.dLJ);
    }

    public void aIm() {
        this.dLm.getSwitchView().setOnCheckedChangeListener(null);
        this.dLm.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zq());
        this.dLm.getSwitchView().setOnCheckedChangeListener(this.dLJ);
    }

    public void aIn() {
        this.dLn.getSwitchView().setOnCheckedChangeListener(null);
        this.dLn.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs());
        this.dLn.getSwitchView().setOnCheckedChangeListener(this.dLJ);
    }

    public void aIo() {
        this.dLo.getSwitchView().setOnCheckedChangeListener(null);
        this.dLo.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.zk().zz());
        this.dLo.getSwitchView().setOnCheckedChangeListener(this.dLJ);
    }

    public void hD(boolean z) {
        if (this.dLI != z) {
            this.dLI = z;
            if (z) {
                this.ML.setText(t.j.msg_remind);
                this.dLC.setVisibility(0);
                this.dLD.setVisibility(8);
                return;
            }
            this.ML.setText(t.j.no_disturb_mode_time);
            this.dLD.setVisibility(0);
            this.dLC.setVisibility(8);
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
        this.dLJ.getLayoutMode().ac(i == 1);
        this.dLJ.getLayoutMode().x(this.bOs);
        this.mNavigationBar.onChangeSkinType(this.dLJ.getPageContext(), i);
        this.dLh.d(this.dLJ.getPageContext(), i);
        this.dLj.d(this.dLJ.getPageContext(), i);
        this.dLk.d(this.dLJ.getPageContext(), i);
        this.dLl.d(this.dLJ.getPageContext(), i);
        this.dLm.d(this.dLJ.getPageContext(), i);
        this.dLn.d(this.dLJ.getPageContext(), i);
        this.dLo.d(this.dLJ.getPageContext(), i);
        this.dLp.d(this.dLJ.getPageContext(), i);
        this.dLq.d(this.dLJ.getPageContext(), i);
        this.dLr.d(this.dLJ.getPageContext(), i);
        this.dLs.d(this.dLJ.getPageContext(), i);
        this.dLt.d(this.dLJ.getPageContext(), i);
        this.dLu.d(this.dLJ.getPageContext(), i);
        this.dLx.d(this.dLJ.getPageContext(), i);
        this.dLz.d(this.dLJ.getPageContext(), i);
        if (this.dLy != null) {
            this.dLy.d(this.dLJ.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.ar.k(this.dLA, t.f.more_all);
        com.baidu.tbadk.core.util.ar.k(this.dLE, t.f.more_all);
        com.baidu.tbadk.core.util.ar.k(this.dLG, t.f.more_all);
        com.baidu.tbadk.core.util.ar.k(this.dLv, t.f.more_all);
        com.baidu.tbadk.core.util.ar.c((ImageView) this.dLA.findViewById(t.g.no_disturb_mode_time_arrow), t.f.icon_arrow_right);
        com.baidu.tbadk.core.util.ar.c((ImageView) this.dLv.findViewById(t.g.sign_remind_arrow), t.f.icon_arrow_right);
        com.baidu.tbadk.core.util.ar.c((ImageView) this.dLE.findViewById(t.g.no_disturb_start_time_arrow), t.f.icon_arrow_right);
        com.baidu.tbadk.core.util.ar.c((ImageView) this.dLG.findViewById(t.g.no_disturb_end_time_arrow), t.f.icon_arrow_right);
    }
}
