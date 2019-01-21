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
import com.baidu.tieba.e;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aNz;
    private MsgSettingItemView hbP;
    private LinearLayout hbQ;
    private MsgSettingItemView hbR;
    private MsgSettingItemView hbS;
    private MsgSettingItemView hbT;
    private MsgSettingItemView hbU;
    private MsgSettingItemView hbV;
    private MsgSettingItemView hbW;
    private MsgSettingItemView hbX;
    private MsgSettingItemView hbY;
    private MsgSettingItemView hbZ;
    private MsgSettingItemView hca;
    private MsgSettingItemView hcb;
    private LinearLayout hcc;
    private TextView hcd;
    private MsgSettingItemView hce;
    private LinearLayout hcf;
    private TextView hcg;
    private LinearLayout hch;
    private LinearLayout hci;
    private LinearLayout hcj;
    private TextView hck;
    private LinearLayout hcl;
    private TextView hcm;
    public boolean hcn;
    private MsgRemindActivity hco;
    private TbSettingTextTipView hcp;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.hcn = true;
        this.hco = msgRemindActivity;
        msgRemindActivity.setContentView(e.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bze();
        bzh();
        bzg();
        bzf();
        bzi();
        d(msgRemindActivity);
        byY();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(e.g.parent);
        msgRemindActivity.findViewById(e.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(e.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hch = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.hci = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.hbP = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.hbP.setText(e.j.receive_msg_text);
        this.hbP.setLineVisibility(false);
        this.hbQ = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.hbR = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.hbR.setText(e.j.reply);
        this.hbS = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.hbS.setVisibility(0);
        this.hbS.setText(e.j.action_praise_default);
        this.hbT = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.hbT.setText(e.j.mention_atme);
        this.hbU = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.hbU.setText(e.j.new_fans);
        this.hbV = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.hbV.setText(e.j.chat_msg_text);
        this.hbW = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.hbW.setLineVisibility(false);
        this.hbW.setText(e.j.group_chat_text);
        this.hbX = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.hbX.setText(e.j.remind_screen_lock);
        this.hbX.setLineVisibility(false);
        this.hbY = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.hbY.setText(e.j.remind_tone);
        this.hbZ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.hbZ.setText(e.j.remind_vibrate);
        this.hca = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.hca.setLineVisibility(true);
        this.hca.setText(e.j.remind_light);
        this.hcb = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.hcb.setText(e.j.sign_remind_outline);
        this.hcc = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.hcd = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.hce = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.hce.setText(e.j.no_disturb_mode);
        this.hce.setLineVisibility(false);
        this.hcf = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.hcg = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.hcj = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.hck = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.hcl = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.hcm = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.hcp = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
    }

    private void byY() {
        byZ();
        bza();
        bzb();
        bzc();
    }

    private void byZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.hce.setVisibility(8);
            this.hcf.setVisibility(8);
            this.hbP.setVisibility(8);
            this.hbQ.setVisibility(8);
            this.hcb.setVisibility(8);
            this.hcc.setVisibility(8);
            this.hbY.setVisibility(8);
            this.hbZ.setVisibility(8);
            this.hca.setVisibility(8);
            this.hbX.setVisibility(8);
        }
    }

    private void bza() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.hbX.setLineVisibility(true);
        } else {
            this.hbX.setLineVisibility(false);
        }
    }

    private void bzb() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.hbV.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.hbW.setVisibility(0);
        } else {
            this.hbW.setVisibility(8);
        }
    }

    private void bzc() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.hbX.setVisibility(0);
        } else {
            this.hbX.setVisibility(8);
        }
    }

    public View bzd() {
        return this.aNz;
    }

    private void bze() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IO()) {
            this.hbP.nT();
            this.hbQ.setVisibility(0);
        } else {
            this.hbP.nU();
            this.hbQ.setVisibility(8);
        }
        this.hbR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IT());
        this.hbS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jd());
        this.hbT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IR());
        this.hbU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IS());
        this.hbV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IU());
        this.hbW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jc());
    }

    private void bzf() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().isSignAlertOn()) {
            this.hcb.nV();
            this.hcc.setVisibility(0);
            this.hcb.setLineVisibility(true);
            bzj();
            return;
        }
        this.hcb.nW();
        this.hcb.setLineVisibility(false);
        this.hcc.setVisibility(8);
    }

    private void bzg() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IV()) {
            this.hbY.nT();
        } else {
            this.hbY.nU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IY()) {
            this.hbZ.nT();
        } else {
            this.hbZ.nU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IW()) {
            this.hca.nT();
        } else {
            this.hca.nU();
        }
    }

    private void bzh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().Je()) {
            this.hbX.nT();
        } else {
            this.hbX.nU();
        }
    }

    private void bzi() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IX()) {
            this.hce.nT();
            this.hcf.setVisibility(0);
            bzk();
            return;
        }
        this.hce.nU();
        this.hcf.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aNz.setOnClickListener(msgRemindActivity);
        this.hbP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hca.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hcb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hcc.setOnClickListener(msgRemindActivity);
        this.hce.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hcf.setOnClickListener(msgRemindActivity);
        this.hcj.setOnClickListener(msgRemindActivity);
        this.hcl.setOnClickListener(msgRemindActivity);
        this.hcp.setOnClickListener(msgRemindActivity);
    }

    public void nb(boolean z) {
        this.hce.setLineVisibility(z);
        if (z) {
            this.hcf.setVisibility(0);
            bzk();
            al.i(this.hcf, e.f.more_all);
            return;
        }
        this.hcf.setVisibility(8);
    }

    public void nc(boolean z) {
        if (z) {
            this.hcc.setVisibility(0);
            this.hcb.setLineVisibility(true);
            al.i(this.hcc, e.f.more_all);
            return;
        }
        this.hcc.setVisibility(8);
        this.hcb.setLineVisibility(false);
    }

    public void nd(boolean z) {
        if (z) {
            this.hbQ.setVisibility(0);
        } else {
            this.hbQ.setVisibility(8);
        }
    }

    public void bzj() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.IM().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.IM().getSignAlertMins();
            this.hcd.setText(this.hco.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.hcc.setVisibility(0);
            if (!this.hcb.jJ()) {
                this.hcb.nT();
                return;
            }
            return;
        }
        this.hcd.setText(e.j.close);
        this.hcc.setVisibility(8);
        if (this.hcb.jJ()) {
            this.hcb.nU();
        }
    }

    public void bzk() {
        String IZ = com.baidu.tbadk.coreExtra.messageCenter.c.IM().IZ();
        String Ja = com.baidu.tbadk.coreExtra.messageCenter.c.IM().Ja();
        this.hcg.setText(IZ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Ja);
        this.hck.setText(IZ);
        this.hcm.setText(Ja);
    }

    public BdSwitchView bzl() {
        return this.hcb.getSwitchView();
    }

    public BdSwitchView bzm() {
        return this.hbP.getSwitchView();
    }

    public View bzn() {
        return this.hcc;
    }

    public BdSwitchView bzo() {
        return this.hce.getSwitchView();
    }

    public View bzp() {
        return this.hcf;
    }

    public LinearLayout bzq() {
        return this.hcj;
    }

    public LinearLayout bzr() {
        return this.hcl;
    }

    public BdSwitchView bzs() {
        return this.hbY.getSwitchView();
    }

    public BdSwitchView bzt() {
        return this.hbZ.getSwitchView();
    }

    public BdSwitchView bzu() {
        return this.hca.getSwitchView();
    }

    public BdSwitchView bzv() {
        return this.hbX.getSwitchView();
    }

    public BdSwitchView bzw() {
        return this.hbR.getSwitchView();
    }

    public BdSwitchView bzx() {
        return this.hbS.getSwitchView();
    }

    public BdSwitchView bzy() {
        return this.hbT.getSwitchView();
    }

    public BdSwitchView bzz() {
        return this.hbV.getSwitchView();
    }

    public BdSwitchView bzA() {
        return this.hbW.getSwitchView();
    }

    public BdSwitchView bzB() {
        return this.hbU.getSwitchView();
    }

    public TbSettingTextTipView bzC() {
        return this.hcp;
    }

    public void bzD() {
        this.hbR.setOnSwitchStateChangeListener(null);
        this.hbR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IT());
        this.hbR.setOnSwitchStateChangeListener(this.hco);
    }

    public void bzE() {
        this.hbS.setOnSwitchStateChangeListener(null);
        this.hbS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jd());
        this.hbS.setOnSwitchStateChangeListener(this.hco);
    }

    public void bzF() {
        this.hbT.setOnSwitchStateChangeListener(null);
        this.hbT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IR());
        this.hbT.setOnSwitchStateChangeListener(this.hco);
    }

    public void bzG() {
        this.hbU.setOnSwitchStateChangeListener(null);
        this.hbU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IS());
        this.hbU.setOnSwitchStateChangeListener(this.hco);
    }

    public void bzH() {
        this.hbV.setOnSwitchStateChangeListener(null);
        this.hbV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IU());
        this.hbV.setOnSwitchStateChangeListener(this.hco);
    }

    public void bzI() {
        this.hbW.setOnSwitchStateChangeListener(null);
        this.hbW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jc());
        this.hbW.setOnSwitchStateChangeListener(this.hco);
    }

    public void ne(boolean z) {
        if (this.hcn != z) {
            this.hcn = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.hco.getString(e.j.msg_remind));
                this.hch.setVisibility(0);
                this.hci.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.hco.getString(e.j.no_disturb_mode_time));
            this.hci.setVisibility(0);
            this.hch.setVisibility(8);
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
        this.hco.getLayoutMode().setNightMode(i == 1);
        this.hco.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hco.getPageContext(), i);
        this.hbP.d(this.hco.getPageContext(), i);
        this.hbR.d(this.hco.getPageContext(), i);
        this.hbS.d(this.hco.getPageContext(), i);
        this.hbT.d(this.hco.getPageContext(), i);
        this.hbU.d(this.hco.getPageContext(), i);
        this.hbV.d(this.hco.getPageContext(), i);
        this.hbW.d(this.hco.getPageContext(), i);
        this.hbX.d(this.hco.getPageContext(), i);
        this.hbY.d(this.hco.getPageContext(), i);
        this.hbZ.d(this.hco.getPageContext(), i);
        this.hca.d(this.hco.getPageContext(), i);
        this.hcb.d(this.hco.getPageContext(), i);
        this.hce.d(this.hco.getPageContext(), i);
        al.i(this.hcf, e.f.more_all);
        al.i(this.hcj, e.f.more_all);
        al.i(this.hcl, e.f.more_all);
        al.i(this.hcc, e.f.more_all);
        al.c((ImageView) this.hcf.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hcc.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hcj.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hcl.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void bzJ() {
        com.baidu.tbadk.coreExtra.messageCenter.d.Jh().b(this.hco.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
