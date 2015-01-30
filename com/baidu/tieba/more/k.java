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
    private final DialogInterface.OnClickListener bvB;
    private BrowseSettingActivity bvl;
    private SettingTextSwitchView bvm;
    private SettingTextSwitchView bvn;
    private TbSettingTextTipView bvo;
    private TbSettingTextTipView bvp;
    private TbSettingTextTipView bvq;
    private TbSettingTextTipView bvr;
    private AlertDialog bvs;
    private AlertDialog bvt;
    private final AlertDialog bvu;
    private AlertDialog bvv;
    private AlertDialog bvw;
    private final com.baidu.adp.widget.BdSwitchView.c bvx;
    private final DialogInterface.OnClickListener bvy;
    private final DialogInterface.OnClickListener bvz;
    Handler mHandler;
    private NavigationBar mNavigationBar;
    private RelativeLayout mParent;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.bvl = null;
        this.mParent = null;
        this.mNavigationBar = null;
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
        this.bvw = null;
        this.bvx = new l(this);
        this.bvy = new m(this);
        this.bvz = new n(this);
        this.bvA = new o(this);
        this.bvB = new p(this);
        this.mHandler = new Handler();
        this.bvl = browseSettingActivity;
        initUI();
        pJ();
        Ke();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.bvm.da(i);
        this.bvn.da(i);
        this.bvl.getLayoutMode().ab(i == 1);
        this.bvl.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView UU() {
        return this.bvp;
    }

    public TbSettingTextTipView UV() {
        return this.bvo;
    }

    public TbSettingTextTipView UW() {
        return null;
    }

    public TbSettingTextTipView UX() {
        return this.bvq;
    }

    public TbSettingTextTipView UY() {
        return this.bvr;
    }

    public void UZ() {
        Vf();
        this.bvs.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvs, this.bvl.getPageContext());
    }

    public void Va() {
        Ve();
        this.bvt.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvt, this.bvl.getPageContext());
    }

    public void Vb() {
        Vg();
        this.bvu.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvu, this.bvl.getPageContext());
    }

    public void Vc() {
        Vh();
        this.bvv.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvv, this.bvl.getPageContext());
    }

    public void Vd() {
        Vi();
        this.bvw.setCanceledOnTouchOutside(true);
        com.baidu.adp.lib.g.k.a(this.bvw, this.bvl.getPageContext());
    }

    private void initUI() {
        this.bvl.setContentView(com.baidu.tieba.x.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.bvl.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.bvl.getPageContext().getString(com.baidu.tieba.z.browse_setting));
        this.bvm = (SettingTextSwitchView) this.bvl.findViewById(com.baidu.tieba.w.eyeshield_mode);
        this.bvn = (SettingTextSwitchView) this.bvl.findViewById(com.baidu.tieba.w.img_thrift_setting);
        this.bvo = (TbSettingTextTipView) this.bvl.findViewById(com.baidu.tieba.w.img_browser);
        this.bvp = (TbSettingTextTipView) this.bvl.findViewById(com.baidu.tieba.w.img_upload);
        this.bvq = (TbSettingTextTipView) this.bvl.findViewById(com.baidu.tieba.w.show_image);
        this.bvr = (TbSettingTextTipView) this.bvl.findViewById(com.baidu.tieba.w.font_size);
        this.mParent = (RelativeLayout) this.bvl.findViewById(com.baidu.tieba.w.parent);
    }

    private void Ke() {
        this.bvo.setOnClickListener(this.bvl);
        this.bvp.setOnClickListener(this.bvl);
        this.bvm.setSwitchStateChangeListener(this.bvl);
        this.bvq.setOnClickListener(this.bvl);
        this.bvr.setOnClickListener(this.bvl);
    }

    private void Ve() {
        if (this.bvt == null) {
            SpannableString spannableString = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.view_image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_low_menu));
            spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
            SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.z.view_image_quality_close_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 2, spannableString4.length(), 18);
            this.bvt = new AlertDialog.Builder(this.bvl.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.browser_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bvy).create();
        }
    }

    private void Vf() {
        if (this.bvs == null) {
            SpannableString spannableString = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.image_quality_auto_menu));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            SpannableString spannableString2 = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.image_quality_high_menu));
            spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
            SpannableString spannableString3 = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.image_quality_mid_menu));
            SpannableString spannableString4 = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.image_quality_low_menu));
            spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString4.length(), 18);
            this.bvs = new AlertDialog.Builder(this.bvl.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.upload_image_quality).setItems(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.bvz).create();
        }
    }

    private void Vg() {
        if (this.bvu == null) {
            int applyDimension = (int) TypedValue.applyDimension(2, 14.0f, this.mContext.getResources().getDisplayMetrics());
            SpannableString spannableString = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.is_flowmode_close));
            spannableString.setSpan(new AbsoluteSizeSpan(applyDimension), 3, spannableString.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.is_flowmode_2g3gopen));
            spannableString2.setSpan(new AbsoluteSizeSpan(applyDimension), 12, spannableString2.length(), 33);
            SpannableString spannableString3 = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.is_flowmode_alwaysopen));
            spannableString3.setSpan(new AbsoluteSizeSpan(applyDimension), 4, spannableString3.length(), 33);
        }
    }

    private void Vh() {
        if (this.bvv == null) {
            SpannableString spannableString = new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.is_wifiopen_dialog));
            spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
            this.bvv = new AlertDialog.Builder(this.bvl.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.show_photo).setItems(new CharSequence[]{spannableString, new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.is_alwaysopen)), new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.is_close))}, this.bvA).create();
        }
    }

    private void Vi() {
        if (this.bvw == null) {
            this.bvw = new AlertDialog.Builder(this.bvl.getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.font_size).setItems(new CharSequence[]{new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.font_size_big)), new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.font_size_mid)), new SpannableString(this.bvl.getPageContext().getString(com.baidu.tieba.z.font_size_small))}, this.bvB).create();
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

    public void pJ() {
        Hv();
        Vl();
        Vm();
        Vo();
        Vn();
        dz(false);
    }

    public void Vj() {
        Vl();
        Vm();
        Vn();
    }

    public void Hv() {
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.bvm.iL();
        } else {
            this.bvm.iM();
        }
    }

    public void dz(boolean z) {
        this.bvn.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.mc().mh()) {
            this.bvn.M(z);
        } else {
            this.bvn.N(z);
        }
        this.bvn.setSwitchStateChangeListener(this.bvx);
    }

    public void Vk() {
        dz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (!com.baidu.tbadk.core.l.mc().mg()) {
            this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_close));
        } else if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 1) {
            this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_high));
        } else if (com.baidu.tbadk.core.l.mc().getViewImageQuality() == 2) {
            this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_low));
        } else {
            this.bvo.setTip(this.mContext.getString(com.baidu.tieba.z.view_auto));
        }
    }

    private void Vm() {
        gU(com.baidu.tbadk.core.l.mc().mf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU(int i) {
        switch (i) {
            case 0:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.view_auto));
                return;
            case 1:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.view_high));
                return;
            case 2:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.view_mid));
                return;
            case 3:
                this.bvp.setTip(this.mContext.getString(com.baidu.tieba.z.view_low));
                return;
            default:
                return;
        }
    }

    public void Vn() {
        switch (com.baidu.tbadk.core.l.mc().md()) {
            case 0:
                this.bvq.setTip(this.mContext.getString(com.baidu.tieba.z.is_wifiopen));
                return;
            case 1:
                this.bvq.setTip(this.mContext.getString(com.baidu.tieba.z.is_alwaysopen));
                return;
            case 2:
                this.bvq.setTip(this.mContext.getString(com.baidu.tieba.z.is_close));
                return;
            default:
                return;
        }
    }

    public void Vo() {
        if (TbadkCoreApplication.m255getInst().getFontSize() == 1) {
            this.bvr.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_big));
        } else if (TbadkCoreApplication.m255getInst().getFontSize() == 2) {
            this.bvr.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_mid));
        } else {
            this.bvr.setTip(this.mContext.getString(com.baidu.tieba.z.font_size_small));
        }
    }
}
