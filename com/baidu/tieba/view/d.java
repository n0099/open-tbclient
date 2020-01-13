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
    private RelativeLayout kHr;
    private ImageView kHs;
    public ImageView kHt;
    private RelativeLayout kHu;
    private ImageView kHv;
    public ImageView kHw;
    private View kHx;
    private ImageView kHy;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private int kHq = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean kHz = false;
    private Handler mHandler = new Handler();
    private Runnable gLk = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.kHv;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.iSz, imageView);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.kHz = true;
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
        this.kHr = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.kHs = (ImageView) this.kHr.findViewById(R.id.person_navigation_dressup_img);
        this.kHt = (ImageView) this.kHr.findViewById(R.id.person_navigation_dressup_red_tip);
        this.kHu = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.kHv = (ImageView) this.kHu.findViewById(R.id.person_navigation_setting_img);
        this.kHw = (ImageView) this.kHu.findViewById(R.id.person_navigation_setting_red_tip);
        this.kHx = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.kHy = (ImageView) this.kHx.findViewById(R.id.person_navigation_scan_img);
    }

    public void cRX() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.kHr != null && this.kHr.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kHr, (View.OnClickListener) null);
            }
            if (this.kHu != null && this.kHu.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kHu, (View.OnClickListener) null);
            }
            if (this.kHx != null && this.kHx.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.kHx, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(e eVar) {
        if (this.kHr != null) {
            this.kHr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").Z("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").cp("obj_locate", "1"));
                    }
                    d.this.Q(6, false);
                    com.baidu.tieba.o.a.cCk().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.kHu != null) {
            this.kHu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
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
                    com.baidu.tieba.o.a.cCk().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aCu();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.kHx != null) {
            this.kHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
        if (i == 5 && this.kHw != null) {
            this.kHw.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.kHt != null) {
            this.kHt.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kHs != null) {
            if (2 == i) {
                SvgManager.aEp().a(this.kHs, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aEp().a(this.kHs, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.kHs, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kHt != null) {
                am.setImageResource(this.kHt, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.kHv != null) {
            if (2 == i) {
                SvgManager.aEp().a(this.kHv, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aEp().a(this.kHv, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aEp().a(this.kHv, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kHw != null) {
                am.setImageResource(this.kHw, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.aEp().a(this.kHy, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
