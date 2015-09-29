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
    private View LR;
    private BdSwitchView cMA;
    private SettingTextSwitchView cMB;
    private TbSettingTextTipView cMC;
    private TbSettingTextTipView cMD;
    private TbSettingTextTipView cME;
    private TbSettingTextTipView cMF;
    private com.baidu.tbadk.core.dialog.e cMG;
    private com.baidu.tbadk.core.dialog.e cMH;
    private com.baidu.tbadk.core.dialog.e cMI;
    private com.baidu.tbadk.core.dialog.e cMJ;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cMK;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cML;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cMM;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cMN;
    private final BdSwitchView.a cMO;
    private final AdapterView.OnItemClickListener cMP;
    private final AdapterView.OnItemClickListener cMQ;
    private final AdapterView.OnItemClickListener cMR;
    private final AdapterView.OnItemClickListener cMS;
    private BrowseSettingActivity cMx;
    private View cMy;
    private RelativeLayout cMz;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cMx = null;
        this.LR = null;
        this.mNavigationBar = null;
        this.cMy = null;
        this.cMz = null;
        this.cMA = null;
        this.cMB = null;
        this.cMC = null;
        this.cMD = null;
        this.cME = null;
        this.cMF = null;
        this.cMG = null;
        this.cMH = null;
        this.cMI = null;
        this.cMJ = null;
        this.cMO = new m(this);
        this.cMP = new n(this);
        this.cMQ = new o(this);
        this.cMR = new p(this);
        this.cMS = new q(this);
        this.mHandler = new Handler();
        this.cMx = browseSettingActivity;
        initUI();
        uJ();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.cMB.dF(i);
        this.cMx.getLayoutMode().ad(i == 1);
        this.cMx.getLayoutMode().k(this.LR);
        this.cMA.a(com.baidu.tbadk.core.util.am.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.am.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.am.cw(i.e.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView aru() {
        return this.cMD;
    }

    public TbSettingTextTipView arv() {
        return this.cMC;
    }

    public TbSettingTextTipView arw() {
        return this.cME;
    }

    public TbSettingTextTipView arx() {
        return this.cMF;
    }

    public void ary() {
        arD();
        this.cMG.sW();
    }

    public void arz() {
        arC();
        this.cMH.sW();
    }

    public void arA() {
        arE();
        this.cMI.sW();
    }

    public void arB() {
        arF();
        this.cMJ.sW();
    }

    private void initUI() {
        this.cMx.setContentView(i.g.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cMx.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cMx.getPageContext().getString(i.h.browse_setting));
        this.cMz = (RelativeLayout) this.cMx.findViewById(i.f.eyeshield_mode);
        this.cMA = (BdSwitchView) this.cMx.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cMx.getPageContext().getPageActivity(), this.cMA, 10, 10, 10, 10);
        this.cMy = this.cMx.findViewById(i.f.divide_view2);
        this.cMB = (SettingTextSwitchView) this.cMx.findViewById(i.f.img_thrift_setting);
        this.cMC = (TbSettingTextTipView) this.cMx.findViewById(i.f.img_browser);
        this.cMD = (TbSettingTextTipView) this.cMx.findViewById(i.f.img_upload);
        this.cME = (TbSettingTextTipView) this.cMx.findViewById(i.f.show_image);
        this.cMF = (TbSettingTextTipView) this.cMx.findViewById(i.f.font_size);
        this.LR = this.cMx.findViewById(i.f.parent);
        if (!Mz()) {
            this.cMy.setVisibility(8);
            this.cMz.setVisibility(8);
            return;
        }
        this.cMy.setVisibility(0);
        this.cMz.setVisibility(0);
    }

    public boolean Mz() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.cMC.setOnClickListener(this.cMx);
        this.cMD.setOnClickListener(this.cMx);
        this.cMA.setOnSwitchStateChangeListener(this.cMx);
        this.cME.setOnClickListener(this.cMx);
        this.cMF.setOnClickListener(this.cMx);
    }

    private void arC() {
        this.cML = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.qX().getViewImageQuality();
        boolean rb = com.baidu.tbadk.core.m.qX().rb();
        this.cML.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cMx.getPageContext().getString(i.h.view_image_quality_auto_menu_desc), rb && viewImageQuality == 0));
        this.cML.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_high_menu), this.cMx.getPageContext().getString(i.h.view_image_quality_high_menu_desc), rb && viewImageQuality == 1));
        this.cML.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_low_menu), this.cMx.getPageContext().getString(i.h.view_image_quality_low_menu_desc), rb && viewImageQuality == 2));
        this.cML.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_close_menu), this.cMx.getPageContext().getString(i.h.view_image_quality_close_menu_desc), rb ? false : true));
        this.cMH = new com.baidu.tbadk.core.dialog.e(this.cMx.getPageContext());
        this.cMH.bN(i.h.browser_image_quality);
        this.cMH.a(this.cML, this.cMP).sV();
    }

    private void arD() {
        this.cMM = new ArrayList<>();
        int ra = com.baidu.tbadk.core.m.qX().ra();
        this.cMM.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.image_quality_auto_menu), this.cMx.getPageContext().getString(i.h.image_quality_auto_menu_desc), ra == 0));
        this.cMM.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_high_menu), this.cMx.getPageContext().getString(i.h.image_quality_high_menu_desc), ra == 1));
        this.cMM.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.image_quality_mid_menu), this.cMx.getPageContext().getString(i.h.image_quality_mid_menu_desc), ra == 2));
        this.cMM.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_low_menu), this.cMx.getPageContext().getString(i.h.image_quality_low_menu_desc), ra == 3));
        this.cMG = new com.baidu.tbadk.core.dialog.e(this.cMx.getPageContext()).bN(i.h.upload_image_quality);
        this.cMG.a(this.cMM, this.cMQ).sV();
    }

    private void arE() {
        this.cMN = new ArrayList<>();
        int qY = com.baidu.tbadk.core.m.qX().qY();
        this.cMN.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cMx.getPageContext().getString(i.h.is_wifiopen_dialog), qY == 0));
        this.cMN.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.is_alwaysopen), null, qY == 1));
        this.cMN.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.is_close), null, qY == 2));
        this.cMI = new com.baidu.tbadk.core.dialog.e(this.cMx.getPageContext()).bN(i.h.show_photo);
        this.cMI.a(this.cMN, this.cMR).sV();
    }

    private void arF() {
        this.cMJ = new com.baidu.tbadk.core.dialog.e(this.cMx.getPageContext());
        this.cMK = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cMK.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.font_size_big), null, fontSize == 1));
        this.cMK.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.font_size_mid), null, fontSize == 2));
        this.cMK.add(new com.baidu.tbadk.core.dialog.g(this.cMx.getPageContext().getString(i.h.font_size_small), null, fontSize == 3));
        this.cMJ.bN(i.h.font_size);
        this.cMJ.a(this.cMK, this.cMS);
        this.cMJ.sV();
    }

    public void kz(int i) {
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
        com.baidu.tbadk.core.util.c.iv();
    }

    public void uJ() {
        MC();
        arI();
        arJ();
        arL();
        arK();
        fY(false);
    }

    public void arG() {
        arI();
        arJ();
        arK();
    }

    public void MC() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cMA.mB();
        } else {
            this.cMA.mC();
        }
    }

    public void fY(boolean z) {
        this.cMB.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qX().rc()) {
            this.cMB.O(z);
        } else {
            this.cMB.P(z);
        }
        this.cMB.setSwitchStateChangeListener(this.cMO);
    }

    public void arH() {
        fY(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arI() {
        if (!com.baidu.tbadk.core.m.qX().rb()) {
            this.cMC.setTip(this.mContext.getString(i.h.view_close));
        } else if (com.baidu.tbadk.core.m.qX().getViewImageQuality() == 1) {
            this.cMC.setTip(this.mContext.getString(i.h.view_high));
        } else if (com.baidu.tbadk.core.m.qX().getViewImageQuality() == 2) {
            this.cMC.setTip(this.mContext.getString(i.h.view_low));
        } else {
            this.cMC.setTip(this.mContext.getString(i.h.view_auto));
        }
    }

    private void arJ() {
        kA(com.baidu.tbadk.core.m.qX().ra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA(int i) {
        switch (i) {
            case 0:
                this.cMD.setTip(this.mContext.getString(i.h.view_auto));
                return;
            case 1:
                this.cMD.setTip(this.mContext.getString(i.h.view_high));
                return;
            case 2:
                this.cMD.setTip(this.mContext.getString(i.h.view_mid));
                return;
            case 3:
                this.cMD.setTip(this.mContext.getString(i.h.view_low));
                return;
            default:
                return;
        }
    }

    public void arK() {
        switch (com.baidu.tbadk.core.m.qX().qY()) {
            case 0:
                this.cME.setTip(this.mContext.getString(i.h.is_wifiopen));
                return;
            case 1:
                this.cME.setTip(this.mContext.getString(i.h.is_alwaysopen));
                return;
            case 2:
                this.cME.setTip(this.mContext.getString(i.h.is_close));
                return;
            default:
                return;
        }
    }

    public void arL() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cMF.setTip(this.mContext.getString(i.h.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cMF.setTip(this.mContext.getString(i.h.font_size_mid));
        } else {
            this.cMF.setTip(this.mContext.getString(i.h.font_size_small));
        }
    }
}
