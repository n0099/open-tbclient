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
    private BrowseSettingActivity naP;
    private TbSettingTextTipView naQ;
    private TbSettingTextTipView naR;
    private TbSettingTextTipView naS;
    private TbSettingTextTipView naT;
    private MsgSettingItemView naU;
    private com.baidu.tbadk.core.dialog.e naV;
    private com.baidu.tbadk.core.dialog.e naW;
    private com.baidu.tbadk.core.dialog.e naX;
    private com.baidu.tbadk.core.dialog.e naY;
    private ArrayList<m> naZ;
    private ArrayList<m> nba;
    private ArrayList<m> nbb;
    private ArrayList<m> nbc;
    private TbSettingTextTipView nbd;
    private final AdapterView.OnItemClickListener nbe;
    private final AdapterView.OnItemClickListener nbf;
    private final AdapterView.OnItemClickListener nbg;
    private final AdapterView.OnItemClickListener nbh;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.naP = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.naQ = null;
        this.naR = null;
        this.naS = null;
        this.naT = null;
        this.naV = null;
        this.naW = null;
        this.naX = null;
        this.naY = null;
        this.nbe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.naV.refresh(i);
                switch (i) {
                    case 0:
                        k.bov().setShowImages(true);
                        k.bov().or(0);
                        break;
                    case 1:
                        k.bov().setShowImages(true);
                        k.bov().or(1);
                        TiebaStatic.log(new aq("c10415").an("obj_type", 1));
                        break;
                    case 2:
                        k.bov().setShowImages(true);
                        k.bov().or(2);
                        TiebaStatic.log(new aq("c10415").an("obj_type", 3));
                        break;
                    case 3:
                        k.bov().setShowImages(false);
                        break;
                }
                c.this.naV.dismiss();
                c.this.dIB();
            }
        };
        this.nbf = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.naW.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.naP.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bov().setImageWaterType(i2);
                c.this.JW(i2);
            }
        };
        this.nbg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.naX.refresh(i);
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
                c.this.dID();
            }
        };
        this.nbh = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.naY.refresh(i);
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
                c.this.dIE();
            }
        };
        this.naP = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.naP.getLayoutMode().setNightMode(i == 1);
        this.naP.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.naU.onChangeSkinType(this.naP.getPageContext(), i);
        if (this.naV != null) {
            this.naV.onChangeSkinType();
        }
        if (this.naW != null) {
            this.naW.onChangeSkinType();
        }
        if (this.naX != null) {
            this.naX.onChangeSkinType();
        }
        if (this.naY != null) {
            this.naY.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dIn() {
        return this.naR;
    }

    public TbSettingTextTipView dIo() {
        return this.naQ;
    }

    public TbSettingTextTipView dIp() {
        return this.naS;
    }

    public TbSettingTextTipView dIq() {
        return this.naT;
    }

    public void dIr() {
        dIy();
        this.naW.buc();
    }

    public void dIs() {
        dIx();
        this.naV.buc();
    }

    public void dIt() {
        dIz();
        this.naX.buc();
    }

    public void dIu() {
        dIA();
        this.naY.buc();
    }

    public TbSettingTextTipView dIv() {
        return this.nbd;
    }

    private void initUI() {
        this.naP.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.naP.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.naP.getPageContext().getString(R.string.browse_setting));
        this.nbd = (TbSettingTextTipView) this.naP.findViewById(R.id.debug_tool_entrance);
        this.nbd.setBottomLineVisibility(true);
        this.naQ = (TbSettingTextTipView) this.naP.findViewById(R.id.img_browser);
        this.naQ.setBottomLineVisibility(true);
        this.naR = (TbSettingTextTipView) this.naP.findViewById(R.id.add_img_water);
        this.naR.setBottomLineVisibility(true);
        this.naS = (TbSettingTextTipView) this.naP.findViewById(R.id.font_size);
        this.naS.setBottomLineVisibility(true);
        this.naT = (TbSettingTextTipView) this.naP.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.naT.setText(R.string.video_gif_auto_play);
        } else {
            this.naT.setText(R.string.video_auto_play);
        }
        this.naT.setBottomLineVisibility(true);
        this.naU = (MsgSettingItemView) this.naP.findViewById(R.id.slide_anim_switch);
        this.naU.setText(R.string.slide_anim_switch);
        this.naU.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.naU.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bvr().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").an("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").an("obj_type", 2));
            }
        });
        this.mParent = this.naP.findViewById(R.id.parent);
    }

    private void dIw() {
        this.nbd.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.naQ.setOnClickListener(this.naP);
        this.naR.setOnClickListener(this.naP);
        this.naS.setOnClickListener(this.naP);
        this.naT.setOnClickListener(this.naP);
        this.nbd.setOnClickListener(this.naP);
    }

    private void dIx() {
        boolean z = true;
        this.nba = new ArrayList<>();
        int viewImageQuality = k.bov().getViewImageQuality();
        boolean isShowImages = k.bov().isShowImages();
        this.nba.add(new m(this.naP.getPageContext().getString(R.string.view_image_quality_auto_menu), this.naP.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.nba.add(new m(this.naP.getPageContext().getString(R.string.view_high), this.naP.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.nba;
        String string = this.naP.getPageContext().getString(R.string.view_low);
        String string2 = this.naP.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.naV = new com.baidu.tbadk.core.dialog.e(this.naP.getPageContext());
        this.naV.pi(R.string.browser_image_quality);
        this.naV.a(this.nba, this.nbe).bub();
    }

    private void dIy() {
        this.nbb = new ArrayList<>();
        int imageWaterType = k.bov().getImageWaterType();
        this.nbb.add(new m(this.naP.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.nbb.add(new m(this.naP.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.nbb.add(new m(this.naP.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.naW = new com.baidu.tbadk.core.dialog.e(this.naP.getPageContext()).pi(R.string.add_image_water);
        this.naW.a(this.nbb, this.nbf).bub();
    }

    private void dIz() {
        this.naX = new com.baidu.tbadk.core.dialog.e(this.naP.getPageContext());
        this.naZ = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.naZ.add(new m(this.naP.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.naZ.add(new m(this.naP.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.naZ.add(new m(this.naP.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.naZ.add(new m(this.naP.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.naX.pi(R.string.font_size);
        this.naX.a(this.naZ, this.nbg);
        this.naX.bub();
    }

    private void dIA() {
        this.naY = new com.baidu.tbadk.core.dialog.e(this.naP.getPageContext());
        this.nbc = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.nbc.add(new m(this.naP.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.nbc.add(new m(this.naP.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.nbc.add(new m(this.naP.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.naY.pi(R.string.video_gif_auto_play);
        } else {
            this.naY.pi(R.string.video_auto_play);
        }
        this.naY.a(this.nbc, this.nbh);
        this.naY.bub();
    }

    public void updateAll() {
        dIB();
        dIC();
        dID();
        dIE();
        dIw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIB() {
        if (!k.bov().isShowImages()) {
            this.naQ.setTip(this.mContext.getString(R.string.close));
        } else if (k.bov().getViewImageQuality() == 1) {
            this.naQ.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bov().getViewImageQuality() == 2) {
            this.naQ.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.naQ.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dIC() {
        JW(k.bov().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW(int i) {
        switch (i) {
            case 0:
                this.naR.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.naR.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.naR.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dID() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.naS.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.naS.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.naS.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.naS.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dIE() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.naT.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.naT.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.naT.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
