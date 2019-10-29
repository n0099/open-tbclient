package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.t.bd;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private ArrayList<m> iUA;
    private final AdapterView.OnItemClickListener iUB;
    private final AdapterView.OnItemClickListener iUC;
    private final AdapterView.OnItemClickListener iUD;
    private final AdapterView.OnItemClickListener iUE;
    private BrowseSettingActivity iUn;
    private TbSettingTextTipView iUo;
    private TbSettingTextTipView iUp;
    private TbSettingTextTipView iUq;
    private TbSettingTextTipView iUr;
    private MsgSettingItemView iUs;
    private com.baidu.tbadk.core.dialog.e iUt;
    private com.baidu.tbadk.core.dialog.e iUu;
    private com.baidu.tbadk.core.dialog.e iUv;
    private com.baidu.tbadk.core.dialog.e iUw;
    private ArrayList<m> iUx;
    private ArrayList<m> iUy;
    private ArrayList<m> iUz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iUn = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iUo = null;
        this.iUp = null;
        this.iUq = null;
        this.iUr = null;
        this.iUt = null;
        this.iUu = null;
        this.iUv = null;
        this.iUw = null;
        this.iUB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iUt.refresh(i);
                switch (i) {
                    case 0:
                        i.agq().setShowImages(true);
                        i.agq().setViewImageQuality(0);
                        break;
                    case 1:
                        i.agq().setShowImages(true);
                        i.agq().setViewImageQuality(1);
                        TiebaStatic.log(new an("c10415").O("obj_type", 1));
                        break;
                    case 2:
                        i.agq().setShowImages(true);
                        i.agq().setViewImageQuality(2);
                        TiebaStatic.log(new an("c10415").O("obj_type", 3));
                        break;
                    case 3:
                        i.agq().setShowImages(false);
                        break;
                }
                c.this.iUt.dismiss();
                c.this.ciV();
            }
        };
        this.iUC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iUu.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").O("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").O("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").O("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.agq().setImageWaterType(i2);
                c.this.yY(i2);
            }
        };
        this.iUD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iUv.refresh(i);
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
                c.this.ciX();
            }
        };
        this.iUE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iUw.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").O("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").O("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").O("obj_type", 3));
                        break;
                }
                c.this.ciY();
            }
        };
        this.iUn = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iUn.getLayoutMode().setNightMode(i == 1);
        this.iUn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iUs.onChangeSkinType(this.iUn.getPageContext(), i);
        if (this.iUt != null) {
            this.iUt.onChangeSkinType();
        }
        if (this.iUu != null) {
            this.iUu.onChangeSkinType();
        }
        if (this.iUv != null) {
            this.iUv.onChangeSkinType();
        }
        if (this.iUw != null) {
            this.iUw.onChangeSkinType();
        }
    }

    public TbSettingTextTipView ciJ() {
        return this.iUp;
    }

    public TbSettingTextTipView ciK() {
        return this.iUo;
    }

    public TbSettingTextTipView ciL() {
        return this.iUq;
    }

    public TbSettingTextTipView ciM() {
        return this.iUr;
    }

    public void ciN() {
        ciS();
        this.iUu.akR();
    }

    public void ciO() {
        ciR();
        this.iUt.akR();
    }

    public void ciP() {
        ciT();
        this.iUv.akR();
    }

    public void ciQ() {
        ciU();
        this.iUw.akR();
    }

    private void initUI() {
        this.iUn.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iUn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iUn.getPageContext().getString(R.string.browse_setting));
        this.iUo = (TbSettingTextTipView) this.iUn.findViewById(R.id.img_browser);
        this.iUo.setBottomLineVisibility(true);
        this.iUp = (TbSettingTextTipView) this.iUn.findViewById(R.id.add_img_water);
        this.iUp.setBottomLineVisibility(true);
        this.iUq = (TbSettingTextTipView) this.iUn.findViewById(R.id.font_size);
        this.iUq.setBottomLineVisibility(true);
        this.iUr = (TbSettingTextTipView) this.iUn.findViewById(R.id.video_auto_play);
        if (bd.isOn()) {
            this.iUr.setText(R.string.video_gif_auto_play);
        } else {
            this.iUr.setText(R.string.video_auto_play);
        }
        this.iUr.setBottomLineVisibility(true);
        this.iUs = (MsgSettingItemView) this.iUn.findViewById(R.id.slide_anim_switch);
        this.iUs.setText(R.string.slide_anim_switch);
        this.iUs.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iUs.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.alR().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").O("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").O("obj_type", 2));
            }
        });
        this.mParent = this.iUn.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iUo.setOnClickListener(this.iUn);
        this.iUp.setOnClickListener(this.iUn);
        this.iUq.setOnClickListener(this.iUn);
        this.iUr.setOnClickListener(this.iUn);
    }

    private void ciR() {
        this.iUy = new ArrayList<>();
        int viewImageQuality = i.agq().getViewImageQuality();
        boolean isShowImages = i.agq().isShowImages();
        this.iUy.add(new m(this.iUn.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iUn.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.iUy.add(new m(this.iUn.getPageContext().getString(R.string.view_high), this.iUn.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.iUy.add(new m(this.iUn.getPageContext().getString(R.string.view_low), this.iUn.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.iUy.add(new m(this.iUn.getPageContext().getString(R.string.close), this.iUn.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.iUt = new com.baidu.tbadk.core.dialog.e(this.iUn.getPageContext());
        this.iUt.ib(R.string.browser_image_quality);
        this.iUt.a(this.iUy, this.iUB).akQ();
    }

    private void ciS() {
        this.iUz = new ArrayList<>();
        int imageWaterType = i.agq().getImageWaterType();
        this.iUz.add(new m(this.iUn.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.iUz.add(new m(this.iUn.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.iUz.add(new m(this.iUn.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.iUu = new com.baidu.tbadk.core.dialog.e(this.iUn.getPageContext()).ib(R.string.add_image_water);
        this.iUu.a(this.iUz, this.iUC).akQ();
    }

    private void ciT() {
        this.iUv = new com.baidu.tbadk.core.dialog.e(this.iUn.getPageContext());
        this.iUx = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iUx.add(new m(this.iUn.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iUx.add(new m(this.iUn.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iUx.add(new m(this.iUn.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iUx.add(new m(this.iUn.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iUv.ib(R.string.font_size);
        this.iUv.a(this.iUx, this.iUD);
        this.iUv.akQ();
    }

    private void ciU() {
        this.iUw = new com.baidu.tbadk.core.dialog.e(this.iUn.getPageContext());
        this.iUA = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iUA.add(new m(this.iUn.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iUA.add(new m(this.iUn.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iUA.add(new m(this.iUn.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.isOn()) {
            this.iUw.ib(R.string.video_gif_auto_play);
        } else {
            this.iUw.ib(R.string.video_auto_play);
        }
        this.iUw.a(this.iUA, this.iUE);
        this.iUw.akQ();
    }

    public void updateAll() {
        ciV();
        ciW();
        ciX();
        ciY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciV() {
        if (!i.agq().isShowImages()) {
            this.iUo.setTip(this.mContext.getString(R.string.close));
        } else if (i.agq().getViewImageQuality() == 1) {
            this.iUo.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.agq().getViewImageQuality() == 2) {
            this.iUo.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iUo.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void ciW() {
        yY(i.agq().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY(int i) {
        switch (i) {
            case 0:
                this.iUp.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iUp.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iUp.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void ciX() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iUq.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iUq.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iUq.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iUq.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void ciY() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iUr.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iUr.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iUr.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
