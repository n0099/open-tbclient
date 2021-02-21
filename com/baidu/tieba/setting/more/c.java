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
    private com.baidu.tbadk.core.dialog.e ngA;
    private com.baidu.tbadk.core.dialog.e ngB;
    private ArrayList<m> ngC;
    private ArrayList<m> ngD;
    private ArrayList<m> ngE;
    private ArrayList<m> ngF;
    private TbSettingTextTipView ngG;
    private final AdapterView.OnItemClickListener ngH;
    private final AdapterView.OnItemClickListener ngI;
    private final AdapterView.OnItemClickListener ngJ;
    private final AdapterView.OnItemClickListener ngK;
    private BrowseSettingActivity ngs;
    private TbSettingTextTipView ngt;
    private TbSettingTextTipView ngu;
    private TbSettingTextTipView ngv;
    private TbSettingTextTipView ngw;
    private MsgSettingItemView ngx;
    private com.baidu.tbadk.core.dialog.e ngy;
    private com.baidu.tbadk.core.dialog.e ngz;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.ngs = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.ngt = null;
        this.ngu = null;
        this.ngv = null;
        this.ngw = null;
        this.ngy = null;
        this.ngz = null;
        this.ngA = null;
        this.ngB = null;
        this.ngH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.ngy.refresh(i);
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
                c.this.ngy.dismiss();
                c.this.dHc();
            }
        };
        this.ngI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.ngz.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.ngs.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bkT().setImageWaterType(i2);
                c.this.IJ(i2);
            }
        };
        this.ngJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.ngA.refresh(i);
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
                c.this.dHe();
            }
        };
        this.ngK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.ngB.refresh(i);
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
                c.this.dHf();
            }
        };
        this.ngs = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.ngs.getLayoutMode().setNightMode(i == 1);
        this.ngs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ngx.onChangeSkinType(this.ngs.getPageContext(), i);
        if (this.ngy != null) {
            this.ngy.onChangeSkinType();
        }
        if (this.ngz != null) {
            this.ngz.onChangeSkinType();
        }
        if (this.ngA != null) {
            this.ngA.onChangeSkinType();
        }
        if (this.ngB != null) {
            this.ngB.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dGO() {
        return this.ngu;
    }

    public TbSettingTextTipView dGP() {
        return this.ngt;
    }

    public TbSettingTextTipView dGQ() {
        return this.ngv;
    }

    public TbSettingTextTipView dGR() {
        return this.ngw;
    }

    public void dGS() {
        dGZ();
        this.ngz.bqB();
    }

    public void dGT() {
        dGY();
        this.ngy.bqB();
    }

    public void dGU() {
        dHa();
        this.ngA.bqB();
    }

    public void dGV() {
        dHb();
        this.ngB.bqB();
    }

    public TbSettingTextTipView dGW() {
        return this.ngG;
    }

    private void initUI() {
        this.ngs.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.ngs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.ngs.getPageContext().getString(R.string.browse_setting));
        this.ngG = (TbSettingTextTipView) this.ngs.findViewById(R.id.debug_tool_entrance);
        this.ngG.setBottomLineVisibility(true);
        this.ngt = (TbSettingTextTipView) this.ngs.findViewById(R.id.img_browser);
        this.ngt.setBottomLineVisibility(true);
        this.ngu = (TbSettingTextTipView) this.ngs.findViewById(R.id.add_img_water);
        this.ngu.setBottomLineVisibility(true);
        this.ngv = (TbSettingTextTipView) this.ngs.findViewById(R.id.font_size);
        this.ngv.setBottomLineVisibility(true);
        this.ngw = (TbSettingTextTipView) this.ngs.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.ngw.setText(R.string.video_gif_auto_play);
        } else {
            this.ngw.setText(R.string.video_auto_play);
        }
        this.ngw.setBottomLineVisibility(true);
        this.ngx = (MsgSettingItemView) this.ngs.findViewById(R.id.slide_anim_switch);
        this.ngx.setText(R.string.slide_anim_switch);
        this.ngx.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.ngx.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.ngs.findViewById(R.id.parent);
    }

    private void dGX() {
        this.ngG.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.ngt.setOnClickListener(this.ngs);
        this.ngu.setOnClickListener(this.ngs);
        this.ngv.setOnClickListener(this.ngs);
        this.ngw.setOnClickListener(this.ngs);
        this.ngG.setOnClickListener(this.ngs);
    }

    private void dGY() {
        boolean z = true;
        this.ngD = new ArrayList<>();
        int viewImageQuality = k.bkT().getViewImageQuality();
        boolean isShowImages = k.bkT().isShowImages();
        this.ngD.add(new m(this.ngs.getPageContext().getString(R.string.view_image_quality_auto_menu), this.ngs.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.ngD.add(new m(this.ngs.getPageContext().getString(R.string.view_high), this.ngs.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.ngD;
        String string = this.ngs.getPageContext().getString(R.string.view_low);
        String string2 = this.ngs.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.ngy = new com.baidu.tbadk.core.dialog.e(this.ngs.getPageContext());
        this.ngy.nF(R.string.browser_image_quality);
        this.ngy.a(this.ngD, this.ngH).bqA();
    }

    private void dGZ() {
        this.ngE = new ArrayList<>();
        int imageWaterType = k.bkT().getImageWaterType();
        this.ngE.add(new m(this.ngs.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.ngE.add(new m(this.ngs.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.ngE.add(new m(this.ngs.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.ngz = new com.baidu.tbadk.core.dialog.e(this.ngs.getPageContext()).nF(R.string.add_image_water);
        this.ngz.a(this.ngE, this.ngI).bqA();
    }

    private void dHa() {
        this.ngA = new com.baidu.tbadk.core.dialog.e(this.ngs.getPageContext());
        this.ngC = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.ngC.add(new m(this.ngs.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.ngC.add(new m(this.ngs.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.ngC.add(new m(this.ngs.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.ngC.add(new m(this.ngs.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.ngA.nF(R.string.font_size);
        this.ngA.a(this.ngC, this.ngJ);
        this.ngA.bqA();
    }

    private void dHb() {
        this.ngB = new com.baidu.tbadk.core.dialog.e(this.ngs.getPageContext());
        this.ngF = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.ngF.add(new m(this.ngs.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.ngF.add(new m(this.ngs.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.ngF.add(new m(this.ngs.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.ngB.nF(R.string.video_gif_auto_play);
        } else {
            this.ngB.nF(R.string.video_auto_play);
        }
        this.ngB.a(this.ngF, this.ngK);
        this.ngB.bqA();
    }

    public void updateAll() {
        dHc();
        dHd();
        dHe();
        dHf();
        dGX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHc() {
        if (!k.bkT().isShowImages()) {
            this.ngt.setTip(this.mContext.getString(R.string.close));
        } else if (k.bkT().getViewImageQuality() == 1) {
            this.ngt.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bkT().getViewImageQuality() == 2) {
            this.ngt.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.ngt.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dHd() {
        IJ(k.bkT().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(int i) {
        switch (i) {
            case 0:
                this.ngu.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.ngu.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.ngu.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dHe() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.ngv.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.ngv.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.ngv.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.ngv.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dHf() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.ngw.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.ngw.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.ngw.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
