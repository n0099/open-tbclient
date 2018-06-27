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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View aBf;
    private MsgSettingItemView gzA;
    private MsgSettingItemView gzB;
    private MsgSettingItemView gzC;
    private MsgSettingItemView gzD;
    private MsgSettingItemView gzE;
    private LinearLayout gzF;
    private TextView gzG;
    private MsgSettingItemView gzH;
    private LinearLayout gzI;
    private TextView gzJ;
    private LinearLayout gzK;
    private LinearLayout gzL;
    private LinearLayout gzM;
    private TextView gzN;
    private LinearLayout gzO;
    private TextView gzP;
    public boolean gzQ;
    private MsgRemindActivity gzR;
    private TbSettingTextTipView gzS;
    private MsgSettingItemView gzs;
    private LinearLayout gzt;
    private MsgSettingItemView gzu;
    private MsgSettingItemView gzv;
    private MsgSettingItemView gzw;
    private MsgSettingItemView gzx;
    private MsgSettingItemView gzy;
    private MsgSettingItemView gzz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public f(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.gzQ = true;
        this.gzR = msgRemindActivity;
        msgRemindActivity.setContentView(d.i.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        brV();
        brY();
        brX();
        brW();
        brZ();
        d(msgRemindActivity);
        brP();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.k.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gzK = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.gzL = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.gzs = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.gzs.setText(d.k.receive_msg_text);
        this.gzs.setLineVisibility(false);
        this.gzt = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.gzu = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.gzu.setText(d.k.reply);
        this.gzv = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.gzv.setVisibility(0);
        this.gzv.setText(d.k.action_praise_default);
        this.gzw = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.gzw.setText(d.k.mention_atme);
        this.gzx = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.gzx.setText(d.k.new_fans);
        this.gzy = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.gzy.setText(d.k.chat_msg_text);
        this.gzz = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.gzz.setLineVisibility(false);
        this.gzz.setText(d.k.group_chat_text);
        this.gzA = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.gzA.setText(d.k.remind_screen_lock);
        this.gzA.setLineVisibility(false);
        this.gzB = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.gzB.setText(d.k.remind_tone);
        this.gzC = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.gzC.setText(d.k.remind_vibrate);
        this.gzD = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.gzD.setLineVisibility(true);
        this.gzD.setText(d.k.remind_light);
        this.gzE = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.gzE.setText(d.k.sign_remind_outline);
        this.gzF = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.gzG = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.gzH = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.gzH.setText(d.k.no_disturb_mode);
        this.gzH.setLineVisibility(false);
        this.gzI = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.gzJ = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.gzM = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.gzN = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.gzO = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.gzP = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.gzS = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void brP() {
        brQ();
        brR();
        brS();
        brT();
    }

    private void brQ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.gzH.setVisibility(8);
            this.gzI.setVisibility(8);
            this.gzs.setVisibility(8);
            this.gzt.setVisibility(8);
            this.gzE.setVisibility(8);
            this.gzF.setVisibility(8);
            this.gzB.setVisibility(8);
            this.gzC.setVisibility(8);
            this.gzD.setVisibility(8);
            this.gzA.setVisibility(8);
        }
    }

    private void brR() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.gzA.setLineVisibility(true);
        } else {
            this.gzA.setLineVisibility(false);
        }
    }

    private void brS() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.gzy.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.gzz.setVisibility(0);
        } else {
            this.gzz.setVisibility(8);
        }
    }

    private void brT() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.gzA.setVisibility(0);
        } else {
            this.gzA.setVisibility(8);
        }
    }

    public View brU() {
        return this.aBf;
    }

    private void brV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().DY()) {
            this.gzs.mA();
            this.gzt.setVisibility(0);
        } else {
            this.gzs.mB();
            this.gzt.setVisibility(8);
        }
        this.gzu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ed());
        this.gzv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Em());
        this.gzw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Eb());
        this.gzx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ec());
        this.gzy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ee());
        this.gzz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().El());
    }

    private void brW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().isSignAlertOn()) {
            this.gzE.mC();
            this.gzF.setVisibility(0);
            this.gzE.setLineVisibility(true);
            bsa();
            return;
        }
        this.gzE.mD();
        this.gzE.setLineVisibility(false);
        this.gzF.setVisibility(8);
    }

    private void brX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ef()) {
            this.gzB.mA();
        } else {
            this.gzB.mB();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ei()) {
            this.gzC.mA();
        } else {
            this.gzC.mB();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().Eg()) {
            this.gzD.mA();
        } else {
            this.gzD.mB();
        }
    }

    private void brY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().En()) {
            this.gzA.mA();
        } else {
            this.gzA.mB();
        }
    }

    private void brZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().Eh()) {
            this.gzH.mA();
            this.gzI.setVisibility(0);
            bsb();
            return;
        }
        this.gzH.mB();
        this.gzI.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.aBf.setOnClickListener(msgRemindActivity);
        this.gzs.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzx.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzy.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzA.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzB.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzC.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzD.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzE.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzF.setOnClickListener(msgRemindActivity);
        this.gzH.setOnSwitchStateChangeListener(msgRemindActivity);
        this.gzI.setOnClickListener(msgRemindActivity);
        this.gzM.setOnClickListener(msgRemindActivity);
        this.gzO.setOnClickListener(msgRemindActivity);
        this.gzS.setOnClickListener(msgRemindActivity);
    }

    public void mj(boolean z) {
        this.gzH.setLineVisibility(z);
        if (z) {
            this.gzI.setVisibility(0);
            bsb();
            am.i(this.gzI, d.f.more_all);
            return;
        }
        this.gzI.setVisibility(8);
    }

    public void mk(boolean z) {
        if (z) {
            this.gzF.setVisibility(0);
            this.gzE.setLineVisibility(true);
            am.i(this.gzF, d.f.more_all);
            return;
        }
        this.gzF.setVisibility(8);
        this.gzE.setLineVisibility(false);
    }

    public void ml(boolean z) {
        if (z) {
            this.gzt.setVisibility(0);
        } else {
            this.gzt.setVisibility(8);
        }
    }

    public void bsa() {
        String str;
        String str2;
        if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().isSignAlertOn()) {
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertHours() > 9) {
                str = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertHours());
            } else {
                str = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertHours();
            }
            if (com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertMins() > 9) {
                str2 = String.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertMins());
            } else {
                str2 = "0" + com.baidu.tbadk.coreExtra.messageCenter.c.DW().getSignAlertMins();
            }
            this.gzG.setText(this.gzR.getPageContext().getPageActivity().getString(d.k.sign_remind_time, new Object[]{str, str2}));
            this.gzF.setVisibility(0);
            if (!this.gzE.ip()) {
                this.gzE.mA();
                return;
            }
            return;
        }
        this.gzG.setText(d.k.close);
        this.gzF.setVisibility(8);
        if (this.gzE.ip()) {
            this.gzE.mB();
        }
    }

    public void bsb() {
        this.gzJ.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ej() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ek());
        this.gzN.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ej());
        this.gzP.setText(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ek());
    }

    public BdSwitchView bsc() {
        return this.gzE.getSwitchView();
    }

    public BdSwitchView bsd() {
        return this.gzs.getSwitchView();
    }

    public View bse() {
        return this.gzF;
    }

    public BdSwitchView bsf() {
        return this.gzH.getSwitchView();
    }

    public View bsg() {
        return this.gzI;
    }

    public LinearLayout bsh() {
        return this.gzM;
    }

    public LinearLayout bsi() {
        return this.gzO;
    }

    public BdSwitchView bsj() {
        return this.gzB.getSwitchView();
    }

    public BdSwitchView bsk() {
        return this.gzC.getSwitchView();
    }

    public BdSwitchView bsl() {
        return this.gzD.getSwitchView();
    }

    public BdSwitchView bsm() {
        return this.gzA.getSwitchView();
    }

    public BdSwitchView bsn() {
        return this.gzu.getSwitchView();
    }

    public BdSwitchView bso() {
        return this.gzv.getSwitchView();
    }

    public BdSwitchView bsp() {
        return this.gzw.getSwitchView();
    }

    public BdSwitchView bsq() {
        return this.gzy.getSwitchView();
    }

    public BdSwitchView bsr() {
        return this.gzz.getSwitchView();
    }

    public BdSwitchView bss() {
        return this.gzx.getSwitchView();
    }

    public TbSettingTextTipView bst() {
        return this.gzS;
    }

    public void bsu() {
        this.gzu.setOnSwitchStateChangeListener(null);
        this.gzu.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ed());
        this.gzu.setOnSwitchStateChangeListener(this.gzR);
    }

    public void bsv() {
        this.gzv.setOnSwitchStateChangeListener(null);
        this.gzv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Em());
        this.gzv.setOnSwitchStateChangeListener(this.gzR);
    }

    public void bsw() {
        this.gzw.setOnSwitchStateChangeListener(null);
        this.gzw.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Eb());
        this.gzw.setOnSwitchStateChangeListener(this.gzR);
    }

    public void bsx() {
        this.gzx.setOnSwitchStateChangeListener(null);
        this.gzx.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ec());
        this.gzx.setOnSwitchStateChangeListener(this.gzR);
    }

    public void bsy() {
        this.gzy.setOnSwitchStateChangeListener(null);
        this.gzy.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().Ee());
        this.gzy.setOnSwitchStateChangeListener(this.gzR);
    }

    public void bsz() {
        this.gzz.setOnSwitchStateChangeListener(null);
        this.gzz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.c.DW().El());
        this.gzz.setOnSwitchStateChangeListener(this.gzR);
    }

    public void mm(boolean z) {
        if (this.gzQ != z) {
            this.gzQ = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.gzR.getPageContext().getString(d.k.msg_remind));
                this.gzK.setVisibility(0);
                this.gzL.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.gzR.getPageContext().getString(d.k.no_disturb_mode_time));
            this.gzL.setVisibility(0);
            this.gzK.setVisibility(8);
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
        this.gzR.getLayoutMode().setNightMode(i == 1);
        this.gzR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.gzR.getPageContext(), i);
        this.gzs.d(this.gzR.getPageContext(), i);
        this.gzu.d(this.gzR.getPageContext(), i);
        this.gzv.d(this.gzR.getPageContext(), i);
        this.gzw.d(this.gzR.getPageContext(), i);
        this.gzx.d(this.gzR.getPageContext(), i);
        this.gzy.d(this.gzR.getPageContext(), i);
        this.gzz.d(this.gzR.getPageContext(), i);
        this.gzA.d(this.gzR.getPageContext(), i);
        this.gzB.d(this.gzR.getPageContext(), i);
        this.gzC.d(this.gzR.getPageContext(), i);
        this.gzD.d(this.gzR.getPageContext(), i);
        this.gzE.d(this.gzR.getPageContext(), i);
        this.gzH.d(this.gzR.getPageContext(), i);
        am.i(this.gzI, d.f.more_all);
        am.i(this.gzM, d.f.more_all);
        am.i(this.gzO, d.f.more_all);
        am.i(this.gzF, d.f.more_all);
        am.c((ImageView) this.gzI.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gzF.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gzM.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        am.c((ImageView) this.gzO.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }
}
