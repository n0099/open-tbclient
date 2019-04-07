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
    private BrowseSettingActivity irQ;
    private TbSettingTextTipView irR;
    private TbSettingTextTipView irS;
    private TbSettingTextTipView irT;
    private TbSettingTextTipView irU;
    private MsgSettingItemView irV;
    private com.baidu.tbadk.core.dialog.e irW;
    private com.baidu.tbadk.core.dialog.e irX;
    private com.baidu.tbadk.core.dialog.e irY;
    private com.baidu.tbadk.core.dialog.e irZ;
    private ArrayList<k> isa;
    private ArrayList<k> isb;
    private ArrayList<k> isc;
    private ArrayList<k> isd;
    private final AdapterView.OnItemClickListener ise;
    private final AdapterView.OnItemClickListener isf;
    private final AdapterView.OnItemClickListener isg;
    private final AdapterView.OnItemClickListener ish;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.irQ = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.irR = null;
        this.irS = null;
        this.irT = null;
        this.irU = null;
        this.irW = null;
        this.irX = null;
        this.irY = null;
        this.irZ = null;
        this.ise = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.irW.refresh(i);
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
                c.this.irW.dismiss();
                c.this.bZh();
            }
        };
        this.isf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.irX.refresh(i);
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
        this.isg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.irY.refresh(i);
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
        this.ish = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.irZ.refresh(i);
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
        this.irQ = browseSettingActivity;
        initUI();
        adn();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.irQ.getLayoutMode().setNightMode(i == 1);
        this.irQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.irV.onChangeSkinType(this.irQ.getPageContext(), i);
    }

    public TbSettingTextTipView bYV() {
        return this.irS;
    }

    public TbSettingTextTipView bYW() {
        return this.irR;
    }

    public TbSettingTextTipView bYX() {
        return this.irT;
    }

    public TbSettingTextTipView bYY() {
        return this.irU;
    }

    public void bYZ() {
        bZe();
        this.irX.abb();
    }

    public void bZa() {
        bZd();
        this.irW.abb();
    }

    public void bZb() {
        bZf();
        this.irY.abb();
    }

    public void bZc() {
        bZg();
        this.irZ.abb();
    }

    private void initUI() {
        this.irQ.setContentView(d.h.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.irQ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.irQ.getPageContext().getString(d.j.browse_setting));
        this.irR = (TbSettingTextTipView) this.irQ.findViewById(d.g.img_browser);
        this.irR.setBottomLineVisibility(true);
        this.irS = (TbSettingTextTipView) this.irQ.findViewById(d.g.add_img_water);
        this.irS.setBottomLineVisibility(true);
        this.irT = (TbSettingTextTipView) this.irQ.findViewById(d.g.font_size);
        this.irT.setBottomLineVisibility(true);
        this.irU = (TbSettingTextTipView) this.irQ.findViewById(d.g.video_auto_play);
        if (ax.jK()) {
            this.irU.setText(d.j.video_gif_auto_play);
        } else {
            this.irU.setText(d.j.video_auto_play);
        }
        this.irU.setBottomLineVisibility(true);
        this.irV = (MsgSettingItemView) this.irQ.findViewById(d.g.slide_anim_switch);
        this.irV.setText(d.j.slide_anim_switch);
        this.irV.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.irV.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.irQ.findViewById(d.g.parent);
    }

    private void initListener() {
        this.irR.setOnClickListener(this.irQ);
        this.irS.setOnClickListener(this.irQ);
        this.irT.setOnClickListener(this.irQ);
        this.irU.setOnClickListener(this.irQ);
    }

    private void bZd() {
        this.isb = new ArrayList<>();
        int viewImageQuality = i.Wv().getViewImageQuality();
        boolean Wz = i.Wv().Wz();
        this.isb.add(new k(this.irQ.getPageContext().getString(d.j.view_image_quality_auto_menu), this.irQ.getPageContext().getString(d.j.view_image_quality_auto_menu_desc), Wz && viewImageQuality == 0));
        this.isb.add(new k(this.irQ.getPageContext().getString(d.j.view_high), this.irQ.getPageContext().getString(d.j.view_image_quality_high_menu_desc), Wz && viewImageQuality == 1));
        this.isb.add(new k(this.irQ.getPageContext().getString(d.j.view_low), this.irQ.getPageContext().getString(d.j.view_image_quality_low_menu_desc), Wz && viewImageQuality == 2));
        this.isb.add(new k(this.irQ.getPageContext().getString(d.j.close), this.irQ.getPageContext().getString(d.j.view_image_quality_close_menu_desc), Wz ? false : true));
        this.irW = new com.baidu.tbadk.core.dialog.e(this.irQ.getPageContext());
        this.irW.gK(d.j.browser_image_quality);
        this.irW.a(this.isb, this.ise).aba();
    }

    private void bZe() {
        this.isc = new ArrayList<>();
        int Wx = i.Wv().Wx();
        this.isc.add(new k(this.irQ.getPageContext().getString(d.j.image_water_show_user_name), null, Wx == 1));
        this.isc.add(new k(this.irQ.getPageContext().getString(d.j.image_water_show_forum_name), null, Wx == 2));
        this.isc.add(new k(this.irQ.getPageContext().getString(d.j.image_water_show_none), null, Wx == 0));
        this.irX = new com.baidu.tbadk.core.dialog.e(this.irQ.getPageContext()).gK(d.j.add_image_water);
        this.irX.a(this.isc, this.isf).aba();
    }

    private void bZf() {
        this.irY = new com.baidu.tbadk.core.dialog.e(this.irQ.getPageContext());
        this.isa = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.isa.add(new k(this.irQ.getPageContext().getString(d.j.font_size_xlarge), null, fontSize == 0));
        this.isa.add(new k(this.irQ.getPageContext().getString(d.j.font_size_big), null, fontSize == 1));
        this.isa.add(new k(this.irQ.getPageContext().getString(d.j.font_size_mid), null, fontSize == 2));
        this.isa.add(new k(this.irQ.getPageContext().getString(d.j.font_size_small), null, fontSize == 3));
        this.irY.gK(d.j.font_size);
        this.irY.a(this.isa, this.isg);
        this.irY.aba();
    }

    private void bZg() {
        this.irZ = new com.baidu.tbadk.core.dialog.e(this.irQ.getPageContext());
        this.isd = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.isd.add(new k(this.irQ.getPageContext().getString(d.j.video_auto_play_always), null, videoAutoPlay == 2));
        this.isd.add(new k(this.irQ.getPageContext().getString(d.j.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.isd.add(new k(this.irQ.getPageContext().getString(d.j.close), null, videoAutoPlay == 1));
        if (ax.jK()) {
            this.irZ.gK(d.j.video_gif_auto_play);
        } else {
            this.irZ.gK(d.j.video_auto_play);
        }
        this.irZ.a(this.isd, this.ish);
        this.irZ.aba();
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
            this.irR.setTip(this.mContext.getString(d.j.close));
        } else if (i.Wv().getViewImageQuality() == 1) {
            this.irR.setTip(this.mContext.getString(d.j.view_high));
        } else if (i.Wv().getViewImageQuality() == 2) {
            this.irR.setTip(this.mContext.getString(d.j.view_low));
        } else {
            this.irR.setTip(this.mContext.getString(d.j.view_image_quality_auto_menu));
        }
    }

    private void bZi() {
        yy(i.Wv().Wx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(int i) {
        switch (i) {
            case 0:
                this.irS.setTip(this.mContext.getString(d.j.image_water_show_none));
                return;
            case 1:
                this.irS.setTip(this.mContext.getString(d.j.image_water_show_user_name));
                return;
            case 2:
                this.irS.setTip(this.mContext.getString(d.j.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void bZj() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.irT.setTip(this.mContext.getString(d.j.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.irT.setTip(this.mContext.getString(d.j.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.irT.setTip(this.mContext.getString(d.j.font_size_mid));
        } else {
            this.irT.setTip(this.mContext.getString(d.j.font_size_small));
        }
    }

    public void bZk() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.irU.setTip(this.mContext.getString(d.j.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.irU.setTip(this.mContext.getString(d.j.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.irU.setTip(this.mContext.getString(d.j.video_auto_play_always));
        }
    }
}
