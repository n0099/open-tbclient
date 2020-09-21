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
/* loaded from: classes21.dex */
public class d {
    private PopupWindow kZH;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private RelativeLayout mSE;
    private ImageView mSF;
    public ImageView mSG;
    private RelativeLayout mSH;
    private ImageView mSI;
    public ImageView mSJ;
    private View mSK;
    private ImageView mSL;
    private int mSD = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean mSM = false;
    private Handler mHandler = new Handler();
    private Runnable iDg = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.mSI;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.kZH, imageView);
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.mSM = true;
                d.this.mHandler.postDelayed(d.this.iDh, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };
    private Runnable iDh = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cxx();
        }
    };
    private View.OnClickListener iDi = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dfU();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.mSE = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.mSF = (ImageView) this.mSE.findViewById(R.id.person_navigation_dressup_img);
        this.mSG = (ImageView) this.mSE.findViewById(R.id.person_navigation_dressup_red_tip);
        this.mSH = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.mSI = (ImageView) this.mSH.findViewById(R.id.person_navigation_setting_img);
        this.mSJ = (ImageView) this.mSH.findViewById(R.id.person_navigation_setting_red_tip);
        this.mSK = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.mSL = (ImageView) this.mSK.findViewById(R.id.person_navigation_scan_img);
    }

    public void dJk() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.mSE != null && this.mSE.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mSE, (View.OnClickListener) null);
            }
            if (this.mSH != null && this.mSH.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mSH, (View.OnClickListener) null);
            }
            if (this.mSK != null && this.mSK.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mSK, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.mSE != null) {
            this.mSE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").ai("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new aq("c12502").dF("obj_locate", "1"));
                    }
                    d.this.ae(6, false);
                    com.baidu.tieba.p.a.dsD().h(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.mSH != null) {
            this.mSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").ai("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new aq("c12502").dF("obj_locate", "2"));
                    }
                    d.this.ae(5, false);
                    TiebaStatic.log(new aq("c12502").dF("obj_locate", "2"));
                    d.this.ae(5, false);
                    com.baidu.tieba.p.a.dsD().h(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).big();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.mSK != null) {
            this.mSK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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
        if (i == 5 && this.mSJ != null) {
            this.mSJ.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.mSG != null) {
            this.mSG.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSF != null) {
            if (2 == i) {
                SvgManager.bkl().a(this.mSF, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bkl().a(this.mSF, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bkl().a(this.mSF, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mSG != null) {
                ap.setImageResource(this.mSG, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.mSI != null) {
            if (2 == i) {
                SvgManager.bkl().a(this.mSI, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bkl().a(this.mSI, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bkl().a(this.mSI, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mSJ != null) {
                ap.setImageResource(this.mSJ, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.bkl().a(this.mSL, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dfU() {
        this.mHandler.removeCallbacks(this.iDg);
        this.mHandler.removeCallbacks(this.iDh);
        cxx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxx() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kZH);
    }
}
