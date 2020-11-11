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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes22.dex */
public class d {
    private PopupWindow lHu;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private RelativeLayout nAC;
    private ImageView nAD;
    public ImageView nAE;
    private RelativeLayout nAF;
    private ImageView nAG;
    public ImageView nAH;
    private View nAI;
    private ImageView nAJ;
    private int nAB = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean nAK = false;
    private Handler mHandler = new Handler();
    private Runnable jkq = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.nAG;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.lHu, imageView);
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.nAK = true;
                d.this.mHandler.postDelayed(d.this.jkr, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };
    private Runnable jkr = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cGC();
        }
    };
    private View.OnClickListener jks = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dpn();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.nAC = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.nAD = (ImageView) this.nAC.findViewById(R.id.person_navigation_dressup_img);
        this.nAE = (ImageView) this.nAC.findViewById(R.id.person_navigation_dressup_red_tip);
        this.nAF = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.nAG = (ImageView) this.nAF.findViewById(R.id.person_navigation_setting_img);
        this.nAH = (ImageView) this.nAF.findViewById(R.id.person_navigation_setting_red_tip);
        this.nAI = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.nAJ = (ImageView) this.nAI.findViewById(R.id.person_navigation_scan_img);
    }

    public void dSG() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.nAC != null && this.nAC.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nAC, (View.OnClickListener) null);
            }
            if (this.nAF != null && this.nAF.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nAF, (View.OnClickListener) null);
            }
            if (this.nAI != null && this.nAI.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.nAI, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.nAC != null) {
            this.nAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").al("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "1"));
                    }
                    d.this.ag(6, false);
                    com.baidu.tieba.p.a.dBY().h(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.nAF != null) {
            this.nAF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").al("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new aq("c12502").dR("obj_locate", "2"));
                    }
                    d.this.ag(5, false);
                    TiebaStatic.log(new aq("c12502").dR("obj_locate", "2"));
                    d.this.ag(5, false);
                    com.baidu.tieba.p.a.dBY().h(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).bpi();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.nAI != null) {
            this.nAI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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

    public void ag(int i, boolean z) {
        if (i == 5 && this.nAH != null) {
            this.nAH.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.nAE != null) {
            this.nAE.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.nAD != null) {
            if (2 == i) {
                SvgManager.brn().a(this.nAD, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.brn().a(this.nAD, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.brn().a(this.nAD, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nAE != null) {
                ap.setImageResource(this.nAE, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.nAG != null) {
            if (2 == i) {
                SvgManager.brn().a(this.nAG, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.brn().a(this.nAG, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.brn().a(this.nAG, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nAH != null) {
                ap.setImageResource(this.nAH, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.brn().a(this.nAJ, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dpn() {
        this.mHandler.removeCallbacks(this.jkq);
        this.mHandler.removeCallbacks(this.jkr);
        cGC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGC() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lHu);
    }
}
