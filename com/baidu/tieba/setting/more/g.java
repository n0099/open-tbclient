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
    private RelativeLayout ita;
    private LinearLayout kYA;
    private TextView kYB;
    public boolean kYC;
    private MsgRemindActivity kYD;
    private TbSettingTextTipView kYE;
    private MsgSettingItemView kYe;
    private LinearLayout kYf;
    private MsgSettingItemView kYg;
    private MsgSettingItemView kYh;
    private MsgSettingItemView kYi;
    private MsgSettingItemView kYj;
    private MsgSettingItemView kYk;
    private MsgSettingItemView kYl;
    private MsgSettingItemView kYm;
    private MsgSettingItemView kYn;
    private MsgSettingItemView kYo;
    private MsgSettingItemView kYp;
    private MsgSettingItemView kYq;
    private LinearLayout kYr;
    private TextView kYs;
    private MsgSettingItemView kYt;
    private LinearLayout kYu;
    private TextView kYv;
    private LinearLayout kYw;
    private LinearLayout kYx;
    private LinearLayout kYy;
    private TextView kYz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.ita = null;
        this.mNavigationBar = null;
        this.kYC = true;
        this.kYD = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cYB();
        cYE();
        cYD();
        cYC();
        cYF();
        d(msgRemindActivity);
        cYw();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.ita = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kYw = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.kYx = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.kYe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.kYe.setText(R.string.receive_msg_text);
        this.kYe.setLineVisibility(false);
        this.kYf = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.kYg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.kYg.setText(R.string.reply);
        this.kYh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.kYh.setVisibility(0);
        this.kYh.setText(R.string.action_praise_default);
        this.kYi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.kYi.setText(R.string.mention_atme);
        this.kYj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.kYj.setText(R.string.new_fans);
        this.kYk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.kYk.setText(R.string.chat_msg_text);
        this.kYl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.kYl.setLineVisibility(false);
        this.kYl.setText(R.string.group_chat_text);
        this.kYm = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.kYm.setText(R.string.remind_screen_lock);
        this.kYm.setLineVisibility(false);
        this.kYn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.kYn.setText(R.string.remind_tone);
        this.kYo = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.kYo.setText(R.string.remind_vibrate);
        this.kYp = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.kYp.setLineVisibility(true);
        this.kYp.setText(R.string.remind_light);
        this.kYq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.kYq.setText(R.string.sign_remind_outline);
        this.kYr = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.kYs = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.kYt = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.kYt.setText(R.string.no_disturb_mode);
        this.kYt.setLineVisibility(false);
        this.kYu = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.kYv = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.kYy = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.kYz = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.kYA = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.kYB = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.kYE = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cYw() {
        cYx();
        cYy();
        cYz();
        cYA();
    }

    private void cYx() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.kYt.setVisibility(8);
            this.kYu.setVisibility(8);
            this.kYe.setVisibility(8);
            this.kYf.setVisibility(8);
            this.kYq.setVisibility(8);
            this.kYr.setVisibility(8);
            this.kYn.setVisibility(8);
            this.kYo.setVisibility(8);
            this.kYp.setVisibility(8);
            this.kYm.setVisibility(8);
        }
    }

    private void cYy() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.kYm.setLineVisibility(true);
        } else {
            this.kYm.setLineVisibility(false);
        }
    }

    private void cYz() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.kYk.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.kYl.setVisibility(0);
        } else {
            this.kYl.setVisibility(8);
        }
    }

    private void cYA() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.kYm.setVisibility(0);
        } else {
            this.kYm.setVisibility(8);
        }
    }

    public View HI() {
        return this.mBack;
    }

    private void cYB() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZV()) {
            this.kYe.turnOnNoCallback();
            this.kYf.setVisibility(0);
        } else {
            this.kYe.turnOffNoCallback();
            this.kYf.setVisibility(8);
        }
        this.kYg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().baa());
        this.kYh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bak());
        this.kYi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZY());
        this.kYj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZZ());
        this.kYk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bab());
        this.kYl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().baj());
    }

    private void cYC() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().isSignAlertOn()) {
            this.kYq.turnOn();
            this.kYr.setVisibility(0);
            this.kYq.setLineVisibility(true);
            cYG();
            return;
        }
        this.kYq.turnOff();
        this.kYq.setLineVisibility(false);
        this.kYr.setVisibility(8);
    }

    private void cYD() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bac()) {
            this.kYn.turnOnNoCallback();
        } else {
            this.kYn.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().baf()) {
            this.kYo.turnOnNoCallback();
        } else {
            this.kYo.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bad()) {
            this.kYp.turnOnNoCallback();
        } else {
            this.kYp.turnOffNoCallback();
        }
    }

    private void cYE() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bal()) {
            this.kYm.turnOnNoCallback();
        } else {
            this.kYm.turnOffNoCallback();
        }
    }

    private void cYF() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bae()) {
            this.kYt.turnOnNoCallback();
            this.kYu.setVisibility(0);
            cYH();
            return;
        }
        this.kYt.turnOffNoCallback();
        this.kYu.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.kYe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYr.setOnClickListener(msgRemindActivity);
        this.kYt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.kYu.setOnClickListener(msgRemindActivity);
        this.kYy.setOnClickListener(msgRemindActivity);
        this.kYA.setOnClickListener(msgRemindActivity);
        this.kYE.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void tV(boolean z) {
        this.kYt.setLineVisibility(z);
        if (z) {
            this.kYu.setVisibility(0);
            cYH();
            am.setBackgroundResource(this.kYu, R.drawable.more_all);
            return;
        }
        this.kYu.setVisibility(8);
    }

    public void tW(boolean z) {
        if (z) {
            this.kYr.setVisibility(0);
            this.kYq.setLineVisibility(true);
            am.setBackgroundResource(this.kYr, R.drawable.more_all);
            return;
        }
        this.kYr.setVisibility(8);
        this.kYq.setLineVisibility(false);
    }

    public void tX(boolean z) {
        if (z) {
            this.kYf.setVisibility(0);
        } else {
            this.kYf.setVisibility(8);
        }
    }

    public void cYG() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aZT().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aZT().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aZT().getSignAlertMins();
            this.kYs.setText(this.kYD.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.kYr.setVisibility(0);
            if (!this.kYq.isOn()) {
                this.kYq.turnOnNoCallback();
                return;
            }
            return;
        }
        this.kYs.setText(R.string.close);
        this.kYr.setVisibility(8);
        if (this.kYq.isOn()) {
            this.kYq.turnOffNoCallback();
        }
    }

    public void cYH() {
        String bag = com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bag();
        String bah = com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bah();
        this.kYv.setText(bag + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bah);
        this.kYz.setText(bag);
        this.kYB.setText(bah);
    }

    public BdSwitchView cYI() {
        return this.kYq.getSwitchView();
    }

    public BdSwitchView cYJ() {
        return this.kYe.getSwitchView();
    }

    public View cYK() {
        return this.kYr;
    }

    public BdSwitchView cYL() {
        return this.kYt.getSwitchView();
    }

    public View cYM() {
        return this.kYu;
    }

    public LinearLayout cYN() {
        return this.kYy;
    }

    public LinearLayout cYO() {
        return this.kYA;
    }

    public BdSwitchView cYP() {
        return this.kYn.getSwitchView();
    }

    public BdSwitchView cYQ() {
        return this.kYo.getSwitchView();
    }

    public BdSwitchView cYR() {
        return this.kYp.getSwitchView();
    }

    public BdSwitchView cYS() {
        return this.kYm.getSwitchView();
    }

    public BdSwitchView cYT() {
        return this.kYg.getSwitchView();
    }

    public BdSwitchView cYU() {
        return this.kYh.getSwitchView();
    }

    public BdSwitchView cYV() {
        return this.kYi.getSwitchView();
    }

    public BdSwitchView cYW() {
        return this.kYk.getSwitchView();
    }

    public BdSwitchView cYX() {
        return this.kYl.getSwitchView();
    }

    public BdSwitchView cYY() {
        return this.kYj.getSwitchView();
    }

    public TbSettingTextTipView cYZ() {
        return this.kYE;
    }

    public TextView cZa() {
        return this.mNavigationBar.getCenterText();
    }

    public void cZb() {
        this.kYg.setOnSwitchStateChangeListener(null);
        this.kYg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().baa());
        this.kYg.setOnSwitchStateChangeListener(this.kYD);
    }

    public void cZc() {
        this.kYh.setOnSwitchStateChangeListener(null);
        this.kYh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bak());
        this.kYh.setOnSwitchStateChangeListener(this.kYD);
    }

    public void cZd() {
        this.kYi.setOnSwitchStateChangeListener(null);
        this.kYi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZY());
        this.kYi.setOnSwitchStateChangeListener(this.kYD);
    }

    public void cZe() {
        this.kYj.setOnSwitchStateChangeListener(null);
        this.kYj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZZ());
        this.kYj.setOnSwitchStateChangeListener(this.kYD);
    }

    public void cZf() {
        this.kYk.setOnSwitchStateChangeListener(null);
        this.kYk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bab());
        this.kYk.setOnSwitchStateChangeListener(this.kYD);
    }

    public void cZg() {
        this.kYl.setOnSwitchStateChangeListener(null);
        this.kYl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aZT().baj());
        this.kYl.setOnSwitchStateChangeListener(this.kYD);
    }

    public void tY(boolean z) {
        if (this.kYC != z) {
            this.kYC = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.kYD.getString(R.string.msg_remind));
                this.kYw.setVisibility(0);
                this.kYx.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.kYD.getString(R.string.no_disturb_mode_time));
            this.kYx.setVisibility(0);
            this.kYw.setVisibility(8);
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
        this.kYD.getLayoutMode().setNightMode(i == 1);
        this.kYD.getLayoutMode().onModeChanged(this.ita);
        this.mNavigationBar.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYe.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYg.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYh.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYi.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYj.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYk.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYl.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYm.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYn.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYo.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYp.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYq.onChangeSkinType(this.kYD.getPageContext(), i);
        this.kYt.onChangeSkinType(this.kYD.getPageContext(), i);
        am.setBackgroundResource(this.kYu, R.drawable.more_all);
        am.setBackgroundResource(this.kYy, R.drawable.more_all);
        am.setBackgroundResource(this.kYA, R.drawable.more_all);
        am.setBackgroundResource(this.kYr, R.drawable.more_all);
        SvgManager.aUW().a((ImageView) this.kYu.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUW().a((ImageView) this.kYr.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUW().a((ImageView) this.kYy.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aUW().a((ImageView) this.kYA.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cZh() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bao().a(this.kYD.getActivity(), this.ita);
    }

    public void onDestroy() {
    }
}
