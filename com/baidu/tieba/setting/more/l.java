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
    private View MQ;
    private BrowseSettingActivity dJZ;
    private View dKa;
    private RelativeLayout dKb;
    private BdSwitchView dKc;
    private SettingTextSwitchView dKd;
    private TbSettingTextTipView dKe;
    private TbSettingTextTipView dKf;
    private TbSettingTextTipView dKg;
    private TbSettingTextTipView dKh;
    private TbSettingTextTipView dKi;
    private com.baidu.tbadk.core.dialog.f dKj;
    private com.baidu.tbadk.core.dialog.f dKk;
    private com.baidu.tbadk.core.dialog.f dKl;
    private com.baidu.tbadk.core.dialog.f dKm;
    private com.baidu.tbadk.core.dialog.f dKn;
    private ArrayList<com.baidu.tbadk.core.dialog.h> dKo;
    private ArrayList<com.baidu.tbadk.core.dialog.h> dKp;
    private ArrayList<com.baidu.tbadk.core.dialog.h> dKq;
    private ArrayList<com.baidu.tbadk.core.dialog.h> dKr;
    private ArrayList<com.baidu.tbadk.core.dialog.h> dKs;
    private final BdSwitchView.a dKt;
    private final AdapterView.OnItemClickListener dKu;
    private final AdapterView.OnItemClickListener dKv;
    private final AdapterView.OnItemClickListener dKw;
    private final AdapterView.OnItemClickListener dKx;
    private final AdapterView.OnItemClickListener dKy;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.dJZ = null;
        this.MQ = null;
        this.mNavigationBar = null;
        this.dKa = null;
        this.dKb = null;
        this.dKc = null;
        this.dKd = null;
        this.dKe = null;
        this.dKf = null;
        this.dKg = null;
        this.dKh = null;
        this.dKi = null;
        this.dKj = null;
        this.dKk = null;
        this.dKl = null;
        this.dKm = null;
        this.dKn = null;
        this.dKt = new m(this);
        this.dKu = new n(this);
        this.dKv = new o(this);
        this.dKw = new p(this);
        this.dKx = new q(this);
        this.dKy = new r(this);
        this.mHandler = new Handler();
        this.dJZ = browseSettingActivity;
        qD();
        wh();
        pm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.dKd.ej(i);
        this.dJZ.getLayoutMode().ac(i == 1);
        this.dJZ.getLayoutMode().x(this.MQ);
        this.dKc.a(com.baidu.tbadk.core.util.ar.cO(t.f.bg_switch_open), com.baidu.tbadk.core.util.ar.cO(t.f.bg_switch_close), com.baidu.tbadk.core.util.ar.cO(t.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView aGN() {
        return this.dKg;
    }

    public TbSettingTextTipView aGO() {
        return this.dKf;
    }

    public TbSettingTextTipView aGP() {
        return this.dKe;
    }

    public TbSettingTextTipView aGQ() {
        return this.dKh;
    }

    public TbSettingTextTipView aGR() {
        return this.dKi;
    }

    public void aGS() {
        aGZ();
        this.dKl.up();
    }

    public void aGT() {
        aGY();
        this.dKj.up();
    }

    public void aGU() {
        aGX();
        this.dKk.up();
    }

    public void aGV() {
        aHa();
        this.dKm.up();
    }

    public void aGW() {
        aHb();
        this.dKn.up();
    }

    private void qD() {
        this.dJZ.setContentView(t.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.dJZ.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.dJZ.getPageContext().getString(t.j.browse_setting));
        this.dKb = (RelativeLayout) this.dJZ.findViewById(t.g.eyeshield_mode);
        this.dKc = (BdSwitchView) this.dJZ.findViewById(t.g.item_switch);
        com.baidu.adp.lib.util.k.a(this.dJZ.getPageContext().getPageActivity(), this.dKc, 10, 10, 10, 10);
        this.dKa = this.dJZ.findViewById(t.g.divide_view2);
        this.dKd = (SettingTextSwitchView) this.dJZ.findViewById(t.g.img_thrift_setting);
        this.dKe = (TbSettingTextTipView) this.dJZ.findViewById(t.g.img_browser);
        this.dKf = (TbSettingTextTipView) this.dJZ.findViewById(t.g.img_upload);
        this.dKg = (TbSettingTextTipView) this.dJZ.findViewById(t.g.add_img_water);
        this.dKh = (TbSettingTextTipView) this.dJZ.findViewById(t.g.show_image);
        this.dKi = (TbSettingTextTipView) this.dJZ.findViewById(t.g.font_size);
        this.MQ = this.dJZ.findViewById(t.g.parent);
        if (!QE()) {
            this.dKa.setVisibility(8);
            this.dKb.setVisibility(8);
            return;
        }
        this.dKa.setVisibility(0);
        this.dKb.setVisibility(0);
    }

    public boolean QE() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void pm() {
        this.dKe.setOnClickListener(this.dJZ);
        this.dKf.setOnClickListener(this.dJZ);
        this.dKg.setOnClickListener(this.dJZ);
        this.dKc.setOnSwitchStateChangeListener(this.dJZ);
        this.dKh.setOnClickListener(this.dJZ);
        this.dKi.setOnClickListener(this.dJZ);
    }

    private void aGX() {
        this.dKp = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.l.rn().getViewImageQuality();
        boolean rt = com.baidu.tbadk.core.l.rn().rt();
        this.dKp.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_auto_menu), this.dJZ.getPageContext().getString(t.j.view_image_quality_auto_menu_desc), rt && viewImageQuality == 0));
        this.dKp.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_high_menu), this.dJZ.getPageContext().getString(t.j.view_image_quality_high_menu_desc), rt && viewImageQuality == 1));
        this.dKp.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_low_menu), this.dJZ.getPageContext().getString(t.j.view_image_quality_low_menu_desc), rt && viewImageQuality == 2));
        this.dKp.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_close_menu), this.dJZ.getPageContext().getString(t.j.view_image_quality_close_menu_desc), rt ? false : true));
        this.dKk = new com.baidu.tbadk.core.dialog.f(this.dJZ.getPageContext());
        this.dKk.ch(t.j.browser_image_quality);
        this.dKk.a(this.dKp, this.dKu).uo();
    }

    private void aGY() {
        this.dKq = new ArrayList<>();
        int rq = com.baidu.tbadk.core.l.rn().rq();
        this.dKq.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.image_quality_auto_menu), this.dJZ.getPageContext().getString(t.j.image_quality_auto_menu_desc), rq == 0));
        this.dKq.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_high_menu), this.dJZ.getPageContext().getString(t.j.image_quality_high_menu_desc), rq == 1));
        this.dKq.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.image_quality_mid_menu), this.dJZ.getPageContext().getString(t.j.image_quality_mid_menu_desc), rq == 2));
        this.dKq.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_low_menu), this.dJZ.getPageContext().getString(t.j.image_quality_low_menu_desc), rq == 3));
        this.dKj = new com.baidu.tbadk.core.dialog.f(this.dJZ.getPageContext()).ch(t.j.upload_image_quality);
        this.dKj.a(this.dKq, this.dKv).uo();
    }

    private void aGZ() {
        this.dKs = new ArrayList<>();
        int rr = com.baidu.tbadk.core.l.rn().rr();
        this.dKs.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.image_water_show_user_name), null, rr == 1));
        this.dKs.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.image_water_show_forum_name), null, rr == 2));
        this.dKs.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.image_water_show_none), null, rr == 0));
        this.dKl = new com.baidu.tbadk.core.dialog.f(this.dJZ.getPageContext()).ch(t.j.add_image_water);
        this.dKl.a(this.dKs, this.dKw).uo();
    }

    private void aHa() {
        this.dKr = new ArrayList<>();
        int ro = com.baidu.tbadk.core.l.rn().ro();
        this.dKr.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.view_image_quality_auto_menu), this.dJZ.getPageContext().getString(t.j.is_wifiopen_dialog), ro == 0));
        this.dKr.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.is_alwaysopen), null, ro == 1));
        this.dKr.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.is_close), null, ro == 2));
        this.dKm = new com.baidu.tbadk.core.dialog.f(this.dJZ.getPageContext()).ch(t.j.show_photo);
        this.dKm.a(this.dKr, this.dKx).uo();
    }

    private void aHb() {
        this.dKn = new com.baidu.tbadk.core.dialog.f(this.dJZ.getPageContext());
        this.dKo = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.dKo.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.font_size_big), null, fontSize == 1));
        this.dKo.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.font_size_mid), null, fontSize == 2));
        this.dKo.add(new com.baidu.tbadk.core.dialog.h(this.dJZ.getPageContext().getString(t.j.font_size_small), null, fontSize == 3));
        this.dKn.ch(t.j.font_size);
        this.dKn.a(this.dKo, this.dKy);
        this.dKn.uo();
    }

    public void nL(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 1) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10647").aa("obj_type", "1"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() != 0) {
                TbadkCoreApplication.m411getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10647").aa("obj_type", "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void wh() {
        QH();
        aHe();
        aHf();
        aHg();
        aHi();
        aHh();
        hz(false);
    }

    public void aHc() {
        aHe();
        aHf();
        aHg();
        aHh();
    }

    public void QH() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.dKc.ms();
        } else {
            this.dKc.mt();
        }
    }

    public void hz(boolean z) {
        this.dKd.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.rn().ru()) {
            this.dKd.L(z);
        } else {
            this.dKd.M(z);
        }
        this.dKd.setSwitchStateChangeListener(this.dKt);
    }

    public void aHd() {
        hz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHe() {
        if (!com.baidu.tbadk.core.l.rn().rt()) {
            this.dKe.setTip(this.mContext.getString(t.j.view_close));
        } else if (com.baidu.tbadk.core.l.rn().getViewImageQuality() == 1) {
            this.dKe.setTip(this.mContext.getString(t.j.view_high));
        } else if (com.baidu.tbadk.core.l.rn().getViewImageQuality() == 2) {
            this.dKe.setTip(this.mContext.getString(t.j.view_low));
        } else {
            this.dKe.setTip(this.mContext.getString(t.j.view_auto));
        }
    }

    private void aHf() {
        nM(com.baidu.tbadk.core.l.rn().rq());
    }

    private void aHg() {
        nN(com.baidu.tbadk.core.l.rn().rr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(int i) {
        switch (i) {
            case 0:
                this.dKf.setTip(this.mContext.getString(t.j.view_auto));
                return;
            case 1:
                this.dKf.setTip(this.mContext.getString(t.j.view_high));
                return;
            case 2:
                this.dKf.setTip(this.mContext.getString(t.j.view_mid));
                return;
            case 3:
                this.dKf.setTip(this.mContext.getString(t.j.view_low));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(int i) {
        switch (i) {
            case 0:
                this.dKg.setTip(this.mContext.getString(t.j.image_water_show_none));
                return;
            case 1:
                this.dKg.setTip(this.mContext.getString(t.j.image_water_show_user_name));
                return;
            case 2:
                this.dKg.setTip(this.mContext.getString(t.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void aHh() {
        switch (com.baidu.tbadk.core.l.rn().ro()) {
            case 0:
                this.dKh.setTip(this.mContext.getString(t.j.is_wifiopen));
                return;
            case 1:
                this.dKh.setTip(this.mContext.getString(t.j.is_alwaysopen));
                return;
            case 2:
                this.dKh.setTip(this.mContext.getString(t.j.is_close));
                return;
            default:
                return;
        }
    }

    public void aHi() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.dKi.setTip(this.mContext.getString(t.j.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.dKi.setTip(this.mContext.getString(t.j.font_size_mid));
        } else {
            this.dKi.setTip(this.mContext.getString(t.j.font_size_small));
        }
    }
}
