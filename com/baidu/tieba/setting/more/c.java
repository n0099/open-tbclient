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
/* loaded from: classes25.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity lYF;
    private TbSettingTextTipView lYG;
    private TbSettingTextTipView lYH;
    private TbSettingTextTipView lYI;
    private TbSettingTextTipView lYJ;
    private MsgSettingItemView lYK;
    private com.baidu.tbadk.core.dialog.e lYL;
    private com.baidu.tbadk.core.dialog.e lYM;
    private com.baidu.tbadk.core.dialog.e lYN;
    private com.baidu.tbadk.core.dialog.e lYO;
    private ArrayList<m> lYP;
    private ArrayList<m> lYQ;
    private ArrayList<m> lYR;
    private ArrayList<m> lYS;
    private TbSettingTextTipView lYT;
    private final AdapterView.OnItemClickListener lYU;
    private final AdapterView.OnItemClickListener lYV;
    private final AdapterView.OnItemClickListener lYW;
    private final AdapterView.OnItemClickListener lYX;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.lYF = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.lYG = null;
        this.lYH = null;
        this.lYI = null;
        this.lYJ = null;
        this.lYL = null;
        this.lYM = null;
        this.lYN = null;
        this.lYO = null;
        this.lYU = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lYL.refresh(i);
                switch (i) {
                    case 0:
                        k.bcG().setShowImages(true);
                        k.bcG().mV(0);
                        break;
                    case 1:
                        k.bcG().setShowImages(true);
                        k.bcG().mV(1);
                        TiebaStatic.log(new aq("c10415").ai("obj_type", 1));
                        break;
                    case 2:
                        k.bcG().setShowImages(true);
                        k.bcG().mV(2);
                        TiebaStatic.log(new aq("c10415").ai("obj_type", 3));
                        break;
                    case 3:
                        k.bcG().setShowImages(false);
                        break;
                }
                c.this.lYL.dismiss();
                c.this.duz();
            }
        };
        this.lYV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.lYM.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.lYF.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bcG().setImageWaterType(i2);
                c.this.Hy(i2);
            }
        };
        this.lYW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lYN.refresh(i);
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
                c.this.duB();
            }
        };
        this.lYX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lYO.refresh(i);
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
                c.this.duC();
            }
        };
        this.lYF = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lYF.getLayoutMode().setNightMode(i == 1);
        this.lYF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lYK.onChangeSkinType(this.lYF.getPageContext(), i);
        if (this.lYL != null) {
            this.lYL.onChangeSkinType();
        }
        if (this.lYM != null) {
            this.lYM.onChangeSkinType();
        }
        if (this.lYN != null) {
            this.lYN.onChangeSkinType();
        }
        if (this.lYO != null) {
            this.lYO.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dul() {
        return this.lYH;
    }

    public TbSettingTextTipView dum() {
        return this.lYG;
    }

    public TbSettingTextTipView dun() {
        return this.lYI;
    }

    public TbSettingTextTipView duo() {
        return this.lYJ;
    }

    public void dup() {
        duw();
        this.lYM.bie();
    }

    public void duq() {
        duv();
        this.lYL.bie();
    }

    public void dur() {
        dux();
        this.lYN.bie();
    }

    public void dus() {
        duy();
        this.lYO.bie();
    }

    public TbSettingTextTipView dut() {
        return this.lYT;
    }

    private void initUI() {
        this.lYF.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lYF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lYF.getPageContext().getString(R.string.browse_setting));
        this.lYT = (TbSettingTextTipView) this.lYF.findViewById(R.id.debug_tool_entrance);
        this.lYT.setBottomLineVisibility(true);
        this.lYG = (TbSettingTextTipView) this.lYF.findViewById(R.id.img_browser);
        this.lYG.setBottomLineVisibility(true);
        this.lYH = (TbSettingTextTipView) this.lYF.findViewById(R.id.add_img_water);
        this.lYH.setBottomLineVisibility(true);
        this.lYI = (TbSettingTextTipView) this.lYF.findViewById(R.id.font_size);
        this.lYI.setBottomLineVisibility(true);
        this.lYJ = (TbSettingTextTipView) this.lYF.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.lYJ.setText(R.string.video_gif_auto_play);
        } else {
            this.lYJ.setText(R.string.video_auto_play);
        }
        this.lYJ.setBottomLineVisibility(true);
        this.lYK = (MsgSettingItemView) this.lYF.findViewById(R.id.slide_anim_switch);
        this.lYK.setText(R.string.slide_anim_switch);
        this.lYK.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.lYK.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bjf().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").ai("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").ai("obj_type", 2));
            }
        });
        this.mParent = this.lYF.findViewById(R.id.parent);
    }

    private void duu() {
        this.lYT.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.lYG.setOnClickListener(this.lYF);
        this.lYH.setOnClickListener(this.lYF);
        this.lYI.setOnClickListener(this.lYF);
        this.lYJ.setOnClickListener(this.lYF);
        this.lYT.setOnClickListener(this.lYF);
    }

    private void duv() {
        this.lYQ = new ArrayList<>();
        int viewImageQuality = k.bcG().getViewImageQuality();
        boolean isShowImages = k.bcG().isShowImages();
        this.lYQ.add(new m(this.lYF.getPageContext().getString(R.string.view_image_quality_auto_menu), this.lYF.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.lYQ.add(new m(this.lYF.getPageContext().getString(R.string.view_high), this.lYF.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.lYQ.add(new m(this.lYF.getPageContext().getString(R.string.view_low), this.lYF.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.lYQ.add(new m(this.lYF.getPageContext().getString(R.string.close), this.lYF.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.lYL = new com.baidu.tbadk.core.dialog.e(this.lYF.getPageContext());
        this.lYL.nM(R.string.browser_image_quality);
        this.lYL.a(this.lYQ, this.lYU).bid();
    }

    private void duw() {
        this.lYR = new ArrayList<>();
        int imageWaterType = k.bcG().getImageWaterType();
        this.lYR.add(new m(this.lYF.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.lYR.add(new m(this.lYF.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.lYR.add(new m(this.lYF.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.lYM = new com.baidu.tbadk.core.dialog.e(this.lYF.getPageContext()).nM(R.string.add_image_water);
        this.lYM.a(this.lYR, this.lYV).bid();
    }

    private void dux() {
        this.lYN = new com.baidu.tbadk.core.dialog.e(this.lYF.getPageContext());
        this.lYP = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.lYP.add(new m(this.lYF.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.lYP.add(new m(this.lYF.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.lYP.add(new m(this.lYF.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.lYP.add(new m(this.lYF.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.lYN.nM(R.string.font_size);
        this.lYN.a(this.lYP, this.lYW);
        this.lYN.bid();
    }

    private void duy() {
        this.lYO = new com.baidu.tbadk.core.dialog.e(this.lYF.getPageContext());
        this.lYS = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.lYS.add(new m(this.lYF.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.lYS.add(new m(this.lYF.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.lYS.add(new m(this.lYF.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.lYO.nM(R.string.video_gif_auto_play);
        } else {
            this.lYO.nM(R.string.video_auto_play);
        }
        this.lYO.a(this.lYS, this.lYX);
        this.lYO.bid();
    }

    public void updateAll() {
        duz();
        duA();
        duB();
        duC();
        duu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duz() {
        if (!k.bcG().isShowImages()) {
            this.lYG.setTip(this.mContext.getString(R.string.close));
        } else if (k.bcG().getViewImageQuality() == 1) {
            this.lYG.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bcG().getViewImageQuality() == 2) {
            this.lYG.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.lYG.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void duA() {
        Hy(k.bcG().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(int i) {
        switch (i) {
            case 0:
                this.lYH.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.lYH.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.lYH.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void duB() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.lYI.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.lYI.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.lYI.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.lYI.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void duC() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.lYJ.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.lYJ.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.lYJ.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
