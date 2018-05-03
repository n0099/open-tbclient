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
    private MsgSettingItemView giW;
    private LinearLayout giX;
    private MsgSettingItemView giY;
    private MsgSettingItemView giZ;
    private MsgSettingItemView gja;
    private MsgSettingItemView gjb;
    private MsgSettingItemView gjc;
    private MsgSettingItemView gjd;
    private MsgSettingItemView gje;
    private MsgSettingItemView gjf;
    private MsgSettingItemView gjg;
    private MsgSettingItemView gjh;
    private MsgSettingItemView gji;
    private LinearLayout gjj;
    private TextView gjk;
    private MsgSettingItemView gjl;
    private LinearLayout gjm;
    private TextView gjn;
    private LinearLayout gjo;
    private LinearLayout gjp;
    private LinearLayout gjq;
    private TextView gjr;
    private LinearLayout gjs;
    private TextView gjt;
    public boolean gju;
    private MsgRemindActivity gjv;
    private TbSettingTextTipView gjw;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gju = true;
        this.gjv = msgRemindActivity;
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
        this.gjo = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gjp = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.giW = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.giW.setText(d.k.receive_msg_text);
        this.giW.setLineVisibility(false);
        this.giX = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.giY = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.giY.setText(d.k.reply);
        this.giZ = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.giZ.setVisibility(0);
        this.giZ.setText(d.k.action_praise_default);
        this.gja = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gja.setText(d.k.mention_atme);
        this.gjb = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gjb.setText(d.k.new_fans);
        this.gjc = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gjc.setText(d.k.chat_msg_text);
        this.gjd = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gjd.setLineVisibility(false);
        this.gjd.setText(d.k.group_chat_text);
        this.gje = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gje.setText(d.k.remind_screen_lock);
        this.gje.setLineVisibility(false);
        this.gjf = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gjf.setText(d.k.remind_tone);
        this.gjg = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gjg.setText(d.k.remind_vibrate);
        this.gjh = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gjh.setLineVisibility(true);
        this.gjh.setText(d.k.remind_light);
        this.gji = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gji.setText(d.k.sign_remind_outline);
        this.gjj = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gjk = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gjl = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gjl.setText(d.k.no_disturb_mode);
        this.gjl.setLineVisibility(false);
        this.gjm = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gjn = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gjq = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gjr = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gjs = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gjt = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gjw = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
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
            this.gjl.setVisibility(8);
            this.gjm.setVisibility(8);
            this.giW.setVisibility(8);
            this.giX.setVisibility(8);
            this.gji.setVisibility(8);
            this.gjj.setVisibility(8);
            this.gjf.setVisibility(8);
            this.gjg.setVisibility(8);
            this.gjh.setVisibility(8);
            this.gje.setVisibility(8);
        }
    }

    private void bms() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gje.setLineVisibility(true);
        } else {
            this.gje.setLineVisibility(false);
        }
    }

    private void bmt() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gjc.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gjd.setVisibility(0);
        } else {
            this.gjd.setVisibility(8);
        }
    }

    private void bmu() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gje.setVisibility(0);
        } else {
            this.gje.setVisibility(8);
        }
    }

    public View bmv() {
        return this.asg;
    }

    private void bmw() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ag()) {
            this.giW.jM();
            this.giX.setVisibility(0);
        } else {
            this.giW.jN();
            this.giX.setVisibility(8);
        }
        this.giY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Al());
        this.giZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Au());
        this.gja.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aj());
        this.gjb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ak());
        this.gjc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Am());
        this.gjd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().At());
    }

    private void bmx() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().isSignAlertOn()) {
            this.gji.jO();
            this.gjj.setVisibility(0);
            this.gji.setLineVisibility(true);
            bmB();
            return;
        }
        this.gji.jP();
        this.gji.setLineVisibility(false);
        this.gjj.setVisibility(8);
    }

    private void bmy() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().An()) {
            this.gjf.jM();
        } else {
            this.gjf.jN();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aq()) {
            this.gjg.jM();
        } else {
            this.gjg.jN();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ao()) {
            this.gjh.jM();
        } else {
            this.gjh.jN();
        }
    }

    private void bmz() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Av()) {
            this.gje.jM();
        } else {
            this.gje.jN();
        }
    }

    private void bmA() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ap()) {
            this.gjl.jM();
            this.gjm.setVisibility(0);
            bmC();
            return;
        }
        this.gjl.jN();
        this.gjm.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.asg.setOnClickListener(msgRemindActivity);
        this.giW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.giY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gja.setOnSwitchStateChangeListener(msgRemindActivity);
        this.giZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gje.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gji.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjj.setOnClickListener(msgRemindActivity);
        this.gjl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gjm.setOnClickListener(msgRemindActivity);
        this.gjq.setOnClickListener(msgRemindActivity);
        this.gjs.setOnClickListener(msgRemindActivity);
        this.gjw.setOnClickListener(msgRemindActivity);
    }

    public void lR(boolean z) {
        this.gjl.setLineVisibility(z);
        if (z) {
            this.gjm.setVisibility(0);
            bmC();
            ak.i(this.gjm, d.f.more_all);
            return;
        }
        this.gjm.setVisibility(8);
    }

    public void lS(boolean z) {
        if (z) {
            this.gjj.setVisibility(0);
            this.gji.setLineVisibility(true);
            ak.i(this.gjj, d.f.more_all);
            return;
        }
        this.gjj.setVisibility(8);
        this.gji.setLineVisibility(false);
    }

    public void lT(boolean z) {
        if (z) {
            this.giX.setVisibility(0);
        } else {
            this.giX.setVisibility(8);
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
            this.gjk.setText(this.gjv.getPageContext().getPageActivity().getString(d.k.sign_remind_time, new Object[]{str, str2}));
            this.gjj.setVisibility(0);
            if (!this.gji.fz()) {
                this.gji.jM();
                return;
            }
            return;
        }
        this.gjk.setText(d.k.close);
        this.gjj.setVisibility(8);
        if (this.gji.fz()) {
            this.gji.jN();
        }
    }

    public void bmC() {
        this.gjn.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ar() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.Ae().As());
        this.gjr.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ar());
        this.gjt.setText(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().As());
    }

    public BdSwitchView bmD() {
        return this.gji.getSwitchView();
    }

    public BdSwitchView bmE() {
        return this.giW.getSwitchView();
    }

    public View bmF() {
        return this.gjj;
    }

    public BdSwitchView bmG() {
        return this.gjl.getSwitchView();
    }

    public View bmH() {
        return this.gjm;
    }

    public LinearLayout bmI() {
        return this.gjq;
    }

    public LinearLayout bmJ() {
        return this.gjs;
    }

    public BdSwitchView bmK() {
        return this.gjf.getSwitchView();
    }

    public BdSwitchView bmL() {
        return this.gjg.getSwitchView();
    }

    public BdSwitchView bmM() {
        return this.gjh.getSwitchView();
    }

    public BdSwitchView bmN() {
        return this.gje.getSwitchView();
    }

    public BdSwitchView bmO() {
        return this.giY.getSwitchView();
    }

    public BdSwitchView bmP() {
        return this.giZ.getSwitchView();
    }

    public BdSwitchView bmQ() {
        return this.gja.getSwitchView();
    }

    public BdSwitchView bmR() {
        return this.gjc.getSwitchView();
    }

    public BdSwitchView bmS() {
        return this.gjd.getSwitchView();
    }

    public BdSwitchView bmT() {
        return this.gjb.getSwitchView();
    }

    public TbSettingTextTipView bmU() {
        return this.gjw;
    }

    public void bmV() {
        this.giY.setOnSwitchStateChangeListener(null);
        this.giY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Al());
        this.giY.setOnSwitchStateChangeListener(this.gjv);
    }

    public void bmW() {
        this.giZ.setOnSwitchStateChangeListener(null);
        this.giZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Au());
        this.giZ.setOnSwitchStateChangeListener(this.gjv);
    }

    public void bmX() {
        this.gja.setOnSwitchStateChangeListener(null);
        this.gja.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aj());
        this.gja.setOnSwitchStateChangeListener(this.gjv);
    }

    public void bmY() {
        this.gjb.setOnSwitchStateChangeListener(null);
        this.gjb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ak());
        this.gjb.setOnSwitchStateChangeListener(this.gjv);
    }

    public void bmZ() {
        this.gjc.setOnSwitchStateChangeListener(null);
        this.gjc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Am());
        this.gjc.setOnSwitchStateChangeListener(this.gjv);
    }

    public void bna() {
        this.gjd.setOnSwitchStateChangeListener(null);
        this.gjd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.Ae().At());
        this.gjd.setOnSwitchStateChangeListener(this.gjv);
    }

    public void lU(boolean z) {
        if (this.gju != z) {
            this.gju = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gjv.getPageContext().getString(d.k.msg_remind));
                this.gjo.setVisibility(0);
                this.gjp.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gjv.getPageContext().getString(d.k.no_disturb_mode_time));
            this.gjp.setVisibility(0);
            this.gjo.setVisibility(8);
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
        this.gjv.getLayoutMode().setNightMode(i == 1);
        this.gjv.getLayoutMode().u(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gjv.getPageContext(), i);
        this.giW.d(this.gjv.getPageContext(), i);
        this.giY.d(this.gjv.getPageContext(), i);
        this.giZ.d(this.gjv.getPageContext(), i);
        this.gja.d(this.gjv.getPageContext(), i);
        this.gjb.d(this.gjv.getPageContext(), i);
        this.gjc.d(this.gjv.getPageContext(), i);
        this.gjd.d(this.gjv.getPageContext(), i);
        this.gje.d(this.gjv.getPageContext(), i);
        this.gjf.d(this.gjv.getPageContext(), i);
        this.gjg.d(this.gjv.getPageContext(), i);
        this.gjh.d(this.gjv.getPageContext(), i);
        this.gji.d(this.gjv.getPageContext(), i);
        this.gjl.d(this.gjv.getPageContext(), i);
        ak.i(this.gjm, d.f.more_all);
        ak.i(this.gjq, d.f.more_all);
        ak.i(this.gjs, d.f.more_all);
        ak.i(this.gjj, d.f.more_all);
        ak.c((ImageView) this.gjm.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gjj.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gjq.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        ak.c((ImageView) this.gjs.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
