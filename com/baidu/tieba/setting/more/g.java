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
/* loaded from: classes8.dex */
public class g extends com.baidu.adp.base.d<MsgRemindActivity> {
    private LinearLayout iWv;
    private View mBack;
    private NavigationBar mNavigationBar;
    private MsgSettingItemView nhF;
    private MsgSettingItemView nhG;
    private MsgSettingItemView nhH;
    private MsgSettingItemView nhQ;
    private LinearLayout nhR;
    private MsgSettingItemView nhS;
    private MsgSettingItemView nhT;
    private MsgSettingItemView nhU;
    private MsgSettingItemView nhV;
    private MsgSettingItemView nhW;
    private MsgSettingItemView nhX;
    private MsgSettingItemView nhY;
    private MsgSettingItemView nhZ;
    private MsgSettingItemView nia;
    private MsgSettingItemView nib;
    private MsgSettingItemView nic;
    private LinearLayout nie;
    private TextView nif;
    private MsgSettingItemView nig;
    private LinearLayout nih;
    private TextView nii;
    private LinearLayout nij;
    private LinearLayout nik;
    private LinearLayout nil;
    private TextView nim;
    private LinearLayout nin;
    private TextView nio;
    public boolean nip;
    private MsgRemindActivity niq;
    private TbSettingTextTipView nir;
    private View nis;
    private BdSwitchView nit;
    private View niu;
    private MsgSettingItemView niv;

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.iWv = null;
        this.mNavigationBar = null;
        this.nip = true;
        this.niq = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public void b(MsgRemindActivity msgRemindActivity) {
        c(msgRemindActivity);
        dHQ();
        dHT();
        dHS();
        dHR();
        dHU();
        d(msgRemindActivity);
        dHL();
    }

    void c(MsgRemindActivity msgRemindActivity) {
        this.iWv = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nij = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.nik = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        this.nhQ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.nhQ.setText(R.string.receive_msg_text);
        this.nhQ.setLineVisibility(false);
        this.nhR = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        this.nhS = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.nhS.setText(R.string.reply);
        this.nhT = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.nhT.setVisibility(0);
        this.nhT.setText(R.string.action_praise_default);
        this.nhU = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.nhU.setText(R.string.mention_atme);
        this.nhV = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.nhV.setText(R.string.new_fans);
        this.nhW = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.nhW.setText(R.string.chat_msg_text);
        this.nhX = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.nhX.setLineVisibility(false);
        this.nhX.setText(R.string.group_chat_text);
        this.nhY = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.nhY.setText(R.string.remind_screen_lock);
        this.nhY.setLineVisibility(false);
        this.nhZ = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
        this.nhZ.setText(R.string.remind_tone);
        this.nia = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
        this.nia.setText(R.string.remind_vibrate);
        this.nib = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
        this.nib.setLineVisibility(true);
        this.nib.setText(R.string.remind_light);
        this.nic = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
        this.nic.setText(R.string.sign_remind_outline);
        this.nie = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
        this.nif = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
        this.nig = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
        this.nig.setText(R.string.no_disturb_mode);
        this.nig.setLineVisibility(false);
        this.nih = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
        this.nii = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
        this.nil = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
        this.nim = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
        this.nin = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
        this.nio = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
        this.nir = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
        this.nis = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
        boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
        this.nis.setVisibility(areNotificationsEnabled ? 8 : 0);
        TiebaStatic.log(new ar("c13890").ap("obj_type", areNotificationsEnabled ? 1 : 2));
        this.nit = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
        this.niu = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
        this.niu.setOnClickListener(msgRemindActivity);
        this.nhF = (MsgSettingItemView) this.niq.findViewById(R.id.item_view_friend_msg);
        this.nhF.setText(R.string.friend_msg_switch);
        this.nhF.setOnSwitchStateChangeListener(this.niq);
        this.nhG = (MsgSettingItemView) this.niq.findViewById(R.id.item_view_stranger_msg);
        this.nhG.setText(R.string.stranger_msg_switch);
        this.nhG.setOnSwitchStateChangeListener(this.niq);
        this.nhG.setLineVisibility(false);
        dHE();
        this.nhH = (MsgSettingItemView) this.niq.findViewById(R.id.item_view_forum_broadcast_msg);
        this.nhH.setText(R.string.receive_forum_broadcast_message);
        this.nhH.setOnSwitchStateChangeListener(this.niq);
        this.nhH.setLineVisibility(false);
        dHF();
        this.niv = (MsgSettingItemView) this.niq.findViewById(R.id.item_view_tb_selection_msg);
        this.niv.setText(R.string.official_push_message_switch_text);
        this.niv.setOnSwitchStateChangeListener(this.niq);
        this.niv.setLineVisibility(false);
        dHK();
    }

