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
    private View cfb;
    private MsgSettingItemView iSA;
    private MsgSettingItemView iSB;
    private MsgSettingItemView iSC;
    private MsgSettingItemView iSD;
    private MsgSettingItemView iSE;
    private MsgSettingItemView iSF;
    private MsgSettingItemView iSG;
    private MsgSettingItemView iSH;
    private MsgSettingItemView iSI;
    private LinearLayout iSJ;
    private TextView iSK;
    private MsgSettingItemView iSL;
    private LinearLayout iSM;
    private TextView iSN;
    private LinearLayout iSO;
    private LinearLayout iSP;
    private LinearLayout iSQ;
    private TextView iSR;
    private LinearLayout iSS;
    private TextView iST;
    public boolean iSU;
    private MsgRemindActivity iSV;
    private TbSettingTextTipView iSW;
    private MsgSettingItemView iSw;
    private LinearLayout iSx;
    private MsgSettingItemView iSy;
    private MsgSettingItemView iSz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iSU = true;
        this.iSV = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        ckP();
        ckS();
        ckR();
        ckQ();
        ckT();
        d(msgRemindActivity);
        ckJ();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iSO = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iSP = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iSw = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iSw.setText(R.string.receive_msg_text);
        this.iSw.setLineVisibility(false);
        this.iSx = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iSy = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iSy.setText(R.string.reply);
        this.iSz = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iSz.setVisibility(0);
        this.iSz.setText(R.string.action_praise_default);
        this.iSA = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iSA.setText(R.string.mention_atme);
        this.iSB = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iSB.setText(R.string.new_fans);
        this.iSC = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iSC.setText(R.string.chat_msg_text);
        this.iSD = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iSD.setLineVisibility(false);
        this.iSD.setText(R.string.group_chat_text);
        this.iSE = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iSE.setText(R.string.remind_screen_lock);
        this.iSE.setLineVisibility(false);
        this.iSF = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iSF.setText(R.string.remind_tone);
        this.iSG = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iSG.setText(R.string.remind_vibrate);
        this.iSH = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iSH.setLineVisibility(true);
        this.iSH.setText(R.string.remind_light);
        this.iSI = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iSI.setText(R.string.sign_remind_outline);
        this.iSJ = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iSK = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iSL = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iSL.setText(R.string.no_disturb_mode);
        this.iSL.setLineVisibility(false);
        this.iSM = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iSN = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iSQ = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iSR = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iSS = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iST = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iSW = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void ckJ() {
        ckK();
        ckL();
        ckM();
        ckN();
    }

    private void ckK() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iSL.setVisibility(8);
            this.iSM.setVisibility(8);
            this.iSw.setVisibility(8);
            this.iSx.setVisibility(8);
            this.iSI.setVisibility(8);
            this.iSJ.setVisibility(8);
            this.iSF.setVisibility(8);
            this.iSG.setVisibility(8);
            this.iSH.setVisibility(8);
            this.iSE.setVisibility(8);
        }
    }

    private void ckL() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iSE.setLineVisibility(true);
        } else {
            this.iSE.setLineVisibility(false);
        }
    }

    private void ckM() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iSC.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iSD.setVisibility(0);
        } else {
            this.iSD.setVisibility(8);
        }
    }

    private void ckN() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iSE.setVisibility(0);
        } else {
            this.iSE.setVisibility(8);
        }
    }

    public View ckO() {
        return this.cfb;
    }

    private void ckP() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aom()) {
            this.iSw.nk();
            this.iSx.setVisibility(0);
        } else {
            this.iSw.nl();
            this.iSx.setVisibility(8);
        }
        this.iSy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aor());
        this.iSz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoB());
        this.iSA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aop());
        this.iSB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoq());
        this.iSC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aos());
        this.iSD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoA());
    }

    private void ckQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().isSignAlertOn()) {
            this.iSI.nm();
            this.iSJ.setVisibility(0);
            this.iSI.setLineVisibility(true);
            ckU();
            return;
        }
        this.iSI.nn();
        this.iSI.setLineVisibility(false);
        this.iSJ.setVisibility(8);
    }

    private void ckR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aot()) {
            this.iSF.nk();
        } else {
            this.iSF.nl();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aow()) {
            this.iSG.nk();
        } else {
            this.iSG.nl();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aou()) {
            this.iSH.nk();
        } else {
            this.iSH.nl();
        }
    }

    private void ckS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoC()) {
            this.iSE.nk();
        } else {
            this.iSE.nl();
        }
    }

    private void ckT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().aov()) {
            this.iSL.nk();
            this.iSM.setVisibility(0);
            ckV();
            return;
        }
        this.iSL.nl();
        this.iSM.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.cfb.setOnClickListener(msgRemindActivity);
        this.iSw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSJ.setOnClickListener(msgRemindActivity);
        this.iSL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iSM.setOnClickListener(msgRemindActivity);
        this.iSQ.setOnClickListener(msgRemindActivity);
        this.iSS.setOnClickListener(msgRemindActivity);
        this.iSW.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void qF(boolean z) {
        this.iSL.setLineVisibility(z);
        if (z) {
            this.iSM.setVisibility(0);
            ckV();
            am.k(this.iSM, R.drawable.more_all);
            return;
        }
        this.iSM.setVisibility(8);
    }

    public void qG(boolean z) {
        if (z) {
            this.iSJ.setVisibility(0);
            this.iSI.setLineVisibility(true);
            am.k(this.iSJ, R.drawable.more_all);
            return;
        }
        this.iSJ.setVisibility(8);
        this.iSI.setLineVisibility(false);
    }

    public void qH(boolean z) {
        if (z) {
            this.iSx.setVisibility(0);
        } else {
            this.iSx.setVisibility(8);
        }
    }

    public void ckU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aok().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aok().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aok().getSignAlertMins();
            this.iSK.setText(this.iSV.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iSJ.setVisibility(0);
            if (!this.iSI.iN()) {
                this.iSI.nk();
                return;
            }
            return;
        }
        this.iSK.setText(R.string.close);
        this.iSJ.setVisibility(8);
        if (this.iSI.iN()) {
            this.iSI.nl();
        }
    }

    public void ckV() {
        String aox = com.baidu.tbadk.coreExtra.messageCenter.d.aok().aox();
        String aoy = com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoy();
        this.iSN.setText(aox + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoy);
        this.iSR.setText(aox);
        this.iST.setText(aoy);
    }

    public BdSwitchView ckW() {
        return this.iSI.getSwitchView();
    }

    public BdSwitchView ckX() {
        return this.iSw.getSwitchView();
    }

    public View ckY() {
        return this.iSJ;
    }

    public BdSwitchView ckZ() {
        return this.iSL.getSwitchView();
    }

    public View cla() {
        return this.iSM;
    }

    public LinearLayout clb() {
        return this.iSQ;
    }

    public LinearLayout clc() {
        return this.iSS;
    }

    public BdSwitchView cld() {
        return this.iSF.getSwitchView();
    }

    public BdSwitchView cle() {
        return this.iSG.getSwitchView();
    }

    public BdSwitchView clf() {
        return this.iSH.getSwitchView();
    }

    public BdSwitchView clg() {
        return this.iSE.getSwitchView();
    }

    public BdSwitchView clh() {
        return this.iSy.getSwitchView();
    }

    public BdSwitchView cli() {
        return this.iSz.getSwitchView();
    }

    public BdSwitchView clj() {
        return this.iSA.getSwitchView();
    }

    public BdSwitchView clk() {
        return this.iSC.getSwitchView();
    }

    public BdSwitchView cll() {
        return this.iSD.getSwitchView();
    }

    public BdSwitchView clm() {
        return this.iSB.getSwitchView();
    }

    public TbSettingTextTipView cln() {
        return this.iSW;
    }

    public TextView clo() {
        return this.mNavigationBar.getCenterText();
    }

    public void clp() {
        this.iSy.setOnSwitchStateChangeListener(null);
        this.iSy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aor());
        this.iSy.setOnSwitchStateChangeListener(this.iSV);
    }

    public void clq() {
        this.iSz.setOnSwitchStateChangeListener(null);
        this.iSz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoB());
        this.iSz.setOnSwitchStateChangeListener(this.iSV);
    }

    public void clr() {
        this.iSA.setOnSwitchStateChangeListener(null);
        this.iSA.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aop());
        this.iSA.setOnSwitchStateChangeListener(this.iSV);
    }

    public void cls() {
        this.iSB.setOnSwitchStateChangeListener(null);
        this.iSB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoq());
        this.iSB.setOnSwitchStateChangeListener(this.iSV);
    }

    public void clt() {
        this.iSC.setOnSwitchStateChangeListener(null);
        this.iSC.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aos());
        this.iSC.setOnSwitchStateChangeListener(this.iSV);
    }

    public void clu() {
        this.iSD.setOnSwitchStateChangeListener(null);
        this.iSD.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoA());
        this.iSD.setOnSwitchStateChangeListener(this.iSV);
    }

    public void qI(boolean z) {
        if (this.iSU != z) {
            this.iSU = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iSV.getString(R.string.msg_remind));
                this.iSO.setVisibility(0);
                this.iSP.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iSV.getString(R.string.no_disturb_mode_time));
            this.iSP.setVisibility(0);
            this.iSO.setVisibility(8);
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
        this.iSV.getLayoutMode().setNightMode(i == 1);
        this.iSV.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSw.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSy.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSz.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSA.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSB.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSC.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSD.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSE.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSF.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSG.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSH.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSI.onChangeSkinType(this.iSV.getPageContext(), i);
        this.iSL.onChangeSkinType(this.iSV.getPageContext(), i);
        am.k(this.iSM, R.drawable.more_all);
        am.k(this.iSQ, R.drawable.more_all);
        am.k(this.iSS, R.drawable.more_all);
        am.k(this.iSJ, R.drawable.more_all);
        am.c((ImageView) this.iSM.findViewById(R.id.no_disturb_mode_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        am.c((ImageView) this.iSJ.findViewById(R.id.sign_remind_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        am.c((ImageView) this.iSQ.findViewById(R.id.no_disturb_start_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        am.c((ImageView) this.iSS.findViewById(R.id.no_disturb_end_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
    }

    public void clv() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aoF().b(this.iSV.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
