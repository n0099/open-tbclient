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
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.base.d<BrowseSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private final AdapterView.OnItemClickListener mWA;
    private final AdapterView.OnItemClickListener mWB;
    private BrowseSettingActivity mWj;
    private TbSettingTextTipView mWk;
    private TbSettingTextTipView mWl;
    private TbSettingTextTipView mWm;
    private TbSettingTextTipView mWn;
    private MsgSettingItemView mWo;
    private com.baidu.tbadk.core.dialog.e mWp;
    private com.baidu.tbadk.core.dialog.e mWq;
    private com.baidu.tbadk.core.dialog.e mWr;
    private com.baidu.tbadk.core.dialog.e mWs;
    private ArrayList<m> mWt;
    private ArrayList<m> mWu;
    private ArrayList<m> mWv;
    private ArrayList<m> mWw;
    private TbSettingTextTipView mWx;
    private final AdapterView.OnItemClickListener mWy;
    private final AdapterView.OnItemClickListener mWz;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mWj = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mWk = null;
        this.mWl = null;
        this.mWm = null;
        this.mWn = null;
        this.mWp = null;
        this.mWq = null;
        this.mWr = null;
        this.mWs = null;
        this.mWy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mWp.refresh(i);
                switch (i) {
                    case 0:
                        k.bkB().setShowImages(true);
                        k.bkB().mL(0);
                        break;
                    case 1:
                        k.bkB().setShowImages(true);
                        k.bkB().mL(1);
                        TiebaStatic.log(new aq("c10415").an("obj_type", 1));
                        break;
                    case 2:
                        k.bkB().setShowImages(true);
                        k.bkB().mL(2);
                        TiebaStatic.log(new aq("c10415").an("obj_type", 3));
                        break;
                    case 3:
                        k.bkB().setShowImages(false);
                        break;
                }
                c.this.mWp.dismiss();
                c.this.dEJ();
            }
        };
        this.mWz = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mWq.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new aq("c10411").an("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new aq("c10411").an("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new aq("c10411").an("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.mWj.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bkB().setImageWaterType(i2);
                c.this.Ip(i2);
            }
        };
        this.mWA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mWr.refresh(i);
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
                c.this.dEL();
            }
        };
        this.mWB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mWs.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new aq("c11281").an("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new aq("c11281").an("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new aq("c11281").an("obj_type", 3));
                        break;
                }
                c.this.dEM();
            }
        };
        this.mWj = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mWj.getLayoutMode().setNightMode(i == 1);
        this.mWj.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mWo.onChangeSkinType(this.mWj.getPageContext(), i);
        if (this.mWp != null) {
            this.mWp.onChangeSkinType();
        }
        if (this.mWq != null) {
            this.mWq.onChangeSkinType();
        }
        if (this.mWr != null) {
            this.mWr.onChangeSkinType();
        }
        if (this.mWs != null) {
            this.mWs.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dEv() {
        return this.mWl;
    }

    public TbSettingTextTipView dEw() {
        return this.mWk;
    }

    public TbSettingTextTipView dEx() {
        return this.mWm;
    }

    public TbSettingTextTipView dEy() {
        return this.mWn;
    }

    public void dEz() {
        dEG();
        this.mWq.bqi();
    }

    public void dEA() {
        dEF();
        this.mWp.bqi();
    }

    public void dEB() {
        dEH();
        this.mWr.bqi();
    }

    public void dEC() {
        dEI();
        this.mWs.bqi();
    }

    public TbSettingTextTipView dED() {
        return this.mWx;
    }

    private void initUI() {
        this.mWj.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mWj.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mWj.getPageContext().getString(R.string.browse_setting));
        this.mWx = (TbSettingTextTipView) this.mWj.findViewById(R.id.debug_tool_entrance);
        this.mWx.setBottomLineVisibility(true);
        this.mWk = (TbSettingTextTipView) this.mWj.findViewById(R.id.img_browser);
        this.mWk.setBottomLineVisibility(true);
        this.mWl = (TbSettingTextTipView) this.mWj.findViewById(R.id.add_img_water);
        this.mWl.setBottomLineVisibility(true);
        this.mWm = (TbSettingTextTipView) this.mWj.findViewById(R.id.font_size);
        this.mWm.setBottomLineVisibility(true);
        this.mWn = (TbSettingTextTipView) this.mWj.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.mWn.setText(R.string.video_gif_auto_play);
        } else {
            this.mWn.setText(R.string.video_auto_play);
        }
        this.mWn.setBottomLineVisibility(true);
        this.mWo = (MsgSettingItemView) this.mWj.findViewById(R.id.slide_anim_switch);
        this.mWo.setText(R.string.slide_anim_switch);
        this.mWo.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mWo.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.brx().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").an("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").an("obj_type", 2));
            }
        });
        this.mParent = this.mWj.findViewById(R.id.parent);
    }

    private void dEE() {
        this.mWx.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mWk.setOnClickListener(this.mWj);
        this.mWl.setOnClickListener(this.mWj);
        this.mWm.setOnClickListener(this.mWj);
        this.mWn.setOnClickListener(this.mWj);
        this.mWx.setOnClickListener(this.mWj);
    }

    private void dEF() {
        boolean z = true;
        this.mWu = new ArrayList<>();
        int viewImageQuality = k.bkB().getViewImageQuality();
        boolean isShowImages = k.bkB().isShowImages();
        this.mWu.add(new m(this.mWj.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mWj.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mWu.add(new m(this.mWj.getPageContext().getString(R.string.view_high), this.mWj.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mWu;
        String string = this.mWj.getPageContext().getString(R.string.view_low);
        String string2 = this.mWj.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mWp = new com.baidu.tbadk.core.dialog.e(this.mWj.getPageContext());
        this.mWp.nC(R.string.browser_image_quality);
        this.mWp.a(this.mWu, this.mWy).bqh();
    }

    private void dEG() {
        this.mWv = new ArrayList<>();
        int imageWaterType = k.bkB().getImageWaterType();
        this.mWv.add(new m(this.mWj.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.mWv.add(new m(this.mWj.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.mWv.add(new m(this.mWj.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mWq = new com.baidu.tbadk.core.dialog.e(this.mWj.getPageContext()).nC(R.string.add_image_water);
        this.mWq.a(this.mWv, this.mWz).bqh();
    }

    private void dEH() {
        this.mWr = new com.baidu.tbadk.core.dialog.e(this.mWj.getPageContext());
        this.mWt = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mWt.add(new m(this.mWj.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mWt.add(new m(this.mWj.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mWt.add(new m(this.mWj.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mWt.add(new m(this.mWj.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mWr.nC(R.string.font_size);
        this.mWr.a(this.mWt, this.mWA);
        this.mWr.bqh();
    }

    private void dEI() {
        this.mWs = new com.baidu.tbadk.core.dialog.e(this.mWj.getPageContext());
        this.mWw = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.mWw.add(new m(this.mWj.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.mWw.add(new m(this.mWj.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.mWw.add(new m(this.mWj.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mWs.nC(R.string.video_gif_auto_play);
        } else {
            this.mWs.nC(R.string.video_auto_play);
        }
        this.mWs.a(this.mWw, this.mWB);
        this.mWs.bqh();
    }

    public void updateAll() {
        dEJ();
        dEK();
        dEL();
        dEM();
        dEE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEJ() {
        if (!k.bkB().isShowImages()) {
            this.mWk.setTip(this.mContext.getString(R.string.close));
        } else if (k.bkB().getViewImageQuality() == 1) {
            this.mWk.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bkB().getViewImageQuality() == 2) {
            this.mWk.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mWk.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dEK() {
        Ip(k.bkB().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip(int i) {
        switch (i) {
            case 0:
                this.mWl.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.mWl.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.mWl.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dEL() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mWm.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mWm.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mWm.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mWm.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dEM() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.mWn.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.mWn.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.mWn.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
