package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.s.ax;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity irR;
    private TbSettingTextTipView irS;
    private TbSettingTextTipView irT;
    private TbSettingTextTipView irU;
    private TbSettingTextTipView irV;
    private MsgSettingItemView irW;
    private com.baidu.tbadk.core.dialog.e irX;
    private com.baidu.tbadk.core.dialog.e irY;
    private com.baidu.tbadk.core.dialog.e irZ;
    private com.baidu.tbadk.core.dialog.e isa;
    private ArrayList<k> isb;
    private ArrayList<k> isc;
    private ArrayList<k> isd;
    private ArrayList<k> ise;
    private final AdapterView.OnItemClickListener isf;
    private final AdapterView.OnItemClickListener isg;
    private final AdapterView.OnItemClickListener ish;
    private final AdapterView.OnItemClickListener isi;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.irR = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.irS = null;
        this.irT = null;
        this.irU = null;
        this.irV = null;
        this.irX = null;
        this.irY = null;
        this.irZ = null;
        this.isa = null;
        this.isf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.irX.refresh(i);
                switch (i) {
                    case 0:
                        i.Wv().dg(true);
                        i.Wv().fZ(0);
                        break;
                    case 1:
                        i.Wv().dg(true);
                        i.Wv().fZ(1);
                        TiebaStatic.log(new am("c10415").T("obj_type", 1));
                        break;
                    case 2:
                        i.Wv().dg(true);
                        i.Wv().fZ(2);
                        TiebaStatic.log(new am("c10415").T("obj_type", 3));
                        break;
                    case 3:
                        i.Wv().dg(false);
                        break;
                }
                c.this.irX.dismiss();
                c.this.bZh();
            }
        };
        this.isg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.irY.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new am("c10411").T("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new am("c10411").T("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new am("c10411").T("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.Wv().fY(i2);
                c.this.yy(i2);
            }
        };
        this.ish = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.irZ.refresh(i);
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
                c.this.bZj();
            }
        };
        this.isi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.isa.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new am("c11281").T("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new am("c11281").T("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new am("c11281").T("obj_type", 3));
                        break;
                }
                c.this.bZk();
            }
        };
        this.irR = browseSettingActivity;
        initUI();
        adn();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.irR.getLayoutMode().setNightMode(i == 1);
        this.irR.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irW.onChangeSkinType(this.irR.getPageContext(), i);
    }

    public TbSettingTextTipView bYV() {
        return this.irT;
    }

    public TbSettingTextTipView bYW() {
        return this.irS;
    }

    public TbSettingTextTipView bYX() {
        return this.irU;
    }

    public TbSettingTextTipView bYY() {
        return this.irV;
    }

    public void bYZ() {
        bZe();
        this.irY.abb();
    }

    public void bZa() {
        bZd();
        this.irX.abb();
    }

    public void bZb() {
        bZf();
        this.irZ.abb();
    }

    public void bZc() {
        bZg();
        this.isa.abb();
    }

    private void initUI() {
        this.irR.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irR.getPageContext().getString(d.j.browse_setting));
        this.irS = (TbSettingTextTipView) this.irR.findViewById(d.g.img_browser);
        this.irS.setBottomLineVisibility(true);
        this.irT = (TbSettingTextTipView) this.irR.findViewById(d.g.add_img_water);
        this.irT.setBottomLineVisibility(true);
        this.irU = (TbSettingTextTipView) this.irR.findViewById(d.g.font_size);
        this.irU.setBottomLineVisibility(true);
        this.irV = (TbSettingTextTipView) this.irR.findViewById(d.g.video_auto_play);
        if (ax.jK()) {
            this.irV.setText(d.j.video_gif_auto_play);
        } else {
            this.irV.setText(d.j.video_auto_play);
        }
        this.irV.setBottomLineVisibility(true);
        this.irW = (MsgSettingItemView) this.irR.findViewById(d.g.slide_anim_switch);
        this.irW.setText(d.j.slide_anim_switch);
        this.irW.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.irW.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new am("c13396").T("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new am("c13396").T("obj_type", 2));
            }
        });
        this.mParent = this.irR.findViewById(d.g.parent);
    }

    private void initListener() {
        this.irS.setOnClickListener(this.irR);
        this.irT.setOnClickListener(this.irR);
        this.irU.setOnClickListener(this.irR);
        this.irV.setOnClickListener(this.irR);
    }

    private void bZd() {
        this.isc = new ArrayList<>();
        int viewImageQuality = i.Wv().getViewImageQuality();
        boolean Wz = i.Wv().Wz();
        this.isc.add(new k(this.irR.getPageContext().getString(d.j.view_image_quality_auto_menu), this.irR.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), Wz && viewImageQuality == 0));
        this.isc.add(new k(this.irR.getPageContext().getString(d.j.view_high), this.irR.getPageContext().getString(d.j.view_image_quality_high_menu_desc), Wz && viewImageQuality == 1));
        this.isc.add(new k(this.irR.getPageContext().getString(d.j.view_low), this.irR.getPageContext().getString(d.j.view_image_quality_low_menu_desc), Wz && viewImageQuality == 2));
        this.isc.add(new k(this.irR.getPageContext().getString(d.j.close), this.irR.getPageContext().getString(d.j.view_image_quality_close_menu_desc), Wz ? false : true));
        this.irX = new com.baidu.tbadk.core.dialog.e(this.irR.getPageContext());
        this.irX.gK(d.j.browser_image_quality);
        this.irX.a(this.isc, this.isf).aba();
    }

    private void bZe() {
        this.isd = new ArrayList<>();
        int Wx = i.Wv().Wx();
        this.isd.add(new k(this.irR.getPageContext().getString(d.j.image_water_show_user_name), null, Wx == 1));
        this.isd.add(new k(this.irR.getPageContext().getString(d.j.image_water_show_forum_name), null, Wx == 2));
        this.isd.add(new k(this.irR.getPageContext().getString(d.j.image_water_show_none), null, Wx == 0));
        this.irY = new com.baidu.tbadk.core.dialog.e(this.irR.getPageContext()).gK(d.j.add_image_water);
        this.irY.a(this.isd, this.isg).aba();
    }

    private void bZf() {
        this.irZ = new com.baidu.tbadk.core.dialog.e(this.irR.getPageContext());
        this.isb = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.isb.add(new k(this.irR.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.isb.add(new k(this.irR.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.isb.add(new k(this.irR.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.isb.add(new k(this.irR.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.irZ.gK(d.j.font_size);
        this.irZ.a(this.isb, this.ish);
        this.irZ.aba();
    }

    private void bZg() {
        this.isa = new com.baidu.tbadk.core.dialog.e(this.irR.getPageContext());
        this.ise = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.ise.add(new k(this.irR.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.ise.add(new k(this.irR.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.ise.add(new k(this.irR.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (ax.jK()) {
            this.isa.gK(d.j.video_gif_auto_play);
        } else {
            this.isa.gK(d.j.video_auto_play);
        }
        this.isa.a(this.ise, this.isi);
        this.isa.aba();
    }

    public void adn() {
        bZh();
        bZi();
        bZj();
        bZk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZh() {
        if (!i.Wv().Wz()) {
            this.irS.setTip(this.mContext.getString(d.j.close));
        } else if (i.Wv().getViewImageQuality() == 1) {
            this.irS.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.Wv().getViewImageQuality() == 2) {
            this.irS.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.irS.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bZi() {
        yy(i.Wv().Wx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(int i) {
        switch (i) {
            case 0:
                this.irT.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.irT.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.irT.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bZj() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.irU.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.irU.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.irU.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.irU.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bZk() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.irV.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.irV.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.irV.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
