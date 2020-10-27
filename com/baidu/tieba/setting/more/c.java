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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.switchs.RichTextGifViewSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity mAM;
    private TbSettingTextTipView mAN;
    private TbSettingTextTipView mAO;
    private TbSettingTextTipView mAP;
    private TbSettingTextTipView mAQ;
    private MsgSettingItemView mAR;
    private com.baidu.tbadk.core.dialog.e mAS;
    private com.baidu.tbadk.core.dialog.e mAT;
    private com.baidu.tbadk.core.dialog.e mAU;
    private com.baidu.tbadk.core.dialog.e mAV;
    private ArrayList<m> mAW;
    private ArrayList<m> mAX;
    private ArrayList<m> mAY;
    private ArrayList<m> mAZ;
    private TbSettingTextTipView mBa;
    private final AdapterView.OnItemClickListener mBb;
    private final AdapterView.OnItemClickListener mBc;
    private final AdapterView.OnItemClickListener mBd;
    private final AdapterView.OnItemClickListener mBe;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mAM = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mAN = null;
        this.mAO = null;
        this.mAP = null;
        this.mAQ = null;
        this.mAS = null;
        this.mAT = null;
        this.mAU = null;
        this.mAV = null;
        this.mBb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mAS.refresh(i);
                switch (i) {
                    case 0:
                        k.bhh().setShowImages(true);
                        k.bhh().nD(0);
                        break;
                    case 1:
                        k.bhh().setShowImages(true);
                        k.bhh().nD(1);
                        TiebaStatic.log(new aq("c10415").aj("obj_type", 1));
                        break;
                    case 2:
                        k.bhh().setShowImages(true);
                        k.bhh().nD(2);
                        TiebaStatic.log(new aq("c10415").aj("obj_type", 3));
                        break;
                    case 3:
                        k.bhh().setShowImages(false);
                        break;
                }
                c.this.mAS.dismiss();
                c.this.dBs();
            }
        };
        this.mBc = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mAT.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new aq("c10411").aj("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new aq("c10411").aj("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new aq("c10411").aj("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.mAM.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bhh().setImageWaterType(i2);
                c.this.Ix(i2);
            }
        };
        this.mBd = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mAU.refresh(i);
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
                c.this.dBu();
            }
        };
        this.mBe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mAV.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new aq("c11281").aj("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new aq("c11281").aj("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new aq("c11281").aj("obj_type", 3));
                        break;
                }
                c.this.dBv();
            }
        };
        this.mAM = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mAM.getLayoutMode().setNightMode(i == 1);
        this.mAM.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mAR.onChangeSkinType(this.mAM.getPageContext(), i);
        if (this.mAS != null) {
            this.mAS.onChangeSkinType();
        }
        if (this.mAT != null) {
            this.mAT.onChangeSkinType();
        }
        if (this.mAU != null) {
            this.mAU.onChangeSkinType();
        }
        if (this.mAV != null) {
            this.mAV.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dBe() {
        return this.mAO;
    }

    public TbSettingTextTipView dBf() {
        return this.mAN;
    }

    public TbSettingTextTipView dBg() {
        return this.mAP;
    }

    public TbSettingTextTipView dBh() {
        return this.mAQ;
    }

    public void dBi() {
        dBp();
        this.mAT.bmG();
    }

    public void dBj() {
        dBo();
        this.mAS.bmG();
    }

    public void dBk() {
        dBq();
        this.mAU.bmG();
    }

    public void dBl() {
        dBr();
        this.mAV.bmG();
    }

    public TbSettingTextTipView dBm() {
        return this.mBa;
    }

    private void initUI() {
        this.mAM.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mAM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mAM.getPageContext().getString(R.string.browse_setting));
        this.mBa = (TbSettingTextTipView) this.mAM.findViewById(R.id.debug_tool_entrance);
        this.mBa.setBottomLineVisibility(true);
        this.mAN = (TbSettingTextTipView) this.mAM.findViewById(R.id.img_browser);
        this.mAN.setBottomLineVisibility(true);
        this.mAO = (TbSettingTextTipView) this.mAM.findViewById(R.id.add_img_water);
        this.mAO.setBottomLineVisibility(true);
        this.mAP = (TbSettingTextTipView) this.mAM.findViewById(R.id.font_size);
        this.mAP.setBottomLineVisibility(true);
        this.mAQ = (TbSettingTextTipView) this.mAM.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.mAQ.setText(R.string.video_gif_auto_play);
        } else {
            this.mAQ.setText(R.string.video_auto_play);
        }
        this.mAQ.setBottomLineVisibility(true);
        this.mAR = (MsgSettingItemView) this.mAM.findViewById(R.id.slide_anim_switch);
        this.mAR.setText(R.string.slide_anim_switch);
        this.mAR.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mAR.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bnH().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").aj("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").aj("obj_type", 2));
            }
        });
        this.mParent = this.mAM.findViewById(R.id.parent);
    }

    private void dBn() {
        this.mBa.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mAN.setOnClickListener(this.mAM);
        this.mAO.setOnClickListener(this.mAM);
        this.mAP.setOnClickListener(this.mAM);
        this.mAQ.setOnClickListener(this.mAM);
        this.mBa.setOnClickListener(this.mAM);
    }

    private void dBo() {
        boolean z = true;
        this.mAX = new ArrayList<>();
        int viewImageQuality = k.bhh().getViewImageQuality();
        boolean isShowImages = k.bhh().isShowImages();
        this.mAX.add(new m(this.mAM.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mAM.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mAX.add(new m(this.mAM.getPageContext().getString(R.string.view_high), this.mAM.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mAX;
        String string = this.mAM.getPageContext().getString(R.string.view_low);
        String string2 = this.mAM.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mAS = new com.baidu.tbadk.core.dialog.e(this.mAM.getPageContext());
        this.mAS.ou(R.string.browser_image_quality);
        this.mAS.a(this.mAX, this.mBb).bmF();
    }

    private void dBp() {
        this.mAY = new ArrayList<>();
        int imageWaterType = k.bhh().getImageWaterType();
        this.mAY.add(new m(this.mAM.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.mAY.add(new m(this.mAM.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.mAY.add(new m(this.mAM.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mAT = new com.baidu.tbadk.core.dialog.e(this.mAM.getPageContext()).ou(R.string.add_image_water);
        this.mAT.a(this.mAY, this.mBc).bmF();
    }

    private void dBq() {
        this.mAU = new com.baidu.tbadk.core.dialog.e(this.mAM.getPageContext());
        this.mAW = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mAW.add(new m(this.mAM.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mAW.add(new m(this.mAM.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mAW.add(new m(this.mAM.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mAW.add(new m(this.mAM.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mAU.ou(R.string.font_size);
        this.mAU.a(this.mAW, this.mBd);
        this.mAU.bmF();
    }

    private void dBr() {
        this.mAV = new com.baidu.tbadk.core.dialog.e(this.mAM.getPageContext());
        this.mAZ = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.mAZ.add(new m(this.mAM.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.mAZ.add(new m(this.mAM.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.mAZ.add(new m(this.mAM.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mAV.ou(R.string.video_gif_auto_play);
        } else {
            this.mAV.ou(R.string.video_auto_play);
        }
        this.mAV.a(this.mAZ, this.mBe);
        this.mAV.bmF();
    }

    public void updateAll() {
        dBs();
        dBt();
        dBu();
        dBv();
        dBn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBs() {
        if (!k.bhh().isShowImages()) {
            this.mAN.setTip(this.mContext.getString(R.string.close));
        } else if (k.bhh().getViewImageQuality() == 1) {
            this.mAN.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bhh().getViewImageQuality() == 2) {
            this.mAN.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mAN.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dBt() {
        Ix(k.bhh().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix(int i) {
        switch (i) {
            case 0:
                this.mAO.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.mAO.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.mAO.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dBu() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mAP.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mAP.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mAP.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mAP.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dBv() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.mAQ.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.mAQ.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.mAQ.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
