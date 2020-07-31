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
    private RelativeLayout iQl;
    private MsgSettingItemView lzA;
    private MsgSettingItemView lzB;
    private MsgSettingItemView lzC;
    private MsgSettingItemView lzD;
    private MsgSettingItemView lzE;
    private MsgSettingItemView lzF;
    private LinearLayout lzG;
    private TextView lzH;
    private MsgSettingItemView lzI;
    private LinearLayout lzJ;
    private TextView lzK;
    private LinearLayout lzL;
    private LinearLayout lzM;
    private LinearLayout lzN;
    private TextView lzO;
    private LinearLayout lzP;
    private TextView lzQ;
    public boolean lzR;
    private MsgRemindActivity lzS;
    private TbSettingTextTipView lzT;
    private MsgSettingItemView lzt;
    private LinearLayout lzu;
    private MsgSettingItemView lzv;
    private MsgSettingItemView lzw;
    private MsgSettingItemView lzx;
    private MsgSettingItemView lzy;
    private MsgSettingItemView lzz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iQl = null;
        this.mNavigationBar = null;
        this.lzR = true;
        this.lzS = msgRemindActivity;
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
        this.iQl = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lzL = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.lzM = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.lzt = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.lzt.setText(R.string.receive_msg_text);
        this.lzt.setLineVisibility(false);
        this.lzu = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.lzv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.lzv.setText(R.string.reply);
        this.lzw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.lzw.setVisibility(0);
        this.lzw.setText(R.string.action_praise_default);
        this.lzx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.lzx.setText(R.string.mention_atme);
        this.lzy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.lzy.setText(R.string.new_fans);
        this.lzz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.lzz.setText(R.string.chat_msg_text);
        this.lzA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.lzA.setLineVisibility(false);
        this.lzA.setText(R.string.group_chat_text);
        this.lzB = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.lzB.setText(R.string.remind_screen_lock);
        this.lzB.setLineVisibility(false);
        this.lzC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.lzC.setText(R.string.remind_tone);
        this.lzD = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.lzD.setText(R.string.remind_vibrate);
        this.lzE = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.lzE.setLineVisibility(true);
        this.lzE.setText(R.string.remind_light);
        this.lzF = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.lzF.setText(R.string.sign_remind_outline);
        this.lzG = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.lzH = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.lzI = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.lzI.setText(R.string.no_disturb_mode);
        this.lzI.setLineVisibility(false);
        this.lzJ = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.lzK = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.lzN = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.lzO = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.lzP = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.lzQ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.lzT = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
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
            this.lzI.setVisibility(8);
            this.lzJ.setVisibility(8);
            this.lzt.setVisibility(8);
            this.lzu.setVisibility(8);
            this.lzF.setVisibility(8);
            this.lzG.setVisibility(8);
            this.lzC.setVisibility(8);
            this.lzD.setVisibility(8);
            this.lzE.setVisibility(8);
            this.lzB.setVisibility(8);
        }
    }

    private void dfV() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.lzB.setLineVisibility(true);
        } else {
            this.lzB.setLineVisibility(false);
        }
    }

    private void dfW() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.lzz.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.lzA.setVisibility(0);
        } else {
            this.lzA.setVisibility(8);
        }
    }

    private void dfX() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.lzB.setVisibility(0);
        } else {
            this.lzB.setVisibility(8);
        }
    }

    public View Jb() {
        return this.mBack;
    }

    private void dfY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfQ()) {
            this.lzt.turnOnNoCallback();
            this.lzu.setVisibility(0);
        } else {
            this.lzt.turnOffNoCallback();
            this.lzu.setVisibility(8);
        }
        this.lzv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfV());
        this.lzw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgf());
        this.lzx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfT());
        this.lzy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfU());
        this.lzz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfW());
        this.lzA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bge());
    }

    private void dfZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().isSignAlertOn()) {
            this.lzF.turnOn();
            this.lzG.setVisibility(0);
            this.lzF.setLineVisibility(true);
            dgd();
            return;
        }
        this.lzF.turnOff();
        this.lzF.setLineVisibility(false);
        this.lzG.setVisibility(8);
    }

    private void dga() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfX()) {
            this.lzC.turnOnNoCallback();
        } else {
            this.lzC.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bga()) {
            this.lzD.turnOnNoCallback();
        } else {
            this.lzD.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfY()) {
            this.lzE.turnOnNoCallback();
        } else {
            this.lzE.turnOffNoCallback();
        }
    }

    private void dgb() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgg()) {
            this.lzB.turnOnNoCallback();
        } else {
            this.lzB.turnOffNoCallback();
        }
    }

    private void dgc() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfZ()) {
            this.lzI.turnOnNoCallback();
            this.lzJ.setVisibility(0);
            dge();
            return;
        }
        this.lzI.turnOffNoCallback();
        this.lzJ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.lzt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzG.setOnClickListener(msgRemindActivity);
        this.lzI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lzJ.setOnClickListener(msgRemindActivity);
        this.lzN.setOnClickListener(msgRemindActivity);
        this.lzP.setOnClickListener(msgRemindActivity);
        this.lzT.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void uO(boolean z) {
        this.lzI.setLineVisibility(z);
        if (z) {
            this.lzJ.setVisibility(0);
            dge();
            ao.setBackgroundResource(this.lzJ, R.drawable.more_all);
            return;
        }
        this.lzJ.setVisibility(8);
    }

    public void uP(boolean z) {
        if (z) {
            this.lzG.setVisibility(0);
            this.lzF.setLineVisibility(true);
            ao.setBackgroundResource(this.lzG, R.drawable.more_all);
            return;
        }
        this.lzG.setVisibility(8);
        this.lzF.setLineVisibility(false);
    }

    public void uQ(boolean z) {
        if (z) {
            this.lzu.setVisibility(0);
        } else {
            this.lzu.setVisibility(8);
        }
    }

    public void dgd() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bfO().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().getSignAlertMins();
            this.lzH.setText(this.lzS.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.lzG.setVisibility(0);
            if (!this.lzF.isOn()) {
                this.lzF.turnOnNoCallback();
                return;
            }
            return;
        }
        this.lzH.setText(R.string.close);
        this.lzG.setVisibility(8);
        if (this.lzF.isOn()) {
            this.lzF.turnOffNoCallback();
        }
    }

    public void dge() {
        String bgb = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgb();
        String bgc = com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgc();
        this.lzK.setText(bgb + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bgc);
        this.lzO.setText(bgb);
        this.lzQ.setText(bgc);
    }

    public BdSwitchView dgf() {
        return this.lzF.getSwitchView();
    }

    public BdSwitchView dgg() {
        return this.lzt.getSwitchView();
    }

    public View dgh() {
        return this.lzG;
    }

    public BdSwitchView dgi() {
        return this.lzI.getSwitchView();
    }

    public View dgj() {
        return this.lzJ;
    }

    public LinearLayout dgk() {
        return this.lzN;
    }

    public LinearLayout dgl() {
        return this.lzP;
    }

    public BdSwitchView dgm() {
        return this.lzC.getSwitchView();
    }

    public BdSwitchView dgn() {
        return this.lzD.getSwitchView();
    }

    public BdSwitchView dgo() {
        return this.lzE.getSwitchView();
    }

    public BdSwitchView dgp() {
        return this.lzB.getSwitchView();
    }

    public BdSwitchView dgq() {
        return this.lzv.getSwitchView();
    }

    public BdSwitchView dgr() {
        return this.lzw.getSwitchView();
    }

    public BdSwitchView dgs() {
        return this.lzx.getSwitchView();
    }

    public BdSwitchView dgt() {
        return this.lzz.getSwitchView();
    }

    public BdSwitchView dgu() {
        return this.lzA.getSwitchView();
    }

    public BdSwitchView dgv() {
        return this.lzy.getSwitchView();
    }

    public TbSettingTextTipView dgw() {
        return this.lzT;
    }

    public TextView dgx() {
        return this.mNavigationBar.getCenterText();
    }

    public void dgy() {
        this.lzv.setOnSwitchStateChangeListener(null);
        this.lzv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfV());
        this.lzv.setOnSwitchStateChangeListener(this.lzS);
    }

    public void dgz() {
        this.lzw.setOnSwitchStateChangeListener(null);
        this.lzw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgf());
        this.lzw.setOnSwitchStateChangeListener(this.lzS);
    }

    public void dgA() {
        this.lzx.setOnSwitchStateChangeListener(null);
        this.lzx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfT());
        this.lzx.setOnSwitchStateChangeListener(this.lzS);
    }

    public void dgB() {
        this.lzy.setOnSwitchStateChangeListener(null);
        this.lzy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfU());
        this.lzy.setOnSwitchStateChangeListener(this.lzS);
    }

    public void dgC() {
        this.lzz.setOnSwitchStateChangeListener(null);
        this.lzz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bfW());
        this.lzz.setOnSwitchStateChangeListener(this.lzS);
    }

    public void dgD() {
        this.lzA.setOnSwitchStateChangeListener(null);
        this.lzA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bge());
        this.lzA.setOnSwitchStateChangeListener(this.lzS);
    }

    public void uR(boolean z) {
        if (this.lzR != z) {
            this.lzR = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.lzS.getString(R.string.msg_remind));
                this.lzL.setVisibility(0);
                this.lzM.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.lzS.getString(R.string.no_disturb_mode_time));
            this.lzM.setVisibility(0);
            this.lzL.setVisibility(8);
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
        this.lzS.getLayoutMode().setNightMode(i == 1);
        this.lzS.getLayoutMode().onModeChanged(this.iQl);
        this.mNavigationBar.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzt.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzv.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzw.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzx.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzy.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzz.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzA.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzB.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzC.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzD.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzE.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzF.onChangeSkinType(this.lzS.getPageContext(), i);
        this.lzI.onChangeSkinType(this.lzS.getPageContext(), i);
        ao.setBackgroundResource(this.lzJ, R.drawable.more_all);
        ao.setBackgroundResource(this.lzN, R.drawable.more_all);
        ao.setBackgroundResource(this.lzP, R.drawable.more_all);
        ao.setBackgroundResource(this.lzG, R.drawable.more_all);
        SvgManager.baR().a((ImageView) this.lzJ.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a((ImageView) this.lzG.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a((ImageView) this.lzN.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.baR().a((ImageView) this.lzP.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void dgE() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bgj().a(this.lzS.getActivity(), this.iQl);
    }

    public void onDestroy() {
    }
}
