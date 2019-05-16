package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.t.bd;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity iKF;
    private TbSettingTextTipView iKG;
    private TbSettingTextTipView iKH;
    private TbSettingTextTipView iKI;
    private TbSettingTextTipView iKJ;
    private MsgSettingItemView iKK;
    private com.baidu.tbadk.core.dialog.e iKL;
    private com.baidu.tbadk.core.dialog.e iKM;
    private com.baidu.tbadk.core.dialog.e iKN;
    private com.baidu.tbadk.core.dialog.e iKO;
    private ArrayList<m> iKP;
    private ArrayList<m> iKQ;
    private ArrayList<m> iKR;
    private ArrayList<m> iKS;
    private final AdapterView.OnItemClickListener iKT;
    private final AdapterView.OnItemClickListener iKU;
    private final AdapterView.OnItemClickListener iKV;
    private final AdapterView.OnItemClickListener iKW;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iKF = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iKG = null;
        this.iKH = null;
        this.iKI = null;
        this.iKJ = null;
        this.iKL = null;
        this.iKM = null;
        this.iKN = null;
        this.iKO = null;
        this.iKT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKL.refresh(i);
                switch (i) {
                    case 0:
                        i.abb().dB(true);
                        i.abb().gL(0);
                        break;
                    case 1:
                        i.abb().dB(true);
                        i.abb().gL(1);
                        TiebaStatic.log(new am("c10415").P("obj_type", 1));
                        break;
                    case 2:
                        i.abb().dB(true);
                        i.abb().gL(2);
                        TiebaStatic.log(new am("c10415").P("obj_type", 3));
                        break;
                    case 3:
                        i.abb().dB(false);
                        break;
                }
                c.this.iKL.dismiss();
                c.this.chl();
            }
        };
        this.iKU = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iKM.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").P("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").P("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").P("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.abb().gK(i2);
                c.this.zF(i2);
            }
        };
        this.iKV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKN.refresh(i);
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
                c.this.chn();
            }
        };
        this.iKW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKO.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").P("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").P("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").P("obj_type", 3));
                        break;
                }
                c.this.cho();
            }
        };
        this.iKF = browseSettingActivity;
        initUI();
        aim();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iKF.getLayoutMode().setNightMode(i == 1);
        this.iKF.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iKK.onChangeSkinType(this.iKF.getPageContext(), i);
    }

    public TbSettingTextTipView cgZ() {
        return this.iKH;
    }

    public TbSettingTextTipView cha() {
        return this.iKG;
    }

    public TbSettingTextTipView chb() {
        return this.iKI;
    }

    public TbSettingTextTipView chc() {
        return this.iKJ;
    }

    public void chd() {
        chi();
        this.iKM.afL();
    }

    public void che() {
        chh();
        this.iKL.afL();
    }

    public void chf() {
        chj();
        this.iKN.afL();
    }

    public void chg() {
        chk();
        this.iKO.afL();
    }

    private void initUI() {
        this.iKF.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iKF.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKF.getPageContext().getString(R.string.browse_setting));
        this.iKG = (TbSettingTextTipView) this.iKF.findViewById(R.id.img_browser);
        this.iKG.setBottomLineVisibility(true);
        this.iKH = (TbSettingTextTipView) this.iKF.findViewById(R.id.add_img_water);
        this.iKH.setBottomLineVisibility(true);
        this.iKI = (TbSettingTextTipView) this.iKF.findViewById(R.id.font_size);
        this.iKI.setBottomLineVisibility(true);
        this.iKJ = (TbSettingTextTipView) this.iKF.findViewById(R.id.video_auto_play);
        if (bd.iE()) {
            this.iKJ.setText(R.string.video_gif_auto_play);
        } else {
            this.iKJ.setText(R.string.video_auto_play);
        }
        this.iKJ.setBottomLineVisibility(true);
        this.iKK = (MsgSettingItemView) this.iKF.findViewById(R.id.slide_anim_switch);
        this.iKK.setText(R.string.slide_anim_switch);
        this.iKK.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iKK.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.agM().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new am("c13396").P("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new am("c13396").P("obj_type", 2));
            }
        });
        this.mParent = this.iKF.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iKG.setOnClickListener(this.iKF);
        this.iKH.setOnClickListener(this.iKF);
        this.iKI.setOnClickListener(this.iKF);
        this.iKJ.setOnClickListener(this.iKF);
    }

    private void chh() {
        this.iKQ = new ArrayList<>();
        int viewImageQuality = i.abb().getViewImageQuality();
        boolean abf = i.abb().abf();
        this.iKQ.add(new m(this.iKF.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iKF.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), abf && viewImageQuality == 0));
        this.iKQ.add(new m(this.iKF.getPageContext().getString(R.string.view_high), this.iKF.getPageContext().getString(R.string.view_image_quality_high_menu_desc), abf && viewImageQuality == 1));
        this.iKQ.add(new m(this.iKF.getPageContext().getString(R.string.view_low), this.iKF.getPageContext().getString(R.string.view_image_quality_low_menu_desc), abf && viewImageQuality == 2));
        this.iKQ.add(new m(this.iKF.getPageContext().getString(R.string.close), this.iKF.getPageContext().getString(R.string.view_image_quality_close_menu_desc), abf ? false : true));
        this.iKL = new com.baidu.tbadk.core.dialog.e(this.iKF.getPageContext());
        this.iKL.hx(R.string.browser_image_quality);
        this.iKL.a(this.iKQ, this.iKT).afK();
    }

    private void chi() {
        this.iKR = new ArrayList<>();
        int abd = i.abb().abd();
        this.iKR.add(new m(this.iKF.getPageContext().getString(R.string.image_water_show_user_name), null, abd == 1));
        this.iKR.add(new m(this.iKF.getPageContext().getString(R.string.image_water_show_forum_name), null, abd == 2));
        this.iKR.add(new m(this.iKF.getPageContext().getString(R.string.image_water_show_none), null, abd == 0));
        this.iKM = new com.baidu.tbadk.core.dialog.e(this.iKF.getPageContext()).hx(R.string.add_image_water);
        this.iKM.a(this.iKR, this.iKU).afK();
    }

    private void chj() {
        this.iKN = new com.baidu.tbadk.core.dialog.e(this.iKF.getPageContext());
        this.iKP = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iKP.add(new m(this.iKF.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iKP.add(new m(this.iKF.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iKP.add(new m(this.iKF.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iKP.add(new m(this.iKF.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iKN.hx(R.string.font_size);
        this.iKN.a(this.iKP, this.iKV);
        this.iKN.afK();
    }

    private void chk() {
        this.iKO = new com.baidu.tbadk.core.dialog.e(this.iKF.getPageContext());
        this.iKS = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iKS.add(new m(this.iKF.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iKS.add(new m(this.iKF.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iKS.add(new m(this.iKF.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.iE()) {
            this.iKO.hx(R.string.video_gif_auto_play);
        } else {
            this.iKO.hx(R.string.video_auto_play);
        }
        this.iKO.a(this.iKS, this.iKW);
        this.iKO.afK();
    }

    public void aim() {
        chl();
        chm();
        chn();
        cho();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chl() {
        if (!i.abb().abf()) {
            this.iKG.setTip(this.mContext.getString(R.string.close));
        } else if (i.abb().getViewImageQuality() == 1) {
            this.iKG.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.abb().getViewImageQuality() == 2) {
            this.iKG.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iKG.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void chm() {
        zF(i.abb().abd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        switch (i) {
            case 0:
                this.iKH.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iKH.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iKH.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void chn() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iKI.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iKI.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iKI.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iKI.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cho() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iKJ.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iKJ.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iKJ.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
