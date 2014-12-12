package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g<BrowseSettingActivity> {
    private BrowseSettingActivity btO;
    private SettingTextSwitchView btP;
    private SettingTextSwitchView btQ;
    private TbSettingTextTipView btR;
    private TbSettingTextTipView btS;
    private TbSettingTextTipView btT;
    private TbSettingTextTipView btU;
    private AlertDialog btV;
    private AlertDialog btW;
    private final AlertDialog btX;
    private AlertDialog btY;
    private AlertDialog btZ;
    private final com.baidu.adp.widget.BdSwitchView.c bua;
    private final DialogInterface.OnClickListener bub;
    private final DialogInterface.OnClickListener buc;
    private final DialogInterface.OnClickListener bud;
    private final DialogInterface.OnClickListener bue;
    Handler mHandler;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.btO = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.btP = null;
        this.btQ = null;
        this.btR = null;
        this.btS = null;
        this.btT = null;
        this.btU = null;
        this.btV = null;
        this.btW = null;
        this.btX = null;
        this.btY = null;
        this.btZ = null;
        this.bua = new l(this);
        this.bub = new m(this);
        this.buc = new n(this);
        this.bud = new o(this);
        this.bue = new p(this);
        this.mHandler = new Handler();
        this.btO = browseSettingActivity;
        initUI();
        py();
        JJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.btP.cT(i);
        this.btQ.cT(i);
        this.btO.getLayoutMode().ab(i == 1);
        this.btO.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView Uw() {
        return this.btS;
    }

    public TbSettingTextTipView Ux() {
        return this.btR;
    }

    public TbSettingTextTipView Uy() {
        return null;
    }

    public TbSettingTextTipView Uz() {
        return this.btT;
    }

    public TbSettingTextTipView UA() {
        return this.btU;
    }

    public void UB() {
        UH();
        this.btV.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.btV, this.btO.getPageContext());
    }

    public void UC() {
        UG();
        this.btW.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.btW, this.btO.getPageContext());
    }

    public void UD() {
        UI();
        this.btX.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.btX, this.btO.getPageContext());
    }

    public void UE() {
        UJ();
        this.btY.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.btY, this.btO.getPageContext());
    }

    public void UF() {
        UK();
        this.btZ.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.btZ, this.btO.getPageContext());
    }

    private void initUI() {
        this.btO.setContentView(com.baidu.tieba.x.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.btO.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.btO.getPageContext().getString(com.baidu.tieba.z.browse_setting));
        this.btP = (SettingTextSwitchView) this.btO.findViewById(com.baidu.tieba.w.eyeshield_mode);
        this.btQ = (SettingTextSwitchView) this.btO.findViewById(com.baidu.tieba.w.img_thrift_setting);
        this.btR = (TbSettingTextTipView) this.btO.findViewById(com.baidu.tieba.w.img_browser);
        this.btS = (TbSettingTextTipView) this.btO.findViewById(com.baidu.tieba.w.img_upload);
        this.btT = (TbSettingTextTipView) this.btO.findViewById(com.baidu.tieba.w.show_image);
        this.btU = (TbSettingTextTipView) this.btO.findViewById(com.baidu.tieba.w.font_size);
        this.mParent = (RelativeLayout) this.btO.findViewById(com.baidu.tieba.w.parent);
    }

    private void JJ() {
        this.btR.setOnClickListener(this.btO);
        this.btS.setOnClickListener(this.btO);
        this.btP.setSwitchStateChangeListener(this.btO);
        this.btT.setOnClickListener(this.btO);
        this.btU.setOnClickListener(this.btO);
    }

    private void UG() {
        if (this.btW == null) {
            SpannableString spannableString = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 2, spannableString4.length(), 18);
            this.btW = new AlertDialog.Builder(this.btO.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bub).create();
        }
    }

    private void UH() {
        if (this.btV == null) {
            SpannableString spannableString = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString4.length(), 18);
            this.btV = new AlertDialog.Builder(this.btO.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.buc).create();
        }
    }

    private void UI() {
        if (this.btX == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.mContext.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
    }

    private void UJ() {
        if (this.btY == null) {
            SpannableString spannableString = new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            this.btY = new AlertDialog.Builder(this.btO.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.is_alwaysopen)), new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.is_close))}, this.bud).create();
        }
    }

    private void UK() {
        if (this.btZ == null) {
            this.btZ = new AlertDialog.Builder(this.btO.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.font_size).setItems(new CharSequence[]{new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.font_size_big)), new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.font_size_mid)), new SpannableString(this.btO.getPageContext().getString(com.baidu.tieba.z.font_size_small))}, this.bue).create();
        }
    }

    public void gK(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.m255getInst().getSkinType() != 1) {
                TbadkCoreApplication.m255getInst().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.m255getInst().getSkinType() != 0) {
                TbadkCoreApplication.m255getInst().setSkinType(i);
                onChangeSkinType(i);
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.d.eT();
    }

    public void py() {
        GX();
        UN();
        UO();
        UQ();
        UP();
        du(false);
    }

    public void UL() {
        UN();
        UO();
        UP();
    }

    public void GX() {
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.btP.iK();
        } else {
            this.btP.iL();
        }
    }

    public void du(boolean z) {
        this.btQ.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.mc().mh()) {
            this.btQ.M(z);
        } else {
            this.btQ.N(z);
        }
        this.btQ.setSwitchStateChangeListener(this.bua);
    }

    public void UM() {
        du(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UN() {
        if (!com.baidu.tbadk.core.l.mc().mg()) {
            this.btR.setTip(this.mContext.getString(com.baidu.tieba.z.view_close));
        } else if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 1) {
            this.btR.setTip(this.mContext.getString(com.baidu.tieba.z.view_high));
        } else if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 2) {
            this.btR.setTip(this.mContext.getString(com.baidu.tieba.z.view_low));
        } else {
            this.btR.setTip(this.mContext.getString(com.baidu.tieba.z.view_auto));
        }
    }

    private void UO() {
        gL(com.baidu.tbadk.core.l.mc().mf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL(int i) {
        switch (i) {
            case 0:
                this.btS.setTip(this.mContext.getString(com.baidu.tieba.z.view_auto));
                return;
            case 1:
                this.btS.setTip(this.mContext.getString(com.baidu.tieba.z.view_high));
                return;
            case 2:
                this.btS.setTip(this.mContext.getString(com.baidu.tieba.z.view_mid));
                return;
            case 3:
                this.btS.setTip(this.mContext.getString(com.baidu.tieba.z.view_low));
                return;
            default:
                return;
        }
    }

    public void UP() {
        switch (com.baidu.tbadk.core.l.mc().md()) {
            case 0:
                this.btT.setTip(this.mContext.getString(com.baidu.tieba.z.is_wifiopen));
                return;
            case 1:
                this.btT.setTip(this.mContext.getString(com.baidu.tieba.z.is_alwaysopen));
                return;
            case 2:
                this.btT.setTip(this.mContext.getString(com.baidu.tieba.z.is_close));
                return;
            default:
                return;
        }
    }

    public void UQ() {
        if (TbadkCoreApplication.m255getInst().getFontSize() == 1) {
            this.btU.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_big));
        } else if (TbadkCoreApplication.m255getInst().getFontSize() == 2) {
            this.btU.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_mid));
        } else {
            this.btU.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_small));
        }
    }
}
