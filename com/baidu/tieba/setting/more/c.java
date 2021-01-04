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
/* loaded from: classes8.dex */
public class c extends com.baidu.adp.base.d<BrowseSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private BrowseSettingActivity naQ;
    private TbSettingTextTipView naR;
    private TbSettingTextTipView naS;
    private TbSettingTextTipView naT;
    private TbSettingTextTipView naU;
    private MsgSettingItemView naV;
    private com.baidu.tbadk.core.dialog.e naW;
    private com.baidu.tbadk.core.dialog.e naX;
    private com.baidu.tbadk.core.dialog.e naY;
    private com.baidu.tbadk.core.dialog.e naZ;
    private ArrayList<m> nba;
    private ArrayList<m> nbb;
    private ArrayList<m> nbc;
    private ArrayList<m> nbd;
    private TbSettingTextTipView nbe;
    private final AdapterView.OnItemClickListener nbf;
    private final AdapterView.OnItemClickListener nbg;
    private final AdapterView.OnItemClickListener nbh;
    private final AdapterView.OnItemClickListener nbi;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.naQ = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.naR = null;
        this.naS = null;
        this.naT = null;
        this.naU = null;
        this.naW = null;
        this.naX = null;
        this.naY = null;
        this.naZ = null;
        this.nbf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.naW.refresh(i);
                switch (i) {
                    case 0:
                        k.bou().setShowImages(true);
                        k.bou().or(0);
                        break;
                    case 1:
                        k.bou().setShowImages(true);
                        k.bou().or(1);
                        TiebaStatic.log(new aq("c10415").an("obj_type", 1));
                        break;
                    case 2:
                        k.bou().setShowImages(true);
                        k.bou().or(2);
                        TiebaStatic.log(new aq("c10415").an("obj_type", 3));
                        break;
                    case 3:
                        k.bou().setShowImages(false);
                        break;
                }
                c.this.naW.dismiss();
                c.this.dIA();
            }
        };
        this.nbg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.naX.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.naQ.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bou().setImageWaterType(i2);
                c.this.JW(i2);
            }
        };
        this.nbh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.naY.refresh(i);
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
                c.this.dIC();
            }
        };
        this.nbi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.naZ.refresh(i);
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
                c.this.dID();
            }
        };
        this.naQ = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.naQ.getLayoutMode().setNightMode(i == 1);
        this.naQ.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.naV.onChangeSkinType(this.naQ.getPageContext(), i);
        if (this.naW != null) {
            this.naW.onChangeSkinType();
        }
        if (this.naX != null) {
            this.naX.onChangeSkinType();
        }
        if (this.naY != null) {
            this.naY.onChangeSkinType();
        }
        if (this.naZ != null) {
            this.naZ.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dIm() {
        return this.naS;
    }

    public TbSettingTextTipView dIn() {
        return this.naR;
    }

    public TbSettingTextTipView dIo() {
        return this.naT;
    }

    public TbSettingTextTipView dIp() {
        return this.naU;
    }

    public void dIq() {
        dIx();
        this.naX.bub();
    }

    public void dIr() {
        dIw();
        this.naW.bub();
    }

    public void dIs() {
        dIy();
        this.naY.bub();
    }

    public void dIt() {
        dIz();
        this.naZ.bub();
    }

    public TbSettingTextTipView dIu() {
        return this.nbe;
    }

    private void initUI() {
        this.naQ.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.naQ.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.naQ.getPageContext().getString(R.string.browse_setting));
        this.nbe = (TbSettingTextTipView) this.naQ.findViewById(R.id.debug_tool_entrance);
        this.nbe.setBottomLineVisibility(true);
        this.naR = (TbSettingTextTipView) this.naQ.findViewById(R.id.img_browser);
        this.naR.setBottomLineVisibility(true);
        this.naS = (TbSettingTextTipView) this.naQ.findViewById(R.id.add_img_water);
        this.naS.setBottomLineVisibility(true);
        this.naT = (TbSettingTextTipView) this.naQ.findViewById(R.id.font_size);
        this.naT.setBottomLineVisibility(true);
        this.naU = (TbSettingTextTipView) this.naQ.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.naU.setText(R.string.video_gif_auto_play);
        } else {
            this.naU.setText(R.string.video_auto_play);
        }
        this.naU.setBottomLineVisibility(true);
        this.naV = (MsgSettingItemView) this.naQ.findViewById(R.id.slide_anim_switch);
        this.naV.setText(R.string.slide_anim_switch);
        this.naV.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.naV.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bvq().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").an("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").an("obj_type", 2));
            }
        });
        this.mParent = this.naQ.findViewById(R.id.parent);
    }

    private void dIv() {
        this.nbe.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.naR.setOnClickListener(this.naQ);
        this.naS.setOnClickListener(this.naQ);
        this.naT.setOnClickListener(this.naQ);
        this.naU.setOnClickListener(this.naQ);
        this.nbe.setOnClickListener(this.naQ);
    }

    private void dIw() {
        boolean z = true;
        this.nbb = new ArrayList<>();
        int viewImageQuality = k.bou().getViewImageQuality();
        boolean isShowImages = k.bou().isShowImages();
        this.nbb.add(new m(this.naQ.getPageContext().getString(R.string.view_image_quality_auto_menu), this.naQ.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.nbb.add(new m(this.naQ.getPageContext().getString(R.string.view_high), this.naQ.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.nbb;
        String string = this.naQ.getPageContext().getString(R.string.view_low);
        String string2 = this.naQ.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.naW = new com.baidu.tbadk.core.dialog.e(this.naQ.getPageContext());
        this.naW.pi(R.string.browser_image_quality);
        this.naW.a(this.nbb, this.nbf).bua();
    }

    private void dIx() {
        this.nbc = new ArrayList<>();
        int imageWaterType = k.bou().getImageWaterType();
        this.nbc.add(new m(this.naQ.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.nbc.add(new m(this.naQ.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.nbc.add(new m(this.naQ.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.naX = new com.baidu.tbadk.core.dialog.e(this.naQ.getPageContext()).pi(R.string.add_image_water);
        this.naX.a(this.nbc, this.nbg).bua();
    }

    private void dIy() {
        this.naY = new com.baidu.tbadk.core.dialog.e(this.naQ.getPageContext());
        this.nba = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.nba.add(new m(this.naQ.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.nba.add(new m(this.naQ.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.nba.add(new m(this.naQ.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.nba.add(new m(this.naQ.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.naY.pi(R.string.font_size);
        this.naY.a(this.nba, this.nbh);
        this.naY.bua();
    }

    private void dIz() {
        this.naZ = new com.baidu.tbadk.core.dialog.e(this.naQ.getPageContext());
        this.nbd = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.nbd.add(new m(this.naQ.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.nbd.add(new m(this.naQ.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.nbd.add(new m(this.naQ.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.naZ.pi(R.string.video_gif_auto_play);
        } else {
            this.naZ.pi(R.string.video_auto_play);
        }
        this.naZ.a(this.nbd, this.nbi);
        this.naZ.bua();
    }

    public void updateAll() {
        dIA();
        dIB();
        dIC();
        dID();
        dIv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIA() {
        if (!k.bou().isShowImages()) {
            this.naR.setTip(this.mContext.getString(R.string.close));
        } else if (k.bou().getViewImageQuality() == 1) {
            this.naR.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bou().getViewImageQuality() == 2) {
            this.naR.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.naR.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dIB() {
        JW(k.bou().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW(int i) {
        switch (i) {
            case 0:
                this.naS.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.naS.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.naS.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dIC() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.naT.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.naT.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.naT.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.naT.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dID() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.naU.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.naU.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.naU.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
