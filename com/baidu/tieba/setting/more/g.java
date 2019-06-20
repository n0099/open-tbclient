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
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private View cdY;
    private LinearLayout iMA;
    private TextView iMB;
    public boolean iMC;
    private MsgRemindActivity iMD;
    private TbSettingTextTipView iME;
    private MsgSettingItemView iMe;
    private LinearLayout iMf;
    private MsgSettingItemView iMg;
    private MsgSettingItemView iMh;
    private MsgSettingItemView iMi;
    private MsgSettingItemView iMj;
    private MsgSettingItemView iMk;
    private MsgSettingItemView iMl;
    private MsgSettingItemView iMm;
    private MsgSettingItemView iMn;
    private MsgSettingItemView iMo;
    private MsgSettingItemView iMp;
    private MsgSettingItemView iMq;
    private LinearLayout iMr;
    private TextView iMs;
    private MsgSettingItemView iMt;
    private LinearLayout iMu;
    private TextView iMv;
    private LinearLayout iMw;
    private LinearLayout iMx;
    private LinearLayout iMy;
    private TextView iMz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iMC = true;
        this.iMD = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        chY();
        cib();
        cia();
        chZ();
        cic();
        d(msgRemindActivity);
        chS();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMw = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iMx = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iMe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iMe.setText(R.string.receive_msg_text);
        this.iMe.setLineVisibility(false);
        this.iMf = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iMg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iMg.setText(R.string.reply);
        this.iMh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iMh.setVisibility(0);
        this.iMh.setText(R.string.action_praise_default);
        this.iMi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iMi.setText(R.string.mention_atme);
        this.iMj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iMj.setText(R.string.new_fans);
        this.iMk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iMk.setText(R.string.chat_msg_text);
        this.iMl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iMl.setLineVisibility(false);
        this.iMl.setText(R.string.group_chat_text);
        this.iMm = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iMm.setText(R.string.remind_screen_lock);
        this.iMm.setLineVisibility(false);
        this.iMn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iMn.setText(R.string.remind_tone);
        this.iMo = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iMo.setText(R.string.remind_vibrate);
        this.iMp = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iMp.setLineVisibility(true);
        this.iMp.setText(R.string.remind_light);
        this.iMq = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iMq.setText(R.string.sign_remind_outline);
        this.iMr = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iMs = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iMt = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iMt.setText(R.string.no_disturb_mode);
        this.iMt.setLineVisibility(false);
        this.iMu = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iMv = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iMy = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iMz = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iMA = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iMB = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iME = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void chS() {
        chT();
        chU();
        chV();
        chW();
    }

    private void chT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iMt.setVisibility(8);
            this.iMu.setVisibility(8);
            this.iMe.setVisibility(8);
            this.iMf.setVisibility(8);
            this.iMq.setVisibility(8);
            this.iMr.setVisibility(8);
            this.iMn.setVisibility(8);
            this.iMo.setVisibility(8);
            this.iMp.setVisibility(8);
            this.iMm.setVisibility(8);
        }
    }

    private void chU() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iMm.setLineVisibility(true);
        } else {
            this.iMm.setLineVisibility(false);
        }
    }

    private void chV() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iMk.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iMl.setVisibility(0);
        } else {
            this.iMl.setVisibility(8);
        }
    }

    private void chW() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iMm.setVisibility(0);
        } else {
            this.iMm.setVisibility(8);
        }
    }

    public View chX() {
        return this.cdY;
    }

    private void chY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anh()) {
            this.iMe.mT();
            this.iMf.setVisibility(0);
        } else {
            this.iMe.mU();
            this.iMf.setVisibility(8);
        }
        this.iMg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anm());
        this.iMh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw());
        this.iMi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank());
        this.iMj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anl());
        this.iMk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ann());
        this.iMl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv());
    }

    private void chZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().isSignAlertOn()) {
            this.iMq.mV();
            this.iMr.setVisibility(0);
            this.iMq.setLineVisibility(true);
            cid();
            return;
        }
        this.iMq.mW();
        this.iMq.setLineVisibility(false);
        this.iMr.setVisibility(8);
    }

    private void cia() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().ano()) {
            this.iMn.mT();
        } else {
            this.iMn.mU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anr()) {
            this.iMo.mT();
        } else {
            this.iMo.mU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anp()) {
            this.iMp.mT();
        } else {
            this.iMp.mU();
        }
    }

    private void cib() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anx()) {
            this.iMm.mT();
        } else {
            this.iMm.mU();
        }
    }

    private void cic() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anq()) {
            this.iMt.mT();
            this.iMu.setVisibility(0);
            cie();
            return;
        }
        this.iMt.mU();
        this.iMu.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.cdY.setOnClickListener(msgRemindActivity);
        this.iMe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMo.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMq.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMr.setOnClickListener(msgRemindActivity);
        this.iMt.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMu.setOnClickListener(msgRemindActivity);
        this.iMy.setOnClickListener(msgRemindActivity);
        this.iMA.setOnClickListener(msgRemindActivity);
        this.iME.setOnClickListener(msgRemindActivity);
    }

    public void qq(boolean z) {
        this.iMt.setLineVisibility(z);
        if (z) {
            this.iMu.setVisibility(0);
            cie();
            al.k(this.iMu, R.drawable.more_all);
            return;
        }
        this.iMu.setVisibility(8);
    }

    public void qr(boolean z) {
        if (z) {
            this.iMr.setVisibility(0);
            this.iMq.setLineVisibility(true);
            al.k(this.iMr, R.drawable.more_all);
            return;
        }
        this.iMr.setVisibility(8);
        this.iMq.setLineVisibility(false);
    }

    public void qs(boolean z) {
        if (z) {
            this.iMf.setVisibility(0);
        } else {
            this.iMf.setVisibility(8);
        }
    }

    public void cid() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.anf().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.anf().getSignAlertMins();
            this.iMs.setText(this.iMD.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iMr.setVisibility(0);
            if (!this.iMq.iE()) {
                this.iMq.mT();
                return;
            }
            return;
        }
        this.iMs.setText(R.string.close);
        this.iMr.setVisibility(8);
        if (this.iMq.iE()) {
            this.iMq.mU();
        }
    }

    public void cie() {
        String ans = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ans();
        String ant = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ant();
        this.iMv.setText(ans + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ant);
        this.iMz.setText(ans);
        this.iMB.setText(ant);
    }

    public BdSwitchView cif() {
        return this.iMq.getSwitchView();
    }

    public BdSwitchView cig() {
        return this.iMe.getSwitchView();
    }

    public View cih() {
        return this.iMr;
    }

    public BdSwitchView cii() {
        return this.iMt.getSwitchView();
    }

    public View cij() {
        return this.iMu;
    }

    public LinearLayout cik() {
        return this.iMy;
    }

    public LinearLayout cil() {
        return this.iMA;
    }

    public BdSwitchView cim() {
        return this.iMn.getSwitchView();
    }

    public BdSwitchView cin() {
        return this.iMo.getSwitchView();
    }

    public BdSwitchView cio() {
        return this.iMp.getSwitchView();
    }

    public BdSwitchView cip() {
        return this.iMm.getSwitchView();
    }

    public BdSwitchView ciq() {
        return this.iMg.getSwitchView();
    }

    public BdSwitchView cir() {
        return this.iMh.getSwitchView();
    }

    public BdSwitchView cis() {
        return this.iMi.getSwitchView();
    }

    public BdSwitchView cit() {
        return this.iMk.getSwitchView();
    }

    public BdSwitchView ciu() {
        return this.iMl.getSwitchView();
    }

    public BdSwitchView civ() {
        return this.iMj.getSwitchView();
    }

    public TbSettingTextTipView ciw() {
        return this.iME;
    }

    public void cix() {
        this.iMg.setOnSwitchStateChangeListener(null);
        this.iMg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anm());
        this.iMg.setOnSwitchStateChangeListener(this.iMD);
    }

    public void ciy() {
        this.iMh.setOnSwitchStateChangeListener(null);
        this.iMh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw());
        this.iMh.setOnSwitchStateChangeListener(this.iMD);
    }

    public void ciz() {
        this.iMi.setOnSwitchStateChangeListener(null);
        this.iMi.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank());
        this.iMi.setOnSwitchStateChangeListener(this.iMD);
    }

    public void ciA() {
        this.iMj.setOnSwitchStateChangeListener(null);
        this.iMj.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anl());
        this.iMj.setOnSwitchStateChangeListener(this.iMD);
    }

    public void ciB() {
        this.iMk.setOnSwitchStateChangeListener(null);
        this.iMk.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ann());
        this.iMk.setOnSwitchStateChangeListener(this.iMD);
    }

    public void ciC() {
        this.iMl.setOnSwitchStateChangeListener(null);
        this.iMl.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv());
        this.iMl.setOnSwitchStateChangeListener(this.iMD);
    }

    public void qt(boolean z) {
        if (this.iMC != z) {
            this.iMC = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iMD.getString(R.string.msg_remind));
                this.iMw.setVisibility(0);
                this.iMx.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iMD.getString(R.string.no_disturb_mode_time));
            this.iMx.setVisibility(0);
            this.iMw.setVisibility(8);
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
        this.iMD.getLayoutMode().setNightMode(i == 1);
        this.iMD.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMe.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMg.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMh.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMi.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMj.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMk.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMl.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMm.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMn.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMo.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMp.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMq.onChangeSkinType(this.iMD.getPageContext(), i);
        this.iMt.onChangeSkinType(this.iMD.getPageContext(), i);
        al.k(this.iMu, R.drawable.more_all);
        al.k(this.iMy, R.drawable.more_all);
        al.k(this.iMA, R.drawable.more_all);
        al.k(this.iMr, R.drawable.more_all);
        al.c((ImageView) this.iMu.findViewById(R.id.no_disturb_mode_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMr.findViewById(R.id.sign_remind_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMy.findViewById(R.id.no_disturb_start_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMA.findViewById(R.id.no_disturb_end_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
    }

    public void ciD() {
        com.baidu.tbadk.coreExtra.messageCenter.f.anA().b(this.iMD.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
