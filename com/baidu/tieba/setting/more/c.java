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
/* loaded from: classes26.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private NavigationBar mNavigationBar;
    private View mParent;
    private com.baidu.tbadk.core.dialog.e mVA;
    private com.baidu.tbadk.core.dialog.e mVB;
    private com.baidu.tbadk.core.dialog.e mVC;
    private com.baidu.tbadk.core.dialog.e mVD;
    private ArrayList<m> mVE;
    private ArrayList<m> mVF;
    private ArrayList<m> mVG;
    private ArrayList<m> mVH;
    private TbSettingTextTipView mVI;
    private final AdapterView.OnItemClickListener mVJ;
    private final AdapterView.OnItemClickListener mVK;
    private final AdapterView.OnItemClickListener mVL;
    private final AdapterView.OnItemClickListener mVM;
    private BrowseSettingActivity mVu;
    private TbSettingTextTipView mVv;
    private TbSettingTextTipView mVw;
    private TbSettingTextTipView mVx;
    private TbSettingTextTipView mVy;
    private MsgSettingItemView mVz;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mVu = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mVv = null;
        this.mVw = null;
        this.mVx = null;
        this.mVy = null;
        this.mVA = null;
        this.mVB = null;
        this.mVC = null;
        this.mVD = null;
        this.mVJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mVA.refresh(i);
                switch (i) {
                    case 0:
                        k.blV().setShowImages(true);
                        k.blV().oh(0);
                        break;
                    case 1:
                        k.blV().setShowImages(true);
                        k.blV().oh(1);
                        TiebaStatic.log(new ar("c10415").al("obj_type", 1));
                        break;
                    case 2:
                        k.blV().setShowImages(true);
                        k.blV().oh(2);
                        TiebaStatic.log(new ar("c10415").al("obj_type", 3));
                        break;
                    case 3:
                        k.blV().setShowImages(false);
                        break;
                }
                c.this.mVA.dismiss();
                c.this.dIL();
            }
        };
        this.mVK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mVB.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new ar("c10411").al("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new ar("c10411").al("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new ar("c10411").al("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                SetImageWatermarkTypeReqMsg setImageWatermarkTypeReqMsg = new SetImageWatermarkTypeReqMsg(i2);
                setImageWatermarkTypeReqMsg.setTag(c.this.mVu.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.blV().setImageWaterType(i2);
                c.this.Kc(i2);
            }
        };
        this.mVL = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mVC.refresh(i);
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
                c.this.dIN();
            }
        };
        this.mVM = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mVD.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new ar("c11281").al("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new ar("c11281").al("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new ar("c11281").al("obj_type", 3));
                        break;
                }
                c.this.dIO();
            }
        };
        this.mVu = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mVu.getLayoutMode().setNightMode(i == 1);
        this.mVu.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mVz.onChangeSkinType(this.mVu.getPageContext(), i);
        if (this.mVA != null) {
            this.mVA.onChangeSkinType();
        }
        if (this.mVB != null) {
            this.mVB.onChangeSkinType();
        }
        if (this.mVC != null) {
            this.mVC.onChangeSkinType();
        }
        if (this.mVD != null) {
            this.mVD.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dIx() {
        return this.mVw;
    }

    public TbSettingTextTipView dIy() {
        return this.mVv;
    }

    public TbSettingTextTipView dIz() {
        return this.mVx;
    }

    public TbSettingTextTipView dIA() {
        return this.mVy;
    }

    public void dIB() {
        dII();
        this.mVB.brz();
    }

    public void dIC() {
        dIH();
        this.mVA.brz();
    }

    public void dID() {
        dIJ();
        this.mVC.brz();
    }

    public void dIE() {
        dIK();
        this.mVD.brz();
    }

    public TbSettingTextTipView dIF() {
        return this.mVI;
    }

    private void initUI() {
        this.mVu.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mVu.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mVu.getPageContext().getString(R.string.browse_setting));
        this.mVI = (TbSettingTextTipView) this.mVu.findViewById(R.id.debug_tool_entrance);
        this.mVI.setBottomLineVisibility(true);
        this.mVv = (TbSettingTextTipView) this.mVu.findViewById(R.id.img_browser);
        this.mVv.setBottomLineVisibility(true);
        this.mVw = (TbSettingTextTipView) this.mVu.findViewById(R.id.add_img_water);
        this.mVw.setBottomLineVisibility(true);
        this.mVx = (TbSettingTextTipView) this.mVu.findViewById(R.id.font_size);
        this.mVx.setBottomLineVisibility(true);
        this.mVy = (TbSettingTextTipView) this.mVu.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.mVy.setText(R.string.video_gif_auto_play);
        } else {
            this.mVy.setText(R.string.video_auto_play);
        }
        this.mVy.setBottomLineVisibility(true);
        this.mVz = (MsgSettingItemView) this.mVu.findViewById(R.id.slide_anim_switch);
        this.mVz.setText(R.string.slide_anim_switch);
        this.mVz.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mVz.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.bsO().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new ar("c13396").al("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new ar("c13396").al("obj_type", 2));
            }
        });
        this.mParent = this.mVu.findViewById(R.id.parent);
    }

    private void dIG() {
        this.mVI.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mVv.setOnClickListener(this.mVu);
        this.mVw.setOnClickListener(this.mVu);
        this.mVx.setOnClickListener(this.mVu);
        this.mVy.setOnClickListener(this.mVu);
        this.mVI.setOnClickListener(this.mVu);
    }

    private void dIH() {
        boolean z = true;
        this.mVF = new ArrayList<>();
        int viewImageQuality = k.blV().getViewImageQuality();
        boolean isShowImages = k.blV().isShowImages();
        this.mVF.add(new m(this.mVu.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mVu.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mVF.add(new m(this.mVu.getPageContext().getString(R.string.view_high), this.mVu.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mVF;
        String string = this.mVu.getPageContext().getString(R.string.view_low);
        String string2 = this.mVu.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mVA = new com.baidu.tbadk.core.dialog.e(this.mVu.getPageContext());
        this.mVA.oY(R.string.browser_image_quality);
        this.mVA.a(this.mVF, this.mVJ).bry();
    }

    private void dII() {
        this.mVG = new ArrayList<>();
        int imageWaterType = k.blV().getImageWaterType();
        this.mVG.add(new m(this.mVu.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.mVG.add(new m(this.mVu.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.mVG.add(new m(this.mVu.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mVB = new com.baidu.tbadk.core.dialog.e(this.mVu.getPageContext()).oY(R.string.add_image_water);
        this.mVB.a(this.mVG, this.mVK).bry();
    }

    private void dIJ() {
        this.mVC = new com.baidu.tbadk.core.dialog.e(this.mVu.getPageContext());
        this.mVE = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mVE.add(new m(this.mVu.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mVE.add(new m(this.mVu.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mVE.add(new m(this.mVu.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mVE.add(new m(this.mVu.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mVC.oY(R.string.font_size);
        this.mVC.a(this.mVE, this.mVL);
        this.mVC.bry();
    }

    private void dIK() {
        this.mVD = new com.baidu.tbadk.core.dialog.e(this.mVu.getPageContext());
        this.mVH = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.mVH.add(new m(this.mVu.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.mVH.add(new m(this.mVu.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.mVH.add(new m(this.mVu.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mVD.oY(R.string.video_gif_auto_play);
        } else {
            this.mVD.oY(R.string.video_auto_play);
        }
        this.mVD.a(this.mVH, this.mVM);
        this.mVD.bry();
    }

    public void updateAll() {
        dIL();
        dIM();
        dIN();
        dIO();
        dIG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIL() {
        if (!k.blV().isShowImages()) {
            this.mVv.setTip(this.mContext.getString(R.string.close));
        } else if (k.blV().getViewImageQuality() == 1) {
            this.mVv.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.blV().getViewImageQuality() == 2) {
            this.mVv.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mVv.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dIM() {
        Kc(k.blV().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc(int i) {
        switch (i) {
            case 0:
                this.mVw.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.mVw.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.mVw.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dIN() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mVx.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mVx.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mVx.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mVx.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dIO() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.mVy.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.mVy.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.mVy.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
