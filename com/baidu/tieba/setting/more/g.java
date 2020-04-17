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
    private RelativeLayout idy;
    private MsgSettingItemView kEP;
    private LinearLayout kEQ;
    private MsgSettingItemView kER;
    private MsgSettingItemView kES;
    private MsgSettingItemView kET;
    private MsgSettingItemView kEU;
    private MsgSettingItemView kEV;
    private MsgSettingItemView kEW;
    private MsgSettingItemView kEX;
    private MsgSettingItemView kEY;
    private MsgSettingItemView kEZ;
    private MsgSettingItemView kFa;
    private MsgSettingItemView kFb;
    private LinearLayout kFc;
    private TextView kFd;
    private MsgSettingItemView kFe;
    private LinearLayout kFf;
    private TextView kFg;
    private LinearLayout kFh;
    private LinearLayout kFi;
    private LinearLayout kFj;
    private TextView kFk;
    private LinearLayout kFl;
    private TextView kFm;
    public boolean kFn;
    private MsgRemindActivity kFo;
    private TbSettingTextTipView kFp;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.idy = null;
        this.mNavigationBar = null;
        this.kFn = true;
        this.kFo = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cRk();
        cRn();
        cRm();
        cRl();
        cRo();
        d(msgRemindActivity);
        cRf();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.idy = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFh = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.kFi = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.kEP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.kEP.setText(R.string.receive_msg_text);
        this.kEP.setLineVisibility(false);
        this.kEQ = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.kER = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.kER.setText(R.string.reply);
        this.kES = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.kES.setVisibility(0);
        this.kES.setText(R.string.action_praise_default);
        this.kET = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.kET.setText(R.string.mention_atme);
        this.kEU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.kEU.setText(R.string.new_fans);
        this.kEV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.kEV.setText(R.string.chat_msg_text);
        this.kEW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.kEW.setLineVisibility(false);
        this.kEW.setText(R.string.group_chat_text);
        this.kEX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.kEX.setText(R.string.remind_screen_lock);
        this.kEX.setLineVisibility(false);
        this.kEY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.kEY.setText(R.string.remind_tone);
        this.kEZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.kEZ.setText(R.string.remind_vibrate);
        this.kFa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.kFa.setLineVisibility(true);
        this.kFa.setText(R.string.remind_light);
        this.kFb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.kFb.setText(R.string.sign_remind_outline);
        this.kFc = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.kFd = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.kFe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.kFe.setText(R.string.no_disturb_mode);
        this.kFe.setLineVisibility(false);
        this.kFf = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.kFg = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.kFj = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.kFk = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.kFl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.kFm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.kFp = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cRf() {
        cRg();
        cRh();
        cRi();
        cRj();
    }

    private void cRg() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kFe.setVisibility(8);
            this.kFf.setVisibility(8);
            this.kEP.setVisibility(8);
            this.kEQ.setVisibility(8);
            this.kFb.setVisibility(8);
            this.kFc.setVisibility(8);
            this.kEY.setVisibility(8);
            this.kEZ.setVisibility(8);
            this.kFa.setVisibility(8);
            this.kEX.setVisibility(8);
        }
    }

    private void cRh() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.kEX.setLineVisibility(true);
        } else {
            this.kEX.setLineVisibility(false);
        }
    }

    private void cRi() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.kEV.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.kEW.setVisibility(0);
        } else {
            this.kEW.setVisibility(8);
        }
    }

    private void cRj() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.kEX.setVisibility(0);
        } else {
            this.kEX.setVisibility(8);
        }
    }

    public View FF() {
        return this.mBack;
    }

    private void cRk() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTP()) {
            this.kEP.turnOnNoCallback();
            this.kEQ.setVisibility(0);
        } else {
            this.kEP.turnOffNoCallback();
            this.kEQ.setVisibility(8);
        }
        this.kER.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTU());
        this.kES.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUe());
        this.kET.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTS());
        this.kEU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTT());
        this.kEV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTV());
        this.kEW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUd());
    }

    private void cRl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().isSignAlertOn()) {
            this.kFb.turnOn();
            this.kFc.setVisibility(0);
            this.kFb.setLineVisibility(true);
            cRp();
            return;
        }
        this.kFb.turnOff();
        this.kFb.setLineVisibility(false);
        this.kFc.setVisibility(8);
    }

    private void cRm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTW()) {
            this.kEY.turnOnNoCallback();
        } else {
            this.kEY.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTZ()) {
            this.kEZ.turnOnNoCallback();
        } else {
            this.kEZ.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTX()) {
            this.kFa.turnOnNoCallback();
        } else {
            this.kFa.turnOffNoCallback();
        }
    }

    private void cRn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUf()) {
            this.kEX.turnOnNoCallback();
        } else {
            this.kEX.turnOffNoCallback();
        }
    }

    private void cRo() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTY()) {
            this.kFe.turnOnNoCallback();
            this.kFf.setVisibility(0);
            cRq();
            return;
        }
        this.kFe.turnOffNoCallback();
        this.kFf.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.kEP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kER.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kET.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kES.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFc.setOnClickListener(msgRemindActivity);
        this.kFe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFf.setOnClickListener(msgRemindActivity);
        this.kFj.setOnClickListener(msgRemindActivity);
        this.kFl.setOnClickListener(msgRemindActivity);
        this.kFp.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void tx(boolean z) {
        this.kFe.setLineVisibility(z);
        if (z) {
            this.kFf.setVisibility(0);
            cRq();
            am.setBackgroundResource(this.kFf, R.drawable.more_all);
            return;
        }
        this.kFf.setVisibility(8);
    }

    public void ty(boolean z) {
        if (z) {
            this.kFc.setVisibility(0);
            this.kFb.setLineVisibility(true);
            am.setBackgroundResource(this.kFc, R.drawable.more_all);
            return;
        }
        this.kFc.setVisibility(8);
        this.kFb.setLineVisibility(false);
    }

    public void tz(boolean z) {
        if (z) {
            this.kEQ.setVisibility(0);
        } else {
            this.kEQ.setVisibility(8);
        }
    }

    public void cRp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTN().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aTN().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aTN().getSignAlertMins();
            this.kFd.setText(this.kFo.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.kFc.setVisibility(0);
            if (!this.kFb.isOn()) {
                this.kFb.turnOnNoCallback();
                return;
            }
            return;
        }
        this.kFd.setText(R.string.close);
        this.kFc.setVisibility(8);
        if (this.kFb.isOn()) {
            this.kFb.turnOffNoCallback();
        }
    }

    public void cRq() {
        String aUa = com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUa();
        String aUb = com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUb();
        this.kFg.setText(aUa + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aUb);
        this.kFk.setText(aUa);
        this.kFm.setText(aUb);
    }

    public BdSwitchView cRr() {
        return this.kFb.getSwitchView();
    }

    public BdSwitchView cRs() {
        return this.kEP.getSwitchView();
    }

    public View cRt() {
        return this.kFc;
    }

    public BdSwitchView cRu() {
        return this.kFe.getSwitchView();
    }

    public View cRv() {
        return this.kFf;
    }

    public LinearLayout cRw() {
        return this.kFj;
    }

    public LinearLayout cRx() {
        return this.kFl;
    }

    public BdSwitchView cRy() {
        return this.kEY.getSwitchView();
    }

    public BdSwitchView cRz() {
        return this.kEZ.getSwitchView();
    }

    public BdSwitchView cRA() {
        return this.kFa.getSwitchView();
    }

    public BdSwitchView cRB() {
        return this.kEX.getSwitchView();
    }

    public BdSwitchView cRC() {
        return this.kER.getSwitchView();
    }

    public BdSwitchView cRD() {
        return this.kES.getSwitchView();
    }

    public BdSwitchView cRE() {
        return this.kET.getSwitchView();
    }

    public BdSwitchView cRF() {
        return this.kEV.getSwitchView();
    }

    public BdSwitchView cRG() {
        return this.kEW.getSwitchView();
    }

    public BdSwitchView cRH() {
        return this.kEU.getSwitchView();
    }

    public TbSettingTextTipView cRI() {
        return this.kFp;
    }

    public TextView cRJ() {
        return this.mNavigationBar.getCenterText();
    }

    public void cRK() {
        this.kER.setOnSwitchStateChangeListener(null);
        this.kER.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTU());
        this.kER.setOnSwitchStateChangeListener(this.kFo);
    }

    public void cRL() {
        this.kES.setOnSwitchStateChangeListener(null);
        this.kES.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUe());
        this.kES.setOnSwitchStateChangeListener(this.kFo);
    }

    public void cRM() {
        this.kET.setOnSwitchStateChangeListener(null);
        this.kET.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTS());
        this.kET.setOnSwitchStateChangeListener(this.kFo);
    }

    public void cRN() {
        this.kEU.setOnSwitchStateChangeListener(null);
        this.kEU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTT());
        this.kEU.setOnSwitchStateChangeListener(this.kFo);
    }

    public void cRO() {
        this.kEV.setOnSwitchStateChangeListener(null);
        this.kEV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTV());
        this.kEV.setOnSwitchStateChangeListener(this.kFo);
    }

    public void cRP() {
        this.kEW.setOnSwitchStateChangeListener(null);
        this.kEW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUd());
        this.kEW.setOnSwitchStateChangeListener(this.kFo);
    }

    public void tA(boolean z) {
        if (this.kFn != z) {
            this.kFn = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.kFo.getString(R.string.msg_remind));
                this.kFh.setVisibility(0);
                this.kFi.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.kFo.getString(R.string.no_disturb_mode_time));
            this.kFi.setVisibility(0);
            this.kFh.setVisibility(8);
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
        this.kFo.getLayoutMode().setNightMode(i == 1);
        this.kFo.getLayoutMode().onModeChanged(this.idy);
        this.mNavigationBar.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEP.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kER.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kES.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kET.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEU.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEV.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEW.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEX.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEY.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kEZ.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kFa.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kFb.onChangeSkinType(this.kFo.getPageContext(), i);
        this.kFe.onChangeSkinType(this.kFo.getPageContext(), i);
        am.setBackgroundResource(this.kFf, R.drawable.more_all);
        am.setBackgroundResource(this.kFj, R.drawable.more_all);
        am.setBackgroundResource(this.kFl, R.drawable.more_all);
        am.setBackgroundResource(this.kFc, R.drawable.more_all);
        SvgManager.aOU().a((ImageView) this.kFf.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOU().a((ImageView) this.kFc.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOU().a((ImageView) this.kFj.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOU().a((ImageView) this.kFl.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cRQ() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aUi().a(this.kFo.getActivity(), this.idy);
    }

    public void onDestroy() {
    }
}
