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
    private RelativeLayout hrX;
    public boolean isFront;
    private MsgSettingItemView jTR;
    private LinearLayout jTS;
    private MsgSettingItemView jTT;
    private MsgSettingItemView jTU;
    private MsgSettingItemView jTV;
    private MsgSettingItemView jTW;
    private MsgSettingItemView jTX;
    private MsgSettingItemView jTY;
    private MsgSettingItemView jTZ;
    private MsgSettingItemView jUa;
    private MsgSettingItemView jUb;
    private MsgSettingItemView jUc;
    private MsgSettingItemView jUd;
    private LinearLayout jUe;
    private TextView jUf;
    private MsgSettingItemView jUg;
    private LinearLayout jUh;
    private TextView jUi;
    private LinearLayout jUj;
    private LinearLayout jUk;
    private LinearLayout jUl;
    private TextView jUm;
    private LinearLayout jUn;
    private TextView jUo;
    private MsgRemindActivity jUp;
    private TbSettingTextTipView jUq;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hrX = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jUp = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cGp();
        cGs();
        cGr();
        cGq();
        cGt();
        d(msgRemindActivity);
        cGk();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hrX = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUj = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jUk = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jTR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jTR.setText(R.string.receive_msg_text);
        this.jTR.setLineVisibility(false);
        this.jTS = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jTT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jTT.setText(R.string.reply);
        this.jTU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jTU.setVisibility(0);
        this.jTU.setText(R.string.action_praise_default);
        this.jTV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jTV.setText(R.string.mention_atme);
        this.jTW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jTW.setText(R.string.new_fans);
        this.jTX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jTX.setText(R.string.chat_msg_text);
        this.jTY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jTY.setLineVisibility(false);
        this.jTY.setText(R.string.group_chat_text);
        this.jTZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jTZ.setText(R.string.remind_screen_lock);
        this.jTZ.setLineVisibility(false);
        this.jUa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jUa.setText(R.string.remind_tone);
        this.jUb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jUb.setText(R.string.remind_vibrate);
        this.jUc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jUc.setLineVisibility(true);
        this.jUc.setText(R.string.remind_light);
        this.jUd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jUd.setText(R.string.sign_remind_outline);
        this.jUe = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jUf = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jUg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jUg.setText(R.string.no_disturb_mode);
        this.jUg.setLineVisibility(false);
        this.jUh = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jUi = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jUl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jUm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jUn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jUo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jUq = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cGk() {
        cGl();
        cGm();
        cGn();
        cGo();
    }

    private void cGl() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jUg.setVisibility(8);
            this.jUh.setVisibility(8);
            this.jTR.setVisibility(8);
            this.jTS.setVisibility(8);
            this.jUd.setVisibility(8);
            this.jUe.setVisibility(8);
            this.jUa.setVisibility(8);
            this.jUb.setVisibility(8);
            this.jUc.setVisibility(8);
            this.jTZ.setVisibility(8);
        }
    }

    private void cGm() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jTZ.setLineVisibility(true);
        } else {
            this.jTZ.setLineVisibility(false);
        }
    }

    private void cGn() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jTX.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jTY.setVisibility(0);
        } else {
            this.jTY.setVisibility(8);
        }
    }

    private void cGo() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jTZ.setVisibility(0);
        } else {
            this.jTZ.setVisibility(8);
        }
    }

    public View Ay() {
        return this.mBack;
    }

    private void cGp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLl()) {
            this.jTR.turnOnNoCallback();
            this.jTS.setVisibility(0);
        } else {
            this.jTR.turnOffNoCallback();
            this.jTS.setVisibility(8);
        }
        this.jTT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLq());
        this.jTU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLA());
        this.jTV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLo());
        this.jTW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLp());
        this.jTX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLr());
        this.jTY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLz());
    }

    private void cGq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().isSignAlertOn()) {
            this.jUd.turnOn();
            this.jUe.setVisibility(0);
            this.jUd.setLineVisibility(true);
            cGu();
            return;
        }
        this.jUd.turnOff();
        this.jUd.setLineVisibility(false);
        this.jUe.setVisibility(8);
    }

    private void cGr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLs()) {
            this.jUa.turnOnNoCallback();
        } else {
            this.jUa.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLv()) {
            this.jUb.turnOnNoCallback();
        } else {
            this.jUb.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLt()) {
            this.jUc.turnOnNoCallback();
        } else {
            this.jUc.turnOffNoCallback();
        }
    }

    private void cGs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLB()) {
            this.jTZ.turnOnNoCallback();
        } else {
            this.jTZ.turnOffNoCallback();
        }
    }

    private void cGt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLu()) {
            this.jUg.turnOnNoCallback();
            this.jUh.setVisibility(0);
            cGv();
            return;
        }
        this.jUg.turnOffNoCallback();
        this.jUh.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jTR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUe.setOnClickListener(msgRemindActivity);
        this.jUg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUh.setOnClickListener(msgRemindActivity);
        this.jUl.setOnClickListener(msgRemindActivity);
        this.jUn.setOnClickListener(msgRemindActivity);
        this.jUq.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sq(boolean z) {
        this.jUg.setLineVisibility(z);
        if (z) {
            this.jUh.setVisibility(0);
            cGv();
            am.setBackgroundResource(this.jUh, R.drawable.more_all);
            return;
        }
        this.jUh.setVisibility(8);
    }

    public void sr(boolean z) {
        if (z) {
            this.jUe.setVisibility(0);
            this.jUd.setLineVisibility(true);
            am.setBackgroundResource(this.jUe, R.drawable.more_all);
            return;
        }
        this.jUe.setVisibility(8);
        this.jUd.setLineVisibility(false);
    }

    public void ss(boolean z) {
        if (z) {
            this.jTS.setVisibility(0);
        } else {
            this.jTS.setVisibility(8);
        }
    }

    public void cGu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLj().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aLj().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aLj().getSignAlertMins();
            this.jUf.setText(this.jUp.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jUe.setVisibility(0);
            if (!this.jUd.isOn()) {
                this.jUd.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jUf.setText(R.string.close);
        this.jUe.setVisibility(8);
        if (this.jUd.isOn()) {
            this.jUd.turnOffNoCallback();
        }
    }

    public void cGv() {
        String aLw = com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLw();
        String aLx = com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLx();
        this.jUi.setText(aLw + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aLx);
        this.jUm.setText(aLw);
        this.jUo.setText(aLx);
    }

    public BdSwitchView cGw() {
        return this.jUd.getSwitchView();
    }

    public BdSwitchView cGx() {
        return this.jTR.getSwitchView();
    }

    public View cGy() {
        return this.jUe;
    }

    public BdSwitchView cGz() {
        return this.jUg.getSwitchView();
    }

    public View cGA() {
        return this.jUh;
    }

    public LinearLayout cGB() {
        return this.jUl;
    }

    public LinearLayout cGC() {
        return this.jUn;
    }

    public BdSwitchView cGD() {
        return this.jUa.getSwitchView();
    }

    public BdSwitchView cGE() {
        return this.jUb.getSwitchView();
    }

    public BdSwitchView cGF() {
        return this.jUc.getSwitchView();
    }

    public BdSwitchView cGG() {
        return this.jTZ.getSwitchView();
    }

    public BdSwitchView cGH() {
        return this.jTT.getSwitchView();
    }

    public BdSwitchView cGI() {
        return this.jTU.getSwitchView();
    }

    public BdSwitchView cGJ() {
        return this.jTV.getSwitchView();
    }

    public BdSwitchView cGK() {
        return this.jTX.getSwitchView();
    }

    public BdSwitchView cGL() {
        return this.jTY.getSwitchView();
    }

    public BdSwitchView cGM() {
        return this.jTW.getSwitchView();
    }

    public TbSettingTextTipView cGN() {
        return this.jUq;
    }

    public TextView cGO() {
        return this.mNavigationBar.getCenterText();
    }

    public void cGP() {
        this.jTT.setOnSwitchStateChangeListener(null);
        this.jTT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLq());
        this.jTT.setOnSwitchStateChangeListener(this.jUp);
    }

    public void cGQ() {
        this.jTU.setOnSwitchStateChangeListener(null);
        this.jTU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLA());
        this.jTU.setOnSwitchStateChangeListener(this.jUp);
    }

    public void cGR() {
        this.jTV.setOnSwitchStateChangeListener(null);
        this.jTV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLo());
        this.jTV.setOnSwitchStateChangeListener(this.jUp);
    }

    public void cGS() {
        this.jTW.setOnSwitchStateChangeListener(null);
        this.jTW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLp());
        this.jTW.setOnSwitchStateChangeListener(this.jUp);
    }

    public void cGT() {
        this.jTX.setOnSwitchStateChangeListener(null);
        this.jTX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLr());
        this.jTX.setOnSwitchStateChangeListener(this.jUp);
    }

    public void cGU() {
        this.jTY.setOnSwitchStateChangeListener(null);
        this.jTY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLz());
        this.jTY.setOnSwitchStateChangeListener(this.jUp);
    }

    public void st(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jUp.getString(R.string.msg_remind));
                this.jUj.setVisibility(0);
                this.jUk.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jUp.getString(R.string.no_disturb_mode_time));
            this.jUk.setVisibility(0);
            this.jUj.setVisibility(8);
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
        this.jUp.getLayoutMode().setNightMode(i == 1);
        this.jUp.getLayoutMode().onModeChanged(this.hrX);
        this.mNavigationBar.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTR.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTT.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTU.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTV.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTW.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTX.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTY.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jTZ.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jUa.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jUb.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jUc.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jUd.onChangeSkinType(this.jUp.getPageContext(), i);
        this.jUg.onChangeSkinType(this.jUp.getPageContext(), i);
        am.setBackgroundResource(this.jUh, R.drawable.more_all);
        am.setBackgroundResource(this.jUl, R.drawable.more_all);
        am.setBackgroundResource(this.jUn, R.drawable.more_all);
        am.setBackgroundResource(this.jUe, R.drawable.more_all);
        SvgManager.aGA().a((ImageView) this.jUh.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGA().a((ImageView) this.jUe.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGA().a((ImageView) this.jUl.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGA().a((ImageView) this.jUn.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cGV() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aLE().a(this.jUp.getActivity(), this.hrX);
    }

    public void onDestroy() {
    }
}
