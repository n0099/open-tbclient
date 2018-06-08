package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.o.ap;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity guf;
    private TbSettingTextTipView gug;
    private TbSettingTextTipView guh;
    private TbSettingTextTipView gui;
    private TbSettingTextTipView guj;
    private TbSettingTextTipView guk;
    private com.baidu.tbadk.core.dialog.e gul;
    private com.baidu.tbadk.core.dialog.e gum;
    private com.baidu.tbadk.core.dialog.e gun;
    private com.baidu.tbadk.core.dialog.e guo;
    private com.baidu.tbadk.core.dialog.e gup;
    private ArrayList<com.baidu.tbadk.core.dialog.g> guq;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gur;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gus;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gut;
    private ArrayList<com.baidu.tbadk.core.dialog.g> guu;
    private final AdapterView.OnItemClickListener guv;
    private final AdapterView.OnItemClickListener guw;
    private final AdapterView.OnItemClickListener gux;
    private final AdapterView.OnItemClickListener guy;
    private final AdapterView.OnItemClickListener guz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.guf = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gug = null;
        this.guh = null;
        this.gui = null;
        this.guj = null;
        this.guk = null;
        this.gul = null;
        this.gum = null;
        this.gun = null;
        this.guo = null;
        this.gup = null;
        this.guv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gul.refresh(i);
                switch (i) {
                    case 0:
                        i.tt().ao(true);
                        i.tt().bA(0);
                        break;
                    case 1:
                        i.tt().ao(true);
                        i.tt().bA(1);
                        TiebaStatic.log(new am("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.tt().ao(true);
                        i.tt().bA(2);
                        TiebaStatic.log(new am("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.tt().ao(false);
                        break;
                }
                b.this.gul.dismiss();
                b.this.bqF();
            }
        };
        this.guw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gum.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").r("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").r("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").r("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.tt().bz(i2);
                b.this.sF(i2);
            }
        };
        this.gux = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gun.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("set_viewnophoto").r("obj_index", 2));
                        i.tt().by(0);
                        break;
                    case 1:
                        TiebaStatic.log(new am("set_viewnophoto").r("obj_index", 1));
                        i.tt().by(1);
                        break;
                    case 2:
                        TiebaStatic.log(new am("set_viewnophoto").r("obj_index", 3));
                        i.tt().by(2);
                        break;
                }
                b.this.bqH();
            }
        };
        this.guy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.guo.refresh(i);
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
                b.this.bqI();
            }
        };
        this.guz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gup.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        break;
                }
                b.this.bqJ();
            }
        };
        this.guf = browseSettingActivity;
        initUI();
        zr();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.guf.getLayoutMode().setNightMode(i == 1);
        this.guf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bqq() {
        return this.guh;
    }

    public TbSettingTextTipView bqr() {
        return this.gug;
    }

    public TbSettingTextTipView bqs() {
        return this.gui;
    }

    public TbSettingTextTipView bqt() {
        return this.guj;
    }

    public TbSettingTextTipView bqu() {
        return this.guk;
    }

    public void bqv() {
        bqB();
        this.gum.xf();
    }

    public void bqw() {
        bqA();
        this.gul.xf();
    }

    public void bqx() {
        bqC();
        this.gun.xf();
    }

    public void bqy() {
        bqD();
        this.guo.xf();
    }

    public void bqz() {
        bqE();
        this.gup.xf();
    }

    private void initUI() {
        this.guf.setContentView(d.i.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.guf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.guf.getPageContext().getString(d.k.browse_setting));
        this.gug = (TbSettingTextTipView) this.guf.findViewById(d.g.img_browser);
        this.gug.setBottomLineVisibility(true);
        this.guh = (TbSettingTextTipView) this.guf.findViewById(d.g.add_img_water);
        this.guh.setBottomLineVisibility(true);
        this.gui = (TbSettingTextTipView) this.guf.findViewById(d.g.show_image);
        this.gui.setBottomLineVisibility(true);
        this.guj = (TbSettingTextTipView) this.guf.findViewById(d.g.font_size);
        this.guj.setBottomLineVisibility(true);
        this.guk = (TbSettingTextTipView) this.guf.findViewById(d.g.video_auto_play);
        if (ap.ip()) {
            this.guk.setText(d.k.video_gif_auto_play);
        } else {
            this.guk.setText(d.k.video_auto_play);
        }
        this.guk.setBottomLineVisibility(true);
        this.mParent = this.guf.findViewById(d.g.parent);
    }

    private void initListener() {
        this.gug.setOnClickListener(this.guf);
        this.guh.setOnClickListener(this.guf);
        this.gui.setOnClickListener(this.guf);
        this.guj.setOnClickListener(this.guf);
        this.guk.setOnClickListener(this.guf);
    }

    private void bqA() {
        this.gur = new ArrayList<>();
        int viewImageQuality = i.tt().getViewImageQuality();
        boolean tz = i.tt().tz();
        this.gur.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.view_image_quality_auto_menu), this.guf.getPageContext().getString(d.k.view_image_quality_auto_menu_desc), tz && viewImageQuality == 0));
        this.gur.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.view_high), this.guf.getPageContext().getString(d.k.view_image_quality_high_menu_desc), tz && viewImageQuality == 1));
        this.gur.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.view_low), this.guf.getPageContext().getString(d.k.view_image_quality_low_menu_desc), tz && viewImageQuality == 2));
        this.gur.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.close), this.guf.getPageContext().getString(d.k.view_image_quality_close_menu_desc), tz ? false : true));
        this.gul = new com.baidu.tbadk.core.dialog.e(this.guf.getPageContext());
        this.gul.cl(d.k.browser_image_quality);
        this.gul.a(this.gur, this.guv).xe();
    }

    private void bqB() {
        this.gut = new ArrayList<>();
        int tx = i.tt().tx();
        this.gut.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.image_water_show_user_name), null, tx == 1));
        this.gut.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.image_water_show_forum_name), null, tx == 2));
        this.gut.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.image_water_show_none), null, tx == 0));
        this.gum = new com.baidu.tbadk.core.dialog.e(this.guf.getPageContext()).cl(d.k.add_image_water);
        this.gum.a(this.gut, this.guw).xe();
    }

    private void bqC() {
        this.gus = new ArrayList<>();
        int tu = i.tt().tu();
        this.gus.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.view_image_quality_auto_menu), this.guf.getPageContext().getString(d.k.is_wifiopen_dialog), tu == 0));
        this.gus.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.is_alwaysopen), null, tu == 1));
        this.gus.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.is_close), null, tu == 2));
        this.gun = new com.baidu.tbadk.core.dialog.e(this.guf.getPageContext()).cl(d.k.show_photo);
        this.gun.a(this.gus, this.gux).xe();
    }

    private void bqD() {
        this.guo = new com.baidu.tbadk.core.dialog.e(this.guf.getPageContext());
        this.guq = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.guq.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.font_size_xlarge), null, fontSize == 0));
        this.guq.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.font_size_big), null, fontSize == 1));
        this.guq.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.font_size_mid), null, fontSize == 2));
        this.guq.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.font_size_small), null, fontSize == 3));
        this.guo.cl(d.k.font_size);
        this.guo.a(this.guq, this.guy);
        this.guo.xe();
    }

    private void bqE() {
        this.gup = new com.baidu.tbadk.core.dialog.e(this.guf.getPageContext());
        this.guu = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.guu.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.video_auto_play_always), null, videoAutoPlay == 2));
        this.guu.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.guu.add(new com.baidu.tbadk.core.dialog.g(this.guf.getPageContext().getString(d.k.close), null, videoAutoPlay == 1));
        if (ap.ip()) {
            this.gup.cl(d.k.video_gif_auto_play);
        } else {
            this.gup.cl(d.k.video_auto_play);
        }
        this.gup.a(this.guu, this.guz);
        this.gup.xe();
    }

    public void zr() {
        bqF();
        bqG();
        bqI();
        bqJ();
        bqH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqF() {
        if (!i.tt().tz()) {
            this.gug.setTip(this.mContext.getString(d.k.close));
        } else if (i.tt().getViewImageQuality() == 1) {
            this.gug.setTip(this.mContext.getString(d.k.view_high));
        } else if (i.tt().getViewImageQuality() == 2) {
            this.gug.setTip(this.mContext.getString(d.k.view_low));
        } else {
            this.gug.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
        }
    }

    private void bqG() {
        sF(i.tt().tx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sF(int i) {
        switch (i) {
            case 0:
                this.guh.setTip(this.mContext.getString(d.k.image_water_show_none));
                return;
            case 1:
                this.guh.setTip(this.mContext.getString(d.k.image_water_show_user_name));
                return;
            case 2:
                this.guh.setTip(this.mContext.getString(d.k.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bqH() {
        switch (i.tt().tu()) {
            case 0:
                this.gui.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
                return;
            case 1:
                this.gui.setTip(this.mContext.getString(d.k.is_alwaysopen));
                return;
            case 2:
                this.gui.setTip(this.mContext.getString(d.k.is_close));
                return;
            default:
                return;
        }
    }

    public void bqI() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.guj.setTip(this.mContext.getString(d.k.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.guj.setTip(this.mContext.getString(d.k.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.guj.setTip(this.mContext.getString(d.k.font_size_mid));
        } else {
            this.guj.setTip(this.mContext.getString(d.k.font_size_small));
        }
    }

    public void bqJ() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.guk.setTip(this.mContext.getString(d.k.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.guk.setTip(this.mContext.getString(d.k.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.guk.setTip(this.mContext.getString(d.k.video_auto_play_always));
        }
    }
}
