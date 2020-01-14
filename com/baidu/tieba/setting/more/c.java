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
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity jRA;
    private TbSettingTextTipView jRB;
    private TbSettingTextTipView jRC;
    private TbSettingTextTipView jRD;
    private TbSettingTextTipView jRE;
    private MsgSettingItemView jRF;
    private com.baidu.tbadk.core.dialog.e jRG;
    private com.baidu.tbadk.core.dialog.e jRH;
    private com.baidu.tbadk.core.dialog.e jRI;
    private com.baidu.tbadk.core.dialog.e jRJ;
    private ArrayList<m> jRK;
    private ArrayList<m> jRL;
    private ArrayList<m> jRM;
    private ArrayList<m> jRN;
    private final AdapterView.OnItemClickListener jRO;
    private final AdapterView.OnItemClickListener jRP;
    private final AdapterView.OnItemClickListener jRQ;
    private final AdapterView.OnItemClickListener jRR;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jRA = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jRB = null;
        this.jRC = null;
        this.jRD = null;
        this.jRE = null;
        this.jRG = null;
        this.jRH = null;
        this.jRI = null;
        this.jRJ = null;
        this.jRO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jRG.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.axy().setShowImages(true);
                        com.baidu.tbadk.core.i.axy().setViewImageQuality(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.axy().setShowImages(true);
                        com.baidu.tbadk.core.i.axy().setViewImageQuality(1);
                        TiebaStatic.log(new an("c10415").Z("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.axy().setShowImages(true);
                        com.baidu.tbadk.core.i.axy().setViewImageQuality(2);
                        TiebaStatic.log(new an("c10415").Z("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.axy().setShowImages(false);
                        break;
                }
                c.this.jRG.dismiss();
                c.this.cEd();
            }
        };
        this.jRP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jRH.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").Z("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").Z("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").Z("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.jRA.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.axy().setImageWaterType(i2);
                c.this.Bx(i2);
            }
        };
        this.jRQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jRI.refresh(i);
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
                c.this.cEf();
            }
        };
        this.jRR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jRJ.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").Z("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").Z("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").Z("obj_type", 3));
                        break;
                }
                c.this.cEg();
            }
        };
        this.jRA = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jRA.getLayoutMode().setNightMode(i == 1);
        this.jRA.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jRF.onChangeSkinType(this.jRA.getPageContext(), i);
        if (this.jRG != null) {
            this.jRG.onChangeSkinType();
        }
        if (this.jRH != null) {
            this.jRH.onChangeSkinType();
        }
        if (this.jRI != null) {
            this.jRI.onChangeSkinType();
        }
        if (this.jRJ != null) {
            this.jRJ.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cDR() {
        return this.jRC;
    }

    public TbSettingTextTipView cDS() {
        return this.jRB;
    }

    public TbSettingTextTipView cDT() {
        return this.jRD;
    }

    public TbSettingTextTipView cDU() {
        return this.jRE;
    }

    public void cDV() {
        cEa();
        this.jRH.aCs();
    }

    public void cDW() {
        cDZ();
        this.jRG.aCs();
    }

    public void cDX() {
        cEb();
        this.jRI.aCs();
    }

    public void cDY() {
        cEc();
        this.jRJ.aCs();
    }

    private void initUI() {
        this.jRA.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jRA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRA.getPageContext().getString(R.string.browse_setting));
        this.jRB = (TbSettingTextTipView) this.jRA.findViewById(R.id.img_browser);
        this.jRB.setBottomLineVisibility(true);
        this.jRC = (TbSettingTextTipView) this.jRA.findViewById(R.id.add_img_water);
        this.jRC.setBottomLineVisibility(true);
        this.jRD = (TbSettingTextTipView) this.jRA.findViewById(R.id.font_size);
        this.jRD.setBottomLineVisibility(true);
        this.jRE = (TbSettingTextTipView) this.jRA.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jRE.setText(R.string.video_gif_auto_play);
        } else {
            this.jRE.setText(R.string.video_auto_play);
        }
        this.jRE.setBottomLineVisibility(true);
        this.jRF = (MsgSettingItemView) this.jRA.findViewById(R.id.slide_anim_switch);
        this.jRF.setText(R.string.slide_anim_switch);
        this.jRF.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jRF.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aDr().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").Z("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").Z("obj_type", 2));
            }
        });
        this.mParent = this.jRA.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jRB.setOnClickListener(this.jRA);
        this.jRC.setOnClickListener(this.jRA);
        this.jRD.setOnClickListener(this.jRA);
        this.jRE.setOnClickListener(this.jRA);
    }

    private void cDZ() {
        this.jRL = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.axy().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
        this.jRL.add(new m(this.jRA.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jRA.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jRL.add(new m(this.jRA.getPageContext().getString(R.string.view_high), this.jRA.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jRL.add(new m(this.jRA.getPageContext().getString(R.string.view_low), this.jRA.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jRL.add(new m(this.jRA.getPageContext().getString(R.string.close), this.jRA.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jRG = new com.baidu.tbadk.core.dialog.e(this.jRA.getPageContext());
        this.jRG.jM(R.string.browser_image_quality);
        this.jRG.a(this.jRL, this.jRO).aCr();
    }

    private void cEa() {
        this.jRM = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.axy().getImageWaterType();
        this.jRM.add(new m(this.jRA.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jRM.add(new m(this.jRA.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jRM.add(new m(this.jRA.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jRH = new com.baidu.tbadk.core.dialog.e(this.jRA.getPageContext()).jM(R.string.add_image_water);
        this.jRH.a(this.jRM, this.jRP).aCr();
    }

    private void cEb() {
        this.jRI = new com.baidu.tbadk.core.dialog.e(this.jRA.getPageContext());
        this.jRK = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jRK.add(new m(this.jRA.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jRK.add(new m(this.jRA.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jRK.add(new m(this.jRA.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jRK.add(new m(this.jRA.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jRI.jM(R.string.font_size);
        this.jRI.a(this.jRK, this.jRQ);
        this.jRI.aCr();
    }

    private void cEc() {
        this.jRJ = new com.baidu.tbadk.core.dialog.e(this.jRA.getPageContext());
        this.jRN = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jRN.add(new m(this.jRA.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jRN.add(new m(this.jRA.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jRN.add(new m(this.jRA.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jRJ.jM(R.string.video_gif_auto_play);
        } else {
            this.jRJ.jM(R.string.video_auto_play);
        }
        this.jRJ.a(this.jRN, this.jRR);
        this.jRJ.aCr();
    }

    public void updateAll() {
        cEd();
        cEe();
        cEf();
        cEg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEd() {
        if (!com.baidu.tbadk.core.i.axy().isShowImages()) {
            this.jRB.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.axy().getViewImageQuality() == 1) {
            this.jRB.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.axy().getViewImageQuality() == 2) {
            this.jRB.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jRB.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cEe() {
        Bx(com.baidu.tbadk.core.i.axy().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bx(int i) {
        switch (i) {
            case 0:
                this.jRC.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jRC.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jRC.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cEf() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jRD.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jRD.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jRD.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jRD.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cEg() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jRE.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jRE.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jRE.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
