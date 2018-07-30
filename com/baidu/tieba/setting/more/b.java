package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.p.ar;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity gzf;
    private TbSettingTextTipView gzg;
    private TbSettingTextTipView gzh;
    private TbSettingTextTipView gzi;
    private TbSettingTextTipView gzj;
    private TbSettingTextTipView gzk;
    private com.baidu.tbadk.core.dialog.e gzl;
    private com.baidu.tbadk.core.dialog.e gzm;
    private com.baidu.tbadk.core.dialog.e gzn;
    private com.baidu.tbadk.core.dialog.e gzo;
    private com.baidu.tbadk.core.dialog.e gzp;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzq;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzr;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzs;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzt;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzu;
    private final AdapterView.OnItemClickListener gzv;
    private final AdapterView.OnItemClickListener gzw;
    private final AdapterView.OnItemClickListener gzx;
    private final AdapterView.OnItemClickListener gzy;
    private final AdapterView.OnItemClickListener gzz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gzf = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gzg = null;
        this.gzh = null;
        this.gzi = null;
        this.gzj = null;
        this.gzk = null;
        this.gzl = null;
        this.gzm = null;
        this.gzn = null;
        this.gzo = null;
        this.gzp = null;
        this.gzv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzl.refresh(i);
                switch (i) {
                    case 0:
                        i.te().ak(true);
                        i.te().bB(0);
                        break;
                    case 1:
                        i.te().ak(true);
                        i.te().bB(1);
                        TiebaStatic.log(new an("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.te().ak(true);
                        i.te().bB(2);
                        TiebaStatic.log(new an("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.te().ak(false);
                        break;
                }
                b.this.gzl.dismiss();
                b.this.bpJ();
            }
        };
        this.gzw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gzm.refresh(i);
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
                i.te().bA(i2);
                b.this.sN(i2);
            }
        };
        this.gzx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzn.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 2));
                        i.te().bz(0);
                        break;
                    case 1:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 1));
                        i.te().bz(1);
                        break;
                    case 2:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 3));
                        i.te().bz(2);
                        break;
                }
                b.this.bpL();
            }
        };
        this.gzy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzo.refresh(i);
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
                b.this.bpM();
            }
        };
        this.gzz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzp.refresh(i);
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
                b.this.bpN();
            }
        };
        this.gzf = browseSettingActivity;
        initUI();
        zx();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gzf.getLayoutMode().setNightMode(i == 1);
        this.gzf.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bpu() {
        return this.gzh;
    }

    public TbSettingTextTipView bpv() {
        return this.gzg;
    }

    public TbSettingTextTipView bpw() {
        return this.gzi;
    }

    public TbSettingTextTipView bpx() {
        return this.gzj;
    }

    public TbSettingTextTipView bpy() {
        return this.gzk;
    }

    public void bpz() {
        bpF();
        this.gzm.xk();
    }

    public void bpA() {
        bpE();
        this.gzl.xk();
    }

    public void bpB() {
        bpG();
        this.gzn.xk();
    }

    public void bpC() {
        bpH();
        this.gzo.xk();
    }

    public void bpD() {
        bpI();
        this.gzp.xk();
    }

    private void initUI() {
        this.gzf.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gzf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gzf.getPageContext().getString(d.j.browse_setting));
        this.gzg = (TbSettingTextTipView) this.gzf.findViewById(d.g.img_browser);
        this.gzg.setBottomLineVisibility(true);
        this.gzh = (TbSettingTextTipView) this.gzf.findViewById(d.g.add_img_water);
        this.gzh.setBottomLineVisibility(true);
        this.gzi = (TbSettingTextTipView) this.gzf.findViewById(d.g.show_image);
        this.gzi.setBottomLineVisibility(true);
        this.gzj = (TbSettingTextTipView) this.gzf.findViewById(d.g.font_size);
        this.gzj.setBottomLineVisibility(true);
        this.gzk = (TbSettingTextTipView) this.gzf.findViewById(d.g.video_auto_play);
        if (ar.iq()) {
            this.gzk.setText(d.j.video_gif_auto_play);
        } else {
            this.gzk.setText(d.j.video_auto_play);
        }
        this.gzk.setBottomLineVisibility(true);
        this.mParent = this.gzf.findViewById(d.g.parent);
    }

    private void initListener() {
        this.gzg.setOnClickListener(this.gzf);
        this.gzh.setOnClickListener(this.gzf);
        this.gzi.setOnClickListener(this.gzf);
        this.gzj.setOnClickListener(this.gzf);
        this.gzk.setOnClickListener(this.gzf);
    }

    private void bpE() {
        this.gzr = new ArrayList<>();
        int viewImageQuality = i.te().getViewImageQuality();
        boolean tk = i.te().tk();
        this.gzr.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gzf.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), tk && viewImageQuality == 0));
        this.gzr.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.view_high), this.gzf.getPageContext().getString(d.j.view_image_quality_high_menu_desc), tk && viewImageQuality == 1));
        this.gzr.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.view_low), this.gzf.getPageContext().getString(d.j.view_image_quality_low_menu_desc), tk && viewImageQuality == 2));
        this.gzr.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.close), this.gzf.getPageContext().getString(d.j.view_image_quality_close_menu_desc), tk ? false : true));
        this.gzl = new com.baidu.tbadk.core.dialog.e(this.gzf.getPageContext());
        this.gzl.co(d.j.browser_image_quality);
        this.gzl.a(this.gzr, this.gzv).xj();
    }

    private void bpF() {
        this.gzt = new ArrayList<>();
        int ti = i.te().ti();
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.image_water_show_user_name), null, ti == 1));
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.image_water_show_forum_name), null, ti == 2));
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.image_water_show_none), null, ti == 0));
        this.gzm = new com.baidu.tbadk.core.dialog.e(this.gzf.getPageContext()).co(d.j.add_image_water);
        this.gzm.a(this.gzt, this.gzw).xj();
    }

    private void bpG() {
        this.gzs = new ArrayList<>();
        int tf = i.te().tf();
        this.gzs.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gzf.getPageContext().getString(d.j.is_wifiopen_dialog), tf == 0));
        this.gzs.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.is_alwaysopen), null, tf == 1));
        this.gzs.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.is_close), null, tf == 2));
        this.gzn = new com.baidu.tbadk.core.dialog.e(this.gzf.getPageContext()).co(d.j.show_photo);
        this.gzn.a(this.gzs, this.gzx).xj();
    }

    private void bpH() {
        this.gzo = new com.baidu.tbadk.core.dialog.e(this.gzf.getPageContext());
        this.gzq = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gzq.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.gzq.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.gzq.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.gzq.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.gzo.co(d.j.font_size);
        this.gzo.a(this.gzq, this.gzy);
        this.gzo.xj();
    }

    private void bpI() {
        this.gzp = new com.baidu.tbadk.core.dialog.e(this.gzf.getPageContext());
        this.gzu = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzf.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (ar.iq()) {
            this.gzp.co(d.j.video_gif_auto_play);
        } else {
            this.gzp.co(d.j.video_auto_play);
        }
        this.gzp.a(this.gzu, this.gzz);
        this.gzp.xj();
    }

    public void zx() {
        bpJ();
        bpK();
        bpM();
        bpN();
        bpL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpJ() {
        if (!i.te().tk()) {
            this.gzg.setTip(this.mContext.getString(d.j.close));
        } else if (i.te().getViewImageQuality() == 1) {
            this.gzg.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.te().getViewImageQuality() == 2) {
            this.gzg.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.gzg.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bpK() {
        sN(i.te().ti());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN(int i) {
        switch (i) {
            case 0:
                this.gzh.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.gzh.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.gzh.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bpL() {
        switch (i.te().tf()) {
            case 0:
                this.gzi.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
                return;
            case 1:
                this.gzi.setTip(this.mContext.getString(d.j.is_alwaysopen));
                return;
            case 2:
                this.gzi.setTip(this.mContext.getString(d.j.is_close));
                return;
            default:
                return;
        }
    }

    public void bpM() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gzj.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gzj.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gzj.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.gzj.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bpN() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gzk.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gzk.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gzk.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
