package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private TbSettingTextTipView kDA;
    private TbSettingTextTipView kDB;
    private MsgSettingItemView kDC;
    private com.baidu.tbadk.core.dialog.e kDD;
    private com.baidu.tbadk.core.dialog.e kDE;
    private com.baidu.tbadk.core.dialog.e kDF;
    private com.baidu.tbadk.core.dialog.e kDG;
    private ArrayList<m> kDH;
    private ArrayList<m> kDI;
    private ArrayList<m> kDJ;
    private ArrayList<m> kDK;
    private final AdapterView.OnItemClickListener kDL;
    private final AdapterView.OnItemClickListener kDM;
    private final AdapterView.OnItemClickListener kDN;
    private final AdapterView.OnItemClickListener kDO;
    private BrowseSettingActivity kDx;
    private TbSettingTextTipView kDy;
    private TbSettingTextTipView kDz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.kDx = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.kDy = null;
        this.kDz = null;
        this.kDA = null;
        this.kDB = null;
        this.kDD = null;
        this.kDE = null;
        this.kDF = null;
        this.kDG = null;
        this.kDL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kDD.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.aIc().setShowImages(true);
                        com.baidu.tbadk.core.i.aIc().jy(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.aIc().setShowImages(true);
                        com.baidu.tbadk.core.i.aIc().jy(1);
                        TiebaStatic.log(new an("c10415").af("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.aIc().setShowImages(true);
                        com.baidu.tbadk.core.i.aIc().jy(2);
                        TiebaStatic.log(new an("c10415").af("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.aIc().setShowImages(false);
                        break;
                }
                c.this.kDD.dismiss();
                c.this.cQx();
            }
        };
        this.kDM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.kDE.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").af("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").af("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").af("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.kDx.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.aIc().setImageWaterType(i2);
                c.this.Co(i2);
            }
        };
        this.kDN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kDF.refresh(i);
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
                c.this.cQz();
            }
        };
        this.kDO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kDG.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").af("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").af("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").af("obj_type", 3));
                        break;
                }
                c.this.cQA();
            }
        };
        this.kDx = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kDx.getLayoutMode().setNightMode(i == 1);
        this.kDx.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kDC.onChangeSkinType(this.kDx.getPageContext(), i);
        if (this.kDD != null) {
            this.kDD.onChangeSkinType();
        }
        if (this.kDE != null) {
            this.kDE.onChangeSkinType();
        }
        if (this.kDF != null) {
            this.kDF.onChangeSkinType();
        }
        if (this.kDG != null) {
            this.kDG.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cQl() {
        return this.kDz;
    }

    public TbSettingTextTipView cQm() {
        return this.kDy;
    }

    public TbSettingTextTipView cQn() {
        return this.kDA;
    }

    public TbSettingTextTipView cQo() {
        return this.kDB;
    }

    public void cQp() {
        cQu();
        this.kDE.aMV();
    }

    public void cQq() {
        cQt();
        this.kDD.aMV();
    }

    public void cQr() {
        cQv();
        this.kDF.aMV();
    }

    public void cQs() {
        cQw();
        this.kDG.aMV();
    }

    private void initUI() {
        this.kDx.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kDx.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kDx.getPageContext().getString(R.string.browse_setting));
        this.kDy = (TbSettingTextTipView) this.kDx.findViewById(R.id.img_browser);
        this.kDy.setBottomLineVisibility(true);
        this.kDz = (TbSettingTextTipView) this.kDx.findViewById(R.id.add_img_water);
        this.kDz.setBottomLineVisibility(true);
        this.kDA = (TbSettingTextTipView) this.kDx.findViewById(R.id.font_size);
        this.kDA.setBottomLineVisibility(true);
        this.kDB = (TbSettingTextTipView) this.kDx.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.kDB.setText(R.string.video_gif_auto_play);
        } else {
            this.kDB.setText(R.string.video_auto_play);
        }
        this.kDB.setBottomLineVisibility(true);
        this.kDC = (MsgSettingItemView) this.kDx.findViewById(R.id.slide_anim_switch);
        this.kDC.setText(R.string.slide_anim_switch);
        this.kDC.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.kDC.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aNT().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").af("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").af("obj_type", 2));
            }
        });
        this.mParent = this.kDx.findViewById(R.id.parent);
    }

    private void initListener() {
        this.kDy.setOnClickListener(this.kDx);
        this.kDz.setOnClickListener(this.kDx);
        this.kDA.setOnClickListener(this.kDx);
        this.kDB.setOnClickListener(this.kDx);
    }

    private void cQt() {
        this.kDI = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.aIc().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.aIc().isShowImages();
        this.kDI.add(new m(this.kDx.getPageContext().getString(R.string.view_image_quality_auto_menu), this.kDx.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.kDI.add(new m(this.kDx.getPageContext().getString(R.string.view_high), this.kDx.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.kDI.add(new m(this.kDx.getPageContext().getString(R.string.view_low), this.kDx.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.kDI.add(new m(this.kDx.getPageContext().getString(R.string.close), this.kDx.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.kDD = new com.baidu.tbadk.core.dialog.e(this.kDx.getPageContext());
        this.kDD.kk(R.string.browser_image_quality);
        this.kDD.a(this.kDI, this.kDL).aMU();
    }

    private void cQu() {
        this.kDJ = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.aIc().getImageWaterType();
        this.kDJ.add(new m(this.kDx.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.kDJ.add(new m(this.kDx.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.kDJ.add(new m(this.kDx.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.kDE = new com.baidu.tbadk.core.dialog.e(this.kDx.getPageContext()).kk(R.string.add_image_water);
        this.kDE.a(this.kDJ, this.kDM).aMU();
    }

    private void cQv() {
        this.kDF = new com.baidu.tbadk.core.dialog.e(this.kDx.getPageContext());
        this.kDH = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.kDH.add(new m(this.kDx.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.kDH.add(new m(this.kDx.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.kDH.add(new m(this.kDx.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.kDH.add(new m(this.kDx.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.kDF.kk(R.string.font_size);
        this.kDF.a(this.kDH, this.kDN);
        this.kDF.aMU();
    }

    private void cQw() {
        this.kDG = new com.baidu.tbadk.core.dialog.e(this.kDx.getPageContext());
        this.kDK = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.kDK.add(new m(this.kDx.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.kDK.add(new m(this.kDx.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.kDK.add(new m(this.kDx.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.kDG.kk(R.string.video_gif_auto_play);
        } else {
            this.kDG.kk(R.string.video_auto_play);
        }
        this.kDG.a(this.kDK, this.kDO);
        this.kDG.aMU();
    }

    public void updateAll() {
        cQx();
        cQy();
        cQz();
        cQA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQx() {
        if (!com.baidu.tbadk.core.i.aIc().isShowImages()) {
            this.kDy.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.aIc().getViewImageQuality() == 1) {
            this.kDy.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.aIc().getViewImageQuality() == 2) {
            this.kDy.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.kDy.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cQy() {
        Co(com.baidu.tbadk.core.i.aIc().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co(int i) {
        switch (i) {
            case 0:
                this.kDz.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.kDz.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.kDz.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cQz() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.kDA.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.kDA.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.kDA.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.kDA.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cQA() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.kDB.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.kDB.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.kDB.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
