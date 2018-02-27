package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.o.an;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private com.baidu.tbadk.core.dialog.e gMA;
    private com.baidu.tbadk.core.dialog.e gMB;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMC;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMD;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gME;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMF;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMG;
    private final AdapterView.OnItemClickListener gMH;
    private final AdapterView.OnItemClickListener gMI;
    private final AdapterView.OnItemClickListener gMJ;
    private final AdapterView.OnItemClickListener gMK;
    private final AdapterView.OnItemClickListener gML;
    private BrowseSettingActivity gMo;
    private View gMp;
    private RelativeLayout gMq;
    private BdSwitchView gMr;
    private TbSettingTextTipView gMs;
    private TbSettingTextTipView gMt;
    private TbSettingTextTipView gMu;
    private TbSettingTextTipView gMv;
    private TbSettingTextTipView gMw;
    private com.baidu.tbadk.core.dialog.e gMx;
    private com.baidu.tbadk.core.dialog.e gMy;
    private com.baidu.tbadk.core.dialog.e gMz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gMo = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gMp = null;
        this.gMq = null;
        this.gMr = null;
        this.gMs = null;
        this.gMt = null;
        this.gMu = null;
        this.gMv = null;
        this.gMw = null;
        this.gMx = null;
        this.gMy = null;
        this.gMz = null;
        this.gMA = null;
        this.gMB = null;
        this.gMH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMx.refresh(i);
                switch (i) {
                    case 0:
                        i.xo().aT(true);
                        i.xo().eA(0);
                        break;
                    case 1:
                        i.xo().aT(true);
                        i.xo().eA(1);
                        TiebaStatic.log(new ak("c10415").s("obj_type", 1));
                        break;
                    case 2:
                        i.xo().aT(true);
                        i.xo().eA(2);
                        TiebaStatic.log(new ak("c10415").s("obj_type", 3));
                        break;
                    case 3:
                        i.xo().aT(false);
                        break;
                }
                b.this.gMx.dismiss();
                b.this.bqA();
            }
        };
        this.gMI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gMy.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ak("c10411").s("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ak("c10411").s("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ak("c10411").s("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.xo().ez(i2);
                b.this.uT(i2);
            }
        };
        this.gMJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMz.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ak("set_viewnophoto").s("obj_index", 2));
                        i.xo().ey(0);
                        break;
                    case 1:
                        TiebaStatic.log(new ak("set_viewnophoto").s("obj_index", 1));
                        i.xo().ey(1);
                        break;
                    case 2:
                        TiebaStatic.log(new ak("set_viewnophoto").s("obj_index", 3));
                        i.xo().ey(2);
                        break;
                }
                b.this.bqC();
            }
        };
        this.gMK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMA.refresh(i);
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
                b.this.bqD();
            }
        };
        this.gML = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMB.refresh(i);
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
                b.this.bqE();
            }
        };
        this.gMo = browseSettingActivity;
        initUI();
        De();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gMo.getLayoutMode().aQ(i == 1);
        this.gMo.getLayoutMode().aM(this.mParent);
        this.gMr.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bqj() {
        return this.gMt;
    }

    public TbSettingTextTipView bqk() {
        return this.gMs;
    }

    public TbSettingTextTipView bql() {
        return this.gMu;
    }

    public TbSettingTextTipView bqm() {
        return this.gMv;
    }

    public TbSettingTextTipView bqn() {
        return this.gMw;
    }

    public void bqo() {
        bqv();
        this.gMy.AZ();
    }

    public void bqp() {
        bqu();
        this.gMx.AZ();
    }

    public void bqq() {
        bqw();
        this.gMz.AZ();
    }

    public void bqr() {
        bqx();
        this.gMA.AZ();
    }

    public void bqs() {
        bqy();
        this.gMB.AZ();
    }

    private void initUI() {
        this.gMo.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gMo.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gMo.getPageContext().getString(d.j.browse_setting));
        this.gMq = (RelativeLayout) this.gMo.findViewById(d.g.eyeshield_mode);
        this.gMr = (BdSwitchView) this.gMo.findViewById(d.g.item_switch);
        l.a(this.gMo.getPageContext().getPageActivity(), this.gMr, 10, 10, 10, 10);
        this.gMp = this.gMo.findViewById(d.g.divide_view2);
        this.gMs = (TbSettingTextTipView) this.gMo.findViewById(d.g.img_browser);
        this.gMs.setBottomLineVisibility(true);
        this.gMt = (TbSettingTextTipView) this.gMo.findViewById(d.g.add_img_water);
        this.gMt.setBottomLineVisibility(true);
        this.gMu = (TbSettingTextTipView) this.gMo.findViewById(d.g.show_image);
        this.gMu.setBottomLineVisibility(true);
        this.gMv = (TbSettingTextTipView) this.gMo.findViewById(d.g.font_size);
        this.gMv.setBottomLineVisibility(true);
        this.gMw = (TbSettingTextTipView) this.gMo.findViewById(d.g.video_auto_play);
        if (an.nv()) {
            this.gMw.setText(d.j.video_gif_auto_play);
        } else {
            this.gMw.setText(d.j.video_auto_play);
        }
        this.gMw.setBottomLineVisibility(true);
        this.mParent = this.gMo.findViewById(d.g.parent);
        if (!bqt()) {
            this.gMp.setVisibility(8);
            this.gMq.setVisibility(8);
            return;
        }
        this.gMp.setVisibility(0);
        this.gMq.setVisibility(0);
    }

    public boolean bqt() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void initListener() {
        this.gMs.setOnClickListener(this.gMo);
        this.gMt.setOnClickListener(this.gMo);
        this.gMr.setOnSwitchStateChangeListener(this.gMo);
        this.gMu.setOnClickListener(this.gMo);
        this.gMv.setOnClickListener(this.gMo);
        this.gMw.setOnClickListener(this.gMo);
    }

    private void bqu() {
        this.gMD = new ArrayList<>();
        int viewImageQuality = i.xo().getViewImageQuality();
        boolean xu = i.xo().xu();
        this.gMD.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gMo.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), xu && viewImageQuality == 0));
        this.gMD.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.view_high), this.gMo.getPageContext().getString(d.j.view_image_quality_high_menu_desc), xu && viewImageQuality == 1));
        this.gMD.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.view_low), this.gMo.getPageContext().getString(d.j.view_image_quality_low_menu_desc), xu && viewImageQuality == 2));
        this.gMD.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.close), this.gMo.getPageContext().getString(d.j.view_image_quality_close_menu_desc), xu ? false : true));
        this.gMx = new com.baidu.tbadk.core.dialog.e(this.gMo.getPageContext());
        this.gMx.fk(d.j.browser_image_quality);
        this.gMx.a(this.gMD, this.gMH).AY();
    }

    private void bqv() {
        this.gMF = new ArrayList<>();
        int xs = i.xo().xs();
        this.gMF.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.image_water_show_user_name), null, xs == 1));
        this.gMF.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.image_water_show_forum_name), null, xs == 2));
        this.gMF.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.image_water_show_none), null, xs == 0));
        this.gMy = new com.baidu.tbadk.core.dialog.e(this.gMo.getPageContext()).fk(d.j.add_image_water);
        this.gMy.a(this.gMF, this.gMI).AY();
    }

    private void bqw() {
        this.gME = new ArrayList<>();
        int xp = i.xo().xp();
        this.gME.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gMo.getPageContext().getString(d.j.is_wifiopen_dialog), xp == 0));
        this.gME.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.is_alwaysopen), null, xp == 1));
        this.gME.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.is_close), null, xp == 2));
        this.gMz = new com.baidu.tbadk.core.dialog.e(this.gMo.getPageContext()).fk(d.j.show_photo);
        this.gMz.a(this.gME, this.gMJ).AY();
    }

    private void bqx() {
        this.gMA = new com.baidu.tbadk.core.dialog.e(this.gMo.getPageContext());
        this.gMC = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gMC.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.gMC.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.gMC.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.gMC.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.gMA.fk(d.j.font_size);
        this.gMA.a(this.gMC, this.gMK);
        this.gMA.AY();
    }

    private void bqy() {
        this.gMB = new com.baidu.tbadk.core.dialog.e(this.gMo.getPageContext());
        this.gMG = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gMG.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gMG.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gMG.add(new com.baidu.tbadk.core.dialog.h(this.gMo.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (an.nv()) {
            this.gMB.fk(d.j.video_gif_auto_play);
        } else {
            this.gMB.fk(d.j.video_auto_play);
        }
        this.gMB.a(this.gMG, this.gML);
        this.gMB.AY();
    }

    public void uS(int i) {
        if (i == 1) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                TiebaStatic.log(new ak("c10647").ab("obj_type", "1").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        } else if (i == 0) {
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                onChangeSkinType(i);
                TbadkCoreApplication.getInst().setSkinType(i);
                TiebaStatic.log(new ak("c10647").ab("obj_type", "0").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0"));
            } else {
                return;
            }
        }
        BitmapHelper.clearCashBitmap();
    }

    public void De() {
        bqz();
        bqA();
        bqB();
        bqD();
        bqE();
        bqC();
    }

    public void bqz() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gMr.rJ();
        } else {
            this.gMr.rK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqA() {
        if (!i.xo().xu()) {
            this.gMs.setTip(this.mContext.getString(d.j.close));
        } else if (i.xo().getViewImageQuality() == 1) {
            this.gMs.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.xo().getViewImageQuality() == 2) {
            this.gMs.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.gMs.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bqB() {
        uT(i.xo().xs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(int i) {
        switch (i) {
            case 0:
                this.gMt.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.gMt.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.gMt.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bqC() {
        switch (i.xo().xp()) {
            case 0:
                this.gMu.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
                return;
            case 1:
                this.gMu.setTip(this.mContext.getString(d.j.is_alwaysopen));
                return;
            case 2:
                this.gMu.setTip(this.mContext.getString(d.j.is_close));
                return;
            default:
                return;
        }
    }

    public void bqD() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gMv.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gMv.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gMv.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.gMv.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bqE() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gMw.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gMw.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gMw.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
