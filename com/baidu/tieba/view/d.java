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
    private PopupWindow jYK;
    private RelativeLayout lOp;
    private ImageView lOq;
    public ImageView lOr;
    private RelativeLayout lOs;
    private ImageView lOt;
    public ImageView lOu;
    private View lOv;
    private ImageView lOw;
    private Context mContext;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgement;
    private int lOo = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
    private boolean lOx = false;
    private Handler mHandler = new Handler();
    private Runnable hOj = new Runnable() { // from class: com.baidu.tieba.view.d.4
        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.lOt;
            if (imageView != null) {
                com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(d.this.jYK, imageView);
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.SHOW_PERSON_TAB_FEEDBACK_TIPS, true);
                d.this.lOx = true;
                d.this.mHandler.postDelayed(d.this.hOk, 3000L);
            }
        }
    };
    private Runnable hOk = new Runnable() { // from class: com.baidu.tieba.view.d.5
        @Override // java.lang.Runnable
        public void run() {
            d.this.ccG();
        }
    };
    private View.OnClickListener hOl = new View.OnClickListener() { // from class: com.baidu.tieba.view.d.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.cJu();
        }
    };

    public d(int i) {
        this.mFrom = i;
    }

    public void a(Context context, NavigationBar navigationBar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.lOp = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.lOq = (ImageView) this.lOp.findViewById(R.id.person_navigation_dressup_img);
        this.lOr = (ImageView) this.lOp.findViewById(R.id.person_navigation_dressup_red_tip);
        this.lOs = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.lOt = (ImageView) this.lOs.findViewById(R.id.person_navigation_setting_img);
        this.lOu = (ImageView) this.lOs.findViewById(R.id.person_navigation_setting_red_tip);
        this.lOv = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.lOw = (ImageView) this.lOv.findViewById(R.id.person_navigation_scan_img);
    }

    public void dmi() {
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.mFrom == 1) {
            if (this.lOp != null && this.lOp.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lOp, (View.OnClickListener) null);
            }
            if (this.lOs != null && this.lOs.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.lOs, (View.OnClickListener) null);
            }
            if (this.lOv != null && this.lOv.getParent() == null) {
                this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.lOv, (View.OnClickListener) null);
            }
        }
    }

    public void setOnViewResponseListener(f fVar) {
        if (this.lOp != null) {
            this.lOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").ag("obj_locate", 22));
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "1"));
                    }
                    d.this.Z(6, false);
                    com.baidu.tieba.p.a.cWb().g(6, false, true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(d.this.mContext)));
                }
            });
        }
        if (this.lOs != null) {
            this.lOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.mFrom == 1) {
                        TiebaStatic.log(new an("c12523").ag("obj_locate", 23));
                    } else {
                        TiebaStatic.log(new an("c12502").dh("obj_locate", "2"));
                    }
                    d.this.Z(5, false);
                    TiebaStatic.log(new an("c12502").dh("obj_locate", "2"));
                    d.this.Z(5, false);
                    com.baidu.tieba.p.a.cWb().g(5, false, true);
                    if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_MORE)) {
                        BdToast.a(d.this.mContext, d.this.mContext.getResources().getString(R.string.plugin_video_installing), 0).aSY();
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MORE, new IntentConfig(view.getContext())));
                }
            });
        }
        if (this.lOv != null) {
            this.lOv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.d.3
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

    public void Z(int i, boolean z) {
        if (i == 5 && this.lOu != null) {
            this.lOu.setVisibility(z ? 0 : 8);
        } else if (i == 6 && this.lOr != null) {
            this.lOr.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.lOq != null) {
            if (2 == i) {
                SvgManager.aUW().a(this.lOq, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aUW().a(this.lOq, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUW().a(this.lOq, R.drawable.icon_pure_topbar_store44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.lOr != null) {
                am.setImageResource(this.lOr, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.lOt != null) {
            if (2 == i) {
                SvgManager.aUW().a(this.lOt, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.aUW().a(this.lOt, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aUW().a(this.lOt, R.drawable.icon_pure_topbar_set44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.lOu != null) {
                am.setImageResource(this.lOu, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.aUW().a(this.lOw, R.drawable.icon_pure_topbar_scan44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void cJu() {
        this.mHandler.removeCallbacks(this.hOj);
        this.mHandler.removeCallbacks(this.hOk);
        ccG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccG() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.jYK);
    }
}
