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
    private MsgSettingItemView jRA;
    private com.baidu.tbadk.core.dialog.e jRB;
    private com.baidu.tbadk.core.dialog.e jRC;
    private com.baidu.tbadk.core.dialog.e jRD;
    private com.baidu.tbadk.core.dialog.e jRE;
    private ArrayList<m> jRF;
    private ArrayList<m> jRG;
    private ArrayList<m> jRH;
    private ArrayList<m> jRI;
    private final AdapterView.OnItemClickListener jRJ;
    private final AdapterView.OnItemClickListener jRK;
    private final AdapterView.OnItemClickListener jRL;
    private final AdapterView.OnItemClickListener jRM;
    private BrowseSettingActivity jRv;
    private TbSettingTextTipView jRw;
    private TbSettingTextTipView jRx;
    private TbSettingTextTipView jRy;
    private TbSettingTextTipView jRz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jRv = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jRw = null;
        this.jRx = null;
        this.jRy = null;
        this.jRz = null;
        this.jRB = null;
        this.jRC = null;
        this.jRD = null;
        this.jRE = null;
        this.jRJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jRB.refresh(i);
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
                c.this.jRB.dismiss();
                c.this.cEb();
            }
        };
        this.jRK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jRC.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.jRv.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.axy().setImageWaterType(i2);
                c.this.Bx(i2);
            }
        };
        this.jRL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jRD.refresh(i);
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
                c.this.cEd();
            }
        };
        this.jRM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jRE.refresh(i);
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
                c.this.cEe();
            }
        };
        this.jRv = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jRv.getLayoutMode().setNightMode(i == 1);
        this.jRv.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jRA.onChangeSkinType(this.jRv.getPageContext(), i);
        if (this.jRB != null) {
            this.jRB.onChangeSkinType();
        }
        if (this.jRC != null) {
            this.jRC.onChangeSkinType();
        }
        if (this.jRD != null) {
            this.jRD.onChangeSkinType();
        }
        if (this.jRE != null) {
            this.jRE.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cDP() {
        return this.jRx;
    }

    public TbSettingTextTipView cDQ() {
        return this.jRw;
    }

    public TbSettingTextTipView cDR() {
        return this.jRy;
    }

    public TbSettingTextTipView cDS() {
        return this.jRz;
    }

    public void cDT() {
        cDY();
        this.jRC.aCs();
    }

    public void cDU() {
        cDX();
        this.jRB.aCs();
    }

    public void cDV() {
        cDZ();
        this.jRD.aCs();
    }

    public void cDW() {
        cEa();
        this.jRE.aCs();
    }

    private void initUI() {
        this.jRv.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jRv.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jRv.getPageContext().getString(R.string.browse_setting));
        this.jRw = (TbSettingTextTipView) this.jRv.findViewById(R.id.img_browser);
        this.jRw.setBottomLineVisibility(true);
        this.jRx = (TbSettingTextTipView) this.jRv.findViewById(R.id.add_img_water);
        this.jRx.setBottomLineVisibility(true);
        this.jRy = (TbSettingTextTipView) this.jRv.findViewById(R.id.font_size);
        this.jRy.setBottomLineVisibility(true);
        this.jRz = (TbSettingTextTipView) this.jRv.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jRz.setText(R.string.video_gif_auto_play);
        } else {
            this.jRz.setText(R.string.video_auto_play);
        }
        this.jRz.setBottomLineVisibility(true);
        this.jRA = (MsgSettingItemView) this.jRv.findViewById(R.id.slide_anim_switch);
        this.jRA.setText(R.string.slide_anim_switch);
        this.jRA.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jRA.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.jRv.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jRw.setOnClickListener(this.jRv);
        this.jRx.setOnClickListener(this.jRv);
        this.jRy.setOnClickListener(this.jRv);
        this.jRz.setOnClickListener(this.jRv);
    }

    private void cDX() {
        this.jRG = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.axy().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.axy().isShowImages();
        this.jRG.add(new m(this.jRv.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jRv.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jRG.add(new m(this.jRv.getPageContext().getString(R.string.view_high), this.jRv.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jRG.add(new m(this.jRv.getPageContext().getString(R.string.view_low), this.jRv.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jRG.add(new m(this.jRv.getPageContext().getString(R.string.close), this.jRv.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jRB = new com.baidu.tbadk.core.dialog.e(this.jRv.getPageContext());
        this.jRB.jM(R.string.browser_image_quality);
        this.jRB.a(this.jRG, this.jRJ).aCr();
    }

    private void cDY() {
        this.jRH = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.axy().getImageWaterType();
        this.jRH.add(new m(this.jRv.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jRH.add(new m(this.jRv.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jRH.add(new m(this.jRv.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jRC = new com.baidu.tbadk.core.dialog.e(this.jRv.getPageContext()).jM(R.string.add_image_water);
        this.jRC.a(this.jRH, this.jRK).aCr();
    }

    private void cDZ() {
        this.jRD = new com.baidu.tbadk.core.dialog.e(this.jRv.getPageContext());
        this.jRF = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jRF.add(new m(this.jRv.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jRF.add(new m(this.jRv.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jRF.add(new m(this.jRv.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jRF.add(new m(this.jRv.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jRD.jM(R.string.font_size);
        this.jRD.a(this.jRF, this.jRL);
        this.jRD.aCr();
    }

    private void cEa() {
        this.jRE = new com.baidu.tbadk.core.dialog.e(this.jRv.getPageContext());
        this.jRI = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jRI.add(new m(this.jRv.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jRI.add(new m(this.jRv.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jRI.add(new m(this.jRv.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jRE.jM(R.string.video_gif_auto_play);
        } else {
            this.jRE.jM(R.string.video_auto_play);
        }
        this.jRE.a(this.jRI, this.jRM);
        this.jRE.aCr();
    }

    public void updateAll() {
        cEb();
        cEc();
        cEd();
        cEe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEb() {
        if (!com.baidu.tbadk.core.i.axy().isShowImages()) {
            this.jRw.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.axy().getViewImageQuality() == 1) {
            this.jRw.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.axy().getViewImageQuality() == 2) {
            this.jRw.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jRw.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cEc() {
        Bx(com.baidu.tbadk.core.i.axy().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bx(int i) {
        switch (i) {
            case 0:
                this.jRx.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jRx.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jRx.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cEd() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jRy.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jRy.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jRy.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jRy.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cEe() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jRz.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jRz.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jRz.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
