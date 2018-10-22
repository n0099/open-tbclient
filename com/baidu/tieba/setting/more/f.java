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
    private MsgSettingItemView gPC;
    private LinearLayout gPD;
    private TextView gPE;
    private MsgSettingItemView gPF;
    private LinearLayout gPG;
    private TextView gPH;
    private LinearLayout gPI;
    private LinearLayout gPJ;
    private LinearLayout gPK;
    private TextView gPL;
    private LinearLayout gPM;
    private TextView gPN;
    public boolean gPO;
    private MsgRemindActivity gPP;
    private TbSettingTextTipView gPQ;
    private MsgSettingItemView gPq;
    private LinearLayout gPr;
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
        this.gPO = true;
        this.gPP = msgRemindActivity;
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
        this.gPI = (LinearLayout) msgRemindActivity.findViewById(e.g.front_container);
        this.gPJ = (LinearLayout) msgRemindActivity.findViewById(e.g.back_container);
        this.gPq = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.receive_message_swtich);
        this.gPq.setText(e.j.receive_msg_text);
        this.gPq.setLineVisibility(false);
        this.gPr = (LinearLayout) msgRemindActivity.findViewById(e.g.receive_message_container);
        this.gPs = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.reply_check_box);
        this.gPs.setText(e.j.reply);
        this.gPt = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.zan_check_box);
        this.gPt.setVisibility(0);
        this.gPt.setText(e.j.action_praise_default);
        this.gPu = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.at_me_check_box);
        this.gPu.setText(e.j.mention_atme);
        this.gPv = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.new_fans_swtich);
        this.gPv.setText(e.j.new_fans);
        this.gPw = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.chat_msg_swtich);
        this.gPw.setText(e.j.chat_msg_text);
        this.gPx = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.group_chat_swtich);
        this.gPx.setLineVisibility(false);
        this.gPx.setText(e.j.group_chat_text);
        this.gPy = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.screen_lock_swtich);
        this.gPy.setText(e.j.remind_screen_lock);
        this.gPy.setLineVisibility(false);
        this.gPz = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.tone_remind_swtich);
        this.gPz.setText(e.j.remind_tone);
        this.gPA = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.vibrate_remind_swtich);
        this.gPA.setText(e.j.remind_vibrate);
        this.gPB = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.light_remind_swtich);
        this.gPB.setLineVisibility(true);
        this.gPB.setText(e.j.remind_light);
        this.gPC = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.sign_remind_swtich);
        this.gPC.setText(e.j.sign_remind_outline);
        this.gPD = (LinearLayout) msgRemindActivity.findViewById(e.g.sign_remind);
        this.gPE = (TextView) msgRemindActivity.findViewById(e.g.sign_remind_time);
        this.gPF = (MsgSettingItemView) msgRemindActivity.findViewById(e.g.no_disturb_swtich);
        this.gPF.setText(e.j.no_disturb_mode);
        this.gPF.setLineVisibility(false);
        this.gPG = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_container);
        this.gPH = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_mode_time_value);
        this.gPK = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_start_time);
        this.gPL = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_start_time_value);
        this.gPM = (LinearLayout) msgRemindActivity.findViewById(e.g.no_disturb_end_time);
        this.gPN = (TextView) msgRemindActivity.findViewById(e.g.no_disturb_end_time_value);
        this.gPQ = (TbSettingTextTipView) msgRemindActivity.findViewById(e.g.msg_receive_item_view);
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
            this.gPF.setVisibility(8);
            this.gPG.setVisibility(8);
            this.gPq.setVisibility(8);
            this.gPr.setVisibility(8);
            this.gPC.setVisibility(8);
            this.gPD.setVisibility(8);
            this.gPz.setVisibility(8);
            this.gPA.setVisibility(8);
            this.gPB.setVisibility(8);
            this.gPy.setVisibility(8);
        }
    }

    private void bwn() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gPy.setLineVisibility(true);
        } else {
            this.gPy.setLineVisibility(false);
        }
    }

    private void bwo() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gPw.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gPx.setVisibility(0);
        } else {
            this.gPx.setVisibility(8);
        }
    }

    private void bwp() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gPy.setVisibility(0);
        } else {
            this.gPy.setVisibility(8);
        }
    }

    public View bwq() {
        return this.aIE;
    }

    private void bwr() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hi()) {
            this.gPq.nS();
            this.gPr.setVisibility(0);
        } else {
            this.gPq.nT();
            this.gPr.setVisibility(8);
        }
        this.gPs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hn());
        this.gPt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hx());
        this.gPu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hl());
        this.gPv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hm());
        this.gPw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ho());
        this.gPx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hw());
    }

    private void bws() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().isSignAlertOn()) {
            this.gPC.nU();
            this.gPD.setVisibility(0);
            this.gPC.setLineVisibility(true);
            bww();
            return;
        }
        this.gPC.nV();
        this.gPC.setLineVisibility(false);
        this.gPD.setVisibility(8);
    }

    private void bwt() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hp()) {
            this.gPz.nS();
        } else {
            this.gPz.nT();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hs()) {
            this.gPA.nS();
        } else {
            this.gPA.nT();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hq()) {
            this.gPB.nS();
        } else {
            this.gPB.nT();
        }
    }

    private void bwu() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hy()) {
            this.gPy.nS();
        } else {
            this.gPy.nT();
        }
    }

    private void bwv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hr()) {
            this.gPF.nS();
            this.gPG.setVisibility(0);
            bwx();
            return;
        }
        this.gPF.nT();
        this.gPG.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aIE.setOnClickListener(msgRemindActivity);
        this.gPq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPD.setOnClickListener(msgRemindActivity);
        this.gPF.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gPG.setOnClickListener(msgRemindActivity);
        this.gPK.setOnClickListener(msgRemindActivity);
        this.gPM.setOnClickListener(msgRemindActivity);
        this.gPQ.setOnClickListener(msgRemindActivity);
    }

    public void mJ(boolean z) {
        this.gPF.setLineVisibility(z);
        if (z) {
            this.gPG.setVisibility(0);
            bwx();
            al.i(this.gPG, e.f.more_all);
            return;
        }
        this.gPG.setVisibility(8);
    }

    public void mK(boolean z) {
        if (z) {
            this.gPD.setVisibility(0);
            this.gPC.setLineVisibility(true);
            al.i(this.gPD, e.f.more_all);
            return;
        }
        this.gPD.setVisibility(8);
        this.gPC.setLineVisibility(false);
    }

    public void mL(boolean z) {
        if (z) {
            this.gPr.setVisibility(0);
        } else {
            this.gPr.setVisibility(8);
        }
    }

    public void bww() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Hg().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().getSignAlertMins();
            this.gPE.setText(this.gPP.getString(e.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.gPD.setVisibility(0);
            if (!this.gPC.jL()) {
                this.gPC.nS();
                return;
            }
            return;
        }
        this.gPE.setText(e.j.close);
        this.gPD.setVisibility(8);
        if (this.gPC.jL()) {
            this.gPC.nT();
        }
    }

    public void bwx() {
        String Ht = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ht();
        String Hu = com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hu();
        this.gPH.setText(Ht + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Hu);
        this.gPL.setText(Ht);
        this.gPN.setText(Hu);
    }

    public BdSwitchView bwy() {
        return this.gPC.getSwitchView();
    }

    public BdSwitchView bwz() {
        return this.gPq.getSwitchView();
    }

    public View bwA() {
        return this.gPD;
    }

    public BdSwitchView bwB() {
        return this.gPF.getSwitchView();
    }

    public View bwC() {
        return this.gPG;
    }

    public LinearLayout bwD() {
        return this.gPK;
    }

    public LinearLayout bwE() {
        return this.gPM;
    }

    public BdSwitchView bwF() {
        return this.gPz.getSwitchView();
    }

    public BdSwitchView bwG() {
        return this.gPA.getSwitchView();
    }

    public BdSwitchView bwH() {
        return this.gPB.getSwitchView();
    }

    public BdSwitchView bwI() {
        return this.gPy.getSwitchView();
    }

    public BdSwitchView bwJ() {
        return this.gPs.getSwitchView();
    }

    public BdSwitchView bwK() {
        return this.gPt.getSwitchView();
    }

    public BdSwitchView bwL() {
        return this.gPu.getSwitchView();
    }

    public BdSwitchView bwM() {
        return this.gPw.getSwitchView();
    }

    public BdSwitchView bwN() {
        return this.gPx.getSwitchView();
    }

    public BdSwitchView bwO() {
        return this.gPv.getSwitchView();
    }

    public TbSettingTextTipView bwP() {
        return this.gPQ;
    }

    public void bwQ() {
        this.gPs.setOnSwitchStateChangeListener(null);
        this.gPs.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hn());
        this.gPs.setOnSwitchStateChangeListener(this.gPP);
    }

    public void bwR() {
        this.gPt.setOnSwitchStateChangeListener(null);
        this.gPt.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hx());
        this.gPt.setOnSwitchStateChangeListener(this.gPP);
    }

    public void bwS() {
        this.gPu.setOnSwitchStateChangeListener(null);
        this.gPu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hl());
        this.gPu.setOnSwitchStateChangeListener(this.gPP);
    }

    public void bwT() {
        this.gPv.setOnSwitchStateChangeListener(null);
        this.gPv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hm());
        this.gPv.setOnSwitchStateChangeListener(this.gPP);
    }

    public void bwU() {
        this.gPw.setOnSwitchStateChangeListener(null);
        this.gPw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ho());
        this.gPw.setOnSwitchStateChangeListener(this.gPP);
    }

    public void bwV() {
        this.gPx.setOnSwitchStateChangeListener(null);
        this.gPx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hw());
        this.gPx.setOnSwitchStateChangeListener(this.gPP);
    }

    public void mM(boolean z) {
        if (this.gPO != z) {
            this.gPO = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gPP.getString(e.j.msg_remind));
                this.gPI.setVisibility(0);
                this.gPJ.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gPP.getString(e.j.no_disturb_mode_time));
            this.gPJ.setVisibility(0);
            this.gPI.setVisibility(8);
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
        this.gPP.getLayoutMode().setNightMode(i == 1);
        this.gPP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gPP.getPageContext(), i);
        this.gPq.d(this.gPP.getPageContext(), i);
        this.gPs.d(this.gPP.getPageContext(), i);
        this.gPt.d(this.gPP.getPageContext(), i);
        this.gPu.d(this.gPP.getPageContext(), i);
        this.gPv.d(this.gPP.getPageContext(), i);
        this.gPw.d(this.gPP.getPageContext(), i);
        this.gPx.d(this.gPP.getPageContext(), i);
        this.gPy.d(this.gPP.getPageContext(), i);
        this.gPz.d(this.gPP.getPageContext(), i);
        this.gPA.d(this.gPP.getPageContext(), i);
        this.gPB.d(this.gPP.getPageContext(), i);
        this.gPC.d(this.gPP.getPageContext(), i);
        this.gPF.d(this.gPP.getPageContext(), i);
        al.i(this.gPG, e.f.more_all);
        al.i(this.gPK, e.f.more_all);
        al.i(this.gPM, e.f.more_all);
        al.i(this.gPD, e.f.more_all);
        al.c((ImageView) this.gPG.findViewById(e.g.no_disturb_mode_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gPD.findViewById(e.g.sign_remind_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gPK.findViewById(e.g.no_disturb_start_time_arrow), e.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.gPM.findViewById(e.g.no_disturb_end_time_arrow), e.f.icon_arrow_gray_right_n);
    }

    public void bwW() {
        com.baidu.tbadk.coreExtra.messageCenter.d.HB().b(this.gPP.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
