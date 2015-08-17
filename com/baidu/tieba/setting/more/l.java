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
    private BrowseSettingActivity cwZ;
    private View cxa;
    private RelativeLayout cxb;
    private BdSwitchView cxc;
    private SettingTextSwitchView cxd;
    private TbSettingTextTipView cxe;
    private TbSettingTextTipView cxf;
    private TbSettingTextTipView cxg;
    private TbSettingTextTipView cxh;
    private com.baidu.tbadk.core.dialog.e cxi;
    private com.baidu.tbadk.core.dialog.e cxj;
    private com.baidu.tbadk.core.dialog.e cxk;
    private com.baidu.tbadk.core.dialog.e cxl;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cxm;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cxn;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cxo;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cxp;
    private final BdSwitchView.a cxq;
    private final AdapterView.OnItemClickListener cxr;
    private final AdapterView.OnItemClickListener cxs;
    private final AdapterView.OnItemClickListener cxt;
    private final AdapterView.OnItemClickListener cxu;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cwZ = null;
        this.LR = null;
        this.mNavigationBar = null;
        this.cxa = null;
        this.cxb = null;
        this.cxc = null;
        this.cxd = null;
        this.cxe = null;
        this.cxf = null;
        this.cxg = null;
        this.cxh = null;
        this.cxi = null;
        this.cxj = null;
        this.cxk = null;
        this.cxl = null;
        this.cxq = new m(this);
        this.cxr = new n(this);
        this.cxs = new o(this);
        this.cxt = new p(this);
        this.cxu = new q(this);
        this.mHandler = new Handler();
        this.cwZ = browseSettingActivity;
        initUI();
        uF();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.cxd.dw(i);
        this.cwZ.getLayoutMode().ad(i == 1);
        this.cwZ.getLayoutMode().k(this.LR);
        this.cxc.a(com.baidu.tbadk.core.util.al.cq(i.e.bg_switch_open), com.baidu.tbadk.core.util.al.cq(i.e.bg_switch_close), com.baidu.tbadk.core.util.al.cq(i.e.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView akV() {
        return this.cxf;
    }

    public TbSettingTextTipView akW() {
        return this.cxe;
    }

    public TbSettingTextTipView akX() {
        return this.cxg;
    }

    public TbSettingTextTipView akY() {
        return this.cxh;
    }

    public void akZ() {
        ale();
        this.cxi.sU();
    }

    public void ala() {
        ald();
        this.cxj.sU();
    }

    public void alb() {
        alf();
        this.cxk.sU();
    }

    public void alc() {
        alg();
        this.cxl.sU();
    }

    private void initUI() {
        this.cwZ.setContentView(i.g.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cwZ.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cwZ.getPageContext().getString(i.C0057i.browse_setting));
        this.cxb = (RelativeLayout) this.cwZ.findViewById(i.f.eyeshield_mode);
        this.cxc = (BdSwitchView) this.cwZ.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cwZ.getPageContext().getPageActivity(), this.cxc, 10, 10, 10, 10);
        this.cxa = this.cwZ.findViewById(i.f.divide_view2);
        this.cxd = (SettingTextSwitchView) this.cwZ.findViewById(i.f.img_thrift_setting);
        this.cxe = (TbSettingTextTipView) this.cwZ.findViewById(i.f.img_browser);
        this.cxf = (TbSettingTextTipView) this.cwZ.findViewById(i.f.img_upload);
        this.cxg = (TbSettingTextTipView) this.cwZ.findViewById(i.f.show_image);
        this.cxh = (TbSettingTextTipView) this.cwZ.findViewById(i.f.font_size);
        this.LR = this.cwZ.findViewById(i.f.parent);
        if (!MA()) {
            this.cxa.setVisibility(8);
            this.cxb.setVisibility(8);
            return;
        }
        this.cxa.setVisibility(0);
        this.cxb.setVisibility(0);
    }

    public boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.cxe.setOnClickListener(this.cwZ);
        this.cxf.setOnClickListener(this.cwZ);
        this.cxc.setOnSwitchStateChangeListener(this.cwZ);
        this.cxg.setOnClickListener(this.cwZ);
        this.cxh.setOnClickListener(this.cwZ);
    }

    private void ald() {
        this.cxn = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.rd().getViewImageQuality();
        boolean rh = com.baidu.tbadk.core.m.rd().rh();
        this.cxn.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_auto_menu), this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_auto_menu_desc), rh && viewImageQuality == 0));
        this.cxn.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_high_menu), this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_high_menu_desc), rh && viewImageQuality == 1));
        this.cxn.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_low_menu), this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_low_menu_desc), rh && viewImageQuality == 2));
        this.cxn.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_close_menu), this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_close_menu_desc), rh ? false : true));
        this.cxj = new com.baidu.tbadk.core.dialog.e(this.cwZ.getPageContext());
        this.cxj.bK(i.C0057i.browser_image_quality);
        this.cxj.a(this.cxn, this.cxr).sT();
    }

    private void ale() {
        this.cxo = new ArrayList<>();
        int rg = com.baidu.tbadk.core.m.rd().rg();
        this.cxo.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.image_quality_auto_menu), this.cwZ.getPageContext().getString(i.C0057i.image_quality_auto_menu_desc), rg == 0));
        this.cxo.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_high_menu), this.cwZ.getPageContext().getString(i.C0057i.image_quality_high_menu_desc), rg == 1));
        this.cxo.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.image_quality_mid_menu), this.cwZ.getPageContext().getString(i.C0057i.image_quality_mid_menu_desc), rg == 2));
        this.cxo.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_low_menu), this.cwZ.getPageContext().getString(i.C0057i.image_quality_low_menu_desc), rg == 3));
        this.cxi = new com.baidu.tbadk.core.dialog.e(this.cwZ.getPageContext()).bK(i.C0057i.upload_image_quality);
        this.cxi.a(this.cxo, this.cxs).sT();
    }

    private void alf() {
        this.cxp = new ArrayList<>();
        int re = com.baidu.tbadk.core.m.rd().re();
        this.cxp.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.view_image_quality_auto_menu), this.cwZ.getPageContext().getString(i.C0057i.is_wifiopen_dialog), re == 0));
        this.cxp.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.is_alwaysopen), null, re == 1));
        this.cxp.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.is_close), null, re == 2));
        this.cxk = new com.baidu.tbadk.core.dialog.e(this.cwZ.getPageContext()).bK(i.C0057i.show_photo);
        this.cxk.a(this.cxp, this.cxt).sT();
    }

    private void alg() {
        this.cxl = new com.baidu.tbadk.core.dialog.e(this.cwZ.getPageContext());
        this.cxm = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cxm.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.font_size_big), null, fontSize == 1));
        this.cxm.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.font_size_mid), null, fontSize == 2));
        this.cxm.add(new com.baidu.tbadk.core.dialog.g(this.cwZ.getPageContext().getString(i.C0057i.font_size_small), null, fontSize == 3));
        this.cxl.bK(i.C0057i.font_size);
        this.cxl.a(this.cxm, this.cxu);
        this.cxl.sT();
    }

    public void jq(int i) {
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
        com.baidu.tbadk.core.util.c.ix();
    }

    public void uF() {
        MD();
        alj();
        alk();
        alm();
        all();
        fc(false);
    }

    public void alh() {
        alj();
        alk();
        all();
    }

    public void MD() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cxc.mD();
        } else {
            this.cxc.mE();
        }
    }

    public void fc(boolean z) {
        this.cxd.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.rd().ri()) {
            this.cxd.O(z);
        } else {
            this.cxd.P(z);
        }
        this.cxd.setSwitchStateChangeListener(this.cxq);
    }

    public void ali() {
        fc(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alj() {
        if (!com.baidu.tbadk.core.m.rd().rh()) {
            this.cxe.setTip(this.mContext.getString(i.C0057i.view_close));
        } else if (com.baidu.tbadk.core.m.rd().getViewImageQuality() == 1) {
            this.cxe.setTip(this.mContext.getString(i.C0057i.view_high));
        } else if (com.baidu.tbadk.core.m.rd().getViewImageQuality() == 2) {
            this.cxe.setTip(this.mContext.getString(i.C0057i.view_low));
        } else {
            this.cxe.setTip(this.mContext.getString(i.C0057i.view_auto));
        }
    }

    private void alk() {
        jr(com.baidu.tbadk.core.m.rd().rg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr(int i) {
        switch (i) {
            case 0:
                this.cxf.setTip(this.mContext.getString(i.C0057i.view_auto));
                return;
            case 1:
                this.cxf.setTip(this.mContext.getString(i.C0057i.view_high));
                return;
            case 2:
                this.cxf.setTip(this.mContext.getString(i.C0057i.view_mid));
                return;
            case 3:
                this.cxf.setTip(this.mContext.getString(i.C0057i.view_low));
                return;
            default:
                return;
        }
    }

    public void all() {
        switch (com.baidu.tbadk.core.m.rd().re()) {
            case 0:
                this.cxg.setTip(this.mContext.getString(i.C0057i.is_wifiopen));
                return;
            case 1:
                this.cxg.setTip(this.mContext.getString(i.C0057i.is_alwaysopen));
                return;
            case 2:
                this.cxg.setTip(this.mContext.getString(i.C0057i.is_close));
                return;
            default:
                return;
        }
    }

    public void alm() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cxh.setTip(this.mContext.getString(i.C0057i.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cxh.setTip(this.mContext.getString(i.C0057i.font_size_mid));
        } else {
            this.cxh.setTip(this.mContext.getString(i.C0057i.font_size_small));
        }
    }
}
