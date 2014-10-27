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
    private final DialogInterface.OnClickListener bqA;
    private final DialogInterface.OnClickListener bqB;
    private final DialogInterface.OnClickListener bqC;
    private BrowseSettingActivity bqm;
    private SettingTextSwitchView bqn;
    private SettingTextSwitchView bqo;
    private TbSettingTextTipView bqp;
    private TbSettingTextTipView bqq;
    private TbSettingTextTipView bqr;
    private TbSettingTextTipView bqs;
    private AlertDialog bqt;
    private AlertDialog bqu;
    private final AlertDialog bqv;
    private AlertDialog bqw;
    private AlertDialog bqx;
    private final com.baidu.adp.widget.BdSwitchView.c bqy;
    private final DialogInterface.OnClickListener bqz;
    Handler mHandler;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public l(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity);
        this.bqm = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.bqn = null;
        this.bqo = null;
        this.bqp = null;
        this.bqq = null;
        this.bqr = null;
        this.bqs = null;
        this.bqt = null;
        this.bqu = null;
        this.bqv = null;
        this.bqw = null;
        this.bqx = null;
        this.bqy = new m(this);
        this.bqz = new n(this);
        this.bqA = new o(this);
        this.bqB = new p(this);
        this.bqC = new q(this);
        this.mHandler = new Handler();
        this.bqm = browseSettingActivity;
        initUI();
        mE();
        HJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.bqn.cu(i);
        this.bqo.cu(i);
        this.bqm.getLayoutMode().L(i == 1);
        this.bqm.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public TbSettingTextTipView Ug() {
        return this.bqq;
    }

    public TbSettingTextTipView Uh() {
        return this.bqp;
    }

    public TbSettingTextTipView Ui() {
        return null;
    }

    public TbSettingTextTipView Uj() {
        return this.bqr;
    }

    public TbSettingTextTipView Uk() {
        return this.bqs;
    }

    public void Ul() {
        Ur();
        this.bqt.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqt, this.bqm);
    }

    public void Um() {
        Uq();
        this.bqu.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqu, this.bqm);
    }

    public void Un() {
        Us();
        this.bqv.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqv, this.bqm);
    }

    public void Uo() {
        Ut();
        this.bqw.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqw, this.bqm);
    }

    public void Up() {
        Uu();
        this.bqx.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.j.a(this.bqx, this.bqm);
    }

    private void initUI() {
        this.bqm.setContentView(com.baidu.tieba.w.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.bqm.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bqm.getString(com.baidu.tieba.y.browse_setting));
        this.bqn = (SettingTextSwitchView) this.bqm.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.bqo = (SettingTextSwitchView) this.bqm.findViewById(com.baidu.tieba.v.img_thrift_setting);
        this.bqp = (TbSettingTextTipView) this.bqm.findViewById(com.baidu.tieba.v.img_browser);
        this.bqq = (TbSettingTextTipView) this.bqm.findViewById(com.baidu.tieba.v.img_upload);
        this.bqr = (TbSettingTextTipView) this.bqm.findViewById(com.baidu.tieba.v.show_image);
        this.bqs = (TbSettingTextTipView) this.bqm.findViewById(com.baidu.tieba.v.font_size);
        this.mParent = (RelativeLayout) this.bqm.findViewById(com.baidu.tieba.v.parent);
    }

    private void HJ() {
        this.bqp.setOnClickListener(this.bqm);
        this.bqq.setOnClickListener(this.bqm);
        this.bqn.setSwitchStateChangeListener(this.bqm);
        this.bqr.setOnClickListener(this.bqm);
        this.bqs.setOnClickListener(this.bqm);
    }

    private void Uq() {
        if (this.bqu == null) {
            SpannableString spannableString = new SpannableString(this.bqm.getString(com.baidu.tieba.y.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 2, spannableString4.length(), 18);
            this.bqu = new AlertDialog.Builder(this.bqm).setTitle(com.baidu.tieba.y.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bqz).create();
        }
    }

    private void Ur() {
        if (this.bqt == null) {
            SpannableString spannableString = new SpannableString(this.bqm.getString(com.baidu.tieba.y.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.bqm.getString(com.baidu.tieba.y.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.bqm, 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.bqm.getString(com.baidu.tieba.y.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.bqm.getString(com.baidu.tieba.y.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.bqm, 12.0f)), 1, spannableString4.length(), 18);
            this.bqt = new AlertDialog.Builder(this.bqm).setTitle(com.baidu.tieba.y.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bqA).create();
        }
    }

    private void Us() {
        if (this.bqv == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.mContext.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.bqm.getString(com.baidu.tieba.y.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.bqm.getString(com.baidu.tieba.y.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.bqm.getString(com.baidu.tieba.y.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
    }

    private void Ut() {
        if (this.bqw == null) {
            SpannableString spannableString = new SpannableString(this.bqm.getString(com.baidu.tieba.y.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.m.dip2px(this.mContext, 12.0f)), 5, spannableString.length(), 18);
            this.bqw = new AlertDialog.Builder(this.bqm).setTitle(com.baidu.tieba.y.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.bqm.getString(com.baidu.tieba.y.is_alwaysopen)), new SpannableString(this.bqm.getString(com.baidu.tieba.y.is_close))}, this.bqB).create();
        }
    }

    private void Uu() {
        if (this.bqx == null) {
            this.bqx = new AlertDialog.Builder(this.bqm).setTitle(com.baidu.tieba.y.font_size).setItems(new CharSequence[]{new SpannableString(this.bqm.getString(com.baidu.tieba.y.font_size_big)), new SpannableString(this.bqm.getString(com.baidu.tieba.y.font_size_mid)), new SpannableString(this.bqm.getString(com.baidu.tieba.y.font_size_small))}, this.bqC).create();
        }
    }

    public void gG(int i) {
        if (i == 1) {
            if (TbadkApplication.m251getInst().getSkinType() != 1) {
                com.baidu.tieba.aj.wk().setSkinType(i);
                onChangeSkinType(i);
                TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkApplication.m251getInst().getSkinType() != 0) {
                com.baidu.tieba.aj.wk().setSkinType(i);
                onChangeSkinType(i);
            } else {
                return;
            }
        }
        com.baidu.tbadk.core.util.d.lp();
    }

    public void mE() {
        GP();
        Uy();
        Uz();
        UB();
        UA();
        dJ(false);
    }

    public void Uv() {
        Uy();
        Uz();
        UA();
    }

    public void GP() {
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.bqn.gN();
        } else {
            this.bqn.gO();
        }
    }

    public SettingTextSwitchView Uw() {
        return this.bqn;
    }

    public void dJ(boolean z) {
        this.bqo.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.k.js().jx()) {
            this.bqo.A(z);
        } else {
            this.bqo.B(z);
        }
        this.bqo.setSwitchStateChangeListener(this.bqy);
    }

    public void Ux() {
        dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
        if (!com.baidu.tbadk.core.k.js().jw()) {
            this.bqp.setTip(this.mContext.getString(com.baidu.tieba.y.view_close));
        } else if (com.baidu.tbadk.core.k.js().getViewImageQuality() == 1) {
            this.bqp.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
        } else if (com.baidu.tbadk.core.k.js().getViewImageQuality() == 2) {
            this.bqp.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
        } else {
            this.bqp.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uz() {
        switch (com.baidu.tbadk.core.k.js().jv()) {
            case 0:
                this.bqq.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
                return;
            case 1:
                this.bqq.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
                return;
            case 2:
                this.bqq.setTip(this.mContext.getString(com.baidu.tieba.y.view_mid));
                return;
            case 3:
                this.bqq.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
                return;
            default:
                return;
        }
    }

    public void UA() {
        switch (com.baidu.tbadk.core.k.js().jt()) {
            case 0:
                this.bqr.setTip(this.mContext.getString(com.baidu.tieba.y.is_wifiopen));
                return;
            case 1:
                this.bqr.setTip(this.mContext.getString(com.baidu.tieba.y.is_alwaysopen));
                return;
            case 2:
                this.bqr.setTip(this.mContext.getString(com.baidu.tieba.y.is_close));
                return;
            default:
                return;
        }
    }

    public void UB() {
        if (TbadkApplication.m251getInst().getFontSize() == 1) {
            this.bqs.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_big));
        } else if (TbadkApplication.m251getInst().getFontSize() == 2) {
            this.bqs.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_mid));
        } else {
            this.bqs.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_small));
        }
    }
}
