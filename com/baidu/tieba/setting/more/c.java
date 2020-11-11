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
    private BrowseSettingActivity mGP;
    private TbSettingTextTipView mGQ;
    private TbSettingTextTipView mGR;
    private TbSettingTextTipView mGS;
    private TbSettingTextTipView mGT;
    private MsgSettingItemView mGU;
    private com.baidu.tbadk.core.dialog.e mGV;
    private com.baidu.tbadk.core.dialog.e mGW;
    private com.baidu.tbadk.core.dialog.e mGX;
    private com.baidu.tbadk.core.dialog.e mGY;
    private ArrayList<m> mGZ;
    private ArrayList<m> mHa;
    private ArrayList<m> mHb;
    private ArrayList<m> mHc;
    private TbSettingTextTipView mHd;
    private final AdapterView.OnItemClickListener mHe;
    private final AdapterView.OnItemClickListener mHf;
    private final AdapterView.OnItemClickListener mHg;
    private final AdapterView.OnItemClickListener mHh;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mGP = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mGQ = null;
        this.mGR = null;
        this.mGS = null;
        this.mGT = null;
        this.mGV = null;
        this.mGW = null;
        this.mGX = null;
        this.mGY = null;
        this.mHe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mGV.refresh(i);
                switch (i) {
                    case 0:
                        k.bjH().setShowImages(true);
                        k.bjH().nN(0);
                        break;
                    case 1:
                        k.bjH().setShowImages(true);
                        k.bjH().nN(1);
                        TiebaStatic.log(new aq("c10415").al("obj_type", 1));
                        break;
                    case 2:
                        k.bjH().setShowImages(true);
                        k.bjH().nN(2);
                        TiebaStatic.log(new aq("c10415").al("obj_type", 3));
                        break;
                    case 3:
                        k.bjH().setShowImages(false);
                        break;
                }
                c.this.mGV.dismiss();
                c.this.dDU();
            }
        };
        this.mHf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mGW.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new aq("c10411").al("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new aq("c10411").al("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new aq("c10411").al("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.mGP.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bjH().setImageWaterType(i2);
                c.this.IK(i2);
            }
        };
        this.mHg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mGX.refresh(i);
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
                c.this.dDW();
            }
        };
        this.mHh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mGY.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new aq("c11281").al("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new aq("c11281").al("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new aq("c11281").al("obj_type", 3));
                        break;
                }
                c.this.dDX();
            }
        };
        this.mGP = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mGP.getLayoutMode().setNightMode(i == 1);
        this.mGP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mGU.onChangeSkinType(this.mGP.getPageContext(), i);
        if (this.mGV != null) {
            this.mGV.onChangeSkinType();
        }
        if (this.mGW != null) {
            this.mGW.onChangeSkinType();
        }
        if (this.mGX != null) {
            this.mGX.onChangeSkinType();
        }
        if (this.mGY != null) {
            this.mGY.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dDG() {
        return this.mGR;
    }

    public TbSettingTextTipView dDH() {
        return this.mGQ;
    }

    public TbSettingTextTipView dDI() {
        return this.mGS;
    }

    public TbSettingTextTipView dDJ() {
        return this.mGT;
    }

    public void dDK() {
        dDR();
        this.mGW.bpg();
    }

    public void dDL() {
        dDQ();
        this.mGV.bpg();
    }

    public void dDM() {
        dDS();
        this.mGX.bpg();
    }

    public void dDN() {
        dDT();
        this.mGY.bpg();
    }

    public TbSettingTextTipView dDO() {
        return this.mHd;
    }

    private void initUI() {
        this.mGP.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mGP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mGP.getPageContext().getString(R.string.browse_setting));
        this.mHd = (TbSettingTextTipView) this.mGP.findViewById(R.id.debug_tool_entrance);
        this.mHd.setBottomLineVisibility(true);
        this.mGQ = (TbSettingTextTipView) this.mGP.findViewById(R.id.img_browser);
        this.mGQ.setBottomLineVisibility(true);
        this.mGR = (TbSettingTextTipView) this.mGP.findViewById(R.id.add_img_water);
        this.mGR.setBottomLineVisibility(true);
        this.mGS = (TbSettingTextTipView) this.mGP.findViewById(R.id.font_size);
        this.mGS.setBottomLineVisibility(true);
        this.mGT = (TbSettingTextTipView) this.mGP.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.mGT.setText(R.string.video_gif_auto_play);
        } else {
            this.mGT.setText(R.string.video_auto_play);
        }
        this.mGT.setBottomLineVisibility(true);
        this.mGU = (MsgSettingItemView) this.mGP.findViewById(R.id.slide_anim_switch);
        this.mGU.setText(R.string.slide_anim_switch);
        this.mGU.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mGU.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").al("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").al("obj_type", 2));
            }
        });
        this.mParent = this.mGP.findViewById(R.id.parent);
    }

    private void dDP() {
        this.mHd.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mGQ.setOnClickListener(this.mGP);
        this.mGR.setOnClickListener(this.mGP);
        this.mGS.setOnClickListener(this.mGP);
        this.mGT.setOnClickListener(this.mGP);
        this.mHd.setOnClickListener(this.mGP);
    }

    private void dDQ() {
        boolean z = true;
        this.mHa = new ArrayList<>();
        int viewImageQuality = k.bjH().getViewImageQuality();
        boolean isShowImages = k.bjH().isShowImages();
        this.mHa.add(new m(this.mGP.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mGP.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mHa.add(new m(this.mGP.getPageContext().getString(R.string.view_high), this.mGP.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mHa;
        String string = this.mGP.getPageContext().getString(R.string.view_low);
        String string2 = this.mGP.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mGV = new com.baidu.tbadk.core.dialog.e(this.mGP.getPageContext());
        this.mGV.oE(R.string.browser_image_quality);
        this.mGV.a(this.mHa, this.mHe).bpf();
    }

    private void dDR() {
        this.mHb = new ArrayList<>();
        int imageWaterType = k.bjH().getImageWaterType();
        this.mHb.add(new m(this.mGP.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.mHb.add(new m(this.mGP.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.mHb.add(new m(this.mGP.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mGW = new com.baidu.tbadk.core.dialog.e(this.mGP.getPageContext()).oE(R.string.add_image_water);
        this.mGW.a(this.mHb, this.mHf).bpf();
    }

    private void dDS() {
        this.mGX = new com.baidu.tbadk.core.dialog.e(this.mGP.getPageContext());
        this.mGZ = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mGZ.add(new m(this.mGP.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mGZ.add(new m(this.mGP.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mGZ.add(new m(this.mGP.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mGZ.add(new m(this.mGP.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mGX.oE(R.string.font_size);
        this.mGX.a(this.mGZ, this.mHg);
        this.mGX.bpf();
    }

    private void dDT() {
        this.mGY = new com.baidu.tbadk.core.dialog.e(this.mGP.getPageContext());
        this.mHc = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.mHc.add(new m(this.mGP.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.mHc.add(new m(this.mGP.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.mHc.add(new m(this.mGP.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mGY.oE(R.string.video_gif_auto_play);
        } else {
            this.mGY.oE(R.string.video_auto_play);
        }
        this.mGY.a(this.mHc, this.mHh);
        this.mGY.bpf();
    }

    public void updateAll() {
        dDU();
        dDV();
        dDW();
        dDX();
        dDP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDU() {
        if (!k.bjH().isShowImages()) {
            this.mGQ.setTip(this.mContext.getString(R.string.close));
        } else if (k.bjH().getViewImageQuality() == 1) {
            this.mGQ.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bjH().getViewImageQuality() == 2) {
            this.mGQ.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mGQ.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dDV() {
        IK(k.bjH().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IK(int i) {
        switch (i) {
            case 0:
                this.mGR.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.mGR.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.mGR.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dDW() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mGS.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mGS.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mGS.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mGS.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dDX() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.mGT.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.mGT.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.mGT.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
