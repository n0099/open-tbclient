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
    private RelativeLayout gze;
    private MsgSettingItemView iVI;
    private LinearLayout iVJ;
    private MsgSettingItemView iVK;
    private MsgSettingItemView iVL;
    private MsgSettingItemView iVM;
    private MsgSettingItemView iVN;
    private MsgSettingItemView iVO;
    private MsgSettingItemView iVP;
    private MsgSettingItemView iVQ;
    private MsgSettingItemView iVR;
    private MsgSettingItemView iVS;
    private MsgSettingItemView iVT;
    private MsgSettingItemView iVU;
    private LinearLayout iVV;
    private TextView iVW;
    private MsgSettingItemView iVX;
    private LinearLayout iVY;
    private TextView iVZ;
    private LinearLayout iWa;
    private LinearLayout iWb;
    private LinearLayout iWc;
    private TextView iWd;
    private LinearLayout iWe;
    private TextView iWf;
    public boolean iWg;
    private MsgRemindActivity iWh;
    private TbSettingTextTipView iWi;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.gze = null;
        this.mNavigationBar = null;
        this.iWg = true;
        this.iWh = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cjG();
        cjJ();
        cjI();
        cjH();
        cjK();
        d(msgRemindActivity);
        cjB();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.gze = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWa = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iWb = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iVI = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iVI.setText(R.string.receive_msg_text);
        this.iVI.setLineVisibility(false);
        this.iVJ = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iVK = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iVK.setText(R.string.reply);
        this.iVL = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iVL.setVisibility(0);
        this.iVL.setText(R.string.action_praise_default);
        this.iVM = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iVM.setText(R.string.mention_atme);
        this.iVN = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iVN.setText(R.string.new_fans);
        this.iVO = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iVO.setText(R.string.chat_msg_text);
        this.iVP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iVP.setLineVisibility(false);
        this.iVP.setText(R.string.group_chat_text);
        this.iVQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iVQ.setText(R.string.remind_screen_lock);
        this.iVQ.setLineVisibility(false);
        this.iVR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iVR.setText(R.string.remind_tone);
        this.iVS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iVS.setText(R.string.remind_vibrate);
        this.iVT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iVT.setLineVisibility(true);
        this.iVT.setText(R.string.remind_light);
        this.iVU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iVU.setText(R.string.sign_remind_outline);
        this.iVV = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iVW = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iVX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iVX.setText(R.string.no_disturb_mode);
        this.iVX.setLineVisibility(false);
        this.iVY = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iVZ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iWc = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iWd = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iWe = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iWf = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iWi = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cjB() {
        cjC();
        cjD();
        cjE();
        cjF();
    }

    private void cjC() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iVX.setVisibility(8);
            this.iVY.setVisibility(8);
            this.iVI.setVisibility(8);
            this.iVJ.setVisibility(8);
            this.iVU.setVisibility(8);
            this.iVV.setVisibility(8);
            this.iVR.setVisibility(8);
            this.iVS.setVisibility(8);
            this.iVT.setVisibility(8);
            this.iVQ.setVisibility(8);
        }
    }

    private void cjD() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iVQ.setLineVisibility(true);
        } else {
            this.iVQ.setLineVisibility(false);
        }
    }

    private void cjE() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iVO.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iVP.setVisibility(0);
        } else {
            this.iVP.setVisibility(8);
        }
    }

    private void cjF() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iVQ.setVisibility(0);
        } else {
            this.iVQ.setVisibility(8);
        }
    }

    public View vS() {
        return this.mBack;
    }

    private void cjG() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().arc()) {
            this.iVI.turnOnNoCallback();
            this.iVJ.setVisibility(0);
        } else {
            this.iVI.turnOffNoCallback();
            this.iVJ.setVisibility(8);
        }
        this.iVK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arh());
        this.iVL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arr());
        this.iVM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arf());
        this.iVN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arg());
        this.iVO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().ari());
        this.iVP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arq());
    }

    private void cjH() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().isSignAlertOn()) {
            this.iVU.turnOn();
            this.iVV.setVisibility(0);
            this.iVU.setLineVisibility(true);
            cjL();
            return;
        }
        this.iVU.turnOff();
        this.iVU.setLineVisibility(false);
        this.iVV.setVisibility(8);
    }

    private void cjI() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().arj()) {
            this.iVR.turnOnNoCallback();
        } else {
            this.iVR.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().arm()) {
            this.iVS.turnOnNoCallback();
        } else {
            this.iVS.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().ark()) {
            this.iVT.turnOnNoCallback();
        } else {
            this.iVT.turnOffNoCallback();
        }
    }

    private void cjJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().ars()) {
            this.iVQ.turnOnNoCallback();
        } else {
            this.iVQ.turnOffNoCallback();
        }
    }

    private void cjK() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().arl()) {
            this.iVX.turnOnNoCallback();
            this.iVY.setVisibility(0);
            cjM();
            return;
        }
        this.iVX.turnOffNoCallback();
        this.iVY.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.iVI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVV.setOnClickListener(msgRemindActivity);
        this.iVX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVY.setOnClickListener(msgRemindActivity);
        this.iWc.setOnClickListener(msgRemindActivity);
        this.iWe.setOnClickListener(msgRemindActivity);
        this.iWi.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void qs(boolean z) {
        this.iVX.setLineVisibility(z);
        if (z) {
            this.iVY.setVisibility(0);
            cjM();
            am.setBackgroundResource(this.iVY, R.drawable.more_all);
            return;
        }
        this.iVY.setVisibility(8);
    }

    public void qt(boolean z) {
        if (z) {
            this.iVV.setVisibility(0);
            this.iVU.setLineVisibility(true);
            am.setBackgroundResource(this.iVV, R.drawable.more_all);
            return;
        }
        this.iVV.setVisibility(8);
        this.iVU.setLineVisibility(false);
    }

    public void qu(boolean z) {
        if (z) {
            this.iVJ.setVisibility(0);
        } else {
            this.iVJ.setVisibility(8);
        }
    }

    public void cjL() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.ara().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.ara().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.ara().getSignAlertMins();
            this.iVW.setText(this.iWh.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iVV.setVisibility(0);
            if (!this.iVU.isOn()) {
                this.iVU.turnOnNoCallback();
                return;
            }
            return;
        }
        this.iVW.setText(R.string.close);
        this.iVV.setVisibility(8);
        if (this.iVU.isOn()) {
            this.iVU.turnOffNoCallback();
        }
    }

    public void cjM() {
        String arn = com.baidu.tbadk.coreExtra.messageCenter.d.ara().arn();
        String aro = com.baidu.tbadk.coreExtra.messageCenter.d.ara().aro();
        this.iVZ.setText(arn + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aro);
        this.iWd.setText(arn);
        this.iWf.setText(aro);
    }

    public BdSwitchView cjN() {
        return this.iVU.getSwitchView();
    }

    public BdSwitchView cjO() {
        return this.iVI.getSwitchView();
    }

    public View cjP() {
        return this.iVV;
    }

    public BdSwitchView cjQ() {
        return this.iVX.getSwitchView();
    }

    public View cjR() {
        return this.iVY;
    }

    public LinearLayout cjS() {
        return this.iWc;
    }

    public LinearLayout cjT() {
        return this.iWe;
    }

    public BdSwitchView cjU() {
        return this.iVR.getSwitchView();
    }

    public BdSwitchView cjV() {
        return this.iVS.getSwitchView();
    }

    public BdSwitchView cjW() {
        return this.iVT.getSwitchView();
    }

    public BdSwitchView cjX() {
        return this.iVQ.getSwitchView();
    }

    public BdSwitchView cjY() {
        return this.iVK.getSwitchView();
    }

    public BdSwitchView cjZ() {
        return this.iVL.getSwitchView();
    }

    public BdSwitchView cka() {
        return this.iVM.getSwitchView();
    }

    public BdSwitchView ckb() {
        return this.iVO.getSwitchView();
    }

    public BdSwitchView ckc() {
        return this.iVP.getSwitchView();
    }

    public BdSwitchView ckd() {
        return this.iVN.getSwitchView();
    }

    public TbSettingTextTipView cke() {
        return this.iWi;
    }

    public TextView ckf() {
        return this.mNavigationBar.getCenterText();
    }

    public void ckg() {
        this.iVK.setOnSwitchStateChangeListener(null);
        this.iVK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arh());
        this.iVK.setOnSwitchStateChangeListener(this.iWh);
    }

    public void ckh() {
        this.iVL.setOnSwitchStateChangeListener(null);
        this.iVL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arr());
        this.iVL.setOnSwitchStateChangeListener(this.iWh);
    }

    public void cki() {
        this.iVM.setOnSwitchStateChangeListener(null);
        this.iVM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arf());
        this.iVM.setOnSwitchStateChangeListener(this.iWh);
    }

    public void ckj() {
        this.iVN.setOnSwitchStateChangeListener(null);
        this.iVN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arg());
        this.iVN.setOnSwitchStateChangeListener(this.iWh);
    }

    public void ckk() {
        this.iVO.setOnSwitchStateChangeListener(null);
        this.iVO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().ari());
        this.iVO.setOnSwitchStateChangeListener(this.iWh);
    }

    public void ckl() {
        this.iVP.setOnSwitchStateChangeListener(null);
        this.iVP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.ara().arq());
        this.iVP.setOnSwitchStateChangeListener(this.iWh);
    }

    public void qv(boolean z) {
        if (this.iWg != z) {
            this.iWg = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iWh.getString(R.string.msg_remind));
                this.iWa.setVisibility(0);
                this.iWb.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iWh.getString(R.string.no_disturb_mode_time));
            this.iWb.setVisibility(0);
            this.iWa.setVisibility(8);
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
        this.iWh.getLayoutMode().setNightMode(i == 1);
        this.iWh.getLayoutMode().onModeChanged(this.gze);
        this.mNavigationBar.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVI.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVK.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVL.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVM.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVN.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVO.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVP.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVQ.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVR.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVS.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVT.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVU.onChangeSkinType(this.iWh.getPageContext(), i);
        this.iVX.onChangeSkinType(this.iWh.getPageContext(), i);
        am.setBackgroundResource(this.iVY, R.drawable.more_all);
        am.setBackgroundResource(this.iWc, R.drawable.more_all);
        am.setBackgroundResource(this.iWe, R.drawable.more_all);
        am.setBackgroundResource(this.iVV, R.drawable.more_all);
        SvgManager.amN().a((ImageView) this.iVY.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.amN().a((ImageView) this.iVV.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.amN().a((ImageView) this.iWc.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.amN().a((ImageView) this.iWe.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void ckm() {
        com.baidu.tbadk.coreExtra.messageCenter.f.arv().b(this.iWh.getActivity(), this.gze);
    }

    public void onDestroy() {
    }
}
