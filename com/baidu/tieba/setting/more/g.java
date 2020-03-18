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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes13.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private RelativeLayout htL;
    public boolean isFront;
    private MsgSettingItemView jVH;
    private LinearLayout jVI;
    private MsgSettingItemView jVJ;
    private MsgSettingItemView jVK;
    private MsgSettingItemView jVL;
    private MsgSettingItemView jVM;
    private MsgSettingItemView jVN;
    private MsgSettingItemView jVO;
    private MsgSettingItemView jVP;
    private MsgSettingItemView jVQ;
    private MsgSettingItemView jVR;
    private MsgSettingItemView jVS;
    private MsgSettingItemView jVT;
    private LinearLayout jVU;
    private TextView jVV;
    private MsgSettingItemView jVW;
    private LinearLayout jVX;
    private TextView jVY;
    private LinearLayout jVZ;
    private LinearLayout jWa;
    private LinearLayout jWb;
    private TextView jWc;
    private LinearLayout jWd;
    private TextView jWe;
    private MsgRemindActivity jWf;
    private TbSettingTextTipView jWg;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.htL = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jWf = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cGM();
        cGP();
        cGO();
        cGN();
        cGQ();
        d(msgRemindActivity);
        cGH();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.htL = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jVZ = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jWa = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jVH = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jVH.setText(R.string.receive_msg_text);
        this.jVH.setLineVisibility(false);
        this.jVI = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jVJ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jVJ.setText(R.string.reply);
        this.jVK = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jVK.setVisibility(0);
        this.jVK.setText(R.string.action_praise_default);
        this.jVL = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jVL.setText(R.string.mention_atme);
        this.jVM = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jVM.setText(R.string.new_fans);
        this.jVN = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jVN.setText(R.string.chat_msg_text);
        this.jVO = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jVO.setLineVisibility(false);
        this.jVO.setText(R.string.group_chat_text);
        this.jVP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jVP.setText(R.string.remind_screen_lock);
        this.jVP.setLineVisibility(false);
        this.jVQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jVQ.setText(R.string.remind_tone);
        this.jVR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jVR.setText(R.string.remind_vibrate);
        this.jVS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jVS.setLineVisibility(true);
        this.jVS.setText(R.string.remind_light);
        this.jVT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jVT.setText(R.string.sign_remind_outline);
        this.jVU = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jVV = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jVW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jVW.setText(R.string.no_disturb_mode);
        this.jVW.setLineVisibility(false);
        this.jVX = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jVY = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jWb = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jWc = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jWd = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jWe = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jWg = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cGH() {
        cGI();
        cGJ();
        cGK();
        cGL();
    }

    private void cGI() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jVW.setVisibility(8);
            this.jVX.setVisibility(8);
            this.jVH.setVisibility(8);
            this.jVI.setVisibility(8);
            this.jVT.setVisibility(8);
            this.jVU.setVisibility(8);
            this.jVQ.setVisibility(8);
            this.jVR.setVisibility(8);
            this.jVS.setVisibility(8);
            this.jVP.setVisibility(8);
        }
    }

    private void cGJ() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jVP.setLineVisibility(true);
        } else {
            this.jVP.setLineVisibility(false);
        }
    }

    private void cGK() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jVN.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jVO.setVisibility(0);
        } else {
            this.jVO.setVisibility(8);
        }
    }

    private void cGL() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jVP.setVisibility(0);
        } else {
            this.jVP.setVisibility(8);
        }
    }

    public View AH() {
        return this.mBack;
    }

    private void cGM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLs()) {
            this.jVH.turnOnNoCallback();
            this.jVI.setVisibility(0);
        } else {
            this.jVH.turnOffNoCallback();
            this.jVI.setVisibility(8);
        }
        this.jVJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLx());
        this.jVK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLH());
        this.jVL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLv());
        this.jVM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLw());
        this.jVN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLy());
        this.jVO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLG());
    }

    private void cGN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().isSignAlertOn()) {
            this.jVT.turnOn();
            this.jVU.setVisibility(0);
            this.jVT.setLineVisibility(true);
            cGR();
            return;
        }
        this.jVT.turnOff();
        this.jVT.setLineVisibility(false);
        this.jVU.setVisibility(8);
    }

    private void cGO() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLz()) {
            this.jVQ.turnOnNoCallback();
        } else {
            this.jVQ.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLC()) {
            this.jVR.turnOnNoCallback();
        } else {
            this.jVR.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLA()) {
            this.jVS.turnOnNoCallback();
        } else {
            this.jVS.turnOffNoCallback();
        }
    }

    private void cGP() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLI()) {
            this.jVP.turnOnNoCallback();
        } else {
            this.jVP.turnOffNoCallback();
        }
    }

    private void cGQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLB()) {
            this.jVW.turnOnNoCallback();
            this.jVX.setVisibility(0);
            cGS();
            return;
        }
        this.jVW.turnOffNoCallback();
        this.jVX.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jVH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVU.setOnClickListener(msgRemindActivity);
        this.jVW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jVX.setOnClickListener(msgRemindActivity);
        this.jWb.setOnClickListener(msgRemindActivity);
        this.jWd.setOnClickListener(msgRemindActivity);
        this.jWg.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sw(boolean z) {
        this.jVW.setLineVisibility(z);
        if (z) {
            this.jVX.setVisibility(0);
            cGS();
            am.setBackgroundResource(this.jVX, R.drawable.more_all);
            return;
        }
        this.jVX.setVisibility(8);
    }

    public void sx(boolean z) {
        if (z) {
            this.jVU.setVisibility(0);
            this.jVT.setLineVisibility(true);
            am.setBackgroundResource(this.jVU, R.drawable.more_all);
            return;
        }
        this.jVU.setVisibility(8);
        this.jVT.setLineVisibility(false);
    }

    public void sy(boolean z) {
        if (z) {
            this.jVI.setVisibility(0);
        } else {
            this.jVI.setVisibility(8);
        }
    }

    public void cGR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLq().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aLq().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aLq().getSignAlertMins();
            this.jVV.setText(this.jWf.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jVU.setVisibility(0);
            if (!this.jVT.isOn()) {
                this.jVT.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jVV.setText(R.string.close);
        this.jVU.setVisibility(8);
        if (this.jVT.isOn()) {
            this.jVT.turnOffNoCallback();
        }
    }

    public void cGS() {
        String aLD = com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLD();
        String aLE = com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLE();
        this.jVY.setText(aLD + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aLE);
        this.jWc.setText(aLD);
        this.jWe.setText(aLE);
    }

    public BdSwitchView cGT() {
        return this.jVT.getSwitchView();
    }

    public BdSwitchView cGU() {
        return this.jVH.getSwitchView();
    }

    public View cGV() {
        return this.jVU;
    }

    public BdSwitchView cGW() {
        return this.jVW.getSwitchView();
    }

    public View cGX() {
        return this.jVX;
    }

    public LinearLayout cGY() {
        return this.jWb;
    }

    public LinearLayout cGZ() {
        return this.jWd;
    }

    public BdSwitchView cHa() {
        return this.jVQ.getSwitchView();
    }

    public BdSwitchView cHb() {
        return this.jVR.getSwitchView();
    }

    public BdSwitchView cHc() {
        return this.jVS.getSwitchView();
    }

    public BdSwitchView cHd() {
        return this.jVP.getSwitchView();
    }

    public BdSwitchView cHe() {
        return this.jVJ.getSwitchView();
    }

    public BdSwitchView cHf() {
        return this.jVK.getSwitchView();
    }

    public BdSwitchView cHg() {
        return this.jVL.getSwitchView();
    }

    public BdSwitchView cHh() {
        return this.jVN.getSwitchView();
    }

    public BdSwitchView cHi() {
        return this.jVO.getSwitchView();
    }

    public BdSwitchView cHj() {
        return this.jVM.getSwitchView();
    }

    public TbSettingTextTipView cHk() {
        return this.jWg;
    }

    public TextView cHl() {
        return this.mNavigationBar.getCenterText();
    }

    public void cHm() {
        this.jVJ.setOnSwitchStateChangeListener(null);
        this.jVJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLx());
        this.jVJ.setOnSwitchStateChangeListener(this.jWf);
    }

    public void cHn() {
        this.jVK.setOnSwitchStateChangeListener(null);
        this.jVK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLH());
        this.jVK.setOnSwitchStateChangeListener(this.jWf);
    }

    public void cHo() {
        this.jVL.setOnSwitchStateChangeListener(null);
        this.jVL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLv());
        this.jVL.setOnSwitchStateChangeListener(this.jWf);
    }

    public void cHp() {
        this.jVM.setOnSwitchStateChangeListener(null);
        this.jVM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLw());
        this.jVM.setOnSwitchStateChangeListener(this.jWf);
    }

    public void cHq() {
        this.jVN.setOnSwitchStateChangeListener(null);
        this.jVN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLy());
        this.jVN.setOnSwitchStateChangeListener(this.jWf);
    }

    public void cHr() {
        this.jVO.setOnSwitchStateChangeListener(null);
        this.jVO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLG());
        this.jVO.setOnSwitchStateChangeListener(this.jWf);
    }

    public void sz(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jWf.getString(R.string.msg_remind));
                this.jVZ.setVisibility(0);
                this.jWa.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jWf.getString(R.string.no_disturb_mode_time));
            this.jWa.setVisibility(0);
            this.jVZ.setVisibility(8);
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
        this.jWf.getLayoutMode().setNightMode(i == 1);
        this.jWf.getLayoutMode().onModeChanged(this.htL);
        this.mNavigationBar.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVH.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVJ.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVK.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVL.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVM.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVN.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVO.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVP.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVQ.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVR.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVS.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVT.onChangeSkinType(this.jWf.getPageContext(), i);
        this.jVW.onChangeSkinType(this.jWf.getPageContext(), i);
        am.setBackgroundResource(this.jVX, R.drawable.more_all);
        am.setBackgroundResource(this.jWb, R.drawable.more_all);
        am.setBackgroundResource(this.jWd, R.drawable.more_all);
        am.setBackgroundResource(this.jVU, R.drawable.more_all);
        SvgManager.aGG().a((ImageView) this.jVX.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGG().a((ImageView) this.jVU.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGG().a((ImageView) this.jWb.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGG().a((ImageView) this.jWd.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cHs() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aLL().a(this.jWf.getActivity(), this.htL);
    }

    public void onDestroy() {
    }
}
