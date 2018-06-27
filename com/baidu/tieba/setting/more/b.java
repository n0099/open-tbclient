package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.o.aq;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity gxX;
    private TbSettingTextTipView gxY;
    private TbSettingTextTipView gxZ;
    private TbSettingTextTipView gya;
    private TbSettingTextTipView gyb;
    private TbSettingTextTipView gyc;
    private com.baidu.tbadk.core.dialog.e gyd;
    private com.baidu.tbadk.core.dialog.e gye;
    private com.baidu.tbadk.core.dialog.e gyf;
    private com.baidu.tbadk.core.dialog.e gyg;
    private com.baidu.tbadk.core.dialog.e gyh;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gyi;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gyj;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gyk;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gyl;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gym;
    private final AdapterView.OnItemClickListener gyn;
    private final AdapterView.OnItemClickListener gyo;
    private final AdapterView.OnItemClickListener gyp;
    private final AdapterView.OnItemClickListener gyq;
    private final AdapterView.OnItemClickListener gyr;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gxX = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gxY = null;
        this.gxZ = null;
        this.gya = null;
        this.gyb = null;
        this.gyc = null;
        this.gyd = null;
        this.gye = null;
        this.gyf = null;
        this.gyg = null;
        this.gyh = null;
        this.gyn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gyd.refresh(i);
                switch (i) {
                    case 0:
                        i.tt().ao(true);
                        i.tt().bz(0);
                        break;
                    case 1:
                        i.tt().ao(true);
                        i.tt().bz(1);
                        TiebaStatic.log(new an("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.tt().ao(true);
                        i.tt().bz(2);
                        TiebaStatic.log(new an("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.tt().ao(false);
                        break;
                }
                b.this.gyd.dismiss();
                b.this.brg();
            }
        };
        this.gyo = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gye.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").r("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").r("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").r("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.tt().by(i2);
                b.this.sP(i2);
            }
        };
        this.gyp = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gyf.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 2));
                        i.tt().bx(0);
                        break;
                    case 1:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 1));
                        i.tt().bx(1);
                        break;
                    case 2:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 3));
                        i.tt().bx(2);
                        break;
                }
                b.this.bri();
            }
        };
        this.gyq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gyg.refresh(i);
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
                b.this.brj();
            }
        };
        this.gyr = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gyh.refresh(i);
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
                b.this.brk();
            }
        };
        this.gxX = browseSettingActivity;
        initUI();
        zG();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gxX.getLayoutMode().setNightMode(i == 1);
        this.gxX.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bqR() {
        return this.gxZ;
    }

    public TbSettingTextTipView bqS() {
        return this.gxY;
    }

    public TbSettingTextTipView bqT() {
        return this.gya;
    }

    public TbSettingTextTipView bqU() {
        return this.gyb;
    }

    public TbSettingTextTipView bqV() {
        return this.gyc;
    }

    public void bqW() {
        brc();
        this.gye.xs();
    }

    public void bqX() {
        brb();
        this.gyd.xs();
    }

    public void bqY() {
        brd();
        this.gyf.xs();
    }

    public void bqZ() {
        bre();
        this.gyg.xs();
    }

    public void bra() {
        brf();
        this.gyh.xs();
    }

    private void initUI() {
        this.gxX.setContentView(d.i.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gxX.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gxX.getPageContext().getString(d.k.browse_setting));
        this.gxY = (TbSettingTextTipView) this.gxX.findViewById(d.g.img_browser);
        this.gxY.setBottomLineVisibility(true);
        this.gxZ = (TbSettingTextTipView) this.gxX.findViewById(d.g.add_img_water);
        this.gxZ.setBottomLineVisibility(true);
        this.gya = (TbSettingTextTipView) this.gxX.findViewById(d.g.show_image);
        this.gya.setBottomLineVisibility(true);
        this.gyb = (TbSettingTextTipView) this.gxX.findViewById(d.g.font_size);
        this.gyb.setBottomLineVisibility(true);
        this.gyc = (TbSettingTextTipView) this.gxX.findViewById(d.g.video_auto_play);
        if (aq.ip()) {
            this.gyc.setText(d.k.video_gif_auto_play);
        } else {
            this.gyc.setText(d.k.video_auto_play);
        }
        this.gyc.setBottomLineVisibility(true);
        this.mParent = this.gxX.findViewById(d.g.parent);
    }

    private void initListener() {
        this.gxY.setOnClickListener(this.gxX);
        this.gxZ.setOnClickListener(this.gxX);
        this.gya.setOnClickListener(this.gxX);
        this.gyb.setOnClickListener(this.gxX);
        this.gyc.setOnClickListener(this.gxX);
    }

    private void brb() {
        this.gyj = new ArrayList<>();
        int viewImageQuality = i.tt().getViewImageQuality();
        boolean tz = i.tt().tz();
        this.gyj.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.view_image_quality_auto_menu), this.gxX.getPageContext().getString(d.k.view_image_quality_auto_menu_desc), tz && viewImageQuality == 0));
        this.gyj.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.view_high), this.gxX.getPageContext().getString(d.k.view_image_quality_high_menu_desc), tz && viewImageQuality == 1));
        this.gyj.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.view_low), this.gxX.getPageContext().getString(d.k.view_image_quality_low_menu_desc), tz && viewImageQuality == 2));
        this.gyj.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.close), this.gxX.getPageContext().getString(d.k.view_image_quality_close_menu_desc), tz ? false : true));
        this.gyd = new com.baidu.tbadk.core.dialog.e(this.gxX.getPageContext());
        this.gyd.cm(d.k.browser_image_quality);
        this.gyd.a(this.gyj, this.gyn).xr();
    }

    private void brc() {
        this.gyl = new ArrayList<>();
        int tx = i.tt().tx();
        this.gyl.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.image_water_show_user_name), null, tx == 1));
        this.gyl.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.image_water_show_forum_name), null, tx == 2));
        this.gyl.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.image_water_show_none), null, tx == 0));
        this.gye = new com.baidu.tbadk.core.dialog.e(this.gxX.getPageContext()).cm(d.k.add_image_water);
        this.gye.a(this.gyl, this.gyo).xr();
    }

    private void brd() {
        this.gyk = new ArrayList<>();
        int tu = i.tt().tu();
        this.gyk.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.view_image_quality_auto_menu), this.gxX.getPageContext().getString(d.k.is_wifiopen_dialog), tu == 0));
        this.gyk.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.is_alwaysopen), null, tu == 1));
        this.gyk.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.is_close), null, tu == 2));
        this.gyf = new com.baidu.tbadk.core.dialog.e(this.gxX.getPageContext()).cm(d.k.show_photo);
        this.gyf.a(this.gyk, this.gyp).xr();
    }

    private void bre() {
        this.gyg = new com.baidu.tbadk.core.dialog.e(this.gxX.getPageContext());
        this.gyi = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gyi.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.font_size_xlarge), null, fontSize == 0));
        this.gyi.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.font_size_big), null, fontSize == 1));
        this.gyi.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.font_size_mid), null, fontSize == 2));
        this.gyi.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.font_size_small), null, fontSize == 3));
        this.gyg.cm(d.k.font_size);
        this.gyg.a(this.gyi, this.gyq);
        this.gyg.xr();
    }

    private void brf() {
        this.gyh = new com.baidu.tbadk.core.dialog.e(this.gxX.getPageContext());
        this.gym = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gym.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.video_auto_play_always), null, videoAutoPlay == 2));
        this.gym.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gym.add(new com.baidu.tbadk.core.dialog.g(this.gxX.getPageContext().getString(d.k.close), null, videoAutoPlay == 1));
        if (aq.ip()) {
            this.gyh.cm(d.k.video_gif_auto_play);
        } else {
            this.gyh.cm(d.k.video_auto_play);
        }
        this.gyh.a(this.gym, this.gyr);
        this.gyh.xr();
    }

    public void zG() {
        brg();
        brh();
        brj();
        brk();
        bri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brg() {
        if (!i.tt().tz()) {
            this.gxY.setTip(this.mContext.getString(d.k.close));
        } else if (i.tt().getViewImageQuality() == 1) {
            this.gxY.setTip(this.mContext.getString(d.k.view_high));
        } else if (i.tt().getViewImageQuality() == 2) {
            this.gxY.setTip(this.mContext.getString(d.k.view_low));
        } else {
            this.gxY.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
        }
    }

    private void brh() {
        sP(i.tt().tx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(int i) {
        switch (i) {
            case 0:
                this.gxZ.setTip(this.mContext.getString(d.k.image_water_show_none));
                return;
            case 1:
                this.gxZ.setTip(this.mContext.getString(d.k.image_water_show_user_name));
                return;
            case 2:
                this.gxZ.setTip(this.mContext.getString(d.k.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bri() {
        switch (i.tt().tu()) {
            case 0:
                this.gya.setTip(this.mContext.getString(d.k.view_image_quality_auto_menu));
                return;
            case 1:
                this.gya.setTip(this.mContext.getString(d.k.is_alwaysopen));
                return;
            case 2:
                this.gya.setTip(this.mContext.getString(d.k.is_close));
                return;
            default:
                return;
        }
    }

    public void brj() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gyb.setTip(this.mContext.getString(d.k.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gyb.setTip(this.mContext.getString(d.k.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gyb.setTip(this.mContext.getString(d.k.font_size_mid));
        } else {
            this.gyb.setTip(this.mContext.getString(d.k.font_size_small));
        }
    }

    public void brk() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gyc.setTip(this.mContext.getString(d.k.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gyc.setTip(this.mContext.getString(d.k.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gyc.setTip(this.mContext.getString(d.k.video_auto_play_always));
        }
    }
}
