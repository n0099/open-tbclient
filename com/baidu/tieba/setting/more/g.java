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
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private RelativeLayout gyn;
    private MsgSettingItemView iUR;
    private LinearLayout iUS;
    private MsgSettingItemView iUT;
    private MsgSettingItemView iUU;
    private MsgSettingItemView iUV;
    private MsgSettingItemView iUW;
    private MsgSettingItemView iUX;
    private MsgSettingItemView iUY;
    private MsgSettingItemView iUZ;
    private MsgSettingItemView iVa;
    private MsgSettingItemView iVb;
    private MsgSettingItemView iVc;
    private MsgSettingItemView iVd;
    private LinearLayout iVe;
    private TextView iVf;
    private MsgSettingItemView iVg;
    private LinearLayout iVh;
    private TextView iVi;
    private LinearLayout iVj;
    private LinearLayout iVk;
    private LinearLayout iVl;
    private TextView iVm;
    private LinearLayout iVn;
    private TextView iVo;
    public boolean iVp;
    private MsgRemindActivity iVq;
    private TbSettingTextTipView iVr;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.gyn = null;
        this.mNavigationBar = null;
        this.iVp = true;
        this.iVq = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cjE();
        cjH();
        cjG();
        cjF();
        cjI();
        d(msgRemindActivity);
        cjz();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.gyn = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVj = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iVk = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iUR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iUR.setText(R.string.receive_msg_text);
        this.iUR.setLineVisibility(false);
        this.iUS = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iUT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iUT.setText(R.string.reply);
        this.iUU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iUU.setVisibility(0);
        this.iUU.setText(R.string.action_praise_default);
        this.iUV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iUV.setText(R.string.mention_atme);
        this.iUW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iUW.setText(R.string.new_fans);
        this.iUX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iUX.setText(R.string.chat_msg_text);
        this.iUY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iUY.setLineVisibility(false);
        this.iUY.setText(R.string.group_chat_text);
        this.iUZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iUZ.setText(R.string.remind_screen_lock);
        this.iUZ.setLineVisibility(false);
        this.iVa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iVa.setText(R.string.remind_tone);
        this.iVb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iVb.setText(R.string.remind_vibrate);
        this.iVc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iVc.setLineVisibility(true);
        this.iVc.setText(R.string.remind_light);
        this.iVd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iVd.setText(R.string.sign_remind_outline);
        this.iVe = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iVf = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iVg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iVg.setText(R.string.no_disturb_mode);
        this.iVg.setLineVisibility(false);
        this.iVh = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iVi = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iVl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iVm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iVn = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iVo = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iVr = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cjz() {
        cjA();
        cjB();
        cjC();
        cjD();
    }

    private void cjA() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iVg.setVisibility(8);
            this.iVh.setVisibility(8);
            this.iUR.setVisibility(8);
            this.iUS.setVisibility(8);
            this.iVd.setVisibility(8);
            this.iVe.setVisibility(8);
            this.iVa.setVisibility(8);
            this.iVb.setVisibility(8);
            this.iVc.setVisibility(8);
            this.iUZ.setVisibility(8);
        }
    }

    private void cjB() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iUZ.setLineVisibility(true);
        } else {
            this.iUZ.setLineVisibility(false);
        }
    }

    private void cjC() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iUX.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iUY.setVisibility(0);
        } else {
            this.iUY.setVisibility(8);
        }
    }

    private void cjD() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iUZ.setVisibility(0);
        } else {
            this.iUZ.setVisibility(8);
        }
    }

    public View vT() {
        return this.mBack;
    }

    private void cjE() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ara()) {
            this.iUR.turnOnNoCallback();
            this.iUS.setVisibility(0);
        } else {
            this.iUR.turnOffNoCallback();
            this.iUS.setVisibility(8);
        }
        this.iUT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arf());
        this.iUU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arp());
        this.iUV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ard());
        this.iUW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().are());
        this.iUX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arg());
        this.iUY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().aro());
    }

    private void cjF() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().isSignAlertOn()) {
            this.iVd.turnOn();
            this.iVe.setVisibility(0);
            this.iVd.setLineVisibility(true);
            cjJ();
            return;
        }
        this.iVd.turnOff();
        this.iVd.setLineVisibility(false);
        this.iVe.setVisibility(8);
    }

    private void cjG() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arh()) {
            this.iVa.turnOnNoCallback();
        } else {
            this.iVa.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ark()) {
            this.iVb.turnOnNoCallback();
        } else {
            this.iVb.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ari()) {
            this.iVc.turnOnNoCallback();
        } else {
            this.iVc.turnOffNoCallback();
        }
    }

    private void cjH() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arq()) {
            this.iUZ.turnOnNoCallback();
        } else {
            this.iUZ.turnOffNoCallback();
        }
    }

    private void cjI() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arj()) {
            this.iVg.turnOnNoCallback();
            this.iVh.setVisibility(0);
            cjK();
            return;
        }
        this.iVg.turnOffNoCallback();
        this.iVh.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.iUR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iUZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVe.setOnClickListener(msgRemindActivity);
        this.iVg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVh.setOnClickListener(msgRemindActivity);
        this.iVl.setOnClickListener(msgRemindActivity);
        this.iVn.setOnClickListener(msgRemindActivity);
        this.iVr.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void qs(boolean z) {
        this.iVg.setLineVisibility(z);
        if (z) {
            this.iVh.setVisibility(0);
            cjK();
            am.setBackgroundResource(this.iVh, R.drawable.more_all);
            return;
        }
        this.iVh.setVisibility(8);
    }

    public void qt(boolean z) {
        if (z) {
            this.iVe.setVisibility(0);
            this.iVd.setLineVisibility(true);
            am.setBackgroundResource(this.iVe, R.drawable.more_all);
            return;
        }
        this.iVe.setVisibility(8);
        this.iVd.setLineVisibility(false);
    }

    public void qu(boolean z) {
        if (z) {
            this.iUS.setVisibility(0);
        } else {
            this.iUS.setVisibility(8);
        }
    }

    public void cjJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aqY().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aqY().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aqY().getSignAlertMins();
            this.iVf.setText(this.iVq.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iVe.setVisibility(0);
            if (!this.iVd.isOn()) {
                this.iVd.turnOnNoCallback();
                return;
            }
            return;
        }
        this.iVf.setText(R.string.close);
        this.iVe.setVisibility(8);
        if (this.iVd.isOn()) {
            this.iVd.turnOffNoCallback();
        }
    }

    public void cjK() {
        String arl = com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arl();
        String arm = com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arm();
        this.iVi.setText(arl + Constants.ACCEPT_TIME_SEPARATOR_SERVER + arm);
        this.iVm.setText(arl);
        this.iVo.setText(arm);
    }

    public BdSwitchView cjL() {
        return this.iVd.getSwitchView();
    }

    public BdSwitchView cjM() {
        return this.iUR.getSwitchView();
    }

    public View cjN() {
        return this.iVe;
    }

    public BdSwitchView cjO() {
        return this.iVg.getSwitchView();
    }

    public View cjP() {
        return this.iVh;
    }

    public LinearLayout cjQ() {
        return this.iVl;
    }

    public LinearLayout cjR() {
        return this.iVn;
    }

    public BdSwitchView cjS() {
        return this.iVa.getSwitchView();
    }

    public BdSwitchView cjT() {
        return this.iVb.getSwitchView();
    }

    public BdSwitchView cjU() {
        return this.iVc.getSwitchView();
    }

    public BdSwitchView cjV() {
        return this.iUZ.getSwitchView();
    }

    public BdSwitchView cjW() {
        return this.iUT.getSwitchView();
    }

    public BdSwitchView cjX() {
        return this.iUU.getSwitchView();
    }

    public BdSwitchView cjY() {
        return this.iUV.getSwitchView();
    }

    public BdSwitchView cjZ() {
        return this.iUX.getSwitchView();
    }

    public BdSwitchView cka() {
        return this.iUY.getSwitchView();
    }

    public BdSwitchView ckb() {
        return this.iUW.getSwitchView();
    }

    public TbSettingTextTipView ckc() {
        return this.iVr;
    }

    public TextView ckd() {
        return this.mNavigationBar.getCenterText();
    }

    public void cke() {
        this.iUT.setOnSwitchStateChangeListener(null);
        this.iUT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arf());
        this.iUT.setOnSwitchStateChangeListener(this.iVq);
    }

    public void ckf() {
        this.iUU.setOnSwitchStateChangeListener(null);
        this.iUU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arp());
        this.iUU.setOnSwitchStateChangeListener(this.iVq);
    }

    public void ckg() {
        this.iUV.setOnSwitchStateChangeListener(null);
        this.iUV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ard());
        this.iUV.setOnSwitchStateChangeListener(this.iVq);
    }

    public void ckh() {
        this.iUW.setOnSwitchStateChangeListener(null);
        this.iUW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().are());
        this.iUW.setOnSwitchStateChangeListener(this.iVq);
    }

    public void cki() {
        this.iUX.setOnSwitchStateChangeListener(null);
        this.iUX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arg());
        this.iUX.setOnSwitchStateChangeListener(this.iVq);
    }

    public void ckj() {
        this.iUY.setOnSwitchStateChangeListener(null);
        this.iUY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aqY().aro());
        this.iUY.setOnSwitchStateChangeListener(this.iVq);
    }

    public void qv(boolean z) {
        if (this.iVp != z) {
            this.iVp = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iVq.getString(R.string.msg_remind));
                this.iVj.setVisibility(0);
                this.iVk.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iVq.getString(R.string.no_disturb_mode_time));
            this.iVk.setVisibility(0);
            this.iVj.setVisibility(8);
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
        this.iVq.getLayoutMode().setNightMode(i == 1);
        this.iVq.getLayoutMode().onModeChanged(this.gyn);
        this.mNavigationBar.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUR.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUT.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUU.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUV.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUW.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUX.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUY.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iUZ.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iVa.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iVb.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iVc.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iVd.onChangeSkinType(this.iVq.getPageContext(), i);
        this.iVg.onChangeSkinType(this.iVq.getPageContext(), i);
        am.setBackgroundResource(this.iVh, R.drawable.more_all);
        am.setBackgroundResource(this.iVl, R.drawable.more_all);
        am.setBackgroundResource(this.iVn, R.drawable.more_all);
        am.setBackgroundResource(this.iVe, R.drawable.more_all);
        SvgManager.amL().a((ImageView) this.iVh.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.amL().a((ImageView) this.iVe.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.amL().a((ImageView) this.iVl.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.amL().a((ImageView) this.iVn.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void ckk() {
        com.baidu.tbadk.coreExtra.messageCenter.f.art().b(this.iVq.getActivity(), this.gyn);
    }

    public void onDestroy() {
    }
}
