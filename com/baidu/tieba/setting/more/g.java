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
    private View aNy;
    private MsgSettingItemView hbO;
    private LinearLayout hbP;
    private MsgSettingItemView hbQ;
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
    private LinearLayout hcb;
    private TextView hcc;
    private MsgSettingItemView hcd;
    private LinearLayout hce;
    private TextView hcf;
    private LinearLayout hcg;
    private LinearLayout hch;
    private LinearLayout hci;
    private TextView hcj;
    private LinearLayout hck;
    private TextView hcl;
    public boolean hcm;
    private MsgRemindActivity hcn;
    private TbSettingTextTipView hco;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.hcm = true;
        this.hcn = msgRemindActivity;
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
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hcg = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.hch = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.hbO = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.hbO.setText(e.j.receive_msg_text);
        this.hbO.setLineVisibility(false);
        this.hbP = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.hbQ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.hbQ.setText(e.j.reply);
        this.hbR = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.hbR.setVisibility(0);
        this.hbR.setText(e.j.action_praise_default);
        this.hbS = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.hbS.setText(e.j.mention_atme);
        this.hbT = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.hbT.setText(e.j.new_fans);
        this.hbU = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.hbU.setText(e.j.chat_msg_text);
        this.hbV = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.hbV.setLineVisibility(false);
        this.hbV.setText(e.j.group_chat_text);
        this.hbW = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.hbW.setText(e.j.remind_screen_lock);
        this.hbW.setLineVisibility(false);
        this.hbX = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.hbX.setText(e.j.remind_tone);
        this.hbY = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.hbY.setText(e.j.remind_vibrate);
        this.hbZ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.hbZ.setLineVisibility(true);
        this.hbZ.setText(e.j.remind_light);
        this.hca = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.hca.setText(e.j.sign_remind_outline);
        this.hcb = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.hcc = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.hcd = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.hcd.setText(e.j.no_disturb_mode);
        this.hcd.setLineVisibility(false);
        this.hce = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.hcf = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.hci = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.hcj = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.hck = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.hcl = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.hco = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
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
            this.hcd.setVisibility(8);
            this.hce.setVisibility(8);
            this.hbO.setVisibility(8);
            this.hbP.setVisibility(8);
            this.hca.setVisibility(8);
            this.hcb.setVisibility(8);
            this.hbX.setVisibility(8);
            this.hbY.setVisibility(8);
            this.hbZ.setVisibility(8);
            this.hbW.setVisibility(8);
        }
    }

    private void bza() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.hbW.setLineVisibility(true);
        } else {
            this.hbW.setLineVisibility(false);
        }
    }

    private void bzb() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.hbU.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.hbV.setVisibility(0);
        } else {
            this.hbV.setVisibility(8);
        }
    }

    private void bzc() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.hbW.setVisibility(0);
        } else {
            this.hbW.setVisibility(8);
        }
    }

    public View bzd() {
        return this.aNy;
    }

    private void bze() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IO()) {
            this.hbO.nT();
            this.hbP.setVisibility(0);
        } else {
            this.hbO.nU();
            this.hbP.setVisibility(8);
        }
        this.hbQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IT());
        this.hbR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jd());
        this.hbS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IR());
        this.hbT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IS());
        this.hbU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IU());
        this.hbV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jc());
    }

    private void bzf() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().isSignAlertOn()) {
            this.hca.nV();
            this.hcb.setVisibility(0);
            this.hca.setLineVisibility(true);
            bzj();
            return;
        }
        this.hca.nW();
        this.hca.setLineVisibility(false);
        this.hcb.setVisibility(8);
    }

    private void bzg() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IV()) {
            this.hbX.nT();
        } else {
            this.hbX.nU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IY()) {
            this.hbY.nT();
        } else {
            this.hbY.nU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IW()) {
            this.hbZ.nT();
        } else {
            this.hbZ.nU();
        }
    }

    private void bzh() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().Je()) {
            this.hbW.nT();
        } else {
            this.hbW.nU();
        }
    }

    private void bzi() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().IX()) {
            this.hcd.nT();
            this.hce.setVisibility(0);
            bzk();
            return;
        }
        this.hcd.nU();
        this.hce.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aNy.setOnClickListener(msgRemindActivity);
        this.hbO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hbZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hca.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hcb.setOnClickListener(msgRemindActivity);
        this.hcd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.hce.setOnClickListener(msgRemindActivity);
        this.hci.setOnClickListener(msgRemindActivity);
        this.hck.setOnClickListener(msgRemindActivity);
        this.hco.setOnClickListener(msgRemindActivity);
    }

    public void nb(boolean z) {
        this.hcd.setLineVisibility(z);
        if (z) {
            this.hce.setVisibility(0);
            bzk();
            al.i(this.hce, e.f.more_all);
            return;
        }
        this.hce.setVisibility(8);
    }

    public void nc(boolean z) {
        if (z) {
            this.hcb.setVisibility(0);
            this.hca.setLineVisibility(true);
            al.i(this.hcb, e.f.more_all);
            return;
        }
        this.hcb.setVisibility(8);
        this.hca.setLineVisibility(false);
    }

    public void nd(boolean z) {
        if (z) {
            this.hbP.setVisibility(0);
        } else {
            this.hbP.setVisibility(8);
        }
    }

    public void bzj() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.IM().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.IM().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.IM().getSignAlertMins();
            this.hcc.setText(this.hcn.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.hcb.setVisibility(0);
            if (!this.hca.jJ()) {
                this.hca.nT();
                return;
            }
            return;
        }
        this.hcc.setText(e.j.close);
        this.hcb.setVisibility(8);
        if (this.hca.jJ()) {
            this.hca.nU();
        }
    }

    public void bzk() {
        String IZ = com.baidu.tbadk.coreExtra.messageCenter.c.IM().IZ();
        String Ja = com.baidu.tbadk.coreExtra.messageCenter.c.IM().Ja();
        this.hcf.setText(IZ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Ja);
        this.hcj.setText(IZ);
        this.hcl.setText(Ja);
    }

    public BdSwitchView bzl() {
        return this.hca.getSwitchView();
    }

    public BdSwitchView bzm() {
        return this.hbO.getSwitchView();
    }

    public View bzn() {
        return this.hcb;
    }

    public BdSwitchView bzo() {
        return this.hcd.getSwitchView();
    }

    public View bzp() {
        return this.hce;
    }

    public LinearLayout bzq() {
        return this.hci;
    }

    public LinearLayout bzr() {
        return this.hck;
    }

    public BdSwitchView bzs() {
        return this.hbX.getSwitchView();
    }

    public BdSwitchView bzt() {
        return this.hbY.getSwitchView();
    }

    public BdSwitchView bzu() {
        return this.hbZ.getSwitchView();
    }

    public BdSwitchView bzv() {
        return this.hbW.getSwitchView();
    }

    public BdSwitchView bzw() {
        return this.hbQ.getSwitchView();
    }

    public BdSwitchView bzx() {
        return this.hbR.getSwitchView();
    }

    public BdSwitchView bzy() {
        return this.hbS.getSwitchView();
    }

    public BdSwitchView bzz() {
        return this.hbU.getSwitchView();
    }

    public BdSwitchView bzA() {
        return this.hbV.getSwitchView();
    }

    public BdSwitchView bzB() {
        return this.hbT.getSwitchView();
    }

    public TbSettingTextTipView bzC() {
        return this.hco;
    }

    public void bzD() {
        this.hbQ.setOnSwitchStateChangeListener(null);
        this.hbQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IT());
        this.hbQ.setOnSwitchStateChangeListener(this.hcn);
    }

    public void bzE() {
        this.hbR.setOnSwitchStateChangeListener(null);
        this.hbR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jd());
        this.hbR.setOnSwitchStateChangeListener(this.hcn);
    }

    public void bzF() {
        this.hbS.setOnSwitchStateChangeListener(null);
        this.hbS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IR());
        this.hbS.setOnSwitchStateChangeListener(this.hcn);
    }

    public void bzG() {
        this.hbT.setOnSwitchStateChangeListener(null);
        this.hbT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IS());
        this.hbT.setOnSwitchStateChangeListener(this.hcn);
    }

    public void bzH() {
        this.hbU.setOnSwitchStateChangeListener(null);
        this.hbU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().IU());
        this.hbU.setOnSwitchStateChangeListener(this.hcn);
    }

    public void bzI() {
        this.hbV.setOnSwitchStateChangeListener(null);
        this.hbV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jc());
        this.hbV.setOnSwitchStateChangeListener(this.hcn);
    }

    public void ne(boolean z) {
        if (this.hcm != z) {
            this.hcm = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.hcn.getString(e.j.msg_remind));
                this.hcg.setVisibility(0);
                this.hch.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.hcn.getString(e.j.no_disturb_mode_time));
            this.hch.setVisibility(0);
            this.hcg.setVisibility(8);
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
        this.hcn.getLayoutMode().setNightMode(i == 1);
        this.hcn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.hcn.getPageContext(), i);
        this.hbO.d(this.hcn.getPageContext(), i);
        this.hbQ.d(this.hcn.getPageContext(), i);
        this.hbR.d(this.hcn.getPageContext(), i);
        this.hbS.d(this.hcn.getPageContext(), i);
        this.hbT.d(this.hcn.getPageContext(), i);
        this.hbU.d(this.hcn.getPageContext(), i);
        this.hbV.d(this.hcn.getPageContext(), i);
        this.hbW.d(this.hcn.getPageContext(), i);
        this.hbX.d(this.hcn.getPageContext(), i);
        this.hbY.d(this.hcn.getPageContext(), i);
        this.hbZ.d(this.hcn.getPageContext(), i);
        this.hca.d(this.hcn.getPageContext(), i);
        this.hcd.d(this.hcn.getPageContext(), i);
        al.i(this.hce, e.f.more_all);
        al.i(this.hci, e.f.more_all);
        al.i(this.hck, e.f.more_all);
        al.i(this.hcb, e.f.more_all);
        al.c((ImageView) this.hce.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hcb.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hci.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.hck.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void bzJ() {
        com.baidu.tbadk.coreExtra.messageCenter.d.Jh().b(this.hcn.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
