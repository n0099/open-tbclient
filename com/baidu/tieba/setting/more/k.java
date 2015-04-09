package com.baidu.tieba.setting.more;

import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g<BrowseSettingActivity> {
    private RelativeLayout aXd;
    private BdSwitchView caA;
    private SettingTextSwitchView caB;
    private TbSettingTextTipView caC;
    private TbSettingTextTipView caD;
    private TbSettingTextTipView caE;
    private TbSettingTextTipView caF;
    private com.baidu.tbadk.core.dialog.e caG;
    private com.baidu.tbadk.core.dialog.e caH;
    private com.baidu.tbadk.core.dialog.e caI;
    private com.baidu.tbadk.core.dialog.e caJ;
    private final com.baidu.adp.widget.BdSwitchView.b caK;
    private final com.baidu.tbadk.core.dialog.h caL;
    private final com.baidu.tbadk.core.dialog.h caM;
    private final com.baidu.tbadk.core.dialog.h caN;
    private final com.baidu.tbadk.core.dialog.h caO;
    private BrowseSettingActivity cax;
    private View cay;
    private RelativeLayout caz;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cax = null;
        this.aXd = null;
        this.mNavigationBar = null;
        this.cay = null;
        this.caz = null;
        this.caA = null;
        this.caB = null;
        this.caC = null;
        this.caD = null;
        this.caE = null;
        this.caF = null;
        this.caG = null;
        this.caH = null;
        this.caI = null;
        this.caJ = null;
        this.caK = new l(this);
        this.caL = new m(this);
        this.caM = new n(this);
        this.caN = new o(this);
        this.caO = new p(this);
        this.mHandler = new Handler();
        this.cax = browseSettingActivity;
        initUI();
        sZ();
        HH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.caB.dc(i);
        this.cax.getLayoutMode().X(i == 1);
        this.cax.getLayoutMode().h(this.aXd);
        this.caA.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView agB() {
        return this.caD;
    }

    public TbSettingTextTipView agC() {
        return this.caC;
    }

    public TbSettingTextTipView agD() {
        return this.caE;
    }

    public TbSettingTextTipView agE() {
        return this.caF;
    }

    public void agF() {
        agK();
        this.caG.rg();
    }

    public void agG() {
        agJ();
        this.caH.rg();
    }

    public void agH() {
        agL();
        this.caI.rg();
    }

    public void agI() {
        agM();
        this.caJ.rg();
    }

    private void initUI() {
        this.cax.setContentView(com.baidu.tieba.w.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cax.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cax.getPageContext().getString(com.baidu.tieba.y.browse_setting));
        this.caz = (RelativeLayout) this.cax.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.caA = (BdSwitchView) this.cax.findViewById(com.baidu.tieba.v.item_switch);
        com.baidu.adp.lib.util.n.a(this.cax.getPageContext().getPageActivity(), this.caA, 10, 10, 10, 10);
        this.cay = this.cax.findViewById(com.baidu.tieba.v.divide_view2);
        this.caB = (SettingTextSwitchView) this.cax.findViewById(com.baidu.tieba.v.img_thrift_setting);
        this.caC = (TbSettingTextTipView) this.cax.findViewById(com.baidu.tieba.v.img_browser);
        this.caD = (TbSettingTextTipView) this.cax.findViewById(com.baidu.tieba.v.img_upload);
        this.caE = (TbSettingTextTipView) this.cax.findViewById(com.baidu.tieba.v.show_image);
        this.caF = (TbSettingTextTipView) this.cax.findViewById(com.baidu.tieba.v.font_size);
        this.aXd = (RelativeLayout) this.cax.findViewById(com.baidu.tieba.v.parent);
        if (!KF()) {
            this.cay.setVisibility(8);
            this.caz.setVisibility(8);
            return;
        }
        this.cay.setVisibility(0);
        this.caz.setVisibility(0);
    }

    public boolean KF() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void HH() {
        this.caC.setOnClickListener(this.cax);
        this.caD.setOnClickListener(this.cax);
        this.caA.setOnSwitchStateChangeListener(this.cax);
        this.caE.setOnClickListener(this.cax);
        this.caF.setOnClickListener(this.cax);
    }

    private void agJ() {
        SpannableString spannableString = new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.view_image_quality_auto_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_high_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_low_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
        SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_close_menu));
        spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 2, spannableString4.length(), 18);
        this.caH = new com.baidu.tbadk.core.dialog.e(this.cax.getPageContext().getPageActivity()).by(com.baidu.tieba.y.browser_image_quality).a(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.caL).d(this.cax.getPageContext());
    }

    private void agK() {
        SpannableString spannableString = new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.image_quality_auto_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.image_quality_high_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.image_quality_mid_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
        SpannableString spannableString4 = new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.image_quality_low_menu));
        spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString4.length(), 18);
        this.caG = new com.baidu.tbadk.core.dialog.e(this.cax.getPageContext().getPageActivity()).by(com.baidu.tieba.y.upload_image_quality).a(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.caM).d(this.cax.getPageContext());
    }

    private void agL() {
        SpannableString spannableString = new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.is_wifiopen_dialog));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
        this.caI = new com.baidu.tbadk.core.dialog.e(this.cax.getPageContext().getPageActivity()).by(com.baidu.tieba.y.show_photo).a(new CharSequence[]{spannableString, new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.is_alwaysopen)), new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.is_close))}, this.caN).d(this.cax.getPageContext());
    }

    private void agM() {
        this.caJ = new com.baidu.tbadk.core.dialog.e(this.cax.getPageContext().getPageActivity()).by(com.baidu.tieba.y.font_size).a(new CharSequence[]{new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.font_size_big)), new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.font_size_mid)), new SpannableString(this.cax.getPageContext().getString(com.baidu.tieba.y.font_size_small))}, this.caO).d(this.cax.getPageContext());
    }

    public void hX(int i) {
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

    public void sZ() {
        KI();
        agP();
        agQ();
        agS();
        agR();
        eq(false);
    }

    public void agN() {
        agP();
        agQ();
        agR();
    }

    public void KI() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.caA.ma();
        } else {
            this.caA.mb();
        }
    }

    public void eq(boolean z) {
        this.caB.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.px().pC()) {
            this.caB.L(z);
        } else {
            this.caB.M(z);
        }
        this.caB.setSwitchStateChangeListener(this.caK);
    }

    public void agO() {
        eq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agP() {
        if (!com.baidu.tbadk.core.n.px().pB()) {
            this.caC.setTip(this.mContext.getString(com.baidu.tieba.y.view_close));
        } else if (com.baidu.tbadk.core.n.px().getViewImageQuality() == 1) {
            this.caC.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
        } else if (com.baidu.tbadk.core.n.px().getViewImageQuality() == 2) {
            this.caC.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
        } else {
            this.caC.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
        }
    }

    private void agQ() {
        hY(com.baidu.tbadk.core.n.px().pA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hY(int i) {
        switch (i) {
            case 0:
                this.caD.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
                return;
            case 1:
                this.caD.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
                return;
            case 2:
                this.caD.setTip(this.mContext.getString(com.baidu.tieba.y.view_mid));
                return;
            case 3:
                this.caD.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
                return;
            default:
                return;
        }
    }

    public void agR() {
        switch (com.baidu.tbadk.core.n.px().py()) {
            case 0:
                this.caE.setTip(this.mContext.getString(com.baidu.tieba.y.is_wifiopen));
                return;
            case 1:
                this.caE.setTip(this.mContext.getString(com.baidu.tieba.y.is_alwaysopen));
                return;
            case 2:
                this.caE.setTip(this.mContext.getString(com.baidu.tieba.y.is_close));
                return;
            default:
                return;
        }
    }

    public void agS() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.caF.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.caF.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_mid));
        } else {
            this.caF.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_small));
        }
    }
}
