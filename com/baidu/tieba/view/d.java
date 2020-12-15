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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes22.dex */
public class d {
    private PopupWindow lVI;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private RelativeLayout nPN;
    private ImageView nPO;
    public ImageView nPP;
    private RelativeLayout nPQ;
    private ImageView nPR;
    public ImageView nPS;
    private View nPT;
    private ImageView nPU;
    private int nPM = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean nPV = false;
    private Handler mHandler = new Handler();
    private Runnable jyF = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.nPR;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.lVI, imageView);
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.nPV = true;
                d.this.mHandler.postDelayed(d.this.jyG, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };
    private Runnable jyG = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cLx();
        }
    };
    private View.OnClickListener jyH = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.duf();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.nPN = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.nPO = (ImageView) this.nPN.findViewById(R.id.person_navigation_dressup_img);
        this.nPP = (ImageView) this.nPN.findViewById(R.id.person_navigation_dressup_red_tip);
        this.nPQ = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.nPR = (ImageView) this.nPQ.findViewById(R.id.person_navigation_setting_img);
        this.nPS = (ImageView) this.nPQ.findViewById(R.id.person_navigation_setting_red_tip);
        this.nPT = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.nPU = (ImageView) this.nPT.findViewById(R.id.person_navigation_scan_img);
    }

    public void dYa() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.nPN != null && this.nPN.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nPN, (View.OnClickListener) null);
            }
            if (this.nPQ != null && this.nPQ.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.nPQ, (View.OnClickListener) null);
            }
            if (this.nPT != null && this.nPT.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.nPT, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.nPN != null) {
            this.nPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ar("c12523").al("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new ar("c12502").dY("obj_locate", "1"));
                    }
                    d.this.ag(6, false);
                    com.baidu.tieba.q.a.dGO().h(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.nPQ != null) {
            this.nPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new ar("c12523").al("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new ar("c12502").dY("obj_locate", "2"));
                    }
                    d.this.ag(5, false);
                    TiebaStatic.log(new ar("c12502").dY("obj_locate", "2"));
                    d.this.ag(5, false);
                    com.baidu.tieba.q.a.dGO().h(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).brB();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.nPT != null) {
            this.nPT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
                                TiebaStatic.log(new ar("c12706"));
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
        if (i == 5 && this.nPS != null) {
            this.nPS.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.nPP != null) {
            this.nPP.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.nPO != null) {
            if (2 == i) {
                SvgManager.btW().a(this.nPO, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.btW().a(this.nPO, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.btW().a(this.nPO, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nPP != null) {
                ap.setImageResource(this.nPP, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.nPR != null) {
            if (2 == i) {
                SvgManager.btW().a(this.nPR, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.btW().a(this.nPR, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.btW().a(this.nPR, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.nPS != null) {
                ap.setImageResource(this.nPS, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.btW().a(this.nPU, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void duf() {
        this.mHandler.removeCallbacks(this.jyF);
        this.mHandler.removeCallbacks(this.jyG);
        cLx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLx() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lVI);
    }
}
