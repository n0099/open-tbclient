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
    private View aJu;
    private MsgSettingItemView gQP;
    private LinearLayout gQQ;
    private MsgSettingItemView gQR;
    private MsgSettingItemView gQS;
    private MsgSettingItemView gQT;
    private MsgSettingItemView gQU;
    private MsgSettingItemView gQV;
    private MsgSettingItemView gQW;
    private MsgSettingItemView gQX;
    private MsgSettingItemView gQY;
    private MsgSettingItemView gQZ;
    private MsgSettingItemView gRa;
    private MsgSettingItemView gRb;
    private LinearLayout gRc;
    private TextView gRd;
    private MsgSettingItemView gRe;
    private LinearLayout gRf;
    private TextView gRg;
    private LinearLayout gRh;
    private LinearLayout gRi;
    private LinearLayout gRj;
    private TextView gRk;
    private LinearLayout gRl;
    private TextView gRm;
    public boolean gRn;
    private MsgRemindActivity gRo;
    private TbSettingTextTipView gRp;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gRn = true;
        this.gRo = msgRemindActivity;
        msgRemindActivity.setContentView(e.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bvN();
        bvQ();
        bvP();
        bvO();
        bvR();
        d(msgRemindActivity);
        bvH();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(e.g.parent);
        msgRemindActivity.findViewById(e.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(e.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gRh = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.gRi = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.gQP = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.gQP.setText(e.j.receive_msg_text);
        this.gQP.setLineVisibility(false);
        this.gQQ = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.gQR = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.gQR.setText(e.j.reply);
        this.gQS = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.gQS.setVisibility(0);
        this.gQS.setText(e.j.action_praise_default);
        this.gQT = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.gQT.setText(e.j.mention_atme);
        this.gQU = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.gQU.setText(e.j.new_fans);
        this.gQV = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.gQV.setText(e.j.chat_msg_text);
        this.gQW = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.gQW.setLineVisibility(false);
        this.gQW.setText(e.j.group_chat_text);
        this.gQX = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.gQX.setText(e.j.remind_screen_lock);
        this.gQX.setLineVisibility(false);
        this.gQY = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.gQY.setText(e.j.remind_tone);
        this.gQZ = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.gQZ.setText(e.j.remind_vibrate);
        this.gRa = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.gRa.setLineVisibility(true);
        this.gRa.setText(e.j.remind_light);
        this.gRb = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.gRb.setText(e.j.sign_remind_outline);
        this.gRc = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.gRd = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.gRe = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.gRe.setText(e.j.no_disturb_mode);
        this.gRe.setLineVisibility(false);
        this.gRf = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.gRg = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.gRj = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.gRk = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.gRl = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.gRm = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.gRp = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
    }

    private void bvH() {
        bvI();
        bvJ();
        bvK();
        bvL();
    }

    private void bvI() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gRe.setVisibility(8);
            this.gRf.setVisibility(8);
            this.gQP.setVisibility(8);
            this.gQQ.setVisibility(8);
            this.gRb.setVisibility(8);
            this.gRc.setVisibility(8);
            this.gQY.setVisibility(8);
            this.gQZ.setVisibility(8);
            this.gRa.setVisibility(8);
            this.gQX.setVisibility(8);
        }
    }

    private void bvJ() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gQX.setLineVisibility(true);
        } else {
            this.gQX.setLineVisibility(false);
        }
    }

    private void bvK() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gQV.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gQW.setVisibility(0);
        } else {
            this.gQW.setVisibility(8);
        }
    }

    private void bvL() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gQX.setVisibility(0);
        } else {
            this.gQX.setVisibility(8);
        }
    }

    public View bvM() {
        return this.aJu;
    }

    private void bvN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hu()) {
            this.gQP.nQ();
            this.gQQ.setVisibility(0);
        } else {
            this.gQP.nR();
            this.gQQ.setVisibility(8);
        }
        this.gQR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hz());
        this.gQS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HJ());
        this.gQT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hx());
        this.gQU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hy());
        this.gQV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HA());
        this.gQW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HI());
    }

    private void bvO() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().isSignAlertOn()) {
            this.gRb.nS();
            this.gRc.setVisibility(0);
            this.gRb.setLineVisibility(true);
            bvS();
            return;
        }
        this.gRb.nT();
        this.gRb.setLineVisibility(false);
        this.gRc.setVisibility(8);
    }

    private void bvP() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HB()) {
            this.gQY.nQ();
        } else {
            this.gQY.nR();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HE()) {
            this.gQZ.nQ();
        } else {
            this.gQZ.nR();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HC()) {
            this.gRa.nQ();
        } else {
            this.gRa.nR();
        }
    }

    private void bvQ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HK()) {
            this.gQX.nQ();
        } else {
            this.gQX.nR();
        }
    }

    private void bvR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HD()) {
            this.gRe.nQ();
            this.gRf.setVisibility(0);
            bvT();
            return;
        }
        this.gRe.nR();
        this.gRf.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aJu.setOnClickListener(msgRemindActivity);
        this.gQP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gQZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gRa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gRb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gRc.setOnClickListener(msgRemindActivity);
        this.gRe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gRf.setOnClickListener(msgRemindActivity);
        this.gRj.setOnClickListener(msgRemindActivity);
        this.gRl.setOnClickListener(msgRemindActivity);
        this.gRp.setOnClickListener(msgRemindActivity);
    }

    public void mU(boolean z) {
        this.gRe.setLineVisibility(z);
        if (z) {
            this.gRf.setVisibility(0);
            bvT();
            al.i(this.gRf, e.f.more_all);
            return;
        }
        this.gRf.setVisibility(8);
    }

    public void mV(boolean z) {
        if (z) {
            this.gRc.setVisibility(0);
            this.gRb.setLineVisibility(true);
            al.i(this.gRc, e.f.more_all);
            return;
        }
        this.gRc.setVisibility(8);
        this.gRb.setLineVisibility(false);
    }

    public void mW(boolean z) {
        if (z) {
            this.gQQ.setVisibility(0);
        } else {
            this.gQQ.setVisibility(8);
        }
    }

    public void bvS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hs().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.Hs().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.Hs().getSignAlertMins();
            this.gRd.setText(this.gRo.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.gRc.setVisibility(0);
            if (!this.gRb.jJ()) {
                this.gRb.nQ();
                return;
            }
            return;
        }
        this.gRd.setText(e.j.close);
        this.gRc.setVisibility(8);
        if (this.gRb.jJ()) {
            this.gRb.nR();
        }
    }

    public void bvT() {
        String HF = com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HF();
        String HG = com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HG();
        this.gRg.setText(HF + Constants.ACCEPT_TIME_SEPARATOR_SERVER + HG);
        this.gRk.setText(HF);
        this.gRm.setText(HG);
    }

    public BdSwitchView bvU() {
        return this.gRb.getSwitchView();
    }

    public BdSwitchView bvV() {
        return this.gQP.getSwitchView();
    }

    public View bvW() {
        return this.gRc;
    }

    public BdSwitchView bvX() {
        return this.gRe.getSwitchView();
    }

    public View bvY() {
        return this.gRf;
    }

    public LinearLayout bvZ() {
        return this.gRj;
    }

    public LinearLayout bwa() {
        return this.gRl;
    }

    public BdSwitchView bwb() {
        return this.gQY.getSwitchView();
    }

    public BdSwitchView bwc() {
        return this.gQZ.getSwitchView();
    }

    public BdSwitchView bwd() {
        return this.gRa.getSwitchView();
    }

    public BdSwitchView bwe() {
        return this.gQX.getSwitchView();
    }

    public BdSwitchView bwf() {
        return this.gQR.getSwitchView();
    }

    public BdSwitchView bwg() {
        return this.gQS.getSwitchView();
    }

    public BdSwitchView bwh() {
        return this.gQT.getSwitchView();
    }

    public BdSwitchView bwi() {
        return this.gQV.getSwitchView();
    }

    public BdSwitchView bwj() {
        return this.gQW.getSwitchView();
    }

    public BdSwitchView bwk() {
        return this.gQU.getSwitchView();
    }

    public TbSettingTextTipView bwl() {
        return this.gRp;
    }

    public void bwm() {
        this.gQR.setOnSwitchStateChangeListener(null);
        this.gQR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hz());
        this.gQR.setOnSwitchStateChangeListener(this.gRo);
    }

    public void bwn() {
        this.gQS.setOnSwitchStateChangeListener(null);
        this.gQS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HJ());
        this.gQS.setOnSwitchStateChangeListener(this.gRo);
    }

    public void bwo() {
        this.gQT.setOnSwitchStateChangeListener(null);
        this.gQT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hx());
        this.gQT.setOnSwitchStateChangeListener(this.gRo);
    }

    public void bwp() {
        this.gQU.setOnSwitchStateChangeListener(null);
        this.gQU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hy());
        this.gQU.setOnSwitchStateChangeListener(this.gRo);
    }

    public void bwq() {
        this.gQV.setOnSwitchStateChangeListener(null);
        this.gQV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HA());
        this.gQV.setOnSwitchStateChangeListener(this.gRo);
    }

    public void bwr() {
        this.gQW.setOnSwitchStateChangeListener(null);
        this.gQW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HI());
        this.gQW.setOnSwitchStateChangeListener(this.gRo);
    }

    public void mX(boolean z) {
        if (this.gRn != z) {
            this.gRn = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gRo.getString(e.j.msg_remind));
                this.gRh.setVisibility(0);
                this.gRi.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gRo.getString(e.j.no_disturb_mode_time));
            this.gRi.setVisibility(0);
            this.gRh.setVisibility(8);
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
        this.gRo.getLayoutMode().setNightMode(i == 1);
        this.gRo.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gRo.getPageContext(), i);
        this.gQP.d(this.gRo.getPageContext(), i);
        this.gQR.d(this.gRo.getPageContext(), i);
        this.gQS.d(this.gRo.getPageContext(), i);
        this.gQT.d(this.gRo.getPageContext(), i);
        this.gQU.d(this.gRo.getPageContext(), i);
        this.gQV.d(this.gRo.getPageContext(), i);
        this.gQW.d(this.gRo.getPageContext(), i);
        this.gQX.d(this.gRo.getPageContext(), i);
        this.gQY.d(this.gRo.getPageContext(), i);
        this.gQZ.d(this.gRo.getPageContext(), i);
        this.gRa.d(this.gRo.getPageContext(), i);
        this.gRb.d(this.gRo.getPageContext(), i);
        this.gRe.d(this.gRo.getPageContext(), i);
        al.i(this.gRf, e.f.more_all);
        al.i(this.gRj, e.f.more_all);
        al.i(this.gRl, e.f.more_all);
        al.i(this.gRc, e.f.more_all);
        al.c((ImageView) this.gRf.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gRc.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gRj.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gRl.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void bws() {
        com.baidu.tbadk.coreExtra.messageCenter.d.HN().b(this.gRo.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
