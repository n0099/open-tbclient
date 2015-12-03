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
    private View Mk;
    private BrowseSettingActivity dmJ;
    private View dmK;
    private RelativeLayout dmL;
    private BdSwitchView dmM;
    private SettingTextSwitchView dmN;
    private TbSettingTextTipView dmO;
    private TbSettingTextTipView dmP;
    private TbSettingTextTipView dmQ;
    private TbSettingTextTipView dmR;
    private TbSettingTextTipView dmS;
    private com.baidu.tbadk.core.dialog.e dmT;
    private com.baidu.tbadk.core.dialog.e dmU;
    private com.baidu.tbadk.core.dialog.e dmV;
    private com.baidu.tbadk.core.dialog.e dmW;
    private com.baidu.tbadk.core.dialog.e dmX;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dmY;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dmZ;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dna;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dnb;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dnc;
    private final BdSwitchView.a dnd;
    private final AdapterView.OnItemClickListener dne;
    private final AdapterView.OnItemClickListener dnf;
    private final AdapterView.OnItemClickListener dng;
    private final AdapterView.OnItemClickListener dnh;
    private final AdapterView.OnItemClickListener dni;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.dmJ = null;
        this.Mk = null;
        this.mNavigationBar = null;
        this.dmK = null;
        this.dmL = null;
        this.dmM = null;
        this.dmN = null;
        this.dmO = null;
        this.dmP = null;
        this.dmQ = null;
        this.dmR = null;
        this.dmS = null;
        this.dmT = null;
        this.dmU = null;
        this.dmV = null;
        this.dmW = null;
        this.dmX = null;
        this.dnd = new m(this);
        this.dne = new n(this);
        this.dnf = new o(this);
        this.dng = new p(this);
        this.dnh = new q(this);
        this.dni = new r(this);
        this.mHandler = new Handler();
        this.dmJ = browseSettingActivity;
        initUI();
        vr();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.dmN.dU(i);
        this.dmJ.getLayoutMode().af(i == 1);
        this.dmJ.getLayoutMode().k(this.Mk);
        this.dmM.a(com.baidu.tbadk.core.util.as.cE(n.e.bg_switch_open), com.baidu.tbadk.core.util.as.cE(n.e.bg_switch_close), com.baidu.tbadk.core.util.as.cE(n.e.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView axA() {
        return this.dmQ;
    }

    public TbSettingTextTipView axB() {
        return this.dmP;
    }

    public TbSettingTextTipView axC() {
        return this.dmO;
    }

    public TbSettingTextTipView axD() {
        return this.dmR;
    }

    public TbSettingTextTipView axE() {
        return this.dmS;
    }

    public void axF() {
        axM();
        this.dmV.tB();
    }

    public void axG() {
        axL();
        this.dmT.tB();
    }

    public void axH() {
        axK();
        this.dmU.tB();
    }

    public void axI() {
        axN();
        this.dmW.tB();
    }

    public void axJ() {
        axO();
        this.dmX.tB();
    }

    private void initUI() {
        this.dmJ.setContentView(n.g.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.dmJ.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dmJ.getPageContext().getString(n.i.browse_setting));
        this.dmL = (RelativeLayout) this.dmJ.findViewById(n.f.eyeshield_mode);
        this.dmM = (BdSwitchView) this.dmJ.findViewById(n.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.dmJ.getPageContext().getPageActivity(), this.dmM, 10, 10, 10, 10);
        this.dmK = this.dmJ.findViewById(n.f.divide_view2);
        this.dmN = (SettingTextSwitchView) this.dmJ.findViewById(n.f.img_thrift_setting);
        this.dmO = (TbSettingTextTipView) this.dmJ.findViewById(n.f.img_browser);
        this.dmP = (TbSettingTextTipView) this.dmJ.findViewById(n.f.img_upload);
        this.dmQ = (TbSettingTextTipView) this.dmJ.findViewById(n.f.add_img_water);
        this.dmR = (TbSettingTextTipView) this.dmJ.findViewById(n.f.show_image);
        this.dmS = (TbSettingTextTipView) this.dmJ.findViewById(n.f.font_size);
        this.Mk = this.dmJ.findViewById(n.f.parent);
        if (!Ok()) {
            this.dmK.setVisibility(8);
            this.dmL.setVisibility(8);
            return;
        }
        this.dmK.setVisibility(0);
        this.dmL.setVisibility(0);
    }

    public boolean Ok() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.dmO.setOnClickListener(this.dmJ);
        this.dmP.setOnClickListener(this.dmJ);
        this.dmQ.setOnClickListener(this.dmJ);
        this.dmM.setOnSwitchStateChangeListener(this.dmJ);
        this.dmR.setOnClickListener(this.dmJ);
        this.dmS.setOnClickListener(this.dmJ);
    }

    private void axK() {
        this.dmZ = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.rh().getViewImageQuality();
        boolean rn = com.baidu.tbadk.core.m.rh().rn();
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_auto_menu), this.dmJ.getPageContext().getString(n.i.view_image_quality_auto_menu_desc), rn && viewImageQuality == 0));
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_high_menu), this.dmJ.getPageContext().getString(n.i.view_image_quality_high_menu_desc), rn && viewImageQuality == 1));
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_low_menu), this.dmJ.getPageContext().getString(n.i.view_image_quality_low_menu_desc), rn && viewImageQuality == 2));
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_close_menu), this.dmJ.getPageContext().getString(n.i.view_image_quality_close_menu_desc), rn ? false : true));
        this.dmU = new com.baidu.tbadk.core.dialog.e(this.dmJ.getPageContext());
        this.dmU.bV(n.i.browser_image_quality);
        this.dmU.a(this.dmZ, this.dne).tA();
    }

    private void axL() {
        this.dna = new ArrayList<>();
        int rk = com.baidu.tbadk.core.m.rh().rk();
        this.dna.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.image_quality_auto_menu), this.dmJ.getPageContext().getString(n.i.image_quality_auto_menu_desc), rk == 0));
        this.dna.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_high_menu), this.dmJ.getPageContext().getString(n.i.image_quality_high_menu_desc), rk == 1));
        this.dna.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.image_quality_mid_menu), this.dmJ.getPageContext().getString(n.i.image_quality_mid_menu_desc), rk == 2));
        this.dna.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_low_menu), this.dmJ.getPageContext().getString(n.i.image_quality_low_menu_desc), rk == 3));
        this.dmT = new com.baidu.tbadk.core.dialog.e(this.dmJ.getPageContext()).bV(n.i.upload_image_quality);
        this.dmT.a(this.dna, this.dnf).tA();
    }

    private void axM() {
        this.dnc = new ArrayList<>();
        int rl = com.baidu.tbadk.core.m.rh().rl();
        this.dnc.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.image_water_show_user_name), null, rl == 1));
        this.dnc.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.image_water_show_forum_name), null, rl == 2));
        this.dnc.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.image_water_show_none), null, rl == 0));
        this.dmV = new com.baidu.tbadk.core.dialog.e(this.dmJ.getPageContext()).bV(n.i.add_image_water);
        this.dmV.a(this.dnc, this.dng).tA();
    }

    private void axN() {
        this.dnb = new ArrayList<>();
        int ri = com.baidu.tbadk.core.m.rh().ri();
        this.dnb.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.view_image_quality_auto_menu), this.dmJ.getPageContext().getString(n.i.is_wifiopen_dialog), ri == 0));
        this.dnb.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.is_alwaysopen), null, ri == 1));
        this.dnb.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.is_close), null, ri == 2));
        this.dmW = new com.baidu.tbadk.core.dialog.e(this.dmJ.getPageContext()).bV(n.i.show_photo);
        this.dmW.a(this.dnb, this.dnh).tA();
    }

    private void axO() {
        this.dmX = new com.baidu.tbadk.core.dialog.e(this.dmJ.getPageContext());
        this.dmY = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.dmY.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.font_size_big), null, fontSize == 1));
        this.dmY.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.font_size_mid), null, fontSize == 2));
        this.dmY.add(new com.baidu.tbadk.core.dialog.g(this.dmJ.getPageContext().getString(n.i.font_size_small), null, fontSize == 3));
        this.dmX.bV(n.i.font_size);
        this.dmX.a(this.dmY, this.dni);
        this.dmX.tA();
    }

    public void lX(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10647").ab("obj_type", "1"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10647").ab("obj_type", "0"));
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.c.iy();
    }

    public void vr() {
        On();
        axR();
        axS();
        axT();
        axV();
        axU();
        gR(false);
    }

    public void axP() {
        axR();
        axS();
        axT();
        axU();
    }

    public void On() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.dmM.mG();
        } else {
            this.dmM.mH();
        }
    }

    public void gR(boolean z) {
        this.dmN.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.rh().ro()) {
            this.dmN.O(z);
        } else {
            this.dmN.P(z);
        }
        this.dmN.setSwitchStateChangeListener(this.dnd);
    }

    public void axQ() {
        gR(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axR() {
        if (!com.baidu.tbadk.core.m.rh().rn()) {
            this.dmO.setTip(this.mContext.getString(n.i.view_close));
        } else if (com.baidu.tbadk.core.m.rh().getViewImageQuality() == 1) {
            this.dmO.setTip(this.mContext.getString(n.i.view_high));
        } else if (com.baidu.tbadk.core.m.rh().getViewImageQuality() == 2) {
            this.dmO.setTip(this.mContext.getString(n.i.view_low));
        } else {
            this.dmO.setTip(this.mContext.getString(n.i.view_auto));
        }
    }

    private void axS() {
        lY(com.baidu.tbadk.core.m.rh().rk());
    }

    private void axT() {
        lZ(com.baidu.tbadk.core.m.rh().rl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(int i) {
        switch (i) {
            case 0:
                this.dmP.setTip(this.mContext.getString(n.i.view_auto));
                return;
            case 1:
                this.dmP.setTip(this.mContext.getString(n.i.view_high));
                return;
            case 2:
                this.dmP.setTip(this.mContext.getString(n.i.view_mid));
                return;
            case 3:
                this.dmP.setTip(this.mContext.getString(n.i.view_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(int i) {
        switch (i) {
            case 0:
                this.dmQ.setTip(this.mContext.getString(n.i.image_water_show_none));
                return;
            case 1:
                this.dmQ.setTip(this.mContext.getString(n.i.image_water_show_user_name));
                return;
            case 2:
                this.dmQ.setTip(this.mContext.getString(n.i.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void axU() {
        switch (com.baidu.tbadk.core.m.rh().ri()) {
            case 0:
                this.dmR.setTip(this.mContext.getString(n.i.is_wifiopen));
                return;
            case 1:
                this.dmR.setTip(this.mContext.getString(n.i.is_alwaysopen));
                return;
            case 2:
                this.dmR.setTip(this.mContext.getString(n.i.is_close));
                return;
            default:
                return;
        }
    }

    public void axV() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.dmS.setTip(this.mContext.getString(n.i.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.dmS.setTip(this.mContext.getString(n.i.font_size_mid));
        } else {
            this.dmS.setTip(this.mContext.getString(n.i.font_size_small));
        }
    }
}
