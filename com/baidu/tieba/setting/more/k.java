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
    private BrowseSettingActivity ceU;
    private View ceV;
    private RelativeLayout ceW;
    private BdSwitchView ceX;
    private SettingTextSwitchView ceY;
    private TbSettingTextTipView ceZ;
    private TbSettingTextTipView cfa;
    private TbSettingTextTipView cfb;
    private TbSettingTextTipView cfc;
    private com.baidu.tbadk.core.dialog.i cfd;
    private com.baidu.tbadk.core.dialog.i cfe;
    private com.baidu.tbadk.core.dialog.i cff;
    private com.baidu.tbadk.core.dialog.i cfg;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfh;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfi;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfj;
    private ArrayList<com.baidu.tbadk.core.dialog.m> cfk;
    private final com.baidu.adp.widget.BdSwitchView.b cfl;
    private final AdapterView.OnItemClickListener cfm;
    private final AdapterView.OnItemClickListener cfn;
    private final AdapterView.OnItemClickListener cfo;
    private final AdapterView.OnItemClickListener cfp;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ceU = null;
        this.LG = null;
        this.mNavigationBar = null;
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
        this.cfg = null;
        this.cfl = new l(this);
        this.cfm = new m(this);
        this.cfn = new n(this);
        this.cfo = new o(this);
        this.cfp = new p(this);
        this.mHandler = new Handler();
        this.ceU = browseSettingActivity;
        initUI();
        tC();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ceY.dl(i);
        this.ceU.getLayoutMode().ab(i == 1);
        this.ceU.getLayoutMode().j(this.LG);
        this.ceX.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView aiv() {
        return this.cfa;
    }

    public TbSettingTextTipView aiw() {
        return this.ceZ;
    }

    public TbSettingTextTipView aix() {
        return this.cfb;
    }

    public TbSettingTextTipView aiy() {
        return this.cfc;
    }

    public void aiz() {
        aiE();
        this.cfd.rP();
    }

    public void aiA() {
        aiD();
        this.cfe.rP();
    }

    public void aiB() {
        aiF();
        this.cff.rP();
    }

    public void aiC() {
        aiG();
        this.cfg.rP();
    }

    private void initUI() {
        this.ceU.setContentView(com.baidu.tieba.r.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ceU.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ceU.getPageContext().getString(com.baidu.tieba.t.browse_setting));
        this.ceW = (RelativeLayout) this.ceU.findViewById(com.baidu.tieba.q.eyeshield_mode);
        this.ceX = (BdSwitchView) this.ceU.findViewById(com.baidu.tieba.q.item_switch);
        com.baidu.adp.lib.util.n.a(this.ceU.getPageContext().getPageActivity(), this.ceX, 10, 10, 10, 10);
        this.ceV = this.ceU.findViewById(com.baidu.tieba.q.divide_view2);
        this.ceY = (SettingTextSwitchView) this.ceU.findViewById(com.baidu.tieba.q.img_thrift_setting);
        this.ceZ = (TbSettingTextTipView) this.ceU.findViewById(com.baidu.tieba.q.img_browser);
        this.cfa = (TbSettingTextTipView) this.ceU.findViewById(com.baidu.tieba.q.img_upload);
        this.cfb = (TbSettingTextTipView) this.ceU.findViewById(com.baidu.tieba.q.show_image);
        this.cfc = (TbSettingTextTipView) this.ceU.findViewById(com.baidu.tieba.q.font_size);
        this.LG = this.ceU.findViewById(com.baidu.tieba.q.parent);
        if (!LL()) {
            this.ceV.setVisibility(8);
            this.ceW.setVisibility(8);
            return;
        }
        this.ceV.setVisibility(0);
        this.ceW.setVisibility(0);
    }

    public boolean LL() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void initListener() {
        this.ceZ.setOnClickListener(this.ceU);
        this.cfa.setOnClickListener(this.ceU);
        this.ceX.setOnSwitchStateChangeListener(this.ceU);
        this.cfb.setOnClickListener(this.ceU);
        this.cfc.setOnClickListener(this.ceU);
    }

    private void aiD() {
        this.cfi = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.n.qc().getViewImageQuality();
        boolean qg = com.baidu.tbadk.core.n.qc().qg();
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_auto_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_auto_menu_desc), qg && viewImageQuality == 0));
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_high_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_high_menu_desc), qg && viewImageQuality == 1));
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_low_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_low_menu_desc), qg && viewImageQuality == 2));
        this.cfi.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_close_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_close_menu_desc), qg ? false : true));
        this.cfe = new com.baidu.tbadk.core.dialog.i(this.ceU.getPageContext());
        this.cfe.bC(com.baidu.tieba.t.browser_image_quality);
        this.cfe.a(this.cfi, this.cfm).rO();
    }

    private void aiE() {
        this.cfj = new ArrayList<>();
        int qf = com.baidu.tbadk.core.n.qc().qf();
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.image_quality_auto_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.image_quality_auto_menu_desc), qf == 0));
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_high_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.image_quality_high_menu_desc), qf == 1));
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.image_quality_mid_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.image_quality_mid_menu_desc), qf == 2));
        this.cfj.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_low_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.image_quality_low_menu_desc), qf == 3));
        this.cfd = new com.baidu.tbadk.core.dialog.i(this.ceU.getPageContext()).bC(com.baidu.tieba.t.upload_image_quality);
        this.cfd.a(this.cfj, this.cfn).rO();
    }

    private void aiF() {
        this.cfk = new ArrayList<>();
        int qd = com.baidu.tbadk.core.n.qc().qd();
        this.cfk.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.view_image_quality_auto_menu), this.ceU.getPageContext().getString(com.baidu.tieba.t.is_wifiopen_dialog), qd == 0));
        this.cfk.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.is_alwaysopen), null, qd == 1));
        this.cfk.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.is_close), null, qd == 2));
        this.cff = new com.baidu.tbadk.core.dialog.i(this.ceU.getPageContext()).bC(com.baidu.tieba.t.show_photo);
        this.cff.a(this.cfk, this.cfo).rO();
    }

    private void aiG() {
        this.cfg = new com.baidu.tbadk.core.dialog.i(this.ceU.getPageContext());
        this.cfh = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.font_size_big), null, fontSize == 1));
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.font_size_mid), null, fontSize == 2));
        this.cfh.add(new com.baidu.tbadk.core.dialog.m(this.ceU.getPageContext().getString(com.baidu.tieba.t.font_size_small), null, fontSize == 3));
        this.cfg.bC(com.baidu.tieba.t.font_size);
        this.cfg.a(this.cfh, this.cfp);
        this.cfg.rO();
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
        LO();
        aiJ();
        aiK();
        aiM();
        aiL();
        eJ(false);
    }

    public void aiH() {
        aiJ();
        aiK();
        aiL();
    }

    public void LO() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.ceX.mt();
        } else {
            this.ceX.mu();
        }
    }

    public void eJ(boolean z) {
        this.ceY.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.qc().qh()) {
            this.ceY.N(z);
        } else {
            this.ceY.O(z);
        }
        this.ceY.setSwitchStateChangeListener(this.cfl);
    }

    public void aiI() {
        eJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        if (!com.baidu.tbadk.core.n.qc().qg()) {
            this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_close));
        } else if (com.baidu.tbadk.core.n.qc().getViewImageQuality() == 1) {
            this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_high));
        } else if (com.baidu.tbadk.core.n.qc().getViewImageQuality() == 2) {
            this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_low));
        } else {
            this.ceZ.setTip(this.mContext.getString(com.baidu.tieba.t.view_auto));
        }
    }

    private void aiK() {
        iw(com.baidu.tbadk.core.n.qc().qf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iw(int i) {
        switch (i) {
            case 0:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.view_auto));
                return;
            case 1:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.view_high));
                return;
            case 2:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.view_mid));
                return;
            case 3:
                this.cfa.setTip(this.mContext.getString(com.baidu.tieba.t.view_low));
                return;
            default:
                return;
        }
    }

    public void aiL() {
        switch (com.baidu.tbadk.core.n.qc().qd()) {
            case 0:
                this.cfb.setTip(this.mContext.getString(com.baidu.tieba.t.is_wifiopen));
                return;
            case 1:
                this.cfb.setTip(this.mContext.getString(com.baidu.tieba.t.is_alwaysopen));
                return;
            case 2:
                this.cfb.setTip(this.mContext.getString(com.baidu.tieba.t.is_close));
                return;
            default:
                return;
        }
    }

    public void aiM() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cfc.setTip(this.mContext.getString(com.baidu.tieba.t.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cfc.setTip(this.mContext.getString(com.baidu.tieba.t.font_size_mid));
        } else {
            this.cfc.setTip(this.mContext.getString(com.baidu.tieba.t.font_size_small));
        }
    }
}
