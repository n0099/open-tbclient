package com.baidu.tieba.setting.more;

import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class g extends com.baidu.adp.base.c<MsgRemindActivity> {
    private LinearLayout ieS;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView mpA;
    private MsgSettingItemView mpB;
    private MsgSettingItemView mpK;
    private LinearLayout mpL;
    private MsgSettingItemView mpM;
    private MsgSettingItemView mpN;
    private MsgSettingItemView mpO;
    private MsgSettingItemView mpP;
    private MsgSettingItemView mpQ;
    private MsgSettingItemView mpR;
    private MsgSettingItemView mpS;
    private MsgSettingItemView mpT;
    private MsgSettingItemView mpU;
    private MsgSettingItemView mpV;
    private MsgSettingItemView mpW;
    private LinearLayout mpX;
    private TextView mpY;
    private MsgSettingItemView mpZ;
    private MsgSettingItemView mpz;
    private LinearLayout mqa;
    private TextView mqb;
    private LinearLayout mqc;
    private LinearLayout mqd;
    private LinearLayout mqe;
    private TextView mqf;
    private LinearLayout mqg;
    private TextView mqh;
    public boolean mqi;
    private MsgRemindActivity mqj;
    private TbSettingTextTipView mqk;
    private View mql;
    private BdSwitchView mqm;
    private View mqn;
    private MsgSettingItemView mqo;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.ieS = null;
        this.mNavigationBar = null;
        this.mqi = true;
        this.mqj = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dyY();
        dzb();
        dza();
        dyZ();
        dzc();
        d(msgRemindActivity);
        dyT();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.ieS = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mqc = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.mqd = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.mpK = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.mpK.setText(R.string.receive_msg_text);
        this.mpK.setLineVisibility(false);
        this.mpL = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.mpM = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.mpM.setText(R.string.reply);
        this.mpN = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.mpN.setVisibility(0);
        this.mpN.setText(R.string.action_praise_default);
        this.mpO = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.mpO.setText(R.string.mention_atme);
        this.mpP = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.mpP.setText(R.string.new_fans);
        this.mpQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.mpQ.setText(R.string.chat_msg_text);
        this.mpR = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.mpR.setLineVisibility(false);
        this.mpR.setText(R.string.group_chat_text);
        this.mpS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.mpS.setText(R.string.remind_screen_lock);
        this.mpS.setLineVisibility(false);
        this.mpT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.mpT.setText(R.string.remind_tone);
        this.mpU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.mpU.setText(R.string.remind_vibrate);
        this.mpV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.mpV.setLineVisibility(true);
        this.mpV.setText(R.string.remind_light);
        this.mpW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.mpW.setText(R.string.sign_remind_outline);
        this.mpX = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.mpY = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.mpZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.mpZ.setText(R.string.no_disturb_mode);
        this.mpZ.setLineVisibility(false);
        this.mqa = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.mqb = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.mqe = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.mqf = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.mqg = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.mqh = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.mqk = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.mql = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.mql.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new aq("c13890").aj("obj_type", areNotificationsEnabled ? 1 : 2));
        this.mqm = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.mqn = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.mqn.setOnClickListener(msgRemindActivity);
        this.mpz = (MsgSettingItemView) this.mqj.findViewById(R.id.item_view_friend_msg);
        this.mpz.setText(R.string.friend_msg_switch);
        this.mpz.setOnSwitchStateChangeListener(this.mqj);
        this.mpA = (MsgSettingItemView) this.mqj.findViewById(R.id.item_view_stranger_msg);
        this.mpA.setText(R.string.stranger_msg_switch);
        this.mpA.setOnSwitchStateChangeListener(this.mqj);
        this.mpA.setLineVisibility(false);
        dyM();
        this.mpB = (MsgSettingItemView) this.mqj.findViewById(R.id.item_view_forum_broadcast_msg);
        this.mpB.setText(R.string.receive_forum_broadcast_message);
        this.mpB.setOnSwitchStateChangeListener(this.mqj);
        this.mpB.setLineVisibility(false);
        dyN();
        this.mqo = (MsgSettingItemView) this.mqj.findViewById(R.id.item_view_tb_selection_msg);
        this.mqo.setText(R.string.official_push_message_switch_text);
        this.mqo.setOnSwitchStateChangeListener(this.mqj);
        this.mqo.setLineVisibility(false);
        dyS();
    }

    private void dyM() {
        if (this.mpz == null || this.mpA == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.mpz.getSwitchView().turnOnNoCallback();
                this.mpz.setLineVisibility(true);
                this.mpA.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.mpz.getSwitchView().turnOffNoCallback();
                this.mpz.setLineVisibility(false);
                this.mpA.setVisibility(8);
                this.mpA.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dyN() {
        if (this.mpB != null) {
            this.mpB.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsw());
        }
    }

    private void dyS() {
        if (this.mqo != null) {
            this.mqo.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsx());
            new OfficialAccountPushModel(new OfficialAccountPushModel.a() { // from class: com.baidu.tieba.setting.more.g.1
                @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.a
                public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
                    boolean z;
                    Iterator<OfficialAccountPushInfo> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        OfficialAccountPushInfo next = it.next();
                        if (next.uid == 1501754229) {
                            z = next.is_on == 1;
                        }
                    }
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsx() != z) {
                        g.this.mqo.setSwitchStateNoCallback(z);
                    }
                }
            }).dzV();
        }
    }

    private void dyT() {
        dyU();
        dyV();
        dyW();
        dyX();
    }

    private void dyU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.mpZ.setVisibility(8);
            this.mqa.setVisibility(8);
            this.mpK.setVisibility(8);
            this.mpL.setVisibility(8);
            this.mpW.setVisibility(8);
            this.mpX.setVisibility(8);
            this.mpT.setVisibility(8);
            this.mpU.setVisibility(8);
            this.mpV.setVisibility(8);
            this.mpS.setVisibility(8);
        }
    }

    private void dyV() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.mpS.setLineVisibility(true);
        } else {
            this.mpS.setLineVisibility(false);
        }
    }

    private void dyW() {
        this.mpQ.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dyX() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View QB() {
        return this.mBack;
    }

    private void dyY() {
        this.mpM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsj());
        this.mpN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bst());
        this.mpO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsh());
        this.mpP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsi());
        this.mpQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsk());
        this.mpR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bss());
    }

    private void dyZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().isSignAlertOn()) {
            this.mpW.turnOn();
            this.mpX.setVisibility(0);
            this.mpW.setLineVisibility(true);
            dzd();
            return;
        }
        this.mpW.turnOff();
        this.mpW.setLineVisibility(false);
        this.mpX.setVisibility(8);
    }

    private void dza() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsl()) {
            this.mpT.turnOnNoCallback();
        } else {
            this.mpT.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bso()) {
            this.mpU.turnOnNoCallback();
        } else {
            this.mpU.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsm()) {
            this.mpV.turnOnNoCallback();
        } else {
            this.mpV.turnOffNoCallback();
        }
    }

    private void dzb() {
    }

    private void dzc() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsn()) {
            this.mpZ.turnOnNoCallback();
            this.mqa.setVisibility(0);
            dze();
            return;
        }
        this.mpZ.turnOffNoCallback();
        this.mqa.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.mpM.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpO.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpN.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpP.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpQ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpR.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mpX.setOnClickListener(msgRemindActivity);
        this.mpZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.mqa.setOnClickListener(msgRemindActivity);
        this.mqe.setOnClickListener(msgRemindActivity);
        this.mqg.setOnClickListener(msgRemindActivity);
        this.mqk.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void wu(boolean z) {
        this.mpZ.setLineVisibility(z);
        if (z) {
            this.mqa.setVisibility(0);
            dze();
            ap.setBackgroundResource(this.mqa, R.drawable.more_all);
            return;
        }
        this.mqa.setVisibility(8);
    }

    public void wv(boolean z) {
        if (z) {
            this.mpX.setVisibility(0);
            this.mpW.setLineVisibility(true);
            ap.setBackgroundResource(this.mpX, R.drawable.more_all);
            return;
        }
        this.mpX.setVisibility(8);
        this.mpW.setLineVisibility(false);
    }

    public void ww(boolean z) {
    }

    public void dzd() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bsc().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bsc().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bsc().getSignAlertMins();
            this.mpY.setText(this.mqj.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.mpX.setVisibility(0);
            if (!this.mpW.isOn()) {
                this.mpW.turnOnNoCallback();
                return;
            }
            return;
        }
        this.mpY.setText(R.string.close);
        this.mpX.setVisibility(8);
        if (this.mpW.isOn()) {
            this.mpW.turnOffNoCallback();
        }
    }

    public void dze() {
        String bsp = com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsp();
        String bsq = com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsq();
        this.mqb.setText(bsp + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bsq);
        this.mqf.setText(bsp);
        this.mqh.setText(bsq);
    }

    public BdSwitchView dzf() {
        return this.mpW.getSwitchView();
    }

    public BdSwitchView dzg() {
        return this.mpK.getSwitchView();
    }

    public View dzh() {
        return this.mpX;
    }

    public BdSwitchView dzi() {
        return this.mpZ.getSwitchView();
    }

    public View dzj() {
        return this.mqa;
    }

    public LinearLayout dzk() {
        return this.mqe;
    }

    public LinearLayout dzl() {
        return this.mqg;
    }

    public BdSwitchView dzm() {
        return this.mpT.getSwitchView();
    }

    public BdSwitchView dzn() {
        return this.mpU.getSwitchView();
    }

    public BdSwitchView dzo() {
        return this.mpV.getSwitchView();
    }

    public BdSwitchView dzp() {
        return this.mpS.getSwitchView();
    }

    public BdSwitchView dzq() {
        return this.mpM.getSwitchView();
    }

    public BdSwitchView dzr() {
        return this.mpN.getSwitchView();
    }

    public BdSwitchView dzs() {
        return this.mpO.getSwitchView();
    }

    public BdSwitchView dzt() {
        return this.mpQ.getSwitchView();
    }

    public BdSwitchView dzu() {
        return this.mpR.getSwitchView();
    }

    public BdSwitchView dzv() {
        return this.mpP.getSwitchView();
    }

    public TbSettingTextTipView dzw() {
        return this.mqk;
    }

    public TextView dzx() {
        return this.mNavigationBar.getCenterText();
    }

    public void dzy() {
        this.mpM.setOnSwitchStateChangeListener(null);
        this.mpM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsj());
        this.mpM.setOnSwitchStateChangeListener(this.mqj);
    }

    public void dzz() {
        this.mpN.setOnSwitchStateChangeListener(null);
        this.mpN.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bst());
        this.mpN.setOnSwitchStateChangeListener(this.mqj);
    }

    public void dzA() {
        this.mpO.setOnSwitchStateChangeListener(null);
        this.mpO.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsh());
        this.mpO.setOnSwitchStateChangeListener(this.mqj);
    }

    public void dzB() {
        this.mpP.setOnSwitchStateChangeListener(null);
        this.mpP.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsi());
        this.mpP.setOnSwitchStateChangeListener(this.mqj);
    }

    public void dzC() {
        this.mpQ.setOnSwitchStateChangeListener(null);
        this.mpQ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bsk());
        this.mpQ.setOnSwitchStateChangeListener(this.mqj);
    }

    public void dzD() {
        this.mpR.setOnSwitchStateChangeListener(null);
        this.mpR.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bsc().bss());
        this.mpR.setOnSwitchStateChangeListener(this.mqj);
    }

    public void wx(boolean z) {
        if (this.mqi != z) {
            this.mqi = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.mqj.getString(R.string.msg_remind));
                this.mqc.setVisibility(0);
                this.mqd.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.mqj.getString(R.string.no_disturb_mode_time));
            this.mqd.setVisibility(0);
            this.mqc.setVisibility(8);
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
    /* JADX DEBUG: Multi-variable search result rejected for r1v35, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v37, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.baidu.tieba.setting.more.MsgRemindActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mqj.getLayoutMode().setNightMode(i == 1);
        this.mqj.getLayoutMode().onModeChanged(this.ieS);
        this.mNavigationBar.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpK.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpM.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpN.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpO.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpP.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpQ.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpR.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpS.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpT.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpU.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpV.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpW.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpZ.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpz.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpA.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mpB.onChangeSkinType(this.mqj.getPageContext(), i);
        this.mqo.onChangeSkinType(this.mqj.getPageContext(), i);
        ap.setBackgroundResource(this.mqa, R.drawable.more_all);
        ap.setBackgroundResource(this.mqe, R.drawable.more_all);
        ap.setBackgroundResource(this.mqg, R.drawable.more_all);
        ap.setBackgroundResource(this.mpX, R.drawable.more_all);
        SvgManager.bmU().a((ImageView) this.mqa.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a((ImageView) this.mpX.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a((ImageView) this.mqe.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bmU().a((ImageView) this.mqg.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dyO() {
        return this.mpz.getSwitchView();
    }

    public BdSwitchView dyP() {
        return this.mpA.getSwitchView();
    }

    public BdSwitchView dyQ() {
        return this.mpB.getSwitchView();
    }

    public BdSwitchView dzE() {
        return this.mqo.getSwitchView();
    }

    public void wt(boolean z) {
        this.mpz.setLineVisibility(z);
    }

    public void ws(boolean z) {
        if (z) {
            this.mpA.setVisibility(0);
        } else {
            this.mpA.setVisibility(8);
        }
    }

    public void dzF() {
        com.baidu.tbadk.coreExtra.messageCenter.f.bsy().a(this.mqj.getActivity(), this.ieS);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mqj).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.mqm.turnOn();
            i = 1;
        } else {
            this.mqm.turnOff();
            i = 2;
        }
        this.mql.setVisibility(areNotificationsEnabled ? 8 : 0);
        rh(areNotificationsEnabled);
        TiebaStatic.log(new aq("c13889").aj("obj_locate", i).aj("obj_source", 8));
    }

    private void rh(boolean z) {
        if (z) {
            this.mpM.getSwitchView().setEnabled(true);
            this.mpN.getSwitchView().setEnabled(true);
            this.mpP.getSwitchView().setEnabled(true);
            this.mpO.getSwitchView().setEnabled(true);
            this.mpz.getSwitchView().setEnabled(true);
            this.mpA.getSwitchView().setEnabled(true);
            this.mpB.getSwitchView().setEnabled(true);
            this.mqo.getSwitchView().setEnabled(true);
            this.mpW.getSwitchView().setEnabled(true);
            this.mpZ.getSwitchView().setEnabled(true);
            this.mpM.getSwitchView().setAlpha(1.0f);
            this.mpN.getSwitchView().setAlpha(1.0f);
            this.mpP.getSwitchView().setAlpha(1.0f);
            this.mpO.getSwitchView().setAlpha(1.0f);
            this.mpz.getSwitchView().setAlpha(1.0f);
            this.mpA.getSwitchView().setAlpha(1.0f);
            this.mpB.getSwitchView().setAlpha(1.0f);
            this.mqo.getSwitchView().setAlpha(1.0f);
            this.mpW.getSwitchView().setAlpha(1.0f);
            this.mpZ.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.mpM.getSwitchView().setEnabled(false);
        this.mpN.getSwitchView().setEnabled(false);
        this.mpP.getSwitchView().setEnabled(false);
        this.mpO.getSwitchView().setEnabled(false);
        this.mpz.getSwitchView().setEnabled(false);
        this.mpA.getSwitchView().setEnabled(false);
        this.mpB.getSwitchView().setEnabled(false);
        this.mqo.getSwitchView().setEnabled(false);
        this.mpW.getSwitchView().setEnabled(false);
        this.mpZ.getSwitchView().setEnabled(false);
        this.mpM.getSwitchView().setAlpha(0.3f);
        this.mpN.getSwitchView().setAlpha(0.3f);
        this.mpP.getSwitchView().setAlpha(0.3f);
        this.mpO.getSwitchView().setAlpha(0.3f);
        this.mpz.getSwitchView().setAlpha(0.3f);
        this.mpA.getSwitchView().setAlpha(0.3f);
        this.mpB.getSwitchView().setAlpha(0.3f);
        this.mqo.getSwitchView().setAlpha(0.3f);
        this.mpW.getSwitchView().setAlpha(0.3f);
        this.mpZ.getSwitchView().setAlpha(0.3f);
    }
}
