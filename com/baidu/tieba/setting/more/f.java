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
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aEa;
    private MsgSettingItemView gHT;
    private LinearLayout gHU;
    private MsgSettingItemView gHV;
    private MsgSettingItemView gHW;
    private MsgSettingItemView gHX;
    private MsgSettingItemView gHY;
    private MsgSettingItemView gHZ;
    private MsgSettingItemView gIa;
    private MsgSettingItemView gIb;
    private MsgSettingItemView gIc;
    private MsgSettingItemView gId;
    private MsgSettingItemView gIe;
    private MsgSettingItemView gIf;
    private LinearLayout gIg;
    private TextView gIh;
    private MsgSettingItemView gIi;
    private LinearLayout gIj;
    private TextView gIk;
    private LinearLayout gIl;
    private LinearLayout gIm;
    private LinearLayout gIn;
    private TextView gIo;
    private LinearLayout gIp;
    private TextView gIq;
    public boolean gIr;
    private MsgRemindActivity gIs;
    private TbSettingTextTipView gIt;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gIr = true;
        this.gIs = msgRemindActivity;
        msgRemindActivity.setContentView(e.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        btc();
        btf();
        bte();
        btd();
        btg();
        d(msgRemindActivity);
        bsW();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(e.g.parent);
        msgRemindActivity.findViewById(e.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(e.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIl = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.gIm = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.gHT = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.gHT.setText(e.j.receive_msg_text);
        this.gHT.setLineVisibility(false);
        this.gHU = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.gHV = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.gHV.setText(e.j.reply);
        this.gHW = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.gHW.setVisibility(0);
        this.gHW.setText(e.j.action_praise_default);
        this.gHX = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.gHX.setText(e.j.mention_atme);
        this.gHY = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.gHY.setText(e.j.new_fans);
        this.gHZ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.gHZ.setText(e.j.chat_msg_text);
        this.gIa = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.gIa.setLineVisibility(false);
        this.gIa.setText(e.j.group_chat_text);
        this.gIb = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.gIb.setText(e.j.remind_screen_lock);
        this.gIb.setLineVisibility(false);
        this.gIc = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.gIc.setText(e.j.remind_tone);
        this.gId = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.gId.setText(e.j.remind_vibrate);
        this.gIe = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.gIe.setLineVisibility(true);
        this.gIe.setText(e.j.remind_light);
        this.gIf = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.gIf.setText(e.j.sign_remind_outline);
        this.gIg = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.gIh = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.gIi = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.gIi.setText(e.j.no_disturb_mode);
        this.gIi.setLineVisibility(false);
        this.gIj = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.gIk = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.gIn = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.gIo = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.gIp = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.gIq = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.gIt = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
    }

    private void bsW() {
        bsX();
        bsY();
        bsZ();
        bta();
    }

    private void bsX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gIi.setVisibility(8);
            this.gIj.setVisibility(8);
            this.gHT.setVisibility(8);
            this.gHU.setVisibility(8);
            this.gIf.setVisibility(8);
            this.gIg.setVisibility(8);
            this.gIc.setVisibility(8);
            this.gId.setVisibility(8);
            this.gIe.setVisibility(8);
            this.gIb.setVisibility(8);
        }
    }

    private void bsY() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gIb.setLineVisibility(true);
        } else {
            this.gIb.setLineVisibility(false);
        }
    }

    private void bsZ() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gHZ.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gIa.setVisibility(0);
        } else {
            this.gIa.setVisibility(8);
        }
    }

    private void bta() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gIb.setVisibility(0);
        } else {
            this.gIb.setVisibility(8);
        }
    }

    public View btb() {
        return this.aEa;
    }

    private void btc() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fh()) {
            this.gHT.nI();
            this.gHU.setVisibility(0);
        } else {
            this.gHT.nJ();
            this.gHU.setVisibility(8);
        }
        this.gHV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fm());
        this.gHW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fw());
        this.gHX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fk());
        this.gHY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fl());
        this.gHZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fn());
        this.gIa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fv());
    }

    private void btd() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().isSignAlertOn()) {
            this.gIf.nK();
            this.gIg.setVisibility(0);
            this.gIf.setLineVisibility(true);
            bth();
            return;
        }
        this.gIf.nL();
        this.gIf.setLineVisibility(false);
        this.gIg.setVisibility(8);
    }

    private void bte() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fo()) {
            this.gIc.nI();
        } else {
            this.gIc.nJ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fr()) {
            this.gId.nI();
        } else {
            this.gId.nJ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fp()) {
            this.gIe.nI();
        } else {
            this.gIe.nJ();
        }
    }

    private void btf() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fx()) {
            this.gIb.nI();
        } else {
            this.gIb.nJ();
        }
    }

    private void btg() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fq()) {
            this.gIi.nI();
            this.gIj.setVisibility(0);
            bti();
            return;
        }
        this.gIi.nJ();
        this.gIj.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aEa.setOnClickListener(msgRemindActivity);
        this.gHT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gHV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gHX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gHW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gHY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gHZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gId.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIg.setOnClickListener(msgRemindActivity);
        this.gIi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gIj.setOnClickListener(msgRemindActivity);
        this.gIn.setOnClickListener(msgRemindActivity);
        this.gIp.setOnClickListener(msgRemindActivity);
        this.gIt.setOnClickListener(msgRemindActivity);
    }

    public void ms(boolean z) {
        this.gIi.setLineVisibility(z);
        if (z) {
            this.gIj.setVisibility(0);
            bti();
            al.i(this.gIj, e.f.more_all);
            return;
        }
        this.gIj.setVisibility(8);
    }

    public void mt(boolean z) {
        if (z) {
            this.gIg.setVisibility(0);
            this.gIf.setLineVisibility(true);
            al.i(this.gIg, e.f.more_all);
            return;
        }
        this.gIg.setVisibility(8);
        this.gIf.setLineVisibility(false);
    }

    public void mu(boolean z) {
        if (z) {
            this.gHU.setVisibility(0);
        } else {
            this.gHU.setVisibility(8);
        }
    }

    public void bth() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ff().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.Ff().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.Ff().getSignAlertMins();
            this.gIh.setText(this.gIs.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.gIg.setVisibility(0);
            if (!this.gIf.jw()) {
                this.gIf.nI();
                return;
            }
            return;
        }
        this.gIh.setText(e.j.close);
        this.gIg.setVisibility(8);
        if (this.gIf.jw()) {
            this.gIf.nJ();
        }
    }

    public void bti() {
        String Fs = com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fs();
        String Ft = com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Ft();
        this.gIk.setText(Fs + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Ft);
        this.gIo.setText(Fs);
        this.gIq.setText(Ft);
    }

    public BdSwitchView btj() {
        return this.gIf.getSwitchView();
    }

    public BdSwitchView btk() {
        return this.gHT.getSwitchView();
    }

    public View btl() {
        return this.gIg;
    }

    public BdSwitchView btm() {
        return this.gIi.getSwitchView();
    }

    public View btn() {
        return this.gIj;
    }

    public LinearLayout bto() {
        return this.gIn;
    }

    public LinearLayout btp() {
        return this.gIp;
    }

    public BdSwitchView btq() {
        return this.gIc.getSwitchView();
    }

    public BdSwitchView btr() {
        return this.gId.getSwitchView();
    }

    public BdSwitchView bts() {
        return this.gIe.getSwitchView();
    }

    public BdSwitchView btt() {
        return this.gIb.getSwitchView();
    }

    public BdSwitchView btu() {
        return this.gHV.getSwitchView();
    }

    public BdSwitchView btv() {
        return this.gHW.getSwitchView();
    }

    public BdSwitchView btw() {
        return this.gHX.getSwitchView();
    }

    public BdSwitchView btx() {
        return this.gHZ.getSwitchView();
    }

    public BdSwitchView bty() {
        return this.gIa.getSwitchView();
    }

    public BdSwitchView btz() {
        return this.gHY.getSwitchView();
    }

    public TbSettingTextTipView btA() {
        return this.gIt;
    }

    public void btB() {
        this.gHV.setOnSwitchStateChangeListener(null);
        this.gHV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fm());
        this.gHV.setOnSwitchStateChangeListener(this.gIs);
    }

    public void btC() {
        this.gHW.setOnSwitchStateChangeListener(null);
        this.gHW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fw());
        this.gHW.setOnSwitchStateChangeListener(this.gIs);
    }

    public void btD() {
        this.gHX.setOnSwitchStateChangeListener(null);
        this.gHX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fk());
        this.gHX.setOnSwitchStateChangeListener(this.gIs);
    }

    public void btE() {
        this.gHY.setOnSwitchStateChangeListener(null);
        this.gHY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fl());
        this.gHY.setOnSwitchStateChangeListener(this.gIs);
    }

    public void btF() {
        this.gHZ.setOnSwitchStateChangeListener(null);
        this.gHZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fn());
        this.gHZ.setOnSwitchStateChangeListener(this.gIs);
    }

    public void btG() {
        this.gIa.setOnSwitchStateChangeListener(null);
        this.gIa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fv());
        this.gIa.setOnSwitchStateChangeListener(this.gIs);
    }

    public void mv(boolean z) {
        if (this.gIr != z) {
            this.gIr = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gIs.getString(e.j.msg_remind));
                this.gIl.setVisibility(0);
                this.gIm.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gIs.getString(e.j.no_disturb_mode_time));
            this.gIm.setVisibility(0);
            this.gIl.setVisibility(8);
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
        this.gIs.getLayoutMode().setNightMode(i == 1);
        this.gIs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gIs.getPageContext(), i);
        this.gHT.d(this.gIs.getPageContext(), i);
        this.gHV.d(this.gIs.getPageContext(), i);
        this.gHW.d(this.gIs.getPageContext(), i);
        this.gHX.d(this.gIs.getPageContext(), i);
        this.gHY.d(this.gIs.getPageContext(), i);
        this.gHZ.d(this.gIs.getPageContext(), i);
        this.gIa.d(this.gIs.getPageContext(), i);
        this.gIb.d(this.gIs.getPageContext(), i);
        this.gIc.d(this.gIs.getPageContext(), i);
        this.gId.d(this.gIs.getPageContext(), i);
        this.gIe.d(this.gIs.getPageContext(), i);
        this.gIf.d(this.gIs.getPageContext(), i);
        this.gIi.d(this.gIs.getPageContext(), i);
        al.i(this.gIj, e.f.more_all);
        al.i(this.gIn, e.f.more_all);
        al.i(this.gIp, e.f.more_all);
        al.i(this.gIg, e.f.more_all);
        al.c((ImageView) this.gIj.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gIg.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gIn.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gIp.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void btH() {
        com.baidu.tbadk.coreExtra.messageCenter.d.FA().b(this.gIs.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
