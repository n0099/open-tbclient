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
    private View cdX;
    private MsgSettingItemView iLY;
    private LinearLayout iLZ;
    private MsgSettingItemView iMa;
    private MsgSettingItemView iMb;
    private MsgSettingItemView iMc;
    private MsgSettingItemView iMd;
    private MsgSettingItemView iMe;
    private MsgSettingItemView iMf;
    private MsgSettingItemView iMg;
    private MsgSettingItemView iMh;
    private MsgSettingItemView iMi;
    private MsgSettingItemView iMj;
    private MsgSettingItemView iMk;
    private LinearLayout iMl;
    private TextView iMm;
    private MsgSettingItemView iMn;
    private LinearLayout iMo;
    private TextView iMp;
    private LinearLayout iMq;
    private LinearLayout iMr;
    private LinearLayout iMs;
    private TextView iMt;
    private LinearLayout iMu;
    private TextView iMv;
    public boolean iMw;
    private MsgRemindActivity iMx;
    private TbSettingTextTipView iMy;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iMw = true;
        this.iMx = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        chV();
        chY();
        chX();
        chW();
        chZ();
        d(msgRemindActivity);
        chP();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMq = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iMr = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iLY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iLY.setText(R.string.receive_msg_text);
        this.iLY.setLineVisibility(false);
        this.iLZ = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iMa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iMa.setText(R.string.reply);
        this.iMb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iMb.setVisibility(0);
        this.iMb.setText(R.string.action_praise_default);
        this.iMc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iMc.setText(R.string.mention_atme);
        this.iMd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iMd.setText(R.string.new_fans);
        this.iMe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iMe.setText(R.string.chat_msg_text);
        this.iMf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iMf.setLineVisibility(false);
        this.iMf.setText(R.string.group_chat_text);
        this.iMg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iMg.setText(R.string.remind_screen_lock);
        this.iMg.setLineVisibility(false);
        this.iMh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iMh.setText(R.string.remind_tone);
        this.iMi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iMi.setText(R.string.remind_vibrate);
        this.iMj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iMj.setLineVisibility(true);
        this.iMj.setText(R.string.remind_light);
        this.iMk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iMk.setText(R.string.sign_remind_outline);
        this.iMl = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iMm = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iMn = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iMn.setText(R.string.no_disturb_mode);
        this.iMn.setLineVisibility(false);
        this.iMo = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iMp = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iMs = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iMt = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iMu = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iMv = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iMy = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void chP() {
        chQ();
        chR();
        chS();
        chT();
    }

    private void chQ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iMn.setVisibility(8);
            this.iMo.setVisibility(8);
            this.iLY.setVisibility(8);
            this.iLZ.setVisibility(8);
            this.iMk.setVisibility(8);
            this.iMl.setVisibility(8);
            this.iMh.setVisibility(8);
            this.iMi.setVisibility(8);
            this.iMj.setVisibility(8);
            this.iMg.setVisibility(8);
        }
    }

    private void chR() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iMg.setLineVisibility(true);
        } else {
            this.iMg.setLineVisibility(false);
        }
    }

    private void chS() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iMe.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iMf.setVisibility(0);
        } else {
            this.iMf.setVisibility(8);
        }
    }

    private void chT() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iMg.setVisibility(0);
        } else {
            this.iMg.setVisibility(8);
        }
    }

    public View chU() {
        return this.cdX;
    }

    private void chV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anh()) {
            this.iLY.mT();
            this.iLZ.setVisibility(0);
        } else {
            this.iLY.mU();
            this.iLZ.setVisibility(8);
        }
        this.iMa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anm());
        this.iMb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw());
        this.iMc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank());
        this.iMd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anl());
        this.iMe.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ann());
        this.iMf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv());
    }

    private void chW() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().isSignAlertOn()) {
            this.iMk.mV();
            this.iMl.setVisibility(0);
            this.iMk.setLineVisibility(true);
            cia();
            return;
        }
        this.iMk.mW();
        this.iMk.setLineVisibility(false);
        this.iMl.setVisibility(8);
    }

    private void chX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().ano()) {
            this.iMh.mT();
        } else {
            this.iMh.mU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anr()) {
            this.iMi.mT();
        } else {
            this.iMi.mU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anp()) {
            this.iMj.mT();
        } else {
            this.iMj.mU();
        }
    }

    private void chY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anx()) {
            this.iMg.mT();
        } else {
            this.iMg.mU();
        }
    }

    private void chZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anq()) {
            this.iMn.mT();
            this.iMo.setVisibility(0);
            cib();
            return;
        }
        this.iMn.mU();
        this.iMo.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.cdX.setOnClickListener(msgRemindActivity);
        this.iLY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMl.setOnClickListener(msgRemindActivity);
        this.iMn.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMo.setOnClickListener(msgRemindActivity);
        this.iMs.setOnClickListener(msgRemindActivity);
        this.iMu.setOnClickListener(msgRemindActivity);
        this.iMy.setOnClickListener(msgRemindActivity);
    }

    public void qp(boolean z) {
        this.iMn.setLineVisibility(z);
        if (z) {
            this.iMo.setVisibility(0);
            cib();
            al.k(this.iMo, R.drawable.more_all);
            return;
        }
        this.iMo.setVisibility(8);
    }

    public void qq(boolean z) {
        if (z) {
            this.iMl.setVisibility(0);
            this.iMk.setLineVisibility(true);
            al.k(this.iMl, R.drawable.more_all);
            return;
        }
        this.iMl.setVisibility(8);
        this.iMk.setLineVisibility(false);
    }

    public void qr(boolean z) {
        if (z) {
            this.iLZ.setVisibility(0);
        } else {
            this.iLZ.setVisibility(8);
        }
    }

    public void cia() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.anf().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.anf().getSignAlertMins();
            this.iMm.setText(this.iMx.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iMl.setVisibility(0);
            if (!this.iMk.iE()) {
                this.iMk.mT();
                return;
            }
            return;
        }
        this.iMm.setText(R.string.close);
        this.iMl.setVisibility(8);
        if (this.iMk.iE()) {
            this.iMk.mU();
        }
    }

    public void cib() {
        String ans = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ans();
        String ant = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ant();
        this.iMp.setText(ans + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ant);
        this.iMt.setText(ans);
        this.iMv.setText(ant);
    }

    public BdSwitchView cic() {
        return this.iMk.getSwitchView();
    }

    public BdSwitchView cid() {
        return this.iLY.getSwitchView();
    }

    public View cie() {
        return this.iMl;
    }

    public BdSwitchView cif() {
        return this.iMn.getSwitchView();
    }

    public View cig() {
        return this.iMo;
    }

    public LinearLayout cih() {
        return this.iMs;
    }

    public LinearLayout cii() {
        return this.iMu;
    }

    public BdSwitchView cij() {
        return this.iMh.getSwitchView();
    }

    public BdSwitchView cik() {
        return this.iMi.getSwitchView();
    }

    public BdSwitchView cil() {
        return this.iMj.getSwitchView();
    }

    public BdSwitchView cim() {
        return this.iMg.getSwitchView();
    }

    public BdSwitchView cin() {
        return this.iMa.getSwitchView();
    }

    public BdSwitchView cio() {
        return this.iMb.getSwitchView();
    }

    public BdSwitchView cip() {
        return this.iMc.getSwitchView();
    }

    public BdSwitchView ciq() {
        return this.iMe.getSwitchView();
    }

    public BdSwitchView cir() {
        return this.iMf.getSwitchView();
    }

    public BdSwitchView cis() {
        return this.iMd.getSwitchView();
    }

    public TbSettingTextTipView cit() {
        return this.iMy;
    }

    public void ciu() {
        this.iMa.setOnSwitchStateChangeListener(null);
        this.iMa.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anm());
        this.iMa.setOnSwitchStateChangeListener(this.iMx);
    }

    public void civ() {
        this.iMb.setOnSwitchStateChangeListener(null);
        this.iMb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw());
        this.iMb.setOnSwitchStateChangeListener(this.iMx);
    }

    public void ciw() {
        this.iMc.setOnSwitchStateChangeListener(null);
        this.iMc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank());
        this.iMc.setOnSwitchStateChangeListener(this.iMx);
    }

    public void cix() {
        this.iMd.setOnSwitchStateChangeListener(null);
        this.iMd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anl());
        this.iMd.setOnSwitchStateChangeListener(this.iMx);
    }

    public void ciy() {
        this.iMe.setOnSwitchStateChangeListener(null);
        this.iMe.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ann());
        this.iMe.setOnSwitchStateChangeListener(this.iMx);
    }

    public void ciz() {
        this.iMf.setOnSwitchStateChangeListener(null);
        this.iMf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv());
        this.iMf.setOnSwitchStateChangeListener(this.iMx);
    }

    public void qs(boolean z) {
        if (this.iMw != z) {
            this.iMw = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iMx.getString(R.string.msg_remind));
                this.iMq.setVisibility(0);
                this.iMr.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iMx.getString(R.string.no_disturb_mode_time));
            this.iMr.setVisibility(0);
            this.iMq.setVisibility(8);
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
        this.iMx.getLayoutMode().setNightMode(i == 1);
        this.iMx.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iLY.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMa.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMb.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMc.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMd.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMe.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMf.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMg.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMh.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMi.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMj.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMk.onChangeSkinType(this.iMx.getPageContext(), i);
        this.iMn.onChangeSkinType(this.iMx.getPageContext(), i);
        al.k(this.iMo, R.drawable.more_all);
        al.k(this.iMs, R.drawable.more_all);
        al.k(this.iMu, R.drawable.more_all);
        al.k(this.iMl, R.drawable.more_all);
        al.c((ImageView) this.iMo.findViewById(R.id.no_disturb_mode_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMl.findViewById(R.id.sign_remind_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMs.findViewById(R.id.no_disturb_start_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMu.findViewById(R.id.no_disturb_end_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
    }

    public void ciA() {
        com.baidu.tbadk.coreExtra.messageCenter.f.anA().b(this.iMx.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
