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
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View bWc;
    private LinearLayout itA;
    private TextView itB;
    private LinearLayout itC;
    private LinearLayout itD;
    private LinearLayout itE;
    private TextView itF;
    private LinearLayout itG;
    private TextView itH;
    public boolean itI;
    private MsgRemindActivity itJ;
    private TbSettingTextTipView itK;
    private MsgSettingItemView itk;
    private LinearLayout itl;
    private MsgSettingItemView itm;
    private MsgSettingItemView itn;
    private MsgSettingItemView ito;
    private MsgSettingItemView itp;
    private MsgSettingItemView itq;
    private MsgSettingItemView itr;
    private MsgSettingItemView its;
    private MsgSettingItemView itt;
    private MsgSettingItemView itu;
    private MsgSettingItemView itv;
    private MsgSettingItemView itw;
    private LinearLayout itx;
    private TextView ity;
    private MsgSettingItemView itz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.itI = true;
        this.itJ = msgRemindActivity;
        msgRemindActivity.setContentView(d.h.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        bZR();
        bZU();
        bZT();
        bZS();
        bZV();
        d(msgRemindActivity);
        bZL();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(d.g.parent);
        msgRemindActivity.findViewById(d.g.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(d.j.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.bWc = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.itC = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.itD = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.itk = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.itk.setText(d.j.receive_msg_text);
        this.itk.setLineVisibility(false);
        this.itl = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.itm = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.itm.setText(d.j.reply);
        this.itn = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.itn.setVisibility(0);
        this.itn.setText(d.j.action_praise_default);
        this.ito = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.ito.setText(d.j.mention_atme);
        this.itp = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.itp.setText(d.j.new_fans);
        this.itq = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.itq.setText(d.j.chat_msg_text);
        this.itr = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.itr.setLineVisibility(false);
        this.itr.setText(d.j.group_chat_text);
        this.its = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.its.setText(d.j.remind_screen_lock);
        this.its.setLineVisibility(false);
        this.itt = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.itt.setText(d.j.remind_tone);
        this.itu = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.itu.setText(d.j.remind_vibrate);
        this.itv = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.itv.setLineVisibility(true);
        this.itv.setText(d.j.remind_light);
        this.itw = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.itw.setText(d.j.sign_remind_outline);
        this.itx = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.ity = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.itz = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.itz.setText(d.j.no_disturb_mode);
        this.itz.setLineVisibility(false);
        this.itA = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.itB = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.itE = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.itF = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.itG = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.itH = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.itK = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
    }

    private void bZL() {
        bZM();
        bZN();
        bZO();
        bZP();
    }

    private void bZM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.itz.setVisibility(8);
            this.itA.setVisibility(8);
            this.itk.setVisibility(8);
            this.itl.setVisibility(8);
            this.itw.setVisibility(8);
            this.itx.setVisibility(8);
            this.itt.setVisibility(8);
            this.itu.setVisibility(8);
            this.itv.setVisibility(8);
            this.its.setVisibility(8);
        }
    }

    private void bZN() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.its.setLineVisibility(true);
        } else {
            this.its.setLineVisibility(false);
        }
    }

    private void bZO() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.itq.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.itr.setVisibility(0);
        } else {
            this.itr.setVisibility(8);
        }
    }

    private void bZP() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.its.setVisibility(0);
        } else {
            this.its.setVisibility(8);
        }
    }

    public View bZQ() {
        return this.bWc;
    }

    private void bZR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aig()) {
            this.itk.nY();
            this.itl.setVisibility(0);
        } else {
            this.itk.nZ();
            this.itl.setVisibility(8);
        }
        this.itm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().ail());
        this.itn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv());
        this.ito.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij());
        this.itp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aik());
        this.itq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aim());
        this.itr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiu());
    }

    private void bZS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().isSignAlertOn()) {
            this.itw.oa();
            this.itx.setVisibility(0);
            this.itw.setLineVisibility(true);
            bZW();
            return;
        }
        this.itw.ob();
        this.itw.setLineVisibility(false);
        this.itx.setVisibility(8);
    }

    private void bZT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().ain()) {
            this.itt.nY();
        } else {
            this.itt.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiq()) {
            this.itu.nY();
        } else {
            this.itu.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aio()) {
            this.itv.nY();
        } else {
            this.itv.nZ();
        }
    }

    private void bZU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiw()) {
            this.its.nY();
        } else {
            this.its.nZ();
        }
    }

    private void bZV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aip()) {
            this.itz.nY();
            this.itA.setVisibility(0);
            bZX();
            return;
        }
        this.itz.nZ();
        this.itA.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bWc.setOnClickListener(msgRemindActivity);
        this.itk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ito.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.its.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itw.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itx.setOnClickListener(msgRemindActivity);
        this.itz.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itA.setOnClickListener(msgRemindActivity);
        this.itE.setOnClickListener(msgRemindActivity);
        this.itG.setOnClickListener(msgRemindActivity);
        this.itK.setOnClickListener(msgRemindActivity);
    }

    public void pA(boolean z) {
        this.itz.setLineVisibility(z);
        if (z) {
            this.itA.setVisibility(0);
            bZX();
            al.k(this.itA, d.f.more_all);
            return;
        }
        this.itA.setVisibility(8);
    }

    public void pB(boolean z) {
        if (z) {
            this.itx.setVisibility(0);
            this.itw.setLineVisibility(true);
            al.k(this.itx, d.f.more_all);
            return;
        }
        this.itx.setVisibility(8);
        this.itw.setLineVisibility(false);
    }

    public void pC(boolean z) {
        if (z) {
            this.itl.setVisibility(0);
        } else {
            this.itl.setVisibility(8);
        }
    }

    public void bZW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aie().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aie().getSignAlertMins();
            this.ity.setText(this.itJ.getString(d.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.itx.setVisibility(0);
            if (!this.itw.jK()) {
                this.itw.nY();
                return;
            }
            return;
        }
        this.ity.setText(d.j.close);
        this.itx.setVisibility(8);
        if (this.itw.jK()) {
            this.itw.nZ();
        }
    }

    public void bZX() {
        String air = com.baidu.tbadk.coreExtra.messageCenter.d.aie().air();
        String ais = com.baidu.tbadk.coreExtra.messageCenter.d.aie().ais();
        this.itB.setText(air + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ais);
        this.itF.setText(air);
        this.itH.setText(ais);
    }

    public BdSwitchView bZY() {
        return this.itw.getSwitchView();
    }

    public BdSwitchView bZZ() {
        return this.itk.getSwitchView();
    }

    public View caa() {
        return this.itx;
    }

    public BdSwitchView cab() {
        return this.itz.getSwitchView();
    }

    public View cac() {
        return this.itA;
    }

    public LinearLayout cad() {
        return this.itE;
    }

    public LinearLayout cae() {
        return this.itG;
    }

    public BdSwitchView caf() {
        return this.itt.getSwitchView();
    }

    public BdSwitchView cag() {
        return this.itu.getSwitchView();
    }

    public BdSwitchView cah() {
        return this.itv.getSwitchView();
    }

    public BdSwitchView cai() {
        return this.its.getSwitchView();
    }

    public BdSwitchView caj() {
        return this.itm.getSwitchView();
    }

    public BdSwitchView cak() {
        return this.itn.getSwitchView();
    }

    public BdSwitchView cal() {
        return this.ito.getSwitchView();
    }

    public BdSwitchView cam() {
        return this.itq.getSwitchView();
    }

    public BdSwitchView can() {
        return this.itr.getSwitchView();
    }

    public BdSwitchView cao() {
        return this.itp.getSwitchView();
    }

    public TbSettingTextTipView cap() {
        return this.itK;
    }

    public void caq() {
        this.itm.setOnSwitchStateChangeListener(null);
        this.itm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().ail());
        this.itm.setOnSwitchStateChangeListener(this.itJ);
    }

    public void car() {
        this.itn.setOnSwitchStateChangeListener(null);
        this.itn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv());
        this.itn.setOnSwitchStateChangeListener(this.itJ);
    }

    public void cas() {
        this.ito.setOnSwitchStateChangeListener(null);
        this.ito.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij());
        this.ito.setOnSwitchStateChangeListener(this.itJ);
    }

    public void cat() {
        this.itp.setOnSwitchStateChangeListener(null);
        this.itp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aik());
        this.itp.setOnSwitchStateChangeListener(this.itJ);
    }

    public void cau() {
        this.itq.setOnSwitchStateChangeListener(null);
        this.itq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aim());
        this.itq.setOnSwitchStateChangeListener(this.itJ);
    }

    public void cav() {
        this.itr.setOnSwitchStateChangeListener(null);
        this.itr.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiu());
        this.itr.setOnSwitchStateChangeListener(this.itJ);
    }

    public void pD(boolean z) {
        if (this.itI != z) {
            this.itI = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.itJ.getString(d.j.msg_remind));
                this.itC.setVisibility(0);
                this.itD.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.itJ.getString(d.j.no_disturb_mode_time));
            this.itD.setVisibility(0);
            this.itC.setVisibility(8);
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
        this.itJ.getLayoutMode().setNightMode(i == 1);
        this.itJ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itk.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itm.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itn.onChangeSkinType(this.itJ.getPageContext(), i);
        this.ito.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itp.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itq.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itr.onChangeSkinType(this.itJ.getPageContext(), i);
        this.its.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itt.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itu.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itv.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itw.onChangeSkinType(this.itJ.getPageContext(), i);
        this.itz.onChangeSkinType(this.itJ.getPageContext(), i);
        al.k(this.itA, d.f.more_all);
        al.k(this.itE, d.f.more_all);
        al.k(this.itG, d.f.more_all);
        al.k(this.itx, d.f.more_all);
        al.c((ImageView) this.itA.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itx.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itE.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itG.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }

    public void caw() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aiz().b(this.itJ.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
