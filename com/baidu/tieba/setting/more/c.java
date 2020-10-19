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
    private NavigationBar mNavigationBar;
    private View mParent;
    private TbSettingTextTipView moA;
    private final AdapterView.OnItemClickListener moB;
    private final AdapterView.OnItemClickListener moC;
    private final AdapterView.OnItemClickListener moD;
    private final AdapterView.OnItemClickListener moE;
    private BrowseSettingActivity mol;
    private TbSettingTextTipView mom;
    private TbSettingTextTipView moo;
    private TbSettingTextTipView mop;
    private TbSettingTextTipView moq;
    private MsgSettingItemView mor;
    private com.baidu.tbadk.core.dialog.e mos;
    private com.baidu.tbadk.core.dialog.e mot;
    private com.baidu.tbadk.core.dialog.e mou;
    private com.baidu.tbadk.core.dialog.e mov;
    private ArrayList<m> mow;
    private ArrayList<m> mox;
    private ArrayList<m> moy;
    private ArrayList<m> moz;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mol = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mom = null;
        this.moo = null;
        this.mop = null;
        this.moq = null;
        this.mos = null;
        this.mot = null;
        this.mou = null;
        this.mov = null;
        this.moB = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mos.refresh(i);
                switch (i) {
                    case 0:
                        k.bfo().setShowImages(true);
                        k.bfo().ns(0);
                        break;
                    case 1:
                        k.bfo().setShowImages(true);
                        k.bfo().ns(1);
                        TiebaStatic.log(new aq("c10415").aj("obj_type", 1));
                        break;
                    case 2:
                        k.bfo().setShowImages(true);
                        k.bfo().ns(2);
                        TiebaStatic.log(new aq("c10415").aj("obj_type", 3));
                        break;
                    case 3:
                        k.bfo().setShowImages(false);
                        break;
                }
                c.this.mos.dismiss();
                c.this.dyk();
            }
        };
        this.moC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mot.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.mol.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.bfo().setImageWaterType(i2);
                c.this.Ie(i2);
            }
        };
        this.moD = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mou.refresh(i);
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
                c.this.dym();
            }
        };
        this.moE = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mov.refresh(i);
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
                c.this.dyn();
            }
        };
        this.mol = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mol.getLayoutMode().setNightMode(i == 1);
        this.mol.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mor.onChangeSkinType(this.mol.getPageContext(), i);
        if (this.mos != null) {
            this.mos.onChangeSkinType();
        }
        if (this.mot != null) {
            this.mot.onChangeSkinType();
        }
        if (this.mou != null) {
            this.mou.onChangeSkinType();
        }
        if (this.mov != null) {
            this.mov.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dxW() {
        return this.moo;
    }

    public TbSettingTextTipView dxX() {
        return this.mom;
    }

    public TbSettingTextTipView dxY() {
        return this.mop;
    }

    public TbSettingTextTipView dxZ() {
        return this.moq;
    }

    public void dya() {
        dyh();
        this.mot.bkN();
    }

    public void dyb() {
        dyg();
        this.mos.bkN();
    }

    public void dyc() {
        dyi();
        this.mou.bkN();
    }

    public void dyd() {
        dyj();
        this.mov.bkN();
    }

    public TbSettingTextTipView dye() {
        return this.moA;
    }

    private void initUI() {
        this.mol.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mol.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mol.getPageContext().getString(R.string.browse_setting));
        this.moA = (TbSettingTextTipView) this.mol.findViewById(R.id.debug_tool_entrance);
        this.moA.setBottomLineVisibility(true);
        this.mom = (TbSettingTextTipView) this.mol.findViewById(R.id.img_browser);
        this.mom.setBottomLineVisibility(true);
        this.moo = (TbSettingTextTipView) this.mol.findViewById(R.id.add_img_water);
        this.moo.setBottomLineVisibility(true);
        this.mop = (TbSettingTextTipView) this.mol.findViewById(R.id.font_size);
        this.mop.setBottomLineVisibility(true);
        this.moq = (TbSettingTextTipView) this.mol.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.moq.setText(R.string.video_gif_auto_play);
        } else {
            this.moq.setText(R.string.video_auto_play);
        }
        this.moq.setBottomLineVisibility(true);
        this.mor = (MsgSettingItemView) this.mol.findViewById(R.id.slide_anim_switch);
        this.mor.setText(R.string.slide_anim_switch);
        this.mor.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mor.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.blO().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new aq("c13396").aj("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new aq("c13396").aj("obj_type", 2));
            }
        });
        this.mParent = this.mol.findViewById(R.id.parent);
    }

    private void dyf() {
        this.moA.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mom.setOnClickListener(this.mol);
        this.moo.setOnClickListener(this.mol);
        this.mop.setOnClickListener(this.mol);
        this.moq.setOnClickListener(this.mol);
        this.moA.setOnClickListener(this.mol);
    }

    private void dyg() {
        boolean z = true;
        this.mox = new ArrayList<>();
        int viewImageQuality = k.bfo().getViewImageQuality();
        boolean isShowImages = k.bfo().isShowImages();
        this.mox.add(new m(this.mol.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mol.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mox.add(new m(this.mol.getPageContext().getString(R.string.view_high), this.mol.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mox;
        String string = this.mol.getPageContext().getString(R.string.view_low);
        String string2 = this.mol.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mos = new com.baidu.tbadk.core.dialog.e(this.mol.getPageContext());
        this.mos.oj(R.string.browser_image_quality);
        this.mos.a(this.mox, this.moB).bkM();
    }

    private void dyh() {
        this.moy = new ArrayList<>();
        int imageWaterType = k.bfo().getImageWaterType();
        this.moy.add(new m(this.mol.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.moy.add(new m(this.mol.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.moy.add(new m(this.mol.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mot = new com.baidu.tbadk.core.dialog.e(this.mol.getPageContext()).oj(R.string.add_image_water);
        this.mot.a(this.moy, this.moC).bkM();
    }

    private void dyi() {
        this.mou = new com.baidu.tbadk.core.dialog.e(this.mol.getPageContext());
        this.mow = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mow.add(new m(this.mol.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mow.add(new m(this.mol.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mow.add(new m(this.mol.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mow.add(new m(this.mol.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mou.oj(R.string.font_size);
        this.mou.a(this.mow, this.moD);
        this.mou.bkM();
    }

    private void dyj() {
        this.mov = new com.baidu.tbadk.core.dialog.e(this.mol.getPageContext());
        this.moz = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.moz.add(new m(this.mol.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.moz.add(new m(this.mol.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.moz.add(new m(this.mol.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mov.oj(R.string.video_gif_auto_play);
        } else {
            this.mov.oj(R.string.video_auto_play);
        }
        this.mov.a(this.moz, this.moE);
        this.mov.bkM();
    }

    public void updateAll() {
        dyk();
        dyl();
        dym();
        dyn();
        dyf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyk() {
        if (!k.bfo().isShowImages()) {
            this.mom.setTip(this.mContext.getString(R.string.close));
        } else if (k.bfo().getViewImageQuality() == 1) {
            this.mom.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.bfo().getViewImageQuality() == 2) {
            this.mom.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mom.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dyl() {
        Ie(k.bfo().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ie(int i) {
        switch (i) {
            case 0:
                this.moo.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.moo.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.moo.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dym() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mop.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mop.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mop.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mop.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dyn() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.moq.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.moq.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.moq.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
