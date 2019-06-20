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
    private BrowseSettingActivity iKL;
    private TbSettingTextTipView iKM;
    private TbSettingTextTipView iKN;
    private TbSettingTextTipView iKO;
    private TbSettingTextTipView iKP;
    private MsgSettingItemView iKQ;
    private com.baidu.tbadk.core.dialog.e iKR;
    private com.baidu.tbadk.core.dialog.e iKS;
    private com.baidu.tbadk.core.dialog.e iKT;
    private com.baidu.tbadk.core.dialog.e iKU;
    private ArrayList<m> iKV;
    private ArrayList<m> iKW;
    private ArrayList<m> iKX;
    private ArrayList<m> iKY;
    private final AdapterView.OnItemClickListener iKZ;
    private final AdapterView.OnItemClickListener iLa;
    private final AdapterView.OnItemClickListener iLb;
    private final AdapterView.OnItemClickListener iLc;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iKL = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iKM = null;
        this.iKN = null;
        this.iKO = null;
        this.iKP = null;
        this.iKR = null;
        this.iKS = null;
        this.iKT = null;
        this.iKU = null;
        this.iKZ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKR.refresh(i);
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
                c.this.iKR.dismiss();
                c.this.cho();
            }
        };
        this.iLa = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iKS.refresh(i);
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
        this.iLb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKT.refresh(i);
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
                c.this.chq();
            }
        };
        this.iLc = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKU.refresh(i);
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
                c.this.chr();
            }
        };
        this.iKL = browseSettingActivity;
        initUI();
        aim();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iKL.getLayoutMode().setNightMode(i == 1);
        this.iKL.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iKQ.onChangeSkinType(this.iKL.getPageContext(), i);
    }

    public TbSettingTextTipView chc() {
        return this.iKN;
    }

    public TbSettingTextTipView chd() {
        return this.iKM;
    }

    public TbSettingTextTipView che() {
        return this.iKO;
    }

    public TbSettingTextTipView chf() {
        return this.iKP;
    }

    public void chg() {
        chl();
        this.iKS.afL();
    }

    public void chh() {
        chk();
        this.iKR.afL();
    }

    public void chi() {
        chm();
        this.iKT.afL();
    }

    public void chj() {
        chn();
        this.iKU.afL();
    }

    private void initUI() {
        this.iKL.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iKL.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKL.getPageContext().getString(R.string.browse_setting));
        this.iKM = (TbSettingTextTipView) this.iKL.findViewById(R.id.img_browser);
        this.iKM.setBottomLineVisibility(true);
        this.iKN = (TbSettingTextTipView) this.iKL.findViewById(R.id.add_img_water);
        this.iKN.setBottomLineVisibility(true);
        this.iKO = (TbSettingTextTipView) this.iKL.findViewById(R.id.font_size);
        this.iKO.setBottomLineVisibility(true);
        this.iKP = (TbSettingTextTipView) this.iKL.findViewById(R.id.video_auto_play);
        if (bd.iE()) {
            this.iKP.setText(R.string.video_gif_auto_play);
        } else {
            this.iKP.setText(R.string.video_auto_play);
        }
        this.iKP.setBottomLineVisibility(true);
        this.iKQ = (MsgSettingItemView) this.iKL.findViewById(R.id.slide_anim_switch);
        this.iKQ.setText(R.string.slide_anim_switch);
        this.iKQ.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iKQ.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.iKL.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iKM.setOnClickListener(this.iKL);
        this.iKN.setOnClickListener(this.iKL);
        this.iKO.setOnClickListener(this.iKL);
        this.iKP.setOnClickListener(this.iKL);
    }

    private void chk() {
        this.iKW = new ArrayList<>();
        int viewImageQuality = i.abb().getViewImageQuality();
        boolean abf = i.abb().abf();
        this.iKW.add(new m(this.iKL.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iKL.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), abf && viewImageQuality == 0));
        this.iKW.add(new m(this.iKL.getPageContext().getString(R.string.view_high), this.iKL.getPageContext().getString(R.string.view_image_quality_high_menu_desc), abf && viewImageQuality == 1));
        this.iKW.add(new m(this.iKL.getPageContext().getString(R.string.view_low), this.iKL.getPageContext().getString(R.string.view_image_quality_low_menu_desc), abf && viewImageQuality == 2));
        this.iKW.add(new m(this.iKL.getPageContext().getString(R.string.close), this.iKL.getPageContext().getString(R.string.view_image_quality_close_menu_desc), abf ? false : true));
        this.iKR = new com.baidu.tbadk.core.dialog.e(this.iKL.getPageContext());
        this.iKR.hx(R.string.browser_image_quality);
        this.iKR.a(this.iKW, this.iKZ).afK();
    }

    private void chl() {
        this.iKX = new ArrayList<>();
        int abd = i.abb().abd();
        this.iKX.add(new m(this.iKL.getPageContext().getString(R.string.image_water_show_user_name), null, abd == 1));
        this.iKX.add(new m(this.iKL.getPageContext().getString(R.string.image_water_show_forum_name), null, abd == 2));
        this.iKX.add(new m(this.iKL.getPageContext().getString(R.string.image_water_show_none), null, abd == 0));
        this.iKS = new com.baidu.tbadk.core.dialog.e(this.iKL.getPageContext()).hx(R.string.add_image_water);
        this.iKS.a(this.iKX, this.iLa).afK();
    }

    private void chm() {
        this.iKT = new com.baidu.tbadk.core.dialog.e(this.iKL.getPageContext());
        this.iKV = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iKV.add(new m(this.iKL.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iKV.add(new m(this.iKL.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iKV.add(new m(this.iKL.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iKV.add(new m(this.iKL.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iKT.hx(R.string.font_size);
        this.iKT.a(this.iKV, this.iLb);
        this.iKT.afK();
    }

    private void chn() {
        this.iKU = new com.baidu.tbadk.core.dialog.e(this.iKL.getPageContext());
        this.iKY = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iKY.add(new m(this.iKL.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iKY.add(new m(this.iKL.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iKY.add(new m(this.iKL.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.iE()) {
            this.iKU.hx(R.string.video_gif_auto_play);
        } else {
            this.iKU.hx(R.string.video_auto_play);
        }
        this.iKU.a(this.iKY, this.iLc);
        this.iKU.afK();
    }

    public void aim() {
        cho();
        chp();
        chq();
        chr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cho() {
        if (!i.abb().abf()) {
            this.iKM.setTip(this.mContext.getString(R.string.close));
        } else if (i.abb().getViewImageQuality() == 1) {
            this.iKM.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.abb().getViewImageQuality() == 2) {
            this.iKM.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iKM.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void chp() {
        zF(i.abb().abd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        switch (i) {
            case 0:
                this.iKN.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iKN.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iKN.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void chq() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iKO.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iKO.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iKO.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iKO.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void chr() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iKP.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iKP.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iKP.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
