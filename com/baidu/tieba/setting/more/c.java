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
    private BrowseSettingActivity iRd;
    private TbSettingTextTipView iRe;
    private TbSettingTextTipView iRf;
    private TbSettingTextTipView iRg;
    private TbSettingTextTipView iRh;
    private MsgSettingItemView iRi;
    private com.baidu.tbadk.core.dialog.e iRj;
    private com.baidu.tbadk.core.dialog.e iRk;
    private com.baidu.tbadk.core.dialog.e iRl;
    private com.baidu.tbadk.core.dialog.e iRm;
    private ArrayList<m> iRn;
    private ArrayList<m> iRo;
    private ArrayList<m> iRp;
    private ArrayList<m> iRq;
    private final AdapterView.OnItemClickListener iRr;
    private final AdapterView.OnItemClickListener iRs;
    private final AdapterView.OnItemClickListener iRt;
    private final AdapterView.OnItemClickListener iRu;
    private NavigationBar mNavigationBar;
    private View mParent;

    public c(BrowseSettingActivity browseSettingActivity) {
        super(browseSettingActivity.getPageContext());
        this.iRd = null;
        this.mParent = null;
        this.mNavigationBar = null;
        this.iRe = null;
        this.iRf = null;
        this.iRg = null;
        this.iRh = null;
        this.iRj = null;
        this.iRk = null;
        this.iRl = null;
        this.iRm = null;
        this.iRr = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iRj.refresh(i);
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
                c.this.iRj.dismiss();
                c.this.ckf();
            }
        };
        this.iRs = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                c.this.iRk.refresh(i);
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
                c.this.Al(i2);
            }
        };
        this.iRt = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iRl.refresh(i);
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
                c.this.ckh();
            }
        };
        this.iRu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.more.c.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                c.this.iRm.refresh(i);
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
                c.this.cki();
            }
        };
        this.iRd = browseSettingActivity;
        initUI();
        ajp();
        initListener();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: com.baidu.tieba.setting.more.BrowseSettingActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.iRd.getLayoutMode().setNightMode(i == 1);
        this.iRd.getLayoutMode().onModeChanged(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iRi.onChangeSkinType(this.iRd.getPageContext(), i);
    }

    public TbSettingTextTipView cjT() {
        return this.iRf;
    }

    public TbSettingTextTipView cjU() {
        return this.iRe;
    }

    public TbSettingTextTipView cjV() {
        return this.iRg;
    }

    public TbSettingTextTipView cjW() {
        return this.iRh;
    }

    public void cjX() {
        ckc();
        this.iRk.agN();
    }

    public void cjY() {
        ckb();
        this.iRj.agN();
    }

    public void cjZ() {
        ckd();
        this.iRl.agN();
    }

    public void cka() {
        cke();
        this.iRm.agN();
    }

    private void initUI() {
        this.iRd.setContentView(R.layout.browse_setting_activity);
        this.mNavigationBar = (NavigationBar) this.iRd.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(this.iRd.getPageContext().getString(R.string.browse_setting));
        this.iRe = (TbSettingTextTipView) this.iRd.findViewById(R.id.img_browser);
        this.iRe.setBottomLineVisibility(true);
        this.iRf = (TbSettingTextTipView) this.iRd.findViewById(R.id.add_img_water);
        this.iRf.setBottomLineVisibility(true);
        this.iRg = (TbSettingTextTipView) this.iRd.findViewById(R.id.font_size);
        this.iRg.setBottomLineVisibility(true);
        this.iRh = (TbSettingTextTipView) this.iRd.findViewById(R.id.video_auto_play);
        if (bd.iN()) {
            this.iRh.setText(R.string.video_gif_auto_play);
        } else {
            this.iRh.setText(R.string.video_auto_play);
        }
        this.iRh.setBottomLineVisibility(true);
        this.iRi = (MsgSettingItemView) this.iRd.findViewById(R.id.slide_anim_switch);
        this.iRi.setText(R.string.slide_anim_switch);
        this.iRi.setSwitchStateNoCallback(TbSingleton.getInstance().isSlideAnimLocalSwitchOn());
        this.iRi.setOnSwitchStateChangeListener(new BdSwitchView.a() { // from class: com.baidu.tieba.setting.more.c.1
            @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
            public void a(View view, BdSwitchView.SwitchState switchState) {
                com.baidu.tbadk.core.sharedPref.b.ahO().putInt("slide_local_switch_is_clicked", 1);
                if (switchState == BdSwitchView.SwitchState.ON) {
                    TbSingleton.getInstance().setSlideAnimLocalSwitch(true);
                    TiebaStatic.log(new an("c13396").P("obj_type", 1));
                    return;
                }
                TbSingleton.getInstance().setSlideAnimLocalSwitch(false);
                TiebaStatic.log(new an("c13396").P("obj_type", 2));
            }
        });
        this.mParent = this.iRd.findViewById(R.id.parent);
    }

    private void initListener() {
        this.iRe.setOnClickListener(this.iRd);
        this.iRf.setOnClickListener(this.iRd);
        this.iRg.setOnClickListener(this.iRd);
        this.iRh.setOnClickListener(this.iRd);
    }

    private void ckb() {
        this.iRo = new ArrayList<>();
        int viewImageQuality = i.aca().getViewImageQuality();
        boolean ace = i.aca().ace();
        this.iRo.add(new m(this.iRd.getPageContext().getString(R.string.view_image_quality_auto_menu), this.iRd.getPageContext().getString(R.string.view_image_quality_auto_menu_desc), ace && viewImageQuality == 0));
        this.iRo.add(new m(this.iRd.getPageContext().getString(R.string.view_high), this.iRd.getPageContext().getString(R.string.view_image_quality_high_menu_desc), ace && viewImageQuality == 1));
        this.iRo.add(new m(this.iRd.getPageContext().getString(R.string.view_low), this.iRd.getPageContext().getString(R.string.view_image_quality_low_menu_desc), ace && viewImageQuality == 2));
        this.iRo.add(new m(this.iRd.getPageContext().getString(R.string.close), this.iRd.getPageContext().getString(R.string.view_image_quality_close_menu_desc), ace ? false : true));
        this.iRj = new com.baidu.tbadk.core.dialog.e(this.iRd.getPageContext());
        this.iRj.hD(R.string.browser_image_quality);
        this.iRj.a(this.iRo, this.iRr).agM();
    }

    private void ckc() {
        this.iRp = new ArrayList<>();
        int acc = i.aca().acc();
        this.iRp.add(new m(this.iRd.getPageContext().getString(R.string.image_water_show_user_name), null, acc == 1));
        this.iRp.add(new m(this.iRd.getPageContext().getString(R.string.image_water_show_forum_name), null, acc == 2));
        this.iRp.add(new m(this.iRd.getPageContext().getString(R.string.image_water_show_none), null, acc == 0));
        this.iRk = new com.baidu.tbadk.core.dialog.e(this.iRd.getPageContext()).hD(R.string.add_image_water);
        this.iRk.a(this.iRp, this.iRs).agM();
    }

    private void ckd() {
        this.iRl = new com.baidu.tbadk.core.dialog.e(this.iRd.getPageContext());
        this.iRn = new ArrayList<>();
        int fontSize = TbadkCoreApplication.getInst().getFontSize();
        this.iRn.add(new m(this.iRd.getPageContext().getString(R.string.font_size_xlarge), null, fontSize == 0));
        this.iRn.add(new m(this.iRd.getPageContext().getString(R.string.font_size_big), null, fontSize == 1));
        this.iRn.add(new m(this.iRd.getPageContext().getString(R.string.font_size_mid), null, fontSize == 2));
        this.iRn.add(new m(this.iRd.getPageContext().getString(R.string.font_size_small), null, fontSize == 3));
        this.iRl.hD(R.string.font_size);
        this.iRl.a(this.iRn, this.iRt);
        this.iRl.agM();
    }

    private void cke() {
        this.iRm = new com.baidu.tbadk.core.dialog.e(this.iRd.getPageContext());
        this.iRq = new ArrayList<>();
        int videoAutoPlay = TbadkCoreApplication.getInst().getVideoAutoPlay();
        this.iRq.add(new m(this.iRd.getPageContext().getString(R.string.video_auto_play_always), null, videoAutoPlay == 2));
        this.iRq.add(new m(this.iRd.getPageContext().getString(R.string.video_auto_play_in_wifi), null, videoAutoPlay == 0));
        this.iRq.add(new m(this.iRd.getPageContext().getString(R.string.close), null, videoAutoPlay == 1));
        if (bd.iN()) {
            this.iRm.hD(R.string.video_gif_auto_play);
        } else {
            this.iRm.hD(R.string.video_auto_play);
        }
        this.iRm.a(this.iRq, this.iRu);
        this.iRm.agM();
    }

    public void ajp() {
        ckf();
        ckg();
        ckh();
        cki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckf() {
        if (!i.aca().ace()) {
            this.iRe.setTip(this.mContext.getString(R.string.close));
        } else if (i.aca().getViewImageQuality() == 1) {
            this.iRe.setTip(this.mContext.getString(R.string.view_high));
        } else if (i.aca().getViewImageQuality() == 2) {
            this.iRe.setTip(this.mContext.getString(R.string.view_low));
        } else {
            this.iRe.setTip(this.mContext.getString(R.string.view_image_quality_auto_menu));
        }
    }

    private void ckg() {
        Al(i.aca().acc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Al(int i) {
        switch (i) {
            case 0:
                this.iRf.setTip(this.mContext.getString(R.string.image_water_show_none));
                return;
            case 1:
                this.iRf.setTip(this.mContext.getString(R.string.image_water_show_user_name));
                return;
            case 2:
                this.iRf.setTip(this.mContext.getString(R.string.image_water_show_forum_name));
                return;
            default:
                return;
        }
    }

    public void ckh() {
        if (TbadkCoreApplication.getInst().getFontSize() == 0) {
            this.iRg.setTip(this.mContext.getString(R.string.font_size_xlarge));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 1) {
            this.iRg.setTip(this.mContext.getString(R.string.font_size_big));
        } else if (TbadkCoreApplication.getInst().getFontSize() == 2) {
            this.iRg.setTip(this.mContext.getString(R.string.font_size_mid));
        } else {
            this.iRg.setTip(this.mContext.getString(R.string.font_size_small));
        }
    }

    public void cki() {
        if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 0) {
            this.iRh.setTip(this.mContext.getString(R.string.video_auto_play_in_wifi));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 1) {
            this.iRh.setTip(this.mContext.getString(R.string.close));
        } else if (TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) {
            this.iRh.setTip(this.mContext.getString(R.string.video_auto_play_always));
        }
    }
}
