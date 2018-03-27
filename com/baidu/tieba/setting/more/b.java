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
    private BrowseSettingActivity gME;
    private View gMF;
    private RelativeLayout gMG;
    private BdSwitchView gMH;
    private TbSettingTextTipView gMI;
    private TbSettingTextTipView gMJ;
    private TbSettingTextTipView gMK;
    private TbSettingTextTipView gML;
    private TbSettingTextTipView gMM;
    private com.baidu.tbadk.core.dialog.e gMN;
    private com.baidu.tbadk.core.dialog.e gMO;
    private com.baidu.tbadk.core.dialog.e gMP;
    private com.baidu.tbadk.core.dialog.e gMQ;
    private com.baidu.tbadk.core.dialog.e gMR;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMS;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMT;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMU;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMV;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMW;
    private final AdapterView.OnItemClickListener gMX;
    private final AdapterView.OnItemClickListener gMY;
    private final AdapterView.OnItemClickListener gMZ;
    private final AdapterView.OnItemClickListener gNa;
    private final AdapterView.OnItemClickListener gNb;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gME = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gMF = null;
        this.gMG = null;
        this.gMH = null;
        this.gMI = null;
        this.gMJ = null;
        this.gMK = null;
        this.gML = null;
        this.gMM = null;
        this.gMN = null;
        this.gMO = null;
        this.gMP = null;
        this.gMQ = null;
        this.gMR = null;
        this.gMX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMN.refresh(i);
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
                b.this.gMN.dismiss();
                b.this.bqB();
            }
        };
        this.gMY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gMO.refresh(i);
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
        this.gMZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMP.refresh(i);
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
                b.this.bqD();
            }
        };
        this.gNa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMQ.refresh(i);
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
                b.this.bqE();
            }
        };
        this.gNb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMR.refresh(i);
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
                b.this.bqF();
            }
        };
        this.gME = browseSettingActivity;
        initUI();
        Df();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gME.getLayoutMode().aQ(i == 1);
        this.gME.getLayoutMode().aM(this.mParent);
        this.gMH.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bqk() {
        return this.gMJ;
    }

    public TbSettingTextTipView bql() {
        return this.gMI;
    }

    public TbSettingTextTipView bqm() {
        return this.gMK;
    }

    public TbSettingTextTipView bqn() {
        return this.gML;
    }

    public TbSettingTextTipView bqo() {
        return this.gMM;
    }

    public void bqp() {
        bqw();
        this.gMO.Ba();
    }

    public void bqq() {
        bqv();
        this.gMN.Ba();
    }

    public void bqr() {
        bqx();
        this.gMP.Ba();
    }

    public void bqs() {
        bqy();
        this.gMQ.Ba();
    }

    public void bqt() {
        bqz();
        this.gMR.Ba();
    }

    private void initUI() {
        this.gME.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gME.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gME.getPageContext().getString(d.j.browse_setting));
        this.gMG = (RelativeLayout) this.gME.findViewById(d.g.eyeshield_mode);
        this.gMH = (BdSwitchView) this.gME.findViewById(d.g.item_switch);
        l.a(this.gME.getPageContext().getPageActivity(), this.gMH, 10, 10, 10, 10);
        this.gMF = this.gME.findViewById(d.g.divide_view2);
        this.gMI = (TbSettingTextTipView) this.gME.findViewById(d.g.img_browser);
        this.gMI.setBottomLineVisibility(true);
        this.gMJ = (TbSettingTextTipView) this.gME.findViewById(d.g.add_img_water);
        this.gMJ.setBottomLineVisibility(true);
        this.gMK = (TbSettingTextTipView) this.gME.findViewById(d.g.show_image);
        this.gMK.setBottomLineVisibility(true);
        this.gML = (TbSettingTextTipView) this.gME.findViewById(d.g.font_size);
        this.gML.setBottomLineVisibility(true);
        this.gMM = (TbSettingTextTipView) this.gME.findViewById(d.g.video_auto_play);
        if (an.nv()) {
            this.gMM.setText(d.j.video_gif_auto_play);
        } else {
            this.gMM.setText(d.j.video_auto_play);
        }
        this.gMM.setBottomLineVisibility(true);
        this.mParent = this.gME.findViewById(d.g.parent);
        if (!bqu()) {
            this.gMF.setVisibility(8);
            this.gMG.setVisibility(8);
            return;
        }
        this.gMF.setVisibility(0);
        this.gMG.setVisibility(0);
    }

    public boolean bqu() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void initListener() {
        this.gMI.setOnClickListener(this.gME);
        this.gMJ.setOnClickListener(this.gME);
        this.gMH.setOnSwitchStateChangeListener(this.gME);
        this.gMK.setOnClickListener(this.gME);
        this.gML.setOnClickListener(this.gME);
        this.gMM.setOnClickListener(this.gME);
    }

    private void bqv() {
        this.gMT = new ArrayList<>();
        int viewImageQuality = i.xo().getViewImageQuality();
        boolean xu = i.xo().xu();
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gME.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), xu && viewImageQuality == 0));
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.view_high), this.gME.getPageContext().getString(d.j.view_image_quality_high_menu_desc), xu && viewImageQuality == 1));
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.view_low), this.gME.getPageContext().getString(d.j.view_image_quality_low_menu_desc), xu && viewImageQuality == 2));
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.close), this.gME.getPageContext().getString(d.j.view_image_quality_close_menu_desc), xu ? false : true));
        this.gMN = new com.baidu.tbadk.core.dialog.e(this.gME.getPageContext());
        this.gMN.fk(d.j.browser_image_quality);
        this.gMN.a(this.gMT, this.gMX).AZ();
    }

    private void bqw() {
        this.gMV = new ArrayList<>();
        int xs = i.xo().xs();
        this.gMV.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.image_water_show_user_name), null, xs == 1));
        this.gMV.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.image_water_show_forum_name), null, xs == 2));
        this.gMV.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.image_water_show_none), null, xs == 0));
        this.gMO = new com.baidu.tbadk.core.dialog.e(this.gME.getPageContext()).fk(d.j.add_image_water);
        this.gMO.a(this.gMV, this.gMY).AZ();
    }

    private void bqx() {
        this.gMU = new ArrayList<>();
        int xp = i.xo().xp();
        this.gMU.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gME.getPageContext().getString(d.j.is_wifiopen_dialog), xp == 0));
        this.gMU.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.is_alwaysopen), null, xp == 1));
        this.gMU.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.is_close), null, xp == 2));
        this.gMP = new com.baidu.tbadk.core.dialog.e(this.gME.getPageContext()).fk(d.j.show_photo);
        this.gMP.a(this.gMU, this.gMZ).AZ();
    }

    private void bqy() {
        this.gMQ = new com.baidu.tbadk.core.dialog.e(this.gME.getPageContext());
        this.gMS = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.gMQ.fk(d.j.font_size);
        this.gMQ.a(this.gMS, this.gNa);
        this.gMQ.AZ();
    }

    private void bqz() {
        this.gMR = new com.baidu.tbadk.core.dialog.e(this.gME.getPageContext());
        this.gMW = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gMW.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gMW.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gMW.add(new com.baidu.tbadk.core.dialog.h(this.gME.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (an.nv()) {
            this.gMR.fk(d.j.video_gif_auto_play);
        } else {
            this.gMR.fk(d.j.video_auto_play);
        }
        this.gMR.a(this.gMW, this.gNb);
        this.gMR.AZ();
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

    public void Df() {
        bqA();
        bqB();
        bqC();
        bqE();
        bqF();
        bqD();
    }

    public void bqA() {
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.gMH.rJ();
        } else {
            this.gMH.rK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqB() {
        if (!i.xo().xu()) {
            this.gMI.setTip(this.mContext.getString(d.j.close));
        } else if (i.xo().getViewImageQuality() == 1) {
            this.gMI.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.xo().getViewImageQuality() == 2) {
            this.gMI.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.gMI.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bqC() {
        uT(i.xo().xs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(int i) {
        switch (i) {
            case 0:
                this.gMJ.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.gMJ.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.gMJ.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bqD() {
        switch (i.xo().xp()) {
            case 0:
                this.gMK.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
                return;
            case 1:
                this.gMK.setTip(this.mContext.getString(d.j.is_alwaysopen));
                return;
            case 2:
                this.gMK.setTip(this.mContext.getString(d.j.is_close));
                return;
            default:
                return;
        }
    }

    public void bqE() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gML.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gML.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gML.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.gML.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bqF() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gMM.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gMM.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gMM.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
