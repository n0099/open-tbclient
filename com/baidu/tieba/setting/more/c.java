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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity lxW;
    private TbSettingTextTipView lxX;
    private TbSettingTextTipView lxY;
    private TbSettingTextTipView lxZ;
    private TbSettingTextTipView lya;
    private MsgSettingItemView lyb;
    private com.baidu.tbadk.core.dialog.e lyc;
    private com.baidu.tbadk.core.dialog.e lyd;
    private com.baidu.tbadk.core.dialog.e lye;
    private com.baidu.tbadk.core.dialog.e lyf;
    private ArrayList<m> lyg;
    private ArrayList<m> lyh;
    private ArrayList<m> lyi;
    private ArrayList<m> lyj;
    private final AdapterView.OnItemClickListener lyk;
    private final AdapterView.OnItemClickListener lyl;
    private final AdapterView.OnItemClickListener lym;
    private final AdapterView.OnItemClickListener lyn;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.lxW = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.lxX = null;
        this.lxY = null;
        this.lxZ = null;
        this.lya = null;
        this.lyc = null;
        this.lyd = null;
        this.lye = null;
        this.lyf = null;
        this.lyk = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lyc.refresh(i);
                switch (i) {
                    case 0:
                        k.aTv().setShowImages(true);
                        k.aTv().kE(0);
                        break;
                    case 1:
                        k.aTv().setShowImages(true);
                        k.aTv().kE(1);
                        TiebaStatic.log(new ap("c10415").ah("obj_type", 1));
                        break;
                    case 2:
                        k.aTv().setShowImages(true);
                        k.aTv().kE(2);
                        TiebaStatic.log(new ap("c10415").ah("obj_type", 3));
                        break;
                    case 3:
                        k.aTv().setShowImages(false);
                        break;
                }
                c.this.lyc.dismiss();
                c.this.dfn();
            }
        };
        this.lyl = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.lyd.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ap("c10411").ah("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ap("c10411").ah("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ap("c10411").ah("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.lxW.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.aTv().setImageWaterType(i2);
                c.this.Ey(i2);
            }
        };
        this.lym = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lye.refresh(i);
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
                c.this.dfp();
            }
        };
        this.lyn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lyf.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new ap("c11281").ah("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new ap("c11281").ah("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new ap("c11281").ah("obj_type", 3));
                        break;
                }
                c.this.dfq();
            }
        };
        this.lxW = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lxW.getLayoutMode().setNightMode(i == 1);
        this.lxW.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lyb.onChangeSkinType(this.lxW.getPageContext(), i);
        if (this.lyc != null) {
            this.lyc.onChangeSkinType();
        }
        if (this.lyd != null) {
            this.lyd.onChangeSkinType();
        }
        if (this.lye != null) {
            this.lye.onChangeSkinType();
        }
        if (this.lyf != null) {
            this.lyf.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dfb() {
        return this.lxY;
    }

    public TbSettingTextTipView dfc() {
        return this.lxX;
    }

    public TbSettingTextTipView dfd() {
        return this.lxZ;
    }

    public TbSettingTextTipView dfe() {
        return this.lya;
    }

    public void dff() {
        dfk();
        this.lyd.aYP();
    }

    public void dfg() {
        dfj();
        this.lyc.aYP();
    }

    public void dfh() {
        dfl();
        this.lye.aYP();
    }

    public void dfi() {
        dfm();
        this.lyf.aYP();
    }

    private void initUI() {
        this.lxW.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lxW.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lxW.getPageContext().getString(R.string.browse_setting));
        this.lxX = (TbSettingTextTipView) this.lxW.findViewById(R.id.img_browser);
        this.lxX.setBottomLineVisibility(true);
        this.lxY = (TbSettingTextTipView) this.lxW.findViewById(R.id.add_img_water);
        this.lxY.setBottomLineVisibility(true);
        this.lxZ = (TbSettingTextTipView) this.lxW.findViewById(R.id.font_size);
        this.lxZ.setBottomLineVisibility(true);
        this.lya = (TbSettingTextTipView) this.lxW.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.lya.setText(R.string.video_gif_auto_play);
        } else {
            this.lya.setText(R.string.video_auto_play);
        }
        this.lya.setBottomLineVisibility(true);
        this.lyb = (MsgSettingItemView) this.lxW.findViewById(R.id.slide_anim_switch);
        this.lyb.setText(R.string.slide_anim_switch);
        this.lyb.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.lyb.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new ap("c13396").ah("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new ap("c13396").ah("obj_type", 2));
            }
        });
        this.mParent = this.lxW.findViewById(R.id.parent);
    }

    private void initListener() {
        this.lxX.setOnClickListener(this.lxW);
        this.lxY.setOnClickListener(this.lxW);
        this.lxZ.setOnClickListener(this.lxW);
        this.lya.setOnClickListener(this.lxW);
    }

    private void dfj() {
        this.lyh = new ArrayList<>();
        int viewImageQuality = k.aTv().getViewImageQuality();
        boolean isShowImages = k.aTv().isShowImages();
        this.lyh.add(new m(this.lxW.getPageContext().getString(R.string.view_image_quality_auto_menu), this.lxW.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.lyh.add(new m(this.lxW.getPageContext().getString(R.string.view_high), this.lxW.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.lyh.add(new m(this.lxW.getPageContext().getString(R.string.view_low), this.lxW.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.lyh.add(new m(this.lxW.getPageContext().getString(R.string.close), this.lxW.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.lyc = new com.baidu.tbadk.core.dialog.e(this.lxW.getPageContext());
        this.lyc.lu(R.string.browser_image_quality);
        this.lyc.a(this.lyh, this.lyk).aYO();
    }

    private void dfk() {
        this.lyi = new ArrayList<>();
        int imageWaterType = k.aTv().getImageWaterType();
        this.lyi.add(new m(this.lxW.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.lyi.add(new m(this.lxW.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.lyi.add(new m(this.lxW.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.lyd = new com.baidu.tbadk.core.dialog.e(this.lxW.getPageContext()).lu(R.string.add_image_water);
        this.lyd.a(this.lyi, this.lyl).aYO();
    }

    private void dfl() {
        this.lye = new com.baidu.tbadk.core.dialog.e(this.lxW.getPageContext());
        this.lyg = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.lyg.add(new m(this.lxW.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.lyg.add(new m(this.lxW.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.lyg.add(new m(this.lxW.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.lyg.add(new m(this.lxW.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.lye.lu(R.string.font_size);
        this.lye.a(this.lyg, this.lym);
        this.lye.aYO();
    }

    private void dfm() {
        this.lyf = new com.baidu.tbadk.core.dialog.e(this.lxW.getPageContext());
        this.lyj = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.lyj.add(new m(this.lxW.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.lyj.add(new m(this.lxW.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.lyj.add(new m(this.lxW.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.lyf.lu(R.string.video_gif_auto_play);
        } else {
            this.lyf.lu(R.string.video_auto_play);
        }
        this.lyf.a(this.lyj, this.lyn);
        this.lyf.aYO();
    }

    public void updateAll() {
        dfn();
        dfo();
        dfp();
        dfq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfn() {
        if (!k.aTv().isShowImages()) {
            this.lxX.setTip(this.mContext.getString(R.string.close));
        } else if (k.aTv().getViewImageQuality() == 1) {
            this.lxX.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.aTv().getViewImageQuality() == 2) {
            this.lxX.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.lxX.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dfo() {
        Ey(k.aTv().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey(int i) {
        switch (i) {
            case 0:
                this.lxY.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.lxY.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.lxY.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dfp() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.lxZ.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.lxZ.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.lxZ.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.lxZ.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dfq() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.lya.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.lya.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.lya.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
