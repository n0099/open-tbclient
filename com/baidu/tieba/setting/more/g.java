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
    private RelativeLayout isn;
    private MsgSettingItemView kWV;
    private LinearLayout kWW;
    private MsgSettingItemView kWX;
    private MsgSettingItemView kWY;
    private MsgSettingItemView kWZ;
    private MsgSettingItemView kXa;
    private MsgSettingItemView kXb;
    private MsgSettingItemView kXc;
    private MsgSettingItemView kXd;
    private MsgSettingItemView kXe;
    private MsgSettingItemView kXf;
    private MsgSettingItemView kXg;
    private MsgSettingItemView kXh;
    private LinearLayout kXi;
    private TextView kXj;
    private MsgSettingItemView kXk;
    private LinearLayout kXl;
    private TextView kXm;
    private LinearLayout kXn;
    private LinearLayout kXo;
    private LinearLayout kXp;
    private TextView kXq;
    private LinearLayout kXr;
    private TextView kXs;
    public boolean kXt;
    private MsgRemindActivity kXu;
    private TbSettingTextTipView kXv;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.isn = null;
        this.mNavigationBar = null;
        this.kXt = true;
        this.kXu = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cYl();
        cYo();
        cYn();
        cYm();
        cYp();
        d(msgRemindActivity);
        cYg();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.isn = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kXn = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.kXo = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.kWV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.kWV.setText(R.string.receive_msg_text);
        this.kWV.setLineVisibility(false);
        this.kWW = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.kWX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.kWX.setText(R.string.reply);
        this.kWY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.kWY.setVisibility(0);
        this.kWY.setText(R.string.action_praise_default);
        this.kWZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.kWZ.setText(R.string.mention_atme);
        this.kXa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.kXa.setText(R.string.new_fans);
        this.kXb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.kXb.setText(R.string.chat_msg_text);
        this.kXc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.kXc.setLineVisibility(false);
        this.kXc.setText(R.string.group_chat_text);
        this.kXd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.kXd.setText(R.string.remind_screen_lock);
        this.kXd.setLineVisibility(false);
        this.kXe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.kXe.setText(R.string.remind_tone);
        this.kXf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.kXf.setText(R.string.remind_vibrate);
        this.kXg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.kXg.setLineVisibility(true);
        this.kXg.setText(R.string.remind_light);
        this.kXh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.kXh.setText(R.string.sign_remind_outline);
        this.kXi = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.kXj = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.kXk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.kXk.setText(R.string.no_disturb_mode);
        this.kXk.setLineVisibility(false);
        this.kXl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.kXm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.kXp = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.kXq = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.kXr = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.kXs = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.kXv = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cYg() {
        cYh();
        cYi();
        cYj();
        cYk();
    }

    private void cYh() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kXk.setVisibility(8);
            this.kXl.setVisibility(8);
            this.kWV.setVisibility(8);
            this.kWW.setVisibility(8);
            this.kXh.setVisibility(8);
            this.kXi.setVisibility(8);
            this.kXe.setVisibility(8);
            this.kXf.setVisibility(8);
            this.kXg.setVisibility(8);
            this.kXd.setVisibility(8);
        }
    }

    private void cYi() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.kXd.setLineVisibility(true);
        } else {
            this.kXd.setLineVisibility(false);
        }
    }

    private void cYj() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.kXb.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.kXc.setVisibility(0);
        } else {
            this.kXc.setVisibility(8);
        }
    }

    private void cYk() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.kXd.setVisibility(0);
        } else {
            this.kXd.setVisibility(8);
        }
    }

    public View HI() {
        return this.mBack;
    }

    private void cYl() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZU()) {
            this.kWV.turnOnNoCallback();
            this.kWW.setVisibility(0);
        } else {
            this.kWV.turnOffNoCallback();
            this.kWW.setVisibility(8);
        }
        this.kWX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZZ());
        this.kWY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baj());
        this.kWZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZX());
        this.kXa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZY());
        this.kXb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baa());
        this.kXc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bai());
    }

    private void cYm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().isSignAlertOn()) {
            this.kXh.turnOn();
            this.kXi.setVisibility(0);
            this.kXh.setLineVisibility(true);
            cYq();
            return;
        }
        this.kXh.turnOff();
        this.kXh.setLineVisibility(false);
        this.kXi.setVisibility(8);
    }

    private void cYn() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bab()) {
            this.kXe.turnOnNoCallback();
        } else {
            this.kXe.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bae()) {
            this.kXf.turnOnNoCallback();
        } else {
            this.kXf.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bac()) {
            this.kXg.turnOnNoCallback();
        } else {
            this.kXg.turnOffNoCallback();
        }
    }

    private void cYo() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bak()) {
            this.kXd.turnOnNoCallback();
        } else {
            this.kXd.turnOffNoCallback();
        }
    }

    private void cYp() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bad()) {
            this.kXk.turnOnNoCallback();
            this.kXl.setVisibility(0);
            cYr();
            return;
        }
        this.kXk.turnOffNoCallback();
        this.kXl.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.kWV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kWX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kWZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kWY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXi.setOnClickListener(msgRemindActivity);
        this.kXk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kXl.setOnClickListener(msgRemindActivity);
        this.kXp.setOnClickListener(msgRemindActivity);
        this.kXr.setOnClickListener(msgRemindActivity);
        this.kXv.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void tV(boolean z) {
        this.kXk.setLineVisibility(z);
        if (z) {
            this.kXl.setVisibility(0);
            cYr();
            am.setBackgroundResource(this.kXl, R.drawable.more_all);
            return;
        }
        this.kXl.setVisibility(8);
    }

    public void tW(boolean z) {
        if (z) {
            this.kXi.setVisibility(0);
            this.kXh.setLineVisibility(true);
            am.setBackgroundResource(this.kXi, R.drawable.more_all);
            return;
        }
        this.kXi.setVisibility(8);
        this.kXh.setLineVisibility(false);
    }

    public void tX(boolean z) {
        if (z) {
            this.kWW.setVisibility(0);
        } else {
            this.kWW.setVisibility(8);
        }
    }

    public void cYq() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZS().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aZS().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aZS().getSignAlertMins();
            this.kXj.setText(this.kXu.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.kXi.setVisibility(0);
            if (!this.kXh.isOn()) {
                this.kXh.turnOnNoCallback();
                return;
            }
            return;
        }
        this.kXj.setText(R.string.close);
        this.kXi.setVisibility(8);
        if (this.kXh.isOn()) {
            this.kXh.turnOffNoCallback();
        }
    }

    public void cYr() {
        String baf = com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baf();
        String bag = com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bag();
        this.kXm.setText(baf + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bag);
        this.kXq.setText(baf);
        this.kXs.setText(bag);
    }

    public BdSwitchView cYs() {
        return this.kXh.getSwitchView();
    }

    public BdSwitchView cYt() {
        return this.kWV.getSwitchView();
    }

    public View cYu() {
        return this.kXi;
    }

    public BdSwitchView cYv() {
        return this.kXk.getSwitchView();
    }

    public View cYw() {
        return this.kXl;
    }

    public LinearLayout cYx() {
        return this.kXp;
    }

    public LinearLayout cYy() {
        return this.kXr;
    }

    public BdSwitchView cYz() {
        return this.kXe.getSwitchView();
    }

    public BdSwitchView cYA() {
        return this.kXf.getSwitchView();
    }

    public BdSwitchView cYB() {
        return this.kXg.getSwitchView();
    }

    public BdSwitchView cYC() {
        return this.kXd.getSwitchView();
    }

    public BdSwitchView cYD() {
        return this.kWX.getSwitchView();
    }

    public BdSwitchView cYE() {
        return this.kWY.getSwitchView();
    }

    public BdSwitchView cYF() {
        return this.kWZ.getSwitchView();
    }

    public BdSwitchView cYG() {
        return this.kXb.getSwitchView();
    }

    public BdSwitchView cYH() {
        return this.kXc.getSwitchView();
    }

    public BdSwitchView cYI() {
        return this.kXa.getSwitchView();
    }

    public TbSettingTextTipView cYJ() {
        return this.kXv;
    }

    public TextView cYK() {
        return this.mNavigationBar.getCenterText();
    }

    public void cYL() {
        this.kWX.setOnSwitchStateChangeListener(null);
        this.kWX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZZ());
        this.kWX.setOnSwitchStateChangeListener(this.kXu);
    }

    public void cYM() {
        this.kWY.setOnSwitchStateChangeListener(null);
        this.kWY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baj());
        this.kWY.setOnSwitchStateChangeListener(this.kXu);
    }

    public void cYN() {
        this.kWZ.setOnSwitchStateChangeListener(null);
        this.kWZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZX());
        this.kWZ.setOnSwitchStateChangeListener(this.kXu);
    }

    public void cYO() {
        this.kXa.setOnSwitchStateChangeListener(null);
        this.kXa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZY());
        this.kXa.setOnSwitchStateChangeListener(this.kXu);
    }

    public void cYP() {
        this.kXb.setOnSwitchStateChangeListener(null);
        this.kXb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baa());
        this.kXb.setOnSwitchStateChangeListener(this.kXu);
    }

    public void cYQ() {
        this.kXc.setOnSwitchStateChangeListener(null);
        this.kXc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZS().bai());
        this.kXc.setOnSwitchStateChangeListener(this.kXu);
    }

    public void tY(boolean z) {
        if (this.kXt != z) {
            this.kXt = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.kXu.getString(R.string.msg_remind));
                this.kXn.setVisibility(0);
                this.kXo.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.kXu.getString(R.string.no_disturb_mode_time));
            this.kXo.setVisibility(0);
            this.kXn.setVisibility(8);
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
        this.kXu.getLayoutMode().setNightMode(i == 1);
        this.kXu.getLayoutMode().onModeChanged(this.isn);
        this.mNavigationBar.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kWV.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kWX.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kWY.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kWZ.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXa.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXb.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXc.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXd.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXe.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXf.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXg.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXh.onChangeSkinType(this.kXu.getPageContext(), i);
        this.kXk.onChangeSkinType(this.kXu.getPageContext(), i);
        am.setBackgroundResource(this.kXl, R.drawable.more_all);
        am.setBackgroundResource(this.kXp, R.drawable.more_all);
        am.setBackgroundResource(this.kXr, R.drawable.more_all);
        am.setBackgroundResource(this.kXi, R.drawable.more_all);
        SvgManager.aUV().a((ImageView) this.kXl.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUV().a((ImageView) this.kXi.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUV().a((ImageView) this.kXp.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUV().a((ImageView) this.kXr.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cYR() {
        com.baidu.tbadk.coreExtra.messageCenter.f.ban().a(this.kXu.getActivity(), this.isn);
    }

    public void onDestroy() {
    }
}
