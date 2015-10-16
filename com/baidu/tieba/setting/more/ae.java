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
    private TextView LN;
    private RelativeLayout bro;
    private MsgSettingItemView cNY;
    private LinearLayout cNZ;
    private MsgRemindActivity cOA;
    private MsgSettingItemView2 cOa;
    private MsgSettingItemView2 cOb;
    private MsgSettingItemView2 cOc;
    private MsgSettingItemView2 cOd;
    private MsgSettingItemView2 cOe;
    private MsgSettingItemView2 cOf;
    private MsgSettingItemView cOg;
    private MsgSettingItemView cOh;
    private MsgSettingItemView cOi;
    private MsgSettingItemView cOj;
    private MsgSettingItemView cOk;
    private MsgSettingItemView cOl;
    private LinearLayout cOm;
    private TextView cOn;
    private MsgSettingItemView cOo;
    private MsgSettingItemView cOp;
    private MsgSettingItemView cOq;
    private LinearLayout cOr;
    private TextView cOs;
    private LinearLayout cOt;
    private LinearLayout cOu;
    private LinearLayout cOv;
    private TextView cOw;
    private LinearLayout cOx;
    private TextView cOy;
    public boolean cOz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ae(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bro = null;
        this.mNavigationBar = null;
        this.LN = null;
        this.cOz = true;
        this.cOA = msgRemindActivity;
        msgRemindActivity.setContentView(i.g.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        aso();
        asu();
        ast();
        ass();
        asr();
        asp();
        asv();
        asq();
        d(msgRemindActivity);
        asj();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.bro = (RelativeLayout) msgRemindActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cOt = (LinearLayout) msgRemindActivity.findViewById(i.f.front_container);
        this.cOu = (LinearLayout) msgRemindActivity.findViewById(i.f.back_container);
        this.LN = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(i.h.msg_remind));
        this.cNY = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.receive_message_swtich);
        this.cNY.setText(i.h.receive_msg_text);
        this.cNY.setLineVisibility(true);
        this.cNZ = (LinearLayout) msgRemindActivity.findViewById(i.f.receive_message_container);
        this.cOa = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.reply_check_box);
        this.cOa.setText(i.h.frs_item_reply_text);
        this.cOb = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.zan_check_box);
        this.cOb.setText(i.h.frs_item_praise_text);
        this.cOc = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.at_me_check_box);
        this.cOc.setText(i.h.mention_atme);
        this.cOd = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.new_fans_swtich);
        this.cOd.setText(i.h.new_fans);
        this.cOe = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.chat_msg_swtich);
        this.cOe.setText(i.h.chat_msg_text);
        this.cOf = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.group_chat_swtich);
        this.cOf.setLineVisibility(false);
        this.cOf.setText(i.h.group_chat_text);
        this.cOg = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.screen_lock_swtich);
        this.cOg.setText(i.h.remind_screen_lock);
        this.cOh = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.chat_float_swtich);
        this.cOh.setLineVisibility(false);
        this.cOh.setText(i.h.chat_float_window);
        this.cOi = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.tone_remind_swtich);
        this.cOi.setText(i.h.remind_tone);
        this.cOj = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.vibrate_remind_swtich);
        this.cOj.setText(i.h.remind_vibrate);
        this.cOk = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.light_remind_swtich);
        this.cOk.setLineVisibility(true);
        this.cOk.setText(i.h.remind_light);
        this.cOl = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.sign_remind_swtich);
        this.cOl.setText(i.h.sign_remind_outline);
        this.cOm = (LinearLayout) msgRemindActivity.findViewById(i.f.sign_remind);
        this.cOn = (TextView) msgRemindActivity.findViewById(i.f.sign_remind_time);
        this.cOo = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.promoted_content_swtich);
        this.cOo.setLineVisibility(true);
        this.cOo.setText(i.h.promoted_message_text);
        this.cOq = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.no_disturb_swtich);
        this.cOq.setText(i.h.no_disturb_mode);
        this.cOr = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_container);
        this.cOs = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_value);
        this.cOv = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_start_time);
        this.cOw = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_start_time_value);
        this.cOx = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_end_time);
        this.cOy = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_end_time_value);
        this.cOp = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.remind_recommend_swtich);
        this.cOp.setLineVisibility(false);
        this.cOp.setText(i.h.remind_message_recommend);
    }

    private void asj() {
        ask();
        asl();
        asm();
        asn();
    }

    private void ask() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cOq.setVisibility(8);
            this.cOr.setVisibility(8);
            this.cNY.setVisibility(8);
            this.cNZ.setVisibility(8);
            this.cOl.setVisibility(8);
            this.cOm.setVisibility(8);
            this.cOi.setVisibility(8);
            this.cOj.setVisibility(8);
            this.cOk.setVisibility(8);
            this.cOg.setVisibility(8);
            this.cOh.setVisibility(8);
        }
    }

    private void asl() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cOh.setVisibility(0);
            this.cOg.setLineVisibility(true);
            return;
        }
        this.cOh.setVisibility(8);
        this.cOg.setLineVisibility(false);
    }

    private void asm() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cOe.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cOf.setVisibility(0);
        } else {
            this.cOf.setVisibility(8);
        }
    }

    private void asn() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cOg.setVisibility(0);
        } else {
            this.cOg.setVisibility(8);
        }
    }

    public View akd() {
        return this.mBack;
    }

    private void aso() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xj()) {
            this.cNY.mz();
            this.cNZ.setVisibility(0);
        } else {
            this.cNY.mA();
            this.cNZ.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo()) {
            this.cOa.getSwitchView().setChecked(true);
        } else {
            this.cOa.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx()) {
            this.cOb.getSwitchView().setChecked(true);
        } else {
            this.cOb.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm()) {
            this.cOc.getSwitchView().setChecked(true);
        } else {
            this.cOc.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn()) {
            this.cOd.getSwitchView().setChecked(true);
        } else {
            this.cOd.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp()) {
            this.cOe.getSwitchView().setChecked(true);
        } else {
            this.cOe.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw()) {
            this.cOf.getSwitchView().setChecked(true);
        } else {
            this.cOf.getSwitchView().setChecked(false);
        }
    }

    private void asp() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cOo.mz();
        } else {
            this.cOo.mA();
        }
    }

    private void asq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xB()) {
            this.cOp.mz();
        } else {
            this.cOp.mA();
        }
    }

    private void asr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().isSignAlertOn()) {
            this.cOl.mB();
            this.cOm.setVisibility(0);
            this.cOl.setLineVisibility(true);
            asw();
            return;
        }
        this.cOl.mC();
        this.cOl.setLineVisibility(false);
        this.cOm.setVisibility(8);
    }

    private void ass() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xq()) {
            this.cOi.mz();
        } else {
            this.cOi.mA();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xt()) {
            this.cOj.mz();
        } else {
            this.cOj.mA();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xr()) {
            this.cOk.mz();
        } else {
            this.cOk.mA();
        }
    }

    private void ast() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy()) {
            this.cOh.mz();
        } else {
            this.cOh.mA();
        }
    }

    private void asu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xz()) {
            this.cOg.mz();
        } else {
            this.cOg.mA();
        }
    }

    private void asv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xs()) {
            this.cOq.mz();
            this.cOr.setVisibility(0);
            asx();
            return;
        }
        this.cOq.mA();
        this.cOr.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cNY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOa.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cOc.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cOb.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cOd.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cOe.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cOf.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cOg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOm.setOnClickListener(msgRemindActivity);
        this.cOo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cOr.setOnClickListener(msgRemindActivity);
        this.cOv.setOnClickListener(msgRemindActivity);
        this.cOx.setOnClickListener(msgRemindActivity);
        this.cOp.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void fZ(boolean z) {
        this.cOq.setLineVisibility(z);
        if (z) {
            this.cOr.setVisibility(0);
            asx();
            com.baidu.tbadk.core.util.an.i(this.cOr, i.e.more_all);
            return;
        }
        this.cOr.setVisibility(8);
    }

    public void ga(boolean z) {
        if (z) {
            this.cOm.setVisibility(0);
            this.cOl.setLineVisibility(true);
            com.baidu.tbadk.core.util.an.i(this.cOm, i.e.more_all);
            return;
        }
        this.cOm.setVisibility(8);
        this.cOl.setLineVisibility(false);
    }

    public void gb(boolean z) {
        if (z) {
            this.cNZ.setVisibility(0);
        } else {
            this.cNZ.setVisibility(8);
        }
    }

    public void asw() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xh().getSignAlertMins();
            }
            this.cOn.setText(this.cOA.getPageContext().getPageActivity().getString(i.h.sign_remind_time, new Object[]{str, str2}));
            this.cOm.setVisibility(0);
            if (!this.cOl.hx()) {
                this.cOl.mz();
                return;
            }
            return;
        }
        this.cOn.setText(i.h.close);
        this.cOm.setVisibility(8);
        if (this.cOl.hx()) {
            this.cOl.mA();
        }
    }

    public void asx() {
        this.cOs.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xu()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.xh().xv());
        this.cOw.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xu());
        this.cOy.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xv());
    }

    public BdSwitchView asy() {
        return this.cOp.getSwitchView();
    }

    public BdSwitchView asz() {
        return this.cOo.getSwitchView();
    }

    public BdSwitchView asA() {
        return this.cOl.getSwitchView();
    }

    public BdSwitchView asB() {
        return this.cNY.getSwitchView();
    }

    public View asC() {
        return this.cOm;
    }

    public BdSwitchView asD() {
        return this.cOq.getSwitchView();
    }

    public View asE() {
        return this.cOr;
    }

    public LinearLayout asF() {
        return this.cOv;
    }

    public LinearLayout asG() {
        return this.cOx;
    }

    public BdSwitchView asH() {
        return this.cOi.getSwitchView();
    }

    public BdSwitchView asI() {
        return this.cOj.getSwitchView();
    }

    public BdSwitchView asJ() {
        return this.cOk.getSwitchView();
    }

    public BdSwitchView asK() {
        return this.cOg.getSwitchView();
    }

    public BdSwitchView asL() {
        return this.cOh.getSwitchView();
    }

    public CheckBox asM() {
        return this.cOa.getSwitchView();
    }

    public CheckBox asN() {
        return this.cOb.getSwitchView();
    }

    public CheckBox asO() {
        return this.cOc.getSwitchView();
    }

    public CheckBox asP() {
        return this.cOe.getSwitchView();
    }

    public CheckBox asQ() {
        return this.cOf.getSwitchView();
    }

    public CheckBox asR() {
        return this.cOd.getSwitchView();
    }

    public void asS() {
        this.cOa.getSwitchView().setOnCheckedChangeListener(null);
        this.cOa.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo());
        this.cOa.getSwitchView().setOnCheckedChangeListener(this.cOA);
    }

    public void asT() {
        this.cOb.getSwitchView().setOnCheckedChangeListener(null);
        this.cOb.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xx());
        this.cOb.getSwitchView().setOnCheckedChangeListener(this.cOA);
    }

    public void asU() {
        this.cOc.getSwitchView().setOnCheckedChangeListener(null);
        this.cOc.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm());
        this.cOc.getSwitchView().setOnCheckedChangeListener(this.cOA);
    }

    public void asV() {
        this.cOd.getSwitchView().setOnCheckedChangeListener(null);
        this.cOd.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn());
        this.cOd.getSwitchView().setOnCheckedChangeListener(this.cOA);
    }

    public void asW() {
        this.cOe.getSwitchView().setOnCheckedChangeListener(null);
        this.cOe.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp());
        this.cOe.getSwitchView().setOnCheckedChangeListener(this.cOA);
    }

    public void asX() {
        this.cOf.getSwitchView().setOnCheckedChangeListener(null);
        this.cOf.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw());
        this.cOf.getSwitchView().setOnCheckedChangeListener(this.cOA);
    }

    public void gc(boolean z) {
        if (this.cOz != z) {
            this.cOz = z;
            if (z) {
                this.LN.setText(i.h.msg_remind);
                this.cOt.setVisibility(0);
                this.cOu.setVisibility(8);
                return;
            }
            this.LN.setText(i.h.no_disturb_mode_time);
            this.cOu.setVisibility(0);
            this.cOt.setVisibility(8);
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
        this.cOA.getLayoutMode().ad(i == 1);
        this.cOA.getLayoutMode().k(this.bro);
        this.mNavigationBar.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cNY.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOa.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOb.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOc.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOd.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOe.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOf.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOg.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOh.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOi.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOj.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOk.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOl.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOo.onChangeSkinType(this.cOA.getPageContext(), i);
        this.cOq.onChangeSkinType(this.cOA.getPageContext(), i);
        if (this.cOp != null) {
            this.cOp.onChangeSkinType(this.cOA.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.an.i(this.cOr, i.e.more_all);
        com.baidu.tbadk.core.util.an.i(this.cOv, i.e.more_all);
        com.baidu.tbadk.core.util.an.i(this.cOx, i.e.more_all);
        com.baidu.tbadk.core.util.an.i(this.cOm, i.e.more_all);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cOr.findViewById(i.f.no_disturb_mode_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cOm.findViewById(i.f.sign_remind_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cOv.findViewById(i.f.no_disturb_start_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.an.c((ImageView) this.cOx.findViewById(i.f.no_disturb_end_time_arrow), i.e.icon_arrow_right);
    }
}
