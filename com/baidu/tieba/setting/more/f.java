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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aAn;
    private MsgSettingItemView gvA;
    private LinearLayout gvB;
    private MsgSettingItemView gvC;
    private MsgSettingItemView gvD;
    private MsgSettingItemView gvE;
    private MsgSettingItemView gvF;
    private MsgSettingItemView gvG;
    private MsgSettingItemView gvH;
    private MsgSettingItemView gvI;
    private MsgSettingItemView gvJ;
    private MsgSettingItemView gvK;
    private MsgSettingItemView gvL;
    private MsgSettingItemView gvM;
    private LinearLayout gvN;
    private TextView gvO;
    private MsgSettingItemView gvP;
    private LinearLayout gvQ;
    private TextView gvR;
    private LinearLayout gvS;
    private LinearLayout gvT;
    private LinearLayout gvU;
    private TextView gvV;
    private LinearLayout gvW;
    private TextView gvX;
    public boolean gvY;
    private MsgRemindActivity gvZ;
    private TbSettingTextTipView gwa;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gvY = true;
        this.gvZ = msgRemindActivity;
        msgRemindActivity.setContentView(d.i.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bru();
        brx();
        brw();
        brv();
        bry();
        d(msgRemindActivity);
        bro();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.k.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gvS = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gvT = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gvA = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gvA.setText(d.k.receive_msg_text);
        this.gvA.setLineVisibility(false);
        this.gvB = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gvC = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gvC.setText(d.k.reply);
        this.gvD = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gvD.setVisibility(0);
        this.gvD.setText(d.k.action_praise_default);
        this.gvE = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gvE.setText(d.k.mention_atme);
        this.gvF = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gvF.setText(d.k.new_fans);
        this.gvG = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gvG.setText(d.k.chat_msg_text);
        this.gvH = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gvH.setLineVisibility(false);
        this.gvH.setText(d.k.group_chat_text);
        this.gvI = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gvI.setText(d.k.remind_screen_lock);
        this.gvI.setLineVisibility(false);
        this.gvJ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gvJ.setText(d.k.remind_tone);
        this.gvK = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gvK.setText(d.k.remind_vibrate);
        this.gvL = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gvL.setLineVisibility(true);
        this.gvL.setText(d.k.remind_light);
        this.gvM = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gvM.setText(d.k.sign_remind_outline);
        this.gvN = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gvO = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gvP = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gvP.setText(d.k.no_disturb_mode);
        this.gvP.setLineVisibility(false);
        this.gvQ = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gvR = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gvU = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gvV = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gvW = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gvX = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gwa = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bro() {
        brp();
        brq();
        brr();
        brs();
    }

    private void brp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gvP.setVisibility(8);
            this.gvQ.setVisibility(8);
            this.gvA.setVisibility(8);
            this.gvB.setVisibility(8);
            this.gvM.setVisibility(8);
            this.gvN.setVisibility(8);
            this.gvJ.setVisibility(8);
            this.gvK.setVisibility(8);
            this.gvL.setVisibility(8);
            this.gvI.setVisibility(8);
        }
    }

    private void brq() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gvI.setLineVisibility(true);
        } else {
            this.gvI.setLineVisibility(false);
        }
    }

    private void brr() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gvG.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gvH.setVisibility(0);
        } else {
            this.gvH.setVisibility(8);
        }
    }

    private void brs() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gvI.setVisibility(0);
        } else {
            this.gvI.setVisibility(8);
        }
    }

    public View brt() {
        return this.aAn;
    }

    private void bru() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().DG()) {
            this.gvA.mA();
            this.gvB.setVisibility(0);
        } else {
            this.gvA.mB();
            this.gvB.setVisibility(8);
        }
        this.gvC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DL());
        this.gvD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DU());
        this.gvE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DJ());
        this.gvF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DK());
        this.gvG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM());
        this.gvH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DT());
    }

    private void brv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().isSignAlertOn()) {
            this.gvM.mC();
            this.gvN.setVisibility(0);
            this.gvM.setLineVisibility(true);
            brz();
            return;
        }
        this.gvM.mD();
        this.gvM.setLineVisibility(false);
        this.gvN.setVisibility(8);
    }

    private void brw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().DN()) {
            this.gvJ.mA();
        } else {
            this.gvJ.mB();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().DQ()) {
            this.gvK.mA();
        } else {
            this.gvK.mB();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().DO()) {
            this.gvL.mA();
        } else {
            this.gvL.mB();
        }
    }

    private void brx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().DV()) {
            this.gvI.mA();
        } else {
            this.gvI.mB();
        }
    }

    private void bry() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().DP()) {
            this.gvP.mA();
            this.gvQ.setVisibility(0);
            brA();
            return;
        }
        this.gvP.mB();
        this.gvQ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aAn.setOnClickListener(msgRemindActivity);
        this.gvA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvN.setOnClickListener(msgRemindActivity);
        this.gvP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gvQ.setOnClickListener(msgRemindActivity);
        this.gvU.setOnClickListener(msgRemindActivity);
        this.gvW.setOnClickListener(msgRemindActivity);
        this.gwa.setOnClickListener(msgRemindActivity);
    }

    public void lY(boolean z) {
        this.gvP.setLineVisibility(z);
        if (z) {
            this.gvQ.setVisibility(0);
            brA();
            al.i(this.gvQ, d.f.more_all);
            return;
        }
        this.gvQ.setVisibility(8);
    }

    public void lZ(boolean z) {
        if (z) {
            this.gvN.setVisibility(0);
            this.gvM.setLineVisibility(true);
            al.i(this.gvN, d.f.more_all);
            return;
        }
        this.gvN.setVisibility(8);
        this.gvM.setLineVisibility(false);
    }

    public void ma(boolean z) {
        if (z) {
            this.gvB.setVisibility(0);
        } else {
            this.gvB.setVisibility(8);
        }
    }

    public void brz() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.DE().getSignAlertMins();
            }
            this.gvO.setText(this.gvZ.getPageContext().getPageActivity().getString(d.k.sign_remind_time, new Object[]{str, str2}));
            this.gvN.setVisibility(0);
            if (!this.gvM.ip()) {
                this.gvM.mA();
                return;
            }
            return;
        }
        this.gvO.setText(d.k.close);
        this.gvN.setVisibility(8);
        if (this.gvM.ip()) {
            this.gvM.mB();
        }
    }

    public void brA() {
        this.gvR.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DR() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.DE().DS());
        this.gvV.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DR());
        this.gvX.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DS());
    }

    public BdSwitchView brB() {
        return this.gvM.getSwitchView();
    }

    public BdSwitchView brC() {
        return this.gvA.getSwitchView();
    }

    public View brD() {
        return this.gvN;
    }

    public BdSwitchView brE() {
        return this.gvP.getSwitchView();
    }

    public View brF() {
        return this.gvQ;
    }

    public LinearLayout brG() {
        return this.gvU;
    }

    public LinearLayout brH() {
        return this.gvW;
    }

    public BdSwitchView brI() {
        return this.gvJ.getSwitchView();
    }

    public BdSwitchView brJ() {
        return this.gvK.getSwitchView();
    }

    public BdSwitchView brK() {
        return this.gvL.getSwitchView();
    }

    public BdSwitchView brL() {
        return this.gvI.getSwitchView();
    }

    public BdSwitchView brM() {
        return this.gvC.getSwitchView();
    }

    public BdSwitchView brN() {
        return this.gvD.getSwitchView();
    }

    public BdSwitchView brO() {
        return this.gvE.getSwitchView();
    }

    public BdSwitchView brP() {
        return this.gvG.getSwitchView();
    }

    public BdSwitchView brQ() {
        return this.gvH.getSwitchView();
    }

    public BdSwitchView brR() {
        return this.gvF.getSwitchView();
    }

    public TbSettingTextTipView brS() {
        return this.gwa;
    }

    public void brT() {
        this.gvC.setOnSwitchStateChangeListener(null);
        this.gvC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DL());
        this.gvC.setOnSwitchStateChangeListener(this.gvZ);
    }

    public void brU() {
        this.gvD.setOnSwitchStateChangeListener(null);
        this.gvD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DU());
        this.gvD.setOnSwitchStateChangeListener(this.gvZ);
    }

    public void brV() {
        this.gvE.setOnSwitchStateChangeListener(null);
        this.gvE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DJ());
        this.gvE.setOnSwitchStateChangeListener(this.gvZ);
    }

    public void brW() {
        this.gvF.setOnSwitchStateChangeListener(null);
        this.gvF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DK());
        this.gvF.setOnSwitchStateChangeListener(this.gvZ);
    }

    public void brX() {
        this.gvG.setOnSwitchStateChangeListener(null);
        this.gvG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM());
        this.gvG.setOnSwitchStateChangeListener(this.gvZ);
    }

    public void brY() {
        this.gvH.setOnSwitchStateChangeListener(null);
        this.gvH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DT());
        this.gvH.setOnSwitchStateChangeListener(this.gvZ);
    }

    public void mb(boolean z) {
        if (this.gvY != z) {
            this.gvY = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gvZ.getPageContext().getString(d.k.msg_remind));
                this.gvS.setVisibility(0);
                this.gvT.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gvZ.getPageContext().getString(d.k.no_disturb_mode_time));
            this.gvT.setVisibility(0);
            this.gvS.setVisibility(8);
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
        this.gvZ.getLayoutMode().setNightMode(i == 1);
        this.gvZ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gvZ.getPageContext(), i);
        this.gvA.d(this.gvZ.getPageContext(), i);
        this.gvC.d(this.gvZ.getPageContext(), i);
        this.gvD.d(this.gvZ.getPageContext(), i);
        this.gvE.d(this.gvZ.getPageContext(), i);
        this.gvF.d(this.gvZ.getPageContext(), i);
        this.gvG.d(this.gvZ.getPageContext(), i);
        this.gvH.d(this.gvZ.getPageContext(), i);
        this.gvI.d(this.gvZ.getPageContext(), i);
        this.gvJ.d(this.gvZ.getPageContext(), i);
        this.gvK.d(this.gvZ.getPageContext(), i);
        this.gvL.d(this.gvZ.getPageContext(), i);
        this.gvM.d(this.gvZ.getPageContext(), i);
        this.gvP.d(this.gvZ.getPageContext(), i);
        al.i(this.gvQ, d.f.more_all);
        al.i(this.gvU, d.f.more_all);
        al.i(this.gvW, d.f.more_all);
        al.i(this.gvN, d.f.more_all);
        al.c((ImageView) this.gvQ.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gvN.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gvU.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gvW.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
