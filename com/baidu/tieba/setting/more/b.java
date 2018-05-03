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
    private BrowseSettingActivity ghF;
    private View ghG;
    private RelativeLayout ghH;
    private BdSwitchView ghI;
    private TbSettingTextTipView ghJ;
    private TbSettingTextTipView ghK;
    private TbSettingTextTipView ghL;
    private TbSettingTextTipView ghM;
    private TbSettingTextTipView ghN;
    private com.baidu.tbadk.core.dialog.e ghO;
    private com.baidu.tbadk.core.dialog.e ghP;
    private com.baidu.tbadk.core.dialog.e ghQ;
    private com.baidu.tbadk.core.dialog.e ghR;
    private com.baidu.tbadk.core.dialog.e ghS;
    private ArrayList<h> ghT;
    private ArrayList<h> ghU;
    private ArrayList<h> ghV;
    private ArrayList<h> ghW;
    private ArrayList<h> ghX;
    private final AdapterView.OnItemClickListener ghY;
    private final AdapterView.OnItemClickListener ghZ;
    private final AdapterView.OnItemClickListener gia;
    private final AdapterView.OnItemClickListener gib;
    private final AdapterView.OnItemClickListener gic;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ghF = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.ghG = null;
        this.ghH = null;
        this.ghI = null;
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
        this.ghY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghO.refresh(i);
                switch (i) {
                    case 0:
                        i.pY().al(true);
                        i.pY().by(0);
                        break;
                    case 1:
                        i.pY().al(true);
                        i.pY().by(1);
                        TiebaStatic.log(new al("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.pY().al(true);
                        i.pY().by(2);
                        TiebaStatic.log(new al("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.pY().al(false);
                        break;
                }
                b.this.ghO.dismiss();
                b.this.blK();
            }
        };
        this.ghZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                int i2 = 1;
                b.this.ghP.refresh(i);
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
                i.pY().bx(i2);
                b.this.sv(i2);
            }
        };
        this.gia = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghQ.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 2));
                        i.pY().bw(0);
                        break;
                    case 1:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 1));
                        i.pY().bw(1);
                        break;
                    case 2:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 3));
                        i.pY().bw(2);
                        break;
                }
                b.this.blM();
            }
        };
        this.gib = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghR.refresh(i);
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
        this.gic = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.ghS.refresh(i);
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
        this.ghF = browseSettingActivity;
        initUI();
        vR();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.ghF.getLayoutMode().setNightMode(i == 1);
        this.ghF.getLayoutMode().u(this.mParent);
        this.ghI.setBackgroundRes(ak.cN(d.f.bg_switch_open), ak.cN(d.f.bg_switch_close), ak.cN(d.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView blt() {
        return this.ghK;
    }

    public TbSettingTextTipView blu() {
        return this.ghJ;
    }

    public TbSettingTextTipView blv() {
        return this.ghL;
    }

    public TbSettingTextTipView blw() {
        return this.ghM;
    }

    public TbSettingTextTipView blx() {
        return this.ghN;
    }

    public void bly() {
        blF();
        this.ghP.tI();
    }

    public void blz() {
        blE();
        this.ghO.tI();
    }

    public void blA() {
        blG();
        this.ghQ.tI();
    }

    public void blB() {
        blH();
        this.ghR.tI();
    }

    public void blC() {
        blI();
        this.ghS.tI();
    }

    private void initUI() {
        this.ghF.setContentView(d.i.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ghF.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ghF.getPageContext().getString(d.k.browse_setting));
        this.ghH = (RelativeLayout) this.ghF.findViewById(d.g.eyeshield_mode);
        this.ghI = (BdSwitchView) this.ghF.findViewById(d.g.item_switch);
        l.a(this.ghF.getPageContext().getPageActivity(), this.ghI, 10, 10, 10, 10);
        this.ghG = this.ghF.findViewById(d.g.divide_view2);
        this.ghJ = (TbSettingTextTipView) this.ghF.findViewById(d.g.img_browser);
        this.ghJ.setBottomLineVisibility(true);
        this.ghK = (TbSettingTextTipView) this.ghF.findViewById(d.g.add_img_water);
        this.ghK.setBottomLineVisibility(true);
        this.ghL = (TbSettingTextTipView) this.ghF.findViewById(d.g.show_image);
        this.ghL.setBottomLineVisibility(true);
        this.ghM = (TbSettingTextTipView) this.ghF.findViewById(d.g.font_size);
        this.ghM.setBottomLineVisibility(true);
        this.ghN = (TbSettingTextTipView) this.ghF.findViewById(d.g.video_auto_play);
        if (an.fz()) {
            this.ghN.setText(d.k.video_gif_auto_play);
        } else {
            this.ghN.setText(d.k.video_auto_play);
        }
        this.ghN.setBottomLineVisibility(true);
        this.mParent = this.ghF.findViewById(d.g.parent);
        if (!blD()) {
            this.ghG.setVisibility(8);
            this.ghH.setVisibility(8);
            return;
        }
        this.ghG.setVisibility(0);
        this.ghH.setVisibility(0);
    }

    public boolean blD() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void initListener() {
        this.ghJ.setOnClickListener(this.ghF);
        this.ghK.setOnClickListener(this.ghF);
        this.ghI.setOnSwitchStateChangeListener(this.ghF);
        this.ghL.setOnClickListener(this.ghF);
        this.ghM.setOnClickListener(this.ghF);
        this.ghN.setOnClickListener(this.ghF);
    }

    private void blE() {
        this.ghU = new ArrayList<>();
        int viewImageQuality = i.pY().getViewImageQuality();
        boolean qe = i.pY().qe();
        this.ghU.add(new h(this.ghF.getPageContext().getString(d.k.view_image_quality_auto_menu), this.ghF.getPageContext().getString(d.k.view_image_quality_auto_menu_desc), qe && viewImageQuality == 0));
        this.ghU.add(new h(this.ghF.getPageContext().getString(d.k.view_high), this.ghF.getPageContext().getString(d.k.view_image_quality_high_menu_desc), qe && viewImageQuality == 1));
        this.ghU.add(new h(this.ghF.getPageContext().getString(d.k.view_low), this.ghF.getPageContext().getString(d.k.view_image_quality_low_menu_desc), qe && viewImageQuality == 2));
        this.ghU.add(new h(this.ghF.getPageContext().getString(d.k.close), this.ghF.getPageContext().getString(d.k.view_image_quality_close_menu_desc), qe ? false : true));
        this.ghO = new com.baidu.tbadk.core.dialog.e(this.ghF.getPageContext());
        this.ghO.ci(d.k.browser_image_quality);
        this.ghO.a(this.ghU, this.ghY).tH();
    }

    private void blF() {
        this.ghW = new ArrayList<>();
        int qc = i.pY().qc();
        this.ghW.add(new h(this.ghF.getPageContext().getString(d.k.image_water_show_user_name), null, qc == 1));
        this.ghW.add(new h(this.ghF.getPageContext().getString(d.k.image_water_show_forum_name), null, qc == 2));
        this.ghW.add(new h(this.ghF.getPageContext().getString(d.k.image_water_show_none), null, qc == 0));
        this.ghP = new com.baidu.tbadk.core.dialog.e(this.ghF.getPageContext()).ci(d.k.add_image_water);
        this.ghP.a(this.ghW, this.ghZ).tH();
    }

    private void blG() {
        this.ghV = new ArrayList<>();
        int pZ = i.pY().pZ();
        this.ghV.add(new h(this.ghF.getPageContext().getString(d.k.view_image_quality_auto_menu), this.ghF.getPageContext().getString(d.k.is_wifiopen_dialog), pZ == 0));
        this.ghV.add(new h(this.ghF.getPageContext().getString(d.k.is_alwaysopen), null, pZ == 1));
        this.ghV.add(new h(this.ghF.getPageContext().getString(d.k.is_close), null, pZ == 2));
        this.ghQ = new com.baidu.tbadk.core.dialog.e(this.ghF.getPageContext()).ci(d.k.show_photo);
        this.ghQ.a(this.ghV, this.gia).tH();
    }

    private void blH() {
        this.ghR = new com.baidu.tbadk.core.dialog.e(this.ghF.getPageContext());
        this.ghT = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.ghT.add(new h(this.ghF.getPageContext().getString(d.k.font_size_xlarge), null, fontSize == 0));
        this.ghT.add(new h(this.ghF.getPageContext().getString(d.k.font_size_big), null, fontSize == 1));
        this.ghT.add(new h(this.ghF.getPageContext().getString(d.k.font_size_mid), null, fontSize == 2));
        this.ghT.add(new h(this.ghF.getPageContext().getString(d.k.font_size_small), null, fontSize == 3));
        this.ghR.ci(d.k.font_size);
        this.ghR.a(this.ghT, this.gib);
        this.ghR.tH();
    }

    private void blI() {
        this.ghS = new com.baidu.tbadk.core.dialog.e(this.ghF.getPageContext());
        this.ghX = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.ghX.add(new h(this.ghF.getPageContext().getString(d.k.video_auto_play_always), null, videoAutoPlay == 2));
        this.ghX.add(new h(this.ghF.getPageContext().getString(d.k.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.ghX.add(new h(this.ghF.getPageContext().getString(d.k.close), null, videoAutoPlay == 1));
        if (an.fz()) {
            this.ghS.ci(d.k.video_gif_auto_play);
        } else {
            this.ghS.ci(d.k.video_auto_play);
        }
        this.ghS.a(this.ghX, this.gic);
        this.ghS.tH();
    }

    public void su(int i) {
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
            this.ghI.jO();
        } else {
            this.ghI.jP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blK() {
        if (!i.pY().qe()) {
            this.ghJ.setTip(this.mContext.getString(d.k.close));
        } else if (i.pY().getViewImageQuality() == 1) {
            this.ghJ.setTip(this.mContext.getString(d.k.view_high));
        } else if (i.pY().getViewImageQuality() == 2) {
            this.ghJ.setTip(this.mContext.getString(d.k.view_low));
        } else {
            this.ghJ.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
        }
    }

    private void blL() {
        sv(i.pY().qc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(int i) {
        switch (i) {
            case 0:
                this.ghK.setTip(this.mContext.getString(d.k.image_water_show_none));
                return;
            case 1:
                this.ghK.setTip(this.mContext.getString(d.k.image_water_show_user_name));
                return;
            case 2:
                this.ghK.setTip(this.mContext.getString(d.k.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void blM() {
        switch (i.pY().pZ()) {
            case 0:
                this.ghL.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
                return;
            case 1:
                this.ghL.setTip(this.mContext.getString(d.k.is_alwaysopen));
                return;
            case 2:
                this.ghL.setTip(this.mContext.getString(d.k.is_close));
                return;
            default:
                return;
        }
    }

    public void blN() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.ghM.setTip(this.mContext.getString(d.k.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.ghM.setTip(this.mContext.getString(d.k.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.ghM.setTip(this.mContext.getString(d.k.font_size_mid));
        } else {
            this.ghM.setTip(this.mContext.getString(d.k.font_size_small));
        }
    }

    public void blO() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.ghN.setTip(this.mContext.getString(d.k.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.ghN.setTip(this.mContext.getString(d.k.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.ghN.setTip(this.mContext.getString(d.k.video_auto_play_always));
        }
    }
}
