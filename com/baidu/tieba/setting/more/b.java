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
    private BrowseSettingActivity gNU;
    private TbSettingTextTipView gNV;
    private TbSettingTextTipView gNW;
    private TbSettingTextTipView gNX;
    private TbSettingTextTipView gNY;
    private com.baidu.tbadk.core.dialog.e gNZ;
    private com.baidu.tbadk.core.dialog.e gOa;
    private com.baidu.tbadk.core.dialog.e gOb;
    private com.baidu.tbadk.core.dialog.e gOc;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOd;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOe;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOf;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOg;
    private final AdapterView.OnItemClickListener gOh;
    private final AdapterView.OnItemClickListener gOi;
    private final AdapterView.OnItemClickListener gOj;
    private final AdapterView.OnItemClickListener gOk;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gNU = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gNV = null;
        this.gNW = null;
        this.gNX = null;
        this.gNY = null;
        this.gNZ = null;
        this.gOa = null;
        this.gOb = null;
        this.gOc = null;
        this.gOh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gNZ.refresh(i);
                switch (i) {
                    case 0:
                        i.ws().aF(true);
                        i.ws().bV(0);
                        break;
                    case 1:
                        i.ws().aF(true);
                        i.ws().bV(1);
                        TiebaStatic.log(new am("c10415").x("obj_type", 1));
                        break;
                    case 2:
                        i.ws().aF(true);
                        i.ws().bV(2);
                        TiebaStatic.log(new am("c10415").x("obj_type", 3));
                        break;
                    case 3:
                        i.ws().aF(false);
                        break;
                }
                b.this.gNZ.dismiss();
                b.this.bvD();
            }
        };
        this.gOi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gOa.refresh(i);
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
                i.ws().bU(i2);
                b.this.tI(i2);
            }
        };
        this.gOj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gOb.refresh(i);
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
                b.this.bvF();
            }
        };
        this.gOk = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gOc.refresh(i);
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
                b.this.bvG();
            }
        };
        this.gNU = browseSettingActivity;
        initUI();
        CH();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gNU.getLayoutMode().setNightMode(i == 1);
        this.gNU.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bvr() {
        return this.gNW;
    }

    public TbSettingTextTipView bvs() {
        return this.gNV;
    }

    public TbSettingTextTipView bvt() {
        return this.gNX;
    }

    public TbSettingTextTipView bvu() {
        return this.gNY;
    }

    public void bvv() {
        bvA();
        this.gOa.Az();
    }

    public void bvw() {
        bvz();
        this.gNZ.Az();
    }

    public void bvx() {
        bvB();
        this.gOb.Az();
    }

    public void bvy() {
        bvC();
        this.gOc.Az();
    }

    private void initUI() {
        this.gNU.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gNU.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gNU.getPageContext().getString(e.j.browse_setting));
        this.gNV = (TbSettingTextTipView) this.gNU.findViewById(e.g.img_browser);
        this.gNV.setBottomLineVisibility(true);
        this.gNW = (TbSettingTextTipView) this.gNU.findViewById(e.g.add_img_water);
        this.gNW.setBottomLineVisibility(true);
        this.gNX = (TbSettingTextTipView) this.gNU.findViewById(e.g.font_size);
        this.gNX.setBottomLineVisibility(true);
        this.gNY = (TbSettingTextTipView) this.gNU.findViewById(e.g.video_auto_play);
        if (au.jL()) {
            this.gNY.setText(e.j.video_gif_auto_play);
        } else {
            this.gNY.setText(e.j.video_auto_play);
        }
        this.gNY.setBottomLineVisibility(true);
        this.mParent = this.gNU.findViewById(e.g.parent);
    }

    private void initListener() {
        this.gNV.setOnClickListener(this.gNU);
        this.gNW.setOnClickListener(this.gNU);
        this.gNX.setOnClickListener(this.gNU);
        this.gNY.setOnClickListener(this.gNU);
    }

    private void bvz() {
        this.gOe = new ArrayList<>();
        int viewImageQuality = i.ws().getViewImageQuality();
        boolean ww = i.ws().ww();
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.view_image_quality_auto_menu), this.gNU.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), ww && viewImageQuality == 0));
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.view_high), this.gNU.getPageContext().getString(e.j.view_image_quality_high_menu_desc), ww && viewImageQuality == 1));
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.view_low), this.gNU.getPageContext().getString(e.j.view_image_quality_low_menu_desc), ww && viewImageQuality == 2));
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.close), this.gNU.getPageContext().getString(e.j.view_image_quality_close_menu_desc), ww ? false : true));
        this.gNZ = new com.baidu.tbadk.core.dialog.e(this.gNU.getPageContext());
        this.gNZ.cI(e.j.browser_image_quality);
        this.gNZ.a(this.gOe, this.gOh).Ay();
    }

    private void bvA() {
        this.gOf = new ArrayList<>();
        int wu = i.ws().wu();
        this.gOf.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.image_water_show_user_name), null, wu == 1));
        this.gOf.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.image_water_show_forum_name), null, wu == 2));
        this.gOf.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.image_water_show_none), null, wu == 0));
        this.gOa = new com.baidu.tbadk.core.dialog.e(this.gNU.getPageContext()).cI(e.j.add_image_water);
        this.gOa.a(this.gOf, this.gOi).Ay();
    }

    private void bvB() {
        this.gOb = new com.baidu.tbadk.core.dialog.e(this.gNU.getPageContext());
        this.gOd = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.gOb.cI(e.j.font_size);
        this.gOb.a(this.gOd, this.gOj);
        this.gOb.Ay();
    }

    private void bvC() {
        this.gOc = new com.baidu.tbadk.core.dialog.e(this.gNU.getPageContext());
        this.gOg = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gOg.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gOg.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gOg.add(new com.baidu.tbadk.core.dialog.g(this.gNU.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (au.jL()) {
            this.gOc.cI(e.j.video_gif_auto_play);
        } else {
            this.gOc.cI(e.j.video_auto_play);
        }
        this.gOc.a(this.gOg, this.gOk);
        this.gOc.Ay();
    }

    public void CH() {
        bvD();
        bvE();
        bvF();
        bvG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvD() {
        if (!i.ws().ww()) {
            this.gNV.setTip(this.mContext.getString(e.j.close));
        } else if (i.ws().getViewImageQuality() == 1) {
            this.gNV.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.ws().getViewImageQuality() == 2) {
            this.gNV.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.gNV.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void bvE() {
        tI(i.ws().wu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        switch (i) {
            case 0:
                this.gNW.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.gNW.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.gNW.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bvF() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gNX.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gNX.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gNX.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.gNX.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void bvG() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gNY.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gNY.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gNY.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
