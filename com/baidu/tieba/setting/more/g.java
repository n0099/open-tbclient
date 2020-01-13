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
/* loaded from: classes11.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private RelativeLayout hpY;
    public boolean isFront;
    private MsgSettingItemView jSR;
    private LinearLayout jSS;
    private MsgSettingItemView jST;
    private MsgSettingItemView jSU;
    private MsgSettingItemView jSV;
    private MsgSettingItemView jSW;
    private MsgSettingItemView jSX;
    private MsgSettingItemView jSY;
    private MsgSettingItemView jSZ;
    private MsgSettingItemView jTa;
    private MsgSettingItemView jTb;
    private MsgSettingItemView jTc;
    private MsgSettingItemView jTd;
    private LinearLayout jTe;
    private TextView jTf;
    private MsgSettingItemView jTg;
    private LinearLayout jTh;
    private TextView jTi;
    private LinearLayout jTj;
    private LinearLayout jTk;
    private LinearLayout jTl;
    private TextView jTm;
    private LinearLayout jTn;
    private TextView jTo;
    private MsgRemindActivity jTp;
    private TbSettingTextTipView jTq;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hpY = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jTp = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cEM();
        cEP();
        cEO();
        cEN();
        cEQ();
        d(msgRemindActivity);
        cEH();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hpY = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jTj = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jTk = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jSR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jSR.setText(R.string.receive_msg_text);
        this.jSR.setLineVisibility(false);
        this.jSS = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jST = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jST.setText(R.string.reply);
        this.jSU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jSU.setVisibility(0);
        this.jSU.setText(R.string.action_praise_default);
        this.jSV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jSV.setText(R.string.mention_atme);
        this.jSW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jSW.setText(R.string.new_fans);
        this.jSX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jSX.setText(R.string.chat_msg_text);
        this.jSY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jSY.setLineVisibility(false);
        this.jSY.setText(R.string.group_chat_text);
        this.jSZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jSZ.setText(R.string.remind_screen_lock);
        this.jSZ.setLineVisibility(false);
        this.jTa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jTa.setText(R.string.remind_tone);
        this.jTb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jTb.setText(R.string.remind_vibrate);
        this.jTc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jTc.setLineVisibility(true);
        this.jTc.setText(R.string.remind_light);
        this.jTd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jTd.setText(R.string.sign_remind_outline);
        this.jTe = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jTf = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jTg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jTg.setText(R.string.no_disturb_mode);
        this.jTg.setLineVisibility(false);
        this.jTh = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jTi = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jTl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jTm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jTn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jTo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jTq = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cEH() {
        cEI();
        cEJ();
        cEK();
        cEL();
    }

    private void cEI() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jTg.setVisibility(8);
            this.jTh.setVisibility(8);
            this.jSR.setVisibility(8);
            this.jSS.setVisibility(8);
            this.jTd.setVisibility(8);
            this.jTe.setVisibility(8);
            this.jTa.setVisibility(8);
            this.jTb.setVisibility(8);
            this.jTc.setVisibility(8);
            this.jSZ.setVisibility(8);
        }
    }

    private void cEJ() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jSZ.setLineVisibility(true);
        } else {
            this.jSZ.setLineVisibility(false);
        }
    }

    private void cEK() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jSX.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jSY.setVisibility(0);
        } else {
            this.jSY.setVisibility(8);
        }
    }

    private void cEL() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jSZ.setVisibility(0);
        } else {
            this.jSZ.setVisibility(8);
        }
    }

    public View yh() {
        return this.mBack;
    }

    private void cEM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIS()) {
            this.jSR.turnOnNoCallback();
            this.jSS.setVisibility(0);
        } else {
            this.jSR.turnOffNoCallback();
            this.jSS.setVisibility(8);
        }
        this.jST.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIX());
        this.jSU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJh());
        this.jSV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIV());
        this.jSW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIW());
        this.jSX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIY());
        this.jSY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJg());
    }

    private void cEN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().isSignAlertOn()) {
            this.jTd.turnOn();
            this.jTe.setVisibility(0);
            this.jTd.setLineVisibility(true);
            cER();
            return;
        }
        this.jTd.turnOff();
        this.jTd.setLineVisibility(false);
        this.jTe.setVisibility(8);
    }

    private void cEO() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIZ()) {
            this.jTa.turnOnNoCallback();
        } else {
            this.jTa.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJc()) {
            this.jTb.turnOnNoCallback();
        } else {
            this.jTb.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJa()) {
            this.jTc.turnOnNoCallback();
        } else {
            this.jTc.turnOffNoCallback();
        }
    }

    private void cEP() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJi()) {
            this.jSZ.turnOnNoCallback();
        } else {
            this.jSZ.turnOffNoCallback();
        }
    }

    private void cEQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJb()) {
            this.jTg.turnOnNoCallback();
            this.jTh.setVisibility(0);
            cES();
            return;
        }
        this.jTg.turnOffNoCallback();
        this.jTh.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jSR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jST.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTe.setOnClickListener(msgRemindActivity);
        this.jTg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTh.setOnClickListener(msgRemindActivity);
        this.jTl.setOnClickListener(msgRemindActivity);
        this.jTn.setOnClickListener(msgRemindActivity);
        this.jTq.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sn(boolean z) {
        this.jTg.setLineVisibility(z);
        if (z) {
            this.jTh.setVisibility(0);
            cES();
            am.setBackgroundResource(this.jTh, R.drawable.more_all);
            return;
        }
        this.jTh.setVisibility(8);
    }

    public void so(boolean z) {
        if (z) {
            this.jTe.setVisibility(0);
            this.jTd.setLineVisibility(true);
            am.setBackgroundResource(this.jTe, R.drawable.more_all);
            return;
        }
        this.jTe.setVisibility(8);
        this.jTd.setLineVisibility(false);
    }

    public void sp(boolean z) {
        if (z) {
            this.jSS.setVisibility(0);
        } else {
            this.jSS.setVisibility(8);
        }
    }

    public void cER() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().getSignAlertMins();
            this.jTf.setText(this.jTp.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jTe.setVisibility(0);
            if (!this.jTd.isOn()) {
                this.jTd.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jTf.setText(R.string.close);
        this.jTe.setVisibility(8);
        if (this.jTd.isOn()) {
            this.jTd.turnOffNoCallback();
        }
    }

    public void cES() {
        String aJd = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJd();
        String aJe = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJe();
        this.jTi.setText(aJd + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aJe);
        this.jTm.setText(aJd);
        this.jTo.setText(aJe);
    }

    public BdSwitchView cET() {
        return this.jTd.getSwitchView();
    }

    public BdSwitchView cEU() {
        return this.jSR.getSwitchView();
    }

    public View cEV() {
        return this.jTe;
    }

    public BdSwitchView cEW() {
        return this.jTg.getSwitchView();
    }

    public View cEX() {
        return this.jTh;
    }

    public LinearLayout cEY() {
        return this.jTl;
    }

    public LinearLayout cEZ() {
        return this.jTn;
    }

    public BdSwitchView cFa() {
        return this.jTa.getSwitchView();
    }

    public BdSwitchView cFb() {
        return this.jTb.getSwitchView();
    }

    public BdSwitchView cFc() {
        return this.jTc.getSwitchView();
    }

    public BdSwitchView cFd() {
        return this.jSZ.getSwitchView();
    }

    public BdSwitchView cFe() {
        return this.jST.getSwitchView();
    }

    public BdSwitchView cFf() {
        return this.jSU.getSwitchView();
    }

    public BdSwitchView cFg() {
        return this.jSV.getSwitchView();
    }

    public BdSwitchView cFh() {
        return this.jSX.getSwitchView();
    }

    public BdSwitchView cFi() {
        return this.jSY.getSwitchView();
    }

    public BdSwitchView cFj() {
        return this.jSW.getSwitchView();
    }

    public TbSettingTextTipView cFk() {
        return this.jTq;
    }

    public TextView cFl() {
        return this.mNavigationBar.getCenterText();
    }

    public void cFm() {
        this.jST.setOnSwitchStateChangeListener(null);
        this.jST.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIX());
        this.jST.setOnSwitchStateChangeListener(this.jTp);
    }

    public void cFn() {
        this.jSU.setOnSwitchStateChangeListener(null);
        this.jSU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJh());
        this.jSU.setOnSwitchStateChangeListener(this.jTp);
    }

    public void cFo() {
        this.jSV.setOnSwitchStateChangeListener(null);
        this.jSV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIV());
        this.jSV.setOnSwitchStateChangeListener(this.jTp);
    }

    public void cFp() {
        this.jSW.setOnSwitchStateChangeListener(null);
        this.jSW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIW());
        this.jSW.setOnSwitchStateChangeListener(this.jTp);
    }

    public void cFq() {
        this.jSX.setOnSwitchStateChangeListener(null);
        this.jSX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIY());
        this.jSX.setOnSwitchStateChangeListener(this.jTp);
    }

    public void cFr() {
        this.jSY.setOnSwitchStateChangeListener(null);
        this.jSY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJg());
        this.jSY.setOnSwitchStateChangeListener(this.jTp);
    }

    public void sq(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jTp.getString(R.string.msg_remind));
                this.jTj.setVisibility(0);
                this.jTk.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jTp.getString(R.string.no_disturb_mode_time));
            this.jTk.setVisibility(0);
            this.jTj.setVisibility(8);
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
        this.jTp.getLayoutMode().setNightMode(i == 1);
        this.jTp.getLayoutMode().onModeChanged(this.hpY);
        this.mNavigationBar.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSR.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jST.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSU.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSV.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSW.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSX.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSY.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jSZ.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jTa.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jTb.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jTc.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jTd.onChangeSkinType(this.jTp.getPageContext(), i);
        this.jTg.onChangeSkinType(this.jTp.getPageContext(), i);
        am.setBackgroundResource(this.jTh, R.drawable.more_all);
        am.setBackgroundResource(this.jTl, R.drawable.more_all);
        am.setBackgroundResource(this.jTn, R.drawable.more_all);
        am.setBackgroundResource(this.jTe, R.drawable.more_all);
        SvgManager.aEp().a((ImageView) this.jTh.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a((ImageView) this.jTe.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a((ImageView) this.jTl.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a((ImageView) this.jTn.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cFs() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(this.jTp.getActivity(), this.hpY);
    }

    public void onDestroy() {
    }
}
