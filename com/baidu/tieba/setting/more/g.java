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
    private RelativeLayout idE;
    private MsgSettingItemView kET;
    private LinearLayout kEU;
    private MsgSettingItemView kEV;
    private MsgSettingItemView kEW;
    private MsgSettingItemView kEX;
    private MsgSettingItemView kEY;
    private MsgSettingItemView kEZ;
    private MsgSettingItemView kFa;
    private MsgSettingItemView kFb;
    private MsgSettingItemView kFc;
    private MsgSettingItemView kFd;
    private MsgSettingItemView kFe;
    private MsgSettingItemView kFf;
    private LinearLayout kFg;
    private TextView kFh;
    private MsgSettingItemView kFi;
    private LinearLayout kFj;
    private TextView kFk;
    private LinearLayout kFl;
    private LinearLayout kFm;
    private LinearLayout kFn;
    private TextView kFo;
    private LinearLayout kFp;
    private TextView kFq;
    public boolean kFr;
    private MsgRemindActivity kFs;
    private TbSettingTextTipView kFt;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.idE = null;
        this.mNavigationBar = null;
        this.kFr = true;
        this.kFs = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cRh();
        cRk();
        cRj();
        cRi();
        cRl();
        d(msgRemindActivity);
        cRc();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.idE = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kFl = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.kFm = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.kET = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.kET.setText(R.string.receive_msg_text);
        this.kET.setLineVisibility(false);
        this.kEU = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.kEV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.kEV.setText(R.string.reply);
        this.kEW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.kEW.setVisibility(0);
        this.kEW.setText(R.string.action_praise_default);
        this.kEX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.kEX.setText(R.string.mention_atme);
        this.kEY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.kEY.setText(R.string.new_fans);
        this.kEZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.kEZ.setText(R.string.chat_msg_text);
        this.kFa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.kFa.setLineVisibility(false);
        this.kFa.setText(R.string.group_chat_text);
        this.kFb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.kFb.setText(R.string.remind_screen_lock);
        this.kFb.setLineVisibility(false);
        this.kFc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.kFc.setText(R.string.remind_tone);
        this.kFd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.kFd.setText(R.string.remind_vibrate);
        this.kFe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.kFe.setLineVisibility(true);
        this.kFe.setText(R.string.remind_light);
        this.kFf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.kFf.setText(R.string.sign_remind_outline);
        this.kFg = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.kFh = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.kFi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.kFi.setText(R.string.no_disturb_mode);
        this.kFi.setLineVisibility(false);
        this.kFj = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.kFk = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.kFn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.kFo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.kFp = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.kFq = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.kFt = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cRc() {
        cRd();
        cRe();
        cRf();
        cRg();
    }

    private void cRd() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kFi.setVisibility(8);
            this.kFj.setVisibility(8);
            this.kET.setVisibility(8);
            this.kEU.setVisibility(8);
            this.kFf.setVisibility(8);
            this.kFg.setVisibility(8);
            this.kFc.setVisibility(8);
            this.kFd.setVisibility(8);
            this.kFe.setVisibility(8);
            this.kFb.setVisibility(8);
        }
    }

    private void cRe() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.kFb.setLineVisibility(true);
        } else {
            this.kFb.setLineVisibility(false);
        }
    }

    private void cRf() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.kEZ.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.kFa.setVisibility(0);
        } else {
            this.kFa.setVisibility(8);
        }
    }

    private void cRg() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.kFb.setVisibility(0);
        } else {
            this.kFb.setVisibility(8);
        }
    }

    public View FE() {
        return this.mBack;
    }

    private void cRh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTN()) {
            this.kET.turnOnNoCallback();
            this.kEU.setVisibility(0);
        } else {
            this.kET.turnOffNoCallback();
            this.kEU.setVisibility(8);
        }
        this.kEV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTS());
        this.kEW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUc());
        this.kEX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTQ());
        this.kEY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTR());
        this.kEZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTT());
        this.kFa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUb());
    }

    private void cRi() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().isSignAlertOn()) {
            this.kFf.turnOn();
            this.kFg.setVisibility(0);
            this.kFf.setLineVisibility(true);
            cRm();
            return;
        }
        this.kFf.turnOff();
        this.kFf.setLineVisibility(false);
        this.kFg.setVisibility(8);
    }

    private void cRj() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTU()) {
            this.kFc.turnOnNoCallback();
        } else {
            this.kFc.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTX()) {
            this.kFd.turnOnNoCallback();
        } else {
            this.kFd.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTV()) {
            this.kFe.turnOnNoCallback();
        } else {
            this.kFe.turnOffNoCallback();
        }
    }

    private void cRk() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUd()) {
            this.kFb.turnOnNoCallback();
        } else {
            this.kFb.turnOffNoCallback();
        }
    }

    private void cRl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTW()) {
            this.kFi.turnOnNoCallback();
            this.kFj.setVisibility(0);
            cRn();
            return;
        }
        this.kFi.turnOffNoCallback();
        this.kFj.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.kET.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kEZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFg.setOnClickListener(msgRemindActivity);
        this.kFi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kFj.setOnClickListener(msgRemindActivity);
        this.kFn.setOnClickListener(msgRemindActivity);
        this.kFp.setOnClickListener(msgRemindActivity);
        this.kFt.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void tx(boolean z) {
        this.kFi.setLineVisibility(z);
        if (z) {
            this.kFj.setVisibility(0);
            cRn();
            am.setBackgroundResource(this.kFj, R.drawable.more_all);
            return;
        }
        this.kFj.setVisibility(8);
    }

    public void ty(boolean z) {
        if (z) {
            this.kFg.setVisibility(0);
            this.kFf.setLineVisibility(true);
            am.setBackgroundResource(this.kFg, R.drawable.more_all);
            return;
        }
        this.kFg.setVisibility(8);
        this.kFf.setLineVisibility(false);
    }

    public void tz(boolean z) {
        if (z) {
            this.kEU.setVisibility(0);
        } else {
            this.kEU.setVisibility(8);
        }
    }

    public void cRm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aTL().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aTL().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aTL().getSignAlertMins();
            this.kFh.setText(this.kFs.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.kFg.setVisibility(0);
            if (!this.kFf.isOn()) {
                this.kFf.turnOnNoCallback();
                return;
            }
            return;
        }
        this.kFh.setText(R.string.close);
        this.kFg.setVisibility(8);
        if (this.kFf.isOn()) {
            this.kFf.turnOffNoCallback();
        }
    }

    public void cRn() {
        String aTY = com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTY();
        String aTZ = com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTZ();
        this.kFk.setText(aTY + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aTZ);
        this.kFo.setText(aTY);
        this.kFq.setText(aTZ);
    }

    public BdSwitchView cRo() {
        return this.kFf.getSwitchView();
    }

    public BdSwitchView cRp() {
        return this.kET.getSwitchView();
    }

    public View cRq() {
        return this.kFg;
    }

    public BdSwitchView cRr() {
        return this.kFi.getSwitchView();
    }

    public View cRs() {
        return this.kFj;
    }

    public LinearLayout cRt() {
        return this.kFn;
    }

    public LinearLayout cRu() {
        return this.kFp;
    }

    public BdSwitchView cRv() {
        return this.kFc.getSwitchView();
    }

    public BdSwitchView cRw() {
        return this.kFd.getSwitchView();
    }

    public BdSwitchView cRx() {
        return this.kFe.getSwitchView();
    }

    public BdSwitchView cRy() {
        return this.kFb.getSwitchView();
    }

    public BdSwitchView cRz() {
        return this.kEV.getSwitchView();
    }

    public BdSwitchView cRA() {
        return this.kEW.getSwitchView();
    }

    public BdSwitchView cRB() {
        return this.kEX.getSwitchView();
    }

    public BdSwitchView cRC() {
        return this.kEZ.getSwitchView();
    }

    public BdSwitchView cRD() {
        return this.kFa.getSwitchView();
    }

    public BdSwitchView cRE() {
        return this.kEY.getSwitchView();
    }

    public TbSettingTextTipView cRF() {
        return this.kFt;
    }

    public TextView cRG() {
        return this.mNavigationBar.getCenterText();
    }

    public void cRH() {
        this.kEV.setOnSwitchStateChangeListener(null);
        this.kEV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTS());
        this.kEV.setOnSwitchStateChangeListener(this.kFs);
    }

    public void cRI() {
        this.kEW.setOnSwitchStateChangeListener(null);
        this.kEW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUc());
        this.kEW.setOnSwitchStateChangeListener(this.kFs);
    }

    public void cRJ() {
        this.kEX.setOnSwitchStateChangeListener(null);
        this.kEX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTQ());
        this.kEX.setOnSwitchStateChangeListener(this.kFs);
    }

    public void cRK() {
        this.kEY.setOnSwitchStateChangeListener(null);
        this.kEY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTR());
        this.kEY.setOnSwitchStateChangeListener(this.kFs);
    }

    public void cRL() {
        this.kEZ.setOnSwitchStateChangeListener(null);
        this.kEZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTT());
        this.kEZ.setOnSwitchStateChangeListener(this.kFs);
    }

    public void cRM() {
        this.kFa.setOnSwitchStateChangeListener(null);
        this.kFa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUb());
        this.kFa.setOnSwitchStateChangeListener(this.kFs);
    }

    public void tA(boolean z) {
        if (this.kFr != z) {
            this.kFr = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.kFs.getString(R.string.msg_remind));
                this.kFl.setVisibility(0);
                this.kFm.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.kFs.getString(R.string.no_disturb_mode_time));
            this.kFm.setVisibility(0);
            this.kFl.setVisibility(8);
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
        this.kFs.getLayoutMode().setNightMode(i == 1);
        this.kFs.getLayoutMode().onModeChanged(this.idE);
        this.mNavigationBar.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kET.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kEV.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kEW.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kEX.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kEY.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kEZ.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFa.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFb.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFc.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFd.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFe.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFf.onChangeSkinType(this.kFs.getPageContext(), i);
        this.kFi.onChangeSkinType(this.kFs.getPageContext(), i);
        am.setBackgroundResource(this.kFj, R.drawable.more_all);
        am.setBackgroundResource(this.kFn, R.drawable.more_all);
        am.setBackgroundResource(this.kFp, R.drawable.more_all);
        am.setBackgroundResource(this.kFg, R.drawable.more_all);
        SvgManager.aOR().a((ImageView) this.kFj.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOR().a((ImageView) this.kFg.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOR().a((ImageView) this.kFn.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aOR().a((ImageView) this.kFp.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cRN() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aUg().a(this.kFs.getActivity(), this.idE);
    }

    public void onDestroy() {
    }
}
