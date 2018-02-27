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
    private View bgy;
    private MsgSettingItemView gNE;
    private LinearLayout gNF;
    private MsgSettingItemView gNG;
    private MsgSettingItemView gNH;
    private MsgSettingItemView gNI;
    private MsgSettingItemView gNJ;
    private MsgSettingItemView gNK;
    private MsgSettingItemView gNL;
    private MsgSettingItemView gNM;
    private MsgSettingItemView gNN;
    private MsgSettingItemView gNO;
    private MsgSettingItemView gNP;
    private MsgSettingItemView gNQ;
    private LinearLayout gNR;
    private TextView gNS;
    private MsgSettingItemView gNT;
    private LinearLayout gNU;
    private TextView gNV;
    private LinearLayout gNW;
    private LinearLayout gNX;
    private LinearLayout gNY;
    private TextView gNZ;
    private LinearLayout gOa;
    private TextView gOb;
    public boolean gOc;
    private MsgRemindActivity gOd;
    private TbSettingTextTipView gOe;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gOc = true;
        this.gOd = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        brm();
        brp();
        bro();
        brn();
        brq();
        d(msgRemindActivity);
        brg();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gNW = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gNX = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gNE = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gNE.setText(d.j.receive_msg_text);
        this.gNE.setLineVisibility(false);
        this.gNF = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gNG = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gNG.setText(d.j.reply);
        this.gNH = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gNH.setVisibility(0);
        this.gNH.setText(d.j.action_praise_default);
        this.gNI = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gNI.setText(d.j.mention_atme);
        this.gNJ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gNJ.setText(d.j.new_fans);
        this.gNK = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gNK.setText(d.j.chat_msg_text);
        this.gNL = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gNL.setLineVisibility(false);
        this.gNL.setText(d.j.group_chat_text);
        this.gNM = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gNM.setText(d.j.remind_screen_lock);
        this.gNM.setLineVisibility(false);
        this.gNN = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gNN.setText(d.j.remind_tone);
        this.gNO = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gNO.setText(d.j.remind_vibrate);
        this.gNP = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gNP.setLineVisibility(true);
        this.gNP.setText(d.j.remind_light);
        this.gNQ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gNQ.setText(d.j.sign_remind_outline);
        this.gNR = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gNS = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gNT = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gNT.setText(d.j.no_disturb_mode);
        this.gNT.setLineVisibility(false);
        this.gNU = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gNV = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gNY = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gNZ = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gOa = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gOb = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gOe = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void brg() {
        brh();
        bri();
        brj();
        brk();
    }

    private void brh() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gNT.setVisibility(8);
            this.gNU.setVisibility(8);
            this.gNE.setVisibility(8);
            this.gNF.setVisibility(8);
            this.gNQ.setVisibility(8);
            this.gNR.setVisibility(8);
            this.gNN.setVisibility(8);
            this.gNO.setVisibility(8);
            this.gNP.setVisibility(8);
            this.gNM.setVisibility(8);
        }
    }

    private void bri() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gNM.setLineVisibility(true);
        } else {
            this.gNM.setLineVisibility(false);
        }
    }

    private void brj() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gNK.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gNL.setVisibility(0);
        } else {
            this.gNL.setVisibility(8);
        }
    }

    private void brk() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gNM.setVisibility(0);
        } else {
            this.gNM.setVisibility(8);
        }
    }

    public View brl() {
        return this.bgy;
    }

    private void brm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hr()) {
            this.gNE.rH();
            this.gNF.setVisibility(0);
        } else {
            this.gNE.rI();
            this.gNF.setVisibility(8);
        }
        this.gNG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hw());
        this.gNH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HF());
        this.gNI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hu());
        this.gNJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hv());
        this.gNK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hx());
        this.gNL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HE());
    }

    private void brn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().isSignAlertOn()) {
            this.gNQ.rJ();
            this.gNR.setVisibility(0);
            this.gNQ.setLineVisibility(true);
            brr();
            return;
        }
        this.gNQ.rK();
        this.gNQ.setLineVisibility(false);
        this.gNR.setVisibility(8);
    }

    private void bro() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hy()) {
            this.gNN.rH();
        } else {
            this.gNN.rI();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HB()) {
            this.gNO.rH();
        } else {
            this.gNO.rI();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hz()) {
            this.gNP.rH();
        } else {
            this.gNP.rI();
        }
    }

    private void brp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HG()) {
            this.gNM.rH();
        } else {
            this.gNM.rI();
        }
    }

    private void brq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HA()) {
            this.gNT.rH();
            this.gNU.setVisibility(0);
            brs();
            return;
        }
        this.gNT.rI();
        this.gNU.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bgy.setOnClickListener(msgRemindActivity);
        this.gNE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNR.setOnClickListener(msgRemindActivity);
        this.gNT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gNU.setOnClickListener(msgRemindActivity);
        this.gNY.setOnClickListener(msgRemindActivity);
        this.gOa.setOnClickListener(msgRemindActivity);
        this.gOe.setOnClickListener(msgRemindActivity);
    }

    public void ml(boolean z) {
        this.gNT.setLineVisibility(z);
        if (z) {
            this.gNU.setVisibility(0);
            brs();
            aj.s(this.gNU, d.f.more_all);
            return;
        }
        this.gNU.setVisibility(8);
    }

    public void mm(boolean z) {
        if (z) {
            this.gNR.setVisibility(0);
            this.gNQ.setLineVisibility(true);
            aj.s(this.gNR, d.f.more_all);
            return;
        }
        this.gNR.setVisibility(8);
        this.gNQ.setLineVisibility(false);
    }

    public void mn(boolean z) {
        if (z) {
            this.gNF.setVisibility(0);
        } else {
            this.gNF.setVisibility(8);
        }
    }

    public void brr() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Hp().getSignAlertMins();
            }
            this.gNS.setText(this.gOd.getPageContext().getPageActivity().getString(d.j.sign_remind_time, new Object[]{str, str2}));
            this.gNR.setVisibility(0);
            if (!this.gNQ.nv()) {
                this.gNQ.rH();
                return;
            }
            return;
        }
        this.gNS.setText(d.j.close);
        this.gNR.setVisibility(8);
        if (this.gNQ.nv()) {
            this.gNQ.rI();
        }
    }

    public void brs() {
        this.gNV.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HC() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HD());
        this.gNZ.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HC());
        this.gOb.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HD());
    }

    public BdSwitchView brt() {
        return this.gNQ.getSwitchView();
    }

    public BdSwitchView bru() {
        return this.gNE.getSwitchView();
    }

    public View brv() {
        return this.gNR;
    }

    public BdSwitchView brw() {
        return this.gNT.getSwitchView();
    }

    public View brx() {
        return this.gNU;
    }

    public LinearLayout bry() {
        return this.gNY;
    }

    public LinearLayout brz() {
        return this.gOa;
    }

    public BdSwitchView brA() {
        return this.gNN.getSwitchView();
    }

    public BdSwitchView brB() {
        return this.gNO.getSwitchView();
    }

    public BdSwitchView brC() {
        return this.gNP.getSwitchView();
    }

    public BdSwitchView brD() {
        return this.gNM.getSwitchView();
    }

    public BdSwitchView brE() {
        return this.gNG.getSwitchView();
    }

    public BdSwitchView brF() {
        return this.gNH.getSwitchView();
    }

    public BdSwitchView brG() {
        return this.gNI.getSwitchView();
    }

    public BdSwitchView brH() {
        return this.gNK.getSwitchView();
    }

    public BdSwitchView brI() {
        return this.gNL.getSwitchView();
    }

    public BdSwitchView brJ() {
        return this.gNJ.getSwitchView();
    }

    public TbSettingTextTipView brK() {
        return this.gOe;
    }

    public void brL() {
        this.gNG.setOnSwitchStateChangeListener(null);
        this.gNG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hw());
        this.gNG.setOnSwitchStateChangeListener(this.gOd);
    }

    public void brM() {
        this.gNH.setOnSwitchStateChangeListener(null);
        this.gNH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HF());
        this.gNH.setOnSwitchStateChangeListener(this.gOd);
    }

    public void brN() {
        this.gNI.setOnSwitchStateChangeListener(null);
        this.gNI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hu());
        this.gNI.setOnSwitchStateChangeListener(this.gOd);
    }

    public void brO() {
        this.gNJ.setOnSwitchStateChangeListener(null);
        this.gNJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hv());
        this.gNJ.setOnSwitchStateChangeListener(this.gOd);
    }

    public void brP() {
        this.gNK.setOnSwitchStateChangeListener(null);
        this.gNK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hx());
        this.gNK.setOnSwitchStateChangeListener(this.gOd);
    }

    public void brQ() {
        this.gNL.setOnSwitchStateChangeListener(null);
        this.gNL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HE());
        this.gNL.setOnSwitchStateChangeListener(this.gOd);
    }

    public void mo(boolean z) {
        if (this.gOc != z) {
            this.gOc = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gOd.getPageContext().getString(d.j.msg_remind));
                this.gNW.setVisibility(0);
                this.gNX.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gOd.getPageContext().getString(d.j.no_disturb_mode_time));
            this.gNX.setVisibility(0);
            this.gNW.setVisibility(8);
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
        this.gOd.getLayoutMode().aQ(i == 1);
        this.gOd.getLayoutMode().aM(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gOd.getPageContext(), i);
        this.gNE.d(this.gOd.getPageContext(), i);
        this.gNG.d(this.gOd.getPageContext(), i);
        this.gNH.d(this.gOd.getPageContext(), i);
        this.gNI.d(this.gOd.getPageContext(), i);
        this.gNJ.d(this.gOd.getPageContext(), i);
        this.gNK.d(this.gOd.getPageContext(), i);
        this.gNL.d(this.gOd.getPageContext(), i);
        this.gNM.d(this.gOd.getPageContext(), i);
        this.gNN.d(this.gOd.getPageContext(), i);
        this.gNO.d(this.gOd.getPageContext(), i);
        this.gNP.d(this.gOd.getPageContext(), i);
        this.gNQ.d(this.gOd.getPageContext(), i);
        this.gNT.d(this.gOd.getPageContext(), i);
        aj.s(this.gNU, d.f.more_all);
        aj.s(this.gNY, d.f.more_all);
        aj.s(this.gOa, d.f.more_all);
        aj.s(this.gNR, d.f.more_all);
        aj.c((ImageView) this.gNU.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gNR.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gNY.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        aj.c((ImageView) this.gOa.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
