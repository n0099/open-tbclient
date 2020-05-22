package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.k;
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
    private TbSettingTextTipView kVA;
    private TbSettingTextTipView kVB;
    private TbSettingTextTipView kVC;
    private TbSettingTextTipView kVD;
    private MsgSettingItemView kVE;
    private com.baidu.tbadk.core.dialog.e kVF;
    private com.baidu.tbadk.core.dialog.e kVG;
    private com.baidu.tbadk.core.dialog.e kVH;
    private com.baidu.tbadk.core.dialog.e kVI;
    private ArrayList<m> kVJ;
    private ArrayList<m> kVK;
    private ArrayList<m> kVL;
    private ArrayList<m> kVM;
    private final AdapterView.OnItemClickListener kVN;
    private final AdapterView.OnItemClickListener kVO;
    private final AdapterView.OnItemClickListener kVP;
    private final AdapterView.OnItemClickListener kVQ;
    private BrowseSettingActivity kVz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.kVz = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.kVA = null;
        this.kVB = null;
        this.kVC = null;
        this.kVD = null;
        this.kVF = null;
        this.kVG = null;
        this.kVH = null;
        this.kVI = null;
        this.kVN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kVF.refresh(i);
                switch (i) {
                    case 0:
                        k.aNQ().setShowImages(true);
                        k.aNQ().jY(0);
                        break;
                    case 1:
                        k.aNQ().setShowImages(true);
                        k.aNQ().jY(1);
                        TiebaStatic.log(new an("c10415").ag("obj_type", 1));
                        break;
                    case 2:
                        k.aNQ().setShowImages(true);
                        k.aNQ().jY(2);
                        TiebaStatic.log(new an("c10415").ag("obj_type", 3));
                        break;
                    case 3:
                        k.aNQ().setShowImages(false);
                        break;
                }
                c.this.kVF.dismiss();
                c.this.cXA();
            }
        };
        this.kVO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.kVG.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").ag("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").ag("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").ag("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.kVz.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.aNQ().setImageWaterType(i2);
                c.this.CY(i2);
            }
        };
        this.kVP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kVH.refresh(i);
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
                c.this.cXC();
            }
        };
        this.kVQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kVI.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").ag("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").ag("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").ag("obj_type", 3));
                        break;
                }
                c.this.cXD();
            }
        };
        this.kVz = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kVz.getLayoutMode().setNightMode(i == 1);
        this.kVz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kVE.onChangeSkinType(this.kVz.getPageContext(), i);
        if (this.kVF != null) {
            this.kVF.onChangeSkinType();
        }
        if (this.kVG != null) {
            this.kVG.onChangeSkinType();
        }
        if (this.kVH != null) {
            this.kVH.onChangeSkinType();
        }
        if (this.kVI != null) {
            this.kVI.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cXo() {
        return this.kVB;
    }

    public TbSettingTextTipView cXp() {
        return this.kVA;
    }

    public TbSettingTextTipView cXq() {
        return this.kVC;
    }

    public TbSettingTextTipView cXr() {
        return this.kVD;
    }

    public void cXs() {
        cXx();
        this.kVG.aSW();
    }

    public void cXt() {
        cXw();
        this.kVF.aSW();
    }

    public void cXu() {
        cXy();
        this.kVH.aSW();
    }

    public void cXv() {
        cXz();
        this.kVI.aSW();
    }

    private void initUI() {
        this.kVz.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kVz.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kVz.getPageContext().getString(R.string.browse_setting));
        this.kVA = (TbSettingTextTipView) this.kVz.findViewById(R.id.img_browser);
        this.kVA.setBottomLineVisibility(true);
        this.kVB = (TbSettingTextTipView) this.kVz.findViewById(R.id.add_img_water);
        this.kVB.setBottomLineVisibility(true);
        this.kVC = (TbSettingTextTipView) this.kVz.findViewById(R.id.font_size);
        this.kVC.setBottomLineVisibility(true);
        this.kVD = (TbSettingTextTipView) this.kVz.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.kVD.setText(R.string.video_gif_auto_play);
        } else {
            this.kVD.setText(R.string.video_auto_play);
        }
        this.kVD.setBottomLineVisibility(true);
        this.kVE = (MsgSettingItemView) this.kVz.findViewById(R.id.slide_anim_switch);
        this.kVE.setText(R.string.slide_anim_switch);
        this.kVE.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.kVE.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aTX().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").ag("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").ag("obj_type", 2));
            }
        });
        this.mParent = this.kVz.findViewById(R.id.parent);
    }

    private void initListener() {
        this.kVA.setOnClickListener(this.kVz);
        this.kVB.setOnClickListener(this.kVz);
        this.kVC.setOnClickListener(this.kVz);
        this.kVD.setOnClickListener(this.kVz);
    }

    private void cXw() {
        this.kVK = new ArrayList<>();
        int viewImageQuality = k.aNQ().getViewImageQuality();
        boolean isShowImages = k.aNQ().isShowImages();
        this.kVK.add(new m(this.kVz.getPageContext().getString(R.string.view_image_quality_auto_menu), this.kVz.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.kVK.add(new m(this.kVz.getPageContext().getString(R.string.view_high), this.kVz.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.kVK.add(new m(this.kVz.getPageContext().getString(R.string.view_low), this.kVz.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.kVK.add(new m(this.kVz.getPageContext().getString(R.string.close), this.kVz.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.kVF = new com.baidu.tbadk.core.dialog.e(this.kVz.getPageContext());
        this.kVF.kK(R.string.browser_image_quality);
        this.kVF.a(this.kVK, this.kVN).aSV();
    }

    private void cXx() {
        this.kVL = new ArrayList<>();
        int imageWaterType = k.aNQ().getImageWaterType();
        this.kVL.add(new m(this.kVz.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.kVL.add(new m(this.kVz.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.kVL.add(new m(this.kVz.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.kVG = new com.baidu.tbadk.core.dialog.e(this.kVz.getPageContext()).kK(R.string.add_image_water);
        this.kVG.a(this.kVL, this.kVO).aSV();
    }

    private void cXy() {
        this.kVH = new com.baidu.tbadk.core.dialog.e(this.kVz.getPageContext());
        this.kVJ = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.kVJ.add(new m(this.kVz.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.kVJ.add(new m(this.kVz.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.kVJ.add(new m(this.kVz.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.kVJ.add(new m(this.kVz.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.kVH.kK(R.string.font_size);
        this.kVH.a(this.kVJ, this.kVP);
        this.kVH.aSV();
    }

    private void cXz() {
        this.kVI = new com.baidu.tbadk.core.dialog.e(this.kVz.getPageContext());
        this.kVM = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.kVM.add(new m(this.kVz.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.kVM.add(new m(this.kVz.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.kVM.add(new m(this.kVz.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.kVI.kK(R.string.video_gif_auto_play);
        } else {
            this.kVI.kK(R.string.video_auto_play);
        }
        this.kVI.a(this.kVM, this.kVQ);
        this.kVI.aSV();
    }

    public void updateAll() {
        cXA();
        cXB();
        cXC();
        cXD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXA() {
        if (!k.aNQ().isShowImages()) {
            this.kVA.setTip(this.mContext.getString(R.string.close));
        } else if (k.aNQ().getViewImageQuality() == 1) {
            this.kVA.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.aNQ().getViewImageQuality() == 2) {
            this.kVA.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.kVA.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cXB() {
        CY(k.aNQ().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY(int i) {
        switch (i) {
            case 0:
                this.kVB.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.kVB.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.kVB.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cXC() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.kVC.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.kVC.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.kVC.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.kVC.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cXD() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.kVD.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.kVD.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.kVD.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
