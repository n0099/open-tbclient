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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<BrowseSettingActivity> {
    private View LT;
    private TbSettingTextTipView cOA;
    private com.baidu.tbadk.core.dialog.e cOB;
    private com.baidu.tbadk.core.dialog.e cOC;
    private com.baidu.tbadk.core.dialog.e cOD;
    private com.baidu.tbadk.core.dialog.e cOE;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cOF;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cOG;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cOH;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cOI;
    private final BdSwitchView.a cOJ;
    private final AdapterView.OnItemClickListener cOK;
    private final AdapterView.OnItemClickListener cOL;
    private final AdapterView.OnItemClickListener cOM;
    private final AdapterView.OnItemClickListener cON;
    private BrowseSettingActivity cOs;
    private View cOt;
    private RelativeLayout cOu;
    private BdSwitchView cOv;
    private SettingTextSwitchView cOw;
    private TbSettingTextTipView cOx;
    private TbSettingTextTipView cOy;
    private TbSettingTextTipView cOz;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cOs = null;
        this.LT = null;
        this.mNavigationBar = null;
        this.cOt = null;
        this.cOu = null;
        this.cOv = null;
        this.cOw = null;
        this.cOx = null;
        this.cOy = null;
        this.cOz = null;
        this.cOA = null;
        this.cOB = null;
        this.cOC = null;
        this.cOD = null;
        this.cOE = null;
        this.cOJ = new m(this);
        this.cOK = new n(this);
        this.cOL = new o(this);
        this.cOM = new p(this);
        this.cON = new q(this);
        this.mHandler = new Handler();
        this.cOs = browseSettingActivity;
        initUI();
        uL();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.cOw.dF(i);
        this.cOs.getLayoutMode().ad(i == 1);
        this.cOs.getLayoutMode().k(this.LT);
        this.cOv.a(com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.an.cw(i.e.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView asc() {
        return this.cOy;
    }

    public TbSettingTextTipView asd() {
        return this.cOx;
    }

    public TbSettingTextTipView ase() {
        return this.cOz;
    }

    public TbSettingTextTipView asf() {
        return this.cOA;
    }

    public void asg() {
        asl();
        this.cOB.sW();
    }

    public void ash() {
        ask();
        this.cOC.sW();
    }

    public void asi() {
        asm();
        this.cOD.sW();
    }

    public void asj() {
        asn();
        this.cOE.sW();
    }

    private void initUI() {
        this.cOs.setContentView(i.g.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cOs.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cOs.getPageContext().getString(i.h.browse_setting));
        this.cOu = (RelativeLayout) this.cOs.findViewById(i.f.eyeshield_mode);
        this.cOv = (BdSwitchView) this.cOs.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cOs.getPageContext().getPageActivity(), this.cOv, 10, 10, 10, 10);
        this.cOt = this.cOs.findViewById(i.f.divide_view2);
        this.cOw = (SettingTextSwitchView) this.cOs.findViewById(i.f.img_thrift_setting);
        this.cOx = (TbSettingTextTipView) this.cOs.findViewById(i.f.img_browser);
        this.cOy = (TbSettingTextTipView) this.cOs.findViewById(i.f.img_upload);
        this.cOz = (TbSettingTextTipView) this.cOs.findViewById(i.f.show_image);
        this.cOA = (TbSettingTextTipView) this.cOs.findViewById(i.f.font_size);
        this.LT = this.cOs.findViewById(i.f.parent);
        if (!ML()) {
            this.cOt.setVisibility(8);
            this.cOu.setVisibility(8);
            return;
        }
        this.cOt.setVisibility(0);
        this.cOu.setVisibility(0);
    }

    public boolean ML() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.cOx.setOnClickListener(this.cOs);
        this.cOy.setOnClickListener(this.cOs);
        this.cOv.setOnSwitchStateChangeListener(this.cOs);
        this.cOz.setOnClickListener(this.cOs);
        this.cOA.setOnClickListener(this.cOs);
    }

    private void ask() {
        this.cOG = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.qV().getViewImageQuality();
        boolean qZ = com.baidu.tbadk.core.m.qV().qZ();
        this.cOG.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cOs.getPageContext().getString(i.h.view_image_quality_auto_menu_desc), qZ && viewImageQuality == 0));
        this.cOG.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_high_menu), this.cOs.getPageContext().getString(i.h.view_image_quality_high_menu_desc), qZ && viewImageQuality == 1));
        this.cOG.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_low_menu), this.cOs.getPageContext().getString(i.h.view_image_quality_low_menu_desc), qZ && viewImageQuality == 2));
        this.cOG.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_close_menu), this.cOs.getPageContext().getString(i.h.view_image_quality_close_menu_desc), qZ ? false : true));
        this.cOC = new com.baidu.tbadk.core.dialog.e(this.cOs.getPageContext());
        this.cOC.bN(i.h.browser_image_quality);
        this.cOC.a(this.cOG, this.cOK).sV();
    }

    private void asl() {
        this.cOH = new ArrayList<>();
        int qY = com.baidu.tbadk.core.m.qV().qY();
        this.cOH.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.image_quality_auto_menu), this.cOs.getPageContext().getString(i.h.image_quality_auto_menu_desc), qY == 0));
        this.cOH.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_high_menu), this.cOs.getPageContext().getString(i.h.image_quality_high_menu_desc), qY == 1));
        this.cOH.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.image_quality_mid_menu), this.cOs.getPageContext().getString(i.h.image_quality_mid_menu_desc), qY == 2));
        this.cOH.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_low_menu), this.cOs.getPageContext().getString(i.h.image_quality_low_menu_desc), qY == 3));
        this.cOB = new com.baidu.tbadk.core.dialog.e(this.cOs.getPageContext()).bN(i.h.upload_image_quality);
        this.cOB.a(this.cOH, this.cOL).sV();
    }

    private void asm() {
        this.cOI = new ArrayList<>();
        int qW = com.baidu.tbadk.core.m.qV().qW();
        this.cOI.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cOs.getPageContext().getString(i.h.is_wifiopen_dialog), qW == 0));
        this.cOI.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.is_alwaysopen), null, qW == 1));
        this.cOI.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.is_close), null, qW == 2));
        this.cOD = new com.baidu.tbadk.core.dialog.e(this.cOs.getPageContext()).bN(i.h.show_photo);
        this.cOD.a(this.cOI, this.cOM).sV();
    }

    private void asn() {
        this.cOE = new com.baidu.tbadk.core.dialog.e(this.cOs.getPageContext());
        this.cOF = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cOF.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.font_size_big), null, fontSize == 1));
        this.cOF.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.font_size_mid), null, fontSize == 2));
        this.cOF.add(new com.baidu.tbadk.core.dialog.g(this.cOs.getPageContext().getString(i.h.font_size_small), null, fontSize == 3));
        this.cOE.bN(i.h.font_size);
        this.cOE.a(this.cOF, this.cON);
        this.cOE.sV();
    }

    public void kP(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.c.iw();
    }

    public void uL() {
        MO();
        asq();
        asr();
        ast();
        ass();
        gb(false);
    }

    public void aso() {
        asq();
        asr();
        ass();
    }

    public void MO() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cOv.mC();
        } else {
            this.cOv.mD();
        }
    }

    public void gb(boolean z) {
        this.cOw.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qV().ra()) {
            this.cOw.O(z);
        } else {
            this.cOw.P(z);
        }
        this.cOw.setSwitchStateChangeListener(this.cOJ);
    }

    public void asp() {
        gb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asq() {
        if (!com.baidu.tbadk.core.m.qV().qZ()) {
            this.cOx.setTip(this.mContext.getString(i.h.view_close));
        } else if (com.baidu.tbadk.core.m.qV().getViewImageQuality() == 1) {
            this.cOx.setTip(this.mContext.getString(i.h.view_high));
        } else if (com.baidu.tbadk.core.m.qV().getViewImageQuality() == 2) {
            this.cOx.setTip(this.mContext.getString(i.h.view_low));
        } else {
            this.cOx.setTip(this.mContext.getString(i.h.view_auto));
        }
    }

    private void asr() {
        kQ(com.baidu.tbadk.core.m.qV().qY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kQ(int i) {
        switch (i) {
            case 0:
                this.cOy.setTip(this.mContext.getString(i.h.view_auto));
                return;
            case 1:
                this.cOy.setTip(this.mContext.getString(i.h.view_high));
                return;
            case 2:
                this.cOy.setTip(this.mContext.getString(i.h.view_mid));
                return;
            case 3:
                this.cOy.setTip(this.mContext.getString(i.h.view_low));
                return;
            default:
                return;
        }
    }

    public void ass() {
        switch (com.baidu.tbadk.core.m.qV().qW()) {
            case 0:
                this.cOz.setTip(this.mContext.getString(i.h.is_wifiopen));
                return;
            case 1:
                this.cOz.setTip(this.mContext.getString(i.h.is_alwaysopen));
                return;
            case 2:
                this.cOz.setTip(this.mContext.getString(i.h.is_close));
                return;
            default:
                return;
        }
    }

    public void ast() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cOA.setTip(this.mContext.getString(i.h.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cOA.setTip(this.mContext.getString(i.h.font_size_mid));
        } else {
            this.cOA.setTip(this.mContext.getString(i.h.font_size_small));
        }
    }
}
