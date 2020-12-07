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
    private ArrayList<m> mVC;
    private ArrayList<m> mVD;
    private ArrayList<m> mVE;
    private ArrayList<m> mVF;
    private TbSettingTextTipView mVG;
    private final AdapterView.OnItemClickListener mVH;
    private final AdapterView.OnItemClickListener mVI;
    private final AdapterView.OnItemClickListener mVJ;
    private final AdapterView.OnItemClickListener mVK;
    private BrowseSettingActivity mVs;
    private TbSettingTextTipView mVt;
    private TbSettingTextTipView mVu;
    private TbSettingTextTipView mVv;
    private TbSettingTextTipView mVw;
    private MsgSettingItemView mVx;
    private com.baidu.tbadk.core.dialog.e mVy;
    private com.baidu.tbadk.core.dialog.e mVz;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.mVs = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.mVt = null;
        this.mVu = null;
        this.mVv = null;
        this.mVw = null;
        this.mVy = null;
        this.mVz = null;
        this.mVA = null;
        this.mVB = null;
        this.mVH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mVy.refresh(i);
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
                c.this.mVy.dismiss();
                c.this.dIK();
            }
        };
        this.mVI = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.mVz.refresh(i);
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
                setImageWatermarkTypeReqMsg.setTag(c.this.mVs.getUniqueId());
                MessageManager.getInstance().sendMessage(setImageWatermarkTypeReqMsg);
                k.blV().setImageWaterType(i2);
                c.this.Kc(i2);
            }
        };
        this.mVJ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mVA.refresh(i);
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
                c.this.dIM();
            }
        };
        this.mVK = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.mVB.refresh(i);
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
                c.this.dIN();
            }
        };
        this.mVs = browseSettingActivity;
        initUI();
        updateAll();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mVs.getLayoutMode().setNightMode(i == 1);
        this.mVs.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mVx.onChangeSkinType(this.mVs.getPageContext(), i);
        if (this.mVy != null) {
            this.mVy.onChangeSkinType();
        }
        if (this.mVz != null) {
            this.mVz.onChangeSkinType();
        }
        if (this.mVA != null) {
            this.mVA.onChangeSkinType();
        }
        if (this.mVB != null) {
            this.mVB.onChangeSkinType();
        }
    }

    public TbSettingTextTipView dIw() {
        return this.mVu;
    }

    public TbSettingTextTipView dIx() {
        return this.mVt;
    }

    public TbSettingTextTipView dIy() {
        return this.mVv;
    }

    public TbSettingTextTipView dIz() {
        return this.mVw;
    }

    public void dIA() {
        dIH();
        this.mVz.brz();
    }

    public void dIB() {
        dIG();
        this.mVy.brz();
    }

    public void dIC() {
        dII();
        this.mVA.brz();
    }

    public void dID() {
        dIJ();
        this.mVB.brz();
    }

    public TbSettingTextTipView dIE() {
        return this.mVG;
    }

    private void initUI() {
        this.mVs.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.mVs.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.mVs.getPageContext().getString(R.string.browse_setting));
        this.mVG = (TbSettingTextTipView) this.mVs.findViewById(R.id.debug_tool_entrance);
        this.mVG.setBottomLineVisibility(true);
        this.mVt = (TbSettingTextTipView) this.mVs.findViewById(R.id.img_browser);
        this.mVt.setBottomLineVisibility(true);
        this.mVu = (TbSettingTextTipView) this.mVs.findViewById(R.id.add_img_water);
        this.mVu.setBottomLineVisibility(true);
        this.mVv = (TbSettingTextTipView) this.mVs.findViewById(R.id.font_size);
        this.mVv.setBottomLineVisibility(true);
        this.mVw = (TbSettingTextTipView) this.mVs.findViewById(R.id.video_auto_play);
        if (RichTextGifViewSwitch.isOn()) {
            this.mVw.setText(R.string.video_gif_auto_play);
        } else {
            this.mVw.setText(R.string.video_auto_play);
        }
        this.mVw.setBottomLineVisibility(true);
        this.mVx = (MsgSettingItemView) this.mVs.findViewById(R.id.slide_anim_switch);
        this.mVx.setText(R.string.slide_anim_switch);
        this.mVx.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.mVx.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
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
        this.mParent = this.mVs.findViewById(R.id.parent);
    }

    private void dIF() {
        this.mVG.setVisibility(TbSingleton.getInstance().isDebugToolMode() ? 0 : 8);
    }

    private void initListener() {
        this.mVt.setOnClickListener(this.mVs);
        this.mVu.setOnClickListener(this.mVs);
        this.mVv.setOnClickListener(this.mVs);
        this.mVw.setOnClickListener(this.mVs);
        this.mVG.setOnClickListener(this.mVs);
    }

    private void dIG() {
        boolean z = true;
        this.mVD = new ArrayList<>();
        int viewImageQuality = k.blV().getViewImageQuality();
        boolean isShowImages = k.blV().isShowImages();
        this.mVD.add(new m(this.mVs.getPageContext().getString(R.string.view_image_quality_auto_menu), this.mVs.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), isShowImages && viewImageQuality == 0));
        this.mVD.add(new m(this.mVs.getPageContext().getString(R.string.view_high), this.mVs.getPageContext().getString(R.string.view_image_quality_high_menu_desc), isShowImages && viewImageQuality == 1));
        ArrayList<m> arrayList = this.mVD;
        String string = this.mVs.getPageContext().getString(R.string.view_low);
        String string2 = this.mVs.getPageContext().getString(R.string.view_image_quality_low_menu_desc);
        if (!isShowImages || viewImageQuality != 2) {
            z = false;
        }
        arrayList.add(new m(string, string2, z));
        this.mVy = new com.baidu.tbadk.core.dialog.e(this.mVs.getPageContext());
        this.mVy.oY(R.string.browser_image_quality);
        this.mVy.a(this.mVD, this.mVH).bry();
    }

    private void dIH() {
        this.mVE = new ArrayList<>();
        int imageWaterType = k.blV().getImageWaterType();
        this.mVE.add(new m(this.mVs.getPageContext().getString(R.string.image_water_show_user_name), null, imageWaterType == 1));
        this.mVE.add(new m(this.mVs.getPageContext().getString(R.string.image_water_show_forum_name), null, imageWaterType == 2));
        this.mVE.add(new m(this.mVs.getPageContext().getString(R.string.image_water_show_none), null, imageWaterType == 0));
        this.mVz = new com.baidu.tbadk.core.dialog.e(this.mVs.getPageContext()).oY(R.string.add_image_water);
        this.mVz.a(this.mVE, this.mVI).bry();
    }

    private void dII() {
        this.mVA = new com.baidu.tbadk.core.dialog.e(this.mVs.getPageContext());
        this.mVC = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.mVC.add(new m(this.mVs.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.mVC.add(new m(this.mVs.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.mVC.add(new m(this.mVs.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.mVC.add(new m(this.mVs.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.mVA.oY(R.string.font_size);
        this.mVA.a(this.mVC, this.mVJ);
        this.mVA.bry();
    }

    private void dIJ() {
        this.mVB = new com.baidu.tbadk.core.dialog.e(this.mVs.getPageContext());
        this.mVF = new ArrayList<>();
        int homePageAutoPlay = TbadkCoreApplication.getInst().getHomePageAutoPlay();
        this.mVF.add(new m(this.mVs.getPageContext().getString(R.string.video_auto_play_always), null, homePageAutoPlay == 2));
        this.mVF.add(new m(this.mVs.getPageContext().getString(R.string.video_auto_play_in_wifi), null, homePageAutoPlay == 0));
        this.mVF.add(new m(this.mVs.getPageContext().getString(R.string.close), null, homePageAutoPlay == 1));
        if (RichTextGifViewSwitch.isOn()) {
            this.mVB.oY(R.string.video_gif_auto_play);
        } else {
            this.mVB.oY(R.string.video_auto_play);
        }
        this.mVB.a(this.mVF, this.mVK);
        this.mVB.bry();
    }

    public void updateAll() {
        dIK();
        dIL();
        dIM();
        dIN();
        dIF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIK() {
        if (!k.blV().isShowImages()) {
            this.mVt.setTip(this.mContext.getString(R.string.close));
        } else if (k.blV().getViewImageQuality() == 1) {
            this.mVt.setTip(this.mContext.getString(R.string.view_high));
        } else if (k.blV().getViewImageQuality() == 2) {
            this.mVt.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.mVt.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void dIL() {
        Kc(k.blV().getImageWaterType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kc(int i) {
        switch (i) {
            case 0:
                this.mVu.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.mVu.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.mVu.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void dIM() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.mVv.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.mVv.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.mVv.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.mVv.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void dIN() {
        if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 0) {
            this.mVw.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 1) {
            this.mVw.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getHomePageAutoPlay() == 2) {
            this.mVw.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
