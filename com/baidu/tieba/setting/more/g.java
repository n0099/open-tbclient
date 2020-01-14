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
    private MsgSettingItemView jSW;
    private LinearLayout jSX;
    private MsgSettingItemView jSY;
    private MsgSettingItemView jSZ;
    private MsgSettingItemView jTa;
    private MsgSettingItemView jTb;
    private MsgSettingItemView jTc;
    private MsgSettingItemView jTd;
    private MsgSettingItemView jTe;
    private MsgSettingItemView jTf;
    private MsgSettingItemView jTg;
    private MsgSettingItemView jTh;
    private MsgSettingItemView jTi;
    private LinearLayout jTj;
    private TextView jTk;
    private MsgSettingItemView jTl;
    private LinearLayout jTm;
    private TextView jTn;
    private LinearLayout jTo;
    private LinearLayout jTp;
    private LinearLayout jTq;
    private TextView jTr;
    private LinearLayout jTs;
    private TextView jTt;
    private MsgRemindActivity jTu;
    private TbSettingTextTipView jTv;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hpY = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jTu = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cEO();
        cER();
        cEQ();
        cEP();
        cES();
        d(msgRemindActivity);
        cEJ();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hpY = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jTo = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jTp = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jSW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jSW.setText(R.string.receive_msg_text);
        this.jSW.setLineVisibility(false);
        this.jSX = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jSY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jSY.setText(R.string.reply);
        this.jSZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jSZ.setVisibility(0);
        this.jSZ.setText(R.string.action_praise_default);
        this.jTa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jTa.setText(R.string.mention_atme);
        this.jTb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jTb.setText(R.string.new_fans);
        this.jTc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jTc.setText(R.string.chat_msg_text);
        this.jTd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jTd.setLineVisibility(false);
        this.jTd.setText(R.string.group_chat_text);
        this.jTe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jTe.setText(R.string.remind_screen_lock);
        this.jTe.setLineVisibility(false);
        this.jTf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jTf.setText(R.string.remind_tone);
        this.jTg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jTg.setText(R.string.remind_vibrate);
        this.jTh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jTh.setLineVisibility(true);
        this.jTh.setText(R.string.remind_light);
        this.jTi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jTi.setText(R.string.sign_remind_outline);
        this.jTj = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jTk = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jTl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jTl.setText(R.string.no_disturb_mode);
        this.jTl.setLineVisibility(false);
        this.jTm = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jTn = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jTq = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jTr = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jTs = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jTt = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jTv = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cEJ() {
        cEK();
        cEL();
        cEM();
        cEN();
    }

    private void cEK() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jTl.setVisibility(8);
            this.jTm.setVisibility(8);
            this.jSW.setVisibility(8);
            this.jSX.setVisibility(8);
            this.jTi.setVisibility(8);
            this.jTj.setVisibility(8);
            this.jTf.setVisibility(8);
            this.jTg.setVisibility(8);
            this.jTh.setVisibility(8);
            this.jTe.setVisibility(8);
        }
    }

    private void cEL() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jTe.setLineVisibility(true);
        } else {
            this.jTe.setLineVisibility(false);
        }
    }

    private void cEM() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jTc.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jTd.setVisibility(0);
        } else {
            this.jTd.setVisibility(8);
        }
    }

    private void cEN() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jTe.setVisibility(0);
        } else {
            this.jTe.setVisibility(8);
        }
    }

    public View yh() {
        return this.mBack;
    }

    private void cEO() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIS()) {
            this.jSW.turnOnNoCallback();
            this.jSX.setVisibility(0);
        } else {
            this.jSW.turnOffNoCallback();
            this.jSX.setVisibility(8);
        }
        this.jSY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIX());
        this.jSZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJh());
        this.jTa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIV());
        this.jTb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIW());
        this.jTc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIY());
        this.jTd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJg());
    }

    private void cEP() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().isSignAlertOn()) {
            this.jTi.turnOn();
            this.jTj.setVisibility(0);
            this.jTi.setLineVisibility(true);
            cET();
            return;
        }
        this.jTi.turnOff();
        this.jTi.setLineVisibility(false);
        this.jTj.setVisibility(8);
    }

    private void cEQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIZ()) {
            this.jTf.turnOnNoCallback();
        } else {
            this.jTf.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJc()) {
            this.jTg.turnOnNoCallback();
        } else {
            this.jTg.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJa()) {
            this.jTh.turnOnNoCallback();
        } else {
            this.jTh.turnOffNoCallback();
        }
    }

    private void cER() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJi()) {
            this.jTe.turnOnNoCallback();
        } else {
            this.jTe.turnOffNoCallback();
        }
    }

    private void cES() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJb()) {
            this.jTl.turnOnNoCallback();
            this.jTm.setVisibility(0);
            cEU();
            return;
        }
        this.jTl.turnOffNoCallback();
        this.jTm.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jSW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jSZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTj.setOnClickListener(msgRemindActivity);
        this.jTl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTm.setOnClickListener(msgRemindActivity);
        this.jTq.setOnClickListener(msgRemindActivity);
        this.jTs.setOnClickListener(msgRemindActivity);
        this.jTv.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sn(boolean z) {
        this.jTl.setLineVisibility(z);
        if (z) {
            this.jTm.setVisibility(0);
            cEU();
            am.setBackgroundResource(this.jTm, R.drawable.more_all);
            return;
        }
        this.jTm.setVisibility(8);
    }

    public void so(boolean z) {
        if (z) {
            this.jTj.setVisibility(0);
            this.jTi.setLineVisibility(true);
            am.setBackgroundResource(this.jTj, R.drawable.more_all);
            return;
        }
        this.jTj.setVisibility(8);
        this.jTi.setLineVisibility(false);
    }

    public void sp(boolean z) {
        if (z) {
            this.jSX.setVisibility(0);
        } else {
            this.jSX.setVisibility(8);
        }
    }

    public void cET() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().getSignAlertMins();
            this.jTk.setText(this.jTu.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jTj.setVisibility(0);
            if (!this.jTi.isOn()) {
                this.jTi.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jTk.setText(R.string.close);
        this.jTj.setVisibility(8);
        if (this.jTi.isOn()) {
            this.jTi.turnOffNoCallback();
        }
    }

    public void cEU() {
        String aJd = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJd();
        String aJe = com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJe();
        this.jTn.setText(aJd + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aJe);
        this.jTr.setText(aJd);
        this.jTt.setText(aJe);
    }

    public BdSwitchView cEV() {
        return this.jTi.getSwitchView();
    }

    public BdSwitchView cEW() {
        return this.jSW.getSwitchView();
    }

    public View cEX() {
        return this.jTj;
    }

    public BdSwitchView cEY() {
        return this.jTl.getSwitchView();
    }

    public View cEZ() {
        return this.jTm;
    }

    public LinearLayout cFa() {
        return this.jTq;
    }

    public LinearLayout cFb() {
        return this.jTs;
    }

    public BdSwitchView cFc() {
        return this.jTf.getSwitchView();
    }

    public BdSwitchView cFd() {
        return this.jTg.getSwitchView();
    }

    public BdSwitchView cFe() {
        return this.jTh.getSwitchView();
    }

    public BdSwitchView cFf() {
        return this.jTe.getSwitchView();
    }

    public BdSwitchView cFg() {
        return this.jSY.getSwitchView();
    }

    public BdSwitchView cFh() {
        return this.jSZ.getSwitchView();
    }

    public BdSwitchView cFi() {
        return this.jTa.getSwitchView();
    }

    public BdSwitchView cFj() {
        return this.jTc.getSwitchView();
    }

    public BdSwitchView cFk() {
        return this.jTd.getSwitchView();
    }

    public BdSwitchView cFl() {
        return this.jTb.getSwitchView();
    }

    public TbSettingTextTipView cFm() {
        return this.jTv;
    }

    public TextView cFn() {
        return this.mNavigationBar.getCenterText();
    }

    public void cFo() {
        this.jSY.setOnSwitchStateChangeListener(null);
        this.jSY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIX());
        this.jSY.setOnSwitchStateChangeListener(this.jTu);
    }

    public void cFp() {
        this.jSZ.setOnSwitchStateChangeListener(null);
        this.jSZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJh());
        this.jSZ.setOnSwitchStateChangeListener(this.jTu);
    }

    public void cFq() {
        this.jTa.setOnSwitchStateChangeListener(null);
        this.jTa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIV());
        this.jTa.setOnSwitchStateChangeListener(this.jTu);
    }

    public void cFr() {
        this.jTb.setOnSwitchStateChangeListener(null);
        this.jTb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIW());
        this.jTb.setOnSwitchStateChangeListener(this.jTu);
    }

    public void cFs() {
        this.jTc.setOnSwitchStateChangeListener(null);
        this.jTc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIY());
        this.jTc.setOnSwitchStateChangeListener(this.jTu);
    }

    public void cFt() {
        this.jTd.setOnSwitchStateChangeListener(null);
        this.jTd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJg());
        this.jTd.setOnSwitchStateChangeListener(this.jTu);
    }

    public void sq(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jTu.getString(R.string.msg_remind));
                this.jTo.setVisibility(0);
                this.jTp.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jTu.getString(R.string.no_disturb_mode_time));
            this.jTp.setVisibility(0);
            this.jTo.setVisibility(8);
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
        this.jTu.getLayoutMode().setNightMode(i == 1);
        this.jTu.getLayoutMode().onModeChanged(this.hpY);
        this.mNavigationBar.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jSW.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jSY.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jSZ.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTa.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTb.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTc.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTd.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTe.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTf.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTg.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTh.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTi.onChangeSkinType(this.jTu.getPageContext(), i);
        this.jTl.onChangeSkinType(this.jTu.getPageContext(), i);
        am.setBackgroundResource(this.jTm, R.drawable.more_all);
        am.setBackgroundResource(this.jTq, R.drawable.more_all);
        am.setBackgroundResource(this.jTs, R.drawable.more_all);
        am.setBackgroundResource(this.jTj, R.drawable.more_all);
        SvgManager.aEp().a((ImageView) this.jTm.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a((ImageView) this.jTj.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a((ImageView) this.jTq.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aEp().a((ImageView) this.jTs.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cFu() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aJl().a(this.jTu.getActivity(), this.hpY);
    }

    public void onDestroy() {
    }
}
