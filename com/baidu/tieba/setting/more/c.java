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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d<BrowseSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private BrowseSettingActivity nfS;
    private TbSettingTextTipView nfT;
    private TbSettingTextTipView nfU;
    private TbSettingTextTipView nfV;
    private TbSettingTextTipView nfW;
    private MsgSettingItemView nfX;
    private com.baidu.tbadk.core.dialog.e nfY;
    private com.baidu.tbadk.core.dialog.e nfZ;
    private com.baidu.tbadk.core.dialog.e nga;
    private com.baidu.tbadk.core.dialog.e ngb;
    private ArrayList<m> ngc;
    private ArrayList<m> ngd;
    private ArrayList<m> nge;
    private ArrayList<m> ngf;
    private TbSettingTextTipView ngg;
    private final AdapterView.OnItemClickListener ngh;
    private final AdapterView.OnItemClickListener ngi;
    private final AdapterView.OnItemClickListener ngj;
    private final AdapterView.OnItemClickListener ngk;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.nfS = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.nfT = null;
        this.nfU = null;
        this.nfV = null;
        this.nfW = null;
        this.nfY = null;
        this.nfZ = null;
        this.nga = null;
        this.ngb = null;
        this.ngh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.nfY.refresh(i);
                switch (i) {
                    case 0:
                        k.bkT().setShowImages(true);
                        k.bkT().mO(0);
                        break;
                    case 1:
                        k.bkT().setShowImages(true);
                        k.bkT().mO(1);
                        TiebaStatic.log(new ar("c10415").ap("obj_type", 1));
                        break;
                    case 2:
                        k.bkT().setShowImages(true);
                        k.bkT().mO(2);
                        TiebaStatic.log(new ar("c10415").ap("obj_type", 3));
                        break;
                    case 3:
                        k.bkT().setShowImages(false);
                        break;
                }
                c.this.nfY.dismiss();
                c.this.dGU();
            }
        };
        this.ngi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.nfZ.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ar("c10411").ap("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ar("c10411").ap("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ar("c10411").ap("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.nfS.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bkT().setImageWaterType(i2);
                c.this.IJ(i2);
            }
        };
        this.ngj = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.nga.refresh(i);
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
                c.this.dGW();
            }
        };
        this.ngk = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.ngb.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new ar("c11281").ap("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new ar("c11281").ap("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new ar("c11281").ap("obj_type", 3));
                        break;
                }
                c.this.dGX();
            }
        };
        this.nfS = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.nfS.getLayoutMode().setNightMode(i == 1);
        this.nfS.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.nfX.onChangeSkinType(this.nfS.getPageContext(), i);
        if (this.nfY != null) {
            this.nfY.onChangeSkinType();
        }
        if (this.nfZ != null) {
            this.nfZ.onChangeSkinType();
        }
        if (this.nga != null) {
            this.nga.onChangeSkinType();
        }
        if (this.ngb != null) {
            this.ngb.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dGG() {
        return this.nfU;
    }

    public TbSettingTextTipView dGH() {
        return this.nfT;
    }

    public TbSettingTextTipView dGI() {
        return this.nfV;
    }

    public TbSettingTextTipView dGJ() {
        return this.nfW;
    }

    public void dGK() {
        dGR();
        this.nfZ.bqB();
    }

    public void dGL() {
        dGQ();
        this.nfY.bqB();
    }

    public void dGM() {
        dGS();
        this.nga.bqB();
    }

    public void dGN() {
        dGT();
        this.ngb.bqB();
    }

    public TbSettingTextTipView dGO() {
        return this.ngg;
    }

    private void initUI() {
        this.nfS.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.nfS.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.nfS.getPageContext().getString(R.string.browse_setting));
        this.ngg = (TbSettingTextTipView) this.nfS.findViewById(R.id.debug_tool_entrance);
        this.ngg.setBottomLineVisibility(true);
        this.nfT = (TbSettingTextTipView) this.nfS.findViewById(R.id.img_browser);
        this.nfT.setBottomLineVisibility(true);
        this.nfU = (TbSettingTextTipView) this.nfS.findViewById(R.id.add_img_water);
        this.nfU.setBottomLineVisibility(true);
        this.nfV = (TbSettingTextTipView) this.nfS.findViewById(R.id.font_size);
        this.nfV.setBottomLineVisibility(true);
        this.nfW = (TbSettingTextTipView) this.nfS.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.nfW.setText(R.string.video_gif_auto_play);
        } else {
            this.nfW.setText(R.string.video_auto_play);
        }
        this.nfW.setBottomLineVisibility(true);
        this.nfX = (MsgSettingItemView) this.nfS.findViewById(R.id.slide_anim_switch);
        this.nfX.setText(R.string.slide_anim_switch);
        this.nfX.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.nfX.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new ar("c13396").ap("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new ar("c13396").ap("obj_type", 2));
            }
        });
        this.mParent = this.nfS.findViewById(R.id.parent);
    }

    private void dGP() {
        this.ngg.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.nfT.setOnClickListener(this.nfS);
        this.nfU.setOnClickListener(this.nfS);
        this.nfV.setOnClickListener(this.nfS);
        this.nfW.setOnClickListener(this.nfS);
        this.ngg.setOnClickListener(this.nfS);
    }

    private void dGQ() {
        boolean z = true;
        this.ngd = new ArrayList<>();
        int viewImageQuality = k.bkT().getViewImageQuality();
        boolean isShowImages = k.bkT().isShowImages();
        this.ngd.add(new m(this.nfS.getPageContext().getString(R.string.view_image_quality_auto_menu), this.nfS.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.ngd.add(new m(this.nfS.getPageContext().getString(R.string.view_high), this.nfS.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.ngd;
        String string = this.nfS.getPageContext().getString(R.string.view_low);
        String string2 = this.nfS.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.nfY = new com.baidu.tbadk.core.dialog.e(this.nfS.getPageContext());
        this.nfY.nF(R.string.browser_image_quality);
        this.nfY.a(this.ngd, this.ngh).bqA();
    }

    private void dGR() {
        this.nge = new ArrayList<>();
        int imageWaterType = k.bkT().getImageWaterType();
        this.nge.add(new m(this.nfS.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.nge.add(new m(this.nfS.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.nge.add(new m(this.nfS.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.nfZ = new com.baidu.tbadk.core.dialog.e(this.nfS.getPageContext()).nF(R.string.add_image_water);
        this.nfZ.a(this.nge, this.ngi).bqA();
    }

    private void dGS() {
        this.nga = new com.baidu.tbadk.core.dialog.e(this.nfS.getPageContext());
        this.ngc = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.ngc.add(new m(this.nfS.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.ngc.add(new m(this.nfS.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.ngc.add(new m(this.nfS.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.ngc.add(new m(this.nfS.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.nga.nF(R.string.font_size);
        this.nga.a(this.ngc, this.ngj);
        this.nga.bqA();
    }

    private void dGT() {
        this.ngb = new com.baidu.tbadk.core.dialog.e(this.nfS.getPageContext());
        this.ngf = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.ngf.add(new m(this.nfS.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.ngf.add(new m(this.nfS.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.ngf.add(new m(this.nfS.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.ngb.nF(R.string.video_gif_auto_play);
        } else {
            this.ngb.nF(R.string.video_auto_play);
        }
        this.ngb.a(this.ngf, this.ngk);
        this.ngb.bqA();
    }

    public void updateAll() {
        dGU();
        dGV();
        dGW();
        dGX();
        dGP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGU() {
        if (!k.bkT().isShowImages()) {
            this.nfT.setTip(this.mContext.getString(R.string.close));
        } else if (k.bkT().getViewImageQuality() == 1) {
            this.nfT.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bkT().getViewImageQuality() == 2) {
            this.nfT.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.nfT.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dGV() {
        IJ(k.bkT().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(int i) {
        switch (i) {
            case 0:
                this.nfU.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.nfU.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.nfU.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dGW() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.nfV.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.nfV.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.nfV.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.nfV.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dGX() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.nfW.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.nfW.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.nfW.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
