package com.baidu.tieba.setting.more;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g<BrowseSettingActivity> {
    private View LG;
    private BrowseSettingActivity ceT;
    private View ceU;
    private RelativeLayout ceV;
    private BdSwitchView ceW;
    private SettingTextSwitchView ceX;
    private TbSettingTextTipView ceY;
    private TbSettingTextTipView ceZ;
    private TbSettingTextTipView cfa;
    private TbSettingTextTipView cfb;
    private com.baidu.tbadk.core.dialog.i cfc;
    private com.baidu.tbadk.core.dialog.i cfd;
    private com.baidu.tbadk.core.dialog.i cfe;
    private com.baidu.tbadk.core.dialog.i cff;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfg;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfh;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfi;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfj;
    private final com.baidu.adp.widget.BdSwitchView.b cfk;
    private final AdapterView.OnItemClickListener cfl;
    private final AdapterView.OnItemClickListener cfm;
    private final AdapterView.OnItemClickListener cfn;
    private final AdapterView.OnItemClickListener cfo;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ceT = null;
        this.LG = null;
        this.mNavigationBar = null;
        this.ceU = null;
        this.ceV = null;
        this.ceW = null;
        this.ceX = null;
        this.ceY = null;
        this.ceZ = null;
        this.cfa = null;
        this.cfb = null;
        this.cfc = null;
        this.cfd = null;
        this.cfe = null;
        this.cff = null;
        this.cfk = new l(this);
        this.cfl = new m(this);
        this.cfm = new n(this);
        this.cfn = new o(this);
        this.cfo = new p(this);
        this.mHandler = new Handler();
        this.ceT = browseSettingActivity;
        initUI();
        tC();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ceX.dl(i);
        this.ceT.getLayoutMode().ab(i == 1);
        this.ceT.getLayoutMode().j(this.LG);
        this.ceW.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView aiu() {
        return this.ceZ;
    }

    public TbSettingTextTipView aiv() {
        return this.ceY;
    }

    public TbSettingTextTipView aiw() {
        return this.cfa;
    }

    public TbSettingTextTipView aix() {
        return this.cfb;
    }

    public void aiy() {
        aiD();
        this.cfc.rP();
    }

    public void aiz() {
        aiC();
        this.cfd.rP();
    }

    public void aiA() {
        aiE();
        this.cfe.rP();
    }

    public void aiB() {
        aiF();
        this.cff.rP();
    }

    private void initUI() {
        this.ceT.setContentView(com.baidu.tieba.r.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ceT.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ceT.getPageContext().getString(com.baidu.tieba.t.browse_setting));
        this.ceV = (RelativeLayout) this.ceT.findViewById(com.baidu.tieba.q.eyeshield_mode);
        this.ceW = (BdSwitchView) this.ceT.findViewById(com.baidu.tieba.q.item_switch);
        com.baidu.adp.lib.util.n.a(this.ceT.getPageContext().getPageActivity(), this.ceW, 10, 10, 10, 10);
        this.ceU = this.ceT.findViewById(com.baidu.tieba.q.divide_view2);
        this.ceX = (SettingTextSwitchView) this.ceT.findViewById(com.baidu.tieba.q.img_thrift_setting);
        this.ceY = (TbSettingTextTipView) this.ceT.findViewById(com.baidu.tieba.q.img_browser);
        this.ceZ = (TbSettingTextTipView) this.ceT.findViewById(com.baidu.tieba.q.img_upload);
        this.cfa = (TbSettingTextTipView) this.ceT.findViewById(com.baidu.tieba.q.show_image);
        this.cfb = (TbSettingTextTipView) this.ceT.findViewById(com.baidu.tieba.q.font_size);
        this.LG = this.ceT.findViewById(com.baidu.tieba.q.parent);
        if (!LK()) {
            this.ceU.setVisibility(8);
            this.ceV.setVisibility(8);
            return;
        }
        this.ceU.setVisibility(0);
        this.ceV.setVisibility(0);
    }

    public boolean LK() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void initListener() {
        this.ceY.setOnClickListener(this.ceT);
        this.ceZ.setOnClickListener(this.ceT);
        this.ceW.setOnSwitchStateChangeListener(this.ceT);
        this.cfa.setOnClickListener(this.ceT);
        this.cfb.setOnClickListener(this.ceT);
    }

    private void aiC() {
        this.cfh = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.n.qc().getViewImageQuality();
        boolean qg = com.baidu.tbadk.core.n.qc().qg();
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_auto_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_auto_menu_desc), qg && viewImageQuality == 0));
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_high_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_high_menu_desc), qg && viewImageQuality == 1));
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_low_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_low_menu_desc), qg && viewImageQuality == 2));
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_close_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_close_menu_desc), qg ? false : true));
        this.cfd = new com.baidu.tbadk.core.dialog.i(this.ceT.getPageContext());
        this.cfd.bC(com.baidu.tieba.t.browser_image_quality);
        this.cfd.a(this.cfh, this.cfl).rO();
    }

    private void aiD() {
        this.cfi = new ArrayList<>();
        int qf = com.baidu.tbadk.core.n.qc().qf();
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.image_quality_auto_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.image_quality_auto_menu_desc), qf == 0));
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_high_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.image_quality_high_menu_desc), qf == 1));
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.image_quality_mid_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.image_quality_mid_menu_desc), qf == 2));
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_low_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.image_quality_low_menu_desc), qf == 3));
        this.cfc = new com.baidu.tbadk.core.dialog.i(this.ceT.getPageContext()).bC(com.baidu.tieba.t.upload_image_quality);
        this.cfc.a(this.cfi, this.cfm).rO();
    }

    private void aiE() {
        this.cfj = new ArrayList<>();
        int qd = com.baidu.tbadk.core.n.qc().qd();
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.view_image_quality_auto_menu), this.ceT.getPageContext().getString(com.baidu.tieba.t.is_wifiopen_dialog), qd == 0));
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.is_alwaysopen), null, qd == 1));
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.is_close), null, qd == 2));
        this.cfe = new com.baidu.tbadk.core.dialog.i(this.ceT.getPageContext()).bC(com.baidu.tieba.t.show_photo);
        this.cfe.a(this.cfj, this.cfn).rO();
    }

    private void aiF() {
        this.cff = new com.baidu.tbadk.core.dialog.i(this.ceT.getPageContext());
        this.cfg = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cfg.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.font_size_big), null, fontSize == 1));
        this.cfg.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.font_size_mid), null, fontSize == 2));
        this.cfg.add(new com.baidu.tbadk.core.dialog.m(this.ceT.getPageContext().getString(com.baidu.tieba.t.font_size_small), null, fontSize == 3));
        this.cff.bC(com.baidu.tieba.t.font_size);
        this.cff.a(this.cfg, this.cfo);
        this.cff.rO();
    }

    public void iv(int i) {
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
        com.baidu.tbadk.core.util.c.iL();
    }

    public void tC() {
        LN();
        aiI();
        aiJ();
        aiL();
        aiK();
        eJ(false);
    }

    public void aiG() {
        aiI();
        aiJ();
        aiK();
    }

    public void LN() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.ceW.mt();
        } else {
            this.ceW.mu();
        }
    }

    public void eJ(boolean z) {
        this.ceX.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.qc().qh()) {
            this.ceX.N(z);
        } else {
            this.ceX.O(z);
        }
        this.ceX.setSwitchStateChangeListener(this.cfk);
    }

    public void aiH() {
        eJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiI() {
        if (!com.baidu.tbadk.core.n.qc().qg()) {
            this.ceY.setTip(this.mContext.getString(com.baidu.tieba.t.view_close));
        } else if (com.baidu.tbadk.core.n.qc().getViewImageQuality() == 1) {
            this.ceY.setTip(this.mContext.getString(com.baidu.tieba.t.view_high));
        } else if (com.baidu.tbadk.core.n.qc().getViewImageQuality() == 2) {
            this.ceY.setTip(this.mContext.getString(com.baidu.tieba.t.view_low));
        } else {
            this.ceY.setTip(this.mContext.getString(com.baidu.tieba.t.view_auto));
        }
    }

    private void aiJ() {
        iw(com.baidu.tbadk.core.n.qc().qf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iw(int i) {
        switch (i) {
            case 0:
                this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_auto));
                return;
            case 1:
                this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_high));
                return;
            case 2:
                this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_mid));
                return;
            case 3:
                this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_low));
                return;
            default:
                return;
        }
    }

    public void aiK() {
        switch (com.baidu.tbadk.core.n.qc().qd()) {
            case 0:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.is_wifiopen));
                return;
            case 1:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.is_alwaysopen));
                return;
            case 2:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.is_close));
                return;
            default:
                return;
        }
    }

    public void aiL() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cfb.setTip(this.mContext.getString(com.baidu.tieba.t.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cfb.setTip(this.mContext.getString(com.baidu.tieba.t.font_size_mid));
        } else {
            this.cfb.setTip(this.mContext.getString(com.baidu.tieba.t.font_size_small));
        }
    }
}
