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
    private ArrayList<k> isA;
    private final AdapterView.OnItemClickListener isB;
    private final AdapterView.OnItemClickListener isC;
    private final AdapterView.OnItemClickListener isD;
    private final AdapterView.OnItemClickListener isE;
    private BrowseSettingActivity isn;
    private TbSettingTextTipView iso;
    private TbSettingTextTipView isp;
    private TbSettingTextTipView isq;
    private TbSettingTextTipView isr;
    private MsgSettingItemView iss;
    private com.baidu.tbadk.core.dialog.e ist;
    private com.baidu.tbadk.core.dialog.e isu;
    private com.baidu.tbadk.core.dialog.e isv;
    private com.baidu.tbadk.core.dialog.e isw;
    private ArrayList<k> isx;
    private ArrayList<k> isy;
    private ArrayList<k> isz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.isn = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iso = null;
        this.isp = null;
        this.isq = null;
        this.isr = null;
        this.ist = null;
        this.isu = null;
        this.isv = null;
        this.isw = null;
        this.isB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.ist.refresh(i);
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
                c.this.ist.dismiss();
                c.this.bZj();
            }
        };
        this.isC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.isu.refresh(i);
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
        this.isD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.isv.refresh(i);
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
                c.this.bZl();
            }
        };
        this.isE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.isw.refresh(i);
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
                c.this.bZm();
            }
        };
        this.isn = browseSettingActivity;
        initUI();
        adq();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.isn.getLayoutMode().setNightMode(i == 1);
        this.isn.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iss.onChangeSkinType(this.isn.getPageContext(), i);
    }

    public TbSettingTextTipView bYX() {
        return this.isp;
    }

    public TbSettingTextTipView bYY() {
        return this.iso;
    }

    public TbSettingTextTipView bYZ() {
        return this.isq;
    }

    public TbSettingTextTipView bZa() {
        return this.isr;
    }

    public void bZb() {
        bZg();
        this.isu.abe();
    }

    public void bZc() {
        bZf();
        this.ist.abe();
    }

    public void bZd() {
        bZh();
        this.isv.abe();
    }

    public void bZe() {
        bZi();
        this.isw.abe();
    }

    private void initUI() {
        this.isn.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.isn.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.isn.getPageContext().getString(d.j.browse_setting));
        this.iso = (TbSettingTextTipView) this.isn.findViewById(d.g.img_browser);
        this.iso.setBottomLineVisibility(true);
        this.isp = (TbSettingTextTipView) this.isn.findViewById(d.g.add_img_water);
        this.isp.setBottomLineVisibility(true);
        this.isq = (TbSettingTextTipView) this.isn.findViewById(d.g.font_size);
        this.isq.setBottomLineVisibility(true);
        this.isr = (TbSettingTextTipView) this.isn.findViewById(d.g.video_auto_play);
        if (ax.jK()) {
            this.isr.setText(d.j.video_gif_auto_play);
        } else {
            this.isr.setText(d.j.video_auto_play);
        }
        this.isr.setBottomLineVisibility(true);
        this.iss = (MsgSettingItemView) this.isn.findViewById(d.g.slide_anim_switch);
        this.iss.setText(d.j.slide_anim_switch);
        this.iss.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iss.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.isn.findViewById(d.g.parent);
    }

    private void initListener() {
        this.iso.setOnClickListener(this.isn);
        this.isp.setOnClickListener(this.isn);
        this.isq.setOnClickListener(this.isn);
        this.isr.setOnClickListener(this.isn);
    }

    private void bZf() {
        this.isy = new ArrayList<>();
        int viewImageQuality = i.Wy().getViewImageQuality();
        boolean WC = i.Wy().WC();
        this.isy.add(new k(this.isn.getPageContext().getString(d.j.view_image_quality_auto_menu), this.isn.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), WC && viewImageQuality == 0));
        this.isy.add(new k(this.isn.getPageContext().getString(d.j.view_high), this.isn.getPageContext().getString(d.j.view_image_quality_high_menu_desc), WC && viewImageQuality == 1));
        this.isy.add(new k(this.isn.getPageContext().getString(d.j.view_low), this.isn.getPageContext().getString(d.j.view_image_quality_low_menu_desc), WC && viewImageQuality == 2));
        this.isy.add(new k(this.isn.getPageContext().getString(d.j.close), this.isn.getPageContext().getString(d.j.view_image_quality_close_menu_desc), WC ? false : true));
        this.ist = new com.baidu.tbadk.core.dialog.e(this.isn.getPageContext());
        this.ist.gL(d.j.browser_image_quality);
        this.ist.a(this.isy, this.isB).abd();
    }

    private void bZg() {
        this.isz = new ArrayList<>();
        int WA = i.Wy().WA();
        this.isz.add(new k(this.isn.getPageContext().getString(d.j.image_water_show_user_name), null, WA == 1));
        this.isz.add(new k(this.isn.getPageContext().getString(d.j.image_water_show_forum_name), null, WA == 2));
        this.isz.add(new k(this.isn.getPageContext().getString(d.j.image_water_show_none), null, WA == 0));
        this.isu = new com.baidu.tbadk.core.dialog.e(this.isn.getPageContext()).gL(d.j.add_image_water);
        this.isu.a(this.isz, this.isC).abd();
    }

    private void bZh() {
        this.isv = new com.baidu.tbadk.core.dialog.e(this.isn.getPageContext());
        this.isx = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.isx.add(new k(this.isn.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.isx.add(new k(this.isn.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.isx.add(new k(this.isn.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.isx.add(new k(this.isn.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.isv.gL(d.j.font_size);
        this.isv.a(this.isx, this.isD);
        this.isv.abd();
    }

    private void bZi() {
        this.isw = new com.baidu.tbadk.core.dialog.e(this.isn.getPageContext());
        this.isA = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.isA.add(new k(this.isn.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.isA.add(new k(this.isn.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.isA.add(new k(this.isn.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (ax.jK()) {
            this.isw.gL(d.j.video_gif_auto_play);
        } else {
            this.isw.gL(d.j.video_auto_play);
        }
        this.isw.a(this.isA, this.isE);
        this.isw.abd();
    }

    public void adq() {
        bZj();
        bZk();
        bZl();
        bZm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZj() {
        if (!i.Wy().WC()) {
            this.iso.setTip(this.mContext.getString(d.j.close));
        } else if (i.Wy().getViewImageQuality() == 1) {
            this.iso.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.Wy().getViewImageQuality() == 2) {
            this.iso.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.iso.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bZk() {
        yC(i.Wy().WA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC(int i) {
        switch (i) {
            case 0:
                this.isp.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.isp.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.isp.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bZl() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.isq.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.isq.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.isq.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.isq.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bZm() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.isr.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.isr.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.isr.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
