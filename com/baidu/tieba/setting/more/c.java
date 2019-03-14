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
    private BrowseSettingActivity isg;
    private TbSettingTextTipView ish;
    private TbSettingTextTipView isi;
    private TbSettingTextTipView isj;
    private TbSettingTextTipView isk;
    private MsgSettingItemView isl;
    private com.baidu.tbadk.core.dialog.e ism;
    private com.baidu.tbadk.core.dialog.e isn;
    private com.baidu.tbadk.core.dialog.e iso;
    private com.baidu.tbadk.core.dialog.e isp;
    private ArrayList<k> isq;
    private ArrayList<k> isr;
    private ArrayList<k> iss;
    private ArrayList<k> ist;
    private final AdapterView.OnItemClickListener isu;
    private final AdapterView.OnItemClickListener isv;
    private final AdapterView.OnItemClickListener isw;
    private final AdapterView.OnItemClickListener isx;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.isg = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.ish = null;
        this.isi = null;
        this.isj = null;
        this.isk = null;
        this.ism = null;
        this.isn = null;
        this.iso = null;
        this.isp = null;
        this.isu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.ism.refresh(i);
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
                c.this.ism.dismiss();
                c.this.bZl();
            }
        };
        this.isv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.isn.refresh(i);
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
        this.isw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iso.refresh(i);
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
                c.this.bZn();
            }
        };
        this.isx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.isp.refresh(i);
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
                c.this.bZo();
            }
        };
        this.isg = browseSettingActivity;
        initUI();
        adq();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.isg.getLayoutMode().setNightMode(i == 1);
        this.isg.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.isl.onChangeSkinType(this.isg.getPageContext(), i);
    }

    public TbSettingTextTipView bYZ() {
        return this.isi;
    }

    public TbSettingTextTipView bZa() {
        return this.ish;
    }

    public TbSettingTextTipView bZb() {
        return this.isj;
    }

    public TbSettingTextTipView bZc() {
        return this.isk;
    }

    public void bZd() {
        bZi();
        this.isn.abe();
    }

    public void bZe() {
        bZh();
        this.ism.abe();
    }

    public void bZf() {
        bZj();
        this.iso.abe();
    }

    public void bZg() {
        bZk();
        this.isp.abe();
    }

    private void initUI() {
        this.isg.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.isg.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.isg.getPageContext().getString(d.j.browse_setting));
        this.ish = (TbSettingTextTipView) this.isg.findViewById(d.g.img_browser);
        this.ish.setBottomLineVisibility(true);
        this.isi = (TbSettingTextTipView) this.isg.findViewById(d.g.add_img_water);
        this.isi.setBottomLineVisibility(true);
        this.isj = (TbSettingTextTipView) this.isg.findViewById(d.g.font_size);
        this.isj.setBottomLineVisibility(true);
        this.isk = (TbSettingTextTipView) this.isg.findViewById(d.g.video_auto_play);
        if (ax.jK()) {
            this.isk.setText(d.j.video_gif_auto_play);
        } else {
            this.isk.setText(d.j.video_auto_play);
        }
        this.isk.setBottomLineVisibility(true);
        this.isl = (MsgSettingItemView) this.isg.findViewById(d.g.slide_anim_switch);
        this.isl.setText(d.j.slide_anim_switch);
        this.isl.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.isl.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new am("c13396").T("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new am("c13396").T("obj_type", 2));
            }
        });
        this.mParent = this.isg.findViewById(d.g.parent);
    }

    private void initListener() {
        this.ish.setOnClickListener(this.isg);
        this.isi.setOnClickListener(this.isg);
        this.isj.setOnClickListener(this.isg);
        this.isk.setOnClickListener(this.isg);
    }

    private void bZh() {
        this.isr = new ArrayList<>();
        int viewImageQuality = i.Wy().getViewImageQuality();
        boolean WC = i.Wy().WC();
        this.isr.add(new k(this.isg.getPageContext().getString(d.j.view_image_quality_auto_menu), this.isg.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), WC && viewImageQuality == 0));
        this.isr.add(new k(this.isg.getPageContext().getString(d.j.view_high), this.isg.getPageContext().getString(d.j.view_image_quality_high_menu_desc), WC && viewImageQuality == 1));
        this.isr.add(new k(this.isg.getPageContext().getString(d.j.view_low), this.isg.getPageContext().getString(d.j.view_image_quality_low_menu_desc), WC && viewImageQuality == 2));
        this.isr.add(new k(this.isg.getPageContext().getString(d.j.close), this.isg.getPageContext().getString(d.j.view_image_quality_close_menu_desc), WC ? false : true));
        this.ism = new com.baidu.tbadk.core.dialog.e(this.isg.getPageContext());
        this.ism.gL(d.j.browser_image_quality);
        this.ism.a(this.isr, this.isu).abd();
    }

    private void bZi() {
        this.iss = new ArrayList<>();
        int WA = i.Wy().WA();
        this.iss.add(new k(this.isg.getPageContext().getString(d.j.image_water_show_user_name), null, WA == 1));
        this.iss.add(new k(this.isg.getPageContext().getString(d.j.image_water_show_forum_name), null, WA == 2));
        this.iss.add(new k(this.isg.getPageContext().getString(d.j.image_water_show_none), null, WA == 0));
        this.isn = new com.baidu.tbadk.core.dialog.e(this.isg.getPageContext()).gL(d.j.add_image_water);
        this.isn.a(this.iss, this.isv).abd();
    }

    private void bZj() {
        this.iso = new com.baidu.tbadk.core.dialog.e(this.isg.getPageContext());
        this.isq = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.isq.add(new k(this.isg.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.isq.add(new k(this.isg.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.isq.add(new k(this.isg.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.isq.add(new k(this.isg.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.iso.gL(d.j.font_size);
        this.iso.a(this.isq, this.isw);
        this.iso.abd();
    }

    private void bZk() {
        this.isp = new com.baidu.tbadk.core.dialog.e(this.isg.getPageContext());
        this.ist = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.ist.add(new k(this.isg.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.ist.add(new k(this.isg.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.ist.add(new k(this.isg.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (ax.jK()) {
            this.isp.gL(d.j.video_gif_auto_play);
        } else {
            this.isp.gL(d.j.video_auto_play);
        }
        this.isp.a(this.ist, this.isx);
        this.isp.abd();
    }

    public void adq() {
        bZl();
        bZm();
        bZn();
        bZo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZl() {
        if (!i.Wy().WC()) {
            this.ish.setTip(this.mContext.getString(d.j.close));
        } else if (i.Wy().getViewImageQuality() == 1) {
            this.ish.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.Wy().getViewImageQuality() == 2) {
            this.ish.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.ish.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bZm() {
        yC(i.Wy().WA());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yC(int i) {
        switch (i) {
            case 0:
                this.isi.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.isi.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.isi.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bZn() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.isj.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.isj.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.isj.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.isj.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bZo() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.isk.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.isk.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.isk.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
