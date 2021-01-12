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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes2.dex */
public class d {
    private PopupWindow lWp;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private RelativeLayout nOD;
    private ImageView nOE;
    public ImageView nOF;
    private RelativeLayout nOG;
    private ImageView nOH;
    public ImageView nOI;
    private View nOJ;
    private ImageView nOK;
    private int nOC = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean nOL = false;
    private Handler mHandler = new Handler();
    private Runnable jGy = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.nOH;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.lWp, imageView);
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.nOL = true;
                d.this.mHandler.postDelayed(d.this.jGz, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };
    private Runnable jGz = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cKJ();
        }
    };
    private View.OnClickListener jGA = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dqd();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.nOD = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.nOE = (ImageView) this.nOD.findViewById(R.id.person_navigation_dressup_img);
        this.nOF = (ImageView) this.nOD.findViewById(R.id.person_navigation_dressup_red_tip);
        this.nOG = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.nOH = (ImageView) this.nOG.findViewById(R.id.person_navigation_setting_img);
        this.nOI = (ImageView) this.nOG.findViewById(R.id.person_navigation_setting_red_tip);
        this.nOJ = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.nOK = (ImageView) this.nOJ.findViewById(R.id.person_navigation_scan_img);
    }

    public void dTM() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.nOD != null && this.nOD.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nOD, (View.OnClickListener) null);
            }
            if (this.nOG != null && this.nOG.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nOG, (View.OnClickListener) null);
            }
            if (this.nOJ != null && this.nOJ.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.nOJ, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.nOD != null) {
            this.nOD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").an("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new aq("c12502").dW("obj_locate", "1"));
                    }
                    d.this.ae(6, false);
                    com.baidu.tieba.p.a.dCM().h(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.nOG != null) {
            this.nOG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").an("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new aq("c12502").dW("obj_locate", "2"));
                    }
                    d.this.ae(5, false);
                    TiebaStatic.log(new aq("c12502").dW("obj_locate", "2"));
                    d.this.ae(5, false);
                    com.baidu.tieba.p.a.dCM().h(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.b(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).bqk();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.nOJ != null) {
            this.nOJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                        d.this.mPermissionJudgement.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                            public void onPermissionsGranted() {
                                TiebaStatic.log(new aq("c12706"));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new QRCodeScanActivityConfig(d.this.mContext)));
                            }
                        });
                        d.this.mPermissionJudgement.startRequestPermission(activity);
                    }
                }
            });
        }
    }

    public void ae(int i, boolean z) {
        if (i == 5 && this.nOI != null) {
            this.nOI.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.nOF != null) {
            this.nOF.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.nOE != null) {
            if (2 == i) {
                SvgManager.bsx().a(this.nOE, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bsx().a(this.nOE, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bsx().a(this.nOE, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nOF != null) {
                ao.setImageResource(this.nOF, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.nOH != null) {
            if (2 == i) {
                SvgManager.bsx().a(this.nOH, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bsx().a(this.nOH, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bsx().a(this.nOH, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nOI != null) {
                ao.setImageResource(this.nOI, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.bsx().a(this.nOK, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dqd() {
        this.mHandler.removeCallbacks(this.jGy);
        this.mHandler.removeCallbacks(this.jGz);
        cKJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKJ() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lWp);
    }
}
