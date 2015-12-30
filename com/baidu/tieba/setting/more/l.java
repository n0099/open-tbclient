package com.baidu.tieba.setting.more;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<BrowseSettingActivity> {
    private View MA;
    private BrowseSettingActivity dtV;
    private View dtW;
    private RelativeLayout dtX;
    private BdSwitchView dtY;
    private SettingTextSwitchView dtZ;
    private TbSettingTextTipView dua;
    private TbSettingTextTipView dub;
    private TbSettingTextTipView duc;
    private TbSettingTextTipView dud;
    private TbSettingTextTipView due;
    private com.baidu.tbadk.core.dialog.e duf;
    private com.baidu.tbadk.core.dialog.e dug;
    private com.baidu.tbadk.core.dialog.e duh;
    private com.baidu.tbadk.core.dialog.e dui;
    private com.baidu.tbadk.core.dialog.e duj;
    private ArrayList<com.baidu.tbadk.core.dialog.g> duk;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dul;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dum;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dun;
    private ArrayList<com.baidu.tbadk.core.dialog.g> duo;
    private final BdSwitchView.a dup;
    private final AdapterView.OnItemClickListener duq;
    private final AdapterView.OnItemClickListener dur;
    private final AdapterView.OnItemClickListener dus;
    private final AdapterView.OnItemClickListener dut;
    private final AdapterView.OnItemClickListener duu;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.dtV = null;
        this.MA = null;
        this.mNavigationBar = null;
        this.dtW = null;
        this.dtX = null;
        this.dtY = null;
        this.dtZ = null;
        this.dua = null;
        this.dub = null;
        this.duc = null;
        this.dud = null;
        this.due = null;
        this.duf = null;
        this.dug = null;
        this.duh = null;
        this.dui = null;
        this.duj = null;
        this.dup = new m(this);
        this.duq = new n(this);
        this.dur = new o(this);
        this.dus = new p(this);
        this.dut = new q(this);
        this.duu = new r(this);
        this.mHandler = new Handler();
        this.dtV = browseSettingActivity;
        initUI();
        vb();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.dtZ.dO(i);
        this.dtV.getLayoutMode().ac(i == 1);
        this.dtV.getLayoutMode().k(this.MA);
        this.dtY.a(com.baidu.tbadk.core.util.as.cx(n.f.bg_switch_open), com.baidu.tbadk.core.util.as.cx(n.f.bg_switch_close), com.baidu.tbadk.core.util.as.cx(n.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView azG() {
        return this.duc;
    }

    public TbSettingTextTipView azH() {
        return this.dub;
    }

    public TbSettingTextTipView azI() {
        return this.dua;
    }

    public TbSettingTextTipView azJ() {
        return this.dud;
    }

    public TbSettingTextTipView azK() {
        return this.due;
    }

    public void azL() {
        azS();
        this.duh.tl();
    }

    public void azM() {
        azR();
        this.duf.tl();
    }

    public void azN() {
        azQ();
        this.dug.tl();
    }

    public void azO() {
        azT();
        this.dui.tl();
    }

    public void azP() {
        azU();
        this.duj.tl();
    }

    private void initUI() {
        this.dtV.setContentView(n.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.dtV.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dtV.getPageContext().getString(n.j.browse_setting));
        this.dtX = (RelativeLayout) this.dtV.findViewById(n.g.eyeshield_mode);
        this.dtY = (BdSwitchView) this.dtV.findViewById(n.g.item_switch);
        com.baidu.adp.lib.util.k.a(this.dtV.getPageContext().getPageActivity(), this.dtY, 10, 10, 10, 10);
        this.dtW = this.dtV.findViewById(n.g.divide_view2);
        this.dtZ = (SettingTextSwitchView) this.dtV.findViewById(n.g.img_thrift_setting);
        this.dua = (TbSettingTextTipView) this.dtV.findViewById(n.g.img_browser);
        this.dub = (TbSettingTextTipView) this.dtV.findViewById(n.g.img_upload);
        this.duc = (TbSettingTextTipView) this.dtV.findViewById(n.g.add_img_water);
        this.dud = (TbSettingTextTipView) this.dtV.findViewById(n.g.show_image);
        this.due = (TbSettingTextTipView) this.dtV.findViewById(n.g.font_size);
        this.MA = this.dtV.findViewById(n.g.parent);
        if (!OC()) {
            this.dtW.setVisibility(8);
            this.dtX.setVisibility(8);
            return;
        }
        this.dtW.setVisibility(0);
        this.dtX.setVisibility(0);
    }

    public boolean OC() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.dua.setOnClickListener(this.dtV);
        this.dub.setOnClickListener(this.dtV);
        this.duc.setOnClickListener(this.dtV);
        this.dtY.setOnSwitchStateChangeListener(this.dtV);
        this.dud.setOnClickListener(this.dtV);
        this.due.setOnClickListener(this.dtV);
    }

    private void azQ() {
        this.dul = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.qQ().getViewImageQuality();
        boolean qW = com.baidu.tbadk.core.m.qQ().qW();
        this.dul.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_auto_menu), this.dtV.getPageContext().getString(n.j.view_image_quality_auto_menu_desc), qW && viewImageQuality == 0));
        this.dul.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_high_menu), this.dtV.getPageContext().getString(n.j.view_image_quality_high_menu_desc), qW && viewImageQuality == 1));
        this.dul.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_low_menu), this.dtV.getPageContext().getString(n.j.view_image_quality_low_menu_desc), qW && viewImageQuality == 2));
        this.dul.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_close_menu), this.dtV.getPageContext().getString(n.j.view_image_quality_close_menu_desc), qW ? false : true));
        this.dug = new com.baidu.tbadk.core.dialog.e(this.dtV.getPageContext());
        this.dug.bO(n.j.browser_image_quality);
        this.dug.a(this.dul, this.duq).tk();
    }

    private void azR() {
        this.dum = new ArrayList<>();
        int qT = com.baidu.tbadk.core.m.qQ().qT();
        this.dum.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.image_quality_auto_menu), this.dtV.getPageContext().getString(n.j.image_quality_auto_menu_desc), qT == 0));
        this.dum.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_high_menu), this.dtV.getPageContext().getString(n.j.image_quality_high_menu_desc), qT == 1));
        this.dum.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.image_quality_mid_menu), this.dtV.getPageContext().getString(n.j.image_quality_mid_menu_desc), qT == 2));
        this.dum.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_low_menu), this.dtV.getPageContext().getString(n.j.image_quality_low_menu_desc), qT == 3));
        this.duf = new com.baidu.tbadk.core.dialog.e(this.dtV.getPageContext()).bO(n.j.upload_image_quality);
        this.duf.a(this.dum, this.dur).tk();
    }

    private void azS() {
        this.duo = new ArrayList<>();
        int qU = com.baidu.tbadk.core.m.qQ().qU();
        this.duo.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.image_water_show_user_name), null, qU == 1));
        this.duo.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.image_water_show_forum_name), null, qU == 2));
        this.duo.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.image_water_show_none), null, qU == 0));
        this.duh = new com.baidu.tbadk.core.dialog.e(this.dtV.getPageContext()).bO(n.j.add_image_water);
        this.duh.a(this.duo, this.dus).tk();
    }

    private void azT() {
        this.dun = new ArrayList<>();
        int qR = com.baidu.tbadk.core.m.qQ().qR();
        this.dun.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.view_image_quality_auto_menu), this.dtV.getPageContext().getString(n.j.is_wifiopen_dialog), qR == 0));
        this.dun.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.is_alwaysopen), null, qR == 1));
        this.dun.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.is_close), null, qR == 2));
        this.dui = new com.baidu.tbadk.core.dialog.e(this.dtV.getPageContext()).bO(n.j.show_photo);
        this.dui.a(this.dun, this.dut).tk();
    }

    private void azU() {
        this.duj = new com.baidu.tbadk.core.dialog.e(this.dtV.getPageContext());
        this.duk = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.duk.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.font_size_big), null, fontSize == 1));
        this.duk.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.font_size_mid), null, fontSize == 2));
        this.duk.add(new com.baidu.tbadk.core.dialog.g(this.dtV.getPageContext().getString(n.j.font_size_small), null, fontSize == 3));
        this.duj.bO(n.j.font_size);
        this.duj.a(this.duk, this.duu);
        this.duj.tk();
    }

    public void mz(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10647").aa("obj_type", "1"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10647").aa("obj_type", "0"));
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.c.iy();
    }

    public void vb() {
        OF();
        azX();
        azY();
        azZ();
        aAb();
        aAa();
        gZ(false);
    }

    public void azV() {
        azX();
        azY();
        azZ();
        aAa();
    }

    public void OF() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.dtY.me();
        } else {
            this.dtY.mf();
        }
    }

    public void gZ(boolean z) {
        this.dtZ.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qQ().qX()) {
            this.dtZ.L(z);
        } else {
            this.dtZ.M(z);
        }
        this.dtZ.setSwitchStateChangeListener(this.dup);
    }

    public void azW() {
        gZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azX() {
        if (!com.baidu.tbadk.core.m.qQ().qW()) {
            this.dua.setTip(this.mContext.getString(n.j.view_close));
        } else if (com.baidu.tbadk.core.m.qQ().getViewImageQuality() == 1) {
            this.dua.setTip(this.mContext.getString(n.j.view_high));
        } else if (com.baidu.tbadk.core.m.qQ().getViewImageQuality() == 2) {
            this.dua.setTip(this.mContext.getString(n.j.view_low));
        } else {
            this.dua.setTip(this.mContext.getString(n.j.view_auto));
        }
    }

    private void azY() {
        mA(com.baidu.tbadk.core.m.qQ().qT());
    }

    private void azZ() {
        mB(com.baidu.tbadk.core.m.qQ().qU());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(int i) {
        switch (i) {
            case 0:
                this.dub.setTip(this.mContext.getString(n.j.view_auto));
                return;
            case 1:
                this.dub.setTip(this.mContext.getString(n.j.view_high));
                return;
            case 2:
                this.dub.setTip(this.mContext.getString(n.j.view_mid));
                return;
            case 3:
                this.dub.setTip(this.mContext.getString(n.j.view_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mB(int i) {
        switch (i) {
            case 0:
                this.duc.setTip(this.mContext.getString(n.j.image_water_show_none));
                return;
            case 1:
                this.duc.setTip(this.mContext.getString(n.j.image_water_show_user_name));
                return;
            case 2:
                this.duc.setTip(this.mContext.getString(n.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void aAa() {
        switch (com.baidu.tbadk.core.m.qQ().qR()) {
            case 0:
                this.dud.setTip(this.mContext.getString(n.j.is_wifiopen));
                return;
            case 1:
                this.dud.setTip(this.mContext.getString(n.j.is_alwaysopen));
                return;
            case 2:
                this.dud.setTip(this.mContext.getString(n.j.is_close));
                return;
            default:
                return;
        }
    }

    public void aAb() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.due.setTip(this.mContext.getString(n.j.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.due.setTip(this.mContext.getString(n.j.font_size_mid));
        } else {
            this.due.setTip(this.mContext.getString(n.j.font_size_small));
        }
    }
}
