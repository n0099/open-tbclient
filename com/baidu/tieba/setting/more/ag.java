package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView Mf;
    private RelativeLayout bGY;
    private MsgSettingItemView dnQ;
    private LinearLayout dnR;
    private MsgSettingItemView2 dnS;
    private MsgSettingItemView2 dnT;
    private MsgSettingItemView2 dnU;
    private MsgSettingItemView2 dnV;
    private MsgSettingItemView2 dnW;
    private MsgSettingItemView2 dnX;
    private MsgSettingItemView dnY;
    private MsgSettingItemView dnZ;
    private MsgSettingItemView doa;
    private MsgSettingItemView dob;
    private MsgSettingItemView doc;
    private MsgSettingItemView dod;
    private LinearLayout doe;
    private TextView dof;
    private MsgSettingItemView dog;
    private MsgSettingItemView doh;
    private MsgSettingItemView doi;
    private LinearLayout doj;
    private TextView dok;
    private LinearLayout dol;
    private LinearLayout dom;
    private LinearLayout don;
    private TextView doo;
    private LinearLayout dop;
    private TextView doq;
    public boolean dor;
    private MsgRemindActivity dos;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ag(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bGY = null;
        this.mNavigationBar = null;
        this.Mf = null;
        this.dor = true;
        this.dos = msgRemindActivity;
        msgRemindActivity.setContentView(n.g.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        ays();
        ayy();
        ayx();
        ayw();
        ayv();
        ayt();
        ayz();
        ayu();
        d(msgRemindActivity);
        ayn();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.bGY = (RelativeLayout) msgRemindActivity.findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(n.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dol = (LinearLayout) msgRemindActivity.findViewById(n.f.front_container);
        this.dom = (LinearLayout) msgRemindActivity.findViewById(n.f.back_container);
        this.Mf = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(n.i.msg_remind));
        this.dnQ = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.receive_message_swtich);
        this.dnQ.setText(n.i.receive_msg_text);
        this.dnQ.setLineVisibility(true);
        this.dnR = (LinearLayout) msgRemindActivity.findViewById(n.f.receive_message_container);
        this.dnS = (MsgSettingItemView2) msgRemindActivity.findViewById(n.f.reply_check_box);
        this.dnS.setText(n.i.frs_item_reply_text);
        this.dnT = (MsgSettingItemView2) msgRemindActivity.findViewById(n.f.zan_check_box);
        this.dnT.setText(n.i.frs_item_praise_text);
        this.dnU = (MsgSettingItemView2) msgRemindActivity.findViewById(n.f.at_me_check_box);
        this.dnU.setText(n.i.mention_atme);
        this.dnV = (MsgSettingItemView2) msgRemindActivity.findViewById(n.f.new_fans_swtich);
        this.dnV.setText(n.i.new_fans);
        this.dnW = (MsgSettingItemView2) msgRemindActivity.findViewById(n.f.chat_msg_swtich);
        this.dnW.setText(n.i.chat_msg_text);
        this.dnX = (MsgSettingItemView2) msgRemindActivity.findViewById(n.f.group_chat_swtich);
        this.dnX.setLineVisibility(false);
        this.dnX.setText(n.i.group_chat_text);
        this.dnY = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.screen_lock_swtich);
        this.dnY.setText(n.i.remind_screen_lock);
        this.dnZ = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.chat_float_swtich);
        this.dnZ.setLineVisibility(false);
        this.dnZ.setText(n.i.chat_float_window);
        this.doa = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.tone_remind_swtich);
        this.doa.setText(n.i.remind_tone);
        this.dob = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.vibrate_remind_swtich);
        this.dob.setText(n.i.remind_vibrate);
        this.doc = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.light_remind_swtich);
        this.doc.setLineVisibility(true);
        this.doc.setText(n.i.remind_light);
        this.dod = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.sign_remind_swtich);
        this.dod.setText(n.i.sign_remind_outline);
        this.doe = (LinearLayout) msgRemindActivity.findViewById(n.f.sign_remind);
        this.dof = (TextView) msgRemindActivity.findViewById(n.f.sign_remind_time);
        this.dog = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.promoted_content_swtich);
        this.dog.setLineVisibility(true);
        this.dog.setText(n.i.promoted_message_text);
        this.doi = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.no_disturb_swtich);
        this.doi.setText(n.i.no_disturb_mode);
        this.doj = (LinearLayout) msgRemindActivity.findViewById(n.f.no_disturb_mode_time_container);
        this.dok = (TextView) msgRemindActivity.findViewById(n.f.no_disturb_mode_time_value);
        this.don = (LinearLayout) msgRemindActivity.findViewById(n.f.no_disturb_start_time);
        this.doo = (TextView) msgRemindActivity.findViewById(n.f.no_disturb_start_time_value);
        this.dop = (LinearLayout) msgRemindActivity.findViewById(n.f.no_disturb_end_time);
        this.doq = (TextView) msgRemindActivity.findViewById(n.f.no_disturb_end_time_value);
        this.doh = (MsgSettingItemView) msgRemindActivity.findViewById(n.f.remind_recommend_swtich);
        this.doh.setLineVisibility(false);
        this.doh.setText(n.i.remind_message_recommend);
    }

    private void ayn() {
        ayo();
        ayp();
        ayq();
        ayr();
    }

    private void ayo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.doi.setVisibility(8);
            this.doj.setVisibility(8);
            this.dnQ.setVisibility(8);
            this.dnR.setVisibility(8);
            this.dod.setVisibility(8);
            this.doe.setVisibility(8);
            this.doa.setVisibility(8);
            this.dob.setVisibility(8);
            this.doc.setVisibility(8);
            this.dnY.setVisibility(8);
            this.dnZ.setVisibility(8);
        }
    }

    private void ayp() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.dnZ.setVisibility(0);
            this.dnY.setLineVisibility(true);
            return;
        }
        this.dnZ.setVisibility(8);
        this.dnY.setLineVisibility(false);
    }

    private void ayq() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.dnW.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.dnX.setVisibility(0);
        } else {
            this.dnX.setVisibility(8);
        }
    }

    private void ayr() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.dnY.setVisibility(0);
        } else {
            this.dnY.setVisibility(8);
        }
    }

    public View apG() {
        return this.mBack;
    }

    private void ays() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yi()) {
            this.dnQ.mE();
            this.dnR.setVisibility(0);
        } else {
            this.dnQ.mF();
            this.dnR.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yn()) {
            this.dnS.getSwitchView().setChecked(true);
        } else {
            this.dnS.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yw()) {
            this.dnT.getSwitchView().setChecked(true);
        } else {
            this.dnT.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl()) {
            this.dnU.getSwitchView().setChecked(true);
        } else {
            this.dnU.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().ym()) {
            this.dnV.getSwitchView().setChecked(true);
        } else {
            this.dnV.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo()) {
            this.dnW.getSwitchView().setChecked(true);
        } else {
            this.dnW.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yv()) {
            this.dnX.getSwitchView().setChecked(true);
        } else {
            this.dnX.getSwitchView().setChecked(false);
        }
    }

    private void ayt() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.dog.mE();
        } else {
            this.dog.mF();
        }
    }

    private void ayu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yA()) {
            this.doh.mE();
        } else {
            this.doh.mF();
        }
    }

    private void ayv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().isSignAlertOn()) {
            this.dod.mG();
            this.doe.setVisibility(0);
            this.dod.setLineVisibility(true);
            ayA();
            return;
        }
        this.dod.mH();
        this.dod.setLineVisibility(false);
        this.doe.setVisibility(8);
    }

    private void ayw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yp()) {
            this.doa.mE();
        } else {
            this.doa.mF();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().ys()) {
            this.dob.mE();
        } else {
            this.dob.mF();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yq()) {
            this.doc.mE();
        } else {
            this.doc.mF();
        }
    }

    private void ayx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yx()) {
            this.dnZ.mE();
        } else {
            this.dnZ.mF();
        }
    }

    private void ayy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yy()) {
            this.dnY.mE();
        } else {
            this.dnY.mF();
        }
    }

    private void ayz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().yr()) {
            this.doi.mE();
            this.doj.setVisibility(0);
            ayB();
            return;
        }
        this.doi.mF();
        this.doj.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.dnQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dnS.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dnU.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dnT.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dnV.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dnW.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dnX.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.dnY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dnZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.doa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dob.setOnSwitchStateChangeListener(msgRemindActivity);
        this.doc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.dod.setOnSwitchStateChangeListener(msgRemindActivity);
        this.doe.setOnClickListener(msgRemindActivity);
        this.dog.setOnSwitchStateChangeListener(msgRemindActivity);
        this.doi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.doj.setOnClickListener(msgRemindActivity);
        this.don.setOnClickListener(msgRemindActivity);
        this.dop.setOnClickListener(msgRemindActivity);
        this.doh.setOnSwitchStateChangeListener(msgRemindActivity);
    }

    public void gS(boolean z) {
        this.doi.setLineVisibility(z);
        if (z) {
            this.doj.setVisibility(0);
            ayB();
            com.baidu.tbadk.core.util.as.i(this.doj, n.e.more_all);
            return;
        }
        this.doj.setVisibility(8);
    }

    public void gT(boolean z) {
        if (z) {
            this.doe.setVisibility(0);
            this.dod.setLineVisibility(true);
            com.baidu.tbadk.core.util.as.i(this.doe, n.e.more_all);
            return;
        }
        this.doe.setVisibility(8);
        this.dod.setLineVisibility(false);
    }

    public void gU(boolean z) {
        if (z) {
            this.dnR.setVisibility(0);
        } else {
            this.dnR.setVisibility(8);
        }
    }

    public void ayA() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.yg().getSignAlertMins();
            }
            this.dof.setText(this.dos.getPageContext().getPageActivity().getString(n.i.sign_remind_time, new Object[]{str, str2}));
            this.doe.setVisibility(0);
            if (!this.dod.hA()) {
                this.dod.mE();
                return;
            }
            return;
        }
        this.dof.setText(n.i.close);
        this.doe.setVisibility(8);
        if (this.dod.hA()) {
            this.dod.mF();
        }
    }

    public void ayB() {
        this.dok.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yt()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.yg().yu());
        this.doo.setText(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yt());
        this.doq.setText(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yu());
    }

    public BdSwitchView ayC() {
        return this.doh.getSwitchView();
    }

    public BdSwitchView ayD() {
        return this.dog.getSwitchView();
    }

    public BdSwitchView ayE() {
        return this.dod.getSwitchView();
    }

    public BdSwitchView ayF() {
        return this.dnQ.getSwitchView();
    }

    public View ayG() {
        return this.doe;
    }

    public BdSwitchView ayH() {
        return this.doi.getSwitchView();
    }

    public View ayI() {
        return this.doj;
    }

    public LinearLayout ayJ() {
        return this.don;
    }

    public LinearLayout ayK() {
        return this.dop;
    }

    public BdSwitchView ayL() {
        return this.doa.getSwitchView();
    }

    public BdSwitchView ayM() {
        return this.dob.getSwitchView();
    }

    public BdSwitchView ayN() {
        return this.doc.getSwitchView();
    }

    public BdSwitchView ayO() {
        return this.dnY.getSwitchView();
    }

    public BdSwitchView ayP() {
        return this.dnZ.getSwitchView();
    }

    public CheckBox ayQ() {
        return this.dnS.getSwitchView();
    }

    public CheckBox ayR() {
        return this.dnT.getSwitchView();
    }

    public CheckBox ayS() {
        return this.dnU.getSwitchView();
    }

    public CheckBox ayT() {
        return this.dnW.getSwitchView();
    }

    public CheckBox ayU() {
        return this.dnX.getSwitchView();
    }

    public CheckBox ayV() {
        return this.dnV.getSwitchView();
    }

    public void ayW() {
        this.dnS.getSwitchView().setOnCheckedChangeListener(null);
        this.dnS.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yn());
        this.dnS.getSwitchView().setOnCheckedChangeListener(this.dos);
    }

    public void ayX() {
        this.dnT.getSwitchView().setOnCheckedChangeListener(null);
        this.dnT.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yw());
        this.dnT.getSwitchView().setOnCheckedChangeListener(this.dos);
    }

    public void ayY() {
        this.dnU.getSwitchView().setOnCheckedChangeListener(null);
        this.dnU.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl());
        this.dnU.getSwitchView().setOnCheckedChangeListener(this.dos);
    }

    public void ayZ() {
        this.dnV.getSwitchView().setOnCheckedChangeListener(null);
        this.dnV.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.yg().ym());
        this.dnV.getSwitchView().setOnCheckedChangeListener(this.dos);
    }

    public void aza() {
        this.dnW.getSwitchView().setOnCheckedChangeListener(null);
        this.dnW.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo());
        this.dnW.getSwitchView().setOnCheckedChangeListener(this.dos);
    }

    public void azb() {
        this.dnX.getSwitchView().setOnCheckedChangeListener(null);
        this.dnX.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.yg().yv());
        this.dnX.getSwitchView().setOnCheckedChangeListener(this.dos);
    }

    public void gV(boolean z) {
        if (this.dor != z) {
            this.dor = z;
            if (z) {
                this.Mf.setText(n.i.msg_remind);
                this.dol.setVisibility(0);
                this.dom.setVisibility(8);
                return;
            }
            this.Mf.setText(n.i.no_disturb_mode_time);
            this.dom.setVisibility(0);
            this.dol.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v33, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v47, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.dos.getLayoutMode().af(i == 1);
        this.dos.getLayoutMode().k(this.bGY);
        this.mNavigationBar.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnQ.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnS.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnT.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnU.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnV.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnW.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnX.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnY.onChangeSkinType(this.dos.getPageContext(), i);
        this.dnZ.onChangeSkinType(this.dos.getPageContext(), i);
        this.doa.onChangeSkinType(this.dos.getPageContext(), i);
        this.dob.onChangeSkinType(this.dos.getPageContext(), i);
        this.doc.onChangeSkinType(this.dos.getPageContext(), i);
        this.dod.onChangeSkinType(this.dos.getPageContext(), i);
        this.dog.onChangeSkinType(this.dos.getPageContext(), i);
        this.doi.onChangeSkinType(this.dos.getPageContext(), i);
        if (this.doh != null) {
            this.doh.onChangeSkinType(this.dos.getPageContext(), i);
        }
        com.baidu.tbadk.core.util.as.i(this.doj, n.e.more_all);
        com.baidu.tbadk.core.util.as.i(this.don, n.e.more_all);
        com.baidu.tbadk.core.util.as.i(this.dop, n.e.more_all);
        com.baidu.tbadk.core.util.as.i(this.doe, n.e.more_all);
        com.baidu.tbadk.core.util.as.c((ImageView) this.doj.findViewById(n.f.no_disturb_mode_time_arrow), n.e.icon_arrow_right);
        com.baidu.tbadk.core.util.as.c((ImageView) this.doe.findViewById(n.f.sign_remind_arrow), n.e.icon_arrow_right);
        com.baidu.tbadk.core.util.as.c((ImageView) this.don.findViewById(n.f.no_disturb_start_time_arrow), n.e.icon_arrow_right);
        com.baidu.tbadk.core.util.as.c((ImageView) this.dop.findViewById(n.f.no_disturb_end_time_arrow), n.e.icon_arrow_right);
    }
}
