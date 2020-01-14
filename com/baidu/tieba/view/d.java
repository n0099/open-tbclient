package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes7.dex */
public class d {
    private PopupWindow iSz;
    private ImageView kHA;
    public ImageView kHB;
    private View kHC;
    private ImageView kHD;
    private RelativeLayout kHw;
    private ImageView kHx;
    public ImageView kHy;
    private RelativeLayout kHz;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int kHv = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean kHE = false;
    private Handler mHandler = new Handler();
    private Runnable gLk = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.kHA;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.iSz, imageView);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.kHE = true;
                d.this.mHandler.postDelayed(d.this.gLl, 3000L);
            }
        }
    };
    private Runnable gLl = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bJD();
        }
    };
    private View.OnClickListener gLm = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cpN();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.kHw = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.kHx = (ImageView) this.kHw.findViewById(R.id.person_navigation_dressup_img);
        this.kHy = (ImageView) this.kHw.findViewById(R.id.person_navigation_dressup_red_tip);
        this.kHz = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.kHA = (ImageView) this.kHz.findViewById(R.id.person_navigation_setting_img);
        this.kHB = (ImageView) this.kHz.findViewById(R.id.person_navigation_setting_red_tip);
        this.kHC = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.kHD = (ImageView) this.kHC.findViewById(R.id.person_navigation_scan_img);
    }

    public void cRZ() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.kHw != null && this.kHw.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kHw, (View.OnClickListener) null);
            }
            if (this.kHz != null && this.kHz.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kHz, (View.OnClickListener) null);
            }
            if (this.kHC != null && this.kHC.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.kHC, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(e eVar) {
        if (this.kHw != null) {
            this.kHw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").Z("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "1"));
                    }
                    d.this.Q(6, false);
                    com.baidu.tieba.o.a.cCm().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.kHz != null) {
            this.kHz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").Z("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "2"));
                    }
                    d.this.Q(5, false);
                    TiebaStatic.log(new an("c12502").cp("obj_locate", "2"));
                    d.this.Q(5, false);
                    com.baidu.tieba.o.a.cCm().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aCu();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.kHC != null) {
            this.kHC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                        d.this.mPermissionJudgement.a(new a.InterfaceC0368a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0368a
                            public void onPermissionsGranted() {
                                TiebaStatic.log(new an("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.startRequestPermission(activity);
                    }
                }
            });
        }
    }

    public void Q(int i, boolean z) {
        if (i == 5 && this.kHB != null) {
            this.kHB.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.kHy != null) {
            this.kHy.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kHx != null) {
            if (2 == i) {
                SvgManager.aEp().a(this.kHx, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aEp().a(this.kHx, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.kHx, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kHy != null) {
                am.setImageResource(this.kHy, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.kHA != null) {
            if (2 == i) {
                SvgManager.aEp().a(this.kHA, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aEp().a(this.kHA, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.kHA, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kHB != null) {
                am.setImageResource(this.kHB, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.aEp().a(this.kHD, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cpN() {
        this.mHandler.removeCallbacks(this.gLk);
        this.mHandler.removeCallbacks(this.gLl);
        bJD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJD() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.iSz);
    }
}
