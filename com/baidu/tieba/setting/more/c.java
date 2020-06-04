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
    private BrowseSettingActivity kWI;
    private TbSettingTextTipView kWJ;
    private TbSettingTextTipView kWK;
    private TbSettingTextTipView kWL;
    private TbSettingTextTipView kWM;
    private MsgSettingItemView kWN;
    private com.baidu.tbadk.core.dialog.e kWO;
    private com.baidu.tbadk.core.dialog.e kWP;
    private com.baidu.tbadk.core.dialog.e kWQ;
    private com.baidu.tbadk.core.dialog.e kWR;
    private ArrayList<m> kWS;
    private ArrayList<m> kWT;
    private ArrayList<m> kWU;
    private ArrayList<m> kWV;
    private final AdapterView.OnItemClickListener kWW;
    private final AdapterView.OnItemClickListener kWX;
    private final AdapterView.OnItemClickListener kWY;
    private final AdapterView.OnItemClickListener kWZ;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.kWI = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.kWJ = null;
        this.kWK = null;
        this.kWL = null;
        this.kWM = null;
        this.kWO = null;
        this.kWP = null;
        this.kWQ = null;
        this.kWR = null;
        this.kWW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kWO.refresh(i);
                switch (i) {
                    case 0:
                        k.aNQ().setShowImages(true);
                        k.aNQ().ka(0);
                        break;
                    case 1:
                        k.aNQ().setShowImages(true);
                        k.aNQ().ka(1);
                        TiebaStatic.log(new an("c10415").ag("obj_type", 1));
                        break;
                    case 2:
                        k.aNQ().setShowImages(true);
                        k.aNQ().ka(2);
                        TiebaStatic.log(new an("c10415").ag("obj_type", 3));
                        break;
                    case 3:
                        k.aNQ().setShowImages(false);
                        break;
                }
                c.this.kWO.dismiss();
                c.this.cXQ();
            }
        };
        this.kWX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.kWP.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.kWI.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.aNQ().setImageWaterType(i2);
                c.this.Da(i2);
            }
        };
        this.kWY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kWQ.refresh(i);
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
                c.this.cXS();
            }
        };
        this.kWZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.kWR.refresh(i);
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
                c.this.cXT();
            }
        };
        this.kWI = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.kWI.getLayoutMode().setNightMode(i == 1);
        this.kWI.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.kWN.onChangeSkinType(this.kWI.getPageContext(), i);
        if (this.kWO != null) {
            this.kWO.onChangeSkinType();
        }
        if (this.kWP != null) {
            this.kWP.onChangeSkinType();
        }
        if (this.kWQ != null) {
            this.kWQ.onChangeSkinType();
        }
        if (this.kWR != null) {
            this.kWR.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cXE() {
        return this.kWK;
    }

    public TbSettingTextTipView cXF() {
        return this.kWJ;
    }

    public TbSettingTextTipView cXG() {
        return this.kWL;
    }

    public TbSettingTextTipView cXH() {
        return this.kWM;
    }

    public void cXI() {
        cXN();
        this.kWP.aSW();
    }

    public void cXJ() {
        cXM();
        this.kWO.aSW();
    }

    public void cXK() {
        cXO();
        this.kWQ.aSW();
    }

    public void cXL() {
        cXP();
        this.kWR.aSW();
    }

    private void initUI() {
        this.kWI.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.kWI.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.kWI.getPageContext().getString(R.string.browse_setting));
        this.kWJ = (TbSettingTextTipView) this.kWI.findViewById(R.id.img_browser);
        this.kWJ.setBottomLineVisibility(true);
        this.kWK = (TbSettingTextTipView) this.kWI.findViewById(R.id.add_img_water);
        this.kWK.setBottomLineVisibility(true);
        this.kWL = (TbSettingTextTipView) this.kWI.findViewById(R.id.font_size);
        this.kWL.setBottomLineVisibility(true);
        this.kWM = (TbSettingTextTipView) this.kWI.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.kWM.setText(R.string.video_gif_auto_play);
        } else {
            this.kWM.setText(R.string.video_auto_play);
        }
        this.kWM.setBottomLineVisibility(true);
        this.kWN = (MsgSettingItemView) this.kWI.findViewById(R.id.slide_anim_switch);
        this.kWN.setText(R.string.slide_anim_switch);
        this.kWN.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.kWN.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.kWI.findViewById(R.id.parent);
    }

    private void initListener() {
        this.kWJ.setOnClickListener(this.kWI);
        this.kWK.setOnClickListener(this.kWI);
        this.kWL.setOnClickListener(this.kWI);
        this.kWM.setOnClickListener(this.kWI);
    }

    private void cXM() {
        this.kWT = new ArrayList<>();
        int viewImageQuality = k.aNQ().getViewImageQuality();
        boolean isShowImages = k.aNQ().isShowImages();
        this.kWT.add(new m(this.kWI.getPageContext().getString(R.string.view_image_quality_auto_menu), this.kWI.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.kWT.add(new m(this.kWI.getPageContext().getString(R.string.view_high), this.kWI.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.kWT.add(new m(this.kWI.getPageContext().getString(R.string.view_low), this.kWI.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.kWT.add(new m(this.kWI.getPageContext().getString(R.string.close), this.kWI.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.kWO = new com.baidu.tbadk.core.dialog.e(this.kWI.getPageContext());
        this.kWO.kM(R.string.browser_image_quality);
        this.kWO.a(this.kWT, this.kWW).aSV();
    }

    private void cXN() {
        this.kWU = new ArrayList<>();
        int imageWaterType = k.aNQ().getImageWaterType();
        this.kWU.add(new m(this.kWI.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.kWU.add(new m(this.kWI.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.kWU.add(new m(this.kWI.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.kWP = new com.baidu.tbadk.core.dialog.e(this.kWI.getPageContext()).kM(R.string.add_image_water);
        this.kWP.a(this.kWU, this.kWX).aSV();
    }

    private void cXO() {
        this.kWQ = new com.baidu.tbadk.core.dialog.e(this.kWI.getPageContext());
        this.kWS = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.kWS.add(new m(this.kWI.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.kWS.add(new m(this.kWI.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.kWS.add(new m(this.kWI.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.kWS.add(new m(this.kWI.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.kWQ.kM(R.string.font_size);
        this.kWQ.a(this.kWS, this.kWY);
        this.kWQ.aSV();
    }

    private void cXP() {
        this.kWR = new com.baidu.tbadk.core.dialog.e(this.kWI.getPageContext());
        this.kWV = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.kWV.add(new m(this.kWI.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.kWV.add(new m(this.kWI.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.kWV.add(new m(this.kWI.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.kWR.kM(R.string.video_gif_auto_play);
        } else {
            this.kWR.kM(R.string.video_auto_play);
        }
        this.kWR.a(this.kWV, this.kWZ);
        this.kWR.aSV();
    }

    public void updateAll() {
        cXQ();
        cXR();
        cXS();
        cXT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXQ() {
        if (!k.aNQ().isShowImages()) {
            this.kWJ.setTip(this.mContext.getString(R.string.close));
        } else if (k.aNQ().getViewImageQuality() == 1) {
            this.kWJ.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.aNQ().getViewImageQuality() == 2) {
            this.kWJ.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.kWJ.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cXR() {
        Da(k.aNQ().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(int i) {
        switch (i) {
            case 0:
                this.kWK.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.kWK.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.kWK.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cXS() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.kWL.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.kWL.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.kWL.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.kWL.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cXT() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.kWM.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.kWM.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.kWM.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
