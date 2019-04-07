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
    private View bWb;
    private TextView itA;
    private LinearLayout itB;
    private LinearLayout itC;
    private LinearLayout itD;
    private TextView itE;
    private LinearLayout itF;
    private TextView itG;
    public boolean itH;
    private MsgRemindActivity itI;
    private TbSettingTextTipView itJ;
    private MsgSettingItemView itj;
    private LinearLayout itk;
    private MsgSettingItemView itl;
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
    private LinearLayout itw;
    private TextView itx;
    private MsgSettingItemView ity;
    private LinearLayout itz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.itH = true;
        this.itI = msgRemindActivity;
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
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.itB = (LinearLayout) msgRemindActivity.findViewById(d.g.front_container);
        this.itC = (LinearLayout) msgRemindActivity.findViewById(d.g.back_container);
        this.itj = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.receive_message_swtich);
        this.itj.setText(d.j.receive_msg_text);
        this.itj.setLineVisibility(false);
        this.itk = (LinearLayout) msgRemindActivity.findViewById(d.g.receive_message_container);
        this.itl = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.reply_check_box);
        this.itl.setText(d.j.reply);
        this.itm = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.zan_check_box);
        this.itm.setVisibility(0);
        this.itm.setText(d.j.action_praise_default);
        this.itn = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.at_me_check_box);
        this.itn.setText(d.j.mention_atme);
        this.ito = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.new_fans_swtich);
        this.ito.setText(d.j.new_fans);
        this.itp = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.chat_msg_swtich);
        this.itp.setText(d.j.chat_msg_text);
        this.itq = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.group_chat_swtich);
        this.itq.setLineVisibility(false);
        this.itq.setText(d.j.group_chat_text);
        this.itr = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.screen_lock_swtich);
        this.itr.setText(d.j.remind_screen_lock);
        this.itr.setLineVisibility(false);
        this.its = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.tone_remind_swtich);
        this.its.setText(d.j.remind_tone);
        this.itt = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.vibrate_remind_swtich);
        this.itt.setText(d.j.remind_vibrate);
        this.itu = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.light_remind_swtich);
        this.itu.setLineVisibility(true);
        this.itu.setText(d.j.remind_light);
        this.itv = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.sign_remind_swtich);
        this.itv.setText(d.j.sign_remind_outline);
        this.itw = (LinearLayout) msgRemindActivity.findViewById(d.g.sign_remind);
        this.itx = (TextView) msgRemindActivity.findViewById(d.g.sign_remind_time);
        this.ity = (MsgSettingItemView) msgRemindActivity.findViewById(d.g.no_disturb_swtich);
        this.ity.setText(d.j.no_disturb_mode);
        this.ity.setLineVisibility(false);
        this.itz = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_container);
        this.itA = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_mode_time_value);
        this.itD = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_start_time);
        this.itE = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_start_time_value);
        this.itF = (LinearLayout) msgRemindActivity.findViewById(d.g.no_disturb_end_time);
        this.itG = (TextView) msgRemindActivity.findViewById(d.g.no_disturb_end_time_value);
        this.itJ = (TbSettingTextTipView) msgRemindActivity.findViewById(d.g.msg_receive_item_view);
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
            this.ity.setVisibility(8);
            this.itz.setVisibility(8);
            this.itj.setVisibility(8);
            this.itk.setVisibility(8);
            this.itv.setVisibility(8);
            this.itw.setVisibility(8);
            this.its.setVisibility(8);
            this.itt.setVisibility(8);
            this.itu.setVisibility(8);
            this.itr.setVisibility(8);
        }
    }

    private void bZN() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.itr.setLineVisibility(true);
        } else {
            this.itr.setLineVisibility(false);
        }
    }

    private void bZO() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.itp.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.itq.setVisibility(0);
        } else {
            this.itq.setVisibility(8);
        }
    }

    private void bZP() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.itr.setVisibility(0);
        } else {
            this.itr.setVisibility(8);
        }
    }

    public View bZQ() {
        return this.bWb;
    }

    private void bZR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aig()) {
            this.itj.nY();
            this.itk.setVisibility(0);
        } else {
            this.itj.nZ();
            this.itk.setVisibility(8);
        }
        this.itl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().ail());
        this.itm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv());
        this.itn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij());
        this.ito.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aik());
        this.itp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aim());
        this.itq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiu());
    }

    private void bZS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().isSignAlertOn()) {
            this.itv.oa();
            this.itw.setVisibility(0);
            this.itv.setLineVisibility(true);
            bZW();
            return;
        }
        this.itv.ob();
        this.itv.setLineVisibility(false);
        this.itw.setVisibility(8);
    }

    private void bZT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().ain()) {
            this.its.nY();
        } else {
            this.its.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiq()) {
            this.itt.nY();
        } else {
            this.itt.nZ();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aio()) {
            this.itu.nY();
        } else {
            this.itu.nZ();
        }
    }

    private void bZU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiw()) {
            this.itr.nY();
        } else {
            this.itr.nZ();
        }
    }

    private void bZV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().aip()) {
            this.ity.nY();
            this.itz.setVisibility(0);
            bZX();
            return;
        }
        this.ity.nZ();
        this.itz.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.bWb.setOnClickListener(msgRemindActivity);
        this.itj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.ito.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itr.setOnSwitchStateChangeListener(msgRemindActivity);
        this.its.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itu.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itv.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itw.setOnClickListener(msgRemindActivity);
        this.ity.setOnSwitchStateChangeListener(msgRemindActivity);
        this.itz.setOnClickListener(msgRemindActivity);
        this.itD.setOnClickListener(msgRemindActivity);
        this.itF.setOnClickListener(msgRemindActivity);
        this.itJ.setOnClickListener(msgRemindActivity);
    }

    public void pA(boolean z) {
        this.ity.setLineVisibility(z);
        if (z) {
            this.itz.setVisibility(0);
            bZX();
            al.k(this.itz, d.f.more_all);
            return;
        }
        this.itz.setVisibility(8);
    }

    public void pB(boolean z) {
        if (z) {
            this.itw.setVisibility(0);
            this.itv.setLineVisibility(true);
            al.k(this.itw, d.f.more_all);
            return;
        }
        this.itw.setVisibility(8);
        this.itv.setLineVisibility(false);
    }

    public void pC(boolean z) {
        if (z) {
            this.itk.setVisibility(0);
        } else {
            this.itk.setVisibility(8);
        }
    }

    public void bZW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aie().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aie().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aie().getSignAlertMins();
            this.itx.setText(this.itI.getString(d.j.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.itw.setVisibility(0);
            if (!this.itv.jK()) {
                this.itv.nY();
                return;
            }
            return;
        }
        this.itx.setText(d.j.close);
        this.itw.setVisibility(8);
        if (this.itv.jK()) {
            this.itv.nZ();
        }
    }

    public void bZX() {
        String air = com.baidu.tbadk.coreExtra.messageCenter.d.aie().air();
        String ais = com.baidu.tbadk.coreExtra.messageCenter.d.aie().ais();
        this.itA.setText(air + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ais);
        this.itE.setText(air);
        this.itG.setText(ais);
    }

    public BdSwitchView bZY() {
        return this.itv.getSwitchView();
    }

    public BdSwitchView bZZ() {
        return this.itj.getSwitchView();
    }

    public View caa() {
        return this.itw;
    }

    public BdSwitchView cab() {
        return this.ity.getSwitchView();
    }

    public View cac() {
        return this.itz;
    }

    public LinearLayout cad() {
        return this.itD;
    }

    public LinearLayout cae() {
        return this.itF;
    }

    public BdSwitchView caf() {
        return this.its.getSwitchView();
    }

    public BdSwitchView cag() {
        return this.itt.getSwitchView();
    }

    public BdSwitchView cah() {
        return this.itu.getSwitchView();
    }

    public BdSwitchView cai() {
        return this.itr.getSwitchView();
    }

    public BdSwitchView caj() {
        return this.itl.getSwitchView();
    }

    public BdSwitchView cak() {
        return this.itm.getSwitchView();
    }

    public BdSwitchView cal() {
        return this.itn.getSwitchView();
    }

    public BdSwitchView cam() {
        return this.itp.getSwitchView();
    }

    public BdSwitchView can() {
        return this.itq.getSwitchView();
    }

    public BdSwitchView cao() {
        return this.ito.getSwitchView();
    }

    public TbSettingTextTipView cap() {
        return this.itJ;
    }

    public void caq() {
        this.itl.setOnSwitchStateChangeListener(null);
        this.itl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().ail());
        this.itl.setOnSwitchStateChangeListener(this.itI);
    }

    public void car() {
        this.itm.setOnSwitchStateChangeListener(null);
        this.itm.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv());
        this.itm.setOnSwitchStateChangeListener(this.itI);
    }

    public void cas() {
        this.itn.setOnSwitchStateChangeListener(null);
        this.itn.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij());
        this.itn.setOnSwitchStateChangeListener(this.itI);
    }

    public void cat() {
        this.ito.setOnSwitchStateChangeListener(null);
        this.ito.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aik());
        this.ito.setOnSwitchStateChangeListener(this.itI);
    }

    public void cau() {
        this.itp.setOnSwitchStateChangeListener(null);
        this.itp.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aim());
        this.itp.setOnSwitchStateChangeListener(this.itI);
    }

    public void cav() {
        this.itq.setOnSwitchStateChangeListener(null);
        this.itq.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiu());
        this.itq.setOnSwitchStateChangeListener(this.itI);
    }

    public void pD(boolean z) {
        if (this.itH != z) {
            this.itH = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.itI.getString(d.j.msg_remind));
                this.itB.setVisibility(0);
                this.itC.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.itI.getString(d.j.no_disturb_mode_time));
            this.itC.setVisibility(0);
            this.itB.setVisibility(8);
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
        this.itI.getLayoutMode().setNightMode(i == 1);
        this.itI.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.itI.getPageContext(), i);
        this.itj.onChangeSkinType(this.itI.getPageContext(), i);
        this.itl.onChangeSkinType(this.itI.getPageContext(), i);
        this.itm.onChangeSkinType(this.itI.getPageContext(), i);
        this.itn.onChangeSkinType(this.itI.getPageContext(), i);
        this.ito.onChangeSkinType(this.itI.getPageContext(), i);
        this.itp.onChangeSkinType(this.itI.getPageContext(), i);
        this.itq.onChangeSkinType(this.itI.getPageContext(), i);
        this.itr.onChangeSkinType(this.itI.getPageContext(), i);
        this.its.onChangeSkinType(this.itI.getPageContext(), i);
        this.itt.onChangeSkinType(this.itI.getPageContext(), i);
        this.itu.onChangeSkinType(this.itI.getPageContext(), i);
        this.itv.onChangeSkinType(this.itI.getPageContext(), i);
        this.ity.onChangeSkinType(this.itI.getPageContext(), i);
        al.k(this.itz, d.f.more_all);
        al.k(this.itD, d.f.more_all);
        al.k(this.itF, d.f.more_all);
        al.k(this.itw, d.f.more_all);
        al.c((ImageView) this.itz.findViewById(d.g.no_disturb_mode_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itw.findViewById(d.g.sign_remind_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itD.findViewById(d.g.no_disturb_start_time_arrow), d.f.icon_arrow_gray_right_n);
        al.c((ImageView) this.itF.findViewById(d.g.no_disturb_end_time_arrow), d.f.icon_arrow_gray_right_n);
    }

    public void caw() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aiz().b(this.itI.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
