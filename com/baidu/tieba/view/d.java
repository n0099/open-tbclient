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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes9.dex */
public class d {
    private PopupWindow iVJ;
    private RelativeLayout kKm;
    private ImageView kKn;
    public ImageView kKo;
    private RelativeLayout kKp;
    private ImageView kKq;
    public ImageView kKr;
    private View kKs;
    private ImageView kKt;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private int kKl = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean kKu = false;
    private Handler mHandler = new Handler();
    private Runnable gOE = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.kKq;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.iVJ, imageView);
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.kKu = true;
                d.this.mHandler.postDelayed(d.this.gOF, 3000L);
            }
        }
    };
    private Runnable gOF = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.bLv();
        }
    };
    private View.OnClickListener gOG = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.crD();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.kKm = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.kKn = (ImageView) this.kKm.findViewById(R.id.person_navigation_dressup_img);
        this.kKo = (ImageView) this.kKm.findViewById(R.id.person_navigation_dressup_red_tip);
        this.kKp = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.kKq = (ImageView) this.kKp.findViewById(R.id.person_navigation_setting_img);
        this.kKr = (ImageView) this.kKp.findViewById(R.id.person_navigation_setting_red_tip);
        this.kKs = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.kKt = (ImageView) this.kKs.findViewById(R.id.person_navigation_scan_img);
    }

    public void cTR() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.kKm != null && this.kKm.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kKm, (View.OnClickListener) null);
            }
            if (this.kKp != null && this.kKp.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kKp, (View.OnClickListener) null);
            }
            if (this.kKs != null && this.kKs.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.kKs, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(e eVar) {
        if (this.kKm != null) {
            this.kKm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").X("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").cx("obj_locate", "1"));
                    }
                    d.this.P(6, false);
                    com.baidu.tieba.p.a.cEk().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.kKp != null) {
            this.kKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").X("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").cx("obj_locate", "2"));
                    }
                    d.this.P(5, false);
                    TiebaStatic.log(new an("c12502").cx("obj_locate", "2"));
                    d.this.P(5, false);
                    com.baidu.tieba.p.a.cEk().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aEL();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.kKs != null) {
            this.kKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mContext instanceof Activity) {
                        Activity activity = (Activity) d.this.mContext;
                        if (d.this.mPermissionJudgement == null) {
                            d.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        d.this.mPermissionJudgement.clearRequestPermissionList();
                        d.this.mPermissionJudgement.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                        d.this.mPermissionJudgement.a(new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.view.d.3.1
                            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
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

    public void P(int i, boolean z) {
        if (i == 5 && this.kKr != null) {
            this.kKr.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.kKo != null) {
            this.kKo.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kKn != null) {
            if (2 == i) {
                SvgManager.aGG().a(this.kKn, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aGG().a(this.kKn, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGG().a(this.kKn, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kKo != null) {
                am.setImageResource(this.kKo, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.kKq != null) {
            if (2 == i) {
                SvgManager.aGG().a(this.kKq, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aGG().a(this.kKq, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aGG().a(this.kKq, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.kKr != null) {
                am.setImageResource(this.kKr, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.aGG().a(this.kKt, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void crD() {
        this.mHandler.removeCallbacks(this.gOE);
        this.mHandler.removeCallbacks(this.gOF);
        bLv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLv() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.iVJ);
    }
}
