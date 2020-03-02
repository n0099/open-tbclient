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
    private TbSettingTextTipView jSA;
    private TbSettingTextTipView jSB;
    private MsgSettingItemView jSC;
    private com.baidu.tbadk.core.dialog.e jSD;
    private com.baidu.tbadk.core.dialog.e jSE;
    private com.baidu.tbadk.core.dialog.e jSF;
    private com.baidu.tbadk.core.dialog.e jSG;
    private ArrayList<m> jSH;
    private ArrayList<m> jSI;
    private ArrayList<m> jSJ;
    private ArrayList<m> jSK;
    private final AdapterView.OnItemClickListener jSL;
    private final AdapterView.OnItemClickListener jSM;
    private final AdapterView.OnItemClickListener jSN;
    private final AdapterView.OnItemClickListener jSO;
    private BrowseSettingActivity jSx;
    private TbSettingTextTipView jSy;
    private TbSettingTextTipView jSz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jSx = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jSy = null;
        this.jSz = null;
        this.jSA = null;
        this.jSB = null;
        this.jSD = null;
        this.jSE = null;
        this.jSF = null;
        this.jSG = null;
        this.jSL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSD.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.azO().setShowImages(true);
                        com.baidu.tbadk.core.i.azO().jr(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.azO().setShowImages(true);
                        com.baidu.tbadk.core.i.azO().jr(1);
                        TiebaStatic.log(new an("c10415").X("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.azO().setShowImages(true);
                        com.baidu.tbadk.core.i.azO().jr(2);
                        TiebaStatic.log(new an("c10415").X("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.azO().setShowImages(false);
                        break;
                }
                c.this.jSD.dismiss();
                c.this.cFG();
            }
        };
        this.jSM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jSE.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").X("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").X("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").X("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.jSx.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.azO().setImageWaterType(i2);
                c.this.BG(i2);
            }
        };
        this.jSN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSF.refresh(i);
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
                c.this.cFI();
            }
        };
        this.jSO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSG.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").X("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").X("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").X("obj_type", 3));
                        break;
                }
                c.this.cFJ();
            }
        };
        this.jSx = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jSx.getLayoutMode().setNightMode(i == 1);
        this.jSx.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jSC.onChangeSkinType(this.jSx.getPageContext(), i);
        if (this.jSD != null) {
            this.jSD.onChangeSkinType();
        }
        if (this.jSE != null) {
            this.jSE.onChangeSkinType();
        }
        if (this.jSF != null) {
            this.jSF.onChangeSkinType();
        }
        if (this.jSG != null) {
            this.jSG.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cFu() {
        return this.jSz;
    }

    public TbSettingTextTipView cFv() {
        return this.jSy;
    }

    public TbSettingTextTipView cFw() {
        return this.jSA;
    }

    public TbSettingTextTipView cFx() {
        return this.jSB;
    }

    public void cFy() {
        cFD();
        this.jSE.aEF();
    }

    public void cFz() {
        cFC();
        this.jSD.aEF();
    }

    public void cFA() {
        cFE();
        this.jSF.aEF();
    }

    public void cFB() {
        cFF();
        this.jSG.aEF();
    }

    private void initUI() {
        this.jSx.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jSx.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSx.getPageContext().getString(R.string.browse_setting));
        this.jSy = (TbSettingTextTipView) this.jSx.findViewById(R.id.img_browser);
        this.jSy.setBottomLineVisibility(true);
        this.jSz = (TbSettingTextTipView) this.jSx.findViewById(R.id.add_img_water);
        this.jSz.setBottomLineVisibility(true);
        this.jSA = (TbSettingTextTipView) this.jSx.findViewById(R.id.font_size);
        this.jSA.setBottomLineVisibility(true);
        this.jSB = (TbSettingTextTipView) this.jSx.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jSB.setText(R.string.video_gif_auto_play);
        } else {
            this.jSB.setText(R.string.video_auto_play);
        }
        this.jSB.setBottomLineVisibility(true);
        this.jSC = (MsgSettingItemView) this.jSx.findViewById(R.id.slide_anim_switch);
        this.jSC.setText(R.string.slide_anim_switch);
        this.jSC.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jSC.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aFD().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").X("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").X("obj_type", 2));
            }
        });
        this.mParent = this.jSx.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jSy.setOnClickListener(this.jSx);
        this.jSz.setOnClickListener(this.jSx);
        this.jSA.setOnClickListener(this.jSx);
        this.jSB.setOnClickListener(this.jSx);
    }

    private void cFC() {
        this.jSI = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.azO().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.azO().isShowImages();
        this.jSI.add(new m(this.jSx.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jSx.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jSI.add(new m(this.jSx.getPageContext().getString(R.string.view_high), this.jSx.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jSI.add(new m(this.jSx.getPageContext().getString(R.string.view_low), this.jSx.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jSI.add(new m(this.jSx.getPageContext().getString(R.string.close), this.jSx.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jSD = new com.baidu.tbadk.core.dialog.e(this.jSx.getPageContext());
        this.jSD.kd(R.string.browser_image_quality);
        this.jSD.a(this.jSI, this.jSL).aEE();
    }

    private void cFD() {
        this.jSJ = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.azO().getImageWaterType();
        this.jSJ.add(new m(this.jSx.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jSJ.add(new m(this.jSx.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jSJ.add(new m(this.jSx.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jSE = new com.baidu.tbadk.core.dialog.e(this.jSx.getPageContext()).kd(R.string.add_image_water);
        this.jSE.a(this.jSJ, this.jSM).aEE();
    }

    private void cFE() {
        this.jSF = new com.baidu.tbadk.core.dialog.e(this.jSx.getPageContext());
        this.jSH = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jSH.add(new m(this.jSx.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jSH.add(new m(this.jSx.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jSH.add(new m(this.jSx.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jSH.add(new m(this.jSx.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jSF.kd(R.string.font_size);
        this.jSF.a(this.jSH, this.jSN);
        this.jSF.aEE();
    }

    private void cFF() {
        this.jSG = new com.baidu.tbadk.core.dialog.e(this.jSx.getPageContext());
        this.jSK = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jSK.add(new m(this.jSx.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jSK.add(new m(this.jSx.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jSK.add(new m(this.jSx.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jSG.kd(R.string.video_gif_auto_play);
        } else {
            this.jSG.kd(R.string.video_auto_play);
        }
        this.jSG.a(this.jSK, this.jSO);
        this.jSG.aEE();
    }

    public void updateAll() {
        cFG();
        cFH();
        cFI();
        cFJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFG() {
        if (!com.baidu.tbadk.core.i.azO().isShowImages()) {
            this.jSy.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.azO().getViewImageQuality() == 1) {
            this.jSy.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.azO().getViewImageQuality() == 2) {
            this.jSy.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jSy.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cFH() {
        BG(com.baidu.tbadk.core.i.azO().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BG(int i) {
        switch (i) {
            case 0:
                this.jSz.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jSz.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jSz.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cFI() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jSA.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jSA.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jSA.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jSA.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cFJ() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jSB.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jSB.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jSB.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
