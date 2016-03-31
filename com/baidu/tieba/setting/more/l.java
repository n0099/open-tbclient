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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f<BrowseSettingActivity> {
    private View MW;
    private TbSettingTextTipView ecA;
    private TbSettingTextTipView ecB;
    private TbSettingTextTipView ecC;
    private com.baidu.tbadk.core.dialog.f ecD;
    private com.baidu.tbadk.core.dialog.f ecE;
    private com.baidu.tbadk.core.dialog.f ecF;
    private com.baidu.tbadk.core.dialog.f ecG;
    private com.baidu.tbadk.core.dialog.f ecH;
    private ArrayList<com.baidu.tbadk.core.dialog.h> ecI;
    private ArrayList<com.baidu.tbadk.core.dialog.h> ecJ;
    private ArrayList<com.baidu.tbadk.core.dialog.h> ecK;
    private ArrayList<com.baidu.tbadk.core.dialog.h> ecL;
    private ArrayList<com.baidu.tbadk.core.dialog.h> ecM;
    private final BdSwitchView.a ecN;
    private final AdapterView.OnItemClickListener ecO;
    private final AdapterView.OnItemClickListener ecP;
    private final AdapterView.OnItemClickListener ecQ;
    private final AdapterView.OnItemClickListener ecR;
    private final AdapterView.OnItemClickListener ecS;
    private BrowseSettingActivity ect;
    private View ecu;
    private RelativeLayout ecv;
    private BdSwitchView ecw;
    private SettingTextSwitchView ecx;
    private TbSettingTextTipView ecy;
    private TbSettingTextTipView ecz;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ect = null;
        this.MW = null;
        this.mNavigationBar = null;
        this.ecu = null;
        this.ecv = null;
        this.ecw = null;
        this.ecx = null;
        this.ecy = null;
        this.ecz = null;
        this.ecA = null;
        this.ecB = null;
        this.ecC = null;
        this.ecD = null;
        this.ecE = null;
        this.ecF = null;
        this.ecG = null;
        this.ecH = null;
        this.ecN = new m(this);
        this.ecO = new n(this);
        this.ecP = new o(this);
        this.ecQ = new p(this);
        this.ecR = new q(this);
        this.ecS = new r(this);
        this.mHandler = new Handler();
        this.ect = browseSettingActivity;
        pU();
        wA();
        pf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ecx.em(i);
        this.ect.getLayoutMode().ab(i == 1);
        this.ect.getLayoutMode().x(this.MW);
        this.ecw.a(com.baidu.tbadk.core.util.at.cR(t.f.bg_switch_open), com.baidu.tbadk.core.util.at.cR(t.f.bg_switch_close), com.baidu.tbadk.core.util.at.cR(t.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView aNx() {
        return this.ecA;
    }

    public TbSettingTextTipView aNy() {
        return this.ecz;
    }

    public TbSettingTextTipView aNz() {
        return this.ecy;
    }

    public TbSettingTextTipView aNA() {
        return this.ecB;
    }

    public TbSettingTextTipView aNB() {
        return this.ecC;
    }

    public void aNC() {
        aNJ();
        this.ecF.uu();
    }

    public void aND() {
        aNI();
        this.ecD.uu();
    }

    public void aNE() {
        aNH();
        this.ecE.uu();
    }

    public void aNF() {
        aNK();
        this.ecG.uu();
    }

    public void aNG() {
        aNL();
        this.ecH.uu();
    }

    private void pU() {
        this.ect.setContentView(t.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ect.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ect.getPageContext().getString(t.j.browse_setting));
        this.ecv = (RelativeLayout) this.ect.findViewById(t.g.eyeshield_mode);
        this.ecw = (BdSwitchView) this.ect.findViewById(t.g.item_switch);
        com.baidu.adp.lib.util.k.a(this.ect.getPageContext().getPageActivity(), this.ecw, 10, 10, 10, 10);
        this.ecu = this.ect.findViewById(t.g.divide_view2);
        this.ecx = (SettingTextSwitchView) this.ect.findViewById(t.g.img_thrift_setting);
        this.ecy = (TbSettingTextTipView) this.ect.findViewById(t.g.img_browser);
        this.ecz = (TbSettingTextTipView) this.ect.findViewById(t.g.img_upload);
        this.ecA = (TbSettingTextTipView) this.ect.findViewById(t.g.add_img_water);
        this.ecB = (TbSettingTextTipView) this.ect.findViewById(t.g.show_image);
        this.ecC = (TbSettingTextTipView) this.ect.findViewById(t.g.font_size);
        this.MW = this.ect.findViewById(t.g.parent);
        if (!Sx()) {
            this.ecu.setVisibility(8);
            this.ecv.setVisibility(8);
            return;
        }
        this.ecu.setVisibility(0);
        this.ecv.setVisibility(0);
    }

    public boolean Sx() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void pf() {
        this.ecy.setOnClickListener(this.ect);
        this.ecz.setOnClickListener(this.ect);
        this.ecA.setOnClickListener(this.ect);
        this.ecw.setOnSwitchStateChangeListener(this.ect);
        this.ecB.setOnClickListener(this.ect);
        this.ecC.setOnClickListener(this.ect);
    }

    private void aNH() {
        this.ecJ = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.l.qE().getViewImageQuality();
        boolean qK = com.baidu.tbadk.core.l.qE().qK();
        this.ecJ.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_auto_menu), this.ect.getPageContext().getString(t.j.view_image_quality_auto_menu_desc), qK && viewImageQuality == 0));
        this.ecJ.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_high_menu), this.ect.getPageContext().getString(t.j.view_image_quality_high_menu_desc), qK && viewImageQuality == 1));
        this.ecJ.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_low_menu), this.ect.getPageContext().getString(t.j.view_image_quality_low_menu_desc), qK && viewImageQuality == 2));
        this.ecJ.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_close_menu), this.ect.getPageContext().getString(t.j.view_image_quality_close_menu_desc), qK ? false : true));
        this.ecE = new com.baidu.tbadk.core.dialog.f(this.ect.getPageContext());
        this.ecE.cj(t.j.browser_image_quality);
        this.ecE.a(this.ecJ, this.ecO).ut();
    }

    private void aNI() {
        this.ecK = new ArrayList<>();
        int qH = com.baidu.tbadk.core.l.qE().qH();
        this.ecK.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.image_quality_auto_menu), this.ect.getPageContext().getString(t.j.image_quality_auto_menu_desc), qH == 0));
        this.ecK.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_high_menu), this.ect.getPageContext().getString(t.j.image_quality_high_menu_desc), qH == 1));
        this.ecK.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.image_quality_mid_menu), this.ect.getPageContext().getString(t.j.image_quality_mid_menu_desc), qH == 2));
        this.ecK.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_low_menu), this.ect.getPageContext().getString(t.j.image_quality_low_menu_desc), qH == 3));
        this.ecD = new com.baidu.tbadk.core.dialog.f(this.ect.getPageContext()).cj(t.j.upload_image_quality);
        this.ecD.a(this.ecK, this.ecP).ut();
    }

    private void aNJ() {
        this.ecM = new ArrayList<>();
        int qI = com.baidu.tbadk.core.l.qE().qI();
        this.ecM.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.image_water_show_user_name), null, qI == 1));
        this.ecM.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.image_water_show_forum_name), null, qI == 2));
        this.ecM.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.image_water_show_none), null, qI == 0));
        this.ecF = new com.baidu.tbadk.core.dialog.f(this.ect.getPageContext()).cj(t.j.add_image_water);
        this.ecF.a(this.ecM, this.ecQ).ut();
    }

    private void aNK() {
        this.ecL = new ArrayList<>();
        int qF = com.baidu.tbadk.core.l.qE().qF();
        this.ecL.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.view_image_quality_auto_menu), this.ect.getPageContext().getString(t.j.is_wifiopen_dialog), qF == 0));
        this.ecL.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.is_alwaysopen), null, qF == 1));
        this.ecL.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.is_close), null, qF == 2));
        this.ecG = new com.baidu.tbadk.core.dialog.f(this.ect.getPageContext()).cj(t.j.show_photo);
        this.ecG.a(this.ecL, this.ecR).ut();
    }

    private void aNL() {
        this.ecH = new com.baidu.tbadk.core.dialog.f(this.ect.getPageContext());
        this.ecI = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.ecI.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.font_size_big), null, fontSize == 1));
        this.ecI.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.font_size_mid), null, fontSize == 2));
        this.ecI.add(new com.baidu.tbadk.core.dialog.h(this.ect.getPageContext().getString(t.j.font_size_small), null, fontSize == 3));
        this.ecH.cj(t.j.font_size);
        this.ecH.a(this.ecI, this.ecS);
        this.ecH.ut();
    }

    public void oQ(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10647").ac("obj_type", "1"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10647").ac("obj_type", "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void wA() {
        SA();
        aNO();
        aNP();
        aNQ();
        aNS();
        aNR();
        in(false);
    }

    public void aNM() {
        aNO();
        aNP();
        aNQ();
        aNR();
    }

    public void SA() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.ecw.mk();
        } else {
            this.ecw.ml();
        }
    }

    public void in(boolean z) {
        this.ecx.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.qE().qL()) {
            this.ecx.K(z);
        } else {
            this.ecx.L(z);
        }
        this.ecx.setSwitchStateChangeListener(this.ecN);
    }

    public void aNN() {
        in(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNO() {
        if (!com.baidu.tbadk.core.l.qE().qK()) {
            this.ecy.setTip(this.mContext.getString(t.j.view_close));
        } else if (com.baidu.tbadk.core.l.qE().getViewImageQuality() == 1) {
            this.ecy.setTip(this.mContext.getString(t.j.view_high));
        } else if (com.baidu.tbadk.core.l.qE().getViewImageQuality() == 2) {
            this.ecy.setTip(this.mContext.getString(t.j.view_low));
        } else {
            this.ecy.setTip(this.mContext.getString(t.j.view_auto));
        }
    }

    private void aNP() {
        oR(com.baidu.tbadk.core.l.qE().qH());
    }

    private void aNQ() {
        oS(com.baidu.tbadk.core.l.qE().qI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oR(int i) {
        switch (i) {
            case 0:
                this.ecz.setTip(this.mContext.getString(t.j.view_auto));
                return;
            case 1:
                this.ecz.setTip(this.mContext.getString(t.j.view_high));
                return;
            case 2:
                this.ecz.setTip(this.mContext.getString(t.j.view_mid));
                return;
            case 3:
                this.ecz.setTip(this.mContext.getString(t.j.view_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(int i) {
        switch (i) {
            case 0:
                this.ecA.setTip(this.mContext.getString(t.j.image_water_show_none));
                return;
            case 1:
                this.ecA.setTip(this.mContext.getString(t.j.image_water_show_user_name));
                return;
            case 2:
                this.ecA.setTip(this.mContext.getString(t.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void aNR() {
        switch (com.baidu.tbadk.core.l.qE().qF()) {
            case 0:
                this.ecB.setTip(this.mContext.getString(t.j.is_wifiopen));
                return;
            case 1:
                this.ecB.setTip(this.mContext.getString(t.j.is_alwaysopen));
                return;
            case 2:
                this.ecB.setTip(this.mContext.getString(t.j.is_close));
                return;
            default:
                return;
        }
    }

    public void aNS() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.ecC.setTip(this.mContext.getString(t.j.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.ecC.setTip(this.mContext.getString(t.j.font_size_mid));
        } else {
            this.ecC.setTip(this.mContext.getString(t.j.font_size_small));
        }
    }
}
