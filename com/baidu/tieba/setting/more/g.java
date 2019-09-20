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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View cgb;
    private MsgSettingItemView iVV;
    private LinearLayout iVW;
    private MsgSettingItemView iVX;
    private MsgSettingItemView iVY;
    private MsgSettingItemView iVZ;
    private MsgSettingItemView iWa;
    private MsgSettingItemView iWb;
    private MsgSettingItemView iWc;
    private MsgSettingItemView iWd;
    private MsgSettingItemView iWe;
    private MsgSettingItemView iWf;
    private MsgSettingItemView iWg;
    private MsgSettingItemView iWh;
    private LinearLayout iWi;
    private TextView iWj;
    private MsgSettingItemView iWk;
    private LinearLayout iWl;
    private TextView iWm;
    private LinearLayout iWn;
    private LinearLayout iWo;
    private LinearLayout iWp;
    private TextView iWq;
    private LinearLayout iWr;
    private TextView iWs;
    public boolean iWt;
    private MsgRemindActivity iWu;
    private TbSettingTextTipView iWv;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iWt = true;
        this.iWu = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        clT();
        clW();
        clV();
        clU();
        clX();
        d(msgRemindActivity);
        clN();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWn = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iWo = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iVV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iVV.setText(R.string.receive_msg_text);
        this.iVV.setLineVisibility(false);
        this.iVW = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iVX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iVX.setText(R.string.reply);
        this.iVY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iVY.setVisibility(0);
        this.iVY.setText(R.string.action_praise_default);
        this.iVZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iVZ.setText(R.string.mention_atme);
        this.iWa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iWa.setText(R.string.new_fans);
        this.iWb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iWb.setText(R.string.chat_msg_text);
        this.iWc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iWc.setLineVisibility(false);
        this.iWc.setText(R.string.group_chat_text);
        this.iWd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iWd.setText(R.string.remind_screen_lock);
        this.iWd.setLineVisibility(false);
        this.iWe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iWe.setText(R.string.remind_tone);
        this.iWf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iWf.setText(R.string.remind_vibrate);
        this.iWg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iWg.setLineVisibility(true);
        this.iWg.setText(R.string.remind_light);
        this.iWh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iWh.setText(R.string.sign_remind_outline);
        this.iWi = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iWj = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iWk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iWk.setText(R.string.no_disturb_mode);
        this.iWk.setLineVisibility(false);
        this.iWl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iWm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iWp = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iWq = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iWr = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iWs = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iWv = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void clN() {
        clO();
        clP();
        clQ();
        clR();
    }

    private void clO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iWk.setVisibility(8);
            this.iWl.setVisibility(8);
            this.iVV.setVisibility(8);
            this.iVW.setVisibility(8);
            this.iWh.setVisibility(8);
            this.iWi.setVisibility(8);
            this.iWe.setVisibility(8);
            this.iWf.setVisibility(8);
            this.iWg.setVisibility(8);
            this.iWd.setVisibility(8);
        }
    }

    private void clP() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iWd.setLineVisibility(true);
        } else {
            this.iWd.setLineVisibility(false);
        }
    }

    private void clQ() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iWb.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iWc.setVisibility(0);
        } else {
            this.iWc.setVisibility(8);
        }
    }

    private void clR() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iWd.setVisibility(0);
        } else {
            this.iWd.setVisibility(8);
        }
    }

    public View clS() {
        return this.cgb;
    }

    private void clT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoA()) {
            this.iVV.nk();
            this.iVW.setVisibility(0);
        } else {
            this.iVV.nl();
            this.iVW.setVisibility(8);
        }
        this.iVX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoF());
        this.iVY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoP());
        this.iVZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoD());
        this.iWa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoE());
        this.iWb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoG());
        this.iWc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoO());
    }

    private void clU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().isSignAlertOn()) {
            this.iWh.nm();
            this.iWi.setVisibility(0);
            this.iWh.setLineVisibility(true);
            clY();
            return;
        }
        this.iWh.nn();
        this.iWh.setLineVisibility(false);
        this.iWi.setVisibility(8);
    }

    private void clV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoH()) {
            this.iWe.nk();
        } else {
            this.iWe.nl();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoK()) {
            this.iWf.nk();
        } else {
            this.iWf.nl();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoI()) {
            this.iWg.nk();
        } else {
            this.iWg.nl();
        }
    }

    private void clW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoQ()) {
            this.iWd.nk();
        } else {
            this.iWd.nl();
        }
    }

    private void clX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoJ()) {
            this.iWk.nk();
            this.iWl.setVisibility(0);
            clZ();
            return;
        }
        this.iWk.nl();
        this.iWl.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.cgb.setOnClickListener(msgRemindActivity);
        this.iVV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iVY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWi.setOnClickListener(msgRemindActivity);
        this.iWk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iWl.setOnClickListener(msgRemindActivity);
        this.iWp.setOnClickListener(msgRemindActivity);
        this.iWr.setOnClickListener(msgRemindActivity);
        this.iWv.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void qJ(boolean z) {
        this.iWk.setLineVisibility(z);
        if (z) {
            this.iWl.setVisibility(0);
            clZ();
            am.k(this.iWl, R.drawable.more_all);
            return;
        }
        this.iWl.setVisibility(8);
    }

    public void qK(boolean z) {
        if (z) {
            this.iWi.setVisibility(0);
            this.iWh.setLineVisibility(true);
            am.k(this.iWi, R.drawable.more_all);
            return;
        }
        this.iWi.setVisibility(8);
        this.iWh.setLineVisibility(false);
    }

    public void qL(boolean z) {
        if (z) {
            this.iVW.setVisibility(0);
        } else {
            this.iVW.setVisibility(8);
        }
    }

    public void clY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.aoy().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.aoy().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.aoy().getSignAlertMins();
            this.iWj.setText(this.iWu.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iWi.setVisibility(0);
            if (!this.iWh.iN()) {
                this.iWh.nk();
                return;
            }
            return;
        }
        this.iWj.setText(R.string.close);
        this.iWi.setVisibility(8);
        if (this.iWh.iN()) {
            this.iWh.nl();
        }
    }

    public void clZ() {
        String aoL = com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoL();
        String aoM = com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoM();
        this.iWm.setText(aoL + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoM);
        this.iWq.setText(aoL);
        this.iWs.setText(aoM);
    }

    public BdSwitchView cma() {
        return this.iWh.getSwitchView();
    }

    public BdSwitchView cmb() {
        return this.iVV.getSwitchView();
    }

    public View cmc() {
        return this.iWi;
    }

    public BdSwitchView cmd() {
        return this.iWk.getSwitchView();
    }

    public View cme() {
        return this.iWl;
    }

    public LinearLayout cmf() {
        return this.iWp;
    }

    public LinearLayout cmg() {
        return this.iWr;
    }

    public BdSwitchView cmh() {
        return this.iWe.getSwitchView();
    }

    public BdSwitchView cmi() {
        return this.iWf.getSwitchView();
    }

    public BdSwitchView cmj() {
        return this.iWg.getSwitchView();
    }

    public BdSwitchView cmk() {
        return this.iWd.getSwitchView();
    }

    public BdSwitchView cml() {
        return this.iVX.getSwitchView();
    }

    public BdSwitchView cmm() {
        return this.iVY.getSwitchView();
    }

    public BdSwitchView cmn() {
        return this.iVZ.getSwitchView();
    }

    public BdSwitchView cmo() {
        return this.iWb.getSwitchView();
    }

    public BdSwitchView cmp() {
        return this.iWc.getSwitchView();
    }

    public BdSwitchView cmq() {
        return this.iWa.getSwitchView();
    }

    public TbSettingTextTipView cmr() {
        return this.iWv;
    }

    public TextView cms() {
        return this.mNavigationBar.getCenterText();
    }

    public void cmt() {
        this.iVX.setOnSwitchStateChangeListener(null);
        this.iVX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoF());
        this.iVX.setOnSwitchStateChangeListener(this.iWu);
    }

    public void cmu() {
        this.iVY.setOnSwitchStateChangeListener(null);
        this.iVY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoP());
        this.iVY.setOnSwitchStateChangeListener(this.iWu);
    }

    public void cmv() {
        this.iVZ.setOnSwitchStateChangeListener(null);
        this.iVZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoD());
        this.iVZ.setOnSwitchStateChangeListener(this.iWu);
    }

    public void cmw() {
        this.iWa.setOnSwitchStateChangeListener(null);
        this.iWa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoE());
        this.iWa.setOnSwitchStateChangeListener(this.iWu);
    }

    public void cmx() {
        this.iWb.setOnSwitchStateChangeListener(null);
        this.iWb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoG());
        this.iWb.setOnSwitchStateChangeListener(this.iWu);
    }

    public void cmy() {
        this.iWc.setOnSwitchStateChangeListener(null);
        this.iWc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoO());
        this.iWc.setOnSwitchStateChangeListener(this.iWu);
    }

    public void qM(boolean z) {
        if (this.iWt != z) {
            this.iWt = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iWu.getString(R.string.msg_remind));
                this.iWn.setVisibility(0);
                this.iWo.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iWu.getString(R.string.no_disturb_mode_time));
            this.iWo.setVisibility(0);
            this.iWn.setVisibility(8);
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
        this.iWu.getLayoutMode().setNightMode(i == 1);
        this.iWu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iVV.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iVX.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iVY.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iVZ.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWa.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWb.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWc.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWd.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWe.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWf.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWg.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWh.onChangeSkinType(this.iWu.getPageContext(), i);
        this.iWk.onChangeSkinType(this.iWu.getPageContext(), i);
        am.k(this.iWl, R.drawable.more_all);
        am.k(this.iWp, R.drawable.more_all);
        am.k(this.iWr, R.drawable.more_all);
        am.k(this.iWi, R.drawable.more_all);
        SvgManager.ajv().a((ImageView) this.iWl.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.ajv().a((ImageView) this.iWi.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.ajv().a((ImageView) this.iWp.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.ajv().a((ImageView) this.iWr.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void cmz() {
        com.baidu.tbadk.coreExtra.messageCenter.f.aoT().b(this.iWu.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
