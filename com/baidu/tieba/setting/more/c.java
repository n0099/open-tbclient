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
    private BrowseSettingActivity iKH;
    private TbSettingTextTipView iKI;
    private TbSettingTextTipView iKJ;
    private TbSettingTextTipView iKK;
    private TbSettingTextTipView iKL;
    private MsgSettingItemView iKM;
    private com.baidu.tbadk.core.dialog.e iKN;
    private com.baidu.tbadk.core.dialog.e iKO;
    private com.baidu.tbadk.core.dialog.e iKP;
    private com.baidu.tbadk.core.dialog.e iKQ;
    private ArrayList<m> iKR;
    private ArrayList<m> iKS;
    private ArrayList<m> iKT;
    private ArrayList<m> iKU;
    private final AdapterView.OnItemClickListener iKV;
    private final AdapterView.OnItemClickListener iKW;
    private final AdapterView.OnItemClickListener iKX;
    private final AdapterView.OnItemClickListener iKY;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iKH = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iKI = null;
        this.iKJ = null;
        this.iKK = null;
        this.iKL = null;
        this.iKN = null;
        this.iKO = null;
        this.iKP = null;
        this.iKQ = null;
        this.iKV = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKN.refresh(i);
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
                c.this.iKN.dismiss();
                c.this.chn();
            }
        };
        this.iKW = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iKO.refresh(i);
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
        this.iKX = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKP.refresh(i);
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
                c.this.chp();
            }
        };
        this.iKY = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iKQ.refresh(i);
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
                c.this.chq();
            }
        };
        this.iKH = browseSettingActivity;
        initUI();
        aim();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iKH.getLayoutMode().setNightMode(i == 1);
        this.iKH.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iKM.onChangeSkinType(this.iKH.getPageContext(), i);
    }

    public TbSettingTextTipView chb() {
        return this.iKJ;
    }

    public TbSettingTextTipView chc() {
        return this.iKI;
    }

    public TbSettingTextTipView chd() {
        return this.iKK;
    }

    public TbSettingTextTipView che() {
        return this.iKL;
    }

    public void chf() {
        chk();
        this.iKO.afL();
    }

    public void chg() {
        chj();
        this.iKN.afL();
    }

    public void chh() {
        chl();
        this.iKP.afL();
    }

    public void chi() {
        chm();
        this.iKQ.afL();
    }

    private void initUI() {
        this.iKH.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iKH.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iKH.getPageContext().getString(R.string.browse_setting));
        this.iKI = (TbSettingTextTipView) this.iKH.findViewById(R.id.img_browser);
        this.iKI.setBottomLineVisibility(true);
        this.iKJ = (TbSettingTextTipView) this.iKH.findViewById(R.id.add_img_water);
        this.iKJ.setBottomLineVisibility(true);
        this.iKK = (TbSettingTextTipView) this.iKH.findViewById(R.id.font_size);
        this.iKK.setBottomLineVisibility(true);
        this.iKL = (TbSettingTextTipView) this.iKH.findViewById(R.id.video_auto_play);
        if (bd.iE()) {
            this.iKL.setText(R.string.video_gif_auto_play);
        } else {
            this.iKL.setText(R.string.video_auto_play);
        }
        this.iKL.setBottomLineVisibility(true);
        this.iKM = (MsgSettingItemView) this.iKH.findViewById(R.id.slide_anim_switch);
        this.iKM.setText(R.string.slide_anim_switch);
        this.iKM.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iKM.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.iKH.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iKI.setOnClickListener(this.iKH);
        this.iKJ.setOnClickListener(this.iKH);
        this.iKK.setOnClickListener(this.iKH);
        this.iKL.setOnClickListener(this.iKH);
    }

    private void chj() {
        this.iKS = new ArrayList<>();
        int viewImageQuality = i.abb().getViewImageQuality();
        boolean abf = i.abb().abf();
        this.iKS.add(new m(this.iKH.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iKH.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), abf && viewImageQuality == 0));
        this.iKS.add(new m(this.iKH.getPageContext().getString(R.string.view_high), this.iKH.getPageContext().getString(R.string.view_image_quality_high_menu_desc), abf && viewImageQuality == 1));
        this.iKS.add(new m(this.iKH.getPageContext().getString(R.string.view_low), this.iKH.getPageContext().getString(R.string.view_image_quality_low_menu_desc), abf && viewImageQuality == 2));
        this.iKS.add(new m(this.iKH.getPageContext().getString(R.string.close), this.iKH.getPageContext().getString(R.string.view_image_quality_close_menu_desc), abf ? false : true));
        this.iKN = new com.baidu.tbadk.core.dialog.e(this.iKH.getPageContext());
        this.iKN.hx(R.string.browser_image_quality);
        this.iKN.a(this.iKS, this.iKV).afK();
    }

    private void chk() {
        this.iKT = new ArrayList<>();
        int abd = i.abb().abd();
        this.iKT.add(new m(this.iKH.getPageContext().getString(R.string.image_water_show_user_name), null, abd == 1));
        this.iKT.add(new m(this.iKH.getPageContext().getString(R.string.image_water_show_forum_name), null, abd == 2));
        this.iKT.add(new m(this.iKH.getPageContext().getString(R.string.image_water_show_none), null, abd == 0));
        this.iKO = new com.baidu.tbadk.core.dialog.e(this.iKH.getPageContext()).hx(R.string.add_image_water);
        this.iKO.a(this.iKT, this.iKW).afK();
    }

    private void chl() {
        this.iKP = new com.baidu.tbadk.core.dialog.e(this.iKH.getPageContext());
        this.iKR = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iKR.add(new m(this.iKH.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iKR.add(new m(this.iKH.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iKR.add(new m(this.iKH.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iKR.add(new m(this.iKH.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iKP.hx(R.string.font_size);
        this.iKP.a(this.iKR, this.iKX);
        this.iKP.afK();
    }

    private void chm() {
        this.iKQ = new com.baidu.tbadk.core.dialog.e(this.iKH.getPageContext());
        this.iKU = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iKU.add(new m(this.iKH.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iKU.add(new m(this.iKH.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iKU.add(new m(this.iKH.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.iE()) {
            this.iKQ.hx(R.string.video_gif_auto_play);
        } else {
            this.iKQ.hx(R.string.video_auto_play);
        }
        this.iKQ.a(this.iKU, this.iKY);
        this.iKQ.afK();
    }

    public void aim() {
        chn();
        cho();
        chp();
        chq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        if (!i.abb().abf()) {
            this.iKI.setTip(this.mContext.getString(R.string.close));
        } else if (i.abb().getViewImageQuality() == 1) {
            this.iKI.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.abb().getViewImageQuality() == 2) {
            this.iKI.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iKI.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cho() {
        zF(i.abb().abd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        switch (i) {
            case 0:
                this.iKJ.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iKJ.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iKJ.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void chp() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iKK.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iKK.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iKK.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iKK.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void chq() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iKL.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iKL.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iKL.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
