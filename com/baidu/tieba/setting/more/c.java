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
    private final AdapterView.OnItemClickListener jUA;
    private final AdapterView.OnItemClickListener jUB;
    private final AdapterView.OnItemClickListener jUC;
    private BrowseSettingActivity jUl;
    private TbSettingTextTipView jUm;
    private TbSettingTextTipView jUn;
    private TbSettingTextTipView jUo;
    private TbSettingTextTipView jUp;
    private MsgSettingItemView jUq;
    private com.baidu.tbadk.core.dialog.e jUr;
    private com.baidu.tbadk.core.dialog.e jUs;
    private com.baidu.tbadk.core.dialog.e jUt;
    private com.baidu.tbadk.core.dialog.e jUu;
    private ArrayList<m> jUv;
    private ArrayList<m> jUw;
    private ArrayList<m> jUx;
    private ArrayList<m> jUy;
    private final AdapterView.OnItemClickListener jUz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jUl = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jUm = null;
        this.jUn = null;
        this.jUo = null;
        this.jUp = null;
        this.jUr = null;
        this.jUs = null;
        this.jUt = null;
        this.jUu = null;
        this.jUz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jUr.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.azR().setShowImages(true);
                        com.baidu.tbadk.core.i.azR().jr(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.azR().setShowImages(true);
                        com.baidu.tbadk.core.i.azR().jr(1);
                        TiebaStatic.log(new an("c10415").X("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.azR().setShowImages(true);
                        com.baidu.tbadk.core.i.azR().jr(2);
                        TiebaStatic.log(new an("c10415").X("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.azR().setShowImages(false);
                        break;
                }
                c.this.jUr.dismiss();
                c.this.cGb();
            }
        };
        this.jUA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jUs.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.jUl.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.azR().setImageWaterType(i2);
                c.this.BO(i2);
            }
        };
        this.jUB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jUt.refresh(i);
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
                c.this.cGd();
            }
        };
        this.jUC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jUu.refresh(i);
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
                c.this.cGe();
            }
        };
        this.jUl = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jUl.getLayoutMode().setNightMode(i == 1);
        this.jUl.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jUq.onChangeSkinType(this.jUl.getPageContext(), i);
        if (this.jUr != null) {
            this.jUr.onChangeSkinType();
        }
        if (this.jUs != null) {
            this.jUs.onChangeSkinType();
        }
        if (this.jUt != null) {
            this.jUt.onChangeSkinType();
        }
        if (this.jUu != null) {
            this.jUu.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cFP() {
        return this.jUn;
    }

    public TbSettingTextTipView cFQ() {
        return this.jUm;
    }

    public TbSettingTextTipView cFR() {
        return this.jUo;
    }

    public TbSettingTextTipView cFS() {
        return this.jUp;
    }

    public void cFT() {
        cFY();
        this.jUs.aEJ();
    }

    public void cFU() {
        cFX();
        this.jUr.aEJ();
    }

    public void cFV() {
        cFZ();
        this.jUt.aEJ();
    }

    public void cFW() {
        cGa();
        this.jUu.aEJ();
    }

    private void initUI() {
        this.jUl.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jUl.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jUl.getPageContext().getString(R.string.browse_setting));
        this.jUm = (TbSettingTextTipView) this.jUl.findViewById(R.id.img_browser);
        this.jUm.setBottomLineVisibility(true);
        this.jUn = (TbSettingTextTipView) this.jUl.findViewById(R.id.add_img_water);
        this.jUn.setBottomLineVisibility(true);
        this.jUo = (TbSettingTextTipView) this.jUl.findViewById(R.id.font_size);
        this.jUo.setBottomLineVisibility(true);
        this.jUp = (TbSettingTextTipView) this.jUl.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jUp.setText(R.string.video_gif_auto_play);
        } else {
            this.jUp.setText(R.string.video_auto_play);
        }
        this.jUp.setBottomLineVisibility(true);
        this.jUq = (MsgSettingItemView) this.jUl.findViewById(R.id.slide_anim_switch);
        this.jUq.setText(R.string.slide_anim_switch);
        this.jUq.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jUq.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aFH().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").X("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").X("obj_type", 2));
            }
        });
        this.mParent = this.jUl.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jUm.setOnClickListener(this.jUl);
        this.jUn.setOnClickListener(this.jUl);
        this.jUo.setOnClickListener(this.jUl);
        this.jUp.setOnClickListener(this.jUl);
    }

    private void cFX() {
        this.jUw = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.azR().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.azR().isShowImages();
        this.jUw.add(new m(this.jUl.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jUl.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jUw.add(new m(this.jUl.getPageContext().getString(R.string.view_high), this.jUl.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jUw.add(new m(this.jUl.getPageContext().getString(R.string.view_low), this.jUl.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jUw.add(new m(this.jUl.getPageContext().getString(R.string.close), this.jUl.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jUr = new com.baidu.tbadk.core.dialog.e(this.jUl.getPageContext());
        this.jUr.kd(R.string.browser_image_quality);
        this.jUr.a(this.jUw, this.jUz).aEI();
    }

    private void cFY() {
        this.jUx = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.azR().getImageWaterType();
        this.jUx.add(new m(this.jUl.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jUx.add(new m(this.jUl.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jUx.add(new m(this.jUl.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jUs = new com.baidu.tbadk.core.dialog.e(this.jUl.getPageContext()).kd(R.string.add_image_water);
        this.jUs.a(this.jUx, this.jUA).aEI();
    }

    private void cFZ() {
        this.jUt = new com.baidu.tbadk.core.dialog.e(this.jUl.getPageContext());
        this.jUv = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jUv.add(new m(this.jUl.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jUv.add(new m(this.jUl.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jUv.add(new m(this.jUl.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jUv.add(new m(this.jUl.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jUt.kd(R.string.font_size);
        this.jUt.a(this.jUv, this.jUB);
        this.jUt.aEI();
    }

    private void cGa() {
        this.jUu = new com.baidu.tbadk.core.dialog.e(this.jUl.getPageContext());
        this.jUy = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jUy.add(new m(this.jUl.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jUy.add(new m(this.jUl.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jUy.add(new m(this.jUl.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jUu.kd(R.string.video_gif_auto_play);
        } else {
            this.jUu.kd(R.string.video_auto_play);
        }
        this.jUu.a(this.jUy, this.jUC);
        this.jUu.aEI();
    }

    public void updateAll() {
        cGb();
        cGc();
        cGd();
        cGe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGb() {
        if (!com.baidu.tbadk.core.i.azR().isShowImages()) {
            this.jUm.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.azR().getViewImageQuality() == 1) {
            this.jUm.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.azR().getViewImageQuality() == 2) {
            this.jUm.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jUm.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cGc() {
        BO(com.baidu.tbadk.core.i.azR().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BO(int i) {
        switch (i) {
            case 0:
                this.jUn.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jUn.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jUn.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cGd() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jUo.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jUo.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jUo.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jUo.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cGe() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jUp.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jUp.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jUp.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
