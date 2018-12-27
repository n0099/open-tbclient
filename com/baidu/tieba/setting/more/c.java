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
    private com.baidu.tbadk.core.dialog.e gZA;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gZB;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gZC;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gZD;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gZE;
    private final AdapterView.OnItemClickListener gZF;
    private final AdapterView.OnItemClickListener gZG;
    private final AdapterView.OnItemClickListener gZH;
    private final AdapterView.OnItemClickListener gZI;
    private BrowseSettingActivity gZs;
    private TbSettingTextTipView gZt;
    private TbSettingTextTipView gZu;
    private TbSettingTextTipView gZv;
    private TbSettingTextTipView gZw;
    private com.baidu.tbadk.core.dialog.e gZx;
    private com.baidu.tbadk.core.dialog.e gZy;
    private com.baidu.tbadk.core.dialog.e gZz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gZs = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gZt = null;
        this.gZu = null;
        this.gZv = null;
        this.gZw = null;
        this.gZx = null;
        this.gZy = null;
        this.gZz = null;
        this.gZA = null;
        this.gZF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.gZx.refresh(i);
                switch (i) {
                    case 0:
                        i.xE().aW(true);
                        i.xE().cy(0);
                        break;
                    case 1:
                        i.xE().aW(true);
                        i.xE().cy(1);
                        TiebaStatic.log(new am("c10415").x("obj_type", 1));
                        break;
                    case 2:
                        i.xE().aW(true);
                        i.xE().cy(2);
                        TiebaStatic.log(new am("c10415").x("obj_type", 3));
                        break;
                    case 3:
                        i.xE().aW(false);
                        break;
                }
                c.this.gZx.dismiss();
                c.this.bxL();
            }
        };
        this.gZG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.gZy.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").x("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").x("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").x("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.xE().cx(i2);
                c.this.uK(i2);
            }
        };
        this.gZH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.gZz.refresh(i);
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
                c.this.bxN();
            }
        };
        this.gZI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.gZA.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").x("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").x("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").x("obj_type", 3));
                        break;
                }
                c.this.bxO();
            }
        };
        this.gZs = browseSettingActivity;
        initUI();
        DS();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gZs.getLayoutMode().setNightMode(i == 1);
        this.gZs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bxz() {
        return this.gZu;
    }

    public TbSettingTextTipView bxA() {
        return this.gZt;
    }

    public TbSettingTextTipView bxB() {
        return this.gZv;
    }

    public TbSettingTextTipView bxC() {
        return this.gZw;
    }

    public void bxD() {
        bxI();
        this.gZy.BK();
    }

    public void bxE() {
        bxH();
        this.gZx.BK();
    }

    public void bxF() {
        bxJ();
        this.gZz.BK();
    }

    public void bxG() {
        bxK();
        this.gZA.BK();
    }

    private void initUI() {
        this.gZs.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gZs.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gZs.getPageContext().getString(e.j.browse_setting));
        this.gZt = (TbSettingTextTipView) this.gZs.findViewById(e.g.img_browser);
        this.gZt.setBottomLineVisibility(true);
        this.gZu = (TbSettingTextTipView) this.gZs.findViewById(e.g.add_img_water);
        this.gZu.setBottomLineVisibility(true);
        this.gZv = (TbSettingTextTipView) this.gZs.findViewById(e.g.font_size);
        this.gZv.setBottomLineVisibility(true);
        this.gZw = (TbSettingTextTipView) this.gZs.findViewById(e.g.video_auto_play);
        if (av.jJ()) {
            this.gZw.setText(e.j.video_gif_auto_play);
        } else {
            this.gZw.setText(e.j.video_auto_play);
        }
        this.gZw.setBottomLineVisibility(true);
        this.mParent = this.gZs.findViewById(e.g.parent);
    }

    private void initListener() {
        this.gZt.setOnClickListener(this.gZs);
        this.gZu.setOnClickListener(this.gZs);
        this.gZv.setOnClickListener(this.gZs);
        this.gZw.setOnClickListener(this.gZs);
    }

    private void bxH() {
        this.gZC = new ArrayList<>();
        int viewImageQuality = i.xE().getViewImageQuality();
        boolean xI = i.xE().xI();
        this.gZC.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.view_image_quality_auto_menu), this.gZs.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), xI && viewImageQuality == 0));
        this.gZC.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.view_high), this.gZs.getPageContext().getString(e.j.view_image_quality_high_menu_desc), xI && viewImageQuality == 1));
        this.gZC.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.view_low), this.gZs.getPageContext().getString(e.j.view_image_quality_low_menu_desc), xI && viewImageQuality == 2));
        this.gZC.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.close), this.gZs.getPageContext().getString(e.j.view_image_quality_close_menu_desc), xI ? false : true));
        this.gZx = new com.baidu.tbadk.core.dialog.e(this.gZs.getPageContext());
        this.gZx.dk(e.j.browser_image_quality);
        this.gZx.a(this.gZC, this.gZF).BJ();
    }

    private void bxI() {
        this.gZD = new ArrayList<>();
        int xG = i.xE().xG();
        this.gZD.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.image_water_show_user_name), null, xG == 1));
        this.gZD.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.image_water_show_forum_name), null, xG == 2));
        this.gZD.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.image_water_show_none), null, xG == 0));
        this.gZy = new com.baidu.tbadk.core.dialog.e(this.gZs.getPageContext()).dk(e.j.add_image_water);
        this.gZy.a(this.gZD, this.gZG).BJ();
    }

    private void bxJ() {
        this.gZz = new com.baidu.tbadk.core.dialog.e(this.gZs.getPageContext());
        this.gZB = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gZB.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.gZB.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.gZB.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.gZB.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.gZz.dk(e.j.font_size);
        this.gZz.a(this.gZB, this.gZH);
        this.gZz.BJ();
    }

    private void bxK() {
        this.gZA = new com.baidu.tbadk.core.dialog.e(this.gZs.getPageContext());
        this.gZE = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gZE.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gZE.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gZE.add(new com.baidu.tbadk.core.dialog.g(this.gZs.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (av.jJ()) {
            this.gZA.dk(e.j.video_gif_auto_play);
        } else {
            this.gZA.dk(e.j.video_auto_play);
        }
        this.gZA.a(this.gZE, this.gZI);
        this.gZA.BJ();
    }

    public void DS() {
        bxL();
        bxM();
        bxN();
        bxO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxL() {
        if (!i.xE().xI()) {
            this.gZt.setTip(this.mContext.getString(e.j.close));
        } else if (i.xE().getViewImageQuality() == 1) {
            this.gZt.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.xE().getViewImageQuality() == 2) {
            this.gZt.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.gZt.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void bxM() {
        uK(i.xE().xG());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uK(int i) {
        switch (i) {
            case 0:
                this.gZu.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.gZu.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.gZu.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bxN() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gZv.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gZv.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gZv.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.gZv.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void bxO() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gZw.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gZw.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gZw.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
