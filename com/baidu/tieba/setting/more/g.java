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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View bVY;
    private MsgSettingItemView itF;
    private LinearLayout itG;
    private MsgSettingItemView itH;
    private MsgSettingItemView itI;
    private MsgSettingItemView itJ;
    private MsgSettingItemView itK;
    private MsgSettingItemView itL;
    private MsgSettingItemView itM;
    private MsgSettingItemView itN;
    private MsgSettingItemView itO;
    private MsgSettingItemView itP;
    private MsgSettingItemView itQ;
    private MsgSettingItemView itR;
    private LinearLayout itS;
    private TextView itT;
    private MsgSettingItemView itU;
    private LinearLayout itV;
    private TextView itW;
    private LinearLayout itX;
    private LinearLayout itY;
    private LinearLayout itZ;
    private TextView iua;
    private LinearLayout iub;
    private TextView iuc;
    public boolean iud;
    private MsgRemindActivity iue;
    private TbSettingTextTipView iuf;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iud = true;
        this.iue = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bZS();
        bZV();
        bZU();
        bZT();
        bZW();
        d(msgRemindActivity);
        bZM();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.itX = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.itY = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.itF = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.itF.setText(d.j.receive_msg_text);
        this.itF.setLineVisibility(false);
        this.itG = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.itH = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.itH.setText(d.j.reply);
        this.itI = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.itI.setVisibility(0);
        this.itI.setText(d.j.action_praise_default);
        this.itJ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.itJ.setText(d.j.mention_atme);
        this.itK = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.itK.setText(d.j.new_fans);
        this.itL = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.itL.setText(d.j.chat_msg_text);
        this.itM = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.itM.setLineVisibility(false);
        this.itM.setText(d.j.group_chat_text);
        this.itN = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.itN.setText(d.j.remind_screen_lock);
        this.itN.setLineVisibility(false);
        this.itO = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.itO.setText(d.j.remind_tone);
        this.itP = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.itP.setText(d.j.remind_vibrate);
        this.itQ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.itQ.setLineVisibility(true);
        this.itQ.setText(d.j.remind_light);
        this.itR = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.itR.setText(d.j.sign_remind_outline);
        this.itS = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.itT = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.itU = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.itU.setText(d.j.no_disturb_mode);
        this.itU.setLineVisibility(false);
        this.itV = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.itW = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.itZ = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.iua = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.iub = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.iuc = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.iuf = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bZM() {
        bZN();
        bZO();
        bZP();
        bZQ();
    }

    private void bZN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.itU.setVisibility(8);
            this.itV.setVisibility(8);
            this.itF.setVisibility(8);
            this.itG.setVisibility(8);
            this.itR.setVisibility(8);
            this.itS.setVisibility(8);
            this.itO.setVisibility(8);
            this.itP.setVisibility(8);
            this.itQ.setVisibility(8);
            this.itN.setVisibility(8);
        }
    }

    private void bZO() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.itN.setLineVisibility(true);
        } else {
            this.itN.setLineVisibility(false);
        }
    }

    private void bZP() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.itL.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.itM.setVisibility(0);
        } else {
            this.itM.setVisibility(8);
        }
    }

    private void bZQ() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.itN.setVisibility(0);
        } else {
            this.itN.setVisibility(8);
        }
    }

    public View bZR() {
        return this.bVY;
    }

    private void bZS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aij()) {
            this.itF.nY();
            this.itG.setVisibility(0);
        } else {
            this.itF.nZ();
            this.itG.setVisibility(8);
        }
        this.itH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aio());
        this.itI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy());
        this.itJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim());
        this.itK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().ain());
        this.itL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip());
        this.itM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix());
    }

    private void bZT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().isSignAlertOn()) {
            this.itR.oa();
            this.itS.setVisibility(0);
            this.itR.setLineVisibility(true);
            bZX();
            return;
        }
        this.itR.ob();
        this.itR.setLineVisibility(false);
        this.itS.setVisibility(8);
    }

    private void bZU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiq()) {
            this.itO.nY();
        } else {
            this.itO.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().ait()) {
            this.itP.nY();
        } else {
            this.itP.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().air()) {
            this.itQ.nY();
        } else {
            this.itQ.nZ();
        }
    }

    private void bZV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiz()) {
            this.itN.nY();
        } else {
            this.itN.nZ();
        }
    }

    private void bZW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().ais()) {
            this.itU.nY();
            this.itV.setVisibility(0);
            bZY();
            return;
        }
        this.itU.nZ();
        this.itV.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bVY.setOnClickListener(msgRemindActivity);
        this.itF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itS.setOnClickListener(msgRemindActivity);
        this.itU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itV.setOnClickListener(msgRemindActivity);
        this.itZ.setOnClickListener(msgRemindActivity);
        this.iub.setOnClickListener(msgRemindActivity);
        this.iuf.setOnClickListener(msgRemindActivity);
    }

    public void pA(boolean z) {
        this.itU.setLineVisibility(z);
        if (z) {
            this.itV.setVisibility(0);
            bZY();
            al.k(this.itV, d.f.more_all);
            return;
        }
        this.itV.setVisibility(8);
    }

    public void pB(boolean z) {
        if (z) {
            this.itS.setVisibility(0);
            this.itR.setLineVisibility(true);
            al.k(this.itS, d.f.more_all);
            return;
        }
        this.itS.setVisibility(8);
        this.itR.setLineVisibility(false);
    }

    public void pC(boolean z) {
        if (z) {
            this.itG.setVisibility(0);
        } else {
            this.itG.setVisibility(8);
        }
    }

    public void bZX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aih().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aih().getSignAlertMins();
            this.itT.setText(this.iue.getString(d.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.itS.setVisibility(0);
            if (!this.itR.jK()) {
                this.itR.nY();
                return;
            }
            return;
        }
        this.itT.setText(d.j.close);
        this.itS.setVisibility(8);
        if (this.itR.jK()) {
            this.itR.nZ();
        }
    }

    public void bZY() {
        String aiu = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiu();
        String aiv = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiv();
        this.itW.setText(aiu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aiv);
        this.iua.setText(aiu);
        this.iuc.setText(aiv);
    }

    public BdSwitchView bZZ() {
        return this.itR.getSwitchView();
    }

    public BdSwitchView caa() {
        return this.itF.getSwitchView();
    }

    public View cab() {
        return this.itS;
    }

    public BdSwitchView cac() {
        return this.itU.getSwitchView();
    }

    public View cad() {
        return this.itV;
    }

    public LinearLayout cae() {
        return this.itZ;
    }

    public LinearLayout caf() {
        return this.iub;
    }

    public BdSwitchView cag() {
        return this.itO.getSwitchView();
    }

    public BdSwitchView cah() {
        return this.itP.getSwitchView();
    }

    public BdSwitchView cai() {
        return this.itQ.getSwitchView();
    }

    public BdSwitchView caj() {
        return this.itN.getSwitchView();
    }

    public BdSwitchView cak() {
        return this.itH.getSwitchView();
    }

    public BdSwitchView cal() {
        return this.itI.getSwitchView();
    }

    public BdSwitchView cam() {
        return this.itJ.getSwitchView();
    }

    public BdSwitchView can() {
        return this.itL.getSwitchView();
    }

    public BdSwitchView cao() {
        return this.itM.getSwitchView();
    }

    public BdSwitchView cap() {
        return this.itK.getSwitchView();
    }

    public TbSettingTextTipView caq() {
        return this.iuf;
    }

    public void car() {
        this.itH.setOnSwitchStateChangeListener(null);
        this.itH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aio());
        this.itH.setOnSwitchStateChangeListener(this.iue);
    }

    public void cas() {
        this.itI.setOnSwitchStateChangeListener(null);
        this.itI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy());
        this.itI.setOnSwitchStateChangeListener(this.iue);
    }

    public void cat() {
        this.itJ.setOnSwitchStateChangeListener(null);
        this.itJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim());
        this.itJ.setOnSwitchStateChangeListener(this.iue);
    }

    public void cau() {
        this.itK.setOnSwitchStateChangeListener(null);
        this.itK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().ain());
        this.itK.setOnSwitchStateChangeListener(this.iue);
    }

    public void cav() {
        this.itL.setOnSwitchStateChangeListener(null);
        this.itL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip());
        this.itL.setOnSwitchStateChangeListener(this.iue);
    }

    public void caw() {
        this.itM.setOnSwitchStateChangeListener(null);
        this.itM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix());
        this.itM.setOnSwitchStateChangeListener(this.iue);
    }

    public void pD(boolean z) {
        if (this.iud != z) {
            this.iud = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iue.getString(d.j.msg_remind));
                this.itX.setVisibility(0);
                this.itY.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iue.getString(d.j.no_disturb_mode_time));
            this.itY.setVisibility(0);
            this.itX.setVisibility(8);
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
        this.iue.getLayoutMode().setNightMode(i == 1);
        this.iue.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iue.getPageContext(), i);
        this.itF.onChangeSkinType(this.iue.getPageContext(), i);
        this.itH.onChangeSkinType(this.iue.getPageContext(), i);
        this.itI.onChangeSkinType(this.iue.getPageContext(), i);
        this.itJ.onChangeSkinType(this.iue.getPageContext(), i);
        this.itK.onChangeSkinType(this.iue.getPageContext(), i);
        this.itL.onChangeSkinType(this.iue.getPageContext(), i);
        this.itM.onChangeSkinType(this.iue.getPageContext(), i);
        this.itN.onChangeSkinType(this.iue.getPageContext(), i);
        this.itO.onChangeSkinType(this.iue.getPageContext(), i);
        this.itP.onChangeSkinType(this.iue.getPageContext(), i);
        this.itQ.onChangeSkinType(this.iue.getPageContext(), i);
        this.itR.onChangeSkinType(this.iue.getPageContext(), i);
        this.itU.onChangeSkinType(this.iue.getPageContext(), i);
        al.k(this.itV, d.f.more_all);
        al.k(this.itZ, d.f.more_all);
        al.k(this.iub, d.f.more_all);
        al.k(this.itS, d.f.more_all);
        al.c((ImageView) this.itV.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itS.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itZ.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.iub.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }

    public void cax() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aiC().b(this.iue.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
