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
    private RelativeLayout aZK;
    private TextView cgA;
    private LinearLayout cgB;
    private LinearLayout cgC;
    private LinearLayout cgD;
    private TextView cgE;
    private LinearLayout cgF;
    private TextView cgG;
    public boolean cgH;
    private MsgRemindActivity cgI;
    private MsgSettingItemView cgg;
    private LinearLayout cgh;
    private MsgSettingItemView2 cgi;
    private MsgSettingItemView2 cgj;
    private MsgSettingItemView2 cgk;
    private MsgSettingItemView2 cgl;
    private MsgSettingItemView2 cgm;
    private MsgSettingItemView2 cgn;
    private MsgSettingItemView2 cgo;
    private MsgSettingItemView cgp;
    private MsgSettingItemView cgq;
    private MsgSettingItemView cgr;
    private MsgSettingItemView cgs;
    private MsgSettingItemView cgt;
    private MsgSettingItemView cgu;
    private LinearLayout cgv;
    private TextView cgw;
    private MsgSettingItemView cgx;
    private MsgSettingItemView cgy;
    private LinearLayout cgz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TextView mTitleText;

    public ar(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.aZK = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.cgH = true;
        this.cgI = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.r.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        aji();
        ajn();
        ajm();
        ajl();
        ajk();
        ajj();
        ajo();
        d(msgRemindActivity);
        ajd();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.aZK = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cgB = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.front_container);
        this.cgC = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.back_container);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.t.msg_remind));
        this.cgg = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.receive_message_swtich);
        this.cgg.setText(com.baidu.tieba.t.receive_msg_text);
        this.cgg.setLineVisibility(true);
        this.cgh = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.receive_message_container);
        this.cgi = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.reply_check_box);
        this.cgi.setText(com.baidu.tieba.t.frs_item_reply_text);
        this.cgj = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.zan_check_box);
        this.cgj.setText(com.baidu.tieba.t.frs_item_praise_text);
        this.cgk = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.at_me_check_box);
        this.cgk.setText(com.baidu.tieba.t.mention_atme);
        this.cgl = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.new_fans_swtich);
        this.cgl.setText(com.baidu.tieba.t.new_fans);
        this.cgo = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.stranger_msg_swtich);
        this.cgo.setText(com.baidu.tieba.t.stranger_chatmessage);
        this.cgm = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.chat_msg_swtich);
        this.cgm.setText(com.baidu.tieba.t.chat_msg_text);
        this.cgn = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.group_chat_swtich);
        this.cgn.setLineVisibility(false);
        this.cgn.setText(com.baidu.tieba.t.group_chat_text);
        this.cgp = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.screen_lock_swtich);
        this.cgp.setText(com.baidu.tieba.t.remind_screen_lock);
        this.cgq = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.chat_float_swtich);
        this.cgq.setLineVisibility(false);
        this.cgq.setText(com.baidu.tieba.t.chat_float_window);
        this.cgr = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.tone_remind_swtich);
        this.cgr.setText(com.baidu.tieba.t.remind_tone);
        this.cgs = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.vibrate_remind_swtich);
        this.cgs.setText(com.baidu.tieba.t.remind_vibrate);
        this.cgt = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.light_remind_swtich);
        this.cgt.setLineVisibility(true);
        this.cgt.setText(com.baidu.tieba.t.remind_light);
        this.cgu = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.sign_remind_swtich);
        this.cgu.setText(com.baidu.tieba.t.sign_remind_outline);
        this.cgv = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.sign_remind);
        this.cgw = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.sign_remind_time);
        this.cgx = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.promoted_content_swtich);
        this.cgx.setLineVisibility(false);
        this.cgx.setText(com.baidu.tieba.t.promoted_message_text);
        this.cgy = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_swtich);
        this.cgy.setText(com.baidu.tieba.t.no_disturb_mode);
        this.cgz = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_mode_time_container);
        this.cgA = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_mode_time_value);
        this.cgD = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_start_time);
        this.cgE = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_start_time_value);
        this.cgF = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_end_time);
        this.cgG = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_end_time_value);
    }

    private void ajd() {
        aje();
        ajf();
        ajg();
        ajh();
    }

    private void aje() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cgy.setVisibility(8);
            this.cgz.setVisibility(8);
            this.cgg.setVisibility(8);
            this.cgh.setVisibility(8);
            this.cgu.setVisibility(8);
            this.cgv.setVisibility(8);
            this.cgr.setVisibility(8);
            this.cgs.setVisibility(8);
            this.cgt.setVisibility(8);
            this.cgp.setVisibility(8);
            this.cgq.setVisibility(8);
        }
    }

    private void ajf() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cgq.setVisibility(0);
            this.cgp.setLineVisibility(true);
            return;
        }
        this.cgq.setVisibility(8);
        this.cgp.setLineVisibility(false);
    }

    private void ajg() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cgm.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cgn.setVisibility(0);
        } else {
            this.cgn.setVisibility(8);
        }
    }

    private void ajh() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cgp.setVisibility(0);
        } else {
            this.cgp.setVisibility(8);
        }
    }

    public View afO() {
        return this.mBack;
    }

    private void aji() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi()) {
            this.cgg.mr();
            this.cgh.setVisibility(0);
        } else {
            this.cgg.ms();
            this.cgh.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn()) {
            this.cgi.getSwitchView().setChecked(true);
        } else {
            this.cgi.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww()) {
            this.cgj.getSwitchView().setChecked(true);
        } else {
            this.cgj.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl()) {
            this.cgk.getSwitchView().setChecked(true);
        } else {
            this.cgk.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm()) {
            this.cgl.getSwitchView().setChecked(true);
        } else {
            this.cgl.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
            this.cgo.getSwitchView().setChecked(true);
        } else {
            this.cgo.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
            this.cgm.getSwitchView().setChecked(true);
        } else {
            this.cgm.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
            this.cgn.getSwitchView().setChecked(true);
        } else {
            this.cgn.getSwitchView().setChecked(false);
        }
    }

    private void ajj() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cgx.mr();
        } else {
            this.cgx.ms();
        }
    }

    private void ajk() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().isSignAlertOn()) {
            this.cgu.mt();
            this.cgv.setVisibility(0);
            this.cgu.setLineVisibility(true);
            ajp();
            return;
        }
        this.cgu.mu();
        this.cgu.setLineVisibility(false);
        this.cgv.setVisibility(8);
    }

    private void ajl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wp()) {
            this.cgr.mr();
        } else {
            this.cgr.ms();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().ws()) {
            this.cgs.mr();
        } else {
            this.cgs.ms();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wq()) {
            this.cgt.mr();
        } else {
            this.cgt.ms();
        }
    }

    private void ajm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx()) {
            this.cgq.mr();
        } else {
            this.cgq.ms();
        }
    }

    private void ajn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wy()) {
            this.cgp.mr();
        } else {
            this.cgp.ms();
        }
    }

    private void ajo() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wr()) {
            this.cgy.mr();
            this.cgz.setVisibility(0);
            ajq();
            return;
        }
        this.cgy.ms();
        this.cgz.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cgg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgi.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgk.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgj.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgl.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgo.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgm.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgn.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgv.setOnClickListener(msgRemindActivity);
        this.cgx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgz.setOnClickListener(msgRemindActivity);
        this.cgD.setOnClickListener(msgRemindActivity);
        this.cgF.setOnClickListener(msgRemindActivity);
    }

    public void eM(boolean z) {
        this.cgy.setLineVisibility(z);
        if (z) {
            this.cgz.setVisibility(0);
            ajq();
            com.baidu.tbadk.core.util.ay.i(this.cgz, com.baidu.tieba.p.more_all);
            return;
        }
        this.cgz.setVisibility(8);
    }

    public void eN(boolean z) {
        if (z) {
            this.cgv.setVisibility(0);
            this.cgu.setLineVisibility(true);
            com.baidu.tbadk.core.util.ay.i(this.cgv, com.baidu.tieba.p.more_all);
            return;
        }
        this.cgv.setVisibility(8);
        this.cgu.setLineVisibility(false);
    }

    public void eO(boolean z) {
        if (z) {
            this.cgh.setVisibility(0);
        } else {
            this.cgh.setVisibility(8);
        }
    }

    public void ajp() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertHours());
            } else {
                str = GameInfoData.NOT_FROM_DETAIL + com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertMins());
            } else {
                str2 = GameInfoData.NOT_FROM_DETAIL + com.baidu.tbadk.coreExtra.messageCenter.c.wg().getSignAlertMins();
            }
            this.cgw.setText(this.cgI.getPageContext().getPageActivity().getString(com.baidu.tieba.t.sign_remind_time, new Object[]{str, str2}));
            this.cgv.setVisibility(0);
            if (!this.cgu.hJ()) {
                this.cgu.mr();
                return;
            }
            return;
        }
        this.cgw.setText(com.baidu.tieba.t.close);
        this.cgv.setVisibility(8);
        if (this.cgu.hJ()) {
            this.cgu.ms();
        }
    }

    public void ajq() {
        this.cgA.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wt()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.wg().wu());
        this.cgE.setText(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wt());
        this.cgG.setText(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wu());
    }

    public BdSwitchView ajr() {
        return this.cgx.getSwitchView();
    }

    public BdSwitchView ajs() {
        return this.cgu.getSwitchView();
    }

    public BdSwitchView ajt() {
        return this.cgg.getSwitchView();
    }

    public View aju() {
        return this.cgv;
    }

    public BdSwitchView ajv() {
        return this.cgy.getSwitchView();
    }

    public View ajw() {
        return this.cgz;
    }

    public LinearLayout ajx() {
        return this.cgD;
    }

    public LinearLayout ajy() {
        return this.cgF;
    }

    public BdSwitchView ajz() {
        return this.cgr.getSwitchView();
    }

    public BdSwitchView ajA() {
        return this.cgs.getSwitchView();
    }

    public BdSwitchView ajB() {
        return this.cgt.getSwitchView();
    }

    public BdSwitchView ajC() {
        return this.cgp.getSwitchView();
    }

    public BdSwitchView ajD() {
        return this.cgq.getSwitchView();
    }

    public CheckBox ajE() {
        return this.cgi.getSwitchView();
    }

    public CheckBox ajF() {
        return this.cgj.getSwitchView();
    }

    public CheckBox ajG() {
        return this.cgk.getSwitchView();
    }

    public CheckBox ajH() {
        return this.cgm.getSwitchView();
    }

    public CheckBox ajI() {
        return this.cgn.getSwitchView();
    }

    public CheckBox ajJ() {
        return this.cgl.getSwitchView();
    }

    public CheckBox ajK() {
        return this.cgo.getSwitchView();
    }

    public void ajL() {
        this.cgi.getSwitchView().setOnCheckedChangeListener(null);
        this.cgi.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn());
        this.cgi.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void ajM() {
        this.cgj.getSwitchView().setOnCheckedChangeListener(null);
        this.cgj.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww());
        this.cgj.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void ajN() {
        this.cgk.getSwitchView().setOnCheckedChangeListener(null);
        this.cgk.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl());
        this.cgk.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void ajO() {
        this.cgl.getSwitchView().setOnCheckedChangeListener(null);
        this.cgl.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm());
        this.cgl.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void ajP() {
        this.cgm.getSwitchView().setOnCheckedChangeListener(null);
        this.cgm.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo());
        this.cgm.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void ajQ() {
        this.cgn.getSwitchView().setOnCheckedChangeListener(null);
        this.cgn.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv());
        this.cgn.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void ajR() {
        this.cgo.getSwitchView().setOnCheckedChangeListener(null);
        this.cgo.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk());
        this.cgo.getSwitchView().setOnCheckedChangeListener(this.cgI);
    }

    public void eP(boolean z) {
        if (this.cgH != z) {
            this.cgH = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.t.msg_remind);
                this.cgB.setVisibility(0);
                this.cgC.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.t.no_disturb_mode_time);
            this.cgC.setVisibility(0);
            this.cgB.setVisibility(8);
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
        this.cgI.getLayoutMode().ab(i == 1);
        this.cgI.getLayoutMode().j(this.aZK);
        this.mNavigationBar.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgg.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgi.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgj.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgk.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgo.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgl.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgm.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgn.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgp.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgq.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgr.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgs.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgt.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgu.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgx.onChangeSkinType(this.cgI.getPageContext(), i);
        this.cgy.onChangeSkinType(this.cgI.getPageContext(), i);
        com.baidu.tbadk.core.util.ay.i(this.cgz, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.i(this.cgD, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.i(this.cgF, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.i(this.cgv, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgz.findViewById(com.baidu.tieba.q.no_disturb_mode_time_arrow), com.baidu.tieba.p.icon_arrow_right);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgv.findViewById(com.baidu.tieba.q.sign_remind_arrow), com.baidu.tieba.p.icon_arrow_right);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgD.findViewById(com.baidu.tieba.q.no_disturb_start_time_arrow), com.baidu.tieba.p.icon_arrow_right);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgF.findViewById(com.baidu.tieba.q.no_disturb_end_time_arrow), com.baidu.tieba.p.icon_arrow_right);
    }
}
