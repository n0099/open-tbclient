package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.p.av;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private TbSettingTextTipView haA;
    private TbSettingTextTipView haB;
    private TbSettingTextTipView haC;
    private com.baidu.tbadk.core.dialog.e haD;
    private com.baidu.tbadk.core.dialog.e haE;
    private com.baidu.tbadk.core.dialog.e haF;
    private com.baidu.tbadk.core.dialog.e haG;
    private ArrayList<com.baidu.tbadk.core.dialog.g> haH;
    private ArrayList<com.baidu.tbadk.core.dialog.g> haI;
    private ArrayList<com.baidu.tbadk.core.dialog.g> haJ;
    private ArrayList<com.baidu.tbadk.core.dialog.g> haK;
    private final AdapterView.OnItemClickListener haL;
    private final AdapterView.OnItemClickListener haM;
    private final AdapterView.OnItemClickListener haN;
    private final AdapterView.OnItemClickListener haO;
    private BrowseSettingActivity hay;
    private TbSettingTextTipView haz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.hay = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.haz = null;
        this.haA = null;
        this.haB = null;
        this.haC = null;
        this.haD = null;
        this.haE = null;
        this.haF = null;
        this.haG = null;
        this.haL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.haD.refresh(i);
                switch (i) {
                    case 0:
                        i.xR().aX(true);
                        i.xR().cy(0);
                        break;
                    case 1:
                        i.xR().aX(true);
                        i.xR().cy(1);
                        TiebaStatic.log(new am("c10415").y("obj_type", 1));
                        break;
                    case 2:
                        i.xR().aX(true);
                        i.xR().cy(2);
                        TiebaStatic.log(new am("c10415").y("obj_type", 3));
                        break;
                    case 3:
                        i.xR().aX(false);
                        break;
                }
                c.this.haD.dismiss();
                c.this.byu();
            }
        };
        this.haM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.haE.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").y("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").y("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").y("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.xR().cx(i2);
                c.this.uN(i2);
            }
        };
        this.haN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.haF.refresh(i);
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
                c.this.byw();
            }
        };
        this.haO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.haG.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").y("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").y("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").y("obj_type", 3));
                        break;
                }
                c.this.byx();
            }
        };
        this.hay = browseSettingActivity;
        initUI();
        Ef();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.hay.getLayoutMode().setNightMode(i == 1);
        this.hay.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView byi() {
        return this.haA;
    }

    public TbSettingTextTipView byj() {
        return this.haz;
    }

    public TbSettingTextTipView byk() {
        return this.haB;
    }

    public TbSettingTextTipView byl() {
        return this.haC;
    }

    public void bym() {
        byr();
        this.haE.BX();
    }

    public void byn() {
        byq();
        this.haD.BX();
    }

    public void byo() {
        bys();
        this.haF.BX();
    }

    public void byp() {
        byt();
        this.haG.BX();
    }

    private void initUI() {
        this.hay.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.hay.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.hay.getPageContext().getString(e.j.browse_setting));
        this.haz = (TbSettingTextTipView) this.hay.findViewById(e.g.img_browser);
        this.haz.setBottomLineVisibility(true);
        this.haA = (TbSettingTextTipView) this.hay.findViewById(e.g.add_img_water);
        this.haA.setBottomLineVisibility(true);
        this.haB = (TbSettingTextTipView) this.hay.findViewById(e.g.font_size);
        this.haB.setBottomLineVisibility(true);
        this.haC = (TbSettingTextTipView) this.hay.findViewById(e.g.video_auto_play);
        if (av.jJ()) {
            this.haC.setText(e.j.video_gif_auto_play);
        } else {
            this.haC.setText(e.j.video_auto_play);
        }
        this.haC.setBottomLineVisibility(true);
        this.mParent = this.hay.findViewById(e.g.parent);
    }

    private void initListener() {
        this.haz.setOnClickListener(this.hay);
        this.haA.setOnClickListener(this.hay);
        this.haB.setOnClickListener(this.hay);
        this.haC.setOnClickListener(this.hay);
    }

    private void byq() {
        this.haI = new ArrayList<>();
        int viewImageQuality = i.xR().getViewImageQuality();
        boolean xV = i.xR().xV();
        this.haI.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.view_image_quality_auto_menu), this.hay.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), xV && viewImageQuality == 0));
        this.haI.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.view_high), this.hay.getPageContext().getString(e.j.view_image_quality_high_menu_desc), xV && viewImageQuality == 1));
        this.haI.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.view_low), this.hay.getPageContext().getString(e.j.view_image_quality_low_menu_desc), xV && viewImageQuality == 2));
        this.haI.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.close), this.hay.getPageContext().getString(e.j.view_image_quality_close_menu_desc), xV ? false : true));
        this.haD = new com.baidu.tbadk.core.dialog.e(this.hay.getPageContext());
        this.haD.dk(e.j.browser_image_quality);
        this.haD.a(this.haI, this.haL).BW();
    }

    private void byr() {
        this.haJ = new ArrayList<>();
        int xT = i.xR().xT();
        this.haJ.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.image_water_show_user_name), null, xT == 1));
        this.haJ.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.image_water_show_forum_name), null, xT == 2));
        this.haJ.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.image_water_show_none), null, xT == 0));
        this.haE = new com.baidu.tbadk.core.dialog.e(this.hay.getPageContext()).dk(e.j.add_image_water);
        this.haE.a(this.haJ, this.haM).BW();
    }

    private void bys() {
        this.haF = new com.baidu.tbadk.core.dialog.e(this.hay.getPageContext());
        this.haH = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.haH.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.haH.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.haH.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.haH.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.haF.dk(e.j.font_size);
        this.haF.a(this.haH, this.haN);
        this.haF.BW();
    }

    private void byt() {
        this.haG = new com.baidu.tbadk.core.dialog.e(this.hay.getPageContext());
        this.haK = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.haK.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.haK.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.haK.add(new com.baidu.tbadk.core.dialog.g(this.hay.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (av.jJ()) {
            this.haG.dk(e.j.video_gif_auto_play);
        } else {
            this.haG.dk(e.j.video_auto_play);
        }
        this.haG.a(this.haK, this.haO);
        this.haG.BW();
    }

    public void Ef() {
        byu();
        byv();
        byw();
        byx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byu() {
        if (!i.xR().xV()) {
            this.haz.setTip(this.mContext.getString(e.j.close));
        } else if (i.xR().getViewImageQuality() == 1) {
            this.haz.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.xR().getViewImageQuality() == 2) {
            this.haz.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.haz.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void byv() {
        uN(i.xR().xT());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(int i) {
        switch (i) {
            case 0:
                this.haA.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.haA.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.haA.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void byw() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.haB.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.haB.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.haB.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.haB.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void byx() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.haC.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.haC.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.haC.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
