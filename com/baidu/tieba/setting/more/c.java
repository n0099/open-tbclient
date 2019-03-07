package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.s.ax;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private final AdapterView.OnItemClickListener isA;
    private final AdapterView.OnItemClickListener isB;
    private final AdapterView.OnItemClickListener isC;
    private final AdapterView.OnItemClickListener isD;
    private BrowseSettingActivity ism;
    private TbSettingTextTipView isn;
    private TbSettingTextTipView iso;
    private TbSettingTextTipView isp;
    private TbSettingTextTipView isq;
    private MsgSettingItemView isr;
    private com.baidu.tbadk.core.dialog.e iss;
    private com.baidu.tbadk.core.dialog.e ist;
    private com.baidu.tbadk.core.dialog.e isu;
    private com.baidu.tbadk.core.dialog.e isv;
    private ArrayList<k> isw;
    private ArrayList<k> isx;
    private ArrayList<k> isy;
    private ArrayList<k> isz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ism = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.isn = null;
        this.iso = null;
        this.isp = null;
        this.isq = null;
        this.iss = null;
        this.ist = null;
        this.isu = null;
        this.isv = null;
        this.isA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iss.refresh(i);
                switch (i) {
                    case 0:
                        i.Wy().dg(true);
                        i.Wy().ga(0);
                        break;
                    case 1:
                        i.Wy().dg(true);
                        i.Wy().ga(1);
                        TiebaStatic.log(new am("c10415").T("obj_type", 1));
                        break;
                    case 2:
                        i.Wy().dg(true);
                        i.Wy().ga(2);
                        TiebaStatic.log(new am("c10415").T("obj_type", 3));
                        break;
                    case 3:
                        i.Wy().dg(false);
                        break;
                }
                c.this.iss.dismiss();
                c.this.bZi();
            }
        };
        this.isB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.ist.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").T("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").T("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").T("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.Wy().fZ(i2);
                c.this.yC(i2);
            }
        };
        this.isC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.isu.refresh(i);
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
                c.this.bZk();
            }
        };
        this.isD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.isv.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").T("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").T("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").T("obj_type", 3));
                        break;
                }
                c.this.bZl();
            }
        };
        this.ism = browseSettingActivity;
        initUI();
        adq();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ism.getLayoutMode().setNightMode(i == 1);
        this.ism.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isr.onChangeSkinType(this.ism.getPageContext(), i);
    }

    public TbSettingTextTipView bYW() {
        return this.iso;
    }

    public TbSettingTextTipView bYX() {
        return this.isn;
    }

    public TbSettingTextTipView bYY() {
        return this.isp;
    }

    public TbSettingTextTipView bYZ() {
        return this.isq;
    }

    public void bZa() {
        bZf();
        this.ist.abe();
    }

    public void bZb() {
        bZe();
        this.iss.abe();
    }

    public void bZc() {
        bZg();
        this.isu.abe();
    }

    public void bZd() {
        bZh();
        this.isv.abe();
    }

    private void initUI() {
        this.ism.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ism.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ism.getPageContext().getString(d.j.browse_setting));
        this.isn = (TbSettingTextTipView) this.ism.findViewById(d.g.img_browser);
        this.isn.setBottomLineVisibility(true);
        this.iso = (TbSettingTextTipView) this.ism.findViewById(d.g.add_img_water);
        this.iso.setBottomLineVisibility(true);
        this.isp = (TbSettingTextTipView) this.ism.findViewById(d.g.font_size);
        this.isp.setBottomLineVisibility(true);
        this.isq = (TbSettingTextTipView) this.ism.findViewById(d.g.video_auto_play);
        if (ax.jK()) {
            this.isq.setText(d.j.video_gif_auto_play);
        } else {
            this.isq.setText(d.j.video_auto_play);
        }
        this.isq.setBottomLineVisibility(true);
        this.isr = (MsgSettingItemView) this.ism.findViewById(d.g.slide_anim_switch);
        this.isr.setText(d.j.slide_anim_switch);
        this.isr.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.isr.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new am("c13396").T("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new am("c13396").T("obj_type", 2));
            }
        });
        this.mParent = this.ism.findViewById(d.g.parent);
    }

    private void initListener() {
        this.isn.setOnClickListener(this.ism);
        this.iso.setOnClickListener(this.ism);
        this.isp.setOnClickListener(this.ism);
        this.isq.setOnClickListener(this.ism);
    }

    private void bZe() {
        this.isx = new ArrayList<>();
        int viewImageQuality = i.Wy().getViewImageQuality();
        boolean WC = i.Wy().WC();
        this.isx.add(new k(this.ism.getPageContext().getString(d.j.view_image_quality_auto_menu), this.ism.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), WC && viewImageQuality == 0));
        this.isx.add(new k(this.ism.getPageContext().getString(d.j.view_high), this.ism.getPageContext().getString(d.j.view_image_quality_high_menu_desc), WC && viewImageQuality == 1));
        this.isx.add(new k(this.ism.getPageContext().getString(d.j.view_low), this.ism.getPageContext().getString(d.j.view_image_quality_low_menu_desc), WC && viewImageQuality == 2));
        this.isx.add(new k(this.ism.getPageContext().getString(d.j.close), this.ism.getPageContext().getString(d.j.view_image_quality_close_menu_desc), WC ? false : true));
        this.iss = new com.baidu.tbadk.core.dialog.e(this.ism.getPageContext());
        this.iss.gL(d.j.browser_image_quality);
        this.iss.a(this.isx, this.isA).abd();
    }

    private void bZf() {
        this.isy = new ArrayList<>();
        int WA = i.Wy().WA();
        this.isy.add(new k(this.ism.getPageContext().getString(d.j.image_water_show_user_name), null, WA == 1));
        this.isy.add(new k(this.ism.getPageContext().getString(d.j.image_water_show_forum_name), null, WA == 2));
        this.isy.add(new k(this.ism.getPageContext().getString(d.j.image_water_show_none), null, WA == 0));
        this.ist = new com.baidu.tbadk.core.dialog.e(this.ism.getPageContext()).gL(d.j.add_image_water);
        this.ist.a(this.isy, this.isB).abd();
    }

    private void bZg() {
        this.isu = new com.baidu.tbadk.core.dialog.e(this.ism.getPageContext());
        this.isw = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.isw.add(new k(this.ism.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.isw.add(new k(this.ism.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.isw.add(new k(this.ism.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.isw.add(new k(this.ism.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.isu.gL(d.j.font_size);
        this.isu.a(this.isw, this.isC);
        this.isu.abd();
    }

    private void bZh() {
        this.isv = new com.baidu.tbadk.core.dialog.e(this.ism.getPageContext());
        this.isz = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.isz.add(new k(this.ism.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.isz.add(new k(this.ism.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.isz.add(new k(this.ism.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (ax.jK()) {
            this.isv.gL(d.j.video_gif_auto_play);
        } else {
            this.isv.gL(d.j.video_auto_play);
        }
        this.isv.a(this.isz, this.isD);
        this.isv.abd();
    }

    public void adq() {
        bZi();
        bZj();
        bZk();
        bZl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZi() {
        if (!i.Wy().WC()) {
            this.isn.setTip(this.mContext.getString(d.j.close));
        } else if (i.Wy().getViewImageQuality() == 1) {
            this.isn.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.Wy().getViewImageQuality() == 2) {
            this.isn.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.isn.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bZj() {
        yC(i.Wy().WA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC(int i) {
        switch (i) {
            case 0:
                this.iso.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.iso.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.iso.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bZk() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.isp.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.isp.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.isp.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.isp.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bZl() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.isq.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.isq.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.isq.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
