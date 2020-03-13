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
    private BrowseSettingActivity jSJ;
    private TbSettingTextTipView jSK;
    private TbSettingTextTipView jSL;
    private TbSettingTextTipView jSM;
    private TbSettingTextTipView jSN;
    private MsgSettingItemView jSO;
    private com.baidu.tbadk.core.dialog.e jSP;
    private com.baidu.tbadk.core.dialog.e jSQ;
    private com.baidu.tbadk.core.dialog.e jSR;
    private com.baidu.tbadk.core.dialog.e jSS;
    private ArrayList<m> jST;
    private ArrayList<m> jSU;
    private ArrayList<m> jSV;
    private ArrayList<m> jSW;
    private final AdapterView.OnItemClickListener jSX;
    private final AdapterView.OnItemClickListener jSY;
    private final AdapterView.OnItemClickListener jSZ;
    private final AdapterView.OnItemClickListener jTa;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jSJ = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jSK = null;
        this.jSL = null;
        this.jSM = null;
        this.jSN = null;
        this.jSP = null;
        this.jSQ = null;
        this.jSR = null;
        this.jSS = null;
        this.jSX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSP.refresh(i);
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
                c.this.jSP.dismiss();
                c.this.cFH();
            }
        };
        this.jSY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jSQ.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.jSJ.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.azO().setImageWaterType(i2);
                c.this.BG(i2);
            }
        };
        this.jSZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSR.refresh(i);
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
                c.this.cFJ();
            }
        };
        this.jTa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jSS.refresh(i);
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
                c.this.cFK();
            }
        };
        this.jSJ = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jSJ.getLayoutMode().setNightMode(i == 1);
        this.jSJ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jSO.onChangeSkinType(this.jSJ.getPageContext(), i);
        if (this.jSP != null) {
            this.jSP.onChangeSkinType();
        }
        if (this.jSQ != null) {
            this.jSQ.onChangeSkinType();
        }
        if (this.jSR != null) {
            this.jSR.onChangeSkinType();
        }
        if (this.jSS != null) {
            this.jSS.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cFv() {
        return this.jSL;
    }

    public TbSettingTextTipView cFw() {
        return this.jSK;
    }

    public TbSettingTextTipView cFx() {
        return this.jSM;
    }

    public TbSettingTextTipView cFy() {
        return this.jSN;
    }

    public void cFz() {
        cFE();
        this.jSQ.aEF();
    }

    public void cFA() {
        cFD();
        this.jSP.aEF();
    }

    public void cFB() {
        cFF();
        this.jSR.aEF();
    }

    public void cFC() {
        cFG();
        this.jSS.aEF();
    }

    private void initUI() {
        this.jSJ.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jSJ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jSJ.getPageContext().getString(R.string.browse_setting));
        this.jSK = (TbSettingTextTipView) this.jSJ.findViewById(R.id.img_browser);
        this.jSK.setBottomLineVisibility(true);
        this.jSL = (TbSettingTextTipView) this.jSJ.findViewById(R.id.add_img_water);
        this.jSL.setBottomLineVisibility(true);
        this.jSM = (TbSettingTextTipView) this.jSJ.findViewById(R.id.font_size);
        this.jSM.setBottomLineVisibility(true);
        this.jSN = (TbSettingTextTipView) this.jSJ.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jSN.setText(R.string.video_gif_auto_play);
        } else {
            this.jSN.setText(R.string.video_auto_play);
        }
        this.jSN.setBottomLineVisibility(true);
        this.jSO = (MsgSettingItemView) this.jSJ.findViewById(R.id.slide_anim_switch);
        this.jSO.setText(R.string.slide_anim_switch);
        this.jSO.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jSO.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.jSJ.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jSK.setOnClickListener(this.jSJ);
        this.jSL.setOnClickListener(this.jSJ);
        this.jSM.setOnClickListener(this.jSJ);
        this.jSN.setOnClickListener(this.jSJ);
    }

    private void cFD() {
        this.jSU = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.azO().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.azO().isShowImages();
        this.jSU.add(new m(this.jSJ.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jSJ.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jSU.add(new m(this.jSJ.getPageContext().getString(R.string.view_high), this.jSJ.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jSU.add(new m(this.jSJ.getPageContext().getString(R.string.view_low), this.jSJ.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jSU.add(new m(this.jSJ.getPageContext().getString(R.string.close), this.jSJ.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jSP = new com.baidu.tbadk.core.dialog.e(this.jSJ.getPageContext());
        this.jSP.kd(R.string.browser_image_quality);
        this.jSP.a(this.jSU, this.jSX).aEE();
    }

    private void cFE() {
        this.jSV = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.azO().getImageWaterType();
        this.jSV.add(new m(this.jSJ.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jSV.add(new m(this.jSJ.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jSV.add(new m(this.jSJ.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jSQ = new com.baidu.tbadk.core.dialog.e(this.jSJ.getPageContext()).kd(R.string.add_image_water);
        this.jSQ.a(this.jSV, this.jSY).aEE();
    }

    private void cFF() {
        this.jSR = new com.baidu.tbadk.core.dialog.e(this.jSJ.getPageContext());
        this.jST = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jST.add(new m(this.jSJ.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jST.add(new m(this.jSJ.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jST.add(new m(this.jSJ.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jST.add(new m(this.jSJ.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jSR.kd(R.string.font_size);
        this.jSR.a(this.jST, this.jSZ);
        this.jSR.aEE();
    }

    private void cFG() {
        this.jSS = new com.baidu.tbadk.core.dialog.e(this.jSJ.getPageContext());
        this.jSW = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jSW.add(new m(this.jSJ.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jSW.add(new m(this.jSJ.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jSW.add(new m(this.jSJ.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jSS.kd(R.string.video_gif_auto_play);
        } else {
            this.jSS.kd(R.string.video_auto_play);
        }
        this.jSS.a(this.jSW, this.jTa);
        this.jSS.aEE();
    }

    public void updateAll() {
        cFH();
        cFI();
        cFJ();
        cFK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFH() {
        if (!com.baidu.tbadk.core.i.azO().isShowImages()) {
            this.jSK.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.azO().getViewImageQuality() == 1) {
            this.jSK.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.azO().getViewImageQuality() == 2) {
            this.jSK.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jSK.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cFI() {
        BG(com.baidu.tbadk.core.i.azO().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BG(int i) {
        switch (i) {
            case 0:
                this.jSL.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jSL.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jSL.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cFJ() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jSM.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jSM.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jSM.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jSM.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cFK() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jSN.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jSN.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jSN.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
