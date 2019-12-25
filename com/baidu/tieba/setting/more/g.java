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
/* loaded from: classes10.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private RelativeLayout hmv;
    public boolean isFront;
    private MsgSettingItemView jPA;
    private LinearLayout jPB;
    private TextView jPC;
    private MsgSettingItemView jPD;
    private LinearLayout jPE;
    private TextView jPF;
    private LinearLayout jPG;
    private LinearLayout jPH;
    private LinearLayout jPI;
    private TextView jPJ;
    private LinearLayout jPK;
    private TextView jPL;
    private MsgRemindActivity jPM;
    private TbSettingTextTipView jPN;
    private MsgSettingItemView jPo;
    private LinearLayout jPp;
    private MsgSettingItemView jPq;
    private MsgSettingItemView jPr;
    private MsgSettingItemView jPs;
    private MsgSettingItemView jPt;
    private MsgSettingItemView jPu;
    private MsgSettingItemView jPv;
    private MsgSettingItemView jPw;
    private MsgSettingItemView jPx;
    private MsgSettingItemView jPy;
    private MsgSettingItemView jPz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.hmv = null;
        this.mNavigationBar = null;
        this.isFront = true;
        this.jPM = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        cDI();
        cDL();
        cDK();
        cDJ();
        cDM();
        d(msgRemindActivity);
        cDD();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.hmv = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jPG = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.jPH = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.jPo = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.jPo.setText(R.string.receive_msg_text);
        this.jPo.setLineVisibility(false);
        this.jPp = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.jPq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.jPq.setText(R.string.reply);
        this.jPr = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.jPr.setVisibility(0);
        this.jPr.setText(R.string.action_praise_default);
        this.jPs = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.jPs.setText(R.string.mention_atme);
        this.jPt = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.jPt.setText(R.string.new_fans);
        this.jPu = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.jPu.setText(R.string.chat_msg_text);
        this.jPv = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.jPv.setLineVisibility(false);
        this.jPv.setText(R.string.group_chat_text);
        this.jPw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.jPw.setText(R.string.remind_screen_lock);
        this.jPw.setLineVisibility(false);
        this.jPx = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.jPx.setText(R.string.remind_tone);
        this.jPy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.jPy.setText(R.string.remind_vibrate);
        this.jPz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.jPz.setLineVisibility(true);
        this.jPz.setText(R.string.remind_light);
        this.jPA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.jPA.setText(R.string.sign_remind_outline);
        this.jPB = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.jPC = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.jPD = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.jPD.setText(R.string.no_disturb_mode);
        this.jPD.setLineVisibility(false);
        this.jPE = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.jPF = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.jPI = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.jPJ = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.jPK = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.jPL = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.jPN = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void cDD() {
        cDE();
        cDF();
        cDG();
        cDH();
    }

    private void cDE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.jPD.setVisibility(8);
            this.jPE.setVisibility(8);
            this.jPo.setVisibility(8);
            this.jPp.setVisibility(8);
            this.jPA.setVisibility(8);
            this.jPB.setVisibility(8);
            this.jPx.setVisibility(8);
            this.jPy.setVisibility(8);
            this.jPz.setVisibility(8);
            this.jPw.setVisibility(8);
        }
    }

    private void cDF() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.jPw.setLineVisibility(true);
        } else {
            this.jPw.setLineVisibility(false);
        }
    }

    private void cDG() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.jPu.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.jPv.setVisibility(0);
        } else {
            this.jPv.setVisibility(8);
        }
    }

    private void cDH() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.jPw.setVisibility(0);
        } else {
            this.jPw.setVisibility(8);
        }
    }

    public View xR() {
        return this.mBack;
    }

    private void cDI() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIy()) {
            this.jPo.turnOnNoCallback();
            this.jPp.setVisibility(0);
        } else {
            this.jPo.turnOffNoCallback();
            this.jPp.setVisibility(8);
        }
        this.jPq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aID());
        this.jPr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIN());
        this.jPs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIB());
        this.jPt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIC());
        this.jPu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIE());
        this.jPv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIM());
    }

    private void cDJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().isSignAlertOn()) {
            this.jPA.turnOn();
            this.jPB.setVisibility(0);
            this.jPA.setLineVisibility(true);
            cDN();
            return;
        }
        this.jPA.turnOff();
        this.jPA.setLineVisibility(false);
        this.jPB.setVisibility(8);
    }

    private void cDK() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIF()) {
            this.jPx.turnOnNoCallback();
        } else {
            this.jPx.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aII()) {
            this.jPy.turnOnNoCallback();
        } else {
            this.jPy.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIG()) {
            this.jPz.turnOnNoCallback();
        } else {
            this.jPz.turnOffNoCallback();
        }
    }

    private void cDL() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIO()) {
            this.jPw.turnOnNoCallback();
        } else {
            this.jPw.turnOffNoCallback();
        }
    }

    private void cDM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIH()) {
            this.jPD.turnOnNoCallback();
            this.jPE.setVisibility(0);
            cDO();
            return;
        }
        this.jPD.turnOffNoCallback();
        this.jPE.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.jPo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPB.setOnClickListener(msgRemindActivity);
        this.jPD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.jPE.setOnClickListener(msgRemindActivity);
        this.jPI.setOnClickListener(msgRemindActivity);
        this.jPK.setOnClickListener(msgRemindActivity);
        this.jPN.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void sb(boolean z) {
        this.jPD.setLineVisibility(z);
        if (z) {
            this.jPE.setVisibility(0);
            cDO();
            am.setBackgroundResource(this.jPE, R.drawable.more_all);
            return;
        }
        this.jPE.setVisibility(8);
    }

    public void sc(boolean z) {
        if (z) {
            this.jPB.setVisibility(0);
            this.jPA.setLineVisibility(true);
            am.setBackgroundResource(this.jPB, R.drawable.more_all);
            return;
        }
        this.jPB.setVisibility(8);
        this.jPA.setLineVisibility(false);
    }

    public void sd(boolean z) {
        if (z) {
            this.jPp.setVisibility(0);
        } else {
            this.jPp.setVisibility(8);
        }
    }

    public void cDN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aIw().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aIw().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aIw().getSignAlertMins();
            this.jPC.setText(this.jPM.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.jPB.setVisibility(0);
            if (!this.jPA.isOn()) {
                this.jPA.turnOnNoCallback();
                return;
            }
            return;
        }
        this.jPC.setText(R.string.close);
        this.jPB.setVisibility(8);
        if (this.jPA.isOn()) {
            this.jPA.turnOffNoCallback();
        }
    }

    public void cDO() {
        String aIJ = com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIJ();
        String aIK = com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIK();
        this.jPF.setText(aIJ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aIK);
        this.jPJ.setText(aIJ);
        this.jPL.setText(aIK);
    }

    public BdSwitchView cDP() {
        return this.jPA.getSwitchView();
    }

    public BdSwitchView cDQ() {
        return this.jPo.getSwitchView();
    }

    public View cDR() {
        return this.jPB;
    }

    public BdSwitchView cDS() {
        return this.jPD.getSwitchView();
    }

    public View cDT() {
        return this.jPE;
    }

    public LinearLayout cDU() {
        return this.jPI;
    }

    public LinearLayout cDV() {
        return this.jPK;
    }

    public BdSwitchView cDW() {
        return this.jPx.getSwitchView();
    }

    public BdSwitchView cDX() {
        return this.jPy.getSwitchView();
    }

    public BdSwitchView cDY() {
        return this.jPz.getSwitchView();
    }

    public BdSwitchView cDZ() {
        return this.jPw.getSwitchView();
    }

    public BdSwitchView cEa() {
        return this.jPq.getSwitchView();
    }

    public BdSwitchView cEb() {
        return this.jPr.getSwitchView();
    }

    public BdSwitchView cEc() {
        return this.jPs.getSwitchView();
    }

    public BdSwitchView cEd() {
        return this.jPu.getSwitchView();
    }

    public BdSwitchView cEe() {
        return this.jPv.getSwitchView();
    }

    public BdSwitchView cEf() {
        return this.jPt.getSwitchView();
    }

    public TbSettingTextTipView cEg() {
        return this.jPN;
    }

    public TextView cEh() {
        return this.mNavigationBar.getCenterText();
    }

    public void cEi() {
        this.jPq.setOnSwitchStateChangeListener(null);
        this.jPq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aID());
        this.jPq.setOnSwitchStateChangeListener(this.jPM);
    }

    public void cEj() {
        this.jPr.setOnSwitchStateChangeListener(null);
        this.jPr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIN());
        this.jPr.setOnSwitchStateChangeListener(this.jPM);
    }

    public void cEk() {
        this.jPs.setOnSwitchStateChangeListener(null);
        this.jPs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIB());
        this.jPs.setOnSwitchStateChangeListener(this.jPM);
    }

    public void cEl() {
        this.jPt.setOnSwitchStateChangeListener(null);
        this.jPt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIC());
        this.jPt.setOnSwitchStateChangeListener(this.jPM);
    }

    public void cEm() {
        this.jPu.setOnSwitchStateChangeListener(null);
        this.jPu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIE());
        this.jPu.setOnSwitchStateChangeListener(this.jPM);
    }

    public void cEn() {
        this.jPv.setOnSwitchStateChangeListener(null);
        this.jPv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIM());
        this.jPv.setOnSwitchStateChangeListener(this.jPM);
    }

    public void se(boolean z) {
        if (this.isFront != z) {
            this.isFront = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.jPM.getString(R.string.msg_remind));
                this.jPG.setVisibility(0);
                this.jPH.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.jPM.getString(R.string.no_disturb_mode_time));
            this.jPH.setVisibility(0);
            this.jPG.setVisibility(8);
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
        this.jPM.getLayoutMode().setNightMode(i == 1);
        this.jPM.getLayoutMode().onModeChanged(this.hmv);
        this.mNavigationBar.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPo.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPq.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPr.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPs.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPt.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPu.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPv.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPw.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPx.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPy.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPz.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPA.onChangeSkinType(this.jPM.getPageContext(), i);
        this.jPD.onChangeSkinType(this.jPM.getPageContext(), i);
        am.setBackgroundResource(this.jPE, R.drawable.more_all);
        am.setBackgroundResource(this.jPI, R.drawable.more_all);
        am.setBackgroundResource(this.jPK, R.drawable.more_all);
        am.setBackgroundResource(this.jPB, R.drawable.more_all);
        SvgManager.aDW().a((ImageView) this.jPE.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aDW().a((ImageView) this.jPB.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aDW().a((ImageView) this.jPI.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aDW().a((ImageView) this.jPK.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cEo() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aIR().a(this.jPM.getActivity(), this.hmv);
    }

    public void onDestroy() {
    }
}
