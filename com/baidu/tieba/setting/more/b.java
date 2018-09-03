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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private final AdapterView.OnItemClickListener gzA;
    private final AdapterView.OnItemClickListener gzB;
    private final AdapterView.OnItemClickListener gzC;
    private BrowseSettingActivity gzi;
    private TbSettingTextTipView gzj;
    private TbSettingTextTipView gzk;
    private TbSettingTextTipView gzl;
    private TbSettingTextTipView gzm;
    private TbSettingTextTipView gzn;
    private com.baidu.tbadk.core.dialog.e gzo;
    private com.baidu.tbadk.core.dialog.e gzp;
    private com.baidu.tbadk.core.dialog.e gzq;
    private com.baidu.tbadk.core.dialog.e gzr;
    private com.baidu.tbadk.core.dialog.e gzs;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzt;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzu;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzv;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzw;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gzx;
    private final AdapterView.OnItemClickListener gzy;
    private final AdapterView.OnItemClickListener gzz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gzi = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gzj = null;
        this.gzk = null;
        this.gzl = null;
        this.gzm = null;
        this.gzn = null;
        this.gzo = null;
        this.gzp = null;
        this.gzq = null;
        this.gzr = null;
        this.gzs = null;
        this.gzy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzo.refresh(i);
                switch (i) {
                    case 0:
                        i.td().al(true);
                        i.td().bB(0);
                        break;
                    case 1:
                        i.td().al(true);
                        i.td().bB(1);
                        TiebaStatic.log(new an("c10415").r("obj_type", 1));
                        break;
                    case 2:
                        i.td().al(true);
                        i.td().bB(2);
                        TiebaStatic.log(new an("c10415").r("obj_type", 3));
                        break;
                    case 3:
                        i.td().al(false);
                        break;
                }
                b.this.gzo.dismiss();
                b.this.bpK();
            }
        };
        this.gzz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gzp.refresh(i);
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
                i.td().bA(i2);
                b.this.sN(i2);
            }
        };
        this.gzA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzq.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 2));
                        i.td().bz(0);
                        break;
                    case 1:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 1));
                        i.td().bz(1);
                        break;
                    case 2:
                        TiebaStatic.log(new an("set_viewnophoto").r("obj_index", 3));
                        i.td().bz(2);
                        break;
                }
                b.this.bpM();
            }
        };
        this.gzB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzr.refresh(i);
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
                b.this.bpN();
            }
        };
        this.gzC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gzs.refresh(i);
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
                b.this.bpO();
            }
        };
        this.gzi = browseSettingActivity;
        initUI();
        zv();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gzi.getLayoutMode().setNightMode(i == 1);
        this.gzi.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bpv() {
        return this.gzk;
    }

    public TbSettingTextTipView bpw() {
        return this.gzj;
    }

    public TbSettingTextTipView bpx() {
        return this.gzl;
    }

    public TbSettingTextTipView bpy() {
        return this.gzm;
    }

    public TbSettingTextTipView bpz() {
        return this.gzn;
    }

    public void bpA() {
        bpG();
        this.gzp.xj();
    }

    public void bpB() {
        bpF();
        this.gzo.xj();
    }

    public void bpC() {
        bpH();
        this.gzq.xj();
    }

    public void bpD() {
        bpI();
        this.gzr.xj();
    }

    public void bpE() {
        bpJ();
        this.gzs.xj();
    }

    private void initUI() {
        this.gzi.setContentView(f.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gzi.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gzi.getPageContext().getString(f.j.browse_setting));
        this.gzj = (TbSettingTextTipView) this.gzi.findViewById(f.g.img_browser);
        this.gzj.setBottomLineVisibility(true);
        this.gzk = (TbSettingTextTipView) this.gzi.findViewById(f.g.add_img_water);
        this.gzk.setBottomLineVisibility(true);
        this.gzl = (TbSettingTextTipView) this.gzi.findViewById(f.g.show_image);
        this.gzl.setBottomLineVisibility(true);
        this.gzm = (TbSettingTextTipView) this.gzi.findViewById(f.g.font_size);
        this.gzm.setBottomLineVisibility(true);
        this.gzn = (TbSettingTextTipView) this.gzi.findViewById(f.g.video_auto_play);
        if (ar.iq()) {
            this.gzn.setText(f.j.video_gif_auto_play);
        } else {
            this.gzn.setText(f.j.video_auto_play);
        }
        this.gzn.setBottomLineVisibility(true);
        this.mParent = this.gzi.findViewById(f.g.parent);
    }

    private void initListener() {
        this.gzj.setOnClickListener(this.gzi);
        this.gzk.setOnClickListener(this.gzi);
        this.gzl.setOnClickListener(this.gzi);
        this.gzm.setOnClickListener(this.gzi);
        this.gzn.setOnClickListener(this.gzi);
    }

    private void bpF() {
        this.gzu = new ArrayList<>();
        int viewImageQuality = i.td().getViewImageQuality();
        boolean tj = i.td().tj();
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.view_image_quality_auto_menu), this.gzi.getPageContext().getString(f.j.view_image_quality_auto_menu_desc), tj && viewImageQuality == 0));
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.view_high), this.gzi.getPageContext().getString(f.j.view_image_quality_high_menu_desc), tj && viewImageQuality == 1));
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.view_low), this.gzi.getPageContext().getString(f.j.view_image_quality_low_menu_desc), tj && viewImageQuality == 2));
        this.gzu.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.close), this.gzi.getPageContext().getString(f.j.view_image_quality_close_menu_desc), tj ? false : true));
        this.gzo = new com.baidu.tbadk.core.dialog.e(this.gzi.getPageContext());
        this.gzo.co(f.j.browser_image_quality);
        this.gzo.a(this.gzu, this.gzy).xi();
    }

    private void bpG() {
        this.gzw = new ArrayList<>();
        int th = i.td().th();
        this.gzw.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.image_water_show_user_name), null, th == 1));
        this.gzw.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.image_water_show_forum_name), null, th == 2));
        this.gzw.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.image_water_show_none), null, th == 0));
        this.gzp = new com.baidu.tbadk.core.dialog.e(this.gzi.getPageContext()).co(f.j.add_image_water);
        this.gzp.a(this.gzw, this.gzz).xi();
    }

    private void bpH() {
        this.gzv = new ArrayList<>();
        int te = i.td().te();
        this.gzv.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.view_image_quality_auto_menu), this.gzi.getPageContext().getString(f.j.is_wifiopen_dialog), te == 0));
        this.gzv.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.is_alwaysopen), null, te == 1));
        this.gzv.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.is_close), null, te == 2));
        this.gzq = new com.baidu.tbadk.core.dialog.e(this.gzi.getPageContext()).co(f.j.show_photo);
        this.gzq.a(this.gzv, this.gzA).xi();
    }

    private void bpI() {
        this.gzr = new com.baidu.tbadk.core.dialog.e(this.gzi.getPageContext());
        this.gzt = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.font_size_xlarge), null, fontSize == 0));
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.font_size_big), null, fontSize == 1));
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.font_size_mid), null, fontSize == 2));
        this.gzt.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.font_size_small), null, fontSize == 3));
        this.gzr.co(f.j.font_size);
        this.gzr.a(this.gzt, this.gzB);
        this.gzr.xi();
    }

    private void bpJ() {
        this.gzs = new com.baidu.tbadk.core.dialog.e(this.gzi.getPageContext());
        this.gzx = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gzx.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gzx.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gzx.add(new com.baidu.tbadk.core.dialog.g(this.gzi.getPageContext().getString(f.j.close), null, videoAutoPlay == 1));
        if (ar.iq()) {
            this.gzs.co(f.j.video_gif_auto_play);
        } else {
            this.gzs.co(f.j.video_auto_play);
        }
        this.gzs.a(this.gzx, this.gzC);
        this.gzs.xi();
    }

    public void zv() {
        bpK();
        bpL();
        bpN();
        bpO();
        bpM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpK() {
        if (!i.td().tj()) {
            this.gzj.setTip(this.mContext.getString(f.j.close));
        } else if (i.td().getViewImageQuality() == 1) {
            this.gzj.setTip(this.mContext.getString(f.j.view_high));
        } else if (i.td().getViewImageQuality() == 2) {
            this.gzj.setTip(this.mContext.getString(f.j.view_low));
        } else {
            this.gzj.setTip(this.mContext.getString(f.j.view_image_quality_auto_menu));
        }
    }

    private void bpL() {
        sN(i.td().th());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN(int i) {
        switch (i) {
            case 0:
                this.gzk.setTip(this.mContext.getString(f.j.image_water_show_none));
                return;
            case 1:
                this.gzk.setTip(this.mContext.getString(f.j.image_water_show_user_name));
                return;
            case 2:
                this.gzk.setTip(this.mContext.getString(f.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bpM() {
        switch (i.td().te()) {
            case 0:
                this.gzl.setTip(this.mContext.getString(f.j.view_image_quality_auto_menu));
                return;
            case 1:
                this.gzl.setTip(this.mContext.getString(f.j.is_alwaysopen));
                return;
            case 2:
                this.gzl.setTip(this.mContext.getString(f.j.is_close));
                return;
            default:
                return;
        }
    }

    public void bpN() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gzm.setTip(this.mContext.getString(f.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gzm.setTip(this.mContext.getString(f.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gzm.setTip(this.mContext.getString(f.j.font_size_mid));
        } else {
            this.gzm.setTip(this.mContext.getString(f.j.font_size_small));
        }
    }

    public void bpO() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gzn.setTip(this.mContext.getString(f.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gzn.setTip(this.mContext.getString(f.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gzn.setTip(this.mContext.getString(f.j.video_auto_play_always));
        }
    }
}
