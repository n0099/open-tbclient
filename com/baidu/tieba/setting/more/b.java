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
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private com.baidu.tbadk.core.dialog.e gPA;
    private com.baidu.tbadk.core.dialog.e gPB;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gPC;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gPD;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gPE;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gPF;
    private final AdapterView.OnItemClickListener gPG;
    private final AdapterView.OnItemClickListener gPH;
    private final AdapterView.OnItemClickListener gPI;
    private final AdapterView.OnItemClickListener gPJ;
    private BrowseSettingActivity gPt;
    private TbSettingTextTipView gPu;
    private TbSettingTextTipView gPv;
    private TbSettingTextTipView gPw;
    private TbSettingTextTipView gPx;
    private com.baidu.tbadk.core.dialog.e gPy;
    private com.baidu.tbadk.core.dialog.e gPz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gPt = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gPu = null;
        this.gPv = null;
        this.gPw = null;
        this.gPx = null;
        this.gPy = null;
        this.gPz = null;
        this.gPA = null;
        this.gPB = null;
        this.gPG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gPy.refresh(i);
                switch (i) {
                    case 0:
                        i.wA().aV(true);
                        i.wA().ck(0);
                        break;
                    case 1:
                        i.wA().aV(true);
                        i.wA().ck(1);
                        TiebaStatic.log(new am("c10415").x("obj_type", 1));
                        break;
                    case 2:
                        i.wA().aV(true);
                        i.wA().ck(2);
                        TiebaStatic.log(new am("c10415").x("obj_type", 3));
                        break;
                    case 3:
                        i.wA().aV(false);
                        break;
                }
                b.this.gPy.dismiss();
                b.this.buZ();
            }
        };
        this.gPH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gPz.refresh(i);
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
                i.wA().cj(i2);
                b.this.ub(i2);
            }
        };
        this.gPI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gPA.refresh(i);
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
                b.this.bvb();
            }
        };
        this.gPJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gPB.refresh(i);
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
                b.this.bvc();
            }
        };
        this.gPt = browseSettingActivity;
        initUI();
        CO();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gPt.getLayoutMode().setNightMode(i == 1);
        this.gPt.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView buN() {
        return this.gPv;
    }

    public TbSettingTextTipView buO() {
        return this.gPu;
    }

    public TbSettingTextTipView buP() {
        return this.gPw;
    }

    public TbSettingTextTipView buQ() {
        return this.gPx;
    }

    public void buR() {
        buW();
        this.gPz.AG();
    }

    public void buS() {
        buV();
        this.gPy.AG();
    }

    public void buT() {
        buX();
        this.gPA.AG();
    }

    public void buU() {
        buY();
        this.gPB.AG();
    }

    private void initUI() {
        this.gPt.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gPt.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gPt.getPageContext().getString(e.j.browse_setting));
        this.gPu = (TbSettingTextTipView) this.gPt.findViewById(e.g.img_browser);
        this.gPu.setBottomLineVisibility(true);
        this.gPv = (TbSettingTextTipView) this.gPt.findViewById(e.g.add_img_water);
        this.gPv.setBottomLineVisibility(true);
        this.gPw = (TbSettingTextTipView) this.gPt.findViewById(e.g.font_size);
        this.gPw.setBottomLineVisibility(true);
        this.gPx = (TbSettingTextTipView) this.gPt.findViewById(e.g.video_auto_play);
        if (av.jJ()) {
            this.gPx.setText(e.j.video_gif_auto_play);
        } else {
            this.gPx.setText(e.j.video_auto_play);
        }
        this.gPx.setBottomLineVisibility(true);
        this.mParent = this.gPt.findViewById(e.g.parent);
    }

    private void initListener() {
        this.gPu.setOnClickListener(this.gPt);
        this.gPv.setOnClickListener(this.gPt);
        this.gPw.setOnClickListener(this.gPt);
        this.gPx.setOnClickListener(this.gPt);
    }

    private void buV() {
        this.gPD = new ArrayList<>();
        int viewImageQuality = i.wA().getViewImageQuality();
        boolean wE = i.wA().wE();
        this.gPD.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.view_image_quality_auto_menu), this.gPt.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), wE && viewImageQuality == 0));
        this.gPD.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.view_high), this.gPt.getPageContext().getString(e.j.view_image_quality_high_menu_desc), wE && viewImageQuality == 1));
        this.gPD.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.view_low), this.gPt.getPageContext().getString(e.j.view_image_quality_low_menu_desc), wE && viewImageQuality == 2));
        this.gPD.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.close), this.gPt.getPageContext().getString(e.j.view_image_quality_close_menu_desc), wE ? false : true));
        this.gPy = new com.baidu.tbadk.core.dialog.e(this.gPt.getPageContext());
        this.gPy.cW(e.j.browser_image_quality);
        this.gPy.a(this.gPD, this.gPG).AF();
    }

    private void buW() {
        this.gPE = new ArrayList<>();
        int wC = i.wA().wC();
        this.gPE.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.image_water_show_user_name), null, wC == 1));
        this.gPE.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.image_water_show_forum_name), null, wC == 2));
        this.gPE.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.image_water_show_none), null, wC == 0));
        this.gPz = new com.baidu.tbadk.core.dialog.e(this.gPt.getPageContext()).cW(e.j.add_image_water);
        this.gPz.a(this.gPE, this.gPH).AF();
    }

    private void buX() {
        this.gPA = new com.baidu.tbadk.core.dialog.e(this.gPt.getPageContext());
        this.gPC = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gPC.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.gPC.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.gPC.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.gPC.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.gPA.cW(e.j.font_size);
        this.gPA.a(this.gPC, this.gPI);
        this.gPA.AF();
    }

    private void buY() {
        this.gPB = new com.baidu.tbadk.core.dialog.e(this.gPt.getPageContext());
        this.gPF = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gPF.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gPF.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gPF.add(new com.baidu.tbadk.core.dialog.g(this.gPt.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (av.jJ()) {
            this.gPB.cW(e.j.video_gif_auto_play);
        } else {
            this.gPB.cW(e.j.video_auto_play);
        }
        this.gPB.a(this.gPF, this.gPJ);
        this.gPB.AF();
    }

    public void CO() {
        buZ();
        bva();
        bvb();
        bvc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buZ() {
        if (!i.wA().wE()) {
            this.gPu.setTip(this.mContext.getString(e.j.close));
        } else if (i.wA().getViewImageQuality() == 1) {
            this.gPu.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.wA().getViewImageQuality() == 2) {
            this.gPu.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.gPu.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void bva() {
        ub(i.wA().wC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        switch (i) {
            case 0:
                this.gPv.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.gPv.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.gPv.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bvb() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gPw.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gPw.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gPw.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.gPw.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void bvc() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gPx.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gPx.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gPx.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
