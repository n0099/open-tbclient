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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View cfi;
    private MsgSettingItemView iTA;
    private LinearLayout iTB;
    private MsgSettingItemView iTC;
    private MsgSettingItemView iTD;
    private MsgSettingItemView iTE;
    private MsgSettingItemView iTF;
    private MsgSettingItemView iTG;
    private MsgSettingItemView iTH;
    private MsgSettingItemView iTI;
    private MsgSettingItemView iTJ;
    private MsgSettingItemView iTK;
    private MsgSettingItemView iTL;
    private MsgSettingItemView iTM;
    private LinearLayout iTN;
    private TextView iTO;
    private MsgSettingItemView iTP;
    private LinearLayout iTQ;
    private TextView iTR;
    private LinearLayout iTS;
    private LinearLayout iTT;
    private LinearLayout iTU;
    private TextView iTV;
    private LinearLayout iTW;
    private TextView iTX;
    public boolean iTY;
    private MsgRemindActivity iTZ;
    private TbSettingTextTipView iUa;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iTY = true;
        this.iTZ = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        clh();
        clk();
        clj();
        cli();
        cll();
        d(msgRemindActivity);
        clb();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTS = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iTT = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iTA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iTA.setText(R.string.receive_msg_text);
        this.iTA.setLineVisibility(false);
        this.iTB = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iTC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iTC.setText(R.string.reply);
        this.iTD = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iTD.setVisibility(0);
        this.iTD.setText(R.string.action_praise_default);
        this.iTE = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iTE.setText(R.string.mention_atme);
        this.iTF = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iTF.setText(R.string.new_fans);
        this.iTG = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iTG.setText(R.string.chat_msg_text);
        this.iTH = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iTH.setLineVisibility(false);
        this.iTH.setText(R.string.group_chat_text);
        this.iTI = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iTI.setText(R.string.remind_screen_lock);
        this.iTI.setLineVisibility(false);
        this.iTJ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iTJ.setText(R.string.remind_tone);
        this.iTK = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iTK.setText(R.string.remind_vibrate);
        this.iTL = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iTL.setLineVisibility(true);
        this.iTL.setText(R.string.remind_light);
        this.iTM = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iTM.setText(R.string.sign_remind_outline);
        this.iTN = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iTO = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iTP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iTP.setText(R.string.no_disturb_mode);
        this.iTP.setLineVisibility(false);
        this.iTQ = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iTR = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iTU = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iTV = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iTW = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iTX = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iUa = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void clb() {
        clc();
        cld();
        cle();
        clf();
    }

    private void clc() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iTP.setVisibility(8);
            this.iTQ.setVisibility(8);
            this.iTA.setVisibility(8);
            this.iTB.setVisibility(8);
            this.iTM.setVisibility(8);
            this.iTN.setVisibility(8);
            this.iTJ.setVisibility(8);
            this.iTK.setVisibility(8);
            this.iTL.setVisibility(8);
            this.iTI.setVisibility(8);
        }
    }

    private void cld() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iTI.setLineVisibility(true);
        } else {
            this.iTI.setLineVisibility(false);
        }
    }

    private void cle() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iTG.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iTH.setVisibility(0);
        } else {
            this.iTH.setVisibility(8);
        }
    }

    private void clf() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iTI.setVisibility(0);
        } else {
            this.iTI.setVisibility(8);
        }
    }

    public View clg() {
        return this.cfi;
    }

    private void clh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoo()) {
            this.iTA.nk();
            this.iTB.setVisibility(0);
        } else {
            this.iTA.nl();
            this.iTB.setVisibility(8);
        }
        this.iTC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aot());
        this.iTD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoD());
        this.iTE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aor());
        this.iTF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aos());
        this.iTG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aou());
        this.iTH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoC());
    }

    private void cli() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().isSignAlertOn()) {
            this.iTM.nm();
            this.iTN.setVisibility(0);
            this.iTM.setLineVisibility(true);
            clm();
            return;
        }
        this.iTM.nn();
        this.iTM.setLineVisibility(false);
        this.iTN.setVisibility(8);
    }

    private void clj() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aov()) {
            this.iTJ.nk();
        } else {
            this.iTJ.nl();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoy()) {
            this.iTK.nk();
        } else {
            this.iTK.nl();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aow()) {
            this.iTL.nk();
        } else {
            this.iTL.nl();
        }
    }

    private void clk() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoE()) {
            this.iTI.nk();
        } else {
            this.iTI.nl();
        }
    }

    private void cll() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().aox()) {
            this.iTP.nk();
            this.iTQ.setVisibility(0);
            cln();
            return;
        }
        this.iTP.nl();
        this.iTQ.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.cfi.setOnClickListener(msgRemindActivity);
        this.iTA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTN.setOnClickListener(msgRemindActivity);
        this.iTP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iTQ.setOnClickListener(msgRemindActivity);
        this.iTU.setOnClickListener(msgRemindActivity);
        this.iTW.setOnClickListener(msgRemindActivity);
        this.iUa.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void qG(boolean z) {
        this.iTP.setLineVisibility(z);
        if (z) {
            this.iTQ.setVisibility(0);
            cln();
            am.k(this.iTQ, R.drawable.more_all);
            return;
        }
        this.iTQ.setVisibility(8);
    }

    public void qH(boolean z) {
        if (z) {
            this.iTN.setVisibility(0);
            this.iTM.setLineVisibility(true);
            am.k(this.iTN, R.drawable.more_all);
            return;
        }
        this.iTN.setVisibility(8);
        this.iTM.setLineVisibility(false);
    }

    public void qI(boolean z) {
        if (z) {
            this.iTB.setVisibility(0);
        } else {
            this.iTB.setVisibility(8);
        }
    }

    public void clm() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aom().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aom().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aom().getSignAlertMins();
            this.iTO.setText(this.iTZ.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iTN.setVisibility(0);
            if (!this.iTM.iN()) {
                this.iTM.nk();
                return;
            }
            return;
        }
        this.iTO.setText(R.string.close);
        this.iTN.setVisibility(8);
        if (this.iTM.iN()) {
            this.iTM.nl();
        }
    }

    public void cln() {
        String aoz = com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoz();
        String aoA = com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoA();
        this.iTR.setText(aoz + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoA);
        this.iTV.setText(aoz);
        this.iTX.setText(aoA);
    }

    public BdSwitchView clo() {
        return this.iTM.getSwitchView();
    }

    public BdSwitchView clp() {
        return this.iTA.getSwitchView();
    }

    public View clq() {
        return this.iTN;
    }

    public BdSwitchView clr() {
        return this.iTP.getSwitchView();
    }

    public View cls() {
        return this.iTQ;
    }

    public LinearLayout clt() {
        return this.iTU;
    }

    public LinearLayout clu() {
        return this.iTW;
    }

    public BdSwitchView clv() {
        return this.iTJ.getSwitchView();
    }

    public BdSwitchView clw() {
        return this.iTK.getSwitchView();
    }

    public BdSwitchView clx() {
        return this.iTL.getSwitchView();
    }

    public BdSwitchView cly() {
        return this.iTI.getSwitchView();
    }

    public BdSwitchView clz() {
        return this.iTC.getSwitchView();
    }

    public BdSwitchView clA() {
        return this.iTD.getSwitchView();
    }

    public BdSwitchView clB() {
        return this.iTE.getSwitchView();
    }

    public BdSwitchView clC() {
        return this.iTG.getSwitchView();
    }

    public BdSwitchView clD() {
        return this.iTH.getSwitchView();
    }

    public BdSwitchView clE() {
        return this.iTF.getSwitchView();
    }

    public TbSettingTextTipView clF() {
        return this.iUa;
    }

    public TextView clG() {
        return this.mNavigationBar.getCenterText();
    }

    public void clH() {
        this.iTC.setOnSwitchStateChangeListener(null);
        this.iTC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aot());
        this.iTC.setOnSwitchStateChangeListener(this.iTZ);
    }

    public void clI() {
        this.iTD.setOnSwitchStateChangeListener(null);
        this.iTD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoD());
        this.iTD.setOnSwitchStateChangeListener(this.iTZ);
    }

    public void clJ() {
        this.iTE.setOnSwitchStateChangeListener(null);
        this.iTE.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aor());
        this.iTE.setOnSwitchStateChangeListener(this.iTZ);
    }

    public void clK() {
        this.iTF.setOnSwitchStateChangeListener(null);
        this.iTF.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aos());
        this.iTF.setOnSwitchStateChangeListener(this.iTZ);
    }

    public void clL() {
        this.iTG.setOnSwitchStateChangeListener(null);
        this.iTG.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aou());
        this.iTG.setOnSwitchStateChangeListener(this.iTZ);
    }

    public void clM() {
        this.iTH.setOnSwitchStateChangeListener(null);
        this.iTH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoC());
        this.iTH.setOnSwitchStateChangeListener(this.iTZ);
    }

    public void qJ(boolean z) {
        if (this.iTY != z) {
            this.iTY = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iTZ.getString(R.string.msg_remind));
                this.iTS.setVisibility(0);
                this.iTT.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iTZ.getString(R.string.no_disturb_mode_time));
            this.iTT.setVisibility(0);
            this.iTS.setVisibility(8);
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
        this.iTZ.getLayoutMode().setNightMode(i == 1);
        this.iTZ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTA.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTC.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTD.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTE.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTF.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTG.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTH.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTI.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTJ.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTK.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTL.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTM.onChangeSkinType(this.iTZ.getPageContext(), i);
        this.iTP.onChangeSkinType(this.iTZ.getPageContext(), i);
        am.k(this.iTQ, R.drawable.more_all);
        am.k(this.iTU, R.drawable.more_all);
        am.k(this.iTW, R.drawable.more_all);
        am.k(this.iTN, R.drawable.more_all);
        am.c((ImageView) this.iTQ.findViewById(R.id.no_disturb_mode_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        am.c((ImageView) this.iTN.findViewById(R.id.sign_remind_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        am.c((ImageView) this.iTU.findViewById(R.id.no_disturb_start_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        am.c((ImageView) this.iTW.findViewById(R.id.no_disturb_end_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
    }

    public void clN() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aoH().b(this.iTZ.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
