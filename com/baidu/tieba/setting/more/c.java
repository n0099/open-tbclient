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
    private BrowseSettingActivity lxY;
    private TbSettingTextTipView lxZ;
    private TbSettingTextTipView lya;
    private TbSettingTextTipView lyb;
    private TbSettingTextTipView lyc;
    private MsgSettingItemView lyd;
    private com.baidu.tbadk.core.dialog.e lye;
    private com.baidu.tbadk.core.dialog.e lyf;
    private com.baidu.tbadk.core.dialog.e lyg;
    private com.baidu.tbadk.core.dialog.e lyh;
    private ArrayList<m> lyi;
    private ArrayList<m> lyj;
    private ArrayList<m> lyk;
    private ArrayList<m> lyl;
    private final AdapterView.OnItemClickListener lym;
    private final AdapterView.OnItemClickListener lyn;
    private final AdapterView.OnItemClickListener lyp;
    private final AdapterView.OnItemClickListener lyq;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.lxY = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.lxZ = null;
        this.lya = null;
        this.lyb = null;
        this.lyc = null;
        this.lye = null;
        this.lyf = null;
        this.lyg = null;
        this.lyh = null;
        this.lym = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lye.refresh(i);
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
                c.this.lye.dismiss();
                c.this.dfn();
            }
        };
        this.lyn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.lyf.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.lxY.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.aTv().setImageWaterType(i2);
                c.this.Ey(i2);
            }
        };
        this.lyp = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lyg.refresh(i);
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
        this.lyq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lyh.refresh(i);
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
        this.lxY = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lxY.getLayoutMode().setNightMode(i == 1);
        this.lxY.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lyd.onChangeSkinType(this.lxY.getPageContext(), i);
        if (this.lye != null) {
            this.lye.onChangeSkinType();
        }
        if (this.lyf != null) {
            this.lyf.onChangeSkinType();
        }
        if (this.lyg != null) {
            this.lyg.onChangeSkinType();
        }
        if (this.lyh != null) {
            this.lyh.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dfb() {
        return this.lya;
    }

    public TbSettingTextTipView dfc() {
        return this.lxZ;
    }

    public TbSettingTextTipView dfd() {
        return this.lyb;
    }

    public TbSettingTextTipView dfe() {
        return this.lyc;
    }

    public void dff() {
        dfk();
        this.lyf.aYP();
    }

    public void dfg() {
        dfj();
        this.lye.aYP();
    }

    public void dfh() {
        dfl();
        this.lyg.aYP();
    }

    public void dfi() {
        dfm();
        this.lyh.aYP();
    }

    private void initUI() {
        this.lxY.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lxY.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lxY.getPageContext().getString(R.string.browse_setting));
        this.lxZ = (TbSettingTextTipView) this.lxY.findViewById(R.id.img_browser);
        this.lxZ.setBottomLineVisibility(true);
        this.lya = (TbSettingTextTipView) this.lxY.findViewById(R.id.add_img_water);
        this.lya.setBottomLineVisibility(true);
        this.lyb = (TbSettingTextTipView) this.lxY.findViewById(R.id.font_size);
        this.lyb.setBottomLineVisibility(true);
        this.lyc = (TbSettingTextTipView) this.lxY.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.lyc.setText(R.string.video_gif_auto_play);
        } else {
            this.lyc.setText(R.string.video_auto_play);
        }
        this.lyc.setBottomLineVisibility(true);
        this.lyd = (MsgSettingItemView) this.lxY.findViewById(R.id.slide_anim_switch);
        this.lyd.setText(R.string.slide_anim_switch);
        this.lyd.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.lyd.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.lxY.findViewById(R.id.parent);
    }

    private void initListener() {
        this.lxZ.setOnClickListener(this.lxY);
        this.lya.setOnClickListener(this.lxY);
        this.lyb.setOnClickListener(this.lxY);
        this.lyc.setOnClickListener(this.lxY);
    }

    private void dfj() {
        this.lyj = new ArrayList<>();
        int viewImageQuality = k.aTv().getViewImageQuality();
        boolean isShowImages = k.aTv().isShowImages();
        this.lyj.add(new m(this.lxY.getPageContext().getString(R.string.view_image_quality_auto_menu), this.lxY.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.lyj.add(new m(this.lxY.getPageContext().getString(R.string.view_high), this.lxY.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.lyj.add(new m(this.lxY.getPageContext().getString(R.string.view_low), this.lxY.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.lyj.add(new m(this.lxY.getPageContext().getString(R.string.close), this.lxY.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.lye = new com.baidu.tbadk.core.dialog.e(this.lxY.getPageContext());
        this.lye.lu(R.string.browser_image_quality);
        this.lye.a(this.lyj, this.lym).aYO();
    }

    private void dfk() {
        this.lyk = new ArrayList<>();
        int imageWaterType = k.aTv().getImageWaterType();
        this.lyk.add(new m(this.lxY.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.lyk.add(new m(this.lxY.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.lyk.add(new m(this.lxY.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.lyf = new com.baidu.tbadk.core.dialog.e(this.lxY.getPageContext()).lu(R.string.add_image_water);
        this.lyf.a(this.lyk, this.lyn).aYO();
    }

    private void dfl() {
        this.lyg = new com.baidu.tbadk.core.dialog.e(this.lxY.getPageContext());
        this.lyi = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.lyi.add(new m(this.lxY.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.lyi.add(new m(this.lxY.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.lyi.add(new m(this.lxY.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.lyi.add(new m(this.lxY.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.lyg.lu(R.string.font_size);
        this.lyg.a(this.lyi, this.lyp);
        this.lyg.aYO();
    }

    private void dfm() {
        this.lyh = new com.baidu.tbadk.core.dialog.e(this.lxY.getPageContext());
        this.lyl = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.lyl.add(new m(this.lxY.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.lyl.add(new m(this.lxY.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.lyl.add(new m(this.lxY.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.lyh.lu(R.string.video_gif_auto_play);
        } else {
            this.lyh.lu(R.string.video_auto_play);
        }
        this.lyh.a(this.lyl, this.lyq);
        this.lyh.aYO();
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
            this.lxZ.setTip(this.mContext.getString(R.string.close));
        } else if (k.aTv().getViewImageQuality() == 1) {
            this.lxZ.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.aTv().getViewImageQuality() == 2) {
            this.lxZ.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.lxZ.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dfo() {
        Ey(k.aTv().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey(int i) {
        switch (i) {
            case 0:
                this.lya.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.lya.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.lya.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dfp() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.lyb.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.lyb.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.lyb.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.lyb.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dfq() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.lyc.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.lyc.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.lyc.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
