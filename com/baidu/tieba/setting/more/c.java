package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.t.bd;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.base.c<BrowseSettingActivity> {
    private BrowseSettingActivity iSh;
    private TbSettingTextTipView iSi;
    private TbSettingTextTipView iSj;
    private TbSettingTextTipView iSk;
    private TbSettingTextTipView iSl;
    private MsgSettingItemView iSm;
    private com.baidu.tbadk.core.dialog.e iSn;
    private com.baidu.tbadk.core.dialog.e iSo;
    private com.baidu.tbadk.core.dialog.e iSp;
    private com.baidu.tbadk.core.dialog.e iSq;
    private ArrayList<m> iSr;
    private ArrayList<m> iSs;
    private ArrayList<m> iSt;
    private ArrayList<m> iSu;
    private final AdapterView.OnItemClickListener iSv;
    private final AdapterView.OnItemClickListener iSw;
    private final AdapterView.OnItemClickListener iSx;
    private final AdapterView.OnItemClickListener iSy;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iSh = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iSi = null;
        this.iSj = null;
        this.iSk = null;
        this.iSl = null;
        this.iSn = null;
        this.iSo = null;
        this.iSp = null;
        this.iSq = null;
        this.iSv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iSn.refresh(i);
                switch (i) {
                    case 0:
                        i.aca().dF(true);
                        i.aca().gP(0);
                        break;
                    case 1:
                        i.aca().dF(true);
                        i.aca().gP(1);
                        TiebaStatic.log(new an("c10415").P("obj_type", 1));
                        break;
                    case 2:
                        i.aca().dF(true);
                        i.aca().gP(2);
                        TiebaStatic.log(new an("c10415").P("obj_type", 3));
                        break;
                    case 3:
                        i.aca().dF(false);
                        break;
                }
                c.this.iSn.dismiss();
                c.this.ckx();
            }
        };
        this.iSw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iSo.refresh(i);
                switch (i) {
                    case 0:
                        TiebaStatic.log(new an("c10411").P("obj_type", 1));
                        break;
                    case 1:
                        TiebaStatic.log(new an("c10411").P("obj_type", 2));
                        i2 = 2;
                        break;
                    case 2:
                        TiebaStatic.log(new an("c10411").P("obj_type", 3));
                        i2 = 0;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                i.aca().gO(i2);
                c.this.An(i2);
            }
        };
        this.iSx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iSp.refresh(i);
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
                c.this.ckz();
            }
        };
        this.iSy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iSq.refresh(i);
                switch (i) {
                    case 0:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(2);
                        TiebaStatic.log(new an("c11281").P("obj_type", 2));
                        break;
                    case 1:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(0);
                        TiebaStatic.log(new an("c11281").P("obj_type", 1));
                        break;
                    case 2:
                        TbadkCoreApplication.getInst().setVideoAutoPlay(1);
                        TiebaStatic.log(new an("c11281").P("obj_type", 3));
                        break;
                }
                c.this.ckA();
            }
        };
        this.iSh = browseSettingActivity;
        initUI();
        ajr();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iSh.getLayoutMode().setNightMode(i == 1);
        this.iSh.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iSm.onChangeSkinType(this.iSh.getPageContext(), i);
    }

    public TbSettingTextTipView ckl() {
        return this.iSj;
    }

    public TbSettingTextTipView ckm() {
        return this.iSi;
    }

    public TbSettingTextTipView ckn() {
        return this.iSk;
    }

    public TbSettingTextTipView cko() {
        return this.iSl;
    }

    public void ckp() {
        cku();
        this.iSo.agP();
    }

    public void ckq() {
        ckt();
        this.iSn.agP();
    }

    public void ckr() {
        ckv();
        this.iSp.agP();
    }

    public void cks() {
        ckw();
        this.iSq.agP();
    }

    private void initUI() {
        this.iSh.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iSh.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iSh.getPageContext().getString(R.string.browse_setting));
        this.iSi = (TbSettingTextTipView) this.iSh.findViewById(R.id.img_browser);
        this.iSi.setBottomLineVisibility(true);
        this.iSj = (TbSettingTextTipView) this.iSh.findViewById(R.id.add_img_water);
        this.iSj.setBottomLineVisibility(true);
        this.iSk = (TbSettingTextTipView) this.iSh.findViewById(R.id.font_size);
        this.iSk.setBottomLineVisibility(true);
        this.iSl = (TbSettingTextTipView) this.iSh.findViewById(R.id.video_auto_play);
        if (bd.iN()) {
            this.iSl.setText(R.string.video_gif_auto_play);
        } else {
            this.iSl.setText(R.string.video_auto_play);
        }
        this.iSl.setBottomLineVisibility(true);
        this.iSm = (MsgSettingItemView) this.iSh.findViewById(R.id.slide_anim_switch);
        this.iSm.setText(R.string.slide_anim_switch);
        this.iSm.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iSm.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").P("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").P("obj_type", 2));
            }
        });
        this.mParent = this.iSh.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iSi.setOnClickListener(this.iSh);
        this.iSj.setOnClickListener(this.iSh);
        this.iSk.setOnClickListener(this.iSh);
        this.iSl.setOnClickListener(this.iSh);
    }

    private void ckt() {
        this.iSs = new ArrayList<>();
        int viewImageQuality = i.aca().getViewImageQuality();
        boolean ace = i.aca().ace();
        this.iSs.add(new m(this.iSh.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iSh.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), ace && viewImageQuality == 0));
        this.iSs.add(new m(this.iSh.getPageContext().getString(R.string.view_high), this.iSh.getPageContext().getString(R.string.view_image_quality_high_menu_desc), ace && viewImageQuality == 1));
        this.iSs.add(new m(this.iSh.getPageContext().getString(R.string.view_low), this.iSh.getPageContext().getString(R.string.view_image_quality_low_menu_desc), ace && viewImageQuality == 2));
        this.iSs.add(new m(this.iSh.getPageContext().getString(R.string.close), this.iSh.getPageContext().getString(R.string.view_image_quality_close_menu_desc), ace ? false : true));
        this.iSn = new com.baidu.tbadk.core.dialog.e(this.iSh.getPageContext());
        this.iSn.hD(R.string.browser_image_quality);
        this.iSn.a(this.iSs, this.iSv).agO();
    }

    private void cku() {
        this.iSt = new ArrayList<>();
        int acc = i.aca().acc();
        this.iSt.add(new m(this.iSh.getPageContext().getString(R.string.image_water_show_user_name), null, acc == 1));
        this.iSt.add(new m(this.iSh.getPageContext().getString(R.string.image_water_show_forum_name), null, acc == 2));
        this.iSt.add(new m(this.iSh.getPageContext().getString(R.string.image_water_show_none), null, acc == 0));
        this.iSo = new com.baidu.tbadk.core.dialog.e(this.iSh.getPageContext()).hD(R.string.add_image_water);
        this.iSo.a(this.iSt, this.iSw).agO();
    }

    private void ckv() {
        this.iSp = new com.baidu.tbadk.core.dialog.e(this.iSh.getPageContext());
        this.iSr = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iSr.add(new m(this.iSh.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iSr.add(new m(this.iSh.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iSr.add(new m(this.iSh.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iSr.add(new m(this.iSh.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iSp.hD(R.string.font_size);
        this.iSp.a(this.iSr, this.iSx);
        this.iSp.agO();
    }

    private void ckw() {
        this.iSq = new com.baidu.tbadk.core.dialog.e(this.iSh.getPageContext());
        this.iSu = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iSu.add(new m(this.iSh.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iSu.add(new m(this.iSh.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iSu.add(new m(this.iSh.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.iN()) {
            this.iSq.hD(R.string.video_gif_auto_play);
        } else {
            this.iSq.hD(R.string.video_auto_play);
        }
        this.iSq.a(this.iSu, this.iSy);
        this.iSq.agO();
    }

    public void ajr() {
        ckx();
        cky();
        ckz();
        ckA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        if (!i.aca().ace()) {
            this.iSi.setTip(this.mContext.getString(R.string.close));
        } else if (i.aca().getViewImageQuality() == 1) {
            this.iSi.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.aca().getViewImageQuality() == 2) {
            this.iSi.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iSi.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void cky() {
        An(i.aca().acc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(int i) {
        switch (i) {
            case 0:
                this.iSj.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iSj.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iSj.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void ckz() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iSk.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iSk.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iSk.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iSk.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void ckA() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iSl.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iSl.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iSl.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
