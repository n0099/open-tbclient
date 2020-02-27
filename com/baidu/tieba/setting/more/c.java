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
    private MsgSettingItemView jSA;
    private com.baidu.tbadk.core.dialog.e jSB;
    private com.baidu.tbadk.core.dialog.e jSC;
    private com.baidu.tbadk.core.dialog.e jSD;
    private com.baidu.tbadk.core.dialog.e jSE;
    private ArrayList<m> jSF;
    private ArrayList<m> jSG;
    private ArrayList<m> jSH;
    private ArrayList<m> jSI;
    private final AdapterView.OnItemClickListener jSJ;
    private final AdapterView.OnItemClickListener jSK;
    private final AdapterView.OnItemClickListener jSL;
    private final AdapterView.OnItemClickListener jSM;
    private BrowseSettingActivity jSv;
    private TbSettingTextTipView jSw;
    private TbSettingTextTipView jSx;
    private TbSettingTextTipView jSy;
    private TbSettingTextTipView jSz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jSv = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jSw = null;
        this.jSx = null;
        this.jSy = null;
        this.jSz = null;
        this.jSB = null;
        this.jSC = null;
        this.jSD = null;
        this.jSE = null;
        this.jSJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSB.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.azM().setShowImages(true);
                        com.baidu.tbadk.core.i.azM().jr(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.azM().setShowImages(true);
                        com.baidu.tbadk.core.i.azM().jr(1);
                        TiebaStatic.log(new an("c10415").X("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.azM().setShowImages(true);
                        com.baidu.tbadk.core.i.azM().jr(2);
                        TiebaStatic.log(new an("c10415").X("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.azM().setShowImages(false);
                        break;
                }
                c.this.jSB.dismiss();
                c.this.cFE();
            }
        };
        this.jSK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jSC.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.jSv.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.azM().setImageWaterType(i2);
                c.this.BG(i2);
            }
        };
        this.jSL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSD.refresh(i);
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
                c.this.cFG();
            }
        };
        this.jSM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSE.refresh(i);
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
                c.this.cFH();
            }
        };
        this.jSv = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jSv.getLayoutMode().setNightMode(i == 1);
        this.jSv.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jSA.onChangeSkinType(this.jSv.getPageContext(), i);
        if (this.jSB != null) {
            this.jSB.onChangeSkinType();
        }
        if (this.jSC != null) {
            this.jSC.onChangeSkinType();
        }
        if (this.jSD != null) {
            this.jSD.onChangeSkinType();
        }
        if (this.jSE != null) {
            this.jSE.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cFs() {
        return this.jSx;
    }

    public TbSettingTextTipView cFt() {
        return this.jSw;
    }

    public TbSettingTextTipView cFu() {
        return this.jSy;
    }

    public TbSettingTextTipView cFv() {
        return this.jSz;
    }

    public void cFw() {
        cFB();
        this.jSC.aED();
    }

    public void cFx() {
        cFA();
        this.jSB.aED();
    }

    public void cFy() {
        cFC();
        this.jSD.aED();
    }

    public void cFz() {
        cFD();
        this.jSE.aED();
    }

    private void initUI() {
        this.jSv.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jSv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSv.getPageContext().getString(R.string.browse_setting));
        this.jSw = (TbSettingTextTipView) this.jSv.findViewById(R.id.img_browser);
        this.jSw.setBottomLineVisibility(true);
        this.jSx = (TbSettingTextTipView) this.jSv.findViewById(R.id.add_img_water);
        this.jSx.setBottomLineVisibility(true);
        this.jSy = (TbSettingTextTipView) this.jSv.findViewById(R.id.font_size);
        this.jSy.setBottomLineVisibility(true);
        this.jSz = (TbSettingTextTipView) this.jSv.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jSz.setText(R.string.video_gif_auto_play);
        } else {
            this.jSz.setText(R.string.video_auto_play);
        }
        this.jSz.setBottomLineVisibility(true);
        this.jSA = (MsgSettingItemView) this.jSv.findViewById(R.id.slide_anim_switch);
        this.jSA.setText(R.string.slide_anim_switch);
        this.jSA.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jSA.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aFB().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").X("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").X("obj_type", 2));
            }
        });
        this.mParent = this.jSv.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jSw.setOnClickListener(this.jSv);
        this.jSx.setOnClickListener(this.jSv);
        this.jSy.setOnClickListener(this.jSv);
        this.jSz.setOnClickListener(this.jSv);
    }

    private void cFA() {
        this.jSG = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.azM().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.azM().isShowImages();
        this.jSG.add(new m(this.jSv.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jSv.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jSG.add(new m(this.jSv.getPageContext().getString(R.string.view_high), this.jSv.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jSG.add(new m(this.jSv.getPageContext().getString(R.string.view_low), this.jSv.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jSG.add(new m(this.jSv.getPageContext().getString(R.string.close), this.jSv.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jSB = new com.baidu.tbadk.core.dialog.e(this.jSv.getPageContext());
        this.jSB.kd(R.string.browser_image_quality);
        this.jSB.a(this.jSG, this.jSJ).aEC();
    }

    private void cFB() {
        this.jSH = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.azM().getImageWaterType();
        this.jSH.add(new m(this.jSv.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jSH.add(new m(this.jSv.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jSH.add(new m(this.jSv.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jSC = new com.baidu.tbadk.core.dialog.e(this.jSv.getPageContext()).kd(R.string.add_image_water);
        this.jSC.a(this.jSH, this.jSK).aEC();
    }

    private void cFC() {
        this.jSD = new com.baidu.tbadk.core.dialog.e(this.jSv.getPageContext());
        this.jSF = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jSF.add(new m(this.jSv.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jSF.add(new m(this.jSv.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jSF.add(new m(this.jSv.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jSF.add(new m(this.jSv.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jSD.kd(R.string.font_size);
        this.jSD.a(this.jSF, this.jSL);
        this.jSD.aEC();
    }

    private void cFD() {
        this.jSE = new com.baidu.tbadk.core.dialog.e(this.jSv.getPageContext());
        this.jSI = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jSI.add(new m(this.jSv.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jSI.add(new m(this.jSv.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jSI.add(new m(this.jSv.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jSE.kd(R.string.video_gif_auto_play);
        } else {
            this.jSE.kd(R.string.video_auto_play);
        }
        this.jSE.a(this.jSI, this.jSM);
        this.jSE.aEC();
    }

    public void updateAll() {
        cFE();
        cFF();
        cFG();
        cFH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFE() {
        if (!com.baidu.tbadk.core.i.azM().isShowImages()) {
            this.jSw.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.azM().getViewImageQuality() == 1) {
            this.jSw.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.azM().getViewImageQuality() == 2) {
            this.jSw.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jSw.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cFF() {
        BG(com.baidu.tbadk.core.i.azM().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BG(int i) {
        switch (i) {
            case 0:
                this.jSx.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jSx.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jSx.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cFG() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jSy.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jSy.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jSy.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jSy.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cFH() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jSz.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jSz.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jSz.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
