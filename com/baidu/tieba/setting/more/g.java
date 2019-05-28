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
    private TbSettingTextTipView iMA;
    private MsgSettingItemView iMa;
    private LinearLayout iMb;
    private MsgSettingItemView iMc;
    private MsgSettingItemView iMd;
    private MsgSettingItemView iMe;
    private MsgSettingItemView iMf;
    private MsgSettingItemView iMg;
    private MsgSettingItemView iMh;
    private MsgSettingItemView iMi;
    private MsgSettingItemView iMj;
    private MsgSettingItemView iMk;
    private MsgSettingItemView iMl;
    private MsgSettingItemView iMm;
    private LinearLayout iMn;
    private TextView iMo;
    private MsgSettingItemView iMp;
    private LinearLayout iMq;
    private TextView iMr;
    private LinearLayout iMs;
    private LinearLayout iMt;
    private LinearLayout iMu;
    private TextView iMv;
    private LinearLayout iMw;
    private TextView iMx;
    public boolean iMy;
    private MsgRemindActivity iMz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.mParent = null;
        this.mNavigationBar = null;
        this.iMy = true;
        this.iMz = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        chX();
        cia();
        chZ();
        chY();
        cib();
        d(msgRemindActivity);
        chR();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.mParent = (RelativeLayout) msgRemindActivity.findViewById(R.id.parent);
        msgRemindActivity.findViewById(R.id.top_head_view).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.cdX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iMs = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.iMt = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.iMa = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.iMa.setText(R.string.receive_msg_text);
        this.iMa.setLineVisibility(false);
        this.iMb = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.iMc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.iMc.setText(R.string.reply);
        this.iMd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.iMd.setVisibility(0);
        this.iMd.setText(R.string.action_praise_default);
        this.iMe = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.iMe.setText(R.string.mention_atme);
        this.iMf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.iMf.setText(R.string.new_fans);
        this.iMg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.iMg.setText(R.string.chat_msg_text);
        this.iMh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.iMh.setLineVisibility(false);
        this.iMh.setText(R.string.group_chat_text);
        this.iMi = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.iMi.setText(R.string.remind_screen_lock);
        this.iMi.setLineVisibility(false);
        this.iMj = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.iMj.setText(R.string.remind_tone);
        this.iMk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.iMk.setText(R.string.remind_vibrate);
        this.iMl = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.iMl.setLineVisibility(true);
        this.iMl.setText(R.string.remind_light);
        this.iMm = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.iMm.setText(R.string.sign_remind_outline);
        this.iMn = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.iMo = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.iMp = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.iMp.setText(R.string.no_disturb_mode);
        this.iMp.setLineVisibility(false);
        this.iMq = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.iMr = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.iMu = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.iMv = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.iMw = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.iMx = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.iMA = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
    }

    private void chR() {
        chS();
        chT();
        chU();
        chV();
    }

    private void chS() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.iMp.setVisibility(8);
            this.iMq.setVisibility(8);
            this.iMa.setVisibility(8);
            this.iMb.setVisibility(8);
            this.iMm.setVisibility(8);
            this.iMn.setVisibility(8);
            this.iMj.setVisibility(8);
            this.iMk.setVisibility(8);
            this.iMl.setVisibility(8);
            this.iMi.setVisibility(8);
        }
    }

    private void chT() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.iMi.setLineVisibility(true);
        } else {
            this.iMi.setLineVisibility(false);
        }
    }

    private void chU() {
        boolean appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        this.iMg.setLineVisibility(appResponseToIntentClass);
        if (appResponseToIntentClass) {
            this.iMh.setVisibility(0);
        } else {
            this.iMh.setVisibility(8);
        }
    }

    private void chV() {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class)) {
            this.iMi.setVisibility(0);
        } else {
            this.iMi.setVisibility(8);
        }
    }

    public View chW() {
        return this.cdX;
    }

    private void chX() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anh()) {
            this.iMa.mT();
            this.iMb.setVisibility(0);
        } else {
            this.iMa.mU();
            this.iMb.setVisibility(8);
        }
        this.iMc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anm());
        this.iMd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw());
        this.iMe.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank());
        this.iMf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anl());
        this.iMg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ann());
        this.iMh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv());
    }

    private void chY() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().isSignAlertOn()) {
            this.iMm.mV();
            this.iMn.setVisibility(0);
            this.iMm.setLineVisibility(true);
            cic();
            return;
        }
        this.iMm.mW();
        this.iMm.setLineVisibility(false);
        this.iMn.setVisibility(8);
    }

    private void chZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().ano()) {
            this.iMj.mT();
        } else {
            this.iMj.mU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anr()) {
            this.iMk.mT();
        } else {
            this.iMk.mU();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anp()) {
            this.iMl.mT();
        } else {
            this.iMl.mU();
        }
    }

    private void cia() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anx()) {
            this.iMi.mT();
        } else {
            this.iMi.mU();
        }
    }

    private void cib() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anq()) {
            this.iMp.mT();
            this.iMq.setVisibility(0);
            cid();
            return;
        }
        this.iMp.mU();
        this.iMq.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.cdX.setOnClickListener(msgRemindActivity);
        this.iMa.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMe.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMi.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMj.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMl.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMm.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMn.setOnClickListener(msgRemindActivity);
        this.iMp.setOnSwitchStateChangeListener(msgRemindActivity);
        this.iMq.setOnClickListener(msgRemindActivity);
        this.iMu.setOnClickListener(msgRemindActivity);
        this.iMw.setOnClickListener(msgRemindActivity);
        this.iMA.setOnClickListener(msgRemindActivity);
    }

    public void qp(boolean z) {
        this.iMp.setLineVisibility(z);
        if (z) {
            this.iMq.setVisibility(0);
            cid();
            al.k(this.iMq, R.drawable.more_all);
            return;
        }
        this.iMq.setVisibility(8);
    }

    public void qq(boolean z) {
        if (z) {
            this.iMn.setVisibility(0);
            this.iMm.setLineVisibility(true);
            al.k(this.iMn, R.drawable.more_all);
            return;
        }
        this.iMn.setVisibility(8);
        this.iMm.setLineVisibility(false);
    }

    public void qr(boolean z) {
        if (z) {
            this.iMb.setVisibility(0);
        } else {
            this.iMb.setVisibility(8);
        }
    }

    public void cic() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.anf().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.anf().getSignAlertMins();
            this.iMo.setText(this.iMz.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.iMn.setVisibility(0);
            if (!this.iMm.iE()) {
                this.iMm.mT();
                return;
            }
            return;
        }
        this.iMo.setText(R.string.close);
        this.iMn.setVisibility(8);
        if (this.iMm.iE()) {
            this.iMm.mU();
        }
    }

    public void cid() {
        String ans = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ans();
        String ant = com.baidu.tbadk.coreExtra.messageCenter.d.anf().ant();
        this.iMr.setText(ans + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ant);
        this.iMv.setText(ans);
        this.iMx.setText(ant);
    }

    public BdSwitchView cie() {
        return this.iMm.getSwitchView();
    }

    public BdSwitchView cif() {
        return this.iMa.getSwitchView();
    }

    public View cig() {
        return this.iMn;
    }

    public BdSwitchView cih() {
        return this.iMp.getSwitchView();
    }

    public View cii() {
        return this.iMq;
    }

    public LinearLayout cij() {
        return this.iMu;
    }

    public LinearLayout cik() {
        return this.iMw;
    }

    public BdSwitchView cil() {
        return this.iMj.getSwitchView();
    }

    public BdSwitchView cim() {
        return this.iMk.getSwitchView();
    }

    public BdSwitchView cin() {
        return this.iMl.getSwitchView();
    }

    public BdSwitchView cio() {
        return this.iMi.getSwitchView();
    }

    public BdSwitchView cip() {
        return this.iMc.getSwitchView();
    }

    public BdSwitchView ciq() {
        return this.iMd.getSwitchView();
    }

    public BdSwitchView cir() {
        return this.iMe.getSwitchView();
    }

    public BdSwitchView cis() {
        return this.iMg.getSwitchView();
    }

    public BdSwitchView cit() {
        return this.iMh.getSwitchView();
    }

    public BdSwitchView ciu() {
        return this.iMf.getSwitchView();
    }

    public TbSettingTextTipView civ() {
        return this.iMA;
    }

    public void ciw() {
        this.iMc.setOnSwitchStateChangeListener(null);
        this.iMc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anm());
        this.iMc.setOnSwitchStateChangeListener(this.iMz);
    }

    public void cix() {
        this.iMd.setOnSwitchStateChangeListener(null);
        this.iMd.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw());
        this.iMd.setOnSwitchStateChangeListener(this.iMz);
    }

    public void ciy() {
        this.iMe.setOnSwitchStateChangeListener(null);
        this.iMe.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank());
        this.iMe.setOnSwitchStateChangeListener(this.iMz);
    }

    public void ciz() {
        this.iMf.setOnSwitchStateChangeListener(null);
        this.iMf.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anl());
        this.iMf.setOnSwitchStateChangeListener(this.iMz);
    }

    public void ciA() {
        this.iMg.setOnSwitchStateChangeListener(null);
        this.iMg.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().ann());
        this.iMg.setOnSwitchStateChangeListener(this.iMz);
    }

    public void ciB() {
        this.iMh.setOnSwitchStateChangeListener(null);
        this.iMh.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.anf().anv());
        this.iMh.setOnSwitchStateChangeListener(this.iMz);
    }

    public void qs(boolean z) {
        if (this.iMy != z) {
            this.iMy = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.iMz.getString(R.string.msg_remind));
                this.iMs.setVisibility(0);
                this.iMt.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.iMz.getString(R.string.no_disturb_mode_time));
            this.iMt.setVisibility(0);
            this.iMs.setVisibility(8);
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
        this.iMz.getLayoutMode().setNightMode(i == 1);
        this.iMz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMa.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMc.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMd.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMe.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMf.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMg.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMh.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMi.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMj.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMk.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMl.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMm.onChangeSkinType(this.iMz.getPageContext(), i);
        this.iMp.onChangeSkinType(this.iMz.getPageContext(), i);
        al.k(this.iMq, R.drawable.more_all);
        al.k(this.iMu, R.drawable.more_all);
        al.k(this.iMw, R.drawable.more_all);
        al.k(this.iMn, R.drawable.more_all);
        al.c((ImageView) this.iMq.findViewById(R.id.no_disturb_mode_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMn.findViewById(R.id.sign_remind_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMu.findViewById(R.id.no_disturb_start_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
        al.c((ImageView) this.iMw.findViewById(R.id.no_disturb_end_time_arrow), (int) R.drawable.icon_arrow_gray_right_n);
    }

    public void ciC() {
        com.baidu.tbadk.coreExtra.messageCenter.f.anA().b(this.iMz.getActivity(), this.mParent);
    }

    public void onDestroy() {
    }
}
