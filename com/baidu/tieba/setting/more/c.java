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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private TbSettingTextTipView lPA;
    private TbSettingTextTipView lPB;
    private TbSettingTextTipView lPC;
    private TbSettingTextTipView lPD;
    private MsgSettingItemView lPE;
    private com.baidu.tbadk.core.dialog.e lPF;
    private com.baidu.tbadk.core.dialog.e lPG;
    private com.baidu.tbadk.core.dialog.e lPH;
    private com.baidu.tbadk.core.dialog.e lPI;
    private ArrayList<m> lPJ;
    private ArrayList<m> lPK;
    private ArrayList<m> lPL;
    private ArrayList<m> lPM;
    private final AdapterView.OnItemClickListener lPN;
    private final AdapterView.OnItemClickListener lPO;
    private final AdapterView.OnItemClickListener lPP;
    private final AdapterView.OnItemClickListener lPQ;
    private BrowseSettingActivity lPz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.lPz = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.lPA = null;
        this.lPB = null;
        this.lPC = null;
        this.lPD = null;
        this.lPF = null;
        this.lPG = null;
        this.lPH = null;
        this.lPI = null;
        this.lPN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lPF.refresh(i);
                switch (i) {
                    case 0:
                        k.bbM().setShowImages(true);
                        k.bbM().mK(0);
                        break;
                    case 1:
                        k.bbM().setShowImages(true);
                        k.bbM().mK(1);
                        TiebaStatic.log(new aq("c10415").ai("obj_type", 1));
                        break;
                    case 2:
                        k.bbM().setShowImages(true);
                        k.bbM().mK(2);
                        TiebaStatic.log(new aq("c10415").ai("obj_type", 3));
                        break;
                    case 3:
                        k.bbM().setShowImages(false);
                        break;
                }
                c.this.lPF.dismiss();
                c.this.dqJ();
            }
        };
        this.lPO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.lPG.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new aq("c10411").ai("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new aq("c10411").ai("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new aq("c10411").ai("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.lPz.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bbM().setImageWaterType(i2);
                c.this.GV(i2);
            }
        };
        this.lPP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lPH.refresh(i);
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
                c.this.dqL();
            }
        };
        this.lPQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lPI.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new aq("c11281").ai("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new aq("c11281").ai("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new aq("c11281").ai("obj_type", 3));
                        break;
                }
                c.this.dqM();
            }
        };
        this.lPz = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lPz.getLayoutMode().setNightMode(i == 1);
        this.lPz.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lPE.onChangeSkinType(this.lPz.getPageContext(), i);
        if (this.lPF != null) {
            this.lPF.onChangeSkinType();
        }
        if (this.lPG != null) {
            this.lPG.onChangeSkinType();
        }
        if (this.lPH != null) {
            this.lPH.onChangeSkinType();
        }
        if (this.lPI != null) {
            this.lPI.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dqx() {
        return this.lPB;
    }

    public TbSettingTextTipView dqy() {
        return this.lPA;
    }

    public TbSettingTextTipView dqz() {
        return this.lPC;
    }

    public TbSettingTextTipView dqA() {
        return this.lPD;
    }

    public void dqB() {
        dqG();
        this.lPG.bhk();
    }

    public void dqC() {
        dqF();
        this.lPF.bhk();
    }

    public void dqD() {
        dqH();
        this.lPH.bhk();
    }

    public void dqE() {
        dqI();
        this.lPI.bhk();
    }

    private void initUI() {
        this.lPz.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lPz.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lPz.getPageContext().getString(R.string.browse_setting));
        this.lPA = (TbSettingTextTipView) this.lPz.findViewById(R.id.img_browser);
        this.lPA.setBottomLineVisibility(true);
        this.lPB = (TbSettingTextTipView) this.lPz.findViewById(R.id.add_img_water);
        this.lPB.setBottomLineVisibility(true);
        this.lPC = (TbSettingTextTipView) this.lPz.findViewById(R.id.font_size);
        this.lPC.setBottomLineVisibility(true);
        this.lPD = (TbSettingTextTipView) this.lPz.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.lPD.setText(R.string.video_gif_auto_play);
        } else {
            this.lPD.setText(R.string.video_auto_play);
        }
        this.lPD.setBottomLineVisibility(true);
        this.lPE = (MsgSettingItemView) this.lPz.findViewById(R.id.slide_anim_switch);
        this.lPE.setText(R.string.slide_anim_switch);
        this.lPE.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.lPE.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").ai("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").ai("obj_type", 2));
            }
        });
        this.mParent = this.lPz.findViewById(R.id.parent);
    }

    private void initListener() {
        this.lPA.setOnClickListener(this.lPz);
        this.lPB.setOnClickListener(this.lPz);
        this.lPC.setOnClickListener(this.lPz);
        this.lPD.setOnClickListener(this.lPz);
    }

    private void dqF() {
        this.lPK = new ArrayList<>();
        int viewImageQuality = k.bbM().getViewImageQuality();
        boolean isShowImages = k.bbM().isShowImages();
        this.lPK.add(new m(this.lPz.getPageContext().getString(R.string.view_image_quality_auto_menu), this.lPz.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.lPK.add(new m(this.lPz.getPageContext().getString(R.string.view_high), this.lPz.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.lPK.add(new m(this.lPz.getPageContext().getString(R.string.view_low), this.lPz.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.lPK.add(new m(this.lPz.getPageContext().getString(R.string.close), this.lPz.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.lPF = new com.baidu.tbadk.core.dialog.e(this.lPz.getPageContext());
        this.lPF.nA(R.string.browser_image_quality);
        this.lPF.a(this.lPK, this.lPN).bhj();
    }

    private void dqG() {
        this.lPL = new ArrayList<>();
        int imageWaterType = k.bbM().getImageWaterType();
        this.lPL.add(new m(this.lPz.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.lPL.add(new m(this.lPz.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.lPL.add(new m(this.lPz.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.lPG = new com.baidu.tbadk.core.dialog.e(this.lPz.getPageContext()).nA(R.string.add_image_water);
        this.lPG.a(this.lPL, this.lPO).bhj();
    }

    private void dqH() {
        this.lPH = new com.baidu.tbadk.core.dialog.e(this.lPz.getPageContext());
        this.lPJ = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.lPJ.add(new m(this.lPz.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.lPJ.add(new m(this.lPz.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.lPJ.add(new m(this.lPz.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.lPJ.add(new m(this.lPz.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.lPH.nA(R.string.font_size);
        this.lPH.a(this.lPJ, this.lPP);
        this.lPH.bhj();
    }

    private void dqI() {
        this.lPI = new com.baidu.tbadk.core.dialog.e(this.lPz.getPageContext());
        this.lPM = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.lPM.add(new m(this.lPz.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.lPM.add(new m(this.lPz.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.lPM.add(new m(this.lPz.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.lPI.nA(R.string.video_gif_auto_play);
        } else {
            this.lPI.nA(R.string.video_auto_play);
        }
        this.lPI.a(this.lPM, this.lPQ);
        this.lPI.bhj();
    }

    public void updateAll() {
        dqJ();
        dqK();
        dqL();
        dqM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqJ() {
        if (!k.bbM().isShowImages()) {
            this.lPA.setTip(this.mContext.getString(R.string.close));
        } else if (k.bbM().getViewImageQuality() == 1) {
            this.lPA.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bbM().getViewImageQuality() == 2) {
            this.lPA.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.lPA.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dqK() {
        GV(k.bbM().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV(int i) {
        switch (i) {
            case 0:
                this.lPB.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.lPB.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.lPB.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dqL() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.lPC.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.lPC.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.lPC.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.lPC.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dqM() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.lPD.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.lPD.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.lPD.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
