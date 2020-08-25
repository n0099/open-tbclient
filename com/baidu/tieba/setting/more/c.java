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
/* loaded from: classes20.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private final AdapterView.OnItemClickListener lPA;
    private final AdapterView.OnItemClickListener lPB;
    private final AdapterView.OnItemClickListener lPC;
    private final AdapterView.OnItemClickListener lPD;
    private BrowseSettingActivity lPm;
    private TbSettingTextTipView lPn;
    private TbSettingTextTipView lPo;
    private TbSettingTextTipView lPp;
    private TbSettingTextTipView lPq;
    private MsgSettingItemView lPr;
    private com.baidu.tbadk.core.dialog.e lPs;
    private com.baidu.tbadk.core.dialog.e lPt;
    private com.baidu.tbadk.core.dialog.e lPu;
    private com.baidu.tbadk.core.dialog.e lPv;
    private ArrayList<m> lPw;
    private ArrayList<m> lPx;
    private ArrayList<m> lPy;
    private ArrayList<m> lPz;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.lPm = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.lPn = null;
        this.lPo = null;
        this.lPp = null;
        this.lPq = null;
        this.lPs = null;
        this.lPt = null;
        this.lPu = null;
        this.lPv = null;
        this.lPA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lPs.refresh(i);
                switch (i) {
                    case 0:
                        k.bbM().setShowImages(true);
                        k.bbM().mK(0);
                        break;
                    case 1:
                        k.bbM().setShowImages(true);
                        k.bbM().mK(1);
                        TiebaStatic.log(new aq("c10415").ai("obj_type", 1));
                        break;
                    case 2:
                        k.bbM().setShowImages(true);
                        k.bbM().mK(2);
                        TiebaStatic.log(new aq("c10415").ai("obj_type", 3));
                        break;
                    case 3:
                        k.bbM().setShowImages(false);
                        break;
                }
                c.this.lPs.dismiss();
                c.this.dqG();
            }
        };
        this.lPB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.lPt.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new aq("c10411").ai("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new aq("c10411").ai("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new aq("c10411").ai("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.lPm.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bbM().setImageWaterType(i2);
                c.this.GV(i2);
            }
        };
        this.lPC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lPu.refresh(i);
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
                c.this.dqI();
            }
        };
        this.lPD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.lPv.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new aq("c11281").ai("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new aq("c11281").ai("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new aq("c11281").ai("obj_type", 3));
                        break;
                }
                c.this.dqJ();
            }
        };
        this.lPm = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.lPm.getLayoutMode().setNightMode(i == 1);
        this.lPm.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.lPr.onChangeSkinType(this.lPm.getPageContext(), i);
        if (this.lPs != null) {
            this.lPs.onChangeSkinType();
        }
        if (this.lPt != null) {
            this.lPt.onChangeSkinType();
        }
        if (this.lPu != null) {
            this.lPu.onChangeSkinType();
        }
        if (this.lPv != null) {
            this.lPv.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dqu() {
        return this.lPo;
    }

    public TbSettingTextTipView dqv() {
        return this.lPn;
    }

    public TbSettingTextTipView dqw() {
        return this.lPp;
    }

    public TbSettingTextTipView dqx() {
        return this.lPq;
    }

    public void dqy() {
        dqD();
        this.lPt.bhk();
    }

    public void dqz() {
        dqC();
        this.lPs.bhk();
    }

    public void dqA() {
        dqE();
        this.lPu.bhk();
    }

    public void dqB() {
        dqF();
        this.lPv.bhk();
    }

    private void initUI() {
        this.lPm.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.lPm.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.lPm.getPageContext().getString(R.string.browse_setting));
        this.lPn = (TbSettingTextTipView) this.lPm.findViewById(R.id.img_browser);
        this.lPn.setBottomLineVisibility(true);
        this.lPo = (TbSettingTextTipView) this.lPm.findViewById(R.id.add_img_water);
        this.lPo.setBottomLineVisibility(true);
        this.lPp = (TbSettingTextTipView) this.lPm.findViewById(R.id.font_size);
        this.lPp.setBottomLineVisibility(true);
        this.lPq = (TbSettingTextTipView) this.lPm.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.lPq.setText(R.string.video_gif_auto_play);
        } else {
            this.lPq.setText(R.string.video_auto_play);
        }
        this.lPq.setBottomLineVisibility(true);
        this.lPr = (MsgSettingItemView) this.lPm.findViewById(R.id.slide_anim_switch);
        this.lPr.setText(R.string.slide_anim_switch);
        this.lPr.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.lPr.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bik().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").ai("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").ai("obj_type", 2));
            }
        });
        this.mParent = this.lPm.findViewById(R.id.parent);
    }

    private void initListener() {
        this.lPn.setOnClickListener(this.lPm);
        this.lPo.setOnClickListener(this.lPm);
        this.lPp.setOnClickListener(this.lPm);
        this.lPq.setOnClickListener(this.lPm);
    }

    private void dqC() {
        this.lPx = new ArrayList<>();
        int viewImageQuality = k.bbM().getViewImageQuality();
        boolean isShowImages = k.bbM().isShowImages();
        this.lPx.add(new m(this.lPm.getPageContext().getString(R.string.view_image_quality_auto_menu), this.lPm.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.lPx.add(new m(this.lPm.getPageContext().getString(R.string.view_high), this.lPm.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        this.lPx.add(new m(this.lPm.getPageContext().getString(R.string.view_low), this.lPm.getPageContext().getString(R.string.view_image_quality_low_menu_desc), isShowImages && viewImageQuality == 2));
        this.lPx.add(new m(this.lPm.getPageContext().getString(R.string.close), this.lPm.getPageContext().getString(R.string.view_image_quality_close_menu_desc), isShowImages ? false : true));
        this.lPs = new com.baidu.tbadk.core.dialog.e(this.lPm.getPageContext());
        this.lPs.nA(R.string.browser_image_quality);
        this.lPs.a(this.lPx, this.lPA).bhj();
    }

    private void dqD() {
        this.lPy = new ArrayList<>();
        int imageWaterType = k.bbM().getImageWaterType();
        this.lPy.add(new m(this.lPm.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.lPy.add(new m(this.lPm.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.lPy.add(new m(this.lPm.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.lPt = new com.baidu.tbadk.core.dialog.e(this.lPm.getPageContext()).nA(R.string.add_image_water);
        this.lPt.a(this.lPy, this.lPB).bhj();
    }

    private void dqE() {
        this.lPu = new com.baidu.tbadk.core.dialog.e(this.lPm.getPageContext());
        this.lPw = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.lPw.add(new m(this.lPm.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.lPw.add(new m(this.lPm.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.lPw.add(new m(this.lPm.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.lPw.add(new m(this.lPm.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.lPu.nA(R.string.font_size);
        this.lPu.a(this.lPw, this.lPC);
        this.lPu.bhj();
    }

    private void dqF() {
        this.lPv = new com.baidu.tbadk.core.dialog.e(this.lPm.getPageContext());
        this.lPz = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.lPz.add(new m(this.lPm.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.lPz.add(new m(this.lPm.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.lPz.add(new m(this.lPm.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.lPv.nA(R.string.video_gif_auto_play);
        } else {
            this.lPv.nA(R.string.video_auto_play);
        }
        this.lPv.a(this.lPz, this.lPD);
        this.lPv.bhj();
    }

    public void updateAll() {
        dqG();
        dqH();
        dqI();
        dqJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqG() {
        if (!k.bbM().isShowImages()) {
            this.lPn.setTip(this.mContext.getString(R.string.close));
        } else if (k.bbM().getViewImageQuality() == 1) {
            this.lPn.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bbM().getViewImageQuality() == 2) {
            this.lPn.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.lPn.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dqH() {
        GV(k.bbM().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV(int i) {
        switch (i) {
            case 0:
                this.lPo.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.lPo.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.lPo.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dqI() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.lPp.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.lPp.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.lPp.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.lPp.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dqJ() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.lPq.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.lPq.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.lPq.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
