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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View asg;
    public boolean gkA;
    private MsgRemindActivity gkB;
    private TbSettingTextTipView gkC;
    private MsgSettingItemView gkc;
    private LinearLayout gkd;
    private MsgSettingItemView gke;
    private MsgSettingItemView gkf;
    private MsgSettingItemView gkg;
    private MsgSettingItemView gkh;
    private MsgSettingItemView gki;
    private MsgSettingItemView gkj;
    private MsgSettingItemView gkk;
    private MsgSettingItemView gkl;
    private MsgSettingItemView gkm;
    private MsgSettingItemView gkn;
    private MsgSettingItemView gko;
    private LinearLayout gkp;
    private TextView gkq;
    private MsgSettingItemView gkr;
    private LinearLayout gks;
    private TextView gkt;
    private LinearLayout gku;
    private LinearLayout gkv;
    private LinearLayout gkw;
    private TextView gkx;
    private LinearLayout gky;
    private TextView gkz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gkA = true;
        this.gkB = msgRemindActivity;
        msgRemindActivity.setContentView(d.i.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bmv();
        bmy();
        bmx();
        bmw();
        bmz();
        d(msgRemindActivity);
        bmp();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.k.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gku = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gkv = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gkc = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gkc.setText(d.k.receive_msg_text);
        this.gkc.setLineVisibility(false);
        this.gkd = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gke = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gke.setText(d.k.reply);
        this.gkf = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gkf.setVisibility(0);
        this.gkf.setText(d.k.action_praise_default);
        this.gkg = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gkg.setText(d.k.mention_atme);
        this.gkh = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gkh.setText(d.k.new_fans);
        this.gki = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gki.setText(d.k.chat_msg_text);
        this.gkj = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gkj.setLineVisibility(false);
        this.gkj.setText(d.k.group_chat_text);
        this.gkk = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gkk.setText(d.k.remind_screen_lock);
        this.gkk.setLineVisibility(false);
        this.gkl = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gkl.setText(d.k.remind_tone);
        this.gkm = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gkm.setText(d.k.remind_vibrate);
        this.gkn = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gkn.setLineVisibility(true);
        this.gkn.setText(d.k.remind_light);
        this.gko = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gko.setText(d.k.sign_remind_outline);
        this.gkp = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gkq = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gkr = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gkr.setText(d.k.no_disturb_mode);
        this.gkr.setLineVisibility(false);
        this.gks = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gkt = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gkw = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gkx = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gky = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gkz = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gkC = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bmp() {
        bmq();
        bmr();
        bms();
        bmt();
    }

    private void bmq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gkr.setVisibility(8);
            this.gks.setVisibility(8);
            this.gkc.setVisibility(8);
            this.gkd.setVisibility(8);
            this.gko.setVisibility(8);
            this.gkp.setVisibility(8);
            this.gkl.setVisibility(8);
            this.gkm.setVisibility(8);
            this.gkn.setVisibility(8);
            this.gkk.setVisibility(8);
        }
    }

    private void bmr() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gkk.setLineVisibility(true);
        } else {
            this.gkk.setLineVisibility(false);
        }
    }

    private void bms() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gki.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gkj.setVisibility(0);
        } else {
            this.gkj.setVisibility(8);
        }
    }

    private void bmt() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gkk.setVisibility(0);
        } else {
            this.gkk.setVisibility(8);
        }
    }

    public View bmu() {
        return this.asg;
    }

    private void bmv() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Af()) {
            this.gkc.jM();
            this.gkd.setVisibility(0);
        } else {
            this.gkc.jN();
            this.gkd.setVisibility(8);
        }
        this.gke.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ak());
        this.gkf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().At());
        this.gkg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ai());
        this.gkh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aj());
        this.gki.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Al());
        this.gkj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().As());
    }

    private void bmw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().isSignAlertOn()) {
            this.gko.jO();
            this.gkp.setVisibility(0);
            this.gko.setLineVisibility(true);
            bmA();
            return;
        }
        this.gko.jP();
        this.gko.setLineVisibility(false);
        this.gkp.setVisibility(8);
    }

    private void bmx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Am()) {
            this.gkl.jM();
        } else {
            this.gkl.jN();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ap()) {
            this.gkm.jM();
        } else {
            this.gkm.jN();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().An()) {
            this.gkn.jM();
        } else {
            this.gkn.jN();
        }
    }

    private void bmy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Au()) {
            this.gkk.jM();
        } else {
            this.gkk.jN();
        }
    }

    private void bmz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ao()) {
            this.gkr.jM();
            this.gks.setVisibility(0);
            bmB();
            return;
        }
        this.gkr.jN();
        this.gks.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.asg.setOnClickListener(msgRemindActivity);
        this.gkc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gke.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gki.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gko.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gkp.setOnClickListener(msgRemindActivity);
        this.gkr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gks.setOnClickListener(msgRemindActivity);
        this.gkw.setOnClickListener(msgRemindActivity);
        this.gky.setOnClickListener(msgRemindActivity);
        this.gkC.setOnClickListener(msgRemindActivity);
    }

    public void lS(boolean z) {
        this.gkr.setLineVisibility(z);
        if (z) {
            this.gks.setVisibility(0);
            bmB();
            ak.i(this.gks, d.f.more_all);
            return;
        }
        this.gks.setVisibility(8);
    }

    public void lT(boolean z) {
        if (z) {
            this.gkp.setVisibility(0);
            this.gko.setLineVisibility(true);
            ak.i(this.gkp, d.f.more_all);
            return;
        }
        this.gkp.setVisibility(8);
        this.gko.setLineVisibility(false);
    }

    public void lU(boolean z) {
        if (z) {
            this.gkd.setVisibility(0);
        } else {
            this.gkd.setVisibility(8);
        }
    }

    public void bmA() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Ad().getSignAlertMins();
            }
            this.gkq.setText(this.gkB.getPageContext().getPageActivity().getString(d.k.sign_remind_time, new Object[]{str, str2}));
            this.gkp.setVisibility(0);
            if (!this.gko.fz()) {
                this.gko.jM();
                return;
            }
            return;
        }
        this.gkq.setText(d.k.close);
        this.gkp.setVisibility(8);
        if (this.gko.fz()) {
            this.gko.jN();
        }
    }

    public void bmB() {
        this.gkt.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aq() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ar());
        this.gkx.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aq());
        this.gkz.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ar());
    }

    public BdSwitchView bmC() {
        return this.gko.getSwitchView();
    }

    public BdSwitchView bmD() {
        return this.gkc.getSwitchView();
    }

    public View bmE() {
        return this.gkp;
    }

    public BdSwitchView bmF() {
        return this.gkr.getSwitchView();
    }

    public View bmG() {
        return this.gks;
    }

    public LinearLayout bmH() {
        return this.gkw;
    }

    public LinearLayout bmI() {
        return this.gky;
    }

    public BdSwitchView bmJ() {
        return this.gkl.getSwitchView();
    }

    public BdSwitchView bmK() {
        return this.gkm.getSwitchView();
    }

    public BdSwitchView bmL() {
        return this.gkn.getSwitchView();
    }

    public BdSwitchView bmM() {
        return this.gkk.getSwitchView();
    }

    public BdSwitchView bmN() {
        return this.gke.getSwitchView();
    }

    public BdSwitchView bmO() {
        return this.gkf.getSwitchView();
    }

    public BdSwitchView bmP() {
        return this.gkg.getSwitchView();
    }

    public BdSwitchView bmQ() {
        return this.gki.getSwitchView();
    }

    public BdSwitchView bmR() {
        return this.gkj.getSwitchView();
    }

    public BdSwitchView bmS() {
        return this.gkh.getSwitchView();
    }

    public TbSettingTextTipView bmT() {
        return this.gkC;
    }

    public void bmU() {
        this.gke.setOnSwitchStateChangeListener(null);
        this.gke.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ak());
        this.gke.setOnSwitchStateChangeListener(this.gkB);
    }

    public void bmV() {
        this.gkf.setOnSwitchStateChangeListener(null);
        this.gkf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().At());
        this.gkf.setOnSwitchStateChangeListener(this.gkB);
    }

    public void bmW() {
        this.gkg.setOnSwitchStateChangeListener(null);
        this.gkg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ai());
        this.gkg.setOnSwitchStateChangeListener(this.gkB);
    }

    public void bmX() {
        this.gkh.setOnSwitchStateChangeListener(null);
        this.gkh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Aj());
        this.gkh.setOnSwitchStateChangeListener(this.gkB);
    }

    public void bmY() {
        this.gki.setOnSwitchStateChangeListener(null);
        this.gki.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Al());
        this.gki.setOnSwitchStateChangeListener(this.gkB);
    }

    public void bmZ() {
        this.gkj.setOnSwitchStateChangeListener(null);
        this.gkj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ad().As());
        this.gkj.setOnSwitchStateChangeListener(this.gkB);
    }

    public void lV(boolean z) {
        if (this.gkA != z) {
            this.gkA = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gkB.getPageContext().getString(d.k.msg_remind));
                this.gku.setVisibility(0);
                this.gkv.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gkB.getPageContext().getString(d.k.no_disturb_mode_time));
            this.gkv.setVisibility(0);
            this.gku.setVisibility(8);
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
        this.gkB.getLayoutMode().setNightMode(i == 1);
        this.gkB.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gkB.getPageContext(), i);
        this.gkc.d(this.gkB.getPageContext(), i);
        this.gke.d(this.gkB.getPageContext(), i);
        this.gkf.d(this.gkB.getPageContext(), i);
        this.gkg.d(this.gkB.getPageContext(), i);
        this.gkh.d(this.gkB.getPageContext(), i);
        this.gki.d(this.gkB.getPageContext(), i);
        this.gkj.d(this.gkB.getPageContext(), i);
        this.gkk.d(this.gkB.getPageContext(), i);
        this.gkl.d(this.gkB.getPageContext(), i);
        this.gkm.d(this.gkB.getPageContext(), i);
        this.gkn.d(this.gkB.getPageContext(), i);
        this.gko.d(this.gkB.getPageContext(), i);
        this.gkr.d(this.gkB.getPageContext(), i);
        ak.i(this.gks, d.f.more_all);
        ak.i(this.gkw, d.f.more_all);
        ak.i(this.gky, d.f.more_all);
        ak.i(this.gkp, d.f.more_all);
        ak.c((ImageView) this.gks.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gkp.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gkw.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gky.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
