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
    private View LS;
    private BrowseSettingActivity cMW;
    private View cMX;
    private RelativeLayout cMY;
    private BdSwitchView cMZ;
    private SettingTextSwitchView cNa;
    private TbSettingTextTipView cNb;
    private TbSettingTextTipView cNc;
    private TbSettingTextTipView cNd;
    private TbSettingTextTipView cNe;
    private com.baidu.tbadk.core.dialog.e cNf;
    private com.baidu.tbadk.core.dialog.e cNg;
    private com.baidu.tbadk.core.dialog.e cNh;
    private com.baidu.tbadk.core.dialog.e cNi;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cNj;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cNk;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cNl;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cNm;
    private final BdSwitchView.a cNn;
    private final AdapterView.OnItemClickListener cNo;
    private final AdapterView.OnItemClickListener cNp;
    private final AdapterView.OnItemClickListener cNq;
    private final AdapterView.OnItemClickListener cNr;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cMW = null;
        this.LS = null;
        this.mNavigationBar = null;
        this.cMX = null;
        this.cMY = null;
        this.cMZ = null;
        this.cNa = null;
        this.cNb = null;
        this.cNc = null;
        this.cNd = null;
        this.cNe = null;
        this.cNf = null;
        this.cNg = null;
        this.cNh = null;
        this.cNi = null;
        this.cNn = new m(this);
        this.cNo = new n(this);
        this.cNp = new o(this);
        this.cNq = new p(this);
        this.cNr = new q(this);
        this.mHandler = new Handler();
        this.cMW = browseSettingActivity;
        initUI();
        uH();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.cNa.dF(i);
        this.cMW.getLayoutMode().ad(i == 1);
        this.cMW.getLayoutMode().k(this.LS);
        this.cMZ.a(com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_open), com.baidu.tbadk.core.util.an.cw(i.e.bg_switch_close), com.baidu.tbadk.core.util.an.cw(i.e.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView arw() {
        return this.cNc;
    }

    public TbSettingTextTipView arx() {
        return this.cNb;
    }

    public TbSettingTextTipView ary() {
        return this.cNd;
    }

    public TbSettingTextTipView arz() {
        return this.cNe;
    }

    public void arA() {
        arF();
        this.cNf.sT();
    }

    public void arB() {
        arE();
        this.cNg.sT();
    }

    public void arC() {
        arG();
        this.cNh.sT();
    }

    public void arD() {
        arH();
        this.cNi.sT();
    }

    private void initUI() {
        this.cMW.setContentView(i.g.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cMW.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cMW.getPageContext().getString(i.h.browse_setting));
        this.cMY = (RelativeLayout) this.cMW.findViewById(i.f.eyeshield_mode);
        this.cMZ = (BdSwitchView) this.cMW.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cMW.getPageContext().getPageActivity(), this.cMZ, 10, 10, 10, 10);
        this.cMX = this.cMW.findViewById(i.f.divide_view2);
        this.cNa = (SettingTextSwitchView) this.cMW.findViewById(i.f.img_thrift_setting);
        this.cNb = (TbSettingTextTipView) this.cMW.findViewById(i.f.img_browser);
        this.cNc = (TbSettingTextTipView) this.cMW.findViewById(i.f.img_upload);
        this.cNd = (TbSettingTextTipView) this.cMW.findViewById(i.f.show_image);
        this.cNe = (TbSettingTextTipView) this.cMW.findViewById(i.f.font_size);
        this.LS = this.cMW.findViewById(i.f.parent);
        if (!Mv()) {
            this.cMX.setVisibility(8);
            this.cMY.setVisibility(8);
            return;
        }
        this.cMX.setVisibility(0);
        this.cMY.setVisibility(0);
    }

    public boolean Mv() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.cNb.setOnClickListener(this.cMW);
        this.cNc.setOnClickListener(this.cMW);
        this.cMZ.setOnSwitchStateChangeListener(this.cMW);
        this.cNd.setOnClickListener(this.cMW);
        this.cNe.setOnClickListener(this.cMW);
    }

    private void arE() {
        this.cNk = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.qU().getViewImageQuality();
        boolean qY = com.baidu.tbadk.core.m.qU().qY();
        this.cNk.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cMW.getPageContext().getString(i.h.view_image_quality_auto_menu_desc), qY && viewImageQuality == 0));
        this.cNk.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_high_menu), this.cMW.getPageContext().getString(i.h.view_image_quality_high_menu_desc), qY && viewImageQuality == 1));
        this.cNk.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_low_menu), this.cMW.getPageContext().getString(i.h.view_image_quality_low_menu_desc), qY && viewImageQuality == 2));
        this.cNk.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_close_menu), this.cMW.getPageContext().getString(i.h.view_image_quality_close_menu_desc), qY ? false : true));
        this.cNg = new com.baidu.tbadk.core.dialog.e(this.cMW.getPageContext());
        this.cNg.bN(i.h.browser_image_quality);
        this.cNg.a(this.cNk, this.cNo).sS();
    }

    private void arF() {
        this.cNl = new ArrayList<>();
        int qX = com.baidu.tbadk.core.m.qU().qX();
        this.cNl.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.image_quality_auto_menu), this.cMW.getPageContext().getString(i.h.image_quality_auto_menu_desc), qX == 0));
        this.cNl.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_high_menu), this.cMW.getPageContext().getString(i.h.image_quality_high_menu_desc), qX == 1));
        this.cNl.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.image_quality_mid_menu), this.cMW.getPageContext().getString(i.h.image_quality_mid_menu_desc), qX == 2));
        this.cNl.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_low_menu), this.cMW.getPageContext().getString(i.h.image_quality_low_menu_desc), qX == 3));
        this.cNf = new com.baidu.tbadk.core.dialog.e(this.cMW.getPageContext()).bN(i.h.upload_image_quality);
        this.cNf.a(this.cNl, this.cNp).sS();
    }

    private void arG() {
        this.cNm = new ArrayList<>();
        int qV = com.baidu.tbadk.core.m.qU().qV();
        this.cNm.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cMW.getPageContext().getString(i.h.is_wifiopen_dialog), qV == 0));
        this.cNm.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.is_alwaysopen), null, qV == 1));
        this.cNm.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.is_close), null, qV == 2));
        this.cNh = new com.baidu.tbadk.core.dialog.e(this.cMW.getPageContext()).bN(i.h.show_photo);
        this.cNh.a(this.cNm, this.cNq).sS();
    }

    private void arH() {
        this.cNi = new com.baidu.tbadk.core.dialog.e(this.cMW.getPageContext());
        this.cNj = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cNj.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.font_size_big), null, fontSize == 1));
        this.cNj.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.font_size_mid), null, fontSize == 2));
        this.cNj.add(new com.baidu.tbadk.core.dialog.g(this.cMW.getPageContext().getString(i.h.font_size_small), null, fontSize == 3));
        this.cNi.bN(i.h.font_size);
        this.cNi.a(this.cNj, this.cNr);
        this.cNi.sS();
    }

    public void kB(int i) {
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

    public void uH() {
        My();
        arK();
        arL();
        arN();
        arM();
        fY(false);
    }

    public void arI() {
        arK();
        arL();
        arM();
    }

    public void My() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cMZ.mB();
        } else {
            this.cMZ.mC();
        }
    }

    public void fY(boolean z) {
        this.cNa.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.qU().qZ()) {
            this.cNa.O(z);
        } else {
            this.cNa.P(z);
        }
        this.cNa.setSwitchStateChangeListener(this.cNn);
    }

    public void arJ() {
        fY(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arK() {
        if (!com.baidu.tbadk.core.m.qU().qY()) {
            this.cNb.setTip(this.mContext.getString(i.h.view_close));
        } else if (com.baidu.tbadk.core.m.qU().getViewImageQuality() == 1) {
            this.cNb.setTip(this.mContext.getString(i.h.view_high));
        } else if (com.baidu.tbadk.core.m.qU().getViewImageQuality() == 2) {
            this.cNb.setTip(this.mContext.getString(i.h.view_low));
        } else {
            this.cNb.setTip(this.mContext.getString(i.h.view_auto));
        }
    }

    private void arL() {
        kC(com.baidu.tbadk.core.m.qU().qX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kC(int i) {
        switch (i) {
            case 0:
                this.cNc.setTip(this.mContext.getString(i.h.view_auto));
                return;
            case 1:
                this.cNc.setTip(this.mContext.getString(i.h.view_high));
                return;
            case 2:
                this.cNc.setTip(this.mContext.getString(i.h.view_mid));
                return;
            case 3:
                this.cNc.setTip(this.mContext.getString(i.h.view_low));
                return;
            default:
                return;
        }
    }

    public void arM() {
        switch (com.baidu.tbadk.core.m.qU().qV()) {
            case 0:
                this.cNd.setTip(this.mContext.getString(i.h.is_wifiopen));
                return;
            case 1:
                this.cNd.setTip(this.mContext.getString(i.h.is_alwaysopen));
                return;
            case 2:
                this.cNd.setTip(this.mContext.getString(i.h.is_close));
                return;
            default:
                return;
        }
    }

    public void arN() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cNe.setTip(this.mContext.getString(i.h.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cNe.setTip(this.mContext.getString(i.h.font_size_mid));
        } else {
            this.cNe.setTip(this.mContext.getString(i.h.font_size_small));
        }
    }
}
