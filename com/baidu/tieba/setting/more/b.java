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
    private BrowseSettingActivity giM;
    private View giN;
    private RelativeLayout giO;
    private BdSwitchView giP;
    private TbSettingTextTipView giQ;
    private TbSettingTextTipView giR;
    private TbSettingTextTipView giS;
    private TbSettingTextTipView giT;
    private TbSettingTextTipView giU;
    private com.baidu.tbadk.core.dialog.e giV;
    private com.baidu.tbadk.core.dialog.e giW;
    private com.baidu.tbadk.core.dialog.e giX;
    private com.baidu.tbadk.core.dialog.e giY;
    private com.baidu.tbadk.core.dialog.e giZ;
    private ArrayList<h> gja;
    private ArrayList<h> gjb;
    private ArrayList<h> gjc;
    private ArrayList<h> gjd;
    private ArrayList<h> gje;
    private final AdapterView.OnItemClickListener gjf;
    private final AdapterView.OnItemClickListener gjg;
    private final AdapterView.OnItemClickListener gjh;
    private final AdapterView.OnItemClickListener gji;
    private final AdapterView.OnItemClickListener gjj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.giM = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.giN = null;
        this.giO = null;
        this.giP = null;
        this.giQ = null;
        this.giR = null;
        this.giS = null;
        this.giT = null;
        this.giU = null;
        this.giV = null;
        this.giW = null;
        this.giX = null;
        this.giY = null;
        this.giZ = null;
        this.gjf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.giV.refresh(i);
                switch (i) {
                    case 0:
                        i.pX().al(true);
                        i.pX().by(0);
                        break;
                    case 1:
                        i.pX().al(true);
                        i.pX().by(1);
                        TiebaStatic.log(new al("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.pX().al(true);
                        i.pX().by(2);
                        TiebaStatic.log(new al("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.pX().al(false);
                        break;
                }
                b.this.giV.dismiss();
                b.this.blJ();
            }
        };
        this.gjg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                int i2 = 1;
                b.this.giW.refresh(i);
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
                i.pX().bx(i2);
                b.this.su(i2);
            }
        };
        this.gjh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.giX.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 2));
                        i.pX().bw(0);
                        break;
                    case 1:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 1));
                        i.pX().bw(1);
                        break;
                    case 2:
                        TiebaStatic.log(new al("set_viewnophoto").r("obj_index", 3));
                        i.pX().bw(2);
                        break;
                }
                b.this.blL();
            }
        };
        this.gji = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.giY.refresh(i);
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
                b.this.blM();
            }
        };
        this.gjj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                b.this.giZ.refresh(i);
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
                b.this.blN();
            }
        };
        this.giM = browseSettingActivity;
        initUI();
        vQ();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.giM.getLayoutMode().setNightMode(i == 1);
        this.giM.getLayoutMode().u(this.mParent);
        this.giP.setBackgroundRes(ak.cO(d.f.bg_switch_open), ak.cO(d.f.bg_switch_close), ak.cO(d.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bls() {
        return this.giR;
    }

    public TbSettingTextTipView blt() {
        return this.giQ;
    }

    public TbSettingTextTipView blu() {
        return this.giS;
    }

    public TbSettingTextTipView blv() {
        return this.giT;
    }

    public TbSettingTextTipView blw() {
        return this.giU;
    }

    public void blx() {
        blE();
        this.giW.tH();
    }

    public void bly() {
        blD();
        this.giV.tH();
    }

    public void blz() {
        blF();
        this.giX.tH();
    }

    public void blA() {
        blG();
        this.giY.tH();
    }

    public void blB() {
        blH();
        this.giZ.tH();
    }

    private void initUI() {
        this.giM.setContentView(d.i.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.giM.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.giM.getPageContext().getString(d.k.browse_setting));
        this.giO = (RelativeLayout) this.giM.findViewById(d.g.eyeshield_mode);
        this.giP = (BdSwitchView) this.giM.findViewById(d.g.item_switch);
        l.a(this.giM.getPageContext().getPageActivity(), this.giP, 10, 10, 10, 10);
        this.giN = this.giM.findViewById(d.g.divide_view2);
        this.giQ = (TbSettingTextTipView) this.giM.findViewById(d.g.img_browser);
        this.giQ.setBottomLineVisibility(true);
        this.giR = (TbSettingTextTipView) this.giM.findViewById(d.g.add_img_water);
        this.giR.setBottomLineVisibility(true);
        this.giS = (TbSettingTextTipView) this.giM.findViewById(d.g.show_image);
        this.giS.setBottomLineVisibility(true);
        this.giT = (TbSettingTextTipView) this.giM.findViewById(d.g.font_size);
        this.giT.setBottomLineVisibility(true);
        this.giU = (TbSettingTextTipView) this.giM.findViewById(d.g.video_auto_play);
        if (an.fz()) {
            this.giU.setText(d.k.video_gif_auto_play);
        } else {
            this.giU.setText(d.k.video_auto_play);
        }
        this.giU.setBottomLineVisibility(true);
        this.mParent = this.giM.findViewById(d.g.parent);
        if (!blC()) {
            this.giN.setVisibility(8);
            this.giO.setVisibility(8);
            return;
        }
        this.giN.setVisibility(0);
        this.giO.setVisibility(0);
    }

    public boolean blC() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void initListener() {
        this.giQ.setOnClickListener(this.giM);
        this.giR.setOnClickListener(this.giM);
        this.giP.setOnSwitchStateChangeListener(this.giM);
        this.giS.setOnClickListener(this.giM);
        this.giT.setOnClickListener(this.giM);
        this.giU.setOnClickListener(this.giM);
    }

    private void blD() {
        this.gjb = new ArrayList<>();
        int viewImageQuality = i.pX().getViewImageQuality();
        boolean qd = i.pX().qd();
        this.gjb.add(new h(this.giM.getPageContext().getString(d.k.view_image_quality_auto_menu), this.giM.getPageContext().getString(d.k.view_image_quality_auto_menu_desc), qd && viewImageQuality == 0));
        this.gjb.add(new h(this.giM.getPageContext().getString(d.k.view_high), this.giM.getPageContext().getString(d.k.view_image_quality_high_menu_desc), qd && viewImageQuality == 1));
        this.gjb.add(new h(this.giM.getPageContext().getString(d.k.view_low), this.giM.getPageContext().getString(d.k.view_image_quality_low_menu_desc), qd && viewImageQuality == 2));
        this.gjb.add(new h(this.giM.getPageContext().getString(d.k.close), this.giM.getPageContext().getString(d.k.view_image_quality_close_menu_desc), qd ? false : true));
        this.giV = new com.baidu.tbadk.core.dialog.e(this.giM.getPageContext());
        this.giV.cj(d.k.browser_image_quality);
        this.giV.a(this.gjb, this.gjf).tG();
    }

    private void blE() {
        this.gjd = new ArrayList<>();
        int qb = i.pX().qb();
        this.gjd.add(new h(this.giM.getPageContext().getString(d.k.image_water_show_user_name), null, qb == 1));
        this.gjd.add(new h(this.giM.getPageContext().getString(d.k.image_water_show_forum_name), null, qb == 2));
        this.gjd.add(new h(this.giM.getPageContext().getString(d.k.image_water_show_none), null, qb == 0));
        this.giW = new com.baidu.tbadk.core.dialog.e(this.giM.getPageContext()).cj(d.k.add_image_water);
        this.giW.a(this.gjd, this.gjg).tG();
    }

    private void blF() {
        this.gjc = new ArrayList<>();
        int pY = i.pX().pY();
        this.gjc.add(new h(this.giM.getPageContext().getString(d.k.view_image_quality_auto_menu), this.giM.getPageContext().getString(d.k.is_wifiopen_dialog), pY == 0));
        this.gjc.add(new h(this.giM.getPageContext().getString(d.k.is_alwaysopen), null, pY == 1));
        this.gjc.add(new h(this.giM.getPageContext().getString(d.k.is_close), null, pY == 2));
        this.giX = new com.baidu.tbadk.core.dialog.e(this.giM.getPageContext()).cj(d.k.show_photo);
        this.giX.a(this.gjc, this.gjh).tG();
    }

    private void blG() {
        this.giY = new com.baidu.tbadk.core.dialog.e(this.giM.getPageContext());
        this.gja = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gja.add(new h(this.giM.getPageContext().getString(d.k.font_size_xlarge), null, fontSize == 0));
        this.gja.add(new h(this.giM.getPageContext().getString(d.k.font_size_big), null, fontSize == 1));
        this.gja.add(new h(this.giM.getPageContext().getString(d.k.font_size_mid), null, fontSize == 2));
        this.gja.add(new h(this.giM.getPageContext().getString(d.k.font_size_small), null, fontSize == 3));
        this.giY.cj(d.k.font_size);
        this.giY.a(this.gja, this.gji);
        this.giY.tG();
    }

    private void blH() {
        this.giZ = new com.baidu.tbadk.core.dialog.e(this.giM.getPageContext());
        this.gje = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gje.add(new h(this.giM.getPageContext().getString(d.k.video_auto_play_always), null, videoAutoPlay == 2));
        this.gje.add(new h(this.giM.getPageContext().getString(d.k.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gje.add(new h(this.giM.getPageContext().getString(d.k.close), null, videoAutoPlay == 1));
        if (an.fz()) {
            this.giZ.cj(d.k.video_gif_auto_play);
        } else {
            this.giZ.cj(d.k.video_auto_play);
        }
        this.giZ.a(this.gje, this.gjj);
        this.giZ.tG();
    }

    public void st(int i) {
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

    public void vQ() {
        blI();
        blJ();
        blK();
        blM();
        blN();
        blL();
    }

    public void blI() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.giP.jO();
        } else {
            this.giP.jP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blJ() {
        if (!i.pX().qd()) {
            this.giQ.setTip(this.mContext.getString(d.k.close));
        } else if (i.pX().getViewImageQuality() == 1) {
            this.giQ.setTip(this.mContext.getString(d.k.view_high));
        } else if (i.pX().getViewImageQuality() == 2) {
            this.giQ.setTip(this.mContext.getString(d.k.view_low));
        } else {
            this.giQ.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
        }
    }

    private void blK() {
        su(i.pX().qb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(int i) {
        switch (i) {
            case 0:
                this.giR.setTip(this.mContext.getString(d.k.image_water_show_none));
                return;
            case 1:
                this.giR.setTip(this.mContext.getString(d.k.image_water_show_user_name));
                return;
            case 2:
                this.giR.setTip(this.mContext.getString(d.k.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void blL() {
        switch (i.pX().pY()) {
            case 0:
                this.giS.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
                return;
            case 1:
                this.giS.setTip(this.mContext.getString(d.k.is_alwaysopen));
                return;
            case 2:
                this.giS.setTip(this.mContext.getString(d.k.is_close));
                return;
            default:
                return;
        }
    }

    public void blM() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.giT.setTip(this.mContext.getString(d.k.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.giT.setTip(this.mContext.getString(d.k.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.giT.setTip(this.mContext.getString(d.k.font_size_mid));
        } else {
            this.giT.setTip(this.mContext.getString(d.k.font_size_small));
        }
    }

    public void blN() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.giU.setTip(this.mContext.getString(d.k.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.giU.setTip(this.mContext.getString(d.k.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.giU.setTip(this.mContext.getString(d.k.video_auto_play_always));
        }
    }
}
