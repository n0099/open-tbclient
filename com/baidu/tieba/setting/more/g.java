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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes20.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private RelativeLayout iQn;
    private MsgSettingItemView lzA;
    private MsgSettingItemView lzB;
    private MsgSettingItemView lzC;
    private MsgSettingItemView lzD;
    private MsgSettingItemView lzE;
    private MsgSettingItemView lzF;
    private MsgSettingItemView lzG;
    private MsgSettingItemView lzH;
    private LinearLayout lzI;
    private TextView lzJ;
    private MsgSettingItemView lzK;
    private LinearLayout lzL;
    private TextView lzM;
    private LinearLayout lzN;
    private LinearLayout lzO;
    private LinearLayout lzP;
    private TextView lzQ;
    private LinearLayout lzR;
    private TextView lzS;
    public boolean lzT;
    private MsgRemindActivity lzU;
    private TbSettingTextTipView lzV;
    private MsgSettingItemView lzv;
    private LinearLayout lzw;
    private MsgSettingItemView lzx;
    private MsgSettingItemView lzy;
    private MsgSettingItemView lzz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iQn = null;
        this.mNavigationBar = null;
        this.lzT = true;
        this.lzU = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dfY();
        dgb();
        dga();
        dfZ();
        dgc();
        d(msgRemindActivity);
        dfT();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iQn = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lzN = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.lzO = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.lzv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.lzv.setText(R.string.receive_msg_text);
        this.lzv.setLineVisibility(false);
        this.lzw = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.lzx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.lzx.setText(R.string.reply);
        this.lzy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.lzy.setVisibility(0);
        this.lzy.setText(R.string.action_praise_default);
        this.lzz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.lzz.setText(R.string.mention_atme);
        this.lzA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.lzA.setText(R.string.new_fans);
        this.lzB = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.lzB.setText(R.string.chat_msg_text);
        this.lzC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.lzC.setLineVisibility(false);
        this.lzC.setText(R.string.group_chat_text);
        this.lzD = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.lzD.setText(R.string.remind_screen_lock);
        this.lzD.setLineVisibility(false);
        this.lzE = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.lzE.setText(R.string.remind_tone);
        this.lzF = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.lzF.setText(R.string.remind_vibrate);
        this.lzG = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.lzG.setLineVisibility(true);
        this.lzG.setText(R.string.remind_light);
        this.lzH = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.lzH.setText(R.string.sign_remind_outline);
        this.lzI = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.lzJ = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.lzK = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.lzK.setText(R.string.no_disturb_mode);
        this.lzK.setLineVisibility(false);
        this.lzL = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.lzM = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.lzP = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.lzQ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.lzR = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.lzS = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.lzV = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void dfT() {
        dfU();
        dfV();
        dfW();
        dfX();
    }

    private void dfU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lzK.setVisibility(8);
            this.lzL.setVisibility(8);
            this.lzv.setVisibility(8);
            this.lzw.setVisibility(8);
            this.lzH.setVisibility(8);
            this.lzI.setVisibility(8);
            this.lzE.setVisibility(8);
            this.lzF.setVisibility(8);
            this.lzG.setVisibility(8);
            this.lzD.setVisibility(8);
        }
    }

    private void dfV() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.lzD.setLineVisibility(true);
        } else {
            this.lzD.setLineVisibility(false);
        }
    }

    private void dfW() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.lzB.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.lzC.setVisibility(0);
        } else {
            this.lzC.setVisibility(8);
        }
    }

    private void dfX() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.lzD.setVisibility(0);
        } else {
            this.lzD.setVisibility(8);
        }
    }

    public View Jb() {
        return this.mBack;
    }

    private void dfY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfQ()) {
            this.lzv.turnOnNoCallback();
            this.lzw.setVisibility(0);
        } else {
            this.lzv.turnOffNoCallback();
            this.lzw.setVisibility(8);
        }
        this.lzx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfV());
        this.lzy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgf());
        this.lzz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfT());
        this.lzA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfU());
        this.lzB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfW());
        this.lzC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bge());
    }

    private void dfZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().isSignAlertOn()) {
            this.lzH.turnOn();
            this.lzI.setVisibility(0);
            this.lzH.setLineVisibility(true);
            dgd();
            return;
        }
        this.lzH.turnOff();
        this.lzH.setLineVisibility(false);
        this.lzI.setVisibility(8);
    }

    private void dga() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfX()) {
            this.lzE.turnOnNoCallback();
        } else {
            this.lzE.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bga()) {
            this.lzF.turnOnNoCallback();
        } else {
            this.lzF.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfY()) {
            this.lzG.turnOnNoCallback();
        } else {
            this.lzG.turnOffNoCallback();
        }
    }

    private void dgb() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgg()) {
            this.lzD.turnOnNoCallback();
        } else {
            this.lzD.turnOffNoCallback();
        }
    }

    private void dgc() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfZ()) {
            this.lzK.turnOnNoCallback();
            this.lzL.setVisibility(0);
            dge();
            return;
        }
        this.lzK.turnOffNoCallback();
        this.lzL.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.lzv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzI.setOnClickListener(msgRemindActivity);
        this.lzK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzL.setOnClickListener(msgRemindActivity);
        this.lzP.setOnClickListener(msgRemindActivity);
        this.lzR.setOnClickListener(msgRemindActivity);
        this.lzV.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void uO(boolean z) {
        this.lzK.setLineVisibility(z);
        if (z) {
            this.lzL.setVisibility(0);
            dge();
            ao.setBackgroundResource(this.lzL, R.drawable.more_all);
            return;
        }
        this.lzL.setVisibility(8);
    }

    public void uP(boolean z) {
        if (z) {
            this.lzI.setVisibility(0);
            this.lzH.setLineVisibility(true);
            ao.setBackgroundResource(this.lzI, R.drawable.more_all);
            return;
        }
        this.lzI.setVisibility(8);
        this.lzH.setLineVisibility(false);
    }

    public void uQ(boolean z) {
        if (z) {
            this.lzw.setVisibility(0);
        } else {
            this.lzw.setVisibility(8);
        }
    }

    public void dgd() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().getSignAlertMins();
            this.lzJ.setText(this.lzU.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.lzI.setVisibility(0);
            if (!this.lzH.isOn()) {
                this.lzH.turnOnNoCallback();
                return;
            }
            return;
        }
        this.lzJ.setText(R.string.close);
        this.lzI.setVisibility(8);
        if (this.lzH.isOn()) {
            this.lzH.turnOffNoCallback();
        }
    }

    public void dge() {
        String bgb = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgb();
        String bgc = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgc();
        this.lzM.setText(bgb + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bgc);
        this.lzQ.setText(bgb);
        this.lzS.setText(bgc);
    }

    public BdSwitchView dgf() {
        return this.lzH.getSwitchView();
    }

    public BdSwitchView dgg() {
        return this.lzv.getSwitchView();
    }

    public View dgh() {
        return this.lzI;
    }

    public BdSwitchView dgi() {
        return this.lzK.getSwitchView();
    }

    public View dgj() {
        return this.lzL;
    }

    public LinearLayout dgk() {
        return this.lzP;
    }

    public LinearLayout dgl() {
        return this.lzR;
    }

    public BdSwitchView dgm() {
        return this.lzE.getSwitchView();
    }

    public BdSwitchView dgn() {
        return this.lzF.getSwitchView();
    }

    public BdSwitchView dgo() {
        return this.lzG.getSwitchView();
    }

    public BdSwitchView dgp() {
        return this.lzD.getSwitchView();
    }

    public BdSwitchView dgq() {
        return this.lzx.getSwitchView();
    }

    public BdSwitchView dgr() {
        return this.lzy.getSwitchView();
    }

    public BdSwitchView dgs() {
        return this.lzz.getSwitchView();
    }

    public BdSwitchView dgt() {
        return this.lzB.getSwitchView();
    }

    public BdSwitchView dgu() {
        return this.lzC.getSwitchView();
    }

    public BdSwitchView dgv() {
        return this.lzA.getSwitchView();
    }

    public TbSettingTextTipView dgw() {
        return this.lzV;
    }

    public TextView dgx() {
        return this.mNavigationBar.getCenterText();
    }

    public void dgy() {
        this.lzx.setOnSwitchStateChangeListener(null);
        this.lzx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfV());
        this.lzx.setOnSwitchStateChangeListener(this.lzU);
    }

    public void dgz() {
        this.lzy.setOnSwitchStateChangeListener(null);
        this.lzy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgf());
        this.lzy.setOnSwitchStateChangeListener(this.lzU);
    }

    public void dgA() {
        this.lzz.setOnSwitchStateChangeListener(null);
        this.lzz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfT());
        this.lzz.setOnSwitchStateChangeListener(this.lzU);
    }

    public void dgB() {
        this.lzA.setOnSwitchStateChangeListener(null);
        this.lzA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfU());
        this.lzA.setOnSwitchStateChangeListener(this.lzU);
    }

    public void dgC() {
        this.lzB.setOnSwitchStateChangeListener(null);
        this.lzB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfW());
        this.lzB.setOnSwitchStateChangeListener(this.lzU);
    }

    public void dgD() {
        this.lzC.setOnSwitchStateChangeListener(null);
        this.lzC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bge());
        this.lzC.setOnSwitchStateChangeListener(this.lzU);
    }

    public void uR(boolean z) {
        if (this.lzT != z) {
            this.lzT = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.lzU.getString(R.string.msg_remind));
                this.lzN.setVisibility(0);
                this.lzO.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.lzU.getString(R.string.no_disturb_mode_time));
            this.lzO.setVisibility(0);
            this.lzN.setVisibility(8);
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
        this.lzU.getLayoutMode().setNightMode(i == 1);
        this.lzU.getLayoutMode().onModeChanged(this.iQn);
        this.mNavigationBar.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzv.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzx.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzy.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzz.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzA.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzB.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzC.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzD.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzE.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzF.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzG.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzH.onChangeSkinType(this.lzU.getPageContext(), i);
        this.lzK.onChangeSkinType(this.lzU.getPageContext(), i);
        ao.setBackgroundResource(this.lzL, R.drawable.more_all);
        ao.setBackgroundResource(this.lzP, R.drawable.more_all);
        ao.setBackgroundResource(this.lzR, R.drawable.more_all);
        ao.setBackgroundResource(this.lzI, R.drawable.more_all);
        SvgManager.baR().a((ImageView) this.lzL.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a((ImageView) this.lzI.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a((ImageView) this.lzP.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a((ImageView) this.lzR.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void dgE() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bgj().a(this.lzU.getActivity(), this.iQn);
    }

    public void onDestroy() {
    }
}
