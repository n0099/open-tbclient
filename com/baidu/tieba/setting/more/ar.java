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
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.base.g<MsgRemindActivity> {
    private RelativeLayout aWN;
    private MsgSettingItemView cbA;
    private MsgSettingItemView cbB;
    private MsgSettingItemView cbC;
    private LinearLayout cbD;
    private TextView cbE;
    private MsgSettingItemView cbF;
    private MsgSettingItemView cbG;
    private LinearLayout cbH;
    private TextView cbI;
    private LinearLayout cbJ;
    private LinearLayout cbK;
    private LinearLayout cbL;
    private TextView cbM;
    private LinearLayout cbN;
    private TextView cbO;
    public boolean cbP;
    private MsgRemindActivity cbQ;
    private MsgSettingItemView cbo;
    private LinearLayout cbp;
    private MsgSettingItemView2 cbq;
    private MsgSettingItemView2 cbr;
    private MsgSettingItemView2 cbs;
    private MsgSettingItemView2 cbt;
    private MsgSettingItemView2 cbu;
    private MsgSettingItemView2 cbv;
    private MsgSettingItemView2 cbw;
    private MsgSettingItemView cbx;
    private MsgSettingItemView cby;
    private MsgSettingItemView cbz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TextView mTitleText;

    public ar(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.aWN = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.cbP = true;
        this.cbQ = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.w.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        ahb();
        ahg();
        ahf();
        ahe();
        ahd();
        ahc();
        ahh();
        d(msgRemindActivity);
        agW();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.aWN = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cbJ = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.front_container);
        this.cbK = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.back_container);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.y.msg_remind));
        this.cbo = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.receive_message_swtich);
        this.cbo.setText(com.baidu.tieba.y.receive_msg_text);
        this.cbo.setLineVisibility(true);
        this.cbp = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.receive_message_container);
        this.cbq = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.reply_check_box);
        this.cbq.setText(com.baidu.tieba.y.frs_item_reply_text);
        this.cbr = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.zan_check_box);
        this.cbr.setText(com.baidu.tieba.y.frs_item_praise_text);
        this.cbs = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.at_me_check_box);
        this.cbs.setText(com.baidu.tieba.y.mention_atme);
        this.cbt = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.new_fans_swtich);
        this.cbt.setText(com.baidu.tieba.y.new_fans);
        this.cbw = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.stranger_msg_swtich);
        this.cbw.setText(com.baidu.tieba.y.stranger_chatmessage);
        this.cbu = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.chat_msg_swtich);
        this.cbu.setText(com.baidu.tieba.y.chat_msg_text);
        this.cbv = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.v.group_chat_swtich);
        this.cbv.setLineVisibility(false);
        this.cbv.setText(com.baidu.tieba.y.group_chat_text);
        this.cbx = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.screen_lock_swtich);
        this.cbx.setText(com.baidu.tieba.y.remind_screen_lock);
        this.cby = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.chat_float_swtich);
        this.cby.setLineVisibility(false);
        this.cby.setText(com.baidu.tieba.y.chat_float_window);
        this.cbz = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.tone_remind_swtich);
        this.cbz.setText(com.baidu.tieba.y.remind_tone);
        this.cbA = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.vibrate_remind_swtich);
        this.cbA.setText(com.baidu.tieba.y.remind_vibrate);
        this.cbB = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.light_remind_swtich);
        this.cbB.setLineVisibility(true);
        this.cbB.setText(com.baidu.tieba.y.remind_light);
        this.cbC = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_swtich);
        this.cbC.setText(com.baidu.tieba.y.sign_remind_outline);
        this.cbD = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind);
        this.cbE = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.sign_remind_time);
        this.cbF = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.promoted_content_swtich);
        this.cbF.setLineVisibility(false);
        this.cbF.setText(com.baidu.tieba.y.promoted_message_text);
        this.cbG = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_swtich);
        this.cbG.setText(com.baidu.tieba.y.no_disturb_mode);
        this.cbH = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_container);
        this.cbI = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_mode_time_value);
        this.cbL = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time);
        this.cbM = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_start_time_value);
        this.cbN = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time);
        this.cbO = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.v.no_disturb_end_time_value);
    }

    private void agW() {
        agX();
        agY();
        agZ();
        aha();
    }

    private void agX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cbG.setVisibility(8);
            this.cbH.setVisibility(8);
            this.cbo.setVisibility(8);
            this.cbp.setVisibility(8);
            this.cbC.setVisibility(8);
            this.cbD.setVisibility(8);
            this.cbz.setVisibility(8);
            this.cbA.setVisibility(8);
            this.cbB.setVisibility(8);
            this.cbx.setVisibility(8);
            this.cby.setVisibility(8);
        }
    }

    private void agY() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cby.setVisibility(0);
            this.cbx.setLineVisibility(true);
            return;
        }
        this.cby.setVisibility(8);
        this.cbx.setLineVisibility(false);
    }

    private void agZ() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cbu.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cbv.setVisibility(0);
        } else {
            this.cbv.setVisibility(8);
        }
    }

    private void aha() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cbx.setVisibility(0);
        } else {
            this.cbx.setVisibility(8);
        }
    }

    public View aes() {
        return this.mBack;
    }

    private void ahb() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vs()) {
            this.cbo.lY();
            this.cbp.setVisibility(0);
        } else {
            this.cbo.lZ();
            this.cbp.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx()) {
            this.cbq.getSwitchView().setChecked(true);
        } else {
            this.cbq.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vG()) {
            this.cbr.getSwitchView().setChecked(true);
        } else {
            this.cbr.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv()) {
            this.cbs.getSwitchView().setChecked(true);
        } else {
            this.cbs.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vw()) {
            this.cbt.getSwitchView().setChecked(true);
        } else {
            this.cbt.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
            this.cbw.getSwitchView().setChecked(true);
        } else {
            this.cbw.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
            this.cbu.getSwitchView().setChecked(true);
        } else {
            this.cbu.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF()) {
            this.cbv.getSwitchView().setChecked(true);
        } else {
            this.cbv.getSwitchView().setChecked(false);
        }
    }

    private void ahc() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cbF.lY();
        } else {
            this.cbF.lZ();
        }
    }

    private void ahd() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().isSignAlertOn()) {
            this.cbC.ma();
            this.cbD.setVisibility(0);
            this.cbC.setLineVisibility(true);
            ahi();
            return;
        }
        this.cbC.mb();
        this.cbC.setLineVisibility(false);
        this.cbD.setVisibility(8);
    }

    private void ahe() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vz()) {
            this.cbz.lY();
        } else {
            this.cbz.lZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vC()) {
            this.cbA.lY();
        } else {
            this.cbA.lZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vA()) {
            this.cbB.lY();
        } else {
            this.cbB.lZ();
        }
    }

    private void ahf() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vH()) {
            this.cby.lY();
        } else {
            this.cby.lZ();
        }
    }

    private void ahg() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vI()) {
            this.cbx.lY();
        } else {
            this.cbx.lZ();
        }
    }

    private void ahh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vB()) {
            this.cbG.lY();
            this.cbH.setVisibility(0);
            this.cbG.setLineVisibility(true);
            ahj();
            return;
        }
        this.cbG.lZ();
        this.cbG.setLineVisibility(false);
        this.cbH.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cbo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbq.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbs.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbr.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbt.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbw.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbu.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbv.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cbx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cby.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbD.setOnClickListener(msgRemindActivity);
        this.cbF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cbH.setOnClickListener(msgRemindActivity);
        this.cbL.setOnClickListener(msgRemindActivity);
        this.cbN.setOnClickListener(msgRemindActivity);
    }

    public void eu(boolean z) {
        this.cbG.setLineVisibility(z);
        if (z) {
            this.cbH.setVisibility(0);
            ahj();
            com.baidu.tbadk.core.util.ba.i(this.cbH, com.baidu.tieba.u.more_all);
            return;
        }
        this.cbH.setVisibility(8);
    }

    public void ev(boolean z) {
        if (z) {
            this.cbD.setVisibility(0);
            this.cbC.setLineVisibility(true);
            com.baidu.tbadk.core.util.ba.i(this.cbD, com.baidu.tieba.u.more_all);
            return;
        }
        this.cbD.setVisibility(8);
        this.cbC.setLineVisibility(false);
    }

    public void ew(boolean z) {
        if (z) {
            this.cbp.setVisibility(0);
        } else {
            this.cbp.setVisibility(8);
        }
    }

    public void ahi() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertHours());
            } else {
                str = GameInfoData.NOT_FROM_DETAIL + com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertMins());
            } else {
                str2 = GameInfoData.NOT_FROM_DETAIL + com.baidu.tbadk.coreExtra.messageCenter.c.vq().getSignAlertMins();
            }
            this.cbE.setText(this.cbQ.getPageContext().getPageActivity().getString(com.baidu.tieba.y.sign_remind_time, new Object[]{str, str2}));
            this.cbD.setVisibility(0);
            if (!this.cbC.hZ()) {
                this.cbC.lY();
                return;
            }
            return;
        }
        this.cbE.setText(com.baidu.tieba.y.close);
        this.cbD.setVisibility(8);
        if (this.cbC.hZ()) {
            this.cbC.lZ();
        }
    }

    public void ahj() {
        this.cbI.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vD()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.vq().vE());
        this.cbM.setText(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vD());
        this.cbO.setText(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vE());
    }

    public BdSwitchView ahk() {
        return this.cbF.getSwitchView();
    }

    public BdSwitchView ahl() {
        return this.cbC.getSwitchView();
    }

    public BdSwitchView ahm() {
        return this.cbo.getSwitchView();
    }

    public View ahn() {
        return this.cbD;
    }

    public BdSwitchView aho() {
        return this.cbG.getSwitchView();
    }

    public View ahp() {
        return this.cbH;
    }

    public LinearLayout ahq() {
        return this.cbL;
    }

    public LinearLayout ahr() {
        return this.cbN;
    }

    public BdSwitchView ahs() {
        return this.cbz.getSwitchView();
    }

    public BdSwitchView aht() {
        return this.cbA.getSwitchView();
    }

    public BdSwitchView ahu() {
        return this.cbB.getSwitchView();
    }

    public BdSwitchView ahv() {
        return this.cbx.getSwitchView();
    }

    public BdSwitchView ahw() {
        return this.cby.getSwitchView();
    }

    public CheckBox ahx() {
        return this.cbq.getSwitchView();
    }

    public CheckBox ahy() {
        return this.cbr.getSwitchView();
    }

    public CheckBox ahz() {
        return this.cbs.getSwitchView();
    }

    public CheckBox ahA() {
        return this.cbu.getSwitchView();
    }

    public CheckBox ahB() {
        return this.cbv.getSwitchView();
    }

    public CheckBox ahC() {
        return this.cbt.getSwitchView();
    }

    public CheckBox ahD() {
        return this.cbw.getSwitchView();
    }

    public void ahE() {
        this.cbq.getSwitchView().setOnCheckedChangeListener(null);
        this.cbq.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx());
        this.cbq.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ahF() {
        this.cbr.getSwitchView().setOnCheckedChangeListener(null);
        this.cbr.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vG());
        this.cbr.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ahG() {
        this.cbs.getSwitchView().setOnCheckedChangeListener(null);
        this.cbs.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv());
        this.cbs.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ahH() {
        this.cbt.getSwitchView().setOnCheckedChangeListener(null);
        this.cbt.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vw());
        this.cbt.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ahI() {
        this.cbu.getSwitchView().setOnCheckedChangeListener(null);
        this.cbu.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy());
        this.cbu.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ahJ() {
        this.cbv.getSwitchView().setOnCheckedChangeListener(null);
        this.cbv.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF());
        this.cbv.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ahK() {
        this.cbw.getSwitchView().setOnCheckedChangeListener(null);
        this.cbw.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu());
        this.cbw.getSwitchView().setOnCheckedChangeListener(this.cbQ);
    }

    public void ex(boolean z) {
        if (this.cbP != z) {
            this.cbP = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.y.msg_remind);
                this.cbJ.setVisibility(0);
                this.cbK.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.y.no_disturb_mode_time);
            this.cbK.setVisibility(0);
            this.cbJ.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v35, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cbQ.getLayoutMode().X(i == 1);
        this.cbQ.getLayoutMode().h(this.aWN);
        this.mNavigationBar.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbo.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbq.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbr.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbs.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbw.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbt.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbu.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbv.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbx.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cby.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbz.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbA.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbB.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbC.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbF.onChangeSkinType(this.cbQ.getPageContext(), i);
        this.cbG.onChangeSkinType(this.cbQ.getPageContext(), i);
        com.baidu.tbadk.core.util.ba.i(this.cbH, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.i(this.cbL, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.i(this.cbN, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.i(this.cbD, com.baidu.tieba.u.more_all);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cbH.findViewById(com.baidu.tieba.v.no_disturb_mode_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cbD.findViewById(com.baidu.tieba.v.sign_remind_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cbL.findViewById(com.baidu.tieba.v.no_disturb_start_time_arrow), com.baidu.tieba.u.icon_arrow_right);
        com.baidu.tbadk.core.util.ba.c((ImageView) this.cbN.findViewById(com.baidu.tieba.v.no_disturb_end_time_arrow), com.baidu.tieba.u.icon_arrow_right);
    }
}
