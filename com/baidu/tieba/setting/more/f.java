package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View bgB;
    private MsgSettingItemView gNU;
    private LinearLayout gNV;
    private MsgSettingItemView gNW;
    private MsgSettingItemView gNX;
    private MsgSettingItemView gNY;
    private MsgSettingItemView gNZ;
    private MsgSettingItemView gOa;
    private MsgSettingItemView gOb;
    private MsgSettingItemView gOc;
    private MsgSettingItemView gOd;
    private MsgSettingItemView gOe;
    private MsgSettingItemView gOf;
    private MsgSettingItemView gOg;
    private LinearLayout gOh;
    private TextView gOi;
    private MsgSettingItemView gOj;
    private LinearLayout gOk;
    private TextView gOl;
    private LinearLayout gOm;
    private LinearLayout gOn;
    private LinearLayout gOo;
    private TextView gOp;
    private LinearLayout gOq;
    private TextView gOr;
    public boolean gOs;
    private MsgRemindActivity gOt;
    private TbSettingTextTipView gOu;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gOs = true;
        this.gOt = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        brn();
        brq();
        brp();
        bro();
        brr();
        d(msgRemindActivity);
        brh();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOm = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gOn = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gNU = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gNU.setText(d.j.receive_msg_text);
        this.gNU.setLineVisibility(false);
        this.gNV = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gNW = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gNW.setText(d.j.reply);
        this.gNX = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gNX.setVisibility(0);
        this.gNX.setText(d.j.action_praise_default);
        this.gNY = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gNY.setText(d.j.mention_atme);
        this.gNZ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gNZ.setText(d.j.new_fans);
        this.gOa = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gOa.setText(d.j.chat_msg_text);
        this.gOb = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gOb.setLineVisibility(false);
        this.gOb.setText(d.j.group_chat_text);
        this.gOc = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gOc.setText(d.j.remind_screen_lock);
        this.gOc.setLineVisibility(false);
        this.gOd = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gOd.setText(d.j.remind_tone);
        this.gOe = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gOe.setText(d.j.remind_vibrate);
        this.gOf = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gOf.setLineVisibility(true);
        this.gOf.setText(d.j.remind_light);
        this.gOg = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gOg.setText(d.j.sign_remind_outline);
        this.gOh = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gOi = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gOj = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gOj.setText(d.j.no_disturb_mode);
        this.gOj.setLineVisibility(false);
        this.gOk = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gOl = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gOo = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gOp = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gOq = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gOr = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gOu = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void brh() {
        bri();
        brj();
        brk();
        brl();
    }

    private void bri() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gOj.setVisibility(8);
            this.gOk.setVisibility(8);
            this.gNU.setVisibility(8);
            this.gNV.setVisibility(8);
            this.gOg.setVisibility(8);
            this.gOh.setVisibility(8);
            this.gOd.setVisibility(8);
            this.gOe.setVisibility(8);
            this.gOf.setVisibility(8);
            this.gOc.setVisibility(8);
        }
    }

    private void brj() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gOc.setLineVisibility(true);
        } else {
            this.gOc.setLineVisibility(false);
        }
    }

    private void brk() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gOa.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gOb.setVisibility(0);
        } else {
            this.gOb.setVisibility(8);
        }
    }

    private void brl() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gOc.setVisibility(0);
        } else {
            this.gOc.setVisibility(8);
        }
    }

    public View brm() {
        return this.bgB;
    }

    private void brn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hs()) {
            this.gNU.rH();
            this.gNV.setVisibility(0);
        } else {
            this.gNU.rI();
            this.gNV.setVisibility(8);
        }
        this.gNW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hx());
        this.gNX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG());
        this.gNY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv());
        this.gNZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hw());
        this.gOa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy());
        this.gOb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF());
    }

    private void bro() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().isSignAlertOn()) {
            this.gOg.rJ();
            this.gOh.setVisibility(0);
            this.gOg.setLineVisibility(true);
            brs();
            return;
        }
        this.gOg.rK();
        this.gOg.setLineVisibility(false);
        this.gOh.setVisibility(8);
    }

    private void brp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hz()) {
            this.gOd.rH();
        } else {
            this.gOd.rI();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HC()) {
            this.gOe.rH();
        } else {
            this.gOe.rI();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HA()) {
            this.gOf.rH();
        } else {
            this.gOf.rI();
        }
    }

    private void brq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HH()) {
            this.gOc.rH();
        } else {
            this.gOc.rI();
        }
    }

    private void brr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HB()) {
            this.gOj.rH();
            this.gOk.setVisibility(0);
            brt();
            return;
        }
        this.gOj.rI();
        this.gOk.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bgB.setOnClickListener(msgRemindActivity);
        this.gNU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOh.setOnClickListener(msgRemindActivity);
        this.gOj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOk.setOnClickListener(msgRemindActivity);
        this.gOo.setOnClickListener(msgRemindActivity);
        this.gOq.setOnClickListener(msgRemindActivity);
        this.gOu.setOnClickListener(msgRemindActivity);
    }

    public void mq(boolean z) {
        this.gOj.setLineVisibility(z);
        if (z) {
            this.gOk.setVisibility(0);
            brt();
            aj.s(this.gOk, d.f.more_all);
            return;
        }
        this.gOk.setVisibility(8);
    }

    public void mr(boolean z) {
        if (z) {
            this.gOh.setVisibility(0);
            this.gOg.setLineVisibility(true);
            aj.s(this.gOh, d.f.more_all);
            return;
        }
        this.gOh.setVisibility(8);
        this.gOg.setLineVisibility(false);
    }

    public void ms(boolean z) {
        if (z) {
            this.gNV.setVisibility(0);
        } else {
            this.gNV.setVisibility(8);
        }
    }

    public void brs() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Hq().getSignAlertMins();
            }
            this.gOi.setText(this.gOt.getPageContext().getPageActivity().getString(d.j.sign_remind_time, new Object[]{str, str2}));
            this.gOh.setVisibility(0);
            if (!this.gOg.nv()) {
                this.gOg.rH();
                return;
            }
            return;
        }
        this.gOi.setText(d.j.close);
        this.gOh.setVisibility(8);
        if (this.gOg.nv()) {
            this.gOg.rI();
        }
    }

    public void brt() {
        this.gOl.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HD() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HE());
        this.gOp.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HD());
        this.gOr.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HE());
    }

    public BdSwitchView bru() {
        return this.gOg.getSwitchView();
    }

    public BdSwitchView brv() {
        return this.gNU.getSwitchView();
    }

    public View brw() {
        return this.gOh;
    }

    public BdSwitchView brx() {
        return this.gOj.getSwitchView();
    }

    public View bry() {
        return this.gOk;
    }

    public LinearLayout brz() {
        return this.gOo;
    }

    public LinearLayout brA() {
        return this.gOq;
    }

    public BdSwitchView brB() {
        return this.gOd.getSwitchView();
    }

    public BdSwitchView brC() {
        return this.gOe.getSwitchView();
    }

    public BdSwitchView brD() {
        return this.gOf.getSwitchView();
    }

    public BdSwitchView brE() {
        return this.gOc.getSwitchView();
    }

    public BdSwitchView brF() {
        return this.gNW.getSwitchView();
    }

    public BdSwitchView brG() {
        return this.gNX.getSwitchView();
    }

    public BdSwitchView brH() {
        return this.gNY.getSwitchView();
    }

    public BdSwitchView brI() {
        return this.gOa.getSwitchView();
    }

    public BdSwitchView brJ() {
        return this.gOb.getSwitchView();
    }

    public BdSwitchView brK() {
        return this.gNZ.getSwitchView();
    }

    public TbSettingTextTipView brL() {
        return this.gOu;
    }

    public void brM() {
        this.gNW.setOnSwitchStateChangeListener(null);
        this.gNW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hx());
        this.gNW.setOnSwitchStateChangeListener(this.gOt);
    }

    public void brN() {
        this.gNX.setOnSwitchStateChangeListener(null);
        this.gNX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG());
        this.gNX.setOnSwitchStateChangeListener(this.gOt);
    }

    public void brO() {
        this.gNY.setOnSwitchStateChangeListener(null);
        this.gNY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv());
        this.gNY.setOnSwitchStateChangeListener(this.gOt);
    }

    public void brP() {
        this.gNZ.setOnSwitchStateChangeListener(null);
        this.gNZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hw());
        this.gNZ.setOnSwitchStateChangeListener(this.gOt);
    }

    public void brQ() {
        this.gOa.setOnSwitchStateChangeListener(null);
        this.gOa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy());
        this.gOa.setOnSwitchStateChangeListener(this.gOt);
    }

    public void brR() {
        this.gOb.setOnSwitchStateChangeListener(null);
        this.gOb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF());
        this.gOb.setOnSwitchStateChangeListener(this.gOt);
    }

    public void mt(boolean z) {
        if (this.gOs != z) {
            this.gOs = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gOt.getPageContext().getString(d.j.msg_remind));
                this.gOm.setVisibility(0);
                this.gOn.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gOt.getPageContext().getString(d.j.no_disturb_mode_time));
            this.gOn.setVisibility(0);
            this.gOm.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.gOt.getLayoutMode().aQ(i == 1);
        this.gOt.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gOt.getPageContext(), i);
        this.gNU.d(this.gOt.getPageContext(), i);
        this.gNW.d(this.gOt.getPageContext(), i);
        this.gNX.d(this.gOt.getPageContext(), i);
        this.gNY.d(this.gOt.getPageContext(), i);
        this.gNZ.d(this.gOt.getPageContext(), i);
        this.gOa.d(this.gOt.getPageContext(), i);
        this.gOb.d(this.gOt.getPageContext(), i);
        this.gOc.d(this.gOt.getPageContext(), i);
        this.gOd.d(this.gOt.getPageContext(), i);
        this.gOe.d(this.gOt.getPageContext(), i);
        this.gOf.d(this.gOt.getPageContext(), i);
        this.gOg.d(this.gOt.getPageContext(), i);
        this.gOj.d(this.gOt.getPageContext(), i);
        aj.s(this.gOk, d.f.more_all);
        aj.s(this.gOo, d.f.more_all);
        aj.s(this.gOq, d.f.more_all);
        aj.s(this.gOh, d.f.more_all);
        aj.c((ImageView) this.gOk.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOh.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOo.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOq.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
