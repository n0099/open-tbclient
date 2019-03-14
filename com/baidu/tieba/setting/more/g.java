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
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View bVZ;
    private LinearLayout itA;
    private MsgSettingItemView itB;
    private MsgSettingItemView itC;
    private MsgSettingItemView itD;
    private MsgSettingItemView itE;
    private MsgSettingItemView itF;
    private MsgSettingItemView itG;
    private MsgSettingItemView itH;
    private MsgSettingItemView itI;
    private MsgSettingItemView itJ;
    private MsgSettingItemView itK;
    private MsgSettingItemView itL;
    private LinearLayout itM;
    private TextView itN;
    private MsgSettingItemView itO;
    private LinearLayout itP;
    private TextView itQ;
    private LinearLayout itR;
    private LinearLayout itS;
    private LinearLayout itT;
    private TextView itU;
    private LinearLayout itV;
    private TextView itW;
    public boolean itX;
    private MsgRemindActivity itY;
    private TbSettingTextTipView itZ;
    private MsgSettingItemView itz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.itX = true;
        this.itY = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bZV();
        bZY();
        bZX();
        bZW();
        bZZ();
        d(msgRemindActivity);
        bZP();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.itR = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.itS = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.itz = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.itz.setText(d.j.receive_msg_text);
        this.itz.setLineVisibility(false);
        this.itA = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.itB = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.itB.setText(d.j.reply);
        this.itC = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.itC.setVisibility(0);
        this.itC.setText(d.j.action_praise_default);
        this.itD = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.itD.setText(d.j.mention_atme);
        this.itE = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.itE.setText(d.j.new_fans);
        this.itF = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.itF.setText(d.j.chat_msg_text);
        this.itG = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.itG.setLineVisibility(false);
        this.itG.setText(d.j.group_chat_text);
        this.itH = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.itH.setText(d.j.remind_screen_lock);
        this.itH.setLineVisibility(false);
        this.itI = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.itI.setText(d.j.remind_tone);
        this.itJ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.itJ.setText(d.j.remind_vibrate);
        this.itK = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.itK.setLineVisibility(true);
        this.itK.setText(d.j.remind_light);
        this.itL = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.itL.setText(d.j.sign_remind_outline);
        this.itM = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.itN = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.itO = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.itO.setText(d.j.no_disturb_mode);
        this.itO.setLineVisibility(false);
        this.itP = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.itQ = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.itT = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.itU = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.itV = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.itW = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.itZ = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bZP() {
        bZQ();
        bZR();
        bZS();
        bZT();
    }

    private void bZQ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.itO.setVisibility(8);
            this.itP.setVisibility(8);
            this.itz.setVisibility(8);
            this.itA.setVisibility(8);
            this.itL.setVisibility(8);
            this.itM.setVisibility(8);
            this.itI.setVisibility(8);
            this.itJ.setVisibility(8);
            this.itK.setVisibility(8);
            this.itH.setVisibility(8);
        }
    }

    private void bZR() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.itH.setLineVisibility(true);
        } else {
            this.itH.setLineVisibility(false);
        }
    }

    private void bZS() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.itF.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.itG.setVisibility(0);
        } else {
            this.itG.setVisibility(8);
        }
    }

    private void bZT() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.itH.setVisibility(0);
        } else {
            this.itH.setVisibility(8);
        }
    }

    public View bZU() {
        return this.bVZ;
    }

    private void bZV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aij()) {
            this.itz.nY();
            this.itA.setVisibility(0);
        } else {
            this.itz.nZ();
            this.itA.setVisibility(8);
        }
        this.itB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aio());
        this.itC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy());
        this.itD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim());
        this.itE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().ain());
        this.itF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip());
        this.itG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix());
    }

    private void bZW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().isSignAlertOn()) {
            this.itL.oa();
            this.itM.setVisibility(0);
            this.itL.setLineVisibility(true);
            caa();
            return;
        }
        this.itL.ob();
        this.itL.setLineVisibility(false);
        this.itM.setVisibility(8);
    }

    private void bZX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiq()) {
            this.itI.nY();
        } else {
            this.itI.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().ait()) {
            this.itJ.nY();
        } else {
            this.itJ.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().air()) {
            this.itK.nY();
        } else {
            this.itK.nZ();
        }
    }

    private void bZY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiz()) {
            this.itH.nY();
        } else {
            this.itH.nZ();
        }
    }

    private void bZZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().ais()) {
            this.itO.nY();
            this.itP.setVisibility(0);
            cab();
            return;
        }
        this.itO.nZ();
        this.itP.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bVZ.setOnClickListener(msgRemindActivity);
        this.itz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itM.setOnClickListener(msgRemindActivity);
        this.itO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itP.setOnClickListener(msgRemindActivity);
        this.itT.setOnClickListener(msgRemindActivity);
        this.itV.setOnClickListener(msgRemindActivity);
        this.itZ.setOnClickListener(msgRemindActivity);
    }

    public void pA(boolean z) {
        this.itO.setLineVisibility(z);
        if (z) {
            this.itP.setVisibility(0);
            cab();
            al.k(this.itP, d.f.more_all);
            return;
        }
        this.itP.setVisibility(8);
    }

    public void pB(boolean z) {
        if (z) {
            this.itM.setVisibility(0);
            this.itL.setLineVisibility(true);
            al.k(this.itM, d.f.more_all);
            return;
        }
        this.itM.setVisibility(8);
        this.itL.setLineVisibility(false);
    }

    public void pC(boolean z) {
        if (z) {
            this.itA.setVisibility(0);
        } else {
            this.itA.setVisibility(8);
        }
    }

    public void caa() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aih().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aih().getSignAlertMins();
            this.itN.setText(this.itY.getString(d.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.itM.setVisibility(0);
            if (!this.itL.jK()) {
                this.itL.nY();
                return;
            }
            return;
        }
        this.itN.setText(d.j.close);
        this.itM.setVisibility(8);
        if (this.itL.jK()) {
            this.itL.nZ();
        }
    }

    public void cab() {
        String aiu = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiu();
        String aiv = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiv();
        this.itQ.setText(aiu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aiv);
        this.itU.setText(aiu);
        this.itW.setText(aiv);
    }

    public BdSwitchView cac() {
        return this.itL.getSwitchView();
    }

    public BdSwitchView cad() {
        return this.itz.getSwitchView();
    }

    public View cae() {
        return this.itM;
    }

    public BdSwitchView caf() {
        return this.itO.getSwitchView();
    }

    public View cag() {
        return this.itP;
    }

    public LinearLayout cah() {
        return this.itT;
    }

    public LinearLayout cai() {
        return this.itV;
    }

    public BdSwitchView caj() {
        return this.itI.getSwitchView();
    }

    public BdSwitchView cak() {
        return this.itJ.getSwitchView();
    }

    public BdSwitchView cal() {
        return this.itK.getSwitchView();
    }

    public BdSwitchView cam() {
        return this.itH.getSwitchView();
    }

    public BdSwitchView can() {
        return this.itB.getSwitchView();
    }

    public BdSwitchView cao() {
        return this.itC.getSwitchView();
    }

    public BdSwitchView cap() {
        return this.itD.getSwitchView();
    }

    public BdSwitchView caq() {
        return this.itF.getSwitchView();
    }

    public BdSwitchView car() {
        return this.itG.getSwitchView();
    }

    public BdSwitchView cas() {
        return this.itE.getSwitchView();
    }

    public TbSettingTextTipView cat() {
        return this.itZ;
    }

    public void cau() {
        this.itB.setOnSwitchStateChangeListener(null);
        this.itB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aio());
        this.itB.setOnSwitchStateChangeListener(this.itY);
    }

    public void cav() {
        this.itC.setOnSwitchStateChangeListener(null);
        this.itC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy());
        this.itC.setOnSwitchStateChangeListener(this.itY);
    }

    public void caw() {
        this.itD.setOnSwitchStateChangeListener(null);
        this.itD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim());
        this.itD.setOnSwitchStateChangeListener(this.itY);
    }

    public void cax() {
        this.itE.setOnSwitchStateChangeListener(null);
        this.itE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().ain());
        this.itE.setOnSwitchStateChangeListener(this.itY);
    }

    public void cay() {
        this.itF.setOnSwitchStateChangeListener(null);
        this.itF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip());
        this.itF.setOnSwitchStateChangeListener(this.itY);
    }

    public void caz() {
        this.itG.setOnSwitchStateChangeListener(null);
        this.itG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix());
        this.itG.setOnSwitchStateChangeListener(this.itY);
    }

    public void pD(boolean z) {
        if (this.itX != z) {
            this.itX = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.itY.getString(d.j.msg_remind));
                this.itR.setVisibility(0);
                this.itS.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.itY.getString(d.j.no_disturb_mode_time));
            this.itS.setVisibility(0);
            this.itR.setVisibility(8);
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
        this.itY.getLayoutMode().setNightMode(i == 1);
        this.itY.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.itY.getPageContext(), i);
        this.itz.onChangeSkinType(this.itY.getPageContext(), i);
        this.itB.onChangeSkinType(this.itY.getPageContext(), i);
        this.itC.onChangeSkinType(this.itY.getPageContext(), i);
        this.itD.onChangeSkinType(this.itY.getPageContext(), i);
        this.itE.onChangeSkinType(this.itY.getPageContext(), i);
        this.itF.onChangeSkinType(this.itY.getPageContext(), i);
        this.itG.onChangeSkinType(this.itY.getPageContext(), i);
        this.itH.onChangeSkinType(this.itY.getPageContext(), i);
        this.itI.onChangeSkinType(this.itY.getPageContext(), i);
        this.itJ.onChangeSkinType(this.itY.getPageContext(), i);
        this.itK.onChangeSkinType(this.itY.getPageContext(), i);
        this.itL.onChangeSkinType(this.itY.getPageContext(), i);
        this.itO.onChangeSkinType(this.itY.getPageContext(), i);
        al.k(this.itP, d.f.more_all);
        al.k(this.itT, d.f.more_all);
        al.k(this.itV, d.f.more_all);
        al.k(this.itM, d.f.more_all);
        al.c((ImageView) this.itP.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itM.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itT.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itV.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }

    public void caA() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aiC().b(this.itY.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
