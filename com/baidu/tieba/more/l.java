package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f {
    private BrowseSettingActivity bqA;
    private SettingTextSwitchView bqB;
    private SettingTextSwitchView bqC;
    private TbSettingTextTipView bqD;
    private TbSettingTextTipView bqE;
    private TbSettingTextTipView bqF;
    private TbSettingTextTipView bqG;
    private AlertDialog bqH;
    private AlertDialog bqI;
    private final AlertDialog bqJ;
    private AlertDialog bqK;
    private AlertDialog bqL;
    private final com.baidu.adp.widget.BdSwitchView.c bqM;
    private final DialogInterface.OnClickListener bqN;
    private final DialogInterface.OnClickListener bqO;
    private final DialogInterface.OnClickListener bqP;
    private final DialogInterface.OnClickListener bqQ;
    Handler mHandler;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity);
        this.bqA = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.bqB = null;
        this.bqC = null;
        this.bqD = null;
        this.bqE = null;
        this.bqF = null;
        this.bqG = null;
        this.bqH = null;
        this.bqI = null;
        this.bqJ = null;
        this.bqK = null;
        this.bqL = null;
        this.bqM = new m(this);
        this.bqN = new n(this);
        this.bqO = new o(this);
        this.bqP = new p(this);
        this.bqQ = new q(this);
        this.mHandler = new Handler();
        this.bqA = browseSettingActivity;
        initUI();
        mE();
        HN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.bqB.cu(i);
        this.bqC.cu(i);
        this.bqA.getLayoutMode().L(i == 1);
        this.bqA.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public TbSettingTextTipView Uj() {
        return this.bqE;
    }

    public TbSettingTextTipView Uk() {
        return this.bqD;
    }

    public TbSettingTextTipView Ul() {
        return null;
    }

    public TbSettingTextTipView Um() {
        return this.bqF;
    }

    public TbSettingTextTipView Un() {
        return this.bqG;
    }

    public void Uo() {
        Uu();
        this.bqH.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqH, this.bqA);
    }

    public void Up() {
        Ut();
        this.bqI.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqI, this.bqA);
    }

    public void Uq() {
        Uv();
        this.bqJ.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqJ, this.bqA);
    }

    public void Ur() {
        Uw();
        this.bqK.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqK, this.bqA);
    }

    public void Us() {
        Ux();
        this.bqL.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqL, this.bqA);
    }

    private void initUI() {
        this.bqA.setContentView(com.baidu.tieba.w.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.bqA.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bqA.getString(com.baidu.tieba.y.browse_setting));
        this.bqB = (SettingTextSwitchView) this.bqA.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.bqC = (SettingTextSwitchView) this.bqA.findViewById(com.baidu.tieba.v.img_thrift_setting);
        this.bqD = (TbSettingTextTipView) this.bqA.findViewById(com.baidu.tieba.v.img_browser);
        this.bqE = (TbSettingTextTipView) this.bqA.findViewById(com.baidu.tieba.v.img_upload);
        this.bqF = (TbSettingTextTipView) this.bqA.findViewById(com.baidu.tieba.v.show_image);
        this.bqG = (TbSettingTextTipView) this.bqA.findViewById(com.baidu.tieba.v.font_size);
        this.mParent = (RelativeLayout) this.bqA.findViewById(com.baidu.tieba.v.parent);
    }

    private void HN() {
        this.bqD.setOnClickListener(this.bqA);
        this.bqE.setOnClickListener(this.bqA);
        this.bqB.setSwitchStateChangeListener(this.bqA);
        this.bqF.setOnClickListener(this.bqA);
        this.bqG.setOnClickListener(this.bqA);
    }

    private void Ut() {
        if (this.bqI == null) {
            SpannableString spannableString = new SpannableString(this.bqA.getString(com.baidu.tieba.y.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 2, spannableString4.length(), 18);
            this.bqI = new AlertDialog.Builder(this.bqA).setTitle(com.baidu.tieba.y.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bqN).create();
        }
    }

    private void Uu() {
        if (this.bqH == null) {
            SpannableString spannableString = new SpannableString(this.bqA.getString(com.baidu.tieba.y.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.bqA.getString(com.baidu.tieba.y.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.bqA, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.bqA.getString(com.baidu.tieba.y.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.bqA.getString(com.baidu.tieba.y.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.bqA, 12.0f)), 1, spannableString4.length(), 18);
            this.bqH = new AlertDialog.Builder(this.bqA).setTitle(com.baidu.tieba.y.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bqO).create();
        }
    }

    private void Uv() {
        if (this.bqJ == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.mContext.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.bqA.getString(com.baidu.tieba.y.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.bqA.getString(com.baidu.tieba.y.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.bqA.getString(com.baidu.tieba.y.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
    }

    private void Uw() {
        if (this.bqK == null) {
            SpannableString spannableString = new SpannableString(this.bqA.getString(com.baidu.tieba.y.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            this.bqK = new AlertDialog.Builder(this.bqA).setTitle(com.baidu.tieba.y.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.bqA.getString(com.baidu.tieba.y.is_alwaysopen)), new SpannableString(this.bqA.getString(com.baidu.tieba.y.is_close))}, this.bqP).create();
        }
    }

    private void Ux() {
        if (this.bqL == null) {
            this.bqL = new AlertDialog.Builder(this.bqA).setTitle(com.baidu.tieba.y.font_size).setItems(new CharSequence[]{new SpannableString(this.bqA.getString(com.baidu.tieba.y.font_size_big)), new SpannableString(this.bqA.getString(com.baidu.tieba.y.font_size_mid)), new SpannableString(this.bqA.getString(com.baidu.tieba.y.font_size_small))}, this.bqQ).create();
        }
    }

    public void gG(int i) {
        if (i == 1) {
            if (TbadkApplication.m251getInst().getSkinType() != 1) {
                com.baidu.tieba.aj.wm().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkApplication.m251getInst().getSkinType() != 0) {
                com.baidu.tieba.aj.wm().setSkinType(i);
                onChangeSkinType(i);
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.d.lp();
    }

    public void mE() {
        GR();
        UB();
        UC();
        UE();
        UD();
        dJ(false);
    }

    public void Uy() {
        UB();
        UC();
        UD();
    }

    public void GR() {
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.bqB.gN();
        } else {
            this.bqB.gO();
        }
    }

    public SettingTextSwitchView Uz() {
        return this.bqB;
    }

    public void dJ(boolean z) {
        this.bqC.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.js().jx()) {
            this.bqC.A(z);
        } else {
            this.bqC.B(z);
        }
        this.bqC.setSwitchStateChangeListener(this.bqM);
    }

    public void UA() {
        dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UB() {
        if (!com.baidu.tbadk.core.l.js().jw()) {
            this.bqD.setTip(this.mContext.getString(com.baidu.tieba.y.view_close));
        } else if (com.baidu.tbadk.core.l.js().getViewImageQuality() == 1) {
            this.bqD.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
        } else if (com.baidu.tbadk.core.l.js().getViewImageQuality() == 2) {
            this.bqD.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
        } else {
            this.bqD.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UC() {
        switch (com.baidu.tbadk.core.l.js().jv()) {
            case 0:
                this.bqE.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
                return;
            case 1:
                this.bqE.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
                return;
            case 2:
                this.bqE.setTip(this.mContext.getString(com.baidu.tieba.y.view_mid));
                return;
            case 3:
                this.bqE.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
                return;
            default:
                return;
        }
    }

    public void UD() {
        switch (com.baidu.tbadk.core.l.js().jt()) {
            case 0:
                this.bqF.setTip(this.mContext.getString(com.baidu.tieba.y.is_wifiopen));
                return;
            case 1:
                this.bqF.setTip(this.mContext.getString(com.baidu.tieba.y.is_alwaysopen));
                return;
            case 2:
                this.bqF.setTip(this.mContext.getString(com.baidu.tieba.y.is_close));
                return;
            default:
                return;
        }
    }

    public void UE() {
        if (TbadkApplication.m251getInst().getFontSize() == 1) {
            this.bqG.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_big));
        } else if (TbadkApplication.m251getInst().getFontSize() == 2) {
            this.bqG.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_mid));
        } else {
            this.bqG.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_small));
        }
    }
}
