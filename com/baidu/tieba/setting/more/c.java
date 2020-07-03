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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity lqF;
    private TbSettingTextTipView lqG;
    private TbSettingTextTipView lqH;
    private TbSettingTextTipView lqI;
    private TbSettingTextTipView lqJ;
    private MsgSettingItemView lqK;
    private com.baidu.tbadk.core.dialog.e lqL;
    private com.baidu.tbadk.core.dialog.e lqM;
    private com.baidu.tbadk.core.dialog.e lqN;
    private com.baidu.tbadk.core.dialog.e lqO;
    private ArrayList<m> lqP;
    private ArrayList<m> lqQ;
    private ArrayList<m> lqR;
    private ArrayList<m> lqS;
    private final AdapterView.OnItemClickListener lqT;
    private final AdapterView.OnItemClickListener lqU;
    private final AdapterView.OnItemClickListener lqV;
    private final AdapterView.OnItemClickListener lqW;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.lqF = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.lqG = null;
        this.lqH = null;
        this.lqI = null;
        this.lqJ = null;
        this.lqL = null;
        this.lqM = null;
        this.lqN = null;
        this.lqO = null;
        this.lqT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lqL.refresh(i);
                switch (i) {
                    case 0:
                        k.aPA().setShowImages(true);
                        k.aPA().kl(0);
                        break;
                    case 1:
                        k.aPA().setShowImages(true);
                        k.aPA().kl(1);
                        TiebaStatic.log(new ao("c10415").ag("obj_type", 1));
                        break;
                    case 2:
                        k.aPA().setShowImages(true);
                        k.aPA().kl(2);
                        TiebaStatic.log(new ao("c10415").ag("obj_type", 3));
                        break;
                    case 3:
                        k.aPA().setShowImages(false);
                        break;
                }
                c.this.lqL.dismiss();
                c.this.dcf();
            }
        };
        this.lqU = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.lqM.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ao("c10411").ag("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ao("c10411").ag("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ao("c10411").ag("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.lqF.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.aPA().setImageWaterType(i2);
                c.this.Ec(i2);
            }
        };
        this.lqV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lqN.refresh(i);
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
                c.this.dch();
            }
        };
        this.lqW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lqO.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new ao("c11281").ag("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new ao("c11281").ag("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new ao("c11281").ag("obj_type", 3));
                        break;
                }
                c.this.dci();
            }
        };
        this.lqF = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lqF.getLayoutMode().setNightMode(i == 1);
        this.lqF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lqK.onChangeSkinType(this.lqF.getPageContext(), i);
        if (this.lqL != null) {
            this.lqL.onChangeSkinType();
        }
        if (this.lqM != null) {
            this.lqM.onChangeSkinType();
        }
        if (this.lqN != null) {
            this.lqN.onChangeSkinType();
        }
        if (this.lqO != null) {
            this.lqO.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dbT() {
        return this.lqH;
    }

    public TbSettingTextTipView dbU() {
        return this.lqG;
    }

    public TbSettingTextTipView dbV() {
        return this.lqI;
    }

    public TbSettingTextTipView dbW() {
        return this.lqJ;
    }

    public void dbX() {
        dcc();
        this.lqM.aUQ();
    }

    public void dbY() {
        dcb();
        this.lqL.aUQ();
    }

    public void dbZ() {
        dcd();
        this.lqN.aUQ();
    }

    public void dca() {
        dce();
        this.lqO.aUQ();
    }

    private void initUI() {
        this.lqF.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lqF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lqF.getPageContext().getString(R.string.browse_setting));
        this.lqG = (TbSettingTextTipView) this.lqF.findViewById(R.id.img_browser);
        this.lqG.setBottomLineVisibility(true);
        this.lqH = (TbSettingTextTipView) this.lqF.findViewById(R.id.add_img_water);
        this.lqH.setBottomLineVisibility(true);
        this.lqI = (TbSettingTextTipView) this.lqF.findViewById(R.id.font_size);
        this.lqI.setBottomLineVisibility(true);
        this.lqJ = (TbSettingTextTipView) this.lqF.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.lqJ.setText(R.string.video_gif_auto_play);
        } else {
            this.lqJ.setText(R.string.video_auto_play);
        }
        this.lqJ.setBottomLineVisibility(true);
        this.lqK = (MsgSettingItemView) this.lqF.findViewById(R.id.slide_anim_switch);
        this.lqK.setText(R.string.slide_anim_switch);
        this.lqK.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.lqK.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new ao("c13396").ag("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new ao("c13396").ag("obj_type", 2));
            }
        });
        this.mParent = this.lqF.findViewById(R.id.parent);
    }

    private void initListener() {
        this.lqG.setOnClickListener(this.lqF);
        this.lqH.setOnClickListener(this.lqF);
        this.lqI.setOnClickListener(this.lqF);
        this.lqJ.setOnClickListener(this.lqF);
    }

    private void dcb() {
        this.lqQ = new ArrayList<>();
        int viewImageQuality = k.aPA().getViewImageQuality();
        boolean isShowImages = k.aPA().isShowImages();
        this.lqQ.add(new m(this.lqF.getPageContext().getString(R.string.view_image_quality_auto_menu), this.lqF.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.lqQ.add(new m(this.lqF.getPageContext().getString(R.string.view_high), this.lqF.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.lqQ.add(new m(this.lqF.getPageContext().getString(R.string.view_low), this.lqF.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.lqQ.add(new m(this.lqF.getPageContext().getString(R.string.close), this.lqF.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.lqL = new com.baidu.tbadk.core.dialog.e(this.lqF.getPageContext());
        this.lqL.la(R.string.browser_image_quality);
        this.lqL.a(this.lqQ, this.lqT).aUP();
    }

    private void dcc() {
        this.lqR = new ArrayList<>();
        int imageWaterType = k.aPA().getImageWaterType();
        this.lqR.add(new m(this.lqF.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.lqR.add(new m(this.lqF.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.lqR.add(new m(this.lqF.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.lqM = new com.baidu.tbadk.core.dialog.e(this.lqF.getPageContext()).la(R.string.add_image_water);
        this.lqM.a(this.lqR, this.lqU).aUP();
    }

    private void dcd() {
        this.lqN = new com.baidu.tbadk.core.dialog.e(this.lqF.getPageContext());
        this.lqP = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.lqP.add(new m(this.lqF.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.lqP.add(new m(this.lqF.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.lqP.add(new m(this.lqF.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.lqP.add(new m(this.lqF.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.lqN.la(R.string.font_size);
        this.lqN.a(this.lqP, this.lqV);
        this.lqN.aUP();
    }

    private void dce() {
        this.lqO = new com.baidu.tbadk.core.dialog.e(this.lqF.getPageContext());
        this.lqS = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.lqS.add(new m(this.lqF.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.lqS.add(new m(this.lqF.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.lqS.add(new m(this.lqF.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.lqO.la(R.string.video_gif_auto_play);
        } else {
            this.lqO.la(R.string.video_auto_play);
        }
        this.lqO.a(this.lqS, this.lqW);
        this.lqO.aUP();
    }

    public void updateAll() {
        dcf();
        dcg();
        dch();
        dci();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcf() {
        if (!k.aPA().isShowImages()) {
            this.lqG.setTip(this.mContext.getString(R.string.close));
        } else if (k.aPA().getViewImageQuality() == 1) {
            this.lqG.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.aPA().getViewImageQuality() == 2) {
            this.lqG.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.lqG.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dcg() {
        Ec(k.aPA().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ec(int i) {
        switch (i) {
            case 0:
                this.lqH.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.lqH.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.lqH.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dch() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.lqI.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.lqI.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.lqI.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.lqI.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dci() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.lqJ.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.lqJ.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.lqJ.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
