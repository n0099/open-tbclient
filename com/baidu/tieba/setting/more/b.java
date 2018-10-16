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
    private BrowseSettingActivity gNT;
    private TbSettingTextTipView gNU;
    private TbSettingTextTipView gNV;
    private TbSettingTextTipView gNW;
    private TbSettingTextTipView gNX;
    private com.baidu.tbadk.core.dialog.e gNY;
    private com.baidu.tbadk.core.dialog.e gNZ;
    private com.baidu.tbadk.core.dialog.e gOa;
    private com.baidu.tbadk.core.dialog.e gOb;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOc;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOd;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOe;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gOf;
    private final AdapterView.OnItemClickListener gOg;
    private final AdapterView.OnItemClickListener gOh;
    private final AdapterView.OnItemClickListener gOi;
    private final AdapterView.OnItemClickListener gOj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gNT = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gNU = null;
        this.gNV = null;
        this.gNW = null;
        this.gNX = null;
        this.gNY = null;
        this.gNZ = null;
        this.gOa = null;
        this.gOb = null;
        this.gOg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gNY.refresh(i);
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
                b.this.gNY.dismiss();
                b.this.bvD();
            }
        };
        this.gOh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gNZ.refresh(i);
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
        this.gOi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gOa.refresh(i);
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
        this.gOj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gOb.refresh(i);
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
        this.gNT = browseSettingActivity;
        initUI();
        CH();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gNT.getLayoutMode().setNightMode(i == 1);
        this.gNT.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bvr() {
        return this.gNV;
    }

    public TbSettingTextTipView bvs() {
        return this.gNU;
    }

    public TbSettingTextTipView bvt() {
        return this.gNW;
    }

    public TbSettingTextTipView bvu() {
        return this.gNX;
    }

    public void bvv() {
        bvA();
        this.gNZ.Az();
    }

    public void bvw() {
        bvz();
        this.gNY.Az();
    }

    public void bvx() {
        bvB();
        this.gOa.Az();
    }

    public void bvy() {
        bvC();
        this.gOb.Az();
    }

    private void initUI() {
        this.gNT.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gNT.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gNT.getPageContext().getString(e.j.browse_setting));
        this.gNU = (TbSettingTextTipView) this.gNT.findViewById(e.g.img_browser);
        this.gNU.setBottomLineVisibility(true);
        this.gNV = (TbSettingTextTipView) this.gNT.findViewById(e.g.add_img_water);
        this.gNV.setBottomLineVisibility(true);
        this.gNW = (TbSettingTextTipView) this.gNT.findViewById(e.g.font_size);
        this.gNW.setBottomLineVisibility(true);
        this.gNX = (TbSettingTextTipView) this.gNT.findViewById(e.g.video_auto_play);
        if (au.jL()) {
            this.gNX.setText(e.j.video_gif_auto_play);
        } else {
            this.gNX.setText(e.j.video_auto_play);
        }
        this.gNX.setBottomLineVisibility(true);
        this.mParent = this.gNT.findViewById(e.g.parent);
    }

    private void initListener() {
        this.gNU.setOnClickListener(this.gNT);
        this.gNV.setOnClickListener(this.gNT);
        this.gNW.setOnClickListener(this.gNT);
        this.gNX.setOnClickListener(this.gNT);
    }

    private void bvz() {
        this.gOd = new ArrayList<>();
        int viewImageQuality = i.ws().getViewImageQuality();
        boolean ww = i.ws().ww();
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.view_image_quality_auto_menu), this.gNT.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), ww && viewImageQuality == 0));
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.view_high), this.gNT.getPageContext().getString(e.j.view_image_quality_high_menu_desc), ww && viewImageQuality == 1));
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.view_low), this.gNT.getPageContext().getString(e.j.view_image_quality_low_menu_desc), ww && viewImageQuality == 2));
        this.gOd.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.close), this.gNT.getPageContext().getString(e.j.view_image_quality_close_menu_desc), ww ? false : true));
        this.gNY = new com.baidu.tbadk.core.dialog.e(this.gNT.getPageContext());
        this.gNY.cI(e.j.browser_image_quality);
        this.gNY.a(this.gOd, this.gOg).Ay();
    }

    private void bvA() {
        this.gOe = new ArrayList<>();
        int wu = i.ws().wu();
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.image_water_show_user_name), null, wu == 1));
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.image_water_show_forum_name), null, wu == 2));
        this.gOe.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.image_water_show_none), null, wu == 0));
        this.gNZ = new com.baidu.tbadk.core.dialog.e(this.gNT.getPageContext()).cI(e.j.add_image_water);
        this.gNZ.a(this.gOe, this.gOh).Ay();
    }

    private void bvB() {
        this.gOa = new com.baidu.tbadk.core.dialog.e(this.gNT.getPageContext());
        this.gOc = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gOc.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.gOc.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.gOc.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.gOc.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.gOa.cI(e.j.font_size);
        this.gOa.a(this.gOc, this.gOi);
        this.gOa.Ay();
    }

    private void bvC() {
        this.gOb = new com.baidu.tbadk.core.dialog.e(this.gNT.getPageContext());
        this.gOf = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gOf.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gOf.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gOf.add(new com.baidu.tbadk.core.dialog.g(this.gNT.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (au.jL()) {
            this.gOb.cI(e.j.video_gif_auto_play);
        } else {
            this.gOb.cI(e.j.video_auto_play);
        }
        this.gOb.a(this.gOf, this.gOj);
        this.gOb.Ay();
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
            this.gNU.setTip(this.mContext.getString(e.j.close));
        } else if (i.ws().getViewImageQuality() == 1) {
            this.gNU.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.ws().getViewImageQuality() == 2) {
            this.gNU.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.gNU.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void bvE() {
        tI(i.ws().wu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        switch (i) {
            case 0:
                this.gNV.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.gNV.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.gNV.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bvF() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gNW.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gNW.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gNW.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.gNW.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void bvG() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gNX.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gNX.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gNX.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
