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
    private RelativeLayout aZJ;
    private LinearLayout cgA;
    private LinearLayout cgB;
    private LinearLayout cgC;
    private TextView cgD;
    private LinearLayout cgE;
    private TextView cgF;
    public boolean cgG;
    private MsgRemindActivity cgH;
    private MsgSettingItemView cgf;
    private LinearLayout cgg;
    private MsgSettingItemView2 cgh;
    private MsgSettingItemView2 cgi;
    private MsgSettingItemView2 cgj;
    private MsgSettingItemView2 cgk;
    private MsgSettingItemView2 cgl;
    private MsgSettingItemView2 cgm;
    private MsgSettingItemView2 cgn;
    private MsgSettingItemView cgo;
    private MsgSettingItemView cgp;
    private MsgSettingItemView cgq;
    private MsgSettingItemView cgr;
    private MsgSettingItemView cgs;
    private MsgSettingItemView cgt;
    private LinearLayout cgu;
    private TextView cgv;
    private MsgSettingItemView cgw;
    private MsgSettingItemView cgx;
    private LinearLayout cgy;
    private TextView cgz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private TextView mTitleText;

    public ar(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.aZJ = null;
        this.mNavigationBar = null;
        this.mTitleText = null;
        this.cgG = true;
        this.cgH = msgRemindActivity;
        msgRemindActivity.setContentView(com.baidu.tieba.r.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        ajh();
        ajm();
        ajl();
        ajk();
        ajj();
        aji();
        ajn();
        d(msgRemindActivity);
        ajc();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.aZJ = (RelativeLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cgA = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.front_container);
        this.cgB = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.back_container);
        this.mTitleText = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(com.baidu.tieba.t.msg_remind));
        this.cgf = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.receive_message_swtich);
        this.cgf.setText(com.baidu.tieba.t.receive_msg_text);
        this.cgf.setLineVisibility(true);
        this.cgg = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.receive_message_container);
        this.cgh = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.reply_check_box);
        this.cgh.setText(com.baidu.tieba.t.frs_item_reply_text);
        this.cgi = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.zan_check_box);
        this.cgi.setText(com.baidu.tieba.t.frs_item_praise_text);
        this.cgj = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.at_me_check_box);
        this.cgj.setText(com.baidu.tieba.t.mention_atme);
        this.cgk = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.new_fans_swtich);
        this.cgk.setText(com.baidu.tieba.t.new_fans);
        this.cgn = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.stranger_msg_swtich);
        this.cgn.setText(com.baidu.tieba.t.stranger_chatmessage);
        this.cgl = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.chat_msg_swtich);
        this.cgl.setText(com.baidu.tieba.t.chat_msg_text);
        this.cgm = (MsgSettingItemView2) msgRemindActivity.findViewById(com.baidu.tieba.q.group_chat_swtich);
        this.cgm.setLineVisibility(false);
        this.cgm.setText(com.baidu.tieba.t.group_chat_text);
        this.cgo = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.screen_lock_swtich);
        this.cgo.setText(com.baidu.tieba.t.remind_screen_lock);
        this.cgp = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.chat_float_swtich);
        this.cgp.setLineVisibility(false);
        this.cgp.setText(com.baidu.tieba.t.chat_float_window);
        this.cgq = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.tone_remind_swtich);
        this.cgq.setText(com.baidu.tieba.t.remind_tone);
        this.cgr = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.vibrate_remind_swtich);
        this.cgr.setText(com.baidu.tieba.t.remind_vibrate);
        this.cgs = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.light_remind_swtich);
        this.cgs.setLineVisibility(true);
        this.cgs.setText(com.baidu.tieba.t.remind_light);
        this.cgt = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.sign_remind_swtich);
        this.cgt.setText(com.baidu.tieba.t.sign_remind_outline);
        this.cgu = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.sign_remind);
        this.cgv = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.sign_remind_time);
        this.cgw = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.promoted_content_swtich);
        this.cgw.setLineVisibility(false);
        this.cgw.setText(com.baidu.tieba.t.promoted_message_text);
        this.cgx = (MsgSettingItemView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_swtich);
        this.cgx.setText(com.baidu.tieba.t.no_disturb_mode);
        this.cgy = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_mode_time_container);
        this.cgz = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_mode_time_value);
        this.cgC = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_start_time);
        this.cgD = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_start_time_value);
        this.cgE = (LinearLayout) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_end_time);
        this.cgF = (TextView) msgRemindActivity.findViewById(com.baidu.tieba.q.no_disturb_end_time_value);
    }

    private void ajc() {
        ajd();
        aje();
        ajf();
        ajg();
    }

    private void ajd() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cgx.setVisibility(8);
            this.cgy.setVisibility(8);
            this.cgf.setVisibility(8);
            this.cgg.setVisibility(8);
            this.cgt.setVisibility(8);
            this.cgu.setVisibility(8);
            this.cgq.setVisibility(8);
            this.cgr.setVisibility(8);
            this.cgs.setVisibility(8);
            this.cgo.setVisibility(8);
            this.cgp.setVisibility(8);
        }
    }

    private void aje() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cgp.setVisibility(0);
            this.cgo.setLineVisibility(true);
            return;
        }
        this.cgp.setVisibility(8);
        this.cgo.setLineVisibility(false);
    }

    private void ajf() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cgl.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cgm.setVisibility(0);
        } else {
            this.cgm.setVisibility(8);
        }
    }

    private void ajg() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cgo.setVisibility(0);
        } else {
            this.cgo.setVisibility(8);
        }
    }

    public View afN() {
        return this.mBack;
    }

    private void ajh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi()) {
            this.cgf.mr();
            this.cgg.setVisibility(0);
        } else {
            this.cgf.ms();
            this.cgg.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn()) {
            this.cgh.getSwitchView().setChecked(true);
        } else {
            this.cgh.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww()) {
            this.cgi.getSwitchView().setChecked(true);
        } else {
            this.cgi.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl()) {
            this.cgj.getSwitchView().setChecked(true);
        } else {
            this.cgj.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm()) {
            this.cgk.getSwitchView().setChecked(true);
        } else {
            this.cgk.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
            this.cgn.getSwitchView().setChecked(true);
        } else {
            this.cgn.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
            this.cgl.getSwitchView().setChecked(true);
        } else {
            this.cgl.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
            this.cgm.getSwitchView().setChecked(true);
        } else {
            this.cgm.getSwitchView().setChecked(false);
        }
    }

    private void aji() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cgw.mr();
        } else {
            this.cgw.ms();
        }
    }

    private void ajj() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().isSignAlertOn()) {
            this.cgt.mt();
            this.cgu.setVisibility(0);
            this.cgt.setLineVisibility(true);
            ajo();
            return;
        }
        this.cgt.mu();
        this.cgt.setLineVisibility(false);
        this.cgu.setVisibility(8);
    }

    private void ajk() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wp()) {
            this.cgq.mr();
        } else {
            this.cgq.ms();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().ws()) {
            this.cgr.mr();
        } else {
            this.cgr.ms();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wq()) {
            this.cgs.mr();
        } else {
            this.cgs.ms();
        }
    }

    private void ajl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx()) {
            this.cgp.mr();
        } else {
            this.cgp.ms();
        }
    }

    private void ajm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wy()) {
            this.cgo.mr();
        } else {
            this.cgo.ms();
        }
    }

    private void ajn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wr()) {
            this.cgx.mr();
            this.cgy.setVisibility(0);
            ajp();
            return;
        }
        this.cgx.ms();
        this.cgy.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cgf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgh.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgj.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgi.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgk.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgn.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgl.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgm.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cgo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgu.setOnClickListener(msgRemindActivity);
        this.cgw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cgy.setOnClickListener(msgRemindActivity);
        this.cgC.setOnClickListener(msgRemindActivity);
        this.cgE.setOnClickListener(msgRemindActivity);
    }

    public void eM(boolean z) {
        this.cgx.setLineVisibility(z);
        if (z) {
            this.cgy.setVisibility(0);
            ajp();
            com.baidu.tbadk.core.util.ay.i(this.cgy, com.baidu.tieba.p.more_all);
            return;
        }
        this.cgy.setVisibility(8);
    }

    public void eN(boolean z) {
        if (z) {
            this.cgu.setVisibility(0);
            this.cgt.setLineVisibility(true);
            com.baidu.tbadk.core.util.ay.i(this.cgu, com.baidu.tieba.p.more_all);
            return;
        }
        this.cgu.setVisibility(8);
        this.cgt.setLineVisibility(false);
    }

    public void eO(boolean z) {
        if (z) {
            this.cgg.setVisibility(0);
        } else {
            this.cgg.setVisibility(8);
        }
    }

    public void ajo() {
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
            this.cgv.setText(this.cgH.getPageContext().getPageActivity().getString(com.baidu.tieba.t.sign_remind_time, new Object[]{str, str2}));
            this.cgu.setVisibility(0);
            if (!this.cgt.hJ()) {
                this.cgt.mr();
                return;
            }
            return;
        }
        this.cgv.setText(com.baidu.tieba.t.close);
        this.cgu.setVisibility(8);
        if (this.cgt.hJ()) {
            this.cgt.ms();
        }
    }

    public void ajp() {
        this.cgz.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wt()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.wg().wu());
        this.cgD.setText(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wt());
        this.cgF.setText(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wu());
    }

    public BdSwitchView ajq() {
        return this.cgw.getSwitchView();
    }

    public BdSwitchView ajr() {
        return this.cgt.getSwitchView();
    }

    public BdSwitchView ajs() {
        return this.cgf.getSwitchView();
    }

    public View ajt() {
        return this.cgu;
    }

    public BdSwitchView aju() {
        return this.cgx.getSwitchView();
    }

    public View ajv() {
        return this.cgy;
    }

    public LinearLayout ajw() {
        return this.cgC;
    }

    public LinearLayout ajx() {
        return this.cgE;
    }

    public BdSwitchView ajy() {
        return this.cgq.getSwitchView();
    }

    public BdSwitchView ajz() {
        return this.cgr.getSwitchView();
    }

    public BdSwitchView ajA() {
        return this.cgs.getSwitchView();
    }

    public BdSwitchView ajB() {
        return this.cgo.getSwitchView();
    }

    public BdSwitchView ajC() {
        return this.cgp.getSwitchView();
    }

    public CheckBox ajD() {
        return this.cgh.getSwitchView();
    }

    public CheckBox ajE() {
        return this.cgi.getSwitchView();
    }

    public CheckBox ajF() {
        return this.cgj.getSwitchView();
    }

    public CheckBox ajG() {
        return this.cgl.getSwitchView();
    }

    public CheckBox ajH() {
        return this.cgm.getSwitchView();
    }

    public CheckBox ajI() {
        return this.cgk.getSwitchView();
    }

    public CheckBox ajJ() {
        return this.cgn.getSwitchView();
    }

    public void ajK() {
        this.cgh.getSwitchView().setOnCheckedChangeListener(null);
        this.cgh.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn());
        this.cgh.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void ajL() {
        this.cgi.getSwitchView().setOnCheckedChangeListener(null);
        this.cgi.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().ww());
        this.cgi.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void ajM() {
        this.cgj.getSwitchView().setOnCheckedChangeListener(null);
        this.cgj.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl());
        this.cgj.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void ajN() {
        this.cgk.getSwitchView().setOnCheckedChangeListener(null);
        this.cgk.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm());
        this.cgk.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void ajO() {
        this.cgl.getSwitchView().setOnCheckedChangeListener(null);
        this.cgl.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo());
        this.cgl.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void ajP() {
        this.cgm.getSwitchView().setOnCheckedChangeListener(null);
        this.cgm.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv());
        this.cgm.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void ajQ() {
        this.cgn.getSwitchView().setOnCheckedChangeListener(null);
        this.cgn.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk());
        this.cgn.getSwitchView().setOnCheckedChangeListener(this.cgH);
    }

    public void eP(boolean z) {
        if (this.cgG != z) {
            this.cgG = z;
            if (z) {
                this.mTitleText.setText(com.baidu.tieba.t.msg_remind);
                this.cgA.setVisibility(0);
                this.cgB.setVisibility(8);
                return;
            }
            this.mTitleText.setText(com.baidu.tieba.t.no_disturb_mode_time);
            this.cgB.setVisibility(0);
            this.cgA.setVisibility(8);
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
        this.cgH.getLayoutMode().ab(i == 1);
        this.cgH.getLayoutMode().j(this.aZJ);
        this.mNavigationBar.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgf.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgh.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgi.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgj.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgn.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgk.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgl.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgm.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgo.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgp.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgq.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgr.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgs.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgt.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgw.onChangeSkinType(this.cgH.getPageContext(), i);
        this.cgx.onChangeSkinType(this.cgH.getPageContext(), i);
        com.baidu.tbadk.core.util.ay.i(this.cgy, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.i(this.cgC, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.i(this.cgE, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.i(this.cgu, com.baidu.tieba.p.more_all);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgy.findViewById(com.baidu.tieba.q.no_disturb_mode_time_arrow), com.baidu.tieba.p.icon_arrow_right);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgu.findViewById(com.baidu.tieba.q.sign_remind_arrow), com.baidu.tieba.p.icon_arrow_right);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgC.findViewById(com.baidu.tieba.q.no_disturb_start_time_arrow), com.baidu.tieba.p.icon_arrow_right);
        com.baidu.tbadk.core.util.ay.c((ImageView) this.cgE.findViewById(com.baidu.tieba.q.no_disturb_end_time_arrow), com.baidu.tieba.p.icon_arrow_right);
    }
}