    private void dHE() {
        if (this.nhF == null || this.nhG == null) {
            return;
        }
        switch (GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) {
            case 0:
                return;
            case 1:
                this.nhF.getSwitchView().turnOnNoCallback();
                this.nhF.setLineVisibility(true);
                this.nhG.getSwitchView().turnOffNoCallback();
                return;
            default:
                this.nhF.getSwitchView().turnOffNoCallback();
                this.nhF.setLineVisibility(false);
                this.nhG.setVisibility(8);
                this.nhG.getSwitchView().turnOffNoCallback();
                return;
        }
    }

    private void dHF() {
        if (this.nhH != null) {
            this.nhH.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byy());
        }
    }

    private void dHK() {
        if (this.niv != null) {
            this.niv.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byz());
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
                    if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byz() != z) {
                        g.this.niv.setSwitchStateNoCallback(z);
                    }
                }
            }).dIX();
        }
    }

    private void dHL() {
        dHM();
        dHN();
        dHO();
        dHP();
    }

    private void dHM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.nig.setVisibility(8);
            this.nih.setVisibility(8);
            this.nhQ.setVisibility(8);
            this.nhR.setVisibility(8);
            this.nic.setVisibility(8);
            this.nie.setVisibility(8);
            this.nhZ.setVisibility(8);
            this.nia.setVisibility(8);
            this.nib.setVisibility(8);
            this.nhY.setVisibility(8);
        }
    }

    private void dHN() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.nhY.setLineVisibility(true);
        } else {
            this.nhY.setLineVisibility(false);
        }
    }

    private void dHO() {
        this.nhW.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    private void dHP() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public View UM() {
        return this.mBack;
    }

    private void dHQ() {
        this.nhS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byl());
        this.nhT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byv());
        this.nhU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byj());
        this.nhV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byk());
        this.nhW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().bym());
        this.nhX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byu());
    }

    private void dHR() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().isSignAlertOn()) {
            this.nic.turnOn();
            this.nie.setVisibility(0);
            this.nic.setLineVisibility(true);
            dHV();
            return;
        }
        this.nic.turnOff();
        this.nic.setLineVisibility(false);
        this.nie.setVisibility(8);
    }

    private void dHS() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byn()) {
            this.nhZ.turnOnNoCallback();
        } else {
            this.nhZ.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byq()) {
            this.nia.turnOnNoCallback();
        } else {
            this.nia.turnOffNoCallback();
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byo()) {
            this.nib.turnOnNoCallback();
        } else {
            this.nib.turnOffNoCallback();
        }
    }

    private void dHT() {
    }

    private void dHU() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().byp()) {
            this.nig.turnOnNoCallback();
            this.nih.setVisibility(0);
            dHW();
            return;
        }
        this.nig.turnOffNoCallback();
        this.nih.setVisibility(8);
    }

    private void d(MsgRemindActivity msgRemindActivity) {
        this.mBack.setOnClickListener(msgRemindActivity);
        this.nhS.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhU.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhT.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhV.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhW.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhX.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhY.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nhZ.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nia.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nib.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nic.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nie.setOnClickListener(msgRemindActivity);
        this.nig.setOnSwitchStateChangeListener(msgRemindActivity);
        this.nih.setOnClickListener(msgRemindActivity);
        this.nil.setOnClickListener(msgRemindActivity);
        this.nin.setOnClickListener(msgRemindActivity);
        this.nir.setOnClickListener(msgRemindActivity);
        this.mNavigationBar.getCenterText().setOnClickListener(msgRemindActivity);
    }

    public void xR(boolean z) {
        this.nig.setLineVisibility(z);
        if (z) {
            this.nih.setVisibility(0);
            dHW();
            ap.setBackgroundResource(this.nih, R.drawable.more_all);
            return;
        }
        this.nih.setVisibility(8);
    }

    public void xS(boolean z) {
        if (z) {
            this.nie.setVisibility(0);
            this.nic.setLineVisibility(true);
            ap.setBackgroundResource(this.nie, R.drawable.more_all);
            return;
        }
        this.nie.setVisibility(8);
        this.nic.setLineVisibility(false);
    }

    public void xT(boolean z) {
    }

    public void dHV() {
        if (com.baidu.tbadk.coreExtra.messageCenter.d.bye().isSignAlertOn()) {
            int signAlertHours = com.baidu.tbadk.coreExtra.messageCenter.d.bye().getSignAlertHours();
            int signAlertMins = com.baidu.tbadk.coreExtra.messageCenter.d.bye().getSignAlertMins();
            this.nif.setText(this.niq.getString(R.string.sign_remind_time, new Object[]{signAlertHours > 9 ? String.valueOf(signAlertHours) : "0" + signAlertHours, signAlertMins > 9 ? String.valueOf(signAlertMins) : "0" + signAlertMins}));
            this.nie.setVisibility(0);
            if (!this.nic.isOn()) {
                this.nic.turnOnNoCallback();
                return;
            }
            return;
        }
        this.nif.setText(R.string.close);
        this.nie.setVisibility(8);
        if (this.nic.isOn()) {
            this.nic.turnOffNoCallback();
        }
    }

    public void dHW() {
        String byr = com.baidu.tbadk.coreExtra.messageCenter.d.bye().byr();
        String bys = com.baidu.tbadk.coreExtra.messageCenter.d.bye().bys();
        this.nii.setText(byr + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bys);
        this.nim.setText(byr);
        this.nio.setText(bys);
    }

    public BdSwitchView dHX() {
        return this.nic.getSwitchView();
    }

    public BdSwitchView dHY() {
        return this.nhQ.getSwitchView();
    }

    public View dHZ() {
        return this.nie;
    }

    public BdSwitchView dIa() {
        return this.nig.getSwitchView();
    }

    public View dIb() {
        return this.nih;
    }

    public LinearLayout dIc() {
        return this.nil;
    }

    public LinearLayout dId() {
        return this.nin;
    }

    public BdSwitchView dIe() {
        return this.nhZ.getSwitchView();
    }

    public BdSwitchView dIf() {
        return this.nia.getSwitchView();
    }

    public BdSwitchView dIg() {
        return this.nib.getSwitchView();
    }

    public BdSwitchView dIh() {
        return this.nhY.getSwitchView();
    }

    public BdSwitchView dIi() {
        return this.nhS.getSwitchView();
    }

    public BdSwitchView dIj() {
        return this.nhT.getSwitchView();
    }

    public BdSwitchView dIk() {
        return this.nhU.getSwitchView();
    }

    public BdSwitchView dIl() {
        return this.nhW.getSwitchView();
    }

    public BdSwitchView dIm() {
        return this.nhX.getSwitchView();
    }

    public BdSwitchView dIn() {
        return this.nhV.getSwitchView();
    }

    public TbSettingTextTipView dIo() {
        return this.nir;
    }

    public TextView dIp() {
        return this.mNavigationBar.getCenterText();
    }

    public void dIq() {
        this.nhS.setOnSwitchStateChangeListener(null);
        this.nhS.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byl());
        this.nhS.setOnSwitchStateChangeListener(this.niq);
    }

    public void dIr() {
        this.nhT.setOnSwitchStateChangeListener(null);
        this.nhT.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byv());
        this.nhT.setOnSwitchStateChangeListener(this.niq);
    }

    public void dIs() {
        this.nhU.setOnSwitchStateChangeListener(null);
        this.nhU.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byj());
        this.nhU.setOnSwitchStateChangeListener(this.niq);
    }

    public void dIt() {
        this.nhV.setOnSwitchStateChangeListener(null);
        this.nhV.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byk());
        this.nhV.setOnSwitchStateChangeListener(this.niq);
    }

    public void dIu() {
        this.nhW.setOnSwitchStateChangeListener(null);
        this.nhW.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().bym());
        this.nhW.setOnSwitchStateChangeListener(this.niq);
    }

    public void dIv() {
        this.nhX.setOnSwitchStateChangeListener(null);
        this.nhX.setSwitchStateNoCallback(com.baidu.tbadk.coreExtra.messageCenter.d.bye().byu());
        this.nhX.setOnSwitchStateChangeListener(this.niq);
    }

    public void xU(boolean z) {
        if (this.nip != z) {
            this.nip = z;
            if (z) {
                this.mNavigationBar.setCenterTextTitle(this.niq.getString(R.string.msg_remind));
                this.nij.setVisibility(0);
                this.nik.setVisibility(8);
                return;
            }
            this.mNavigationBar.setCenterTextTitle(this.niq.getString(R.string.no_disturb_mode_time));
            this.nik.setVisibility(0);
            this.nij.setVisibility(8);
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
        this.niq.getLayoutMode().setNightMode(i == 1);
        this.niq.getLayoutMode().onModeChanged(this.iWv);
        this.mNavigationBar.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhQ.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhS.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhT.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhU.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhV.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhW.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhX.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhY.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhZ.onChangeSkinType(this.niq.getPageContext(), i);
        this.nia.onChangeSkinType(this.niq.getPageContext(), i);
        this.nib.onChangeSkinType(this.niq.getPageContext(), i);
        this.nic.onChangeSkinType(this.niq.getPageContext(), i);
        this.nig.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhF.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhG.onChangeSkinType(this.niq.getPageContext(), i);
        this.nhH.onChangeSkinType(this.niq.getPageContext(), i);
        this.niv.onChangeSkinType(this.niq.getPageContext(), i);
        ap.setBackgroundResource(this.nih, R.drawable.more_all);
        ap.setBackgroundResource(this.nil, R.drawable.more_all);
        ap.setBackgroundResource(this.nin, R.drawable.more_all);
        ap.setBackgroundResource(this.nie, R.drawable.more_all);
        SvgManager.bsR().a((ImageView) this.nih.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a((ImageView) this.nie.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a((ImageView) this.nil.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.bsR().a((ImageView) this.nin.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public BdSwitchView dHG() {
        return this.nhF.getSwitchView();
    }

    public BdSwitchView dHH() {
        return this.nhG.getSwitchView();
    }

    public BdSwitchView dHI() {
        return this.nhH.getSwitchView();
    }

    public BdSwitchView dIw() {
        return this.niv.getSwitchView();
    }

    public void xQ(boolean z) {
        this.nhF.setLineVisibility(z);
    }

    public void xP(boolean z) {
        if (z) {
            this.nhG.setVisibility(0);
        } else {
            this.nhG.setVisibility(8);
        }
    }

    public void dIx() {
        com.baidu.tbadk.coreExtra.messageCenter.f.byA().a(this.niq.getActivity(), this.iWv);
    }

    public void onDestroy() {
    }

    public void onResume() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.niq).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.nit.turnOn();
            i = 1;
        } else {
            this.nit.turnOff();
            i = 2;
        }
        this.nis.setVisibility(areNotificationsEnabled ? 8 : 0);
        xV(areNotificationsEnabled);
        TiebaStatic.log(new ar("c13889").ap("obj_locate", i).ap("obj_source", 8));
    }

    private void xV(boolean z) {
        if (z) {
            this.nhS.getSwitchView().setEnabled(true);
            this.nhT.getSwitchView().setEnabled(true);
            this.nhV.getSwitchView().setEnabled(true);
            this.nhU.getSwitchView().setEnabled(true);
            this.nhF.getSwitchView().setEnabled(true);
            this.nhG.getSwitchView().setEnabled(true);
            this.nhH.getSwitchView().setEnabled(true);
            this.niv.getSwitchView().setEnabled(true);
            this.nic.getSwitchView().setEnabled(true);
            this.nig.getSwitchView().setEnabled(true);
            this.nhS.getSwitchView().setAlpha(1.0f);
            this.nhT.getSwitchView().setAlpha(1.0f);
            this.nhV.getSwitchView().setAlpha(1.0f);
            this.nhU.getSwitchView().setAlpha(1.0f);
            this.nhF.getSwitchView().setAlpha(1.0f);
            this.nhG.getSwitchView().setAlpha(1.0f);
            this.nhH.getSwitchView().setAlpha(1.0f);
            this.niv.getSwitchView().setAlpha(1.0f);
            this.nic.getSwitchView().setAlpha(1.0f);
            this.nig.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.nhS.getSwitchView().setEnabled(false);
        this.nhT.getSwitchView().setEnabled(false);
        this.nhV.getSwitchView().setEnabled(false);
        this.nhU.getSwitchView().setEnabled(false);
        this.nhF.getSwitchView().setEnabled(false);
        this.nhG.getSwitchView().setEnabled(false);
        this.nhH.getSwitchView().setEnabled(false);
        this.niv.getSwitchView().setEnabled(false);
        this.nic.getSwitchView().setEnabled(false);
        this.nig.getSwitchView().setEnabled(false);
        this.nhS.getSwitchView().setAlpha(0.3f);
        this.nhT.getSwitchView().setAlpha(0.3f);
        this.nhV.getSwitchView().setAlpha(0.3f);
        this.nhU.getSwitchView().setAlpha(0.3f);
        this.nhF.getSwitchView().setAlpha(0.3f);
        this.nhG.getSwitchView().setAlpha(0.3f);
        this.nhH.getSwitchView().setAlpha(0.3f);
        this.niv.getSwitchView().setAlpha(0.3f);
        this.nic.getSwitchView().setAlpha(0.3f);
        this.nig.getSwitchView().setAlpha(0.3f);
    }
}
