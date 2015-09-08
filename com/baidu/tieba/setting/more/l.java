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
    private SettingTextSwitchView cFA;
    private TbSettingTextTipView cFB;
    private TbSettingTextTipView cFC;
    private TbSettingTextTipView cFD;
    private TbSettingTextTipView cFE;
    private com.baidu.tbadk.core.dialog.e cFF;
    private com.baidu.tbadk.core.dialog.e cFG;
    private com.baidu.tbadk.core.dialog.e cFH;
    private com.baidu.tbadk.core.dialog.e cFI;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cFJ;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cFK;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cFL;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cFM;
    private final BdSwitchView.a cFN;
    private final AdapterView.OnItemClickListener cFO;
    private final AdapterView.OnItemClickListener cFP;
    private final AdapterView.OnItemClickListener cFQ;
    private final AdapterView.OnItemClickListener cFR;
    private BrowseSettingActivity cFw;
    private View cFx;
    private RelativeLayout cFy;
    private BdSwitchView cFz;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cFw = null;
        this.LR = null;
        this.mNavigationBar = null;
        this.cFx = null;
        this.cFy = null;
        this.cFz = null;
        this.cFA = null;
        this.cFB = null;
        this.cFC = null;
        this.cFD = null;
        this.cFE = null;
        this.cFF = null;
        this.cFG = null;
        this.cFH = null;
        this.cFI = null;
        this.cFN = new m(this);
        this.cFO = new n(this);
        this.cFP = new o(this);
        this.cFQ = new p(this);
        this.cFR = new q(this);
        this.mHandler = new Handler();
        this.cFw = browseSettingActivity;
        initUI();
        uL();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.cFA.dE(i);
        this.cFw.getLayoutMode().ad(i == 1);
        this.cFw.getLayoutMode().k(this.LR);
        this.cFz.a(com.baidu.tbadk.core.util.al.cu(i.e.bg_switch_open), com.baidu.tbadk.core.util.al.cu(i.e.bg_switch_close), com.baidu.tbadk.core.util.al.cu(i.e.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView apc() {
        return this.cFC;
    }

    public TbSettingTextTipView apd() {
        return this.cFB;
    }

    public TbSettingTextTipView ape() {
        return this.cFD;
    }

    public TbSettingTextTipView apf() {
        return this.cFE;
    }

    public void apg() {
        apl();
        this.cFF.sZ();
    }

    public void aph() {
        apk();
        this.cFG.sZ();
    }

    public void api() {
        apm();
        this.cFH.sZ();
    }

    public void apj() {
        apn();
        this.cFI.sZ();
    }

    private void initUI() {
        this.cFw.setContentView(i.g.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cFw.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cFw.getPageContext().getString(i.h.browse_setting));
        this.cFy = (RelativeLayout) this.cFw.findViewById(i.f.eyeshield_mode);
        this.cFz = (BdSwitchView) this.cFw.findViewById(i.f.item_switch);
        com.baidu.adp.lib.util.k.a(this.cFw.getPageContext().getPageActivity(), this.cFz, 10, 10, 10, 10);
        this.cFx = this.cFw.findViewById(i.f.divide_view2);
        this.cFA = (SettingTextSwitchView) this.cFw.findViewById(i.f.img_thrift_setting);
        this.cFB = (TbSettingTextTipView) this.cFw.findViewById(i.f.img_browser);
        this.cFC = (TbSettingTextTipView) this.cFw.findViewById(i.f.img_upload);
        this.cFD = (TbSettingTextTipView) this.cFw.findViewById(i.f.show_image);
        this.cFE = (TbSettingTextTipView) this.cFw.findViewById(i.f.font_size);
        this.LR = this.cFw.findViewById(i.f.parent);
        if (!MA()) {
            this.cFx.setVisibility(8);
            this.cFy.setVisibility(8);
            return;
        }
        this.cFx.setVisibility(0);
        this.cFy.setVisibility(0);
    }

    public boolean MA() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    private void initListener() {
        this.cFB.setOnClickListener(this.cFw);
        this.cFC.setOnClickListener(this.cFw);
        this.cFz.setOnSwitchStateChangeListener(this.cFw);
        this.cFD.setOnClickListener(this.cFw);
        this.cFE.setOnClickListener(this.cFw);
    }

    private void apk() {
        this.cFK = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.m.rb().getViewImageQuality();
        boolean rf = com.baidu.tbadk.core.m.rb().rf();
        this.cFK.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cFw.getPageContext().getString(i.h.view_image_quality_auto_menu_desc), rf && viewImageQuality == 0));
        this.cFK.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_high_menu), this.cFw.getPageContext().getString(i.h.view_image_quality_high_menu_desc), rf && viewImageQuality == 1));
        this.cFK.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_low_menu), this.cFw.getPageContext().getString(i.h.view_image_quality_low_menu_desc), rf && viewImageQuality == 2));
        this.cFK.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_close_menu), this.cFw.getPageContext().getString(i.h.view_image_quality_close_menu_desc), rf ? false : true));
        this.cFG = new com.baidu.tbadk.core.dialog.e(this.cFw.getPageContext());
        this.cFG.bN(i.h.browser_image_quality);
        this.cFG.a(this.cFK, this.cFO).sY();
    }

    private void apl() {
        this.cFL = new ArrayList<>();
        int re = com.baidu.tbadk.core.m.rb().re();
        this.cFL.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.image_quality_auto_menu), this.cFw.getPageContext().getString(i.h.image_quality_auto_menu_desc), re == 0));
        this.cFL.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_high_menu), this.cFw.getPageContext().getString(i.h.image_quality_high_menu_desc), re == 1));
        this.cFL.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.image_quality_mid_menu), this.cFw.getPageContext().getString(i.h.image_quality_mid_menu_desc), re == 2));
        this.cFL.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_low_menu), this.cFw.getPageContext().getString(i.h.image_quality_low_menu_desc), re == 3));
        this.cFF = new com.baidu.tbadk.core.dialog.e(this.cFw.getPageContext()).bN(i.h.upload_image_quality);
        this.cFF.a(this.cFL, this.cFP).sY();
    }

    private void apm() {
        this.cFM = new ArrayList<>();
        int rc = com.baidu.tbadk.core.m.rb().rc();
        this.cFM.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.view_image_quality_auto_menu), this.cFw.getPageContext().getString(i.h.is_wifiopen_dialog), rc == 0));
        this.cFM.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.is_alwaysopen), null, rc == 1));
        this.cFM.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.is_close), null, rc == 2));
        this.cFH = new com.baidu.tbadk.core.dialog.e(this.cFw.getPageContext()).bN(i.h.show_photo);
        this.cFH.a(this.cFM, this.cFQ).sY();
    }

    private void apn() {
        this.cFI = new com.baidu.tbadk.core.dialog.e(this.cFw.getPageContext());
        this.cFJ = new ArrayList<>();
        int fontSize = TbadkCoreApplication.m411getInst().getFontSize();
        this.cFJ.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.font_size_big), null, fontSize == 1));
        this.cFJ.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.font_size_mid), null, fontSize == 2));
        this.cFJ.add(new com.baidu.tbadk.core.dialog.g(this.cFw.getPageContext().getString(i.h.font_size_small), null, fontSize == 3));
        this.cFI.bN(i.h.font_size);
        this.cFI.a(this.cFJ, this.cFR);
        this.cFI.sY();
    }

    public void ka(int i) {
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
        com.baidu.tbadk.core.util.c.iu();
    }

    public void uL() {
        MD();
        apq();
        apr();
        apt();
        aps();
        fN(false);
    }

    public void apo() {
        apq();
        apr();
        aps();
    }

    public void MD() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cFz.mA();
        } else {
            this.cFz.mB();
        }
    }

    public void fN(boolean z) {
        this.cFA.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.m.rb().rg()) {
            this.cFA.O(z);
        } else {
            this.cFA.P(z);
        }
        this.cFA.setSwitchStateChangeListener(this.cFN);
    }

    public void app() {
        fN(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apq() {
        if (!com.baidu.tbadk.core.m.rb().rf()) {
            this.cFB.setTip(this.mContext.getString(i.h.view_close));
        } else if (com.baidu.tbadk.core.m.rb().getViewImageQuality() == 1) {
            this.cFB.setTip(this.mContext.getString(i.h.view_high));
        } else if (com.baidu.tbadk.core.m.rb().getViewImageQuality() == 2) {
            this.cFB.setTip(this.mContext.getString(i.h.view_low));
        } else {
            this.cFB.setTip(this.mContext.getString(i.h.view_auto));
        }
    }

    private void apr() {
        kb(com.baidu.tbadk.core.m.rb().re());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(int i) {
        switch (i) {
            case 0:
                this.cFC.setTip(this.mContext.getString(i.h.view_auto));
                return;
            case 1:
                this.cFC.setTip(this.mContext.getString(i.h.view_high));
                return;
            case 2:
                this.cFC.setTip(this.mContext.getString(i.h.view_mid));
                return;
            case 3:
                this.cFC.setTip(this.mContext.getString(i.h.view_low));
                return;
            default:
                return;
        }
    }

    public void aps() {
        switch (com.baidu.tbadk.core.m.rb().rc()) {
            case 0:
                this.cFD.setTip(this.mContext.getString(i.h.is_wifiopen));
                return;
            case 1:
                this.cFD.setTip(this.mContext.getString(i.h.is_alwaysopen));
                return;
            case 2:
                this.cFD.setTip(this.mContext.getString(i.h.is_close));
                return;
            default:
                return;
        }
    }

    public void apt() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.cFE.setTip(this.mContext.getString(i.h.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.cFE.setTip(this.mContext.getString(i.h.font_size_mid));
        } else {
            this.cFE.setTip(this.mContext.getString(i.h.font_size_small));
        }
    }
}
