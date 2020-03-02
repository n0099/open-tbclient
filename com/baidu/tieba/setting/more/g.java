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
    private RelativeLayout hrZ;
    public boolean isFront;
    private MsgSettingItemView jTT;
    private LinearLayout jTU;
    private MsgSettingItemView jTV;
    private MsgSettingItemView jTW;
    private MsgSettingItemView jTX;
    private MsgSettingItemView jTY;
    private MsgSettingItemView jTZ;
    private MsgSettingItemView jUa;
    private MsgSettingItemView jUb;
    private MsgSettingItemView jUc;
    private MsgSettingItemView jUd;
    private MsgSettingItemView jUe;
    private MsgSettingItemView jUf;
    private LinearLayout jUg;
    private TextView jUh;
    private MsgSettingItemView jUi;
    private LinearLayout jUj;
    private TextView jUk;
    private LinearLayout jUl;
    private LinearLayout jUm;
    private LinearLayout jUn;
    private TextView jUo;
    private LinearLayout jUp;
    private TextView jUq;
    private MsgRemindActivity jUr;
    private TbSettingTextTipView jUs;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hrZ = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jUr = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cGr();
        cGu();
        cGt();
        cGs();
        cGv();
        d(msgRemindActivity);
        cGm();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hrZ = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUl = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jUm = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jTT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jTT.setText(R.string.receive_msg_text);
        this.jTT.setLineVisibility(false);
        this.jTU = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jTV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jTV.setText(R.string.reply);
        this.jTW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jTW.setVisibility(0);
        this.jTW.setText(R.string.action_praise_default);
        this.jTX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jTX.setText(R.string.mention_atme);
        this.jTY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jTY.setText(R.string.new_fans);
        this.jTZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jTZ.setText(R.string.chat_msg_text);
        this.jUa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jUa.setLineVisibility(false);
        this.jUa.setText(R.string.group_chat_text);
        this.jUb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jUb.setText(R.string.remind_screen_lock);
        this.jUb.setLineVisibility(false);
        this.jUc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jUc.setText(R.string.remind_tone);
        this.jUd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jUd.setText(R.string.remind_vibrate);
        this.jUe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jUe.setLineVisibility(true);
        this.jUe.setText(R.string.remind_light);
        this.jUf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jUf.setText(R.string.sign_remind_outline);
        this.jUg = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jUh = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jUi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jUi.setText(R.string.no_disturb_mode);
        this.jUi.setLineVisibility(false);
        this.jUj = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jUk = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jUn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jUo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jUp = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jUq = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jUs = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cGm() {
        cGn();
        cGo();
        cGp();
        cGq();
    }

    private void cGn() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jUi.setVisibility(8);
            this.jUj.setVisibility(8);
            this.jTT.setVisibility(8);
            this.jTU.setVisibility(8);
            this.jUf.setVisibility(8);
            this.jUg.setVisibility(8);
            this.jUc.setVisibility(8);
            this.jUd.setVisibility(8);
            this.jUe.setVisibility(8);
            this.jUb.setVisibility(8);
        }
    }

    private void cGo() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jUb.setLineVisibility(true);
        } else {
            this.jUb.setLineVisibility(false);
        }
    }

    private void cGp() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jTZ.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jUa.setVisibility(0);
        } else {
            this.jUa.setVisibility(8);
        }
    }

    private void cGq() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jUb.setVisibility(0);
        } else {
            this.jUb.setVisibility(8);
        }
    }

    public View AA() {
        return this.mBack;
    }

    private void cGr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLn()) {
            this.jTT.turnOnNoCallback();
            this.jTU.setVisibility(0);
        } else {
            this.jTT.turnOffNoCallback();
            this.jTU.setVisibility(8);
        }
        this.jTV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLs());
        this.jTW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLC());
        this.jTX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLq());
        this.jTY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLr());
        this.jTZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLt());
        this.jUa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLB());
    }

    private void cGs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().isSignAlertOn()) {
            this.jUf.turnOn();
            this.jUg.setVisibility(0);
            this.jUf.setLineVisibility(true);
            cGw();
            return;
        }
        this.jUf.turnOff();
        this.jUf.setLineVisibility(false);
        this.jUg.setVisibility(8);
    }

    private void cGt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLu()) {
            this.jUc.turnOnNoCallback();
        } else {
            this.jUc.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLx()) {
            this.jUd.turnOnNoCallback();
        } else {
            this.jUd.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLv()) {
            this.jUe.turnOnNoCallback();
        } else {
            this.jUe.turnOffNoCallback();
        }
    }

    private void cGu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLD()) {
            this.jUb.turnOnNoCallback();
        } else {
            this.jUb.turnOffNoCallback();
        }
    }

    private void cGv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLw()) {
            this.jUi.turnOnNoCallback();
            this.jUj.setVisibility(0);
            cGx();
            return;
        }
        this.jUi.turnOffNoCallback();
        this.jUj.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jTT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jTZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUg.setOnClickListener(msgRemindActivity);
        this.jUi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUj.setOnClickListener(msgRemindActivity);
        this.jUn.setOnClickListener(msgRemindActivity);
        this.jUp.setOnClickListener(msgRemindActivity);
        this.jUs.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sq(boolean z) {
        this.jUi.setLineVisibility(z);
        if (z) {
            this.jUj.setVisibility(0);
            cGx();
            am.setBackgroundResource(this.jUj, R.drawable.more_all);
            return;
        }
        this.jUj.setVisibility(8);
    }

    public void sr(boolean z) {
        if (z) {
            this.jUg.setVisibility(0);
            this.jUf.setLineVisibility(true);
            am.setBackgroundResource(this.jUg, R.drawable.more_all);
            return;
        }
        this.jUg.setVisibility(8);
        this.jUf.setLineVisibility(false);
    }

    public void ss(boolean z) {
        if (z) {
            this.jTU.setVisibility(0);
        } else {
            this.jTU.setVisibility(8);
        }
    }

    public void cGw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLl().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aLl().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aLl().getSignAlertMins();
            this.jUh.setText(this.jUr.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jUg.setVisibility(0);
            if (!this.jUf.isOn()) {
                this.jUf.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jUh.setText(R.string.close);
        this.jUg.setVisibility(8);
        if (this.jUf.isOn()) {
            this.jUf.turnOffNoCallback();
        }
    }

    public void cGx() {
        String aLy = com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLy();
        String aLz = com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLz();
        this.jUk.setText(aLy + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aLz);
        this.jUo.setText(aLy);
        this.jUq.setText(aLz);
    }

    public BdSwitchView cGy() {
        return this.jUf.getSwitchView();
    }

    public BdSwitchView cGz() {
        return this.jTT.getSwitchView();
    }

    public View cGA() {
        return this.jUg;
    }

    public BdSwitchView cGB() {
        return this.jUi.getSwitchView();
    }

    public View cGC() {
        return this.jUj;
    }

    public LinearLayout cGD() {
        return this.jUn;
    }

    public LinearLayout cGE() {
        return this.jUp;
    }

    public BdSwitchView cGF() {
        return this.jUc.getSwitchView();
    }

    public BdSwitchView cGG() {
        return this.jUd.getSwitchView();
    }

    public BdSwitchView cGH() {
        return this.jUe.getSwitchView();
    }

    public BdSwitchView cGI() {
        return this.jUb.getSwitchView();
    }

    public BdSwitchView cGJ() {
        return this.jTV.getSwitchView();
    }

    public BdSwitchView cGK() {
        return this.jTW.getSwitchView();
    }

    public BdSwitchView cGL() {
        return this.jTX.getSwitchView();
    }

    public BdSwitchView cGM() {
        return this.jTZ.getSwitchView();
    }

    public BdSwitchView cGN() {
        return this.jUa.getSwitchView();
    }

    public BdSwitchView cGO() {
        return this.jTY.getSwitchView();
    }

    public TbSettingTextTipView cGP() {
        return this.jUs;
    }

    public TextView cGQ() {
        return this.mNavigationBar.getCenterText();
    }

    public void cGR() {
        this.jTV.setOnSwitchStateChangeListener(null);
        this.jTV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLs());
        this.jTV.setOnSwitchStateChangeListener(this.jUr);
    }

    public void cGS() {
        this.jTW.setOnSwitchStateChangeListener(null);
        this.jTW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLC());
        this.jTW.setOnSwitchStateChangeListener(this.jUr);
    }

    public void cGT() {
        this.jTX.setOnSwitchStateChangeListener(null);
        this.jTX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLq());
        this.jTX.setOnSwitchStateChangeListener(this.jUr);
    }

    public void cGU() {
        this.jTY.setOnSwitchStateChangeListener(null);
        this.jTY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLr());
        this.jTY.setOnSwitchStateChangeListener(this.jUr);
    }

    public void cGV() {
        this.jTZ.setOnSwitchStateChangeListener(null);
        this.jTZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLt());
        this.jTZ.setOnSwitchStateChangeListener(this.jUr);
    }

    public void cGW() {
        this.jUa.setOnSwitchStateChangeListener(null);
        this.jUa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLB());
        this.jUa.setOnSwitchStateChangeListener(this.jUr);
    }

    public void st(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jUr.getString(R.string.msg_remind));
                this.jUl.setVisibility(0);
                this.jUm.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jUr.getString(R.string.no_disturb_mode_time));
            this.jUm.setVisibility(0);
            this.jUl.setVisibility(8);
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
        this.jUr.getLayoutMode().setNightMode(i == 1);
        this.jUr.getLayoutMode().onModeChanged(this.hrZ);
        this.mNavigationBar.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jTT.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jTV.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jTW.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jTX.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jTY.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jTZ.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUa.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUb.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUc.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUd.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUe.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUf.onChangeSkinType(this.jUr.getPageContext(), i);
        this.jUi.onChangeSkinType(this.jUr.getPageContext(), i);
        am.setBackgroundResource(this.jUj, R.drawable.more_all);
        am.setBackgroundResource(this.jUn, R.drawable.more_all);
        am.setBackgroundResource(this.jUp, R.drawable.more_all);
        am.setBackgroundResource(this.jUg, R.drawable.more_all);
        SvgManager.aGC().a((ImageView) this.jUj.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a((ImageView) this.jUg.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a((ImageView) this.jUn.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a((ImageView) this.jUp.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cGX() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aLG().a(this.jUr.getActivity(), this.hrZ);
    }

    public void onDestroy() {
    }
}
