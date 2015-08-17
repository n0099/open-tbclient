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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.f<MsgRemindActivity> {
    private TextView LM;
    private RelativeLayout bnG;
    private TextView cyA;
    public boolean cyB;
    private MsgRemindActivity cyC;
    private MsgSettingItemView cyb;
    private LinearLayout cyc;
    private MsgSettingItemView2 cyd;
    private MsgSettingItemView2 cye;
    private MsgSettingItemView2 cyf;
    private MsgSettingItemView2 cyg;
    private MsgSettingItemView2 cyh;
    private MsgSettingItemView2 cyi;
    private MsgSettingItemView cyj;
    private MsgSettingItemView cyk;
    private MsgSettingItemView cyl;
    private MsgSettingItemView cym;
    private MsgSettingItemView cyn;
    private MsgSettingItemView cyo;
    private LinearLayout cyp;
    private TextView cyq;
    private MsgSettingItemView cyr;
    private MsgSettingItemView cys;
    private LinearLayout cyt;
    private TextView cyu;
    private LinearLayout cyv;
    private LinearLayout cyw;
    private LinearLayout cyx;
    private TextView cyy;
    private LinearLayout cyz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public ae(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.bnG = null;
        this.mNavigationBar = null;
        this.LM = null;
        this.cyB = true;
        this.cyC = msgRemindActivity;
        msgRemindActivity.setContentView(i.g.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        alJ();
        alO();
        alN();
        alM();
        alL();
        alK();
        alP();
        d(msgRemindActivity);
        alE();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.bnG = (RelativeLayout) msgRemindActivity.findViewById(i.f.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cyv = (LinearLayout) msgRemindActivity.findViewById(i.f.front_container);
        this.cyw = (LinearLayout) msgRemindActivity.findViewById(i.f.back_container);
        this.LM = this.mNavigationBar.setTitleText(msgRemindActivity.getPageContext().getString(i.C0057i.msg_remind));
        this.cyb = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.receive_message_swtich);
        this.cyb.setText(i.C0057i.receive_msg_text);
        this.cyb.setLineVisibility(true);
        this.cyc = (LinearLayout) msgRemindActivity.findViewById(i.f.receive_message_container);
        this.cyd = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.reply_check_box);
        this.cyd.setText(i.C0057i.frs_item_reply_text);
        this.cye = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.zan_check_box);
        this.cye.setText(i.C0057i.frs_item_praise_text);
        this.cyf = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.at_me_check_box);
        this.cyf.setText(i.C0057i.mention_atme);
        this.cyg = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.new_fans_swtich);
        this.cyg.setText(i.C0057i.new_fans);
        this.cyh = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.chat_msg_swtich);
        this.cyh.setText(i.C0057i.chat_msg_text);
        this.cyi = (MsgSettingItemView2) msgRemindActivity.findViewById(i.f.group_chat_swtich);
        this.cyi.setLineVisibility(false);
        this.cyi.setText(i.C0057i.group_chat_text);
        this.cyj = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.screen_lock_swtich);
        this.cyj.setText(i.C0057i.remind_screen_lock);
        this.cyk = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.chat_float_swtich);
        this.cyk.setLineVisibility(false);
        this.cyk.setText(i.C0057i.chat_float_window);
        this.cyl = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.tone_remind_swtich);
        this.cyl.setText(i.C0057i.remind_tone);
        this.cym = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.vibrate_remind_swtich);
        this.cym.setText(i.C0057i.remind_vibrate);
        this.cyn = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.light_remind_swtich);
        this.cyn.setLineVisibility(true);
        this.cyn.setText(i.C0057i.remind_light);
        this.cyo = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.sign_remind_swtich);
        this.cyo.setText(i.C0057i.sign_remind_outline);
        this.cyp = (LinearLayout) msgRemindActivity.findViewById(i.f.sign_remind);
        this.cyq = (TextView) msgRemindActivity.findViewById(i.f.sign_remind_time);
        this.cyr = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.promoted_content_swtich);
        this.cyr.setLineVisibility(false);
        this.cyr.setText(i.C0057i.promoted_message_text);
        this.cys = (MsgSettingItemView) msgRemindActivity.findViewById(i.f.no_disturb_swtich);
        this.cys.setText(i.C0057i.no_disturb_mode);
        this.cyt = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_container);
        this.cyu = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_mode_time_value);
        this.cyx = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_start_time);
        this.cyy = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_start_time_value);
        this.cyz = (LinearLayout) msgRemindActivity.findViewById(i.f.no_disturb_end_time);
        this.cyA = (TextView) msgRemindActivity.findViewById(i.f.no_disturb_end_time_value);
    }

    private void alE() {
        alF();
        alG();
        alH();
        alI();
    }

    private void alF() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.cys.setVisibility(8);
            this.cyt.setVisibility(8);
            this.cyb.setVisibility(8);
            this.cyc.setVisibility(8);
            this.cyo.setVisibility(8);
            this.cyp.setVisibility(8);
            this.cyl.setVisibility(8);
            this.cym.setVisibility(8);
            this.cyn.setVisibility(8);
            this.cyj.setVisibility(8);
            this.cyk.setVisibility(8);
        }
    }

    private void alG() {
        boolean isMIUIRom = TbadkCoreApplication.m411getInst().isMIUIRom();
        if (TbadkCoreApplication.m411getInst().isFloatingWindowOpened() && !isMIUIRom) {
            this.cyk.setVisibility(0);
            this.cyj.setLineVisibility(true);
            return;
        }
        this.cyk.setVisibility(8);
        this.cyj.setLineVisibility(false);
    }

    private void alH() {
        boolean appResponseToIntentClass = TbadkCoreApplication.m411getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.cyh.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.cyi.setVisibility(0);
        } else {
            this.cyi.setVisibility(8);
        }
    }

    private void alI() {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.cyj.setVisibility(0);
        } else {
            this.cyj.setVisibility(8);
        }
    }

    public View ahK() {
        return this.mBack;
    }

    private void alJ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xs()) {
            this.cyb.mB();
            this.cyc.setVisibility(0);
        } else {
            this.cyb.mC();
            this.cyc.setVisibility(8);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xx()) {
            this.cyd.getSwitchView().setChecked(true);
        } else {
            this.cyd.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xG()) {
            this.cye.getSwitchView().setChecked(true);
        } else {
            this.cye.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv()) {
            this.cyf.getSwitchView().setChecked(true);
        } else {
            this.cyf.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xw()) {
            this.cyg.getSwitchView().setChecked(true);
        } else {
            this.cyg.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy()) {
            this.cyh.getSwitchView().setChecked(true);
        } else {
            this.cyh.getSwitchView().setChecked(false);
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xF()) {
            this.cyi.getSwitchView().setChecked(true);
        } else {
            this.cyi.getSwitchView().setChecked(false);
        }
    }

    private void alK() {
        if (TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
            this.cyr.mB();
        } else {
            this.cyr.mC();
        }
    }

    private void alL() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().isSignAlertOn()) {
            this.cyo.mD();
            this.cyp.setVisibility(0);
            this.cyo.setLineVisibility(true);
            alQ();
            return;
        }
        this.cyo.mE();
        this.cyo.setLineVisibility(false);
        this.cyp.setVisibility(8);
    }

    private void alM() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xz()) {
            this.cyl.mB();
        } else {
            this.cyl.mC();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xC()) {
            this.cym.mB();
        } else {
            this.cym.mC();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xA()) {
            this.cyn.mB();
        } else {
            this.cyn.mC();
        }
    }

    private void alN() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xH()) {
            this.cyk.mB();
        } else {
            this.cyk.mC();
        }
    }

    private void alO() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xI()) {
            this.cyj.mB();
        } else {
            this.cyj.mC();
        }
    }

    private void alP() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xB()) {
            this.cys.mB();
            this.cyt.setVisibility(0);
            alR();
            return;
        }
        this.cys.mC();
        this.cyt.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.cyb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyd.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cyf.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cye.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cyg.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cyh.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cyi.getSwitchView().setOnCheckedChangeListener(msgRemindActivity);
        this.cyj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cym.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyp.setOnClickListener(msgRemindActivity);
        this.cyr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cys.setOnSwitchStateChangeListener(msgRemindActivity);
        this.cyt.setOnClickListener(msgRemindActivity);
        this.cyx.setOnClickListener(msgRemindActivity);
        this.cyz.setOnClickListener(msgRemindActivity);
    }

    public void fd(boolean z) {
        this.cys.setLineVisibility(z);
        if (z) {
            this.cyt.setVisibility(0);
            alR();
            com.baidu.tbadk.core.util.al.i(this.cyt, i.e.more_all);
            return;
        }
        this.cyt.setVisibility(8);
    }

    public void fe(boolean z) {
        if (z) {
            this.cyp.setVisibility(0);
            this.cyo.setLineVisibility(true);
            com.baidu.tbadk.core.util.al.i(this.cyp, i.e.more_all);
            return;
        }
        this.cyp.setVisibility(8);
        this.cyo.setLineVisibility(false);
    }

    public void ff(boolean z) {
        if (z) {
            this.cyc.setVisibility(0);
        } else {
            this.cyc.setVisibility(8);
        }
    }

    public void alQ() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.xq().getSignAlertMins();
            }
            this.cyq.setText(this.cyC.getPageContext().getPageActivity().getString(i.C0057i.sign_remind_time, new Object[]{str, str2}));
            this.cyp.setVisibility(0);
            if (!this.cyo.hz()) {
                this.cyo.mB();
                return;
            }
            return;
        }
        this.cyq.setText(i.C0057i.close);
        this.cyp.setVisibility(8);
        if (this.cyo.hz()) {
            this.cyo.mC();
        }
    }

    public void alR() {
        this.cyu.setText(String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xD()) + "-" + com.baidu.tbadk.coreExtra.messageCenter.c.xq().xE());
        this.cyy.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xD());
        this.cyA.setText(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xE());
    }

    public BdSwitchView alS() {
        return this.cyr.getSwitchView();
    }

    public BdSwitchView alT() {
        return this.cyo.getSwitchView();
    }

    public BdSwitchView alU() {
        return this.cyb.getSwitchView();
    }

    public View alV() {
        return this.cyp;
    }

    public BdSwitchView alW() {
        return this.cys.getSwitchView();
    }

    public View alX() {
        return this.cyt;
    }

    public LinearLayout alY() {
        return this.cyx;
    }

    public LinearLayout alZ() {
        return this.cyz;
    }

    public BdSwitchView ama() {
        return this.cyl.getSwitchView();
    }

    public BdSwitchView amb() {
        return this.cym.getSwitchView();
    }

    public BdSwitchView amc() {
        return this.cyn.getSwitchView();
    }

    public BdSwitchView amd() {
        return this.cyj.getSwitchView();
    }

    public BdSwitchView ame() {
        return this.cyk.getSwitchView();
    }

    public CheckBox amf() {
        return this.cyd.getSwitchView();
    }

    public CheckBox amg() {
        return this.cye.getSwitchView();
    }

    public CheckBox amh() {
        return this.cyf.getSwitchView();
    }

    public CheckBox ami() {
        return this.cyh.getSwitchView();
    }

    public CheckBox amj() {
        return this.cyi.getSwitchView();
    }

    public CheckBox amk() {
        return this.cyg.getSwitchView();
    }

    public void aml() {
        this.cyd.getSwitchView().setOnCheckedChangeListener(null);
        this.cyd.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xx());
        this.cyd.getSwitchView().setOnCheckedChangeListener(this.cyC);
    }

    public void amm() {
        this.cye.getSwitchView().setOnCheckedChangeListener(null);
        this.cye.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xG());
        this.cye.getSwitchView().setOnCheckedChangeListener(this.cyC);
    }

    public void amn() {
        this.cyf.getSwitchView().setOnCheckedChangeListener(null);
        this.cyf.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv());
        this.cyf.getSwitchView().setOnCheckedChangeListener(this.cyC);
    }

    public void amo() {
        this.cyg.getSwitchView().setOnCheckedChangeListener(null);
        this.cyg.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xw());
        this.cyg.getSwitchView().setOnCheckedChangeListener(this.cyC);
    }

    public void amp() {
        this.cyh.getSwitchView().setOnCheckedChangeListener(null);
        this.cyh.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xy());
        this.cyh.getSwitchView().setOnCheckedChangeListener(this.cyC);
    }

    public void amq() {
        this.cyi.getSwitchView().setOnCheckedChangeListener(null);
        this.cyi.getSwitchView().setChecked(com.baidu.tbadk.coreExtra.messageCenter.c.xq().xF());
        this.cyi.getSwitchView().setOnCheckedChangeListener(this.cyC);
    }

    public void fg(boolean z) {
        if (this.cyB != z) {
            this.cyB = z;
            if (z) {
                this.LM.setText(i.C0057i.msg_remind);
                this.cyv.setVisibility(0);
                this.cyw.setVisibility(8);
                return;
            }
            this.LM.setText(i.C0057i.no_disturb_mode_time);
            this.cyw.setVisibility(0);
            this.cyv.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.cyC.getLayoutMode().ad(i == 1);
        this.cyC.getLayoutMode().k(this.bnG);
        this.mNavigationBar.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyb.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyd.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cye.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyf.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyg.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyh.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyi.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyj.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyk.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyl.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cym.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyn.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyo.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cyr.onChangeSkinType(this.cyC.getPageContext(), i);
        this.cys.onChangeSkinType(this.cyC.getPageContext(), i);
        com.baidu.tbadk.core.util.al.i(this.cyt, i.e.more_all);
        com.baidu.tbadk.core.util.al.i(this.cyx, i.e.more_all);
        com.baidu.tbadk.core.util.al.i(this.cyz, i.e.more_all);
        com.baidu.tbadk.core.util.al.i(this.cyp, i.e.more_all);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cyt.findViewById(i.f.no_disturb_mode_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cyp.findViewById(i.f.sign_remind_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cyx.findViewById(i.f.no_disturb_start_time_arrow), i.e.icon_arrow_right);
        com.baidu.tbadk.core.util.al.c((ImageView) this.cyz.findViewById(i.f.no_disturb_end_time_arrow), i.e.icon_arrow_right);
    }
}
