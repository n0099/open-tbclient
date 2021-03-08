package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.d<BrowseSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private TbSettingTextTipView niA;
    private TbSettingTextTipView niB;
    private MsgSettingItemView niC;
    private com.baidu.tbadk.core.dialog.e niD;
    private com.baidu.tbadk.core.dialog.e niE;
    private com.baidu.tbadk.core.dialog.e niF;
    private com.baidu.tbadk.core.dialog.e niG;
    private ArrayList<m> niH;
    private ArrayList<m> niI;
    private ArrayList<m> niJ;
    private ArrayList<m> niK;
    private TbSettingTextTipView niL;
    private final AdapterView.OnItemClickListener niM;
    private final AdapterView.OnItemClickListener niN;
    private final AdapterView.OnItemClickListener niO;
    private final AdapterView.OnItemClickListener niP;
    private BrowseSettingActivity nix;
    private TbSettingTextTipView niy;
    private TbSettingTextTipView niz;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.nix = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.niy = null;
        this.niz = null;
        this.niA = null;
        this.niB = null;
        this.niD = null;
        this.niE = null;
        this.niF = null;
        this.niG = null;
        this.niM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.niD.refresh(i);
                switch (i) {
                    case 0:
                        k.bkV().setShowImages(true);
                        k.bkV().mP(0);
                        break;
                    case 1:
                        k.bkV().setShowImages(true);
                        k.bkV().mP(1);
                        TiebaStatic.log(new ar("c10415").aq("obj_type", 1));
                        break;
                    case 2:
                        k.bkV().setShowImages(true);
                        k.bkV().mP(2);
                        TiebaStatic.log(new ar("c10415").aq("obj_type", 3));
                        break;
                    case 3:
                        k.bkV().setShowImages(false);
                        break;
                }
                c.this.niD.dismiss();
                c.this.dHk();
            }
        };
        this.niN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.niE.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ar("c10411").aq("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ar("c10411").aq("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ar("c10411").aq("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.nix.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bkV().setImageWaterType(i2);
                c.this.IN(i2);
            }
        };
        this.niO = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.niF.refresh(i);
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
                c.this.dHm();
            }
        };
        this.niP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.niG.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new ar("c11281").aq("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new ar("c11281").aq("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new ar("c11281").aq("obj_type", 3));
                        break;
                }
                c.this.dHn();
            }
        };
        this.nix = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.nix.getLayoutMode().setNightMode(i == 1);
        this.nix.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.niC.onChangeSkinType(this.nix.getPageContext(), i);
        if (this.niD != null) {
            this.niD.onChangeSkinType();
        }
        if (this.niE != null) {
            this.niE.onChangeSkinType();
        }
        if (this.niF != null) {
            this.niF.onChangeSkinType();
        }
        if (this.niG != null) {
            this.niG.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dGW() {
        return this.niz;
    }

    public TbSettingTextTipView dGX() {
        return this.niy;
    }

    public TbSettingTextTipView dGY() {
        return this.niA;
    }

    public TbSettingTextTipView dGZ() {
        return this.niB;
    }

    public void dHa() {
        dHh();
        this.niE.bqD();
    }

    public void dHb() {
        dHg();
        this.niD.bqD();
    }

    public void dHc() {
        dHi();
        this.niF.bqD();
    }

    public void dHd() {
        dHj();
        this.niG.bqD();
    }

    public TbSettingTextTipView dHe() {
        return this.niL;
    }

    private void initUI() {
        this.nix.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.nix.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nix.getPageContext().getString(R.string.browse_setting));
        this.niL = (TbSettingTextTipView) this.nix.findViewById(R.id.debug_tool_entrance);
        this.niL.setBottomLineVisibility(true);
        this.niy = (TbSettingTextTipView) this.nix.findViewById(R.id.img_browser);
        this.niy.setBottomLineVisibility(true);
        this.niz = (TbSettingTextTipView) this.nix.findViewById(R.id.add_img_water);
        this.niz.setBottomLineVisibility(true);
        this.niA = (TbSettingTextTipView) this.nix.findViewById(R.id.font_size);
        this.niA.setBottomLineVisibility(true);
        this.niB = (TbSettingTextTipView) this.nix.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.niB.setText(R.string.video_gif_auto_play);
        } else {
            this.niB.setText(R.string.video_auto_play);
        }
        this.niB.setBottomLineVisibility(true);
        this.niC = (MsgSettingItemView) this.nix.findViewById(R.id.slide_anim_switch);
        this.niC.setText(R.string.slide_anim_switch);
        this.niC.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.niC.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.brR().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new ar("c13396").aq("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new ar("c13396").aq("obj_type", 2));
            }
        });
        this.mParent = this.nix.findViewById(R.id.parent);
    }

    private void dHf() {
        this.niL.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.niy.setOnClickListener(this.nix);
        this.niz.setOnClickListener(this.nix);
        this.niA.setOnClickListener(this.nix);
        this.niB.setOnClickListener(this.nix);
        this.niL.setOnClickListener(this.nix);
    }

    private void dHg() {
        boolean z = true;
        this.niI = new ArrayList<>();
        int viewImageQuality = k.bkV().getViewImageQuality();
        boolean isShowImages = k.bkV().isShowImages();
        this.niI.add(new m(this.nix.getPageContext().getString(R.string.view_image_quality_auto_menu), this.nix.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.niI.add(new m(this.nix.getPageContext().getString(R.string.view_high), this.nix.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.niI;
        String string = this.nix.getPageContext().getString(R.string.view_low);
        String string2 = this.nix.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.niD = new com.baidu.tbadk.core.dialog.e(this.nix.getPageContext());
        this.niD.nG(R.string.browser_image_quality);
        this.niD.a(this.niI, this.niM).bqC();
    }

    private void dHh() {
        this.niJ = new ArrayList<>();
        int imageWaterType = k.bkV().getImageWaterType();
        this.niJ.add(new m(this.nix.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.niJ.add(new m(this.nix.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.niJ.add(new m(this.nix.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.niE = new com.baidu.tbadk.core.dialog.e(this.nix.getPageContext()).nG(R.string.add_image_water);
        this.niE.a(this.niJ, this.niN).bqC();
    }

    private void dHi() {
        this.niF = new com.baidu.tbadk.core.dialog.e(this.nix.getPageContext());
        this.niH = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.niH.add(new m(this.nix.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.niH.add(new m(this.nix.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.niH.add(new m(this.nix.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.niH.add(new m(this.nix.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.niF.nG(R.string.font_size);
        this.niF.a(this.niH, this.niO);
        this.niF.bqC();
    }

    private void dHj() {
        this.niG = new com.baidu.tbadk.core.dialog.e(this.nix.getPageContext());
        this.niK = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.niK.add(new m(this.nix.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.niK.add(new m(this.nix.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.niK.add(new m(this.nix.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.niG.nG(R.string.video_gif_auto_play);
        } else {
            this.niG.nG(R.string.video_auto_play);
        }
        this.niG.a(this.niK, this.niP);
        this.niG.bqC();
    }

    public void updateAll() {
        dHk();
        dHl();
        dHm();
        dHn();
        dHf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHk() {
        if (!k.bkV().isShowImages()) {
            this.niy.setTip(this.mContext.getString(R.string.close));
        } else if (k.bkV().getViewImageQuality() == 1) {
            this.niy.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bkV().getViewImageQuality() == 2) {
            this.niy.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.niy.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dHl() {
        IN(k.bkV().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN(int i) {
        switch (i) {
            case 0:
                this.niz.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.niz.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.niz.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dHm() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.niA.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.niA.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.niA.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.niA.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dHn() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.niB.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.niB.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.niB.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
