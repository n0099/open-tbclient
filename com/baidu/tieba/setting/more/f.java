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
import com.baidu.tieba.e;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aMU;
    private MsgSettingItemView gXF;
    private LinearLayout gXG;
    private MsgSettingItemView gXH;
    private MsgSettingItemView gXI;
    private MsgSettingItemView gXJ;
    private MsgSettingItemView gXK;
    private MsgSettingItemView gXL;
    private MsgSettingItemView gXM;
    private MsgSettingItemView gXN;
    private MsgSettingItemView gXO;
    private MsgSettingItemView gXP;
    private MsgSettingItemView gXQ;
    private MsgSettingItemView gXR;
    private LinearLayout gXS;
    private TextView gXT;
    private MsgSettingItemView gXU;
    private LinearLayout gXV;
    private TextView gXW;
    private LinearLayout gXX;
    private LinearLayout gXY;
    private LinearLayout gXZ;
    private TextView gYa;
    private LinearLayout gYb;
    private TextView gYc;
    public boolean gYd;
    private MsgRemindActivity gYe;
    private TbSettingTextTipView gYf;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gYd = true;
        this.gYe = msgRemindActivity;
        msgRemindActivity.setContentView(e.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bxF();
        bxI();
        bxH();
        bxG();
        bxJ();
        d(msgRemindActivity);
        bxz();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(e.g.parent);
        msgRemindActivity.findViewById(e.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(e.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gXX = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.gXY = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.gXF = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.gXF.setText(e.j.receive_msg_text);
        this.gXF.setLineVisibility(false);
        this.gXG = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.gXH = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.gXH.setText(e.j.reply);
        this.gXI = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.gXI.setVisibility(0);
        this.gXI.setText(e.j.action_praise_default);
        this.gXJ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.gXJ.setText(e.j.mention_atme);
        this.gXK = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.gXK.setText(e.j.new_fans);
        this.gXL = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.gXL.setText(e.j.chat_msg_text);
        this.gXM = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.gXM.setLineVisibility(false);
        this.gXM.setText(e.j.group_chat_text);
        this.gXN = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.gXN.setText(e.j.remind_screen_lock);
        this.gXN.setLineVisibility(false);
        this.gXO = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.gXO.setText(e.j.remind_tone);
        this.gXP = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.gXP.setText(e.j.remind_vibrate);
        this.gXQ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.gXQ.setLineVisibility(true);
        this.gXQ.setText(e.j.remind_light);
        this.gXR = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.gXR.setText(e.j.sign_remind_outline);
        this.gXS = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.gXT = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.gXU = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.gXU.setText(e.j.no_disturb_mode);
        this.gXU.setLineVisibility(false);
        this.gXV = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.gXW = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.gXZ = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.gYa = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.gYb = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.gYc = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.gYf = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
    }

    private void bxz() {
        bxA();
        bxB();
        bxC();
        bxD();
    }

    private void bxA() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gXU.setVisibility(8);
            this.gXV.setVisibility(8);
            this.gXF.setVisibility(8);
            this.gXG.setVisibility(8);
            this.gXR.setVisibility(8);
            this.gXS.setVisibility(8);
            this.gXO.setVisibility(8);
            this.gXP.setVisibility(8);
            this.gXQ.setVisibility(8);
            this.gXN.setVisibility(8);
        }
    }

    private void bxB() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gXN.setLineVisibility(true);
        } else {
            this.gXN.setLineVisibility(false);
        }
    }

    private void bxC() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gXL.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gXM.setVisibility(0);
        } else {
            this.gXM.setVisibility(8);
        }
    }

    private void bxD() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gXN.setVisibility(0);
        } else {
            this.gXN.setVisibility(8);
        }
    }

    public View bxE() {
        return this.aMU;
    }

    private void bxF() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().Iy()) {
            this.gXF.nP();
            this.gXG.setVisibility(0);
        } else {
            this.gXF.nQ();
            this.gXG.setVisibility(8);
        }
        this.gXH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().ID());
        this.gXI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IN());
        this.gXJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IB());
        this.gXK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IC());
        this.gXL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IE());
        this.gXM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IM());
    }

    private void bxG() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().isSignAlertOn()) {
            this.gXR.nR();
            this.gXS.setVisibility(0);
            this.gXR.setLineVisibility(true);
            bxK();
            return;
        }
        this.gXR.nS();
        this.gXR.setLineVisibility(false);
        this.gXS.setVisibility(8);
    }

    private void bxH() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IF()) {
            this.gXO.nP();
        } else {
            this.gXO.nQ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().II()) {
            this.gXP.nP();
        } else {
            this.gXP.nQ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IG()) {
            this.gXQ.nP();
        } else {
            this.gXQ.nQ();
        }
    }

    private void bxI() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IO()) {
            this.gXN.nP();
        } else {
            this.gXN.nQ();
        }
    }

    private void bxJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IH()) {
            this.gXU.nP();
            this.gXV.setVisibility(0);
            bxL();
            return;
        }
        this.gXU.nQ();
        this.gXV.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aMU.setOnClickListener(msgRemindActivity);
        this.gXF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXS.setOnClickListener(msgRemindActivity);
        this.gXU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gXV.setOnClickListener(msgRemindActivity);
        this.gXZ.setOnClickListener(msgRemindActivity);
        this.gYb.setOnClickListener(msgRemindActivity);
        this.gYf.setOnClickListener(msgRemindActivity);
    }

    public void mX(boolean z) {
        this.gXU.setLineVisibility(z);
        if (z) {
            this.gXV.setVisibility(0);
            bxL();
            al.i(this.gXV, e.f.more_all);
            return;
        }
        this.gXV.setVisibility(8);
    }

    public void mY(boolean z) {
        if (z) {
            this.gXS.setVisibility(0);
            this.gXR.setLineVisibility(true);
            al.i(this.gXS, e.f.more_all);
            return;
        }
        this.gXS.setVisibility(8);
        this.gXR.setLineVisibility(false);
    }

    public void mZ(boolean z) {
        if (z) {
            this.gXG.setVisibility(0);
        } else {
            this.gXG.setVisibility(8);
        }
    }

    public void bxK() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Iw().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.Iw().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.Iw().getSignAlertMins();
            this.gXT.setText(this.gYe.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.gXS.setVisibility(0);
            if (!this.gXR.jJ()) {
                this.gXR.nP();
                return;
            }
            return;
        }
        this.gXT.setText(e.j.close);
        this.gXS.setVisibility(8);
        if (this.gXR.jJ()) {
            this.gXR.nQ();
        }
    }

    public void bxL() {
        String IJ = com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IJ();
        String IK = com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IK();
        this.gXW.setText(IJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + IK);
        this.gYa.setText(IJ);
        this.gYc.setText(IK);
    }

    public BdSwitchView bxM() {
        return this.gXR.getSwitchView();
    }

    public BdSwitchView bxN() {
        return this.gXF.getSwitchView();
    }

    public View bxO() {
        return this.gXS;
    }

    public BdSwitchView bxP() {
        return this.gXU.getSwitchView();
    }

    public View bxQ() {
        return this.gXV;
    }

    public LinearLayout bxR() {
        return this.gXZ;
    }

    public LinearLayout bxS() {
        return this.gYb;
    }

    public BdSwitchView bxT() {
        return this.gXO.getSwitchView();
    }

    public BdSwitchView bxU() {
        return this.gXP.getSwitchView();
    }

    public BdSwitchView bxV() {
        return this.gXQ.getSwitchView();
    }

    public BdSwitchView bxW() {
        return this.gXN.getSwitchView();
    }

    public BdSwitchView bxX() {
        return this.gXH.getSwitchView();
    }

    public BdSwitchView bxY() {
        return this.gXI.getSwitchView();
    }

    public BdSwitchView bxZ() {
        return this.gXJ.getSwitchView();
    }

    public BdSwitchView bya() {
        return this.gXL.getSwitchView();
    }

    public BdSwitchView byb() {
        return this.gXM.getSwitchView();
    }

    public BdSwitchView byc() {
        return this.gXK.getSwitchView();
    }

    public TbSettingTextTipView byd() {
        return this.gYf;
    }

    public void bye() {
        this.gXH.setOnSwitchStateChangeListener(null);
        this.gXH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().ID());
        this.gXH.setOnSwitchStateChangeListener(this.gYe);
    }

    public void byf() {
        this.gXI.setOnSwitchStateChangeListener(null);
        this.gXI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IN());
        this.gXI.setOnSwitchStateChangeListener(this.gYe);
    }

    public void byg() {
        this.gXJ.setOnSwitchStateChangeListener(null);
        this.gXJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IB());
        this.gXJ.setOnSwitchStateChangeListener(this.gYe);
    }

    public void byh() {
        this.gXK.setOnSwitchStateChangeListener(null);
        this.gXK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IC());
        this.gXK.setOnSwitchStateChangeListener(this.gYe);
    }

    public void byi() {
        this.gXL.setOnSwitchStateChangeListener(null);
        this.gXL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IE());
        this.gXL.setOnSwitchStateChangeListener(this.gYe);
    }

    public void byj() {
        this.gXM.setOnSwitchStateChangeListener(null);
        this.gXM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IM());
        this.gXM.setOnSwitchStateChangeListener(this.gYe);
    }

    public void na(boolean z) {
        if (this.gYd != z) {
            this.gYd = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gYe.getString(e.j.msg_remind));
                this.gXX.setVisibility(0);
                this.gXY.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gYe.getString(e.j.no_disturb_mode_time));
            this.gXY.setVisibility(0);
            this.gXX.setVisibility(8);
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
        this.gYe.getLayoutMode().setNightMode(i == 1);
        this.gYe.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gYe.getPageContext(), i);
        this.gXF.d(this.gYe.getPageContext(), i);
        this.gXH.d(this.gYe.getPageContext(), i);
        this.gXI.d(this.gYe.getPageContext(), i);
        this.gXJ.d(this.gYe.getPageContext(), i);
        this.gXK.d(this.gYe.getPageContext(), i);
        this.gXL.d(this.gYe.getPageContext(), i);
        this.gXM.d(this.gYe.getPageContext(), i);
        this.gXN.d(this.gYe.getPageContext(), i);
        this.gXO.d(this.gYe.getPageContext(), i);
        this.gXP.d(this.gYe.getPageContext(), i);
        this.gXQ.d(this.gYe.getPageContext(), i);
        this.gXR.d(this.gYe.getPageContext(), i);
        this.gXU.d(this.gYe.getPageContext(), i);
        al.i(this.gXV, e.f.more_all);
        al.i(this.gXZ, e.f.more_all);
        al.i(this.gYb, e.f.more_all);
        al.i(this.gXS, e.f.more_all);
        al.c((ImageView) this.gXV.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gXS.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gXZ.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gYb.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void byk() {
        com.baidu.tbadk.coreExtra.messageCenter.d.IR().b(this.gYe.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
