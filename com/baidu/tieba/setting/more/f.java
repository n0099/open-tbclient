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
    private View bgK;
    private MsgSettingItemView gNT;
    private LinearLayout gNU;
    private MsgSettingItemView gNV;
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
    private LinearLayout gOg;
    private TextView gOh;
    private MsgSettingItemView gOi;
    private LinearLayout gOj;
    private TextView gOk;
    private LinearLayout gOl;
    private LinearLayout gOm;
    private LinearLayout gOn;
    private TextView gOo;
    private LinearLayout gOp;
    private TextView gOq;
    public boolean gOr;
    private MsgRemindActivity gOs;
    private TbSettingTextTipView gOt;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gOr = true;
        this.gOs = msgRemindActivity;
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
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOl = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gOm = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gNT = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gNT.setText(d.j.receive_msg_text);
        this.gNT.setLineVisibility(false);
        this.gNU = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gNV = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gNV.setText(d.j.reply);
        this.gNW = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gNW.setVisibility(0);
        this.gNW.setText(d.j.action_praise_default);
        this.gNX = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gNX.setText(d.j.mention_atme);
        this.gNY = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gNY.setText(d.j.new_fans);
        this.gNZ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gNZ.setText(d.j.chat_msg_text);
        this.gOa = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gOa.setLineVisibility(false);
        this.gOa.setText(d.j.group_chat_text);
        this.gOb = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gOb.setText(d.j.remind_screen_lock);
        this.gOb.setLineVisibility(false);
        this.gOc = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gOc.setText(d.j.remind_tone);
        this.gOd = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gOd.setText(d.j.remind_vibrate);
        this.gOe = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gOe.setLineVisibility(true);
        this.gOe.setText(d.j.remind_light);
        this.gOf = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gOf.setText(d.j.sign_remind_outline);
        this.gOg = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gOh = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gOi = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gOi.setText(d.j.no_disturb_mode);
        this.gOi.setLineVisibility(false);
        this.gOj = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gOk = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gOn = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gOo = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gOp = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gOq = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gOt = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
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
            this.gOi.setVisibility(8);
            this.gOj.setVisibility(8);
            this.gNT.setVisibility(8);
            this.gNU.setVisibility(8);
            this.gOf.setVisibility(8);
            this.gOg.setVisibility(8);
            this.gOc.setVisibility(8);
            this.gOd.setVisibility(8);
            this.gOe.setVisibility(8);
            this.gOb.setVisibility(8);
        }
    }

    private void brj() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gOb.setLineVisibility(true);
        } else {
            this.gOb.setLineVisibility(false);
        }
    }

    private void brk() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gNZ.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gOa.setVisibility(0);
        } else {
            this.gOa.setVisibility(8);
        }
    }

    private void brl() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gOb.setVisibility(0);
        } else {
            this.gOb.setVisibility(8);
        }
    }

    public View brm() {
        return this.bgK;
    }

    private void brn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hs()) {
            this.gNT.rH();
            this.gNU.setVisibility(0);
        } else {
            this.gNT.rI();
            this.gNU.setVisibility(8);
        }
        this.gNV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hx());
        this.gNW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG());
        this.gNX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv());
        this.gNY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hw());
        this.gNZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy());
        this.gOa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF());
    }

    private void bro() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().isSignAlertOn()) {
            this.gOf.rJ();
            this.gOg.setVisibility(0);
            this.gOf.setLineVisibility(true);
            brs();
            return;
        }
        this.gOf.rK();
        this.gOf.setLineVisibility(false);
        this.gOg.setVisibility(8);
    }

    private void brp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hz()) {
            this.gOc.rH();
        } else {
            this.gOc.rI();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HC()) {
            this.gOd.rH();
        } else {
            this.gOd.rI();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HA()) {
            this.gOe.rH();
        } else {
            this.gOe.rI();
        }
    }

    private void brq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HH()) {
            this.gOb.rH();
        } else {
            this.gOb.rI();
        }
    }

    private void brr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HB()) {
            this.gOi.rH();
            this.gOj.setVisibility(0);
            brt();
            return;
        }
        this.gOi.rI();
        this.gOj.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bgK.setOnClickListener(msgRemindActivity);
        this.gNT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOg.setOnClickListener(msgRemindActivity);
        this.gOi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gOj.setOnClickListener(msgRemindActivity);
        this.gOn.setOnClickListener(msgRemindActivity);
        this.gOp.setOnClickListener(msgRemindActivity);
        this.gOt.setOnClickListener(msgRemindActivity);
    }

    public void ml(boolean z) {
        this.gOi.setLineVisibility(z);
        if (z) {
            this.gOj.setVisibility(0);
            brt();
            aj.s(this.gOj, d.f.more_all);
            return;
        }
        this.gOj.setVisibility(8);
    }

    public void mm(boolean z) {
        if (z) {
            this.gOg.setVisibility(0);
            this.gOf.setLineVisibility(true);
            aj.s(this.gOg, d.f.more_all);
            return;
        }
        this.gOg.setVisibility(8);
        this.gOf.setLineVisibility(false);
    }

    public void mn(boolean z) {
        if (z) {
            this.gNU.setVisibility(0);
        } else {
            this.gNU.setVisibility(8);
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
            this.gOh.setText(this.gOs.getPageContext().getPageActivity().getString(d.j.sign_remind_time, new Object[]{str, str2}));
            this.gOg.setVisibility(0);
            if (!this.gOf.nv()) {
                this.gOf.rH();
                return;
            }
            return;
        }
        this.gOh.setText(d.j.close);
        this.gOg.setVisibility(8);
        if (this.gOf.nv()) {
            this.gOf.rI();
        }
    }

    public void brt() {
        this.gOk.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HD() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HE());
        this.gOo.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HD());
        this.gOq.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HE());
    }

    public BdSwitchView bru() {
        return this.gOf.getSwitchView();
    }

    public BdSwitchView brv() {
        return this.gNT.getSwitchView();
    }

    public View brw() {
        return this.gOg;
    }

    public BdSwitchView brx() {
        return this.gOi.getSwitchView();
    }

    public View bry() {
        return this.gOj;
    }

    public LinearLayout brz() {
        return this.gOn;
    }

    public LinearLayout brA() {
        return this.gOp;
    }

    public BdSwitchView brB() {
        return this.gOc.getSwitchView();
    }

    public BdSwitchView brC() {
        return this.gOd.getSwitchView();
    }

    public BdSwitchView brD() {
        return this.gOe.getSwitchView();
    }

    public BdSwitchView brE() {
        return this.gOb.getSwitchView();
    }

    public BdSwitchView brF() {
        return this.gNV.getSwitchView();
    }

    public BdSwitchView brG() {
        return this.gNW.getSwitchView();
    }

    public BdSwitchView brH() {
        return this.gNX.getSwitchView();
    }

    public BdSwitchView brI() {
        return this.gNZ.getSwitchView();
    }

    public BdSwitchView brJ() {
        return this.gOa.getSwitchView();
    }

    public BdSwitchView brK() {
        return this.gNY.getSwitchView();
    }

    public TbSettingTextTipView brL() {
        return this.gOt;
    }

    public void brM() {
        this.gNV.setOnSwitchStateChangeListener(null);
        this.gNV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hx());
        this.gNV.setOnSwitchStateChangeListener(this.gOs);
    }

    public void brN() {
        this.gNW.setOnSwitchStateChangeListener(null);
        this.gNW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG());
        this.gNW.setOnSwitchStateChangeListener(this.gOs);
    }

    public void brO() {
        this.gNX.setOnSwitchStateChangeListener(null);
        this.gNX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv());
        this.gNX.setOnSwitchStateChangeListener(this.gOs);
    }

    public void brP() {
        this.gNY.setOnSwitchStateChangeListener(null);
        this.gNY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hw());
        this.gNY.setOnSwitchStateChangeListener(this.gOs);
    }

    public void brQ() {
        this.gNZ.setOnSwitchStateChangeListener(null);
        this.gNZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy());
        this.gNZ.setOnSwitchStateChangeListener(this.gOs);
    }

    public void brR() {
        this.gOa.setOnSwitchStateChangeListener(null);
        this.gOa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF());
        this.gOa.setOnSwitchStateChangeListener(this.gOs);
    }

    public void mo(boolean z) {
        if (this.gOr != z) {
            this.gOr = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gOs.getPageContext().getString(d.j.msg_remind));
                this.gOl.setVisibility(0);
                this.gOm.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gOs.getPageContext().getString(d.j.no_disturb_mode_time));
            this.gOm.setVisibility(0);
            this.gOl.setVisibility(8);
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
        this.gOs.getLayoutMode().aQ(i == 1);
        this.gOs.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gOs.getPageContext(), i);
        this.gNT.d(this.gOs.getPageContext(), i);
        this.gNV.d(this.gOs.getPageContext(), i);
        this.gNW.d(this.gOs.getPageContext(), i);
        this.gNX.d(this.gOs.getPageContext(), i);
        this.gNY.d(this.gOs.getPageContext(), i);
        this.gNZ.d(this.gOs.getPageContext(), i);
        this.gOa.d(this.gOs.getPageContext(), i);
        this.gOb.d(this.gOs.getPageContext(), i);
        this.gOc.d(this.gOs.getPageContext(), i);
        this.gOd.d(this.gOs.getPageContext(), i);
        this.gOe.d(this.gOs.getPageContext(), i);
        this.gOf.d(this.gOs.getPageContext(), i);
        this.gOi.d(this.gOs.getPageContext(), i);
        aj.s(this.gOj, d.f.more_all);
        aj.s(this.gOn, d.f.more_all);
        aj.s(this.gOp, d.f.more_all);
        aj.s(this.gOg, d.f.more_all);
        aj.c((ImageView) this.gOj.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOg.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOn.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOp.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
