package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.t.bd;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity iUC;
    private TbSettingTextTipView iUD;
    private TbSettingTextTipView iUE;
    private TbSettingTextTipView iUF;
    private TbSettingTextTipView iUG;
    private MsgSettingItemView iUH;
    private com.baidu.tbadk.core.dialog.e iUI;
    private com.baidu.tbadk.core.dialog.e iUJ;
    private com.baidu.tbadk.core.dialog.e iUK;
    private com.baidu.tbadk.core.dialog.e iUL;
    private ArrayList<m> iUM;
    private ArrayList<m> iUN;
    private ArrayList<m> iUO;
    private ArrayList<m> iUP;
    private final AdapterView.OnItemClickListener iUQ;
    private final AdapterView.OnItemClickListener iUR;
    private final AdapterView.OnItemClickListener iUS;
    private final AdapterView.OnItemClickListener iUT;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iUC = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iUD = null;
        this.iUE = null;
        this.iUF = null;
        this.iUG = null;
        this.iUI = null;
        this.iUJ = null;
        this.iUK = null;
        this.iUL = null;
        this.iUQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iUI.refresh(i);
                switch (i) {
                    case 0:
                        i.ace().dF(true);
                        i.ace().gQ(0);
                        break;
                    case 1:
                        i.ace().dF(true);
                        i.ace().gQ(1);
                        TiebaStatic.log(new an("c10415").P("obj_type", 1));
                        break;
                    case 2:
                        i.ace().dF(true);
                        i.ace().gQ(2);
                        TiebaStatic.log(new an("c10415").P("obj_type", 3));
                        break;
                    case 3:
                        i.ace().dF(false);
                        break;
                }
                c.this.iUI.dismiss();
                c.this.clj();
            }
        };
        this.iUR = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iUJ.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").P("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").P("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").P("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.ace().gP(i2);
                c.this.Aq(i2);
            }
        };
        this.iUS = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iUK.refresh(i);
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
                c.this.cll();
            }
        };
        this.iUT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iUL.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").P("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").P("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").P("obj_type", 3));
                        break;
                }
                c.this.clm();
            }
        };
        this.iUC = browseSettingActivity;
        initUI();
        ajx();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iUC.getLayoutMode().setNightMode(i == 1);
        this.iUC.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iUH.onChangeSkinType(this.iUC.getPageContext(), i);
        if (this.iUI != null) {
            this.iUI.onChangeSkinType();
        }
        if (this.iUJ != null) {
            this.iUJ.onChangeSkinType();
        }
        if (this.iUK != null) {
            this.iUK.onChangeSkinType();
        }
        if (this.iUL != null) {
            this.iUL.onChangeSkinType();
        }
    }

    public TbSettingTextTipView ckX() {
        return this.iUE;
    }

    public TbSettingTextTipView ckY() {
        return this.iUD;
    }

    public TbSettingTextTipView ckZ() {
        return this.iUF;
    }

    public TbSettingTextTipView cla() {
        return this.iUG;
    }

    public void clb() {
        clg();
        this.iUJ.agT();
    }

    public void clc() {
        clf();
        this.iUI.agT();
    }

    public void cld() {
        clh();
        this.iUK.agT();
    }

    public void cle() {
        cli();
        this.iUL.agT();
    }

    private void initUI() {
        this.iUC.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iUC.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iUC.getPageContext().getString(R.string.browse_setting));
        this.iUD = (TbSettingTextTipView) this.iUC.findViewById(R.id.img_browser);
        this.iUD.setBottomLineVisibility(true);
        this.iUE = (TbSettingTextTipView) this.iUC.findViewById(R.id.add_img_water);
        this.iUE.setBottomLineVisibility(true);
        this.iUF = (TbSettingTextTipView) this.iUC.findViewById(R.id.font_size);
        this.iUF.setBottomLineVisibility(true);
        this.iUG = (TbSettingTextTipView) this.iUC.findViewById(R.id.video_auto_play);
        if (bd.iN()) {
            this.iUG.setText(R.string.video_gif_auto_play);
        } else {
            this.iUG.setText(R.string.video_auto_play);
        }
        this.iUG.setBottomLineVisibility(true);
        this.iUH = (MsgSettingItemView) this.iUC.findViewById(R.id.slide_anim_switch);
        this.iUH.setText(R.string.slide_anim_switch);
        this.iUH.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iUH.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").P("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").P("obj_type", 2));
            }
        });
        this.mParent = this.iUC.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iUD.setOnClickListener(this.iUC);
        this.iUE.setOnClickListener(this.iUC);
        this.iUF.setOnClickListener(this.iUC);
        this.iUG.setOnClickListener(this.iUC);
    }

    private void clf() {
        this.iUN = new ArrayList<>();
        int viewImageQuality = i.ace().getViewImageQuality();
        boolean aci = i.ace().aci();
        this.iUN.add(new m(this.iUC.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iUC.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), aci && viewImageQuality == 0));
        this.iUN.add(new m(this.iUC.getPageContext().getString(R.string.view_high), this.iUC.getPageContext().getString(R.string.view_image_quality_high_menu_desc), aci && viewImageQuality == 1));
        this.iUN.add(new m(this.iUC.getPageContext().getString(R.string.view_low), this.iUC.getPageContext().getString(R.string.view_image_quality_low_menu_desc), aci && viewImageQuality == 2));
        this.iUN.add(new m(this.iUC.getPageContext().getString(R.string.close), this.iUC.getPageContext().getString(R.string.view_image_quality_close_menu_desc), aci ? false : true));
        this.iUI = new com.baidu.tbadk.core.dialog.e(this.iUC.getPageContext());
        this.iUI.hE(R.string.browser_image_quality);
        this.iUI.a(this.iUN, this.iUQ).agS();
    }

    private void clg() {
        this.iUO = new ArrayList<>();
        int acg = i.ace().acg();
        this.iUO.add(new m(this.iUC.getPageContext().getString(R.string.image_water_show_user_name), null, acg == 1));
        this.iUO.add(new m(this.iUC.getPageContext().getString(R.string.image_water_show_forum_name), null, acg == 2));
        this.iUO.add(new m(this.iUC.getPageContext().getString(R.string.image_water_show_none), null, acg == 0));
        this.iUJ = new com.baidu.tbadk.core.dialog.e(this.iUC.getPageContext()).hE(R.string.add_image_water);
        this.iUJ.a(this.iUO, this.iUR).agS();
    }

    private void clh() {
        this.iUK = new com.baidu.tbadk.core.dialog.e(this.iUC.getPageContext());
        this.iUM = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iUM.add(new m(this.iUC.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iUM.add(new m(this.iUC.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iUM.add(new m(this.iUC.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iUM.add(new m(this.iUC.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iUK.hE(R.string.font_size);
        this.iUK.a(this.iUM, this.iUS);
        this.iUK.agS();
    }

    private void cli() {
        this.iUL = new com.baidu.tbadk.core.dialog.e(this.iUC.getPageContext());
        this.iUP = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iUP.add(new m(this.iUC.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iUP.add(new m(this.iUC.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iUP.add(new m(this.iUC.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.iN()) {
            this.iUL.hE(R.string.video_gif_auto_play);
        } else {
            this.iUL.hE(R.string.video_auto_play);
        }
        this.iUL.a(this.iUP, this.iUT);
        this.iUL.agS();
    }

    public void ajx() {
        clj();
        clk();
        cll();
        clm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clj() {
        if (!i.ace().aci()) {
            this.iUD.setTip(this.mContext.getString(R.string.close));
        } else if (i.ace().getViewImageQuality() == 1) {
            this.iUD.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.ace().getViewImageQuality() == 2) {
            this.iUD.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iUD.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void clk() {
        Aq(i.ace().acg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(int i) {
        switch (i) {
            case 0:
                this.iUE.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iUE.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iUE.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void cll() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iUF.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iUF.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iUF.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iUF.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void clm() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iUG.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iUG.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iUG.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
