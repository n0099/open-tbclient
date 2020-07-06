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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes13.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private RelativeLayout iKg;
    private MsgRemindActivity lsA;
    private TbSettingTextTipView lsB;
    private MsgSettingItemView lsb;
    private LinearLayout lsc;
    private MsgSettingItemView lsd;
    private MsgSettingItemView lse;
    private MsgSettingItemView lsf;
    private MsgSettingItemView lsg;
    private MsgSettingItemView lsh;
    private MsgSettingItemView lsi;
    private MsgSettingItemView lsj;
    private MsgSettingItemView lsk;
    private MsgSettingItemView lsl;
    private MsgSettingItemView lsm;
    private MsgSettingItemView lsn;
    private LinearLayout lso;
    private TextView lsp;
    private MsgSettingItemView lsq;
    private LinearLayout lsr;
    private TextView lss;
    private LinearLayout lst;
    private LinearLayout lsu;
    private LinearLayout lsv;
    private TextView lsw;
    private LinearLayout lsx;
    private TextView lsy;
    public boolean lsz;
    private View mBack;
    private NavigationBar mNavigationBar;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iKg = null;
        this.mNavigationBar = null;
        this.lsz = true;
        this.lsA = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dcR();
        dcU();
        dcT();
        dcS();
        dcV();
        d(msgRemindActivity);
        dcM();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iKg = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lst = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.lsu = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.lsb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.lsb.setText(R.string.receive_msg_text);
        this.lsb.setLineVisibility(false);
        this.lsc = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.lsd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.lsd.setText(R.string.reply);
        this.lse = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.lse.setVisibility(0);
        this.lse.setText(R.string.action_praise_default);
        this.lsf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.lsf.setText(R.string.mention_atme);
        this.lsg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.lsg.setText(R.string.new_fans);
        this.lsh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.lsh.setText(R.string.chat_msg_text);
        this.lsi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.lsi.setLineVisibility(false);
        this.lsi.setText(R.string.group_chat_text);
        this.lsj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.lsj.setText(R.string.remind_screen_lock);
        this.lsj.setLineVisibility(false);
        this.lsk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.lsk.setText(R.string.remind_tone);
        this.lsl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.lsl.setText(R.string.remind_vibrate);
        this.lsm = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.lsm.setLineVisibility(true);
        this.lsm.setText(R.string.remind_light);
        this.lsn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.lsn.setText(R.string.sign_remind_outline);
        this.lso = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.lsp = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.lsq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.lsq.setText(R.string.no_disturb_mode);
        this.lsq.setLineVisibility(false);
        this.lsr = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.lss = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.lsv = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.lsw = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.lsx = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.lsy = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.lsB = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void dcM() {
        dcN();
        dcO();
        dcP();
        dcQ();
    }

    private void dcN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.lsq.setVisibility(8);
            this.lsr.setVisibility(8);
            this.lsb.setVisibility(8);
            this.lsc.setVisibility(8);
            this.lsn.setVisibility(8);
            this.lso.setVisibility(8);
            this.lsk.setVisibility(8);
            this.lsl.setVisibility(8);
            this.lsm.setVisibility(8);
            this.lsj.setVisibility(8);
        }
    }

    private void dcO() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.lsj.setLineVisibility(true);
        } else {
            this.lsj.setLineVisibility(false);
        }
    }

    private void dcP() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.lsh.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.lsi.setVisibility(0);
        } else {
            this.lsi.setVisibility(8);
        }
    }

    private void dcQ() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.lsj.setVisibility(0);
        } else {
            this.lsj.setVisibility(8);
        }
    }

    public View IV() {
        return this.mBack;
    }

    private void dcR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bbX()) {
            this.lsb.turnOnNoCallback();
            this.lsc.setVisibility(0);
        } else {
            this.lsb.turnOffNoCallback();
            this.lsc.setVisibility(8);
        }
        this.lsd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcc());
        this.lse.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcm());
        this.lsf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bca());
        this.lsg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcb());
        this.lsh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcd());
        this.lsi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcl());
    }

    private void dcS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().isSignAlertOn()) {
            this.lsn.turnOn();
            this.lso.setVisibility(0);
            this.lsn.setLineVisibility(true);
            dcW();
            return;
        }
        this.lsn.turnOff();
        this.lsn.setLineVisibility(false);
        this.lso.setVisibility(8);
    }

    private void dcT() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bce()) {
            this.lsk.turnOnNoCallback();
        } else {
            this.lsk.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bch()) {
            this.lsl.turnOnNoCallback();
        } else {
            this.lsl.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcf()) {
            this.lsm.turnOnNoCallback();
        } else {
            this.lsm.turnOffNoCallback();
        }
    }

    private void dcU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcn()) {
            this.lsj.turnOnNoCallback();
        } else {
            this.lsj.turnOffNoCallback();
        }
    }

    private void dcV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcg()) {
            this.lsq.turnOnNoCallback();
            this.lsr.setVisibility(0);
            dcX();
            return;
        }
        this.lsq.turnOffNoCallback();
        this.lsr.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.lsb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lse.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lso.setOnClickListener(msgRemindActivity);
        this.lsq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.lsr.setOnClickListener(msgRemindActivity);
        this.lsv.setOnClickListener(msgRemindActivity);
        this.lsx.setOnClickListener(msgRemindActivity);
        this.lsB.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void uk(boolean z) {
        this.lsq.setLineVisibility(z);
        if (z) {
            this.lsr.setVisibility(0);
            dcX();
            an.setBackgroundResource(this.lsr, R.drawable.more_all);
            return;
        }
        this.lsr.setVisibility(8);
    }

    public void ul(boolean z) {
        if (z) {
            this.lso.setVisibility(0);
            this.lsn.setLineVisibility(true);
            an.setBackgroundResource(this.lso, R.drawable.more_all);
            return;
        }
        this.lso.setVisibility(8);
        this.lsn.setLineVisibility(false);
    }

    public void um(boolean z) {
        if (z) {
            this.lsc.setVisibility(0);
        } else {
            this.lsc.setVisibility(8);
        }
    }

    public void dcW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bbV().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bbV().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bbV().getSignAlertMins();
            this.lsp.setText(this.lsA.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.lso.setVisibility(0);
            if (!this.lsn.isOn()) {
                this.lsn.turnOnNoCallback();
                return;
            }
            return;
        }
        this.lsp.setText(R.string.close);
        this.lso.setVisibility(8);
        if (this.lsn.isOn()) {
            this.lsn.turnOffNoCallback();
        }
    }

    public void dcX() {
        String bci = com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bci();
        String bcj = com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcj();
        this.lss.setText(bci + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bcj);
        this.lsw.setText(bci);
        this.lsy.setText(bcj);
    }

    public BdSwitchView dcY() {
        return this.lsn.getSwitchView();
    }

    public BdSwitchView dcZ() {
        return this.lsb.getSwitchView();
    }

    public View dda() {
        return this.lso;
    }

    public BdSwitchView ddb() {
        return this.lsq.getSwitchView();
    }

    public View ddc() {
        return this.lsr;
    }

    public LinearLayout ddd() {
        return this.lsv;
    }

    public LinearLayout dde() {
        return this.lsx;
    }

    public BdSwitchView ddf() {
        return this.lsk.getSwitchView();
    }

    public BdSwitchView ddg() {
        return this.lsl.getSwitchView();
    }

    public BdSwitchView ddh() {
        return this.lsm.getSwitchView();
    }

    public BdSwitchView ddi() {
        return this.lsj.getSwitchView();
    }

    public BdSwitchView ddj() {
        return this.lsd.getSwitchView();
    }

    public BdSwitchView ddk() {
        return this.lse.getSwitchView();
    }

    public BdSwitchView ddl() {
        return this.lsf.getSwitchView();
    }

    public BdSwitchView ddm() {
        return this.lsh.getSwitchView();
    }

    public BdSwitchView ddn() {
        return this.lsi.getSwitchView();
    }

    public BdSwitchView ddo() {
        return this.lsg.getSwitchView();
    }

    public TbSettingTextTipView ddp() {
        return this.lsB;
    }

    public TextView ddq() {
        return this.mNavigationBar.getCenterText();
    }

    public void ddr() {
        this.lsd.setOnSwitchStateChangeListener(null);
        this.lsd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcc());
        this.lsd.setOnSwitchStateChangeListener(this.lsA);
    }

    public void dds() {
        this.lse.setOnSwitchStateChangeListener(null);
        this.lse.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcm());
        this.lse.setOnSwitchStateChangeListener(this.lsA);
    }

    public void ddt() {
        this.lsf.setOnSwitchStateChangeListener(null);
        this.lsf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bca());
        this.lsf.setOnSwitchStateChangeListener(this.lsA);
    }

    public void ddu() {
        this.lsg.setOnSwitchStateChangeListener(null);
        this.lsg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcb());
        this.lsg.setOnSwitchStateChangeListener(this.lsA);
    }

    public void ddv() {
        this.lsh.setOnSwitchStateChangeListener(null);
        this.lsh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcd());
        this.lsh.setOnSwitchStateChangeListener(this.lsA);
    }

    public void ddw() {
        this.lsi.setOnSwitchStateChangeListener(null);
        this.lsi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcl());
        this.lsi.setOnSwitchStateChangeListener(this.lsA);
    }

    public void un(boolean z) {
        if (this.lsz != z) {
            this.lsz = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.lsA.getString(R.string.msg_remind));
                this.lst.setVisibility(0);
                this.lsu.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.lsA.getString(R.string.no_disturb_mode_time));
            this.lsu.setVisibility(0);
            this.lst.setVisibility(8);
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
        this.lsA.getLayoutMode().setNightMode(i == 1);
        this.lsA.getLayoutMode().onModeChanged(this.iKg);
        this.mNavigationBar.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsb.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsd.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lse.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsf.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsg.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsh.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsi.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsj.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsk.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsl.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsm.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsn.onChangeSkinType(this.lsA.getPageContext(), i);
        this.lsq.onChangeSkinType(this.lsA.getPageContext(), i);
        an.setBackgroundResource(this.lsr, R.drawable.more_all);
        an.setBackgroundResource(this.lsv, R.drawable.more_all);
        an.setBackgroundResource(this.lsx, R.drawable.more_all);
        an.setBackgroundResource(this.lso, R.drawable.more_all);
        SvgManager.aWQ().a((ImageView) this.lsr.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aWQ().a((ImageView) this.lso.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aWQ().a((ImageView) this.lsv.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.aWQ().a((ImageView) this.lsx.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void ddx() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bcq().a(this.lsA.getActivity(), this.iKg);
    }

    public void onDestroy() {
    }
}
