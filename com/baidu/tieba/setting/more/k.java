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
    private RelativeLayout aWN;
    private BrowseSettingActivity cai;
    private View caj;
    private RelativeLayout cak;
    private BdSwitchView cal;
    private SettingTextSwitchView cam;
    private TbSettingTextTipView can;
    private TbSettingTextTipView cao;
    private TbSettingTextTipView cap;
    private TbSettingTextTipView caq;
    private com.baidu.tbadk.core.dialog.e car;
    private com.baidu.tbadk.core.dialog.e cas;
    private com.baidu.tbadk.core.dialog.e cat;
    private com.baidu.tbadk.core.dialog.e cau;
    private final com.baidu.adp.widget.BdSwitchView.b cav;
    private final com.baidu.tbadk.core.dialog.h caw;
    private final com.baidu.tbadk.core.dialog.h cax;
    private final com.baidu.tbadk.core.dialog.h cay;
    private final com.baidu.tbadk.core.dialog.h caz;
    Handler mHandler;
    private NavigationBar mNavigationBar;

    public k(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.cai = null;
        this.aWN = null;
        this.mNavigationBar = null;
        this.caj = null;
        this.cak = null;
        this.cal = null;
        this.cam = null;
        this.can = null;
        this.cao = null;
        this.cap = null;
        this.caq = null;
        this.car = null;
        this.cas = null;
        this.cat = null;
        this.cau = null;
        this.cav = new l(this);
        this.caw = new m(this);
        this.cax = new n(this);
        this.cay = new o(this);
        this.caz = new p(this);
        this.mHandler = new Handler();
        this.cai = browseSettingActivity;
        initUI();
        sZ();
        HB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.cam.dc(i);
        this.cai.getLayoutMode().X(i == 1);
        this.cai.getLayoutMode().h(this.aWN);
        this.cal.a(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_open), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.bg_game_switch_close), com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.btn_game_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView agm() {
        return this.cao;
    }

    public TbSettingTextTipView agn() {
        return this.can;
    }

    public TbSettingTextTipView ago() {
        return this.cap;
    }

    public TbSettingTextTipView agp() {
        return this.caq;
    }

    public void agq() {
        agv();
        this.car.rg();
    }

    public void agr() {
        agu();
        this.cas.rg();
    }

    public void ags() {
        agw();
        this.cat.rg();
    }

    public void agt() {
        agx();
        this.cau.rg();
    }

    private void initUI() {
        this.cai.setContentView(com.baidu.tieba.w.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.cai.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.cai.getPageContext().getString(com.baidu.tieba.y.browse_setting));
        this.cak = (RelativeLayout) this.cai.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.cal = (BdSwitchView) this.cai.findViewById(com.baidu.tieba.v.item_switch);
        com.baidu.adp.lib.util.n.a(this.cai.getPageContext().getPageActivity(), this.cal, 10, 10, 10, 10);
        this.caj = this.cai.findViewById(com.baidu.tieba.v.divide_view2);
        this.cam = (SettingTextSwitchView) this.cai.findViewById(com.baidu.tieba.v.img_thrift_setting);
        this.can = (TbSettingTextTipView) this.cai.findViewById(com.baidu.tieba.v.img_browser);
        this.cao = (TbSettingTextTipView) this.cai.findViewById(com.baidu.tieba.v.img_upload);
        this.cap = (TbSettingTextTipView) this.cai.findViewById(com.baidu.tieba.v.show_image);
        this.caq = (TbSettingTextTipView) this.cai.findViewById(com.baidu.tieba.v.font_size);
        this.aWN = (RelativeLayout) this.cai.findViewById(com.baidu.tieba.v.parent);
        if (!Kv()) {
            this.caj.setVisibility(8);
            this.cak.setVisibility(8);
            return;
        }
        this.caj.setVisibility(0);
        this.cak.setVisibility(0);
    }

    public boolean Kv() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    private void HB() {
        this.can.setOnClickListener(this.cai);
        this.cao.setOnClickListener(this.cai);
        this.cal.setOnSwitchStateChangeListener(this.cai);
        this.cap.setOnClickListener(this.cai);
        this.caq.setOnClickListener(this.cai);
    }

    private void agu() {
        SpannableString spannableString = new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.view_image_quality_auto_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_high_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_low_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
        SpannableString spannableString4 = new SpannableString(this.mContext.getString(com.baidu.tieba.y.view_image_quality_close_menu));
        spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 2, spannableString4.length(), 18);
        this.cas = new com.baidu.tbadk.core.dialog.e(this.cai.getPageContext().getPageActivity()).by(com.baidu.tieba.y.browser_image_quality).a(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.caw).d(this.cai.getPageContext());
    }

    private void agv() {
        SpannableString spannableString = new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.image_quality_auto_menu));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.image_quality_high_menu));
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString2.length(), 18);
        SpannableString spannableString3 = new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.image_quality_mid_menu));
        spannableString3.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString3.length(), 18);
        SpannableString spannableString4 = new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.image_quality_low_menu));
        spannableString4.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 1, spannableString4.length(), 18);
        this.car = new com.baidu.tbadk.core.dialog.e(this.cai.getPageContext().getPageActivity()).by(com.baidu.tieba.y.upload_image_quality).a(new CharSequence[]{spannableString, spannableString2, spannableString3, spannableString4}, this.cax).d(this.cai.getPageContext());
    }

    private void agw() {
        SpannableString spannableString = new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.is_wifiopen_dialog));
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.adp.lib.util.n.dip2px(this.mContext.getPageActivity(), 12.0f)), 5, spannableString.length(), 18);
        this.cat = new com.baidu.tbadk.core.dialog.e(this.cai.getPageContext().getPageActivity()).by(com.baidu.tieba.y.show_photo).a(new CharSequence[]{spannableString, new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.is_alwaysopen)), new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.is_close))}, this.cay).d(this.cai.getPageContext());
    }

    private void agx() {
        this.cau = new com.baidu.tbadk.core.dialog.e(this.cai.getPageContext().getPageActivity()).by(com.baidu.tieba.y.font_size).a(new CharSequence[]{new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.font_size_big)), new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.font_size_mid)), new SpannableString(this.cai.getPageContext().getString(com.baidu.tieba.y.font_size_small))}, this.caz).d(this.cai.getPageContext());
    }

    public void hU(int i) {
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
        Ky();
        agA();
        agB();
        agD();
        agC();
        es(false);
    }

    public void agy() {
        agA();
        agB();
        agC();
    }

    public void Ky() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.cal.ma();
        } else {
            this.cal.mb();
        }
    }

    public void es(boolean z) {
        this.cam.setSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.px().pC()) {
            this.cam.L(z);
        } else {
            this.cam.M(z);
        }
        this.cam.setSwitchStateChangeListener(this.cav);
    }

    public void agz() {
        es(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agA() {
        if (!com.baidu.tbadk.core.n.px().pB()) {
            this.can.setTip(this.mContext.getString(com.baidu.tieba.y.view_close));
        } else if (com.baidu.tbadk.core.n.px().getViewImageQuality() == 1) {
            this.can.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
        } else if (com.baidu.tbadk.core.n.px().getViewImageQuality() == 2) {
            this.can.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
        } else {
            this.can.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
        }
    }

    private void agB() {
        hV(com.baidu.tbadk.core.n.px().pA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hV(int i) {
        switch (i) {
            case 0:
                this.cao.setTip(this.mContext.getString(com.baidu.tieba.y.view_auto));
                return;
            case 1:
                this.cao.setTip(this.mContext.getString(com.baidu.tieba.y.view_high));
                return;
            case 2:
                this.cao.setTip(this.mContext.getString(com.baidu.tieba.y.view_mid));
                return;
            case 3:
                this.cao.setTip(this.mContext.getString(com.baidu.tieba.y.view_low));
                return;
            default:
                return;
        }
    }

    public void agC() {
        switch (com.baidu.tbadk.core.n.px().py()) {
            case 0:
                this.cap.setTip(this.mContext.getString(com.baidu.tieba.y.is_wifiopen));
                return;
            case 1:
                this.cap.setTip(this.mContext.getString(com.baidu.tieba.y.is_alwaysopen));
                return;
            case 2:
                this.cap.setTip(this.mContext.getString(com.baidu.tieba.y.is_close));
                return;
            default:
                return;
        }
    }

    public void agD() {
        if (TbadkCoreApplication.m411getInst().getFontSize() == 1) {
            this.caq.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_big));
        } else if (TbadkCoreApplication.m411getInst().getFontSize() == 2) {
            this.caq.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_mid));
        } else {
            this.caq.setTip(this.mContext.getString(com.baidu.tieba.y.font_size_small));
        }
    }
}
