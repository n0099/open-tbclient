package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.t.bd;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private TbSettingTextTipView iTA;
    private MsgSettingItemView iTB;
    private com.baidu.tbadk.core.dialog.e iTC;
    private com.baidu.tbadk.core.dialog.e iTD;
    private com.baidu.tbadk.core.dialog.e iTE;
    private com.baidu.tbadk.core.dialog.e iTF;
    private ArrayList<m> iTG;
    private ArrayList<m> iTH;
    private ArrayList<m> iTI;
    private ArrayList<m> iTJ;
    private final AdapterView.OnItemClickListener iTK;
    private final AdapterView.OnItemClickListener iTL;
    private final AdapterView.OnItemClickListener iTM;
    private final AdapterView.OnItemClickListener iTN;
    private BrowseSettingActivity iTw;
    private TbSettingTextTipView iTx;
    private TbSettingTextTipView iTy;
    private TbSettingTextTipView iTz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iTw = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iTx = null;
        this.iTy = null;
        this.iTz = null;
        this.iTA = null;
        this.iTC = null;
        this.iTD = null;
        this.iTE = null;
        this.iTF = null;
        this.iTK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iTC.refresh(i);
                switch (i) {
                    case 0:
                        i.ago().setShowImages(true);
                        i.ago().setViewImageQuality(0);
                        break;
                    case 1:
                        i.ago().setShowImages(true);
                        i.ago().setViewImageQuality(1);
                        TiebaStatic.log(new an("c10415").O("obj_type", 1));
                        break;
                    case 2:
                        i.ago().setShowImages(true);
                        i.ago().setViewImageQuality(2);
                        TiebaStatic.log(new an("c10415").O("obj_type", 3));
                        break;
                    case 3:
                        i.ago().setShowImages(false);
                        break;
                }
                c.this.iTC.dismiss();
                c.this.ciT();
            }
        };
        this.iTL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iTD.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").O("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").O("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").O("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.ago().setImageWaterType(i2);
                c.this.yX(i2);
            }
        };
        this.iTM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iTE.refresh(i);
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
                c.this.ciV();
            }
        };
        this.iTN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iTF.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").O("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").O("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").O("obj_type", 3));
                        break;
                }
                c.this.ciW();
            }
        };
        this.iTw = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iTw.getLayoutMode().setNightMode(i == 1);
        this.iTw.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iTB.onChangeSkinType(this.iTw.getPageContext(), i);
        if (this.iTC != null) {
            this.iTC.onChangeSkinType();
        }
        if (this.iTD != null) {
            this.iTD.onChangeSkinType();
        }
        if (this.iTE != null) {
            this.iTE.onChangeSkinType();
        }
        if (this.iTF != null) {
            this.iTF.onChangeSkinType();
        }
    }

    public TbSettingTextTipView ciH() {
        return this.iTy;
    }

    public TbSettingTextTipView ciI() {
        return this.iTx;
    }

    public TbSettingTextTipView ciJ() {
        return this.iTz;
    }

    public TbSettingTextTipView ciK() {
        return this.iTA;
    }

    public void ciL() {
        ciQ();
        this.iTD.akP();
    }

    public void ciM() {
        ciP();
        this.iTC.akP();
    }

    public void ciN() {
        ciR();
        this.iTE.akP();
    }

    public void ciO() {
        ciS();
        this.iTF.akP();
    }

    private void initUI() {
        this.iTw.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iTw.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iTw.getPageContext().getString(R.string.browse_setting));
        this.iTx = (TbSettingTextTipView) this.iTw.findViewById(R.id.img_browser);
        this.iTx.setBottomLineVisibility(true);
        this.iTy = (TbSettingTextTipView) this.iTw.findViewById(R.id.add_img_water);
        this.iTy.setBottomLineVisibility(true);
        this.iTz = (TbSettingTextTipView) this.iTw.findViewById(R.id.font_size);
        this.iTz.setBottomLineVisibility(true);
        this.iTA = (TbSettingTextTipView) this.iTw.findViewById(R.id.video_auto_play);
        if (bd.isOn()) {
            this.iTA.setText(R.string.video_gif_auto_play);
        } else {
            this.iTA.setText(R.string.video_auto_play);
        }
        this.iTA.setBottomLineVisibility(true);
        this.iTB = (MsgSettingItemView) this.iTw.findViewById(R.id.slide_anim_switch);
        this.iTB.setText(R.string.slide_anim_switch);
        this.iTB.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iTB.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.alP().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").O("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").O("obj_type", 2));
            }
        });
        this.mParent = this.iTw.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iTx.setOnClickListener(this.iTw);
        this.iTy.setOnClickListener(this.iTw);
        this.iTz.setOnClickListener(this.iTw);
        this.iTA.setOnClickListener(this.iTw);
    }

    private void ciP() {
        this.iTH = new ArrayList<>();
        int viewImageQuality = i.ago().getViewImageQuality();
        boolean isShowImages = i.ago().isShowImages();
        this.iTH.add(new m(this.iTw.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iTw.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.iTH.add(new m(this.iTw.getPageContext().getString(R.string.view_high), this.iTw.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.iTH.add(new m(this.iTw.getPageContext().getString(R.string.view_low), this.iTw.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.iTH.add(new m(this.iTw.getPageContext().getString(R.string.close), this.iTw.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.iTC = new com.baidu.tbadk.core.dialog.e(this.iTw.getPageContext());
        this.iTC.ia(R.string.browser_image_quality);
        this.iTC.a(this.iTH, this.iTK).akO();
    }

    private void ciQ() {
        this.iTI = new ArrayList<>();
        int imageWaterType = i.ago().getImageWaterType();
        this.iTI.add(new m(this.iTw.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.iTI.add(new m(this.iTw.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.iTI.add(new m(this.iTw.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.iTD = new com.baidu.tbadk.core.dialog.e(this.iTw.getPageContext()).ia(R.string.add_image_water);
        this.iTD.a(this.iTI, this.iTL).akO();
    }

    private void ciR() {
        this.iTE = new com.baidu.tbadk.core.dialog.e(this.iTw.getPageContext());
        this.iTG = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iTG.add(new m(this.iTw.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iTG.add(new m(this.iTw.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iTG.add(new m(this.iTw.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iTG.add(new m(this.iTw.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iTE.ia(R.string.font_size);
        this.iTE.a(this.iTG, this.iTM);
        this.iTE.akO();
    }

    private void ciS() {
        this.iTF = new com.baidu.tbadk.core.dialog.e(this.iTw.getPageContext());
        this.iTJ = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iTJ.add(new m(this.iTw.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iTJ.add(new m(this.iTw.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iTJ.add(new m(this.iTw.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.isOn()) {
            this.iTF.ia(R.string.video_gif_auto_play);
        } else {
            this.iTF.ia(R.string.video_auto_play);
        }
        this.iTF.a(this.iTJ, this.iTN);
        this.iTF.akO();
    }

    public void updateAll() {
        ciT();
        ciU();
        ciV();
        ciW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciT() {
        if (!i.ago().isShowImages()) {
            this.iTx.setTip(this.mContext.getString(R.string.close));
        } else if (i.ago().getViewImageQuality() == 1) {
            this.iTx.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.ago().getViewImageQuality() == 2) {
            this.iTx.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iTx.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void ciU() {
        yX(i.ago().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX(int i) {
        switch (i) {
            case 0:
                this.iTy.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iTy.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iTy.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void ciV() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iTz.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iTz.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iTz.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iTz.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void ciW() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iTA.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iTA.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iTA.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
