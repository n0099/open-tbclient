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
    private MsgSettingItemView giZ;
    private LinearLayout gja;
    private MsgSettingItemView gjb;
    private MsgSettingItemView gjc;
    private MsgSettingItemView gjd;
    private MsgSettingItemView gje;
    private MsgSettingItemView gjf;
    private MsgSettingItemView gjg;
    private MsgSettingItemView gjh;
    private MsgSettingItemView gji;
    private MsgSettingItemView gjj;
    private MsgSettingItemView gjk;
    private MsgSettingItemView gjl;
    private LinearLayout gjm;
    private TextView gjn;
    private MsgSettingItemView gjo;
    private LinearLayout gjp;
    private TextView gjq;
    private LinearLayout gjr;
    private LinearLayout gjs;
    private LinearLayout gjt;
    private TextView gju;
    private LinearLayout gjv;
    private TextView gjw;
    public boolean gjx;
    private MsgRemindActivity gjy;
    private TbSettingTextTipView gjz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gjx = true;
        this.gjy = msgRemindActivity;
        msgRemindActivity.setContentView(d.i.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bmw();
        bmz();
        bmy();
        bmx();
        bmA();
        d(msgRemindActivity);
        bmq();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.k.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjr = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gjs = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.giZ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.giZ.setText(d.k.receive_msg_text);
        this.giZ.setLineVisibility(false);
        this.gja = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gjb = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gjb.setText(d.k.reply);
        this.gjc = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gjc.setVisibility(0);
        this.gjc.setText(d.k.action_praise_default);
        this.gjd = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gjd.setText(d.k.mention_atme);
        this.gje = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gje.setText(d.k.new_fans);
        this.gjf = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gjf.setText(d.k.chat_msg_text);
        this.gjg = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gjg.setLineVisibility(false);
        this.gjg.setText(d.k.group_chat_text);
        this.gjh = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gjh.setText(d.k.remind_screen_lock);
        this.gjh.setLineVisibility(false);
        this.gji = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gji.setText(d.k.remind_tone);
        this.gjj = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gjj.setText(d.k.remind_vibrate);
        this.gjk = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gjk.setLineVisibility(true);
        this.gjk.setText(d.k.remind_light);
        this.gjl = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gjl.setText(d.k.sign_remind_outline);
        this.gjm = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gjn = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gjo = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gjo.setText(d.k.no_disturb_mode);
        this.gjo.setLineVisibility(false);
        this.gjp = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gjq = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gjt = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gju = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gjv = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gjw = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gjz = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bmq() {
        bmr();
        bms();
        bmt();
        bmu();
    }

    private void bmr() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gjo.setVisibility(8);
            this.gjp.setVisibility(8);
            this.giZ.setVisibility(8);
            this.gja.setVisibility(8);
            this.gjl.setVisibility(8);
            this.gjm.setVisibility(8);
            this.gji.setVisibility(8);
            this.gjj.setVisibility(8);
            this.gjk.setVisibility(8);
            this.gjh.setVisibility(8);
        }
    }

    private void bms() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gjh.setLineVisibility(true);
        } else {
            this.gjh.setLineVisibility(false);
        }
    }

    private void bmt() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gjf.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gjg.setVisibility(0);
        } else {
            this.gjg.setVisibility(8);
        }
    }

    private void bmu() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gjh.setVisibility(0);
        } else {
            this.gjh.setVisibility(8);
        }
    }

    public View bmv() {
        return this.asg;
    }

    private void bmw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ag()) {
            this.giZ.jM();
            this.gja.setVisibility(0);
        } else {
            this.giZ.jN();
            this.gja.setVisibility(8);
        }
        this.gjb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Al());
        this.gjc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Au());
        this.gjd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aj());
        this.gje.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ak());
        this.gjf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Am());
        this.gjg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().At());
    }

    private void bmx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().isSignAlertOn()) {
            this.gjl.jO();
            this.gjm.setVisibility(0);
            this.gjl.setLineVisibility(true);
            bmB();
            return;
        }
        this.gjl.jP();
        this.gjl.setLineVisibility(false);
        this.gjm.setVisibility(8);
    }

    private void bmy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().An()) {
            this.gji.jM();
        } else {
            this.gji.jN();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aq()) {
            this.gjj.jM();
        } else {
            this.gjj.jN();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ao()) {
            this.gjk.jM();
        } else {
            this.gjk.jN();
        }
    }

    private void bmz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Av()) {
            this.gjh.jM();
        } else {
            this.gjh.jN();
        }
    }

    private void bmA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ap()) {
            this.gjo.jM();
            this.gjp.setVisibility(0);
            bmC();
            return;
        }
        this.gjo.jN();
        this.gjp.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.asg.setOnClickListener(msgRemindActivity);
        this.giZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gje.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gji.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjm.setOnClickListener(msgRemindActivity);
        this.gjo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjp.setOnClickListener(msgRemindActivity);
        this.gjt.setOnClickListener(msgRemindActivity);
        this.gjv.setOnClickListener(msgRemindActivity);
        this.gjz.setOnClickListener(msgRemindActivity);
    }

    public void lR(boolean z) {
        this.gjo.setLineVisibility(z);
        if (z) {
            this.gjp.setVisibility(0);
            bmC();
            ak.i(this.gjp, d.f.more_all);
            return;
        }
        this.gjp.setVisibility(8);
    }

    public void lS(boolean z) {
        if (z) {
            this.gjm.setVisibility(0);
            this.gjl.setLineVisibility(true);
            ak.i(this.gjm, d.f.more_all);
            return;
        }
        this.gjm.setVisibility(8);
        this.gjl.setLineVisibility(false);
    }

    public void lT(boolean z) {
        if (z) {
            this.gja.setVisibility(0);
        } else {
            this.gja.setVisibility(8);
        }
    }

    public void bmB() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.Ae().getSignAlertMins();
            }
            this.gjn.setText(this.gjy.getPageContext().getPageActivity().getString(d.k.sign_remind_time, new Object[]{str, str2}));
            this.gjm.setVisibility(0);
            if (!this.gjl.fz()) {
                this.gjl.jM();
                return;
            }
            return;
        }
        this.gjn.setText(d.k.close);
        this.gjm.setVisibility(8);
        if (this.gjl.fz()) {
            this.gjl.jN();
        }
    }

    public void bmC() {
        this.gjq.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ar() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.Ae().As());
        this.gju.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ar());
        this.gjw.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().As());
    }

    public BdSwitchView bmD() {
        return this.gjl.getSwitchView();
    }

    public BdSwitchView bmE() {
        return this.giZ.getSwitchView();
    }

    public View bmF() {
        return this.gjm;
    }

    public BdSwitchView bmG() {
        return this.gjo.getSwitchView();
    }

    public View bmH() {
        return this.gjp;
    }

    public LinearLayout bmI() {
        return this.gjt;
    }

    public LinearLayout bmJ() {
        return this.gjv;
    }

    public BdSwitchView bmK() {
        return this.gji.getSwitchView();
    }

    public BdSwitchView bmL() {
        return this.gjj.getSwitchView();
    }

    public BdSwitchView bmM() {
        return this.gjk.getSwitchView();
    }

    public BdSwitchView bmN() {
        return this.gjh.getSwitchView();
    }

    public BdSwitchView bmO() {
        return this.gjb.getSwitchView();
    }

    public BdSwitchView bmP() {
        return this.gjc.getSwitchView();
    }

    public BdSwitchView bmQ() {
        return this.gjd.getSwitchView();
    }

    public BdSwitchView bmR() {
        return this.gjf.getSwitchView();
    }

    public BdSwitchView bmS() {
        return this.gjg.getSwitchView();
    }

    public BdSwitchView bmT() {
        return this.gje.getSwitchView();
    }

    public TbSettingTextTipView bmU() {
        return this.gjz;
    }

    public void bmV() {
        this.gjb.setOnSwitchStateChangeListener(null);
        this.gjb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Al());
        this.gjb.setOnSwitchStateChangeListener(this.gjy);
    }

    public void bmW() {
        this.gjc.setOnSwitchStateChangeListener(null);
        this.gjc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Au());
        this.gjc.setOnSwitchStateChangeListener(this.gjy);
    }

    public void bmX() {
        this.gjd.setOnSwitchStateChangeListener(null);
        this.gjd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aj());
        this.gjd.setOnSwitchStateChangeListener(this.gjy);
    }

    public void bmY() {
        this.gje.setOnSwitchStateChangeListener(null);
        this.gje.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ak());
        this.gje.setOnSwitchStateChangeListener(this.gjy);
    }

    public void bmZ() {
        this.gjf.setOnSwitchStateChangeListener(null);
        this.gjf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Am());
        this.gjf.setOnSwitchStateChangeListener(this.gjy);
    }

    public void bna() {
        this.gjg.setOnSwitchStateChangeListener(null);
        this.gjg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().At());
        this.gjg.setOnSwitchStateChangeListener(this.gjy);
    }

    public void lU(boolean z) {
        if (this.gjx != z) {
            this.gjx = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gjy.getPageContext().getString(d.k.msg_remind));
                this.gjr.setVisibility(0);
                this.gjs.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gjy.getPageContext().getString(d.k.no_disturb_mode_time));
            this.gjs.setVisibility(0);
            this.gjr.setVisibility(8);
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
        this.gjy.getLayoutMode().setNightMode(i == 1);
        this.gjy.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gjy.getPageContext(), i);
        this.giZ.d(this.gjy.getPageContext(), i);
        this.gjb.d(this.gjy.getPageContext(), i);
        this.gjc.d(this.gjy.getPageContext(), i);
        this.gjd.d(this.gjy.getPageContext(), i);
        this.gje.d(this.gjy.getPageContext(), i);
        this.gjf.d(this.gjy.getPageContext(), i);
        this.gjg.d(this.gjy.getPageContext(), i);
        this.gjh.d(this.gjy.getPageContext(), i);
        this.gji.d(this.gjy.getPageContext(), i);
        this.gjj.d(this.gjy.getPageContext(), i);
        this.gjk.d(this.gjy.getPageContext(), i);
        this.gjl.d(this.gjy.getPageContext(), i);
        this.gjo.d(this.gjy.getPageContext(), i);
        ak.i(this.gjp, d.f.more_all);
        ak.i(this.gjt, d.f.more_all);
        ak.i(this.gjv, d.f.more_all);
        ak.i(this.gjm, d.f.more_all);
        ak.c((ImageView) this.gjp.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gjm.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gjt.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gjv.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
