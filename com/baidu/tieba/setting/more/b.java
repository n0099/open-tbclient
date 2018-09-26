package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.p.au;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private TbSettingTextTipView gGA;
    private TbSettingTextTipView gGB;
    private com.baidu.tbadk.core.dialog.e gGC;
    private com.baidu.tbadk.core.dialog.e gGD;
    private com.baidu.tbadk.core.dialog.e gGE;
    private com.baidu.tbadk.core.dialog.e gGF;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gGG;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gGH;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gGI;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gGJ;
    private final AdapterView.OnItemClickListener gGK;
    private final AdapterView.OnItemClickListener gGL;
    private final AdapterView.OnItemClickListener gGM;
    private final AdapterView.OnItemClickListener gGN;
    private BrowseSettingActivity gGx;
    private TbSettingTextTipView gGy;
    private TbSettingTextTipView gGz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gGx = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gGy = null;
        this.gGz = null;
        this.gGA = null;
        this.gGB = null;
        this.gGC = null;
        this.gGD = null;
        this.gGE = null;
        this.gGF = null;
        this.gGK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gGC.refresh(i);
                switch (i) {
                    case 0:
                        i.uj().au(true);
                        i.uj().bK(0);
                        break;
                    case 1:
                        i.uj().au(true);
                        i.uj().bK(1);
                        TiebaStatic.log(new am("c10415").w("obj_type", 1));
                        break;
                    case 2:
                        i.uj().au(true);
                        i.uj().bK(2);
                        TiebaStatic.log(new am("c10415").w("obj_type", 3));
                        break;
                    case 3:
                        i.uj().au(false);
                        break;
                }
                b.this.gGC.dismiss();
                b.this.bso();
            }
        };
        this.gGL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gGD.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").w("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").w("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").w("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.uj().bJ(i2);
                b.this.tl(i2);
            }
        };
        this.gGM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gGE.refresh(i);
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
                b.this.bsq();
            }
        };
        this.gGN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gGF.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").w("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").w("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").w("obj_type", 3));
                        break;
                }
                b.this.bsr();
            }
        };
        this.gGx = browseSettingActivity;
        initUI();
        AA();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gGx.getLayoutMode().setNightMode(i == 1);
        this.gGx.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bsc() {
        return this.gGz;
    }

    public TbSettingTextTipView bsd() {
        return this.gGy;
    }

    public TbSettingTextTipView bse() {
        return this.gGA;
    }

    public TbSettingTextTipView bsf() {
        return this.gGB;
    }

    public void bsg() {
        bsl();
        this.gGD.yq();
    }

    public void bsh() {
        bsk();
        this.gGC.yq();
    }

    public void bsi() {
        bsm();
        this.gGE.yq();
    }

    public void bsj() {
        bsn();
        this.gGF.yq();
    }

    private void initUI() {
        this.gGx.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gGx.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gGx.getPageContext().getString(e.j.browse_setting));
        this.gGy = (TbSettingTextTipView) this.gGx.findViewById(e.g.img_browser);
        this.gGy.setBottomLineVisibility(true);
        this.gGz = (TbSettingTextTipView) this.gGx.findViewById(e.g.add_img_water);
        this.gGz.setBottomLineVisibility(true);
        this.gGA = (TbSettingTextTipView) this.gGx.findViewById(e.g.font_size);
        this.gGA.setBottomLineVisibility(true);
        this.gGB = (TbSettingTextTipView) this.gGx.findViewById(e.g.video_auto_play);
        if (au.jw()) {
            this.gGB.setText(e.j.video_gif_auto_play);
        } else {
            this.gGB.setText(e.j.video_auto_play);
        }
        this.gGB.setBottomLineVisibility(true);
        this.mParent = this.gGx.findViewById(e.g.parent);
    }

    private void initListener() {
        this.gGy.setOnClickListener(this.gGx);
        this.gGz.setOnClickListener(this.gGx);
        this.gGA.setOnClickListener(this.gGx);
        this.gGB.setOnClickListener(this.gGx);
    }

    private void bsk() {
        this.gGH = new ArrayList<>();
        int viewImageQuality = i.uj().getViewImageQuality();
        boolean un = i.uj().un();
        this.gGH.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.view_image_quality_auto_menu), this.gGx.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), un && viewImageQuality == 0));
        this.gGH.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.view_high), this.gGx.getPageContext().getString(e.j.view_image_quality_high_menu_desc), un && viewImageQuality == 1));
        this.gGH.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.view_low), this.gGx.getPageContext().getString(e.j.view_image_quality_low_menu_desc), un && viewImageQuality == 2));
        this.gGH.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.close), this.gGx.getPageContext().getString(e.j.view_image_quality_close_menu_desc), un ? false : true));
        this.gGC = new com.baidu.tbadk.core.dialog.e(this.gGx.getPageContext());
        this.gGC.cy(e.j.browser_image_quality);
        this.gGC.a(this.gGH, this.gGK).yp();
    }

    private void bsl() {
        this.gGI = new ArrayList<>();
        int ul = i.uj().ul();
        this.gGI.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.image_water_show_user_name), null, ul == 1));
        this.gGI.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.image_water_show_forum_name), null, ul == 2));
        this.gGI.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.image_water_show_none), null, ul == 0));
        this.gGD = new com.baidu.tbadk.core.dialog.e(this.gGx.getPageContext()).cy(e.j.add_image_water);
        this.gGD.a(this.gGI, this.gGL).yp();
    }

    private void bsm() {
        this.gGE = new com.baidu.tbadk.core.dialog.e(this.gGx.getPageContext());
        this.gGG = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gGG.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.gGG.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.gGG.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.gGG.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.gGE.cy(e.j.font_size);
        this.gGE.a(this.gGG, this.gGM);
        this.gGE.yp();
    }

    private void bsn() {
        this.gGF = new com.baidu.tbadk.core.dialog.e(this.gGx.getPageContext());
        this.gGJ = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gGJ.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gGJ.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gGJ.add(new com.baidu.tbadk.core.dialog.g(this.gGx.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (au.jw()) {
            this.gGF.cy(e.j.video_gif_auto_play);
        } else {
            this.gGF.cy(e.j.video_auto_play);
        }
        this.gGF.a(this.gGJ, this.gGN);
        this.gGF.yp();
    }

    public void AA() {
        bso();
        bsp();
        bsq();
        bsr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bso() {
        if (!i.uj().un()) {
            this.gGy.setTip(this.mContext.getString(e.j.close));
        } else if (i.uj().getViewImageQuality() == 1) {
            this.gGy.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.uj().getViewImageQuality() == 2) {
            this.gGy.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.gGy.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void bsp() {
        tl(i.uj().ul());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        switch (i) {
            case 0:
                this.gGz.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.gGz.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.gGz.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bsq() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gGA.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gGA.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gGA.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.gGA.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void bsr() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gGB.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gGB.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gGB.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
