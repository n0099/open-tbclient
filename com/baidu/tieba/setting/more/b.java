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
    private BrowseSettingActivity gMD;
    private View gME;
    private RelativeLayout gMF;
    private BdSwitchView gMG;
    private TbSettingTextTipView gMH;
    private TbSettingTextTipView gMI;
    private TbSettingTextTipView gMJ;
    private TbSettingTextTipView gMK;
    private TbSettingTextTipView gML;
    private com.baidu.tbadk.core.dialog.e gMM;
    private com.baidu.tbadk.core.dialog.e gMN;
    private com.baidu.tbadk.core.dialog.e gMO;
    private com.baidu.tbadk.core.dialog.e gMP;
    private com.baidu.tbadk.core.dialog.e gMQ;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMR;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMS;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMT;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMU;
    private ArrayList<com.baidu.tbadk.core.dialog.h> gMV;
    private final AdapterView.OnItemClickListener gMW;
    private final AdapterView.OnItemClickListener gMX;
    private final AdapterView.OnItemClickListener gMY;
    private final AdapterView.OnItemClickListener gMZ;
    private final AdapterView.OnItemClickListener gNa;
    private NavigationBar mNavigationBar;
    private View mParent;

    public b(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.gMD = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.gME = null;
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
        this.gMW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMM.refresh(i);
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
                b.this.gMM.dismiss();
                b.this.bqB();
            }
        };
        this.gMX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                b.this.gMN.refresh(i);
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
                b.this.uS(i2);
            }
        };
        this.gMY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMO.refresh(i);
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
        this.gMZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMP.refresh(i);
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
        this.gNa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.b.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b.this.gMQ.refresh(i);
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
        this.gMD = browseSettingActivity;
        initUI();
        Df();
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        this.gMD.getLayoutMode().aQ(i == 1);
        this.gMD.getLayoutMode().aM(this.mParent);
        this.gMG.a(aj.fO(d.f.bg_switch_open), aj.fO(d.f.bg_switch_close), aj.fO(d.f.btn_handle));
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    public TbSettingTextTipView bqk() {
        return this.gMI;
    }

    public TbSettingTextTipView bql() {
        return this.gMH;
    }

    public TbSettingTextTipView bqm() {
        return this.gMJ;
    }

    public TbSettingTextTipView bqn() {
        return this.gMK;
    }

    public TbSettingTextTipView bqo() {
        return this.gML;
    }

    public void bqp() {
        bqw();
        this.gMN.AZ();
    }

    public void bqq() {
        bqv();
        this.gMM.AZ();
    }

    public void bqr() {
        bqx();
        this.gMO.AZ();
    }

    public void bqs() {
        bqy();
        this.gMP.AZ();
    }

    public void bqt() {
        bqz();
        this.gMQ.AZ();
    }

    private void initUI() {
        this.gMD.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.gMD.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.gMD.getPageContext().getString(d.j.browse_setting));
        this.gMF = (RelativeLayout) this.gMD.findViewById(d.g.eyeshield_mode);
        this.gMG = (BdSwitchView) this.gMD.findViewById(d.g.item_switch);
        l.a(this.gMD.getPageContext().getPageActivity(), this.gMG, 10, 10, 10, 10);
        this.gME = this.gMD.findViewById(d.g.divide_view2);
        this.gMH = (TbSettingTextTipView) this.gMD.findViewById(d.g.img_browser);
        this.gMH.setBottomLineVisibility(true);
        this.gMI = (TbSettingTextTipView) this.gMD.findViewById(d.g.add_img_water);
        this.gMI.setBottomLineVisibility(true);
        this.gMJ = (TbSettingTextTipView) this.gMD.findViewById(d.g.show_image);
        this.gMJ.setBottomLineVisibility(true);
        this.gMK = (TbSettingTextTipView) this.gMD.findViewById(d.g.font_size);
        this.gMK.setBottomLineVisibility(true);
        this.gML = (TbSettingTextTipView) this.gMD.findViewById(d.g.video_auto_play);
        if (an.nv()) {
            this.gML.setText(d.j.video_gif_auto_play);
        } else {
            this.gML.setText(d.j.video_auto_play);
        }
        this.gML.setBottomLineVisibility(true);
        this.mParent = this.gMD.findViewById(d.g.parent);
        if (!bqu()) {
            this.gME.setVisibility(8);
            this.gMF.setVisibility(8);
            return;
        }
        this.gME.setVisibility(0);
        this.gMF.setVisibility(0);
    }

    public boolean bqu() {
        return MessageManager.getInstance().runTask(2001281, Boolean.class) != null;
    }

    private void initListener() {
        this.gMH.setOnClickListener(this.gMD);
        this.gMI.setOnClickListener(this.gMD);
        this.gMG.setOnSwitchStateChangeListener(this.gMD);
        this.gMJ.setOnClickListener(this.gMD);
        this.gMK.setOnClickListener(this.gMD);
        this.gML.setOnClickListener(this.gMD);
    }

    private void bqv() {
        this.gMS = new ArrayList<>();
        int viewImageQuality = i.xo().getViewImageQuality();
        boolean xu = i.xo().xu();
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gMD.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), xu && viewImageQuality == 0));
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.view_high), this.gMD.getPageContext().getString(d.j.view_image_quality_high_menu_desc), xu && viewImageQuality == 1));
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.view_low), this.gMD.getPageContext().getString(d.j.view_image_quality_low_menu_desc), xu && viewImageQuality == 2));
        this.gMS.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.close), this.gMD.getPageContext().getString(d.j.view_image_quality_close_menu_desc), xu ? false : true));
        this.gMM = new com.baidu.tbadk.core.dialog.e(this.gMD.getPageContext());
        this.gMM.fk(d.j.browser_image_quality);
        this.gMM.a(this.gMS, this.gMW).AY();
    }

    private void bqw() {
        this.gMU = new ArrayList<>();
        int xs = i.xo().xs();
        this.gMU.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.image_water_show_user_name), null, xs == 1));
        this.gMU.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.image_water_show_forum_name), null, xs == 2));
        this.gMU.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.image_water_show_none), null, xs == 0));
        this.gMN = new com.baidu.tbadk.core.dialog.e(this.gMD.getPageContext()).fk(d.j.add_image_water);
        this.gMN.a(this.gMU, this.gMX).AY();
    }

    private void bqx() {
        this.gMT = new ArrayList<>();
        int xp = i.xo().xp();
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.view_image_quality_auto_menu), this.gMD.getPageContext().getString(d.j.is_wifiopen_dialog), xp == 0));
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.is_alwaysopen), null, xp == 1));
        this.gMT.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.is_close), null, xp == 2));
        this.gMO = new com.baidu.tbadk.core.dialog.e(this.gMD.getPageContext()).fk(d.j.show_photo);
        this.gMO.a(this.gMT, this.gMY).AY();
    }

    private void bqy() {
        this.gMP = new com.baidu.tbadk.core.dialog.e(this.gMD.getPageContext());
        this.gMR = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.gMR.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.gMR.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.gMR.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.gMR.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.gMP.fk(d.j.font_size);
        this.gMP.a(this.gMR, this.gMZ);
        this.gMP.AY();
    }

    private void bqz() {
        this.gMQ = new com.baidu.tbadk.core.dialog.e(this.gMD.getPageContext());
        this.gMV = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.gMV.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.gMV.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.gMV.add(new com.baidu.tbadk.core.dialog.h(this.gMD.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (an.nv()) {
            this.gMQ.fk(d.j.video_gif_auto_play);
        } else {
            this.gMQ.fk(d.j.video_auto_play);
        }
        this.gMQ.a(this.gMV, this.gNa);
        this.gMQ.AY();
    }

    public void uR(int i) {
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
            this.gMG.rJ();
        } else {
            this.gMG.rK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqB() {
        if (!i.xo().xu()) {
            this.gMH.setTip(this.mContext.getString(d.j.close));
        } else if (i.xo().getViewImageQuality() == 1) {
            this.gMH.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.xo().getViewImageQuality() == 2) {
            this.gMH.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.gMH.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bqC() {
        uS(i.xo().xs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        switch (i) {
            case 0:
                this.gMI.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.gMI.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.gMI.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bqD() {
        switch (i.xo().xp()) {
            case 0:
                this.gMJ.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
                return;
            case 1:
                this.gMJ.setTip(this.mContext.getString(d.j.is_alwaysopen));
                return;
            case 2:
                this.gMJ.setTip(this.mContext.getString(d.j.is_close));
                return;
            default:
                return;
        }
    }

    public void bqE() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.gMK.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.gMK.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.gMK.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.gMK.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bqF() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.gML.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.gML.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.gML.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
