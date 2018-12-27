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
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aMW;
    private MsgSettingItemView haJ;
    private LinearLayout haK;
    private MsgSettingItemView haL;
    private MsgSettingItemView haM;
    private MsgSettingItemView haN;
    private MsgSettingItemView haO;
    private MsgSettingItemView haP;
    private MsgSettingItemView haQ;
    private MsgSettingItemView haR;
    private MsgSettingItemView haS;
    private MsgSettingItemView haT;
    private MsgSettingItemView haU;
    private MsgSettingItemView haV;
    private LinearLayout haW;
    private TextView haX;
    private MsgSettingItemView haY;
    private LinearLayout haZ;
    private TextView hba;
    private LinearLayout hbb;
    private LinearLayout hbc;
    private LinearLayout hbd;
    private TextView hbe;
    private LinearLayout hbf;
    private TextView hbg;
    public boolean hbh;
    private MsgRemindActivity hbi;
    private TbSettingTextTipView hbj;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.hbh = true;
        this.hbi = msgRemindActivity;
        msgRemindActivity.setContentView(e.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        byv();
        byy();
        byx();
        byw();
        byz();
        d(msgRemindActivity);
        byp();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(e.g.parent);
        msgRemindActivity.findViewById(e.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(e.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hbb = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.hbc = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.haJ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.haJ.setText(e.j.receive_msg_text);
        this.haJ.setLineVisibility(false);
        this.haK = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.haL = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.haL.setText(e.j.reply);
        this.haM = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.haM.setVisibility(0);
        this.haM.setText(e.j.action_praise_default);
        this.haN = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.haN.setText(e.j.mention_atme);
        this.haO = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.haO.setText(e.j.new_fans);
        this.haP = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.haP.setText(e.j.chat_msg_text);
        this.haQ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.haQ.setLineVisibility(false);
        this.haQ.setText(e.j.group_chat_text);
        this.haR = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.haR.setText(e.j.remind_screen_lock);
        this.haR.setLineVisibility(false);
        this.haS = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.haS.setText(e.j.remind_tone);
        this.haT = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.haT.setText(e.j.remind_vibrate);
        this.haU = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.haU.setLineVisibility(true);
        this.haU.setText(e.j.remind_light);
        this.haV = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.haV.setText(e.j.sign_remind_outline);
        this.haW = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.haX = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.haY = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.haY.setText(e.j.no_disturb_mode);
        this.haY.setLineVisibility(false);
        this.haZ = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.hba = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.hbd = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.hbe = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.hbf = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.hbg = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.hbj = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
    }

    private void byp() {
        byq();
        byr();
        bys();
        byt();
    }

    private void byq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.haY.setVisibility(8);
            this.haZ.setVisibility(8);
            this.haJ.setVisibility(8);
            this.haK.setVisibility(8);
            this.haV.setVisibility(8);
            this.haW.setVisibility(8);
            this.haS.setVisibility(8);
            this.haT.setVisibility(8);
            this.haU.setVisibility(8);
            this.haR.setVisibility(8);
        }
    }

    private void byr() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.haR.setLineVisibility(true);
        } else {
            this.haR.setLineVisibility(false);
        }
    }

    private void bys() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.haP.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.haQ.setVisibility(0);
        } else {
            this.haQ.setVisibility(8);
        }
    }

    private void byt() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.haR.setVisibility(0);
        } else {
            this.haR.setVisibility(8);
        }
    }

    public View byu() {
        return this.aMW;
    }

    private void byv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().Iz()) {
            this.haJ.nP();
            this.haK.setVisibility(0);
        } else {
            this.haJ.nQ();
            this.haK.setVisibility(8);
        }
        this.haL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IE());
        this.haM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IO());
        this.haN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IC());
        this.haO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ID());
        this.haP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IF());
        this.haQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IN());
    }

    private void byw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().isSignAlertOn()) {
            this.haV.nR();
            this.haW.setVisibility(0);
            this.haV.setLineVisibility(true);
            byA();
            return;
        }
        this.haV.nS();
        this.haV.setLineVisibility(false);
        this.haW.setVisibility(8);
    }

    private void byx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IG()) {
            this.haS.nP();
        } else {
            this.haS.nQ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IJ()) {
            this.haT.nP();
        } else {
            this.haT.nQ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IH()) {
            this.haU.nP();
        } else {
            this.haU.nQ();
        }
    }

    private void byy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IP()) {
            this.haR.nP();
        } else {
            this.haR.nQ();
        }
    }

    private void byz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().II()) {
            this.haY.nP();
            this.haZ.setVisibility(0);
            byB();
            return;
        }
        this.haY.nQ();
        this.haZ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aMW.setOnClickListener(msgRemindActivity);
        this.haJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haW.setOnClickListener(msgRemindActivity);
        this.haY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.haZ.setOnClickListener(msgRemindActivity);
        this.hbd.setOnClickListener(msgRemindActivity);
        this.hbf.setOnClickListener(msgRemindActivity);
        this.hbj.setOnClickListener(msgRemindActivity);
    }

    public void na(boolean z) {
        this.haY.setLineVisibility(z);
        if (z) {
            this.haZ.setVisibility(0);
            byB();
            al.i(this.haZ, e.f.more_all);
            return;
        }
        this.haZ.setVisibility(8);
    }

    public void nb(boolean z) {
        if (z) {
            this.haW.setVisibility(0);
            this.haV.setLineVisibility(true);
            al.i(this.haW, e.f.more_all);
            return;
        }
        this.haW.setVisibility(8);
        this.haV.setLineVisibility(false);
    }

    public void nc(boolean z) {
        if (z) {
            this.haK.setVisibility(0);
        } else {
            this.haK.setVisibility(8);
        }
    }

    public void byA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ix().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().getSignAlertMins();
            this.haX.setText(this.hbi.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.haW.setVisibility(0);
            if (!this.haV.jJ()) {
                this.haV.nP();
                return;
            }
            return;
        }
        this.haX.setText(e.j.close);
        this.haW.setVisibility(8);
        if (this.haV.jJ()) {
            this.haV.nQ();
        }
    }

    public void byB() {
        String IK = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IK();
        String IL = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IL();
        this.hba.setText(IK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + IL);
        this.hbe.setText(IK);
        this.hbg.setText(IL);
    }

    public BdSwitchView byC() {
        return this.haV.getSwitchView();
    }

    public BdSwitchView byD() {
        return this.haJ.getSwitchView();
    }

    public View byE() {
        return this.haW;
    }

    public BdSwitchView byF() {
        return this.haY.getSwitchView();
    }

    public View byG() {
        return this.haZ;
    }

    public LinearLayout byH() {
        return this.hbd;
    }

    public LinearLayout byI() {
        return this.hbf;
    }

    public BdSwitchView byJ() {
        return this.haS.getSwitchView();
    }

    public BdSwitchView byK() {
        return this.haT.getSwitchView();
    }

    public BdSwitchView byL() {
        return this.haU.getSwitchView();
    }

    public BdSwitchView byM() {
        return this.haR.getSwitchView();
    }

    public BdSwitchView byN() {
        return this.haL.getSwitchView();
    }

    public BdSwitchView byO() {
        return this.haM.getSwitchView();
    }

    public BdSwitchView byP() {
        return this.haN.getSwitchView();
    }

    public BdSwitchView byQ() {
        return this.haP.getSwitchView();
    }

    public BdSwitchView byR() {
        return this.haQ.getSwitchView();
    }

    public BdSwitchView byS() {
        return this.haO.getSwitchView();
    }

    public TbSettingTextTipView byT() {
        return this.hbj;
    }

    public void byU() {
        this.haL.setOnSwitchStateChangeListener(null);
        this.haL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IE());
        this.haL.setOnSwitchStateChangeListener(this.hbi);
    }

    public void byV() {
        this.haM.setOnSwitchStateChangeListener(null);
        this.haM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IO());
        this.haM.setOnSwitchStateChangeListener(this.hbi);
    }

    public void byW() {
        this.haN.setOnSwitchStateChangeListener(null);
        this.haN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IC());
        this.haN.setOnSwitchStateChangeListener(this.hbi);
    }

    public void byX() {
        this.haO.setOnSwitchStateChangeListener(null);
        this.haO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ID());
        this.haO.setOnSwitchStateChangeListener(this.hbi);
    }

    public void byY() {
        this.haP.setOnSwitchStateChangeListener(null);
        this.haP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IF());
        this.haP.setOnSwitchStateChangeListener(this.hbi);
    }

    public void byZ() {
        this.haQ.setOnSwitchStateChangeListener(null);
        this.haQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IN());
        this.haQ.setOnSwitchStateChangeListener(this.hbi);
    }

    public void nd(boolean z) {
        if (this.hbh != z) {
            this.hbh = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.hbi.getString(e.j.msg_remind));
                this.hbb.setVisibility(0);
                this.hbc.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.hbi.getString(e.j.no_disturb_mode_time));
            this.hbc.setVisibility(0);
            this.hbb.setVisibility(8);
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
        this.hbi.getLayoutMode().setNightMode(i == 1);
        this.hbi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hbi.getPageContext(), i);
        this.haJ.d(this.hbi.getPageContext(), i);
        this.haL.d(this.hbi.getPageContext(), i);
        this.haM.d(this.hbi.getPageContext(), i);
        this.haN.d(this.hbi.getPageContext(), i);
        this.haO.d(this.hbi.getPageContext(), i);
        this.haP.d(this.hbi.getPageContext(), i);
        this.haQ.d(this.hbi.getPageContext(), i);
        this.haR.d(this.hbi.getPageContext(), i);
        this.haS.d(this.hbi.getPageContext(), i);
        this.haT.d(this.hbi.getPageContext(), i);
        this.haU.d(this.hbi.getPageContext(), i);
        this.haV.d(this.hbi.getPageContext(), i);
        this.haY.d(this.hbi.getPageContext(), i);
        al.i(this.haZ, e.f.more_all);
        al.i(this.hbd, e.f.more_all);
        al.i(this.hbf, e.f.more_all);
        al.i(this.haW, e.f.more_all);
        al.c((ImageView) this.haZ.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.haW.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hbd.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hbf.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void bza() {
        com.baidu.tbadk.coreExtra.messageCenter.d.IS().b(this.hbi.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
