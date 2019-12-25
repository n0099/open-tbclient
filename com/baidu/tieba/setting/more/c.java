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
/* loaded from: classes10.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity jNS;
    private TbSettingTextTipView jNT;
    private TbSettingTextTipView jNU;
    private TbSettingTextTipView jNV;
    private TbSettingTextTipView jNW;
    private MsgSettingItemView jNX;
    private com.baidu.tbadk.core.dialog.e jNY;
    private com.baidu.tbadk.core.dialog.e jNZ;
    private com.baidu.tbadk.core.dialog.e jOa;
    private com.baidu.tbadk.core.dialog.e jOb;
    private ArrayList<m> jOc;
    private ArrayList<m> jOd;
    private ArrayList<m> jOe;
    private ArrayList<m> jOf;
    private final AdapterView.OnItemClickListener jOg;
    private final AdapterView.OnItemClickListener jOh;
    private final AdapterView.OnItemClickListener jOi;
    private final AdapterView.OnItemClickListener jOj;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.jNS = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.jNT = null;
        this.jNU = null;
        this.jNV = null;
        this.jNW = null;
        this.jNY = null;
        this.jNZ = null;
        this.jOa = null;
        this.jOb = null;
        this.jOg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jNY.refresh(i);
                switch (i) {
                    case 0:
                        com.baidu.tbadk.core.i.axf().setShowImages(true);
                        com.baidu.tbadk.core.i.axf().setViewImageQuality(0);
                        break;
                    case 1:
                        com.baidu.tbadk.core.i.axf().setShowImages(true);
                        com.baidu.tbadk.core.i.axf().setViewImageQuality(1);
                        TiebaStatic.log(new an("c10415").Z("obj_type", 1));
                        break;
                    case 2:
                        com.baidu.tbadk.core.i.axf().setShowImages(true);
                        com.baidu.tbadk.core.i.axf().setViewImageQuality(2);
                        TiebaStatic.log(new an("c10415").Z("obj_type", 3));
                        break;
                    case 3:
                        com.baidu.tbadk.core.i.axf().setShowImages(false);
                        break;
                }
                c.this.jNY.dismiss();
                c.this.cCX();
            }
        };
        this.jOh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.jNZ.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.jNS.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                com.baidu.tbadk.core.i.axf().setImageWaterType(i2);
                c.this.Bs(i2);
            }
        };
        this.jOi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jOa.refresh(i);
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
                c.this.cCZ();
            }
        };
        this.jOj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.jOb.refresh(i);
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
                c.this.cDa();
            }
        };
        this.jNS = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.jNS.getLayoutMode().setNightMode(i == 1);
        this.jNS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jNX.onChangeSkinType(this.jNS.getPageContext(), i);
        if (this.jNY != null) {
            this.jNY.onChangeSkinType();
        }
        if (this.jNZ != null) {
            this.jNZ.onChangeSkinType();
        }
        if (this.jOa != null) {
            this.jOa.onChangeSkinType();
        }
        if (this.jOb != null) {
            this.jOb.onChangeSkinType();
        }
    }

    public TbSettingTextTipView cCL() {
        return this.jNU;
    }

    public TbSettingTextTipView cCM() {
        return this.jNT;
    }

    public TbSettingTextTipView cCN() {
        return this.jNV;
    }

    public TbSettingTextTipView cCO() {
        return this.jNW;
    }

    public void cCP() {
        cCU();
        this.jNZ.aBZ();
    }

    public void cCQ() {
        cCT();
        this.jNY.aBZ();
    }

    public void cCR() {
        cCV();
        this.jOa.aBZ();
    }

    public void cCS() {
        cCW();
        this.jOb.aBZ();
    }

    private void initUI() {
        this.jNS.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.jNS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.jNS.getPageContext().getString(R.string.browse_setting));
        this.jNT = (TbSettingTextTipView) this.jNS.findViewById(R.id.img_browser);
        this.jNT.setBottomLineVisibility(true);
        this.jNU = (TbSettingTextTipView) this.jNS.findViewById(R.id.add_img_water);
        this.jNU.setBottomLineVisibility(true);
        this.jNV = (TbSettingTextTipView) this.jNS.findViewById(R.id.font_size);
        this.jNV.setBottomLineVisibility(true);
        this.jNW = (TbSettingTextTipView) this.jNS.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.jNW.setText(R.string.video_gif_auto_play);
        } else {
            this.jNW.setText(R.string.video_auto_play);
        }
        this.jNW.setBottomLineVisibility(true);
        this.jNX = (MsgSettingItemView) this.jNS.findViewById(R.id.slide_anim_switch);
        this.jNX.setText(R.string.slide_anim_switch);
        this.jNX.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.jNX.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aCY().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").Z("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").Z("obj_type", 2));
            }
        });
        this.mParent = this.jNS.findViewById(R.id.parent);
    }

    private void initListener() {
        this.jNT.setOnClickListener(this.jNS);
        this.jNU.setOnClickListener(this.jNS);
        this.jNV.setOnClickListener(this.jNS);
        this.jNW.setOnClickListener(this.jNS);
    }

    private void cCT() {
        this.jOd = new ArrayList<>();
        int viewImageQuality = com.baidu.tbadk.core.i.axf().getViewImageQuality();
        boolean isShowImages = com.baidu.tbadk.core.i.axf().isShowImages();
        this.jOd.add(new m(this.jNS.getPageContext().getString(R.string.view_image_quality_auto_menu), this.jNS.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.jOd.add(new m(this.jNS.getPageContext().getString(R.string.view_high), this.jNS.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.jOd.add(new m(this.jNS.getPageContext().getString(R.string.view_low), this.jNS.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.jOd.add(new m(this.jNS.getPageContext().getString(R.string.close), this.jNS.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.jNY = new com.baidu.tbadk.core.dialog.e(this.jNS.getPageContext());
        this.jNY.jM(R.string.browser_image_quality);
        this.jNY.a(this.jOd, this.jOg).aBY();
    }

    private void cCU() {
        this.jOe = new ArrayList<>();
        int imageWaterType = com.baidu.tbadk.core.i.axf().getImageWaterType();
        this.jOe.add(new m(this.jNS.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.jOe.add(new m(this.jNS.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.jOe.add(new m(this.jNS.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.jNZ = new com.baidu.tbadk.core.dialog.e(this.jNS.getPageContext()).jM(R.string.add_image_water);
        this.jNZ.a(this.jOe, this.jOh).aBY();
    }

    private void cCV() {
        this.jOa = new com.baidu.tbadk.core.dialog.e(this.jNS.getPageContext());
        this.jOc = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.jOc.add(new m(this.jNS.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.jOc.add(new m(this.jNS.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.jOc.add(new m(this.jNS.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.jOc.add(new m(this.jNS.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.jOa.jM(R.string.font_size);
        this.jOa.a(this.jOc, this.jOi);
        this.jOa.aBY();
    }

    private void cCW() {
        this.jOb = new com.baidu.tbadk.core.dialog.e(this.jNS.getPageContext());
        this.jOf = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.jOf.add(new m(this.jNS.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.jOf.add(new m(this.jNS.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.jOf.add(new m(this.jNS.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.jOb.jM(R.string.video_gif_auto_play);
        } else {
            this.jOb.jM(R.string.video_auto_play);
        }
        this.jOb.a(this.jOf, this.jOj);
        this.jOb.aBY();
    }

    public void updateAll() {
        cCX();
        cCY();
        cCZ();
        cDa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCX() {
        if (!com.baidu.tbadk.core.i.axf().isShowImages()) {
            this.jNT.setTip(this.mContext.getString(R.string.close));
        } else if (com.baidu.tbadk.core.i.axf().getViewImageQuality() == 1) {
            this.jNT.setTip(this.mContext.getString(R.string.view_high));
        } else if (com.baidu.tbadk.core.i.axf().getViewImageQuality() == 2) {
            this.jNT.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.jNT.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cCY() {
        Bs(com.baidu.tbadk.core.i.axf().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bs(int i) {
        switch (i) {
            case 0:
                this.jNU.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.jNU.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.jNU.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cCZ() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.jNV.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.jNV.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.jNV.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.jNV.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cDa() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.jNW.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.jNW.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.jNW.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
