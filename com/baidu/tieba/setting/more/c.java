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
    private com.baidu.tbadk.core.dialog.e kDA;
    private com.baidu.tbadk.core.dialog.e kDB;
    private com.baidu.tbadk.core.dialog.e kDC;
    private ArrayList<m> kDD;
    private ArrayList<m> kDE;
    private ArrayList<m> kDF;
    private ArrayList<m> kDG;
    private final AdapterView.OnItemClickListener kDH;
    private final AdapterView.OnItemClickListener kDI;
    private final AdapterView.OnItemClickListener kDJ;
    private final AdapterView.OnItemClickListener kDK;
    private BrowseSettingActivity kDt;
    private TbSettingTextTipView kDu;
    private TbSettingTextTipView kDv;
    private TbSettingTextTipView kDw;
    private TbSettingTextTipView kDx;
    private MsgSettingItemView kDy;
    private com.baidu.tbadk.core.dialog.e kDz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.kDt = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.kDu = null;
        this.kDv = null;
        this.kDw = null;
        this.kDx = null;
        this.kDz = null;
        this.kDA = null;
        this.kDB = null;
        this.kDC = null;
        this.kDH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kDz.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.aIe().setShowImages(true);
                        com.baidu.tbadk.core.i.aIe().jy(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.aIe().setShowImages(true);
                        com.baidu.tbadk.core.i.aIe().jy(1);
                        TiebaStatic.log(new an("c10415").af("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.aIe().setShowImages(true);
                        com.baidu.tbadk.core.i.aIe().jy(2);
                        TiebaStatic.log(new an("c10415").af("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.aIe().setShowImages(false);
                        break;
                }
                c.this.kDz.dismiss();
                c.this.cQz();
            }
        };
        this.kDI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.kDA.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.kDt.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.aIe().setImageWaterType(i2);
                c.this.Co(i2);
            }
        };
        this.kDJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kDB.refresh(i);
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
                c.this.cQB();
            }
        };
        this.kDK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kDC.refresh(i);
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
                c.this.cQC();
            }
        };
        this.kDt = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kDt.getLayoutMode().setNightMode(i == 1);
        this.kDt.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kDy.onChangeSkinType(this.kDt.getPageContext(), i);
        if (this.kDz != null) {
            this.kDz.onChangeSkinType();
        }
        if (this.kDA != null) {
            this.kDA.onChangeSkinType();
        }
        if (this.kDB != null) {
            this.kDB.onChangeSkinType();
        }
        if (this.kDC != null) {
            this.kDC.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cQn() {
        return this.kDv;
    }

    public TbSettingTextTipView cQo() {
        return this.kDu;
    }

    public TbSettingTextTipView cQp() {
        return this.kDw;
    }

    public TbSettingTextTipView cQq() {
        return this.kDx;
    }

    public void cQr() {
        cQw();
        this.kDA.aMX();
    }

    public void cQs() {
        cQv();
        this.kDz.aMX();
    }

    public void cQt() {
        cQx();
        this.kDB.aMX();
    }

    public void cQu() {
        cQy();
        this.kDC.aMX();
    }

    private void initUI() {
        this.kDt.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kDt.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kDt.getPageContext().getString(R.string.browse_setting));
        this.kDu = (TbSettingTextTipView) this.kDt.findViewById(R.id.img_browser);
        this.kDu.setBottomLineVisibility(true);
        this.kDv = (TbSettingTextTipView) this.kDt.findViewById(R.id.add_img_water);
        this.kDv.setBottomLineVisibility(true);
        this.kDw = (TbSettingTextTipView) this.kDt.findViewById(R.id.font_size);
        this.kDw.setBottomLineVisibility(true);
        this.kDx = (TbSettingTextTipView) this.kDt.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.kDx.setText(R.string.video_gif_auto_play);
        } else {
            this.kDx.setText(R.string.video_auto_play);
        }
        this.kDx.setBottomLineVisibility(true);
        this.kDy = (MsgSettingItemView) this.kDt.findViewById(R.id.slide_anim_switch);
        this.kDy.setText(R.string.slide_anim_switch);
        this.kDy.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.kDy.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aNV().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").af("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").af("obj_type", 2));
            }
        });
        this.mParent = this.kDt.findViewById(R.id.parent);
    }

    private void initListener() {
        this.kDu.setOnClickListener(this.kDt);
        this.kDv.setOnClickListener(this.kDt);
        this.kDw.setOnClickListener(this.kDt);
        this.kDx.setOnClickListener(this.kDt);
    }

    private void cQv() {
        this.kDE = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.aIe().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.aIe().isShowImages();
        this.kDE.add(new m(this.kDt.getPageContext().getString(R.string.view_image_quality_auto_menu), this.kDt.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.kDE.add(new m(this.kDt.getPageContext().getString(R.string.view_high), this.kDt.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.kDE.add(new m(this.kDt.getPageContext().getString(R.string.view_low), this.kDt.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.kDE.add(new m(this.kDt.getPageContext().getString(R.string.close), this.kDt.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.kDz = new com.baidu.tbadk.core.dialog.e(this.kDt.getPageContext());
        this.kDz.kk(R.string.browser_image_quality);
        this.kDz.a(this.kDE, this.kDH).aMW();
    }

    private void cQw() {
        this.kDF = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.aIe().getImageWaterType();
        this.kDF.add(new m(this.kDt.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.kDF.add(new m(this.kDt.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.kDF.add(new m(this.kDt.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.kDA = new com.baidu.tbadk.core.dialog.e(this.kDt.getPageContext()).kk(R.string.add_image_water);
        this.kDA.a(this.kDF, this.kDI).aMW();
    }

    private void cQx() {
        this.kDB = new com.baidu.tbadk.core.dialog.e(this.kDt.getPageContext());
        this.kDD = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.kDD.add(new m(this.kDt.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.kDD.add(new m(this.kDt.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.kDD.add(new m(this.kDt.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.kDD.add(new m(this.kDt.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.kDB.kk(R.string.font_size);
        this.kDB.a(this.kDD, this.kDJ);
        this.kDB.aMW();
    }

    private void cQy() {
        this.kDC = new com.baidu.tbadk.core.dialog.e(this.kDt.getPageContext());
        this.kDG = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.kDG.add(new m(this.kDt.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.kDG.add(new m(this.kDt.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.kDG.add(new m(this.kDt.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.kDC.kk(R.string.video_gif_auto_play);
        } else {
            this.kDC.kk(R.string.video_auto_play);
        }
        this.kDC.a(this.kDG, this.kDK);
        this.kDC.aMW();
    }

    public void updateAll() {
        cQz();
        cQA();
        cQB();
        cQC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQz() {
        if (!com.baidu.tbadk.core.i.aIe().isShowImages()) {
            this.kDu.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.aIe().getViewImageQuality() == 1) {
            this.kDu.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.aIe().getViewImageQuality() == 2) {
            this.kDu.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.kDu.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cQA() {
        Co(com.baidu.tbadk.core.i.aIe().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co(int i) {
        switch (i) {
            case 0:
                this.kDv.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.kDv.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.kDv.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cQB() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.kDw.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.kDw.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.kDw.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.kDw.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cQC() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.kDx.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.kDx.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.kDx.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
