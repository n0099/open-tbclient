package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.p.av;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity gWj;
    private TbSettingTextTipView gWk;
    private TbSettingTextTipView gWl;
    private TbSettingTextTipView gWm;
    private TbSettingTextTipView gWn;
    private com.baidu.tbadk.core.dialog.e gWo;
    private com.baidu.tbadk.core.dialog.e gWp;
    private com.baidu.tbadk.core.dialog.e gWq;
    private com.baidu.tbadk.core.dialog.e gWr;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gWs;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gWt;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gWu;
    private ArrayList<com.baidu.tbadk.core.dialog.g> gWv;
    private final AdapterView.OnItemClickListener gWw;
    private final AdapterView.OnItemClickListener gWx;
    private final AdapterView.OnItemClickListener gWy;
    private final AdapterView.OnItemClickListener gWz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gWj = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gWk = null;
        this.gWl = null;
        this.gWm = null;
        this.gWn = null;
        this.gWo = null;
        this.gWp = null;
        this.gWq = null;
        this.gWr = null;
        this.gWw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gWo.refresh(i);
                switch (i) {
                    case 0:
                        i.xE().aW(true);
                        i.xE().cy(0);
                        break;
                    case 1:
                        i.xE().aW(true);
                        i.xE().cy(1);
                        TiebaStatic.log(new am("c10415").x("obj_type", 1));
                        break;
                    case 2:
                        i.xE().aW(true);
                        i.xE().cy(2);
                        TiebaStatic.log(new am("c10415").x("obj_type", 3));
                        break;
                    case 3:
                        i.xE().aW(false);
                        break;
                }
                b.this.gWo.dismiss();
                b.this.bwS();
            }
        };
        this.gWx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gWp.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").x("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").x("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").x("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.xE().cx(i2);
                b.this.uv(i2);
            }
        };
        this.gWy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gWq.refresh(i);
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
                b.this.bwU();
            }
        };
        this.gWz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gWr.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").x("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").x("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").x("obj_type", 3));
                        break;
                }
                b.this.bwV();
            }
        };
        this.gWj = browseSettingActivity;
        initUI();
        DS();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gWj.getLayoutMode().setNightMode(i == 1);
        this.gWj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bwG() {
        return this.gWl;
    }

    public TbSettingTextTipView bwH() {
        return this.gWk;
    }

    public TbSettingTextTipView bwI() {
        return this.gWm;
    }

    public TbSettingTextTipView bwJ() {
        return this.gWn;
    }

    public void bwK() {
        bwP();
        this.gWp.BK();
    }

    public void bwL() {
        bwO();
        this.gWo.BK();
    }

    public void bwM() {
        bwQ();
        this.gWq.BK();
    }

    public void bwN() {
        bwR();
        this.gWr.BK();
    }

    private void initUI() {
        this.gWj.setContentView(e.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gWj.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gWj.getPageContext().getString(e.j.browse_setting));
        this.gWk = (TbSettingTextTipView) this.gWj.findViewById(e.g.img_browser);
        this.gWk.setBottomLineVisibility(true);
        this.gWl = (TbSettingTextTipView) this.gWj.findViewById(e.g.add_img_water);
        this.gWl.setBottomLineVisibility(true);
        this.gWm = (TbSettingTextTipView) this.gWj.findViewById(e.g.font_size);
        this.gWm.setBottomLineVisibility(true);
        this.gWn = (TbSettingTextTipView) this.gWj.findViewById(e.g.video_auto_play);
        if (av.jJ()) {
            this.gWn.setText(e.j.video_gif_auto_play);
        } else {
            this.gWn.setText(e.j.video_auto_play);
        }
        this.gWn.setBottomLineVisibility(true);
        this.mParent = this.gWj.findViewById(e.g.parent);
    }

    private void initListener() {
        this.gWk.setOnClickListener(this.gWj);
        this.gWl.setOnClickListener(this.gWj);
        this.gWm.setOnClickListener(this.gWj);
        this.gWn.setOnClickListener(this.gWj);
    }

    private void bwO() {
        this.gWt = new ArrayList<>();
        int viewImageQuality = i.xE().getViewImageQuality();
        boolean xI = i.xE().xI();
        this.gWt.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.view_image_quality_auto_menu), this.gWj.getPageContext().getString(e.j.view_image_quality_auto_menu_desc), xI && viewImageQuality == 0));
        this.gWt.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.view_high), this.gWj.getPageContext().getString(e.j.view_image_quality_high_menu_desc), xI && viewImageQuality == 1));
        this.gWt.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.view_low), this.gWj.getPageContext().getString(e.j.view_image_quality_low_menu_desc), xI && viewImageQuality == 2));
        this.gWt.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.close), this.gWj.getPageContext().getString(e.j.view_image_quality_close_menu_desc), xI ? false : true));
        this.gWo = new com.baidu.tbadk.core.dialog.e(this.gWj.getPageContext());
        this.gWo.dk(e.j.browser_image_quality);
        this.gWo.a(this.gWt, this.gWw).BJ();
    }

    private void bwP() {
        this.gWu = new ArrayList<>();
        int xG = i.xE().xG();
        this.gWu.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.image_water_show_user_name), null, xG == 1));
        this.gWu.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.image_water_show_forum_name), null, xG == 2));
        this.gWu.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.image_water_show_none), null, xG == 0));
        this.gWp = new com.baidu.tbadk.core.dialog.e(this.gWj.getPageContext()).dk(e.j.add_image_water);
        this.gWp.a(this.gWu, this.gWx).BJ();
    }

    private void bwQ() {
        this.gWq = new com.baidu.tbadk.core.dialog.e(this.gWj.getPageContext());
        this.gWs = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gWs.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.font_size_xlarge), null, fontSize == 0));
        this.gWs.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.font_size_big), null, fontSize == 1));
        this.gWs.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.font_size_mid), null, fontSize == 2));
        this.gWs.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.font_size_small), null, fontSize == 3));
        this.gWq.dk(e.j.font_size);
        this.gWq.a(this.gWs, this.gWy);
        this.gWq.BJ();
    }

    private void bwR() {
        this.gWr = new com.baidu.tbadk.core.dialog.e(this.gWj.getPageContext());
        this.gWv = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gWv.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gWv.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gWv.add(new com.baidu.tbadk.core.dialog.g(this.gWj.getPageContext().getString(e.j.close), null, videoAutoPlay == 1));
        if (av.jJ()) {
            this.gWr.dk(e.j.video_gif_auto_play);
        } else {
            this.gWr.dk(e.j.video_auto_play);
        }
        this.gWr.a(this.gWv, this.gWz);
        this.gWr.BJ();
    }

    public void DS() {
        bwS();
        bwT();
        bwU();
        bwV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwS() {
        if (!i.xE().xI()) {
            this.gWk.setTip(this.mContext.getString(e.j.close));
        } else if (i.xE().getViewImageQuality() == 1) {
            this.gWk.setTip(this.mContext.getString(e.j.view_high));
        } else if (i.xE().getViewImageQuality() == 2) {
            this.gWk.setTip(this.mContext.getString(e.j.view_low));
        } else {
            this.gWk.setTip(this.mContext.getString(e.j.view_image_quality_auto_menu));
        }
    }

    private void bwT() {
        uv(i.xE().xG());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uv(int i) {
        switch (i) {
            case 0:
                this.gWl.setTip(this.mContext.getString(e.j.image_water_show_none));
                return;
            case 1:
                this.gWl.setTip(this.mContext.getString(e.j.image_water_show_user_name));
                return;
            case 2:
                this.gWl.setTip(this.mContext.getString(e.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bwU() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gWm.setTip(this.mContext.getString(e.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gWm.setTip(this.mContext.getString(e.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gWm.setTip(this.mContext.getString(e.j.font_size_mid));
        } else {
            this.gWm.setTip(this.mContext.getString(e.j.font_size_small));
        }
    }

    public void bwV() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gWn.setTip(this.mContext.getString(e.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gWn.setTip(this.mContext.getString(e.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gWn.setTip(this.mContext.getString(e.j.video_auto_play_always));
        }
    }
}
