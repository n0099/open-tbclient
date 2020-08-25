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
/* loaded from: classes16.dex */
public class d {
    private PopupWindow kQX;
    private Context mContext;
    private int mFrom;
    private RelativeLayout mIC;
    private ImageView mIE;
    public ImageView mIF;
    private RelativeLayout mIG;
    private ImageView mIH;
    public ImageView mII;
    private View mIJ;
    private ImageView mIK;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private int mIB = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean mIL = false;
    private Handler mHandler = new Handler();
    private Runnable ivE = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.mIH;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.kQX, imageView);
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.mIL = true;
                d.this.mHandler.postDelayed(d.this.ivF, IMConnection.RETRY_DELAY_TIMES);
            }
        }
    };
    private Runnable ivF = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.cud();
        }
    };
    private View.OnClickListener ivG = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dcp();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.mIC = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.mIE = (ImageView) this.mIC.findViewById(R.id.person_navigation_dressup_img);
        this.mIF = (ImageView) this.mIC.findViewById(R.id.person_navigation_dressup_red_tip);
        this.mIG = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.mIH = (ImageView) this.mIG.findViewById(R.id.person_navigation_setting_img);
        this.mII = (ImageView) this.mIG.findViewById(R.id.person_navigation_setting_red_tip);
        this.mIJ = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.mIK = (ImageView) this.mIJ.findViewById(R.id.person_navigation_scan_img);
    }

    public void dFh() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.mIC != null && this.mIC.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mIC, (View.OnClickListener) null);
            }
            if (this.mIG != null && this.mIG.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mIG, (View.OnClickListener) null);
            }
            if (this.mIJ != null && this.mIJ.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mIJ, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.mIC != null) {
            this.mIC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").ai("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "1"));
                    }
                    d.this.ad(6, false);
                    com.baidu.tieba.p.a.doQ().h(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.mIG != null) {
            this.mIG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new aq("c12523").ai("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new aq("c12502").dD("obj_locate", "2"));
                    }
                    d.this.ad(5, false);
                    TiebaStatic.log(new aq("c12502").dD("obj_locate", "2"));
                    d.this.ad(5, false);
                    com.baidu.tieba.p.a.doQ().h(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).bhm();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.mIJ != null) {
            this.mIJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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

    public void ad(int i, boolean z) {
        if (i == 5 && this.mII != null) {
            this.mII.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.mIF != null) {
            this.mIF.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mIE != null) {
            if (2 == i) {
                SvgManager.bjq().a(this.mIE, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bjq().a(this.mIE, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.mIE, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mIF != null) {
                ap.setImageResource(this.mIF, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.mIH != null) {
            if (2 == i) {
                SvgManager.bjq().a(this.mIH, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.bjq().a(this.mIH, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bjq().a(this.mIH, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mII != null) {
                ap.setImageResource(this.mII, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.bjq().a(this.mIK, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void dcp() {
        this.mHandler.removeCallbacks(this.ivE);
        this.mHandler.removeCallbacks(this.ivF);
        cud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.kQX);
    }
}
