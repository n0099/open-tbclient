package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.o.an;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity ghI;
    private View ghJ;
    private RelativeLayout ghK;
    private BdSwitchView ghL;
    private TbSettingTextTipView ghM;
    private TbSettingTextTipView ghN;
    private TbSettingTextTipView ghO;
    private TbSettingTextTipView ghP;
    private TbSettingTextTipView ghQ;
    private com.baidu.tbadk.core.dialog.e ghR;
    private com.baidu.tbadk.core.dialog.e ghS;
    private com.baidu.tbadk.core.dialog.e ghT;
    private com.baidu.tbadk.core.dialog.e ghU;
    private com.baidu.tbadk.core.dialog.e ghV;
    private ArrayList<h> ghW;
    private ArrayList<h> ghX;
    private ArrayList<h> ghY;
    private ArrayList<h> ghZ;
    private ArrayList<h> gia;
    private final AdapterView.OnItemClickListener gib;
    private final AdapterView.OnItemClickListener gic;
    private final AdapterView.OnItemClickListener gie;
    private final AdapterView.OnItemClickListener gif;
    private final AdapterView.OnItemClickListener gig;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ghI = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.ghJ = null;
        this.ghK = null;
        this.ghL = null;
        this.ghM = null;
        this.ghN = null;
        this.ghO = null;
        this.ghP = null;
        this.ghQ = null;
        this.ghR = null;
        this.ghS = null;
        this.ghT = null;
        this.ghU = null;
        this.ghV = null;
        this.gib = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghR.refresh(i);
                switch (i) {
                    case 0:
                        i.pY().al(true);
                        i.pY().bz(0);
                        break;
                    case 1:
                        i.pY().al(true);
                        i.pY().bz(1);
                        TiebaStatic.log(new al("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.pY().al(true);
                        i.pY().bz(2);
                        TiebaStatic.log(new al("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.pY().al(false);
                        break;
                }
                b.this.ghR.dismiss();
                b.this.blK();
            }
        };
        this.gic = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                int i2 = 1;
                b.this.ghS.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new al("c10411").r("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new al("c10411").r("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new al("c10411").r("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.pY().by(i2);
                b.this.sw(i2);
            }
        };
        this.gie = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghT.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 2));
                        i.pY().bx(0);
                        break;
                    case 1:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 1));
                        i.pY().bx(1);
                        break;
                    case 2:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 3));
                        i.pY().bx(2);
                        break;
                }
                b.this.blM();
            }
        };
        this.gif = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghU.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setFontSize(0);
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setFontSize(1);
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setFontSize(2);
                        break;
                    case 3:
                        TbadkCoreApplication.getInst().setFontSize(3);
                        break;
                }
                b.this.blN();
            }
        };
        this.gig = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghV.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        break;
                }
                b.this.blO();
            }
        };
        this.ghI = browseSettingActivity;
        initUI();
        vR();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ghI.getLayoutMode().setNightMode(i == 1);
        this.ghI.getLayoutMode().u(this.mParent);
        this.ghL.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView blt() {
        return this.ghN;
    }

    public TbSettingTextTipView blu() {
        return this.ghM;
    }

    public TbSettingTextTipView blv() {
        return this.ghO;
    }

    public TbSettingTextTipView blw() {
        return this.ghP;
    }

    public TbSettingTextTipView blx() {
        return this.ghQ;
    }

    public void bly() {
        blF();
        this.ghS.tI();
    }

    public void blz() {
        blE();
        this.ghR.tI();
    }

    public void blA() {
        blG();
        this.ghT.tI();
    }

    public void blB() {
        blH();
        this.ghU.tI();
    }

    public void blC() {
        blI();
        this.ghV.tI();
    }

    private void initUI() {
        this.ghI.setContentView(d.i.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ghI.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ghI.getPageContext().getString(d.k.browse_setting));
        this.ghK = (RelativeLayout) this.ghI.findViewById(d.g.eyeshield_mode);
        this.ghL = (BdSwitchView) this.ghI.findViewById(d.g.item_switch);
        l.a(this.ghI.getPageContext().getPageActivity(), this.ghL, 10, 10, 10, 10);
        this.ghJ = this.ghI.findViewById(d.g.divide_view2);
        this.ghM = (TbSettingTextTipView) this.ghI.findViewById(d.g.img_browser);
        this.ghM.setBottomLineVisibility(true);
        this.ghN = (TbSettingTextTipView) this.ghI.findViewById(d.g.add_img_water);
        this.ghN.setBottomLineVisibility(true);
        this.ghO = (TbSettingTextTipView) this.ghI.findViewById(d.g.show_image);
        this.ghO.setBottomLineVisibility(true);
        this.ghP = (TbSettingTextTipView) this.ghI.findViewById(d.g.font_size);
        this.ghP.setBottomLineVisibility(true);
        this.ghQ = (TbSettingTextTipView) this.ghI.findViewById(d.g.video_auto_play);
        if (an.fz()) {
            this.ghQ.setText(d.k.video_gif_auto_play);
        } else {
            this.ghQ.setText(d.k.video_auto_play);
        }
        this.ghQ.setBottomLineVisibility(true);
        this.mParent = this.ghI.findViewById(d.g.parent);
        if (!blD()) {
            this.ghJ.setVisibility(8);
            this.ghK.setVisibility(8);
            return;
        }
        this.ghJ.setVisibility(0);
        this.ghK.setVisibility(0);
    }

    public boolean blD() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void initListener() {
        this.ghM.setOnClickListener(this.ghI);
        this.ghN.setOnClickListener(this.ghI);
        this.ghL.setOnSwitchStateChangeListener(this.ghI);
        this.ghO.setOnClickListener(this.ghI);
        this.ghP.setOnClickListener(this.ghI);
        this.ghQ.setOnClickListener(this.ghI);
    }

    private void blE() {
        this.ghX = new ArrayList<>();
        int viewImageQuality = i.pY().getViewImageQuality();
        boolean qe = i.pY().qe();
        this.ghX.add(new h(this.ghI.getPageContext().getString(d.k.view_image_quality_auto_menu), this.ghI.getPageContext().getString(d.k.view_image_quality_auto_menu_desc), qe && viewImageQuality == 0));
        this.ghX.add(new h(this.ghI.getPageContext().getString(d.k.view_high), this.ghI.getPageContext().getString(d.k.view_image_quality_high_menu_desc), qe && viewImageQuality == 1));
        this.ghX.add(new h(this.ghI.getPageContext().getString(d.k.view_low), this.ghI.getPageContext().getString(d.k.view_image_quality_low_menu_desc), qe && viewImageQuality == 2));
        this.ghX.add(new h(this.ghI.getPageContext().getString(d.k.close), this.ghI.getPageContext().getString(d.k.view_image_quality_close_menu_desc), qe ? false : true));
        this.ghR = new com.baidu.tbadk.core.dialog.e(this.ghI.getPageContext());
        this.ghR.cj(d.k.browser_image_quality);
        this.ghR.a(this.ghX, this.gib).tH();
    }

    private void blF() {
        this.ghZ = new ArrayList<>();
        int qc = i.pY().qc();
        this.ghZ.add(new h(this.ghI.getPageContext().getString(d.k.image_water_show_user_name), null, qc == 1));
        this.ghZ.add(new h(this.ghI.getPageContext().getString(d.k.image_water_show_forum_name), null, qc == 2));
        this.ghZ.add(new h(this.ghI.getPageContext().getString(d.k.image_water_show_none), null, qc == 0));
        this.ghS = new com.baidu.tbadk.core.dialog.e(this.ghI.getPageContext()).cj(d.k.add_image_water);
        this.ghS.a(this.ghZ, this.gic).tH();
    }

    private void blG() {
        this.ghY = new ArrayList<>();
        int pZ = i.pY().pZ();
        this.ghY.add(new h(this.ghI.getPageContext().getString(d.k.view_image_quality_auto_menu), this.ghI.getPageContext().getString(d.k.is_wifiopen_dialog), pZ == 0));
        this.ghY.add(new h(this.ghI.getPageContext().getString(d.k.is_alwaysopen), null, pZ == 1));
        this.ghY.add(new h(this.ghI.getPageContext().getString(d.k.is_close), null, pZ == 2));
        this.ghT = new com.baidu.tbadk.core.dialog.e(this.ghI.getPageContext()).cj(d.k.show_photo);
        this.ghT.a(this.ghY, this.gie).tH();
    }

    private void blH() {
        this.ghU = new com.baidu.tbadk.core.dialog.e(this.ghI.getPageContext());
        this.ghW = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.ghW.add(new h(this.ghI.getPageContext().getString(d.k.font_size_xlarge), null, fontSize == 0));
        this.ghW.add(new h(this.ghI.getPageContext().getString(d.k.font_size_big), null, fontSize == 1));
        this.ghW.add(new h(this.ghI.getPageContext().getString(d.k.font_size_mid), null, fontSize == 2));
        this.ghW.add(new h(this.ghI.getPageContext().getString(d.k.font_size_small), null, fontSize == 3));
        this.ghU.cj(d.k.font_size);
        this.ghU.a(this.ghW, this.gif);
        this.ghU.tH();
    }

    private void blI() {
        this.ghV = new com.baidu.tbadk.core.dialog.e(this.ghI.getPageContext());
        this.gia = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gia.add(new h(this.ghI.getPageContext().getString(d.k.video_auto_play_always), null, videoAutoPlay == 2));
        this.gia.add(new h(this.ghI.getPageContext().getString(d.k.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gia.add(new h(this.ghI.getPageContext().getString(d.k.close), null, videoAutoPlay == 1));
        if (an.fz()) {
            this.ghV.cj(d.k.video_gif_auto_play);
        } else {
            this.ghV.cj(d.k.video_auto_play);
        }
        this.ghV.a(this.gia, this.gig);
        this.ghV.tH();
    }

    public void sv(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new al("c10647").ac("obj_type", "1").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new al("c10647").ac("obj_type", "0").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void vR() {
        blJ();
        blK();
        blL();
        blN();
        blO();
        blM();
    }

    public void blJ() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.ghL.jO();
        } else {
            this.ghL.jP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blK() {
        if (!i.pY().qe()) {
            this.ghM.setTip(this.mContext.getString(d.k.close));
        } else if (i.pY().getViewImageQuality() == 1) {
            this.ghM.setTip(this.mContext.getString(d.k.view_high));
        } else if (i.pY().getViewImageQuality() == 2) {
            this.ghM.setTip(this.mContext.getString(d.k.view_low));
        } else {
            this.ghM.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
        }
    }

    private void blL() {
        sw(i.pY().qc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(int i) {
        switch (i) {
            case 0:
                this.ghN.setTip(this.mContext.getString(d.k.image_water_show_none));
                return;
            case 1:
                this.ghN.setTip(this.mContext.getString(d.k.image_water_show_user_name));
                return;
            case 2:
                this.ghN.setTip(this.mContext.getString(d.k.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void blM() {
        switch (i.pY().pZ()) {
            case 0:
                this.ghO.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
                return;
            case 1:
                this.ghO.setTip(this.mContext.getString(d.k.is_alwaysopen));
                return;
            case 2:
                this.ghO.setTip(this.mContext.getString(d.k.is_close));
                return;
            default:
                return;
        }
    }

    public void blN() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.ghP.setTip(this.mContext.getString(d.k.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.ghP.setTip(this.mContext.getString(d.k.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.ghP.setTip(this.mContext.getString(d.k.font_size_mid));
        } else {
            this.ghP.setTip(this.mContext.getString(d.k.font_size_small));
        }
    }

    public void blO() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.ghQ.setTip(this.mContext.getString(d.k.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.ghQ.setTip(this.mContext.getString(d.k.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.ghQ.setTip(this.mContext.getString(d.k.video_auto_play_always));
        }
    }
}
