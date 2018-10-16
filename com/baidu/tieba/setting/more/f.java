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
    private View aIE;
    private MsgSettingItemView gPA;
    private MsgSettingItemView gPB;
    private LinearLayout gPC;
    private TextView gPD;
    private MsgSettingItemView gPE;
    private LinearLayout gPF;
    private TextView gPG;
    private LinearLayout gPH;
    private LinearLayout gPI;
    private LinearLayout gPJ;
    private TextView gPK;
    private LinearLayout gPL;
    private TextView gPM;
    public boolean gPN;
    private MsgRemindActivity gPO;
    private TbSettingTextTipView gPP;
    private MsgSettingItemView gPp;
    private LinearLayout gPq;
    private MsgSettingItemView gPr;
    private MsgSettingItemView gPs;
    private MsgSettingItemView gPt;
    private MsgSettingItemView gPu;
    private MsgSettingItemView gPv;
    private MsgSettingItemView gPw;
    private MsgSettingItemView gPx;
    private MsgSettingItemView gPy;
    private MsgSettingItemView gPz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gPN = true;
        this.gPO = msgRemindActivity;
        msgRemindActivity.setContentView(e.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bwr();
        bwu();
        bwt();
        bws();
        bwv();
        d(msgRemindActivity);
        bwl();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(e.g.parent);
        msgRemindActivity.findViewById(e.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(e.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gPH = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.gPI = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.gPp = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.gPp.setText(e.j.receive_msg_text);
        this.gPp.setLineVisibility(false);
        this.gPq = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.gPr = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.gPr.setText(e.j.reply);
        this.gPs = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.gPs.setVisibility(0);
        this.gPs.setText(e.j.action_praise_default);
        this.gPt = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.gPt.setText(e.j.mention_atme);
        this.gPu = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.gPu.setText(e.j.new_fans);
        this.gPv = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.gPv.setText(e.j.chat_msg_text);
        this.gPw = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.gPw.setLineVisibility(false);
        this.gPw.setText(e.j.group_chat_text);
        this.gPx = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.gPx.setText(e.j.remind_screen_lock);
        this.gPx.setLineVisibility(false);
        this.gPy = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.gPy.setText(e.j.remind_tone);
        this.gPz = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.gPz.setText(e.j.remind_vibrate);
        this.gPA = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.gPA.setLineVisibility(true);
        this.gPA.setText(e.j.remind_light);
        this.gPB = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.gPB.setText(e.j.sign_remind_outline);
        this.gPC = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.gPD = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.gPE = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.gPE.setText(e.j.no_disturb_mode);
        this.gPE.setLineVisibility(false);
        this.gPF = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.gPG = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.gPJ = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.gPK = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.gPL = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.gPM = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.gPP = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
    }

    private void bwl() {
        bwm();
        bwn();
        bwo();
        bwp();
    }

    private void bwm() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gPE.setVisibility(8);
            this.gPF.setVisibility(8);
            this.gPp.setVisibility(8);
            this.gPq.setVisibility(8);
            this.gPB.setVisibility(8);
            this.gPC.setVisibility(8);
            this.gPy.setVisibility(8);
            this.gPz.setVisibility(8);
            this.gPA.setVisibility(8);
            this.gPx.setVisibility(8);
        }
    }

    private void bwn() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gPx.setLineVisibility(true);
        } else {
            this.gPx.setLineVisibility(false);
        }
    }

    private void bwo() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gPv.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gPw.setVisibility(0);
        } else {
            this.gPw.setVisibility(8);
        }
    }

    private void bwp() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gPx.setVisibility(0);
        } else {
            this.gPx.setVisibility(8);
        }
    }

    public View bwq() {
        return this.aIE;
    }

    private void bwr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hi()) {
            this.gPp.nS();
            this.gPq.setVisibility(0);
        } else {
            this.gPp.nT();
            this.gPq.setVisibility(8);
        }
        this.gPr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hn());
        this.gPs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hx());
        this.gPt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hl());
        this.gPu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hm());
        this.gPv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ho());
        this.gPw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hw());
    }

    private void bws() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().isSignAlertOn()) {
            this.gPB.nU();
            this.gPC.setVisibility(0);
            this.gPB.setLineVisibility(true);
            bww();
            return;
        }
        this.gPB.nV();
        this.gPB.setLineVisibility(false);
        this.gPC.setVisibility(8);
    }

    private void bwt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hp()) {
            this.gPy.nS();
        } else {
            this.gPy.nT();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hs()) {
            this.gPz.nS();
        } else {
            this.gPz.nT();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hq()) {
            this.gPA.nS();
        } else {
            this.gPA.nT();
        }
    }

    private void bwu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hy()) {
            this.gPx.nS();
        } else {
            this.gPx.nT();
        }
    }

    private void bwv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hr()) {
            this.gPE.nS();
            this.gPF.setVisibility(0);
            bwx();
            return;
        }
        this.gPE.nT();
        this.gPF.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aIE.setOnClickListener(msgRemindActivity);
        this.gPp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPC.setOnClickListener(msgRemindActivity);
        this.gPE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPF.setOnClickListener(msgRemindActivity);
        this.gPJ.setOnClickListener(msgRemindActivity);
        this.gPL.setOnClickListener(msgRemindActivity);
        this.gPP.setOnClickListener(msgRemindActivity);
    }

    public void mJ(boolean z) {
        this.gPE.setLineVisibility(z);
        if (z) {
            this.gPF.setVisibility(0);
            bwx();
            al.i(this.gPF, e.f.more_all);
            return;
        }
        this.gPF.setVisibility(8);
    }

    public void mK(boolean z) {
        if (z) {
            this.gPC.setVisibility(0);
            this.gPB.setLineVisibility(true);
            al.i(this.gPC, e.f.more_all);
            return;
        }
        this.gPC.setVisibility(8);
        this.gPB.setLineVisibility(false);
    }

    public void mL(boolean z) {
        if (z) {
            this.gPq.setVisibility(0);
        } else {
            this.gPq.setVisibility(8);
        }
    }

    public void bww() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().getSignAlertMins();
            this.gPD.setText(this.gPO.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.gPC.setVisibility(0);
            if (!this.gPB.jL()) {
                this.gPB.nS();
                return;
            }
            return;
        }
        this.gPD.setText(e.j.close);
        this.gPC.setVisibility(8);
        if (this.gPB.jL()) {
            this.gPB.nT();
        }
    }

    public void bwx() {
        String Ht = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ht();
        String Hu = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hu();
        this.gPG.setText(Ht + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Hu);
        this.gPK.setText(Ht);
        this.gPM.setText(Hu);
    }

    public BdSwitchView bwy() {
        return this.gPB.getSwitchView();
    }

    public BdSwitchView bwz() {
        return this.gPp.getSwitchView();
    }

    public View bwA() {
        return this.gPC;
    }

    public BdSwitchView bwB() {
        return this.gPE.getSwitchView();
    }

    public View bwC() {
        return this.gPF;
    }

    public LinearLayout bwD() {
        return this.gPJ;
    }

    public LinearLayout bwE() {
        return this.gPL;
    }

    public BdSwitchView bwF() {
        return this.gPy.getSwitchView();
    }

    public BdSwitchView bwG() {
        return this.gPz.getSwitchView();
    }

    public BdSwitchView bwH() {
        return this.gPA.getSwitchView();
    }

    public BdSwitchView bwI() {
        return this.gPx.getSwitchView();
    }

    public BdSwitchView bwJ() {
        return this.gPr.getSwitchView();
    }

    public BdSwitchView bwK() {
        return this.gPs.getSwitchView();
    }

    public BdSwitchView bwL() {
        return this.gPt.getSwitchView();
    }

    public BdSwitchView bwM() {
        return this.gPv.getSwitchView();
    }

    public BdSwitchView bwN() {
        return this.gPw.getSwitchView();
    }

    public BdSwitchView bwO() {
        return this.gPu.getSwitchView();
    }

    public TbSettingTextTipView bwP() {
        return this.gPP;
    }

    public void bwQ() {
        this.gPr.setOnSwitchStateChangeListener(null);
        this.gPr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hn());
        this.gPr.setOnSwitchStateChangeListener(this.gPO);
    }

    public void bwR() {
        this.gPs.setOnSwitchStateChangeListener(null);
        this.gPs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hx());
        this.gPs.setOnSwitchStateChangeListener(this.gPO);
    }

    public void bwS() {
        this.gPt.setOnSwitchStateChangeListener(null);
        this.gPt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hl());
        this.gPt.setOnSwitchStateChangeListener(this.gPO);
    }

    public void bwT() {
        this.gPu.setOnSwitchStateChangeListener(null);
        this.gPu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hm());
        this.gPu.setOnSwitchStateChangeListener(this.gPO);
    }

    public void bwU() {
        this.gPv.setOnSwitchStateChangeListener(null);
        this.gPv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ho());
        this.gPv.setOnSwitchStateChangeListener(this.gPO);
    }

    public void bwV() {
        this.gPw.setOnSwitchStateChangeListener(null);
        this.gPw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hw());
        this.gPw.setOnSwitchStateChangeListener(this.gPO);
    }

    public void mM(boolean z) {
        if (this.gPN != z) {
            this.gPN = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gPO.getString(e.j.msg_remind));
                this.gPH.setVisibility(0);
                this.gPI.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gPO.getString(e.j.no_disturb_mode_time));
            this.gPI.setVisibility(0);
            this.gPH.setVisibility(8);
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
        this.gPO.getLayoutMode().setNightMode(i == 1);
        this.gPO.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gPO.getPageContext(), i);
        this.gPp.d(this.gPO.getPageContext(), i);
        this.gPr.d(this.gPO.getPageContext(), i);
        this.gPs.d(this.gPO.getPageContext(), i);
        this.gPt.d(this.gPO.getPageContext(), i);
        this.gPu.d(this.gPO.getPageContext(), i);
        this.gPv.d(this.gPO.getPageContext(), i);
        this.gPw.d(this.gPO.getPageContext(), i);
        this.gPx.d(this.gPO.getPageContext(), i);
        this.gPy.d(this.gPO.getPageContext(), i);
        this.gPz.d(this.gPO.getPageContext(), i);
        this.gPA.d(this.gPO.getPageContext(), i);
        this.gPB.d(this.gPO.getPageContext(), i);
        this.gPE.d(this.gPO.getPageContext(), i);
        al.i(this.gPF, e.f.more_all);
        al.i(this.gPJ, e.f.more_all);
        al.i(this.gPL, e.f.more_all);
        al.i(this.gPC, e.f.more_all);
        al.c((ImageView) this.gPF.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gPC.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gPJ.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gPL.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void bwW() {
        com.baidu.tbadk.coreExtra.messageCenter.d.HB().b(this.gPO.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
