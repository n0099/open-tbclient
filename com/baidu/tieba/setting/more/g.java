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
    private RelativeLayout hsl;
    public boolean isFront;
    private TextView jUA;
    private LinearLayout jUB;
    private TextView jUC;
    private MsgRemindActivity jUD;
    private TbSettingTextTipView jUE;
    private MsgSettingItemView jUf;
    private LinearLayout jUg;
    private MsgSettingItemView jUh;
    private MsgSettingItemView jUi;
    private MsgSettingItemView jUj;
    private MsgSettingItemView jUk;
    private MsgSettingItemView jUl;
    private MsgSettingItemView jUm;
    private MsgSettingItemView jUn;
    private MsgSettingItemView jUo;
    private MsgSettingItemView jUp;
    private MsgSettingItemView jUq;
    private MsgSettingItemView jUr;
    private LinearLayout jUs;
    private TextView jUt;
    private MsgSettingItemView jUu;
    private LinearLayout jUv;
    private TextView jUw;
    private LinearLayout jUx;
    private LinearLayout jUy;
    private LinearLayout jUz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hsl = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jUD = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cGs();
        cGv();
        cGu();
        cGt();
        cGw();
        d(msgRemindActivity);
        cGn();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hsl = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jUx = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jUy = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jUf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jUf.setText(R.string.receive_msg_text);
        this.jUf.setLineVisibility(false);
        this.jUg = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jUh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jUh.setText(R.string.reply);
        this.jUi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jUi.setVisibility(0);
        this.jUi.setText(R.string.action_praise_default);
        this.jUj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jUj.setText(R.string.mention_atme);
        this.jUk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jUk.setText(R.string.new_fans);
        this.jUl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jUl.setText(R.string.chat_msg_text);
        this.jUm = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jUm.setLineVisibility(false);
        this.jUm.setText(R.string.group_chat_text);
        this.jUn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jUn.setText(R.string.remind_screen_lock);
        this.jUn.setLineVisibility(false);
        this.jUo = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jUo.setText(R.string.remind_tone);
        this.jUp = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jUp.setText(R.string.remind_vibrate);
        this.jUq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jUq.setLineVisibility(true);
        this.jUq.setText(R.string.remind_light);
        this.jUr = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jUr.setText(R.string.sign_remind_outline);
        this.jUs = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jUt = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jUu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jUu.setText(R.string.no_disturb_mode);
        this.jUu.setLineVisibility(false);
        this.jUv = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jUw = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jUz = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jUA = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jUB = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jUC = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jUE = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cGn() {
        cGo();
        cGp();
        cGq();
        cGr();
    }

    private void cGo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jUu.setVisibility(8);
            this.jUv.setVisibility(8);
            this.jUf.setVisibility(8);
            this.jUg.setVisibility(8);
            this.jUr.setVisibility(8);
            this.jUs.setVisibility(8);
            this.jUo.setVisibility(8);
            this.jUp.setVisibility(8);
            this.jUq.setVisibility(8);
            this.jUn.setVisibility(8);
        }
    }

    private void cGp() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jUn.setLineVisibility(true);
        } else {
            this.jUn.setLineVisibility(false);
        }
    }

    private void cGq() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jUl.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jUm.setVisibility(0);
        } else {
            this.jUm.setVisibility(8);
        }
    }

    private void cGr() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jUn.setVisibility(0);
        } else {
            this.jUn.setVisibility(8);
        }
    }

    public View AA() {
        return this.mBack;
    }

    private void cGs() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLo()) {
            this.jUf.turnOnNoCallback();
            this.jUg.setVisibility(0);
        } else {
            this.jUf.turnOffNoCallback();
            this.jUg.setVisibility(8);
        }
        this.jUh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLt());
        this.jUi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLD());
        this.jUj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLr());
        this.jUk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLs());
        this.jUl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLu());
        this.jUm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLC());
    }

    private void cGt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().isSignAlertOn()) {
            this.jUr.turnOn();
            this.jUs.setVisibility(0);
            this.jUr.setLineVisibility(true);
            cGx();
            return;
        }
        this.jUr.turnOff();
        this.jUr.setLineVisibility(false);
        this.jUs.setVisibility(8);
    }

    private void cGu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLv()) {
            this.jUo.turnOnNoCallback();
        } else {
            this.jUo.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLy()) {
            this.jUp.turnOnNoCallback();
        } else {
            this.jUp.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLw()) {
            this.jUq.turnOnNoCallback();
        } else {
            this.jUq.turnOffNoCallback();
        }
    }

    private void cGv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLE()) {
            this.jUn.turnOnNoCallback();
        } else {
            this.jUn.turnOffNoCallback();
        }
    }

    private void cGw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLx()) {
            this.jUu.turnOnNoCallback();
            this.jUv.setVisibility(0);
            cGy();
            return;
        }
        this.jUu.turnOffNoCallback();
        this.jUv.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jUf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUs.setOnClickListener(msgRemindActivity);
        this.jUu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jUv.setOnClickListener(msgRemindActivity);
        this.jUz.setOnClickListener(msgRemindActivity);
        this.jUB.setOnClickListener(msgRemindActivity);
        this.jUE.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sq(boolean z) {
        this.jUu.setLineVisibility(z);
        if (z) {
            this.jUv.setVisibility(0);
            cGy();
            am.setBackgroundResource(this.jUv, R.drawable.more_all);
            return;
        }
        this.jUv.setVisibility(8);
    }

    public void sr(boolean z) {
        if (z) {
            this.jUs.setVisibility(0);
            this.jUr.setLineVisibility(true);
            am.setBackgroundResource(this.jUs, R.drawable.more_all);
            return;
        }
        this.jUs.setVisibility(8);
        this.jUr.setLineVisibility(false);
    }

    public void ss(boolean z) {
        if (z) {
            this.jUg.setVisibility(0);
        } else {
            this.jUg.setVisibility(8);
        }
    }

    public void cGx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aLm().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aLm().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aLm().getSignAlertMins();
            this.jUt.setText(this.jUD.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jUs.setVisibility(0);
            if (!this.jUr.isOn()) {
                this.jUr.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jUt.setText(R.string.close);
        this.jUs.setVisibility(8);
        if (this.jUr.isOn()) {
            this.jUr.turnOffNoCallback();
        }
    }

    public void cGy() {
        String aLz = com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLz();
        String aLA = com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLA();
        this.jUw.setText(aLz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aLA);
        this.jUA.setText(aLz);
        this.jUC.setText(aLA);
    }

    public BdSwitchView cGz() {
        return this.jUr.getSwitchView();
    }

    public BdSwitchView cGA() {
        return this.jUf.getSwitchView();
    }

    public View cGB() {
        return this.jUs;
    }

    public BdSwitchView cGC() {
        return this.jUu.getSwitchView();
    }

    public View cGD() {
        return this.jUv;
    }

    public LinearLayout cGE() {
        return this.jUz;
    }

    public LinearLayout cGF() {
        return this.jUB;
    }

    public BdSwitchView cGG() {
        return this.jUo.getSwitchView();
    }

    public BdSwitchView cGH() {
        return this.jUp.getSwitchView();
    }

    public BdSwitchView cGI() {
        return this.jUq.getSwitchView();
    }

    public BdSwitchView cGJ() {
        return this.jUn.getSwitchView();
    }

    public BdSwitchView cGK() {
        return this.jUh.getSwitchView();
    }

    public BdSwitchView cGL() {
        return this.jUi.getSwitchView();
    }

    public BdSwitchView cGM() {
        return this.jUj.getSwitchView();
    }

    public BdSwitchView cGN() {
        return this.jUl.getSwitchView();
    }

    public BdSwitchView cGO() {
        return this.jUm.getSwitchView();
    }

    public BdSwitchView cGP() {
        return this.jUk.getSwitchView();
    }

    public TbSettingTextTipView cGQ() {
        return this.jUE;
    }

    public TextView cGR() {
        return this.mNavigationBar.getCenterText();
    }

    public void cGS() {
        this.jUh.setOnSwitchStateChangeListener(null);
        this.jUh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLt());
        this.jUh.setOnSwitchStateChangeListener(this.jUD);
    }

    public void cGT() {
        this.jUi.setOnSwitchStateChangeListener(null);
        this.jUi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLD());
        this.jUi.setOnSwitchStateChangeListener(this.jUD);
    }

    public void cGU() {
        this.jUj.setOnSwitchStateChangeListener(null);
        this.jUj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLr());
        this.jUj.setOnSwitchStateChangeListener(this.jUD);
    }

    public void cGV() {
        this.jUk.setOnSwitchStateChangeListener(null);
        this.jUk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLs());
        this.jUk.setOnSwitchStateChangeListener(this.jUD);
    }

    public void cGW() {
        this.jUl.setOnSwitchStateChangeListener(null);
        this.jUl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLu());
        this.jUl.setOnSwitchStateChangeListener(this.jUD);
    }

    public void cGX() {
        this.jUm.setOnSwitchStateChangeListener(null);
        this.jUm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLC());
        this.jUm.setOnSwitchStateChangeListener(this.jUD);
    }

    public void st(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jUD.getString(R.string.msg_remind));
                this.jUx.setVisibility(0);
                this.jUy.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jUD.getString(R.string.no_disturb_mode_time));
            this.jUy.setVisibility(0);
            this.jUx.setVisibility(8);
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
        this.jUD.getLayoutMode().setNightMode(i == 1);
        this.jUD.getLayoutMode().onModeChanged(this.hsl);
        this.mNavigationBar.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUf.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUh.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUi.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUj.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUk.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUl.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUm.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUn.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUo.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUp.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUq.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUr.onChangeSkinType(this.jUD.getPageContext(), i);
        this.jUu.onChangeSkinType(this.jUD.getPageContext(), i);
        am.setBackgroundResource(this.jUv, R.drawable.more_all);
        am.setBackgroundResource(this.jUz, R.drawable.more_all);
        am.setBackgroundResource(this.jUB, R.drawable.more_all);
        am.setBackgroundResource(this.jUs, R.drawable.more_all);
        SvgManager.aGC().a((ImageView) this.jUv.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a((ImageView) this.jUs.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a((ImageView) this.jUz.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aGC().a((ImageView) this.jUB.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cGY() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aLH().a(this.jUD.getActivity(), this.hsl);
    }

    public void onDestroy() {
    }
}
