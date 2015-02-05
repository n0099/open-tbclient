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
    private final DialogInterface.OnClickListener bvA;
    private BrowseSettingActivity bvk;
    private SettingTextSwitchView bvl;
    private SettingTextSwitchView bvm;
    private TbSettingTextTipView bvn;
    private TbSettingTextTipView bvo;
    private TbSettingTextTipView bvp;
    private TbSettingTextTipView bvq;
    private AlertDialog bvr;
    private AlertDialog bvs;
    private final AlertDialog bvt;
    private AlertDialog bvu;
    private AlertDialog bvv;
    private final com.baidu.adp.widget.BdSwitchView.c bvw;
    private final DialogInterface.OnClickListener bvx;
    private final DialogInterface.OnClickListener bvy;
    private final DialogInterface.OnClickListener bvz;
    Handler mHandler;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.bvk = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.bvl = null;
        this.bvm = null;
        this.bvn = null;
        this.bvo = null;
        this.bvp = null;
        this.bvq = null;
        this.bvr = null;
        this.bvs = null;
        this.bvt = null;
        this.bvu = null;
        this.bvv = null;
        this.bvw = new l(this);
        this.bvx = new m(this);
        this.bvy = new n(this);
        this.bvz = new o(this);
        this.bvA = new p(this);
        this.mHandler = new Handler();
        this.bvk = browseSettingActivity;
        initUI();
        pC();
        JZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.bvl.da(i);
        this.bvm.da(i);
        this.bvk.getLayoutMode().ab(i == 1);
        this.bvk.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView UP() {
        return this.bvo;
    }

    public TbSettingTextTipView UQ() {
        return this.bvn;
    }

    public TbSettingTextTipView UR() {
        return null;
    }

    public TbSettingTextTipView US() {
        return this.bvp;
    }

    public TbSettingTextTipView UT() {
        return this.bvq;
    }

    public void UU() {
        Va();
        this.bvr.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvr, this.bvk.getPageContext());
    }

    public void UV() {
        UZ();
        this.bvs.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvs, this.bvk.getPageContext());
    }

    public void UW() {
        Vb();
        this.bvt.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvt, this.bvk.getPageContext());
    }

    public void UX() {
        Vc();
        this.bvu.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvu, this.bvk.getPageContext());
    }

    public void UY() {
        Vd();
        this.bvv.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvv, this.bvk.getPageContext());
    }

    private void initUI() {
        this.bvk.setContentView(com.baidu.tieba.x.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.bvk.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bvk.getPageContext().getString(com.baidu.tieba.z.browse_setting));
        this.bvl = (SettingTextSwitchView) this.bvk.findViewById(com.baidu.tieba.w.eyeshield_mode);
        this.bvm = (SettingTextSwitchView) this.bvk.findViewById(com.baidu.tieba.w.img_thrift_setting);
        this.bvn = (TbSettingTextTipView) this.bvk.findViewById(com.baidu.tieba.w.img_browser);
        this.bvo = (TbSettingTextTipView) this.bvk.findViewById(com.baidu.tieba.w.img_upload);
        this.bvp = (TbSettingTextTipView) this.bvk.findViewById(com.baidu.tieba.w.show_image);
        this.bvq = (TbSettingTextTipView) this.bvk.findViewById(com.baidu.tieba.w.font_size);
        this.mParent = (RelativeLayout) this.bvk.findViewById(com.baidu.tieba.w.parent);
    }

    private void JZ() {
        this.bvn.setOnClickListener(this.bvk);
        this.bvo.setOnClickListener(this.bvk);
        this.bvl.setSwitchStateChangeListener(this.bvk);
        this.bvp.setOnClickListener(this.bvk);
        this.bvq.setOnClickListener(this.bvk);
    }

    private void UZ() {
        if (this.bvs == null) {
            SpannableString spannableString = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 2, spannableString4.length(), 18);
            this.bvs = new AlertDialog.Builder(this.bvk.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bvx).create();
        }
    }

    private void Va() {
        if (this.bvr == null) {
            SpannableString spannableString = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString4.length(), 18);
            this.bvr = new AlertDialog.Builder(this.bvk.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bvy).create();
        }
    }

    private void Vb() {
        if (this.bvt == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.mContext.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
    }

    private void Vc() {
        if (this.bvu == null) {
            SpannableString spannableString = new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            this.bvu = new AlertDialog.Builder(this.bvk.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.is_alwaysopen)), new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.is_close))}, this.bvz).create();
        }
    }

    private void Vd() {
        if (this.bvv == null) {
            this.bvv = new AlertDialog.Builder(this.bvk.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.font_size).setItems(new CharSequence[]{new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.font_size_big)), new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.font_size_mid)), new SpannableString(this.bvk.getPageContext().getString(com.baidu.tieba.z.font_size_small))}, this.bvA).create();
        }
    }

    public void gT(int i) {
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
        com.baidu.tbadk.core.util.d.eS();
    }

    public void pC() {
        Hp();
        Vg();
        Vh();
        Vj();
        Vi();
        dz(false);
    }

    public void Ve() {
        Vg();
        Vh();
        Vi();
    }

    public void Hp() {
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.bvl.iE();
        } else {
            this.bvl.iF();
        }
    }

    public void dz(boolean z) {
        this.bvm.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.lV().ma()) {
            this.bvm.M(z);
        } else {
            this.bvm.N(z);
        }
        this.bvm.setSwitchStateChangeListener(this.bvw);
    }

    public void Vf() {
        dz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vg() {
        if (!com.baidu.tbadk.core.l.lV().lZ()) {
            this.bvn.setTip(this.mContext.getString(com.baidu.tieba.z.view_close));
        } else if (com.baidu.tbadk.core.l.lV().getViewImageQuality() == 1) {
            this.bvn.setTip(this.mContext.getString(com.baidu.tieba.z.view_high));
        } else if (com.baidu.tbadk.core.l.lV().getViewImageQuality() == 2) {
            this.bvn.setTip(this.mContext.getString(com.baidu.tieba.z.view_low));
        } else {
            this.bvn.setTip(this.mContext.getString(com.baidu.tieba.z.view_auto));
        }
    }

    private void Vh() {
        gU(com.baidu.tbadk.core.l.lV().lY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(int i) {
        switch (i) {
            case 0:
                this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_auto));
                return;
            case 1:
                this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_high));
                return;
            case 2:
                this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_mid));
                return;
            case 3:
                this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_low));
                return;
            default:
                return;
        }
    }

    public void Vi() {
        switch (com.baidu.tbadk.core.l.lV().lW()) {
            case 0:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.is_wifiopen));
                return;
            case 1:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.is_alwaysopen));
                return;
            case 2:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.is_close));
                return;
            default:
                return;
        }
    }

    public void Vj() {
        if (TbadkCoreApplication.m255getInst().getFontSize() == 1) {
            this.bvq.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_big));
        } else if (TbadkCoreApplication.m255getInst().getFontSize() == 2) {
            this.bvq.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_mid));
        } else {
            this.bvq.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_small));
        }
    }
}
