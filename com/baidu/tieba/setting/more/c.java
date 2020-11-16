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
/* loaded from: classes25.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private ArrayList<m> mHA;
    private ArrayList<m> mHB;
    private TbSettingTextTipView mHC;
    private final AdapterView.OnItemClickListener mHD;
    private final AdapterView.OnItemClickListener mHE;
    private final AdapterView.OnItemClickListener mHF;
    private final AdapterView.OnItemClickListener mHG;
    private BrowseSettingActivity mHo;
    private TbSettingTextTipView mHp;
    private TbSettingTextTipView mHq;
    private TbSettingTextTipView mHr;
    private TbSettingTextTipView mHs;
    private MsgSettingItemView mHt;
    private com.baidu.tbadk.core.dialog.e mHu;
    private com.baidu.tbadk.core.dialog.e mHv;
    private com.baidu.tbadk.core.dialog.e mHw;
    private com.baidu.tbadk.core.dialog.e mHx;
    private ArrayList<m> mHy;
    private ArrayList<m> mHz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mHo = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mHp = null;
        this.mHq = null;
        this.mHr = null;
        this.mHs = null;
        this.mHu = null;
        this.mHv = null;
        this.mHw = null;
        this.mHx = null;
        this.mHD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mHu.refresh(i);
                switch (i) {
                    case 0:
                        k.biL().setShowImages(true);
                        k.biL().nJ(0);
                        break;
                    case 1:
                        k.biL().setShowImages(true);
                        k.biL().nJ(1);
                        TiebaStatic.log(new ar("c10415").ak("obj_type", 1));
                        break;
                    case 2:
                        k.biL().setShowImages(true);
                        k.biL().nJ(2);
                        TiebaStatic.log(new ar("c10415").ak("obj_type", 3));
                        break;
                    case 3:
                        k.biL().setShowImages(false);
                        break;
                }
                c.this.mHu.dismiss();
                c.this.dDz();
            }
        };
        this.mHE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mHv.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ar("c10411").ak("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ar("c10411").ak("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ar("c10411").ak("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.mHo.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.biL().setImageWaterType(i2);
                c.this.Jl(i2);
            }
        };
        this.mHF = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mHw.refresh(i);
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
                c.this.dDB();
            }
        };
        this.mHG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mHx.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new ar("c11281").ak("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new ar("c11281").ak("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new ar("c11281").ak("obj_type", 3));
                        break;
                }
                c.this.dDC();
            }
        };
        this.mHo = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mHo.getLayoutMode().setNightMode(i == 1);
        this.mHo.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mHt.onChangeSkinType(this.mHo.getPageContext(), i);
        if (this.mHu != null) {
            this.mHu.onChangeSkinType();
        }
        if (this.mHv != null) {
            this.mHv.onChangeSkinType();
        }
        if (this.mHw != null) {
            this.mHw.onChangeSkinType();
        }
        if (this.mHx != null) {
            this.mHx.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dDl() {
        return this.mHq;
    }

    public TbSettingTextTipView dDm() {
        return this.mHp;
    }

    public TbSettingTextTipView dDn() {
        return this.mHr;
    }

    public TbSettingTextTipView dDo() {
        return this.mHs;
    }

    public void dDp() {
        dDw();
        this.mHv.bok();
    }

    public void dDq() {
        dDv();
        this.mHu.bok();
    }

    public void dDr() {
        dDx();
        this.mHw.bok();
    }

    public void dDs() {
        dDy();
        this.mHx.bok();
    }

    public TbSettingTextTipView dDt() {
        return this.mHC;
    }

    private void initUI() {
        this.mHo.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mHo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mHo.getPageContext().getString(R.string.browse_setting));
        this.mHC = (TbSettingTextTipView) this.mHo.findViewById(R.id.debug_tool_entrance);
        this.mHC.setBottomLineVisibility(true);
        this.mHp = (TbSettingTextTipView) this.mHo.findViewById(R.id.img_browser);
        this.mHp.setBottomLineVisibility(true);
        this.mHq = (TbSettingTextTipView) this.mHo.findViewById(R.id.add_img_water);
        this.mHq.setBottomLineVisibility(true);
        this.mHr = (TbSettingTextTipView) this.mHo.findViewById(R.id.font_size);
        this.mHr.setBottomLineVisibility(true);
        this.mHs = (TbSettingTextTipView) this.mHo.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.mHs.setText(R.string.video_gif_auto_play);
        } else {
            this.mHs.setText(R.string.video_auto_play);
        }
        this.mHs.setBottomLineVisibility(true);
        this.mHt = (MsgSettingItemView) this.mHo.findViewById(R.id.slide_anim_switch);
        this.mHt.setText(R.string.slide_anim_switch);
        this.mHt.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mHt.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bpu().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new ar("c13396").ak("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new ar("c13396").ak("obj_type", 2));
            }
        });
        this.mParent = this.mHo.findViewById(R.id.parent);
    }

    private void dDu() {
        this.mHC.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mHp.setOnClickListener(this.mHo);
        this.mHq.setOnClickListener(this.mHo);
        this.mHr.setOnClickListener(this.mHo);
        this.mHs.setOnClickListener(this.mHo);
        this.mHC.setOnClickListener(this.mHo);
    }

    private void dDv() {
        boolean z = true;
        this.mHz = new ArrayList<>();
        int viewImageQuality = k.biL().getViewImageQuality();
        boolean isShowImages = k.biL().isShowImages();
        this.mHz.add(new m(this.mHo.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mHo.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mHz.add(new m(this.mHo.getPageContext().getString(R.string.view_high), this.mHo.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mHz;
        String string = this.mHo.getPageContext().getString(R.string.view_low);
        String string2 = this.mHo.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mHu = new com.baidu.tbadk.core.dialog.e(this.mHo.getPageContext());
        this.mHu.oA(R.string.browser_image_quality);
        this.mHu.a(this.mHz, this.mHD).boj();
    }

    private void dDw() {
        this.mHA = new ArrayList<>();
        int imageWaterType = k.biL().getImageWaterType();
        this.mHA.add(new m(this.mHo.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.mHA.add(new m(this.mHo.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.mHA.add(new m(this.mHo.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mHv = new com.baidu.tbadk.core.dialog.e(this.mHo.getPageContext()).oA(R.string.add_image_water);
        this.mHv.a(this.mHA, this.mHE).boj();
    }

    private void dDx() {
        this.mHw = new com.baidu.tbadk.core.dialog.e(this.mHo.getPageContext());
        this.mHy = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mHy.add(new m(this.mHo.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mHy.add(new m(this.mHo.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mHy.add(new m(this.mHo.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mHy.add(new m(this.mHo.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mHw.oA(R.string.font_size);
        this.mHw.a(this.mHy, this.mHF);
        this.mHw.boj();
    }

    private void dDy() {
        this.mHx = new com.baidu.tbadk.core.dialog.e(this.mHo.getPageContext());
        this.mHB = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.mHB.add(new m(this.mHo.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.mHB.add(new m(this.mHo.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.mHB.add(new m(this.mHo.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mHx.oA(R.string.video_gif_auto_play);
        } else {
            this.mHx.oA(R.string.video_auto_play);
        }
        this.mHx.a(this.mHB, this.mHG);
        this.mHx.boj();
    }

    public void updateAll() {
        dDz();
        dDA();
        dDB();
        dDC();
        dDu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDz() {
        if (!k.biL().isShowImages()) {
            this.mHp.setTip(this.mContext.getString(R.string.close));
        } else if (k.biL().getViewImageQuality() == 1) {
            this.mHp.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.biL().getViewImageQuality() == 2) {
            this.mHp.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mHp.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dDA() {
        Jl(k.biL().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jl(int i) {
        switch (i) {
            case 0:
                this.mHq.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.mHq.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.mHq.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dDB() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mHr.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mHr.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mHr.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mHr.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dDC() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.mHs.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.mHs.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.mHs.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
