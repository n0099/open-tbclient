package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class g extends com.baidu.adp.base.d<MsgRemindActivity> {
    private LinearLayout iYe;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView njK;
    private MsgSettingItemView njL;
    private MsgSettingItemView njM;
    private MsgSettingItemView njV;
    private LinearLayout njW;
    private MsgSettingItemView njX;
    private MsgSettingItemView njY;
    private MsgSettingItemView njZ;
    private MsgSettingItemView nka;
    private MsgSettingItemView nkb;
    private MsgSettingItemView nkc;
    private MsgSettingItemView nkd;
    private MsgSettingItemView nke;
    private MsgSettingItemView nkf;
    private MsgSettingItemView nkg;
    private MsgSettingItemView nkh;
    private LinearLayout nki;
    private TextView nkj;
    private MsgSettingItemView nkk;
    private LinearLayout nkl;
    private TextView nkm;
    private LinearLayout nkn;
    private LinearLayout nko;
    private LinearLayout nkp;
    private TextView nkq;
    private LinearLayout nkr;
    private TextView nks;
    public boolean nkt;
    private MsgRemindActivity nku;
    private TbSettingTextTipView nkv;
    private View nkw;
    private BdSwitchView nkx;
    private View nky;
    private MsgSettingItemView nkz;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iYe = null;
        this.mNavigationBar = null;
        this.nkt = true;
        this.nku = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dHY();
        dIb();
        dIa();
        dHZ();
        dIc();
        d(msgRemindActivity);
        dHT();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iYe = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nkn = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.nko = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.njV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.njV.setText(R.string.receive_msg_text);
        this.njV.setLineVisibility(false);
        this.njW = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.njX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.njX.setText(R.string.reply);
        this.njY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.njY.setVisibility(0);
        this.njY.setText(R.string.action_praise_default);
        this.njZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.njZ.setText(R.string.mention_atme);
        this.nka = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.nka.setText(R.string.new_fans);
        this.nkb = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.nkb.setText(R.string.chat_msg_text);
        this.nkc = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.nkc.setLineVisibility(false);
        this.nkc.setText(R.string.group_chat_text);
        this.nkd = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.nkd.setText(R.string.remind_screen_lock);
        this.nkd.setLineVisibility(false);
        this.nke = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.nke.setText(R.string.remind_tone);
        this.nkf = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.nkf.setText(R.string.remind_vibrate);
        this.nkg = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.nkg.setLineVisibility(true);
        this.nkg.setText(R.string.remind_light);
        this.nkh = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.nkh.setText(R.string.sign_remind_outline);
        this.nki = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.nkj = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.nkk = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.nkk.setText(R.string.no_disturb_mode);
        this.nkk.setLineVisibility(false);
        this.nkl = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.nkm = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.nkp = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.nkq = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.nkr = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.nks = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.nkv = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.nkw = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.nkw.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new ar("c13890").aq("obj_type", areNotificationsEnabled ? 1 : 2));
        this.nkx = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.nky = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.nky.setOnClickListener(msgRemindActivity);
        this.njK = (MsgSettingItemView) this.nku.findViewById(R.id.item_view_friend_msg);
        this.njK.setText(R.string.friend_msg_switch);
        this.njK.setOnSwitchStateChangeListener(this.nku);
        this.njL = (MsgSettingItemView) this.nku.findViewById(R.id.item_view_stranger_msg);
        this.njL.setText(R.string.stranger_msg_switch);
        this.njL.setOnSwitchStateChangeListener(this.nku);
        this.njL.setLineVisibility(false);
        dHM();
        this.njM = (MsgSettingItemView) this.nku.findViewById(R.id.item_view_forum_broadcast_msg);
        this.njM.setText(R.string.receive_forum_broadcast_message);
        this.njM.setOnSwitchStateChangeListener(this.nku);
        this.njM.setLineVisibility(false);
        dHN();
        this.nkz = (MsgSettingItemView) this.nku.findViewById(R.id.item_view_tb_selection_msg);
        this.nkz.setText(R.string.official_push_message_switch_text);
        this.nkz.setOnSwitchStateChangeListener(this.nku);
        this.nkz.setLineVisibility(false);
        dHS();
    }

    private void dHM() {
        if (this.njK == null || this.njL == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.njK.getSwitchView().turnOnNoCallback();
                this.njK.setLineVisibility(true);
                this.njL.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.njK.getSwitchView().turnOffNoCallback();
                this.njK.setLineVisibility(false);
                this.njL.setVisibility(8);
                this.njL.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dHN() {
        if (this.njM != null) {
            this.njM.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byB());
        }
    }

    private void dHS() {
        if (this.nkz != null) {
            this.nkz.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byC());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byC() != z) {
                        g.this.nkz.setSwitchStateNoCallback(z);
                    }
                }
            }).dJf();
        }
    }

    private void dHT() {
        dHU();
        dHV();
        dHW();
        dHX();
    }

    private void dHU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.nkk.setVisibility(8);
            this.nkl.setVisibility(8);
            this.njV.setVisibility(8);
            this.njW.setVisibility(8);
            this.nkh.setVisibility(8);
            this.nki.setVisibility(8);
            this.nke.setVisibility(8);
            this.nkf.setVisibility(8);
            this.nkg.setVisibility(8);
            this.nkd.setVisibility(8);
        }
    }

    private void dHV() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.nkd.setLineVisibility(true);
        } else {
            this.nkd.setLineVisibility(false);
        }
    }

    private void dHW() {
        this.nkb.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dHX() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View UP() {
        return this.mBack;
    }

    private void dHY() {
        this.njX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byo());
        this.njY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byy());
        this.njZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().bym());
        this.nka.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byn());
        this.nkb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byp());
        this.nkc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byx());
    }

    private void dHZ() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().isSignAlertOn()) {
            this.nkh.turnOn();
            this.nki.setVisibility(0);
            this.nkh.setLineVisibility(true);
            dId();
            return;
        }
        this.nkh.turnOff();
        this.nkh.setLineVisibility(false);
        this.nki.setVisibility(8);
    }

    private void dIa() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byq()) {
            this.nke.turnOnNoCallback();
        } else {
            this.nke.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byt()) {
            this.nkf.turnOnNoCallback();
        } else {
            this.nkf.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().byr()) {
            this.nkg.turnOnNoCallback();
        } else {
            this.nkg.turnOffNoCallback();
        }
    }

    private void dIb() {
    }

    private void dIc() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().bys()) {
            this.nkk.turnOnNoCallback();
            this.nkl.setVisibility(0);
            dIe();
            return;
        }
        this.nkk.turnOffNoCallback();
        this.nkl.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.njX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.njZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.njY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nka.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkb.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkc.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkd.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nke.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkf.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkg.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkh.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nki.setOnClickListener(msgRemindActivity);
        this.nkk.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nkl.setOnClickListener(msgRemindActivity);
        this.nkp.setOnClickListener(msgRemindActivity);
        this.nkr.setOnClickListener(msgRemindActivity);
        this.nkv.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xR(boolean z) {
        this.nkk.setLineVisibility(z);
        if (z) {
            this.nkl.setVisibility(0);
            dIe();
            ap.setBackgroundResource(this.nkl, R.drawable.more_all);
            return;
        }
        this.nkl.setVisibility(8);
    }

    public void xS(boolean z) {
        if (z) {
            this.nki.setVisibility(0);
            this.nkh.setLineVisibility(true);
            ap.setBackgroundResource(this.nki, R.drawable.more_all);
            return;
        }
        this.nki.setVisibility(8);
        this.nkh.setLineVisibility(false);
    }

    public void xT(boolean z) {
    }

    public void dId() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.byh().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.byh().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.byh().getSignAlertMins();
            this.nkj.setText(this.nku.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.nki.setVisibility(0);
            if (!this.nkh.isOn()) {
                this.nkh.turnOnNoCallback();
                return;
            }
            return;
        }
        this.nkj.setText(R.string.close);
        this.nki.setVisibility(8);
        if (this.nkh.isOn()) {
            this.nkh.turnOffNoCallback();
        }
    }

    public void dIe() {
        String byu = com.baidu.tbadk.coreExtra.messageCenter.d.byh().byu();
        String byv = com.baidu.tbadk.coreExtra.messageCenter.d.byh().byv();
        this.nkm.setText(byu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + byv);
        this.nkq.setText(byu);
        this.nks.setText(byv);
    }

    public BdSwitchView dIf() {
        return this.nkh.getSwitchView();
    }

    public BdSwitchView dIg() {
        return this.njV.getSwitchView();
    }

    public View dIh() {
        return this.nki;
    }

    public BdSwitchView dIi() {
        return this.nkk.getSwitchView();
    }

    public View dIj() {
        return this.nkl;
    }

    public LinearLayout dIk() {
        return this.nkp;
    }

    public LinearLayout dIl() {
        return this.nkr;
    }

    public BdSwitchView dIm() {
        return this.nke.getSwitchView();
    }

    public BdSwitchView dIn() {
        return this.nkf.getSwitchView();
    }

    public BdSwitchView dIo() {
        return this.nkg.getSwitchView();
    }

    public BdSwitchView dIp() {
        return this.nkd.getSwitchView();
    }

    public BdSwitchView dIq() {
        return this.njX.getSwitchView();
    }

    public BdSwitchView dIr() {
        return this.njY.getSwitchView();
    }

    public BdSwitchView dIs() {
        return this.njZ.getSwitchView();
    }

    public BdSwitchView dIt() {
        return this.nkb.getSwitchView();
    }

    public BdSwitchView dIu() {
        return this.nkc.getSwitchView();
    }

    public BdSwitchView dIv() {
        return this.nka.getSwitchView();
    }

    public TbSettingTextTipView dIw() {
        return this.nkv;
    }

    public TextView dIx() {
        return this.mNavigationBar.getCenterText();
    }

    public void dIy() {
        this.njX.setOnSwitchStateChangeListener(null);
        this.njX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byo());
        this.njX.setOnSwitchStateChangeListener(this.nku);
    }

    public void dIz() {
        this.njY.setOnSwitchStateChangeListener(null);
        this.njY.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byy());
        this.njY.setOnSwitchStateChangeListener(this.nku);
    }

    public void dIA() {
        this.njZ.setOnSwitchStateChangeListener(null);
        this.njZ.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().bym());
        this.njZ.setOnSwitchStateChangeListener(this.nku);
    }

    public void dIB() {
        this.nka.setOnSwitchStateChangeListener(null);
        this.nka.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byn());
        this.nka.setOnSwitchStateChangeListener(this.nku);
    }

    public void dIC() {
        this.nkb.setOnSwitchStateChangeListener(null);
        this.nkb.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byp());
        this.nkb.setOnSwitchStateChangeListener(this.nku);
    }

    public void dID() {
        this.nkc.setOnSwitchStateChangeListener(null);
        this.nkc.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.byh().byx());
        this.nkc.setOnSwitchStateChangeListener(this.nku);
    }

    public void xU(boolean z) {
        if (this.nkt != z) {
            this.nkt = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.nku.getString(R.string.msg_remind));
                this.nkn.setVisibility(0);
                this.nko.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.nku.getString(R.string.no_disturb_mode_time));
            this.nko.setVisibility(0);
            this.nkn.setVisibility(8);
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
        this.nku.getLayoutMode().setNightMode(i == 1);
        this.nku.getLayoutMode().onModeChanged(this.iYe);
        this.mNavigationBar.onChangeSkinType(this.nku.getPageContext(), i);
        this.njV.onChangeSkinType(this.nku.getPageContext(), i);
        this.njX.onChangeSkinType(this.nku.getPageContext(), i);
        this.njY.onChangeSkinType(this.nku.getPageContext(), i);
        this.njZ.onChangeSkinType(this.nku.getPageContext(), i);
        this.nka.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkb.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkc.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkd.onChangeSkinType(this.nku.getPageContext(), i);
        this.nke.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkf.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkg.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkh.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkk.onChangeSkinType(this.nku.getPageContext(), i);
        this.njK.onChangeSkinType(this.nku.getPageContext(), i);
        this.njL.onChangeSkinType(this.nku.getPageContext(), i);
        this.njM.onChangeSkinType(this.nku.getPageContext(), i);
        this.nkz.onChangeSkinType(this.nku.getPageContext(), i);
        ap.setBackgroundResource(this.nkl, R.drawable.more_all);
        ap.setBackgroundResource(this.nkp, R.drawable.more_all);
        ap.setBackgroundResource(this.nkr, R.drawable.more_all);
        ap.setBackgroundResource(this.nki, R.drawable.more_all);
        SvgManager.bsU().a((ImageView) this.nkl.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a((ImageView) this.nki.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a((ImageView) this.nkp.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsU().a((ImageView) this.nkr.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dHO() {
        return this.njK.getSwitchView();
    }

    public BdSwitchView dHP() {
        return this.njL.getSwitchView();
    }

    public BdSwitchView dHQ() {
        return this.njM.getSwitchView();
    }

    public BdSwitchView dIE() {
        return this.nkz.getSwitchView();
    }

    public void xQ(boolean z) {
        this.njK.setLineVisibility(z);
    }

    public void xP(boolean z) {
        if (z) {
            this.njL.setVisibility(0);
        } else {
            this.njL.setVisibility(8);
        }
    }

    public void dIF() {
        com.baidu.tbadk.coreExtra.messageCenter.f.byD().a(this.nku.getActivity(), this.iYe);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.nku).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.nkx.turnOn();
            i = 1;
        } else {
            this.nkx.turnOff();
            i = 2;
        }
        this.nkw.setVisibility(areNotificationsEnabled ? 8 : 0);
        xV(areNotificationsEnabled);
        TiebaStatic.log(new ar("c13889").aq("obj_locate", i).aq("obj_source", 8));
    }

    private void xV(boolean z) {
        if (z) {
            this.njX.getSwitchView().setEnabled(true);
            this.njY.getSwitchView().setEnabled(true);
            this.nka.getSwitchView().setEnabled(true);
            this.njZ.getSwitchView().setEnabled(true);
            this.njK.getSwitchView().setEnabled(true);
            this.njL.getSwitchView().setEnabled(true);
            this.njM.getSwitchView().setEnabled(true);
            this.nkz.getSwitchView().setEnabled(true);
            this.nkh.getSwitchView().setEnabled(true);
            this.nkk.getSwitchView().setEnabled(true);
            this.njX.getSwitchView().setAlpha(1.0f);
            this.njY.getSwitchView().setAlpha(1.0f);
            this.nka.getSwitchView().setAlpha(1.0f);
            this.njZ.getSwitchView().setAlpha(1.0f);
            this.njK.getSwitchView().setAlpha(1.0f);
            this.njL.getSwitchView().setAlpha(1.0f);
            this.njM.getSwitchView().setAlpha(1.0f);
            this.nkz.getSwitchView().setAlpha(1.0f);
            this.nkh.getSwitchView().setAlpha(1.0f);
            this.nkk.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.njX.getSwitchView().setEnabled(false);
        this.njY.getSwitchView().setEnabled(false);
        this.nka.getSwitchView().setEnabled(false);
        this.njZ.getSwitchView().setEnabled(false);
        this.njK.getSwitchView().setEnabled(false);
        this.njL.getSwitchView().setEnabled(false);
        this.njM.getSwitchView().setEnabled(false);
        this.nkz.getSwitchView().setEnabled(false);
        this.nkh.getSwitchView().setEnabled(false);
        this.nkk.getSwitchView().setEnabled(false);
        this.njX.getSwitchView().setAlpha(0.3f);
        this.njY.getSwitchView().setAlpha(0.3f);
        this.nka.getSwitchView().setAlpha(0.3f);
        this.njZ.getSwitchView().setAlpha(0.3f);
        this.njK.getSwitchView().setAlpha(0.3f);
        this.njL.getSwitchView().setAlpha(0.3f);
        this.njM.getSwitchView().setAlpha(0.3f);
        this.nkz.getSwitchView().setAlpha(0.3f);
        this.nkh.getSwitchView().setAlpha(0.3f);
        this.nkk.getSwitchView().setAlpha(0.3f);
    }
}
