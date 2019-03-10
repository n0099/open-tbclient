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
    private MsgSettingItemView itG;
    private LinearLayout itH;
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
    private MsgSettingItemView itS;
    private LinearLayout itT;
    private TextView itU;
    private MsgSettingItemView itV;
    private LinearLayout itW;
    private TextView itX;
    private LinearLayout itY;
    private LinearLayout itZ;
    private LinearLayout iua;
    private TextView iub;
    private LinearLayout iuc;
    private TextView iud;
    public boolean iue;
    private MsgRemindActivity iuf;
    private TbSettingTextTipView iug;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iue = true;
        this.iuf = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bZT();
        bZW();
        bZV();
        bZU();
        bZX();
        d(msgRemindActivity);
        bZN();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.bVY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.itY = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.itZ = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.itG = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.itG.setText(d.j.receive_msg_text);
        this.itG.setLineVisibility(false);
        this.itH = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.itI = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.itI.setText(d.j.reply);
        this.itJ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.itJ.setVisibility(0);
        this.itJ.setText(d.j.action_praise_default);
        this.itK = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.itK.setText(d.j.mention_atme);
        this.itL = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.itL.setText(d.j.new_fans);
        this.itM = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.itM.setText(d.j.chat_msg_text);
        this.itN = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.itN.setLineVisibility(false);
        this.itN.setText(d.j.group_chat_text);
        this.itO = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.itO.setText(d.j.remind_screen_lock);
        this.itO.setLineVisibility(false);
        this.itP = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.itP.setText(d.j.remind_tone);
        this.itQ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.itQ.setText(d.j.remind_vibrate);
        this.itR = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.itR.setLineVisibility(true);
        this.itR.setText(d.j.remind_light);
        this.itS = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.itS.setText(d.j.sign_remind_outline);
        this.itT = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.itU = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.itV = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.itV.setText(d.j.no_disturb_mode);
        this.itV.setLineVisibility(false);
        this.itW = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.itX = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.iua = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.iub = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.iuc = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.iud = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.iug = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bZN() {
        bZO();
        bZP();
        bZQ();
        bZR();
    }

    private void bZO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.itV.setVisibility(8);
            this.itW.setVisibility(8);
            this.itG.setVisibility(8);
            this.itH.setVisibility(8);
            this.itS.setVisibility(8);
            this.itT.setVisibility(8);
            this.itP.setVisibility(8);
            this.itQ.setVisibility(8);
            this.itR.setVisibility(8);
            this.itO.setVisibility(8);
        }
    }

    private void bZP() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.itO.setLineVisibility(true);
        } else {
            this.itO.setLineVisibility(false);
        }
    }

    private void bZQ() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.itM.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.itN.setVisibility(0);
        } else {
            this.itN.setVisibility(8);
        }
    }

    private void bZR() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.itO.setVisibility(0);
        } else {
            this.itO.setVisibility(8);
        }
    }

    public View bZS() {
        return this.bVY;
    }

    private void bZT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aij()) {
            this.itG.nY();
            this.itH.setVisibility(0);
        } else {
            this.itG.nZ();
            this.itH.setVisibility(8);
        }
        this.itI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aio());
        this.itJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy());
        this.itK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim());
        this.itL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().ain());
        this.itM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip());
        this.itN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix());
    }

    private void bZU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().isSignAlertOn()) {
            this.itS.oa();
            this.itT.setVisibility(0);
            this.itS.setLineVisibility(true);
            bZY();
            return;
        }
        this.itS.ob();
        this.itS.setLineVisibility(false);
        this.itT.setVisibility(8);
    }

    private void bZV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiq()) {
            this.itP.nY();
        } else {
            this.itP.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().ait()) {
            this.itQ.nY();
        } else {
            this.itQ.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().air()) {
            this.itR.nY();
        } else {
            this.itR.nZ();
        }
    }

    private void bZW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiz()) {
            this.itO.nY();
        } else {
            this.itO.nZ();
        }
    }

    private void bZX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().ais()) {
            this.itV.nY();
            this.itW.setVisibility(0);
            bZZ();
            return;
        }
        this.itV.nZ();
        this.itW.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bVY.setOnClickListener(msgRemindActivity);
        this.itG.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itI.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itK.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itJ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itL.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itT.setOnClickListener(msgRemindActivity);
        this.itV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itW.setOnClickListener(msgRemindActivity);
        this.iua.setOnClickListener(msgRemindActivity);
        this.iuc.setOnClickListener(msgRemindActivity);
        this.iug.setOnClickListener(msgRemindActivity);
    }

    public void pA(boolean z) {
        this.itV.setLineVisibility(z);
        if (z) {
            this.itW.setVisibility(0);
            bZZ();
            al.k(this.itW, d.f.more_all);
            return;
        }
        this.itW.setVisibility(8);
    }

    public void pB(boolean z) {
        if (z) {
            this.itT.setVisibility(0);
            this.itS.setLineVisibility(true);
            al.k(this.itT, d.f.more_all);
            return;
        }
        this.itT.setVisibility(8);
        this.itS.setLineVisibility(false);
    }

    public void pC(boolean z) {
        if (z) {
            this.itH.setVisibility(0);
        } else {
            this.itH.setVisibility(8);
        }
    }

    public void bZY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aih().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aih().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aih().getSignAlertMins();
            this.itU.setText(this.iuf.getString(d.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.itT.setVisibility(0);
            if (!this.itS.jK()) {
                this.itS.nY();
                return;
            }
            return;
        }
        this.itU.setText(d.j.close);
        this.itT.setVisibility(8);
        if (this.itS.jK()) {
            this.itS.nZ();
        }
    }

    public void bZZ() {
        String aiu = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiu();
        String aiv = com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiv();
        this.itX.setText(aiu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aiv);
        this.iub.setText(aiu);
        this.iud.setText(aiv);
    }

    public BdSwitchView caa() {
        return this.itS.getSwitchView();
    }

    public BdSwitchView cab() {
        return this.itG.getSwitchView();
    }

    public View cac() {
        return this.itT;
    }

    public BdSwitchView cad() {
        return this.itV.getSwitchView();
    }

    public View cae() {
        return this.itW;
    }

    public LinearLayout caf() {
        return this.iua;
    }

    public LinearLayout cag() {
        return this.iuc;
    }

    public BdSwitchView cah() {
        return this.itP.getSwitchView();
    }

    public BdSwitchView cai() {
        return this.itQ.getSwitchView();
    }

    public BdSwitchView caj() {
        return this.itR.getSwitchView();
    }

    public BdSwitchView cak() {
        return this.itO.getSwitchView();
    }

    public BdSwitchView cal() {
        return this.itI.getSwitchView();
    }

    public BdSwitchView cam() {
        return this.itJ.getSwitchView();
    }

    public BdSwitchView can() {
        return this.itK.getSwitchView();
    }

    public BdSwitchView cao() {
        return this.itM.getSwitchView();
    }

    public BdSwitchView cap() {
        return this.itN.getSwitchView();
    }

    public BdSwitchView caq() {
        return this.itL.getSwitchView();
    }

    public TbSettingTextTipView car() {
        return this.iug;
    }

    public void cas() {
        this.itI.setOnSwitchStateChangeListener(null);
        this.itI.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aio());
        this.itI.setOnSwitchStateChangeListener(this.iuf);
    }

    public void cat() {
        this.itJ.setOnSwitchStateChangeListener(null);
        this.itJ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy());
        this.itJ.setOnSwitchStateChangeListener(this.iuf);
    }

    public void cau() {
        this.itK.setOnSwitchStateChangeListener(null);
        this.itK.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim());
        this.itK.setOnSwitchStateChangeListener(this.iuf);
    }

    public void cav() {
        this.itL.setOnSwitchStateChangeListener(null);
        this.itL.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().ain());
        this.itL.setOnSwitchStateChangeListener(this.iuf);
    }

    public void caw() {
        this.itM.setOnSwitchStateChangeListener(null);
        this.itM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aip());
        this.itM.setOnSwitchStateChangeListener(this.iuf);
    }

    public void cax() {
        this.itN.setOnSwitchStateChangeListener(null);
        this.itN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aih().aix());
        this.itN.setOnSwitchStateChangeListener(this.iuf);
    }

    public void pD(boolean z) {
        if (this.iue != z) {
            this.iue = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iuf.getString(d.j.msg_remind));
                this.itY.setVisibility(0);
                this.itZ.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iuf.getString(d.j.no_disturb_mode_time));
            this.itZ.setVisibility(0);
            this.itY.setVisibility(8);
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
        this.iuf.getLayoutMode().setNightMode(i == 1);
        this.iuf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itG.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itI.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itJ.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itK.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itL.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itM.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itN.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itO.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itP.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itQ.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itR.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itS.onChangeSkinType(this.iuf.getPageContext(), i);
        this.itV.onChangeSkinType(this.iuf.getPageContext(), i);
        al.k(this.itW, d.f.more_all);
        al.k(this.iua, d.f.more_all);
        al.k(this.iuc, d.f.more_all);
        al.k(this.itT, d.f.more_all);
        al.c((ImageView) this.itW.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itT.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.iua.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.iuc.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }

    public void cay() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aiC().b(this.iuf.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
